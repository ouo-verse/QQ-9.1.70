package com.tencent.gathererga.core.internal.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f108292a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55982);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f108292a = "AES";
        }
    }

    public static String a(String str, String str2) throws Exception {
        return new String(b(str.getBytes(), m.b(str2)));
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) throws Exception {
        String str = f108292a;
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, str);
        Cipher cipher = Cipher.getInstance(str);
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    public static String c(String str, String str2) throws Exception {
        return m.c(d(str.getBytes(), str2.getBytes()));
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) throws Exception {
        String str = f108292a;
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, str);
        Cipher cipher = Cipher.getInstance(str);
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(bArr2);
    }
}
