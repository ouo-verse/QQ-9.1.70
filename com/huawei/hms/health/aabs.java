package com.huawei.hms.health;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aabs {
    private static int aab(Parcel parcel, int i3) {
        return (i3 | 65535) != 65535 ? (i3 >> 16) & 65535 : parcel.readInt();
    }

    private static Object aaba(Field field, Parcel parcel, int i3) {
        switch (aabu.aab(field).ordinal()) {
            case 15:
                return Integer.valueOf(SafeParcelReader.readInt(parcel, i3));
            case 16:
                return Long.valueOf(SafeParcelReader.readLong(parcel, i3));
            case 17:
                return Character.valueOf(SafeParcelReader.readChar(parcel, i3));
            case 18:
                return Boolean.valueOf(SafeParcelReader.readBoolean(parcel, i3));
            case 19:
                return Float.valueOf(SafeParcelReader.readFloat(parcel, i3));
            case 20:
                return Double.valueOf(SafeParcelReader.readDouble(parcel, i3));
            case 21:
            case 22:
            default:
                return null;
            case 23:
                return Byte.valueOf(SafeParcelReader.readByte(parcel, i3));
            case 24:
                return Short.valueOf(SafeParcelReader.readShort(parcel, i3));
        }
    }

    private static Object aabb(Field field, Parcel parcel, int i3) {
        switch (aabu.aab(field).ordinal()) {
            case 5:
                Parcelable.Creator<Parcelable> aab = aab(field);
                int aab2 = aab(parcel, i3);
                int dataPosition = parcel.dataPosition();
                if (aab2 == 0) {
                    return aab.newArray(0);
                }
                int readInt = parcel.readInt();
                Object[] createTypedArray = parcel.createTypedArray(aab);
                parcel.setDataPosition(dataPosition + readInt);
                return createTypedArray;
            case 6:
                return SafeParcelReader.createStringArray(parcel, i3);
            case 7:
                return SafeParcelReader.createByteArray(parcel, i3);
            case 8:
            default:
                return null;
            case 9:
                return SafeParcelReader.createIntArray(parcel, i3);
            case 10:
                return SafeParcelReader.createLongArray(parcel, i3);
            case 11:
                return SafeParcelReader.createFloatArray(parcel, i3);
            case 12:
                return SafeParcelReader.createDoubleArray(parcel, i3);
            case 13:
                return SafeParcelReader.createCharArray(parcel, i3);
            case 14:
                return SafeParcelReader.createBooleanArray(parcel, i3);
        }
    }

    private static int aab(Parcel parcel, int i3, int i16) {
        if (i16 == 0 || i16 >= 65535) {
            parcel.writeInt(i3 & 65535);
            parcel.writeInt(i16);
        } else {
            parcel.writeInt(i3 | (i16 << 16));
        }
        return parcel.dataPosition();
    }

    private static void aaba(Parcel parcel, int i3) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i3);
        parcel.writeInt(dataPosition - i3);
        parcel.setDataPosition(dataPosition);
    }

    static Parcelable.Creator<Parcelable> aab(Class cls) {
        try {
            Field declaredField = cls.getDeclaredField("CREATOR");
            AccessController.doPrivileged(new aabt(declaredField));
            return (Parcelable.Creator) declaredField.get(null);
        } catch (IllegalAccessException unused) {
            aabz.aab("SafeParcelUtil", cls + " CREATOR is not useable");
            throw new IllegalArgumentException(cls + " CREATOR is not useable");
        } catch (NoSuchFieldException unused2) {
            aabz.aab("SafeParcelUtil", "not CREATOR in " + cls);
            throw new IllegalArgumentException("not CREATOR in " + cls);
        }
    }

    static Parcelable.Creator<Parcelable> aab(Field field) {
        Class<?> type = field.getType();
        if (type.isArray()) {
            type = type.getComponentType();
        }
        if (type != null && Parcelable.class.isAssignableFrom(type)) {
            return aab(type);
        }
        aabz.aab("SafeParcelUtil", type + " not have Parcelable Field");
        throw new IllegalStateException(type + " not have Parcelable Field");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v4, types: [android.os.Parcelable] */
    public static <T extends Parcelable> T aab(Class<T> cls, Parcel parcel) {
        String str;
        T t16 = null;
        try {
            HashMap hashMap = new HashMap();
            Class<T> cls2 = cls;
            while (true) {
                int i3 = 0;
                if (cls2 != null) {
                    Field[] declaredFields = cls2.getDeclaredFields();
                    int length = declaredFields.length;
                    while (i3 < length) {
                        Field field = declaredFields[i3];
                        if (field.isAnnotationPresent(aaby.class)) {
                            int id5 = ((aaby) field.getAnnotation(aaby.class)).id();
                            if (hashMap.containsKey(Integer.valueOf(id5))) {
                                aabz.aab("SafeParcelUtil", "Field of " + field.getName() + " (" + id5 + ") in " + cls2.getName() + " is repeat of " + ((Field) hashMap.get(Integer.valueOf(id5))).getName());
                                return null;
                            }
                            hashMap.put(Integer.valueOf(id5), field);
                        }
                        i3++;
                    }
                    cls2 = cls2.getSuperclass();
                } else {
                    hashMap.size();
                    cls.getName();
                    Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
                    int length2 = declaredConstructors.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length2) {
                            break;
                        }
                        Constructor<?> constructor = declaredConstructors[i16];
                        boolean isAccessible = constructor.isAccessible();
                        constructor.setAccessible(true);
                        if (constructor.isAnnotationPresent(aabw.class)) {
                            t16 = (Parcelable) constructor.newInstance(aab(hashMap, constructor.getParameterAnnotations(), parcel));
                            i3 = 1;
                            break;
                        }
                        constructor.setAccessible(isAccessible);
                        i16++;
                    }
                    if (i3 == 0) {
                        aabz.aab("SafeParcelUtil", "[createObject] not find Constructor of " + cls.getName());
                    }
                }
            }
        } catch (IllegalAccessException unused) {
            str = "Encountered an IllegalAccessException";
            aabz.aab("SafeParcelUtil", str);
            return t16;
        } catch (InstantiationException unused2) {
            str = "Encountered an InstantiationException";
            aabz.aab("SafeParcelUtil", str);
            return t16;
        } catch (InvocationTargetException unused3) {
            str = "Encountered an InvocationTargetException";
            aabz.aab("SafeParcelUtil", str);
            return t16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class aab(Field field, int i3) {
        Type type;
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            if (parameterizedType.getActualTypeArguments().length >= 1 && i3 < parameterizedType.getActualTypeArguments().length && i3 >= 0) {
                type = parameterizedType.getActualTypeArguments()[i3];
                if (type instanceof Class) {
                    return (Class) type;
                }
                return (Class) type;
            }
        }
        type = null;
        return (Class) type;
    }

    private static Object aab(Parcel parcel, Field field, int i3) throws IllegalAccessException {
        boolean isAccessible = field.isAccessible();
        boolean CanBeNull = field.getAnnotation(aaby.class) != null ? ((aaby) field.getAnnotation(aaby.class)).CanBeNull() : true;
        field.setAccessible(true);
        try {
            Object aab = aab(field, parcel, i3, CanBeNull);
            if (aab != null) {
                return aab;
            }
            Object aabb = aabb(field, parcel, i3);
            if (aabb != null) {
                return aabb;
            }
            Object aaba = aaba(field, parcel, i3);
            return aaba != null ? aaba : aab(field, parcel, i3);
        } finally {
            field.setAccessible(isAccessible);
        }
    }

    private static Object aab(Field field, Parcel parcel, int i3, boolean z16) throws IllegalAccessException {
        int ordinal = aabu.aab(field).ordinal();
        if (ordinal == 0) {
            return SafeParcelReader.createParcelable(parcel, i3, aab(field));
        }
        boolean z17 = true;
        if (ordinal == 1) {
            return SafeParcelReader.readIBinder(parcel, i3);
        }
        if (ordinal == 4) {
            return SafeParcelReader.createBundle(parcel, i3);
        }
        Object obj = null;
        if (ordinal != 8) {
            return null;
        }
        Class<?>[] declaredClasses = field.getType().getDeclaredClasses();
        int length = declaredClasses.length;
        int i16 = 0;
        while (true) {
            if (i16 >= length) {
                z17 = false;
                break;
            }
            Class<?> cls = declaredClasses[i16];
            try {
                IBinder readIBinder = SafeParcelReader.readIBinder(parcel, i3);
                if (readIBinder != null) {
                    obj = cls.getDeclaredMethod("asInterface", IBinder.class).invoke(null, readIBinder);
                    break;
                }
                break;
            } catch (NoSuchMethodException | InvocationTargetException unused) {
                aabz.aab("SafeParcelUtil", "[readObjectField] readIBinder Exception, ignore");
                i16++;
            }
        }
        if (z17 || z16) {
            return obj;
        }
        throw new IllegalStateException("[interface] Field illegal : " + field);
    }

    private static <T> void aab(Parcel parcel, T t16, int i3) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        if (t16 instanceof Parcelable) {
            ((Parcelable) t16).writeToParcel(parcel, i3);
        } else {
            parcel.writeValue(t16);
        }
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void aab(Parcelable parcelable, Parcel parcel, int i3) {
        int i16;
        parcelable.getClass();
        HashMap hashMap = new HashMap();
        Class<?> cls = parcelable.getClass();
        while (true) {
            i16 = 0;
            if (cls == null) {
                break;
            }
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            while (i16 < length) {
                Field field = declaredFields[i16];
                if (field != null && field.isAnnotationPresent(aaby.class)) {
                    int id5 = ((aaby) field.getAnnotation(aaby.class)).id();
                    if (hashMap.get(Integer.valueOf(id5)) != null) {
                        StringBuilder aab = aab.aab("Field of ");
                        aab.append(field.getName());
                        aab.append("(");
                        aab.append(id5);
                        aab.append(") repeat with ");
                        aab.append(((Field) hashMap.get(Integer.valueOf(id5))).getName());
                        aab.append(" in ");
                        aab.append(cls.getName());
                        aabz.aab("SafeParcelUtil", aab.toString());
                    } else {
                        hashMap.put(Integer.valueOf(id5), field);
                    }
                }
                i16++;
            }
            cls = cls.getSuperclass();
        }
        Object[] array = hashMap.keySet().toArray();
        Arrays.sort(array);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int length2 = array.length;
        while (i16 < length2) {
            try {
                aab(parcelable, parcel, (Field) hashMap.get(array[i16]), i3);
            } catch (Exception unused) {
                aabz.aab("SafeParcelUtil", "write Object Field Exception");
            }
            i16++;
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private static boolean aab(Object obj, int i3, Parcel parcel, aabu aabuVar) {
        switch (aabuVar.ordinal()) {
            case 15:
                SafeParcelWriter.writeInt(parcel, i3, ((Integer) obj).intValue());
                return true;
            case 16:
                SafeParcelWriter.writeLong(parcel, i3, ((Long) obj).longValue());
                return true;
            case 17:
                SafeParcelWriter.writeChar(parcel, i3, ((Character) obj).charValue());
                return true;
            case 18:
                SafeParcelWriter.writeBoolean(parcel, i3, ((Boolean) obj).booleanValue());
                return true;
            case 19:
                SafeParcelWriter.writeFloat(parcel, i3, ((Float) obj).floatValue());
                return true;
            case 20:
                SafeParcelWriter.writeDouble(parcel, i3, ((Double) obj).doubleValue());
                return true;
            case 21:
            case 22:
            default:
                return false;
            case 23:
                SafeParcelWriter.writeByte(parcel, i3, ((Byte) obj).byteValue());
                return true;
            case 24:
                SafeParcelWriter.writeShort(parcel, i3, ((Short) obj).shortValue());
                return true;
        }
    }

    private static <T> T aab(Parcel parcel, Class cls) {
        if (parcel.readInt() == 0) {
            return null;
        }
        if (cls == null || !Parcelable.class.isAssignableFrom(cls)) {
            return (T) parcel.readValue((cls == null || cls.getClassLoader() == null) ? ClassLoader.getSystemClassLoader() : cls.getClassLoader());
        }
        if (aab(cls) != null) {
            return (T) aab(cls).createFromParcel(parcel);
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x004d. Please report as an issue. */
    private static Object[] aab(Map<Integer, Field> map, Annotation[][] annotationArr, Parcel parcel) {
        int i3;
        String str;
        int i16;
        Object[] objArr = new Object[annotationArr.length];
        HashMap hashMap = new HashMap();
        int i17 = 0;
        for (int i18 = 0; i18 < annotationArr.length; i18++) {
            Object obj = null;
            objArr[i18] = null;
            Annotation[] annotationArr2 = annotationArr[i18];
            int length = annotationArr2.length;
            int i19 = 0;
            while (true) {
                if (i19 < length) {
                    Annotation annotation = annotationArr2[i19];
                    if (annotation instanceof aabv) {
                        i16 = ((aabv) annotation).id();
                    } else {
                        i19++;
                    }
                } else {
                    i16 = -1;
                }
            }
            if (i16 > 0 && i16 <= 10000 && map.get(Integer.valueOf(i16)) != null) {
                Field field = map.get(Integer.valueOf(i16));
                switch (aabu.aab(field).ordinal()) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 21:
                    case 22:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                        objArr[i18] = obj;
                        hashMap.put(Integer.valueOf(i16), Integer.valueOf(i18));
                        break;
                    case 15:
                        obj = -1;
                        objArr[i18] = obj;
                        hashMap.put(Integer.valueOf(i16), Integer.valueOf(i18));
                        break;
                    case 16:
                        obj = -1L;
                        objArr[i18] = obj;
                        hashMap.put(Integer.valueOf(i16), Integer.valueOf(i18));
                        break;
                    case 17:
                    case 23:
                    case 24:
                        obj = 0;
                        objArr[i18] = obj;
                        hashMap.put(Integer.valueOf(i16), Integer.valueOf(i18));
                        break;
                    case 18:
                        obj = Boolean.FALSE;
                        objArr[i18] = obj;
                        hashMap.put(Integer.valueOf(i16), Integer.valueOf(i18));
                        break;
                    case 19:
                        obj = Float.valueOf(-1.0f);
                        objArr[i18] = obj;
                        hashMap.put(Integer.valueOf(i16), Integer.valueOf(i18));
                        break;
                    case 20:
                        obj = Double.valueOf(-1.0d);
                        objArr[i18] = obj;
                        hashMap.put(Integer.valueOf(i16), Integer.valueOf(i18));
                        break;
                    default:
                        StringBuilder aab = aab.aab("Unexpected value : ");
                        aab.append(aabu.aab(field));
                        aabz.aab("SafeParcelUtil", aab.toString());
                        StringBuilder aab2 = aab.aab("Unexpected value : ");
                        aab2.append(aabu.aab(field));
                        throw new IllegalStateException(aab2.toString());
                }
            }
        }
        aab.aab("idAndIndexMap size : ").append(hashMap.size());
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        while (true) {
            i3 = i17 + 1;
            if (i17 <= validateObjectHeader && parcel.dataPosition() < validateObjectHeader) {
                int readHeader = SafeParcelReader.readHeader(parcel);
                int fieldId = SafeParcelReader.getFieldId(readHeader);
                Field field2 = map.get(Integer.valueOf(fieldId));
                if (field2 == null || fieldId <= 0 || fieldId > 10000 || !hashMap.containsKey(Integer.valueOf(fieldId))) {
                    str = "skip Unknown fieldId : " + fieldId;
                } else {
                    try {
                        objArr[((Integer) hashMap.get(Integer.valueOf(fieldId))).intValue()] = aab(parcel, field2, readHeader);
                        field2.getName();
                    } catch (IllegalAccessException | IllegalStateException unused) {
                        str = "skip Error field : " + fieldId + "(" + field2.getName() + ")";
                    }
                    i17 = i3;
                }
                aabz.aab("SafeParcelUtil", str);
                SafeParcelReader.skipUnknownField(parcel, readHeader);
                i17 = i3;
            }
        }
        if (i3 > validateObjectHeader) {
            aabz.aab("SafeParcelUtil", "Max loop reached, readParcelObject parcel failed");
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return objArr;
    }

    private static Object aab(Field field, Parcel parcel, int i3) {
        int ordinal = aabu.aab(field).ordinal();
        if (ordinal == 2) {
            return SafeParcelReader.createStringList(parcel, i3);
        }
        if (ordinal == 3) {
            Class aab = aab(field, 0);
            if (aab != null && Parcelable.class.isAssignableFrom(aab)) {
                return SafeParcelReader.createTypedList(parcel, i3, aab(aab));
            }
            ArrayList arrayList = new ArrayList();
            SafeParcelReader.readList(parcel, i3, arrayList, (aab == null || aab.getClassLoader() == null) ? ClassLoader.getSystemClassLoader() : aab.getClassLoader());
            return arrayList;
        }
        if (ordinal == 21) {
            return SafeParcelReader.createString(parcel, i3);
        }
        if (ordinal != 22) {
            switch (ordinal) {
                case 25:
                    return SafeParcelReader.readIntegerObject(parcel, i3);
                case 26:
                    return SafeParcelReader.readLongObject(parcel, i3);
                case 27:
                    return SafeParcelReader.readFloatObject(parcel, i3);
                case 28:
                    return SafeParcelReader.readDoubleObject(parcel, i3);
                case 29:
                    return SafeParcelReader.readBooleanObject(parcel, i3);
                default:
                    StringBuilder aab2 = aab.aab("Unexpected value\uff08or value is null\uff09: ");
                    aab2.append(aabu.aab(field));
                    aabz.aabc("SafeParcelUtil", aab2.toString());
                    return null;
            }
        }
        int aab3 = aab(parcel, i3);
        int dataPosition = parcel.dataPosition();
        if (aab3 == 0) {
            return Collections.emptyMap();
        }
        int readInt = parcel.readInt();
        HashMap hashMap = new HashMap();
        for (int i16 = 0; i16 < aab3; i16++) {
            hashMap.put(aab(parcel, aab(field, 0)), aab(parcel, aab(field, 1)));
        }
        parcel.setDataPosition(dataPosition + readInt);
        return hashMap;
    }

    private static boolean aab(Object obj, int i3, boolean z16, Parcel parcel, Field field, int i16) {
        int ordinal = aabu.aab(field).ordinal();
        if (ordinal == 8) {
            SafeParcelWriter.writeIBinder(parcel, i3, obj == null ? null : ((IInterface) obj).asBinder(), z16);
        } else if (ordinal == 22) {
            Map map = (Map) obj;
            if (map != null) {
                int aab = aab(parcel, i3, map.size());
                if (map.size() != 0) {
                    parcel.writeInt(aab);
                    for (Map.Entry entry : map.entrySet()) {
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        aab(parcel, key, i16);
                        if (value == null) {
                            parcel.writeInt(0);
                        } else {
                            aab(parcel, value, i16);
                        }
                    }
                    aaba(parcel, aab);
                }
            }
        } else if (ordinal == 0) {
            SafeParcelWriter.writeParcelable(parcel, i3, (Parcelable) obj, i16, z16);
        } else if (ordinal == 1) {
            SafeParcelWriter.writeIBinder(parcel, i3, (IBinder) obj, z16);
        } else if (ordinal == 2) {
            SafeParcelWriter.writeStringList(parcel, i3, (List) obj, z16);
        } else if (ordinal == 3) {
            Class aab2 = aab(field, 0);
            if (aab2 == null || !Parcelable.class.isAssignableFrom(aab2)) {
                SafeParcelWriter.writeList(parcel, i3, (List) obj, z16);
            } else {
                SafeParcelWriter.writeTypedList(parcel, i3, (List) obj, z16);
            }
        } else {
            if (ordinal != 4) {
                return false;
            }
            SafeParcelWriter.writeBundle(parcel, i3, (Bundle) obj, z16);
        }
        return true;
    }

    private static boolean aab(Object obj, int i3, boolean z16, Parcel parcel, aabu aabuVar, int i16) {
        switch (aabuVar.ordinal()) {
            case 5:
                Parcelable[] parcelableArr = (Parcelable[]) obj;
                if (parcelableArr == null) {
                    return true;
                }
                int aab = aab(parcel, i3, parcelableArr.length);
                if (parcelableArr.length == 0) {
                    return true;
                }
                parcel.writeInt(aab);
                parcel.writeInt(parcelableArr.length);
                for (Parcelable parcelable : parcelableArr) {
                    if (parcelable == null) {
                        parcel.writeInt(0);
                    } else {
                        aab(parcel, parcelable, i16);
                    }
                }
                aaba(parcel, aab);
                return true;
            case 6:
                SafeParcelWriter.writeStringArray(parcel, i3, (String[]) obj, z16);
                return true;
            case 7:
                SafeParcelWriter.writeByteArray(parcel, i3, (byte[]) obj, z16);
                return true;
            case 8:
            default:
                return false;
            case 9:
                SafeParcelWriter.writeIntArray(parcel, i3, (int[]) obj, z16);
                return true;
            case 10:
                SafeParcelWriter.writeLongArray(parcel, i3, (long[]) obj, z16);
                return true;
            case 11:
                SafeParcelWriter.writeFloatArray(parcel, i3, (float[]) obj, z16);
                return true;
            case 12:
                SafeParcelWriter.writeDoubleArray(parcel, i3, (double[]) obj, z16);
                return true;
            case 13:
                SafeParcelWriter.writeCharArray(parcel, i3, (char[]) obj, z16);
                return true;
            case 14:
                SafeParcelWriter.writeBooleanArray(parcel, i3, (boolean[]) obj, z16);
                return true;
        }
    }

    private static void aab(Parcelable parcelable, Parcel parcel, Field field, int i3) throws IllegalAccessException {
        aaby aabyVar = (aaby) field.getAnnotation(aaby.class);
        if (aabyVar == null) {
            aabz.aab("SafeParcelUtil", "getFieldId IllegalStateException");
            throw new IllegalStateException();
        }
        int id5 = aabyVar.id();
        if (id5 <= 0 || id5 > 10000) {
            aabz.aab("SafeParcelUtil", "fieldId Must be in the range of 1-10000, failed fieldId : " + id5);
            return;
        }
        boolean isAccessible = field.isAccessible();
        boolean CanBeNull = field.getAnnotation(aaby.class) != null ? ((aaby) field.getAnnotation(aaby.class)).CanBeNull() : true;
        field.setAccessible(true);
        try {
            Object obj = field.get(parcelable);
            aabu aab = aabu.aab(field);
            if (aab(obj, id5, CanBeNull, parcel, field, i3)) {
                return;
            }
            if (aab(obj, id5, CanBeNull, parcel, aab, i3)) {
                return;
            }
            if (aab(obj, id5, parcel, aab)) {
                return;
            }
            int ordinal = aab.ordinal();
            if (ordinal != 21) {
                switch (ordinal) {
                    case 25:
                        SafeParcelWriter.writeIntegerObject(parcel, id5, (Integer) obj, CanBeNull);
                        break;
                    case 26:
                        SafeParcelWriter.writeLongObject(parcel, id5, (Long) obj, CanBeNull);
                        break;
                    case 27:
                        SafeParcelWriter.writeFloatObject(parcel, id5, (Float) obj, CanBeNull);
                        break;
                    case 28:
                        SafeParcelWriter.writeDoubleObject(parcel, id5, (Double) obj, CanBeNull);
                        break;
                    case 29:
                        SafeParcelWriter.writeBooleanObject(parcel, id5, (Boolean) obj, CanBeNull);
                        break;
                    default:
                        aabz.aab("SafeParcelUtil", "[writeObjectField] cant find fit case");
                        break;
                }
            } else {
                SafeParcelWriter.writeString(parcel, id5, (String) obj, CanBeNull);
            }
        } finally {
            field.setAccessible(isAccessible);
        }
    }
}
