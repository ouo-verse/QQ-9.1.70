package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.exifinterface.media.ExifInterface;
import c.t.m.g.t;
import c.t.m.g.u2;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public final class f2 implements LocationListener {

    /* renamed from: b, reason: collision with root package name */
    public final n1 f29610b;

    /* renamed from: d, reason: collision with root package name */
    public volatile Location f29612d;

    /* renamed from: e, reason: collision with root package name */
    public Location f29613e;

    /* renamed from: i, reason: collision with root package name */
    public GpsStatus f29617i;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f29622n;

    /* renamed from: q, reason: collision with root package name */
    public boolean f29625q;

    /* renamed from: r, reason: collision with root package name */
    public HandlerThread f29626r;

    /* renamed from: s, reason: collision with root package name */
    public x1 f29627s;

    /* renamed from: t, reason: collision with root package name */
    public Handler f29628t;

    /* renamed from: u, reason: collision with root package name */
    public f2 f29629u;

    /* renamed from: v, reason: collision with root package name */
    public t f29630v;

    /* renamed from: w, reason: collision with root package name */
    public b f29631w;

    /* renamed from: a, reason: collision with root package name */
    public long f29609a = 0;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f29611c = false;

    /* renamed from: f, reason: collision with root package name */
    public int f29614f = 1024;

    /* renamed from: g, reason: collision with root package name */
    public boolean f29615g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f29616h = false;

    /* renamed from: j, reason: collision with root package name */
    public int f29618j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f29619k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f29620l = 0;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<Float> f29621m = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f29623o = true;

    /* renamed from: p, reason: collision with root package name */
    public volatile long f29624p = 0;

    /* renamed from: x, reason: collision with root package name */
    public volatile boolean f29632x = false;

    /* renamed from: y, reason: collision with root package name */
    public w1 f29633y = new a();

    /* renamed from: z, reason: collision with root package name */
    public final double[] f29634z = new double[2];

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements w1 {
        public a() {
        }

        @Override // c.t.m.g.w1
        public void a(int i3) {
            if (i3 == 1 && f2.this.f29632x && f2.this.f29622n) {
                try {
                    o3.a("backgroundloc", "back to foreground ,request gps location again");
                    LocationMonitor.requestLocationUpdates(f2.this.f29610b.b(), "gps", 1000L, 0.0f, f2.this.f29629u, f2.this.f29626r.getLooper());
                } catch (Throwable th5) {
                    o3.a("TxGpsProvider", th5.toString());
                }
                f2.this.f29632x = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class b extends t.g {
        public b() {
        }

        @Override // c.t.m.g.t.g
        public void a(Object obj) {
        }

        @Override // c.t.m.g.t.g
        public void d(int i3) {
            f2.this.a(i3);
        }

        @Override // c.t.m.g.t.g
        public void a(long j3, String str) {
            f2.this.b(j3, str);
        }

        @Override // c.t.m.g.t.g
        public void c(Object obj) {
        }
    }

    public f2(n1 n1Var) {
        this.f29610b = n1Var;
        n1Var.a().a(this.f29633y);
        this.f29613e = new Location("gps");
        this.f29630v = new t();
        this.f29627s = x1.a();
        this.f29629u = this;
    }

    public final void f() {
        this.f29620l = 0;
        this.f29619k = 0;
        this.f29618j = 0;
        GpsStatus gpsStatus = this.f29617i;
        if (gpsStatus == null) {
            return;
        }
        this.f29621m.clear();
        this.f29620l = gpsStatus.getMaxSatellites();
        Iterator<GpsSatellite> it = gpsStatus.getSatellites().iterator();
        if (it == null) {
            return;
        }
        while (it.hasNext() && this.f29618j <= this.f29620l) {
            GpsSatellite next = it.next();
            this.f29618j++;
            this.f29621m.add(Float.valueOf(next.getSnr()));
            if (next.usedInFix()) {
                this.f29619k++;
            }
        }
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        this.f29612d = location;
        c(this.f29612d);
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        if ("gps".equals(str)) {
            o3.b("TxGpsProvider", "onProviderDisabled: gps is disabled");
            this.f29619k = 0;
            this.f29618j = 0;
            this.f29614f = 0;
            this.f29615g = false;
            this.f29609a = 0L;
            d();
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        if ("gps".equals(str)) {
            o3.b("TxGpsProvider", "onProviderEnabled: gps is enabled");
            this.f29614f = 4;
            d();
        }
    }

    public boolean b() {
        try {
            return this.f29610b.b().isProviderEnabled("gps");
        } catch (Throwable th5) {
            o3.a("TxGpsProvider", th5.toString());
            return false;
        }
    }

    public final synchronized void c(Location location) {
        if (location != null) {
            if ("gps".equals(location.getProvider()) && b(location)) {
                f();
                this.f29614f |= 2;
                if (a(this.f29619k, LocationMonitor.getAccuracy(location), location.getBearing(), location.getSpeed())) {
                    location.setTime(System.currentTimeMillis());
                    l2.f29827u = location;
                } else {
                    this.f29609a = System.currentTimeMillis();
                    a(location, a(this.f29610b.f29875a, location));
                    this.f29612d = null;
                }
            }
        }
    }

    public final void d() {
        int i3 = this.f29614f;
        int i16 = i3 == 4 ? 1 : i3 == 0 ? 0 : -1;
        if (i3.f29764a) {
            i16 = 5;
        }
        Message message = new Message();
        message.what = 12999;
        message.arg1 = 12002;
        message.arg2 = i16;
        this.f29610b.a(message);
    }

    public final void e() {
        if (this.f29622n) {
            this.f29622n = false;
            this.f29609a = 0L;
            this.f29614f = 1024;
            this.f29615g = false;
            this.f29616h = false;
            this.f29620l = 0;
            this.f29619k = 0;
            this.f29618j = 0;
            this.f29621m.clear();
            this.f29625q = false;
            Arrays.fill(this.f29634z, 0.0d);
            try {
                LocationMonitor.removeUpdates(this.f29610b.b(), this);
            } catch (Throwable th5) {
                o3.a("TxGpsProvider", th5.toString());
            }
            try {
                this.f29630v.e();
                this.f29631w = null;
            } catch (Throwable th6) {
                o3.a("TxGpsProvider", th6.toString());
            }
            try {
                this.f29628t.removeCallbacksAndMessages(null);
                this.f29626r.quit();
            } catch (Throwable th7) {
                o3.a("TxGpsProvider", th7.toString());
            }
            this.f29611c = false;
            k3.a("gps", "stop");
            o3.b("TxGpsProvider", "shutdown: state=[shutdown]");
        }
    }

    public void a(long j3, boolean z16) {
        if (this.f29622n) {
            return;
        }
        this.f29622n = true;
        this.f29626r = new BaseHandlerThread("gps_provider");
        LocationManager b16 = this.f29610b.b();
        this.f29626r.start();
        this.f29628t = new Handler(this.f29626r.getLooper());
        try {
            if (!z16) {
                if (o1.b() == 1) {
                    this.f29632x = false;
                    try {
                        o3.a("backgroundloc", "request gps in foreground");
                        LocationMonitor.requestLocationUpdates(this.f29610b.b(), "gps", 1000L, 0.0f, this.f29629u, this.f29626r.getLooper());
                    } catch (Throwable th5) {
                        o3.a("TxGpsProvider", th5.toString());
                    }
                } else {
                    o3.a("backgroundloc", "request gps in background,donot allow");
                    this.f29632x = true;
                }
                this.f29624p = System.currentTimeMillis();
                try {
                    b bVar = new b();
                    this.f29631w = bVar;
                    this.f29630v.a(6, bVar, this.f29628t.getLooper());
                } catch (Throwable unused) {
                }
            } else {
                LocationMonitor.requestLocationUpdates(b16, "passive", 5000L, 0.0f, this, this.f29626r.getLooper());
            }
        } catch (Exception e16) {
            i3.f29764a = true;
            o3.a("TxGpsProvider", "startup: can not add location listener", e16);
        }
        if (b()) {
            this.f29614f = 4;
            d();
        }
        k3.a("gps", "start," + b());
        o3.b("TxGpsProvider", "startup: state=[start]");
    }

    public void b(boolean z16) {
        this.f29625q = z16;
    }

    public final boolean b(Location location) {
        double a16 = t3.a(location.getLatitude(), 6);
        double a17 = t3.a(location.getLongitude(), 6);
        o3.a("TxGpsProvider", "lat:" + a16 + ",lng:" + a17);
        if (a(a16) && a(a17)) {
            return false;
        }
        if (((a16 * 1000000.0d) % 1000.0d == 0.0d && (1000000.0d * a17) % 1000.0d == 0.0d) || Math.abs(a16) < 1.0E-8d || Math.abs(a17) < 1.0E-8d || Math.abs(a16 - 1.0d) < 1.0E-8d || Math.abs(a17 - 1.0d) < 1.0E-8d || a16 < -90.0d || a16 > 90.0d || a17 < -180.0d || a17 > 180.0d) {
            return false;
        }
        if (Math.abs(location.getTime() - System.currentTimeMillis()) <= MiniBoxNoticeInfo.MIN_5) {
            return true;
        }
        o3.a("TxGpsProvider", "time:" + location.getTime() + ",current:" + System.currentTimeMillis());
        return true;
    }

    public void b(long j3, String str) {
        a(j3, str);
    }

    public final boolean c() {
        int i3 = this.f29618j;
        int i16 = this.f29619k;
        if (i3 > 0) {
            this.f29616h = true;
        }
        if (i16 > 0) {
            this.f29615g = true;
        }
        if (this.f29616h && i3 <= 2) {
            return false;
        }
        if (this.f29615g) {
            if (i16 >= 3 || i16 == 0) {
                return true;
            }
        } else if (i16 == 0) {
            return true;
        }
        return false;
    }

    public boolean a() {
        boolean z16 = false;
        if ((this.f29614f & 2) == 2 && System.currentTimeMillis() - this.f29609a < e2.d().c()) {
            z16 = true;
        }
        k3.a("gps", "avaiable," + this.f29614f);
        return z16;
    }

    public final boolean a(double d16) {
        return Math.abs(((double) Double.valueOf(d16).longValue()) - d16) < Double.MIN_VALUE;
    }

    public final void a(Location location, int i3) {
        int i16 = this.f29619k;
        int i17 = i16 == 3 ? 1 : (i16 < 4 || i16 > 6) ? i16 >= 7 ? 3 : 0 : 2;
        if (this.f29625q && j3.a(location.getLatitude(), location.getLongitude())) {
            o3.b("TxGpsProvider", "notifyListeners: local deflect");
            t3.a(location, this.f29634z);
            double[] dArr = this.f29634z;
            a(location, dArr[0], dArr[1], i17, i3);
        } else {
            a(location, location.getLatitude(), location.getLongitude(), i17, i3);
        }
        this.f29610b.a(new u2(location, this.f29609a, this.f29618j, this.f29619k, this.f29614f, u2.a.GPS));
    }

    public final double a(String str) {
        double parseDouble = Double.parseDouble(str);
        double floor = (int) Math.floor(parseDouble / 100.0d);
        return floor + ((parseDouble - (100.0d * floor)) / 60.0d);
    }

    public final void a(boolean z16) {
        int i3 = z16 ? 3 : 4;
        Message message = new Message();
        message.what = 12999;
        message.arg1 = 12004;
        message.arg2 = i3;
        this.f29610b.a(message);
    }

    @SuppressLint({"NewApi"})
    public final int a(Context context, Location location) {
        try {
        } catch (Throwable th5) {
            o3.a("TxGpsProvider", th5.toString());
        }
        if (!this.f29610b.b().isProviderEnabled("gps")) {
            k3.a("gps", "mock,1");
            return 1;
        }
        if (location.isFromMockProvider()) {
            k3.a("gps", "mock,2");
            return 1;
        }
        if (!a(location)) {
            k3.a("gps", "mock,11");
            return 1;
        }
        if (!this.f29623o && this.f29610b.a().o() > 0 && System.currentTimeMillis() - this.f29624p > 120000) {
            o3.a("TxGpsProvider", "indoor,but has location,mock!!");
            k3.a("gps", "mock,22");
            return 2;
        }
        Location location2 = this.f29613e;
        if (location2 == null) {
            return 0;
        }
        float distanceTo = location.distanceTo(location2);
        if (distanceTo <= 100.0f || this.f29623o) {
            return 0;
        }
        o3.a("TxGpsProvider", "Distance:" + distanceTo);
        k3.a("gps", "mock,3");
        return 3;
    }

    @SuppressLint({"NewApi"})
    public final boolean a(Location location) {
        try {
            if (location.getElapsedRealtimeNanos() == 0) {
                return false;
            }
        } catch (Throwable th5) {
            o3.a("TxGpsProvider", "isComplete: ", th5);
        }
        if (this.f29610b.a().o() <= 0 || location.getSpeed() != 0.0f || location.getBearing() != 0.0f) {
            return true;
        }
        o3.a("TxGpsProvider", "txy fake");
        return false;
    }

    public final void a(long j3, String str) {
        if (str == null || str.length() <= 5) {
            return;
        }
        int indexOf = str.indexOf(",");
        String trim = indexOf <= 0 ? null : str.substring(0, indexOf).trim();
        if (trim == null || trim.length() <= 5 || trim.charAt(3) != 'R' || !trim.contains("RMC")) {
            return;
        }
        String[] split = str.split(",");
        if (ExifInterface.GPS_MEASUREMENT_IN_PROGRESS.equals(split[2])) {
            try {
                this.f29613e.setLatitude(a(split[3]));
                this.f29613e.setLongitude(a(split[5]));
            } catch (Throwable th5) {
                o3.a("TxGpsProvider", "<" + str + ">", th5);
            }
            boolean z16 = this.f29611c;
            this.f29611c = true;
            if (z16) {
                return;
            }
            c(this.f29612d);
        }
    }

    public final boolean a(int i3, double d16, double d17, double d18) {
        if (i3 == 0 && f1.a(d17) && d18 <= 0.0d) {
            return true;
        }
        return i3 == 0 && d16 > 1000.0d;
    }

    public void a(int i3) {
        ArrayList<Float> arrayList;
        if (i3 == 1) {
            this.f29614f |= 1;
            return;
        }
        if (i3 == 2) {
            this.f29614f = 0;
            return;
        }
        if (i3 == 3) {
            this.f29614f |= 2;
            return;
        }
        if (i3 != 4) {
            return;
        }
        LocationManager b16 = this.f29610b.b();
        try {
            GpsStatus gpsStatus = this.f29617i;
            if (gpsStatus == null) {
                this.f29617i = b16.getGpsStatus(null);
            } else {
                b16.getGpsStatus(gpsStatus);
            }
        } catch (Exception unused) {
        }
        f();
        c();
        if (this.f29617i != null && (arrayList = this.f29621m) != null && arrayList.size() > 0) {
            try {
                this.f29623o = this.f29627s.a(this.f29621m, this.f29618j);
                if (this.f29623o) {
                    this.f29624p = System.currentTimeMillis();
                }
            } catch (Throwable th5) {
                o3.a("TxGpsProvider", "judgeIO Error!", th5);
            }
        }
        a(this.f29623o);
    }

    public final void a(Location location, double d16, double d17, int i3, int i16) {
        Bundle extras = location.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putDouble(QCircleSchemeAttr.Polymerize.LAT, d16);
        extras.putDouble("lng", d17);
        extras.putInt("rssi", i3);
        extras.putInt("fakeCode", i16);
        location.setExtras(extras);
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i3, Bundle bundle) {
    }
}
