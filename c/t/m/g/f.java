package c.t.m.g;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes.dex */
public class f extends f0 {

    /* renamed from: e, reason: collision with root package name */
    public volatile Handler f29600e = null;

    /* renamed from: f, reason: collision with root package name */
    public volatile b f29601f = new b();

    /* renamed from: g, reason: collision with root package name */
    public StringBuilder f29602g = new StringBuilder();

    /* renamed from: h, reason: collision with root package name */
    public AtomicInteger f29603h = new AtomicInteger(0);

    @Override // c.t.m.g.i0
    public String a() {
        return "GpsNaviPro";
    }

    @Override // c.t.m.g.i0
    public void c() {
        this.f29602g.setLength(0);
        this.f29603h.set(0);
        this.f29601f.a("", 0);
        this.f29600e = null;
        w0.a("th_loc_task_t_consume");
    }

    @Override // c.t.m.g.f0
    public void a(Message message) throws Exception {
        String sb5;
        if (message.what != 1001) {
            return;
        }
        y0.a(d(), 1001);
        y0.a(d(), 1001, 5000L);
        int i3 = this.f29603h.get();
        synchronized (this.f29761b) {
            sb5 = this.f29602g.toString();
            this.f29602g.setLength(0);
            this.f29603h.set(0);
        }
        if (sb5.length() <= 0 || this.f29600e == null) {
            return;
        }
        this.f29601f.a(sb5, i3);
        y0.a(this.f29600e, this.f29601f);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b implements Runnable, x {

        /* renamed from: a, reason: collision with root package name */
        public volatile String f29604a;

        /* renamed from: b, reason: collision with root package name */
        public volatile int f29605b;

        public b() {
            this.f29605b = 0;
        }

        public void a(String str, int i3) {
            if (h1.a(str)) {
                this.f29604a = "";
            } else {
                this.f29604a = str;
            }
            this.f29605b = i3;
        }

        @Override // c.t.m.g.x
        public void b(String str) {
            c1.c("FC", "NaviGps," + this.f29605b);
            if (c1.a()) {
                c1.a("GpsNaviPro", "upload success:" + str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (h1.a(this.f29604a)) {
                    return;
                }
                byte[] bytes = this.f29604a.getBytes("UTF-8");
                this.f29604a = "";
                a(bytes);
            } catch (Throwable th5) {
                if (c1.a()) {
                    c1.a("GpsNaviPro", "upload error.", th5);
                }
            }
        }

        public final void a(byte[] bArr) {
            byte[] a16 = p0.a(bArr);
            byte[] a17 = n0.a(a16.length);
            byte[] bArr2 = new byte[a17.length + 1 + a16.length];
            bArr2[0] = 1;
            System.arraycopy(a17, 0, bArr2, 1, a17.length);
            System.arraycopy(a16, 0, bArr2, a17.length + 1, a16.length);
            byte[] a18 = s0.a(bArr2, s0.a("fc_gps_for_navi"));
            if (c1.a()) {
                c1.a("GpsNaviPro", "start upload:strBytes=" + bArr.length + ",encBytes=" + a18.length);
            }
            y.f30109a.a("https://rttgpsreport.map.qq.com/report?type=sdk&key=5e1fe70424035ee83066ac22b24f31dc", a18, this);
        }

        @Override // c.t.m.g.x
        public void a(String str) {
            if (c1.a()) {
                c1.a("GpsNaviPro", "upload fail:" + str);
            }
        }
    }

    @Override // c.t.m.g.i0
    public int a(Looper looper) {
        y0.a(d(), 1001, 5000L);
        this.f29600e = new Handler(w0.b("th_loc_task_t_consume").getLooper());
        this.f29602g.setLength(0);
        this.f29603h.set(0);
        return 0;
    }

    public void a(int i3, Location location) {
        String str;
        synchronized (this.f29761b) {
            if (this.f29602g.length() > 5120) {
                this.f29602g.setLength(0);
                this.f29603h.set(0);
            }
            if (this.f29602g.length() > 0) {
                this.f29602g.append('\n');
            }
            c.t.m.g.a aVar = j.f29778j;
            if (h1.a(aVar.a())) {
                str = "null";
            } else {
                str = "loc_" + aVar.a();
            }
            String a16 = l1.a();
            if (h1.a(a16) || "0123456789ABCDEF".equals(a16)) {
                a16 = l1.i();
            }
            this.f29602g.append(String.format(Locale.ENGLISH, "%s,%d,%d,%.6f,%.6f,%.3f,%.3f,%.3f,%.3f,%d,%d,%d,%d,%d,%d,%d,%s,%s,%s", a16, 12, Integer.valueOf(i3), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(LocationMonitor.getAccuracy(location)), Float.valueOf(location.getBearing()), Float.valueOf(location.getSpeed()), Long.valueOf(location.getTime() / 1000), 2, 0, 2, 2, 1, 0, "null", str, "null"));
            this.f29603h.getAndAdd(1);
        }
    }
}
