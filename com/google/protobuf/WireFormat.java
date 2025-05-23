package com.google.protobuf;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class WireFormat {

    /* renamed from: a, reason: collision with root package name */
    static final int f35627a = c(1, 3);

    /* renamed from: b, reason: collision with root package name */
    static final int f35628b = c(1, 4);

    /* renamed from: c, reason: collision with root package name */
    static final int f35629c = c(2, 0);

    /* renamed from: d, reason: collision with root package name */
    static final int f35630d = c(3, 2);

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INT64' uses external variables
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
    public static class FieldType {
        private static final /* synthetic */ FieldType[] $VALUES;
        public static final FieldType BOOL;
        public static final FieldType BYTES;
        public static final FieldType DOUBLE;
        public static final FieldType ENUM;
        public static final FieldType FIXED32;
        public static final FieldType FIXED64;
        public static final FieldType FLOAT;

        /* renamed from: GROUP, reason: collision with root package name */
        public static final FieldType f35631GROUP;
        public static final FieldType INT32;
        public static final FieldType INT64;
        public static final FieldType MESSAGE;
        public static final FieldType SFIXED32;
        public static final FieldType SFIXED64;
        public static final FieldType SINT32;
        public static final FieldType SINT64;
        public static final FieldType STRING;
        public static final FieldType UINT32;
        public static final FieldType UINT64;
        private final JavaType javaType;
        private final int wireType;

        static {
            FieldType fieldType = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            DOUBLE = fieldType;
            FieldType fieldType2 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            FLOAT = fieldType2;
            JavaType javaType = JavaType.LONG;
            FieldType fieldType3 = new FieldType("INT64", 2, javaType, 0);
            INT64 = fieldType3;
            FieldType fieldType4 = new FieldType("UINT64", 3, javaType, 0);
            UINT64 = fieldType4;
            JavaType javaType2 = JavaType.INT;
            FieldType fieldType5 = new FieldType("INT32", 4, javaType2, 0);
            INT32 = fieldType5;
            FieldType fieldType6 = new FieldType("FIXED64", 5, javaType, 1);
            FIXED64 = fieldType6;
            FieldType fieldType7 = new FieldType("FIXED32", 6, javaType2, 5);
            FIXED32 = fieldType7;
            FieldType fieldType8 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            BOOL = fieldType8;
            FieldType fieldType9 = new FieldType("STRING", 8, JavaType.STRING, 2) { // from class: com.google.protobuf.WireFormat.FieldType.1
                {
                    a aVar = null;
                }

                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    return false;
                }
            };
            STRING = fieldType9;
            JavaType javaType3 = JavaType.MESSAGE;
            FieldType fieldType10 = new FieldType("GROUP", 9, javaType3, 3) { // from class: com.google.protobuf.WireFormat.FieldType.2
                {
                    a aVar = null;
                }

                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    return false;
                }
            };
            f35631GROUP = fieldType10;
            int i3 = 2;
            FieldType fieldType11 = new FieldType("MESSAGE", 10, javaType3, i3) { // from class: com.google.protobuf.WireFormat.FieldType.3
                {
                    a aVar = null;
                }

                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    return false;
                }
            };
            MESSAGE = fieldType11;
            FieldType fieldType12 = new FieldType("BYTES", 11, JavaType.BYTE_STRING, i3) { // from class: com.google.protobuf.WireFormat.FieldType.4
                {
                    a aVar = null;
                }

                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    return false;
                }
            };
            BYTES = fieldType12;
            FieldType fieldType13 = new FieldType("UINT32", 12, javaType2, 0);
            UINT32 = fieldType13;
            FieldType fieldType14 = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            ENUM = fieldType14;
            FieldType fieldType15 = new FieldType("SFIXED32", 14, javaType2, 5);
            SFIXED32 = fieldType15;
            FieldType fieldType16 = new FieldType("SFIXED64", 15, javaType, 1);
            SFIXED64 = fieldType16;
            FieldType fieldType17 = new FieldType("SINT32", 16, javaType2, 0);
            SINT32 = fieldType17;
            FieldType fieldType18 = new FieldType("SINT64", 17, javaType, 0);
            SINT64 = fieldType18;
            $VALUES = new FieldType[]{fieldType, fieldType2, fieldType3, fieldType4, fieldType5, fieldType6, fieldType7, fieldType8, fieldType9, fieldType10, fieldType11, fieldType12, fieldType13, fieldType14, fieldType15, fieldType16, fieldType17, fieldType18};
        }

        /* synthetic */ FieldType(String str, int i3, JavaType javaType, int i16, a aVar) {
            this(str, i3, javaType, i16);
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

        public int getWireType() {
            return this.wireType;
        }

        public boolean isPackable() {
            return true;
        }

        FieldType(String str, int i3, JavaType javaType, int i16) {
            this.javaType = javaType;
            this.wireType = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(ByteString.EMPTY),
        ENUM(null),
        MESSAGE(null);

        private final Object defaultDefault;

        JavaType(Object obj) {
            this.defaultDefault = obj;
        }

        Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    enum Utf8Validation {
        LOOSE { // from class: com.google.protobuf.WireFormat.Utf8Validation.1
            @Override // com.google.protobuf.WireFormat.Utf8Validation
            Object readString(k kVar) throws IOException {
                return kVar.H();
            }
        },
        STRICT { // from class: com.google.protobuf.WireFormat.Utf8Validation.2
            @Override // com.google.protobuf.WireFormat.Utf8Validation
            Object readString(k kVar) throws IOException {
                return kVar.I();
            }
        },
        LAZY { // from class: com.google.protobuf.WireFormat.Utf8Validation.3
            @Override // com.google.protobuf.WireFormat.Utf8Validation
            Object readString(k kVar) throws IOException {
                return kVar.q();
            }
        };

        abstract Object readString(k kVar) throws IOException;

        /* synthetic */ Utf8Validation(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35632a;

        static {
            int[] iArr = new int[FieldType.values().length];
            f35632a = iArr;
            try {
                iArr[FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35632a[FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35632a[FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35632a[FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35632a[FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35632a[FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35632a[FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35632a[FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35632a[FieldType.BYTES.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35632a[FieldType.UINT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35632a[FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35632a[FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f35632a[FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f35632a[FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f35632a[FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f35632a[FieldType.f35631GROUP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f35632a[FieldType.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f35632a[FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    public static int a(int i3) {
        return i3 >>> 3;
    }

    public static int b(int i3) {
        return i3 & 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i3, int i16) {
        return (i3 << 3) | i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object d(k kVar, FieldType fieldType, Utf8Validation utf8Validation) throws IOException {
        switch (a.f35632a[fieldType.ordinal()]) {
            case 1:
                return Double.valueOf(kVar.r());
            case 2:
                return Float.valueOf(kVar.v());
            case 3:
                return Long.valueOf(kVar.y());
            case 4:
                return Long.valueOf(kVar.L());
            case 5:
                return Integer.valueOf(kVar.x());
            case 6:
                return Long.valueOf(kVar.u());
            case 7:
                return Integer.valueOf(kVar.t());
            case 8:
                return Boolean.valueOf(kVar.p());
            case 9:
                return kVar.q();
            case 10:
                return Integer.valueOf(kVar.K());
            case 11:
                return Integer.valueOf(kVar.D());
            case 12:
                return Long.valueOf(kVar.E());
            case 13:
                return Integer.valueOf(kVar.F());
            case 14:
                return Long.valueOf(kVar.G());
            case 15:
                return utf8Validation.readString(kVar);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
