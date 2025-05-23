package com.tencent.vas.update.util;

import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MD5Utils {
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    public static String bytes2HexStr(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                try {
                    byte b16 = bArr[i3];
                    int i16 = i3 * 2;
                    char[] cArr2 = digits;
                    cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                    cArr[i16 + 0] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
                } catch (Exception unused) {
                }
            }
            return new String(cArr);
        }
        return null;
    }

    protected static byte[] encodeFile(String str) {
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                File file = new File(str);
                if (!file.exists()) {
                    return null;
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                byte[] bArr = new byte[4096];
                while (true) {
                    try {
                        try {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            messageDigest.update(bArr, 0, read);
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            try {
                                bufferedInputStream.close();
                                return null;
                            } catch (IOException e17) {
                                e17.printStackTrace();
                                return null;
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                        throw th5;
                    }
                }
                byte[] digest = messageDigest.digest();
                try {
                    bufferedInputStream.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
                return digest;
            } catch (FileNotFoundException e26) {
                e26.printStackTrace();
                return null;
            }
        } catch (NoSuchAlgorithmException e27) {
            e27.printStackTrace();
            return null;
        }
    }

    public static String encodeFileHexStr(String str) {
        return bytes2HexStr(encodeFile(str));
    }
}
