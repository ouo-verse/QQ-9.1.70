package org.apache.commons.lang;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ArrayUtils {
    public static final int INDEX_NOT_FOUND = -1;
    static /* synthetic */ Class class$java$lang$Object;
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    public static final Class[] EMPTY_CLASS_ARRAY = new Class[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];

    public static Object[] add(Object[] objArr, Object obj) {
        Class<?> cls;
        if (objArr != null) {
            cls = objArr.getClass();
        } else if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = class$java$lang$Object;
            if (cls == null) {
                cls = class$("java.lang.Object");
                class$java$lang$Object = cls;
            }
        }
        Object[] objArr2 = (Object[]) copyArrayGrow1(objArr, cls);
        objArr2[objArr2.length - 1] = obj;
        return objArr2;
    }

    public static Object[] addAll(Object[] objArr, Object[] objArr2) {
        if (objArr == null) {
            return clone(objArr2);
        }
        if (objArr2 == null) {
            return clone(objArr);
        }
        Object[] objArr3 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length + objArr2.length);
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        try {
            System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
            return objArr3;
        } catch (ArrayStoreException e16) {
            Class<?> componentType = objArr.getClass().getComponentType();
            Class<?> componentType2 = objArr2.getClass().getComponentType();
            if (!componentType.isAssignableFrom(componentType2)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Cannot store ");
                stringBuffer.append(componentType2.getName());
                stringBuffer.append(" in an array of ");
                stringBuffer.append(componentType.getName());
                throw new IllegalArgumentException(stringBuffer.toString());
            }
            throw e16;
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e16) {
            throw new NoClassDefFoundError(e16.getMessage());
        }
    }

    public static Object[] clone(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        return (Object[]) objArr.clone();
    }

    public static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    private static Object copyArrayGrow1(Object obj, Class cls) {
        if (obj != null) {
            int length = Array.getLength(obj);
            Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + 1);
            System.arraycopy(obj, 0, newInstance, 0, length);
            return newInstance;
        }
        return Array.newInstance((Class<?>) cls, 1);
    }

    public static int getLength(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    public static int hashCode(Object obj) {
        return new HashCodeBuilder().append(obj).toHashCode();
    }

    public static int indexOf(Object[] objArr, Object obj) {
        return indexOf(objArr, obj, 0);
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean isEquals(Object obj, Object obj2) {
        return new EqualsBuilder().append(obj, obj2).isEquals();
    }

    public static boolean isNotEmpty(Object[] objArr) {
        return (objArr == null || objArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        if (objArr == null && objArr2 != null && objArr2.length > 0) {
            return false;
        }
        if (objArr2 != null || objArr == null || objArr.length <= 0) {
            return objArr == null || objArr2 == null || objArr.length == objArr2.length;
        }
        return false;
    }

    public static boolean isSameType(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            return obj.getClass().getName().equals(obj2.getClass().getName());
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static int lastIndexOf(Object[] objArr, Object obj) {
        return lastIndexOf(objArr, obj, Integer.MAX_VALUE);
    }

    public static Object[] nullToEmpty(Object[] objArr) {
        return (objArr == null || objArr.length == 0) ? EMPTY_OBJECT_ARRAY : objArr;
    }

    public static Object[] remove(Object[] objArr, int i3) {
        return (Object[]) remove((Object) objArr, i3);
    }

    public static Object[] removeElement(Object[] objArr, Object obj) {
        int indexOf = indexOf(objArr, obj);
        if (indexOf == -1) {
            return clone(objArr);
        }
        return remove(objArr, indexOf);
    }

    public static void reverse(Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length - 1;
        for (int i3 = 0; length > i3; i3++) {
            Object obj = objArr[length];
            objArr[length] = objArr[i3];
            objArr[i3] = obj;
            length--;
        }
    }

    public static Object[] subarray(Object[] objArr, int i3, int i16) {
        if (objArr == null) {
            return null;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 > objArr.length) {
            i16 = objArr.length;
        }
        int i17 = i16 - i3;
        Class<?> componentType = objArr.getClass().getComponentType();
        if (i17 <= 0) {
            return (Object[]) Array.newInstance(componentType, 0);
        }
        Object[] objArr2 = (Object[]) Array.newInstance(componentType, i17);
        System.arraycopy(objArr, i3, objArr2, 0, i17);
        return objArr2;
    }

    public static Map toMap(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap((int) (objArr.length * 1.5d));
        for (int i3 = 0; i3 < objArr.length; i3++) {
            Object obj = objArr[i3];
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                hashMap.put(entry.getKey(), entry.getValue());
            } else if (obj instanceof Object[]) {
                Object[] objArr2 = (Object[]) obj;
                if (objArr2.length >= 2) {
                    hashMap.put(objArr2[0], objArr2[1]);
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Array element ");
                    stringBuffer.append(i3);
                    stringBuffer.append(", '");
                    stringBuffer.append(obj);
                    stringBuffer.append("', has a length less than 2");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Array element ");
                stringBuffer2.append(i3);
                stringBuffer2.append(", '");
                stringBuffer2.append(obj);
                stringBuffer2.append("', is neither of type Map.Entry nor an Array");
                throw new IllegalArgumentException(stringBuffer2.toString());
            }
        }
        return hashMap;
    }

    public static Character[] toObject(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        if (cArr.length == 0) {
            return EMPTY_CHARACTER_OBJECT_ARRAY;
        }
        Character[] chArr = new Character[cArr.length];
        for (int i3 = 0; i3 < cArr.length; i3++) {
            chArr[i3] = new Character(cArr[i3]);
        }
        return chArr;
    }

    public static char[] toPrimitive(Character[] chArr) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[chArr.length];
        for (int i3 = 0; i3 < chArr.length; i3++) {
            cArr[i3] = chArr[i3].charValue();
        }
        return cArr;
    }

    public static String toString(Object obj) {
        return toString(obj, "{}");
    }

    public static long[] clone(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public static boolean contains(long[] jArr, long j3) {
        return indexOf(jArr, j3) != -1;
    }

    public static int indexOf(Object[] objArr, Object obj, int i3) {
        if (objArr == null) {
            return -1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (obj == null) {
            while (i3 < objArr.length) {
                if (objArr[i3] == null) {
                    return i3;
                }
                i3++;
            }
        } else if (objArr.getClass().getComponentType().isInstance(obj)) {
            while (i3 < objArr.length) {
                if (obj.equals(objArr[i3])) {
                    return i3;
                }
                i3++;
            }
        }
        return -1;
    }

    public static boolean isEmpty(long[] jArr) {
        return jArr == null || jArr.length == 0;
    }

    public static boolean isNotEmpty(long[] jArr) {
        return (jArr == null || jArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(long[] jArr, long[] jArr2) {
        if (jArr == null && jArr2 != null && jArr2.length > 0) {
            return false;
        }
        if (jArr2 != null || jArr == null || jArr.length <= 0) {
            return jArr == null || jArr2 == null || jArr.length == jArr2.length;
        }
        return false;
    }

    public static int lastIndexOf(Object[] objArr, Object obj, int i3) {
        if (objArr == null || i3 < 0) {
            return -1;
        }
        if (i3 >= objArr.length) {
            i3 = objArr.length - 1;
        }
        if (obj == null) {
            while (i3 >= 0) {
                if (objArr[i3] == null) {
                    return i3;
                }
                i3--;
            }
        } else if (objArr.getClass().getComponentType().isInstance(obj)) {
            while (i3 >= 0) {
                if (obj.equals(objArr[i3])) {
                    return i3;
                }
                i3--;
            }
        }
        return -1;
    }

    public static boolean[] remove(boolean[] zArr, int i3) {
        return (boolean[]) remove((Object) zArr, i3);
    }

    public static String toString(Object obj, String str) {
        return obj == null ? str : new ToStringBuilder(obj, ToStringStyle.SIMPLE_STYLE).append(obj).toString();
    }

    public static int[] clone(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public static boolean contains(int[] iArr, int i3) {
        return indexOf(iArr, i3) != -1;
    }

    public static boolean isEmpty(int[] iArr) {
        return iArr == null || iArr.length == 0;
    }

    public static boolean isNotEmpty(int[] iArr) {
        return (iArr == null || iArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(int[] iArr, int[] iArr2) {
        if (iArr == null && iArr2 != null && iArr2.length > 0) {
            return false;
        }
        if (iArr2 != null || iArr == null || iArr.length <= 0) {
            return iArr == null || iArr2 == null || iArr.length == iArr2.length;
        }
        return false;
    }

    public static String[] nullToEmpty(String[] strArr) {
        return (strArr == null || strArr.length == 0) ? EMPTY_STRING_ARRAY : strArr;
    }

    public static byte[] remove(byte[] bArr, int i3) {
        return (byte[]) remove((Object) bArr, i3);
    }

    public static short[] clone(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return (short[]) sArr.clone();
    }

    public static boolean contains(short[] sArr, short s16) {
        return indexOf(sArr, s16) != -1;
    }

    public static boolean isEmpty(short[] sArr) {
        return sArr == null || sArr.length == 0;
    }

    public static boolean isNotEmpty(short[] sArr) {
        return (sArr == null || sArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(short[] sArr, short[] sArr2) {
        if (sArr == null && sArr2 != null && sArr2.length > 0) {
            return false;
        }
        if (sArr2 != null || sArr == null || sArr.length <= 0) {
            return sArr == null || sArr2 == null || sArr.length == sArr2.length;
        }
        return false;
    }

    public static char[] remove(char[] cArr, int i3) {
        return (char[]) remove((Object) cArr, i3);
    }

    public static boolean[] removeElement(boolean[] zArr, boolean z16) {
        int indexOf = indexOf(zArr, z16);
        if (indexOf == -1) {
            return clone(zArr);
        }
        return remove(zArr, indexOf);
    }

    public static char[] clone(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return (char[]) cArr.clone();
    }

    public static boolean contains(char[] cArr, char c16) {
        return indexOf(cArr, c16) != -1;
    }

    public static boolean isEmpty(char[] cArr) {
        return cArr == null || cArr.length == 0;
    }

    public static boolean isNotEmpty(char[] cArr) {
        return (cArr == null || cArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(char[] cArr, char[] cArr2) {
        if (cArr == null && cArr2 != null && cArr2.length > 0) {
            return false;
        }
        if (cArr2 != null || cArr == null || cArr.length <= 0) {
            return cArr == null || cArr2 == null || cArr.length == cArr2.length;
        }
        return false;
    }

    public static long[] nullToEmpty(long[] jArr) {
        return (jArr == null || jArr.length == 0) ? EMPTY_LONG_ARRAY : jArr;
    }

    public static double[] remove(double[] dArr, int i3) {
        return (double[]) remove((Object) dArr, i3);
    }

    public static void reverse(long[] jArr) {
        if (jArr == null) {
            return;
        }
        int length = jArr.length - 1;
        for (int i3 = 0; length > i3; i3++) {
            long j3 = jArr[length];
            jArr[length] = jArr[i3];
            jArr[i3] = j3;
            length--;
        }
    }

    public static boolean[] add(boolean[] zArr, boolean z16) {
        boolean[] zArr2 = (boolean[]) copyArrayGrow1(zArr, Boolean.TYPE);
        zArr2[zArr2.length - 1] = z16;
        return zArr2;
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static boolean contains(byte[] bArr, byte b16) {
        return indexOf(bArr, b16) != -1;
    }

    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static boolean isNotEmpty(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 != null && bArr2.length > 0) {
            return false;
        }
        if (bArr2 != null || bArr == null || bArr.length <= 0) {
            return bArr == null || bArr2 == null || bArr.length == bArr2.length;
        }
        return false;
    }

    public static float[] remove(float[] fArr, int i3) {
        return (float[]) remove((Object) fArr, i3);
    }

    public static Long[] toObject(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        if (jArr.length == 0) {
            return EMPTY_LONG_OBJECT_ARRAY;
        }
        Long[] lArr = new Long[jArr.length];
        for (int i3 = 0; i3 < jArr.length; i3++) {
            lArr[i3] = new Long(jArr[i3]);
        }
        return lArr;
    }

    public static char[] toPrimitive(Character[] chArr, char c16) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[chArr.length];
        for (int i3 = 0; i3 < chArr.length; i3++) {
            Character ch5 = chArr[i3];
            cArr[i3] = ch5 == null ? c16 : ch5.charValue();
        }
        return cArr;
    }

    public static double[] clone(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        return (double[]) dArr.clone();
    }

    public static boolean contains(double[] dArr, double d16) {
        return indexOf(dArr, d16) != -1;
    }

    public static int indexOf(long[] jArr, long j3) {
        return indexOf(jArr, j3, 0);
    }

    public static boolean isEmpty(double[] dArr) {
        return dArr == null || dArr.length == 0;
    }

    public static boolean isNotEmpty(double[] dArr) {
        return (dArr == null || dArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(double[] dArr, double[] dArr2) {
        if (dArr == null && dArr2 != null && dArr2.length > 0) {
            return false;
        }
        if (dArr2 != null || dArr == null || dArr.length <= 0) {
            return dArr == null || dArr2 == null || dArr.length == dArr2.length;
        }
        return false;
    }

    public static int lastIndexOf(long[] jArr, long j3) {
        return lastIndexOf(jArr, j3, Integer.MAX_VALUE);
    }

    public static int[] nullToEmpty(int[] iArr) {
        return (iArr == null || iArr.length == 0) ? EMPTY_INT_ARRAY : iArr;
    }

    public static int[] remove(int[] iArr, int i3) {
        return (int[]) remove((Object) iArr, i3);
    }

    public static byte[] removeElement(byte[] bArr, byte b16) {
        int indexOf = indexOf(bArr, b16);
        if (indexOf == -1) {
            return clone(bArr);
        }
        return remove(bArr, indexOf);
    }

    public static long[] subarray(long[] jArr, int i3, int i16) {
        if (jArr == null) {
            return null;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 > jArr.length) {
            i16 = jArr.length;
        }
        int i17 = i16 - i3;
        if (i17 <= 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr2 = new long[i17];
        System.arraycopy(jArr, i3, jArr2, 0, i17);
        return jArr2;
    }

    public static byte[] add(byte[] bArr, byte b16) {
        byte[] bArr2 = (byte[]) copyArrayGrow1(bArr, Byte.TYPE);
        bArr2[bArr2.length - 1] = b16;
        return bArr2;
    }

    public static float[] clone(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        return (float[]) fArr.clone();
    }

    public static boolean contains(double[] dArr, double d16, double d17) {
        return indexOf(dArr, d16, 0, d17) != -1;
    }

    public static int indexOf(long[] jArr, long j3, int i3) {
        if (jArr == null) {
            return -1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < jArr.length) {
            if (j3 == jArr[i3]) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static boolean isEmpty(float[] fArr) {
        return fArr == null || fArr.length == 0;
    }

    public static boolean isNotEmpty(float[] fArr) {
        return (fArr == null || fArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(float[] fArr, float[] fArr2) {
        if (fArr == null && fArr2 != null && fArr2.length > 0) {
            return false;
        }
        if (fArr2 != null || fArr == null || fArr.length <= 0) {
            return fArr == null || fArr2 == null || fArr.length == fArr2.length;
        }
        return false;
    }

    public static int lastIndexOf(long[] jArr, long j3, int i3) {
        if (jArr == null || i3 < 0) {
            return -1;
        }
        if (i3 >= jArr.length) {
            i3 = jArr.length - 1;
        }
        while (i3 >= 0) {
            if (j3 == jArr[i3]) {
                return i3;
            }
            i3--;
        }
        return -1;
    }

    public static long[] remove(long[] jArr, int i3) {
        return (long[]) remove((Object) jArr, i3);
    }

    public static boolean[] clone(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return (boolean[]) zArr.clone();
    }

    public static boolean contains(float[] fArr, float f16) {
        return indexOf(fArr, f16) != -1;
    }

    public static boolean isEmpty(boolean[] zArr) {
        return zArr == null || zArr.length == 0;
    }

    public static boolean isNotEmpty(boolean[] zArr) {
        return (zArr == null || zArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(boolean[] zArr, boolean[] zArr2) {
        if (zArr == null && zArr2 != null && zArr2.length > 0) {
            return false;
        }
        if (zArr2 != null || zArr == null || zArr.length <= 0) {
            return zArr == null || zArr2 == null || zArr.length == zArr2.length;
        }
        return false;
    }

    public static short[] nullToEmpty(short[] sArr) {
        return (sArr == null || sArr.length == 0) ? EMPTY_SHORT_ARRAY : sArr;
    }

    public static short[] remove(short[] sArr, int i3) {
        return (short[]) remove((Object) sArr, i3);
    }

    public static void reverse(int[] iArr) {
        if (iArr == null) {
            return;
        }
        int length = iArr.length - 1;
        for (int i3 = 0; length > i3; i3++) {
            int i16 = iArr[length];
            iArr[length] = iArr[i3];
            iArr[i3] = i16;
            length--;
        }
    }

    public static char[] add(char[] cArr, char c16) {
        char[] cArr2 = (char[]) copyArrayGrow1(cArr, Character.TYPE);
        cArr2[cArr2.length - 1] = c16;
        return cArr2;
    }

    public static boolean contains(boolean[] zArr, boolean z16) {
        return indexOf(zArr, z16) != -1;
    }

    public static int indexOf(int[] iArr, int i3) {
        return indexOf(iArr, i3, 0);
    }

    private static Object remove(Object obj, int i3) {
        int length = getLength(obj);
        if (i3 >= 0 && i3 < length) {
            int i16 = length - 1;
            Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i16);
            System.arraycopy(obj, 0, newInstance, 0, i3);
            if (i3 < i16) {
                System.arraycopy(obj, i3 + 1, newInstance, i3, (length - i3) - 1);
            }
            return newInstance;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Index: ");
        stringBuffer.append(i3);
        stringBuffer.append(", Length: ");
        stringBuffer.append(length);
        throw new IndexOutOfBoundsException(stringBuffer.toString());
    }

    public static char[] removeElement(char[] cArr, char c16) {
        int indexOf = indexOf(cArr, c16);
        if (indexOf == -1) {
            return clone(cArr);
        }
        return remove(cArr, indexOf);
    }

    public static boolean[] addAll(boolean[] zArr, boolean[] zArr2) {
        if (zArr == null) {
            return clone(zArr2);
        }
        if (zArr2 == null) {
            return clone(zArr);
        }
        boolean[] zArr3 = new boolean[zArr.length + zArr2.length];
        System.arraycopy(zArr, 0, zArr3, 0, zArr.length);
        System.arraycopy(zArr2, 0, zArr3, zArr.length, zArr2.length);
        return zArr3;
    }

    public static int indexOf(int[] iArr, int i3, int i16) {
        if (iArr == null) {
            return -1;
        }
        if (i16 < 0) {
            i16 = 0;
        }
        while (i16 < iArr.length) {
            if (i3 == iArr[i16]) {
                return i16;
            }
            i16++;
        }
        return -1;
    }

    public static int lastIndexOf(int[] iArr, int i3) {
        return lastIndexOf(iArr, i3, Integer.MAX_VALUE);
    }

    public static char[] nullToEmpty(char[] cArr) {
        return (cArr == null || cArr.length == 0) ? EMPTY_CHAR_ARRAY : cArr;
    }

    public static Integer[] toObject(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length == 0) {
            return EMPTY_INTEGER_OBJECT_ARRAY;
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            numArr[i3] = new Integer(iArr[i3]);
        }
        return numArr;
    }

    public static double[] add(double[] dArr, double d16) {
        double[] dArr2 = (double[]) copyArrayGrow1(dArr, Double.TYPE);
        dArr2[dArr2.length - 1] = d16;
        return dArr2;
    }

    public static int lastIndexOf(int[] iArr, int i3, int i16) {
        if (iArr == null || i16 < 0) {
            return -1;
        }
        if (i16 >= iArr.length) {
            i16 = iArr.length - 1;
        }
        while (i16 >= 0) {
            if (i3 == iArr[i16]) {
                return i16;
            }
            i16--;
        }
        return -1;
    }

    public static int[] subarray(int[] iArr, int i3, int i16) {
        if (iArr == null) {
            return null;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 > iArr.length) {
            i16 = iArr.length;
        }
        int i17 = i16 - i3;
        if (i17 <= 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr2 = new int[i17];
        System.arraycopy(iArr, i3, iArr2, 0, i17);
        return iArr2;
    }

    public static long[] toPrimitive(Long[] lArr) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr = new long[lArr.length];
        for (int i3 = 0; i3 < lArr.length; i3++) {
            jArr[i3] = lArr[i3].longValue();
        }
        return jArr;
    }

    public static int indexOf(short[] sArr, short s16) {
        return indexOf(sArr, s16, 0);
    }

    public static byte[] nullToEmpty(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? EMPTY_BYTE_ARRAY : bArr;
    }

    public static double[] removeElement(double[] dArr, double d16) {
        int indexOf = indexOf(dArr, d16);
        if (indexOf == -1) {
            return clone(dArr);
        }
        return remove(dArr, indexOf);
    }

    public static void reverse(short[] sArr) {
        if (sArr == null) {
            return;
        }
        int length = sArr.length - 1;
        for (int i3 = 0; length > i3; i3++) {
            short s16 = sArr[length];
            sArr[length] = sArr[i3];
            sArr[i3] = s16;
            length--;
        }
    }

    public static float[] add(float[] fArr, float f16) {
        float[] fArr2 = (float[]) copyArrayGrow1(fArr, Float.TYPE);
        fArr2[fArr2.length - 1] = f16;
        return fArr2;
    }

    public static int indexOf(short[] sArr, short s16, int i3) {
        if (sArr == null) {
            return -1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < sArr.length) {
            if (s16 == sArr[i3]) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static int lastIndexOf(short[] sArr, short s16) {
        return lastIndexOf(sArr, s16, Integer.MAX_VALUE);
    }

    public static double[] nullToEmpty(double[] dArr) {
        return (dArr == null || dArr.length == 0) ? EMPTY_DOUBLE_ARRAY : dArr;
    }

    public static int[] add(int[] iArr, int i3) {
        int[] iArr2 = (int[]) copyArrayGrow1(iArr, Integer.TYPE);
        iArr2[iArr2.length - 1] = i3;
        return iArr2;
    }

    public static char[] addAll(char[] cArr, char[] cArr2) {
        if (cArr == null) {
            return clone(cArr2);
        }
        if (cArr2 == null) {
            return clone(cArr);
        }
        char[] cArr3 = new char[cArr.length + cArr2.length];
        System.arraycopy(cArr, 0, cArr3, 0, cArr.length);
        System.arraycopy(cArr2, 0, cArr3, cArr.length, cArr2.length);
        return cArr3;
    }

    public static int indexOf(char[] cArr, char c16) {
        return indexOf(cArr, c16, 0);
    }

    public static int lastIndexOf(short[] sArr, short s16, int i3) {
        if (sArr == null || i3 < 0) {
            return -1;
        }
        if (i3 >= sArr.length) {
            i3 = sArr.length - 1;
        }
        while (i3 >= 0) {
            if (s16 == sArr[i3]) {
                return i3;
            }
            i3--;
        }
        return -1;
    }

    public static float[] removeElement(float[] fArr, float f16) {
        int indexOf = indexOf(fArr, f16);
        if (indexOf == -1) {
            return clone(fArr);
        }
        return remove(fArr, indexOf);
    }

    public static Short[] toObject(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        if (sArr.length == 0) {
            return EMPTY_SHORT_OBJECT_ARRAY;
        }
        Short[] shArr = new Short[sArr.length];
        for (int i3 = 0; i3 < sArr.length; i3++) {
            shArr[i3] = new Short(sArr[i3]);
        }
        return shArr;
    }

    public static int indexOf(char[] cArr, char c16, int i3) {
        if (cArr == null) {
            return -1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < cArr.length) {
            if (c16 == cArr[i3]) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static float[] nullToEmpty(float[] fArr) {
        return (fArr == null || fArr.length == 0) ? EMPTY_FLOAT_ARRAY : fArr;
    }

    public static void reverse(char[] cArr) {
        if (cArr == null) {
            return;
        }
        int length = cArr.length - 1;
        for (int i3 = 0; length > i3; i3++) {
            char c16 = cArr[length];
            cArr[length] = cArr[i3];
            cArr[i3] = c16;
            length--;
        }
    }

    public static short[] subarray(short[] sArr, int i3, int i16) {
        if (sArr == null) {
            return null;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 > sArr.length) {
            i16 = sArr.length;
        }
        int i17 = i16 - i3;
        if (i17 <= 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr2 = new short[i17];
        System.arraycopy(sArr, i3, sArr2, 0, i17);
        return sArr2;
    }

    public static long[] toPrimitive(Long[] lArr, long j3) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr = new long[lArr.length];
        for (int i3 = 0; i3 < lArr.length; i3++) {
            Long l3 = lArr[i3];
            jArr[i3] = l3 == null ? j3 : l3.longValue();
        }
        return jArr;
    }

    public static long[] add(long[] jArr, long j3) {
        long[] jArr2 = (long[]) copyArrayGrow1(jArr, Long.TYPE);
        jArr2[jArr2.length - 1] = j3;
        return jArr2;
    }

    public static int indexOf(byte[] bArr, byte b16) {
        return indexOf(bArr, b16, 0);
    }

    public static int lastIndexOf(char[] cArr, char c16) {
        return lastIndexOf(cArr, c16, Integer.MAX_VALUE);
    }

    public static boolean[] nullToEmpty(boolean[] zArr) {
        return (zArr == null || zArr.length == 0) ? EMPTY_BOOLEAN_ARRAY : zArr;
    }

    public static int[] removeElement(int[] iArr, int i3) {
        int indexOf = indexOf(iArr, i3);
        if (indexOf == -1) {
            return clone(iArr);
        }
        return remove(iArr, indexOf);
    }

    public static short[] add(short[] sArr, short s16) {
        short[] sArr2 = (short[]) copyArrayGrow1(sArr, Short.TYPE);
        sArr2[sArr2.length - 1] = s16;
        return sArr2;
    }

    public static int indexOf(byte[] bArr, byte b16, int i3) {
        if (bArr == null) {
            return -1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < bArr.length) {
            if (b16 == bArr[i3]) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static int lastIndexOf(char[] cArr, char c16, int i3) {
        if (cArr == null || i3 < 0) {
            return -1;
        }
        if (i3 >= cArr.length) {
            i3 = cArr.length - 1;
        }
        while (i3 >= 0) {
            if (c16 == cArr[i3]) {
                return i3;
            }
            i3--;
        }
        return -1;
    }

    public static byte[] addAll(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return clone(bArr2);
        }
        if (bArr2 == null) {
            return clone(bArr);
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static Long[] nullToEmpty(Long[] lArr) {
        return (lArr == null || lArr.length == 0) ? EMPTY_LONG_OBJECT_ARRAY : lArr;
    }

    public static void reverse(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        int length = bArr.length - 1;
        for (int i3 = 0; length > i3; i3++) {
            byte b16 = bArr[length];
            bArr[length] = bArr[i3];
            bArr[i3] = b16;
            length--;
        }
    }

    public static Byte[] toObject(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr2[i3] = new Byte(bArr[i3]);
        }
        return bArr2;
    }

    public static Object[] add(Object[] objArr, int i3, Object obj) {
        Class<?> cls;
        if (objArr != null) {
            cls = objArr.getClass().getComponentType();
        } else {
            if (obj == null) {
                return new Object[]{null};
            }
            cls = obj.getClass();
        }
        return (Object[]) add(objArr, i3, obj, cls);
    }

    public static int indexOf(double[] dArr, double d16) {
        return indexOf(dArr, d16, 0);
    }

    public static long[] removeElement(long[] jArr, long j3) {
        int indexOf = indexOf(jArr, j3);
        if (indexOf == -1) {
            return clone(jArr);
        }
        return remove(jArr, indexOf);
    }

    public static char[] subarray(char[] cArr, int i3, int i16) {
        if (cArr == null) {
            return null;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 > cArr.length) {
            i16 = cArr.length;
        }
        int i17 = i16 - i3;
        if (i17 <= 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr2 = new char[i17];
        System.arraycopy(cArr, i3, cArr2, 0, i17);
        return cArr2;
    }

    public static int indexOf(double[] dArr, double d16, double d17) {
        return indexOf(dArr, d16, 0, d17);
    }

    public static int lastIndexOf(byte[] bArr, byte b16) {
        return lastIndexOf(bArr, b16, Integer.MAX_VALUE);
    }

    public static Integer[] nullToEmpty(Integer[] numArr) {
        return (numArr == null || numArr.length == 0) ? EMPTY_INTEGER_OBJECT_ARRAY : numArr;
    }

    public static int[] toPrimitive(Integer[] numArr) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numArr.length];
        for (int i3 = 0; i3 < numArr.length; i3++) {
            iArr[i3] = numArr[i3].intValue();
        }
        return iArr;
    }

    public static int indexOf(double[] dArr, double d16, int i3) {
        if (isEmpty(dArr)) {
            return -1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < dArr.length) {
            if (d16 == dArr[i3]) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static int lastIndexOf(byte[] bArr, byte b16, int i3) {
        if (bArr == null || i3 < 0) {
            return -1;
        }
        if (i3 >= bArr.length) {
            i3 = bArr.length - 1;
        }
        while (i3 >= 0) {
            if (b16 == bArr[i3]) {
                return i3;
            }
            i3--;
        }
        return -1;
    }

    public static boolean[] add(boolean[] zArr, int i3, boolean z16) {
        return (boolean[]) add(zArr, i3, BooleanUtils.toBooleanObject(z16), Boolean.TYPE);
    }

    public static Short[] nullToEmpty(Short[] shArr) {
        return (shArr == null || shArr.length == 0) ? EMPTY_SHORT_OBJECT_ARRAY : shArr;
    }

    public static short[] removeElement(short[] sArr, short s16) {
        int indexOf = indexOf(sArr, s16);
        if (indexOf == -1) {
            return clone(sArr);
        }
        return remove(sArr, indexOf);
    }

    public static void reverse(double[] dArr) {
        if (dArr == null) {
            return;
        }
        int length = dArr.length - 1;
        for (int i3 = 0; length > i3; i3++) {
            double d16 = dArr[length];
            dArr[length] = dArr[i3];
            dArr[i3] = d16;
            length--;
        }
    }

    public static char[] add(char[] cArr, int i3, char c16) {
        return (char[]) add(cArr, i3, new Character(c16), Character.TYPE);
    }

    public static short[] addAll(short[] sArr, short[] sArr2) {
        if (sArr == null) {
            return clone(sArr2);
        }
        if (sArr2 == null) {
            return clone(sArr);
        }
        short[] sArr3 = new short[sArr.length + sArr2.length];
        System.arraycopy(sArr, 0, sArr3, 0, sArr.length);
        System.arraycopy(sArr2, 0, sArr3, sArr.length, sArr2.length);
        return sArr3;
    }

    public static Double[] toObject(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        Double[] dArr2 = new Double[dArr.length];
        for (int i3 = 0; i3 < dArr.length; i3++) {
            dArr2[i3] = new Double(dArr[i3]);
        }
        return dArr2;
    }

    public static byte[] add(byte[] bArr, int i3, byte b16) {
        return (byte[]) add(bArr, i3, new Byte(b16), Byte.TYPE);
    }

    public static int indexOf(double[] dArr, double d16, int i3, double d17) {
        if (isEmpty(dArr)) {
            return -1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        double d18 = d16 - d17;
        double d19 = d16 + d17;
        while (i3 < dArr.length) {
            double d26 = dArr[i3];
            if (d26 >= d18 && d26 <= d19) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static int lastIndexOf(double[] dArr, double d16) {
        return lastIndexOf(dArr, d16, Integer.MAX_VALUE);
    }

    public static Character[] nullToEmpty(Character[] chArr) {
        return (chArr == null || chArr.length == 0) ? EMPTY_CHARACTER_OBJECT_ARRAY : chArr;
    }

    public static byte[] subarray(byte[] bArr, int i3, int i16) {
        if (bArr == null) {
            return null;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 > bArr.length) {
            i16 = bArr.length;
        }
        int i17 = i16 - i3;
        if (i17 <= 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[i17];
        System.arraycopy(bArr, i3, bArr2, 0, i17);
        return bArr2;
    }

    public static short[] add(short[] sArr, int i3, short s16) {
        return (short[]) add(sArr, i3, new Short(s16), Short.TYPE);
    }

    public static int lastIndexOf(double[] dArr, double d16, double d17) {
        return lastIndexOf(dArr, d16, Integer.MAX_VALUE, d17);
    }

    public static int[] toPrimitive(Integer[] numArr, int i3) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numArr.length];
        for (int i16 = 0; i16 < numArr.length; i16++) {
            Integer num = numArr[i16];
            iArr[i16] = num == null ? i3 : num.intValue();
        }
        return iArr;
    }

    public static int[] add(int[] iArr, int i3, int i16) {
        return (int[]) add(iArr, i3, new Integer(i16), Integer.TYPE);
    }

    public static int lastIndexOf(double[] dArr, double d16, int i3) {
        if (isEmpty(dArr) || i3 < 0) {
            return -1;
        }
        if (i3 >= dArr.length) {
            i3 = dArr.length - 1;
        }
        while (i3 >= 0) {
            if (d16 == dArr[i3]) {
                return i3;
            }
            i3--;
        }
        return -1;
    }

    public static Byte[] nullToEmpty(Byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? EMPTY_BYTE_OBJECT_ARRAY : bArr;
    }

    public static void reverse(float[] fArr) {
        if (fArr == null) {
            return;
        }
        int length = fArr.length - 1;
        for (int i3 = 0; length > i3; i3++) {
            float f16 = fArr[length];
            fArr[length] = fArr[i3];
            fArr[i3] = f16;
            length--;
        }
    }

    public static long[] add(long[] jArr, int i3, long j3) {
        return (long[]) add(jArr, i3, new Long(j3), Long.TYPE);
    }

    public static int indexOf(float[] fArr, float f16) {
        return indexOf(fArr, f16, 0);
    }

    public static float[] add(float[] fArr, int i3, float f16) {
        return (float[]) add(fArr, i3, new Float(f16), Float.TYPE);
    }

    public static int[] addAll(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return clone(iArr2);
        }
        if (iArr2 == null) {
            return clone(iArr);
        }
        int[] iArr3 = new int[iArr.length + iArr2.length];
        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
        return iArr3;
    }

    public static int indexOf(float[] fArr, float f16, int i3) {
        if (isEmpty(fArr)) {
            return -1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < fArr.length) {
            if (f16 == fArr[i3]) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static Double[] nullToEmpty(Double[] dArr) {
        return (dArr == null || dArr.length == 0) ? EMPTY_DOUBLE_OBJECT_ARRAY : dArr;
    }

    public static Float[] toObject(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_OBJECT_ARRAY;
        }
        Float[] fArr2 = new Float[fArr.length];
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr2[i3] = new Float(fArr[i3]);
        }
        return fArr2;
    }

    public static double[] add(double[] dArr, int i3, double d16) {
        return (double[]) add(dArr, i3, new Double(d16), Double.TYPE);
    }

    public static double[] subarray(double[] dArr, int i3, int i16) {
        if (dArr == null) {
            return null;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 > dArr.length) {
            i16 = dArr.length;
        }
        int i17 = i16 - i3;
        if (i17 <= 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[i17];
        System.arraycopy(dArr, i3, dArr2, 0, i17);
        return dArr2;
    }

    private static Object add(Object obj, int i3, Object obj2, Class cls) {
        if (obj == null) {
            if (i3 == 0) {
                Object newInstance = Array.newInstance((Class<?>) cls, 1);
                Array.set(newInstance, 0, obj2);
                return newInstance;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Index: ");
            stringBuffer.append(i3);
            stringBuffer.append(", Length: 0");
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        int length = Array.getLength(obj);
        if (i3 <= length && i3 >= 0) {
            Object newInstance2 = Array.newInstance((Class<?>) cls, length + 1);
            System.arraycopy(obj, 0, newInstance2, 0, i3);
            Array.set(newInstance2, i3, obj2);
            if (i3 < length) {
                System.arraycopy(obj, i3, newInstance2, i3 + 1, length - i3);
            }
            return newInstance2;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Index: ");
        stringBuffer2.append(i3);
        stringBuffer2.append(", Length: ");
        stringBuffer2.append(length);
        throw new IndexOutOfBoundsException(stringBuffer2.toString());
    }

    public static int lastIndexOf(double[] dArr, double d16, int i3, double d17) {
        if (isEmpty(dArr) || i3 < 0) {
            return -1;
        }
        if (i3 >= dArr.length) {
            i3 = dArr.length - 1;
        }
        double d18 = d16 - d17;
        double d19 = d16 + d17;
        while (i3 >= 0) {
            double d26 = dArr[i3];
            if (d26 >= d18 && d26 <= d19) {
                return i3;
            }
            i3--;
        }
        return -1;
    }

    public static Float[] nullToEmpty(Float[] fArr) {
        return (fArr == null || fArr.length == 0) ? EMPTY_FLOAT_OBJECT_ARRAY : fArr;
    }

    public static void reverse(boolean[] zArr) {
        if (zArr == null) {
            return;
        }
        int length = zArr.length - 1;
        for (int i3 = 0; length > i3; i3++) {
            boolean z16 = zArr[length];
            zArr[length] = zArr[i3];
            zArr[i3] = z16;
            length--;
        }
    }

    public static int indexOf(boolean[] zArr, boolean z16) {
        return indexOf(zArr, z16, 0);
    }

    public static short[] toPrimitive(Short[] shArr) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr = new short[shArr.length];
        for (int i3 = 0; i3 < shArr.length; i3++) {
            sArr[i3] = shArr[i3].shortValue();
        }
        return sArr;
    }

    public static int indexOf(boolean[] zArr, boolean z16, int i3) {
        if (isEmpty(zArr)) {
            return -1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < zArr.length) {
            if (z16 == zArr[i3]) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static Boolean[] nullToEmpty(Boolean[] boolArr) {
        return (boolArr == null || boolArr.length == 0) ? EMPTY_BOOLEAN_OBJECT_ARRAY : boolArr;
    }

    public static long[] addAll(long[] jArr, long[] jArr2) {
        if (jArr == null) {
            return clone(jArr2);
        }
        if (jArr2 == null) {
            return clone(jArr);
        }
        long[] jArr3 = new long[jArr.length + jArr2.length];
        System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
        System.arraycopy(jArr2, 0, jArr3, jArr.length, jArr2.length);
        return jArr3;
    }

    public static Boolean[] toObject(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        if (zArr.length == 0) {
            return EMPTY_BOOLEAN_OBJECT_ARRAY;
        }
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i3 = 0; i3 < zArr.length; i3++) {
            boolArr[i3] = zArr[i3] ? Boolean.TRUE : Boolean.FALSE;
        }
        return boolArr;
    }

    public static int lastIndexOf(float[] fArr, float f16) {
        return lastIndexOf(fArr, f16, Integer.MAX_VALUE);
    }

    public static float[] subarray(float[] fArr, int i3, int i16) {
        if (fArr == null) {
            return null;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 > fArr.length) {
            i16 = fArr.length;
        }
        int i17 = i16 - i3;
        if (i17 <= 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[i17];
        System.arraycopy(fArr, i3, fArr2, 0, i17);
        return fArr2;
    }

    public static int lastIndexOf(float[] fArr, float f16, int i3) {
        if (isEmpty(fArr) || i3 < 0) {
            return -1;
        }
        if (i3 >= fArr.length) {
            i3 = fArr.length - 1;
        }
        while (i3 >= 0) {
            if (f16 == fArr[i3]) {
                return i3;
            }
            i3--;
        }
        return -1;
    }

    public static short[] toPrimitive(Short[] shArr, short s16) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr = new short[shArr.length];
        for (int i3 = 0; i3 < shArr.length; i3++) {
            Short sh5 = shArr[i3];
            sArr[i3] = sh5 == null ? s16 : sh5.shortValue();
        }
        return sArr;
    }

    public static float[] addAll(float[] fArr, float[] fArr2) {
        if (fArr == null) {
            return clone(fArr2);
        }
        if (fArr2 == null) {
            return clone(fArr);
        }
        float[] fArr3 = new float[fArr.length + fArr2.length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        return fArr3;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z16) {
        return lastIndexOf(zArr, z16, Integer.MAX_VALUE);
    }

    public static boolean[] subarray(boolean[] zArr, int i3, int i16) {
        if (zArr == null) {
            return null;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 > zArr.length) {
            i16 = zArr.length;
        }
        int i17 = i16 - i3;
        if (i17 <= 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr2 = new boolean[i17];
        System.arraycopy(zArr, i3, zArr2, 0, i17);
        return zArr2;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z16, int i3) {
        if (isEmpty(zArr) || i3 < 0) {
            return -1;
        }
        if (i3 >= zArr.length) {
            i3 = zArr.length - 1;
        }
        while (i3 >= 0) {
            if (z16 == zArr[i3]) {
                return i3;
            }
            i3--;
        }
        return -1;
    }

    public static byte[] toPrimitive(Byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr2[i3] = bArr[i3].byteValue();
        }
        return bArr2;
    }

    public static double[] addAll(double[] dArr, double[] dArr2) {
        if (dArr == null) {
            return clone(dArr2);
        }
        if (dArr2 == null) {
            return clone(dArr);
        }
        double[] dArr3 = new double[dArr.length + dArr2.length];
        System.arraycopy(dArr, 0, dArr3, 0, dArr.length);
        System.arraycopy(dArr2, 0, dArr3, dArr.length, dArr2.length);
        return dArr3;
    }

    public static byte[] toPrimitive(Byte[] bArr, byte b16) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            Byte b17 = bArr[i3];
            bArr2[i3] = b17 == null ? b16 : b17.byteValue();
        }
        return bArr2;
    }

    public static double[] toPrimitive(Double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i3 = 0; i3 < dArr.length; i3++) {
            dArr2[i3] = dArr[i3].doubleValue();
        }
        return dArr2;
    }

    public static double[] toPrimitive(Double[] dArr, double d16) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i3 = 0; i3 < dArr.length; i3++) {
            Double d17 = dArr[i3];
            dArr2[i3] = d17 == null ? d16 : d17.doubleValue();
        }
        return dArr2;
    }

    public static float[] toPrimitive(Float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr2[i3] = fArr[i3].floatValue();
        }
        return fArr2;
    }

    public static float[] toPrimitive(Float[] fArr, float f16) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i3 = 0; i3 < fArr.length; i3++) {
            Float f17 = fArr[i3];
            fArr2[i3] = f17 == null ? f16 : f17.floatValue();
        }
        return fArr2;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i3 = 0; i3 < boolArr.length; i3++) {
            zArr[i3] = boolArr[i3].booleanValue();
        }
        return zArr;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr, boolean z16) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i3 = 0; i3 < boolArr.length; i3++) {
            Boolean bool = boolArr[i3];
            zArr[i3] = bool == null ? z16 : bool.booleanValue();
        }
        return zArr;
    }
}
