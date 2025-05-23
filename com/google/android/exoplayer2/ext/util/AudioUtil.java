package com.google.android.exoplayer2.ext.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AudioUtil {
    public static final double PCM_EACH_MAX_16BIT = 1.073676289E9d;

    public static String byteArrayToHex(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (byte b16 : bArr) {
            sb5.append(String.format("%02x ", Byte.valueOf(b16)));
        }
        return sb5.toString();
    }

    public static short byteToShort(byte b16, byte b17) {
        return (short) ((b16 & 255) | ((b17 & 255) << 8));
    }

    private static short byteToShort2(byte b16, byte b17) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(b16);
        allocate.put(b17);
        return allocate.getShort(0);
    }

    public static double mean(double[] dArr, int i3) {
        int min = Math.min(i3, dArr.length);
        double d16 = 0.0d;
        for (int i16 = 0; i16 < min; i16++) {
            d16 += dArr[i16];
        }
        return d16 / min;
    }

    public static double min(double[] dArr, int i3) {
        int min = Math.min(i3, dArr.length);
        double d16 = 0.0d;
        for (int i16 = 0; i16 < min; i16++) {
            d16 = Math.min(d16, dArr[i16]);
        }
        return d16;
    }
}
