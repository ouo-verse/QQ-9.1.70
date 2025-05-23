package com.tencent.gamecenter.wadl.sdk.common.e;

import com.tencent.mobileqq.text.EmotcationConstants;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d {

    /* renamed from: e, reason: collision with root package name */
    static final byte[] f107232e = {Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a, reason: collision with root package name */
    private long[] f107233a = new long[4];

    /* renamed from: b, reason: collision with root package name */
    private long[] f107234b = new long[2];

    /* renamed from: c, reason: collision with root package name */
    private byte[] f107235c = new byte[64];

    /* renamed from: d, reason: collision with root package name */
    private byte[] f107236d = new byte[16];

    public d() {
        b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(byte b16) {
        byte b17;
        if (b16 < 0) {
            b17 = b16 & 255;
        }
        return b17;
    }

    private long b(long j3, long j16, long j17) {
        return (j3 & j17) | (j16 & (~j17));
    }

    private long c(long j3, long j16, long j17) {
        return (j3 ^ j16) ^ j17;
    }

    private long d(long j3, long j16, long j17) {
        return (j3 | (~j17)) ^ j16;
    }

    private long a(long j3, long j16, long j17) {
        return ((~j3) & j17) | (j16 & j3);
    }

    private long b(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        int b16 = (int) (b(j16, j17, j18) + j19 + j27 + j3);
        return ((b16 >>> ((int) (32 - j26))) | (b16 << ((int) j26))) + j16;
    }

    private long c(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        int c16 = (int) (c(j16, j17, j18) + j19 + j27 + j3);
        return ((c16 >>> ((int) (32 - j26))) | (c16 << ((int) j26))) + j16;
    }

    private long d(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        int d16 = (int) (d(j16, j17, j18) + j19 + j27 + j3);
        return ((d16 >>> ((int) (32 - j26))) | (d16 << ((int) j26))) + j16;
    }

    private long a(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        int a16 = (int) (a(j16, j17, j18) + j19 + j27 + j3);
        return ((a16 >>> ((int) (32 - j26))) | (a16 << ((int) j26))) + j16;
    }

    public static String b(byte b16) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        return new String(new char[]{cArr[(b16 >>> 4) & 15], cArr[b16 & RegisterType.DOUBLE_HI]});
    }

    public static String c(byte[] bArr) {
        byte[] a16 = new d().a(bArr);
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < 16; i3++) {
            sb5.append(b(a16[i3]));
        }
        return sb5.toString();
    }

    public static String a(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] a16 = new d().a(bytes);
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < 16; i3++) {
            sb5.append(b(a16[i3]));
        }
        return sb5.toString();
    }

    private void b() {
        long[] jArr = this.f107234b;
        jArr[0] = 0;
        jArr[1] = 0;
        long[] jArr2 = this.f107233a;
        jArr2[0] = 1732584193;
        jArr2[1] = 4023233417L;
        jArr2[2] = 2562383102L;
        jArr2[3] = 271733878;
    }

    private void a() {
        byte[] bArr = new byte[8];
        a(bArr, this.f107234b, 8);
        int i3 = ((int) (this.f107234b[0] >>> 3)) & 63;
        a(f107232e, i3 < 56 ? 56 - i3 : 120 - i3);
        a(bArr, 8);
        a(this.f107236d, this.f107233a, 16);
    }

    private void b(byte[] bArr) {
        long[] jArr = this.f107233a;
        long j3 = jArr[0];
        long j16 = jArr[1];
        long j17 = jArr[2];
        long j18 = jArr[3];
        long[] jArr2 = new long[16];
        a(jArr2, bArr, 64);
        long a16 = a(j3, j16, j17, j18, jArr2[0], 7L, 3614090360L);
        long a17 = a(j18, a16, j16, j17, jArr2[1], 12L, 3905402710L);
        long a18 = a(j17, a17, a16, j16, jArr2[2], 17L, 606105819L);
        long a19 = a(j16, a18, a17, a16, jArr2[3], 22L, 3250441966L);
        long a26 = a(a16, a19, a18, a17, jArr2[4], 7L, 4118548399L);
        long a27 = a(a17, a26, a19, a18, jArr2[5], 12L, 1200080426L);
        long a28 = a(a18, a27, a26, a19, jArr2[6], 17L, 2821735955L);
        long a29 = a(a19, a28, a27, a26, jArr2[7], 22L, 4249261313L);
        long a36 = a(a26, a29, a28, a27, jArr2[8], 7L, 1770035416L);
        long a37 = a(a27, a36, a29, a28, jArr2[9], 12L, 2336552879L);
        long a38 = a(a28, a37, a36, a29, jArr2[10], 17L, 4294925233L);
        long a39 = a(a29, a38, a37, a36, jArr2[11], 22L, 2304563134L);
        long a46 = a(a36, a39, a38, a37, jArr2[12], 7L, 1804603682L);
        long a47 = a(a37, a46, a39, a38, jArr2[13], 12L, 4254626195L);
        long a48 = a(a38, a47, a46, a39, jArr2[14], 17L, 2792965006L);
        long a49 = a(a39, a48, a47, a46, jArr2[15], 22L, 1236535329L);
        long b16 = b(a46, a49, a48, a47, jArr2[1], 5L, 4129170786L);
        long b17 = b(a47, b16, a49, a48, jArr2[6], 9L, 3225465664L);
        long b18 = b(a48, b17, b16, a49, jArr2[11], 14L, 643717713L);
        long b19 = b(a49, b18, b17, b16, jArr2[0], 20L, 3921069994L);
        long b26 = b(b16, b19, b18, b17, jArr2[5], 5L, 3593408605L);
        long b27 = b(b17, b26, b19, b18, jArr2[10], 9L, 38016083L);
        long b28 = b(b18, b27, b26, b19, jArr2[15], 14L, 3634488961L);
        long b29 = b(b19, b28, b27, b26, jArr2[4], 20L, 3889429448L);
        long b36 = b(b26, b29, b28, b27, jArr2[9], 5L, 568446438L);
        long b37 = b(b27, b36, b29, b28, jArr2[14], 9L, 3275163606L);
        long b38 = b(b28, b37, b36, b29, jArr2[3], 14L, 4107603335L);
        long b39 = b(b29, b38, b37, b36, jArr2[8], 20L, 1163531501L);
        long b46 = b(b36, b39, b38, b37, jArr2[13], 5L, 2850285829L);
        long b47 = b(b37, b46, b39, b38, jArr2[2], 9L, 4243563512L);
        long b48 = b(b38, b47, b46, b39, jArr2[7], 14L, 1735328473L);
        long b49 = b(b39, b48, b47, b46, jArr2[12], 20L, 2368359562L);
        long c16 = c(b46, b49, b48, b47, jArr2[5], 4L, 4294588738L);
        long c17 = c(b47, c16, b49, b48, jArr2[8], 11L, 2272392833L);
        long c18 = c(b48, c17, c16, b49, jArr2[11], 16L, 1839030562L);
        long c19 = c(b49, c18, c17, c16, jArr2[14], 23L, 4259657740L);
        long c26 = c(c16, c19, c18, c17, jArr2[1], 4L, 2763975236L);
        long c27 = c(c17, c26, c19, c18, jArr2[4], 11L, 1272893353L);
        long c28 = c(c18, c27, c26, c19, jArr2[7], 16L, 4139469664L);
        long c29 = c(c19, c28, c27, c26, jArr2[10], 23L, 3200236656L);
        long c36 = c(c26, c29, c28, c27, jArr2[13], 4L, 681279174L);
        long c37 = c(c27, c36, c29, c28, jArr2[0], 11L, 3936430074L);
        long c38 = c(c28, c37, c36, c29, jArr2[3], 16L, 3572445317L);
        long c39 = c(c29, c38, c37, c36, jArr2[6], 23L, 76029189L);
        long c46 = c(c36, c39, c38, c37, jArr2[9], 4L, 3654602809L);
        long c47 = c(c37, c46, c39, c38, jArr2[12], 11L, 3873151461L);
        long c48 = c(c38, c47, c46, c39, jArr2[15], 16L, 530742520L);
        long c49 = c(c39, c48, c47, c46, jArr2[2], 23L, 3299628645L);
        long d16 = d(c46, c49, c48, c47, jArr2[0], 6L, 4096336452L);
        long d17 = d(c47, d16, c49, c48, jArr2[7], 10L, 1126891415L);
        long d18 = d(c48, d17, d16, c49, jArr2[14], 15L, 2878612391L);
        long d19 = d(c49, d18, d17, d16, jArr2[5], 21L, 4237533241L);
        long d26 = d(d16, d19, d18, d17, jArr2[12], 6L, 1700485571L);
        long d27 = d(d17, d26, d19, d18, jArr2[3], 10L, 2399980690L);
        long d28 = d(d18, d27, d26, d19, jArr2[10], 15L, 4293915773L);
        long d29 = d(d19, d28, d27, d26, jArr2[1], 21L, 2240044497L);
        long d36 = d(d26, d29, d28, d27, jArr2[8], 6L, 1873313359L);
        long d37 = d(d27, d36, d29, d28, jArr2[15], 10L, 4264355552L);
        long d38 = d(d28, d37, d36, d29, jArr2[6], 15L, 2734768916L);
        long d39 = d(d29, d38, d37, d36, jArr2[13], 21L, 1309151649L);
        long d46 = d(d36, d39, d38, d37, jArr2[4], 6L, 4149444226L);
        long d47 = d(d37, d46, d39, d38, jArr2[11], 10L, 3174756917L);
        long d48 = d(d38, d47, d46, d39, jArr2[2], 15L, 718787259L);
        long d49 = d(d39, d48, d47, d46, jArr2[9], 21L, 3951481745L);
        long[] jArr3 = this.f107233a;
        jArr3[0] = jArr3[0] + d46;
        jArr3[1] = jArr3[1] + d49;
        jArr3[2] = jArr3[2] + d48;
        jArr3[3] = jArr3[3] + d47;
    }

    private void a(byte[] bArr, int i3) {
        int i16;
        byte[] bArr2 = new byte[64];
        long[] jArr = this.f107234b;
        long j3 = jArr[0];
        int i17 = ((int) (j3 >>> 3)) & 63;
        long j16 = i3 << 3;
        long j17 = j3 + j16;
        jArr[0] = j17;
        if (j17 < j16) {
            jArr[1] = jArr[1] + 1;
        }
        jArr[1] = jArr[1] + (i3 >>> 29);
        int i18 = 64 - i17;
        if (i3 >= i18) {
            a(this.f107235c, bArr, i17, 0, i18);
            b(this.f107235c);
            while (i18 + 63 < i3) {
                a(bArr2, bArr, 0, i18, 64);
                b(bArr2);
                i18 += 64;
            }
            i17 = 0;
            i16 = i18;
        } else {
            i16 = 0;
        }
        a(this.f107235c, bArr, i17, i16, i3 - i16);
    }

    private void a(byte[] bArr, byte[] bArr2, int i3, int i16, int i17) {
        for (int i18 = 0; i18 < i17; i18++) {
            bArr[i3 + i18] = bArr2[i16 + i18];
        }
    }

    private void a(byte[] bArr, long[] jArr, int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17 += 4) {
            long j3 = jArr[i16];
            bArr[i17] = (byte) (j3 & 255);
            bArr[i17 + 1] = (byte) ((j3 >>> 8) & 255);
            bArr[i17 + 2] = (byte) ((j3 >>> 16) & 255);
            bArr[i17 + 3] = (byte) ((j3 >>> 24) & 255);
            i16++;
        }
    }

    private void a(long[] jArr, byte[] bArr, int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17 += 4) {
            jArr[i16] = a(bArr[i17]) | (a(bArr[i17 + 1]) << 8) | (a(bArr[i17 + 2]) << 16) | (a(bArr[i17 + 3]) << 24);
            i16++;
        }
    }

    private boolean a(InputStream inputStream, long j3) {
        int i3;
        byte[] bArr = new byte[64];
        long[] jArr = this.f107234b;
        long j16 = jArr[0];
        int i16 = ((int) (j16 >>> 3)) & 63;
        long j17 = j3 << 3;
        long j18 = j16 + j17;
        jArr[0] = j18;
        if (j18 < j17) {
            jArr[1] = jArr[1] + 1;
        }
        jArr[1] = jArr[1] + (j3 >>> 29);
        int i17 = 64 - i16;
        if (j3 >= i17) {
            byte[] bArr2 = new byte[i17];
            try {
                inputStream.read(bArr2, 0, i17);
                a(this.f107235c, bArr2, i16, 0, i17);
                b(this.f107235c);
                while (i17 + 63 < j3) {
                    try {
                        inputStream.read(bArr);
                        b(bArr);
                        i17 += 64;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        return false;
                    }
                }
                i3 = 0;
            } catch (Exception e17) {
                e17.printStackTrace();
                return false;
            }
        } else {
            i3 = i16;
            i17 = 0;
        }
        int i18 = (int) (j3 - i17);
        byte[] bArr3 = new byte[i18];
        try {
            inputStream.read(bArr3);
            a(this.f107235c, bArr3, i3, 0, i18);
            return true;
        } catch (Exception e18) {
            e18.printStackTrace();
            return false;
        }
    }

    public byte[] a(byte[] bArr) {
        b();
        a(new ByteArrayInputStream(bArr), bArr.length);
        a();
        return this.f107236d;
    }
}
