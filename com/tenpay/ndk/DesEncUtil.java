package com.tenpay.ndk;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DesEncUtil {
    private static final String CHARSET = "UTF-8";
    private byte[] enc_buf;
    private byte[] key_buf;
    private byte[] raw_buf;

    public DesEncUtil(Context context) {
        CftSoLoader.loadSo(context);
    }

    private native boolean encryptDes(int i3, byte[] bArr);

    private native boolean encryptDesWithstringkey(byte[] bArr, byte[] bArr2);

    private native boolean encryptDesWithstringkeyOnedes(byte[] bArr, byte[] bArr2);

    public boolean encryptDes(int i3, String str) {
        synchronized (CftSoLoader.lock) {
            if (str.length() <= 0) {
                return false;
            }
            try {
                byte[] bytes = str.getBytes("UTF-8");
                this.raw_buf = bytes;
                return encryptDes(i3, bytes);
            } catch (Error unused) {
                return false;
            } catch (Exception unused2) {
                return false;
            }
        }
    }

    public String encryptDesWithStringKey(String str, String str2) {
        synchronized (CftSoLoader.lock) {
            String str3 = null;
            this.enc_buf = null;
            if (str2 != null && str2.length() > 0 && str != null) {
                try {
                    this.raw_buf = str2.getBytes("UTF-8");
                    byte[] bytes = str.getBytes("UTF-8");
                    this.key_buf = bytes;
                    encryptDesWithstringkey(bytes, this.raw_buf);
                    byte[] bArr = this.enc_buf;
                    if (bArr == null) {
                        return null;
                    }
                    try {
                        str3 = new String(bArr, "UTF-8");
                    } catch (Exception unused) {
                        return null;
                    }
                } catch (Error unused2) {
                    return null;
                } catch (Exception unused3) {
                    return null;
                }
            }
            return str3;
        }
    }

    public String encryptDesWithStringKeyOnedes(String str, String str2) {
        synchronized (CftSoLoader.lock) {
            String str3 = null;
            this.enc_buf = null;
            if (str2 != null && str2.length() > 0 && str != null) {
                try {
                    this.raw_buf = str2.getBytes("UTF-8");
                    byte[] bytes = str.getBytes("UTF-8");
                    this.key_buf = bytes;
                    encryptDesWithstringkeyOnedes(bytes, this.raw_buf);
                    byte[] bArr = this.enc_buf;
                    if (bArr == null) {
                        return null;
                    }
                    try {
                        str3 = new String(bArr, "UTF-8");
                    } catch (Exception unused) {
                        return null;
                    }
                } catch (Exception unused2) {
                    return null;
                }
            }
            return str3;
        }
    }

    public String getDesEncResult() {
        synchronized (CftSoLoader.lock) {
            byte[] bArr = this.enc_buf;
            if (bArr == null) {
                return null;
            }
            try {
                try {
                    return new String(bArr, "UTF-8");
                } catch (Error unused) {
                    return null;
                }
            } catch (Exception unused2) {
                return null;
            }
        }
    }
}
