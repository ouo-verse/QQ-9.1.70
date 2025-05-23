package nd4;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
final class v {

    /* renamed from: h, reason: collision with root package name */
    private static final HandlerThread f420033h;

    /* renamed from: a, reason: collision with root package name */
    private h f420034a;

    /* renamed from: b, reason: collision with root package name */
    private long f420035b;

    /* renamed from: c, reason: collision with root package name */
    private md4.a f420036c;

    /* renamed from: d, reason: collision with root package name */
    private ld4.a f420037d;

    /* renamed from: e, reason: collision with root package name */
    private m f420038e;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, i> f420039f;

    /* renamed from: g, reason: collision with root package name */
    private a f420040g;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1) {
                    v.this.g();
                    removeMessages(1);
                    sendEmptyMessageDelayed(1, v.this.f420035b);
                    return;
                }
                return;
            }
            v.this.f((g) message.obj);
        }
    }

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("TabMetricsDataRollHandlerThread");
        f420033h = baseHandlerThread;
        baseHandlerThread.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v(@NonNull long j3, @NonNull m mVar) {
        this.f420035b = j3;
        this.f420038e = mVar;
        this.f420036c = mVar.b();
        this.f420037d = this.f420038e.a();
        h hVar = new h();
        this.f420034a = hVar;
        this.f420039f = hVar.b();
        this.f420040g = new a(f420033h.getLooper());
    }

    private Map<String, String> d(h hVar) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (hVar == null) {
            return concurrentHashMap;
        }
        Map<String, String> a16 = hVar.a(hVar.b());
        if (a16 != null && !a16.isEmpty()) {
            return a16;
        }
        return new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(g gVar) {
        String e16 = gVar.e();
        i iVar = this.f420039f.get(e16);
        i a16 = gVar.a();
        if (iVar == null) {
            this.f420039f.put(e16, a16);
            return;
        }
        String c16 = gVar.c();
        ConcurrentHashMap<String, g> a17 = iVar.a();
        g gVar2 = a17.get(c16);
        if (gVar2 == null) {
            a17.put(c16, gVar);
        } else {
            a17.put(c16, u.e(gVar2, gVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f420036c == null) {
            Log.w("TAB.MonitorAggregator", "mReportImpl is null, please check report Impl!");
            return;
        }
        Map<String, String> d16 = d(this.f420034a);
        if (d16 != null && !d16.isEmpty()) {
            Log.d("TAB.MonitorAggregator", "isMetricsReportSuccess: " + this.f420036c.a(d16));
            this.f420039f.clear();
            return;
        }
        Log.d("TAB.MonitorAggregator", "reportMonitorGroup: metricsReportParams is empty and ignore!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(g gVar) {
        if (gVar == null) {
            return;
        }
        a aVar = this.f420040g;
        aVar.sendMessage(aVar.obtainMessage(0, gVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f420040g.sendEmptyMessageDelayed(1, this.f420035b);
    }
}
