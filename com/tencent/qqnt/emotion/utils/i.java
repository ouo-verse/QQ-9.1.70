package com.tencent.qqnt.emotion.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes24.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static char[] f356691a;

    /* renamed from: b, reason: collision with root package name */
    protected static MessageDigest f356692b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43787);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f356691a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f356692b = null;
        try {
            f356692b = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        } catch (NoSuchAlgorithmException unused) {
        }
    }

    private static void a(byte b16, StringBuffer stringBuffer) {
        char[] cArr = f356691a;
        char c16 = cArr[(b16 & 240) >> 4];
        char c17 = cArr[b16 & RegisterType.DOUBLE_HI];
        stringBuffer.append(c16);
        stringBuffer.append(c17);
    }

    public static String b(byte[] bArr) {
        return c(bArr, 0, bArr.length);
    }

    private static String c(byte[] bArr, int i3, int i16) {
        StringBuffer stringBuffer = new StringBuffer(i16 * 2);
        int i17 = i16 + i3;
        while (i3 < i17) {
            a(bArr[i3], stringBuffer);
            i3++;
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0055 -> B:25:0x0072). Please report as a decompilation issue!!! */
    public static String d(File file) throws IOException {
        FileInputStream fileInputStream;
        String str = null;
        if (file != null && file.exists()) {
            try {
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            if (file.length() > 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = null;
                }
                try {
                    long length = file.length();
                    byte[] bArr = new byte[4096];
                    while (length > 0) {
                        long read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        if (read > length) {
                            read = length;
                        }
                        length -= read;
                        f356692b.update(ByteBuffer.wrap(bArr, 0, (int) read));
                    }
                    fileInputStream.close();
                    byte[] digest = f356692b.digest();
                    if (digest != null) {
                        str = b(digest);
                    }
                    fileInputStream.close();
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        th.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return str;
                    } catch (Throwable th7) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        throw th7;
                    }
                }
            }
        }
        return str;
    }
}
