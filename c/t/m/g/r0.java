package c.t.m.g;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes.dex */
public class r0 {
    public static Cipher a(byte[] bArr, byte[] bArr2, int i3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i3, secretKeySpec, new IvParameterSpec(bArr2));
        return cipher;
    }

    public static byte[] b(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public static byte[] b(byte[] bArr, int i3, int i16) {
        try {
            byte[] a16 = u0.a(16);
            byte[] a17 = a(bArr, i3, i16, a16, a16, 1);
            if (h1.a(a17)) {
                return a17;
            }
            byte[] bArr2 = new byte[a16.length + a17.length];
            System.arraycopy(a16, 0, bArr2, 0, a16.length);
            System.arraycopy(a17, 0, bArr2, a16.length, a17.length);
            return bArr2;
        } catch (Throwable th5) {
            c1.a("Encrypt2Util", "encrypt error.", th5);
            return k0.f29815a;
        }
    }

    public static byte[] a(byte[] bArr, int i3, int i16, byte[] bArr2, byte[] bArr3, int i17) {
        if (i17 != 1 && i17 != 2) {
            throw new IllegalArgumentException("wrong mode.");
        }
        if (bArr != null && bArr.length != 0 && i3 >= 0 && i16 > 0) {
            try {
                Cipher a16 = a(bArr2, bArr3, i17);
                if (a16 == null) {
                    return k0.f29815a;
                }
                return a16.doFinal(bArr, i3, i16);
            } catch (Throwable th5) {
                c1.a("Encrypt2Util", "en-de crypt error.", th5);
                return k0.f29815a;
            }
        }
        return k0.f29815a;
    }

    public static String b(String str) {
        try {
            return l0.a(b(str.getBytes("UTF-8")));
        } catch (Throwable th5) {
            c1.a("Encrypt2Util", "enc aes base64 error.", th5);
            return "";
        }
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static byte[] a(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        return a(bArr, i3 + 16, i16 - 16, bArr2, bArr2, 2);
    }

    public static String a(String str) {
        try {
            return new String(a(l0.a(str)), "UTF-8");
        } catch (Throwable th5) {
            c1.a("Encrypt2Util", "dec aes base64 error.", th5);
            return "";
        }
    }
}
