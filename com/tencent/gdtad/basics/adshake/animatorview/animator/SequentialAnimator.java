package com.tencent.gdtad.basics.adshake.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes6.dex */
public class SequentialAnimator extends Animator {
    private static final String TAG = "SequentialAnimator";
    private final ArrayList<Animator> mAnimatorList;
    private Animator mLastAnimator;

    public SequentialAnimator(AnimatorLayer animatorLayer) {
        super(animatorLayer);
        this.mAnimatorList = new ArrayList<>();
    }

    private boolean checkAnimator(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator.getRepeatCount() != 0) {
            return true;
        }
        throw new IllegalArgumentException("\u5b50\u52a8\u753b\u4e0d\u5141\u8bb8\u662f\u4e00\u76f4\u91cd\u590d\u7684\u52a8\u753b\uff0c\u5426\u5219\u4f1a\u5f71\u54cd\u540e\u7eed\u5b50\u52a8\u753b\u7684\u6267\u884c\uff01");
    }

    public void addAnimator(Animator animator) {
        if (checkAnimator(animator)) {
            this.mAnimatorList.add(animator);
            animator.assignParent(this);
            this.mLastAnimator = animator;
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    public void drawAnimationByFrame(Canvas canvas, long j3, boolean z16, boolean z17) {
        super.drawAnimationByFrame(canvas, j3, z16, z17);
        Iterator<Animator> it = this.mAnimatorList.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (next != null && !next.isFinish()) {
                next.drawAnimationByFrame(canvas, j3, z16, z17);
                return;
            }
        }
        Animator animator = this.mLastAnimator;
        if (animator != null) {
            animator.drawAnimationByFrame(canvas, j3, z16, z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    public void drawCanvas(Canvas canvas, AnimatorLayer animatorLayer) {
        super.drawCanvas(canvas, animatorLayer);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    public long getDuration() {
        if (this.mDuration == 0) {
            Iterator<Animator> it = this.mAnimatorList.iterator();
            while (it.hasNext()) {
                Animator next = it.next();
                if (next != null) {
                    this.mDuration += (next.getDuration() + next.getRepeatInterval()) * next.getRepeatCount();
                }
            }
        }
        return this.mDuration;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    public void reset() {
        super.reset();
        Iterator<Animator> it = this.mAnimatorList.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    public void setRepeatPlay() {
        super.setRepeatPlay();
        Iterator<Animator> it = this.mAnimatorList.iterator();
        while (it.hasNext()) {
            it.next().setRepeatPlay();
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    public void setStartTime(long j3) {
        super.setStartTime(j3);
        long startTime = getStartTime();
        Iterator<Animator> it = this.mAnimatorList.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (next != null) {
                next.setStartTime(startTime);
                startTime += next.getDuration();
            }
        }
    }

    public SequentialAnimator(AnimatorLayer animatorLayer, Animator... animatorArr) {
        super(animatorLayer);
        this.mAnimatorList = new ArrayList<>();
        for (Animator animator : animatorArr) {
            addAnimator(animator);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    public Animator setDuration(long j3) {
        return this;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    public Animator setInterpolator(TimeInterpolator timeInterpolator) {
        return this;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    protected void onDrawLayer(Canvas canvas, AnimatorLayer animatorLayer, boolean z16, boolean z17) {
    }
}
