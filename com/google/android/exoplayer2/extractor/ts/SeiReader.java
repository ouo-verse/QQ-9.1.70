package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.text.cea.CeaUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
final class SeiReader {
    private final List<Format> closedCaptionFormats;
    private final TrackOutput[] outputs;

    public SeiReader(List<Format> list) {
        this.closedCaptionFormats = list;
        this.outputs = new TrackOutput[list.size()];
    }

    public void consume(long j3, ParsableByteArray parsableByteArray) {
        CeaUtil.consume(j3, parsableByteArray, this.outputs);
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        boolean z16;
        for (int i3 = 0; i3 < this.outputs.length; i3++) {
            trackIdGenerator.generateNewId();
            TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
            Format format = this.closedCaptionFormats.get(i3);
            String str = format.sampleMimeType;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z16 = false;
            } else {
                z16 = true;
            }
            Assertions.checkArgument(z16, "Invalid closed caption mime type provided: " + str);
            String str2 = format.f32936id;
            if (str2 == null) {
                str2 = trackIdGenerator.getFormatId();
            }
            track.format(Format.createTextSampleFormat(str2, str, (String) null, -1, format.selectionFlags, format.language, format.accessibilityChannel, (DrmInitData) null));
            this.outputs[i3] = track;
        }
    }
}
