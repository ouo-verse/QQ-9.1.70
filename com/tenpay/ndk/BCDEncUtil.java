package com.tenpay.ndk;

import android.content.Context;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BCDEncUtil {
    private byte[] enc_buf;
    private byte[] raw_buf;

    public BCDEncUtil(Context context) {
        CftSoLoader.loadSo(context);
    }

    private native boolean bcdEncode();

    public String bcdEncode(String str) {
        String str2;
        synchronized (CftSoLoader.lock) {
            str2 = null;
            if (str.length() > 0) {
                try {
                    this.raw_buf = str.getBytes("UTF-8");
                    bcdEncode();
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
