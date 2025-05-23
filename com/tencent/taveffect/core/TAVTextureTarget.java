package com.tencent.taveffect.core;

import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TAVTextureTarget {
    void addProcessor(TAVTextureProcessor tAVTextureProcessor);

    Collection<TAVTextureProcessor> getAllProcessors();

    void removeAllProcessors();

    void removeProcessor(TAVTextureProcessor tAVTextureProcessor);
}
