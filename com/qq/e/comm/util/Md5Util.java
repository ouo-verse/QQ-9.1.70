package com.qq.e.comm.util;

import android.util.Base64;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Md5Util {
    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String byteArrayToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b16 : bArr) {
            stringBuffer.append(byteToHexString(b16));
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String byteToHexString(byte b16) {
        int i3;
        if (b16 < 0) {
            i3 = b16 + 256;
        }
        StringBuilder sb5 = new StringBuilder();
        String[] strArr = hexDigits;
        sb5.append(strArr[i3 / 16]);
        sb5.append(strArr[i3 % 16]);
        return sb5.toString();
    }

    private static byte charPairToByte(char c16, char c17) {
        int i3;
        int i16;
        char lowerCase = Character.toLowerCase(c16);
        char lowerCase2 = Character.toLowerCase(c17);
        if (lowerCase <= '9') {
            i3 = lowerCase - '0';
        } else {
            i3 = (lowerCase - 'a') + 10;
        }
        int i17 = i3 << 4;
        if (lowerCase2 <= '9') {
            i16 = lowerCase2 - '0';
        } else {
            i16 = (lowerCase2 - 'a') + 10;
        }
        int i18 = i17 + i16;
        if (i18 > 127) {
            i18 -= 256;
        }
        return (byte) i18;
    }

    public static String encode(File file) {
        if (file == null) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    String byteArrayToHexString = byteArrayToHexString(messageDigest.digest());
                    try {
                        fileInputStream2.close();
                    } catch (Exception e16) {
                        GDTLogger.e(e16.getMessage());
                    }
                    return byteArrayToHexString;
                } catch (Exception e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    GDTLogger.e(e.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e18) {
                            GDTLogger.e(e18.getMessage());
                        }
                    }
                    return "";
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e19) {
                            GDTLogger.e(e19.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e26) {
            e = e26;
        }
    }

    public static String encodeBase64String(String str) {
        try {
            return byteArrayToHexString(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(Base64.decode(str, 0)));
        } catch (Exception e16) {
            GDTLogger.e("Exception while md5 base64String", e16);
            return null;
        }
    }

    public static byte[] hexStringtoByteArray(String str) {
        if (str.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i3 = 0; i3 < str.length() - 1; i3 += 2) {
            bArr[i3 / 2] = charPairToByte(str.charAt(i3), str.charAt(i3 + 1));
        }
        return bArr;
    }

    public static String encode(String str) {
        String str2 = null;
        try {
            String str3 = new String(str);
            try {
                return byteArrayToHexString(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str3.getBytes("UTF-8")));
            } catch (Exception e16) {
                e = e16;
                str2 = str3;
                GDTLogger.e(e.getMessage());
                return str2;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }
}
