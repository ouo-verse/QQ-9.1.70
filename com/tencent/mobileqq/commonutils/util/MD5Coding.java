package com.tencent.mobileqq.commonutils.util;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MD5Coding {
    public static byte[] encode(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String encode2HexStr(byte[] bArr) {
        return HexUtil.bytes2HexStr(encode(bArr));
    }

    public static byte[] encodeFile(String str) {
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

    public static String encodeFile2HexStr(String str) {
        return HexUtil.bytes2HexStr(encodeFile(str));
    }

    public static String encodeHexStr(String str) {
        try {
            return HexUtil.bytes2HexStr(encode(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
