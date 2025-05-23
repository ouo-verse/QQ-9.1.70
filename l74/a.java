package l74;

import android.util.Log;
import android.util.SparseArray;
import com.tencent.sqshow.ipc.reflect.ReflectException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static SparseArray<Class> f413931c = new SparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    private static SparseArray<Method> f413932d = new SparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    private static SparseArray<Constructor> f413933e = new SparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    private static SparseArray<Field> f413934f = new SparseArray<>();

    /* renamed from: a, reason: collision with root package name */
    private final Object f413935a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f413936b = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: l74.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static class C10711a {
        C10711a() {
        }
    }

    a(Object obj) {
        this.f413935a = obj;
    }

    private Method c(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        int hashCode;
        Class<?> j3 = j();
        try {
            int hashCode2 = j3.hashCode() + str.hashCode() + Arrays.hashCode(clsArr);
            if (f413932d.get(hashCode2) != null) {
                return f413932d.get(hashCode2);
            }
            Method method = j3.getMethod(str, clsArr);
            if (method != null) {
                f413932d.put(hashCode2, method);
            }
            return method;
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    hashCode = j3.hashCode() + str.hashCode() + Arrays.hashCode(clsArr);
                } catch (NoSuchMethodException e16) {
                    Log.w("Reflect", "error, ", e16);
                }
                if (f413932d.get(hashCode) != null) {
                    return f413932d.get(hashCode);
                }
                Method method2 = (Method) a(j3.getDeclaredMethod(str, clsArr));
                if (method2 != null) {
                    f413932d.put(hashCode, method2);
                    return method2;
                }
                j3 = j3.getSuperclass();
            } while (j3 != null);
            throw new NoSuchMethodException();
        }
    }

    private boolean e(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && f(method.getParameterTypes(), clsArr);
    }

    private boolean f(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < clsArr2.length; i3++) {
            if (clsArr2[i3] != C10711a.class && !l(clsArr[i3]).isAssignableFrom(l(clsArr2[i3]))) {
                return false;
            }
        }
        return true;
    }

    public static a g(Object obj) {
        return new a(obj);
    }

    private static a h(Method method, Object obj, Object... objArr) throws ReflectException {
        try {
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return g(obj);
            }
            return g(method.invoke(obj, objArr));
        } catch (InvocationTargetException e16) {
            throw new ReflectException(e16.getTargetException());
        } catch (Exception e17) {
            throw new ReflectException(e17);
        }
    }

    private Method i(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> j3 = j();
        for (Method method : j3.getMethods()) {
            if (e(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : j3.getDeclaredMethods()) {
                if (e(method2, str, clsArr)) {
                    return method2;
                }
            }
            j3 = j3.getSuperclass();
        } while (j3 != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + j() + ".");
    }

    public a b(String str, Object... objArr) throws ReflectException {
        Class<?>[] k3 = k(objArr);
        try {
            try {
                return h(c(str, k3), this.f413935a, objArr);
            } catch (NoSuchMethodException e16) {
                throw new ReflectException(e16);
            }
        } catch (NoSuchMethodException unused) {
            return h((Method) a(i(str, k3)), this.f413935a, objArr);
        }
    }

    public <T> T d() {
        return (T) this.f413935a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f413935a.equals(((a) obj).d());
        }
        return false;
    }

    public int hashCode() {
        return this.f413935a.hashCode();
    }

    public Class<?> j() {
        if (this.f413936b) {
            return (Class) this.f413935a;
        }
        return this.f413935a.getClass();
    }

    public String toString() {
        return this.f413935a.toString();
    }

    private static Class<?>[] k(Object... objArr) {
        Class<?> cls;
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i3 = 0; i3 < objArr.length; i3++) {
            Object obj = objArr[i3];
            if (obj == null) {
                cls = C10711a.class;
            } else {
                cls = obj.getClass();
            }
            clsArr[i3] = cls;
        }
        return clsArr;
    }

    public static <T extends AccessibleObject> T a(T t16) {
        if (t16 == null) {
            return null;
        }
        if (t16 instanceof Member) {
            Member member = (Member) t16;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t16;
            }
        }
        if (!t16.isAccessible()) {
            t16.setAccessible(true);
        }
        return t16;
    }

    public static Class<?> l(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }
}
