package com.tencent.tav.extractor;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ApiExtractorDelegate implements IExtractorDelegate {
    private boolean released = false;
    private MediaExtractor mediaExtractor = new MediaExtractor();

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public synchronized boolean advance() {
        if (!this.released) {
            this.mediaExtractor.advance();
        }
        return false;
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public synchronized long getSampleTime() {
        if (!this.released) {
            return this.mediaExtractor.getSampleTime();
        }
        return -1L;
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public synchronized int getSampleTrackIndex() {
        if (!this.released) {
            return this.mediaExtractor.getSampleTrackIndex();
        }
        return -1;
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public final synchronized int getTrackCount() {
        if (!this.released) {
            return this.mediaExtractor.getTrackCount();
        }
        return 0;
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    @NonNull
    public synchronized MediaFormat getTrackFormat(int i3) {
        return this.mediaExtractor.getTrackFormat(i3);
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public boolean needMirror() {
        return true;
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public synchronized int readSampleData(@NonNull ByteBuffer byteBuffer, int i3) {
        if (!this.released) {
            return this.mediaExtractor.readSampleData(byteBuffer, i3);
        }
        return -1;
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public final synchronized void release() {
        this.mediaExtractor.release();
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public synchronized void seekTo(long j3, int i3) {
        if (!this.released) {
            this.mediaExtractor.seekTo(j3, i3);
        }
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public synchronized void selectTrack(int i3) {
        if (!this.released) {
            this.mediaExtractor.selectTrack(i3);
        }
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public final synchronized void setDataSource(@NonNull String str) {
        try {
            this.mediaExtractor.setDataSource(str);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public synchronized void unselectTrack(int i3) {
        if (!this.released) {
            this.mediaExtractor.unselectTrack(i3);
        }
    }
}
