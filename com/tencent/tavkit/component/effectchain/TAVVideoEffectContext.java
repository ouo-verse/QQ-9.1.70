package com.tencent.tavkit.component.effectchain;

import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVVideoEffectContext implements IVideoEffectContext {
    protected final VideoEffectProxy sourceVideoEffectProxy = new VideoEffectProxy();
    protected final VideoMixEffectProxy videoMixEffectProxy = new VideoMixEffectProxy();
    protected final VideoEffectProxy globalVideoEffectProxy = new VideoEffectProxy();

    public void addGlobalFilter(TAVVideoEffect tAVVideoEffect) {
        this.globalVideoEffectProxy.getEffects().remove(tAVVideoEffect);
    }

    public void addSourceFilter(TAVVideoEffect tAVVideoEffect) {
        this.sourceVideoEffectProxy.getEffects().remove(tAVVideoEffect);
    }

    public void addVideoMixFilter(TAVVideoMixEffect tAVVideoMixEffect) {
        this.videoMixEffectProxy.getEffects().remove(tAVVideoMixEffect);
    }

    @Override // com.tencent.tavkit.component.effectchain.IVideoEffectContext
    public TAVVideoEffect getGlobalVideoEffect() {
        return this.globalVideoEffectProxy;
    }

    @Override // com.tencent.tavkit.component.effectchain.IVideoEffectContext
    public TAVVideoEffect getSourceVideoEffect() {
        return this.sourceVideoEffectProxy;
    }

    @Override // com.tencent.tavkit.component.effectchain.IVideoEffectContext
    public TAVVideoMixEffect getVideoMixEffect() {
        return this.videoMixEffectProxy;
    }

    public void removeGlobalFilter(TAVVideoEffect tAVVideoEffect) {
        this.globalVideoEffectProxy.getEffects().remove(tAVVideoEffect);
        this.globalVideoEffectProxy.notifyOnEffectRemove();
    }

    public void removeSourceFilter(TAVVideoEffect tAVVideoEffect) {
        this.sourceVideoEffectProxy.getEffects().remove(tAVVideoEffect);
        this.sourceVideoEffectProxy.notifyOnEffectRemove();
    }

    public void removeVideoMixFilter(TAVVideoMixEffect tAVVideoMixEffect) {
        this.videoMixEffectProxy.getEffects().remove(tAVVideoMixEffect);
        this.videoMixEffectProxy.notifyOnEffectRemove();
    }
}
