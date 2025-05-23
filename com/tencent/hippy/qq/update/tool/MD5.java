package com.tencent.hippy.qq.update.tool;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MD5 {
    public static String getFileMd5(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception unused) {
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            String streamToMD5 = streamToMD5(fileInputStream);
            try {
                fileInputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            return streamToMD5;
        } catch (Exception unused2) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String streamToMD5(InputStream inputStream) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    return toHexString(messageDigest.digest());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static String stringToMD5(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bytes);
            return toHexString(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    private static String toHexString(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int length = bArr.length;
        char[] cArr2 = new char[length * 2];
        for (int i3 = 0; i3 < length; i3++) {
            byte b16 = bArr[i3];
            int i16 = i3 * 2;
            cArr2[i16] = cArr[(b16 >>> 4) & 15];
            cArr2[i16 + 1] = cArr[b16 & RegisterType.DOUBLE_HI];
        }
        return new String(cArr2);
    }
}
