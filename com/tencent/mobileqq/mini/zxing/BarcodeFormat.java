package com.tencent.mobileqq.mini.zxing;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BarcodeFormat {
    public final String type;
    public static final BarcodeFormat CODABAR = new BarcodeFormat("CODABAR");
    public static final BarcodeFormat CODE_39 = new BarcodeFormat("CODE_39");
    public static final BarcodeFormat CODE_93 = new BarcodeFormat("CODE_93");
    public static final BarcodeFormat CODE_128 = new BarcodeFormat("CODE_128");
    public static final BarcodeFormat EAN_8 = new BarcodeFormat("EAN_8");
    public static final BarcodeFormat EAN_13 = new BarcodeFormat("EAN_13");
    public static final BarcodeFormat ITF = new BarcodeFormat("ITF");
    public static final BarcodeFormat UPC_A = new BarcodeFormat("UPC_A");
    public static final BarcodeFormat UPC_E = new BarcodeFormat("UPC_E");
    public static final BarcodeFormat UPC_EAN_EXTENSION = new BarcodeFormat("UPC_EAN_EXTENSION");

    BarcodeFormat(String str) {
        this.type = str;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String name() {
        return this.type;
    }

    public String toString() {
        return "BarcodeFormat{type='" + this.type + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.type.equals(((BarcodeFormat) obj).type);
    }
}
