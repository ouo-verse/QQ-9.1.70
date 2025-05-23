package com.tencent.map.geolocation.sapp.internal;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import c.t.m.sapp.c.e;
import c.t.m.sapp.c.f;
import c.t.m.sapp.c.i;
import c.t.m.sapp.c.q;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationManagerOptions;
import com.tencent.map.geolocation.sapp.TencentLocationRequest;
import dalvik.system.DexClassLoader;
import java.io.File;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TencentExtraKeys {
    public static final boolean ALLOW_NLP_LOCATION = true;
    public static final boolean DIDI_INTERNAL = false;
    public static final String LOCATION_KEY_ADMIN_LEVEL1 = "admin_level_1";
    public static final String LOCATION_KEY_ADMIN_LEVEL2 = "admin_level_2";
    public static final String LOCATION_KEY_ADMIN_LEVEL3 = "admin_level_3";
    public static final String LOCATION_KEY_LOCALITY = "locality";
    public static final String LOCATION_KEY_NATION = "nation";
    public static final String LOCATION_KEY_ROUTE = "route";
    public static final String LOCATION_KEY_SUBLOCALITY = "sublocality";
    public static final String LOCATION_SOURCE_CELL = "cell";
    public static final String LOCATION_SOURCE_GPS = "gps";
    public static final String LOCATION_SOURCE_WIFI = "wifi";
    public static final String RAW_DATA = "raw_data";
    public static final String REQUEST_RAW_DATA = "request_raw_data";
    public static final boolean STRICT_CELL_FILTER = true;
    private static final String TAG = "TencentExtraKeys";
    public static final boolean TENCENT_INTERNAL = true;
    private static Context mContext;
    private static DexClassLoader mLoader;
    private static Object mProxyObj;
    private static Class mProxyclass;

    private static boolean a(Context context, int i3) {
        if (i3 > 0) {
            try {
                q.a(q.c(context));
                q.a(q.h(context));
                q.a();
                f.a(context).c();
            } catch (Throwable th5) {
                th5.printStackTrace();
                e.b().a("EKS", "init error 3," + i3 + "," + th5.toString());
                return false;
            }
        }
        DexClassLoader a16 = f.a(context).a();
        if (a16 == null) {
            i.a("EKS,loader is null");
            e.b().a("EKS", "init error 2," + i3);
            return false;
        }
        if (mProxyclass == null || mProxyObj == null) {
            Class<?> loadClass = a16.loadClass("com.tencent.map.geolocation.sapp.proxy.TencentExtraKeysProxy");
            mProxyclass = loadClass;
            mProxyObj = loadClass.newInstance();
        }
        e.b().a("EKS", "init ok 0," + i3);
        return true;
    }

    public static void enableMockLocationFilter(boolean z16) throws Exception {
        try {
            if (initProxy()) {
                mProxyclass.getDeclaredMethod("enableMockLocationFilter", Boolean.TYPE).invoke(mProxyObj, Boolean.valueOf(z16));
                return;
            }
            throw new Exception("proxy is error");
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    public static String getLocationSource(TencentLocation tencentLocation) throws Exception {
        try {
            if (initProxy()) {
                return (String) mProxyclass.getDeclaredMethod("getLocationSource", TencentLocation.class).invoke(mProxyObj, tencentLocation);
            }
            throw new Exception("proxy is error");
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    public static synchronized File getLogDir() throws Exception {
        File file;
        synchronized (TencentExtraKeys.class) {
            try {
                if (initProxy()) {
                    file = (File) mProxyclass.getDeclaredMethod("getLogDir", new Class[0]).invoke(mProxyObj, new Object[0]);
                } else {
                    throw new Exception("proxy is error");
                }
            } finally {
            }
        }
        return file;
    }

    public static byte[] getRawData(TencentLocation tencentLocation) throws Exception {
        try {
            if (initProxy()) {
                return (byte[]) mProxyclass.getDeclaredMethod("getRawData", TencentLocation.class).invoke(mProxyObj, tencentLocation);
            }
            throw new Exception("proxy is error");
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    public static Location getRawGps(TencentLocation tencentLocation) throws Exception {
        try {
            if (initProxy()) {
                return (Location) mProxyclass.getDeclaredMethod("getRawGps", TencentLocation.class).invoke(mProxyObj, tencentLocation);
            }
            throw new Exception("proxy is error");
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    public static String getRawQuery(TencentLocation tencentLocation) throws Exception {
        try {
            if (initProxy()) {
                return (String) mProxyclass.getDeclaredMethod("getRawQuery", TencentLocation.class).invoke(mProxyObj, tencentLocation);
            }
            throw new Exception("proxy is error");
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    private static boolean initProxy() {
        if (mContext == null) {
            return false;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            if (a(mContext, i3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAllowedLevel(int i3) throws Exception {
        try {
            if (initProxy()) {
                return ((Boolean) mProxyclass.getDeclaredMethod("isAllowedLevel", Integer.TYPE).invoke(mProxyObj, Integer.valueOf(i3))).booleanValue();
            }
            throw new Exception("proxy is error");
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    @Deprecated
    public static synchronized boolean isDebugEnabled() throws Exception {
        boolean booleanValue;
        synchronized (TencentExtraKeys.class) {
            try {
                if (initProxy()) {
                    booleanValue = ((Boolean) mProxyclass.getDeclaredMethod("isDebugEnabled", new Class[0]).invoke(mProxyObj, new Object[0])).booleanValue();
                } else {
                    throw new Exception("proxy is error");
                }
            } finally {
            }
        }
        return booleanValue;
    }

    public static int isInsIllegalApp(Context context) throws Exception {
        try {
            mContext = context;
            if (initProxy()) {
                return ((Integer) mProxyclass.getDeclaredMethod("isInsIllegalApp", Context.class).invoke(mProxyObj, context)).intValue();
            }
            throw new Exception("proxy is error");
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    public static boolean isRequestRawData(TencentLocationRequest tencentLocationRequest) throws Exception {
        try {
            if (initProxy()) {
                return ((Boolean) mProxyclass.getDeclaredMethod("isRequestRawData", TencentLocationRequest.class).invoke(mProxyObj, tencentLocationRequest)).booleanValue();
            }
            throw new Exception("proxy is error");
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    public static void loadLibrary(String str) throws Exception {
        try {
            System.load(str);
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    public static void setContext(Context context) {
        mContext = context;
        e.a(context).c();
    }

    public static synchronized void setLogDir(File file) throws Exception {
        synchronized (TencentExtraKeys.class) {
            try {
                if (initProxy()) {
                    mProxyclass.getDeclaredMethod("setLogDir", File.class).invoke(mProxyObj, file);
                } else {
                    throw new Exception("proxy is error");
                }
            } finally {
            }
        }
    }

    public static TencentLocation setRawData(TencentLocation tencentLocation, byte[] bArr) throws Exception {
        try {
            if (initProxy()) {
                return (TencentLocation) mProxyclass.getDeclaredMethod("setRawData", TencentLocation.class, byte[].class).invoke(mProxyObj, tencentLocation, bArr);
            }
            throw new Exception("proxy is error");
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    public static void setRawGps(TencentLocation tencentLocation, Location location) throws Exception {
        try {
            if (initProxy()) {
                mProxyclass.getDeclaredMethod("setRawGps", TencentLocation.class, Location.class).invoke(mProxyObj, tencentLocation, location);
                return;
            }
            throw new Exception("proxy is error");
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    public static void setRawQuery(TencentLocation tencentLocation, String str) throws Exception {
        try {
            if (initProxy()) {
                mProxyclass.getDeclaredMethod("setRawQuery", TencentLocation.class, String.class).invoke(mProxyObj, tencentLocation, str);
                return;
            }
            throw new Exception("proxy is error");
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    public static TencentLocationRequest setRequestRawData(TencentLocationRequest tencentLocationRequest, boolean z16) throws Exception {
        try {
            if (initProxy()) {
                return (TencentLocationRequest) mProxyclass.getDeclaredMethod("setRequestRawData", TencentLocationRequest.class, Boolean.TYPE).invoke(mProxyObj, tencentLocationRequest, Boolean.valueOf(z16));
            }
            throw new Exception("proxy is error");
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    public static void setTencentLog(Context context, File file) throws Exception {
        try {
            mContext = context;
            if (initProxy()) {
                mProxyclass.getDeclaredMethod("setTencentLog", Context.class, File.class).invoke(mProxyObj, context, file);
                return;
            }
            throw new Exception("proxy is error");
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    public static void setTencentLogCallback(LocationLogCallback locationLogCallback) throws Exception {
        try {
            i.a(locationLogCallback);
            if (initProxy()) {
                mProxyclass.getDeclaredMethod("setTencentLogCallback", LocationLogCallback.class).invoke(mProxyObj, locationLogCallback);
                return;
            }
            throw new Exception("proxy is error");
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new Exception(th5.toString());
        }
    }

    public static boolean wgs84ToGcj02(double[] dArr, double[] dArr2) throws Exception {
        try {
            if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
                try {
                    System.loadLibrary("tencentlocsapp");
                } catch (Throwable th5) {
                    Log.e("TencentLocationSDK", "LOAD:" + th5.toString());
                    return false;
                }
            }
            if (initProxy()) {
                return ((Boolean) mProxyclass.getDeclaredMethod("wgs84ToGcj02", double[].class, double[].class).invoke(mProxyObj, dArr, dArr2)).booleanValue();
            }
            throw new Exception("proxy is error");
        } catch (Throwable th6) {
            th6.printStackTrace();
            throw new Exception(th6.toString());
        }
    }
}
