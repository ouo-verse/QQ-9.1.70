package com.tencent.mobileqq.zplan.meme.mp4;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes34.dex */
public interface a {
    void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    void b(int i3);

    void c(int i3, String str);

    void d();

    void e(MediaFormat mediaFormat, boolean z16);

    void onEncodeStart();
}
