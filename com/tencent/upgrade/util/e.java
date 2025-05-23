package com.tencent.upgrade.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Removed duplicated region for block: B:42:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    try {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    return null;
                }
            }
            fileInputStream.close();
            try {
                fileInputStream.close();
            } catch (IOException e19) {
                e19.printStackTrace();
            }
            StringBuilder sb5 = new StringBuilder(new BigInteger(1, messageDigest.digest()).toString(16));
            while (sb5.length() < 32) {
                sb5.insert(0, "0");
            }
            return sb5.toString();
        } catch (Exception e26) {
            e = e26;
            fileInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb5 = new StringBuilder(digest.length * 2);
            for (byte b16 : digest) {
                int i3 = b16 & 255;
                if (i3 < 16) {
                    sb5.append("0");
                }
                sb5.append(Integer.toHexString(i3));
            }
            return sb5.toString();
        } catch (NoSuchAlgorithmException e16) {
            throw new RuntimeException("NoSuchAlgorithmException", e16);
        }
    }
}
