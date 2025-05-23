package me.weishu.reflection;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class BootstrapClass {
    private static final String TAG = "BootstrapClass";
    private static Object sVmRuntime;
    private static Method setHiddenApiExemptions;

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
                Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
                Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
                setHiddenApiExemptions = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
                sVmRuntime = method.invoke(null, new Object[0]);
            } catch (Throwable th5) {
                Log.w(TAG, "reflect bootstrap failed:", th5);
            }
        }
    }

    public static boolean exempt(String str) {
        return exempt(str);
    }

    public static boolean exemptAll() {
        return exempt("L");
    }

    public static boolean exempt(String... strArr) {
        Method method;
        Object obj = sVmRuntime;
        if (obj != null && (method = setHiddenApiExemptions) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
