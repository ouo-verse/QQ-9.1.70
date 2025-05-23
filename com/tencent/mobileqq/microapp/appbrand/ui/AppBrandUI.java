package com.tencent.mobileqq.microapp.appbrand.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.app.b;
import com.tencent.mobileqq.microapp.appbrand.j;
import com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.microapp.widget.input.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.util.aw;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AppBrandUI extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    j f246008a;

    /* renamed from: b, reason: collision with root package name */
    b.C8029b f246009b;

    /* renamed from: c, reason: collision with root package name */
    private Intent f246010c;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f246011d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f246012e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f246013f;

    /* renamed from: g, reason: collision with root package name */
    private aw f246014g;

    /* renamed from: h, reason: collision with root package name */
    private aw.a f246015h;

    public AppBrandUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f246010c = null;
        this.f246015h = new a(this);
        this.f246009b = new d(this);
    }

    private void b(MiniAppConfig miniAppConfig) {
        com.tencent.mobileqq.microapp.appbrand.a a16;
        if (miniAppConfig == null || miniAppConfig.getRuntimeType() != 1 || (a16 = this.f246008a.a(miniAppConfig.config.mini_appid, miniAppConfig.getRuntimeType())) == null || !miniAppConfig.isDebugVersionChange(a16.f245898c.f245825f)) {
            return;
        }
        this.f246008a.c(a16);
    }

    private void c() {
        com.tencent.mobileqq.microapp.appbrand.a a16 = this.f246008a.a();
        com.tencent.mobileqq.microapp.appbrand.a b16 = this.f246008a.b();
        if (a16 != null && b16 != null) {
            a16.f245902g.animate().translationY(a16.f245902g.getMeasuredHeight()).setDuration(400L).setListener(new c(this, a16, b16));
        }
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
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandUI", 1, "doOnActivityResult requestCode=" + i3 + ",resultCode=" + i16);
        }
        if (i3 == 1) {
            if (i16 == -1) {
                z16 = false;
            }
            this.f246012e = z16;
            this.f246013f = false;
            return;
        }
        MiniAppController.getInstance().notifyResultListener(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        int c16 = this.f246008a.c();
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandUI", 4, "onBackPressed appBrandRuntimeSize=" + c16);
        }
        if (c16 > 0) {
            com.tencent.mobileqq.microapp.appbrand.a a16 = this.f246008a.a();
            if (a16.f245902g.handleBackPressed()) {
                return;
            }
            int pageCount = a16.f245902g.getPageCount();
            if (QLog.isColorLevel()) {
                QLog.d("AppBrandUI", 4, "onBackPressed pageCount=" + pageCount);
            }
            if (pageCount > 1) {
                a16.f245902g.navigateBack(1, true);
                return;
            } else {
                a(true, true);
                return;
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        com.tencent.mobileqq.microapp.app.b.a().addObserver(this.f246009b);
        com.tencent.mobileqq.microapp.app.b a16 = com.tencent.mobileqq.microapp.app.b.a();
        com.tencent.mobileqq.microapp.widget.input.a a17 = com.tencent.mobileqq.microapp.widget.input.a.a();
        a17.getClass();
        a16.addObserver(new a.C8033a());
        this.f246010c = getIntent();
        FrameLayout frameLayout = new FrameLayout(this);
        this.f246011d = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.f246011d);
        if (this.f246008a == null) {
            this.f246008a = new j(this, this.f246011d);
        }
        aw awVar = new aw(this.f246011d);
        this.f246014g = awVar;
        awVar.a(this.f246015h);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.doOnDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandUI", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        j jVar = this.f246008a;
        if (jVar != null) {
            jVar.d();
        }
        com.tencent.mobileqq.microapp.app.b.a().deleteObserver(this.f246009b);
        this.f246009b = null;
        aw awVar = this.f246014g;
        if (awVar != null) {
            awVar.e(this.f246015h);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandUI", 4, "onNewIntent");
        }
        boolean z16 = false;
        if (intent != null) {
            try {
                if (intent.getBooleanExtra("key_appbrand_bring_ui_to_front", false)) {
                    z16 = true;
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (z16) {
            j jVar = this.f246008a;
            if (jVar == null || jVar.c() == 0) {
                finish();
                return;
            }
            return;
        }
        this.f246010c = intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        com.tencent.mobileqq.microapp.appbrand.a a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnPause();
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandUI", 4, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        if (!this.f246013f && (a16 = this.f246008a.a()) != null) {
            a16.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        MiniAppConfig miniAppConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnResume();
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandUI", 4, "onResume isLoadFail=" + this.f246012e);
        }
        try {
            miniAppConfig = (MiniAppConfig) this.f246010c.getSerializableExtra("CONFIG");
        } catch (Throwable th5) {
            th5.printStackTrace();
            miniAppConfig = null;
        }
        if (miniAppConfig == null) {
            a(true, false);
            return;
        }
        b(miniAppConfig);
        a(miniAppConfig);
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandUI", 4, "onResume miniConfig.launchParam.tempState=" + miniAppConfig.launchParam.tempState + "---" + ah.q());
        }
        String str = miniAppConfig.config.mini_appid;
        com.tencent.mobileqq.microapp.appbrand.a a16 = this.f246008a.a(str, miniAppConfig.getRuntimeType());
        LaunchParam launchParam = miniAppConfig.launchParam;
        if (launchParam.tempState != 0) {
            if (a16 != null) {
                a16.a(miniAppConfig);
                return;
            }
            return;
        }
        launchParam.tempState = 1;
        try {
            ResultReceiver resultReceiver = (ResultReceiver) this.f246010c.getParcelableExtra("receiver");
            if (resultReceiver != null) {
                resultReceiver.send(0, null);
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandUI", 4, "onResume appid=" + str + ",app_name=" + miniAppConfig.config.app_name + ",entryPath=" + miniAppConfig.launchParam.entryPath + ",appBrandRunTime=" + a16);
        }
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AppBrandUI", 4, "onResume appBrandRunTime not found! isLoadFail=" + this.f246012e);
            }
            if (this.f246012e) {
                a();
                return;
            }
            this.f246012e = true;
            this.f246013f = true;
            if (QLog.isColorLevel()) {
                QLog.d("AppBrandUI", 4, "onResume startActivityForResult isLoadFail=" + this.f246012e + ",appid =" + str + ",entryPath=" + miniAppConfig.launchParam.entryPath);
            }
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("CONFIG", miniAppConfig);
            com.tencent.mobileqq.microapp.a.c.a(this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandUI", 4, "onResume bringToFront appBrandRunTime=" + a16);
        }
        this.f246008a.a(a16);
        if (!TextUtils.isEmpty(miniAppConfig.launchParam.entryPath)) {
            a16.a(miniAppConfig.launchParam.entryPath);
        }
        a16.a(miniAppConfig);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandUI", 4, "finish");
        }
        if (isFinishing()) {
            return;
        }
        super.finishAndRemoveTask();
        com.tencent.mobileqq.microapp.a.c.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        j jVar = this.f246008a;
        if (jVar != null && jVar.a() != null && this.f246008a.a().f245902g != null && this.f246008a.a().f245902g.pageLinkedList != null && this.f246008a.a().f245902g.pageLinkedList.peek() != null && ((AbsAppBrandPage) this.f246008a.a().f245902g.pageLinkedList.peek()).isHomePage()) {
            return true;
        }
        return false;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, z16)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandUI", 4, "moveTaskToBack");
        }
        return super.moveTaskToBack(z16);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f246012e = false;
        if (this.f246008a.c() < 1) {
            finish();
        } else {
            a(true, false);
        }
    }

    private boolean b() {
        com.tencent.mobileqq.microapp.appbrand.a a16 = this.f246008a.a();
        com.tencent.mobileqq.microapp.appbrand.a b16 = this.f246008a.b();
        return a16 != null && a16.f245898c.f245825f.launchParam.scene == 1214 && b16 != null && "101495732".equals(b16.f245896a);
    }

    private void a(MiniAppConfig miniAppConfig) {
        ThreadManagerV2.excute(new b(this, miniAppConfig), 16, null, false);
    }

    public boolean a(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandUI", 4, "moveTaskToBack nonRoot=" + z16 + ",bAnim=" + z17);
        }
        if (b()) {
            c();
            return true;
        }
        boolean moveTaskToBack = super.moveTaskToBack(z16);
        if (z17) {
            com.tencent.mobileqq.microapp.a.c.b(this);
        }
        return moveTaskToBack;
    }
}
