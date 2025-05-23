package com.tencent.cachedrawable.dynamicdrawable.utils;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static char[] f99064a;

    /* renamed from: b, reason: collision with root package name */
    protected static MessageDigest f99065b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7144);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f99064a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f99065b = null;
        try {
            f99065b = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        } catch (NoSuchAlgorithmException e16) {
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("MD5FileUtil", "init, EXCEPTION: " + e16);
        }
    }

    private static void a(byte b16, StringBuffer stringBuffer) {
        char[] cArr = f99064a;
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

    public static synchronized String d(File file) {
        FileInputStream fileInputStream;
        boolean z16;
        Path path;
        synchronized (g.class) {
            String str = null;
            if (file != null) {
                if (file.isFile() && file.exists() && file.length() > 0) {
                    if (com.tencent.cachedrawable.dynamicdrawable.business.toggle.a.f98868a.i()) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            path = Paths.get(file.getAbsolutePath(), new String[0]);
                            z16 = Files.isReadable(path);
                            if (!z16) {
                                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("MD5FileUtil", "filePath:$filePath un readable");
                            }
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            return null;
                        }
                    }
                    try {
                        fileInputStream = new FileInputStream(file);
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
                                f99065b.update(ByteBuffer.wrap(bArr, 0, (int) read));
                            }
                            fileInputStream.close();
                            str = b(f99065b.digest());
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("MD5FileUtil", "getFileMD5String, EXCEPTION: " + th);
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e16) {
                                        e = e16;
                                        e.printStackTrace();
                                        return str;
                                    }
                                }
                                return str;
                            } finally {
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream = null;
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e17) {
                        e = e17;
                        e.printStackTrace();
                        return str;
                    }
                }
            }
            return str;
        }
    }
}
