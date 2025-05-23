package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.MiniAppStartUtils;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppBrandLaunchUI extends BaseActivity {
    public static final int ACTIVITY_CODE_LOGIN = 100001;
    public static final String TAG = "miniapp-start_AppBrandLaunchUI";
    private Handler mUIHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        QLog.i(TAG, 1, "doOnActivityResult requestCode=" + i3 + " resultCode=" + i16);
        if (i3 != 100001) {
            return;
        }
        if (i16 == -1) {
            MiniAppConfig parserStringToMiniAppInfo = MiniAppStartUtils.parserStringToMiniAppInfo(getIntent().getStringExtra("CONFIG_base64"));
            if (parserStringToMiniAppInfo != null) {
                doStartMiniApp(parserStringToMiniAppInfo);
            }
            moveTaskToBack(true);
            finish();
            return;
        }
        finish();
    }

    private void doStartMiniApp(MiniAppConfig miniAppConfig) {
        try {
            MiniAppLauncher.launchAppByAppConfig(this, miniAppConfig, null);
        } catch (Throwable th5) {
            QLog.e("miniapp", 1, "startAppByAppid exception! ", th5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initData() {
        QLog.i("miniapp-start", 1, "LoadingFragment doTask");
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("from");
        int i3 = 0;
        if (!TextUtils.isEmpty(stringExtra) && "SchemeJsPlugin".equals(stringExtra)) {
            String stringExtra2 = intent.getStringExtra(ZPlanPublishSource.FROM_SCHEME);
            ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra("result_receiver");
            ax c16 = bi.c((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), this, stringExtra2);
            Bundle bundle = new Bundle();
            if (c16 != null) {
                boolean b16 = c16.b();
                i3 = b16;
                if (b16 == 0) {
                    bundle.putString("errMsg", "can not find scheme : " + stringExtra2);
                    i3 = b16;
                }
            } else {
                bundle.putString("errMsg", "parse scheme error : " + stringExtra2);
            }
            if (resultReceiver != null) {
                resultReceiver.send(i3, bundle);
            }
            finish();
            return;
        }
        if (!BaseApplicationImpl.getApplication().getRuntime().isLogin()) {
            Intent intent2 = new Intent();
            intent2.putExtra("MINI_SHORTCUT_JUMP_KEY", intent);
            RouteUtils.startActivity(this, intent2, RouterConstants.UI_ROUTER_LOGIN);
            finish();
            return;
        }
        MiniAppConfig parserStringToMiniAppInfo = MiniAppStartUtils.parserStringToMiniAppInfo(intent.getStringExtra("CONFIG_base64"));
        if (parserStringToMiniAppInfo == null) {
            String stringExtra3 = intent.getStringExtra("CONFIG_APPID");
            String stringExtra4 = intent.getStringExtra("CONFIG_APPNAME");
            String stringExtra5 = intent.getStringExtra("CONFIG_APPICON");
            int intExtra = intent.getIntExtra("CONFIG_REPORTTYPE", 0);
            int intExtra2 = intent.getIntExtra("CONFIG_ENGINETYPE", 0);
            int intExtra3 = intent.getIntExtra("MINI_CONFIG_SCENE", 10086);
            if (!TextUtils.isEmpty(stringExtra3) && !TextUtils.isEmpty(stringExtra4) && !TextUtils.isEmpty(stringExtra5)) {
                MiniAppInfo miniAppInfo = new MiniAppInfo();
                miniAppInfo.appId = stringExtra3;
                miniAppInfo.name = stringExtra4;
                miniAppInfo.iconUrl = stringExtra5;
                miniAppInfo.setEngineType(intExtra2);
                miniAppInfo.setReportType(intExtra);
                MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                LaunchParam launchParam = new LaunchParam();
                miniAppConfig.launchParam = launchParam;
                launchParam.miniAppId = stringExtra3;
                launchParam.scene = intExtra3;
                parserStringToMiniAppInfo = miniAppConfig;
            }
        }
        if (parserStringToMiniAppInfo != null) {
            doStartMiniApp(parserStringToMiniAppInfo);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        this.mUIHandler = new Handler(Looper.getMainLooper());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        QLog.i(TAG, 1, "doOnDestroy");
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        QLog.i(TAG, 1, "doOnResume");
        super.doOnNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        QLog.i(TAG, 1, "doOnPause");
        super.doOnPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        QLog.i(TAG, 1, "doOnResume");
        super.doOnResume();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        QLog.i(TAG, 1, "doOnStop");
        super.doOnStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }
}
