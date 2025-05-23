package com.tencent.mobileqq.onlinestatus.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class BaseStatusCardViewFragment extends QPublicBaseFragment implements Animator.AnimatorListener, OnLineStatusBlurBg.b {
    protected View C;
    protected View D;
    protected AnimatorSet H;
    protected a J;
    protected final QBaseActivity K;
    private long L;
    protected float E = 0.5f;
    protected float F = 0.5f;
    private final int[] G = new int[2];
    public int I = 0;
    protected OnLineStatusBlurBg.a M = null;
    protected OnLineStatusBlurBg N = null;
    public int P = R.id.zxc;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void G0(AppRuntime.Status status, long j3);

        void L0(AppRuntime.Status status, int i3);
    }

    public BaseStatusCardViewFragment(@NonNull QBaseActivity qBaseActivity, a aVar) {
        this.K = qBaseActivity;
        this.J = aVar;
    }

    protected abstract void Ah(View view, int[] iArr);

    public void Bh(float[] fArr) {
        if (fArr != null && fArr.length == 2) {
            this.E = fArr[0];
            this.F = fArr[1];
        }
    }

    public void Ch(OnLineStatusBlurBg.a aVar) {
        this.M = aVar;
    }

    public void Dh(int i3) {
        this.P = i3;
    }

    public void Eh() {
        show();
    }

    public void Fh() {
        QBaseActivity qBaseActivity = this.K;
        if (qBaseActivity == null) {
            return;
        }
        try {
            FragmentManager supportFragmentManager = qBaseActivity.getSupportFragmentManager();
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(yh());
            if (findFragmentByTag == null && !isAdded()) {
                supportFragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
                supportFragmentManager.beginTransaction().add(this.P, this, yh()).addToBackStack(yh()).commitAllowingStateLoss();
            } else if (findFragmentByTag != null && !findFragmentByTag.isVisible()) {
                this.K.getSupportFragmentManager().beginTransaction().show(this).commitAllowingStateLoss();
            }
        } catch (Exception e16) {
            QLog.e(QPublicBaseFragment.TAG, 1, "show ", e16);
        }
    }

    public boolean Gh(boolean z16) {
        View vh5 = vh();
        if (this.D == null || this.C == null || vh5 == null) {
            return false;
        }
        Ah(vh5, this.G);
        if (this.I != 0) {
            vh5.setPivotX((this.E * vh5.getResources().getDisplayMetrics().widthPixels) - ViewUtils.dip2px(40.0f));
            vh5.setPivotY((float) (((this.F - 0.5d) * vh5.getResources().getDisplayMetrics().heightPixels) + (xh() / 2)));
        } else {
            vh5.setPivotX(this.E * this.G[0]);
            vh5.setPivotY(this.F * this.G[1]);
        }
        this.H = new AnimatorSet();
        zh(vh5, z16);
        if (!z16) {
            this.H.addListener(this);
        }
        this.H.start();
        return true;
    }

    public void Hh(TextView textView) {
        Ih(textView, R.color.f157041i8, R.color.f157983ai2);
    }

    public void Ih(TextView textView, int i3, int i16) {
        if (!QQTheme.isNowThemeIsNight()) {
            i3 = i16;
        }
        textView.setTextColor(textView.getResources().getColor(i3));
    }

    public final AppRuntime getAppRuntime() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        th();
        ph();
        animator.removeListener(this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z16) {
        onAnimationEnd(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rh() {
        OnLineStatusBlurBg.a wh5;
        if (this.N == null || (wh5 = wh()) == null) {
            return;
        }
        this.N.i(wh5, this);
    }

    public boolean sh() {
        qh();
        boolean z16 = false;
        if (!Gh(false) && (z16 = th())) {
            ph();
        }
        return z16;
    }

    public void show() {
        if (this.K == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.L < 1000) {
            return;
        }
        this.L = currentTimeMillis;
        if (this.K.findViewById(this.P) == null) {
            return;
        }
        Fh();
        com.tencent.mobileqq.theme.a.d(this.K.getWindow());
    }

    public boolean th() {
        FragmentActivity fragmentActivity = this.K;
        if (fragmentActivity == null && getActivity() != null) {
            fragmentActivity = getActivity();
        }
        if (fragmentActivity == null) {
            return false;
        }
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (supportFragmentManager.isStateSaved() || supportFragmentManager.getBackStackEntryCount() <= 0 || ((BaseStatusCardViewFragment) supportFragmentManager.findFragmentByTag(yh())) == null) {
            return false;
        }
        supportFragmentManager.popBackStack(yh(), 1);
        return true;
    }

    public boolean uh() {
        qh();
        boolean th5 = th();
        if (th5) {
            ph();
        }
        return th5;
    }

    @Override // com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.b
    public void v3(boolean z16, Bitmap bitmap, int i3) {
        View view = this.C;
        if (view == null) {
            return;
        }
        if (z16 && bitmap != null) {
            view.setBackground(new BitmapDrawable(this.C.getResources(), bitmap));
        } else {
            view.setBackgroundColor(i3);
        }
    }

    protected View vh() {
        return this.D;
    }

    protected OnLineStatusBlurBg.a wh() {
        return this.M;
    }

    protected int xh() {
        return 0;
    }

    protected String yh() {
        return getClass().getName();
    }

    protected void zh(View view, boolean z16) {
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
        this.H.play(ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, f16, f17)).with(ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, f16, f17)).with(ObjectAnimator.ofFloat(this.C, com.tencent.luggage.wxa.c8.c.f123400v, f18, f19));
        this.H.setDuration(300L);
        this.H.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        th();
        ph();
        animator.removeListener(this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z16) {
        onAnimationStart(animator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ph() {
    }

    protected void qh() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
    }
}
