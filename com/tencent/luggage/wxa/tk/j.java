package com.tencent.luggage.wxa.tk;

import com.tencent.luggage.wxa.tn.w;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {
    public static Object a(Class cls, String str, Object obj, Class[] clsArr, Object[] objArr) {
        return a(cls, str, obj, clsArr, objArr, null);
    }

    public static Object a(Class cls, String str, Object obj, Class[] clsArr, Object[] objArr, Object obj2) {
        if (obj != null) {
            Class<?> cls2 = obj.getClass();
            Method method = null;
            while (cls2 != null) {
                try {
                    try {
                        method = cls2.getDeclaredMethod(str, clsArr);
                    } catch (Exception unused) {
                        if (cls == cls2) {
                            try {
                                method = cls2.getDeclaredMethod(str, clsArr);
                            } catch (Exception unused2) {
                            }
                        }
                    }
                } finally {
                    cls2.getSuperclass();
                }
            }
            if (method == null) {
                return obj2;
            }
            try {
                method.setAccessible(true);
                return method.invoke(obj, objArr);
            } catch (Exception e16) {
                w.a("MicroMsg.ReflectUtil", e16, "", new Object[0]);
                return obj2;
            }
        }
        throw new IllegalArgumentException("instance cannot be null");
    }
}
