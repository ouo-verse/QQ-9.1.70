package com.tencent.timi.game.team.impl.floating;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.widget.MediumBoldTextView;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamFloatingStateView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private TimiGamePAGView f379458d;

    /* renamed from: e, reason: collision with root package name */
    private AvatarRoundImageView f379459e;

    /* renamed from: f, reason: collision with root package name */
    private TimiGamePAGView f379460f;

    /* renamed from: h, reason: collision with root package name */
    private MediumBoldTextView f379461h;

    /* renamed from: i, reason: collision with root package name */
    private View f379462i;

    /* renamed from: m, reason: collision with root package name */
    private String f379463m;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements hi4.c {
        b() {
        }

        @Override // hi4.c
        public void onLoaded() {
            l.i("Timi_Float", "pag is loaded with init,just play anim");
            TeamFloatingStateView.this.f();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements hi4.c {
        c() {
        }

        @Override // hi4.c
        public void onLoaded() {
            l.i("Timi_Float", "pag is loaded with init,just play anim");
            TeamFloatingStateView.this.g();
        }
    }

    public TeamFloatingStateView(Context context) {
        super(context);
        this.f379463m = "";
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f379458d.setRepeatCount(0);
        this.f379458d.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f379460f.setVisibility(0);
        this.f379460f.setRepeatCount(0);
        this.f379460f.g();
    }

    private void i() {
        j();
        k();
        m();
        l();
        p();
        o();
        n();
    }

    private void j() {
        setClipChildren(false);
        setLayoutParams(new RelativeLayout.LayoutParams((int) ba.dp2px(getContext(), 73.0f), -2));
    }

    private void k() {
        View view = new View(getContext());
        view.setId(R.id.f9294599);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) ba.dp2px(getContext(), 60.0f), (int) ba.dp2px(getContext(), 19.0f));
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
        view.setBackgroundResource(R.drawable.ltc);
        int i3 = Build.VERSION.SDK_INT;
        view.setElevation(8.0f);
        if (i3 >= 28) {
            view.setOutlineSpotShadowColor(Integer.MIN_VALUE);
        }
        addView(view);
    }

    private void l() {
        AvatarRoundImageView avatarRoundImageView = new AvatarRoundImageView(getContext());
        this.f379459e = avatarRoundImageView;
        avatarRoundImageView.setId(R.id.f9292597);
        this.f379459e.setLayoutParams(new ViewGroup.MarginLayoutParams((int) ba.dp2px(getContext(), 32.0f), (int) ba.dp2px(getContext(), 32.0f)));
        int dp2px = (int) ba.dp2px(getContext(), 5.5f);
        this.f379459e.setPadding(dp2px, dp2px, dp2px, dp2px);
        int i3 = Build.VERSION.SDK_INT;
        this.f379459e.setElevation(13.0f);
        if (i3 >= 28) {
            this.f379459e.setOutlineSpotShadowColor(0);
        }
        this.f379459e.setDefaultImage(0);
        this.f379459e.setNeedRound(false);
        this.f379459e.setOnClickListener(null);
        this.f379459e.setNeedDefaultBg(false);
        this.f379459e.setBackgroundDrawable(null);
        addView(this.f379459e);
        this.f379459e.setVisibility(4);
    }

    private void m() {
        PAGComposition Make;
        PAGFile q16;
        TimiGamePAGView timiGamePAGView = new TimiGamePAGView(getContext());
        this.f379458d = timiGamePAGView;
        timiGamePAGView.setId(R.id.f9293598);
        int dp2px = (int) ba.dp2px(getContext(), 32.0f);
        int dp2px2 = (int) ba.dp2px(getContext(), 32.0f);
        this.f379458d.setLayoutParams(new ViewGroup.LayoutParams(dp2px, dp2px2));
        int i3 = Build.VERSION.SDK_INT;
        this.f379458d.setElevation(13.0f);
        if (i3 >= 28) {
            this.f379458d.setOutlineSpotShadowColor(0);
        }
        addView(this.f379458d);
        if (!((hi4.b) mm4.b.b(hi4.b.class)).t() || (Make = PAGComposition.Make(dp2px, dp2px2)) == null || (q16 = q(wn4.a.f445988a.e("https://cdn.yes.qq.com/client_business/tg_smoba_icon.pag", null), 32)) == null) {
            return;
        }
        Make.addLayer(q16);
        this.f379458d.setComposition(Make);
        this.f379458d.setProgress(0.0d);
        this.f379458d.setVisibility(4);
    }

    private void n() {
        View view = new View(getContext());
        this.f379462i = view;
        view.setBackgroundResource(R.drawable.lrj);
        this.f379462i.setVisibility(8);
        int dp2px = (int) ba.dp2px(getContext(), 9.0f);
        int dp2px2 = (int) ba.dp2px(getContext(), 9.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dp2px, dp2px2);
        layoutParams.addRule(6, R.id.f9294599);
        layoutParams.addRule(7, R.id.f9294599);
        layoutParams.rightMargin = (-dp2px) / 2;
        layoutParams.topMargin = (-dp2px2) / 2;
        this.f379462i.setLayoutParams(layoutParams);
        int i3 = Build.VERSION.SDK_INT;
        this.f379462i.setElevation(9.0f);
        if (i3 >= 28) {
            this.f379462i.setOutlineSpotShadowColor(0);
        }
        addView(this.f379462i);
    }

    private void o() {
        PAGComposition Make;
        PAGFile q16;
        int dp2px = (int) ba.dp2px(getContext(), 26.0f);
        int dp2px2 = (int) ba.dp2px(getContext(), 26.0f);
        this.f379460f = new TimiGamePAGView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dp2px, dp2px2);
        layoutParams.addRule(6, R.id.f9294599);
        layoutParams.addRule(7, R.id.f9294599);
        layoutParams.rightMargin = (-dp2px) / 2;
        layoutParams.topMargin = (-dp2px2) / 2;
        this.f379460f.setLayoutParams(layoutParams);
        int i3 = Build.VERSION.SDK_INT;
        this.f379460f.setElevation(12.0f);
        if (i3 >= 28) {
            this.f379460f.setOutlineSpotShadowColor(0);
        }
        this.f379460f.setVisibility(8);
        addView(this.f379460f);
        if (!((hi4.b) mm4.b.b(hi4.b.class)).t() || (Make = PAGComposition.Make(dp2px, dp2px2)) == null || (q16 = q(PagViewMonitor.Load(eh4.a.b().getResources().getAssets(), "pag/tg_red_point.pag"), 26)) == null) {
            return;
        }
        Make.addLayer(q16);
        this.f379460f.setComposition(Make);
    }

    private void p() {
        MediumBoldTextView mediumBoldTextView = new MediumBoldTextView(getContext());
        this.f379461h = mediumBoldTextView;
        mediumBoldTextView.setGravity(17);
        this.f379461h.setVisibility(8);
        this.f379461h.setMaxLines(1);
        this.f379461h.setSingleLine(true);
        this.f379461h.setTextColor(-16777216);
        this.f379461h.setTextSize(10.0f);
        this.f379461h.setIncludeFontPadding(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15, -1);
        layoutParams.addRule(7, R.id.f9294599);
        layoutParams.addRule(5, R.id.f9294599);
        layoutParams.leftMargin = (int) ba.dp2px(getContext(), 17.0f);
        this.f379461h.setLayoutParams(layoutParams);
        int i3 = Build.VERSION.SDK_INT;
        this.f379461h.setElevation(11.0f);
        if (i3 >= 28) {
            this.f379461h.setOutlineSpotShadowColor(0);
        }
        addView(this.f379461h);
    }

    private PAGFile q(PAGFile pAGFile, int i3) {
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
    public void t(String str) {
        this.f379461h.setVisibility(0);
        this.f379461h.setText(str);
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(ba.dp2px(getContext(), 10.0f), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(350L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new AccelerateInterpolator(3.0f));
        this.f379461h.startAnimation(animationSet);
    }

    private void u(String str) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -ba.dp2px(getContext(), 10.0f), 0.0f, 0.0f);
        translateAnimation.setAnimationListener(new a(str));
        translateAnimation.setDuration(350L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new DecelerateInterpolator(3.0f));
        this.f379461h.startAnimation(animationSet);
    }

    public void e() {
        this.f379461h.setAlpha(0.0f);
        ViewPropertyAnimator alpha = this.f379461h.animate().alpha(1.0f);
        alpha.setDuration(400L);
        alpha.start();
    }

    public String h() {
        return this.f379463m;
    }

    public void r() {
        if (!((hi4.b) mm4.b.b(hi4.b.class)).t()) {
            l.i("Timi_Float", "pag is not ready, init pag now");
            ((hi4.b) mm4.b.b(hi4.b.class)).P0(new b());
        } else {
            l.i("Timi_Float", "pag is loaded,just play anim");
            f();
        }
    }

    public void s() {
        if (!((hi4.b) mm4.b.b(hi4.b.class)).t()) {
            l.i("Timi_Float", "pag is not ready, init pag now");
            ((hi4.b) mm4.b.b(hi4.b.class)).P0(new c());
        } else {
            l.i("Timi_Float", "pag is loaded,just play anim");
            g();
        }
    }

    public void setGameId(int i3) {
        if (((ag4.h) mm4.b.b(ag4.h.class)).l1(i3) != null && ((ag4.h) mm4.b.b(ag4.h.class)).l1(i3).team_float_window_icon != null) {
            String str = ((ag4.h) mm4.b.b(ag4.h.class)).l1(i3).team_float_window_icon.get();
            this.f379458d.setVisibility(4);
            this.f379459e.setVisibility(0);
            this.f379459e.setAvatarUrl(str);
        }
    }

    public void setRedPointVisible(int i3) {
        this.f379462i.setVisibility(i3);
        this.f379460f.setVisibility(i3);
    }

    public void setTeamStateWithAnim(String str) {
        if (TextUtils.isEmpty(this.f379463m)) {
            t(str);
        } else {
            u(str);
        }
        this.f379463m = str;
    }

    public void v() {
        this.f379458d.h();
        this.f379458d.setProgress(0.0d);
    }

    public void w() {
        this.f379460f.setVisibility(8);
        this.f379460f.h();
        this.f379460f.setProgress(0.0d);
    }

    public TeamFloatingStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f379463m = "";
        i();
    }

    public TeamFloatingStateView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f379463m = "";
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f379464d;

        a(String str) {
            this.f379464d = str;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            TeamFloatingStateView.this.f379461h.setVisibility(8);
            TeamFloatingStateView.this.t(this.f379464d);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            TeamFloatingStateView.this.f379461h.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
