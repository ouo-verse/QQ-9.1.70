package com.tencent.timi.game.team.impl.floating;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.utils.l;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class WaveAvatarRoundView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private TimiGamePAGView f379478d;

    /* renamed from: e, reason: collision with root package name */
    private View f379479e;

    /* renamed from: f, reason: collision with root package name */
    private AvatarRoundImageView f379480f;

    /* renamed from: h, reason: collision with root package name */
    private View f379481h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f379482i;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements hi4.c {
        a() {
        }

        @Override // hi4.c
        public void onLoaded() {
            l.i("Timi_Float", "pag is loaded with init,just play anim");
            WaveAvatarRoundView.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            WaveAvatarRoundView.this.f379478d.setVisibility(0);
        }
    }

    public WaveAvatarRoundView(@NonNull @NotNull Context context) {
        super(context);
        g();
    }

    private void e(View view) {
        view.setAlpha(0.0f);
        ViewPropertyAnimator alpha = view.animate().alpha(1.0f);
        alpha.setDuration(400L);
        alpha.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        PAGComposition Make;
        PAGFile n3;
        if (!((hi4.b) mm4.b.b(hi4.b.class)).t() || this.f379478d.f() || (Make = PAGComposition.Make((int) ba.dp2px(getContext(), 75.0f), (int) ba.dp2px(getContext(), 75.0f))) == null || (n3 = n(wn4.a.f445988a.e("https://cdn.yes.qq.com/client_business/tg_team_wave.pag", null), 75)) == null) {
            return;
        }
        Make.addLayer(n3);
        this.f379478d.setComposition(Make);
        this.f379478d.setRepeatCount(0);
        this.f379478d.b(new d());
        this.f379478d.g();
    }

    private void g() {
        m();
    }

    private void h() {
        int dp2px = (int) ba.dp2px(getContext(), 99.0f);
        int dp2px2 = (int) ba.dp2px(getContext(), 99.0f);
        View view = new View(getContext());
        this.f379479e = view;
        view.setBackgroundResource(R.drawable.o_o);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dp2px, dp2px2);
        layoutParams.addRule(13, -1);
        this.f379479e.setLayoutParams(layoutParams);
        addView(this.f379479e);
    }

    private void i() {
        int dp2px = (int) ba.dp2px(getContext(), 46.0f);
        int dp2px2 = (int) ba.dp2px(getContext(), 46.0f);
        View view = new View(getContext());
        this.f379481h = view;
        view.setBackgroundResource(R.drawable.ltb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dp2px, dp2px2);
        layoutParams.addRule(13, -1);
        this.f379481h.setLayoutParams(layoutParams);
        this.f379481h.setVisibility(8);
        int i3 = Build.VERSION.SDK_INT;
        this.f379481h.setElevation(10.0f);
        if (i3 >= 28) {
            this.f379481h.setOutlineSpotShadowColor(0);
        }
        addView(this.f379481h);
    }

    private void j() {
        AvatarRoundImageView avatarRoundImageView = new AvatarRoundImageView(getContext());
        this.f379480f = avatarRoundImageView;
        avatarRoundImageView.setBackgroundResource(R.drawable.lta);
        int dp2px = (int) ba.dp2px(getContext(), 2.0f);
        this.f379480f.setPadding(dp2px, dp2px, dp2px, dp2px);
        this.f379480f.setId(R.id.f9291596);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) ba.dp2px(getContext(), 50.0f), (int) ba.dp2px(getContext(), 50.0f));
        layoutParams.addRule(13, -1);
        this.f379480f.setElevation(8.0f);
        this.f379480f.setLayoutParams(layoutParams);
        addView(this.f379480f);
    }

    private void k() {
        int dp2px = (int) ba.dp2px(getContext(), 75.0f);
        int dp2px2 = (int) ba.dp2px(getContext(), 75.0f);
        TimiGamePAGView timiGamePAGView = new TimiGamePAGView(getContext());
        this.f379478d = timiGamePAGView;
        timiGamePAGView.setLayoutParams(new ViewGroup.LayoutParams(dp2px, dp2px2));
        addView(this.f379478d);
    }

    private void l() {
        TextView textView = new TextView(getContext());
        this.f379482i = textView;
        textView.setTextSize(14.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(6, R.id.f9291596);
        layoutParams.addRule(14, -1);
        layoutParams.topMargin = (int) ba.dp2px(getContext(), 27.0f);
        this.f379482i.setLayoutParams(layoutParams);
        this.f379482i.setTextColor(-1711276033);
        this.f379482i.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH));
        int i3 = Build.VERSION.SDK_INT;
        this.f379482i.setElevation(10.0f);
        if (i3 >= 28) {
            this.f379482i.setOutlineSpotShadowColor(0);
        }
        addView(this.f379482i);
    }

    private void m() {
        k();
        h();
        j();
        i();
        l();
    }

    private PAGFile n(PAGFile pAGFile, int i3) {
        if (pAGFile == null) {
            return null;
        }
        Matrix totalMatrix = pAGFile.getTotalMatrix();
        float dp2px = (ba.dp2px(getContext(), i3) * 1.0f) / pAGFile.width();
        totalMatrix.setScale(dp2px, dp2px);
        pAGFile.setMatrix(totalMatrix);
        return pAGFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f379478d, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.addListener(new c());
        ofFloat.start();
    }

    private void t() {
        if (this.f379478d.getVisibility() == 8) {
            return;
        }
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(500L);
        animationSet.setAnimationListener(new b());
        this.f379478d.startAnimation(animationSet);
    }

    private void u() {
        VibrationEffect createOneShot;
        try {
            Vibrator vibrator = (Vibrator) getContext().getSystemService("vibrator");
            if (Build.VERSION.SDK_INT >= 26) {
                createOneShot = VibrationEffect.createOneShot(20L, -1);
                vibrator.vibrate(createOneShot);
            } else {
                vibrator.vibrate(20L);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void d() {
        e(this.f379481h);
        e(this.f379482i);
    }

    public void o() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-((int) ba.dp2px(getContext(), 0.5f)), (int) ba.dp2px(getContext(), 0.5f), -((int) ba.dp2px(getContext(), 0.5f)), (int) ba.dp2px(getContext(), 0.5f));
        translateAnimation.setDuration(250L);
        translateAnimation.setInterpolator(new CycleInterpolator(10.0f));
        TranslateAnimation translateAnimation2 = new TranslateAnimation(-((int) ba.dp2px(getContext(), 0.2f)), (int) ba.dp2px(getContext(), 0.2f), (int) ba.dp2px(getContext(), 0.2f), -((int) ba.dp2px(getContext(), 0.2f)));
        translateAnimation2.setDuration(500L);
        translateAnimation2.setInterpolator(new CycleInterpolator(8.0f));
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(translateAnimation2);
        u();
        this.f379480f.startAnimation(animationSet);
    }

    public void p() {
        if (!((hi4.b) mm4.b.b(hi4.b.class)).t()) {
            l.i("Timi_Float", "pag is not ready, init pag now");
            ((hi4.b) mm4.b.b(hi4.b.class)).P0(new a());
        } else {
            l.i("Timi_Float", "pag is loaded,just play anim");
            f();
        }
    }

    public void r(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        if (commonOuterClass$QQUserId != null) {
            this.f379480f.setUserId(commonOuterClass$QQUserId);
        }
    }

    public void s() {
        t();
    }

    public void setAvatarClickListener(View.OnClickListener onClickListener) {
        this.f379480f.setClickJumpPersonalPage(true);
        this.f379480f.t(onClickListener);
    }

    public void setTeamCountText(CharSequence charSequence) {
        this.f379482i.setText(charSequence);
    }

    public void setTeamCountVisible(int i3) {
        this.f379482i.setVisibility(i3);
        this.f379481h.setVisibility(i3);
    }

    public WaveAvatarRoundView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public WaveAvatarRoundView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            WaveAvatarRoundView.this.f379478d.setVisibility(8);
            WaveAvatarRoundView.this.f379478d.h();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements PAGView.PAGViewListener {
        d() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView pAGView) {
            WaveAvatarRoundView.this.f379478d.setVisibility(8);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView pAGView) {
            WaveAvatarRoundView.this.f379478d.setVisibility(8);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView pAGView) {
            WaveAvatarRoundView.this.q();
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView pAGView) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView pAGView) {
        }
    }
}
