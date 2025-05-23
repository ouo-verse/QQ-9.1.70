package com.tencent.gdtad.basics.adshake.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GroupAnimator extends Animator {
    private static final String TAG = "GroupAnimator";
    private final List<Animator> mAnimatorList;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements Comparator<Animator> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Animator animator, Animator animator2) {
            if (animator == null) {
                return -1;
            }
            if (animator2 == null) {
                return 1;
            }
            return animator.getRenderPriority() - animator2.getRenderPriority();
        }
    }

    public GroupAnimator(AnimatorLayer animatorLayer, Animator... animatorArr) {
        super(animatorLayer);
        this.mAnimatorList = new ArrayList();
        addAnimators(animatorArr);
    }

    private void handlerAnimatorList() {
        Collections.sort(this.mAnimatorList, new a());
        if (this.mAnimatorList.size() > 0) {
            for (int i3 = 1; i3 < this.mAnimatorList.size(); i3++) {
                this.mAnimatorList.get(i3).mNeedResetMatrix = false;
            }
        }
    }

    public void addAnimators(Animator... animatorArr) {
        if (animatorArr == null) {
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

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    public void drawAnimationByFrame(Canvas canvas, long j3, boolean z16, boolean z17) {
        super.drawAnimationByFrame(canvas, j3, z16, false);
        for (int i3 = 0; i3 < this.mAnimatorList.size(); i3++) {
            Animator animator = this.mAnimatorList.get(i3);
            if (i3 == this.mAnimatorList.size() - 1) {
                animator.drawAnimationByFrame(canvas, j3, z16, true);
            } else {
                animator.drawAnimationByFrame(canvas, j3, z16, false);
            }
        }
    }

    public List<Animator> getAnimators() {
        return this.mAnimatorList;
    }

    public int getChildAnimatorIndex(Animator animator) {
        if (animator == null) {
            return -1;
        }
        return this.mAnimatorList.indexOf(animator);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    public Animator setDuration(long j3) {
        for (Animator animator : this.mAnimatorList) {
            if (animator != null && (animator.getDuration() <= 0 || animator.getDuration() > j3)) {
                animator.setDuration(j3);
            }
        }
        return super.setDuration(j3);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    public Animator setInterpolator(TimeInterpolator timeInterpolator) {
        Iterator<Animator> it = this.mAnimatorList.iterator();
        while (it.hasNext()) {
            it.next().setInterpolator(timeInterpolator);
        }
        return super.setInterpolator(timeInterpolator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    public void setRepeatPlay() {
        super.setRepeatPlay();
        for (Animator animator : this.mAnimatorList) {
            if (animator != null) {
                animator.setRepeatPlay();
            }
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    protected void onDrawLayer(Canvas canvas, AnimatorLayer animatorLayer, boolean z16, boolean z17) {
    }
}
