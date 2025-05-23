package com.tencent.avcore.jni.codec;

import android.media.MediaCodec;
import android.media.MediaFormat;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IMediaCodecCallback {
    void onError(MediaCodec mediaCodec, Exception exc);

    void onInputBufferAvailable(MediaCodec mediaCodec, int i3);

    void onOutputBufferAvailable(MediaCodec mediaCodec, int i3, MediaCodec.BufferInfo bufferInfo);

    void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat);
}
