package c.t.m.g;

import android.annotation.SuppressLint;
import android.location.GnssMeasurementsEvent;
import android.location.GnssNavigationMessage;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;

/* compiled from: P */
/* loaded from: classes.dex */
public class t extends f0 {

    /* renamed from: e, reason: collision with root package name */
    public int f29983e = 0;

    /* renamed from: f, reason: collision with root package name */
    public volatile g f29984f = g.f29998a;

    /* renamed from: g, reason: collision with root package name */
    public LocationManager f29985g = null;

    /* renamed from: h, reason: collision with root package name */
    public Object f29986h;

    /* renamed from: i, reason: collision with root package name */
    public Object f29987i;

    /* renamed from: j, reason: collision with root package name */
    public Object f29988j;

    /* renamed from: k, reason: collision with root package name */
    public Object f29989k;

    /* renamed from: l, reason: collision with root package name */
    public Object f29990l;

    /* renamed from: m, reason: collision with root package name */
    public Object f29991m;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a extends GnssMeasurementsEvent.Callback {
        public a() {
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            t.this.f29984f.a(gnssMeasurementsEvent);
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(int i3) {
            t.this.f29984f.a(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class b extends GnssNavigationMessage.Callback {
        public b() {
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onGnssNavigationMessageReceived(GnssNavigationMessage gnssNavigationMessage) {
            t.this.f29984f.b(gnssNavigationMessage);
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onStatusChanged(int i3) {
            t.this.f29984f.b(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class c extends GnssStatus.Callback {
        public c() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i3) {
            t.this.f29984f.c(i3);
            t.this.f29984f.d(3);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            t.this.f29984f.c(gnssStatus);
            t.this.f29984f.d(4);
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            t.this.f29984f.a();
            t.this.f29984f.d(1);
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            t.this.f29984f.b();
            t.this.f29984f.d(2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class d implements GpsStatus.Listener {
        public d() {
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i3) {
            t.this.f29984f.d(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class e implements OnNmeaMessageListener {
        public e() {
        }

        @Override // android.location.OnNmeaMessageListener
        public void onNmeaMessage(String str, long j3) {
            t.this.f29984f.a(j3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class f implements GpsStatus.NmeaListener {
        public f() {
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j3, String str) {
            t.this.f29984f.a(j3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class g {

        /* renamed from: a, reason: collision with root package name */
        public static final g f29998a = new a();

        /* compiled from: P */
        /* loaded from: classes.dex */
        public class a extends g {
        }

        public void a() {
        }

        public void b() {
        }

        public void c(int i3) {
        }

        public void a(int i3) {
        }

        public void b(int i3) {
        }

        public void c(Object obj) {
        }

        public void a(long j3, String str) {
        }

        public void b(Object obj) {
        }

        public void a(Object obj) {
        }

        public void d(int i3) {
        }
    }

    @Override // c.t.m.g.i0
    public String a() {
        return "GpsExtraInfoPro";
    }

    @Override // c.t.m.g.i0
    public void c() {
        if (this.f29985g != null) {
            i();
            h();
            if (Build.VERSION.SDK_INT >= 24) {
                if ((this.f29983e & 8) != 0) {
                    this.f29985g.unregisterGnssMeasurementsCallback((GnssMeasurementsEvent.Callback) this.f29991m);
                    this.f29991m = null;
                }
                if ((this.f29983e & 16) != 0) {
                    this.f29985g.unregisterGnssNavigationMessageCallback((GnssNavigationMessage.Callback) this.f29990l);
                    this.f29990l = null;
                }
            }
        }
        this.f29983e = 0;
        this.f29984f = g.f29998a;
        this.f29985g = null;
    }

    @SuppressLint({"MissingPermission"})
    public final void f() {
        if ((this.f29983e & 4) == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            e eVar = new e();
            this.f29989k = eVar;
            this.f29985g.addNmeaListener(eVar, d());
        } else {
            f fVar = new f();
            this.f29987i = fVar;
            j1.a(this.f29985g, "addNmeaListener", new Class[]{GpsStatus.NmeaListener.class}, new Object[]{fVar});
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void g() {
        if ((this.f29983e & 2) == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            c cVar = new c();
            this.f29988j = cVar;
            this.f29985g.registerGnssStatusCallback(cVar, d());
        } else {
            d dVar = new d();
            this.f29986h = dVar;
            LocationMonitor.addGpsStatusListener(this.f29985g, dVar);
        }
    }

    public final void h() {
        if ((this.f29983e & 4) == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f29985g.removeNmeaListener((OnNmeaMessageListener) this.f29989k);
            this.f29989k = null;
        } else {
            j1.a(this.f29985g, "removeNmeaListener", new Class[]{GpsStatus.NmeaListener.class}, new Object[]{this.f29987i});
            this.f29987i = null;
        }
    }

    public final void i() {
        if ((this.f29983e & 2) == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f29985g.unregisterGnssStatusCallback((GnssStatus.Callback) this.f29988j);
            this.f29988j = null;
        } else {
            this.f29985g.removeGpsStatusListener((GpsStatus.Listener) this.f29986h);
            this.f29986h = null;
        }
    }

    @Override // c.t.m.g.f0
    public void a(Message message) {
    }

    public void a(int i3, g gVar, Looper looper) {
        synchronized (this.f29761b) {
            this.f29983e = i3;
            this.f29984f = gVar;
            b(looper);
        }
    }

    @Override // c.t.m.g.i0
    @SuppressLint({"MissingPermission"})
    public int a(Looper looper) {
        if (this.f29984f != g.f29998a) {
            LocationManager locationManager = (LocationManager) o0.a().getSystemService("location");
            this.f29985g = locationManager;
            if (locationManager == null) {
                return -1;
            }
            g();
            f();
            if (Build.VERSION.SDK_INT < 24) {
                return 0;
            }
            if ((this.f29983e & 8) != 0) {
                a aVar = new a();
                this.f29991m = aVar;
                this.f29985g.registerGnssMeasurementsCallback(aVar, d());
            }
            if ((this.f29983e & 16) == 0) {
                return 0;
            }
            b bVar = new b();
            this.f29990l = bVar;
            this.f29985g.registerGnssNavigationMessageCallback(bVar, d());
            return 0;
        }
        throw new IllegalStateException("Please invoke startup(GpsRequest,GpsInfoCallback,Looper).");
    }
}
