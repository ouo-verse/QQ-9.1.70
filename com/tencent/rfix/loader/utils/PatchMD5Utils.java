package com.tencent.rfix.loader.utils;

import android.text.TextUtils;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* loaded from: classes25.dex */
public class PatchMD5Utils {
    private static final String TAG = "RFix.MD5Utils";

    public static boolean checkIfMd5Invalid(String str) {
        if (str != null && str.length() == 32) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public static String getMD5(File file) {
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
                        PatchFileUtils.closeQuietly(str);
                        throw th;
                    }
                    try {
                        str = getMD5(fileInputStream);
                        exists = fileInputStream;
                    } catch (Exception e17) {
                        e = e17;
                        RFixLog.e(TAG, "getMD5 fail.", e);
                        exists = fileInputStream;
                        PatchFileUtils.closeQuietly(exists);
                        return str;
                    }
                    PatchFileUtils.closeQuietly(exists);
                    return str;
                }
            } catch (Throwable th6) {
                th = th6;
                str = exists;
            }
        }
        return null;
    }

    public static boolean verifyFileMd5(File file, String str) {
        if (str == null) {
            return false;
        }
        return TextUtils.equals(getMD5(file), str);
    }

    public static String getMD5(InputStream inputStream) {
        int i3;
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
            for (byte b16 : messageDigest.digest()) {
                sb5.append(Integer.toString((b16 & 255) + 256, 16).substring(1));
            }
            return sb5.toString();
        } catch (Exception e16) {
            RFixLog.e(TAG, "getMD5 fail.", e16);
            return null;
        }
    }

    public static String getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[digest.length * 2];
            int i3 = 0;
            for (byte b16 : digest) {
                int i16 = i3 + 1;
                char[] cArr2 = RFixConstants.HEX_DIGITS;
                cArr[i3] = cArr2[(b16 >>> 4) & 15];
                i3 = i16 + 1;
                cArr[i16] = cArr2[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        } catch (Exception e16) {
            RFixLog.e(TAG, "getMD5 fail.", e16);
            return null;
        }
    }
}
