package org.apache.commons.lang.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Comparator;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.math.NumberUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CompareToBuilder {
    private int comparison = 0;

    private static void reflectionAppend(Object obj, Object obj2, Class cls, CompareToBuilder compareToBuilder, boolean z16, String[] strArr) {
        Field[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (int i3 = 0; i3 < declaredFields.length && compareToBuilder.comparison == 0; i3++) {
            Field field = declaredFields[i3];
            if (!ArrayUtils.contains(strArr, field.getName()) && field.getName().indexOf(36) == -1 && ((z16 || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    compareToBuilder.append(field.get(obj), field.get(obj2));
                } catch (IllegalAccessException unused) {
                    throw new InternalError("Unexpected IllegalAccessException");
                }
            }
        }
    }

    public static int reflectionCompare(Object obj, Object obj2) {
        return reflectionCompare(obj, obj2, false, null, null);
    }

    public CompareToBuilder append(Object obj, Object obj2) {
        return append(obj, obj2, (Comparator) null);
    }

    public CompareToBuilder appendSuper(int i3) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = i3;
        return this;
    }

    public int toComparison() {
        return this.comparison;
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z16) {
        return reflectionCompare(obj, obj2, z16, null, null);
    }

    public CompareToBuilder append(Object obj, Object obj2, Comparator comparator) {
        if (this.comparison != 0 || obj == obj2) {
            return this;
        }
        if (obj == null) {
            this.comparison = -1;
            return this;
        }
        if (obj2 == null) {
            this.comparison = 1;
            return this;
        }
        if (obj.getClass().isArray()) {
            if (obj instanceof long[]) {
                append((long[]) obj, (long[]) obj2);
            } else if (obj instanceof int[]) {
                append((int[]) obj, (int[]) obj2);
            } else if (obj instanceof short[]) {
                append((short[]) obj, (short[]) obj2);
            } else if (obj instanceof char[]) {
                append((char[]) obj, (char[]) obj2);
            } else if (obj instanceof byte[]) {
                append((byte[]) obj, (byte[]) obj2);
            } else if (obj instanceof double[]) {
                append((double[]) obj, (double[]) obj2);
            } else if (obj instanceof float[]) {
                append((float[]) obj, (float[]) obj2);
            } else if (obj instanceof boolean[]) {
                append((boolean[]) obj, (boolean[]) obj2);
            } else {
                append((Object[]) obj, (Object[]) obj2, comparator);
            }
        } else if (comparator == null) {
            this.comparison = ((Comparable) obj).compareTo(obj2);
        } else {
            this.comparison = comparator.compare(obj, obj2);
        }
        return this;
    }

    public static int reflectionCompare(Object obj, Object obj2, Collection collection) {
        return reflectionCompare(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public static int reflectionCompare(Object obj, Object obj2, String[] strArr) {
        return reflectionCompare(obj, obj2, false, null, strArr);
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z16, Class cls) {
        return reflectionCompare(obj, obj2, z16, cls, null);
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z16, Class cls, String[] strArr) {
        if (obj == obj2) {
            return 0;
        }
        if (obj != null && obj2 != null) {
            Class<?> cls2 = obj.getClass();
            if (cls2.isInstance(obj2)) {
                CompareToBuilder compareToBuilder = new CompareToBuilder();
                reflectionAppend(obj, obj2, cls2, compareToBuilder, z16, strArr);
                while (cls2.getSuperclass() != null && cls2 != cls) {
                    cls2 = cls2.getSuperclass();
                    reflectionAppend(obj, obj2, cls2, compareToBuilder, z16, strArr);
                }
                return compareToBuilder.toComparison();
            }
            throw new ClassCastException();
        }
        throw null;
    }

    public CompareToBuilder append(long j3, long j16) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = j3 < j16 ? -1 : j3 > j16 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(int i3, int i16) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = i3 < i16 ? -1 : i3 > i16 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(short s16, short s17) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = s16 < s17 ? -1 : s16 > s17 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(char c16, char c17) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = c16 < c17 ? -1 : c16 > c17 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(byte b16, byte b17) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = b16 < b17 ? -1 : b16 > b17 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(double d16, double d17) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = NumberUtils.compare(d16, d17);
        return this;
    }

    public CompareToBuilder append(float f16, float f17) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = NumberUtils.compare(f16, f17);
        return this;
    }

    public CompareToBuilder append(boolean z16, boolean z17) {
        if (this.comparison != 0 || z16 == z17) {
            return this;
        }
        if (!z16) {
            this.comparison = -1;
        } else {
            this.comparison = 1;
        }
        return this;
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2) {
        return append(objArr, objArr2, (Comparator) null);
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2, Comparator comparator) {
        if (this.comparison != 0 || objArr == objArr2) {
            return this;
        }
        if (objArr == null) {
            this.comparison = -1;
            return this;
        }
        if (objArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (objArr.length != objArr2.length) {
            this.comparison = objArr.length >= objArr2.length ? 1 : -1;
            return this;
        }
        for (int i3 = 0; i3 < objArr.length && this.comparison == 0; i3++) {
            append(objArr[i3], objArr2[i3], comparator);
        }
        return this;
    }

    public CompareToBuilder append(long[] jArr, long[] jArr2) {
        if (this.comparison != 0 || jArr == jArr2) {
            return this;
        }
        if (jArr == null) {
            this.comparison = -1;
            return this;
        }
        if (jArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (jArr.length != jArr2.length) {
            this.comparison = jArr.length >= jArr2.length ? 1 : -1;
            return this;
        }
        for (int i3 = 0; i3 < jArr.length && this.comparison == 0; i3++) {
            append(jArr[i3], jArr2[i3]);
        }
        return this;
    }

    public CompareToBuilder append(int[] iArr, int[] iArr2) {
        if (this.comparison != 0 || iArr == iArr2) {
            return this;
        }
        if (iArr == null) {
            this.comparison = -1;
            return this;
        }
        if (iArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (iArr.length != iArr2.length) {
            this.comparison = iArr.length >= iArr2.length ? 1 : -1;
            return this;
        }
        for (int i3 = 0; i3 < iArr.length && this.comparison == 0; i3++) {
            append(iArr[i3], iArr2[i3]);
        }
        return this;
    }

    public CompareToBuilder append(short[] sArr, short[] sArr2) {
        if (this.comparison != 0 || sArr == sArr2) {
            return this;
        }
        if (sArr == null) {
            this.comparison = -1;
            return this;
        }
        if (sArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (sArr.length != sArr2.length) {
            this.comparison = sArr.length >= sArr2.length ? 1 : -1;
            return this;
        }
        for (int i3 = 0; i3 < sArr.length && this.comparison == 0; i3++) {
            append(sArr[i3], sArr2[i3]);
        }
        return this;
    }

    public CompareToBuilder append(char[] cArr, char[] cArr2) {
        if (this.comparison != 0 || cArr == cArr2) {
            return this;
        }
        if (cArr == null) {
            this.comparison = -1;
            return this;
        }
        if (cArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (cArr.length != cArr2.length) {
            this.comparison = cArr.length >= cArr2.length ? 1 : -1;
            return this;
        }
        for (int i3 = 0; i3 < cArr.length && this.comparison == 0; i3++) {
            append(cArr[i3], cArr2[i3]);
        }
        return this;
    }

    public CompareToBuilder append(byte[] bArr, byte[] bArr2) {
        if (this.comparison != 0 || bArr == bArr2) {
            return this;
        }
        if (bArr == null) {
            this.comparison = -1;
            return this;
        }
        if (bArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (bArr.length != bArr2.length) {
            this.comparison = bArr.length >= bArr2.length ? 1 : -1;
            return this;
        }
        for (int i3 = 0; i3 < bArr.length && this.comparison == 0; i3++) {
            append(bArr[i3], bArr2[i3]);
        }
        return this;
    }

    public CompareToBuilder append(double[] dArr, double[] dArr2) {
        if (this.comparison != 0 || dArr == dArr2) {
            return this;
        }
        if (dArr == null) {
            this.comparison = -1;
            return this;
        }
        if (dArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (dArr.length != dArr2.length) {
            this.comparison = dArr.length >= dArr2.length ? 1 : -1;
            return this;
        }
        for (int i3 = 0; i3 < dArr.length && this.comparison == 0; i3++) {
            append(dArr[i3], dArr2[i3]);
        }
        return this;
    }

    public CompareToBuilder append(float[] fArr, float[] fArr2) {
        if (this.comparison != 0 || fArr == fArr2) {
            return this;
        }
        if (fArr == null) {
            this.comparison = -1;
            return this;
        }
        if (fArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (fArr.length != fArr2.length) {
            this.comparison = fArr.length >= fArr2.length ? 1 : -1;
            return this;
        }
        for (int i3 = 0; i3 < fArr.length && this.comparison == 0; i3++) {
            append(fArr[i3], fArr2[i3]);
        }
        return this;
    }

    public CompareToBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (this.comparison != 0 || zArr == zArr2) {
            return this;
        }
        if (zArr == null) {
            this.comparison = -1;
            return this;
        }
        if (zArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (zArr.length != zArr2.length) {
            this.comparison = zArr.length >= zArr2.length ? 1 : -1;
            return this;
        }
        for (int i3 = 0; i3 < zArr.length && this.comparison == 0; i3++) {
            append(zArr[i3], zArr2[i3]);
        }
        return this;
    }
}
