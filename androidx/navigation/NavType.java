package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.AnyRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.io.Serializable;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class NavType<T> {

    @NonNull
    public static final NavType<boolean[]> BoolArrayType;

    @NonNull
    public static final NavType<Boolean> BoolType;

    @NonNull
    public static final NavType<float[]> FloatArrayType;

    @NonNull
    public static final NavType<Float> FloatType;

    @NonNull
    public static final NavType<int[]> IntArrayType;

    @NonNull
    public static final NavType<Integer> IntType;

    @NonNull
    public static final NavType<long[]> LongArrayType;

    @NonNull
    public static final NavType<Long> LongType;

    @NonNull
    public static final NavType<Integer> ReferenceType;

    @NonNull
    public static final NavType<String[]> StringArrayType;

    @NonNull
    public static final NavType<String> StringType;
    private final boolean mNullableAllowed;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {

        @NonNull
        private final Class<D[]> mArrayType;

        public ParcelableArrayType(@NonNull Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.mArrayType = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                    return;
                } catch (ClassNotFoundException e16) {
                    throw new RuntimeException(e16);
                }
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ParcelableArrayType.class == obj.getClass()) {
                return this.mArrayType.equals(((ParcelableArrayType) obj).mArrayType);
            }
            return false;
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return this.mArrayType.getName();
        }

        public int hashCode() {
            return this.mArrayType.hashCode();
        }

        @Override // androidx.navigation.NavType
        @Nullable
        public D[] get(@NonNull Bundle bundle, @NonNull String str) {
            return (D[]) ((Parcelable[]) bundle.get(str));
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public D[] parseValue(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable D[] dArr) {
            this.mArrayType.cast(dArr);
            bundle.putParcelableArray(str, dArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class ParcelableType<D> extends NavType<D> {

        @NonNull
        private final Class<D> mType;

        public ParcelableType(@NonNull Class<D> cls) {
            super(true);
            if (!Parcelable.class.isAssignableFrom(cls) && !Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
            }
            this.mType = cls;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ParcelableType.class == obj.getClass()) {
                return this.mType.equals(((ParcelableType) obj).mType);
            }
            return false;
        }

        @Override // androidx.navigation.NavType
        @Nullable
        public D get(@NonNull Bundle bundle, @NonNull String str) {
            return (D) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return this.mType.getName();
        }

        public int hashCode() {
            return this.mType.hashCode();
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public D parseValue(@NonNull String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable D d16) {
            this.mType.cast(d16);
            if (d16 != null && !(d16 instanceof Parcelable)) {
                if (d16 instanceof Serializable) {
                    bundle.putSerializable(str, (Serializable) d16);
                    return;
                }
                return;
            }
            bundle.putParcelable(str, (Parcelable) d16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {

        @NonNull
        private final Class<D[]> mArrayType;

        public SerializableArrayType(@NonNull Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.mArrayType = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                    return;
                } catch (ClassNotFoundException e16) {
                    throw new RuntimeException(e16);
                }
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SerializableArrayType.class == obj.getClass()) {
                return this.mArrayType.equals(((SerializableArrayType) obj).mArrayType);
            }
            return false;
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return this.mArrayType.getName();
        }

        public int hashCode() {
            return this.mArrayType.hashCode();
        }

        @Override // androidx.navigation.NavType
        @Nullable
        public D[] get(@NonNull Bundle bundle, @NonNull String str) {
            return (D[]) ((Serializable[]) bundle.get(str));
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public D[] parseValue(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable D[] dArr) {
            this.mArrayType.cast(dArr);
            bundle.putSerializable(str, dArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SerializableType<D extends Serializable> extends NavType<D> {

        @NonNull
        private final Class<D> mType;

        public SerializableType(@NonNull Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                if (!cls.isEnum()) {
                    this.mType = cls;
                    return;
                }
                throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableType)) {
                return false;
            }
            return this.mType.equals(((SerializableType) obj).mType);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return this.mType.getName();
        }

        public int hashCode() {
            return this.mType.hashCode();
        }

        @Override // androidx.navigation.NavType
        @Nullable
        public D get(@NonNull Bundle bundle, @NonNull String str) {
            return (D) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public D parseValue(@NonNull String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable D d16) {
            this.mType.cast(d16);
            bundle.putSerializable(str, d16);
        }

        SerializableType(boolean z16, @NonNull Class<D> cls) {
            super(z16);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.mType = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }
    }

    static {
        boolean z16 = false;
        IntType = new NavType<Integer>(z16) { // from class: androidx.navigation.NavType.1
            @Override // androidx.navigation.NavType
            @NonNull
            public String getName() {
                return "integer";
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.navigation.NavType
            public Integer get(@NonNull Bundle bundle, @NonNull String str) {
                return (Integer) bundle.get(str);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.navigation.NavType
            @NonNull
            public Integer parseValue(@NonNull String str) {
                if (str.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING)) {
                    return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
                }
                return Integer.valueOf(Integer.parseInt(str));
            }

            @Override // androidx.navigation.NavType
            public void put(@NonNull Bundle bundle, @NonNull String str, @NonNull Integer num) {
                bundle.putInt(str, num.intValue());
            }
        };
        ReferenceType = new NavType<Integer>(z16) { // from class: androidx.navigation.NavType.2
            @Override // androidx.navigation.NavType
            @NonNull
            public String getName() {
                return "reference";
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.navigation.NavType
            @AnyRes
            public Integer get(@NonNull Bundle bundle, @NonNull String str) {
                return (Integer) bundle.get(str);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.navigation.NavType
            @NonNull
            public Integer parseValue(@NonNull String str) {
                throw new UnsupportedOperationException("References don't support parsing string values.");
            }

            @Override // androidx.navigation.NavType
            public void put(@NonNull Bundle bundle, @NonNull String str, @NonNull @AnyRes Integer num) {
                bundle.putInt(str, num.intValue());
            }
        };
        boolean z17 = true;
        IntArrayType = new NavType<int[]>(z17) { // from class: androidx.navigation.NavType.3
            @Override // androidx.navigation.NavType
            @NonNull
            public String getName() {
                return "integer[]";
            }

            @Override // androidx.navigation.NavType
            public int[] get(@NonNull Bundle bundle, @NonNull String str) {
                return (int[]) bundle.get(str);
            }

            @Override // androidx.navigation.NavType
            @NonNull
            public int[] parseValue(@NonNull String str) {
                throw new UnsupportedOperationException("Arrays don't support default values.");
            }

            @Override // androidx.navigation.NavType
            public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable int[] iArr) {
                bundle.putIntArray(str, iArr);
            }
        };
        LongType = new NavType<Long>(z16) { // from class: androidx.navigation.NavType.4
            @Override // androidx.navigation.NavType
            @NonNull
            public String getName() {
                return PoiListCacheRecord.TIMESTAMP_TYPE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.navigation.NavType
            public Long get(@NonNull Bundle bundle, @NonNull String str) {
                return (Long) bundle.get(str);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.navigation.NavType
            @NonNull
            public Long parseValue(@NonNull String str) {
                if (str.endsWith("L")) {
                    str = str.substring(0, str.length() - 1);
                }
                if (str.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING)) {
                    return Long.valueOf(Long.parseLong(str.substring(2), 16));
                }
                return Long.valueOf(Long.parseLong(str));
            }

            @Override // androidx.navigation.NavType
            public void put(@NonNull Bundle bundle, @NonNull String str, @NonNull Long l3) {
                bundle.putLong(str, l3.longValue());
            }
        };
        LongArrayType = new NavType<long[]>(z17) { // from class: androidx.navigation.NavType.5
            @Override // androidx.navigation.NavType
            @NonNull
            public String getName() {
                return "long[]";
            }

            @Override // androidx.navigation.NavType
            public long[] get(@NonNull Bundle bundle, @NonNull String str) {
                return (long[]) bundle.get(str);
            }

            @Override // androidx.navigation.NavType
            @NonNull
            public long[] parseValue(@NonNull String str) {
                throw new UnsupportedOperationException("Arrays don't support default values.");
            }

            @Override // androidx.navigation.NavType
            public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable long[] jArr) {
                bundle.putLongArray(str, jArr);
            }
        };
        FloatType = new NavType<Float>(z16) { // from class: androidx.navigation.NavType.6
            @Override // androidx.navigation.NavType
            @NonNull
            public String getName() {
                return "float";
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.navigation.NavType
            public Float get(@NonNull Bundle bundle, @NonNull String str) {
                return (Float) bundle.get(str);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.navigation.NavType
            @NonNull
            public Float parseValue(@NonNull String str) {
                return Float.valueOf(Float.parseFloat(str));
            }

            @Override // androidx.navigation.NavType
            public void put(@NonNull Bundle bundle, @NonNull String str, @NonNull Float f16) {
                bundle.putFloat(str, f16.floatValue());
            }
        };
        FloatArrayType = new NavType<float[]>(z17) { // from class: androidx.navigation.NavType.7
            @Override // androidx.navigation.NavType
            @NonNull
            public String getName() {
                return "float[]";
            }

            @Override // androidx.navigation.NavType
            public float[] get(@NonNull Bundle bundle, @NonNull String str) {
                return (float[]) bundle.get(str);
            }

            @Override // androidx.navigation.NavType
            @NonNull
            public float[] parseValue(@NonNull String str) {
                throw new UnsupportedOperationException("Arrays don't support default values.");
            }

            @Override // androidx.navigation.NavType
            public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable float[] fArr) {
                bundle.putFloatArray(str, fArr);
            }
        };
        BoolType = new NavType<Boolean>(z16) { // from class: androidx.navigation.NavType.8
            @Override // androidx.navigation.NavType
            @NonNull
            public String getName() {
                return HippyControllerProps.BOOLEAN;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.navigation.NavType
            public Boolean get(@NonNull Bundle bundle, @NonNull String str) {
                return (Boolean) bundle.get(str);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.navigation.NavType
            @NonNull
            public Boolean parseValue(@NonNull String str) {
                if ("true".equals(str)) {
                    return Boolean.TRUE;
                }
                if ("false".equals(str)) {
                    return Boolean.FALSE;
                }
                throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
            }

            @Override // androidx.navigation.NavType
            public void put(@NonNull Bundle bundle, @NonNull String str, @NonNull Boolean bool) {
                bundle.putBoolean(str, bool.booleanValue());
            }
        };
        BoolArrayType = new NavType<boolean[]>(z17) { // from class: androidx.navigation.NavType.9
            @Override // androidx.navigation.NavType
            @NonNull
            public String getName() {
                return "boolean[]";
            }

            @Override // androidx.navigation.NavType
            public boolean[] get(@NonNull Bundle bundle, @NonNull String str) {
                return (boolean[]) bundle.get(str);
            }

            @Override // androidx.navigation.NavType
            @NonNull
            public boolean[] parseValue(@NonNull String str) {
                throw new UnsupportedOperationException("Arrays don't support default values.");
            }

            @Override // androidx.navigation.NavType
            public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable boolean[] zArr) {
                bundle.putBooleanArray(str, zArr);
            }
        };
        StringType = new NavType<String>(z17) { // from class: androidx.navigation.NavType.10
            @Override // androidx.navigation.NavType
            @NonNull
            public String getName() {
                return HippyControllerProps.STRING;
            }

            @Override // androidx.navigation.NavType
            @NonNull
            public String parseValue(@NonNull String str) {
                return str;
            }

            @Override // androidx.navigation.NavType
            public String get(@NonNull Bundle bundle, @NonNull String str) {
                return (String) bundle.get(str);
            }

            @Override // androidx.navigation.NavType
            public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable String str2) {
                bundle.putString(str, str2);
            }
        };
        StringArrayType = new NavType<String[]>(z17) { // from class: androidx.navigation.NavType.11
            @Override // androidx.navigation.NavType
            @NonNull
            public String getName() {
                return "string[]";
            }

            @Override // androidx.navigation.NavType
            public String[] get(@NonNull Bundle bundle, @NonNull String str) {
                return (String[]) bundle.get(str);
            }

            @Override // androidx.navigation.NavType
            @NonNull
            public String[] parseValue(@NonNull String str) {
                throw new UnsupportedOperationException("Arrays don't support default values.");
            }

            @Override // androidx.navigation.NavType
            public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable String[] strArr) {
                bundle.putStringArray(str, strArr);
            }
        };
    }

    NavType(boolean z16) {
        this.mNullableAllowed = z16;
    }

    @NonNull
    public static NavType<?> fromArgType(@Nullable String str, @Nullable String str2) {
        String str3;
        NavType<Integer> navType = IntType;
        if (navType.getName().equals(str)) {
            return navType;
        }
        NavType navType2 = IntArrayType;
        if (navType2.getName().equals(str)) {
            return navType2;
        }
        NavType<Long> navType3 = LongType;
        if (navType3.getName().equals(str)) {
            return navType3;
        }
        NavType navType4 = LongArrayType;
        if (navType4.getName().equals(str)) {
            return navType4;
        }
        NavType<Boolean> navType5 = BoolType;
        if (navType5.getName().equals(str)) {
            return navType5;
        }
        NavType navType6 = BoolArrayType;
        if (navType6.getName().equals(str)) {
            return navType6;
        }
        NavType<String> navType7 = StringType;
        if (navType7.getName().equals(str)) {
            return navType7;
        }
        NavType navType8 = StringArrayType;
        if (navType8.getName().equals(str)) {
            return navType8;
        }
        NavType<Float> navType9 = FloatType;
        if (navType9.getName().equals(str)) {
            return navType9;
        }
        NavType navType10 = FloatArrayType;
        if (navType10.getName().equals(str)) {
            return navType10;
        }
        NavType<Integer> navType11 = ReferenceType;
        if (navType11.getName().equals(str)) {
            return navType11;
        }
        if (str != null && !str.isEmpty()) {
            try {
                if (str.startsWith(".") && str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                if (str.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                    str3 = str3.substring(0, str3.length() - 2);
                    Class<?> cls = Class.forName(str3);
                    if (Parcelable.class.isAssignableFrom(cls)) {
                        return new ParcelableArrayType(cls);
                    }
                    if (Serializable.class.isAssignableFrom(cls)) {
                        return new SerializableArrayType(cls);
                    }
                } else {
                    Class<?> cls2 = Class.forName(str3);
                    if (Parcelable.class.isAssignableFrom(cls2)) {
                        return new ParcelableType(cls2);
                    }
                    if (Enum.class.isAssignableFrom(cls2)) {
                        return new EnumType(cls2);
                    }
                    if (Serializable.class.isAssignableFrom(cls2)) {
                        return new SerializableType(cls2);
                    }
                }
                throw new IllegalArgumentException(str3 + " is not Serializable or Parcelable.");
            } catch (ClassNotFoundException e16) {
                throw new RuntimeException(e16);
            }
        }
        return navType7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static NavType inferFromValue(@NonNull String str) {
        try {
            try {
                try {
                    try {
                        NavType<Integer> navType = IntType;
                        navType.parseValue(str);
                        return navType;
                    } catch (IllegalArgumentException unused) {
                        return StringType;
                    }
                } catch (IllegalArgumentException unused2) {
                    NavType<Long> navType2 = LongType;
                    navType2.parseValue(str);
                    return navType2;
                }
            } catch (IllegalArgumentException unused3) {
                NavType<Float> navType3 = FloatType;
                navType3.parseValue(str);
                return navType3;
            }
        } catch (IllegalArgumentException unused4) {
            NavType<Boolean> navType4 = BoolType;
            navType4.parseValue(str);
            return navType4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static NavType inferFromValueType(@Nullable Object obj) {
        if (obj instanceof Integer) {
            return IntType;
        }
        if (obj instanceof int[]) {
            return IntArrayType;
        }
        if (obj instanceof Long) {
            return LongType;
        }
        if (obj instanceof long[]) {
            return LongArrayType;
        }
        if (obj instanceof Float) {
            return FloatType;
        }
        if (obj instanceof float[]) {
            return FloatArrayType;
        }
        if (obj instanceof Boolean) {
            return BoolType;
        }
        if (obj instanceof boolean[]) {
            return BoolArrayType;
        }
        if (!(obj instanceof String) && obj != null) {
            if (obj instanceof String[]) {
                return StringArrayType;
            }
            if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                return new ParcelableArrayType(obj.getClass().getComponentType());
            }
            if (obj.getClass().isArray() && Serializable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                return new SerializableArrayType(obj.getClass().getComponentType());
            }
            if (obj instanceof Parcelable) {
                return new ParcelableType(obj.getClass());
            }
            if (obj instanceof Enum) {
                return new EnumType(obj.getClass());
            }
            if (obj instanceof Serializable) {
                return new SerializableType(obj.getClass());
            }
            throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
        }
        return StringType;
    }

    @Nullable
    public abstract T get(@NonNull Bundle bundle, @NonNull String str);

    @NonNull
    public abstract String getName();

    public boolean isNullableAllowed() {
        return this.mNullableAllowed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public T parseAndPut(@NonNull Bundle bundle, @NonNull String str, @NonNull String str2) {
        T parseValue = parseValue(str2);
        put(bundle, str, parseValue);
        return parseValue;
    }

    @NonNull
    public abstract T parseValue(@NonNull String str);

    public abstract void put(@NonNull Bundle bundle, @NonNull String str, @Nullable T t16);

    @NonNull
    public String toString() {
        return getName();
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class EnumType<D extends Enum> extends SerializableType<D> {

        @NonNull
        private final Class<D> mType;

        public EnumType(@NonNull Class<D> cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.mType = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        @NonNull
        public String getName() {
            return this.mType.getName();
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        @NonNull
        public D parseValue(@NonNull String str) {
            for (D d16 : this.mType.getEnumConstants()) {
                if (d16.name().equals(str)) {
                    return d16;
                }
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.mType.getName() + ".");
        }
    }
}
