package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.emosm.BaseEmosmStrategy;
import com.tencent.mobileqq.emosm.EmosmStrategyFactory;
import com.tencent.mobileqq.emosm.k;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
@RoutePage(desc = "\u6536\u85cf/\u81ea\u62cd\u8868\u60c5\u7ba1\u7406\u9875", path = RouterConstants.UI_ROUTE_FAV_EMOSM_ACTVITY)
/* loaded from: classes9.dex */
public class FavEmosmManageActivity extends QIphoneTitleBarActivity implements k.f {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "FavEmosmManageActivity";
    private BaseQQAppInterface app;
    private BaseEmosmStrategy emosmStrategy;
    private com.tencent.mobileqq.emosm.k favEmosmView;
    BroadcastReceiver mFunnyPicUpdateReceiver;
    private com.tencent.mobileqq.activity.emogroupstore.n sdkEmotionSettingManager;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FavEmosmManageActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (FavEmosmManageActivity.this.emosmStrategy != null) {
                FavEmosmManageActivity.this.emosmStrategy.p(context, intent);
            }
        }
    }

    public FavEmosmManageActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mFunnyPicUpdateReceiver = new a();
        }
    }

    private void sdkSetEmotion() {
        Intent intent = getIntent();
        if (intent == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "SDKEmotionSettingManager not init ");
                return;
            }
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("key_from_sdk_set_emotion", false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initParam fromSdkSetAvatar =  " + booleanExtra);
        }
        if (booleanExtra) {
            com.tencent.mobileqq.activity.emogroupstore.n createSDKEmotionSettingManager = ((IEmosmService) QRoute.api(IEmosmService.class)).createSDKEmotionSettingManager(this);
            this.sdkEmotionSettingManager = createSDKEmotionSettingManager;
            createSDKEmotionSettingManager.a(intent);
            this.sdkEmotionSettingManager.start();
        }
    }

    public static void uploadEmotion(Context context, ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Intent intent = new Intent("com.tencent.mobileqq.action.upload.emotiom");
            intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", arrayList);
            context.sendBroadcast(intent);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "uploadEmotion pathList is empty");
        }
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.h88);
        this.app = (BaseQQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        int intExtra = getIntent().getIntExtra("camera_emo_mode", 0);
        com.tencent.mobileqq.emosm.k kVar = new com.tencent.mobileqq.emosm.k(this.app, this);
        this.favEmosmView = kVar;
        kVar.O(this);
        BaseEmosmStrategy a16 = EmosmStrategyFactory.a(this.app, this.favEmosmView, intExtra);
        this.emosmStrategy = a16;
        this.favEmosmView.w(a16);
        if (this.mFunnyPicUpdateReceiver != null) {
            IntentFilter intentFilter = new IntentFilter("com.tencent.mobileqq.action.update.emotiom");
            intentFilter.addAction("com.tencent.mobileqq.action.refresh.emotiom");
            intentFilter.addAction("com.tencent.mobileqq.action.upload.emotiom");
            getApplicationContext().registerReceiver(this.mFunnyPicUpdateReceiver, intentFilter);
        }
        sdkSetEmotion();
        this.emosmStrategy.n();
        this.emosmStrategy.d();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnDestroy();
        if (this.mFunnyPicUpdateReceiver != null) {
            getApplicationContext().unregisterReceiver(this.mFunnyPicUpdateReceiver);
            this.mFunnyPicUpdateReceiver = null;
        }
        if (this.emosmStrategy.f204075f) {
            getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
        }
        com.tencent.mobileqq.activity.emogroupstore.n nVar = this.sdkEmotionSettingManager;
        if (nVar != null) {
            nVar.onDestory();
        }
        this.emosmStrategy.o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        com.tencent.mobileqq.activity.emogroupstore.n nVar = this.sdkEmotionSettingManager;
        if (nVar != null) {
            nVar.onNewIntent(intent);
        } else {
            setIntent(intent);
            sdkSetEmotion();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.doOnPause();
            this.favEmosmView.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.doOnResume();
            this.favEmosmView.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return super.getNeedGestureBack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        BaseEmosmStrategy baseEmosmStrategy = this.emosmStrategy;
        if (baseEmosmStrategy != null) {
            baseEmosmStrategy.l(i3, i16, intent);
        }
        super.onActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        ReportController.o(this.app, "CliOper", "", "", "ep_mall", "0X80057D4", 0, 0, "", "", "", "");
        com.tencent.mobileqq.activity.emogroupstore.n nVar = this.sdkEmotionSettingManager;
        if (nVar != null) {
            nVar.onBackEvent();
        }
        com.tencent.mobileqq.emosm.k kVar = this.favEmosmView;
        if (kVar != null) {
            kVar.F();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.emosm.k.f
    public void onEditModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            setGuestureInterceptRLEnable(!z16);
        }
    }

    public void setGuestureInterceptRLEnable(boolean z16) {
        TopGestureLayout topGestureLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        FlingHandler flingHandler = GestureActivityModule.getFlingHandler(this);
        if (flingHandler != null && (flingHandler instanceof FlingGestureHandler) && (topGestureLayout = ((FlingGestureHandler) flingHandler).mTopLayout) != null) {
            topGestureLayout.setInterceptScrollLRFlag(false);
        }
    }
}
