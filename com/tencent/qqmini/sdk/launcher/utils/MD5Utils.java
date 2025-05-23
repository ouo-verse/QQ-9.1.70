package com.tencent.qqmini.sdk.launcher.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MD5Utils {
    static final int S11 = 7;
    static final int S12 = 12;
    static final int S13 = 17;
    static final int S14 = 22;
    static final int S21 = 5;
    static final int S22 = 9;
    static final int S23 = 14;
    static final int S24 = 20;
    static final int S31 = 4;
    static final int S32 = 11;
    static final int S33 = 16;
    static final int S34 = 23;
    static final int S41 = 6;
    static final int S42 = 10;
    static final int S43 = 15;
    static final int S44 = 21;
    public String digestHexStr;
    static final byte[] PADDING = {Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
    protected static Comparator strComparator = new StringComparator();
    protected static Comparator<File> fileComparator = new FileComparator();
    protected static List<String> md5List = new ArrayList();
    private long[] state = new long[4];
    private long[] count = new long[2];
    private byte[] buffer = new byte[64];
    private byte[] digest = new byte[16];

    /* compiled from: P */
    /* loaded from: classes23.dex */
    static class FileComparator implements Comparator<File> {
        FileComparator() {
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    static class StringComparator implements Comparator<String> {
        StringComparator() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    public MD5Utils() {
        md5Init();
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

    private void decode(long[] jArr, byte[] bArr, int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17 += 4) {
            jArr[i16] = b2iu(bArr[i17]) | (b2iu(bArr[i17 + 1]) << 8) | (b2iu(bArr[i17 + 2]) << 16) | (b2iu(bArr[i17 + 3]) << 24);
            i16++;
        }
    }

    protected static byte[] encode(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    protected static byte[] encodeFile(String str) {
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                File file = new File(str);
                if (!file.exists()) {
                    return null;
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                byte[] bArr = new byte[4096];
                while (true) {
                    try {
                        try {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            messageDigest.update(bArr, 0, read);
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            try {
                                bufferedInputStream.close();
                                return null;
                            } catch (IOException e17) {
                                e17.printStackTrace();
                                return null;
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                        throw th5;
                    }
                }
                byte[] digest = messageDigest.digest();
                try {
                    bufferedInputStream.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
                return digest;
            } catch (FileNotFoundException e26) {
                e26.printStackTrace();
                return null;
            }
        } catch (NoSuchAlgorithmException e27) {
            e27.printStackTrace();
            return null;
        }
    }

    public static String encodeFileHexStr(String str) {
        return HexUtil.bytes2HexStr(encodeFile(str));
    }

    public static String encodeFolder(String str) {
        File[] listFiles;
        if (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null) {
            return "";
        }
        try {
            Arrays.sort(listFiles, fileComparator);
            for (File file : listFiles) {
                if (file.isFile()) {
                    md5List.add(encodeFileHexStr(file.getAbsolutePath()));
                } else {
                    encodeFolder(file.getAbsolutePath());
                }
            }
            Collections.sort(md5List, strComparator);
            StringBuilder sb5 = new StringBuilder();
            Iterator<String> it = md5List.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
            }
            md5List.clear();
            return encodeHexStr(sb5.toString());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String encodeHexStr(String str) {
        try {
            return HexUtil.bytes2HexStr(encode(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private long func_F(long j3, long j16, long j17) {
        return ((~j3) & j17) | (j16 & j3);
    }

    private long func_FF(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        int func_F = (int) (func_F(j16, j17, j18) + j19 + j27 + j3);
        return ((func_F >>> ((int) (32 - j26))) | (func_F << ((int) j26))) + j16;
    }

    private long func_G(long j3, long j16, long j17) {
        return (j3 & j17) | (j16 & (~j17));
    }

    private long func_GG(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        int func_G = (int) (func_G(j16, j17, j18) + j19 + j27 + j3);
        return ((func_G >>> ((int) (32 - j26))) | (func_G << ((int) j26))) + j16;
    }

    private long func_H(long j3, long j16, long j17) {
        return (j3 ^ j16) ^ j17;
    }

    private long func_HH(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        int func_H = (int) (func_H(j16, j17, j18) + j19 + j27 + j3);
        return ((func_H >>> ((int) (32 - j26))) | (func_H << ((int) j26))) + j16;
    }

    private long func_I(long j3, long j16, long j17) {
        return (j3 | (~j17)) ^ j16;
    }

    private long func_II(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        int func_I = (int) (func_I(j16, j17, j18) + j19 + j27 + j3);
        return ((func_I >>> ((int) (32 - j26))) | (func_I << ((int) j26))) + j16;
    }

    private void md5Final() {
        int i3;
        byte[] bArr = new byte[8];
        encode(bArr, this.count, 8);
        int i16 = ((int) (this.count[0] >>> 3)) & 63;
        if (i16 < 56) {
            i3 = 56 - i16;
        } else {
            i3 = 120 - i16;
        }
        md5Update(PADDING, i3);
        md5Update(bArr, 8);
        encode(this.digest, this.state, 16);
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
        decode(jArr2, bArr, 64);
        long func_FF = func_FF(j3, j16, j17, j18, jArr2[0], 7L, 3614090360L);
        long func_FF2 = func_FF(j18, func_FF, j16, j17, jArr2[1], 12L, 3905402710L);
        long func_FF3 = func_FF(j17, func_FF2, func_FF, j16, jArr2[2], 17L, 606105819L);
        long func_FF4 = func_FF(j16, func_FF3, func_FF2, func_FF, jArr2[3], 22L, 3250441966L);
        long func_FF5 = func_FF(func_FF, func_FF4, func_FF3, func_FF2, jArr2[4], 7L, 4118548399L);
        long func_FF6 = func_FF(func_FF2, func_FF5, func_FF4, func_FF3, jArr2[5], 12L, 1200080426L);
        long func_FF7 = func_FF(func_FF3, func_FF6, func_FF5, func_FF4, jArr2[6], 17L, 2821735955L);
        long func_FF8 = func_FF(func_FF4, func_FF7, func_FF6, func_FF5, jArr2[7], 22L, 4249261313L);
        long func_FF9 = func_FF(func_FF5, func_FF8, func_FF7, func_FF6, jArr2[8], 7L, 1770035416L);
        long func_FF10 = func_FF(func_FF6, func_FF9, func_FF8, func_FF7, jArr2[9], 12L, 2336552879L);
        long func_FF11 = func_FF(func_FF7, func_FF10, func_FF9, func_FF8, jArr2[10], 17L, 4294925233L);
        long func_FF12 = func_FF(func_FF8, func_FF11, func_FF10, func_FF9, jArr2[11], 22L, 2304563134L);
        long func_FF13 = func_FF(func_FF9, func_FF12, func_FF11, func_FF10, jArr2[12], 7L, 1804603682L);
        long func_FF14 = func_FF(func_FF10, func_FF13, func_FF12, func_FF11, jArr2[13], 12L, 4254626195L);
        long func_FF15 = func_FF(func_FF11, func_FF14, func_FF13, func_FF12, jArr2[14], 17L, 2792965006L);
        long func_FF16 = func_FF(func_FF12, func_FF15, func_FF14, func_FF13, jArr2[15], 22L, 1236535329L);
        long func_GG = func_GG(func_FF13, func_FF16, func_FF15, func_FF14, jArr2[1], 5L, 4129170786L);
        long func_GG2 = func_GG(func_FF14, func_GG, func_FF16, func_FF15, jArr2[6], 9L, 3225465664L);
        long func_GG3 = func_GG(func_FF15, func_GG2, func_GG, func_FF16, jArr2[11], 14L, 643717713L);
        long func_GG4 = func_GG(func_FF16, func_GG3, func_GG2, func_GG, jArr2[0], 20L, 3921069994L);
        long func_GG5 = func_GG(func_GG, func_GG4, func_GG3, func_GG2, jArr2[5], 5L, 3593408605L);
        long func_GG6 = func_GG(func_GG2, func_GG5, func_GG4, func_GG3, jArr2[10], 9L, 38016083L);
        long func_GG7 = func_GG(func_GG3, func_GG6, func_GG5, func_GG4, jArr2[15], 14L, 3634488961L);
        long func_GG8 = func_GG(func_GG4, func_GG7, func_GG6, func_GG5, jArr2[4], 20L, 3889429448L);
        long func_GG9 = func_GG(func_GG5, func_GG8, func_GG7, func_GG6, jArr2[9], 5L, 568446438L);
        long func_GG10 = func_GG(func_GG6, func_GG9, func_GG8, func_GG7, jArr2[14], 9L, 3275163606L);
        long func_GG11 = func_GG(func_GG7, func_GG10, func_GG9, func_GG8, jArr2[3], 14L, 4107603335L);
        long func_GG12 = func_GG(func_GG8, func_GG11, func_GG10, func_GG9, jArr2[8], 20L, 1163531501L);
        long func_GG13 = func_GG(func_GG9, func_GG12, func_GG11, func_GG10, jArr2[13], 5L, 2850285829L);
        long func_GG14 = func_GG(func_GG10, func_GG13, func_GG12, func_GG11, jArr2[2], 9L, 4243563512L);
        long func_GG15 = func_GG(func_GG11, func_GG14, func_GG13, func_GG12, jArr2[7], 14L, 1735328473L);
        long func_GG16 = func_GG(func_GG12, func_GG15, func_GG14, func_GG13, jArr2[12], 20L, 2368359562L);
        long func_HH = func_HH(func_GG13, func_GG16, func_GG15, func_GG14, jArr2[5], 4L, 4294588738L);
        long func_HH2 = func_HH(func_GG14, func_HH, func_GG16, func_GG15, jArr2[8], 11L, 2272392833L);
        long func_HH3 = func_HH(func_GG15, func_HH2, func_HH, func_GG16, jArr2[11], 16L, 1839030562L);
        long func_HH4 = func_HH(func_GG16, func_HH3, func_HH2, func_HH, jArr2[14], 23L, 4259657740L);
        long func_HH5 = func_HH(func_HH, func_HH4, func_HH3, func_HH2, jArr2[1], 4L, 2763975236L);
        long func_HH6 = func_HH(func_HH2, func_HH5, func_HH4, func_HH3, jArr2[4], 11L, 1272893353L);
        long func_HH7 = func_HH(func_HH3, func_HH6, func_HH5, func_HH4, jArr2[7], 16L, 4139469664L);
        long func_HH8 = func_HH(func_HH4, func_HH7, func_HH6, func_HH5, jArr2[10], 23L, 3200236656L);
        long func_HH9 = func_HH(func_HH5, func_HH8, func_HH7, func_HH6, jArr2[13], 4L, 681279174L);
        long func_HH10 = func_HH(func_HH6, func_HH9, func_HH8, func_HH7, jArr2[0], 11L, 3936430074L);
        long func_HH11 = func_HH(func_HH7, func_HH10, func_HH9, func_HH8, jArr2[3], 16L, 3572445317L);
        long func_HH12 = func_HH(func_HH8, func_HH11, func_HH10, func_HH9, jArr2[6], 23L, 76029189L);
        long func_HH13 = func_HH(func_HH9, func_HH12, func_HH11, func_HH10, jArr2[9], 4L, 3654602809L);
        long func_HH14 = func_HH(func_HH10, func_HH13, func_HH12, func_HH11, jArr2[12], 11L, 3873151461L);
        long func_HH15 = func_HH(func_HH11, func_HH14, func_HH13, func_HH12, jArr2[15], 16L, 530742520L);
        long func_HH16 = func_HH(func_HH12, func_HH15, func_HH14, func_HH13, jArr2[2], 23L, 3299628645L);
        long func_II = func_II(func_HH13, func_HH16, func_HH15, func_HH14, jArr2[0], 6L, 4096336452L);
        long func_II2 = func_II(func_HH14, func_II, func_HH16, func_HH15, jArr2[7], 10L, 1126891415L);
        long func_II3 = func_II(func_HH15, func_II2, func_II, func_HH16, jArr2[14], 15L, 2878612391L);
        long func_II4 = func_II(func_HH16, func_II3, func_II2, func_II, jArr2[5], 21L, 4237533241L);
        long func_II5 = func_II(func_II, func_II4, func_II3, func_II2, jArr2[12], 6L, 1700485571L);
        long func_II6 = func_II(func_II2, func_II5, func_II4, func_II3, jArr2[3], 10L, 2399980690L);
        long func_II7 = func_II(func_II3, func_II6, func_II5, func_II4, jArr2[10], 15L, 4293915773L);
        long func_II8 = func_II(func_II4, func_II7, func_II6, func_II5, jArr2[1], 21L, 2240044497L);
        long func_II9 = func_II(func_II5, func_II8, func_II7, func_II6, jArr2[8], 6L, 1873313359L);
        long func_II10 = func_II(func_II6, func_II9, func_II8, func_II7, jArr2[15], 10L, 4264355552L);
        long func_II11 = func_II(func_II7, func_II10, func_II9, func_II8, jArr2[6], 15L, 2734768916L);
        long func_II12 = func_II(func_II8, func_II11, func_II10, func_II9, jArr2[13], 21L, 1309151649L);
        long func_II13 = func_II(func_II9, func_II12, func_II11, func_II10, jArr2[4], 6L, 4149444226L);
        long func_II14 = func_II(func_II10, func_II13, func_II12, func_II11, jArr2[11], 10L, 3174756917L);
        long func_II15 = func_II(func_II11, func_II14, func_II13, func_II12, jArr2[2], 15L, 718787259L);
        long func_II16 = func_II(func_II12, func_II15, func_II14, func_II13, jArr2[9], 21L, 3951481745L);
        long[] jArr3 = this.state;
        jArr3[0] = jArr3[0] + func_II13;
        jArr3[1] = jArr3[1] + func_II16;
        jArr3[2] = jArr3[2] + func_II15;
        jArr3[3] = jArr3[3] + func_II14;
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

    public static String toMD5(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] md5 = new MD5Utils().getMD5(bytes);
        StringBuilder sb5 = new StringBuilder(32);
        for (int i3 = 0; i3 < 16; i3++) {
            char[] cArr = Digit;
            sb5.append(cArr[(md5[i3] >>> 4) & 15]);
            sb5.append(cArr[md5[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }

    public byte[] getMD5(byte[] bArr) {
        md5Init();
        md5Update(new ByteArrayInputStream(bArr), bArr.length);
        md5Final();
        return this.digest;
    }

    public static String encodeHexStr(byte[] bArr) {
        return HexUtil.bytes2HexStr(encode(bArr));
    }

    private void encode(byte[] bArr, long[] jArr, int i3) {
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
}
