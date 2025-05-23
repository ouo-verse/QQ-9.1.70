package com.google.android.exoplayer2.extractor.flv;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;

/* loaded from: classes2.dex */
final class AudioTagPayloadReader extends TagPayloadReader {
    private static final int AAC_PACKET_TYPE_AAC_RAW = 1;
    private static final int AAC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    private static final int AUDIO_FORMAT_AAC = 10;
    private static final int AUDIO_FORMAT_ALAW = 7;
    private static final int AUDIO_FORMAT_MP3 = 2;
    private static final int AUDIO_FORMAT_ULAW = 8;
    private static final int[] AUDIO_SAMPLING_RATE_TABLE = {5512, 11025, 22050, 44100};
    private int audioFormat;
    private boolean hasOutputFormat;
    private boolean hasParsedAudioDataHeader;

    public AudioTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean parseHeader(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        String str;
        int i3;
        if (!this.hasParsedAudioDataHeader) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int i16 = (readUnsignedByte >> 4) & 15;
            this.audioFormat = i16;
            if (i16 == 2) {
                this.output.format(Format.createAudioSampleFormat(null, "audio/mpeg", null, -1, -1, 1, AUDIO_SAMPLING_RATE_TABLE[(readUnsignedByte >> 2) & 3], null, null, 0, null));
                this.hasOutputFormat = true;
            } else if (i16 != 7 && i16 != 8) {
                if (i16 != 10) {
                    throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.audioFormat);
                }
            } else {
                if (i16 == 7) {
                    str = "audio/g711-alaw";
                } else {
                    str = "audio/g711-mlaw";
                }
                String str2 = str;
                if ((readUnsignedByte & 1) == 1) {
                    i3 = 2;
                } else {
                    i3 = 3;
                }
                this.output.format(Format.createAudioSampleFormat(null, str2, null, -1, -1, 1, 8000, i3, null, null, 0, null));
                this.hasOutputFormat = true;
            }
            this.hasParsedAudioDataHeader = true;
        } else {
            parsableByteArray.skipBytes(1);
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected void parsePayload(ParsableByteArray parsableByteArray, long j3) throws ParserException {
        if (this.audioFormat == 2) {
            int bytesLeft = parsableByteArray.bytesLeft();
            this.output.sampleData(parsableByteArray, bytesLeft);
            this.output.sampleMetadata(j3, 1, bytesLeft, 0, null);
            return;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if (readUnsignedByte == 0 && !this.hasOutputFormat) {
            int bytesLeft2 = parsableByteArray.bytesLeft();
            byte[] bArr = new byte[bytesLeft2];
            parsableByteArray.readBytes(bArr, 0, bytesLeft2);
            Pair<Integer, Integer> parseAacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArr);
            this.output.format(Format.createAudioSampleFormat(null, "audio/mp4a-latm", null, -1, -1, ((Integer) parseAacAudioSpecificConfig.second).intValue(), ((Integer) parseAacAudioSpecificConfig.first).intValue(), Collections.singletonList(bArr), null, 0, null));
            this.hasOutputFormat = true;
            return;
        }
        if (this.audioFormat != 10 || readUnsignedByte == 1) {
            int bytesLeft3 = parsableByteArray.bytesLeft();
            this.output.sampleData(parsableByteArray, bytesLeft3);
            this.output.sampleMetadata(j3, 1, bytesLeft3, 0, null);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void seek() {
    }
}
