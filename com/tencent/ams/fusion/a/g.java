package com.tencent.ams.fusion.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f70237a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55768);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f70237a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(byte b16) {
        int i3;
        if (b16 < 0) {
            i3 = b16 + 256;
        }
        StringBuilder sb5 = new StringBuilder();
        String[] strArr = f70237a;
        sb5.append(strArr[i3 / 16]);
        sb5.append(strArr[i3 % 16]);
        return sb5.toString();
    }

    public static String b(String str) {
        String str2 = null;
        try {
            String str3 = new String(str);
            try {
                return c(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str3.getBytes("UTF-8")));
            } catch (Exception e16) {
                e = e16;
                str2 = str3;
                f.d("encode error:", e);
                return str2;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b16 : bArr) {
            stringBuffer.append(a(b16));
        }
        return stringBuffer.toString();
    }
}
