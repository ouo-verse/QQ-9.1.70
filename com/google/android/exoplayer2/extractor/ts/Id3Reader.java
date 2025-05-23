package com.google.android.exoplayer2.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Id3Reader implements ElementaryStreamReader {
    private static final int ID3_HEADER_SIZE = 10;
    private static final String TAG = "Id3Reader";
    private final ParsableByteArray id3Header = new ParsableByteArray(10);
    private TrackOutput output;
    private int sampleBytesRead;
    private int sampleSize;
    private long sampleTimeUs;
    private boolean writingSample;

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        if (!this.writingSample) {
            return;
        }
        int bytesLeft = parsableByteArray.bytesLeft();
        int i3 = this.sampleBytesRead;
        if (i3 < 10) {
            int min = Math.min(bytesLeft, 10 - i3);
            System.arraycopy(parsableByteArray.data, parsableByteArray.getPosition(), this.id3Header.data, this.sampleBytesRead, min);
            if (this.sampleBytesRead + min == 10) {
                this.id3Header.setPosition(0);
                if (73 == this.id3Header.readUnsignedByte() && 68 == this.id3Header.readUnsignedByte() && 51 == this.id3Header.readUnsignedByte()) {
                    this.id3Header.skipBytes(3);
                    this.sampleSize = this.id3Header.readSynchSafeInt() + 10;
                } else {
                    Log.w(TAG, "Discarding invalid ID3 tag");
                    this.writingSample = false;
                    return;
                }
            }
        }
        int min2 = Math.min(bytesLeft, this.sampleSize - this.sampleBytesRead);
        this.output.sampleData(parsableByteArray, min2);
        this.sampleBytesRead += min2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 4);
        this.output = track;
        track.format(Format.createSampleFormat(trackIdGenerator.getFormatId(), "application/id3", null, -1, null));
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        int i3;
        if (this.writingSample && (i3 = this.sampleSize) != 0 && this.sampleBytesRead == i3) {
            this.output.sampleMetadata(this.sampleTimeUs, 1, i3, 0, null);
            this.writingSample = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j3, boolean z16) {
        if (!z16) {
            return;
        }
        this.writingSample = true;
        this.sampleTimeUs = j3;
        this.sampleSize = 0;
        this.sampleBytesRead = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.writingSample = false;
    }
}
