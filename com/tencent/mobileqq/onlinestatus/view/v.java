package com.tencent.mobileqq.onlinestatus.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class v extends ReportDialog implements Animator.AnimatorListener {
    protected View C;
    protected View D;
    protected float E;
    protected float F;
    private int[] G;
    protected AnimatorSet H;
    protected a I;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void G0(AppRuntime.Status status, long j3);

        void L0(AppRuntime.Status status, int i3);
    }

    public v(@NonNull Context context, a aVar) {
        super(context, R.style.MenuDialogStyle);
        this.E = 0.5f;
        this.F = 0.5f;
        this.G = new int[2];
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        if (window != null) {
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                window.addFlags(67108864);
            }
            ImmersiveUtils.clearCoverForStatus(window, true);
        }
        this.I = aVar;
    }

    public void P() {
        O();
        super.dismiss();
        N();
    }

    protected void Q(boolean z16) {
        float f16;
        float f17;
        float f18;
        float f19 = 1.0f;
        if (z16) {
            f16 = 0.3f;
        } else {
            f16 = 1.0f;
        }
        if (z16) {
            f17 = 1.0f;
        } else {
            f17 = 0.0f;
        }
        if (z16) {
            f18 = 0.5f;
        } else {
            f18 = 1.0f;
        }
        if (!z16) {
            f19 = 0.0f;
        }
        this.H.play(ObjectAnimator.ofFloat(this.D, BasicAnimation.KeyPath.SCALE_X, f16, f17)).with(ObjectAnimator.ofFloat(this.D, BasicAnimation.KeyPath.SCALE_Y, f16, f17)).with(ObjectAnimator.ofFloat(this.C, com.tencent.luggage.wxa.c8.c.f123400v, f18, f19));
        this.H.setDuration(300L);
        this.H.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    protected abstract void R(int[] iArr);

    public void U(float[] fArr) {
        if (fArr != null && fArr.length == 2) {
            this.E = fArr[0];
            this.F = fArr[1];
        }
    }

    public void W() {
        show();
    }

    public boolean X(boolean z16) {
        if (this.D == null || this.C == null) {
            return false;
        }
        R(this.G);
        this.D.setPivotX(this.E * this.G[0]);
        this.D.setPivotY(this.F * this.G[1]);
        this.H = new AnimatorSet();
        Q(z16);
        if (!z16) {
            this.H.addListener(this);
        }
        this.H.start();
        return true;
    }

    public void Y(TextView textView) {
        Z(textView, R.color.f157041i8, R.color.f157983ai2);
    }

    public void Z(TextView textView, int i3, int i16) {
        if (!QQTheme.isNowThemeIsNight()) {
            i3 = i16;
        }
        textView.setTextColor(textView.getResources().getColor(i3));
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        O();
        if (!X(false)) {
            super.dismiss();
            N();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        super.dismiss();
        N();
        animator.removeListener(this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z16) {
        onAnimationEnd(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        com.tencent.mobileqq.theme.a.d(getWindow());
        super.show();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.dismiss();
        N();
        animator.removeListener(this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z16) {
        onAnimationStart(animator);
    }

    protected void N() {
    }

    protected void O() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    public void S(int i3, int i16, Intent intent) {
    }
}
