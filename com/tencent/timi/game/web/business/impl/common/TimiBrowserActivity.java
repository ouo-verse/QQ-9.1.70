package com.tencent.timi.game.web.business.impl.common;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.tencent.av.utils.ba;
import com.tencent.biz.qqcircle.immersive.constants.QFSNumberConstants;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.f;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.app.event.AudienceFloatCloseEvent;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import com.tencent.timi.game.web.business.api.race.LivingRoomInfo;
import java.io.Serializable;
import java.util.ArrayList;
import yn4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiBrowserActivity extends QQBrowserActivity implements SimpleEventReceiver {

    /* renamed from: a0, reason: collision with root package name */
    private View f380319a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f380320b0;

    /* renamed from: c0, reason: collision with root package name */
    private TimiGamePageLoadingView f380321c0;

    /* renamed from: d0, reason: collision with root package name */
    private ObjectAnimator f380322d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f380323e0 = QFSNumberConstants.Int.NUM_456;

    /* renamed from: f0, reason: collision with root package name */
    private String f380324f0 = "";

    /* renamed from: g0, reason: collision with root package name */
    private boolean f380325g0;

    /* renamed from: h0, reason: collision with root package name */
    private LivingRoomInfo f380326h0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.a() && TimiBrowserActivity.this.f380325g0) {
                TimiBrowserActivity.this.W2();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void M2() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26 && i3 < 28) {
            try {
                View rootView = getRootView();
                while (rootView.getParent() instanceof ViewGroup) {
                    rootView = (ViewGroup) rootView.getParent();
                    if ((rootView.getBackground() instanceof ColorDrawable) && ((ColorDrawable) rootView.getBackground()).getColor() != 0) {
                        rootView.setBackgroundColor(0);
                        return;
                    }
                }
            } catch (Exception e16) {
                l.f(QQBrowserActivity.TAG, "fixAndroidOBackground error:", e16);
            }
        }
    }

    private View N2() {
        if (this.f380320b0 == null) {
            View view = new View(getApplicationContext());
            this.f380320b0 = view;
            view.setBackgroundColor(0);
            this.f380320b0.setOnClickListener(new b());
            this.f380320b0.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) (ScreenUtils.getScreenHeight(this.f380320b0.getContext()) - ba.dp2px(this, L2()))));
        }
        return this.f380320b0;
    }

    private void P2() {
        overridePendingTransition(0, 0);
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        SystemBarActivityModule.setImmersiveStatus(this);
    }

    private void Q2() {
        View findViewById = findViewById(R.id.ae8);
        if (findViewById != null) {
            findViewById.setBackgroundResource(R.color.ajr);
        }
    }

    private void R2() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("tg_data_live_room_info");
            if (serializableExtra instanceof LivingRoomInfo) {
                this.f380326h0 = (LivingRoomInfo) serializableExtra;
                mo4.b.INSTANCE.a().d(this.f380326h0);
            }
            this.f380323e0 = intent.getIntExtra("tg_data_height", QFSNumberConstants.Int.NUM_456);
            this.f380324f0 = intent.getStringExtra("tg_data_from");
        }
    }

    private void S2() {
        this.f380319a0 = findViewById(R.id.b9v);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) ba.dp2px(this, L2()));
        layoutParams.gravity = 80;
        this.f380319a0.setLayoutParams(layoutParams);
        this.f380319a0.setVisibility(8);
        int J2 = J2();
        if (J2 != 0) {
            this.f380319a0.setBackgroundResource(J2);
        }
        this.f380319a0.setOnClickListener(new a());
        ViewCompat.setElevation(this.f380319a0, 1.0f);
    }

    private void T2() {
        if (this.f380321c0 == null) {
            this.f380321c0 = new TimiGamePageLoadingView(this);
            ViewParent parent = this.f380319a0.getParent();
            if (parent instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) ba.dp2px(this, L2()));
                layoutParams.gravity = 80;
                ((FrameLayout) parent).addView(this.f380321c0, layoutParams);
            }
            this.f380321c0.setHintText("\u52a0\u8f7d\u4e2d");
        }
    }

    private void U2() {
        ViewParent parent = this.f380319a0.getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).addView(N2());
        }
    }

    public static void Z2(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) TimiBrowserActivity.class);
        intent.putExtra("url", str);
        intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_NONE, true);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void initView() {
        S2();
        Q2();
        U2();
        showLoading();
        M2();
    }

    public int J2() {
        if ("tg_timi_browser_from_inscription".equals(this.f380324f0)) {
            return R.drawable.lua;
        }
        return R.drawable.lu9;
    }

    public Class<? extends WebViewFragment> K2() {
        return TimiBrowserFragment.class;
    }

    public int L2() {
        l.h(QQBrowserActivity.TAG, 1, "acquireContHeightDp viewHeightDp = " + this.f380323e0);
        return this.f380323e0;
    }

    public boolean V2() {
        return "tg_timi_browser_from_inscription".equals(this.f380324f0);
    }

    public void W2() {
        View view = this.f380319a0;
        if (view == null) {
            return;
        }
        if (view.getVisibility() == 8) {
            finish();
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f380319a0, "translationY", 0.0f, (int) ba.dp2px(this, L2()));
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(b.f.f450694b);
        ofFloat.addListener(new d());
        ofFloat.start();
    }

    public void Y2() {
        if (this.f380319a0 == null) {
            return;
        }
        ObjectAnimator objectAnimator = this.f380322d0;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f380319a0, "translationY", (int) ba.dp2px(this, L2()), 0.0f);
        this.f380322d0 = ofFloat;
        ofFloat.setDuration(500L);
        this.f380322d0.setInterpolator(b.f.f450693a);
        this.f380322d0.addListener(new c());
        this.f380322d0.start();
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
        W2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        SimpleEventBus.getInstance().registerReceiver(this);
        R2();
        this.mFragmentClass = K2();
        P2();
        boolean doOnCreate = super.doOnCreate(bundle);
        initView();
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        pi4.a.f426276a.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
        pi4.a.f426276a.e();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(AudienceFloatCloseEvent.class);
        return arrayList;
    }

    public void hideLoading() {
        TimiGamePageLoadingView timiGamePageLoadingView = this.f380321c0;
        if (timiGamePageLoadingView != null) {
            timiGamePageLoadingView.c();
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof AudienceFloatCloseEvent) {
            l.i(QQBrowserActivity.TAG, "onReceiveEvent : AudienceFloatCloseEvent");
            finish();
        }
    }

    public void showLoading() {
        T2();
        this.f380321c0.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c extends f {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            TimiBrowserActivity.this.f380319a0.setTranslationY(0.0f);
            TimiBrowserActivity.this.f380325g0 = true;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TimiBrowserActivity.this.f380319a0.setTranslationY(0.0f);
            TimiBrowserActivity.this.f380325g0 = true;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TimiBrowserActivity.this.f380319a0.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d extends f {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            TimiBrowserActivity.this.f380319a0.setTranslationY(0.0f);
            TimiBrowserActivity.this.f380319a0.setVisibility(8);
            TimiBrowserActivity.this.finish();
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TimiBrowserActivity.this.f380319a0.setTranslationY(0.0f);
            TimiBrowserActivity.this.f380319a0.setVisibility(8);
            TimiBrowserActivity.this.finish();
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TimiBrowserActivity.this.f380319a0.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
