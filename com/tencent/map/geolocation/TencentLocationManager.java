package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import c.t.m.g.g2;
import c.t.m.g.k3;
import c.t.m.g.l1;
import c.t.m.g.n1;
import c.t.m.g.o0;
import c.t.m.g.o1;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class TencentLocationManager {
    public static final int APP_ENTER_BACKGROUND = 2;
    public static final int APP_ENTER_FOREGROUND = 1;
    public static final int COORDINATE_TYPE_GCJ02 = 1;
    public static final int COORDINATE_TYPE_WGS84 = 0;
    public static final String TYPE_OAID = "oaId";
    public static final String TYPE_QIMEI = "qImei";

    /* renamed from: d, reason: collision with root package name */
    public static TencentLocationManager f147566d;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f147567a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    public final n1 f147568b;

    /* renamed from: c, reason: collision with root package name */
    public final g2 f147569c;

    public TencentLocationManager(Context context) {
        o0.a(context);
        o0.a(true);
        l1.a(true);
        n1 b16 = n1.b(context);
        this.f147568b = b16;
        this.f147569c = new g2(b16);
    }

    public static boolean b(String str) {
        return str.matches("^[a-z0-9A-Z]{6,32}$");
    }

    public static synchronized TencentLocationManager getInstance(Context context) throws NullPointerException, IllegalArgumentException {
        TencentLocationManager tencentLocationManager;
        synchronized (TencentLocationManager.class) {
            if (f147566d == null) {
                if (context != null) {
                    if (context.getApplicationContext() != null) {
                        if (Looper.myLooper() != null) {
                            f147566d = new TencentLocationManager(context.getApplicationContext());
                        } else {
                            throw new IllegalArgumentException("getInstance must be use in Thread with looper. Please first use Looper.prapare()");
                        }
                    } else {
                        throw new NullPointerException("application context is null");
                    }
                } else {
                    throw new NullPointerException("context is null");
                }
            }
            tencentLocationManager = f147566d;
        }
        return tencentLocationManager;
    }

    public static void setTencentLocationLogListener(TencentLocationLogListener tencentLocationLogListener) {
        k3.a(tencentLocationLogListener);
    }

    public final void a(String str) {
        if (str != null && !str.equals("")) {
            return;
        }
        throw new IllegalArgumentException("bad key: " + str);
    }

    public void appStatusChanged(int i3) {
        if (i3 != 2 && i3 != 1) {
            throw new IllegalArgumentException("status of foreground or background is illegal!");
        }
        synchronized (this.f147567a) {
            this.f147568b.a().a(i3);
        }
    }

    public int clearPedometerData() {
        return this.f147569c.d();
    }

    public String getBuild() {
        o1 a16 = this.f147568b.a(-1L);
        if (a16 != null) {
            return a16.d();
        }
        return "None";
    }

    public int getCoordinateType() {
        return this.f147569c.j();
    }

    public String getKey() {
        return this.f147568b.a().h();
    }

    public TencentLocation getLastKnownLocation() {
        return this.f147569c.l();
    }

    public int getPedometerData() {
        return this.f147569c.m();
    }

    public TencentPedestrianData getPedometerDataFromLastCheck() {
        return this.f147569c.n();
    }

    public String getVersion() {
        o1 a16 = this.f147568b.a(-1L);
        if (a16 != null) {
            return a16.p();
        }
        return "None";
    }

    public boolean isSupportPedometer() {
        return this.f147569c.q();
    }

    public void removeUpdates(TencentLocationListener tencentLocationListener) {
        Log.i("TencentLocationSDK", "remove location update,thread name:" + Thread.currentThread().getName());
        synchronized (this.f147567a) {
            this.f147569c.a(tencentLocationListener);
        }
    }

    public int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener) {
        Log.i("TencentLocationSDK", "request location with no looper,thread name:" + Thread.currentThread().getName());
        return requestLocationUpdates(tencentLocationRequest, tencentLocationListener, Looper.myLooper());
    }

    public void setCoordinateType(int i3) {
        if (i3 != 1 && i3 != 0) {
            throw new IllegalArgumentException("unknown coordinate type: " + i3);
        }
        synchronized (this.f147567a) {
            this.f147569c.b(i3);
        }
    }

    public void setDeviceID(Pair<String, String> pair) {
        if (pair != null) {
            if ((((String) pair.first).equals("qImei") || ((String) pair.first).equals("oaId") || b((String) pair.first)) && !TextUtils.isEmpty((CharSequence) pair.second)) {
                this.f147568b.a(pair);
                return;
            }
            throw new IllegalArgumentException("your deviceID is illegal!");
        }
        throw new IllegalArgumentException("deviceID is null!");
    }

    public void setKey(String str) {
        a(str);
        this.f147568b.a().c(str);
    }

    public int startDirectionUpdates(TencentDirectionListener tencentDirectionListener, Looper looper) {
        if (tencentDirectionListener != null) {
            if (looper != null) {
                return this.f147569c.a(tencentDirectionListener, looper);
            }
            throw new NullPointerException("looper is null");
        }
        throw new NullPointerException("listener is null");
    }

    public int startDistanceCalculate(TencentDistanceListener tencentDistanceListener) {
        int a16;
        if (tencentDistanceListener != null) {
            synchronized (this.f147567a) {
                a16 = this.f147569c.a(tencentDistanceListener);
            }
            return a16;
        }
        throw new NullPointerException("listener is null");
    }

    public void stopDirectionUpdate() {
        this.f147569c.r();
    }

    public TencentDistanceAnalysis stopDistanceCalculate(TencentDistanceListener tencentDistanceListener) {
        TencentDistanceAnalysis b16;
        synchronized (this.f147567a) {
            b16 = this.f147569c.b(tencentDistanceListener);
        }
        return b16;
    }

    public int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        int a16;
        Log.i("TencentLocationSDK", "request location with looper,thread name:" + Thread.currentThread().getName());
        if (tencentLocationRequest == null) {
            throw new NullPointerException("request is null");
        }
        if (tencentLocationListener == null) {
            throw new NullPointerException("listener is null");
        }
        if (looper != null) {
            synchronized (this.f147567a) {
                a16 = this.f147569c.a(tencentLocationRequest, tencentLocationListener, looper);
            }
            return a16;
        }
        throw new NullPointerException("looper is null");
    }
}
