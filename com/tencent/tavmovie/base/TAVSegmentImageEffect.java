package com.tencent.tavmovie.base;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVSegmentImageEffect extends TAVSegmentEffect implements Cloneable {
    protected String effectID;
    protected String name;

    public String getEffectID() {
        return this.effectID;
    }

    public String getName() {
        return this.name;
    }

    public void setEffectID(String str) {
        this.effectID = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVSegmentImageEffect m278clone() {
        TAVSegmentImageEffect tAVSegmentImageEffect = new TAVSegmentImageEffect();
        tAVSegmentImageEffect.timeRange = this.timeRange.m260clone();
        tAVSegmentImageEffect.effectID = this.effectID;
        tAVSegmentImageEffect.name = this.name;
        return tAVSegmentImageEffect;
    }
}
