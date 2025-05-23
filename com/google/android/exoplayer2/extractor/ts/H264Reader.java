package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class H264Reader implements ElementaryStreamReader {
    private static final int NAL_UNIT_TYPE_PPS = 8;
    private static final int NAL_UNIT_TYPE_SEI = 6;
    private static final int NAL_UNIT_TYPE_SPS = 7;
    private final boolean allowNonIdrKeyframes;
    private final boolean detectAccessUnits;
    private String formatId;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private SampleReader sampleReader;
    private final SeiReader seiReader;
    private long totalBytesWritten;
    private final boolean[] prefixFlags = new boolean[3];
    private final NalUnitTargetBuffer sps = new NalUnitTargetBuffer(7, 128);
    private final NalUnitTargetBuffer pps = new NalUnitTargetBuffer(8, 128);
    private final NalUnitTargetBuffer sei = new NalUnitTargetBuffer(6, 128);
    private final ParsableByteArray seiWrapper = new ParsableByteArray();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class SampleReader {
        private static final int DEFAULT_BUFFER_SIZE = 128;
        private static final int NAL_UNIT_TYPE_AUD = 9;
        private static final int NAL_UNIT_TYPE_IDR = 5;
        private static final int NAL_UNIT_TYPE_NON_IDR = 1;
        private static final int NAL_UNIT_TYPE_PARTITION_A = 2;
        private final boolean allowNonIdrKeyframes;
        private final ParsableNalUnitBitArray bitArray;
        private byte[] buffer;
        private int bufferLength;
        private final boolean detectAccessUnits;
        private boolean isFilling;
        private long nalUnitStartPosition;
        private long nalUnitTimeUs;
        private int nalUnitType;
        private final TrackOutput output;
        private SliceHeaderData previousSliceHeader;
        private boolean readingSample;
        private boolean sampleIsKeyframe;
        private long samplePosition;
        private long sampleTimeUs;
        private SliceHeaderData sliceHeader;
        private final SparseArray<NalUnitUtil.SpsData> sps = new SparseArray<>();
        private final SparseArray<NalUnitUtil.PpsData> pps = new SparseArray<>();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class SliceHeaderData {
            private static final int SLICE_TYPE_ALL_I = 7;
            private static final int SLICE_TYPE_I = 2;
            private boolean bottomFieldFlag;
            private boolean bottomFieldFlagPresent;
            private int deltaPicOrderCnt0;
            private int deltaPicOrderCnt1;
            private int deltaPicOrderCntBottom;
            private boolean fieldPicFlag;
            private int frameNum;
            private boolean hasSliceType;
            private boolean idrPicFlag;
            private int idrPicId;
            private boolean isComplete;
            private int nalRefIdc;
            private int picOrderCntLsb;
            private int picParameterSetId;
            private int sliceType;
            private NalUnitUtil.SpsData spsData;

            SliceHeaderData() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean isFirstVclNalUnitOfPicture(SliceHeaderData sliceHeaderData) {
                boolean z16;
                boolean z17;
                if (this.isComplete) {
                    if (!sliceHeaderData.isComplete || this.frameNum != sliceHeaderData.frameNum || this.picParameterSetId != sliceHeaderData.picParameterSetId || this.fieldPicFlag != sliceHeaderData.fieldPicFlag) {
                        return true;
                    }
                    if (this.bottomFieldFlagPresent && sliceHeaderData.bottomFieldFlagPresent && this.bottomFieldFlag != sliceHeaderData.bottomFieldFlag) {
                        return true;
                    }
                    int i3 = this.nalRefIdc;
                    int i16 = sliceHeaderData.nalRefIdc;
                    if (i3 != i16 && (i3 == 0 || i16 == 0)) {
                        return true;
                    }
                    int i17 = this.spsData.picOrderCountType;
                    if (i17 == 0 && sliceHeaderData.spsData.picOrderCountType == 0 && (this.picOrderCntLsb != sliceHeaderData.picOrderCntLsb || this.deltaPicOrderCntBottom != sliceHeaderData.deltaPicOrderCntBottom)) {
                        return true;
                    }
                    if ((i17 == 1 && sliceHeaderData.spsData.picOrderCountType == 1 && (this.deltaPicOrderCnt0 != sliceHeaderData.deltaPicOrderCnt0 || this.deltaPicOrderCnt1 != sliceHeaderData.deltaPicOrderCnt1)) || (z16 = this.idrPicFlag) != (z17 = sliceHeaderData.idrPicFlag)) {
                        return true;
                    }
                    if (z16 && z17 && this.idrPicId != sliceHeaderData.idrPicId) {
                        return true;
                    }
                }
                return false;
            }

            public void clear() {
                this.hasSliceType = false;
                this.isComplete = false;
            }

            public boolean isISlice() {
                int i3;
                if (this.hasSliceType && ((i3 = this.sliceType) == 7 || i3 == 2)) {
                    return true;
                }
                return false;
            }

            public void setAll(NalUnitUtil.SpsData spsData, int i3, int i16, int i17, int i18, boolean z16, boolean z17, boolean z18, boolean z19, int i19, int i26, int i27, int i28, int i29) {
                this.spsData = spsData;
                this.nalRefIdc = i3;
                this.sliceType = i16;
                this.frameNum = i17;
                this.picParameterSetId = i18;
                this.fieldPicFlag = z16;
                this.bottomFieldFlagPresent = z17;
                this.bottomFieldFlag = z18;
                this.idrPicFlag = z19;
                this.idrPicId = i19;
                this.picOrderCntLsb = i26;
                this.deltaPicOrderCntBottom = i27;
                this.deltaPicOrderCnt0 = i28;
                this.deltaPicOrderCnt1 = i29;
                this.isComplete = true;
                this.hasSliceType = true;
            }

            public void setSliceType(int i3) {
                this.sliceType = i3;
                this.hasSliceType = true;
            }
        }

        public SampleReader(TrackOutput trackOutput, boolean z16, boolean z17) {
            this.output = trackOutput;
            this.allowNonIdrKeyframes = z16;
            this.detectAccessUnits = z17;
            this.previousSliceHeader = new SliceHeaderData();
            this.sliceHeader = new SliceHeaderData();
            byte[] bArr = new byte[128];
            this.buffer = bArr;
            this.bitArray = new ParsableNalUnitBitArray(bArr, 0, 0);
            reset();
        }

        private void outputSample(int i3) {
            boolean z16 = this.sampleIsKeyframe;
            this.output.sampleMetadata(this.sampleTimeUs, z16 ? 1 : 0, (int) (this.nalUnitStartPosition - this.samplePosition), i3, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0152  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0102  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void appendToNalUnit(byte[] bArr, int i3, int i16) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            int i17;
            int i18;
            int i19;
            int i26;
            int i27;
            int i28;
            if (!this.isFilling) {
                return;
            }
            int i29 = i16 - i3;
            byte[] bArr2 = this.buffer;
            int length = bArr2.length;
            int i36 = this.bufferLength;
            if (length < i36 + i29) {
                this.buffer = Arrays.copyOf(bArr2, (i36 + i29) * 2);
            }
            System.arraycopy(bArr, i3, this.buffer, this.bufferLength, i29);
            int i37 = this.bufferLength + i29;
            this.bufferLength = i37;
            this.bitArray.reset(this.buffer, 0, i37);
            if (!this.bitArray.canReadBits(8)) {
                return;
            }
            this.bitArray.skipBit();
            int readBits = this.bitArray.readBits(2);
            this.bitArray.skipBits(5);
            if (!this.bitArray.canReadExpGolombCodedNum()) {
                return;
            }
            this.bitArray.readUnsignedExpGolombCodedInt();
            if (!this.bitArray.canReadExpGolombCodedNum()) {
                return;
            }
            int readUnsignedExpGolombCodedInt = this.bitArray.readUnsignedExpGolombCodedInt();
            if (!this.detectAccessUnits) {
                this.isFilling = false;
                this.sliceHeader.setSliceType(readUnsignedExpGolombCodedInt);
                return;
            }
            if (!this.bitArray.canReadExpGolombCodedNum()) {
                return;
            }
            int readUnsignedExpGolombCodedInt2 = this.bitArray.readUnsignedExpGolombCodedInt();
            if (this.pps.indexOfKey(readUnsignedExpGolombCodedInt2) < 0) {
                this.isFilling = false;
                return;
            }
            NalUnitUtil.PpsData ppsData = this.pps.get(readUnsignedExpGolombCodedInt2);
            NalUnitUtil.SpsData spsData = this.sps.get(ppsData.seqParameterSetId);
            if (spsData.separateColorPlaneFlag) {
                if (!this.bitArray.canReadBits(2)) {
                    return;
                } else {
                    this.bitArray.skipBits(2);
                }
            }
            if (!this.bitArray.canReadBits(spsData.frameNumLength)) {
                return;
            }
            int readBits2 = this.bitArray.readBits(spsData.frameNumLength);
            if (!spsData.frameMbsOnlyFlag) {
                if (!this.bitArray.canReadBits(1)) {
                    return;
                }
                boolean readBit = this.bitArray.readBit();
                if (readBit) {
                    if (!this.bitArray.canReadBits(1)) {
                        return;
                    }
                    z16 = readBit;
                    z17 = true;
                    z18 = this.bitArray.readBit();
                    if (this.nalUnitType != 5) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (!z19) {
                        if (!this.bitArray.canReadExpGolombCodedNum()) {
                            return;
                        } else {
                            i17 = this.bitArray.readUnsignedExpGolombCodedInt();
                        }
                    } else {
                        i17 = 0;
                    }
                    i18 = spsData.picOrderCountType;
                    if (i18 != 0) {
                        if (!this.bitArray.canReadBits(spsData.picOrderCntLsbLength)) {
                            return;
                        }
                        int readBits3 = this.bitArray.readBits(spsData.picOrderCntLsbLength);
                        if (ppsData.bottomFieldPicOrderInFramePresentFlag && !z16) {
                            if (!this.bitArray.canReadExpGolombCodedNum()) {
                                return;
                            }
                            i26 = this.bitArray.readSignedExpGolombCodedInt();
                            i19 = readBits3;
                            i27 = 0;
                            i28 = i27;
                            this.sliceHeader.setAll(spsData, readBits, readUnsignedExpGolombCodedInt, readBits2, readUnsignedExpGolombCodedInt2, z16, z17, z18, z19, i17, i19, i26, i27, i28);
                            this.isFilling = false;
                        }
                        i19 = readBits3;
                        i26 = 0;
                    } else {
                        if (i18 == 1 && !spsData.deltaPicOrderAlwaysZeroFlag) {
                            if (!this.bitArray.canReadExpGolombCodedNum()) {
                                return;
                            }
                            int readSignedExpGolombCodedInt = this.bitArray.readSignedExpGolombCodedInt();
                            if (ppsData.bottomFieldPicOrderInFramePresentFlag && !z16) {
                                if (!this.bitArray.canReadExpGolombCodedNum()) {
                                    return;
                                }
                                i28 = this.bitArray.readSignedExpGolombCodedInt();
                                i27 = readSignedExpGolombCodedInt;
                                i19 = 0;
                                i26 = 0;
                            } else {
                                i27 = readSignedExpGolombCodedInt;
                                i19 = 0;
                                i26 = 0;
                                i28 = 0;
                            }
                            this.sliceHeader.setAll(spsData, readBits, readUnsignedExpGolombCodedInt, readBits2, readUnsignedExpGolombCodedInt2, z16, z17, z18, z19, i17, i19, i26, i27, i28);
                            this.isFilling = false;
                        }
                        i19 = 0;
                        i26 = 0;
                    }
                    i27 = i26;
                    i28 = i27;
                    this.sliceHeader.setAll(spsData, readBits, readUnsignedExpGolombCodedInt, readBits2, readUnsignedExpGolombCodedInt2, z16, z17, z18, z19, i17, i19, i26, i27, i28);
                    this.isFilling = false;
                }
                z16 = readBit;
                z17 = false;
            } else {
                z16 = false;
                z17 = false;
            }
            z18 = z17;
            if (this.nalUnitType != 5) {
            }
            if (!z19) {
            }
            i18 = spsData.picOrderCountType;
            if (i18 != 0) {
            }
            i27 = i26;
            i28 = i27;
            this.sliceHeader.setAll(spsData, readBits, readUnsignedExpGolombCodedInt, readBits2, readUnsignedExpGolombCodedInt2, z16, z17, z18, z19, i17, i19, i26, i27, i28);
            this.isFilling = false;
        }

        public void endNalUnit(long j3, int i3) {
            boolean z16 = false;
            if (this.nalUnitType == 9 || (this.detectAccessUnits && this.sliceHeader.isFirstVclNalUnitOfPicture(this.previousSliceHeader))) {
                if (this.readingSample) {
                    outputSample(i3 + ((int) (j3 - this.nalUnitStartPosition)));
                }
                this.samplePosition = this.nalUnitStartPosition;
                this.sampleTimeUs = this.nalUnitTimeUs;
                this.sampleIsKeyframe = false;
                this.readingSample = true;
            }
            boolean z17 = this.sampleIsKeyframe;
            int i16 = this.nalUnitType;
            if (i16 == 5 || (this.allowNonIdrKeyframes && i16 == 1 && this.sliceHeader.isISlice())) {
                z16 = true;
            }
            this.sampleIsKeyframe = z17 | z16;
        }

        public boolean needsSpsPps() {
            return this.detectAccessUnits;
        }

        public void putPps(NalUnitUtil.PpsData ppsData) {
            this.pps.append(ppsData.picParameterSetId, ppsData);
        }

        public void putSps(NalUnitUtil.SpsData spsData) {
            this.sps.append(spsData.seqParameterSetId, spsData);
        }

        public void reset() {
            this.isFilling = false;
            this.readingSample = false;
            this.sliceHeader.clear();
        }

        public void startNalUnit(long j3, int i3, long j16) {
            this.nalUnitType = i3;
            this.nalUnitTimeUs = j16;
            this.nalUnitStartPosition = j3;
            if (!this.allowNonIdrKeyframes || i3 != 1) {
                if (this.detectAccessUnits) {
                    if (i3 != 5 && i3 != 1 && i3 != 2) {
                        return;
                    }
                } else {
                    return;
                }
            }
            SliceHeaderData sliceHeaderData = this.previousSliceHeader;
            this.previousSliceHeader = this.sliceHeader;
            this.sliceHeader = sliceHeaderData;
            sliceHeaderData.clear();
            this.bufferLength = 0;
            this.isFilling = true;
        }
    }

    public H264Reader(SeiReader seiReader, boolean z16, boolean z17) {
        this.seiReader = seiReader;
        this.allowNonIdrKeyframes = z16;
        this.detectAccessUnits = z17;
    }

    private void endNalUnit(long j3, int i3, int i16, long j16) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.endNalUnit(i16);
            this.pps.endNalUnit(i16);
            if (!this.hasOutputFormat) {
                if (this.sps.isCompleted() && this.pps.isCompleted()) {
                    ArrayList arrayList = new ArrayList();
                    NalUnitTargetBuffer nalUnitTargetBuffer = this.sps;
                    arrayList.add(Arrays.copyOf(nalUnitTargetBuffer.nalData, nalUnitTargetBuffer.nalLength));
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.pps;
                    arrayList.add(Arrays.copyOf(nalUnitTargetBuffer2.nalData, nalUnitTargetBuffer2.nalLength));
                    NalUnitTargetBuffer nalUnitTargetBuffer3 = this.sps;
                    NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit(nalUnitTargetBuffer3.nalData, 3, nalUnitTargetBuffer3.nalLength);
                    NalUnitTargetBuffer nalUnitTargetBuffer4 = this.pps;
                    NalUnitUtil.PpsData parsePpsNalUnit = NalUnitUtil.parsePpsNalUnit(nalUnitTargetBuffer4.nalData, 3, nalUnitTargetBuffer4.nalLength);
                    this.output.format(Format.createVideoSampleFormat(this.formatId, "video/avc", null, -1, -1, parseSpsNalUnit.width, parseSpsNalUnit.height, -1.0f, arrayList, -1, parseSpsNalUnit.pixelWidthAspectRatio, null));
                    this.hasOutputFormat = true;
                    this.sampleReader.putSps(parseSpsNalUnit);
                    this.sampleReader.putPps(parsePpsNalUnit);
                    this.sps.reset();
                    this.pps.reset();
                }
            } else if (this.sps.isCompleted()) {
                NalUnitTargetBuffer nalUnitTargetBuffer5 = this.sps;
                this.sampleReader.putSps(NalUnitUtil.parseSpsNalUnit(nalUnitTargetBuffer5.nalData, 3, nalUnitTargetBuffer5.nalLength));
                this.sps.reset();
            } else if (this.pps.isCompleted()) {
                NalUnitTargetBuffer nalUnitTargetBuffer6 = this.pps;
                this.sampleReader.putPps(NalUnitUtil.parsePpsNalUnit(nalUnitTargetBuffer6.nalData, 3, nalUnitTargetBuffer6.nalLength));
                this.pps.reset();
            }
        }
        if (this.sei.endNalUnit(i16)) {
            NalUnitTargetBuffer nalUnitTargetBuffer7 = this.sei;
            this.seiWrapper.reset(this.sei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer7.nalData, nalUnitTargetBuffer7.nalLength));
            this.seiWrapper.setPosition(4);
            this.seiReader.consume(j16, this.seiWrapper);
        }
        this.sampleReader.endNalUnit(j3, i3);
    }

    private void nalUnitData(byte[] bArr, int i3, int i16) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.appendToNalUnit(bArr, i3, i16);
            this.pps.appendToNalUnit(bArr, i3, i16);
        }
        this.sei.appendToNalUnit(bArr, i3, i16);
        this.sampleReader.appendToNalUnit(bArr, i3, i16);
    }

    private void startNalUnit(long j3, int i3, long j16) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.startNalUnit(i3);
            this.pps.startNalUnit(i3);
        }
        this.sei.startNalUnit(i3);
        this.sampleReader.startNalUnit(j3, i3, j16);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        int i3;
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] bArr = parsableByteArray.data;
        this.totalBytesWritten += parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        while (true) {
            int findNalUnit = NalUnitUtil.findNalUnit(bArr, position, limit, this.prefixFlags);
            if (findNalUnit == limit) {
                nalUnitData(bArr, position, limit);
                return;
            }
            int nalUnitType = NalUnitUtil.getNalUnitType(bArr, findNalUnit);
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
            startNalUnit(j3, nalUnitType, this.pesTimeUs);
            position = findNalUnit + 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.output = track;
        this.sampleReader = new SampleReader(track, this.allowNonIdrKeyframes, this.detectAccessUnits);
        this.seiReader.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j3, boolean z16) {
        this.pesTimeUs = j3;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.sps.reset();
        this.pps.reset();
        this.sei.reset();
        this.sampleReader.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }
}
