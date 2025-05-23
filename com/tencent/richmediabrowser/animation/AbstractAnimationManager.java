package com.tencent.richmediabrowser.animation;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class AbstractAnimationManager implements AnimationLister {
    public static final long DEFAULT_ANIMATION_DURING = 350;
    public boolean jumpToPhotoList;
    protected boolean mIsAnimating;
    public boolean isRectAnimation = true;
    protected ArrayList<AnimationLister> listeners = new ArrayList<>();
    protected long animationDuring = 350;

    public void addAnimationListener(AnimationLister animationLister) {
        if (!this.listeners.contains(animationLister)) {
            this.listeners.add(animationLister);
        }
    }

    public long getAnimationDuring() {
        return this.animationDuring;
    }

    public boolean isAnimating() {
        return this.mIsAnimating;
    }

    public boolean isRectAnimation() {
        return this.isRectAnimation;
    }

    public void onDestroy() {
        this.listeners.clear();
        this.mIsAnimating = false;
    }

    public void removeAnimationListener(AnimationLister animationLister) {
        if (this.listeners.contains(animationLister)) {
            this.listeners.remove(animationLister);
        }
    }

    public void resetAnimationDuring() {
        this.animationDuring = 350L;
    }

    public void setAnimationDuring(long j3) {
        this.animationDuring = j3;
    }

    public abstract boolean startEnterAnimation();

    public abstract boolean startExitAnimation();
}
