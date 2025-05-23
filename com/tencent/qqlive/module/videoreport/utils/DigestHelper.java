package com.tencent.qqlive.module.videoreport.utils;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DigestHelper {
    static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static byte[] hexStringToBytes(String str) throws IllegalArgumentException {
        if (str != null && str.length() % 2 != 1) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            byte[] bArr = new byte[length / 2];
            for (int i3 = 0; i3 < length; i3 += 2) {
                bArr[i3 / 2] = (byte) ((Character.digit(charArray[i3], 16) << 4) + Character.digit(charArray[i3 + 1], 16));
            }
            return bArr;
        }
        throw new IllegalArgumentException("hexBinary needs to be even-length: " + str);
    }

    public static String md5Hex(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr, 0, 8192);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return toHexString(messageDigest.digest());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static String toHexString(byte[] bArr) {
        if (bArr != null) {
            return toHexString(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String toHexString(byte[] bArr, int i3, int i16) {
        if (bArr != null) {
            if (i3 >= 0 && i3 + i16 <= bArr.length) {
                int i17 = i16 * 2;
                char[] cArr = new char[i17];
                int i18 = 0;
                for (int i19 = 0; i19 < i16; i19++) {
                    int i26 = bArr[i19 + i3] & 255;
                    int i27 = i18 + 1;
                    char[] cArr2 = HEX_CHARS;
                    cArr[i18] = cArr2[i26 >> 4];
                    i18 = i27 + 1;
                    cArr[i27] = cArr2[i26 & 15];
                }
                return new String(cArr, 0, i17);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }

    public static String md5Hex(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                    messageDigest.update(str.getBytes("UTF-8"));
                    return toHexString(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String md5Hex(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                    messageDigest.update(bArr);
                    return toHexString(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String md5Hex(byte[] bArr, int i3, int i16) {
        if (bArr != null && i3 >= 0 && i16 > 0) {
            try {
                if (i3 + i16 <= bArr.length) {
                    MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                    messageDigest.update(bArr, i3, i16);
                    return toHexString(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
