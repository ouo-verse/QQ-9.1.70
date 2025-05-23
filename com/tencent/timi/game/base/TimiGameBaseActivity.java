package com.tencent.timi.game.base;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import hi4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiGameBaseActivity extends QBaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    private FrameLayout f376320a0;

    /* renamed from: b0, reason: collision with root package name */
    private TimiGamePageLoadingView f376321b0;

    public void F2(int i3) {
        G2(getString(i3));
    }

    public void G2(String str) {
        if (str.isEmpty()) {
            str = getString(R.string.f23156727);
        }
        if (this.f376321b0 == null) {
            this.f376321b0 = new TimiGamePageLoadingView(this);
            this.f376320a0.addView(this.f376321b0, new FrameLayout.LayoutParams(-1, -1));
        }
        this.f376321b0.setHintText(str);
        this.f376321b0.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void beforeDoOnCreate() {
        super.beforeDoOnCreate();
        ((b) mm4.b.b(b.class)).d3(null);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public void hideLoadingView() {
        TimiGamePageLoadingView timiGamePageLoadingView = this.f376321b0;
        if (timiGamePageLoadingView != null) {
            timiGamePageLoadingView.c();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        setContentView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    public void showLoadingView() {
        F2(R.string.f23156727);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i3) {
        setContentView(LayoutInflater.from(this).inflate(i3, (ViewGroup) findViewById(android.R.id.content), false), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(@NonNull View view, @NonNull ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) findViewById(android.R.id.content);
        this.f376320a0 = frameLayout;
        frameLayout.addView(view, (FrameLayout.LayoutParams) layoutParams);
    }
}
