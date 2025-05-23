package com.tencent.map.geolocation.sapp;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import c.t.m.sapp.c.e;
import c.t.m.sapp.c.f;
import c.t.m.sapp.c.i;
import c.t.m.sapp.c.q;
import com.tencent.map.geolocation.sapp.databus.DataBusNativeInterface;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class TencentLocationManager {
    public static final int COORDINATE_TYPE_GCJ02 = 1;
    public static final int COORDINATE_TYPE_WGS84 = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "TencentLocationManager";
    public static final String TYPE_OAID = "oaId";
    public static final String TYPE_QIMEI = "qImei";
    private static Context mContext;
    private static Pair<String, String> mPair;
    private static Class mProxyClass;
    private static Object mProxyObj;
    private static TencentLocationManager sInstance;
    private int mInitStatus;
    private final byte[] mLock = new byte[0];

    TencentLocationManager(Context context, Pair<String, String> pair) {
        boolean a16;
        Pair<String, String> pair2;
        this.mInitStatus = 0;
        if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
            try {
                System.loadLibrary("tencentlocsapp");
            } catch (Throwable th5) {
                i.a("libtencentloc", th5);
                this.mInitStatus = 3;
                return;
            }
        }
        mContext = context;
        q.a(context, pair);
        e.a(context).c();
        for (int i3 = 0; i3 < 3; i3++) {
            if (pair == null && (pair2 = mPair) != null) {
                a16 = a(context, pair2, i3);
            } else {
                a16 = a(context, pair, i3);
            }
            if (a16) {
                DataBusNativeInterface.init(context);
                return;
            }
        }
    }

    private boolean a(Context context, Pair<String, String> pair, int i3) {
        if (i3 > 0) {
            q.a(q.c(context));
            q.a(q.h(context));
            q.a();
            f.a(context).c();
        }
        try {
            DexClassLoader a16 = f.a(context).a();
            if (a16 == null) {
                i.a("class loader is null," + i3);
                e.b().a("LMI", "41");
                this.mInitStatus = 4;
                return false;
            }
            Class<?> loadClass = a16.loadClass("com.tencent.map.geolocation.sapp.proxy.TencentLocationManagerProxy");
            mProxyClass = loadClass;
            if (pair != null) {
                mProxyObj = loadClass.getConstructor(Context.class, Pair.class).newInstance(context, pair);
            } else {
                mProxyObj = loadClass.getConstructor(Context.class).newInstance(context);
            }
            if (mProxyObj == null) {
                this.mInitStatus = 4;
                i.a("Mgr init failed," + i3);
                e.b().a("LMI", "42," + i3);
                return false;
            }
            e.b().a("LMI", "0," + i3);
            return true;
        } catch (Throwable th5) {
            this.mInitStatus = 5;
            i.a("initLocManager", th5);
            e.b().a("LMI", "5" + th5.toString());
            return false;
        }
    }

    public static synchronized TencentLocationManager getInstance(Context context) throws NullPointerException, IllegalArgumentException {
        TencentLocationManager tencentLocationManager;
        synchronized (TencentLocationManager.class) {
            if (sInstance == null) {
                if (context != null) {
                    if (context.getApplicationContext() != null) {
                        System.currentTimeMillis();
                        sInstance = new TencentLocationManager(context.getApplicationContext(), null);
                    } else {
                        throw new NullPointerException("application context is null");
                    }
                } else {
                    throw new NullPointerException("context is null");
                }
            }
            tencentLocationManager = sInstance;
        }
        return tencentLocationManager;
    }

    private static boolean isOtherIdIllegal(String str) {
        return str.matches("^[a-z0-9A-Z]{6,32}$");
    }

    public static void setDeviceID(Pair<String, String> pair) {
        if (pair != null) {
            if (!((String) pair.first).equals("qImei") && !((String) pair.first).equals("oaId") && !isOtherIdIllegal((String) pair.first)) {
                throw new IllegalArgumentException("your deviceID is illegal!");
            }
            try {
                Object obj = pair.first;
                if (obj != null && pair.second != null) {
                    if (!((String) obj).equals("qImei") && !((String) pair.first).equals("oaId")) {
                        return;
                    }
                    if (mContext != null) {
                        Class cls = mProxyClass;
                        if (cls != null) {
                            Method declaredMethod = cls.getDeclaredMethod("uploadLimeiInfo", Context.class, Pair.class);
                            declaredMethod.setAccessible(true);
                            Object obj2 = mProxyObj;
                            if (obj2 != null) {
                                declaredMethod.invoke(obj2, mContext, pair);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    mPair = pair;
                    return;
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        throw new IllegalArgumentException("deviceID is null!");
    }

    public String getBuild() {
        try {
            return (String) mProxyClass.getDeclaredMethod("getBuild", new Class[0]).invoke(mProxyObj, new Object[0]);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "error";
        }
    }

    public int getCoordinateType() {
        try {
            return ((Integer) mProxyClass.getDeclaredMethod("getCoordinateType", new Class[0]).invoke(mProxyObj, new Object[0])).intValue();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return -1;
        }
    }

    public int getIndoorStatus() {
        try {
            return ((Integer) mProxyClass.getDeclaredMethod("getIndoorStatus", new Class[0]).invoke(mProxyObj, new Object[0])).intValue();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return -2;
        }
    }

    public TencentLocation getLastKnownLocation() {
        try {
            return (TencentLocation) mProxyClass.getDeclaredMethod("getLastKnownLocation", new Class[0]).invoke(mProxyObj, new Object[0]);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public String getVersion() {
        try {
            return (String) mProxyClass.getDeclaredMethod("getVersion", new Class[0]).invoke(mProxyObj, new Object[0]);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "error";
        }
    }

    public void removeUpdates(TencentLocationListener tencentLocationListener) {
        synchronized (this.mLock) {
            try {
                mProxyClass.getDeclaredMethod("removeUpdates", TencentLocationListener.class).invoke(mProxyObj, tencentLocationListener);
                e.b().d();
            } finally {
            }
        }
    }

    public int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener) {
        int i3 = this.mInitStatus;
        if (i3 > 0) {
            return i3;
        }
        try {
            return ((Integer) mProxyClass.getDeclaredMethod("requestLocationUpdates", TencentLocationRequest.class, TencentLocationListener.class).invoke(mProxyObj, tencentLocationRequest, tencentLocationListener)).intValue();
        } catch (Throwable th5) {
            i.a("reqLocUpdates error. ", th5);
            return 5;
        }
    }

    public int requestSingleFreshLocation(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper, boolean z16) {
        int intValue;
        if (tencentLocationListener == null) {
            throw new NullPointerException("listener is null");
        }
        if (looper != null) {
            int i3 = this.mInitStatus;
            if (i3 > 0) {
                return i3;
            }
            synchronized (this.mLock) {
                try {
                    intValue = ((Integer) mProxyClass.getDeclaredMethod("requestSingleFreshLocation", TencentLocationRequest.class, TencentLocationListener.class, Looper.class, Boolean.TYPE).invoke(mProxyObj, tencentLocationRequest, tencentLocationListener, looper, Boolean.valueOf(z16))).intValue();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    i.a("reqSigLoc error. ", th5);
                    return 5;
                }
            }
            return intValue;
        }
        throw new NullPointerException("looper is null");
    }

    public void setCoordinateType(int i3) {
        try {
            if (i3 != 1 && i3 != 0) {
                throw new IllegalArgumentException("unknown coordinate type: " + i3);
            }
            synchronized (this.mLock) {
                try {
                    mProxyClass.getDeclaredMethod("setCoordinateType", Integer.TYPE).invoke(mProxyObj, Integer.valueOf(i3));
                } catch (Throwable unused) {
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public boolean startIndoorLocation() {
        try {
            return ((Boolean) mProxyClass.getDeclaredMethod("startIndoorLocation", new Class[0]).invoke(mProxyObj, new Object[0])).booleanValue();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public boolean stopIndoorLocation() {
        try {
            return ((Boolean) mProxyClass.getDeclaredMethod("stopIndoorLocation", new Class[0]).invoke(mProxyObj, new Object[0])).booleanValue();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        int intValue;
        System.currentTimeMillis();
        if (tencentLocationRequest == null) {
            throw new NullPointerException("request is null");
        }
        if (tencentLocationListener == null) {
            throw new NullPointerException("listener is null");
        }
        if (looper != null) {
            int i3 = this.mInitStatus;
            if (i3 > 0) {
                return i3;
            }
            synchronized (this.mLock) {
                try {
                    Integer num = (Integer) mProxyClass.getDeclaredMethod("requestLocationUpdates", TencentLocationRequest.class, TencentLocationListener.class, Looper.class).invoke(mProxyObj, tencentLocationRequest, tencentLocationListener, looper);
                    e.b().a("RLU", num.toString());
                    intValue = num.intValue();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    e.b().a("RLU", "5," + th5.toString());
                    i.a("reqLocUpdates looper error. ", th5);
                    return 5;
                }
            }
            return intValue;
        }
        throw new NullPointerException("looper is null");
    }

    public static synchronized TencentLocationManager getInstance(Context context, Pair<String, String> pair) throws NullPointerException, IllegalArgumentException {
        TencentLocationManager tencentLocationManager;
        synchronized (TencentLocationManager.class) {
            if (sInstance == null) {
                if (context != null) {
                    if (context.getApplicationContext() != null) {
                        System.currentTimeMillis();
                        sInstance = new TencentLocationManager(context.getApplicationContext(), pair);
                    } else {
                        throw new NullPointerException("application context is null");
                    }
                } else {
                    throw new NullPointerException("context is null");
                }
            }
            tencentLocationManager = sInstance;
        }
        return tencentLocationManager;
    }

    public int requestSingleFreshLocation(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        return requestSingleFreshLocation(tencentLocationRequest, tencentLocationListener, looper, false);
    }
}
