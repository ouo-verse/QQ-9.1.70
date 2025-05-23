package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class MpegAudioReader implements ElementaryStreamReader {
    private static final int HEADER_SIZE = 4;
    private static final int STATE_FINDING_HEADER = 0;
    private static final int STATE_READING_FRAME = 2;
    private static final int STATE_READING_HEADER = 1;
    private String formatId;
    private int frameBytesRead;
    private long frameDurationUs;
    private int frameSize;
    private boolean hasOutputFormat;
    private final MpegAudioHeader header;
    private final ParsableByteArray headerScratch;
    private final String language;
    private boolean lastByteWasFF;
    private TrackOutput output;
    private int state;
    private long timeUs;

    public MpegAudioReader() {
        this(null);
    }

    private void findHeader(ParsableByteArray parsableByteArray) {
        boolean z16;
        boolean z17;
        byte[] bArr = parsableByteArray.data;
        int limit = parsableByteArray.limit();
        for (int position = parsableByteArray.getPosition(); position < limit; position++) {
            byte b16 = bArr[position];
            if ((b16 & 255) == 255) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.lastByteWasFF && (b16 & 224) == 224) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.lastByteWasFF = z16;
            if (z17) {
                parsableByteArray.setPosition(position + 1);
                this.lastByteWasFF = false;
                this.headerScratch.data[1] = bArr[position];
                this.frameBytesRead = 2;
                this.state = 1;
                return;
            }
        }
        parsableByteArray.setPosition(limit);
    }

    private void readFrameRemainder(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.bytesLeft(), this.frameSize - this.frameBytesRead);
        this.output.sampleData(parsableByteArray, min);
        int i3 = this.frameBytesRead + min;
        this.frameBytesRead = i3;
        int i16 = this.frameSize;
        if (i3 < i16) {
            return;
        }
        this.output.sampleMetadata(this.timeUs, 1, i16, 0, null);
        this.timeUs += this.frameDurationUs;
        this.frameBytesRead = 0;
        this.state = 0;
    }

    private void readHeaderRemainder(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.bytesLeft(), 4 - this.frameBytesRead);
        parsableByteArray.readBytes(this.headerScratch.data, this.frameBytesRead, min);
        int i3 = this.frameBytesRead + min;
        this.frameBytesRead = i3;
        if (i3 < 4) {
            return;
        }
        this.headerScratch.setPosition(0);
        if (!MpegAudioHeader.populateHeader(this.headerScratch.readInt(), this.header)) {
            this.frameBytesRead = 0;
            this.state = 1;
            return;
        }
        MpegAudioHeader mpegAudioHeader = this.header;
        this.frameSize = mpegAudioHeader.frameSize;
        if (!this.hasOutputFormat) {
            int i16 = mpegAudioHeader.sampleRate;
            this.frameDurationUs = (mpegAudioHeader.samplesPerFrame * 1000000) / i16;
            this.output.format(Format.createAudioSampleFormat(this.formatId, mpegAudioHeader.mimeType, null, -1, 4096, mpegAudioHeader.channels, i16, null, null, 0, this.language));
            this.hasOutputFormat = true;
        }
        this.headerScratch.setPosition(0);
        this.output.sampleData(this.headerScratch, 4);
        this.state = 2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.bytesLeft() > 0) {
            int i3 = this.state;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        readFrameRemainder(parsableByteArray);
                    }
                } else {
                    readHeaderRemainder(parsableByteArray);
                }
            } else {
                findHeader(parsableByteArray);
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
        this.frameBytesRead = 0;
        this.lastByteWasFF = false;
    }

    public MpegAudioReader(String str) {
        this.state = 0;
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.headerScratch = parsableByteArray;
        parsableByteArray.data[0] = -1;
        this.header = new MpegAudioHeader();
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }
}
