package com.tencent.tavkit.component.effectchain;

import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IVideoEffectContext {
    TAVVideoEffect getGlobalVideoEffect();

    TAVVideoEffect getSourceVideoEffect();

    TAVVideoMixEffect getVideoMixEffect();
}
