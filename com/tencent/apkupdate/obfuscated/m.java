package com.tencent.apkupdate.obfuscated;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes3.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f72550e;

    /* renamed from: a, reason: collision with root package name */
    public final long[] f72551a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f72552b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f72553c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f72554d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8880);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f72550e = new byte[]{Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f72551a = new long[4];
        this.f72552b = new long[2];
        this.f72553c = new byte[64];
        this.f72554d = new byte[16];
        d();
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

    public static String c(String str) {
        byte[] bytes;
        int i3;
        try {
            bytes = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        m mVar = new m();
        mVar.d();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        long length = bytes.length;
        byte[] bArr = new byte[64];
        long[] jArr = mVar.f72552b;
        long j3 = jArr[0];
        int i16 = ((int) (j3 >>> 3)) & 63;
        long j16 = length << 3;
        long j17 = j3 + j16;
        jArr[0] = j17;
        if (j17 < j16) {
            jArr[1] = jArr[1] + 1;
        }
        jArr[1] = jArr[1] + (length >>> 29);
        int i17 = 64 - i16;
        if (length >= i17) {
            byte[] bArr2 = new byte[i17];
            try {
                byteArrayInputStream.read(bArr2, 0, i17);
                mVar.g(mVar.f72553c, bArr2, i16, 0, i17);
                mVar.e(mVar.f72553c);
                while (i17 + 63 < length) {
                    byteArrayInputStream.read(bArr);
                    mVar.e(bArr);
                    i17 += 64;
                }
                i16 = 0;
            } catch (Exception unused2) {
            }
        } else {
            i17 = 0;
        }
        int i18 = (int) (length - i17);
        byte[] bArr3 = new byte[i18];
        byteArrayInputStream.read(bArr3);
        mVar.g(mVar.f72553c, bArr3, i16, 0, i18);
        try {
            byte[] bArr4 = new byte[8];
            mVar.h(bArr4, mVar.f72552b, 8);
            int i19 = ((int) (mVar.f72552b[0] >>> 3)) & 63;
            if (i19 < 56) {
                i3 = 56 - i19;
            } else {
                i3 = 120 - i19;
            }
            mVar.f(f72550e, i3);
            mVar.f(bArr4, 8);
            mVar.h(mVar.f72554d, mVar.f72551a, 16);
        } catch (Throwable unused3) {
        }
        byte[] bArr5 = mVar.f72554d;
        String str2 = "";
        for (int i26 = 0; i26 < 16; i26++) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            byte b16 = bArr5[i26];
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
            sb5.append(new String(new char[]{cArr[(b16 >>> 4) & 15], cArr[b16 & RegisterType.DOUBLE_HI]}));
            str2 = sb5.toString();
        }
        return str2;
    }

    public final long b(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27))).longValue();
        }
        int i3 = (int) (((j16 & j17) | ((~j16) & j18)) + j19 + j27 + j3);
        return ((i3 >>> ((int) (32 - j26))) | (i3 << ((int) j26))) + j16;
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long[] jArr = this.f72552b;
        jArr[0] = 0;
        jArr[1] = 0;
        long[] jArr2 = this.f72551a;
        jArr2[0] = 1732584193;
        jArr2[1] = 4023233417L;
        jArr2[2] = 2562383102L;
        jArr2[3] = 271733878;
    }

    public final void e(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bArr);
            return;
        }
        long[] jArr = this.f72551a;
        long j3 = jArr[0];
        long j16 = jArr[1];
        long j17 = jArr[2];
        long j18 = jArr[3];
        long[] jArr2 = new long[16];
        int i3 = 0;
        for (int i16 = 0; i16 < 64; i16 += 4) {
            jArr2[i3] = a(bArr[i16]) | (a(bArr[i16 + 1]) << 8) | (a(bArr[i16 + 2]) << 16) | (a(bArr[i16 + 3]) << 24);
            i3++;
        }
        long b16 = b(j3, j16, j17, j18, jArr2[0], 7L, 3614090360L);
        long b17 = b(j18, b16, j16, j17, jArr2[1], 12L, 3905402710L);
        long b18 = b(j17, b17, b16, j16, jArr2[2], 17L, 606105819L);
        long b19 = b(j16, b18, b17, b16, jArr2[3], 22L, 3250441966L);
        long b26 = b(b16, b19, b18, b17, jArr2[4], 7L, 4118548399L);
        long b27 = b(b17, b26, b19, b18, jArr2[5], 12L, 1200080426L);
        long b28 = b(b18, b27, b26, b19, jArr2[6], 17L, 2821735955L);
        long b29 = b(b19, b28, b27, b26, jArr2[7], 22L, 4249261313L);
        long b36 = b(b26, b29, b28, b27, jArr2[8], 7L, 1770035416L);
        long b37 = b(b27, b36, b29, b28, jArr2[9], 12L, 2336552879L);
        long b38 = b(b28, b37, b36, b29, jArr2[10], 17L, 4294925233L);
        long b39 = b(b29, b38, b37, b36, jArr2[11], 22L, 2304563134L);
        long b46 = b(b36, b39, b38, b37, jArr2[12], 7L, 1804603682L);
        long b47 = b(b37, b46, b39, b38, jArr2[13], 12L, 4254626195L);
        long b48 = b(b38, b47, b46, b39, jArr2[14], 17L, 2792965006L);
        long b49 = b(b39, b48, b47, b46, jArr2[15], 22L, 1236535329L);
        long i17 = i(b46, b49, b48, b47, jArr2[1], 5L, 4129170786L);
        long i18 = i(b47, i17, b49, b48, jArr2[6], 9L, 3225465664L);
        long i19 = i(b48, i18, i17, b49, jArr2[11], 14L, 643717713L);
        long i26 = i(b49, i19, i18, i17, jArr2[0], 20L, 3921069994L);
        long i27 = i(i17, i26, i19, i18, jArr2[5], 5L, 3593408605L);
        long i28 = i(i18, i27, i26, i19, jArr2[10], 9L, 38016083L);
        long i29 = i(i19, i28, i27, i26, jArr2[15], 14L, 3634488961L);
        long i36 = i(i26, i29, i28, i27, jArr2[4], 20L, 3889429448L);
        long i37 = i(i27, i36, i29, i28, jArr2[9], 5L, 568446438L);
        long i38 = i(i28, i37, i36, i29, jArr2[14], 9L, 3275163606L);
        long i39 = i(i29, i38, i37, i36, jArr2[3], 14L, 4107603335L);
        long i46 = i(i36, i39, i38, i37, jArr2[8], 20L, 1163531501L);
        long i47 = i(i37, i46, i39, i38, jArr2[13], 5L, 2850285829L);
        long i48 = i(i38, i47, i46, i39, jArr2[2], 9L, 4243563512L);
        long i49 = i(i39, i48, i47, i46, jArr2[7], 14L, 1735328473L);
        long i56 = i(i46, i49, i48, i47, jArr2[12], 20L, 2368359562L);
        long j19 = j(i47, i56, i49, i48, jArr2[5], 4L, 4294588738L);
        long j26 = j(i48, j19, i56, i49, jArr2[8], 11L, 2272392833L);
        long j27 = j(i49, j26, j19, i56, jArr2[11], 16L, 1839030562L);
        long j28 = j(i56, j27, j26, j19, jArr2[14], 23L, 4259657740L);
        long j29 = j(j19, j28, j27, j26, jArr2[1], 4L, 2763975236L);
        long j36 = j(j26, j29, j28, j27, jArr2[4], 11L, 1272893353L);
        long j37 = j(j27, j36, j29, j28, jArr2[7], 16L, 4139469664L);
        long j38 = j(j28, j37, j36, j29, jArr2[10], 23L, 3200236656L);
        long j39 = j(j29, j38, j37, j36, jArr2[13], 4L, 681279174L);
        long j46 = j(j36, j39, j38, j37, jArr2[0], 11L, 3936430074L);
        long j47 = j(j37, j46, j39, j38, jArr2[3], 16L, 3572445317L);
        long j48 = j(j38, j47, j46, j39, jArr2[6], 23L, 76029189L);
        long j49 = j(j39, j48, j47, j46, jArr2[9], 4L, 3654602809L);
        long j56 = j(j46, j49, j48, j47, jArr2[12], 11L, 3873151461L);
        long j57 = j(j47, j56, j49, j48, jArr2[15], 16L, 530742520L);
        long j58 = j(j48, j57, j56, j49, jArr2[2], 23L, 3299628645L);
        long k3 = k(j49, j58, j57, j56, jArr2[0], 6L, 4096336452L);
        long k16 = k(j56, k3, j58, j57, jArr2[7], 10L, 1126891415L);
        long k17 = k(j57, k16, k3, j58, jArr2[14], 15L, 2878612391L);
        long k18 = k(j58, k17, k16, k3, jArr2[5], 21L, 4237533241L);
        long k19 = k(k3, k18, k17, k16, jArr2[12], 6L, 1700485571L);
        long k26 = k(k16, k19, k18, k17, jArr2[3], 10L, 2399980690L);
        long k27 = k(k17, k26, k19, k18, jArr2[10], 15L, 4293915773L);
        long k28 = k(k18, k27, k26, k19, jArr2[1], 21L, 2240044497L);
        long k29 = k(k19, k28, k27, k26, jArr2[8], 6L, 1873313359L);
        long k36 = k(k26, k29, k28, k27, jArr2[15], 10L, 4264355552L);
        long k37 = k(k27, k36, k29, k28, jArr2[6], 15L, 2734768916L);
        long k38 = k(k28, k37, k36, k29, jArr2[13], 21L, 1309151649L);
        long k39 = k(k29, k38, k37, k36, jArr2[4], 6L, 4149444226L);
        long k46 = k(k36, k39, k38, k37, jArr2[11], 10L, 3174756917L);
        long k47 = k(k37, k46, k39, k38, jArr2[2], 15L, 718787259L);
        long k48 = k(k38, k47, k46, k39, jArr2[9], 21L, 3951481745L);
        long[] jArr3 = this.f72551a;
        jArr3[0] = jArr3[0] + k39;
        jArr3[1] = jArr3[1] + k48;
        jArr3[2] = jArr3[2] + k47;
        jArr3[3] = jArr3[3] + k46;
    }

    public final void f(byte[] bArr, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr, i3);
            return;
        }
        byte[] bArr2 = new byte[64];
        long[] jArr = this.f72552b;
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
            g(this.f72553c, bArr, i17, 0, i18);
            e(this.f72553c);
            while (i18 + 63 < i3) {
                g(bArr2, bArr, 0, i18, 64);
                e(bArr2);
                i18 += 64;
            }
            i17 = 0;
            i16 = i18;
        } else {
            i16 = 0;
        }
        g(this.f72553c, bArr, i17, i16, i3 - i16);
    }

    public final void g(byte[] bArr, byte[] bArr2, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, bArr, bArr2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        for (int i18 = 0; i18 < i17; i18++) {
            bArr[i3 + i18] = bArr2[i16 + i18];
        }
    }

    public final void h(byte[] bArr, long[] jArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, bArr, jArr, Integer.valueOf(i3));
            return;
        }
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

    public final long i(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27))).longValue();
        }
        int i3 = (int) ((((~j18) & j17) | (j16 & j18)) + j19 + j27 + j3);
        return ((i3 >>> ((int) (32 - j26))) | (i3 << ((int) j26))) + j16;
    }

    public final long j(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27))).longValue();
        }
        int i3 = (int) (((j16 ^ j17) ^ j18) + j19 + j27 + j3);
        return ((i3 >>> ((int) (32 - j26))) | (i3 << ((int) j26))) + j16;
    }

    public final long k(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27))).longValue();
        }
        int i3 = (int) ((((~j18) | j16) ^ j17) + j19 + j27 + j3);
        return ((i3 >>> ((int) (32 - j26))) | (i3 << ((int) j26))) + j16;
    }
}
