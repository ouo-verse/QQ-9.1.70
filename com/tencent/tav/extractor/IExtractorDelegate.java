package com.tencent.tav.extractor;

import android.media.MediaFormat;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IExtractorDelegate {
    boolean advance();

    long getSampleTime();

    int getSampleTrackIndex();

    int getTrackCount();

    @NonNull
    MediaFormat getTrackFormat(int i3) throws Exception;

    boolean needMirror();

    int readSampleData(@NonNull ByteBuffer byteBuffer, int i3);

    void release();

    void seekTo(long j3, int i3);

    void selectTrack(int i3) throws Exception;

    void setDataSource(@NonNull String str) throws Exception;

    void unselectTrack(int i3);
}
