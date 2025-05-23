package com.google.android.exoplayer2.extractor.mp3;

import android.util.Log;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class VbriSeeker implements Mp3Extractor.Seeker {
    private static final String TAG = "VbriSeeker";
    private final long durationUs;
    private final long[] positions;
    private final long[] timesUs;

    VbriSeeker(long[] jArr, long[] jArr2, long j3) {
        this.timesUs = jArr;
        this.positions = jArr2;
        this.durationUs = j3;
    }

    public static VbriSeeker create(long j3, long j16, MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray) {
        int i3;
        int readUnsignedByte;
        parsableByteArray.skipBytes(10);
        int readInt = parsableByteArray.readInt();
        if (readInt <= 0) {
            return null;
        }
        int i16 = mpegAudioHeader.sampleRate;
        long j17 = readInt;
        if (i16 >= 32000) {
            i3 = gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION;
        } else {
            i3 = PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
        }
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j17, i3 * 1000000, i16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(2);
        long j18 = j16 + mpegAudioHeader.frameSize;
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        int i17 = 0;
        long j19 = j16;
        while (i17 < readUnsignedShort) {
            long j26 = j18;
            long j27 = scaleLargeTimestamp;
            jArr[i17] = (i17 * scaleLargeTimestamp) / readUnsignedShort;
            jArr2[i17] = Math.max(j19, j26);
            if (readUnsignedShort3 != 1) {
                if (readUnsignedShort3 != 2) {
                    if (readUnsignedShort3 != 3) {
                        if (readUnsignedShort3 != 4) {
                            return null;
                        }
                        readUnsignedByte = parsableByteArray.readUnsignedIntToInt();
                    } else {
                        readUnsignedByte = parsableByteArray.readUnsignedInt24();
                    }
                } else {
                    readUnsignedByte = parsableByteArray.readUnsignedShort();
                }
            } else {
                readUnsignedByte = parsableByteArray.readUnsignedByte();
            }
            j19 += readUnsignedByte * readUnsignedShort2;
            i17++;
            j18 = j26;
            scaleLargeTimestamp = j27;
        }
        long j28 = scaleLargeTimestamp;
        if (j3 != -1 && j3 != j19) {
            Log.w(TAG, "VBRI data size mismatch: " + j3 + ", " + j19);
        }
        return new VbriSeeker(jArr, jArr2, j28);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j3) {
        int binarySearchFloor = Util.binarySearchFloor(this.timesUs, j3, true, true);
        SeekPoint seekPoint = new SeekPoint(this.timesUs[binarySearchFloor], this.positions[binarySearchFloor]);
        if (seekPoint.timeUs < j3 && binarySearchFloor != this.timesUs.length - 1) {
            int i3 = binarySearchFloor + 1;
            return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.timesUs[i3], this.positions[i3]));
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j3) {
        return this.timesUs[Util.binarySearchFloor(this.positions, j3, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
