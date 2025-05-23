package com.tenpay.util;

import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MD5 {
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0067: MOVE (r4 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:104), block:B:29:0x0067 */
    public static String getFileMD5(File file) {
        FileInputStream fileInputStream;
        Closeable closeable;
        int i3;
        if (!file.isFile()) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        byte[] bArr = new byte[1024];
        Closeable closeable2 = null;
        r4 = null;
        String str = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Exception e16) {
                        e = e16;
                        e.printStackTrace();
                        Utils.closeObject(fileInputStream);
                        return str;
                    }
                }
                byte[] digest = messageDigest.digest();
                if (digest != null) {
                    char[] cArr2 = new char[32];
                    int i16 = 0;
                    for (i3 = 0; i3 < 16; i3++) {
                        int i17 = digest[i3];
                        int i18 = i16 + 1;
                        cArr2[i16] = cArr[(i17 >>> 4) & 15];
                        i16 = i18 + 1;
                        cArr2[i18] = cArr[(i17 & 15) == true ? 1 : 0];
                    }
                    str = new String(cArr2);
                }
            } catch (Exception e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                Utils.closeObject(closeable2);
                throw th;
            }
            Utils.closeObject(fileInputStream);
            return str;
        } catch (Throwable th6) {
            th = th6;
            closeable2 = closeable;
            Utils.closeObject(closeable2);
            throw th;
        }
    }

    public static String hexdigest(String str) {
        if (str == null) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[32];
            int i3 = 0;
            for (int i16 = 0; i16 < 16; i16++) {
                byte b16 = digest[i16];
                int i17 = i3 + 1;
                cArr2[i3] = cArr[(b16 >>> 4) & 15];
                i3 = i17 + 1;
                cArr2[i17] = cArr[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String hexdigest(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[32];
            int i3 = 0;
            for (int i16 = 0; i16 < 16; i16++) {
                byte b16 = digest[i16];
                int i17 = i3 + 1;
                cArr2[i3] = cArr[(b16 >>> 4) & 15];
                i3 = i17 + 1;
                cArr2[i17] = cArr[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }
}
