package com.tencent.qqmini.sdk.launcher.dynamic;

import android.util.SparseArray;
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
/* loaded from: classes23.dex */
public class Reflect {
    private final boolean isClass = true;
    private final Object object;
    private static SparseArray<Class> mClassMap = new SparseArray<>();
    private static SparseArray<Method> mMethodMap = new SparseArray<>();
    private static SparseArray<Constructor> mConsMap = new SparseArray<>();
    private static SparseArray<Field> mFieldMap = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class NULL {
        NULL() {
        }
    }

    Reflect(Class<?> cls) {
        this.object = cls;
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

    public static boolean checkClassExists(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private Method exactMethod(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        int hashCode;
        Class<?> type = type();
        try {
            int hashCode2 = type.hashCode() + str.hashCode() + Arrays.hashCode(clsArr);
            if (mMethodMap.get(hashCode2) != null) {
                return mMethodMap.get(hashCode2);
            }
            Method method = type.getMethod(str, clsArr);
            if (method != null) {
                mMethodMap.put(hashCode2, method);
            }
            return method;
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    hashCode = type.hashCode() + str.hashCode() + Arrays.hashCode(clsArr);
                } catch (NoSuchMethodException unused2) {
                }
                if (mMethodMap.get(hashCode) != null) {
                    return mMethodMap.get(hashCode);
                }
                Method method2 = (Method) accessible(type.getDeclaredMethod(str, clsArr));
                if (method2 != null) {
                    mMethodMap.put(hashCode, method2);
                    return method2;
                }
                type = type.getSuperclass();
            } while (type != null);
            throw new NoSuchMethodException();
        }
    }

    private Field field0(String str) throws ReflectException {
        Class<?> type = type();
        try {
            int hashCode = type.hashCode() + str.hashCode();
            if (mFieldMap.get(hashCode) != null) {
                return mFieldMap.get(hashCode);
            }
            Field field = type.getField(str);
            if (field != null) {
                mFieldMap.put(hashCode, field);
            }
            return field;
        } catch (NoSuchFieldException e16) {
            do {
                try {
                    int hashCode2 = type.hashCode() + str.hashCode();
                    if (mFieldMap.get(hashCode2) != null) {
                        return mFieldMap.get(hashCode2);
                    }
                    Field field2 = (Field) accessible(type.getDeclaredField(str));
                    if (field2 != null) {
                        mFieldMap.put(hashCode2, field2);
                    }
                    return field2;
                } catch (NoSuchFieldException unused) {
                    type = type.getSuperclass();
                }
            } while (type != null);
            throw new ReflectException(e16);
        }
    }

    private static Class<?> forName(String str) throws ReflectException {
        try {
            int hashCode = str.hashCode();
            if (mClassMap.get(hashCode) != null) {
                return mClassMap.get(hashCode);
            }
            Class<?> cls = Class.forName(str);
            mClassMap.put(hashCode, cls);
            return cls;
        } catch (Exception e16) {
            throw new ReflectException(e16);
        }
    }

    private boolean isSimilarSignature(Method method, String str, Class<?>[] clsArr) {
        if (method.getName().equals(str) && match(method.getParameterTypes(), clsArr)) {
            return true;
        }
        return false;
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

    private static Object unwrap(Object obj) {
        if (obj instanceof Reflect) {
            return ((Reflect) obj).get();
        }
        return obj;
    }

    public static Class<?> wrapper(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (cls.isPrimitive()) {
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
            if (Void.TYPE == cls) {
                return Void.class;
            }
            return cls;
        }
        return cls;
    }

    public <P> P as(Class<P> cls) {
        final boolean z16 = this.object instanceof Map;
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.tencent.qqmini.sdk.launcher.dynamic.Reflect.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                int length;
                String name = method.getName();
                try {
                    return Reflect.on(Reflect.this.object).call(name, objArr).get();
                } catch (ReflectException e16) {
                    if (z16) {
                        Map map = (Map) Reflect.this.object;
                        if (objArr == null) {
                            length = 0;
                        } else {
                            length = objArr.length;
                        }
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
            return on(field0(str).get(this.object));
        } catch (Exception e16) {
            throw new ReflectException(e16);
        }
    }

    public Map<String, Reflect> fields() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<?> type = type();
        do {
            for (Field field : type.getDeclaredFields()) {
                if ((!this.isClass) ^ Modifier.isStatic(field.getModifiers())) {
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
            field0(str).set(this.object, unwrap(obj));
            return this;
        } catch (Exception e16) {
            throw new ReflectException(e16);
        }
    }

    public String toString() {
        return this.object.toString();
    }

    public Class<?> type() {
        if (this.isClass) {
            return (Class) this.object;
        }
        return this.object.getClass();
    }

    public static Reflect on(String str, ClassLoader classLoader) throws ReflectException {
        return on(forName(str, classLoader));
    }

    public Reflect call(String str, Object... objArr) throws ReflectException {
        Class<?>[] types = types(objArr);
        try {
            try {
                return on(exactMethod(str, types), this.object, objArr);
            } catch (NoSuchMethodException e16) {
                throw new ReflectException(e16);
            }
        } catch (NoSuchMethodException unused) {
            return on((Method) accessible(similarMethod(str, types)), this.object, objArr);
        }
    }

    public Reflect create(Object... objArr) throws ReflectException {
        Constructor constructor;
        Class<?>[] types = types(objArr);
        try {
            Class<?> type = type();
            int hashCode = types.hashCode() + Arrays.hashCode(objArr);
            if (mConsMap.get(hashCode) != null) {
                constructor = mConsMap.get(hashCode);
            } else {
                constructor = (Constructor) accessible(type.getDeclaredConstructor(types));
                mConsMap.put(hashCode, constructor);
            }
            return on((Constructor<?>) constructor, objArr);
        } catch (NoSuchMethodException e16) {
            for (Constructor<?> constructor2 : type().getDeclaredConstructors()) {
                if (constructor2 != null && match(constructor2.getParameterTypes(), types)) {
                    return on((Constructor<?>) accessible(constructor2), objArr);
                }
            }
            throw new ReflectException(e16);
        }
    }

    public <T> T get(String str) throws ReflectException {
        return (T) field(str).get();
    }

    public static Reflect on(Class<?> cls) {
        return new Reflect(cls);
    }

    Reflect(Object obj) {
        this.object = obj;
    }

    public static Reflect on(Object obj) {
        return new Reflect(obj);
    }

    private static Reflect on(Constructor<?> constructor, Object... objArr) throws ReflectException {
        try {
            return on(constructor.newInstance(objArr));
        } catch (Exception e16) {
            throw new ReflectException(e16);
        }
    }

    private static Class<?> forName(String str, ClassLoader classLoader) throws ReflectException {
        try {
            return Class.forName(str, true, classLoader);
        } catch (Exception e16) {
            throw new ReflectException(e16);
        }
    }

    private static Reflect on(Method method, Object obj, Object... objArr) throws ReflectException {
        try {
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
