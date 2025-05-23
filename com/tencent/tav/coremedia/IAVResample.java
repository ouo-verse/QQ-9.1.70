package com.tencent.tav.coremedia;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IAVResample {
    void release();

    byte[] resample(ByteBuffer byteBuffer, int i3);

    void updateSrcFormat(int i3, int i16);
}
