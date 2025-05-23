package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.util.Util;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class ConstantBitrateSeeker implements Mp3Extractor.Seeker {
    private static final int BITS_PER_BYTE = 8;
    private final int bitrate;
    private final long dataSize;
    private final long durationUs;
    private final long firstFramePosition;
    private final int frameSize;

    public ConstantBitrateSeeker(long j3, long j16, MpegAudioHeader mpegAudioHeader) {
        this.firstFramePosition = j16;
        this.frameSize = mpegAudioHeader.frameSize;
        this.bitrate = mpegAudioHeader.bitrate;
        if (j3 == -1) {
            this.dataSize = -1L;
            this.durationUs = -9223372036854775807L;
        } else {
            this.dataSize = j3 - j16;
            this.durationUs = getTimeUs(j3);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j3) {
        long j16 = this.dataSize;
        if (j16 == -1) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, this.firstFramePosition));
        }
        int i3 = this.frameSize;
        long constrainValue = Util.constrainValue((((this.bitrate * j3) / 8000000) / i3) * i3, 0L, j16 - i3);
        long j17 = this.firstFramePosition + constrainValue;
        long timeUs = getTimeUs(j17);
        SeekPoint seekPoint = new SeekPoint(timeUs, j17);
        if (timeUs < j3) {
            long j18 = this.dataSize;
            int i16 = this.frameSize;
            if (constrainValue != j18 - i16) {
                long j19 = j17 + i16;
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUs(j19), j19));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j3) {
        return ((Math.max(0L, j3 - this.firstFramePosition) * 1000000) * 8) / this.bitrate;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        if (this.dataSize != -1) {
            return true;
        }
        return false;
    }
}
