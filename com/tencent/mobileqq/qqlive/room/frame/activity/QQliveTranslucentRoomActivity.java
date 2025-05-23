package com.tencent.mobileqq.qqlive.room.frame.activity;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.frame.event.EnterAnimationCompleteEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/frame/activity/QQliveTranslucentRoomActivity;", "Lcom/tencent/mobileqq/qqlive/room/frame/activity/QQliveRoomActivity;", "", "initRequestedOrientation", "onEnterAnimationComplete", "doOnDestroy", "finish", "", "l0", "Z", "enterAnimationComplete", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQliveTranslucentRoomActivity extends QQliveRoomActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private boolean enterAnimationComplete;

    public QQliveTranslucentRoomActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.frame.activity.QQliveRoomActivity, com.tencent.mobileqq.qqlive.room.frame.activity.QQLiveWebShareActivity, com.tencent.mobileqq.activity.QPublicFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqlive.room.frame.activity.QQliveRoomActivity, com.tencent.mobileqq.qqlive.room.frame.activity.QQLiveWebShareActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.doOnDestroy();
            this.enterAnimationComplete = false;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.frame.activity.QQliveRoomActivity, com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.frame.activity.QQliveRoomActivity, com.tencent.mobileqq.activity.QPublicFragmentActivity
    protected void initRequestedOrientation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.frame.activity.QQliveRoomActivity, com.tencent.mobileqq.qqlive.room.frame.activity.QQLiveWebShareActivity, com.tencent.mobileqq.activity.QPublicFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, android.app.Activity
    public void onEnterAnimationComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onEnterAnimationComplete();
        this.enterAnimationComplete = true;
        SimpleEventBus.getInstance().dispatchEvent(new EnterAnimationCompleteEvent());
    }
}
