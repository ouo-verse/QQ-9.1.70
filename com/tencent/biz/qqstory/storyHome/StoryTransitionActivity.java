package com.tencent.biz.qqstory.storyHome;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import hd0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StoryTransitionActivity extends QQStoryBaseActivity {
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        if (this.app == null) {
            c.a("StoryTransitionActivity", "StoryTransitionActivity app is null!!!!!!");
            finish();
            return false;
        }
        int intExtra = getIntent().getIntExtra("jump_action", 0);
        if (7 == intExtra) {
            Bundle extras = getIntent().getExtras();
            extras.putBoolean("resource_need_all_wait", true);
            StoryPublishLauncher.d().k(this, extras, 11000);
            overridePendingTransition(R.anim.f154958fh, R.anim.f154550b4);
            finish();
        } else {
            c.a("StoryTransitionActivity", "StoryTransitionActivity unknow jumpAction is " + intExtra);
            finish();
        }
        return true;
    }

    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
