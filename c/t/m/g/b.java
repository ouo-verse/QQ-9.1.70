package c.t.m.g;

import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.Pair;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public Context f29488b;

    /* renamed from: c, reason: collision with root package name */
    public e f29489c;

    /* renamed from: d, reason: collision with root package name */
    public HandlerThread f29490d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Location f29491e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Location f29492f;

    /* renamed from: g, reason: collision with root package name */
    public volatile List<d> f29493g;

    /* renamed from: h, reason: collision with root package name */
    public volatile d f29494h;

    /* renamed from: i, reason: collision with root package name */
    public volatile List<ScanResult> f29495i;

    /* renamed from: j, reason: collision with root package name */
    public LruCache<String, Pair<Double, Double>> f29496j;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f29487a = new byte[0];

    /* renamed from: k, reason: collision with root package name */
    public long f29497k = 180000;

    /* renamed from: l, reason: collision with root package name */
    public long f29498l = 0;

    /* renamed from: m, reason: collision with root package name */
    public long f29499m = 0;

    /* renamed from: n, reason: collision with root package name */
    public long f29500n = 0;

    public b(Context context) {
        Context applicationContext;
        StringBuilder sb5;
        if (context == null) {
            applicationContext = null;
        } else {
            applicationContext = context.getApplicationContext();
        }
        this.f29488b = applicationContext;
        if (applicationContext != null) {
            o0.a(context);
            this.f29496j = new LruCache<>(100);
            String str = "";
            try {
                try {
                    if (!j.f29769a && !j.f29770b) {
                        str = this.f29488b.getExternalFilesDir("data").getAbsolutePath();
                    }
                } catch (Throwable unused) {
                    if (TextUtils.isEmpty("")) {
                        sb5 = new StringBuilder();
                        sb5.append(this.f29488b.getFilesDir().getAbsolutePath());
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    sb5 = new StringBuilder();
                    sb5.append(this.f29488b.getFilesDir().getAbsolutePath());
                    sb5.append("/data/");
                    str = sb5.toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    this.f29489c = new e(this.f29488b, str);
                    d();
                    return;
                }
                return;
            } catch (Throwable unused2) {
                this.f29489c = null;
                return;
            }
        }
        throw new IllegalArgumentException("context cannot be null!");
    }

    public static String a() {
        return "1.7.7_230716";
    }

    public boolean b() {
        e eVar = this.f29489c;
        if (eVar == null) {
            return false;
        }
        return eVar.b();
    }

    public final void c() {
        this.f29491e = null;
        this.f29492f = null;
        this.f29493g = null;
        this.f29494h = null;
        this.f29495i = null;
        this.f29498l = 0L;
        this.f29499m = 0L;
        this.f29500n = 0L;
        this.f29496j.evictAll();
    }

    public final void d() {
        for (Map.Entry<String, String> entry : j.a().entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public void e() {
        synchronized (this.f29487a) {
            e eVar = this.f29489c;
            if (eVar != null && eVar.b()) {
                this.f29489c.c();
            }
            if (this.f29490d != null) {
                w0.a("th_loc_extra", 300L);
                this.f29490d = null;
            }
            c();
            c1.a("TxCoreDC", "shutdown");
        }
    }

    public final void f() {
        if (h1.a(this.f29489c, this.f29491e) && !h1.a((Collection) this.f29493g)) {
            if (j.f29774f && n.a(this.f29488b) == 3) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f29498l < this.f29497k) {
                this.f29500n = currentTimeMillis;
                this.f29492f = a(this.f29492f, this.f29491e);
                this.f29489c.a(this.f29491e, (List<ScanResult>) null, this.f29493g);
            }
        }
    }

    public void a(Looper looper) {
        synchronized (this.f29487a) {
            c1.a("TxCoreDC", "startup");
            c();
            if (this.f29489c != null) {
                if (looper == null) {
                    HandlerThread b16 = w0.b("th_loc_extra");
                    this.f29490d = b16;
                    looper = b16.getLooper();
                }
                this.f29489c.a(looper);
            }
        }
    }

    public void a(c cVar) {
        synchronized (this.f29487a) {
            j.f29777i = cVar;
            if (c1.a()) {
                c1.a("TxCoreDC", "appInfo:" + cVar.f() + "," + cVar.b() + "_" + cVar.c() + "," + cVar.d() + "," + cVar.e());
            }
        }
    }

    @Deprecated
    public void a(Location location) {
        a(0, location);
    }

    public void a(int i3, Location location) {
        synchronized (this.f29487a) {
            if (b()) {
                if (location != null && "gps".equals(location.getProvider())) {
                    if (j.f29776h || !location.isFromMockProvider()) {
                        c1.a("TxCoreDC", "setGpsLocation");
                        e eVar = this.f29489c;
                        if (eVar != null) {
                            eVar.a(i3, location);
                        }
                        if (!f1.a(location.getAltitude(), 0.0d) || !f1.a(location.getSpeed(), 0.0d)) {
                            this.f29491e = a(this.f29491e, location);
                            if (this.f29492f == null || (this.f29491e != null && this.f29491e.distanceTo(this.f29492f) >= 50.0f && System.currentTimeMillis() - this.f29500n >= 5000)) {
                                f();
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(List<ScanResult> list) {
        long currentTimeMillis;
        boolean a16;
        synchronized (this.f29487a) {
            if (b()) {
                try {
                    currentTimeMillis = System.currentTimeMillis();
                    a16 = n.a(this.f29495i, list);
                    if (c1.a()) {
                        c1.a("TxCoreDC", "setWifiResults, same pre:" + a16);
                    }
                } catch (Throwable th5) {
                    c1.a("TxCoreDC", "setWifiResults error.", th5);
                }
                if (!a16 || currentTimeMillis - this.f29499m <= 30000) {
                    e eVar = this.f29489c;
                    if (eVar != null) {
                        eVar.a(list);
                    }
                    if (this.f29489c != null && this.f29491e != null && !h1.a((Collection) list)) {
                        if (list.size() == 1) {
                            if ("123456789abc".equals(list.get(0).BSSID.toLowerCase())) {
                                return;
                            }
                        } else if (list.size() > 1 && n.a(list)) {
                            return;
                        }
                        if (j.f29774f && currentTimeMillis - this.f29499m < 5000) {
                            return;
                        }
                        if (!a16) {
                            this.f29499m = currentTimeMillis;
                            this.f29495i = list;
                        }
                        this.f29489c.a(this.f29491e, list, currentTimeMillis - this.f29498l < this.f29497k ? this.f29493g : null);
                    }
                }
            }
        }
    }

    public void a(d dVar, List<d> list) {
        synchronized (this.f29487a) {
            if (b()) {
                ArrayList arrayList = new ArrayList();
                for (d dVar2 : list) {
                    if (i.a(dVar2.f29527f, dVar2.f29522a, dVar2.f29523b, dVar2.f29524c, dVar2.f29526e)) {
                        if (a(dVar2.f29524c + "_" + dVar2.f29526e, this.f29491e)) {
                            arrayList.add(dVar2);
                        }
                    }
                }
                this.f29493g = arrayList;
                this.f29498l = System.currentTimeMillis();
                if (dVar != null && !dVar.equals(this.f29494h)) {
                    this.f29494h = dVar;
                    f();
                }
            }
        }
    }

    public void a(String str, String str2) {
        synchronized (this.f29487a) {
            if (this.f29489c == null || h1.a(str2)) {
                return;
            }
            try {
                if (c1.a()) {
                    c1.a("TxCoreDC", "setSetting(" + str + "," + str2 + ")");
                }
                if ("D_CH_ID".equals(str)) {
                    k.a(str2);
                } else if ("D_FC_SRC".equals(str)) {
                    k.b(str2);
                } else if ("D_POS_COLL".equals(str)) {
                    j.f29771c = Boolean.parseBoolean(str2.toLowerCase());
                } else if ("D_WRITE_MAC".equals(str)) {
                    j.f29772d = Boolean.parseBoolean(str2.toLowerCase());
                } else if ("D_UP_NET".equals(str)) {
                    if (QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO.equals(str2.toLowerCase())) {
                        j.f29774f = true;
                    } else if ("w".equals(str2.toLowerCase())) {
                        j.f29774f = false;
                        j.f29775g = false;
                    } else if ("w_m1".equals(str2.toLowerCase())) {
                        j.f29774f = false;
                        j.f29775g = true;
                    }
                } else if ("D_EXTRA_SET_SN".equals(str)) {
                    m.f29851a = h1.a(str2) ? "" : str2;
                } else {
                    this.f29489c.a(str, str2);
                }
            } catch (Throwable th5) {
                if (c1.a()) {
                    c1.a("TxCoreDC", "set setting data[" + str + "," + str2 + "] error.", th5);
                }
            }
        }
    }

    public final Location a(Location location, Location location2) {
        if (location == null) {
            location = new Location("gps");
        }
        if (location2 != null) {
            location.set(location2);
        }
        return location;
    }

    public final boolean a(String str, Location location) {
        if (h1.a(str) || location == null || location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) {
            return false;
        }
        Pair<Double, Double> pair = this.f29496j.get(str);
        if (pair != null) {
            return b1.a(location.getLatitude(), location.getLongitude(), ((Double) pair.first).doubleValue(), ((Double) pair.second).doubleValue()) < 6000.0d;
        }
        this.f29496j.put(str, Pair.create(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
        return true;
    }
}
