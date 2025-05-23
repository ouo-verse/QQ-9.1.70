package ga3;

import cooperation.qzone.QZoneHelper;
import java.nio.charset.StandardCharsets;
import okio.Utf8;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes21.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private char[] f401634a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f401635b;

    /* renamed from: c, reason: collision with root package name */
    public int f401636c;

    public m(int i3) {
        this(new byte[i3], 0);
    }

    private String a(int i3) {
        if (i3 > 2048) {
            return new String(this.f401635b, this.f401636c, i3, StandardCharsets.UTF_8);
        }
        char[] e16 = e(i3);
        byte[] bArr = this.f401635b;
        int i16 = this.f401636c;
        int i17 = i3 + i16;
        int i18 = 0;
        while (i16 < i17) {
            int i19 = i16 + 1;
            byte b16 = bArr[i16];
            if (b16 > 0) {
                e16[i18] = (char) b16;
                i16 = i19;
                i18++;
            } else if (b16 < -32) {
                e16[i18] = (char) (((b16 & 31) << 6) | (bArr[i19] & 63));
                i16 = i19 + 1;
                i18++;
            } else if (b16 < -16) {
                int i26 = i19 + 1;
                e16[i18] = (char) (((b16 & RegisterType.DOUBLE_HI) << 12) | ((bArr[i19] & 63) << 6) | (bArr[i26] & 63));
                i16 = i26 + 1;
                i18++;
            } else {
                int i27 = i19 + 1;
                int i28 = i27 + 1;
                int i29 = ((b16 & 7) << 18) | ((bArr[i19] & 63) << 12) | ((bArr[i27] & 63) << 6) | (bArr[i28] & 63);
                int i36 = i18 + 1;
                e16[i18] = (char) ((i29 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i18 = i36 + 1;
                e16[i36] = (char) ((i29 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                i16 = i28 + 1;
            }
        }
        if (i16 <= i17) {
            return new String(e16, 0, i18);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private void b(String str) {
        byte[] bArr = this.f401635b;
        int i3 = this.f401636c;
        int length = str.length();
        int i16 = 0;
        while (i16 < length) {
            int i17 = i16 + 1;
            char charAt = str.charAt(i16);
            if (charAt < '\u0080') {
                bArr[i3] = (byte) charAt;
                i16 = i17;
                i3++;
            } else if (charAt < '\u0800') {
                int i18 = i3 + 1;
                bArr[i3] = (byte) ((charAt >>> 6) | 192);
                i3 = i18 + 1;
                bArr[i18] = (byte) ((charAt & '?') | 128);
                i16 = i17;
            } else if (charAt >= '\ud800' && charAt <= '\udfff') {
                int i19 = i17 + 1;
                int charAt2 = ((charAt << '\n') + str.charAt(i17)) - 56613888;
                int i26 = i3 + 1;
                bArr[i3] = (byte) ((charAt2 >>> 18) | 240);
                int i27 = i26 + 1;
                bArr[i26] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i28 = i27 + 1;
                bArr[i27] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i3 = i28 + 1;
                bArr[i28] = (byte) ((charAt2 & 63) | 128);
                i16 = i19;
            } else {
                int i29 = i3 + 1;
                bArr[i3] = (byte) ((charAt >>> '\f') | 224);
                int i36 = i29 + 1;
                bArr[i29] = (byte) (((charAt >>> 6) & 63) | 128);
                bArr[i36] = (byte) ((charAt & '?') | 128);
                i16 = i17;
                i3 = i36 + 1;
            }
        }
        this.f401636c = i3;
    }

    private char[] e(int i3) {
        char[] cArr = this.f401634a;
        if (cArr == null) {
            if (i3 <= 256) {
                this.f401634a = new char[256];
            } else {
                this.f401634a = new char[2048];
            }
        } else if (cArr.length < i3) {
            this.f401634a = new char[2048];
        }
        return this.f401634a;
    }

    public static int n(String str) {
        int length = str.length();
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            int i17 = i3 + 1;
            char charAt = str.charAt(i3);
            if (charAt < '\u0080') {
                i16++;
            } else if (charAt < '\u0800') {
                i16 += 2;
            } else if (charAt >= '\ud800' && charAt <= '\udfff') {
                i17++;
                i16 += 4;
            } else {
                i16 += 3;
            }
            i3 = i17;
        }
        return i16;
    }

    public static int o(int i3) {
        if ((i3 >> 7) == 0) {
            return 1;
        }
        if ((i3 >> 14) == 0) {
            return 2;
        }
        if ((i3 >> 21) == 0) {
            return 3;
        }
        if ((i3 >> 28) == 0) {
            return 4;
        }
        return 5;
    }

    public byte c() {
        byte[] bArr = this.f401635b;
        int i3 = this.f401636c;
        this.f401636c = i3 + 1;
        return bArr[i3];
    }

    public byte[] d(int i3) {
        byte[] bArr = new byte[i3];
        System.arraycopy(this.f401635b, this.f401636c, bArr, 0, i3);
        this.f401636c += i3;
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long f(int i3, int i16) {
        long j3 = 0;
        if (i16 <= 0) {
            return 0L;
        }
        int i17 = i16 >> 3;
        int i18 = i16 & 7;
        int i19 = 0;
        int i26 = i3;
        for (int i27 = 0; i27 < i17; i27++) {
            j3 ^= k(i26);
            i26 += 8;
        }
        while (i19 < (i18 << 3)) {
            j3 ^= (this.f401635b[i26] & 255) << i19;
            i19 += 8;
            i26++;
        }
        int i28 = (i3 & 7) << 3;
        return (j3 >>> (64 - i28)) | (j3 << i28);
    }

    public double g() {
        return Double.longBitsToDouble(j());
    }

    public float h() {
        return Float.intBitsToFloat(i());
    }

    public int i() {
        byte[] bArr = this.f401635b;
        int i3 = this.f401636c;
        int i16 = i3 + 1;
        int i17 = i16 + 1;
        int i18 = (bArr[i3] & 255) | ((bArr[i16] & 255) << 8);
        int i19 = i17 + 1;
        int i26 = i18 | ((bArr[i17] & 255) << 16);
        this.f401636c = i19 + 1;
        return (bArr[i19] << 24) | i26;
    }

    public long j() {
        long k3 = k(this.f401636c);
        this.f401636c += 8;
        return k3;
    }

    public long k(int i3) {
        byte[] bArr = this.f401635b;
        long j3 = bArr[i3] & 255;
        int i16 = i3 + 1 + 1 + 1;
        long j16 = j3 | ((bArr[r1] & 255) << 8) | ((bArr[r9] & 255) << 16);
        long j17 = j16 | ((bArr[i16] & 255) << 24);
        long j18 = j17 | ((bArr[r9] & 255) << 32);
        int i17 = i16 + 1 + 1 + 1;
        return j18 | ((bArr[r3] & 255) << 40) | ((255 & bArr[i17]) << 48) | (bArr[i17 + 1] << 56);
    }

    public short l() {
        byte[] bArr = this.f401635b;
        int i3 = this.f401636c;
        int i16 = i3 + 1;
        int i17 = bArr[i3] & 255;
        this.f401636c = i16 + 1;
        return (short) ((bArr[i16] << 8) | i17);
    }

    public String m(int i3) {
        if (i3 < 0) {
            return null;
        }
        if (i3 == 0) {
            return "";
        }
        String a16 = a(i3);
        this.f401636c += i3;
        return a16;
    }

    public int p() {
        byte[] bArr = this.f401635b;
        int i3 = this.f401636c;
        int i16 = i3 + 1;
        this.f401636c = i16;
        byte b16 = bArr[i3];
        if ((b16 >> 7) == 0) {
            return b16;
        }
        int i17 = i16 + 1;
        this.f401636c = i17;
        int i18 = (b16 & Byte.MAX_VALUE) | (bArr[i16] << 7);
        if ((i18 >> 14) == 0) {
            return i18;
        }
        int i19 = i17 + 1;
        this.f401636c = i19;
        int i26 = (i18 & 16383) | (bArr[i17] << RegisterType.DOUBLE_LO);
        if ((i26 >> 21) == 0) {
            return i26;
        }
        int i27 = i19 + 1;
        this.f401636c = i27;
        int i28 = (i26 & 2097151) | (bArr[i19] << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER);
        if ((i28 >> 28) == 0) {
            return i28;
        }
        this.f401636c = i27 + 1;
        return (bArr[i27] << 28) | (i28 & 268435455);
    }

    public final void q(byte b16) {
        byte[] bArr = this.f401635b;
        int i3 = this.f401636c;
        this.f401636c = i3 + 1;
        bArr[i3] = b16;
    }

    public void r(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.f401635b, this.f401636c, length);
            this.f401636c += length;
        }
    }

    public void s(int i3) {
        byte[] bArr = this.f401635b;
        int i16 = this.f401636c;
        int i17 = i16 + 1;
        bArr[i16] = (byte) i3;
        int i18 = i17 + 1;
        bArr[i17] = (byte) (i3 >> 8);
        int i19 = i18 + 1;
        bArr[i18] = (byte) (i3 >> 16);
        this.f401636c = i19 + 1;
        bArr[i19] = (byte) (i3 >> 24);
    }

    public void t(int i3, int i16) {
        byte[] bArr = this.f401635b;
        int i17 = i3 + 1;
        bArr[i3] = (byte) i16;
        int i18 = i17 + 1;
        bArr[i17] = (byte) (i16 >> 8);
        bArr[i18] = (byte) (i16 >> 16);
        bArr[i18 + 1] = (byte) (i16 >> 24);
    }

    public void u(int i3, long j3) {
        byte[] bArr = this.f401635b;
        int i16 = i3 + 1;
        bArr[i3] = (byte) j3;
        int i17 = i16 + 1;
        bArr[i16] = (byte) (j3 >> 8);
        int i18 = i17 + 1;
        bArr[i17] = (byte) (j3 >> 16);
        int i19 = i18 + 1;
        bArr[i18] = (byte) (j3 >> 24);
        int i26 = i19 + 1;
        bArr[i19] = (byte) (j3 >> 32);
        int i27 = i26 + 1;
        bArr[i26] = (byte) (j3 >> 40);
        bArr[i27] = (byte) (j3 >> 48);
        bArr[i27 + 1] = (byte) (j3 >> 56);
    }

    public void v(long j3) {
        u(this.f401636c, j3);
        this.f401636c += 8;
    }

    public void w(short s16) {
        byte[] bArr = this.f401635b;
        int i3 = this.f401636c;
        int i16 = i3 + 1;
        bArr[i3] = (byte) s16;
        this.f401636c = i16 + 1;
        bArr[i16] = (byte) (s16 >> 8);
    }

    public void x(String str) {
        if (str != null && !str.isEmpty()) {
            b(str);
        }
    }

    public int y(int i3, int i16) {
        while ((i16 & (-128)) != 0) {
            this.f401635b[i3] = (byte) ((i16 & 127) | 128);
            i16 >>>= 7;
            i3++;
        }
        int i17 = i3 + 1;
        this.f401635b[i3] = (byte) i16;
        return i17;
    }

    public void z(int i3) {
        this.f401636c = y(this.f401636c, i3);
    }

    public m(byte[] bArr) {
        this(bArr, 0);
    }

    public m(byte[] bArr, int i3) {
        this.f401634a = null;
        this.f401635b = bArr;
        this.f401636c = i3;
    }
}
