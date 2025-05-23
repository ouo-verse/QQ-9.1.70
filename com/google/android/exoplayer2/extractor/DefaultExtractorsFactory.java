package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import java.lang.reflect.Constructor;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DefaultExtractorsFactory implements ExtractorsFactory {
    private static final Constructor<? extends Extractor> FLAC_EXTRACTOR_CONSTRUCTOR;
    private int fragmentedMp4Flags;
    private int matroskaFlags;
    private int mp3Flags;
    private int mp4Flags;
    private int tsFlags;
    private int tsMode = 1;

    static {
        Constructor<? extends Extractor> constructor;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException unused) {
            constructor = null;
        } catch (Exception e16) {
            throw new RuntimeException("Error instantiating FLAC extension", e16);
        }
        FLAC_EXTRACTOR_CONSTRUCTOR = constructor;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public synchronized Extractor[] createExtractors() {
        int i3;
        Extractor[] extractorArr;
        Constructor<? extends Extractor> constructor = FLAC_EXTRACTOR_CONSTRUCTOR;
        if (constructor == null) {
            i3 = 11;
        } else {
            i3 = 12;
        }
        extractorArr = new Extractor[i3];
        extractorArr[0] = new Mp4Extractor(this.mp4Flags);
        extractorArr[1] = new TsExtractor(this.tsMode, this.tsFlags);
        extractorArr[2] = new Mp3Extractor(this.mp3Flags);
        extractorArr[3] = new FragmentedMp4Extractor(this.fragmentedMp4Flags);
        extractorArr[4] = new MatroskaExtractor(this.matroskaFlags);
        extractorArr[5] = new AdtsExtractor();
        extractorArr[6] = new Ac3Extractor();
        extractorArr[7] = new FlvExtractor();
        extractorArr[8] = new OggExtractor();
        extractorArr[9] = new PsExtractor();
        extractorArr[10] = new WavExtractor();
        if (constructor != null) {
            try {
                extractorArr[11] = constructor.newInstance(new Object[0]);
            } catch (Exception e16) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e16);
            }
        }
        return extractorArr;
    }

    public synchronized DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int i3) {
        this.fragmentedMp4Flags = i3;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMatroskaExtractorFlags(int i3) {
        this.matroskaFlags = i3;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp3ExtractorFlags(int i3) {
        this.mp3Flags = i3;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp4ExtractorFlags(int i3) {
        this.mp4Flags = i3;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorFlags(int i3) {
        this.tsFlags = i3;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorMode(int i3) {
        this.tsMode = i3;
        return this;
    }
}
