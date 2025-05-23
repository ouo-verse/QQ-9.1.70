package com.tencent.thumbplayer.core.codec.tmediacodec.util;

import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ReflectUtils {
    public static final Class<?>[] EMPTY_PARAM_TYPES = new Class[0];
    public static final Object[] EMPTY_PARAMS = new Object[0];

    public static String getClassName(Class<?> cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.reflect.Constructor<?>] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public static Constructor<?> getConstructor(Class<?> cls, boolean z16, boolean z17, Class<?>... clsArr) {
        try {
            if (z16) {
                cls = cls.getDeclaredConstructor(clsArr);
            } else {
                cls = cls.getConstructor(clsArr);
            }
            return cls;
        } catch (NoSuchMethodException unused) {
            Constructor<?> constructor = null;
            if (z17) {
                Class superclass = cls.getSuperclass();
                while (constructor == null && superclass != null) {
                    if (z16) {
                        try {
                            constructor = cls.getDeclaredConstructor(clsArr);
                        } catch (NoSuchMethodException unused2) {
                            superclass = superclass.getSuperclass();
                        }
                    } else {
                        constructor = cls.getConstructor(clsArr);
                    }
                }
            }
            return constructor;
        }
    }

    public static List<Constructor<?>> getConstructors(Class<?> cls, boolean z16, boolean z17, boolean z18) {
        Constructor<?>[] constructors;
        Constructor<?>[] constructors2;
        Constructor<?>[] constructors3;
        ArrayList arrayList = new ArrayList();
        if (z17) {
            List<Class<?>> superClasss = getSuperClasss(cls, true);
            if (z18) {
                for (int size = superClasss.size() - 1; size > -1; size--) {
                    if (z16) {
                        constructors3 = superClasss.get(size).getDeclaredConstructors();
                    } else {
                        constructors3 = superClasss.get(size).getConstructors();
                    }
                    for (Constructor<?> constructor : constructors3) {
                        arrayList.add(constructor);
                    }
                }
            } else {
                for (int i3 = 0; i3 < superClasss.size(); i3++) {
                    if (z16) {
                        constructors2 = superClasss.get(i3).getDeclaredConstructors();
                    } else {
                        constructors2 = superClasss.get(i3).getConstructors();
                    }
                    for (Constructor<?> constructor2 : constructors2) {
                        arrayList.add(constructor2);
                    }
                }
            }
        } else {
            if (z16) {
                constructors = cls.getDeclaredConstructors();
            } else {
                constructors = cls.getConstructors();
            }
            for (Constructor<?> constructor3 : constructors) {
                arrayList.add(constructor3);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    public static Field getField(Class<?> cls, String str, boolean z16, boolean z17) {
        try {
            cls = z16 ? cls.getDeclaredField(str) : cls.getField(str);
            return cls;
        } catch (NoSuchFieldException unused) {
            if (!z17) {
                return null;
            }
            Class superclass = cls.getSuperclass();
            Field field = null;
            while (field == null && superclass != null) {
                if (z16) {
                    try {
                        field = superclass.getDeclaredField(str);
                    } catch (NoSuchFieldException unused2) {
                        superclass = superclass.getSuperclass();
                    }
                } else {
                    field = superclass.getField(str);
                }
            }
            return field;
        }
    }

    public static List<Field> getFields(Class<?> cls, boolean z16, boolean z17, boolean z18, boolean z19) {
        List<Class<?>> list;
        Field[] fields;
        Field[] fields2;
        ArrayList arrayList = new ArrayList();
        if (z17) {
            if (z18) {
                list = getSuperClasss(cls, true);
            } else {
                ArrayList arrayList2 = new ArrayList(2);
                arrayList2.add(cls);
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass != null) {
                    arrayList2.add(superclass);
                }
                list = arrayList2;
            }
            if (z19) {
                for (int size = list.size() - 1; size > -1; size--) {
                    if (z16) {
                        fields2 = list.get(size).getDeclaredFields();
                    } else {
                        fields2 = list.get(size).getFields();
                    }
                    for (Field field : fields2) {
                        arrayList.add(field);
                    }
                }
            } else {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if (z16) {
                        fields = list.get(i3).getDeclaredFields();
                    } else {
                        fields = list.get(i3).getFields();
                    }
                    for (Field field2 : fields) {
                        arrayList.add(field2);
                    }
                }
            }
        } else {
            for (Field field3 : z16 ? cls.getDeclaredFields() : cls.getFields()) {
                arrayList.add(field3);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    public static Method getMethod(Class<?> cls, boolean z16, boolean z17, String str, Class<?>... clsArr) {
        try {
            if (z16) {
                cls = cls.getDeclaredMethod(str, clsArr);
            } else {
                cls = cls.getMethod(str, clsArr);
            }
            return cls;
        } catch (NoSuchMethodException unused) {
            if (!z17) {
                return null;
            }
            Class superclass = cls.getSuperclass();
            Method method = null;
            while (method == null && superclass != null) {
                if (z16) {
                    try {
                        method = superclass.getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused2) {
                        superclass = superclass.getSuperclass();
                    }
                } else {
                    method = superclass.getMethod(str, clsArr);
                }
            }
            return method;
        }
    }

    public static List<Method> getMethods(Class<?> cls, boolean z16, boolean z17, boolean z18) {
        Method[] methods;
        Method[] methods2;
        ArrayList arrayList = new ArrayList();
        if (z17) {
            List<Class<?>> superClasss = getSuperClasss(cls, true);
            if (z18) {
                for (int size = superClasss.size() - 1; size > -1; size--) {
                    if (z16) {
                        methods2 = superClasss.get(size).getDeclaredMethods();
                    } else {
                        methods2 = superClasss.get(size).getMethods();
                    }
                    for (Method method : methods2) {
                        arrayList.add(method);
                    }
                }
            } else {
                for (int i3 = 0; i3 < superClasss.size(); i3++) {
                    if (z16) {
                        methods = superClasss.get(i3).getDeclaredMethods();
                    } else {
                        methods = superClasss.get(i3).getMethods();
                    }
                    for (Method method2 : methods) {
                        arrayList.add(method2);
                    }
                }
            }
        } else {
            for (Method method3 : z16 ? cls.getDeclaredMethods() : cls.getMethods()) {
                arrayList.add(method3);
            }
        }
        return arrayList;
    }

    public static <T> T getObjectByFieldName(Object obj, String str, Class<T> cls) {
        if (obj != null && !TextUtils.isEmpty(str) && cls != null) {
            try {
                Field field = getField(obj.getClass(), str, true, true);
                if (field == null) {
                    return null;
                }
                field.setAccessible(true);
                return (T) field.get(obj);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    public static List<Class<?>> getSuperClasss(Class<?> cls, boolean z16) {
        ArrayList arrayList = new ArrayList();
        if (!z16) {
            cls = cls.getSuperclass();
        }
        while (cls != null) {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public static Method getValueOfMethod(Class<?> cls, Class<?>... clsArr) {
        return getMethod(cls, true, true, "valueOf", clsArr);
    }

    public static Object invokeMethod(Method method, Object obj) throws Exception {
        return method.invoke(obj, EMPTY_PARAMS);
    }

    public static final boolean isArrayByType(Field field, Class<?> cls) {
        Class<?> type = field.getType();
        if (type.isArray() && cls.isAssignableFrom(type.getComponentType())) {
            return true;
        }
        return false;
    }

    public static final boolean isCollectionByType(Field field, Class<? extends Collection> cls, Class<?> cls2) {
        if (!cls.isAssignableFrom(field.getType())) {
            return false;
        }
        return cls2.isAssignableFrom((Class) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]);
    }

    public static boolean setField(Object obj, String str, Object obj2, boolean z16, boolean z17) {
        Field field = getField(obj.getClass(), str, z16, z17);
        if (field == null) {
            return false;
        }
        try {
            field.setAccessible(true);
            field.set(obj, obj2);
            return true;
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static Object invokeMethod(Method method, Object obj, Object... objArr) throws Exception {
        return method.invoke(obj, objArr);
    }

    public static Field getField(Class<?> cls, String str) {
        return getField(cls, str, true, true);
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        return getMethod(cls, true, true, str, clsArr);
    }

    public static Method getMethod(Class<?> cls, String str) {
        return getMethod(cls, str, EMPTY_PARAM_TYPES);
    }

    public static List<Method> getMethods(Class<?> cls) {
        return getMethods(cls, true, true, true);
    }

    public static List<Field> getFields(Class<?> cls) {
        return getFields(cls, true, true, true, true);
    }
}
