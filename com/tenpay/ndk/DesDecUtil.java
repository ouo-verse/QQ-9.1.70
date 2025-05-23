package com.tenpay.ndk;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DesDecUtil {
    private static final String CHARSET = "UTF-8";
    private byte[] dec_buf;
    private byte[] key_buf;
    private byte[] raw_buf;

    public DesDecUtil(Context context) {
        CftSoLoader.loadSo(context);
    }

    private native boolean decryptDes(int i3, byte[] bArr);

    private native boolean decryptDesWithstringkey(byte[] bArr, byte[] bArr2);

    public String decDesWithStringKey(String str, String str2) {
        synchronized (CftSoLoader.lock) {
            String str3 = null;
            this.dec_buf = null;
            if (str2 != null && str2.length() > 0) {
                try {
                    this.raw_buf = str2.getBytes("UTF-8");
                    byte[] bytes = str.getBytes("UTF-8");
                    this.key_buf = bytes;
                    decryptDesWithstringkey(bytes, this.raw_buf);
                    byte[] bArr = this.dec_buf;
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

    public boolean decryptDes(int i3, String str) {
        synchronized (CftSoLoader.lock) {
            if (str.length() <= 0) {
                return false;
            }
            try {
                byte[] bytes = str.getBytes("UTF-8");
                this.raw_buf = bytes;
                return decryptDes(i3, bytes);
            } catch (Error unused) {
                return false;
            } catch (Exception unused2) {
                return false;
            }
        }
    }

    public String getDecRes() {
        synchronized (CftSoLoader.lock) {
            byte[] bArr = this.dec_buf;
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
