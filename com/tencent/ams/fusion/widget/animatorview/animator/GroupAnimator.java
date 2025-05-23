package com.tencent.ams.fusion.widget.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GroupAnimator extends Animator {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GroupAnimator";
    private final List<Animator> mAnimatorList;

    public GroupAnimator(AnimatorLayer animatorLayer, Animator... animatorArr) {
        super(animatorLayer);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animatorLayer, (Object) animatorArr);
        } else {
            this.mAnimatorList = new ArrayList();
            addAnimators(animatorArr);
        }
    }

    private void handlerAnimatorList() {
        Collections.sort(this.mAnimatorList, new Comparator<Animator>() { // from class: com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupAnimator.this);
                }
            }

            @Override // java.util.Comparator
            public int compare(Animator animator, Animator animator2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator, (Object) animator2)).intValue();
                }
                if (animator == null) {
                    return -1;
                }
                if (animator2 == null) {
                    return 1;
                }
                return animator.getRenderPriority() - animator2.getRenderPriority();
            }
        });
        if (this.mAnimatorList.size() > 0) {
            for (int i3 = 1; i3 < this.mAnimatorList.size(); i3++) {
                this.mAnimatorList.get(i3).mNeedResetMatrix = false;
            }
        }
    }

    public void addAnimators(Animator... animatorArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animatorArr);
            return;
        }
        if (animatorArr == null) {
            Logger.w(TAG, "can't add null animators");
            return;
        }
        for (Animator animator : animatorArr) {
            if (animator != null) {
                this.mAnimatorList.add(animator);
                animator.assignParent(this);
            }
        }
        handlerAnimatorList();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public void drawAnimationByFrame(Canvas canvas, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, canvas, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        super.drawAnimationByFrame(canvas, j3, false);
        for (int i3 = 0; i3 < this.mAnimatorList.size(); i3++) {
            Animator animator = this.mAnimatorList.get(i3);
            if (i3 == this.mAnimatorList.size() - 1) {
                animator.drawAnimationByFrame(canvas, j3, true);
            } else {
                animator.drawAnimationByFrame(canvas, j3, false);
            }
        }
    }

    public List<Animator> getAnimators() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mAnimatorList;
    }

    public int getChildAnimatorIndex(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator)).intValue();
        }
        if (animator == null) {
            return -1;
        }
        return this.mAnimatorList.indexOf(animator);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    protected void onDrawLayer(Canvas canvas, AnimatorLayer animatorLayer, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, canvas, animatorLayer, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, canvas, animatorLayer, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public Animator setDuration(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Animator) iPatchRedirector.redirect((short) 5, (Object) this, j3);
        }
        for (Animator animator : this.mAnimatorList) {
            if (animator != null && (animator.getDuration() <= 0 || animator.getDuration() > j3)) {
                animator.setDuration(j3);
            }
        }
        return super.setDuration(j3);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public Animator setInterpolator(TimeInterpolator timeInterpolator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Animator) iPatchRedirector.redirect((short) 9, (Object) this, (Object) timeInterpolator);
        }
        Iterator<Animator> it = this.mAnimatorList.iterator();
        while (it.hasNext()) {
            it.next().setInterpolator(timeInterpolator);
        }
        return super.setInterpolator(timeInterpolator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public void setRepeatPlay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.setRepeatPlay();
        for (Animator animator : this.mAnimatorList) {
            if (animator != null) {
                animator.setRepeatPlay();
            }
        }
    }
}
