package com.tencent.tavmovie.base;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.component.TAVTimeEffect;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVMovieTimeEffect implements Cloneable {
    private int loop;
    private CMTimeRange sourceTimeRange;
    private float speed;
    private CMTimeRange timeRange;

    public TAVMovieTimeEffect() {
        CMTime cMTime = CMTime.CMTimeZero;
        this.timeRange = new CMTimeRange(cMTime, cMTime);
        this.loop = 1;
        this.speed = 1.0f;
    }

    public CMTime calculateSourceDuration() {
        CMTimeRange cMTimeRange = this.sourceTimeRange;
        if (cMTimeRange != null) {
            return cMTimeRange.getDuration();
        }
        return CMTime.CMTimeZero;
    }

    public TAVTimeEffect convertToTimeEffect() {
        TAVTimeEffect tAVTimeEffect = new TAVTimeEffect();
        tAVTimeEffect.setLoopCount(this.loop);
        tAVTimeEffect.setTimeRange(this.timeRange);
        if (Math.abs(this.speed - 0.0f) < 1.0E-4f) {
            tAVTimeEffect.setFreeze(true);
        } else {
            if (this.speed < 0.0f) {
                tAVTimeEffect.setReverse(true);
            }
            tAVTimeEffect.setScaledDuration(this.timeRange.getDuration().divide(this.speed));
        }
        return tAVTimeEffect;
    }

    public int getLoop() {
        return this.loop;
    }

    public CMTimeRange getSourceTimeRange() {
        return this.sourceTimeRange;
    }

    public float getSpeed() {
        return this.speed;
    }

    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    public void setLoop(int i3) {
        this.loop = i3;
    }

    public void setSourceTimeRange(CMTimeRange cMTimeRange) {
        this.sourceTimeRange = cMTimeRange;
    }

    public void setSpeed(float f16) {
        this.speed = f16;
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVMovieTimeEffect m276clone() {
        TAVMovieTimeEffect tAVMovieTimeEffect = new TAVMovieTimeEffect();
        tAVMovieTimeEffect.sourceTimeRange = this.sourceTimeRange;
        tAVMovieTimeEffect.timeRange = this.timeRange;
        tAVMovieTimeEffect.loop = this.loop;
        tAVMovieTimeEffect.speed = this.speed;
        return tAVMovieTimeEffect;
    }
}
