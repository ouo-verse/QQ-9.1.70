package com.tencent.soter.core.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SoterCoreUtil {
    static IPatchRedirector $redirector_;

    public SoterCoreUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static long getCurrentTicks() {
        return System.nanoTime();
    }

    public static String getMessageDigest(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i3 = 0;
            for (byte b16 : digest) {
                int i16 = i3 + 1;
                cArr2[i3] = cArr[(b16 >>> 4) & 15];
                i3 = i16 + 1;
                cArr2[i16] = cArr[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isNullOrNil(String str) {
        return str == null || str.length() <= 0;
    }

    public static String nullAsNil(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static long ticksToNowInMs(long j3) {
        return ((System.nanoTime() - j3) / 1000) / 1000;
    }

    public static boolean isNullOrNil(byte[] bArr) {
        return bArr == null || bArr.length <= 0;
    }

    public static boolean isNullOrNil(int[] iArr) {
        return iArr == null || iArr.length <= 0;
    }
}
