package com.heytap.mcssdk.f;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f36185a = "com.nearme.mcs";

    private static String a() {
        byte[] a16 = a(a(f36185a));
        return a16 != null ? new String(a16, Charset.forName("UTF-8")) : "";
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return b.a(str, a());
            } catch (Exception e16) {
                c.e("desDecrypt-" + e16.getMessage());
            }
        }
        return "";
    }

    public static byte[] a(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static byte[] a(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i3 = 0; i3 < length; i3 += 2) {
            byte b16 = bArr[i3];
            int i16 = i3 + 1;
            bArr[i3] = bArr[i16];
            bArr[i16] = b16;
        }
        return bArr;
    }
}
