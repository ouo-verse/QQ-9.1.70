package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.widget.SquareImageView;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniLoadingUI extends RelativeLayout implements View.OnClickListener {
    private ImageView C;
    private View D;
    private ImageView E;
    private ImageView F;
    private ProgressBar G;
    private View H;
    private MiniAppInfo I;
    private boolean J;
    private RelativeLayout K;
    private RelativeLayout L;
    private LinearLayout M;
    private SquareImageView N;
    private TextView P;
    private Drawable Q;
    private View.OnClickListener R;

    /* renamed from: d, reason: collision with root package name */
    private Handler f348387d;

    /* renamed from: e, reason: collision with root package name */
    int f348388e;

    /* renamed from: f, reason: collision with root package name */
    private View f348389f;

    /* renamed from: h, reason: collision with root package name */
    private SquareImageView f348390h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f348391i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f348392m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (MiniLoadingUI.this.R != null) {
                MiniLoadingUI.this.R.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public MiniLoadingUI(Context context) {
        super(context);
        this.f348388e = DisplayUtil.dip2px(getContext(), 60.0f);
        this.J = false;
        i();
    }

    private void f() {
        this.H.setVisibility(0);
        this.H.clearAnimation();
        this.f348390h.clearAnimation();
        this.f348391i.clearAnimation();
        this.G.clearAnimation();
    }

    private void i() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.mini_sdk_mini_loading_layout, this);
        this.H = inflate;
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.mini_sdk_top_bar_mask_container);
        this.K = relativeLayout;
        if (relativeLayout != null) {
            LinearLayout linearLayout = (LinearLayout) this.H.findViewById(R.id.ll_avatar_name_title);
            this.M = linearLayout;
            linearLayout.setOnClickListener(new a());
            this.K.setOnClickListener(new b());
            this.P = (TextView) this.H.findViewById(R.id.mini_sdk_name);
            SquareImageView squareImageView = (SquareImageView) this.H.findViewById(R.id.mini_sdk_top_avatar);
            this.N = squareImageView;
            squareImageView.setRoundRect(DisplayUtil.dip2px(getContext(), 5.0f));
        }
        View findViewById = findViewById(R.id.mini_sdk_nav_mask);
        this.f348389f = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = ImmersiveUtils.getStatusBarHeight(getContext());
        this.f348389f.setLayoutParams(layoutParams);
        this.f348387d = new Handler(Looper.getMainLooper());
        this.L = (RelativeLayout) this.H.findViewById(R.id.mini_sdk_navigation_container);
        ImageView imageView = (ImageView) findViewById(R.id.btn_more_menu);
        this.C = imageView;
        imageView.setImageResource(R.drawable.mini_sdk_top_btns_more_bg);
        this.C.setOnClickListener(this);
        View findViewById2 = findViewById(R.id.v_split_view);
        this.D = findViewById2;
        findViewById2.setBackgroundColor(436207616);
        ImageView imageView2 = (ImageView) findViewById(R.id.btn_close);
        this.E = imageView2;
        imageView2.setImageResource(R.drawable.mini_sdk_top_btns_close_bg);
        this.E.setOnClickListener(this);
        ImageView imageView3 = (ImageView) findViewById(R.id.mini_sdk_left_btn);
        this.F = imageView3;
        imageView3.setOnClickListener(this);
        SquareImageView squareImageView2 = (SquareImageView) findViewById(R.id.logo_mask);
        this.f348390h = squareImageView2;
        squareImageView2.setRoundRect(DisplayUtil.dip2px(getContext(), 5.0f));
        this.f348391i = (TextView) findViewById(R.id.game_name);
        this.G = (ProgressBar) findViewById(R.id.launch_progress);
        Drawable drawable = getResources().getDrawable(R.drawable.mini_sdk_loading_drawable);
        this.Q = drawable;
        this.G.setIndeterminateDrawable(drawable);
        this.G.setIndeterminate(true);
        TextView textView = (TextView) findViewById(R.id.developer_desc);
        this.f348392m = textView;
        textView.setMaxWidth(DisplayUtil.dip2px(getContext(), 187.0f));
        this.f348392m.setGravity(1);
        setImportantForAccessibility(2);
    }

    private boolean j() {
        AppMode appMode;
        MiniAppInfo miniAppInfo = this.I;
        if (miniAppInfo != null && (appMode = miniAppInfo.appMode) != null && appMode.interLoading) {
            return true;
        }
        return false;
    }

    private boolean k() {
        boolean z16;
        LaunchParam launchParam;
        MiniAppInfo miniAppInfo = this.I;
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && launchParam.entryModel != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QMLog.d("minisdk-start_MiniLoadingUI", "isEntryModelValid valid = " + z16);
        return z16;
    }

    private boolean l() {
        AppMode appMode;
        MiniAppInfo miniAppInfo = this.I;
        if (miniAppInfo != null && (appMode = miniAppInfo.appMode) != null && appMode.interMode) {
            return true;
        }
        return false;
    }

    private void o(int i3) {
        ImageView imageView = this.C;
        if (imageView != null && this.D != null && this.E != null) {
            imageView.setVisibility(i3);
            this.D.setVisibility(i3);
            this.E.setVisibility(i3);
        }
    }

    private void p(ImageView imageView) {
        if (!TextUtils.isEmpty(this.I.iconUrl)) {
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.mini_sdk_icon_loading_default);
            Context context = getContext();
            String str = this.I.iconUrl;
            int i3 = this.f348388e;
            Drawable drawable2 = miniAppProxy.getDrawable(context, str, i3, i3, drawable);
            if (drawable2 != null) {
                drawable = drawable2;
            }
            imageView.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 40.0f, 0.0f);
        translateAnimation.setDuration(300L);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setInterpolator(new LinearInterpolator());
        this.f348390h.setVisibility(0);
        this.f348390h.setAnimation(animationSet);
        final AnimationSet animationSet2 = new AnimationSet(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 40.0f, 0.0f);
        translateAnimation2.setDuration(300L);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setDuration(800L);
        alphaAnimation2.setInterpolator(new DecelerateInterpolator());
        animationSet2.addAnimation(translateAnimation2);
        animationSet2.addAnimation(alphaAnimation2);
        translateAnimation2.setAnimationListener(new c());
        this.f348387d.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.MiniLoadingUI.5
            @Override // java.lang.Runnable
            public void run() {
                MiniLoadingUI.this.f348391i.setVisibility(0);
                MiniLoadingUI.this.f348391i.setAnimation(animationSet2);
            }
        }, 200L);
    }

    private void r() {
        f();
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -80.0f);
        translateAnimation.setDuration(200L);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.setFillAfter(true);
        this.f348390h.setVisibility(0);
        this.f348390h.setAnimation(animationSet);
        final AnimationSet animationSet2 = new AnimationSet(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -60.0f);
        translateAnimation2.setDuration(200L);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(300L);
        alphaAnimation2.setInterpolator(new DecelerateInterpolator());
        animationSet2.addAnimation(translateAnimation2);
        animationSet2.addAnimation(alphaAnimation2);
        animationSet2.setFillAfter(true);
        this.f348387d.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.MiniLoadingUI.6
            @Override // java.lang.Runnable
            public void run() {
                MiniLoadingUI.this.f348391i.setVisibility(0);
                MiniLoadingUI.this.f348391i.setAnimation(animationSet2);
            }
        }, 100L);
        this.G.setVisibility(8);
        new AnimationSet(true);
        AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation3.setDuration(400L);
        alphaAnimation3.setAnimationListener(new d());
        this.H.setAnimation(alphaAnimation3);
    }

    void g() {
        LaunchParam launchParam;
        MiniAppInfo miniAppInfo = this.I;
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && launchParam.scene == 5002) {
            o(4);
            ImageView imageView = this.F;
            if (imageView != null) {
                imageView.setVisibility(0);
                return;
            }
            return;
        }
        o(0);
        ImageView imageView2 = this.F;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
    }

    public void h(MiniAppInfo miniAppInfo) {
        this.I = miniAppInfo;
    }

    public void m() {
        AppMode appMode;
        String str;
        MiniAppInfo miniAppInfo;
        this.J = true;
        f();
        if (!l() && !j()) {
            p(this.f348390h);
            o(0);
            TextView textView = this.f348391i;
            MiniAppInfo miniAppInfo2 = this.I;
            String str2 = "";
            if (miniAppInfo2 == null) {
                str = "";
            } else {
                str = miniAppInfo2.name;
            }
            textView.setText(str);
            TextView textView2 = this.P;
            MiniAppInfo miniAppInfo3 = this.I;
            if (miniAppInfo3 != null) {
                str2 = miniAppInfo3.name;
            }
            textView2.setText(str2);
            if (this.M != null && ((miniAppInfo = this.I) == null || TextUtils.isEmpty(miniAppInfo.name))) {
                this.M.setVisibility(8);
            }
            this.f348391i.setVisibility(0);
            this.G.setVisibility(0);
            this.f348390h.setVisibility(0);
            this.H.setBackgroundColor(0);
            this.f348387d.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.MiniLoadingUI.3
                @Override // java.lang.Runnable
                public void run() {
                    MiniLoadingUI.this.q();
                }
            }, 250L);
        } else {
            this.f348390h.setVisibility(8);
            this.N.setVisibility(8);
            this.f348391i.setVisibility(4);
            this.G.setVisibility(0);
            this.H.setBackgroundColor(0);
            MiniAppInfo miniAppInfo4 = this.I;
            if (miniAppInfo4 != null && (appMode = miniAppInfo4.appMode) != null && appMode.closeTopRightCapsule) {
                o(4);
            } else {
                o(0);
            }
        }
        g();
    }

    public void n() {
        this.J = false;
        if (j()) {
            this.H.setVisibility(8);
        } else {
            r();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.btn_close || view.getId() == R.id.mini_sdk_left_btn) {
            MiniReportManager.reportEventType(this.I, 1026, "1");
        }
        View.OnClickListener onClickListener = this.R;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setCustomClickListener(View.OnClickListener onClickListener) {
        this.R = onClickListener;
    }

    public void setMaskContainerShow() {
        if (k()) {
            QMLog.d("minisdk-start_MiniLoadingUI", " param.entryModel.type ");
            if (this.I.launchParam.entryModel.type == 9) {
                QMLog.d("minisdk-start_MiniLoadingUI", " param.entryModel.type half");
                this.K.setVisibility(0);
                return;
            } else {
                this.K.setVisibility(8);
                return;
            }
        }
        QMLog.d("minisdk-start_MiniLoadingUI", "param.entryModel.type null ");
        this.K.setVisibility(8);
    }

    public MiniLoadingUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f348388e = DisplayUtil.dip2px(getContext(), 60.0f);
        this.J = false;
        i();
    }

    public MiniLoadingUI(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f348388e = DisplayUtil.dip2px(getContext(), 60.0f);
        this.J = false;
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            MiniLoadingUI.this.G.setVisibility(0);
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
    /* loaded from: classes23.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            MiniLoadingUI.this.H.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
