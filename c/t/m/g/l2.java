package c.t.m.g;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import c.t.m.g.u2;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class l2 {

    /* renamed from: u, reason: collision with root package name */
    public static Location f29827u;

    /* renamed from: a, reason: collision with root package name */
    public n1 f29828a;

    /* renamed from: c, reason: collision with root package name */
    public LocationManager f29830c;

    /* renamed from: d, reason: collision with root package name */
    public b f29831d;

    /* renamed from: e, reason: collision with root package name */
    public c f29832e;

    /* renamed from: f, reason: collision with root package name */
    public Looper f29833f;

    /* renamed from: g, reason: collision with root package name */
    public int f29834g;

    /* renamed from: h, reason: collision with root package name */
    public String f29835h;

    /* renamed from: j, reason: collision with root package name */
    public long f29837j;

    /* renamed from: m, reason: collision with root package name */
    public int f29840m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f29841n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f29842o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f29843p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f29844q;

    /* renamed from: r, reason: collision with root package name */
    public d f29845r;

    /* renamed from: b, reason: collision with root package name */
    public boolean f29829b = false;

    /* renamed from: i, reason: collision with root package name */
    public long f29836i = 0;

    /* renamed from: k, reason: collision with root package name */
    public Location f29838k = null;

    /* renamed from: l, reason: collision with root package name */
    public Location f29839l = null;

    /* renamed from: s, reason: collision with root package name */
    public boolean f29846s = false;

    /* renamed from: t, reason: collision with root package name */
    public w1 f29847t = new a();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements w1 {
        public a() {
        }

        @Override // c.t.m.g.w1
        public void a(int i3) {
            if (i3 == 1) {
                l2.this.f29846s = false;
            } else {
                l2.this.f29846s = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class c extends Handler {
        public c(@NonNull Looper looper) {
            super(looper);
        }

        public final void a(Message message) {
            if (message.what == 1003) {
                y0.a(l2.this.f29832e, 1003);
                try {
                    if (l2.this.f29846s) {
                        l2 l2Var = l2.this;
                        l2Var.a((Location) null, l2Var.f29845r);
                        return;
                    }
                    if (l2.this.a(l2.f29827u, "sNlpFromGpsProvider")) {
                        return;
                    }
                    l2 l2Var2 = l2.this;
                    if (l2Var2.a(l2Var2.f29839l, "lastnlpLocation")) {
                        return;
                    }
                    Location lastKnownLocation = LocationMonitor.getLastKnownLocation(l2.this.f29830c, "network");
                    if (lastKnownLocation != null) {
                        l2.this.f29838k = lastKnownLocation;
                        l2.this.f29837j = System.currentTimeMillis();
                        d dVar = l2.this.f29845r;
                        if (dVar != null) {
                            lastKnownLocation.setTime(System.currentTimeMillis());
                            lastKnownLocation.setAccuracy(5000.0f);
                            l2.this.a(lastKnownLocation, dVar);
                            return;
                        }
                        return;
                    }
                    k3.a("NLP", "lastKnowLoc invalid");
                    l2 l2Var3 = l2.this;
                    l2Var3.a((Location) null, l2Var3.f29845r);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            try {
                a(message);
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface d {
        void a(String str, v2 v2Var);
    }

    public l2(n1 n1Var) {
        if (n1Var != null) {
            try {
                this.f29828a = n1Var;
                if (n1Var.a() != null) {
                    n1Var.a().a(this.f29847t);
                }
                this.f29830c = n1Var.b();
                this.f29831d = new b();
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void a(int i3, int i16, String str, boolean z16, boolean z17, boolean z18) {
        this.f29840m = i3;
        this.f29834g = i16;
        this.f29835h = str;
        this.f29841n = z16;
        this.f29843p = z17;
        this.f29842o = z18;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized void a(Looper looper, d dVar) {
        try {
            this.f29845r = dVar;
        } catch (Throwable unused) {
        }
        if (this.f29846s) {
            a((Location) null, dVar);
            return;
        }
        if (a(f29827u, "sNlpFromGpsProvider")) {
            return;
        }
        if (a(this.f29839l, "lastnlpLocation")) {
            return;
        }
        if (a(this.f29838k, "lastKownLocation")) {
            return;
        }
        if (this.f29829b) {
            y0.a(this.f29832e, 1003, 500L);
            return;
        }
        this.f29829b = true;
        c cVar = new c(looper);
        this.f29832e = cVar;
        this.f29836i = 0L;
        y0.a(cVar, 1003, 500L);
        List<String> allProviders = this.f29830c.getAllProviders();
        boolean z16 = false;
        if (allProviders != null) {
            Iterator<String> it = allProviders.iterator();
            while (it.hasNext()) {
                if ("network".equals(it.next())) {
                    z16 = true;
                }
            }
        }
        if (z16) {
            LocationMonitor.requestLocationUpdates(this.f29830c, "network", 500L, 0.0f, this.f29831d, this.f29833f);
        }
        k3.a("NLP", "start," + z16);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class b implements LocationListener {
        public b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            try {
                d dVar = l2.this.f29845r;
                if (location != null) {
                    location.setAccuracy(5000.0f);
                    location.setTime(System.currentTimeMillis());
                    l2.this.f29839l = location;
                    if (l2.this.f29829b && dVar != null && System.currentTimeMillis() - l2.this.f29836i > 10000) {
                        k3.a("NLP", "lastnlpLocation update");
                        l2.this.f29844q = false;
                        l2.this.f29836i = System.currentTimeMillis();
                        if (l2.this.a(l2.f29827u, "sNlpFromGpsProvider")) {
                            return;
                        }
                        location.setAccuracy(5000.0f);
                        location.setTime(System.currentTimeMillis());
                        l2.this.a(location, dVar);
                    }
                }
            } catch (Exception unused) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i3, Bundle bundle) {
        }
    }

    public final boolean a(Location location, String str) {
        if (location == null || System.currentTimeMillis() - location.getTime() >= 40000) {
            return false;
        }
        a(location, this.f29845r);
        return true;
    }

    public synchronized void a() {
        if (this.f29829b) {
            this.f29829b = false;
            y0.b(this.f29832e);
            this.f29832e = null;
            LocationMonitor.removeUpdates(this.f29830c, this.f29831d);
            k3.a("NLP", "stop");
        }
    }

    public final void a(Location location, d dVar) {
        try {
            if (location == null) {
                if (dVar != null) {
                    dVar.a(null, null);
                    return;
                }
                return;
            }
            if (this.f29840m == 1 && j3.a(location.getLatitude(), location.getLongitude())) {
                double[] dArr = new double[2];
                t3.a(location, dArr);
                a(location, dArr[0], dArr[1], 0, 0);
            } else {
                a(location, location.getLatitude(), location.getLongitude(), 0, 0);
            }
            v2 v2Var = new v2(null, null, new u2(location, System.currentTimeMillis(), 0, 0, 0, u2.a.NONE), true);
            String a16 = v2Var.a(this.f29834g, this.f29835h, this.f29828a, this.f29841n && !this.f29842o, this.f29843p, this.f29842o);
            if (dVar != null) {
                dVar.a(a16, v2Var);
            }
        } catch (Throwable unused) {
        }
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
}
