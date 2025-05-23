package com.tencent.securitysdk.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static char[] f368867a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42312);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f368867a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        }
    }

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length == 16) {
            char[] cArr = new char[32];
            int i3 = 0;
            for (int i16 = 0; i16 < 16; i16++) {
                byte b16 = bArr[i16];
                int i17 = i3 + 1;
                char[] cArr2 = f368867a;
                cArr[i3] = cArr2[(b16 >>> 4) & 15];
                i3 = i17 + 1;
                cArr[i17] = cArr2[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        }
        return "";
    }

    public static String b(String str) {
        return a(c(str));
    }

    public static byte[] c(String str) {
        if (str == null) {
            return null;
        }
        try {
            try {
                return MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                return null;
            }
        } catch (Exception e17) {
            e17.printStackTrace();
            return null;
        }
    }
}
