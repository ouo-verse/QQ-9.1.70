package com.tencent.tav.decoder.extractor;

import android.media.MediaFormat;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IExtractor {
    boolean advance();

    int getFirstTrackIndex(String str);

    long getMediaDuration(String str);

    long getSampleTime();

    int getSampleTrackIndex();

    String getSourcePath();

    MediaFormat getTrackFormat(int i3);

    int readSampleData(@NonNull ByteBuffer byteBuffer, int i3);

    void release();

    void seekTo(long j3, int i3);

    void selectTrack(int i3);

    void setDataSource(String str);

    void unselectTrack(int i3);
}
