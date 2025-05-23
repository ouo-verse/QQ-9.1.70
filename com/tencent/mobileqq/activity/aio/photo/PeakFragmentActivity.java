package com.tencent.mobileqq.activity.aio.photo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.SystemBarCompact;

/* loaded from: classes10.dex */
public class PeakFragmentActivity extends QBaseActivity {
    protected AppInterface appInterface;
    protected boolean mNeedPauseRichMedia = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustStatusBar() {
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(this);
        if (systemBarComp != null) {
            SimpleUIUtil.adjustSimpleStatusBar(systemBarComp, getWindow());
        }
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
        super.getIntent().putExtra(FlingConstant.FLING_ACTION_KEY, 0);
        super.doOnCreate(bundle);
        if (getAppRuntime() instanceof AppInterface) {
            this.appInterface = (AppInterface) getAppRuntime();
        }
        setVolumeControlStream(3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        if (this.mNeedPauseRichMedia) {
            AbstractVideoImage.pauseAll();
            AbstractGifImage.pauseAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        AbstractVideoImage.resumeAll();
        AbstractGifImage.resumeAll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public String getModuleId() {
        return "peak";
    }

    public int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
