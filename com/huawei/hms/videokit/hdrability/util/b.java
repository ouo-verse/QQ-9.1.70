package com.huawei.hms.videokit.hdrability.util;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.util.ReflectionUtil;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class b {
    public static Object a(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        String str3;
        if (str != null && !TextUtils.isEmpty(str2)) {
            try {
                Class<?> cls = Class.forName(str);
                return cls.getMethod(str2, clsArr).invoke(cls.newInstance(), objArr);
            } catch (ClassNotFoundException unused) {
                str3 = "ClassNotFoundException";
                Log.e(ReflectionUtil.TAG, str3);
                return null;
            } catch (IllegalAccessException unused2) {
                str3 = "IllegalAccessException";
                Log.e(ReflectionUtil.TAG, str3);
                return null;
            } catch (InstantiationException unused3) {
                str3 = "InstantiationException";
                Log.e(ReflectionUtil.TAG, str3);
                return null;
            } catch (NoSuchMethodException unused4) {
                str3 = "NoSuchMethodException";
                Log.e(ReflectionUtil.TAG, str3);
                return null;
            } catch (InvocationTargetException unused5) {
                str3 = "InvocationTargetException";
                Log.e(ReflectionUtil.TAG, str3);
                return null;
            }
        }
        Log.w(ReflectionUtil.TAG, "invoke param className or methodName can not be null!");
        return null;
    }

    public static Object b(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        String str3;
        if (str != null && !TextUtils.isEmpty(str2)) {
            try {
                return Class.forName(str).getDeclaredMethod(str2, clsArr).invoke(null, objArr);
            } catch (ClassNotFoundException unused) {
                str3 = "ClassNotFoundException";
                Log.e(ReflectionUtil.TAG, str3);
                return null;
            } catch (IllegalAccessException unused2) {
                str3 = "IllegalAccessException";
                Log.e(ReflectionUtil.TAG, str3);
                return null;
            } catch (NoSuchMethodException unused3) {
                str3 = "NoSuchMethodException";
                Log.e(ReflectionUtil.TAG, str3);
                return null;
            } catch (InvocationTargetException unused4) {
                str3 = "InvocationTargetException";
                Log.e(ReflectionUtil.TAG, str3);
                return null;
            }
        }
        Log.w(ReflectionUtil.TAG, "invoke param className or methodName can not be null!");
        return null;
    }
}
