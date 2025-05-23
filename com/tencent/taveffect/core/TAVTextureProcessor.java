package com.tencent.taveffect.core;

/* loaded from: classes26.dex */
public interface TAVTextureProcessor {
    TAVTextureInfo applyNewTexture(TAVTextureInfo tAVTextureInfo);

    void onProcess(TAVTextureInfo tAVTextureInfo);

    void release();
}
