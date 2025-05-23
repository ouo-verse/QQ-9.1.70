package ly3;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a<R> implements InterfaceC10753c<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f415788a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class[] f415789b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f415790c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object[] f415791d;

        a(String str, Class[] clsArr, Object obj, Object[] objArr) {
            this.f415788a = str;
            this.f415789b = clsArr;
            this.f415790c = obj;
            this.f415791d = objArr;
        }

        @Override // ly3.c.InterfaceC10753c
        public R a(Class<?> cls) throws Exception {
            Method declaredMethod = cls.getDeclaredMethod(this.f415788a, this.f415789b);
            declaredMethod.setAccessible(true);
            return (R) declaredMethod.invoke(this.f415790c, this.f415791d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b<V> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<? extends V> f415792a;

        /* renamed from: b, reason: collision with root package name */
        public final V f415793b;

        public b(Class<? extends V> cls, V v3) {
            this.f415792a = cls;
            this.f415793b = v3;
        }

        public static Class<?>[] a(b<?>... bVarArr) {
            Class<?>[] clsArr = new Class[bVarArr.length];
            for (int i3 = 0; i3 < bVarArr.length; i3++) {
                clsArr[i3] = bVarArr[i3].f415792a;
            }
            return clsArr;
        }

        public static Object[] b(b<?>... bVarArr) {
            Object[] objArr = new Object[bVarArr.length];
            for (int i3 = 0; i3 < bVarArr.length; i3++) {
                objArr[i3] = bVarArr[i3].f415793b;
            }
            return objArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: ly3.c$c, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC10753c<R> {
        R a(Class<?> cls) throws Exception;
    }

    public static <R> R a(Object obj, String str, b<?>... bVarArr) {
        try {
            return (R) i(obj.getClass(), NoSuchMethodException.class, new a(str, b.a(bVarArr), obj, b.b(bVarArr)));
        } catch (InvocationTargetException e16) {
            if (!(e16.getTargetException() instanceof RuntimeException)) {
                if (e16.getTargetException() instanceof Error) {
                    throw ((Error) e16.getTargetException());
                }
                throw new RuntimeException(e16.getTargetException());
            }
            throw ((RuntimeException) e16.getTargetException());
        } catch (Exception e17) {
            throw new RuntimeException(e17);
        }
    }

    public static <R> R b(Class<?> cls, String str, b<?>... bVarArr) {
        try {
            Class<?>[] a16 = b.a(bVarArr);
            Object[] b16 = b.b(bVarArr);
            Method declaredMethod = cls.getDeclaredMethod(str, a16);
            declaredMethod.setAccessible(true);
            if (Modifier.isStatic(declaredMethod.getModifiers())) {
                return (R) declaredMethod.invoke(null, b16);
            }
            throw new IllegalArgumentException(declaredMethod + " is not static");
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("no such method " + cls + "." + str, e16);
        } catch (InvocationTargetException e17) {
            if (!(e17.getTargetException() instanceof RuntimeException)) {
                if (e17.getTargetException() instanceof Error) {
                    throw ((Error) e17.getTargetException());
                }
                throw new RuntimeException(e17.getTargetException());
            }
            throw ((RuntimeException) e17.getTargetException());
        } catch (Exception e18) {
            throw new RuntimeException(e18);
        }
    }

    public static Field c(Class<?> cls, @NonNull String str) {
        Field field;
        while (true) {
            field = null;
            if (cls == Object.class || cls == null) {
                break;
            }
            try {
                field = cls.getDeclaredField(str);
                break;
            } catch (NoSuchFieldException e16) {
                QLog.e("ReflectHelper", 1, "getDeclaredField failed!", e16);
                cls = cls.getSuperclass();
            }
        }
        return field;
    }

    public static Field d(Object obj, @NonNull String str) {
        if (obj == null) {
            return null;
        }
        return c(obj.getClass(), str);
    }

    public static <T> T e(Object obj, String str) {
        return (T) g(obj, d(obj, str));
    }

    public static Object f(Object obj, String str) {
        return g(obj, d(obj, str));
    }

    public static Object g(Object obj, Field field) {
        if (field != null) {
            try {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                return field.get(obj);
            } catch (Throwable th5) {
                QLog.e("ReflectHelper", 1, "getFieldValueObj failed!", th5);
                return null;
            }
        }
        return null;
    }

    public static boolean h(Class<?> cls, String str, Object obj) {
        Field c16 = c(cls, str);
        if (c16 != null) {
            try {
                if (Modifier.isFinal(c16.getModifiers())) {
                    Field declaredField = Field.class.getDeclaredField("accessFlags");
                    declaredField.setAccessible(true);
                    declaredField.setInt(c16, c16.getModifiers() & (-17));
                }
                if (!c16.isAccessible()) {
                    c16.setAccessible(true);
                }
                c16.set(null, obj);
                return true;
            } catch (Throwable th5) {
                QLog.e("ReflectHelper", 1, "setStaticValue failed!", th5);
                return false;
            }
        }
        return false;
    }

    private static <R, E extends Exception> R i(Class<?> cls, Class<? extends E> cls2, InterfaceC10753c<R> interfaceC10753c) throws Exception {
        do {
            try {
                return interfaceC10753c.a(cls);
            } catch (Exception e16) {
                if (cls2.isInstance(e16)) {
                    cls = cls.getSuperclass();
                } else {
                    throw e16;
                }
            }
        } while (cls != null);
        throw new RuntimeException(e16);
    }
}
