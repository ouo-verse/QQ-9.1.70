package org.apache.commons.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ConstructorUtils {
    public static Constructor getAccessibleConstructor(Class cls, Class cls2) {
        return getAccessibleConstructor(cls, new Class[]{cls2});
    }

    public static Constructor getMatchingAccessibleConstructor(Class cls, Class[] clsArr) {
        Constructor accessibleConstructor;
        try {
            Constructor constructor = cls.getConstructor(clsArr);
            MemberUtils.setAccessibleWorkaround(constructor);
            return constructor;
        } catch (NoSuchMethodException unused) {
            Constructor<?>[] constructors = cls.getConstructors();
            Constructor constructor2 = null;
            for (int i3 = 0; i3 < constructors.length; i3++) {
                if (ClassUtils.isAssignable(clsArr, (Class[]) constructors[i3].getParameterTypes(), true) && (accessibleConstructor = getAccessibleConstructor(constructors[i3])) != null) {
                    MemberUtils.setAccessibleWorkaround(accessibleConstructor);
                    if (constructor2 == null || MemberUtils.compareParameterTypes(accessibleConstructor.getParameterTypes(), constructor2.getParameterTypes(), clsArr) < 0) {
                        constructor2 = accessibleConstructor;
                    }
                }
            }
            return constructor2;
        }
    }

    public static Object invokeConstructor(Class cls, Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return invokeConstructor(cls, new Object[]{obj});
    }

    public static Object invokeExactConstructor(Class cls, Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return invokeExactConstructor(cls, new Object[]{obj});
    }

    public static Constructor getAccessibleConstructor(Class cls, Class[] clsArr) {
        try {
            return getAccessibleConstructor(cls.getConstructor(clsArr));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Object invokeConstructor(Class cls, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (objArr == null) {
            objArr = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i3 = 0; i3 < objArr.length; i3++) {
            clsArr[i3] = objArr[i3].getClass();
        }
        return invokeConstructor(cls, objArr, clsArr);
    }

    public static Object invokeExactConstructor(Class cls, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (objArr == null) {
            objArr = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i3 = 0; i3 < length; i3++) {
            clsArr[i3] = objArr[i3].getClass();
        }
        return invokeExactConstructor(cls, objArr, clsArr);
    }

    public static Constructor getAccessibleConstructor(Constructor constructor) {
        if (MemberUtils.isAccessible(constructor) && Modifier.isPublic(constructor.getDeclaringClass().getModifiers())) {
            return constructor;
        }
        return null;
    }

    public static Object invokeConstructor(Class cls, Object[] objArr, Class[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (clsArr == null) {
            clsArr = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        if (objArr == null) {
            objArr = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, clsArr);
        if (matchingAccessibleConstructor != null) {
            return matchingAccessibleConstructor.newInstance(objArr);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("No such accessible constructor on object: ");
        stringBuffer.append(cls.getName());
        throw new NoSuchMethodException(stringBuffer.toString());
    }

    public static Object invokeExactConstructor(Class cls, Object[] objArr, Class[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (objArr == null) {
            objArr = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        if (clsArr == null) {
            clsArr = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Constructor accessibleConstructor = getAccessibleConstructor(cls, clsArr);
        if (accessibleConstructor != null) {
            return accessibleConstructor.newInstance(objArr);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("No such accessible constructor on object: ");
        stringBuffer.append(cls.getName());
        throw new NoSuchMethodException(stringBuffer.toString());
    }
}
