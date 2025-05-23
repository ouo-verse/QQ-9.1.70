package com.tencent.tavkit.composition.video;

import androidx.annotation.Nullable;
import com.tencent.tavkit.ciimage.CIImage;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TAVVideoMixEffect {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface Filter extends Releasable {
        @RenderThread
        CIImage apply(TAVVideoMixEffect tAVVideoMixEffect, ImageCollection imageCollection, RenderInfo renderInfo);
    }

    @RenderThread
    Filter createFilter();

    @Nullable
    String effectId();
}
