package he2;

import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f404804a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f404805b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                try {
                    byte b16 = bArr[i3];
                    int i16 = i3 * 2;
                    char[] cArr2 = f404805b;
                    cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                    cArr[i16 + 0] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
                } catch (Exception e16) {
                    QLog.e("Event.EventUtils", 1, "[bytesToHexStr] bytes to hex string error", e16);
                    return "";
                }
            }
            return new String(cArr);
        }
        return null;
    }

    protected static byte[] b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(String str) {
        try {
            return a(b(str.getBytes("UTF-8")));
        } catch (Exception e16) {
            QLog.e("Event.EventUtils", 1, "encode hex string error, ", e16);
            return null;
        }
    }

    public static String d() {
        return f404804a.format(new Date(System.currentTimeMillis()));
    }
}
