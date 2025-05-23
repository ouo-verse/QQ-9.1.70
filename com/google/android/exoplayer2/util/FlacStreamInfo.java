package com.google.android.exoplayer2.util;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class FlacStreamInfo {
    public final int bitsPerSample;
    public final int channels;
    public final int maxBlockSize;
    public final int maxFrameSize;
    public final int minBlockSize;
    public final int minFrameSize;
    public final int sampleRate;
    public final long totalSamples;

    public FlacStreamInfo(byte[] bArr, int i3) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.setPosition(i3 * 8);
        this.minBlockSize = parsableBitArray.readBits(16);
        this.maxBlockSize = parsableBitArray.readBits(16);
        this.minFrameSize = parsableBitArray.readBits(24);
        this.maxFrameSize = parsableBitArray.readBits(24);
        this.sampleRate = parsableBitArray.readBits(20);
        this.channels = parsableBitArray.readBits(3) + 1;
        this.bitsPerSample = parsableBitArray.readBits(5) + 1;
        this.totalSamples = ((parsableBitArray.readBits(4) & 15) << 32) | (parsableBitArray.readBits(32) & 4294967295L);
    }

    public int bitRate() {
        return this.bitsPerSample * this.sampleRate;
    }

    public long durationUs() {
        return (this.totalSamples * 1000000) / this.sampleRate;
    }

    public int maxDecodedFrameSize() {
        return this.maxBlockSize * this.channels * (this.bitsPerSample / 8);
    }

    public FlacStreamInfo(int i3, int i16, int i17, int i18, int i19, int i26, int i27, long j3) {
        this.minBlockSize = i3;
        this.maxBlockSize = i16;
        this.minFrameSize = i17;
        this.maxFrameSize = i18;
        this.sampleRate = i19;
        this.channels = i26;
        this.bitsPerSample = i27;
        this.totalSamples = j3;
    }
}
