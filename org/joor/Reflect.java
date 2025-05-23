package org.joor;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class Reflect {
    private final Object object;
    private final Class<?> type;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class NULL {
        NULL() {
        }
    }

    Reflect(Class<?> cls) {
        this(cls, cls);
    }

    private Method exactMethod(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> type = type();
        try {
            return type.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return type.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    type = type.getSuperclass();
                }
            } while (type != null);
            throw new NoSuchMethodException();
        }
    }

    private Field field0(String str) throws ReflectException {
        Class<?> type = type();
        try {
            return (Field) accessible(type.getField(str));
        } catch (NoSuchFieldException e16) {
            do {
                try {
                    return (Field) accessible(type.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new ReflectException(e16);
                    }
                }
            } while (type == null);
            throw new ReflectException(e16);
        }
    }

    private static Class<?> forName(String str) throws ReflectException {
        try {
            return Class.forName(str);
        } catch (Exception e16) {
            throw new ReflectException(e16);
        }
    }

    private boolean isSimilarSignature(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && match(method.getParameterTypes(), clsArr);
    }

    private boolean match(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < clsArr2.length; i3++) {
            if (clsArr2[i3] != NULL.class && !wrapper(clsArr[i3]).isAssignableFrom(wrapper(clsArr2[i3]))) {
                return false;
            }
        }
        return true;
    }

    public static Reflect on(String str) throws ReflectException {
        return on(forName(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String property(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    private Method similarMethod(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> type = type();
        for (Method method : type.getMethods()) {
            if (isSimilarSignature(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : type.getDeclaredMethods()) {
                if (isSimilarSignature(method2, str, clsArr)) {
                    return method2;
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + ".");
    }

    private static Object unwrap(Object obj) {
        return obj instanceof Reflect ? ((Reflect) obj).get() : obj;
    }

    public <P> P as(Class<P> cls) {
        final boolean z16 = this.object instanceof Map;
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: org.joor.Reflect.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                String name = method.getName();
                try {
                    return Reflect.on((Class<?>) Reflect.this.type, Reflect.this.object).call(name, objArr).get();
                } catch (ReflectException e16) {
                    if (z16) {
                        Map map = (Map) Reflect.this.object;
                        int length = objArr == null ? 0 : objArr.length;
                        if (length == 0 && name.startsWith("get")) {
                            return map.get(Reflect.property(name.substring(3)));
                        }
                        if (length == 0 && name.startsWith("is")) {
                            return map.get(Reflect.property(name.substring(2)));
                        }
                        if (length == 1 && name.startsWith("set")) {
                            map.put(Reflect.property(name.substring(3)), objArr[0]);
                            return null;
                        }
                    }
                    throw e16;
                }
            }
        });
    }

    public Reflect call(String str) throws ReflectException {
        return call(str, new Object[0]);
    }

    public Reflect create() throws ReflectException {
        return create(new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.object.equals(((Reflect) obj).get());
        }
        return false;
    }

    public Reflect field(String str) throws ReflectException {
        try {
            Field field0 = field0(str);
            return on(field0.getType(), field0.get(this.object));
        } catch (Exception e16) {
            throw new ReflectException(e16);
        }
    }

    public Map<String, Reflect> fields() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<?> type = type();
        do {
            for (Field field : type.getDeclaredFields()) {
                if ((this.type != this.object) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, field(name));
                    }
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        return linkedHashMap;
    }

    public <T> T get() {
        return (T) this.object;
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public Reflect set(String str, Object obj) throws ReflectException {
        try {
            Field field0 = field0(str);
            if ((field0.getModifiers() & 16) == 16) {
                Field declaredField = Field.class.getDeclaredField("modifiers");
                declaredField.setAccessible(true);
                declaredField.setInt(field0, field0.getModifiers() & (-17));
            }
            field0.set(this.object, unwrap(obj));
            return this;
        } catch (Exception e16) {
            throw new ReflectException(e16);
        }
    }

    public String toString() {
        return this.object.toString();
    }

    public Class<?> type() {
        return this.type;
    }

    Reflect(Class<?> cls, Object obj) {
        this.type = cls;
        this.object = obj;
    }

    public static Reflect on(String str, ClassLoader classLoader) throws ReflectException {
        return on(forName(str, classLoader));
    }

    public Reflect call(String str, Object... objArr) throws ReflectException {
        Class<?>[] types = types(objArr);
        try {
            try {
                return on(exactMethod(str, types), this.object, objArr);
            } catch (NoSuchMethodException unused) {
                return on(similarMethod(str, types), this.object, objArr);
            }
        } catch (NoSuchMethodException e16) {
            throw new ReflectException(e16);
        }
    }

    public Reflect create(Object... objArr) throws ReflectException {
        Class<?>[] types = types(objArr);
        try {
            return on(type().getDeclaredConstructor(types), objArr);
        } catch (NoSuchMethodException e16) {
            for (Constructor<?> constructor : type().getDeclaredConstructors()) {
                if (match(constructor.getParameterTypes(), types)) {
                    return on(constructor, objArr);
                }
            }
            throw new ReflectException(e16);
        }
    }

    public <T> T get(String str) throws ReflectException {
        return (T) field(str).get();
    }

    private static Class<?> forName(String str, ClassLoader classLoader) throws ReflectException {
        try {
            return Class.forName(str, true, classLoader);
        } catch (Exception e16) {
            throw new ReflectException(e16);
        }
    }

    public static Reflect on(Class<?> cls) {
        return new Reflect(cls);
    }

    public static Reflect on(Object obj) {
        return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    private static Class<?>[] types(Object... objArr) {
        Class<?> cls;
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i3 = 0; i3 < objArr.length; i3++) {
            Object obj = objArr[i3];
            if (obj == null) {
                cls = NULL.class;
            } else {
                cls = obj.getClass();
            }
            clsArr[i3] = cls;
        }
        return clsArr;
    }

    public static <T extends AccessibleObject> T accessible(T t16) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static Reflect on(Class<?> cls, Object obj) {
        return new Reflect(cls, obj);
    }

    public static Class<?> wrapper(Class<?> cls) {
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

    private static Reflect on(Constructor<?> constructor, Object... objArr) throws ReflectException {
        try {
            return on(constructor.getDeclaringClass(), ((Constructor) accessible(constructor)).newInstance(objArr));
        } catch (Exception e16) {
            throw new ReflectException(e16);
        }
    }

    private static Reflect on(Method method, Object obj, Object... objArr) throws ReflectException {
        try {
            accessible(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return on(obj);
            }
            return on(method.invoke(obj, objArr));
        } catch (Exception e16) {
            throw new ReflectException(e16);
        }
    }
}
