package com.tencent.centaur.host.loader.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f99148a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16729);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f99148a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        }
    }

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                try {
                    byte b16 = bArr[i3];
                    int i16 = i3 * 2;
                    char[] cArr2 = f99148a;
                    cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                    cArr[i16] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
                } catch (Exception unused) {
                    return "";
                }
            }
            return new String(cArr);
        }
        return null;
    }

    public static byte[] b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[16384];
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                } catch (IOException unused) {
                    fileInputStream.close();
                    return null;
                } catch (Throwable th5) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                    throw th5;
                }
            }
            byte[] digest = messageDigest.digest();
            try {
                fileInputStream.close();
            } catch (IOException unused3) {
            }
            return digest;
        } catch (FileNotFoundException | IOException | NoSuchAlgorithmException unused4) {
            return null;
        }
    }

    public static String c(String str) {
        return a(b(str));
    }
}
