package com.tencent.qqlive.common.webview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;

/* compiled from: P */
/* loaded from: classes22.dex */
public class HalfTranslucentBrowserActivity extends QQBrowserActivity {

    /* renamed from: a0, reason: collision with root package name */
    private View f345204a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f345205b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f345206c0 = R.color.ajr;

    /* renamed from: d0, reason: collision with root package name */
    private float f345207d0 = 0.0f;

    /* renamed from: e0, reason: collision with root package name */
    private int f345208e0 = 0;

    /* renamed from: f0, reason: collision with root package name */
    private float f345209f0 = 0.0f;

    /* renamed from: g0, reason: collision with root package name */
    private String f345210g0 = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f345211a;

        a(int i3) {
            this.f345211a = i3;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f345211a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            HalfTranslucentBrowserActivity.this.Y2();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private static void L2(Bundle bundle, float f16, int i3, int i16) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!bundle.containsKey("halfFragmentClass")) {
            bundle.putSerializable("halfFragmentClass", HalfBrowserFragment.class);
        }
        bundle.putBoolean("isTransparentTitle", true);
        bundle.putBoolean(QQBrowserActivity.EXTRA_FINISH_ANIMATION_NONE, true);
        bundle.putBoolean("hide_more_button", true);
        bundle.putBoolean(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
        bundle.putBoolean("hide_more_button", true);
        bundle.putInt("webViewBgRes", i16);
        bundle.putFloat("webViewHeight", f16);
        bundle.putInt("backgroundColorId", i3);
    }

    private View M2() {
        if (this.f345205b0 == null) {
            View view = new View(getApplicationContext());
            this.f345205b0 = view;
            view.setBackgroundColor(getResources().getColor(this.f345206c0));
            this.f345205b0.setOnClickListener(new c());
            this.f345205b0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        return this.f345205b0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ColorDrawable N2() {
        try {
            if (TextUtils.isEmpty(this.f345210g0)) {
                return null;
            }
            return new ColorDrawable(Color.parseColor(this.f345210g0));
        } catch (IllegalArgumentException e16) {
            QLog.e("BaseHalfTranslucentBrowserActivity", 1, "parse color error:" + e16);
            return null;
        }
    }

    private TranslateAnimation P2(Animation.AnimationListener animationListener) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(125L);
        translateAnimation.setAnimationListener(animationListener);
        return translateAnimation;
    }

    private Class<? extends WebViewFragment> Q2(Bundle bundle) {
        Class<? extends WebViewFragment> cls;
        if (bundle != null && (cls = (Class) bundle.getSerializable("halfFragmentClass")) != null) {
            return cls;
        }
        return HalfBrowserFragment.class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TranslateAnimation R2() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setAnimationListener(new d());
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    private void S2() {
        overridePendingTransition(0, 0);
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        SystemBarActivityModule.setImmersiveStatus(this);
    }

    private void T2() {
        int i3;
        FrameLayout rootView = getRootView();
        if (rootView != null && (i3 = this.f345206c0) != 0) {
            rootView.setBackgroundResource(i3);
        }
    }

    private void U2() {
        View findViewById = findViewById(R.id.b9v);
        this.f345204a0 = findViewById;
        this.f345204a0.setOutlineProvider(new a(DisplayUtil.dip2px(findViewById.getContext(), 15.0f)));
        this.f345204a0.setClipToOutline(true);
        DisplayMetrics displayMetrics = getApplication().getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            QLog.e("BaseHalfTranslucentBrowserActivity", 1, "doOnCreate dm is null");
            return;
        }
        float f16 = this.f345207d0;
        float f17 = this.f345209f0;
        if (f17 == 0.0f) {
            f17 = displayMetrics.scaledDensity;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) (f16 * f17));
        layoutParams.gravity = 80;
        this.f345204a0.setLayoutParams(layoutParams);
        this.f345204a0.setVisibility(4);
        ColorDrawable N2 = N2();
        if (N2 != null) {
            this.f345204a0.setBackground(N2);
        } else {
            int i3 = this.f345208e0;
            if (i3 != 0) {
                this.f345204a0.setBackgroundResource(i3);
            }
        }
        this.f345204a0.setOnClickListener(new b());
        ViewCompat.setElevation(this.f345204a0, 1.0f);
    }

    private void V2() {
        ViewParent parent = this.f345204a0.getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).addView(M2(), 0);
        }
    }

    public static void W2(Context context, String str, Bundle bundle, float f16, int i3, int i16, String str2) {
        Integer num;
        L2(bundle, f16, i3, i16);
        if (context instanceof Activity) {
            num = null;
        } else {
            num = 268435456;
            context = BaseApplication.getContext();
        }
        com.tencent.qqlive.common.webview.a.g(context, str, bundle, HalfTranslucentBrowserActivity.class, null, num, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y2() {
        View view = this.f345204a0;
        if (view != null) {
            view.startAnimation(P2(new e()));
        }
    }

    private void Z2() {
        View view = this.f345204a0;
        if (view != null) {
            view.post(new Runnable() { // from class: com.tencent.qqlive.common.webview.HalfTranslucentBrowserActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (HalfTranslucentBrowserActivity.this.f345204a0 != null) {
                        HalfTranslucentBrowserActivity.this.f345204a0.startAnimation(HalfTranslucentBrowserActivity.this.R2());
                    }
                }
            });
        }
    }

    private void initView() {
        U2();
        T2();
        V2();
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        Y2();
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mFragmentClass = Q2(bundle);
        this.f345207d0 = getIntent().getFloatExtra("webViewHeight", 0.0f);
        this.f345208e0 = getIntent().getIntExtra("webViewBgRes", 0);
        this.f345206c0 = getIntent().getIntExtra("backgroundColorId", R.color.ajr);
        this.f345209f0 = getIntent().getFloatExtra("webViewScaleDensity", 0.0f);
        this.f345210g0 = getIntent().getStringExtra("webViewBgColor");
        S2();
        boolean doOnCreate = super.doOnCreate(bundle);
        initView();
        Z2();
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        if (this.mFragmentClass != null) {
            this.mFragmentClass = null;
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            HalfTranslucentBrowserActivity.this.f345204a0.setVisibility(0);
            View findViewById = HalfTranslucentBrowserActivity.this.f345204a0.findViewById(R.id.webview);
            if (findViewById != null) {
                ColorDrawable N2 = HalfTranslucentBrowserActivity.this.N2();
                if (N2 != null) {
                    findViewById.setBackground(N2);
                } else if (HalfTranslucentBrowserActivity.this.f345208e0 != 0) {
                    findViewById.setBackgroundResource(HalfTranslucentBrowserActivity.this.f345208e0);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (HalfTranslucentBrowserActivity.this.f345204a0 != null) {
                HalfTranslucentBrowserActivity.this.f345204a0.setVisibility(8);
            }
            HalfTranslucentBrowserActivity.this.finish();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
