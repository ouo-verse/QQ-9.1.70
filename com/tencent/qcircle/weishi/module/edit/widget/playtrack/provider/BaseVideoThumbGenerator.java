package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import com.tencent.tav.coremedia.CMTime;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseVideoThumbGenerator {
    protected float mCoverHeight;
    protected float mCoverWidth;
    protected RunnableHandler mGenerateHandler;
    protected VideoThumbListener mVideoThumbListener;

    public abstract void generateCoverByTime(CMTime cMTime);

    public abstract void pause();

    public abstract void release();

    public abstract void resume();

    public void setCoverHeight(float f16) {
        this.mCoverHeight = f16;
    }

    public void setCoverWidth(float f16) {
        this.mCoverWidth = f16;
    }

    public void setGenerateHandler(RunnableHandler runnableHandler) {
        this.mGenerateHandler = runnableHandler;
    }

    public void setVideoThumbListener(VideoThumbListener videoThumbListener) {
        this.mVideoThumbListener = videoThumbListener;
    }
}
