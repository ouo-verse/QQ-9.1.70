package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
final class TrackFragment {
    public long atomPosition;
    public long auxiliaryDataPosition;
    public long dataPosition;
    public boolean definesEncryptionData;
    public DefaultSampleValues header;
    public long nextFragmentDecodeTime;
    public int[] sampleCompositionTimeOffsetTable;
    public int sampleCount;
    public long[] sampleDecodingTimeTable;
    public ParsableByteArray sampleEncryptionData;
    public int sampleEncryptionDataLength;
    public boolean sampleEncryptionDataNeedsFill;
    public boolean[] sampleHasSubsampleEncryptionTable;
    public boolean[] sampleIsSyncFrameTable;
    public int[] sampleSizeTable;
    public TrackEncryptionBox trackEncryptionBox;
    public int trunCount;
    public long[] trunDataPosition;
    public int[] trunLength;

    public void fillEncryptionData(ExtractorInput extractorInput) throws IOException, InterruptedException {
        extractorInput.readFully(this.sampleEncryptionData.data, 0, this.sampleEncryptionDataLength);
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }

    public long getSamplePresentationTime(int i3) {
        return this.sampleDecodingTimeTable[i3] + this.sampleCompositionTimeOffsetTable[i3];
    }

    public void initEncryptionData(int i3) {
        ParsableByteArray parsableByteArray = this.sampleEncryptionData;
        if (parsableByteArray == null || parsableByteArray.limit() < i3) {
            this.sampleEncryptionData = new ParsableByteArray(i3);
        }
        this.sampleEncryptionDataLength = i3;
        this.definesEncryptionData = true;
        this.sampleEncryptionDataNeedsFill = true;
    }

    public void initTables(int i3, int i16) {
        this.trunCount = i3;
        this.sampleCount = i16;
        int[] iArr = this.trunLength;
        if (iArr == null || iArr.length < i3) {
            this.trunDataPosition = new long[i3];
            this.trunLength = new int[i3];
        }
        int[] iArr2 = this.sampleSizeTable;
        if (iArr2 == null || iArr2.length < i16) {
            int i17 = (i16 * 125) / 100;
            this.sampleSizeTable = new int[i17];
            this.sampleCompositionTimeOffsetTable = new int[i17];
            this.sampleDecodingTimeTable = new long[i17];
            this.sampleIsSyncFrameTable = new boolean[i17];
            this.sampleHasSubsampleEncryptionTable = new boolean[i17];
        }
    }

    public void reset() {
        this.trunCount = 0;
        this.nextFragmentDecodeTime = 0L;
        this.definesEncryptionData = false;
        this.sampleEncryptionDataNeedsFill = false;
        this.trackEncryptionBox = null;
    }

    public void fillEncryptionData(ParsableByteArray parsableByteArray) {
        parsableByteArray.readBytes(this.sampleEncryptionData.data, 0, this.sampleEncryptionDataLength);
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }
}
