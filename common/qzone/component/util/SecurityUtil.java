package common.qzone.component.util;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SecurityUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f390061a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    private static long[] f390062b = new long[256];

    static {
        long j3;
        for (int i3 = 0; i3 < 256; i3++) {
            long j16 = i3;
            for (int i16 = 0; i16 < 8; i16++) {
                if ((((int) j16) & 1) != 0) {
                    j3 = -7661587058870466123L;
                } else {
                    j3 = 0;
                }
                j16 = (j16 >> 1) ^ j3;
            }
            f390062b[i3] = j16;
        }
    }

    SecurityUtil() {
    }

    private static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                byte b16 = bArr[i3];
                int i16 = i3 * 2;
                char[] cArr2 = f390061a;
                cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                cArr[i16] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        }
        return null;
    }

    public static long b(byte[] bArr) {
        long j3 = -1;
        for (byte b16 : bArr) {
            j3 = (j3 >> 8) ^ f390062b[(((int) j3) ^ b16) & 255];
        }
        return j3;
    }

    public static String c(String str) {
        return d(str, KeyPropertiesCompact.DIGEST_MD5);
    }

    public static String d(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static byte[] e(String str) {
        byte[] bArr = new byte[str.length() * 2];
        int i3 = 0;
        for (char c16 : str.toCharArray()) {
            int i16 = i3 + 1;
            bArr[i3] = (byte) (c16 & '\u00ff');
            i3 = i16 + 1;
            bArr[i16] = (byte) (c16 >> '\b');
        }
        return bArr;
    }
}
