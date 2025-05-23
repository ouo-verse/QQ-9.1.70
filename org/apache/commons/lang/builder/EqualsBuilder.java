package org.apache.commons.lang.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import org.apache.commons.lang.ArrayUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class EqualsBuilder {
    private boolean isEquals = true;

    private static void reflectionAppend(Object obj, Object obj2, Class cls, EqualsBuilder equalsBuilder, boolean z16, String[] strArr) {
        Field[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (int i3 = 0; i3 < declaredFields.length && equalsBuilder.isEquals; i3++) {
            Field field = declaredFields[i3];
            if (!ArrayUtils.contains(strArr, field.getName()) && field.getName().indexOf(36) == -1 && ((z16 || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    equalsBuilder.append(field.get(obj), field.get(obj2));
                } catch (IllegalAccessException unused) {
                    throw new InternalError("Unexpected IllegalAccessException");
                }
            }
        }
    }

    public static boolean reflectionEquals(Object obj, Object obj2) {
        return reflectionEquals(obj, obj2, false, null, null);
    }

    public EqualsBuilder append(Object obj, Object obj2) {
        if (!this.isEquals || obj == obj2) {
            return this;
        }
        if (obj != null && obj2 != null) {
            if (!obj.getClass().isArray()) {
                this.isEquals = obj.equals(obj2);
            } else if (obj.getClass() != obj2.getClass()) {
                setEquals(false);
            } else if (obj instanceof long[]) {
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
                append((Object[]) obj, (Object[]) obj2);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder appendSuper(boolean z16) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = z16;
        return this;
    }

    public boolean isEquals() {
        return this.isEquals;
    }

    public void reset() {
        this.isEquals = true;
    }

    protected void setEquals(boolean z16) {
        this.isEquals = z16;
    }

    public static boolean reflectionEquals(Object obj, Object obj2, Collection collection) {
        return reflectionEquals(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public static boolean reflectionEquals(Object obj, Object obj2, String[] strArr) {
        return reflectionEquals(obj, obj2, false, null, strArr);
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z16) {
        return reflectionEquals(obj, obj2, z16, null, null);
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z16, Class cls) {
        return reflectionEquals(obj, obj2, z16, cls, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r2.isInstance(r11) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002c, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0029, code lost:
    
        if (r1.isInstance(r12) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean reflectionEquals(Object obj, Object obj2, boolean z16, Class cls, String[] strArr) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj2 != null) {
            Class<?> cls2 = obj.getClass();
            Class<?> cls3 = obj2.getClass();
            if (!cls2.isInstance(obj2)) {
                if (cls3.isInstance(obj)) {
                }
            }
            EqualsBuilder equalsBuilder = new EqualsBuilder();
            try {
                reflectionAppend(obj, obj2, cls2, equalsBuilder, z16, strArr);
                while (cls2.getSuperclass() != null && cls2 != cls) {
                    cls2 = cls2.getSuperclass();
                    reflectionAppend(obj, obj2, cls2, equalsBuilder, z16, strArr);
                }
                return equalsBuilder.isEquals();
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }

    public EqualsBuilder append(long j3, long j16) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = j3 == j16;
        return this;
    }

    public EqualsBuilder append(int i3, int i16) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = i3 == i16;
        return this;
    }

    public EqualsBuilder append(short s16, short s17) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = s16 == s17;
        return this;
    }

    public EqualsBuilder append(char c16, char c17) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = c16 == c17;
        return this;
    }

    public EqualsBuilder append(byte b16, byte b17) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = b16 == b17;
        return this;
    }

    public EqualsBuilder append(double d16, double d17) {
        return !this.isEquals ? this : append(Double.doubleToLongBits(d16), Double.doubleToLongBits(d17));
    }

    public EqualsBuilder append(float f16, float f17) {
        return !this.isEquals ? this : append(Float.floatToIntBits(f16), Float.floatToIntBits(f17));
    }

    public EqualsBuilder append(boolean z16, boolean z17) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = z16 == z17;
        return this;
    }

    public EqualsBuilder append(Object[] objArr, Object[] objArr2) {
        if (!this.isEquals || objArr == objArr2) {
            return this;
        }
        if (objArr != null && objArr2 != null) {
            if (objArr.length != objArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i3 = 0; i3 < objArr.length && this.isEquals; i3++) {
                append(objArr[i3], objArr2[i3]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(long[] jArr, long[] jArr2) {
        if (!this.isEquals || jArr == jArr2) {
            return this;
        }
        if (jArr != null && jArr2 != null) {
            if (jArr.length != jArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i3 = 0; i3 < jArr.length && this.isEquals; i3++) {
                append(jArr[i3], jArr2[i3]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(int[] iArr, int[] iArr2) {
        if (!this.isEquals || iArr == iArr2) {
            return this;
        }
        if (iArr != null && iArr2 != null) {
            if (iArr.length != iArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i3 = 0; i3 < iArr.length && this.isEquals; i3++) {
                append(iArr[i3], iArr2[i3]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(short[] sArr, short[] sArr2) {
        if (!this.isEquals || sArr == sArr2) {
            return this;
        }
        if (sArr != null && sArr2 != null) {
            if (sArr.length != sArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i3 = 0; i3 < sArr.length && this.isEquals; i3++) {
                append(sArr[i3], sArr2[i3]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(char[] cArr, char[] cArr2) {
        if (!this.isEquals || cArr == cArr2) {
            return this;
        }
        if (cArr != null && cArr2 != null) {
            if (cArr.length != cArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i3 = 0; i3 < cArr.length && this.isEquals; i3++) {
                append(cArr[i3], cArr2[i3]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(byte[] bArr, byte[] bArr2) {
        if (!this.isEquals || bArr == bArr2) {
            return this;
        }
        if (bArr != null && bArr2 != null) {
            if (bArr.length != bArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i3 = 0; i3 < bArr.length && this.isEquals; i3++) {
                append(bArr[i3], bArr2[i3]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(double[] dArr, double[] dArr2) {
        if (!this.isEquals || dArr == dArr2) {
            return this;
        }
        if (dArr != null && dArr2 != null) {
            if (dArr.length != dArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i3 = 0; i3 < dArr.length && this.isEquals; i3++) {
                append(dArr[i3], dArr2[i3]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(float[] fArr, float[] fArr2) {
        if (!this.isEquals || fArr == fArr2) {
            return this;
        }
        if (fArr != null && fArr2 != null) {
            if (fArr.length != fArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i3 = 0; i3 < fArr.length && this.isEquals; i3++) {
                append(fArr[i3], fArr2[i3]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (!this.isEquals || zArr == zArr2) {
            return this;
        }
        if (zArr != null && zArr2 != null) {
            if (zArr.length != zArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i3 = 0; i3 < zArr.length && this.isEquals; i3++) {
                append(zArr[i3], zArr2[i3]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }
}
