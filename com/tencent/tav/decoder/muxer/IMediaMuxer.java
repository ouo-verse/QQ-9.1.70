package com.tencent.tav.decoder.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import com.tencent.tav.core.ExportConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IMediaMuxer {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface Format {
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class OutputFormat {
        public static final int MUXER_OUTPUT_3GPP = 2;
        public static final int MUXER_OUTPUT_FIRST = 0;
        public static final int MUXER_OUTPUT_HEIF = 3;
        public static final int MUXER_OUTPUT_LAST = 3;
        public static final int MUXER_OUTPUT_MPEG_4 = 0;
        public static final int MUXER_OUTPUT_WEBM = 1;

        OutputFormat() {
        }
    }

    int addTrack(@NonNull MediaFormat mediaFormat);

    int audioTrackIndex();

    boolean ignoreHeader();

    boolean isMuxerStarted();

    void release();

    void setExportConfig(@NonNull ExportConfig exportConfig);

    void start();

    void stop();

    int videoTrackIndex();

    void writeSampleData(int i3, @NonNull ByteBuffer byteBuffer, @NonNull MediaCodec.BufferInfo bufferInfo);
}
