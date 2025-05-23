package com.tencent.tav.decoder.extractor;

import android.media.MediaFormat;
import androidx.annotation.NonNull;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FfmpegExtractor implements IExtractor {
    private AssetExtractor mExtractor = new AssetExtractor();

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public boolean advance() {
        return this.mExtractor.advance();
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public int getFirstTrackIndex(String str) {
        return ExtractorUtils.getFirstTrackIndex(this.mExtractor, str);
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public long getMediaDuration(String str) {
        str.hashCode();
        if (!str.equals("audio/")) {
            if (!str.equals("video/")) {
                return 0L;
            }
            return this.mExtractor.getDuration();
        }
        return this.mExtractor.getAudioDuration();
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public long getSampleTime() {
        return this.mExtractor.getSampleTime();
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public int getSampleTrackIndex() {
        return this.mExtractor.getSampleTrackIndex();
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public String getSourcePath() {
        return this.mExtractor.getSourcePath();
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public MediaFormat getTrackFormat(int i3) {
        return this.mExtractor.getTrackFormat(i3);
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public int readSampleData(@NonNull ByteBuffer byteBuffer, int i3) {
        return this.mExtractor.readSampleData(byteBuffer, i3);
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public void release() {
        this.mExtractor.dispose();
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public void seekTo(long j3, int i3) {
        this.mExtractor.seekTo(j3, i3);
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public void selectTrack(int i3) {
        this.mExtractor.selectTrack(i3);
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public void setDataSource(String str) {
        this.mExtractor.setDataSource(str);
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public void unselectTrack(int i3) {
        this.mExtractor.unselectTrack(i3);
    }
}
