package com.tencent.gathererga.ad.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes6.dex */
final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f108182a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56122);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f108182a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        }
    }

    public static String a(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        try {
            char[] cArr = new char[length << 1];
            int i3 = 0;
            for (byte b16 : bArr) {
                int i16 = i3 + 1;
                char[] cArr2 = f108182a;
                cArr[i3] = cArr2[(b16 >>> 4) & 15];
                i3 = i16 + 1;
                cArr[i16] = cArr2[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        } catch (Throwable th5) {
            com.tencent.gathererga.core.internal.util.d.c("bytes2HexString", th5);
            return null;
        }
    }
}
