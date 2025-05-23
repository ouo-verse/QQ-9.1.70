package oicq.wlogin_sdk.tools;

import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MD5 {
    public static final byte[] PADDING = {Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final int S11 = 7;
    public static final int S12 = 12;
    public static final int S13 = 17;
    public static final int S14 = 22;
    public static final int S21 = 5;
    public static final int S22 = 9;
    public static final int S23 = 14;
    public static final int S24 = 20;
    public static final int S31 = 4;
    public static final int S32 = 11;
    public static final int S33 = 16;
    public static final int S34 = 23;
    public static final int S41 = 6;
    public static final int S42 = 10;
    public static final int S43 = 15;
    public static final int S44 = 21;
    public String digestHexStr;
    private long[] state = new long[4];
    private long[] count = new long[2];
    private byte[] buffer = new byte[64];
    private byte[] digest = new byte[16];

    public MD5() {
        md5Init();
    }

    private void Decode(long[] jArr, byte[] bArr, int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17 += 4) {
            jArr[i16] = b2iu(bArr[i17]) | (b2iu(bArr[i17 + 1]) << 8) | (b2iu(bArr[i17 + 2]) << 16) | (b2iu(bArr[i17 + 3]) << 24);
            i16++;
        }
    }

    private void Encode(byte[] bArr, long[] jArr, int i3) {
        int length = jArr.length;
        util.LOGI("Encode " + length + " len:" + i3, "");
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17 += 4) {
            if (i16 >= length) {
                util.LOGI("Encode index:" + i16, "");
            }
            long j3 = jArr[i16];
            bArr[i17] = (byte) (j3 & 255);
            bArr[i17 + 1] = (byte) ((j3 >>> 8) & 255);
            bArr[i17 + 2] = (byte) ((j3 >>> 16) & 255);
            bArr[i17 + 3] = (byte) ((j3 >>> 24) & 255);
            i16++;
        }
    }

    private long F(long j3, long j16, long j17) {
        return ((~j3) & j17) | (j16 & j3);
    }

    private long FF(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        int F = (int) (F(j16, j17, j18) + j19 + j27 + j3);
        return ((F >>> ((int) (32 - j26))) | (F << ((int) j26))) + j16;
    }

    private long G(long j3, long j16, long j17) {
        return (j3 & j17) | (j16 & (~j17));
    }

    private long GG(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        int G = (int) (G(j16, j17, j18) + j19 + j27 + j3);
        return ((G >>> ((int) (32 - j26))) | (G << ((int) j26))) + j16;
    }

    private long H(long j3, long j16, long j17) {
        return (j3 ^ j16) ^ j17;
    }

    private long HH(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        int H = (int) (H(j16, j17, j18) + j19 + j27 + j3);
        return ((H >>> ((int) (32 - j26))) | (H << ((int) j26))) + j16;
    }

    private long I(long j3, long j16, long j17) {
        return (j3 | (~j17)) ^ j16;
    }

    private long II(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        int I = (int) (I(j16, j17, j18) + j19 + j27 + j3);
        return ((I >>> ((int) (32 - j26))) | (I << ((int) j26))) + j16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long b2iu(byte b16) {
        byte b17;
        if (b16 < 0) {
            b17 = b16 & 255;
        }
        return b17;
    }

    public static String byteHEX(byte b16) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        return new String(new char[]{cArr[(b16 >>> 4) & 15], cArr[b16 & RegisterType.DOUBLE_HI]});
    }

    public static String getFileMD5(File file) {
        int i3;
        if (file == null) {
            return "";
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 8192);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                fileInputStream.close();
                byte[] digest = messageDigest.digest();
                char[] cArr2 = new char[32];
                int i16 = 0;
                for (i3 = 0; i3 < 16; i3++) {
                    byte b16 = digest[i3];
                    int i17 = i16 + 1;
                    cArr2[i16] = cArr[(b16 >>> 4) & 15];
                    i16 = i17 + 1;
                    cArr2[i17] = cArr[b16 & RegisterType.DOUBLE_HI];
                }
                return new String(cArr2);
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        } catch (Exception e17) {
            util.printException(e17, "");
            return "";
        }
    }

    public static String getMD5String(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[32];
            int i3 = 0;
            for (int i16 = 0; i16 < 16; i16++) {
                byte b16 = digest[i16];
                int i17 = i3 + 1;
                cArr2[i3] = cArr[(b16 >>> 4) & 15];
                i3 = i17 + 1;
                cArr2[i17] = cArr[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr2);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private void md5Final() {
        int i3;
        byte[] bArr = new byte[8];
        Encode(bArr, this.count, 8);
        int i16 = ((int) (this.count[0] >>> 3)) & 63;
        if (i16 < 56) {
            i3 = 56 - i16;
        } else {
            i3 = 120 - i16;
        }
        md5Update(PADDING, i3);
        md5Update(bArr, 8);
        Encode(this.digest, this.state, 16);
    }

    private void md5Init() {
        long[] jArr = this.count;
        jArr[0] = 0;
        jArr[1] = 0;
        long[] jArr2 = this.state;
        jArr2[0] = 1732584193;
        jArr2[1] = 4023233417L;
        jArr2[2] = 2562383102L;
        jArr2[3] = 271733878;
    }

    private void md5Memcpy(byte[] bArr, byte[] bArr2, int i3, int i16, int i17) {
        for (int i18 = 0; i18 < i17; i18++) {
            bArr[i3 + i18] = bArr2[i16 + i18];
        }
    }

    private void md5Transform(byte[] bArr) {
        long[] jArr = this.state;
        long j3 = jArr[0];
        long j16 = jArr[1];
        long j17 = jArr[2];
        long j18 = jArr[3];
        long[] jArr2 = new long[16];
        Decode(jArr2, bArr, 64);
        long FF = FF(j3, j16, j17, j18, jArr2[0], 7L, 3614090360L);
        long FF2 = FF(j18, FF, j16, j17, jArr2[1], 12L, 3905402710L);
        long FF3 = FF(j17, FF2, FF, j16, jArr2[2], 17L, 606105819L);
        long FF4 = FF(j16, FF3, FF2, FF, jArr2[3], 22L, 3250441966L);
        long FF5 = FF(FF, FF4, FF3, FF2, jArr2[4], 7L, 4118548399L);
        long FF6 = FF(FF2, FF5, FF4, FF3, jArr2[5], 12L, 1200080426L);
        long FF7 = FF(FF3, FF6, FF5, FF4, jArr2[6], 17L, 2821735955L);
        long FF8 = FF(FF4, FF7, FF6, FF5, jArr2[7], 22L, 4249261313L);
        long FF9 = FF(FF5, FF8, FF7, FF6, jArr2[8], 7L, 1770035416L);
        long FF10 = FF(FF6, FF9, FF8, FF7, jArr2[9], 12L, 2336552879L);
        long FF11 = FF(FF7, FF10, FF9, FF8, jArr2[10], 17L, 4294925233L);
        long FF12 = FF(FF8, FF11, FF10, FF9, jArr2[11], 22L, 2304563134L);
        long FF13 = FF(FF9, FF12, FF11, FF10, jArr2[12], 7L, 1804603682L);
        long FF14 = FF(FF10, FF13, FF12, FF11, jArr2[13], 12L, 4254626195L);
        long FF15 = FF(FF11, FF14, FF13, FF12, jArr2[14], 17L, 2792965006L);
        long FF16 = FF(FF12, FF15, FF14, FF13, jArr2[15], 22L, 1236535329L);
        long GG = GG(FF13, FF16, FF15, FF14, jArr2[1], 5L, 4129170786L);
        long GG2 = GG(FF14, GG, FF16, FF15, jArr2[6], 9L, 3225465664L);
        long GG3 = GG(FF15, GG2, GG, FF16, jArr2[11], 14L, 643717713L);
        long GG4 = GG(FF16, GG3, GG2, GG, jArr2[0], 20L, 3921069994L);
        long GG5 = GG(GG, GG4, GG3, GG2, jArr2[5], 5L, 3593408605L);
        long GG6 = GG(GG2, GG5, GG4, GG3, jArr2[10], 9L, 38016083L);
        long GG7 = GG(GG3, GG6, GG5, GG4, jArr2[15], 14L, 3634488961L);
        long GG8 = GG(GG4, GG7, GG6, GG5, jArr2[4], 20L, 3889429448L);
        long GG9 = GG(GG5, GG8, GG7, GG6, jArr2[9], 5L, 568446438L);
        long GG10 = GG(GG6, GG9, GG8, GG7, jArr2[14], 9L, 3275163606L);
        long GG11 = GG(GG7, GG10, GG9, GG8, jArr2[3], 14L, 4107603335L);
        long GG12 = GG(GG8, GG11, GG10, GG9, jArr2[8], 20L, 1163531501L);
        long GG13 = GG(GG9, GG12, GG11, GG10, jArr2[13], 5L, 2850285829L);
        long GG14 = GG(GG10, GG13, GG12, GG11, jArr2[2], 9L, 4243563512L);
        long GG15 = GG(GG11, GG14, GG13, GG12, jArr2[7], 14L, 1735328473L);
        long GG16 = GG(GG12, GG15, GG14, GG13, jArr2[12], 20L, 2368359562L);
        long HH = HH(GG13, GG16, GG15, GG14, jArr2[5], 4L, 4294588738L);
        long HH2 = HH(GG14, HH, GG16, GG15, jArr2[8], 11L, 2272392833L);
        long HH3 = HH(GG15, HH2, HH, GG16, jArr2[11], 16L, 1839030562L);
        long HH4 = HH(GG16, HH3, HH2, HH, jArr2[14], 23L, 4259657740L);
        long HH5 = HH(HH, HH4, HH3, HH2, jArr2[1], 4L, 2763975236L);
        long HH6 = HH(HH2, HH5, HH4, HH3, jArr2[4], 11L, 1272893353L);
        long HH7 = HH(HH3, HH6, HH5, HH4, jArr2[7], 16L, 4139469664L);
        long HH8 = HH(HH4, HH7, HH6, HH5, jArr2[10], 23L, 3200236656L);
        long HH9 = HH(HH5, HH8, HH7, HH6, jArr2[13], 4L, 681279174L);
        long HH10 = HH(HH6, HH9, HH8, HH7, jArr2[0], 11L, 3936430074L);
        long HH11 = HH(HH7, HH10, HH9, HH8, jArr2[3], 16L, 3572445317L);
        long HH12 = HH(HH8, HH11, HH10, HH9, jArr2[6], 23L, 76029189L);
        long HH13 = HH(HH9, HH12, HH11, HH10, jArr2[9], 4L, 3654602809L);
        long HH14 = HH(HH10, HH13, HH12, HH11, jArr2[12], 11L, 3873151461L);
        long HH15 = HH(HH11, HH14, HH13, HH12, jArr2[15], 16L, 530742520L);
        long HH16 = HH(HH12, HH15, HH14, HH13, jArr2[2], 23L, 3299628645L);
        long II = II(HH13, HH16, HH15, HH14, jArr2[0], 6L, 4096336452L);
        long II2 = II(HH14, II, HH16, HH15, jArr2[7], 10L, 1126891415L);
        long II3 = II(HH15, II2, II, HH16, jArr2[14], 15L, 2878612391L);
        long II4 = II(HH16, II3, II2, II, jArr2[5], 21L, 4237533241L);
        long II5 = II(II, II4, II3, II2, jArr2[12], 6L, 1700485571L);
        long II6 = II(II2, II5, II4, II3, jArr2[3], 10L, 2399980690L);
        long II7 = II(II3, II6, II5, II4, jArr2[10], 15L, 4293915773L);
        long II8 = II(II4, II7, II6, II5, jArr2[1], 21L, 2240044497L);
        long II9 = II(II5, II8, II7, II6, jArr2[8], 6L, 1873313359L);
        long II10 = II(II6, II9, II8, II7, jArr2[15], 10L, 4264355552L);
        long II11 = II(II7, II10, II9, II8, jArr2[6], 15L, 2734768916L);
        long II12 = II(II8, II11, II10, II9, jArr2[13], 21L, 1309151649L);
        long II13 = II(II9, II12, II11, II10, jArr2[4], 6L, 4149444226L);
        long II14 = II(II10, II13, II12, II11, jArr2[11], 10L, 3174756917L);
        long II15 = II(II11, II14, II13, II12, jArr2[2], 15L, 718787259L);
        long II16 = II(II12, II15, II14, II13, jArr2[9], 21L, 3951481745L);
        long[] jArr3 = this.state;
        jArr3[0] = jArr3[0] + II13;
        jArr3[1] = jArr3[1] + II16;
        jArr3[2] = jArr3[2] + II15;
        jArr3[3] = jArr3[3] + II14;
    }

    private void md5Update(byte[] bArr, int i3) {
        int i16;
        byte[] bArr2 = new byte[64];
        long[] jArr = this.count;
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
            md5Memcpy(this.buffer, bArr, i17, 0, i18);
            md5Transform(this.buffer);
            while (i18 + 63 < i3) {
                md5Memcpy(bArr2, bArr, 0, i18, 64);
                md5Transform(bArr2);
                i18 += 64;
            }
            i17 = 0;
            i16 = i18;
        } else {
            i16 = 0;
        }
        md5Memcpy(this.buffer, bArr, i17, i16, i3 - i16);
    }

    public static String toMD5(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] md5 = new MD5().getMD5(bytes);
        String str2 = "";
        for (int i3 = 0; i3 < 16; i3++) {
            str2 = str2 + byteHEX(md5[i3]);
        }
        return str2;
    }

    public static byte[] toMD5Byte(InputStream inputStream, long j3) {
        return new MD5().getMD5(inputStream, j3);
    }

    public byte[] getMD5(InputStream inputStream, long j3) {
        md5Init();
        if (!md5Update(inputStream, j3)) {
            return new byte[16];
        }
        md5Final();
        return this.digest;
    }

    private boolean md5Update(InputStream inputStream, long j3) {
        int i3;
        byte[] bArr = new byte[64];
        long[] jArr = this.count;
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
                md5Memcpy(this.buffer, bArr2, i16, 0, i17);
                md5Transform(this.buffer);
                while (i17 + 63 < j3) {
                    try {
                        inputStream.read(bArr);
                        md5Transform(bArr);
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
            md5Memcpy(this.buffer, bArr3, i3, 0, i18);
            return true;
        } catch (Exception e18) {
            e18.printStackTrace();
            return false;
        }
    }

    public static String toMD5(byte[] bArr) {
        byte[] md5 = new MD5().getMD5(bArr);
        String str = "";
        for (int i3 = 0; i3 < 16; i3++) {
            str = str + byteHEX(md5[i3]);
        }
        return str;
    }

    public static byte[] toMD5Byte(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        return new MD5().getMD5(bytes);
    }

    public byte[] getMD5(byte[] bArr) {
        md5Init();
        md5Update(new ByteArrayInputStream(bArr), bArr.length);
        md5Final();
        return this.digest;
    }

    public static byte[] toMD5Byte(byte[] bArr) {
        return new MD5().getMD5(bArr);
    }
}
