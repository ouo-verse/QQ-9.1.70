package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DvbSubtitleReader implements ElementaryStreamReader {
    private int bytesToCheck;
    private final TrackOutput[] outputs;
    private int sampleBytesWritten;
    private long sampleTimeUs;
    private final List<TsPayloadReader.DvbSubtitleInfo> subtitleInfos;
    private boolean writingSample;

    public DvbSubtitleReader(List<TsPayloadReader.DvbSubtitleInfo> list) {
        this.subtitleInfos = list;
        this.outputs = new TrackOutput[list.size()];
    }

    private boolean checkNextByte(ParsableByteArray parsableByteArray, int i3) {
        if (parsableByteArray.bytesLeft() == 0) {
            return false;
        }
        if (parsableByteArray.readUnsignedByte() != i3) {
            this.writingSample = false;
        }
        this.bytesToCheck--;
        return this.writingSample;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        if (this.writingSample) {
            if (this.bytesToCheck == 2 && !checkNextByte(parsableByteArray, 32)) {
                return;
            }
            if (this.bytesToCheck == 1 && !checkNextByte(parsableByteArray, 0)) {
                return;
            }
            int position = parsableByteArray.getPosition();
            int bytesLeft = parsableByteArray.bytesLeft();
            for (TrackOutput trackOutput : this.outputs) {
                parsableByteArray.setPosition(position);
                trackOutput.sampleData(parsableByteArray, bytesLeft);
            }
            this.sampleBytesWritten += bytesLeft;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i3 = 0; i3 < this.outputs.length; i3++) {
            TsPayloadReader.DvbSubtitleInfo dvbSubtitleInfo = this.subtitleInfos.get(i3);
            trackIdGenerator.generateNewId();
            TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
            track.format(Format.createImageSampleFormat(trackIdGenerator.getFormatId(), "application/dvbsubs", null, -1, 0, Collections.singletonList(dvbSubtitleInfo.initializationData), dvbSubtitleInfo.language, null));
            this.outputs[i3] = track;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        if (this.writingSample) {
            for (TrackOutput trackOutput : this.outputs) {
                trackOutput.sampleMetadata(this.sampleTimeUs, 1, this.sampleBytesWritten, 0, null);
            }
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
        this.sampleBytesWritten = 0;
        this.bytesToCheck = 2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.writingSample = false;
    }
}
