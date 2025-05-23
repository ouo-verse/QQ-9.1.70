package org.tencwebrtc;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
interface MediaCodecWrapper {
    void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i3);

    Surface createInputSurface();

    int dequeueInputBuffer(long j3);

    int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long j3);

    void flush();

    ByteBuffer[] getInputBuffers();

    ByteBuffer[] getOutputBuffers();

    MediaFormat getOutputFormat();

    void queueInputBuffer(int i3, int i16, int i17, long j3, int i18);

    void release();

    void releaseOutputBuffer(int i3, long j3);

    void releaseOutputBuffer(int i3, boolean z16);

    void setParameters(Bundle bundle);

    void start();

    void stop();
}
