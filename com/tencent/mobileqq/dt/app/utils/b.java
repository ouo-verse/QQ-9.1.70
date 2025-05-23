package com.tencent.mobileqq.dt.app.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static String a(String str) {
        if (str.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.reset();
            byte[] digest = messageDigest.digest(str.getBytes("UTF-8"));
            for (byte b16 : digest) {
                stringBuffer.append(Integer.toString((b16 & 255) + 256, 16).substring(1));
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }
}
