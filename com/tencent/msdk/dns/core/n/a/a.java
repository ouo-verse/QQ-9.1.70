package com.tencent.msdk.dns.core.n.a;

import android.text.TextUtils;
import com.tencent.msdk.dns.core.rest.share.f;
import java.nio.charset.Charset;
import java.security.SecureRandom;

/* compiled from: P */
/* loaded from: classes21.dex */
final class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                byte[] b16 = f.b(str);
                if (b16.length < 16) {
                    return "";
                }
                byte[] bArr = new byte[16];
                System.arraycopy(b16, 0, bArr, 0, 16);
                int length = b16.length - 16;
                byte[] bArr2 = new byte[length];
                System.arraycopy(b16, 16, bArr2, 0, length);
                byte[] d16 = com.tencent.msdk.dns.base.jni.a.d(bArr2, str2, 1, bArr);
                if (d16 == null) {
                    return "";
                }
                return new String(d16, Charset.forName("UTF-8"));
            } catch (Exception unused) {
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                byte[] bArr = new byte[16];
                new SecureRandom().nextBytes(bArr);
                return f.a(com.tencent.msdk.dns.c.e.a.g(bArr, com.tencent.msdk.dns.base.jni.a.d(str.getBytes("utf-8"), str2, 0, bArr)));
            } catch (Exception unused) {
            }
        }
        return "";
    }
}
