package org.apache.commons.lang.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import org.apache.commons.lang.ClassUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FieldUtils {
    public static Field getDeclaredField(Class cls, String str) {
        return getDeclaredField(cls, str, false);
    }

    public static Field getField(Class cls, String str) {
        Field field = getField(cls, str, false);
        MemberUtils.setAccessibleWorkaround(field);
        return field;
    }

    public static Object readDeclaredField(Object obj, String str) throws IllegalAccessException {
        return readDeclaredField(obj, str, false);
    }

    public static Object readDeclaredStaticField(Class cls, String str) throws IllegalAccessException {
        return readDeclaredStaticField(cls, str, false);
    }

    public static Object readField(Field field, Object obj) throws IllegalAccessException {
        return readField(field, obj, false);
    }

    public static Object readStaticField(Field field) throws IllegalAccessException {
        return readStaticField(field, false);
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2) throws IllegalAccessException {
        writeDeclaredField(obj, str, obj2, false);
    }

    public static void writeDeclaredStaticField(Class cls, String str, Object obj) throws IllegalAccessException {
        writeDeclaredStaticField(cls, str, obj, false);
    }

    public static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        writeField(field, obj, obj2, false);
    }

    public static void writeStaticField(Field field, Object obj) throws IllegalAccessException {
        writeStaticField(field, obj, false);
    }

    public static Field getDeclaredField(Class cls, String str, boolean z16) {
        if (cls == null) {
            throw new IllegalArgumentException("The class must not be null");
        }
        if (str != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!MemberUtils.isAccessible(declaredField)) {
                    if (!z16) {
                        return null;
                    }
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("The field name must not be null");
    }

    public static Object readDeclaredField(Object obj, String str, boolean z16) throws IllegalAccessException {
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Field declaredField = getDeclaredField(cls, str, z16);
            if (declaredField != null) {
                return readField(declaredField, obj);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot locate declared field ");
            stringBuffer.append(cls.getName());
            stringBuffer.append(".");
            stringBuffer.append(str);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        throw new IllegalArgumentException("target object must not be null");
    }

    public static Object readDeclaredStaticField(Class cls, String str, boolean z16) throws IllegalAccessException {
        Field declaredField = getDeclaredField(cls, str, z16);
        if (declaredField != null) {
            return readStaticField(declaredField, false);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cannot locate declared field ");
        stringBuffer.append(cls.getName());
        stringBuffer.append(".");
        stringBuffer.append(str);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public static Object readField(Field field, Object obj, boolean z16) throws IllegalAccessException {
        if (field != null) {
            if (z16 && !field.isAccessible()) {
                field.setAccessible(true);
            } else {
                MemberUtils.setAccessibleWorkaround(field);
            }
            return field.get(obj);
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    public static Object readStaticField(Field field, boolean z16) throws IllegalAccessException {
        if (field != null) {
            if (Modifier.isStatic(field.getModifiers())) {
                return readField(field, (Object) null, z16);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The field '");
            stringBuffer.append(field.getName());
            stringBuffer.append("' is not static");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2, boolean z16) throws IllegalAccessException {
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Field declaredField = getDeclaredField(cls, str, z16);
            if (declaredField != null) {
                writeField(declaredField, obj, obj2);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot locate declared field ");
            stringBuffer.append(cls.getName());
            stringBuffer.append(".");
            stringBuffer.append(str);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        throw new IllegalArgumentException("target object must not be null");
    }

    public static void writeDeclaredStaticField(Class cls, String str, Object obj, boolean z16) throws IllegalAccessException {
        Field declaredField = getDeclaredField(cls, str, z16);
        if (declaredField != null) {
            writeField(declaredField, (Object) null, obj);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cannot locate declared field ");
        stringBuffer.append(cls.getName());
        stringBuffer.append(".");
        stringBuffer.append(str);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public static void writeField(Field field, Object obj, Object obj2, boolean z16) throws IllegalAccessException {
        if (field != null) {
            if (z16 && !field.isAccessible()) {
                field.setAccessible(true);
            } else {
                MemberUtils.setAccessibleWorkaround(field);
            }
            field.set(obj, obj2);
            return;
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    public static void writeStaticField(Field field, Object obj, boolean z16) throws IllegalAccessException {
        if (field != null) {
            if (Modifier.isStatic(field.getModifiers())) {
                writeField(field, (Object) null, obj, z16);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The field '");
            stringBuffer.append(field.getName());
            stringBuffer.append("' is not static");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    public static Field getField(Class cls, String str, boolean z16) {
        Field field;
        Field declaredField;
        if (cls == null) {
            throw new IllegalArgumentException("The class must not be null");
        }
        if (str != null) {
            for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                try {
                    declaredField = cls2.getDeclaredField(str);
                } catch (NoSuchFieldException unused) {
                }
                if (!Modifier.isPublic(declaredField.getModifiers())) {
                    if (z16) {
                        declaredField.setAccessible(true);
                    } else {
                        continue;
                    }
                }
                return declaredField;
            }
            Iterator it = ClassUtils.getAllInterfaces(cls).iterator();
            Field field2 = null;
            while (it.hasNext()) {
                try {
                    field = ((Class) it.next()).getField(str);
                } catch (NoSuchFieldException unused2) {
                }
                if (field2 != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Reference to field ");
                    stringBuffer.append(str);
                    stringBuffer.append(" is ambiguous relative to ");
                    stringBuffer.append(cls);
                    stringBuffer.append("; a matching field exists on two or more implemented interfaces.");
                    throw new IllegalArgumentException(stringBuffer.toString());
                    break;
                }
                field2 = field;
            }
            return field2;
        }
        throw new IllegalArgumentException("The field name must not be null");
    }

    public static Object readStaticField(Class cls, String str) throws IllegalAccessException {
        return readStaticField(cls, str, false);
    }

    public static void writeStaticField(Class cls, String str, Object obj) throws IllegalAccessException {
        writeStaticField(cls, str, obj, false);
    }

    public static Object readField(Object obj, String str) throws IllegalAccessException {
        return readField(obj, str, false);
    }

    public static Object readStaticField(Class cls, String str, boolean z16) throws IllegalAccessException {
        Field field = getField(cls, str, z16);
        if (field != null) {
            return readStaticField(field, false);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cannot locate field ");
        stringBuffer.append(str);
        stringBuffer.append(" on ");
        stringBuffer.append(cls);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public static void writeField(Object obj, String str, Object obj2) throws IllegalAccessException {
        writeField(obj, str, obj2, false);
    }

    public static void writeStaticField(Class cls, String str, Object obj, boolean z16) throws IllegalAccessException {
        Field field = getField(cls, str, z16);
        if (field != null) {
            writeStaticField(field, obj);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cannot locate field ");
        stringBuffer.append(str);
        stringBuffer.append(" on ");
        stringBuffer.append(cls);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public static Object readField(Object obj, String str, boolean z16) throws IllegalAccessException {
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Field field = getField(cls, str, z16);
            if (field != null) {
                return readField(field, obj);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot locate field ");
            stringBuffer.append(str);
            stringBuffer.append(" on ");
            stringBuffer.append(cls);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        throw new IllegalArgumentException("target object must not be null");
    }

    public static void writeField(Object obj, String str, Object obj2, boolean z16) throws IllegalAccessException {
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Field field = getField(cls, str, z16);
            if (field != null) {
                writeField(field, obj, obj2);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot locate declared field ");
            stringBuffer.append(cls.getName());
            stringBuffer.append(".");
            stringBuffer.append(str);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        throw new IllegalArgumentException("target object must not be null");
    }
}
