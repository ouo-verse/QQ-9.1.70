package com.tencent.gathererga.ad.internal;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes6.dex */
final class f {
    static IPatchRedirector $redirector_;

    private static byte[] a(String str, byte[] bArr) {
        try {
            return MessageDigest.getInstance(str).digest(bArr);
        } catch (Throwable th5) {
            com.tencent.gathererga.core.internal.util.d.c(PublicAccountMessageUtilImpl.ITEM_DIGEST_NAME, th5);
            return null;
        }
    }

    public static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String a16 = d.a(c(str.getBytes(str2)));
                if (!TextUtils.isEmpty(a16) && a16.length() == 32) {
                    return a16;
                }
                com.tencent.gathererga.core.internal.util.d.b("md5 error");
                return null;
            } catch (Throwable th5) {
                com.tencent.gathererga.core.internal.util.d.c("md5", th5);
            }
        }
        return null;
    }

    public static byte[] c(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            byte[] a16 = a("md5", bArr);
            if (a16 != null && a16.length == 16) {
                return a16;
            }
            com.tencent.gathererga.core.internal.util.d.b("md5 error");
        }
        return null;
    }
}
