package com.google.android.exoplayer2.extractor.mp3;

import android.util.Log;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class XingSeeker implements Mp3Extractor.Seeker {
    private static final String TAG = "XingSeeker";
    private final long dataSize;
    private final long dataStartPosition;
    private final long durationUs;
    private final long[] tableOfContents;
    private final int xingFrameSize;

    XingSeeker(long j3, int i3, long j16) {
        this(j3, i3, j16, -1L, null);
    }

    public static XingSeeker create(long j3, long j16, MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt;
        int i3 = mpegAudioHeader.samplesPerFrame;
        int i16 = mpegAudioHeader.sampleRate;
        int readInt = parsableByteArray.readInt();
        if ((readInt & 1) == 1 && (readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt()) != 0) {
            long scaleLargeTimestamp = Util.scaleLargeTimestamp(readUnsignedIntToInt, i3 * 1000000, i16);
            if ((readInt & 6) != 6) {
                return new XingSeeker(j16, mpegAudioHeader.frameSize, scaleLargeTimestamp);
            }
            long readUnsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
            long[] jArr = new long[100];
            for (int i17 = 0; i17 < 100; i17++) {
                jArr[i17] = parsableByteArray.readUnsignedByte();
            }
            if (j3 != -1) {
                long j17 = j16 + readUnsignedIntToInt2;
                if (j3 != j17) {
                    Log.w(TAG, "XING data size mismatch: " + j3 + ", " + j17);
                }
            }
            return new XingSeeker(j16, mpegAudioHeader.frameSize, scaleLargeTimestamp, readUnsignedIntToInt2, jArr);
        }
        return null;
    }

    private long getTimeUsForTableIndex(int i3) {
        return (this.durationUs * i3) / 100;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j3) {
        double d16;
        if (!isSeekable()) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, this.dataStartPosition + this.xingFrameSize));
        }
        long constrainValue = Util.constrainValue(j3, 0L, this.durationUs);
        double d17 = (constrainValue * 100.0d) / this.durationUs;
        double d18 = 0.0d;
        if (d17 > 0.0d) {
            if (d17 >= 100.0d) {
                d18 = 256.0d;
            } else {
                int i3 = (int) d17;
                long[] jArr = this.tableOfContents;
                double d19 = jArr[i3];
                if (i3 == 99) {
                    d16 = 256.0d;
                } else {
                    d16 = jArr[i3 + 1];
                }
                d18 = d19 + ((d17 - i3) * (d16 - d19));
            }
        }
        return new SeekMap.SeekPoints(new SeekPoint(constrainValue, this.dataStartPosition + Util.constrainValue(Math.round((d18 / 256.0d) * this.dataSize), this.xingFrameSize, this.dataSize - 1)));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j3) {
        long j16;
        double d16;
        long j17 = j3 - this.dataStartPosition;
        if (isSeekable() && j17 > this.xingFrameSize) {
            double d17 = (j17 * 256.0d) / this.dataSize;
            int binarySearchFloor = Util.binarySearchFloor(this.tableOfContents, (long) d17, true, true);
            long timeUsForTableIndex = getTimeUsForTableIndex(binarySearchFloor);
            long j18 = this.tableOfContents[binarySearchFloor];
            int i3 = binarySearchFloor + 1;
            long timeUsForTableIndex2 = getTimeUsForTableIndex(i3);
            if (binarySearchFloor == 99) {
                j16 = 256;
            } else {
                j16 = this.tableOfContents[i3];
            }
            if (j18 == j16) {
                d16 = 0.0d;
            } else {
                d16 = (d17 - j18) / (j16 - j18);
            }
            return timeUsForTableIndex + Math.round(d16 * (timeUsForTableIndex2 - timeUsForTableIndex));
        }
        return 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        if (this.tableOfContents != null) {
            return true;
        }
        return false;
    }

    XingSeeker(long j3, int i3, long j16, long j17, long[] jArr) {
        this.dataStartPosition = j3;
        this.xingFrameSize = i3;
        this.durationUs = j16;
        this.dataSize = j17;
        this.tableOfContents = jArr;
    }
}
