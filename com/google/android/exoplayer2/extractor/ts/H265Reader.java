package com.google.android.exoplayer2.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class H265Reader implements ElementaryStreamReader {
    private static final int BLA_W_LP = 16;
    private static final int CRA_NUT = 21;
    private static final int PPS_NUT = 34;
    private static final int PREFIX_SEI_NUT = 39;
    private static final int RASL_R = 9;
    private static final int SPS_NUT = 33;
    private static final int SUFFIX_SEI_NUT = 40;
    private static final String TAG = "H265Reader";
    private static final int VPS_NUT = 32;
    private String formatId;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private SampleReader sampleReader;
    private final SeiReader seiReader;
    private long totalBytesWritten;
    private final boolean[] prefixFlags = new boolean[3];
    private final NalUnitTargetBuffer vps = new NalUnitTargetBuffer(32, 128);
    private final NalUnitTargetBuffer sps = new NalUnitTargetBuffer(33, 128);
    private final NalUnitTargetBuffer pps = new NalUnitTargetBuffer(34, 128);
    private final NalUnitTargetBuffer prefixSei = new NalUnitTargetBuffer(39, 128);
    private final NalUnitTargetBuffer suffixSei = new NalUnitTargetBuffer(40, 128);
    private final ParsableByteArray seiWrapper = new ParsableByteArray();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class SampleReader {
        private static final int FIRST_SLICE_FLAG_OFFSET = 2;
        private boolean isFirstParameterSet;
        private boolean isFirstSlice;
        private boolean lookingForFirstSliceFlag;
        private int nalUnitBytesRead;
        private boolean nalUnitHasKeyframeData;
        private long nalUnitStartPosition;
        private long nalUnitTimeUs;
        private final TrackOutput output;
        private boolean readingSample;
        private boolean sampleIsKeyframe;
        private long samplePosition;
        private long sampleTimeUs;
        private boolean writingParameterSets;

        public SampleReader(TrackOutput trackOutput) {
            this.output = trackOutput;
        }

        private void outputSample(int i3) {
            boolean z16 = this.sampleIsKeyframe;
            this.output.sampleMetadata(this.sampleTimeUs, z16 ? 1 : 0, (int) (this.nalUnitStartPosition - this.samplePosition), i3, null);
        }

        public void endNalUnit(long j3, int i3) {
            if (this.writingParameterSets && this.isFirstSlice) {
                this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
                this.writingParameterSets = false;
            } else if (this.isFirstParameterSet || this.isFirstSlice) {
                if (this.readingSample) {
                    outputSample(i3 + ((int) (j3 - this.nalUnitStartPosition)));
                }
                this.samplePosition = this.nalUnitStartPosition;
                this.sampleTimeUs = this.nalUnitTimeUs;
                this.readingSample = true;
                this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
            }
        }

        public void readNalUnitData(byte[] bArr, int i3, int i16) {
            boolean z16;
            if (this.lookingForFirstSliceFlag) {
                int i17 = this.nalUnitBytesRead;
                int i18 = (i3 + 2) - i17;
                if (i18 < i16) {
                    if ((bArr[i18] & 128) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.isFirstSlice = z16;
                    this.lookingForFirstSliceFlag = false;
                    return;
                }
                this.nalUnitBytesRead = i17 + (i16 - i3);
            }
        }

        public void reset() {
            this.lookingForFirstSliceFlag = false;
            this.isFirstSlice = false;
            this.isFirstParameterSet = false;
            this.readingSample = false;
            this.writingParameterSets = false;
        }

        public void startNalUnit(long j3, int i3, int i16, long j16) {
            boolean z16;
            boolean z17 = false;
            this.isFirstSlice = false;
            this.isFirstParameterSet = false;
            this.nalUnitTimeUs = j16;
            this.nalUnitBytesRead = 0;
            this.nalUnitStartPosition = j3;
            if (i16 >= 32) {
                if (!this.writingParameterSets && this.readingSample) {
                    outputSample(i3);
                    this.readingSample = false;
                }
                if (i16 <= 34) {
                    this.isFirstParameterSet = !this.writingParameterSets;
                    this.writingParameterSets = true;
                }
            }
            if (i16 >= 16 && i16 <= 21) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.nalUnitHasKeyframeData = z16;
            if (z16 || i16 <= 9) {
                z17 = true;
            }
            this.lookingForFirstSliceFlag = z17;
        }
    }

    public H265Reader(SeiReader seiReader) {
        this.seiReader = seiReader;
    }

    private void endNalUnit(long j3, int i3, int i16, long j16) {
        if (this.hasOutputFormat) {
            this.sampleReader.endNalUnit(j3, i3);
        } else {
            this.vps.endNalUnit(i16);
            this.sps.endNalUnit(i16);
            this.pps.endNalUnit(i16);
            if (this.vps.isCompleted() && this.sps.isCompleted() && this.pps.isCompleted()) {
                this.output.format(parseMediaFormat(this.formatId, this.vps, this.sps, this.pps));
                this.hasOutputFormat = true;
            }
        }
        if (this.prefixSei.endNalUnit(i16)) {
            NalUnitTargetBuffer nalUnitTargetBuffer = this.prefixSei;
            this.seiWrapper.reset(this.prefixSei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer.nalData, nalUnitTargetBuffer.nalLength));
            this.seiWrapper.skipBytes(5);
            this.seiReader.consume(j16, this.seiWrapper);
        }
        if (this.suffixSei.endNalUnit(i16)) {
            NalUnitTargetBuffer nalUnitTargetBuffer2 = this.suffixSei;
            this.seiWrapper.reset(this.suffixSei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer2.nalData, nalUnitTargetBuffer2.nalLength));
            this.seiWrapper.skipBytes(5);
            this.seiReader.consume(j16, this.seiWrapper);
        }
    }

    private void nalUnitData(byte[] bArr, int i3, int i16) {
        if (this.hasOutputFormat) {
            this.sampleReader.readNalUnitData(bArr, i3, i16);
        } else {
            this.vps.appendToNalUnit(bArr, i3, i16);
            this.sps.appendToNalUnit(bArr, i3, i16);
            this.pps.appendToNalUnit(bArr, i3, i16);
        }
        this.prefixSei.appendToNalUnit(bArr, i3, i16);
        this.suffixSei.appendToNalUnit(bArr, i3, i16);
    }

    private static Format parseMediaFormat(String str, NalUnitTargetBuffer nalUnitTargetBuffer, NalUnitTargetBuffer nalUnitTargetBuffer2, NalUnitTargetBuffer nalUnitTargetBuffer3) {
        int i3;
        float f16;
        int i16;
        int i17;
        int i18 = nalUnitTargetBuffer.nalLength;
        byte[] bArr = new byte[nalUnitTargetBuffer2.nalLength + i18 + nalUnitTargetBuffer3.nalLength];
        System.arraycopy(nalUnitTargetBuffer.nalData, 0, bArr, 0, i18);
        System.arraycopy(nalUnitTargetBuffer2.nalData, 0, bArr, nalUnitTargetBuffer.nalLength, nalUnitTargetBuffer2.nalLength);
        System.arraycopy(nalUnitTargetBuffer3.nalData, 0, bArr, nalUnitTargetBuffer.nalLength + nalUnitTargetBuffer2.nalLength, nalUnitTargetBuffer3.nalLength);
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(nalUnitTargetBuffer2.nalData, 0, nalUnitTargetBuffer2.nalLength);
        parsableNalUnitBitArray.skipBits(44);
        int readBits = parsableNalUnitBitArray.readBits(3);
        parsableNalUnitBitArray.skipBit();
        parsableNalUnitBitArray.skipBits(88);
        parsableNalUnitBitArray.skipBits(8);
        int i19 = 0;
        for (int i26 = 0; i26 < readBits; i26++) {
            if (parsableNalUnitBitArray.readBit()) {
                i19 += 89;
            }
            if (parsableNalUnitBitArray.readBit()) {
                i19 += 8;
            }
        }
        parsableNalUnitBitArray.skipBits(i19);
        if (readBits > 0) {
            parsableNalUnitBitArray.skipBits((8 - readBits) * 2);
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readUnsignedExpGolombCodedInt == 3) {
            parsableNalUnitBitArray.skipBit();
        }
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit()) {
            int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (readUnsignedExpGolombCodedInt != 1 && readUnsignedExpGolombCodedInt != 2) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            if (readUnsignedExpGolombCodedInt == 1) {
                i17 = 2;
            } else {
                i17 = 1;
            }
            readUnsignedExpGolombCodedInt2 -= i16 * (readUnsignedExpGolombCodedInt4 + readUnsignedExpGolombCodedInt5);
            readUnsignedExpGolombCodedInt3 -= i17 * (readUnsignedExpGolombCodedInt6 + readUnsignedExpGolombCodedInt7);
        }
        int i27 = readUnsignedExpGolombCodedInt2;
        int i28 = readUnsignedExpGolombCodedInt3;
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit()) {
            i3 = 0;
        } else {
            i3 = readBits;
        }
        while (i3 <= readBits) {
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            i3++;
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
            skipScalingList(parsableNalUnitBitArray);
        }
        parsableNalUnitBitArray.skipBits(2);
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(8);
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
        }
        skipShortTermRefPicSets(parsableNalUnitBitArray);
        if (parsableNalUnitBitArray.readBit()) {
            for (int i29 = 0; i29 < parsableNalUnitBitArray.readUnsignedExpGolombCodedInt(); i29++) {
                parsableNalUnitBitArray.skipBits(readUnsignedExpGolombCodedInt8 + 4 + 1);
            }
        }
        parsableNalUnitBitArray.skipBits(2);
        float f17 = 1.0f;
        if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
            int readBits2 = parsableNalUnitBitArray.readBits(8);
            if (readBits2 == 255) {
                int readBits3 = parsableNalUnitBitArray.readBits(16);
                int readBits4 = parsableNalUnitBitArray.readBits(16);
                if (readBits3 != 0 && readBits4 != 0) {
                    f17 = readBits3 / readBits4;
                }
            } else {
                float[] fArr = NalUnitUtil.ASPECT_RATIO_IDC_VALUES;
                if (readBits2 < fArr.length) {
                    f16 = fArr[readBits2];
                    return Format.createVideoSampleFormat(str, "video/hevc", null, -1, -1, i27, i28, -1.0f, Collections.singletonList(bArr), -1, f16, null);
                }
                Log.w(TAG, "Unexpected aspect_ratio_idc value: " + readBits2);
            }
        }
        f16 = f17;
        return Format.createVideoSampleFormat(str, "video/hevc", null, -1, -1, i27, i28, -1.0f, Collections.singletonList(bArr), -1, f16, null);
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i3 = 0; i3 < 4; i3++) {
            int i16 = 0;
            while (i16 < 6) {
                int i17 = 1;
                if (!parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                } else {
                    int min = Math.min(64, 1 << ((i3 << 1) + 4));
                    if (i3 > 1) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                    for (int i18 = 0; i18 < min; i18++) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                }
                if (i3 == 3) {
                    i17 = 3;
                }
                i16 += i17;
            }
        }
    }

    private static void skipShortTermRefPicSets(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        boolean z16 = false;
        int i3 = 0;
        for (int i16 = 0; i16 < readUnsignedExpGolombCodedInt; i16++) {
            if (i16 != 0) {
                z16 = parsableNalUnitBitArray.readBit();
            }
            if (z16) {
                parsableNalUnitBitArray.skipBit();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                for (int i17 = 0; i17 <= i3; i17++) {
                    if (parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.skipBit();
                    }
                }
            } else {
                int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int i18 = readUnsignedExpGolombCodedInt2 + readUnsignedExpGolombCodedInt3;
                for (int i19 = 0; i19 < readUnsignedExpGolombCodedInt2; i19++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.skipBit();
                }
                for (int i26 = 0; i26 < readUnsignedExpGolombCodedInt3; i26++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.skipBit();
                }
                i3 = i18;
            }
        }
    }

    private void startNalUnit(long j3, int i3, int i16, long j16) {
        if (this.hasOutputFormat) {
            this.sampleReader.startNalUnit(j3, i3, i16, j16);
        } else {
            this.vps.startNalUnit(i16);
            this.sps.startNalUnit(i16);
            this.pps.startNalUnit(i16);
        }
        this.prefixSei.startNalUnit(i16);
        this.suffixSei.startNalUnit(i16);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        int i3;
        while (parsableByteArray.bytesLeft() > 0) {
            int position = parsableByteArray.getPosition();
            int limit = parsableByteArray.limit();
            byte[] bArr = parsableByteArray.data;
            this.totalBytesWritten += parsableByteArray.bytesLeft();
            this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
            while (position < limit) {
                int findNalUnit = NalUnitUtil.findNalUnit(bArr, position, limit, this.prefixFlags);
                if (findNalUnit == limit) {
                    nalUnitData(bArr, position, limit);
                    return;
                }
                int h265NalUnitType = NalUnitUtil.getH265NalUnitType(bArr, findNalUnit);
                int i16 = findNalUnit - position;
                if (i16 > 0) {
                    nalUnitData(bArr, position, findNalUnit);
                }
                int i17 = limit - findNalUnit;
                long j3 = this.totalBytesWritten - i17;
                if (i16 < 0) {
                    i3 = -i16;
                } else {
                    i3 = 0;
                }
                endNalUnit(j3, i17, i3, this.pesTimeUs);
                startNalUnit(j3, i17, h265NalUnitType, this.pesTimeUs);
                position = findNalUnit + 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.output = track;
        this.sampleReader = new SampleReader(track);
        this.seiReader.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j3, boolean z16) {
        this.pesTimeUs = j3;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.vps.reset();
        this.sps.reset();
        this.pps.reset();
        this.prefixSei.reset();
        this.suffixSei.reset();
        this.sampleReader.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }
}
