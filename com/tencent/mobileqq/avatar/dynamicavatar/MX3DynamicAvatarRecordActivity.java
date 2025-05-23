package com.tencent.mobileqq.avatar.dynamicavatar;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MX3DynamicAvatarRecordActivity extends DynamicAvatarRecordActivity {
    static IPatchRedirector $redirector_;

    public MX3DynamicAvatarRecordActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity, com.tencent.mobileqq.activity.richmedia.FlowActivity, com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity, com.tencent.mobileqq.activity.richmedia.FlowActivity, com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
