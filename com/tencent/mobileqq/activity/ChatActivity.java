package com.tencent.mobileqq.activity;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.QUIProfileLayoutInflater;
import android.content.res.QUIProfileResources;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.SplashAIOFragment;
import com.tencent.qqnt.aio.adapter.api.IAIOConvertApi;
import com.tencent.qqnt.aio.adapter.api.UnsupportedChatTypeException;
import com.tencent.qqnt.aio.api.IAIOAnimationApi;
import com.tencent.qqnt.aio.utils.AIOLocalActivitySwitch;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import kotlin.Pair;

/* compiled from: P */
@RoutePage(desc = QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, path = RouterConstants.UI_ROUTE_CHAT_ACTVITY)
/* loaded from: classes9.dex */
public class ChatActivity extends BaseActivity {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Q.aio.ChatActivity";

    /* renamed from: a0, reason: collision with root package name */
    public static final /* synthetic */ int f175053a0 = 0;
    private SplashAIOFragment mAIOFragment;
    private boolean mIsScaleChat;
    private String mQuiProfileId;
    private LayoutInflater mQuiProfileLayoutInflater;
    private Resources mQuiProfileResources;

    public ChatActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mQuiProfileId = "";
        this.mQuiProfileResources = null;
        this.mQuiProfileLayoutInflater = null;
    }

    private void clearCustomTheme() {
        if (!TextUtils.isEmpty(this.mQuiProfileId)) {
            com.tencent.qqnt.aio.palette.c.f351747a.a(this, this.mQuiProfileId);
            this.mQuiProfileId = "";
            this.mQuiProfileResources = null;
            this.mQuiProfileLayoutInflater = null;
        }
        getIntent().removeExtra("key_open_color_palette");
    }

    private void finishScaleChat() {
        String str;
        if (this.mIsScaleChat) {
            if (getIntent().getIntExtra("uintype", 0) == 0) {
                str = "1";
            } else {
                str = "2";
            }
            ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.activity.ChatActivity.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f175054d;

                {
                    this.f175054d = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatActivity.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ReportController.o(ChatActivity.this.app, "dc00898", "", "", "0X800C2A0", "0X800C2A0", 0, 0, "", this.f175054d, "", "");
                    }
                }
            }, 16, null, true);
        }
    }

    private void initScaleChat() {
        boolean booleanExtra = getIntent().getBooleanExtra("KEY_OPEN_MINI_CHAT", false);
        this.mIsScaleChat = booleanExtra;
        if (booleanExtra) {
            QLog.d(TAG, 1, "is MiniChat");
        }
    }

    private void setCustomColorPalette() {
        clearCustomTheme();
        if (!AIOLocalActivitySwitch.f352244a.a()) {
            return;
        }
        Intent intent = getIntent();
        Pair<String, ae0.a> a16 = com.tencent.qqnt.aio.palette.b.f351744a.a(new com.tencent.qqnt.aio.palette.a(intent.getIntExtra("key_chat_type", 0), intent.getExtras()));
        if (a16 != null) {
            String first = a16.getFirst();
            this.mQuiProfileId = first;
            com.tencent.qqnt.aio.palette.c.f351747a.b(this, first, a16.getSecond());
            intent.putExtra("key_open_color_palette", true);
        }
    }

    private void setResultForStateSquare(Intent intent) {
        if (intent == null || intent.getIntExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 0) != 26) {
            return;
        }
        setResult(-1, intent);
    }

    private void showAIO() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(SplashAIOFragment.class.getName());
        if (findFragmentByTag == null) {
            QLog.i(TAG, 1, "[showAIO]: new aioFragment");
            SplashAIOFragment splashAIOFragment = new SplashAIOFragment();
            this.mAIOFragment = splashAIOFragment;
            beginTransaction.add(R.id.content, splashAIOFragment, SplashAIOFragment.class.getName());
            beginTransaction.commitAllowingStateLoss();
        } else {
            QLog.i(TAG, 1, "[showAIO]: aioFragment onNewIntent");
            SplashAIOFragment splashAIOFragment2 = (SplashAIOFragment) findFragmentByTag;
            this.mAIOFragment = splashAIOFragment2;
            beginTransaction.show(splashAIOFragment2);
            this.mAIOFragment.qOnNewIntent();
        }
        ((IAIOAnimationApi) QRoute.api(IAIOAnimationApi.class)).onAIOAnimationStart(this, IAIOAnimationApi.AnimationScene.AIO_ENTER);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        SplashAIOFragment splashAIOFragment = this.mAIOFragment;
        if (splashAIOFragment != null) {
            splashAIOFragment.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        SplashAIOFragment splashAIOFragment = this.mAIOFragment;
        if (splashAIOFragment == null || !splashAIOFragment.qOnBackPressed()) {
            super.doOnBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        if (getIntent().getBooleanExtra("key_babyQ_need_show_video", false)) {
            com.tencent.mobileqq.app.anim.b.c("babyQ", this);
        } else {
            com.tencent.mobileqq.app.anim.b.c("aio", this);
        }
        ThreadRegulator.d().f(1);
        com.tencent.mobileqq.utils.ej.b(null, "AIO_Start_cost");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnCreate strat ");
        }
        com.tencent.qqperf.opt.threadpriority.b.k(true);
        this.mActNeedImmersive = false;
        com.tencent.mobileqq.utils.ca.a(this);
        super.doOnCreate(bundle);
        initScaleChat();
        try {
            ((IAIOConvertApi) QRoute.api(IAIOConvertApi.class)).handleAIOIntent(getIntent());
            setCustomColorPalette();
            showAIO();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "doOnCreate end ");
            }
            return true;
        } catch (UnsupportedChatTypeException e16) {
            QLog.e(TAG, 1, "UnsupportedChatTypeException", e16.getMessage(), e16);
            QQToast makeText = QQToast.makeText(BaseApplication.context, com.tencent.mobileqq.R.string.f1359202r, 1);
            makeText.show(makeText.getTitleBarHeight());
            finish();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        try {
            super.doOnDestroy();
            clearCustomTheme();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnDestroy ");
        }
        if (QLog.isColorLevel()) {
            QLog.i("URLDrawableOptions", 2, "URLDrawableOptions main size " + URLDrawable.getPoolSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        ThreadRegulator.d().f(1);
        com.tencent.mobileqq.utils.ej.b(null, "AIO_Start_cost");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnNewIntent start ");
        }
        if (!intent.hasExtra("KEY_OPEN_MINI_CHAT")) {
            intent.putExtra("KEY_OPEN_MINI_CHAT", this.mIsScaleChat);
        }
        try {
            ((IAIOConvertApi) QRoute.api(IAIOConvertApi.class)).handleAIOIntent(intent);
            super.doOnNewIntent(intent);
            super.setIntent(intent);
            setCustomColorPalette();
            showAIO();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "doOnNewIntent end");
            }
        } catch (UnsupportedChatTypeException e16) {
            QLog.e(TAG, 1, "UnsupportedChatTypeException", e16.getMessage(), e16);
            QQToast makeText = QQToast.makeText(BaseApplication.context, com.tencent.mobileqq.R.string.f1359202r, 1);
            makeText.show(makeText.getTitleBarHeight());
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        super.doOnWindowFocusChanged(z16);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnWindowFocusChanged");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        setResultForStateSquare(getIntent());
        super.finish();
        finishScaleChat();
        com.tencent.mobileqq.app.anim.b.b("aio", this);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Resources) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (TextUtils.isEmpty(this.mQuiProfileId)) {
            return super.getResources();
        }
        if (this.mQuiProfileResources == null) {
            this.mQuiProfileResources = new QUIProfileResources(super.getResources(), this, this.mQuiProfileId);
        }
        return this.mQuiProfileResources;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(this.mQuiProfileId) && "layout_inflater".equals(str)) {
            Object systemService = super.getSystemService(str);
            if (systemService instanceof LayoutInflater) {
                if (this.mQuiProfileLayoutInflater == null) {
                    this.mQuiProfileLayoutInflater = new QUIProfileLayoutInflater((LayoutInflater) systemService, this, this.mQuiProfileId);
                }
                return this.mQuiProfileLayoutInflater;
            }
        }
        return super.getSystemService(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onEnterAnimationComplete();
        SplashAIOFragment splashAIOFragment = this.mAIOFragment;
        if (splashAIOFragment != null) {
            splashAIOFragment.onActivityEnterAnimationComplete();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        super.onMultiWindowModeChanged(z16);
        SplashAIOFragment splashAIOFragment = this.mAIOFragment;
        if (splashAIOFragment != null) {
            splashAIOFragment.onMultiWindowModeChanged(z16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        SplashAIOFragment splashAIOFragment = this.mAIOFragment;
        if (splashAIOFragment != null) {
            splashAIOFragment.onPostThemeChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
            getWindow().setFormat(-3);
        }
    }
}
