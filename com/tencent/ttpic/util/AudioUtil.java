package com.tencent.ttpic.util;

import com.tencent.ttpic.logic.watermark.FFTData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AudioUtil {
    private static final String TAG = "AudioUtil";

    public static int byteArrayToInt(byte[] bArr) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder()).getInt();
    }

    public static short byteArrayToShort(byte[] bArr) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder()).getShort();
    }

    public static void fft(Complex[] complexArr, int i3) {
        Complex complex = new Complex();
        new Complex();
        int i16 = i3 / 2;
        int i17 = i3;
        int i18 = 1;
        while (true) {
            i17 /= 2;
            if (i17 <= 1) {
                break;
            } else {
                i18++;
            }
        }
        int i19 = i3 - 2;
        int i26 = i16;
        for (int i27 = 1; i27 <= i19; i27++) {
            if (i27 < i26) {
                Complex complex2 = complexArr[i26];
                complexArr[i26] = complexArr[i27];
                complexArr[i27] = complex2;
            }
            int i28 = i16;
            while (i26 >= i28) {
                i26 -= i28;
                i28 /= 2;
            }
            i26 += i28;
        }
        for (int i29 = 1; i29 <= i18; i29++) {
            int pow = (int) Math.pow(2.0d, i29);
            int i36 = pow / 2;
            for (int i37 = 0; i37 < i36; i37++) {
                double d16 = (6.283185307179586d / pow) * i37;
                complex.real = Math.cos(d16);
                complex.image = Math.sin(d16) * (-1.0d);
                for (int i38 = i37; i38 < i3; i38 += pow) {
                    int i39 = i38 + i36;
                    Complex cc5 = complexArr[i39].cc(complex);
                    complexArr[i39] = complexArr[i38].cut(cc5);
                    complexArr[i38] = complexArr[i38].sum(cc5);
                }
            }
        }
    }

    public static int getPcmDB16Bit(byte[] bArr, int i3) {
        short[] pcm16BitToShort = pcm16BitToShort(bArr, i3);
        return getPcmDBFromShortBuffer(pcm16BitToShort, pcm16BitToShort.length);
    }

    public static int getPcmDB8Bit(byte[] bArr, int i3) {
        short[] pcm8BitTo16Bit = pcm8BitTo16Bit(bArr, i3);
        return getPcmDBFromShortBuffer(pcm8BitTo16Bit, pcm8BitTo16Bit.length);
    }

    public static int getPcmDBFromShortBuffer(short[] sArr, int i3) {
        double d16 = 0.0d;
        for (int i16 = 0; i16 < i3; i16++) {
            d16 += Math.abs((int) sArr[i16]);
        }
        double d17 = d16 / i3;
        if (d17 <= 0.0d) {
            return 0;
        }
        return (int) (Math.log10(d17) * 20.0d);
    }

    public static void getPcmFFTFromShortBuffer(short[] sArr, int i3, FFTData fFTData) {
        if (i3 <= FFTData.BUFFER_SIZE && i3 != 0) {
            int up2int = up2int(i3);
            Complex[] complexArr = new Complex[up2int];
            for (int i16 = 0; i16 < up2int; i16++) {
                complexArr[i16] = new Complex(Short.valueOf(sArr[i16]).doubleValue());
            }
            fft(complexArr, up2int);
            fFTData.mFFTSum = 0;
            fFTData.mFFTSize = up2int / 2;
            int min = Math.min(up2int, fFTData.mFFTBuffer.length);
            for (int i17 = 0; i17 < min; i17++) {
                fFTData.mFFTBuffer[i17] = complexArr[i17].getIntValue();
                fFTData.mFFTSum += fFTData.mFFTBuffer[i17];
            }
            fFTData.mFFTSum /= 2;
            while (true) {
                int[] iArr = fFTData.mFFTBuffer;
                if (min < iArr.length) {
                    iArr[min] = 0;
                    min++;
                } else {
                    return;
                }
            }
        }
    }

    public static short[] pcm16BitToShort(byte[] bArr, int i3) {
        int i16 = i3 / 2;
        short[] sArr = new short[i16];
        byte[] bArr2 = new byte[2];
        for (int i17 = 0; i17 < i16; i17++) {
            int i18 = i17 * 2;
            bArr2[0] = bArr[i18];
            bArr2[1] = bArr[i18 + 1];
            sArr[i17] = byteArrayToShort(bArr2);
        }
        return sArr;
    }

    private static short[] pcm8BitTo16Bit(byte[] bArr, int i3) {
        short[] sArr = new short[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            sArr[i16] = (short) ((bArr[i16] - 128) << 8);
        }
        return sArr;
    }

    private static int up2int(int i3) {
        int i16 = 1;
        while (i16 <= i3) {
            i16 <<= 1;
        }
        return i16 >> 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Complex {
        public double image;
        public double real;

        public Complex() {
            this.real = 0.0d;
            this.image = 0.0d;
        }

        public Complex cc(Complex complex) {
            Complex complex2 = new Complex();
            double d16 = this.real * complex.real;
            double d17 = this.image;
            double d18 = complex.image;
            complex2.real = d16 - (d17 * d18);
            complex2.image = (this.real * d18) + (d17 * complex.real);
            return complex2;
        }

        public Complex cut(Complex complex) {
            Complex complex2 = new Complex();
            complex2.real = this.real - complex.real;
            complex2.image = this.image - complex.image;
            return complex2;
        }

        public int getIntValue() {
            double d16 = this.real;
            double d17 = this.image;
            return (int) Math.round(Math.sqrt((d16 * d16) - (d17 * d17)));
        }

        public Complex sum(Complex complex) {
            Complex complex2 = new Complex();
            complex2.real = this.real + complex.real;
            complex2.image = this.image + complex.image;
            return complex2;
        }

        public Complex(double d16, double d17) {
            this.real = d16;
            this.image = d17;
        }

        public Complex(int i3, int i16) {
            this.real = Integer.valueOf(i3).floatValue();
            this.image = Integer.valueOf(i16).floatValue();
        }

        public Complex(double d16) {
            this.real = d16;
            this.image = 0.0d;
        }
    }
}
