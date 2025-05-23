package org.apache.commons.lang.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang.ArrayUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class HashCodeBuilder {
    private static final ThreadLocal REGISTRY = new ThreadLocal();
    static /* synthetic */ Class class$org$apache$commons$lang$builder$HashCodeBuilder;
    private final int iConstant;
    private int iTotal;

    public HashCodeBuilder() {
        this.iConstant = 37;
        this.iTotal = 17;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e16) {
            throw new NoClassDefFoundError(e16.getMessage());
        }
    }

    static Set getRegistry() {
        return (Set) REGISTRY.get();
    }

    static boolean isRegistered(Object obj) {
        Set registry = getRegistry();
        if (registry != null && registry.contains(new IDKey(obj))) {
            return true;
        }
        return false;
    }

    private static void reflectionAppend(Object obj, Class cls, HashCodeBuilder hashCodeBuilder, boolean z16, String[] strArr) {
        if (isRegistered(obj)) {
            return;
        }
        try {
            register(obj);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (Field field : declaredFields) {
                if (!ArrayUtils.contains(strArr, field.getName()) && field.getName().indexOf(36) == -1 && ((z16 || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                    try {
                        hashCodeBuilder.append(field.get(obj));
                    } catch (IllegalAccessException unused) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
        } finally {
            unregister(obj);
        }
    }

    public static int reflectionHashCode(int i3, int i16, Object obj) {
        return reflectionHashCode(i3, i16, obj, false, null, null);
    }

    static void register(Object obj) {
        Class cls = class$org$apache$commons$lang$builder$HashCodeBuilder;
        if (cls == null) {
            cls = class$("org.apache.commons.lang.builder.HashCodeBuilder");
            class$org$apache$commons$lang$builder$HashCodeBuilder = cls;
        }
        synchronized (cls) {
            if (getRegistry() == null) {
                REGISTRY.set(new HashSet());
            }
        }
        getRegistry().add(new IDKey(obj));
    }

    static void unregister(Object obj) {
        Set registry = getRegistry();
        if (registry != null) {
            registry.remove(new IDKey(obj));
            Class cls = class$org$apache$commons$lang$builder$HashCodeBuilder;
            if (cls == null) {
                cls = class$("org.apache.commons.lang.builder.HashCodeBuilder");
                class$org$apache$commons$lang$builder$HashCodeBuilder = cls;
            }
            synchronized (cls) {
                Set registry2 = getRegistry();
                if (registry2 != null && registry2.isEmpty()) {
                    REGISTRY.set(null);
                }
            }
        }
    }

    public HashCodeBuilder append(boolean z16) {
        this.iTotal = (this.iTotal * this.iConstant) + (!z16 ? 1 : 0);
        return this;
    }

    public HashCodeBuilder appendSuper(int i3) {
        this.iTotal = (this.iTotal * this.iConstant) + i3;
        return this;
    }

    public int hashCode() {
        return toHashCode();
    }

    public int toHashCode() {
        return this.iTotal;
    }

    public static int reflectionHashCode(int i3, int i16, Object obj, boolean z16) {
        return reflectionHashCode(i3, i16, obj, z16, null, null);
    }

    public HashCodeBuilder append(boolean[] zArr) {
        if (zArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (boolean z16 : zArr) {
                append(z16);
            }
        }
        return this;
    }

    public static int reflectionHashCode(int i3, int i16, Object obj, boolean z16, Class cls) {
        return reflectionHashCode(i3, i16, obj, z16, cls, null);
    }

    public HashCodeBuilder(int i3, int i16) {
        this.iTotal = 0;
        if (i3 != 0) {
            if (i3 % 2 == 0) {
                throw new IllegalArgumentException("HashCodeBuilder requires an odd initial value");
            }
            if (i16 != 0) {
                if (i16 % 2 != 0) {
                    this.iConstant = i16;
                    this.iTotal = i3;
                    return;
                }
                throw new IllegalArgumentException("HashCodeBuilder requires an odd multiplier");
            }
            throw new IllegalArgumentException("HashCodeBuilder requires a non zero multiplier");
        }
        throw new IllegalArgumentException("HashCodeBuilder requires a non zero initial value");
    }

    public static int reflectionHashCode(int i3, int i16, Object obj, boolean z16, Class cls, String[] strArr) {
        if (obj != null) {
            HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(i3, i16);
            Class<?> cls2 = obj.getClass();
            reflectionAppend(obj, cls2, hashCodeBuilder, z16, strArr);
            while (cls2.getSuperclass() != null && cls2 != cls) {
                cls2 = cls2.getSuperclass();
                reflectionAppend(obj, cls2, hashCodeBuilder, z16, strArr);
            }
            return hashCodeBuilder.toHashCode();
        }
        throw new IllegalArgumentException("The object to build a hash code for must not be null");
    }

    public HashCodeBuilder append(byte b16) {
        this.iTotal = (this.iTotal * this.iConstant) + b16;
        return this;
    }

    public HashCodeBuilder append(byte[] bArr) {
        if (bArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (byte b16 : bArr) {
                append(b16);
            }
        }
        return this;
    }

    public HashCodeBuilder append(char c16) {
        this.iTotal = (this.iTotal * this.iConstant) + c16;
        return this;
    }

    public HashCodeBuilder append(char[] cArr) {
        if (cArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (char c16 : cArr) {
                append(c16);
            }
        }
        return this;
    }

    public static int reflectionHashCode(Object obj) {
        return reflectionHashCode(17, 37, obj, false, null, null);
    }

    public static int reflectionHashCode(Object obj, boolean z16) {
        return reflectionHashCode(17, 37, obj, z16, null, null);
    }

    public HashCodeBuilder append(double d16) {
        return append(Double.doubleToLongBits(d16));
    }

    public static int reflectionHashCode(Object obj, Collection collection) {
        return reflectionHashCode(obj, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public HashCodeBuilder append(double[] dArr) {
        if (dArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (double d16 : dArr) {
                append(d16);
            }
        }
        return this;
    }

    public static int reflectionHashCode(Object obj, String[] strArr) {
        return reflectionHashCode(17, 37, obj, false, null, strArr);
    }

    public HashCodeBuilder append(float f16) {
        this.iTotal = (this.iTotal * this.iConstant) + Float.floatToIntBits(f16);
        return this;
    }

    public HashCodeBuilder append(float[] fArr) {
        if (fArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (float f16 : fArr) {
                append(f16);
            }
        }
        return this;
    }

    public HashCodeBuilder append(int i3) {
        this.iTotal = (this.iTotal * this.iConstant) + i3;
        return this;
    }

    public HashCodeBuilder append(int[] iArr) {
        if (iArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (int i3 : iArr) {
                append(i3);
            }
        }
        return this;
    }

    public HashCodeBuilder append(long j3) {
        this.iTotal = (this.iTotal * this.iConstant) + ((int) (j3 ^ (j3 >> 32)));
        return this;
    }

    public HashCodeBuilder append(long[] jArr) {
        if (jArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (long j3 : jArr) {
                append(j3);
            }
        }
        return this;
    }

    public HashCodeBuilder append(Object obj) {
        if (obj == null) {
            this.iTotal *= this.iConstant;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof long[]) {
                append((long[]) obj);
            } else if (obj instanceof int[]) {
                append((int[]) obj);
            } else if (obj instanceof short[]) {
                append((short[]) obj);
            } else if (obj instanceof char[]) {
                append((char[]) obj);
            } else if (obj instanceof byte[]) {
                append((byte[]) obj);
            } else if (obj instanceof double[]) {
                append((double[]) obj);
            } else if (obj instanceof float[]) {
                append((float[]) obj);
            } else if (obj instanceof boolean[]) {
                append((boolean[]) obj);
            } else {
                append((Object[]) obj);
            }
        } else {
            this.iTotal = (this.iTotal * this.iConstant) + obj.hashCode();
        }
        return this;
    }

    public HashCodeBuilder append(Object[] objArr) {
        if (objArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (Object obj : objArr) {
                append(obj);
            }
        }
        return this;
    }

    public HashCodeBuilder append(short s16) {
        this.iTotal = (this.iTotal * this.iConstant) + s16;
        return this;
    }

    public HashCodeBuilder append(short[] sArr) {
        if (sArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (short s16 : sArr) {
                append(s16);
            }
        }
        return this;
    }
}
