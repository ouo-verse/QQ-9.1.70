package com.tencent.tbs.logger.file;

import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static String a() {
        return String.valueOf(System.currentTimeMillis());
    }

    private static byte[] b(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static byte[] c(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static byte[] d(String str, String str2) {
        try {
            byte[] b16 = b(str, str2);
            if (b16 == null) {
                return null;
            }
            String format = String.format(Locale.US, "%03d", Integer.valueOf(b16.length));
            byte[] bArr = new byte[b16.length + 3];
            bArr[0] = (byte) format.charAt(0);
            bArr[1] = (byte) format.charAt(1);
            bArr[2] = (byte) format.charAt(2);
            System.arraycopy(b16, 0, bArr, 3, b16.length);
            return bArr;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static synchronized byte[] e(String str, String str2, byte[] bArr) {
        synchronized (a.class) {
            byte[] c16 = c(str, str2);
            if (c16 != null) {
                byte[] bArr2 = new byte[bArr.length + c16.length + 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                int length = bArr.length + 0;
                System.arraycopy(c16, 0, bArr2, length, c16.length);
                System.arraycopy(new byte[]{10, 10}, 0, bArr2, length + c16.length, 2);
                return bArr2;
            }
            return str2.getBytes();
        }
    }
}
