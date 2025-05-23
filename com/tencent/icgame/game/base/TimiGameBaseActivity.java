package com.tencent.icgame.game.base;

import android.R;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ev0.b;
import qx0.a;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TimiGameBaseActivity extends QBaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    private FrameLayout f114890a0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void beforeDoOnCreate() {
        super.beforeDoOnCreate();
        ((b) a.b(b.class)).v3(null);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
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

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i3) {
        setContentView(LayoutInflater.from(this).inflate(i3, (ViewGroup) findViewById(R.id.content), false), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(@NonNull View view, @NonNull ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
        this.f114890a0 = frameLayout;
        frameLayout.addView(view, (FrameLayout.LayoutParams) layoutParams);
    }
}
