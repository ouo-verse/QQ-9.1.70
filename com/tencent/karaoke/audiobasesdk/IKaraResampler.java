package com.tencent.karaoke.audiobasesdk;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IKaraResampler {
    int init(int i3, int i16, int i17, int i18);

    int maxOutFrameCount();

    void release();

    int resample(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2);
}
