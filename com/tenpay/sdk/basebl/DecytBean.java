package com.tenpay.sdk.basebl;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DecytBean {
    public static final int TLSCODE_COMMUNICATION = 0;
    public static final int TLSCODE_ENCRYT_CHANGE = 3;
    public static final int TLSCODE_KEYSHARE_SUCC = 1;
    public static final int TLSCODE_KEY_OVERTIME = 2;
    public static final int TYPE_DES = 0;
    public static final int TYPE_ECDH = 1;
    public final String decryptStr;
    public final int tls_code;
    public final int type;

    public DecytBean(int i3, int i16, String str) {
        this.type = i3;
        this.tls_code = i16;
        this.decryptStr = str;
    }
}
