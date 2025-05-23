package com.tenpay.ndk;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CommonEncUtil {
    private byte[] enc_text;
    private byte[] raw_text;

    public CommonEncUtil(Context context) {
        CftSoLoader.loadSo(context);
    }

    private native boolean encrypt1(byte[] bArr);

    private native boolean encrypt2(byte[] bArr, byte[] bArr2);

    private boolean encryptText(String str) {
        synchronized (CftSoLoader.lock) {
            this.raw_text = null;
            this.enc_text = null;
            if (str.length() <= 0) {
                return false;
            }
            try {
                byte[] bytes = str.getBytes("ASCII");
                this.raw_text = bytes;
                return encrypt1(bytes);
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public String getEncryptText() {
        synchronized (CftSoLoader.lock) {
            byte[] bArr = this.enc_text;
            if (bArr == null) {
                return null;
            }
            try {
                return new String(bArr, "ASCII");
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public boolean encryptText(String str, String str2) {
        synchronized (CftSoLoader.lock) {
            this.raw_text = null;
            this.enc_text = null;
            if (str.length() <= 0) {
                return false;
            }
            try {
                this.raw_text = str.getBytes("ASCII");
                return encrypt2(this.raw_text, str2.getBytes("ASCII"));
            } catch (Exception unused) {
                return false;
            }
        }
    }
}
