package hynb.g;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.google.gson.Gson;
import com.huya.huyasdk.data.RegisterResultInfo;
import com.huya.huyasdk.data.WSPushMessage;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import hynb.b.f;
import hynb.b.i;
import hynb.b.l;
import hynb.g.b;
import hynb.p.e;
import hynb.p.g;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* renamed from: m, reason: collision with root package name */
    public static b f406712m = new b();

    /* renamed from: n, reason: collision with root package name */
    public static final Runnable f406713n = new Runnable() { // from class: t15.a
        @Override // java.lang.Runnable
        public final void run() {
            l.i().d();
        }
    };

    /* renamed from: i, reason: collision with root package name */
    public Handler f406722i;

    /* renamed from: j, reason: collision with root package name */
    public Handler f406723j;

    /* renamed from: a, reason: collision with root package name */
    public final Map<Integer, Class<?>> f406714a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Set<hynb.g.a> f406715b = new CopyOnWriteArraySet();

    /* renamed from: c, reason: collision with root package name */
    public int f406716c = 500;

    /* renamed from: d, reason: collision with root package name */
    public int f406717d = 500;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicInteger f406718e = new AtomicInteger(0);

    /* renamed from: f, reason: collision with root package name */
    public final AtomicInteger f406719f = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name */
    public final Set<String> f406720g = new HashSet();

    /* renamed from: h, reason: collision with root package name */
    public final Set<String> f406721h = new HashSet();

    /* renamed from: k, reason: collision with root package name */
    public final f f406724k = new a();

    /* renamed from: l, reason: collision with root package name */
    public long f406725l = 0;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements f {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(WSPushMessage wSPushMessage) {
            b.this.f406719f.decrementAndGet();
            b.this.f406718e.decrementAndGet();
            Class cls = (Class) b.this.f406714a.get(wSPushMessage.iUri);
            if (cls != null) {
                try {
                    b.this.a(wSPushMessage, wSPushMessage.sMsg, (Class<?>) cls);
                } catch (Exception e16) {
                    g.f406799a.error("HuyaPushImpl", "onPush errorMsg=" + e16);
                }
            }
        }

        @Override // hynb.b.f
        public void a(final WSPushMessage wSPushMessage) {
            e eVar = g.f406799a;
            eVar.a("HuyaPushImpl", "onPushMessage()  message = [" + wSPushMessage + "]");
            if (b.this.f406714a.containsKey(wSPushMessage.iUri)) {
                b.this.f406718e.incrementAndGet();
                if (b.this.f406719f.get() > b.this.f406717d) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    if (uptimeMillis - b.this.f406725l > 10000) {
                        b.this.f406725l = uptimeMillis;
                        eVar.a("HuyaPushImpl", "onPush max count return queueCount=%s, allCount=%s", Integer.valueOf(b.this.f406719f.get()), Integer.valueOf(b.this.f406718e.get()));
                    }
                    if (wSPushMessage.iUri.intValue() == 1402) {
                        return;
                    }
                }
                b.this.f406719f.incrementAndGet();
                if (b.this.f406723j != null) {
                    eVar.a("HuyaPushImpl", "onPushMessage() post  message uri = [" + wSPushMessage.iUri + "]");
                    b.this.f406723j.post(new Runnable() { // from class: t15.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.a.this.b(wSPushMessage);
                        }
                    });
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: hynb.g.b$b, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public class C10484b implements hynb.b.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hynb.b.g f406727a;

        public C10484b(b bVar, hynb.b.g gVar) {
            this.f406727a = gVar;
        }

        @Override // hynb.b.g
        public void a(RegisterResultInfo registerResultInfo) {
            this.f406727a.a(registerResultInfo);
        }

        @Override // hynb.b.g
        public void b(RegisterResultInfo registerResultInfo) {
            if (!l.i().r()) {
                g.f406799a.info("HuyaPushImpl", "Push Long Link not create!");
            } else {
                this.f406727a.b(registerResultInfo);
            }
        }
    }

    public synchronized void b(String str) {
        if (this.f406721h.contains(str)) {
            return;
        }
        this.f406721h.add(str);
        g.f406799a.a("HuyaPushImpl", "enablePush() source = [" + str + "], enablePushSource = [" + this.f406721h + "]");
        if (this.f406721h.size() > 1) {
            return;
        }
        l.i().a(this.f406724k);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("HuyaPushImpl-callback", 0);
        baseHandlerThread.start();
        this.f406723j = new Handler(baseHandlerThread.getLooper(), null);
    }

    public final Handler a() {
        if (this.f406722i == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("HuyaPushImpl-longLinkDestroy");
            baseHandlerThread.start();
            this.f406722i = new Handler(baseHandlerThread.getLooper());
        }
        return this.f406722i;
    }

    public synchronized void a(String str, List<String> list, hynb.b.g gVar) {
        if (this.f406720g.contains(str)) {
            return;
        }
        this.f406720g.add(str);
        g.f406799a.a("HuyaPushImpl", "registerGroup() source = [" + str + "], registerGroupSource = [" + this.f406720g + "]");
        a().removeCallbacks(f406713n);
        l.i().c();
        l.i().a(list, new C10484b(this, gVar));
    }

    public void b(hynb.g.a aVar) {
        this.f406715b.remove(aVar);
    }

    public synchronized void a(String str, List<String> list, i iVar) {
        if (this.f406720g.contains(str)) {
            this.f406720g.remove(str);
            e eVar = g.f406799a;
            eVar.a("HuyaPushImpl", "unregisterGroup() source = [" + str + "], registerGroupSource = [" + this.f406720g + "]");
            l.i().a(list, iVar);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("unregisterGroups isLongLinkConnected: ");
            sb5.append(l.i().q());
            eVar.info("HuyaPushImpl", sb5.toString());
            if (this.f406720g.isEmpty() && l.i().q()) {
                eVar.info("HuyaPushImpl", "unregisterGroups and count is 0, try close long link");
                Handler a16 = a();
                Runnable runnable = f406713n;
                a16.removeCallbacks(runnable);
                a().postDelayed(runnable, 60000L);
            }
        }
    }

    public synchronized void a(String str) {
        if (this.f406721h.contains(str)) {
            this.f406721h.remove(str);
            g.f406799a.a("HuyaPushImpl", "disablePush() source = [" + str + "], enablePushSource = [" + this.f406721h + "]");
            if (this.f406721h.size() > 0) {
                return;
            }
            l.i().b(this.f406724k);
            this.f406718e.set(0);
            this.f406719f.set(0);
            Handler handler = this.f406723j;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f406723j.getLooper().quitSafely();
                this.f406723j = null;
            }
        }
    }

    public void a(int i3, Class<?> cls) {
        this.f406714a.put(Integer.valueOf(i3), cls);
    }

    public void a(int i3) {
        this.f406714a.remove(Integer.valueOf(i3));
    }

    public void a(hynb.g.a aVar) {
        this.f406715b.add(aVar);
    }

    public final void a(WSPushMessage wSPushMessage, List<Integer> list, Class<?> cls) {
        long uptimeMillis = SystemClock.uptimeMillis();
        Object a16 = a(list, cls);
        Iterator<hynb.g.a> it = this.f406715b.iterator();
        while (it.hasNext()) {
            it.next().a(wSPushMessage.iUri.intValue(), a16);
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (uptimeMillis2 <= 1 || uptimeMillis2 >= this.f406716c) {
            return;
        }
        g.f406799a.a("HuyaPushImpl", String.format("onDispatchTimeout uri=%s, time=%s", wSPushMessage.iUri, Long.valueOf(uptimeMillis2)));
    }

    public static <T> T a(List<Integer> list, Class<T> cls) {
        try {
            String a16 = a(list);
            Gson gson = new Gson();
            g.f406799a.a("HuyaPushImpl", "parseJsonResponse() jsonString: " + a16);
            return (T) gson.fromJson(a16, (Class) cls);
        } catch (Exception e16) {
            e eVar = g.f406799a;
            eVar.error("HuyaPushImpl", "parseJsonResponse() jsonString error: " + e16.getMessage());
            eVar.c("HuyaPushImpl", "parseJsonResponse() jsonString error: %s", Log.getStackTraceString(e16));
            return null;
        }
    }

    public static String a(List<Integer> list) {
        byte[] bArr = new byte[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            bArr[i3] = list.get(i3).byteValue();
        }
        return new String(bArr, StandardCharsets.UTF_8);
    }
}
