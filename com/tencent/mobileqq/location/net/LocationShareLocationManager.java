package com.tencent.mobileqq.location.net;

import android.app.Activity;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.map.geolocation.TencentDirectionListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.location.LocationShareViewModel;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.ReportLocationHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LocationShareLocationManager {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static volatile LocationShareLocationManager f241316i;

    /* renamed from: j, reason: collision with root package name */
    public static LatLng f241317j;

    /* renamed from: a, reason: collision with root package name */
    public ReportLocationHandler f241318a;

    /* renamed from: b, reason: collision with root package name */
    private volatile d f241319b;

    /* renamed from: c, reason: collision with root package name */
    private TencentLocationManager f241320c;

    /* renamed from: d, reason: collision with root package name */
    private TencentLocationListener f241321d;

    /* renamed from: e, reason: collision with root package name */
    private TencentDirectionListener f241322e;

    /* renamed from: f, reason: collision with root package name */
    private double f241323f;

    /* renamed from: g, reason: collision with root package name */
    private LatLng f241324g;

    /* renamed from: h, reason: collision with root package name */
    private LocationRoom.b f241325h;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements TencentLocationListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ LocationRoom C;

        /* renamed from: d, reason: collision with root package name */
        private volatile boolean f241329d;

        /* renamed from: e, reason: collision with root package name */
        private volatile boolean f241330e;

        /* renamed from: f, reason: collision with root package name */
        private Runnable f241331f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f241332h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Runnable f241333i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ MqqHandler f241334m;

        a(boolean z16, Runnable runnable, MqqHandler mqqHandler, LocationRoom locationRoom) {
            this.f241332h = z16;
            this.f241333i = runnable;
            this.f241334m = mqqHandler;
            this.C = locationRoom;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LocationShareLocationManager.this, Boolean.valueOf(z16), runnable, mqqHandler, locationRoom);
                return;
            }
            this.f241329d = true;
            this.f241330e = !z16;
            this.f241331f = runnable;
        }

        @Override // com.tencent.map.geolocation.TencentLocationListener
        public void onLocationChanged(TencentLocation tencentLocation, int i3, String str) {
            LatLng latLng;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, tencentLocation, Integer.valueOf(i3), str);
                return;
            }
            if (i3 == 0) {
                LatLng latLng2 = new LatLng(tencentLocation.getLatitude(), tencentLocation.getLongitude());
                if (QLog.isColorLevel() && (latLng = LocationShareLocationManager.f241317j) != null) {
                    latLng2 = latLng;
                }
                if (latLng2.getLatitude() != 0.0d || latLng2.getLongitude() != 0.0d) {
                    LocationShareLocationManager.this.f241324g = latLng2;
                } else {
                    if (this.f241329d) {
                        this.f241329d = false;
                        QLog.e("Q.LocationShare", 1, "[LocationManager] onLocationChanged: invoked. (0,0) detected");
                        return;
                    }
                    return;
                }
            }
            if (this.f241330e && this.f241331f != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.LocationShare", 2, "[LocationManager] onLocationChanged: invoked. remove over time runnable");
                }
                this.f241334m.removeCallbacks(this.f241331f);
                this.f241331f = null;
            }
            if (i3 != 0) {
                LocationRoom.b g16 = this.C.g();
                LocationShareViewModel.h2((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null), g16.b(), g16.c(), 1);
            } else {
                if (this.f241330e) {
                    this.f241330e = false;
                    e.c().a(LocationShareLocationManager.this.f241325h.b(), LocationShareLocationManager.this.f241325h.c());
                }
                LocationShareLocationManager.h().j(true);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.LocationShare", 2, "[LocationManager] onLocationChanged: invoked. errorCode: " + i3 + " errorMsg: " + str);
            }
        }

        @Override // com.tencent.map.geolocation.TencentLocationListener
        public void onStatusUpdate(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements TencentDirectionListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationShareLocationManager.this);
            }
        }

        @Override // com.tencent.map.geolocation.TencentDirectionListener
        public void onDirectionChanged(double d16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16), Integer.valueOf(i3));
            } else if (LocationShareLocationManager.this.f241324g != null) {
                LocationShareLocationManager.this.f241323f = d16 + 180.0d;
                LocationShareLocationManager.h().j(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements ReportLocationHandler.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationShareLocationManager.this);
            }
        }

        @Override // com.tencent.mobileqq.location.net.ReportLocationHandler.a
        public com.tencent.mobileqq.location.data.a getLocation() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.location.data.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            if (LocationShareLocationManager.this.f241324g == null) {
                QLog.d("Q.LocationShare", 1, "[LocationManager] getLocation: invoked. location null detected");
            }
            return new com.tencent.mobileqq.location.data.a(((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getAccount(), LocationShareLocationManager.this.f241324g, LocationShareLocationManager.this.f241323f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface d {
        void a(LatLng latLng, Double d16, boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26717);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f241317j = null;
        }
    }

    LocationShareLocationManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f241323f = 0.0d;
        this.f241324g = null;
        this.f241318a = new ReportLocationHandler();
    }

    private void f() {
        try {
            Field declaredField = this.f241320c.getClass().getDeclaredField("c");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.f241320c);
            Field declaredField2 = obj.getClass().getDeclaredField("b");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Field declaredField3 = obj2.getClass().getDeclaredField("g");
            declaredField3.setAccessible(true);
            declaredField3.set(obj2, null);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (NoSuchFieldException e17) {
            e17.printStackTrace();
        }
    }

    public static LocationShareLocationManager h() {
        if (f241316i == null) {
            synchronized (LocationShareLocationManager.class) {
                if (f241316i == null) {
                    f241316i = new LocationShareLocationManager();
                }
            }
        }
        return f241316i;
    }

    public LatLng g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LatLng) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.f241324g == null) {
            QLog.d("Q.LocationShare", 1, "[LocationManager] getSelfLatLng: invoked. location null detected");
        }
        return this.f241324g;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.f241325h != null) {
            return true;
        }
        return false;
    }

    public synchronized void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            if (this.f241319b != null) {
                this.f241319b.a(this.f241324g, Double.valueOf(this.f241323f), z16);
            }
        }
    }

    public synchronized void k(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.LocationShare", 2, "removeLocationListener: invoked. listener: ", dVar + " mLocationListener: ", this.f241319b);
        }
        if (dVar == this.f241319b) {
            this.f241319b = null;
        }
    }

    public synchronized void l(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
        } else {
            this.f241319b = dVar;
        }
    }

    public void m(Activity activity, LocationRoom locationRoom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) locationRoom);
            return;
        }
        if (i()) {
            return;
        }
        this.f241325h = locationRoom.g();
        e.c().f241358b = this.f241325h;
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(LocationHandler.K2());
        }
        Runnable runnable = new Runnable(new SoftReference(activity)) { // from class: com.tencent.mobileqq.location.net.LocationShareLocationManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ SoftReference f241326d;

            {
                this.f241326d = r5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocationShareLocationManager.this, (Object) r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.LocationShare", 2, "[LocationManager] startLocationUpdate: invoked. call over time runnable");
                }
                if (LocationShareLocationManager.this.f241325h != null) {
                    e.c().e(LocationShareLocationManager.this.f241325h.b(), LocationShareLocationManager.this.f241325h.c(), LocationHandler.K2().H2(), 4);
                    LocationShareLocationManager.h().o(LocationShareLocationManager.this.f241325h, true);
                }
                QQToast.makeText(BaseApplication.getContext(), "\u4f4d\u7f6e\u83b7\u53d6\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
                Activity activity2 = (Activity) this.f241326d.get();
                if (activity2 != null && !activity2.isFinishing()) {
                    this.f241326d.clear();
                    activity2.finish();
                }
            }
        };
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        boolean n3 = this.f241318a.n(this.f241325h);
        if (n3) {
            e.c().a(this.f241325h.b(), this.f241325h.c());
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("Q.LocationShare", 2, "[LocationManager] startLocationUpdate: invoked.  add over time runnable");
            }
            uIHandler.postDelayed(runnable, 15000L);
        }
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).initLocationManager();
        this.f241320c = TencentLocationManager.getInstance(BaseApplication.getContext());
        this.f241321d = new a(n3, runnable, uIHandler, locationRoom);
        this.f241322e = new b();
        int requestLocationUpdates = this.f241320c.requestLocationUpdates(TencentLocationRequest.create().setInterval(2000L), this.f241321d);
        if (requestLocationUpdates != 0) {
            QLog.e("Q.LocationShare", 1, "[LocationManager] requestLocationUpdates: invoked. error: " + requestLocationUpdates);
            QQToast.makeText(BaseApplication.getContext(), "\u5730\u56fe\u5b9a\u4f4d\u7cfb\u7edf\u521d\u59cb\u5316\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
            if (activity != null) {
                activity.finish();
            }
        }
        int startDirectionUpdates = this.f241320c.startDirectionUpdates(this.f241322e, Looper.myLooper());
        if (startDirectionUpdates != 0) {
            QLog.e("Q.LocationShare", 1, "[LocationManager] startDirectionUpdates: invoked. error: " + startDirectionUpdates);
            QQToast.makeText(BaseApplication.getContext(), 1, "\u65b9\u5411\u7bad\u5934\u6682\u4e0d\u53ef\u7528", 0).show();
        }
    }

    public void n(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
        } else {
            this.f241318a.u(str, i3, new c());
        }
    }

    public void o(LocationRoom.b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bVar, Boolean.valueOf(z16));
            return;
        }
        if (!z16 && bVar != null && !bVar.equals(this.f241325h)) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            ThreadManager.getUIHandler().post(new Runnable(bVar, z16) { // from class: com.tencent.mobileqq.location.net.LocationShareLocationManager.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ LocationRoom.b f241327d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f241328e;

                {
                    this.f241327d = bVar;
                    this.f241328e = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LocationShareLocationManager.this, bVar, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LocationShareLocationManager.this.o(this.f241327d, this.f241328e);
                    }
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.LocationShare", 2, "stopLocationSharing: invoked. roomKey: " + bVar);
        }
        this.f241325h = null;
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.unregisterCallback(LocationHandler.K2());
        }
        TencentLocationManager tencentLocationManager = this.f241320c;
        if (tencentLocationManager != null) {
            this.f241322e = null;
            tencentLocationManager.removeUpdates(this.f241321d);
            this.f241320c.stopDirectionUpdate();
            f();
            this.f241320c = null;
        }
        this.f241318a.k();
        QQNotificationManager.getInstance().cancel("Q.LocationShare", 525);
        try {
            ((IFloatMapService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "")).quitFloat(-1);
        } catch (Throwable th5) {
            QLog.e("Q.LocationShare", 1, "stopLocationSharing: failed. ", th5);
        }
    }
}
