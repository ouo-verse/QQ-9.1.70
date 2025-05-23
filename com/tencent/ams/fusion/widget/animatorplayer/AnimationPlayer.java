package com.tencent.ams.fusion.widget.animatorplayer;

/* loaded from: classes3.dex */
public interface AnimationPlayer {

    /* loaded from: classes3.dex */
    public interface AnimationClickListener {
        void onAnimationClick(AnimationClickInfo animationClickInfo);
    }

    /* loaded from: classes3.dex */
    public interface AnimationPlayListener {
        void onComplete();

        void onError(AnimationItem animationItem, int i3);

        void onPause();

        void onStart();

        void onStop();
    }

    void clearAnimation();

    void pause();

    void resume();

    void setAnimationClickListener(AnimationClickListener animationClickListener);

    void setAnimationPlayInfo(AnimationPlayInfo animationPlayInfo);

    void setAnimationPlayListener(AnimationPlayListener animationPlayListener);

    void start();

    void stop();
}
