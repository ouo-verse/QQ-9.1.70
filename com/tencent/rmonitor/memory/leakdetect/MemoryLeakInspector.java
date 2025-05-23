package com.tencent.rmonitor.memory.leakdetect;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.heapdump.ForkJvmHeapDumper;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.RecyclablePool;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.rmonitor.base.config.data.i;
import com.tencent.rmonitor.base.meta.DumpResult;
import com.tencent.rmonitor.base.meta.InspectUUID;
import com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.common.logger.Logger;
import h14.b;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MemoryLeakInspector {

    /* renamed from: f, reason: collision with root package name */
    private static ReferenceQueue<Object> f365718f;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f365721a;

    /* renamed from: b, reason: collision with root package name */
    private final IMemoryLeakListener f365722b;

    /* renamed from: c, reason: collision with root package name */
    private final b f365723c = new b();

    /* renamed from: d, reason: collision with root package name */
    private static final RecyclablePool f365716d = new RecyclablePool(InspectUUID.class, 20);

    /* renamed from: e, reason: collision with root package name */
    private static long f365717e = 0;

    /* renamed from: g, reason: collision with root package name */
    private static List<a> f365719g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private static final Object f365720h = new Object();

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class DumperRunner implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        i f365726d = e14.a.e();

        private boolean e() {
            if (MemoryLeakInspector.f365719g.size() > 5) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = MemoryLeakInspector.f365719g.iterator();
            while (it.hasNext()) {
                if (((a) it.next()).f365736d + 180000 < currentTimeMillis) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar;
            String inspectUUID;
            try {
                synchronized (MemoryLeakInspector.f365720h) {
                    if (MemoryLeakInspector.f365719g != null && !MemoryLeakInspector.f365719g.isEmpty()) {
                        boolean e16 = e();
                        if (e16) {
                            HashMap hashMap = new HashMap();
                            synchronized (MemoryLeakInspector.f365720h) {
                                aVar = (a) MemoryLeakInspector.f365719g.get(0);
                                inspectUUID = aVar.f365733a.toString();
                                MemoryLeakInspector.f365719g.remove(0);
                                for (a aVar2 : MemoryLeakInspector.f365719g) {
                                    hashMap.put(new String(aVar2.f365733a.uuid), aVar2.f365733a.className);
                                }
                                MemoryLeakInspector.f365719g.clear();
                            }
                            DumpResult b16 = e14.b.b(inspectUUID, inspectUUID + "_leak", this.f365726d.c(), false, aVar.f365734b, this.f365726d.e(), this.f365726d.f365316m);
                            if (b16.success) {
                                String str = "";
                                String str2 = aVar.f365733a.uuid;
                                if (str2 != null) {
                                    str = new String(str2);
                                }
                                aVar.f365735c.a(aVar.f365733a.className, str, b16, hashMap);
                                return;
                            }
                            return;
                        }
                        ThreadManager.runInDumpThread(this, 30000L);
                    }
                }
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_MemoryLeak_LeakInspector", th5);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class InspectorRunner implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f365727d;

        /* renamed from: e, reason: collision with root package name */
        private final InspectUUID f365728e;

        /* renamed from: f, reason: collision with root package name */
        private final Handler f365729f;

        /* renamed from: h, reason: collision with root package name */
        private final IMemoryLeakListener f365730h;

        /* renamed from: i, reason: collision with root package name */
        private final b f365731i;

        /* renamed from: m, reason: collision with root package name */
        private long f365732m = -1;

        public InspectorRunner(InspectUUID inspectUUID, int i3, Handler handler, IMemoryLeakListener iMemoryLeakListener, b bVar) {
            this.f365727d = i3;
            this.f365728e = inspectUUID;
            this.f365729f = handler;
            this.f365730h = iMemoryLeakListener;
            this.f365731i = bVar;
        }

        private boolean a(i iVar, String str) {
            if (!b(iVar.b())) {
                this.f365730h.onCheckingLeaked(((this.f365727d - 1) * 5000) / 1000, str);
                this.f365729f.postDelayed(this, 5000L);
                return false;
            }
            if (this.f365730h.onLeaked(this.f365728e)) {
                return true;
            }
            if (!iVar.f()) {
                MemoryLeakInspector.f365716d.recycle(this.f365728e);
            }
            return false;
        }

        private boolean b(long j3) {
            long j16 = -1;
            if (AndroidVersion.isOverM()) {
                long a16 = g14.a.a();
                if (this.f365732m == -1) {
                    this.f365732m = a16;
                }
                j16 = a16;
            }
            if (j16 - this.f365732m < 20) {
                int i3 = this.f365727d + 1;
                this.f365727d = i3;
                if (i3 < j3) {
                    MemoryLeakInspector.h();
                    return false;
                }
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            InspectUUID inspectUUID = this.f365728e;
            if (inspectUUID == null) {
                Logger.f365497g.w("RMonitor_MemoryLeak_LeakInspector", "uuid is null");
                return;
            }
            String inspectUUID2 = inspectUUID.toString();
            try {
                Logger logger = Logger.f365497g;
                logger.d("RMonitor_MemoryLeak_LeakInspector", "Inspecting ", inspectUUID2, " Time=", String.valueOf(System.currentTimeMillis()), " count=", String.valueOf(this.f365727d));
                i e16 = e14.a.e();
                WeakReference<Object> weakReference = this.f365728e.weakObj;
                if (weakReference != null && weakReference.get() != null && !this.f365728e.weakObj.isEnqueued()) {
                    if (!a(e16, inspectUUID2)) {
                        return;
                    }
                    a aVar = new a(this.f365728e, this.f365730h, System.currentTimeMillis(), this.f365731i);
                    synchronized (MemoryLeakInspector.f365720h) {
                        MemoryLeakInspector.f365719g.add(aVar);
                    }
                    ThreadManager.runInDumpThread(new DumperRunner(), 0L);
                    return;
                }
                logger.d("RMonitor_MemoryLeak_LeakInspector", "inspect ", inspectUUID2, " finished no leak");
                MemoryLeakInspector.f365716d.recycle(this.f365728e);
            } catch (Throwable th5) {
                Logger logger2 = Logger.f365497g;
                logger2.e("RMonitor_MemoryLeak_LeakInspector", "error, ", inspectUUID2, " Time=", String.valueOf(System.currentTimeMillis()), " count=", String.valueOf(this.f365727d), " Throwable: ", logger2.i(th5));
                MemoryLeakInspector.f365716d.recycle(this.f365728e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final InspectUUID f365733a;

        /* renamed from: b, reason: collision with root package name */
        public final IMemoryLeakListener f365734b;

        /* renamed from: c, reason: collision with root package name */
        public final b f365735c;

        /* renamed from: d, reason: collision with root package name */
        public final long f365736d;

        public a(InspectUUID inspectUUID, IMemoryLeakListener iMemoryLeakListener, long j3, b bVar) {
            this.f365733a = inspectUUID;
            this.f365734b = iMemoryLeakListener;
            this.f365736d = j3;
            this.f365735c = bVar;
        }
    }

    public MemoryLeakInspector(Handler handler, IMemoryLeakListener iMemoryLeakListener) {
        this.f365721a = handler;
        this.f365722b = iMemoryLeakListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f365717e >= 5000) {
            Runtime.getRuntime().gc();
            i();
            System.runFinalization();
            f365717e = currentTimeMillis;
        }
    }

    private static void i() {
        try {
            LockMethodProxy.sleep(100L);
        } catch (InterruptedException unused) {
            throw new AssertionError();
        }
    }

    @Nullable
    private InspectUUID j(@NonNull Object obj, String str) {
        try {
            InspectUUID inspectUUID = (InspectUUID) f365716d.obtain(InspectUUID.class);
            if (inspectUUID == null) {
                return null;
            }
            inspectUUID.weakObj = new WeakReference<>(obj, f365718f);
            inspectUUID.uuid = UUID.randomUUID().toString();
            inspectUUID.digest = str;
            inspectUUID.className = obj.getClass().getName();
            return inspectUUID;
        } catch (Exception unused) {
            return null;
        }
    }

    private void k(@NonNull Object obj, String str) {
        final InspectUUID j3;
        if (!this.f365722b.onFilter(obj) && (j3 = j(obj, str)) != null) {
            Looper.getMainLooper();
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    MemoryLeakInspector.this.f365721a.post(new InspectorRunner(j3, 0, MemoryLeakInspector.this.f365721a, MemoryLeakInspector.this.f365722b, MemoryLeakInspector.this.f365723c));
                    return false;
                }
            });
        }
    }

    public static void l(Object obj, IMemoryLeakListener iMemoryLeakListener) {
        if (obj == null) {
            Logger.f365497g.i("RMonitor_MemoryLeak_LeakInspector", "leakObj is null");
            return;
        }
        if (!(b14.a.a() instanceof ForkJvmHeapDumper)) {
            Logger.f365497g.i("RMonitor_MemoryLeak_LeakInspector", "startInspect has not valid dumper");
            return;
        }
        InspectUUID inspectUUID = (InspectUUID) f365716d.obtain(InspectUUID.class);
        if (inspectUUID == null) {
            return;
        }
        PluginController pluginController = PluginController.f365404b;
        if (!pluginController.f(BuglyMonitorName.MEMORY_JAVA_LEAK)) {
            Logger.f365497g.i("RMonitor_MemoryLeak_LeakInspector", "leakSampleLost for user");
            return;
        }
        if (!pluginController.d(BuglyMonitorName.MEMORY_JAVA_LEAK)) {
            Logger.f365497g.i("RMonitor_MemoryLeak_LeakInspector", "leakSampleLost for event");
            return;
        }
        if (!pluginController.b(BuglyMonitorName.MEMORY_JAVA_LEAK)) {
            Logger.f365497g.i("RMonitor_MemoryLeak_LeakInspector", "can not report again");
            return;
        }
        inspectUUID.weakObj = new WeakReference<>(obj, f365718f);
        inspectUUID.uuid = UUID.randomUUID().toString();
        inspectUUID.digest = PublicAccountMessageUtilImpl.ITEM_DIGEST_NAME;
        inspectUUID.className = obj.getClass().getSimpleName();
        if (iMemoryLeakListener == null) {
            iMemoryLeakListener = new h14.a();
        }
        ThreadManager.runInMonitorThread(new InspectorRunner(inspectUUID, 0, new Handler(ThreadManager.getMonitorThreadLooper()), iMemoryLeakListener, new b()), 0L);
    }

    public void m(@NonNull Object obj, String str) {
        if (this.f365722b == null) {
            Logger.f365497g.e("RMonitor_MemoryLeak_LeakInspector", "Please init a listener first!");
            return;
        }
        PluginController pluginController = PluginController.f365404b;
        if (!pluginController.d(BuglyMonitorName.MEMORY_JAVA_LEAK)) {
            Logger.f365497g.i("RMonitor_MemoryLeak_LeakInspector", "leakSampleLost");
        } else if (!pluginController.b(BuglyMonitorName.MEMORY_JAVA_LEAK)) {
            Logger.f365497g.i("RMonitor_MemoryLeak_LeakInspector", "can not report again");
        } else {
            k(obj, str);
        }
    }

    public void n() {
        this.f365721a.removeCallbacksAndMessages(null);
    }
}
