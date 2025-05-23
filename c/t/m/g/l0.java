package c.t.m.g;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.text.EmotcationConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f29820a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    public static String a(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        int i3 = length - 3;
        int i16 = 0;
        int i17 = 0;
        while (i16 <= i3) {
            int i18 = ((bArr[i16] & 255) << 16) | ((bArr[i16 + 1] & 255) << 8) | (bArr[i16 + 2] & 255);
            char[] cArr = f29820a;
            stringBuffer.append(cArr[(i18 >> 18) & 63]);
            stringBuffer.append(cArr[(i18 >> 12) & 63]);
            stringBuffer.append(cArr[(i18 >> 6) & 63]);
            stringBuffer.append(cArr[i18 & 63]);
            i16 += 3;
            i17 = i17 >= 14 ? 0 : i17 + 1;
        }
        int i19 = 0 + length;
        if (i16 == i19 - 2) {
            int i26 = ((bArr[i16 + 1] & 255) << 8) | ((bArr[i16] & 255) << 16);
            char[] cArr2 = f29820a;
            stringBuffer.append(cArr2[(i26 >> 18) & 63]);
            stringBuffer.append(cArr2[(i26 >> 12) & 63]);
            stringBuffer.append(cArr2[(i26 >> 6) & 63]);
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
        } else if (i16 == i19 - 1) {
            int i27 = (bArr[i16] & 255) << 16;
            char[] cArr3 = f29820a;
            stringBuffer.append(cArr3[(i27 >> 18) & 63]);
            stringBuffer.append(cArr3[(i27 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer.toString();
    }

    public static int a(char c16) {
        int i3;
        if (c16 >= 'A' && c16 <= 'Z') {
            return c16 - EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET;
        }
        if (c16 >= 'a' && c16 <= 'z') {
            i3 = c16 - 'a';
        } else {
            if (c16 < '0' || c16 > '9') {
                if (c16 == '+') {
                    return 62;
                }
                if (c16 == '/') {
                    return 63;
                }
                if (c16 == '=') {
                    return 0;
                }
                throw new RuntimeException("unexpected code: " + c16);
            }
            i3 = (c16 - '0') + 26;
        }
        return i3 + 26;
    }

    public static byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(str, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e16) {
                System.err.println("Error while decoding BASE64: " + e16.toString());
            }
            return byteArray;
        } catch (IOException unused) {
            throw new RuntimeException();
        }
    }

    public static void a(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        int i3 = 0;
        while (true) {
            if (i3 < length && str.charAt(i3) <= ' ') {
                i3++;
            } else {
                if (i3 == length) {
                    return;
                }
                int i16 = i3 + 2;
                int i17 = i3 + 3;
                int a16 = (a(str.charAt(i3)) << 18) + (a(str.charAt(i3 + 1)) << 12) + (a(str.charAt(i16)) << 6) + a(str.charAt(i17));
                outputStream.write((a16 >> 16) & 255);
                if (str.charAt(i16) == '=') {
                    return;
                }
                outputStream.write((a16 >> 8) & 255);
                if (str.charAt(i17) == '=') {
                    return;
                }
                outputStream.write(a16 & 255);
                i3 += 4;
            }
        }
    }
}
