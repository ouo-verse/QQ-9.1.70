package com.tencent.tavmovie.filter;

import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.report.IReportable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVMovieFilterChainContext implements TAVVideoEffect {
    private List<TAVVideoEffect> videoEffects = new ArrayList();
    protected String reportKey = "TAVMovieFilterChainContext";

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private class MyCompositionEffect implements TAVVideoEffect.Filter, IReportable {
        private final List<TAVVideoEffect.Filter> effects;

        @Override // com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
        public CIImage apply(TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo) {
            Iterator<TAVVideoEffect.Filter> it = this.effects.iterator();
            while (it.hasNext()) {
                cIImage = it.next().apply(tAVVideoEffect, cIImage, renderInfo);
            }
            return cIImage;
        }

        @Override // com.tencent.tavkit.report.IReportable
        public String getReportKey() {
            return TAVMovieFilterChainContext.this.reportKey;
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            Iterator<TAVVideoEffect.Filter> it = this.effects.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
        }

        MyCompositionEffect(List<TAVVideoEffect> list) {
            this.effects = new ArrayList();
            Iterator<TAVVideoEffect> it = list.iterator();
            while (it.hasNext()) {
                this.effects.add(it.next().createFilter());
            }
        }
    }

    public void addFilter(TAVVideoEffect tAVVideoEffect) {
        this.videoEffects.add(tAVVideoEffect);
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    public TAVVideoEffect.Filter createFilter() {
        return new MyCompositionEffect(this.videoEffects);
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    public String effectId() {
        return "TAVMovieFilterChainContext";
    }

    public List<TAVVideoEffect> getVideoEffects() {
        return this.videoEffects;
    }

    public void setReportKey(String str) {
        this.reportKey = str;
    }
}
