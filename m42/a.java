package m42;

import java.nio.charset.Charset;
import kotlin.text.Charsets;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    private static long a(char c16) {
        return (((c16 & '?') | 128) << 16) | (((c16 >>> '\f') | 480) & 255) | ((((c16 >>> 6) & 63) | 128) << 8);
    }

    private static long b(char c16) {
        return (((c16 & '?') | 128) << 8) | (((c16 >>> 6) | 960) & 255);
    }

    private static long c(int i3) {
        return (((i3 >>> 18) | 240) & 255) | ((((i3 >>> 12) & 63) | 128) << 8) | ((((i3 >>> 6) & 63) | 128) << 16) | (((i3 & 63) | 128) << 24);
    }

    public static long d(long j3) {
        if (j3 >= 0 && j3 < 4294967296L) {
            return -((j3 ^ (j((int) r0, k(r0), Charsets.UTF_8) & 4294967295L)) | (((43753 * j3) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32));
        }
        return j3;
    }

    private static int e(int i3, int i16) {
        int i17 = i3 ^ i16;
        int i18 = (i17 ^ (i17 >>> 16)) * (-2048144789);
        int i19 = (i18 ^ (i18 >>> 13)) * (-1028477387);
        return i19 ^ (i19 >>> 16);
    }

    public static int f(byte b16, byte b17, byte b18, byte b19) {
        return (b16 << 24) | ((b17 & 255) << 16) | ((b18 & 255) << 8) | (b19 & 255);
    }

    private static int g(byte[] bArr, int i3) {
        return f(bArr[i3 + 3], bArr[i3 + 2], bArr[i3 + 1], bArr[i3]);
    }

    public static int h(int i3, byte[] bArr) {
        return i(i3, bArr, 0, bArr.length);
    }

    public static int i(int i3, byte[] bArr, int i16, int i17) {
        int i18 = 0;
        int i19 = 0;
        while (true) {
            int i26 = i19 + 4;
            if (i26 > i17) {
                break;
            }
            i3 = l(i3, m(g(bArr, i19 + i16)));
            i19 = i26;
        }
        int i27 = i19;
        int i28 = 0;
        while (i27 < i17) {
            i18 ^= n(bArr[i16 + i27]) << i28;
            i27++;
            i28 += 8;
        }
        return e(i3 ^ m(i18), i17);
    }

    public static int j(int i3, CharSequence charSequence, Charset charset) {
        if (Charsets.UTF_8.equals(charset)) {
            int length = charSequence.length();
            int i16 = 0;
            int i17 = i3;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                int i26 = i18 + 4;
                if (i26 > length) {
                    break;
                }
                char charAt = charSequence.charAt(i18);
                char charAt2 = charSequence.charAt(i18 + 1);
                char charAt3 = charSequence.charAt(i18 + 2);
                char charAt4 = charSequence.charAt(i18 + 3);
                if (charAt >= '\u0080' || charAt2 >= '\u0080' || charAt3 >= '\u0080' || charAt4 >= '\u0080') {
                    break;
                }
                i17 = l(i17, m((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
                i19 += 4;
                i18 = i26;
            }
            long j3 = 0;
            while (i18 < length) {
                char charAt5 = charSequence.charAt(i18);
                if (charAt5 < '\u0080') {
                    j3 |= charAt5 << i16;
                    i16 += 8;
                    i19++;
                } else if (charAt5 < '\u0800') {
                    j3 |= b(charAt5) << i16;
                    i16 += 16;
                    i19 += 2;
                } else if (charAt5 >= '\ud800' && charAt5 <= '\udfff') {
                    int codePointAt = Character.codePointAt(charSequence, i18);
                    if (codePointAt == charAt5) {
                        return h(i3, charSequence.toString().getBytes(charset));
                    }
                    i18++;
                    j3 |= c(codePointAt) << i16;
                    i19 += 4;
                } else {
                    j3 |= a(charAt5) << i16;
                    i16 += 24;
                    i19 += 3;
                }
                if (i16 >= 32) {
                    i17 = l(i17, m((int) j3));
                    j3 >>>= 32;
                    i16 -= 32;
                }
                i18++;
            }
            return e(m((int) j3) ^ i17, i19);
        }
        return h(i3, charSequence.toString().getBytes(charset));
    }

    private static String k(long j3) {
        return "!59M(/QlvkDj@f.v" + j3;
    }

    private static int l(int i3, int i16) {
        return (Integer.rotateLeft(i3 ^ i16, 13) * 5) - 430675100;
    }

    private static int m(int i3) {
        return Integer.rotateLeft(i3 * (-862048943), 15) * 461845907;
    }

    public static int n(byte b16) {
        return b16 & 255;
    }
}
