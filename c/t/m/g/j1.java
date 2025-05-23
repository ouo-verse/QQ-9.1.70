package c.t.m.g;

import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes.dex */
public class j1 {
    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        return a(obj.getClass(), obj, str, clsArr, objArr);
    }

    public static Object a(Class<?> cls, Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = h1.b(clsArr) ? cls.getDeclaredMethod(str, new Class[0]) : cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod != null) {
                boolean isAccessible = declaredMethod.isAccessible();
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(obj, objArr);
                declaredMethod.setAccessible(isAccessible);
                return invoke;
            }
            if (!c1.a()) {
                return null;
            }
            c1.b("ReflectUtil", "method " + str + "() is null.");
            return null;
        } catch (Throwable th5) {
            if (!c1.a()) {
                return null;
            }
            c1.a("ReflectUtil", "invoke " + str + " error.", th5);
            return null;
        }
    }
}
