package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ChunkExtractorWrapper implements ExtractorOutput {
    private final SparseArray<BindingTrackOutput> bindingTrackOutputs = new SparseArray<>();
    public final Extractor extractor;
    private boolean extractorInitialized;
    private final Format primaryTrackManifestFormat;
    private final int primaryTrackType;
    private Format[] sampleFormats;
    private SeekMap seekMap;
    private TrackOutputProvider trackOutputProvider;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class BindingTrackOutput implements TrackOutput {

        /* renamed from: id, reason: collision with root package name */
        private final int f32947id;
        private final Format manifestFormat;
        public Format sampleFormat;
        private TrackOutput trackOutput;
        private final int type;

        public BindingTrackOutput(int i3, int i16, Format format) {
            this.f32947id = i3;
            this.type = i16;
            this.manifestFormat = format;
        }

        public void bind(TrackOutputProvider trackOutputProvider) {
            if (trackOutputProvider == null) {
                this.trackOutput = new DummyTrackOutput();
                return;
            }
            TrackOutput track = trackOutputProvider.track(this.f32947id, this.type);
            this.trackOutput = track;
            Format format = this.sampleFormat;
            if (format != null) {
                track.format(format);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(Format format) {
            Format format2 = this.manifestFormat;
            if (format2 != null) {
                format = format.copyWithManifestFormatInfo(format2);
            }
            this.sampleFormat = format;
            this.trackOutput.format(format);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int sampleData(ExtractorInput extractorInput, int i3, boolean z16) throws IOException, InterruptedException {
            return this.trackOutput.sampleData(extractorInput, i3, z16);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long j3, int i3, int i16, int i17, TrackOutput.CryptoData cryptoData) {
            this.trackOutput.sampleMetadata(j3, i3, i16, i17, cryptoData);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(ParsableByteArray parsableByteArray, int i3) {
            this.trackOutput.sampleData(parsableByteArray, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface TrackOutputProvider {
        TrackOutput track(int i3, int i16);
    }

    public ChunkExtractorWrapper(Extractor extractor, int i3, Format format) {
        this.extractor = extractor;
        this.primaryTrackType = i3;
        this.primaryTrackManifestFormat = format;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        Format[] formatArr = new Format[this.bindingTrackOutputs.size()];
        for (int i3 = 0; i3 < this.bindingTrackOutputs.size(); i3++) {
            formatArr[i3] = this.bindingTrackOutputs.valueAt(i3).sampleFormat;
        }
        this.sampleFormats = formatArr;
    }

    public Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    public SeekMap getSeekMap() {
        return this.seekMap;
    }

    public void init(TrackOutputProvider trackOutputProvider) {
        this.trackOutputProvider = trackOutputProvider;
        if (!this.extractorInitialized) {
            this.extractor.init(this);
            this.extractorInitialized = true;
            return;
        }
        this.extractor.seek(0L, 0L);
        for (int i3 = 0; i3 < this.bindingTrackOutputs.size(); i3++) {
            this.bindingTrackOutputs.valueAt(i3).bind(trackOutputProvider);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        this.seekMap = seekMap;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int i3, int i16) {
        boolean z16;
        Format format;
        BindingTrackOutput bindingTrackOutput = this.bindingTrackOutputs.get(i3);
        if (bindingTrackOutput == null) {
            if (this.sampleFormats == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Assertions.checkState(z16);
            if (i16 == this.primaryTrackType) {
                format = this.primaryTrackManifestFormat;
            } else {
                format = null;
            }
            bindingTrackOutput = new BindingTrackOutput(i3, i16, format);
            bindingTrackOutput.bind(this.trackOutputProvider);
            this.bindingTrackOutputs.put(i3, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }
}
