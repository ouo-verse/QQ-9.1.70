package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WaveWriter {
    private static final int OUTPUT_STREAM_BUFFER = 16384;
    private static final String TAG = "WaveWriter";
    private int mBytesWritten = 0;
    private int mChannels;
    private File mOutFile;
    private BufferedOutputStream mOutStream;
    private int mSampleBits;
    private int mSampleRate;
    private ByteArrayOutputStream mTmpStream;

    public WaveWriter(String str, String str2, int i3, int i16, int i17) {
        this.mOutFile = new File(str + File.separator + str2);
        this.mSampleRate = i3;
        this.mChannels = i16;
        this.mSampleBits = i17;
    }

    private short[] interpolate(int i3, int i16, short[] sArr) {
        if (i3 == i16) {
            return sArr;
        }
        int round = Math.round((sArr.length / i3) * i16);
        float length = round / sArr.length;
        short[] sArr2 = new short[round];
        for (int i17 = 0; i17 < round; i17++) {
            int i18 = (int) (i17 / length);
            int i19 = i18 + 1;
            if (i19 >= sArr.length) {
                i19 = sArr.length - 1;
            }
            short s16 = sArr[i19];
            short s17 = sArr[i18];
            sArr2[i17] = (short) (((s16 - s17) * (r2 - i18)) + s17);
        }
        return sArr2;
    }

    private byte[] reSample(byte[] bArr, int i3, int i16, int i17) {
        byte[] bArr2;
        int i18 = i3 / 8;
        if (i18 <= 0) {
            return null;
        }
        int length = bArr.length / i18;
        short[] sArr = new short[length];
        int i19 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < length; i27++) {
            int i28 = 0;
            short s16 = 0;
            while (i28 < i18) {
                s16 = (short) (((short) ((bArr[i26] & 255) << (i28 * 8))) | s16);
                i28++;
                i26++;
            }
            sArr[i27] = s16;
        }
        short[] interpolate = interpolate(i16, i17, sArr);
        int length2 = interpolate.length;
        if (i18 == 1) {
            bArr2 = new byte[length2];
            while (i19 < length2) {
                bArr2[i19] = (byte) interpolate[i19];
                i19++;
            }
        } else {
            bArr2 = new byte[length2 * 2];
            while (i19 < interpolate.length) {
                int i29 = i19 * 2;
                short s17 = interpolate[i19];
                bArr2[i29] = (byte) (s17 & 255);
                bArr2[i29 + 1] = (byte) ((s17 >> 8) & 255);
                i19++;
            }
        }
        this.mSampleRate = i17;
        return bArr2;
    }

    private static void writeUnsignedShortLE(ByteArrayOutputStream byteArrayOutputStream, short s16) throws IOException {
        byteArrayOutputStream.write(s16);
        byteArrayOutputStream.write(s16 >> 8);
    }

    private void writeWaveHeader() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.mOutFile, "rw");
        randomAccessFile.seek(0L);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int i3 = (this.mSampleBits + 7) / 8;
        try {
            dataOutputStream.writeBytes("RIFF");
            dataOutputStream.writeInt(Integer.reverseBytes(this.mBytesWritten + 36));
            dataOutputStream.writeBytes("WAVE");
            dataOutputStream.writeBytes("fmt ");
            dataOutputStream.writeInt(Integer.reverseBytes(16));
            dataOutputStream.writeShort(Short.reverseBytes((short) 1));
            dataOutputStream.writeShort(Short.reverseBytes((short) this.mChannels));
            dataOutputStream.writeInt(Integer.reverseBytes(this.mSampleRate));
            dataOutputStream.writeInt(Integer.reverseBytes(this.mSampleRate * this.mChannels * i3));
            dataOutputStream.writeShort(Short.reverseBytes((short) (this.mChannels * i3)));
            dataOutputStream.writeShort(Short.reverseBytes((short) this.mSampleBits));
            dataOutputStream.writeBytes("data");
            dataOutputStream.writeInt(Integer.reverseBytes(this.mBytesWritten));
            byteArrayOutputStream.flush();
            randomAccessFile.write(byteArrayOutputStream.toByteArray());
        } finally {
            byteArrayOutputStream.close();
            dataOutputStream.close();
            randomAccessFile.close();
        }
    }

    public byte[] changeStereoToMono(byte[] bArr) {
        int i3 = this.mChannels;
        if (i3 == 2) {
            int i16 = this.mSampleBits / 8;
            long length = (bArr.length / i3) / i16;
            byte[] bArr2 = new byte[(int) (i16 * length)];
            for (int i17 = 0; i17 < length; i17++) {
                for (int i18 = 0; i18 < i16; i18++) {
                    int i19 = this.mChannels * i17;
                    bArr2[(i17 * i16) + i18] = (byte) ((bArr[(i19 * i16) + i18] + bArr[((i19 + 1) * i16) + i18]) / 2);
                }
            }
            this.mChannels = 1;
            return bArr2;
        }
        return bArr;
    }

    public void closeWaveFile() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.mOutStream;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
            this.mOutStream.close();
        }
        ByteArrayOutputStream byteArrayOutputStream = this.mTmpStream;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.flush();
            this.mTmpStream.close();
        }
        writeWaveHeader();
    }

    public boolean createWaveFile() throws IOException {
        if (this.mOutFile.exists()) {
            this.mOutFile.delete();
        }
        this.mOutFile.getParentFile().mkdirs();
        if (this.mOutFile.createNewFile()) {
            this.mOutStream = new BufferedOutputStream(new FileOutputStream(this.mOutFile), 16384);
            this.mTmpStream = new ByteArrayOutputStream();
            this.mOutStream.write(new byte[44]);
            return true;
        }
        return false;
    }

    public int getChannels() {
        return this.mChannels;
    }

    public boolean reSampler() {
        try {
            byte[] reSample = reSample(this.mTmpStream.toByteArray(), this.mSampleBits, this.mSampleRate, 8000);
            if (reSample == null) {
                return false;
            }
            Logger.d(TAG, "mTmpStream length = " + this.mTmpStream.toByteArray().length);
            byte[] changeStereoToMono = changeStereoToMono(reSample);
            Logger.d(TAG, "monoData length = " + changeStereoToMono.length);
            byte[] reSample2 = reSample(changeStereoToMono, this.mSampleBits, 8000, 4000);
            if (reSample2 == null) {
                return false;
            }
            Logger.d(TAG, "resultData length = " + reSample2.length);
            this.mBytesWritten = reSample2.length;
            this.mOutStream.write(reSample2);
            return true;
        } catch (Throwable th5) {
            Logger.e(TAG, th5);
            return false;
        }
    }

    public boolean reSamplerTo8K() {
        try {
            byte[] reSample = reSample(this.mTmpStream.toByteArray(), this.mSampleBits, this.mSampleRate, 8000);
            if (reSample == null) {
                return false;
            }
            Logger.d(TAG, "mTmpStream length = " + this.mTmpStream.toByteArray().length);
            byte[] changeStereoToMono = changeStereoToMono(reSample);
            Logger.d(TAG, "resultData length = " + changeStereoToMono.length);
            this.mBytesWritten = changeStereoToMono.length;
            this.mOutStream.write(changeStereoToMono);
            return true;
        } catch (Throwable th5) {
            Logger.e(TAG, th5);
            return false;
        }
    }

    public void setSampleByte(int i3) {
        this.mSampleBits = i3;
    }

    public void write(short[] sArr, int i3, int i16) throws IOException {
        if (i3 > i16) {
            throw new IndexOutOfBoundsException(String.format("offset %d is greater than length %d", Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        while (i3 < i16) {
            writeUnsignedShortLE(this.mTmpStream, sArr[i3]);
            this.mBytesWritten += 2;
            i3++;
        }
    }

    public void writeDone() {
        try {
            this.mOutStream.write(this.mTmpStream.toByteArray());
        } catch (IOException e16) {
            Logger.e(TAG, e16);
        }
    }

    public void write(short[] sArr, short[] sArr2, int i3, int i16) throws IOException {
        if (this.mChannels != 2) {
            return;
        }
        if (i3 > i16) {
            throw new IndexOutOfBoundsException(String.format("offset %d is greater than length %d", Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        while (i3 < i16) {
            writeUnsignedShortLE(this.mTmpStream, sArr[i3]);
            writeUnsignedShortLE(this.mTmpStream, sArr2[i3]);
            this.mBytesWritten += 4;
            i3++;
        }
    }

    public WaveWriter(File file, int i3, int i16, int i17) {
        this.mOutFile = file;
        this.mSampleRate = i3;
        this.mChannels = i16;
        this.mSampleBits = i17;
    }
}
