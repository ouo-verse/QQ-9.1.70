package com.tencent.mobileqq.richmedia.capture.data;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface GifDecoder {
    Bitmap getNextGifFrame(long j3);

    void init();

    void release();
}
