package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DtsReader implements ElementaryStreamReader {
    private static final int HEADER_SIZE = 18;
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int bytesRead;
    private Format format;
    private String formatId;
    private final String language;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int syncBytes;
    private long timeUs;
    private final ParsableByteArray headerScratchBytes = new ParsableByteArray(new byte[18]);
    private int state = 0;

    public DtsReader(String str) {
        this.language = str;
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i3) {
        int min = Math.min(parsableByteArray.bytesLeft(), i3 - this.bytesRead);
        parsableByteArray.readBytes(bArr, this.bytesRead, min);
        int i16 = this.bytesRead + min;
        this.bytesRead = i16;
        if (i16 == i3) {
            return true;
        }
        return false;
    }

    private void parseHeader() {
        byte[] bArr = this.headerScratchBytes.data;
        if (this.format == null) {
            Format parseDtsFormat = DtsUtil.parseDtsFormat(bArr, this.formatId, this.language, null);
            this.format = parseDtsFormat;
            this.output.format(parseDtsFormat);
        }
        this.sampleSize = DtsUtil.getDtsFrameSize(bArr);
        this.sampleDurationUs = (int) ((DtsUtil.parseDtsAudioSampleCount(bArr) * 1000000) / this.format.sampleRate);
    }

    private boolean skipToNextSync(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.bytesLeft() > 0) {
            int i3 = this.syncBytes << 8;
            this.syncBytes = i3;
            int readUnsignedByte = i3 | parsableByteArray.readUnsignedByte();
            this.syncBytes = readUnsignedByte;
            if (DtsUtil.isSyncWord(readUnsignedByte)) {
                byte[] bArr = this.headerScratchBytes.data;
                int i16 = this.syncBytes;
                bArr[0] = (byte) ((i16 >> 24) & 255);
                bArr[1] = (byte) ((i16 >> 16) & 255);
                bArr[2] = (byte) ((i16 >> 8) & 255);
                bArr[3] = (byte) (i16 & 255);
                this.bytesRead = 4;
                this.syncBytes = 0;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.bytesLeft() > 0) {
            int i3 = this.state;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        int min = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
                        this.output.sampleData(parsableByteArray, min);
                        int i16 = this.bytesRead + min;
                        this.bytesRead = i16;
                        int i17 = this.sampleSize;
                        if (i16 == i17) {
                            this.output.sampleMetadata(this.timeUs, 1, i17, 0, null);
                            this.timeUs += this.sampleDurationUs;
                            this.state = 0;
                        }
                    }
                } else if (continueRead(parsableByteArray, this.headerScratchBytes.data, 18)) {
                    parseHeader();
                    this.headerScratchBytes.setPosition(0);
                    this.output.sampleData(this.headerScratchBytes, 18);
                    this.state = 2;
                }
            } else if (skipToNextSync(parsableByteArray)) {
                this.state = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j3, boolean z16) {
        this.timeUs = j3;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.syncBytes = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }
}
