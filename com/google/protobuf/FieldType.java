package com.google.protobuf;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DOUBLE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class FieldType {
    private static final /* synthetic */ FieldType[] $VALUES;
    public static final FieldType BOOL;
    public static final FieldType BOOL_LIST;
    public static final FieldType BOOL_LIST_PACKED;
    public static final FieldType BYTES;
    public static final FieldType BYTES_LIST;
    public static final FieldType DOUBLE;
    public static final FieldType DOUBLE_LIST;
    public static final FieldType DOUBLE_LIST_PACKED;
    private static final Type[] EMPTY_TYPES;
    public static final FieldType ENUM;
    public static final FieldType ENUM_LIST;
    public static final FieldType ENUM_LIST_PACKED;
    public static final FieldType FIXED32;
    public static final FieldType FIXED32_LIST;
    public static final FieldType FIXED32_LIST_PACKED;
    public static final FieldType FIXED64;
    public static final FieldType FIXED64_LIST;
    public static final FieldType FIXED64_LIST_PACKED;
    public static final FieldType FLOAT;
    public static final FieldType FLOAT_LIST;
    public static final FieldType FLOAT_LIST_PACKED;

    /* renamed from: GROUP, reason: collision with root package name */
    public static final FieldType f35416GROUP;
    public static final FieldType GROUP_LIST;
    public static final FieldType INT32;
    public static final FieldType INT32_LIST;
    public static final FieldType INT32_LIST_PACKED;
    public static final FieldType INT64;
    public static final FieldType INT64_LIST;
    public static final FieldType INT64_LIST_PACKED;
    public static final FieldType MAP;
    public static final FieldType MESSAGE;
    public static final FieldType MESSAGE_LIST;
    public static final FieldType SFIXED32;
    public static final FieldType SFIXED32_LIST;
    public static final FieldType SFIXED32_LIST_PACKED;
    public static final FieldType SFIXED64;
    public static final FieldType SFIXED64_LIST;
    public static final FieldType SFIXED64_LIST_PACKED;
    public static final FieldType SINT32;
    public static final FieldType SINT32_LIST;
    public static final FieldType SINT32_LIST_PACKED;
    public static final FieldType SINT64;
    public static final FieldType SINT64_LIST;
    public static final FieldType SINT64_LIST_PACKED;
    public static final FieldType STRING;
    public static final FieldType STRING_LIST;
    public static final FieldType UINT32;
    public static final FieldType UINT32_LIST;
    public static final FieldType UINT32_LIST_PACKED;
    public static final FieldType UINT64;
    public static final FieldType UINT64_LIST;
    public static final FieldType UINT64_LIST_PACKED;
    private static final FieldType[] VALUES;
    private final Collection collection;
    private final Class<?> elementType;

    /* renamed from: id, reason: collision with root package name */
    private final int f35417id;
    private final JavaType javaType;
    private final boolean primitiveScalar;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    enum Collection {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);

        private final boolean isList;

        Collection(boolean z16) {
            this.isList = z16;
        }

        public boolean isList() {
            return this.isList;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35418a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f35419b;

        static {
            int[] iArr = new int[JavaType.values().length];
            f35419b = iArr;
            try {
                iArr[JavaType.BYTE_STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35419b[JavaType.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35419b[JavaType.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Collection.values().length];
            f35418a = iArr2;
            try {
                iArr2[Collection.MAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35418a[Collection.VECTOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35418a[Collection.SCALAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        Collection collection = Collection.SCALAR;
        JavaType javaType = JavaType.DOUBLE;
        FieldType fieldType = new FieldType("DOUBLE", 0, 0, collection, javaType);
        DOUBLE = fieldType;
        JavaType javaType2 = JavaType.FLOAT;
        FieldType fieldType2 = new FieldType("FLOAT", 1, 1, collection, javaType2);
        FLOAT = fieldType2;
        JavaType javaType3 = JavaType.LONG;
        FieldType fieldType3 = new FieldType("INT64", 2, 2, collection, javaType3);
        INT64 = fieldType3;
        FieldType fieldType4 = new FieldType("UINT64", 3, 3, collection, javaType3);
        UINT64 = fieldType4;
        JavaType javaType4 = JavaType.INT;
        FieldType fieldType5 = new FieldType("INT32", 4, 4, collection, javaType4);
        INT32 = fieldType5;
        FieldType fieldType6 = new FieldType("FIXED64", 5, 5, collection, javaType3);
        FIXED64 = fieldType6;
        FieldType fieldType7 = new FieldType("FIXED32", 6, 6, collection, javaType4);
        FIXED32 = fieldType7;
        JavaType javaType5 = JavaType.BOOLEAN;
        FieldType fieldType8 = new FieldType("BOOL", 7, 7, collection, javaType5);
        BOOL = fieldType8;
        JavaType javaType6 = JavaType.STRING;
        FieldType fieldType9 = new FieldType("STRING", 8, 8, collection, javaType6);
        STRING = fieldType9;
        JavaType javaType7 = JavaType.MESSAGE;
        FieldType fieldType10 = new FieldType("MESSAGE", 9, 9, collection, javaType7);
        MESSAGE = fieldType10;
        JavaType javaType8 = JavaType.BYTE_STRING;
        FieldType fieldType11 = new FieldType("BYTES", 10, 10, collection, javaType8);
        BYTES = fieldType11;
        FieldType fieldType12 = new FieldType("UINT32", 11, 11, collection, javaType4);
        UINT32 = fieldType12;
        JavaType javaType9 = JavaType.ENUM;
        FieldType fieldType13 = new FieldType("ENUM", 12, 12, collection, javaType9);
        ENUM = fieldType13;
        FieldType fieldType14 = new FieldType("SFIXED32", 13, 13, collection, javaType4);
        SFIXED32 = fieldType14;
        FieldType fieldType15 = new FieldType("SFIXED64", 14, 14, collection, javaType3);
        SFIXED64 = fieldType15;
        FieldType fieldType16 = new FieldType("SINT32", 15, 15, collection, javaType4);
        SINT32 = fieldType16;
        FieldType fieldType17 = new FieldType("SINT64", 16, 16, collection, javaType3);
        SINT64 = fieldType17;
        FieldType fieldType18 = new FieldType("GROUP", 17, 17, collection, javaType7);
        f35416GROUP = fieldType18;
        Collection collection2 = Collection.VECTOR;
        FieldType fieldType19 = new FieldType("DOUBLE_LIST", 18, 18, collection2, javaType);
        DOUBLE_LIST = fieldType19;
        FieldType fieldType20 = new FieldType("FLOAT_LIST", 19, 19, collection2, javaType2);
        FLOAT_LIST = fieldType20;
        FieldType fieldType21 = new FieldType("INT64_LIST", 20, 20, collection2, javaType3);
        INT64_LIST = fieldType21;
        FieldType fieldType22 = new FieldType("UINT64_LIST", 21, 21, collection2, javaType3);
        UINT64_LIST = fieldType22;
        FieldType fieldType23 = new FieldType("INT32_LIST", 22, 22, collection2, javaType4);
        INT32_LIST = fieldType23;
        FieldType fieldType24 = new FieldType("FIXED64_LIST", 23, 23, collection2, javaType3);
        FIXED64_LIST = fieldType24;
        FieldType fieldType25 = new FieldType("FIXED32_LIST", 24, 24, collection2, javaType4);
        FIXED32_LIST = fieldType25;
        FieldType fieldType26 = new FieldType("BOOL_LIST", 25, 25, collection2, javaType5);
        BOOL_LIST = fieldType26;
        FieldType fieldType27 = new FieldType("STRING_LIST", 26, 26, collection2, javaType6);
        STRING_LIST = fieldType27;
        FieldType fieldType28 = new FieldType("MESSAGE_LIST", 27, 27, collection2, javaType7);
        MESSAGE_LIST = fieldType28;
        FieldType fieldType29 = new FieldType("BYTES_LIST", 28, 28, collection2, javaType8);
        BYTES_LIST = fieldType29;
        FieldType fieldType30 = new FieldType("UINT32_LIST", 29, 29, collection2, javaType4);
        UINT32_LIST = fieldType30;
        FieldType fieldType31 = new FieldType("ENUM_LIST", 30, 30, collection2, javaType9);
        ENUM_LIST = fieldType31;
        FieldType fieldType32 = new FieldType("SFIXED32_LIST", 31, 31, collection2, javaType4);
        SFIXED32_LIST = fieldType32;
        FieldType fieldType33 = new FieldType("SFIXED64_LIST", 32, 32, collection2, javaType3);
        SFIXED64_LIST = fieldType33;
        FieldType fieldType34 = new FieldType("SINT32_LIST", 33, 33, collection2, javaType4);
        SINT32_LIST = fieldType34;
        FieldType fieldType35 = new FieldType("SINT64_LIST", 34, 34, collection2, javaType3);
        SINT64_LIST = fieldType35;
        Collection collection3 = Collection.PACKED_VECTOR;
        FieldType fieldType36 = new FieldType("DOUBLE_LIST_PACKED", 35, 35, collection3, javaType);
        DOUBLE_LIST_PACKED = fieldType36;
        FieldType fieldType37 = new FieldType("FLOAT_LIST_PACKED", 36, 36, collection3, javaType2);
        FLOAT_LIST_PACKED = fieldType37;
        FieldType fieldType38 = new FieldType("INT64_LIST_PACKED", 37, 37, collection3, javaType3);
        INT64_LIST_PACKED = fieldType38;
        FieldType fieldType39 = new FieldType("UINT64_LIST_PACKED", 38, 38, collection3, javaType3);
        UINT64_LIST_PACKED = fieldType39;
        FieldType fieldType40 = new FieldType("INT32_LIST_PACKED", 39, 39, collection3, javaType4);
        INT32_LIST_PACKED = fieldType40;
        FieldType fieldType41 = new FieldType("FIXED64_LIST_PACKED", 40, 40, collection3, javaType3);
        FIXED64_LIST_PACKED = fieldType41;
        FieldType fieldType42 = new FieldType("FIXED32_LIST_PACKED", 41, 41, collection3, javaType4);
        FIXED32_LIST_PACKED = fieldType42;
        FieldType fieldType43 = new FieldType("BOOL_LIST_PACKED", 42, 42, collection3, javaType5);
        BOOL_LIST_PACKED = fieldType43;
        FieldType fieldType44 = new FieldType("UINT32_LIST_PACKED", 43, 43, collection3, javaType4);
        UINT32_LIST_PACKED = fieldType44;
        FieldType fieldType45 = new FieldType("ENUM_LIST_PACKED", 44, 44, collection3, javaType9);
        ENUM_LIST_PACKED = fieldType45;
        FieldType fieldType46 = new FieldType("SFIXED32_LIST_PACKED", 45, 45, collection3, javaType4);
        SFIXED32_LIST_PACKED = fieldType46;
        FieldType fieldType47 = new FieldType("SFIXED64_LIST_PACKED", 46, 46, collection3, javaType3);
        SFIXED64_LIST_PACKED = fieldType47;
        FieldType fieldType48 = new FieldType("SINT32_LIST_PACKED", 47, 47, collection3, javaType4);
        SINT32_LIST_PACKED = fieldType48;
        FieldType fieldType49 = new FieldType("SINT64_LIST_PACKED", 48, 48, collection3, javaType3);
        SINT64_LIST_PACKED = fieldType49;
        FieldType fieldType50 = new FieldType("GROUP_LIST", 49, 49, collection2, javaType7);
        GROUP_LIST = fieldType50;
        FieldType fieldType51 = new FieldType("MAP", 50, 50, Collection.MAP, JavaType.VOID);
        MAP = fieldType51;
        $VALUES = new FieldType[]{fieldType, fieldType2, fieldType3, fieldType4, fieldType5, fieldType6, fieldType7, fieldType8, fieldType9, fieldType10, fieldType11, fieldType12, fieldType13, fieldType14, fieldType15, fieldType16, fieldType17, fieldType18, fieldType19, fieldType20, fieldType21, fieldType22, fieldType23, fieldType24, fieldType25, fieldType26, fieldType27, fieldType28, fieldType29, fieldType30, fieldType31, fieldType32, fieldType33, fieldType34, fieldType35, fieldType36, fieldType37, fieldType38, fieldType39, fieldType40, fieldType41, fieldType42, fieldType43, fieldType44, fieldType45, fieldType46, fieldType47, fieldType48, fieldType49, fieldType50, fieldType51};
        EMPTY_TYPES = new Type[0];
        FieldType[] values = values();
        VALUES = new FieldType[values.length];
        for (FieldType fieldType52 : values) {
            VALUES[fieldType52.f35417id] = fieldType52;
        }
    }

    FieldType(String str, int i3, int i16, Collection collection, JavaType javaType) {
        int i17;
        this.f35417id = i16;
        this.collection = collection;
        this.javaType = javaType;
        int i18 = a.f35418a[collection.ordinal()];
        if (i18 != 1) {
            if (i18 != 2) {
                this.elementType = null;
            } else {
                this.elementType = javaType.getBoxedType();
            }
        } else {
            this.elementType = javaType.getBoxedType();
        }
        this.primitiveScalar = (collection != Collection.SCALAR || (i17 = a.f35419b[javaType.ordinal()]) == 1 || i17 == 2 || i17 == 3) ? false : true;
    }

    public static FieldType forId(int i3) {
        if (i3 >= 0) {
            FieldType[] fieldTypeArr = VALUES;
            if (i3 < fieldTypeArr.length) {
                return fieldTypeArr[i3];
            }
            return null;
        }
        return null;
    }

    private static Type getGenericSuperList(Class<?> cls) {
        for (Type type : cls.getGenericInterfaces()) {
            if ((type instanceof ParameterizedType) && List.class.isAssignableFrom((Class) ((ParameterizedType) type).getRawType())) {
                return type;
            }
        }
        Type genericSuperclass = cls.getGenericSuperclass();
        if ((genericSuperclass instanceof ParameterizedType) && List.class.isAssignableFrom((Class) ((ParameterizedType) genericSuperclass).getRawType())) {
            return genericSuperclass;
        }
        return null;
    }

    private static Type getListParameter(Class<?> cls, Type[] typeArr) {
        boolean z16;
        while (true) {
            int i3 = 0;
            if (cls != List.class) {
                Type genericSuperList = getGenericSuperList(cls);
                if (genericSuperList instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) genericSuperList;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i16 = 0; i16 < actualTypeArguments.length; i16++) {
                        Type type = actualTypeArguments[i16];
                        if (type instanceof TypeVariable) {
                            TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
                            if (typeArr.length == typeParameters.length) {
                                int i17 = 0;
                                while (true) {
                                    if (i17 < typeParameters.length) {
                                        if (type == typeParameters[i17]) {
                                            actualTypeArguments[i16] = typeArr[i17];
                                            z16 = true;
                                            break;
                                        }
                                        i17++;
                                    } else {
                                        z16 = false;
                                        break;
                                    }
                                }
                                if (!z16) {
                                    throw new RuntimeException("Unable to find replacement for " + type);
                                }
                            } else {
                                throw new RuntimeException("Type array mismatch");
                            }
                        }
                    }
                    cls = (Class) parameterizedType.getRawType();
                    typeArr = actualTypeArguments;
                } else {
                    typeArr = EMPTY_TYPES;
                    Class<?>[] interfaces = cls.getInterfaces();
                    int length = interfaces.length;
                    while (true) {
                        if (i3 < length) {
                            Class<?> cls2 = interfaces[i3];
                            if (List.class.isAssignableFrom(cls2)) {
                                cls = cls2;
                                break;
                            }
                            i3++;
                        } else {
                            cls = cls.getSuperclass();
                            break;
                        }
                    }
                }
            } else {
                if (typeArr.length == 1) {
                    return typeArr[0];
                }
                throw new RuntimeException("Unable to identify parameter type for List<T>");
            }
        }
    }

    private boolean isValidForList(Field field) {
        Class<?> type = field.getType();
        if (!this.javaType.getType().isAssignableFrom(type)) {
            return false;
        }
        Type[] typeArr = EMPTY_TYPES;
        if (field.getGenericType() instanceof ParameterizedType) {
            typeArr = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
        }
        Type listParameter = getListParameter(type, typeArr);
        if (!(listParameter instanceof Class)) {
            return true;
        }
        return this.elementType.isAssignableFrom((Class) listParameter);
    }

    public static FieldType valueOf(String str) {
        return (FieldType) Enum.valueOf(FieldType.class, str);
    }

    public static FieldType[] values() {
        return (FieldType[]) $VALUES.clone();
    }

    public JavaType getJavaType() {
        return this.javaType;
    }

    public int id() {
        return this.f35417id;
    }

    public boolean isList() {
        return this.collection.isList();
    }

    public boolean isMap() {
        if (this.collection == Collection.MAP) {
            return true;
        }
        return false;
    }

    public boolean isPacked() {
        return Collection.PACKED_VECTOR.equals(this.collection);
    }

    public boolean isPrimitiveScalar() {
        return this.primitiveScalar;
    }

    public boolean isScalar() {
        if (this.collection == Collection.SCALAR) {
            return true;
        }
        return false;
    }

    public boolean isValidForField(Field field) {
        if (Collection.VECTOR.equals(this.collection)) {
            return isValidForList(field);
        }
        return this.javaType.getType().isAssignableFrom(field.getType());
    }
}
