package com.tencent.mapsdk.internal;

import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class mt implements mu {

    /* renamed from: g, reason: collision with root package name */
    private static final String f149337g = "UTF-16LE";

    /* renamed from: h, reason: collision with root package name */
    private ByteArrayOutputStream f149338h = new ByteArrayOutputStream();

    private void a(byte b16) {
        this.f149338h.write(b16);
    }

    private static byte[] b(long j3) {
        return new byte[]{(byte) j3, (byte) (j3 >> 8), (byte) (j3 >> 16), (byte) (j3 >> 24), (byte) (j3 >> 32), (byte) (j3 >> 40), (byte) (j3 >> 48), (byte) (j3 >> 56)};
    }

    private void c(byte[] bArr) {
        this.f149338h.write(bArr, 0, bArr.length);
    }

    private static byte[] d(int i3) {
        return new byte[]{(byte) i3, (byte) (i3 >> 8), (byte) (i3 >> 16), (byte) (i3 >> 24)};
    }

    private static long e(byte[] bArr) {
        return (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 24) | ((bArr[4] & 255) << 32) | ((bArr[5] & 255) << 40) | ((bArr[6] & 255) << 48) | ((bArr[7] & 255) << 56);
    }

    private static float f(byte[] bArr) {
        return Float.intBitsToFloat(a(bArr));
    }

    private static double g(byte[] bArr) {
        return Double.longBitsToDouble((bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 24) | ((bArr[4] & 255) << 32) | ((bArr[5] & 255) << 40) | ((bArr[6] & 255) << 48) | ((bArr[7] & 255) << 56));
    }

    private void a(boolean z16) {
        a(z16 ? (byte) 1 : (byte) 0);
    }

    private static byte[] b(String str) {
        if (str != null) {
            try {
                return str.getBytes("UTF-16LE");
            } catch (Exception unused) {
            }
        }
        return new byte[0];
    }

    private void c(int i3) {
        a(i3, 4);
    }

    private static boolean d(byte[] bArr) {
        return bArr[0] > 0;
    }

    private void a(int i3) {
        a(i3, 2);
    }

    public static String b(byte[] bArr) {
        try {
            return new String(bArr, "UTF-16LE").trim();
        } catch (Exception unused) {
            return null;
        }
    }

    private void a(char c16) {
        for (int i3 = 0; i3 < 2; i3++) {
            a((byte) ((c16 >> (i3 * 8)) & 255));
        }
    }

    private static byte[] b(int i3) {
        byte[] bArr = new byte[4];
        long j3 = i3;
        for (int i16 = 3; i16 >= 0; i16--) {
            bArr[(4 - i16) - 1] = (byte) ((j3 >> (i16 * 8)) & 255);
        }
        return bArr;
    }

    private static void a(long j3, byte[] bArr) {
        for (int i3 = 3; i3 >= 0; i3--) {
            bArr[(4 - i3) - 1] = (byte) ((j3 >> (i3 * 8)) & 255);
        }
    }

    private void a(long j3) {
        a(j3, 8);
    }

    private void a(String str) {
        if (str == null) {
            return;
        }
        byte[] bytes = str.getBytes();
        a(bytes.length, 2);
        this.f149338h.write(bytes, 0, bytes.length);
    }

    private byte[] a() {
        byte[] bArr;
        IOException e16;
        try {
            this.f149338h.close();
            bArr = this.f149338h.toByteArray();
            try {
                this.f149338h = null;
            } catch (IOException e17) {
                e16 = e17;
                e16.printStackTrace();
                return bArr;
            }
        } catch (IOException e18) {
            bArr = null;
            e16 = e18;
        }
        return bArr;
    }

    private void a(long j3, int i3) {
        for (int i16 = i3 - 1; i16 >= 0; i16--) {
            a((byte) ((j3 >> (i16 * 8)) & 255));
        }
    }

    public static int a(byte[] bArr) {
        return ((bArr[3] << 24) & (-16777216)) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT);
    }

    private static byte[] a(float f16) {
        int floatToIntBits = Float.floatToIntBits(f16);
        return new byte[]{(byte) floatToIntBits, (byte) (floatToIntBits >> 8), (byte) (floatToIntBits >> 16), (byte) (floatToIntBits >> 24)};
    }

    private static byte[] a(double d16) {
        return new byte[]{(byte) Double.doubleToLongBits(d16), (byte) (r4 >> 8), (byte) (r4 >> 16), (byte) (r4 >> 24), (byte) (r4 >> 32), (byte) (r4 >> 40), (byte) (r4 >> 48), (byte) (r4 >> 56)};
    }

    public static String a(byte[] bArr, String str) {
        try {
            return new String(bArr, str).trim();
        } catch (Exception unused) {
            return null;
        }
    }
}
