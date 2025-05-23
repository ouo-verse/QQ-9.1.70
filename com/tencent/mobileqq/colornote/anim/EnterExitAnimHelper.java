package com.tencent.mobileqq.colornote.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.f;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EnterExitAnimHelper {

    /* renamed from: a, reason: collision with root package name */
    private View f201334a;

    /* renamed from: b, reason: collision with root package name */
    private AnimatorSet f201335b = new AnimatorSet();

    /* renamed from: c, reason: collision with root package name */
    private float f201336c;

    /* renamed from: d, reason: collision with root package name */
    private float f201337d;

    public EnterExitAnimHelper(View view) {
        this.f201334a = view;
    }

    private void c() {
        this.f201334a.setPivotX(this.f201336c);
        this.f201334a.setPivotY(this.f201337d);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f201334a, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f201334a, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f);
        AnimatorSet animatorSet = this.f201335b;
        if (animatorSet != null) {
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.f201335b.setDuration(500L);
        }
    }

    public void a(final ha1.a aVar, final boolean z16, int i3) {
        if (this.f201335b != null) {
            Animator a16 = d.a(this.f201334a, ((int) this.f201336c) + i3, (int) this.f201337d, r0.getHeight() / 2, 1.0f);
            a16.addListener(new f() { // from class: com.tencent.mobileqq.colornote.anim.EnterExitAnimHelper.1
                @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(final Animator animator) {
                    ha1.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onColorNoteAnimFinish();
                    }
                    if (z16 && (animator instanceof a)) {
                        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.colornote.anim.EnterExitAnimHelper.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((a) animator).a();
                            }
                        }, 200L);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            a16.setDuration(300L);
            a16.start();
        }
    }

    public void b() {
        c();
    }

    public void d(float f16, float f17) {
        this.f201336c = f16;
        this.f201337d = f17;
    }
}
