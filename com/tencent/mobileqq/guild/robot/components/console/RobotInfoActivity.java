package com.tencent.mobileqq.guild.robot.components.console;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.robot.components.square.RobotListFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotInfoActivity extends QBaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    private FrameLayout f232153a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f232154b0 = true;

    public boolean F2() {
        return this.f232154b0;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mActNeedImmersive = false;
        setContentView(R.layout.f4u);
        this.f232153a0 = (FrameLayout) findViewById(R.id.wwh);
        super.doOnCreate(bundle);
        setContentView(R.layout.f4u);
        this.f232153a0 = (FrameLayout) findViewById(R.id.wwh);
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("GUILD_ROBOT_SHOW_UI_KEY");
            QLog.i("RobotInfoActivity", 1, "doOnCreate, flag = " + stringExtra);
            getActionBar().hide();
            if ("com.tencent.mobileqq.guild.robot.audio.robotListView.RobotListFragment".equals(stringExtra)) {
                RobotListFragment robotListFragment = new RobotListFragment();
                robotListFragment.setArguments(getIntent().getBundleExtra("com.tencent.mobileqq.guild.robot.audio.robotListView.RobotListFragment"));
                getSupportFragmentManager().beginTransaction().add(R.id.wwh, robotListFragment).commit();
                this.f232154b0 = false;
            } else {
                Bundle bundleExtra = getIntent().getBundleExtra("robot_bundle");
                RobotInfoFragment robotInfoFragment = new RobotInfoFragment();
                robotInfoFragment.setArguments(bundleExtra);
                robotInfoFragment.show(getSupportFragmentManager(), "RobotInfoActivity");
            }
        } else {
            finish();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
