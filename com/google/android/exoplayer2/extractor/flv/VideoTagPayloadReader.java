package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.video.AvcConfig;

/* loaded from: classes2.dex */
final class VideoTagPayloadReader extends TagPayloadReader {
    private static final int AVC_PACKET_TYPE_AVC_NALU = 1;
    private static final int AVC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    private static final int VIDEO_CODEC_AVC = 7;
    private static final int VIDEO_FRAME_KEYFRAME = 1;
    private static final int VIDEO_FRAME_VIDEO_INFO = 5;
    private int frameType;
    private boolean hasOutputFormat;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int nalUnitLengthFieldLength;

    public VideoTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean parseHeader(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i3 = (readUnsignedByte >> 4) & 15;
        int i16 = readUnsignedByte & 15;
        if (i16 == 7) {
            this.frameType = i3;
            if (i3 != 5) {
                return true;
            }
            return false;
        }
        throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i16);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected void parsePayload(ParsableByteArray parsableByteArray, long j3) throws ParserException {
        int i3;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        long readInt24 = j3 + (parsableByteArray.readInt24() * 1000);
        if (readUnsignedByte == 0 && !this.hasOutputFormat) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.bytesLeft()]);
            parsableByteArray.readBytes(parsableByteArray2.data, 0, parsableByteArray.bytesLeft());
            AvcConfig parse = AvcConfig.parse(parsableByteArray2);
            this.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
            this.output.format(Format.createVideoSampleFormat(null, "video/avc", null, -1, -1, parse.width, parse.height, -1.0f, parse.initializationData, -1, parse.pixelWidthAspectRatio, null));
            this.hasOutputFormat = true;
            return;
        }
        if (readUnsignedByte == 1 && this.hasOutputFormat) {
            byte[] bArr = this.nalLength.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i16 = 4 - this.nalUnitLengthFieldLength;
            int i17 = 0;
            while (parsableByteArray.bytesLeft() > 0) {
                parsableByteArray.readBytes(this.nalLength.data, i16, this.nalUnitLengthFieldLength);
                this.nalLength.setPosition(0);
                int readUnsignedIntToInt = this.nalLength.readUnsignedIntToInt();
                this.nalStartCode.setPosition(0);
                this.output.sampleData(this.nalStartCode, 4);
                this.output.sampleData(parsableByteArray, readUnsignedIntToInt);
                i17 = i17 + 4 + readUnsignedIntToInt;
            }
            TrackOutput trackOutput = this.output;
            if (this.frameType == 1) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            trackOutput.sampleMetadata(readInt24, i3, i17, 0, null);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void seek() {
    }
}
