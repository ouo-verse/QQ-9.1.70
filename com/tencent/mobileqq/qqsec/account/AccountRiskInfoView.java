package com.tencent.mobileqq.qqsec.account;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AccountRiskInfoView extends LinearLayout implements View.OnClickListener, com.tencent.mobileqq.widget.listitem.q, com.tencent.mobileqq.widget.listitem.l {
    static IPatchRedirector $redirector_;
    private ImageView C;
    private int D;
    private final LottieDrawable[] E;
    private boolean F;
    private boolean G;
    private View.OnClickListener H;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f274354d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f274355e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f274356f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f274357h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f274358i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f274359m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements LottieHelper.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f274360a;

        a(int i3) {
            this.f274360a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountRiskInfoView.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieDrawable);
            } else {
                AccountRiskInfoView.this.E[this.f274360a] = lottieDrawable;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountRiskInfoView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                AccountRiskInfoView.this.n();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountRiskInfoView.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                AccountRiskInfoView.this.l(1);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class d implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f274364d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f274365e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f274366f;

        d(boolean z16, String str, int i3) {
            this.f274364d = z16;
            this.f274365e = str;
            this.f274366f = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AccountRiskInfoView.this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                AccountRiskInfoView.this.l(2);
                AccountRiskInfoView.this.p(this.f274364d, this.f274365e);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            } else if (AccountRiskInfoView.this.E != null && this.f274366f < AccountRiskInfoView.this.E.length && AccountRiskInfoView.this.E[this.f274366f] != null) {
                AccountRiskInfoView.this.E[this.f274366f].endAnimation();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class e implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountRiskInfoView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                AccountRiskInfoView.this.f274359m.setVisibility(4);
                AccountRiskInfoView.this.f274359m.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class f implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountRiskInfoView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                AccountRiskInfoView.this.f274357h.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    public AccountRiskInfoView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f274354d = null;
        this.f274355e = null;
        this.f274356f = null;
        this.f274357h = null;
        this.f274358i = null;
        this.f274359m = null;
        this.C = null;
        this.D = 2;
        this.E = new LottieDrawable[3];
        this.F = false;
        this.G = false;
        j();
    }

    private Drawable g(Boolean bool) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (bool.booleanValue()) {
            gradientDrawable.setColor(getContext().getColorStateList(R.color.qui_common_feedback_normal));
        } else {
            gradientDrawable.setColor(getContext().getColorStateList(R.color.qui_common_feedback_error));
        }
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(88.0f));
        return gradientDrawable;
    }

    private Drawable h(Boolean bool) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (bool.booleanValue()) {
            gradientDrawable.setColor(getContext().getColorStateList(R.color.qui_common_feedback_normal));
        } else {
            gradientDrawable.setColor(getContext().getColorStateList(R.color.qui_common_feedback_error));
        }
        if (QQTheme.isNowThemeIsNight()) {
            gradientDrawable.setAlpha(64);
        } else {
            gradientDrawable.setAlpha(26);
        }
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(110.0f));
        return gradientDrawable;
    }

    private void i() {
        String[] strArr = {"phase_0.json", "phase_1.json", "phase_2.json"};
        if (QQTheme.isNowThemeIsNight()) {
            strArr = new String[]{"phase_0_night.json", "phase_1_night.json", "phase_2_night.json"};
        }
        int[] iArr = {0, -1, 0};
        for (int i3 = 0; i3 < this.E.length; i3++) {
            LottieHelper.b(getContext(), "login_info/" + strArr[i3], "login_info/" + LottieLoader.FILE_IMAGES, 110, 110, iArr[i3], new a(i3));
        }
    }

    private void j() {
        LayoutInflater.from(getContext()).inflate(R.layout.f168775gv2, this);
        setOrientation(1);
        this.f274354d = (ImageView) findViewById(R.id.f75083y0);
        this.f274355e = (ImageView) findViewById(R.id.f74953xn);
        this.f274356f = (ImageView) findViewById(R.id.f75053xx);
        this.f274357h = (ImageView) findViewById(R.id.f75063xy);
        ImageView imageView = this.f274355e;
        Boolean bool = Boolean.TRUE;
        imageView.setImageDrawable(g(bool));
        this.f274356f.setImageDrawable(h(bool));
        i();
        this.f274358i = (TextView) findViewById(R.id.ib9);
        this.f274359m = (TextView) findViewById(R.id.f75073xz);
        ImageView imageView2 = (ImageView) findViewById(R.id.iav);
        this.C = imageView2;
        if (AppSetting.f99565y) {
            imageView2.setContentDescription(getContext().getString(R.string.g37));
        }
        this.f274358i.setClickable(false);
        this.f274358i.setOnClickListener(this);
        this.C.setClickable(false);
        this.C.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i3) {
        LottieDrawable[] lottieDrawableArr;
        LottieDrawable lottieDrawable;
        QLog.d("AccountRiskInfoView", 2, "playScanningLottieDrawable phase = " + i3 + ", curLottiePhase = " + this.D);
        if (i3 == this.D) {
            QLog.e("AccountRiskInfoView", 1, "playScanningLottieDrawable phase == curLottiePhase!");
            return;
        }
        this.D = i3;
        ImageView imageView = this.f274357h;
        if (imageView != null && (lottieDrawableArr = this.E) != null && i3 < lottieDrawableArr.length && (lottieDrawable = lottieDrawableArr[i3]) != null) {
            imageView.setImageDrawable(lottieDrawable);
            this.E[i3].playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f274356f.setVisibility(4);
        this.f274355e.setVisibility(4);
        this.f274354d.setVisibility(4);
        this.f274357h.setVisibility(0);
        LottieDrawable[] lottieDrawableArr = this.E;
        if (lottieDrawableArr != null && lottieDrawableArr.length > 0 && lottieDrawableArr[0] != null) {
            l(0);
            this.E[0].removeAllAnimatorListeners();
            this.E[0].addAnimatorListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z16, String str) {
        AnimationSet animationSet = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 2, 0.0f, 2, 1.0f);
        translateAnimation.setDuration(300L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        this.f274359m.startAnimation(animationSet);
        animationSet.setAnimationListener(new e());
        this.f274358i.setVisibility(0);
        this.f274358i.setText(str);
        if (AppSetting.f99565y) {
            this.f274358i.setContentDescription(str);
        }
        AnimationSet animationSet2 = new AnimationSet(false);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 2, -1.0f, 2, 0.0f);
        translateAnimation2.setDuration(300L);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setDuration(300L);
        animationSet2.addAnimation(translateAnimation2);
        animationSet2.addAnimation(alphaAnimation2);
        this.f274358i.startAnimation(animationSet2);
        this.f274358i.setClickable(!z16);
        if (!z16) {
            this.C.setVisibility(0);
            this.C.startAnimation(animationSet2);
        } else {
            this.C.setVisibility(8);
        }
        AnimationSet animationSet3 = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        alphaAnimation2.setDuration(300L);
        animationSet3.addAnimation(scaleAnimation);
        animationSet3.addAnimation(alphaAnimation2);
        q(z16);
        this.f274357h.clearAnimation();
        this.f274357h.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new f());
        this.f274354d.setVisibility(0);
        this.f274354d.startAnimation(animationSet3);
        this.f274355e.setVisibility(0);
        this.f274355e.startAnimation(animationSet3);
        this.f274356f.setVisibility(0);
        this.f274356f.startAnimation(alphaAnimation2);
        this.F = false;
        this.G = false;
    }

    private void q(boolean z16) {
        int i3;
        this.f274356f.setImageDrawable(h(Boolean.valueOf(z16)));
        this.f274355e.setImageDrawable(g(Boolean.valueOf(z16)));
        if (z16) {
            i3 = R.drawable.ong;
        } else {
            i3 = R.drawable.onf;
        }
        this.f274354d.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), i3, null));
    }

    @Override // android.view.View
    public void clearAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.clearAnimation();
        LottieDrawable[] lottieDrawableArr = this.E;
        if (lottieDrawableArr != null) {
            for (LottieDrawable lottieDrawable : lottieDrawableArr) {
                if (lottieDrawable != null) {
                    lottieDrawable.removeAllAnimatorListeners();
                    lottieDrawable.cancelAnimation();
                }
            }
        }
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!this.F && !this.G) {
            return false;
        }
        return true;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.F) {
            return;
        }
        this.F = true;
        this.G = false;
        this.f274359m.setVisibility(0);
        this.f274358i.setVisibility(4);
        this.C.setVisibility(4);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f));
        animationSet.setDuration(300L);
        animationSet.setAnimationListener(new b());
        this.f274354d.setVisibility(0);
        this.f274354d.startAnimation(animationSet);
        this.f274355e.startAnimation(animationSet);
    }

    public void o(boolean z16, String str) {
        LottieDrawable lottieDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str);
            return;
        }
        if (!this.F) {
            return;
        }
        this.G = true;
        int i3 = this.D;
        QLog.d("AccountRiskInfoView", 4, "scanning lottie phase = " + i3 + ", curLottiePhase = " + this.D);
        if (i3 == 2) {
            QLog.e("AccountRiskInfoView", 1, "playStopScanningAnimPhase1 phase == SCANNING_END!");
            return;
        }
        LottieDrawable[] lottieDrawableArr = this.E;
        if (lottieDrawableArr != null && i3 < lottieDrawableArr.length && (lottieDrawable = lottieDrawableArr[i3]) != null) {
            lottieDrawable.removeAllAnimatorListeners();
            this.E[i3].addAnimatorListener(new d(z16, str, i3));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            View.OnClickListener onClickListener = this.H;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.widget.listitem.l
    public void setBackgroundType(@NonNull QUIListItemBackgroundType qUIListItemBackgroundType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) qUIListItemBackgroundType);
        }
    }

    public void setOnRiskClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onClickListener);
        } else {
            this.H = onClickListener;
        }
    }

    @Override // com.tencent.mobileqq.widget.listitem.q
    public void setStyle(@NonNull QUIListItemStyle qUIListItemStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) qUIListItemStyle);
        }
    }

    public AccountRiskInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f274354d = null;
        this.f274355e = null;
        this.f274356f = null;
        this.f274357h = null;
        this.f274358i = null;
        this.f274359m = null;
        this.C = null;
        this.D = 2;
        this.E = new LottieDrawable[3];
        this.F = false;
        this.G = false;
        j();
    }
}
