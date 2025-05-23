package com.tencent.tav.decoder.extractor;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import com.tencent.tav.decoder.logger.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AVHWExtractor implements IExtractor {
    private static final String TAG = "AVHWExtractor";
    private String mDataSourcePath;
    private MediaExtractor mExtractor = new MediaExtractor();

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public boolean advance() {
        return this.mExtractor.advance();
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public int getFirstTrackIndex(String str) {
        int trackCount = this.mExtractor.getTrackCount();
        for (int i3 = 0; i3 < trackCount; i3++) {
            if (this.mExtractor.getTrackFormat(i3).getString("mime").equals(str)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public long getMediaDuration(String str) {
        int trackCount = this.mExtractor.getTrackCount();
        for (int i3 = 0; i3 < trackCount; i3++) {
            MediaFormat trackFormat = this.mExtractor.getTrackFormat(i3);
            if (trackFormat.getString("mime").equals(str)) {
                return trackFormat.getLong("durationUs");
            }
        }
        return -1L;
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
        return this.mDataSourcePath;
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
        this.mExtractor.release();
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
        try {
            this.mExtractor.setDataSource(str);
            this.mDataSourcePath = str;
        } catch (IOException e16) {
            Logger.e(TAG, "setDataSource exception: " + e16.getMessage());
        }
    }

    @Override // com.tencent.tav.decoder.extractor.IExtractor
    public void unselectTrack(int i3) {
        this.mExtractor.unselectTrack(i3);
    }
}
