package com.tencent.ams.fusion.widget.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SequentialAnimator extends Animator {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SequentialAnimator";
    private final ArrayList<Animator> mAnimatorList;
    private Animator mLastAnimator;

    public SequentialAnimator(AnimatorLayer animatorLayer) {
        super(animatorLayer);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mAnimatorList = new ArrayList<>();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animatorLayer);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
        } else if (checkAnimator(animator)) {
            this.mAnimatorList.add(animator);
            animator.assignParent(this);
            this.mLastAnimator = animator;
        }
    }

    public void addAnimators(Animator... animatorArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animatorArr);
            return;
        }
        if (animatorArr == null) {
            Logger.w(TAG, "can't add null animators");
            return;
        }
        for (Animator animator : animatorArr) {
            addAnimator(animator);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public void drawAnimationByFrame(Canvas canvas, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, canvas, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        super.drawAnimationByFrame(canvas, j3, z16);
        Iterator<Animator> it = this.mAnimatorList.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (next != null && !next.isFinish()) {
                next.drawAnimationByFrame(canvas, j3, z16);
                return;
            }
        }
        Animator animator = this.mLastAnimator;
        if (animator != null) {
            animator.drawAnimationByFrame(canvas, j3, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public void drawCanvas(Canvas canvas, AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas, (Object) animatorLayer);
        } else {
            super.drawCanvas(canvas, animatorLayer);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public long getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
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

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    protected void onDrawLayer(Canvas canvas, AnimatorLayer animatorLayer, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, canvas, animatorLayer, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, canvas, animatorLayer, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.reset();
        Iterator<Animator> it = this.mAnimatorList.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public Animator setDuration(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Animator) iPatchRedirector.redirect((short) 11, (Object) this, j3);
        }
        return this;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public Animator setInterpolator(TimeInterpolator timeInterpolator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Animator) iPatchRedirector.redirect((short) 13, (Object) this, (Object) timeInterpolator);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public void setRepeatPlay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.setRepeatPlay();
        Iterator<Animator> it = this.mAnimatorList.iterator();
        while (it.hasNext()) {
            it.next().setRepeatPlay();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public void setStartTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animatorLayer, (Object) animatorArr);
            return;
        }
        this.mAnimatorList = new ArrayList<>();
        for (Animator animator : animatorArr) {
            addAnimator(animator);
        }
    }
}
