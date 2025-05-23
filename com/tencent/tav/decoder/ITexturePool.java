package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.TextureInfo;

/* loaded from: classes26.dex */
public interface ITexturePool {
    TextureInfo popTexture(int i3, int i16, int i17);

    void pushTexture(TextureInfo textureInfo);

    void release();

    void setMaxCacheLength(int i3);

    void setMaxCacheSize(long j3);
}
