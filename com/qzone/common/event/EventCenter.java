package com.qzone.common.event;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.util.t;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneEventApi;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import mqq.app.MobileQQ;

/* compiled from: P */
@Deprecated
/* loaded from: classes39.dex */
public class EventCenter {
    private static volatile EventCenter instance = null;
    private static final Object lock = new Object();
    private static final String tag = "EventCenter";
    private static IThreadPool threadPool;
    private final AsyncPoster asyncPoster;
    private final BackgroundPoster backgroundPoster;
    private final ThreadLocal<List<Object>> currentThreadEventQueue;
    private final ThreadLocal<d> currentThreadIsPosting;
    private final ExecutorService executor;
    private final boolean isSendMode;
    private final com.qzone.common.event.a mainThreadPoster;
    private ConcurrentHashMap<EventSource, t<com.qzone.common.event.b>> observerMap;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends ThreadLocal<List<Object>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<Object> initialValue() {
            return new ArrayList();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b extends ThreadLocal<d> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d initialValue() {
            return new d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements IThreadPool {

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements ThreadPool.Job<Object> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Runnable f45856d;

            a(Runnable runnable) {
                this.f45856d = runnable;
            }

            @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
            public Object run(ThreadPool.JobContext jobContext) {
                this.f45856d.run();
                return null;
            }
        }

        c() {
        }

        @Override // com.qzone.common.event.IThreadPool
        public void submit(Runnable runnable) {
            PriorityThreadPool.getDefault().submit(new a(runnable));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        boolean f45858a;

        d() {
        }
    }

    EventCenter() {
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        this.executor = newSingleThreadExecutor;
        this.observerMap = new ConcurrentHashMap<>();
        this.currentThreadEventQueue = new a();
        this.currentThreadIsPosting = new b();
        if (threadPool == null) {
            j.f("EventCenter", "threadPool is null, init it inner.");
            threadPool = new c();
        }
        this.mainThreadPoster = new com.qzone.common.event.a(this, Looper.getMainLooper(), 10);
        this.backgroundPoster = new BackgroundPoster(this, threadPool);
        this.asyncPoster = new AsyncPoster(this, threadPool);
        boolean z16 = MobileQQ.sProcessId == 2;
        this.isSendMode = z16;
        j.f("EventCenter", "init: " + z16);
        if (z16) {
            return;
        }
        newSingleThreadExecutor.execute(new Runnable() { // from class: com.qzone.common.event.EventCenter.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    IQzoneEventApi iQzoneEventApi = (IQzoneEventApi) QRoute.api(IQzoneEventApi.class);
                    int i3 = 0;
                    while (i3 < 5) {
                        try {
                            IQzoneEventApi.ExoticEventInterface pollEvent = iQzoneEventApi.pollEvent();
                            if (pollEvent != null) {
                                EventCenter.this.postFromOtherProcess(pollEvent);
                            }
                        } catch (Throwable th5) {
                            j.j("EventCenter", "init: failed to poll or post exotic event", th5);
                            i3++;
                        }
                    }
                } catch (Throwable th6) {
                    j.j("EventCenter", "init: failed to get exotic event pool", th6);
                }
                j.i("EventCenter", "init: get other process event task quit!");
            }
        });
    }

