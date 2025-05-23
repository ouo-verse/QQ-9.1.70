package com.tencent.tavkit.composition.video;

import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.ciimage.CIImage;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TAVVideoTransition {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface Filter extends Releasable {
        @RenderThread
        CIImage apply(TAVVideoTransition tAVVideoTransition, CIImage cIImage, CIImage cIImage2, float f16, RenderInfo renderInfo);
    }

    @RenderThread
    Filter createFilter();

    @Nullable
    String effectId();

    CMTime getDuration();
}
