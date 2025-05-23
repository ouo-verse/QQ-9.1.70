package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.MotionEvent;
import com.google.gson.Gson;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.share.GuildMiniAppShareData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import mqq.util.WeakReference;

/* compiled from: P */
@RoutePage(desc = "\u9009\u4eba\u900f\u660e\u9875\u9762", path = RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS)
/* loaded from: classes9.dex */
public class ForwardRecentTranslucentActivity extends ForwardRecentActivity {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class InnerResultReceiver extends ResultReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<ForwardRecentTranslucentActivity> f175875d;

        public InnerResultReceiver(Handler handler, ForwardRecentTranslucentActivity forwardRecentTranslucentActivity) {
            super(handler);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) handler, (Object) forwardRecentTranslucentActivity);
            } else {
                this.f175875d = new WeakReference<>(forwardRecentTranslucentActivity);
            }
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bundle);
                return;
            }
            super.onReceiveResult(i3, bundle);
            ForwardRecentTranslucentActivity forwardRecentTranslucentActivity = this.f175875d.get();
            if (forwardRecentTranslucentActivity == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardEntranceActivity", 2, "onReceiveResult() called with: resultCode = [" + i3 + "], resultData = [" + bundle + "] #this = " + Integer.toHexString(System.identityHashCode(forwardRecentTranslucentActivity)));
            }
            if (i3 == 1) {
                forwardRecentTranslucentActivity.finish();
            }
        }
    }

    public ForwardRecentTranslucentActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.ForwardRecentActivity, com.tencent.mobileqq.forward.ForwardBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.ForwardRecentActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mReq = getIntent().getIntExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, -1);
        overridePendingTransition(0, 0);
        int i3 = this.mReq;
        if (2 == i3) {
            getWindow().addFlags(24);
            ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("PARAM_ActivityResultReceiver");
            if (resultReceiver != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 2);
                bundle2.putParcelable("receiver", new InnerResultReceiver(new Handler(Looper.getMainLooper()), this));
                resultReceiver.send(100, bundle2);
            }
        } else if (4 == i3) {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openChannelSharePanel(this, (GuildMiniAppShareData) new Gson().fromJson(getIntent().getStringExtra("KEY_MINI_DATA"), GuildMiniAppShareData.class), new ActionSheet.OnDismissListener() { // from class: com.tencent.mobileqq.activity.ca
                @Override // com.tencent.widget.ActionSheet.OnDismissListener
                public final void onDismiss() {
                    ForwardRecentTranslucentActivity.this.finish();
                }
            });
        }
        return super.doOnCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.ForwardRecentActivity
    public boolean doOnCreate_init(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle)).booleanValue();
        }
        return super.doOnCreate_init(bundle);
    }

    @Override // com.tencent.mobileqq.activity.ForwardRecentActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.activity.ForwardRecentActivity, com.tencent.mobileqq.forward.ForwardBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
    }
}
