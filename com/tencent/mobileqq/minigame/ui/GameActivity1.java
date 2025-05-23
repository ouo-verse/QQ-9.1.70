package com.tencent.mobileqq.minigame.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.mini.appbrand.ui.MiniBaseActivity;
import com.tencent.mobileqq.mini.util.AnimUtil;
import com.tencent.mobileqq.minigame.ui.controller.BaseGameActController;
import com.tencent.mobileqq.minigame.ui.controller.MiniGameActController;
import com.tencent.mobileqq.minigame.ui.controller.MiniThirdPartyActController;
import com.tencent.mobileqq.minigame.utils.MiniGameStorageUtil;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.minihippy.MiniHippyWebViewFragment;
import com.tencent.mobileqq.minihippy.api.IMiniHippyApi;
import com.tencent.mobileqq.minispecial.api.IThirdPartyMiniApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GameActivity1 extends MiniBaseActivity {
    private static final String TAG = "GameActivity1";
    private BaseGameActController mController;
    private ViewGroup mRootView;
    private long onCreateTime;

    private BaseGameActController createController(MiniAppInfo miniAppInfo) {
        int thirdPartyEngineType = ((IThirdPartyMiniApi) QRoute.api(IThirdPartyMiniApi.class)).getThirdPartyEngineType(miniAppInfo);
        if (thirdPartyEngineType != 0) {
            return new MiniThirdPartyActController(this, this.mRootView, thirdPartyEngineType);
        }
        return new MiniGameActController(this, this.mRootView);
    }

    private void handleSelectPictureAction(Intent intent) {
        FragmentManager supportFragmentManager;
        List<Fragment> fragments;
        if (!"actionSelectPicture".equals(intent.getStringExtra("keyAction")) || (supportFragmentManager = getSupportFragmentManager()) == null || (fragments = supportFragmentManager.getFragments()) == null || fragments.isEmpty()) {
            return;
        }
        for (Fragment fragment : fragments) {
            if ((fragment instanceof BaseHippyFragment) && fragment.isVisible()) {
                ((BaseHippyFragment) fragment).doOnNewIntent(intent);
            }
            if ((fragment instanceof MiniHippyWebViewFragment) && fragment.isVisible()) {
                ((MiniHippyWebViewFragment) fragment).doOnNewIntent(intent);
            }
        }
    }

    private void loadNegativeFeedBack(Intent intent, MiniAppInfo miniAppInfo) {
        intent.putExtra("negative_feedback_business_id", "mini_game");
        Bundle bundle = new Bundle();
        bundle.putString("from_src", miniAppInfo.via);
        bundle.putInt("ad_id", miniAppInfo.tianshuAdId);
        intent.putExtra("negative_feedback_business_extras", bundle);
    }

    public void backToHome() {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController instanceof MiniThirdPartyActController) {
            ((MiniThirdPartyActController) baseGameActController).backToHome();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            baseGameActController.doOnActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            baseGameActController.doOnBackPressed();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        super.doOnConfigurationChanged(configuration);
        QLog.d(TAG, 1, "--onConfigurationChanged-- screenWidthDp=" + configuration.screenWidthDp + ", screenHeightDp=" + configuration.screenHeightDp);
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            baseGameActController.doOnConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.onCreateTime = System.currentTimeMillis();
        MiniSDK.init(getApplicationContext());
        try {
            super.getIntent().putExtra(FlingConstant.FLING_ACTION_KEY, 0);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[MiniEng]\u7981\u7528\u53f3\u6ed1\u5173\u95ed\u5931\u8d25:" + th5.getMessage());
        }
        this.mNeedStatusTrans = false;
        try {
            DisplayUtil.setActivityTransparent(this);
        } catch (Throwable th6) {
            QLog.e(TAG, 1, "setActivityTransparent fail:" + th6.getMessage());
        }
        boolean doOnCreate = super.doOnCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        setContentView(relativeLayout);
        this.mRootView = relativeLayout;
        Intent intent = getIntent();
        if (intent == null) {
            intent = new Intent();
            QLog.i(TAG, 1, "doOnCreate: getIntent null.");
        }
        MiniAppInfo miniAppInfo = (MiniAppInfo) intent.getParcelableExtra(IPCConst.KEY_APPINFO);
        if (miniAppInfo == null && bundle != null) {
            miniAppInfo = (MiniAppInfo) bundle.getParcelable(IPCConst.KEY_APPINFO);
            if (miniAppInfo != null) {
                intent.putExtra(IPCConst.KEY_APPINFO, miniAppInfo);
            }
            QLog.i(TAG, 1, "doOnCreate: getAppInfo from savedInstanceState. appInfo=" + miniAppInfo);
        }
        if (miniAppInfo == null) {
            QLog.e(TAG, 1, "doOnCreate: get appInfo null.");
            QQToast.makeText(this, 1, getResources().getString(R.string.c5o), 0).show();
            finish();
            return false;
        }
        setTransitionAnimation(intent, miniAppInfo);
        BaseGameActController createController = createController(miniAppInfo);
        this.mController = createController;
        createController.doOnCreate(bundle, intent);
        loadNegativeFeedBack(intent, miniAppInfo);
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            baseGameActController.doOnDestroy();
            this.mController = null;
        }
        MiniGameStorageUtil.closeMMKVEntity();
        QLog.i(TAG, 1, "[MiniEng]doOnDestroy " + this);
    }

    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController == null || !baseGameActController.doOnKeyDown(i3, keyEvent)) {
            return super.doOnKeyDown(i3, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        QMLog.i(TAG, "--doOnNewIntent");
        super.doOnNewIntent(intent);
        if (this.mController == null) {
            QMLog.e(TAG, "doOnNewIntent: mController is null.");
            finish();
            return;
        }
        if (intent == null) {
            return;
        }
        MiniAppInfo miniAppInfo = (MiniAppInfo) intent.getParcelableExtra(IPCConst.KEY_APPINFO);
        MiniAppInfo miniAppInfo2 = this.mController.getMiniAppInfo();
        if (isReCreateController(miniAppInfo2, miniAppInfo)) {
            QMLog.e(TAG, "doOnNewIntent: change miniAppInfo, new=" + miniAppInfo.appId + ", current=" + miniAppInfo2.appId);
            this.mController.doOnDestroy();
            BaseGameActController createController = createController(miniAppInfo);
            this.mController = createController;
            createController.doOnCreate(null, intent);
            return;
        }
        this.mController.doOnNewIntent(intent);
        handleSelectPictureAction(intent);
        setTransitionAnimation(intent, miniAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        QMLog.i(TAG, "doOnPause ");
        super.doOnPause();
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            baseGameActController.doOnPause();
        }
        if (getRequestedOrientation() == 0) {
            return;
        }
        AnimUtil.setCloseAnim(this);
    }

    public void doOnPopFragment() {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController instanceof MiniThirdPartyActController) {
            ((MiniThirdPartyActController) baseGameActController).doOnPopFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            baseGameActController.doOnResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnSaveInstanceState(Bundle bundle) {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null && baseGameActController.getMiniAppInfo() != null) {
            bundle.putParcelable(IPCConst.KEY_APPINFO, this.mController.getMiniAppInfo());
        }
        super.doOnSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
        QMLog.i(TAG, "doOnStart game");
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            baseGameActController.doOnStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            baseGameActController.doOnStop();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        setActivityFullScreen(this);
        super.doOnWindowFocusChanged(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mini.appbrand.ui.MiniBaseActivity
    public void doRefreshMiniBadge(Bundle bundle) {
        super.doRefreshMiniBadge(bundle);
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            baseGameActController.doRefreshMiniBadge(bundle);
        }
    }

    public IColorNoteController getColorNoteController() {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            return baseGameActController.getColorNoteController();
        }
        return null;
    }

    public long getStartTime() {
        return this.onCreateTime;
    }

    public void hideMiniAIOEntrance() {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            baseGameActController.hideMiniAIOEntrance();
        }
    }

    public boolean isMiniHippyEngine() {
        BaseGameActController baseGameActController = this.mController;
        return (baseGameActController instanceof MiniThirdPartyActController) && ((MiniThirdPartyActController) baseGameActController).getEnginType() == 1;
    }

    public boolean isMiniKuiklyEngine() {
        BaseGameActController baseGameActController = this.mController;
        return (baseGameActController instanceof MiniThirdPartyActController) && ((MiniThirdPartyActController) baseGameActController).getEnginType() == 2;
    }

    @Override // com.tencent.mobileqq.mini.appbrand.ui.MiniBaseActivity
    public void onProcessForeGround(Bundle bundle) {
        QMLog.i(TAG, "onProcessForeGround");
        super.onProcessForeGround(bundle);
    }

    @Override // com.tencent.mobileqq.mini.appbrand.ui.MiniBaseActivity
    public void onRefreshMiniBadge(Bundle bundle) {
        QMLog.i(TAG, "onRefreshMiniBadge");
        super.onRefreshMiniBadge(bundle);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            baseGameActController.onRequestPermissionsResult(i3, strArr, iArr);
        }
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    public void openUrl(String str) {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController instanceof MiniThirdPartyActController) {
            ((MiniThirdPartyActController) baseGameActController).openUrl(str);
        }
    }

    public void pushMiniHippy(Intent intent) {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController instanceof MiniThirdPartyActController) {
            ((MiniThirdPartyActController) baseGameActController).pushMiniHippy(intent);
        }
    }

    public void restart() {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController instanceof MiniThirdPartyActController) {
            ((MiniThirdPartyActController) baseGameActController).restart();
        }
    }

    public void setColorNoteQueryPath(String str) {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            baseGameActController.setColorNoteQueryPath(str);
        }
    }

    public void setColorSignAddListener(ColorNotePlugin.a aVar) {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            baseGameActController.setColorSignAddListener(aVar);
        }
    }

    public boolean showMiniAIOEntrance(JSONObject jSONObject) {
        BaseGameActController baseGameActController = this.mController;
        if (baseGameActController != null) {
            return baseGameActController.showMiniAIOEntrance(jSONObject);
        }
        return false;
    }

    public static void setActivityFullScreen(Activity activity) {
        Window window;
        if (activity == null || activity.isFinishing() || (window = activity.getWindow()) == null) {
            return;
        }
        window.getDecorView().setSystemUiVisibility(23075586);
    }

    private void setTransitionAnimation(Intent intent, MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null && MiniGameVAUtil.META_MINI_GAME_APPID.equals(miniAppInfo.appId) && miniAppInfo.launchParam.scene == 2079) {
            QLog.i(TAG, 1, "setTransitionAnimation for metadream");
            overridePendingTransition(R.anim.f154392ke, R.anim.f154393kf);
            if (intent != null) {
                intent.putExtra(MiniGameVAUtil.KEY_META_MINI_GAME_ACTIVITY_ANIM_START_TS, System.currentTimeMillis());
                intent.putExtra(MiniGameVAUtil.KEY_META_MINI_GAME_ACTIVITY_ANIM_DURATION, 430);
                return;
            }
            return;
        }
        overridePendingTransition(R.anim.q_, R.anim.f154704qa);
    }

    private boolean isReCreateController(MiniAppInfo miniAppInfo, MiniAppInfo miniAppInfo2) {
        if (miniAppInfo2 == null || miniAppInfo == null) {
            return false;
        }
        return ((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).checkIfColdReloadHippy(miniAppInfo, miniAppInfo2) || miniAppInfo2.engineType != miniAppInfo.engineType;
    }
}
