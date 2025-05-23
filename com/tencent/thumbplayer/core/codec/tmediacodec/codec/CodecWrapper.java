package com.tencent.thumbplayer.core.codec.tmediacodec.codec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.core.codec.tmediacodec.callback.CodecCallback;
import com.tencent.thumbplayer.core.codec.tmediacodec.reuse.ReuseHelper;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface CodecWrapper {
    void attachThread();

    @NonNull
    ReuseHelper.ReuseType canReuseType(@NonNull FormatWrapper formatWrapper);

    @TargetApi(26)
    void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, int i3, @Nullable MediaDescrambler mediaDescrambler);

    void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i3);

    int dequeueInputBuffer(long j3);

    int dequeueOutputBuffer(@NonNull MediaCodec.BufferInfo bufferInfo, long j3);

    void flush();

    @NonNull
    MediaCodec getMediaCodec();

    void prepareToReUse();

    void queueInputBuffer(int i3, int i16, int i17, long j3, int i18);

    void release();

    void releaseOutputBuffer(int i3, long j3);

    void releaseOutputBuffer(int i3, boolean z16);

    void reset();

    void setCodecCallback(@Nullable CodecCallback codecCallback);

    @TargetApi(23)
    void setOutputSurface(@NonNull Surface surface);

    void start();

    void stop();
}
