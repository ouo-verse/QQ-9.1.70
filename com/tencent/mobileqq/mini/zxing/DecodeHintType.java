package com.tencent.mobileqq.mini.zxing;

import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DecodeHintType {
    public final String name;
    private final Class<?> valueType;
    public static final DecodeHintType OTHER = new DecodeHintType("OTHER", Object.class);
    public static final DecodeHintType PURE_BARCODE = new DecodeHintType("PURE_BARCODE", Void.class);
    public static final DecodeHintType POSSIBLE_FORMATS = new DecodeHintType("POSSIBLE_FORMATS", List.class);
    public static final DecodeHintType TRY_HARDER = new DecodeHintType("TRY_HARDER", Void.class);
    public static final DecodeHintType CHARACTER_SET = new DecodeHintType("CHARACTER_SET", String.class);
    public static final DecodeHintType ALLOWED_LENGTHS = new DecodeHintType("ALLOWED_LENGTHS", int[].class);
    public static final DecodeHintType ASSUME_CODE_39_CHECK_DIGIT = new DecodeHintType("ASSUME_CODE_39_CHECK_DIGIT", Void.class);
    public static final DecodeHintType ASSUME_GS1 = new DecodeHintType("ASSUME_GS1", Void.class);
    public static final DecodeHintType RETURN_CODABAR_START_END = new DecodeHintType("RETURN_CODABAR_START_END", Void.class);
    public static final DecodeHintType NEED_RESULT_POINT_CALLBACK = new DecodeHintType("NEED_RESULT_POINT_CALLBACK", ResultPointCallback.class);
    public static final DecodeHintType ALLOWED_EAN_EXTENSIONS = new DecodeHintType("ALLOWED_EAN_EXTENSIONS", int[].class);

    DecodeHintType(String str, Class<?> cls) {
        this.name = str;
        this.valueType = cls;
    }

    public Class<?> getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.valueType.hashCode();
    }

    public String toString() {
        return "DecodeHintType{valueType=" + this.valueType + ", name='" + this.name + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DecodeHintType decodeHintType = (DecodeHintType) obj;
        return this.valueType.equals(decodeHintType.valueType) && this.name.equals(decodeHintType.name);
    }
}
