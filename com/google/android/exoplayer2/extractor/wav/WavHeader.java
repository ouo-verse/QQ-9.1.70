package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
final class WavHeader implements SeekMap {
    private final int averageBytesPerSecond;
    private final int bitsPerSample;
    private final int blockAlignment;
    private long dataSize;
    private long dataStartPosition;
    private final int encoding;
    private final int numChannels;
    private final int sampleRateHz;

    public WavHeader(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.numChannels = i3;
        this.sampleRateHz = i16;
        this.averageBytesPerSecond = i17;
        this.blockAlignment = i18;
        this.bitsPerSample = i19;
        this.encoding = i26;
    }

    public int getBitrate() {
        return this.sampleRateHz * this.bitsPerSample * this.numChannels;
    }

    public int getBytesPerFrame() {
        return this.blockAlignment;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return ((this.dataSize / this.blockAlignment) * 1000000) / this.sampleRateHz;
    }

    public int getEncoding() {
        return this.encoding;
    }

    public int getNumChannels() {
        return this.numChannels;
    }

    public int getSampleRateHz() {
        return this.sampleRateHz;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j3) {
        int i3 = this.blockAlignment;
        long constrainValue = Util.constrainValue((((this.averageBytesPerSecond * j3) / 1000000) / i3) * i3, 0L, this.dataSize - i3);
        long j16 = this.dataStartPosition + constrainValue;
        long timeUs = getTimeUs(j16);
        SeekPoint seekPoint = new SeekPoint(timeUs, j16);
        if (timeUs < j3) {
            long j17 = this.dataSize;
            int i16 = this.blockAlignment;
            if (constrainValue != j17 - i16) {
                long j18 = j16 + i16;
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUs(j18), j18));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public long getTimeUs(long j3) {
        return (Math.max(0L, j3 - this.dataStartPosition) * 1000000) / this.averageBytesPerSecond;
    }

    public boolean hasDataBounds() {
        if (this.dataStartPosition != 0 && this.dataSize != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    public void setDataBounds(long j3, long j16) {
        this.dataStartPosition = j3;
        this.dataSize = j16;
    }
}
