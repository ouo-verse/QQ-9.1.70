package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class Animator implements Cloneable {
    ArrayList<AnimatorListener> mListeners = null;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface AnimatorListener {
        void onAnimationCancel(Animator animator);

        void onAnimationEnd(Animator animator);

        void onAnimationRepeat(Animator animator);

        void onAnimationStart(Animator animator);
    }

    public void addListener(AnimatorListener animatorListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(animatorListener);
    }

    public abstract long getDuration();

    public ArrayList<AnimatorListener> getListeners() {
        return this.mListeners;
    }

    public abstract long getStartDelay();

    public abstract boolean isRunning();

    public boolean isStarted() {
        return isRunning();
    }

    public void removeAllListeners() {
        ArrayList<AnimatorListener> arrayList = this.mListeners;
        if (arrayList != null) {
            arrayList.clear();
            this.mListeners = null;
        }
    }

    public void removeListener(AnimatorListener animatorListener) {
        ArrayList<AnimatorListener> arrayList = this.mListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
    }

    public abstract Animator setDuration(long j3);

    public abstract void setInterpolator(Interpolator interpolator);

    public abstract void setStartDelay(long j3);

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Animator m71clone() {
        try {
            Animator animator = (Animator) super.clone();
            ArrayList<AnimatorListener> arrayList = this.mListeners;
            if (arrayList != null) {
                animator.mListeners = new ArrayList<>();
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    animator.mListeners.add(arrayList.get(i3));
                }
            }
            return animator;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public void cancel() {
    }

    public void end() {
    }

    public void setupEndValues() {
    }

    public void setupStartValues() {
    }

    public void start() {
    }

    public void setTarget(Object obj) {
    }
}
