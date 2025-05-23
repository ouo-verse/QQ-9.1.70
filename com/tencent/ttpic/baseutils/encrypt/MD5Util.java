package com.tencent.ttpic.baseutils.encrypt;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MD5Util {
    private static final String[] strDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String GetMD5Code(String str) {
        String str2;
        String str3 = null;
        try {
            str2 = new String(str);
        } catch (NoSuchAlgorithmException e16) {
            e = e16;
        }
        try {
            return byteToString(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e17) {
            e = e17;
            str3 = str2;
            LogUtils.e(e);
            return str3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String byteToArrayString(byte b16) {
        int i3;
        if (b16 < 0) {
            i3 = b16 + 256;
        }
        StringBuilder sb5 = new StringBuilder();
        String[] strArr = strDigits;
        sb5.append(strArr[i3 / 16]);
        sb5.append(strArr[i3 % 16]);
        return sb5.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r0 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String byteToNum(byte b16) {
        int i3;
        if (b16 < 0) {
            i3 = b16 + 256;
        }
        return String.valueOf(i3);
    }

    private static String byteToString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b16 : bArr) {
            stringBuffer.append(byteToArrayString(b16));
        }
        return stringBuffer.toString();
    }

    private static String bytesToHexString(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder("");
        if (bArr != null && bArr.length > 0) {
            for (byte b16 : bArr) {
                String hexString = Integer.toHexString(b16 & 255);
                if (hexString.length() < 2) {
                    sb5.append(0);
                }
                sb5.append(hexString);
            }
            return sb5.toString();
        }
        return null;
    }

    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return bytesToHexString(messageDigest.digest());
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
