package com.tencent.mobileqq.mini.zxing;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ResultMetadataType {
    public final String type;
    public static final ResultMetadataType OTHER = new ResultMetadataType("OTHER");
    public static final ResultMetadataType ORIENTATION = new ResultMetadataType("ORIENTATION");
    public static final ResultMetadataType BYTE_SEGMENTS = new ResultMetadataType("BYTE_SEGMENTS");
    public static final ResultMetadataType ERROR_CORRECTION_LEVEL = new ResultMetadataType("ERROR_CORRECTION_LEVEL");
    public static final ResultMetadataType ISSUE_NUMBER = new ResultMetadataType("ISSUE_NUMBER");
    public static final ResultMetadataType SUGGESTED_PRICE = new ResultMetadataType("SUGGESTED_PRICE");
    public static final ResultMetadataType POSSIBLE_COUNTRY = new ResultMetadataType("POSSIBLE_COUNTRY");
    public static final ResultMetadataType UPC_EAN_EXTENSION = new ResultMetadataType("UPC_EAN_EXTENSION");
    public static final ResultMetadataType PDF417_EXTRA_METADATA = new ResultMetadataType("PDF417_EXTRA_METADATA");
    public static final ResultMetadataType STRUCTURED_APPEND_SEQUENCE = new ResultMetadataType("STRUCTURED_APPEND_SEQUENCE");
    public static final ResultMetadataType STRUCTURED_APPEND_PARITY = new ResultMetadataType("STRUCTURED_APPEND_PARITY");

    ResultMetadataType(String str) {
        this.type = str;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return "ResultMetadataType{type='" + this.type + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.type.equals(((ResultMetadataType) obj).type);
    }
}
