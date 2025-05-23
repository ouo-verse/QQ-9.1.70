package com.tencent.tavmovie.base;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVSegmentTimeEffect extends TAVSegmentEffect implements Cloneable {
    protected int loop;
    protected float speed;

    public int getLoop() {
        return this.loop;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setLoop(int i3) {
        this.loop = i3;
    }

    public void setSpeed(float f16) {
        this.speed = f16;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVSegmentTimeEffect m279clone() {
        TAVSegmentTimeEffect tAVSegmentTimeEffect = new TAVSegmentTimeEffect();
        tAVSegmentTimeEffect.timeRange = this.timeRange.m260clone();
        tAVSegmentTimeEffect.loop = this.loop;
        tAVSegmentTimeEffect.speed = this.speed;
        return tAVSegmentTimeEffect;
    }
}