    @Deprecated
    public static EventCenter getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new EventCenter();
                }
            }
        }
        return instance;
    }

    private Collection<com.qzone.common.event.b> getObserverBeans(Event event) {
        List<com.qzone.common.event.b> a16;
        t<com.qzone.common.event.b> tVar = this.observerMap.get(event.source);
        if (tVar == null || (a16 = tVar.a(event.what)) == null) {
            return null;
        }
        return new ArrayList(a16);
    }

    private void postSingleEvent(Event event, boolean z16) throws Error {
        Lock readLock = this.readWriteLock.readLock();
        try {
            readLock.lock();
            Collection<com.qzone.common.event.b> observerBeans = getObserverBeans(event);
            if (observerBeans != null) {
                Iterator<com.qzone.common.event.b> it = observerBeans.iterator();
                while (it.hasNext()) {
                    postToSubscription(it.next(), event, z16);
                }
            }
        } finally {
            readLock.unlock();
        }
    }

    private void postToSubscription(com.qzone.common.event.b bVar, Event event, boolean z16) {
        int i3 = bVar.f45865c;
        if (i3 == 0) {
            if (z16) {
                bVar.b(event);
                return;
            } else {
                this.mainThreadPoster.a(bVar, event);
                return;
            }
        }
        if (i3 == 1) {
            this.asyncPoster.a(bVar, event);
            return;
        }
        if (i3 == 2) {
            bVar.b(event);
            return;
        }
        if (i3 != 3) {
            throw new IllegalStateException("Unknown thread mode: " + bVar.f45865c);
        }
        if (z16) {
            this.backgroundPoster.a(bVar, event);
        } else {
            bVar.b(event);
        }
    }

    @Deprecated
    private void removeAllObserverByEventSource(IObserver iObserver, EventSource eventSource) {
        t<com.qzone.common.event.b> tVar = this.observerMap.get(eventSource);
        if (tVar != null) {
            int c16 = tVar.c();
            for (int i3 = 0; i3 < c16; i3++) {
                removeObserverFromCollection(tVar.a(tVar.b(i3)), iObserver);
            }
        }
    }

    private void removeObserverByEventSource(IObserver iObserver, EventSource eventSource, int i3) {
        t<com.qzone.common.event.b> tVar = this.observerMap.get(eventSource);
        if (tVar != null) {
            removeObserverFromCollection(tVar.a(i3), iObserver);
        }
    }

    @Deprecated
    public void addObserver(IObserver iObserver, String str, int... iArr) {
        addObserver(iObserver, 2, new EventSource(str), iArr);
    }

    @Deprecated
    public void addUIObserver(IObserver iObserver, String str, int... iArr) {
        addObserver(iObserver, 0, new EventSource(str), iArr);
    }

    @Deprecated
    public void invokeObserver(com.qzone.common.event.c cVar) {
        Event event = (Event) cVar.f45869a;
        com.qzone.common.event.b bVar = cVar.f45870b;
        com.qzone.common.event.c.b(cVar);
        bVar.b(event);
    }

    @Deprecated
    public void post(String str, int i3) {
        post(str, i3, (Object[]) null);
    }

    @Deprecated
    public void postFromOtherProcess(IQzoneEventApi.ExoticEventInterface exoticEventInterface) {
        if (TextUtils.isEmpty(exoticEventInterface.getSourceName())) {
            return;
        }
        post(Event.obtain(exoticEventInterface));
    }

    @Deprecated
    public void removeObserver(IObserver iObserver) {
        removeObserver(iObserver, null);
    }

    @Deprecated
    public void addObserver(IObserver iObserver, EventSource eventSource, int... iArr) {
        addObserver(iObserver, 2, eventSource, iArr);
    }

    @Deprecated
    public void addUIObserver(IObserver iObserver, EventSource eventSource, int... iArr) {
        addObserver(iObserver, 0, eventSource, iArr);
    }

    @Deprecated
    public void post(String str, int i3, Object obj) {
        post(Event.obtain(new EventSource(str), i3, obj));
    }

    @Deprecated
    public void removeObserver(IObserver iObserver, EventSource eventSource) {
        if (iObserver != null) {
            Lock writeLock = this.readWriteLock.writeLock();
            try {
                writeLock.lock();
                if (eventSource != null) {
                    removeAllObserverByEventSource(iObserver, eventSource);
                } else {
                    Set<EventSource> keySet = this.observerMap.keySet();
                    if (keySet != null) {
                        Iterator<EventSource> it = keySet.iterator();
                        while (it.hasNext()) {
                            removeAllObserverByEventSource(iObserver, it.next());
                        }
                    }
                }
                return;
            } finally {
                writeLock.unlock();
            }
        }
        throw new NullPointerException("observer must not be null");
    }

    private void removeObserverFromCollection(Collection<com.qzone.common.event.b> collection, IObserver iObserver) {
        IObserver a16;
        if (collection != null) {
            Iterator<com.qzone.common.event.b> it = collection.iterator();
            while (it.hasNext()) {
                com.qzone.common.event.b next = it.next();
                if (next != null && (a16 = next.a()) != null && a16.equals(iObserver)) {
                    it.remove();
                }
            }
        }
    }

    @Deprecated
    public static void setThreadPool(IThreadPool iThreadPool) {
        if (iThreadPool == null || threadPool != null) {
            return;
        }
        threadPool = iThreadPool;
    }

    @Deprecated
    public void addObserver(IObserver iObserver, int i3, String str, int... iArr) {
        addObserver(iObserver, i3, new EventSource(str), iArr);
    }

    @Deprecated
    public void addObserver(IObserver iObserver, int i3, EventSource eventSource, int... iArr) {
        if (iObserver != null) {
            if (eventSource == null || TextUtils.isEmpty(eventSource.getName())) {
                throw new NullPointerException("you must specified eventSource!");
            }
            if (iArr == null) {
                return;
            }
            Lock writeLock = this.readWriteLock.writeLock();
            try {
                writeLock.lock();
                com.qzone.common.event.b bVar = new com.qzone.common.event.b(iObserver, eventSource.getSender(), i3);
                t<com.qzone.common.event.b> tVar = this.observerMap.get(eventSource);
                if (tVar == null) {
                    tVar = new t<>();
                    this.observerMap.put(eventSource, tVar);
                }
                for (int i16 : iArr) {
                    tVar.d(i16, bVar);
                }
                return;
            } finally {
                writeLock.unlock();
            }
        }
        throw new NullPointerException("observer must not be null!");
    }

    @Deprecated
    public void post(String str, int i3, Object... objArr) {
        post(Event.obtain(new EventSource(str), i3, objArr));
    }

    @Deprecated
    public void post(EventSource eventSource, int i3) {
        post(eventSource, i3, (Object) null);
    }

    @Deprecated
    public void post(EventSource eventSource, int i3, Object obj) {
        post(Event.obtain(eventSource, i3, obj));
    }

    @Deprecated
    public void post(final Event event) {
        if (event != null) {
            EventSource eventSource = event.source;
            if (eventSource != null && !TextUtils.isEmpty(eventSource.getName())) {
                if (this.isSendMode) {
                    this.executor.execute(new Runnable() { // from class: com.qzone.common.event.EventCenter.5
                        @Override // java.lang.Runnable
                        public void run() {
                            IQzoneEventApi iQzoneEventApi = (IQzoneEventApi) QRoute.api(IQzoneEventApi.class);
                            Event event2 = event;
                            IQzoneEventApi.ExoticEventInterface obtain = iQzoneEventApi.obtain(event2.what, event2.source.getName(), event.params);
                            if (obtain == null) {
                                j.i("EventCenter", "post: failed to across process by obtain " + event.source.getName() + " " + event.what);
                                return;
                            }
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("event", obtain);
                            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_QZONE_SEND_EVENT, bundle);
                        }
                    });
                }
                List<Object> list = this.currentThreadEventQueue.get();
                list.add(event);
                d dVar = this.currentThreadIsPosting.get();
                if (dVar.f45858a) {
                    return;
                }
                boolean z16 = Looper.getMainLooper() == Looper.myLooper();
                dVar.f45858a = true;
                while (!list.isEmpty()) {
                    try {
                        postSingleEvent((Event) list.remove(0), z16);
                    } finally {
                        dVar.f45858a = false;
                    }
                }
                return;
            }
            throw new NullPointerException("EventSource cannot be null");
        }
        throw new NullPointerException("Event cannot be null");
    }
}
