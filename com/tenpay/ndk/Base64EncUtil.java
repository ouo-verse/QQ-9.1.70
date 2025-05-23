package com.tenpay.ndk;

import android.content.Context;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Base64EncUtil {
    private byte[] enc_buf;
    private byte[] raw_buf;

    public Base64EncUtil(Context context) {
        CftSoLoader.loadSo(context);
    }

    private native boolean base64Encode();

    public String base64Encode(String str) {
        String str2;
        synchronized (CftSoLoader.lock) {
            str2 = null;
            if (str.length() > 0) {
                try {
                    this.raw_buf = str.getBytes("UTF-8");
                    base64Encode();
                    byte[] bArr = this.enc_buf;
                    if (bArr != null) {
                        try {
                            str2 = new String(bArr, "ASCII");
                        } catch (UnsupportedEncodingException unused) {
                        }
                    }
                } catch (Exception unused2) {
                    return null;
                }
            }
        }
        return str2;
    }
}
