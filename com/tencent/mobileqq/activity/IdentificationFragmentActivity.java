package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

/* compiled from: P */
@RoutePage(desc = "\u4eba\u8138\u6838\u8eab\u5f15\u5bfc\u9875", path = RouterConstants.UI_ROUTER_IDENTIFICATION_GUIDE_ACTIVITY)
/* loaded from: classes9.dex */
public class IdentificationFragmentActivity extends QBaseActivity {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "IdentificationFragmentActivity";
    private int mPageCode;

    public IdentificationFragmentActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mPageCode = 102;
        }
    }

    public static void changeBaseFragment(FragmentActivity fragmentActivity, Fragment fragment) {
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        if (supportFragmentManager.findFragmentById(R.id.xgz) != null) {
            beginTransaction.replace(R.id.xgz, fragment);
        } else {
            beginTransaction.add(R.id.xgz, fragment);
        }
        if (VersionUtils.isHoneycomb()) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
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
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        QLog.d(TAG, 4, "doOnActivityResult mPageCode=" + this.mPageCode + " requestCode=" + i3 + " resultCode=" + i16 + " data=" + intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(R.id.xgz);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setContentView(frameLayout);
        this.mPageCode = getIntent().getIntExtra("key_page_code", 102);
        QLog.d(TAG, 1, "doOnCreate mPageCode=" + this.mPageCode);
        int i3 = this.mPageCode;
        if (i3 == 102) {
            changeBaseFragment(this, new IdentificationGuideFragment());
        } else if (i3 == 103) {
            changeBaseFragment(this, new IdentificationResultFragment());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment instanceof IdentificationGuideFragment) {
                ((IdentificationGuideFragment) fragment).di();
            } else if (fragment instanceof IdentificationResultFragment) {
                ((IdentificationResultFragment) fragment).onBackEvent();
            }
        }
        finish();
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
