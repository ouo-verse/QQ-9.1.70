package com.tencent.tav.decoder.muxer;

import androidx.annotation.NonNull;
import com.tencent.tav.core.ExportConfig;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IMediaDemux {
    int audioTrackIndex();

    boolean ignoreHeader();

    boolean isMuxerStarted();

    boolean prepare(@NonNull String str);

    int readSampleData(@NonNull ByteBuffer byteBuffer, int i3);

    void release();

    void seekTo(long j3, int i3);

    boolean selectTrack(int i3);

    void setExportConfig(@NonNull ExportConfig exportConfig);

    void stop();

    int videoTrackIndex();
}
