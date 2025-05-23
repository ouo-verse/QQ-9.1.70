package com.tencent.tavkit.composition.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tavkit.ciimage.CIImage;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TAVVideoEffect {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface Filter extends Releasable {
        @NonNull
        @RenderThread
        CIImage apply(TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo);
    }

    @RenderThread
    Filter createFilter();

    @Nullable
    String effectId();
}
