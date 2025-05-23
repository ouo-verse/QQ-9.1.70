package com.tencent.tav.decoder;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IAudioDecoder extends IDecoder {
    ByteBuffer outputBuffer();

    void release();
}
