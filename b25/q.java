package b25;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes28.dex */
public class q {
    public static Object a(Object obj, Class cls, String str) {
        try {
            Field field = null;
            for (Class<?> cls2 = obj.getClass(); field == null && cls2 != null; cls2 = cls2.getSuperclass()) {
                try {
                    field = cls2.getDeclaredField(str);
                } catch (Throwable unused) {
                }
            }
            field.setAccessible(true);
            return cls.cast(field.get(obj));
        } catch (Throwable th5) {
            p.b(th5);
            return null;
        }
    }

    public static Object b(Object obj, Class cls, Method method, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            method.setAccessible(true);
            Object invoke = method.invoke(obj, objArr);
            if (cls == null) {
                return null;
            }
            return cls.cast(invoke);
        } catch (Throwable th5) {
            p.b(th5);
            return null;
        }
    }

    public static Method c(Object obj, String str, Class... clsArr) {
        Class<?> cls;
        Method method = null;
        if (obj == null) {
            cls = null;
        } else {
            cls = obj.getClass();
        }
        while (method == null && cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (Throwable unused) {
            }
            cls = cls.getSuperclass();
        }
        return method;
    }
}
