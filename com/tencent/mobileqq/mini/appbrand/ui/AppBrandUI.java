package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandMoveBackUtil;
import com.tencent.mobileqq.mini.fake.FakeSdkBrandUI;
import com.tencent.mobileqq.mini.fake.IFakeBrandUI;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.util.AnimUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import common.config.service.QzoneConfig;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppBrandUI extends MiniBaseActivity {
    protected static final String ROLL_BACK_ANIM_CONFIG_ID = "101139";
    public static final String TAG = "miniapp-start_AppBrandUI";
    private boolean enableMemoryDetect = true;
    private boolean isPaused = false;
    protected IFakeBrandUI mFakeBrandUI;
    private QQCustomDialog mRestartDialog;
    private Runnable memoryRunnable;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class DetectMemoryRunnable implements Runnable {
        private WeakReference<AppBrandUI> weakReferenceAppBrandUI;

        public DetectMemoryRunnable(AppBrandUI appBrandUI) {
            this.weakReferenceAppBrandUI = new WeakReference<>(appBrandUI);
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBrandUI appBrandUI = this.weakReferenceAppBrandUI.get();
            if (appBrandUI != null) {
                appBrandUI.detectMemory();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detectMemory() {
        doDetectMemory();
        this.memoryRunnable = new DetectMemoryRunnable(this);
        ThreadManager.getFileThreadHandler().postDelayed(this.memoryRunnable, 60000L);
    }

    private void doDetectMemory() {
        if (this.enableMemoryDetect) {
            if (!(QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_MEMORY_DETECT_ENABLE, 1) == 1)) {
                QLog.i(TAG, 1, "MemoryDetect disabled by config!");
                return;
            }
            try {
                float config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_MEMORY_DETECT_ALERM, 0.95f);
                ActivityManager activityManager = (ActivityManager) getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                float maxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
                float f16 = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("MemoryDetect maxMemory=");
                sb5.append(maxMemory);
                sb5.append(" currMemory=");
                sb5.append(f16);
                sb5.append(" freeMemory=");
                sb5.append((float) ((Runtime.getRuntime().freeMemory() * 1.0d) / 1048576.0d));
                sb5.append(" percent=");
                float f17 = f16 / maxMemory;
                sb5.append(f17);
                sb5.append(" alermThreshold=");
                sb5.append(config);
                QLog.i(TAG, 1, sb5.toString());
                if (f17 >= config) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AppBrandUI.this.showRestartDialog();
                        }
                    });
                    return;
                }
                QLog.i(TAG, 1, "MemoryInfo availMem=" + memoryInfo.availMem + " threshold=" + memoryInfo.threshold + " lowMemory=" + memoryInfo.lowMemory);
                if (memoryInfo.lowMemory) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI.3
                        @Override // java.lang.Runnable
                        public void run() {
                            AppBrandUI.this.showRestartDialog();
                        }
                    });
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "", th5);
            }
        }
    }

    private void enableDetectMemory(boolean z16) {
        this.enableMemoryDetect = z16;
        QLog.i(TAG, 1, "MemoryDetect enableDetectMemory:" + this.enableMemoryDetect);
    }

    private boolean isHuaWeiFoldDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI) && PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD;
    }

    private boolean isMoveTaskToBack(boolean z16) {
        if (Build.VERSION.SDK_INT != 25) {
            return super.moveTaskToBack(z16);
        }
        try {
            return super.moveTaskToBack(z16);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "moveTaskToBack is error!", e16);
            return false;
        }
    }

    private boolean isPadOrFoldDevice() {
        return PadUtil.a(BaseApplication.getContext()) == DeviceType.TABLET || PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRestartDialog() {
        try {
            int config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_MEMORY_ALERT_MODE, 0);
            if (config == 0) {
                QQToast.makeText(this, R.string.f167412cv, 0).show();
                return;
            }
            if (config == 1) {
                if (this.mRestartDialog == null) {
                    QQCustomDialog qQCustomDialog = new QQCustomDialog(this, R.style.qZoneInputDialog);
                    this.mRestartDialog = qQCustomDialog;
                    qQCustomDialog.setContentView(R.layout.custom_dialog);
                    this.mRestartDialog.setTitle(R.string.w1q);
                    this.mRestartDialog.setMessage(R.string.f167412cv);
                    this.mRestartDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.ket), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            QLog.i(AppBrandUI.TAG, 1, MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
                            AppLoaderFactory.getMiniAppInterface().exitProcess();
                        }
                    });
                    this.mRestartDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            QLog.i(AppBrandUI.TAG, 1, "cancel");
                        }
                    });
                    this.mRestartDialog.setCanceledOnTouchOutside(true);
                }
                if (this.mRestartDialog.isShowing()) {
                    return;
                }
                QLog.i(TAG, 1, "Show Memory Alerm Dialog");
                this.mRestartDialog.show();
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "", th5);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doDispatchKeyEvent(KeyEvent keyEvent) {
        if (getFakeBrandUI().doDispatchKeyEvent(keyEvent)) {
            return true;
        }
        return super.doDispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        QLog.i(TAG, 1, "doOnActivityResult requestCode=" + i3 + " resultCode=" + i16);
        getFakeBrandUI().doOnActivityResult(this, i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        QLog.i(TAG, 1, "doOnBackPressed");
        getFakeBrandUI().doOnBackPressed(this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        QLog.i(TAG, 1, "doOnCreate");
        if (!isPadOrFoldDevice()) {
            setRequestedOrientation(1);
        } else {
            getWindow().setBackgroundDrawable(new ColorDrawable(getColor(R.color.qui_common_bg_bottom_standard)));
        }
        this.mActNeedImmersive = false;
        getFakeBrandUI().doBeforeOnCreate(this, bundle);
        super.doOnCreate(bundle);
        overridePendingTransition(R.anim.q_, R.anim.f154704qa);
        return getFakeBrandUI().doOnCreate(this, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        QLog.i(TAG, 1, "doOnPause");
        getFakeBrandUI().doOnPause(this);
        super.doOnPause();
        this.isPaused = true;
        MiniAppInfo miniAppInfo = (MiniAppInfo) getIntent().getParcelableExtra(IPCConst.KEY_APPINFO);
        if (miniAppInfo != null && miniAppInfo.launchParam.scene == 5002) {
            AnimUtil.setCloseAnim4Guild(this);
        } else {
            AnimUtil.setCloseAnim(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        QLog.i(TAG, 1, "doOnResume");
        super.doOnResume();
        this.isPaused = false;
        getFakeBrandUI().doOnResume(this);
        enableDetectMemory(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        QLog.i(TAG, 1, "doOnStart");
        super.doOnStart();
        getFakeBrandUI().doOnStart(this);
        try {
            if (((MiniAppInfo) getIntent().getParcelableExtra(IPCConst.KEY_APPINFO)) != null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle = new Bundle();
                        bundle.putString(MiniChatConstants.PARAM_PROC_NAME, BaseApplicationImpl.getApplication().getQQProcessName());
                        bundle.putString(MiniChatConstants.PARAM_PROC_MODULENAME, MiniConst.MiniSDKClientQIPCModuleConst.MODULE_NAME);
                        bundle.putBoolean(MiniChatConstants.PARAM_PROC_FIRST_STARR, true);
                        AppBrandUI.this.onProcessForeGround(bundle);
                    }
                }, 16, null, true);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "doOnStrart error!", e16.getMessage());
        }
        ThreadManager.getFileThreadHandler().postDelayed(new DetectMemoryRunnable(this), 10000L);
    }

    public IFakeBrandUI getFakeBrandUI() {
        IFakeBrandUI iFakeBrandUI = this.mFakeBrandUI;
        if (iFakeBrandUI != null) {
            return iFakeBrandUI;
        }
        FakeSdkBrandUI fakeSdkBrandUI = new FakeSdkBrandUI();
        this.mFakeBrandUI = fakeSdkBrandUI;
        return fakeSdkBrandUI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return getFakeBrandUI().isWrapContent(this);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z16) {
        QLog.i(TAG, 1, "moveTaskToBack nonRoot=" + z16);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 34 && i3 >= 31 && !z16) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(ROLL_BACK_ANIM_CONFIG_ID, false)) {
                QLog.e(TAG, 1, "rollbackSwitch is true. no close anim");
            } else if (!this.isPaused) {
                startActivity(AppBrandMoveBackUtil.getMoveBackIntent(this), ActivityOptions.makeCustomAnimation(this, 0, 0).toBundle());
                overridePendingTransition(0, 0);
                QLog.i(TAG, 1, "AppBrandMoveBackUI start");
            } else {
                QLog.e(TAG, 1, "isPaused is true. no close anim");
            }
        }
        getFakeBrandUI().moveTaskToBack(this, z16, true);
        return isMoveTaskToBack(z16);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QLog.d(TAG, 1, "onConfigurationChanged");
    }

    public void doOnBackPressedWithOutReport() {
        QLog.i(TAG, 1, "doOnBackPressedWithOutReport");
        getFakeBrandUI().doOnBackPressed(this, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        QLog.i(TAG, 1, "doOnDestroy");
        getFakeBrandUI().doOnDestroy(this);
        this.mFakeBrandUI = null;
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        QLog.i(TAG, 1, "doOnNewIntent");
        setIntent(intent);
        super.doOnNewIntent(intent);
        if (!isHuaWeiFoldDevice()) {
            overridePendingTransition(R.anim.q_, R.anim.f154704qa);
        }
        getFakeBrandUI().doOnNewIntent(this, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        QLog.i(TAG, 1, "doOnStop");
        super.doOnStop();
        getFakeBrandUI().doOnStop(this);
        enableDetectMemory(false);
        if (this.memoryRunnable != null) {
            ThreadManager.getFileThreadHandler().removeCallbacks(this.memoryRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mini.appbrand.ui.MiniBaseActivity
    public void doRefreshMiniBadge(Bundle bundle) {
        QLog.i(TAG, 1, "doRefreshMiniBadge");
        super.doRefreshMiniBadge(bundle);
        getFakeBrandUI().doRefreshMiniBadge(this, bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        QLog.i(TAG, 1, "finish");
        getFakeBrandUI().finish(this);
        super.finish();
    }

    @Override // com.tencent.mobileqq.mini.appbrand.ui.MiniBaseActivity
    public void onProcessBackground(Bundle bundle) {
        QLog.i(TAG, 1, "onProcessBackground");
        super.onProcessBackground(bundle);
        getFakeBrandUI().onProcessBackground(this, bundle);
    }

    @Override // com.tencent.mobileqq.mini.appbrand.ui.MiniBaseActivity
    public void onProcessForeGround(Bundle bundle) {
        QLog.i(TAG, 1, "onProcessForeGround");
        super.onProcessForeGround(bundle);
        getFakeBrandUI().onProcessForeGround(this, bundle);
    }

    @Override // com.tencent.mobileqq.mini.appbrand.ui.MiniBaseActivity
    public void onRefreshMiniBadge(Bundle bundle) {
        QLog.i(TAG, 1, "onRefreshMiniBadge");
        super.onRefreshMiniBadge(bundle);
        getFakeBrandUI().onRefreshMiniBadge(this, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }

    public boolean moveTaskToBack(boolean z16, boolean z17) {
        QLog.i(TAG, 1, "moveTaskToBack nonRoot=" + z16 + " bAnim=" + z17);
        return getFakeBrandUI().moveTaskToBack(this, z16, z17);
    }
}
