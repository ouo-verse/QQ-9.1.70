package com.huawei.hms.utils;

import com.huawei.hms.support.log.HMSLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class SHA256 {
    public static byte[] digest(byte[] bArr) {
        try {
            return MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256).digest(bArr);
        } catch (NoSuchAlgorithmException e16) {
            HMSLog.e("SHA256", "NoSuchAlgorithmException" + e16.getMessage());
            return new byte[0];
        }
    }

    public static byte[] digest(File file) {
        BufferedInputStream bufferedInputStream;
        MessageDigest messageDigest;
        int i3;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr = new byte[4096];
                    i3 = 0;
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        i3 += read;
                        messageDigest.update(bArr, 0, read);
                    }
                } catch (IOException | NoSuchAlgorithmException unused) {
                    bufferedInputStream2 = bufferedInputStream;
                    HMSLog.e("SHA256", "An exception occurred while computing file 'SHA-256'.");
                    IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                    return new byte[0];
                } catch (Throwable th5) {
                    th = th5;
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = bufferedInputStream2;
            }
        } catch (IOException | NoSuchAlgorithmException unused2) {
        }
        if (i3 <= 0) {
            IOUtils.closeQuietly((InputStream) bufferedInputStream);
            return new byte[0];
        }
        byte[] digest = messageDigest.digest();
        IOUtils.closeQuietly((InputStream) bufferedInputStream);
        return digest;
    }
}
