package com.tencent.luggage.wxa.e6;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tk.l;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xk.a;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationListener;
import com.tencent.map.geolocation.sapp.TencentLocationManager;
import com.tencent.map.geolocation.sapp.TencentLocationRequest;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.map.geolocation.sapp.internal.LocationLogCallback;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.qqmini.sdk.plugins.MapJsPlugin;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements com.tencent.luggage.wxa.xk.a {

    /* renamed from: a, reason: collision with root package name */
    public volatile TencentLocationManager f124556a;

    /* renamed from: b, reason: collision with root package name */
    public TencentLocation f124557b = null;

    /* renamed from: c, reason: collision with root package name */
    public long f124558c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f124559d = 0;

    /* renamed from: e, reason: collision with root package name */
    public String f124560e = "";

    /* renamed from: f, reason: collision with root package name */
    public final List f124561f = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final List f124562g = new CopyOnWriteArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final List f124563h = new CopyOnWriteArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final List f124564i = new CopyOnWriteArrayList();

    /* renamed from: j, reason: collision with root package name */
    public TencentLocationListener f124565j = new b();

    /* renamed from: k, reason: collision with root package name */
    public Set f124566k = new HashSet();

    /* renamed from: l, reason: collision with root package name */
    public Runnable f124567l = new c();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.e6.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6156a implements LocationLogCallback {
        public C6156a() {
        }

        @Override // com.tencent.map.geolocation.sapp.internal.LocationLogCallback
        public void onLog(int i3, String str, String str2, @Nullable Throwable th5) {
            String str3;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 == 6) {
                                Object[] objArr = new Object[3];
                                objArr[0] = str;
                                objArr[1] = str2;
                                if (th5 != null) {
                                    str3 = th5.getMessage();
                                } else {
                                    str3 = "";
                                }
                                objArr[2] = str3;
                                w.b("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s th:%s", objArr);
                                return;
                            }
                            return;
                        }
                        w.h("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                        return;
                    }
                    w.d("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                    return;
                }
                w.a("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                return;
            }
            w.g("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements TencentLocationListener {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.e6.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6157a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TencentLocationListener f124570a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TencentLocation f124571b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f124572c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f124573d;

            public RunnableC6157a(TencentLocationListener tencentLocationListener, TencentLocation tencentLocation, int i3, String str) {
                this.f124570a = tencentLocationListener;
                this.f124571b = tencentLocation;
                this.f124572c = i3;
                this.f124573d = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f124570a.onLocationChanged(this.f124571b, this.f124572c, this.f124573d);
            }
        }

        public b() {
        }

        @Override // com.tencent.map.geolocation.sapp.TencentLocationListener
        public void onLocationChanged(TencentLocation tencentLocation, int i3, String str) {
            if (c0.b()) {
                h.f146825d.b(new RunnableC6157a(this, tencentLocation, i3, str), "MicroMsg.DefaultTencentLocationManager");
                return;
            }
            w.g("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", Integer.valueOf(i3), str);
            if (i3 != 0) {
                w.b("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", Integer.valueOf(i3), str);
            }
            if (a.this.f124562g != null && a.this.f124562g.size() > 0) {
                a aVar = a.this;
                aVar.a(aVar.f124562g, i3, str, a.this.a(tencentLocation, false));
                a.this.f124562g.clear();
            }
            if (a.this.f124561f != null && a.this.f124561f.size() > 0) {
                a aVar2 = a.this;
                aVar2.a(aVar2.f124561f, i3, str, a.this.a(tencentLocation, true));
                a.this.f124561f.clear();
            }
            if (a.this.f124564i != null && a.this.f124564i.size() > 0) {
                a aVar3 = a.this;
                aVar3.a(aVar3.f124564i, i3, str, a.this.a(tencentLocation, false));
            }
            if (a.this.f124563h != null && a.this.f124563h.size() > 0) {
                a aVar4 = a.this;
                aVar4.a(aVar4.f124563h, i3, str, a.this.a(tencentLocation, true));
            }
            a.this.f124557b = tencentLocation;
            a.this.f124558c = System.currentTimeMillis();
            a.this.f124559d = i3;
            a.this.f124560e = str;
            a.this.e();
        }

        @Override // com.tencent.map.geolocation.sapp.TencentLocationListener
        public void onStatusUpdate(String str, int i3, String str2) {
            w.d("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]name:%s, status:%d, desc:%s", str, Integer.valueOf(i3), str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f124561f != null && a.this.f124561f.size() > 0) {
                a aVar = a.this;
                aVar.a(aVar.f124561f, -1, "timeout", null);
            }
            if (a.this.f124562g != null && a.this.f124562g.size() > 0) {
                a aVar2 = a.this;
                aVar2.a(aVar2.f124562g, -1, "timeout", null);
            }
        }
    }

    public a() {
        w.d("MicroMsg.DefaultTencentLocationManager", "DefaultTencentLocationManager() construct in process %s", z.i());
    }

    public boolean b() {
        return false;
    }

    public void g(String str) {
        this.f124566k.remove(str);
    }

    @Override // com.tencent.luggage.wxa.xk.a
    public void getLocation(String str, a.b bVar, Bundle bundle) {
        boolean equals = MapJsPlugin.LOCATION_TYPE_84.equals(str);
        boolean z16 = bundle.getBoolean("enableIndoor");
        boolean z17 = bundle.getBoolean("isHighAccuracy", false);
        int i3 = bundle.getInt("highAccuracyExpireTime", 3000);
        boolean z18 = bundle.getBoolean("useCache", false);
        if ((z18 && this.f124557b != null) || (this.f124557b != null && System.currentTimeMillis() - this.f124558c < 5000)) {
            w.d("MicroMsg.DefaultTencentLocationManager", "useCache enableIndoor:%b isHighAccuracy:%b highAccuracyExpireTime:%d", Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
            bVar.a(this.f124559d, this.f124560e, a(this.f124557b, equals));
            return;
        }
        if (MapJsPlugin.LOCATION_TYPE_84.equals(str)) {
            this.f124561f.add(bVar);
            if (this.f124561f.size() > 1) {
                return;
            }
        } else {
            this.f124562g.add(bVar);
            if (this.f124562g.size() > 1) {
                return;
            }
        }
        l.a().b(this.f124567l);
        l.a().b(this.f124567l, 20000L);
        TencentLocationRequest create = TencentLocationRequest.create();
        create.setInterval(2000L);
        create.setIndoorLocationMode(z16);
        create.setSmallAppKey(bundle.getString("smallAppKey"));
        create.setmExpirationTime(i3);
        create.setAndroidId(com.tencent.luggage.wxa.t9.l.b());
        create.setOpenId(bundle.getString("openId"));
        int requestSingleFreshLocation = getLocationManager().requestSingleFreshLocation(create, this.f124565j, Looper.getMainLooper(), z17);
        w.a("MicroMsg.DefaultTencentLocationManager", "MapReport:%s getLocation openId:%s", bundle.getString("smallAppKey"), bundle.getString("openId"));
        w.d("MicroMsg.DefaultTencentLocationManager", "enableIndoor:%b isHighAccuracy:%b highAccuracyExpireTime:%d useCache:%b requestCode %d", Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Boolean.valueOf(z18), Integer.valueOf(requestSingleFreshLocation));
    }

    @Override // com.tencent.luggage.wxa.xk.a
    public a.C6919a getLocationCache(String str, int i3) {
        boolean equals = MapJsPlugin.LOCATION_TYPE_84.equals(str);
        if (this.f124557b != null && System.currentTimeMillis() - this.f124558c < i3) {
            return a(this.f124557b, equals);
        }
        return null;
    }

    public TencentLocationManager getLocationManager() {
        if (this.f124556a == null) {
            synchronized (this) {
                if (this.f124556a == null) {
                    if (b()) {
                        try {
                            TencentExtraKeys.setTencentLog(z.c(), new File(x.b(new v(x.b(com.tencent.luggage.wxa.db.a.e() + "/lbs" + z.i().substring(z.h().length() + 1), true)).m(), true)));
                        } catch (Exception e16) {
                            w.f("MicroMsg.DefaultTencentLocationManager", "", e16);
                        }
                    }
                    TencentExtraKeys.setContext(z.c());
                    try {
                        TencentExtraKeys.setTencentLogCallback(new C6156a());
                    } catch (Exception e17) {
                        w.f("MicroMsg.DefaultTencentLocationManager", "", e17);
                    }
                    if (TextUtils.isEmpty("")) {
                        this.f124556a = TencentLocationManager.getInstance(z.c());
                    } else {
                        this.f124556a = TencentLocationManager.getInstance(z.c(), new Pair("oaId", ""));
                    }
                    this.f124556a.setCoordinateType(0);
                    w.d("MicroMsg.DefaultTencentLocationManager", "%s Location Sdk Version %s", "", this.f124556a.getVersion());
                }
            }
        }
        return this.f124556a;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c8  */
    @Override // com.tencent.luggage.wxa.xk.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean registerLocation(String str, a.b bVar, Bundle bundle) {
        boolean z16;
        boolean z17;
        boolean z18;
        long j3;
        w.d("MicroMsg.DefaultTencentLocationManager", "[registerLocation]type:%s", str);
        if (MapJsPlugin.LOCATION_TYPE_84.equals(str)) {
            for (a.b bVar2 : this.f124563h) {
                if (bVar2 != null && bVar2.equals(bVar)) {
                    w.f("MicroMsg.DefaultTencentLocationManager", "already register");
                    return false;
                }
            }
            this.f124563h.add(bVar);
        } else {
            for (a.b bVar3 : this.f124564i) {
                if (bVar3 != null && bVar3.equals(bVar)) {
                    w.f("MicroMsg.DefaultTencentLocationManager", "already register");
                    return false;
                }
            }
            this.f124564i.add(bVar);
        }
        if (bundle != null) {
            a(bundle.getString("smallAppKey"));
        }
        if (bundle != null && bundle.getBoolean("enableIndoor")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f124563h.size() + this.f124564i.size() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (getLocationManager().getIndoorStatus() != 2001 && getLocationManager().getIndoorStatus() != 2002) {
            z18 = false;
            if (!z17 || (z16 && !z18)) {
                TencentLocationRequest create = TencentLocationRequest.create();
                create.setIndoorLocationMode(z16);
                if (!z16) {
                    j3 = 1000;
                } else {
                    j3 = 2000;
                }
                create.setInterval(j3);
                create.setSmallAppKey(c());
                create.setAndroidId(com.tencent.luggage.wxa.t9.l.b());
                create.setOpenId(bundle.getString("openId"));
                w.d("MicroMsg.DefaultTencentLocationManager", "requestCode %d", Integer.valueOf(getLocationManager().requestLocationUpdates(create, this.f124565j, Looper.getMainLooper())));
            }
            return true;
        }
        z18 = true;
        if (!z17) {
        }
        TencentLocationRequest create2 = TencentLocationRequest.create();
        create2.setIndoorLocationMode(z16);
        if (!z16) {
        }
        create2.setInterval(j3);
        create2.setSmallAppKey(c());
        create2.setAndroidId(com.tencent.luggage.wxa.t9.l.b());
        create2.setOpenId(bundle.getString("openId"));
        w.d("MicroMsg.DefaultTencentLocationManager", "requestCode %d", Integer.valueOf(getLocationManager().requestLocationUpdates(create2, this.f124565j, Looper.getMainLooper())));
        return true;
    }

    @Override // com.tencent.luggage.wxa.xk.a
    public synchronized boolean unregisterLocation(String str, a.b bVar, Bundle bundle) {
        w.d("MicroMsg.DefaultTencentLocationManager", "[unregisterLocation]type:%s", str);
        if (MapJsPlugin.LOCATION_TYPE_84.equals(str)) {
            this.f124563h.remove(bVar);
        } else {
            this.f124564i.remove(bVar);
        }
        if (bundle != null) {
            g(bundle.getString("smallAppKey"));
        }
        e();
        return false;
    }

    public final String c() {
        StringBuilder sb5 = new StringBuilder();
        Iterator it = this.f124566k.iterator();
        while (it.hasNext()) {
            sb5.append((String) it.next());
        }
        w.a("MicroMsg.DefaultTencentLocationManager", "MapReport reportMsg:%s", sb5.toString());
        return sb5.toString();
    }

    public final String d(String str) {
        return "gps".equals(str) ? "gps" : "network";
    }

    public final void e() {
        if (this.f124562g.size() > 0 || this.f124561f.size() > 0 || this.f124563h.size() > 0 || this.f124564i.size() > 0) {
            return;
        }
        w.d("MicroMsg.DefaultTencentLocationManager", "releaseLocationManager");
        getLocationManager().removeUpdates(null);
    }

    public final void a(List list, int i3, String str, a.C6919a c6919a) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a.b bVar = (a.b) it.next();
            if (bVar != null) {
                bVar.a(i3, str, c6919a);
            }
        }
    }

    public void a(String str) {
        if (w0.c(str)) {
            return;
        }
        this.f124566k.add(str);
    }

    public final a.C6919a a(TencentLocation tencentLocation, boolean z16) {
        a.C6919a c6919a = new a.C6919a();
        if (z16) {
            c6919a.f145141a = tencentLocation.getLatitude();
            c6919a.f145142b = tencentLocation.getLongitude();
            c6919a.f145153m = MapJsPlugin.LOCATION_TYPE_84;
        } else {
            double[] dArr = new double[2];
            TencentLocationUtils.wgs84ToGcj02(new double[]{tencentLocation.getLatitude(), tencentLocation.getLongitude()}, dArr);
            c6919a.f145141a = dArr[0];
            c6919a.f145142b = dArr[1];
            c6919a.f145153m = MapJsPlugin.LOCATION_TYPE_02;
        }
        c6919a.f145143c = d(tencentLocation.getProvider());
        c6919a.f145144d = tencentLocation.getSpeed();
        c6919a.f145145e = tencentLocation.getAccuracy();
        c6919a.f145146f = tencentLocation.getAltitude();
        c6919a.f145150j = tencentLocation.getIndoorLocationType();
        c6919a.f145151k = tencentLocation.getBearing();
        if (tencentLocation.getExtra() != null) {
            c6919a.f145152l = tencentLocation.getExtra().getDouble("steps");
        }
        w.g("MicroMsg.DefaultTencentLocationManager", "buildingId:%s floorName:%s steps:%f", tencentLocation.getIndoorBuildingId(), tencentLocation.getIndoorBuildingFloor(), Double.valueOf(c6919a.f145152l));
        if (!w0.c(tencentLocation.getIndoorBuildingId())) {
            c6919a.f145147g = tencentLocation.getIndoorBuildingId();
            c6919a.f145148h = tencentLocation.getIndoorBuildingFloor();
        } else {
            c6919a.f145147g = "";
            c6919a.f145148h = "";
        }
        return c6919a;
    }
}
