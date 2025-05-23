package com.qq.e.comm.plugin.k;

import android.text.TextUtils;
import com.qq.e.comm.plugin.stat.StatTracer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes3.dex */
public class al {
    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th5) {
            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
            cVar.a("msg", str);
            StatTracer.trackEvent(54100, 0, (com.qq.e.comm.plugin.stat.b) null, cVar);
            th5.printStackTrace();
            return null;
        }
    }

    public static Object a(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e16) {
            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
            cVar.a("msg", cls.getName());
            StatTracer.trackEvent(54101, 0, (com.qq.e.comm.plugin.stat.b) null, cVar);
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.reflect.Method, com.qq.e.comm.plugin.stat.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.reflect.Method] */
    public static Method a(Class cls, String str, boolean z16, Class... clsArr) {
        ?? r06 = 0;
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            r06 = z16 ? cls.getMethod(str, clsArr) : cls.getDeclaredMethod(str, clsArr);
            return r06;
        } catch (Exception e16) {
            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
            cVar.a("msg", str);
            StatTracer.trackEvent(54102, 0, (com.qq.e.comm.plugin.stat.b) r06, cVar);
            e16.printStackTrace();
            return r06;
        }
    }

    public static Method a(Class cls, String str, Class... clsArr) {
        return a(cls, str, true, clsArr);
    }

    public static Object a(Object obj, Method method, boolean z16, Object... objArr) {
        if (obj == null || method == null) {
            return null;
        }
        if (!z16) {
            try {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
            } catch (Exception e16) {
                com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
                cVar.a("msg", method.getName());
                StatTracer.trackEvent(54103, 0, (com.qq.e.comm.plugin.stat.b) null, cVar);
                e16.printStackTrace();
                return null;
            }
        }
        return method.invoke(obj, objArr);
    }

    public static Object a(Object obj, Method method, Object... objArr) {
        return a(obj, method, true, objArr);
    }

    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.reflect.Field, com.qq.e.comm.plugin.stat.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.reflect.Field] */
    public static Field a(Class cls, String str, boolean z16) {
        ?? r06 = 0;
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            r06 = z16 ? cls.getField(str) : cls.getDeclaredField(str);
            return r06;
        } catch (Exception e16) {
            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
            cVar.a("msg", str);
            StatTracer.trackEvent(54104, 0, (com.qq.e.comm.plugin.stat.b) r06, cVar);
            e16.printStackTrace();
            return r06;
        }
    }

    public static Field a(Class cls, String str) {
        return a(cls, str, true);
    }

    public static boolean a(Field field, Object obj, boolean z16, Object obj2) {
        if (field != null && obj != null) {
            if (!z16) {
                try {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                } catch (Exception e16) {
                    com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
                    cVar.a("msg", field.getName());
                    StatTracer.trackEvent(54104, 0, (com.qq.e.comm.plugin.stat.b) null, cVar);
                    e16.printStackTrace();
                }
            }
            field.set(obj, obj2);
            return true;
        }
        return false;
    }

    public static boolean a(Field field, Object obj, Object obj2) {
        return a(field, obj, true, obj2);
    }
}
