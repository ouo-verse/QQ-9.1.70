package com.tencent.hotpatch;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f114708a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66074);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f114708a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public static String a(File file) {
        FileInputStream fileInputStream;
        String str = null;
        if (file != null) {
            ?? exists = file.exists();
            try {
                if (exists != 0) {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        b.a(str);
                        throw th;
                    }
                    try {
                        str = b(fileInputStream);
                        exists = fileInputStream;
                    } catch (Exception e17) {
                        e = e17;
                        QLog.e("RFix.MD5Utils", 1, e, new Object[0]);
                        exists = fileInputStream;
                        b.a(exists);
                        return str;
                    }
                    b.a(exists);
                    return str;
                }
            } catch (Throwable th6) {
                th = th6;
                str = exists;
            }
        }
        return null;
    }

    public static String b(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            StringBuilder sb5 = new StringBuilder(32);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bArr = new byte[RFixConstants.MD5_FILE_BUF_LENGTH];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            byte[] digest = messageDigest.digest();
            for (byte b16 : digest) {
                sb5.append(Integer.toString((b16 & 255) + 256, 16).substring(1));
            }
            return sb5.toString();
        } catch (Exception e16) {
            QLog.e("RFix.MD5Utils", 1, e16, new Object[0]);
            return null;
        }
    }
}
