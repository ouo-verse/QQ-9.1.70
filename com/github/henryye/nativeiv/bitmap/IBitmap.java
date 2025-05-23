package com.github.henryye.nativeiv.bitmap;

import androidx.annotation.Keep;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.wxa.f.c;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IBitmap<Type> {
    void decodeInputStream(InputStream inputStream, ImageDecodeConfig imageDecodeConfig, c cVar);

    long getDecodeTime();

    BitmapType getType();

    Object provide();

    @Keep
    void recycle();
}
