package com.tencent.mobileqq.webview.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes20.dex */
public class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static char[] f314879a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49578);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f314879a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        }
    }

    private static String a(byte[] bArr, String str) throws Exception {
        if (bArr != null && bArr.length != 0) {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr, 0, bArr.length);
            return c(messageDigest.digest());
        }
        return "";
    }

    public static String b(String str) {
        try {
            return a(str.getBytes(), "SHA1");
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private static String c(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            sb5.append(f314879a[(bArr[i3] & 240) >>> 4]);
            sb5.append(f314879a[bArr[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }
}
