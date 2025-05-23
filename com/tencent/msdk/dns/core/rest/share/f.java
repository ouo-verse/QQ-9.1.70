package com.tencent.msdk.dns.core.rest.share;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f336365a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17946);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f336365a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        }
    }

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                byte b16 = bArr[i3];
                int i16 = i3 * 2;
                char[] cArr2 = f336365a;
                cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                cArr[i16] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        }
        return "";
    }

    public static byte[] b(String str) {
        int i3 = 0;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        while (true) {
            int i16 = i3 + 1;
            if (i16 < length) {
                bArr[i3 / 2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i16), 16));
                i3 += 2;
            } else {
                return bArr;
            }
        }
    }
}
