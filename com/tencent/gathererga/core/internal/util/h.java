package com.tencent.gathererga.core.internal.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes6.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f108289a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55938);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f108289a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b16 : bArr) {
            stringBuffer.append(b(b16));
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(byte b16) {
        int i3;
        if (b16 < 0) {
            i3 = b16 + 256;
        }
        StringBuilder sb5 = new StringBuilder();
        String[] strArr = f108289a;
        sb5.append(strArr[i3 / 16]);
        sb5.append(strArr[i3 % 16]);
        return sb5.toString();
    }

    public static String c(String str) {
        String str2 = null;
        try {
            String str3 = new String(str);
            try {
                return a(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str3.getBytes("UTF-8")));
            } catch (Exception unused) {
                str2 = str3;
                return str2;
            }
        } catch (Exception unused2) {
        }
    }
}
