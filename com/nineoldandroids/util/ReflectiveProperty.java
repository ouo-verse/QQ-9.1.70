package com.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
class ReflectiveProperty<T, V> extends Property<T, V> {
    private static final String PREFIX_GET = "get";
    private static final String PREFIX_IS = "is";
    private static final String PREFIX_SET = "set";
    private Field mField;
    private Method mGetter;
    private Method mSetter;

    public ReflectiveProperty(Class<T> cls, Class<V> cls2, String str) {
        super(cls2, str);
        char upperCase = Character.toUpperCase(str.charAt(0));
        String str2 = String.valueOf(upperCase) + str.substring(1);
        String str3 = "get" + str2;
        try {
            try {
                this.mGetter = cls.getMethod(str3, null);
            } catch (NoSuchMethodException unused) {
                Method declaredMethod = cls.getDeclaredMethod(str3, null);
                this.mGetter = declaredMethod;
                declaredMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused2) {
            String str4 = PREFIX_IS + str2;
            try {
                try {
                    try {
                        this.mGetter = cls.getMethod(str4, null);
                    } catch (NoSuchFieldException unused3) {
                        throw new NoSuchPropertyException("No accessor method or field found for property with name " + str);
                    }
                } catch (NoSuchMethodException unused4) {
                    Method declaredMethod2 = cls.getDeclaredMethod(str4, null);
                    this.mGetter = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
            } catch (NoSuchMethodException unused5) {
                Field field = cls.getField(str);
                this.mField = field;
                Class<?> type = field.getType();
                if (typesMatch(cls2, type)) {
                    return;
                }
                throw new NoSuchPropertyException("Underlying type (" + type + ") does not match Property type (" + cls2 + ")");
            }
        }
        Class<?> returnType = this.mGetter.getReturnType();
        if (typesMatch(cls2, returnType)) {
            try {
                Method declaredMethod3 = cls.getDeclaredMethod("set" + str2, returnType);
                this.mSetter = declaredMethod3;
                declaredMethod3.setAccessible(true);
                return;
            } catch (NoSuchMethodException unused6) {
                return;
            }
        }
        throw new NoSuchPropertyException("Underlying type (" + returnType + ") does not match Property type (" + cls2 + ")");
    }

    private boolean typesMatch(Class<V> cls, Class cls2) {
        if (cls2 == cls) {
            return true;
        }
        if (cls2.isPrimitive() && ((cls2 == Float.TYPE && cls == Float.class) || ((cls2 == Integer.TYPE && cls == Integer.class) || ((cls2 == Boolean.TYPE && cls == Boolean.class) || ((cls2 == Long.TYPE && cls == Long.class) || ((cls2 == Double.TYPE && cls == Double.class) || ((cls2 == Short.TYPE && cls == Short.class) || ((cls2 == Byte.TYPE && cls == Byte.class) || (cls2 == Character.TYPE && cls == Character.class))))))))) {
            return true;
        }
        return false;
    }

    @Override // com.nineoldandroids.util.Property
    public V get(T t16) {
        Method method = this.mGetter;
        if (method != null) {
            try {
                return (V) method.invoke(t16, null);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e16) {
                throw new RuntimeException(e16.getCause());
            }
        }
        Field field = this.mField;
        if (field != null) {
            try {
                return (V) field.get(t16);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        throw new AssertionError();
    }

    @Override // com.nineoldandroids.util.Property
    public boolean isReadOnly() {
        if (this.mSetter == null && this.mField == null) {
            return true;
        }
        return false;
    }

    @Override // com.nineoldandroids.util.Property
    public void set(T t16, V v3) {
        Method method = this.mSetter;
        if (method != null) {
            try {
                method.invoke(t16, v3);
                return;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e16) {
                throw new RuntimeException(e16.getCause());
            }
        }
        Field field = this.mField;
        if (field != null) {
            try {
                field.set(t16, v3);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        } else {
            throw new UnsupportedOperationException("Property " + getName() + " is read-only");
        }
    }
}
