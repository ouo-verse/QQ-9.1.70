package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f37474a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static int f37475b = -1;

    public static boolean a(Context context) {
        HMSLog.d("CommFun", "existFrameworkPush:" + f37475b);
        try {
            File file = new File("/system/framework/hwpush.jar");
            if (a()) {
                HMSLog.d("CommFun", "push jarFile is exist");
                return true;
            }
            if (!file.isFile()) {
                return false;
            }
            HMSLog.d("CommFun", "push jarFile is exist");
            return true;
        } catch (Exception e16) {
            HMSLog.e("CommFun", "get Apk version faild ,Exception e= " + e16.toString());
            return false;
        }
    }

    public static long b(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.huawei.android.pushagent", 16384).versionCode;
        } catch (Exception unused) {
            HMSLog.e("CommFun", "get nc versionCode error");
            return -1L;
        }
    }

    public static boolean c() {
        return HwBuildEx.VERSION.EMUI_SDK_INT < 19;
    }

    public static boolean d(Context context) {
        HMSLog.d("CommFun", "existFrameworkPush:" + f37475b);
        synchronized (f37474a) {
            int i3 = f37475b;
            boolean z16 = false;
            if (-1 != i3) {
                if (1 == i3) {
                    z16 = true;
                }
                return z16;
            }
            if (a(context)) {
                f37475b = 1;
            } else {
                f37475b = 0;
            }
            if (1 != f37475b) {
                return false;
            }
            return true;
        }
    }

    public static String c(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }

    public static boolean b() {
        return HwBuildEx.VERSION.EMUI_SDK_INT >= 21;
    }

    public static boolean a() {
        try {
            Class<?> cls = Class.forName("huawei.cust.HwCfgFilePolicy");
            int intValue = ((Integer) cls.getDeclaredField("CUST_TYPE_CONFIG").get(cls)).intValue();
            Method declaredMethod = cls.getDeclaredMethod("getCfgFile", String.class, Integer.TYPE);
            Object[] objArr = new Object[2];
            objArr[0] = "jars/hwpush.jar";
            objArr[1] = Integer.valueOf(intValue);
            File file = (File) declaredMethod.invoke(cls, objArr);
            if (file != null && file.exists()) {
                HMSLog.d("CommFun", "get push cust File path success.");
                return true;
            }
        } catch (ClassNotFoundException unused) {
            HMSLog.e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            HMSLog.e("CommFun", "check cust exist push IllegalAccessException.");
        } catch (IllegalArgumentException unused3) {
            HMSLog.e("CommFun", "check cust exist push IllegalArgumentException.");
        } catch (NoSuchFieldException unused4) {
            HMSLog.e("CommFun", "check cust exist push NoSuchFieldException.");
        } catch (NoSuchMethodException unused5) {
            HMSLog.e("CommFun", "check cust exist push NoSuchMethodException.");
        } catch (SecurityException unused6) {
            HMSLog.e("CommFun", "check cust exist push SecurityException.");
        } catch (InvocationTargetException unused7) {
            HMSLog.e("CommFun", "check cust exist push InvocationTargetException.");
        }
        return false;
    }

    public static boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        return jSONObject == null || (TextUtils.isEmpty(str) && jSONObject2 == null);
    }
}
