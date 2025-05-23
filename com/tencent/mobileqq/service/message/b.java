package com.tencent.mobileqq.service.message;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final short[] f286179a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final short[] f286180b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74938);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f286179a = new short[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 34, 41, 20, 44, 22, 10, 21, 107, 36, 251, 26, 25, 2, 1, 24, 0, 70, 0, 0, 0, 0, 48, 0, 96, 0, 72, 97, 39, 0, 78, 0, 0, 61, 9, 58, 0, 29, 75, 60, 77, 0, 0, 76, 0, 0, 69, 53, 54, 0, 0, 33, 13, 0, 14, 23, 27, 3, 38, 51, 8, 0, 0, 46, 67, 59, 0, 0, 0, 0, 0, 0, 55, 16, 4, 19, 31, 32, 82, 83, 43, 84, 35, 12, 50, 85, 40, 79, 6, 5, 68, 0, 81, 17, 71, 0, 56, 28, 7, 86, 87, 88, 47, 89, 45, 90, 49, 15, 91, 42, 37, 92, 52, 18, 62, 93, 94, 30, 63, 57, 64, 74, 73, 66, 95, 65, 98, 99, 100, 101, 80, 102, 103, 104, 105, 106, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            f286180b = new short[]{13, 12, 56, 73, 88, 87, 97, 59, 33, 5, 9, 82, 51, 53, 106, 72, 92, 112, 74, 2, 6, 4, 54, 14, 11, 10, 55, 96, 36, 116, 75, 76, 50, 0, 81, 8, 109, 57, 27, 85, 1, 108, 79, 3, 103, 62, 101, 21, 105, 83, 58, 111, 46, 47, 71, 95, 118, 34, 64, 38, 32, 113, 117, 119, 124, 122, 63, 89, 45, 16, 93, 25, 121, 120, 37, 42, 39, 29, 86, 129, 91, 77, 78, 80, 84, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 23, 26, 125, 126, 127, 128, 130, 131, 132, 133, 134, 7, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9};
        }
    }

    static int a(char c16, byte[] bArr, int i3) {
        if (c16 < '\u0080') {
            bArr[i3 + 0] = (byte) c16;
            return 1;
        }
        if (c16 < '\u0800') {
            bArr[i3 + 0] = (byte) (((c16 >> 6) & 31) | 192);
            bArr[i3 + 1] = (byte) ((c16 & '?') | 128);
            return 2;
        }
        bArr[i3 + 0] = (byte) (((c16 >> '\f') & 15) | 224);
        bArr[i3 + 1] = (byte) (((c16 >> 6) & 63) | 128);
        bArr[i3 + 2] = (byte) ((c16 & '?') | 128);
        return 3;
    }

    public static byte[] b(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        byte[] bArr = new byte[length << 2];
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            if (charAt != 20) {
                i16 += a(charAt, bArr, i16);
            } else {
                int i17 = i16 + 1;
                bArr[i16] = (byte) charAt;
                int i18 = i3 + 1;
                char charAt2 = str.charAt(i18);
                short[] sArr = f286180b;
                if (charAt2 >= sArr.length) {
                    i16 = i17 + a(charAt2, bArr, i17);
                } else {
                    bArr[i17] = (byte) ((char) (sArr[charAt2] + 65));
                    i3 = i18;
                    i16 = i17 + 1;
                }
            }
            i3++;
        }
        byte[] bArr2 = new byte[i16];
        System.arraycopy(bArr, 0, bArr2, 0, i16);
        return bArr2;
    }

    public static String c(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        int i16 = 0;
        while (i16 < str.length()) {
            if (str.charAt(i16) == 20 && (i3 = i16 + 2) < str.length()) {
                int i17 = i16 + 1;
                int charAt = (((str.charAt(i17) - 'A') * 128) + str.charAt(i3)) - 65;
                if (charAt >= 0) {
                    sb5.append(String.valueOf(new char[]{20, (char) QQSysFaceUtil.convertToLocal(charAt)}));
                    i16 = i17 + 1;
                }
            } else {
                sb5.append(str.charAt(i16));
            }
            i16++;
        }
        return sb5.toString();
    }

    public static byte[] d(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length * 2);
        int i3 = 0;
        while (i3 < bArr.length) {
            byte b16 = bArr[i3];
            if (b16 != 20) {
                if (b16 == 13) {
                    if (i3 > 0 && bArr[i3 - 1] == 20) {
                        allocate.put(b16);
                    } else {
                        int i16 = i3 + 1;
                        if (i16 < bArr.length) {
                            if (bArr[i16] != 10) {
                                allocate.put((byte) 10);
                            }
                        } else {
                            allocate.put((byte) 10);
                        }
                    }
                } else {
                    allocate.put(b16);
                }
            } else {
                int i17 = i3 + 1;
                short s16 = (short) (bArr[i17] & 255);
                allocate.put(b16);
                short s17 = f286179a[s16];
                if (s17 > 0) {
                    int i18 = s17 - 1;
                    if (i18 < 128) {
                        allocate.put((byte) i18);
                    } else {
                        allocate.put((byte) (((i18 >> 6) & 31) | 192));
                        allocate.put((byte) (128 | ((i18 >> 0) & 63)));
                    }
                    i3 = i17;
                }
            }
            i3++;
        }
        byte[] bArr2 = new byte[allocate.position()];
        allocate.flip();
        allocate.get(bArr2);
        return bArr2;
    }

    public static String e(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        int i16 = 0;
        while (i16 < str.length()) {
            if (str.charAt(i16) == 20 && (i3 = i16 + 1) < str.length()) {
                int convertToServer = QQSysFaceUtil.convertToServer(str.charAt(i3));
                if (convertToServer >= 0) {
                    sb5.append(str.charAt(i16));
                    sb5.append((char) ((convertToServer / 128) + 65));
                    sb5.append((char) ((convertToServer % 128) + 65));
                    i16 = i3;
                }
            } else {
                sb5.append(str.charAt(i16));
            }
            i16++;
        }
        return sb5.toString();
    }
}
