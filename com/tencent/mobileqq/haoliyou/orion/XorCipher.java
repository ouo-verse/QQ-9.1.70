package com.tencent.mobileqq.haoliyou.orion;

import android.util.Base64;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public class XorCipher {
    static IPatchRedirector $redirector_;
    static final String DEFAULT_KEY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42456);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append('W');
        sb5.append('t');
        sb5.append('R');
        sb5.append('x');
        sb5.append('K');
        sb5.append('b');
        sb5.append('L');
        sb5.append('k');
        DEFAULT_KEY = sb5.toString();
    }

    public XorCipher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String decrypt(String str) throws XorCipherException {
        return decryptWithKey(str, DEFAULT_KEY);
    }

    public static String decryptWithKey(String str, String str2) throws XorCipherException {
        if (str != null) {
            try {
                return new String(xorWithKey(Base64.decode(str, 0), str2.getBytes()));
            } catch (Throwable th5) {
                throw new XorCipherException(th5);
            }
        }
        throw new XorCipherException("null input");
    }

    public static String encrypt(String str) throws XorCipherException {
        return encryptWithKey(str, DEFAULT_KEY);
    }

    public static String encryptWithKey(String str, String str2) throws XorCipherException {
        if (str != null) {
            try {
                return new String(Base64.encode(xorWithKey(str.getBytes(), str2.getBytes()), 0));
            } catch (Throwable th5) {
                throw new XorCipherException(th5);
            }
        }
        throw new XorCipherException("null input");
    }

    private static byte[] xorWithKey(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr3[i3] = (byte) (bArr[i3] ^ bArr2[i3 % bArr2.length]);
        }
        return bArr3;
    }
}
