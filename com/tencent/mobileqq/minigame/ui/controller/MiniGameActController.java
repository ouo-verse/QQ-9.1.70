package com.tencent.mobileqq.minigame.ui.controller;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.manager.MiniAppDetainManager;
import com.tencent.mobileqq.mini.ui.MiniAIOEntryView;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.ui.SparkRewardPopup;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameActController extends BaseGameActController {
    private static final String TAG = "MiniGameActController";
    private boolean isFoldPhoneOpenMode;
    private int mGameHeight;
    private boolean mGameIsRunning;
    private int mGameOrientation;
    private int mGameWidth;
    private SparkRewardPopup mSparkRewardPopup;
    private IUIProxy mUIProxy;
    private MiniAIOEntryView miniAIOEntryView;

    public MiniGameActController(GameActivity1 gameActivity1, ViewGroup viewGroup) {
        super(gameActivity1, viewGroup);
        this.isFoldPhoneOpenMode = false;
        this.mGameWidth = 0;
        this.mGameHeight = 0;
        this.mGameOrientation = -1;
        this.mGameIsRunning = false;
    }

    private ViewGroup createContentView() {
        this.mRootView.removeAllViews();
        FrameLayout frameLayout = new FrameLayout(this.mActivity);
        this.mRootView.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private Size getActivitySize() {
        GameActivity1 gameActivity1 = this.mActivity;
        if (gameActivity1 == null) {
            return null;
        }
        DisplayMetrics displayMetrics = DisplayUtil.getDisplayMetrics(gameActivity1);
        return new Size(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    private void initUIProxy(Intent intent) {
        if (intent == null) {
            QMLog.e(TAG, "Failed to initUIProxy, intent is null");
            return;
        }
        MiniAppInfo miniAppInfo = (MiniAppInfo) intent.getParcelableExtra(IPCConst.KEY_APPINFO);
        this.mSparkRewardPopup.setAppInfo(miniAppInfo);
        this.mMiniAppInfo = miniAppInfo;
        if (miniAppInfo != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.ui.controller.MiniGameActController.2
                @Override // java.lang.Runnable
                public void run() {
                    Bundle bundle = new Bundle();
                    bundle.putString(MiniChatConstants.PARAM_PROC_NAME, BaseApplicationImpl.getApplication().getQQProcessName());
                    bundle.putString(MiniChatConstants.PARAM_PROC_MODULENAME, MiniConst.MiniSDKClientQIPCModuleConst.MODULE_NAME);
                    bundle.putBoolean(MiniChatConstants.PARAM_PROC_FIRST_STARR, true);
                    MiniGameActController.this.mActivity.onProcessForeGround(bundle);
                    MiniGameActController.this.mActivity.onRefreshMiniBadge(bundle);
                }
            }, 16, null, true);
        }
        IUIProxy uIProxy = AppLoaderFactory.g().getMiniAppEnv().getUIProxy(miniAppInfo);
        this.mUIProxy = uIProxy;
        if (uIProxy == null) {
            QLog.e(TAG, 1, "initUIProxy get uiProxy null, appInfo=" + miniAppInfo);
            return;
        }
        QLog.i(TAG, 1, "UIProxy=" + this.mUIProxy.getClass().getSimpleName() + ";Info=" + miniAppInfo);
    }

    private boolean shouldRestart() {
        boolean z16 = false;
        if (!this.mGameIsRunning) {
            return false;
        }
        boolean isFolderScreenOpenMode = HippyUtils.isFolderScreenOpenMode(BaseApplication.getContext());
        boolean z17 = isFolderScreenOpenMode != this.isFoldPhoneOpenMode;
        this.isFoldPhoneOpenMode = isFolderScreenOpenMode;
        if (z17) {
            return true;
        }
        Size activitySize = getActivitySize();
        if (activitySize == null || !HippyUtils.isFolderScreenOpenMode(BaseApplication.getContext())) {
            return false;
        }
        boolean z18 = this.mGameWidth * this.mGameHeight > 0;
        if (!(this.mActivity.getRequestedOrientation() != this.mGameOrientation) && z18 && (this.mGameWidth != activitySize.getWidth() || this.mGameHeight != activitySize.getHeight())) {
            z16 = true;
        }
        this.mGameWidth = activitySize.getWidth();
        this.mGameHeight = activitySize.getHeight();
        this.mGameOrientation = this.mActivity.getRequestedOrientation();
        return z16;
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onActivityResult(this.mActivity, i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnBackPressed() {
        IUIProxy iUIProxy = this.mUIProxy;
        if ((iUIProxy != null && iUIProxy.onBackPressed(this.mActivity)) || this.mActivity.moveTaskToBack(false)) {
            return;
        }
        this.mActivity.finish();
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnConfigurationChanged(Configuration configuration) {
        QLog.d(TAG, 1, "--onConfigurationChanged-- screenWidthDp=" + configuration.screenWidthDp + ", screenHeightDp=" + configuration.screenHeightDp);
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD) {
            if (shouldRestart()) {
                this.mUIProxy.handleRestart();
            } else {
                this.mUIProxy.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnCreate(Bundle bundle, Intent intent) {
        this.mSparkRewardPopup = new SparkRewardPopup(this.mActivity, this.mRootView);
        MiniSDKClientQIPCModule.registerModule();
        initUIProxy(intent);
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy == null) {
            QMLog.e(TAG, "Failed to start GameActivity, UIProxy is null!");
            this.mActivity.finish();
            return;
        }
        iUIProxy.onAttachActivity(this.mActivity, bundle, createContentView());
        this.mUIProxy.onIntentUpdate(intent);
        initColorNote();
        GdtManager.q().r(this.mActivity, new GdtManager.a());
        MiniAppDetainManager.INSTANCE.preloadAppDetainRecord(this.mMiniAppInfo);
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnDestroy() {
        super.doOnDestroy();
        this.mSparkRewardPopup.onDestroy();
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onDetachActivity(this.mActivity);
        }
        QLog.i(TAG, 1, "[MiniEng]doOnDestroy " + this.mActivity);
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnNewIntent(Intent intent) {
        initUIProxy(intent);
        if (this.mUIProxy == null) {
            QMLog.e(TAG, "Failed to start GameActivity, UIProxy is null!");
            this.mActivity.finish();
        } else {
            intent.putExtra(StartupReportUtil.KEY_STARTUP_FLAG, 1);
            this.mUIProxy.onIntentUpdate(intent);
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnResume() {
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onMiniResume();
        }
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(this.mActivity);
        super.doOnResume();
        this.mGameIsRunning = true;
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, false);
        this.mSparkRewardPopup.onResume();
        this.isFoldPhoneOpenMode = HippyUtils.isFolderScreenOpenMode(BaseApplication.getContext());
        Size activitySize = getActivitySize();
        this.mGameWidth = activitySize.getWidth();
        this.mGameHeight = activitySize.getHeight();
        this.mGameOrientation = this.mActivity.getRequestedOrientation();
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnStart() {
        QMLog.i(TAG, "doOnStart game");
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onMiniStart();
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnStop() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.ui.controller.MiniGameActController.1
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString(MiniChatConstants.PARAM_PROC_NAME, BaseApplicationImpl.getApplication().getQQProcessName());
                bundle.putString(MiniChatConstants.PARAM_PROC_MODULENAME, MiniConst.MiniSDKClientQIPCModuleConst.MODULE_NAME);
                MiniGameActController.this.mActivity.onProcessBackground(bundle);
            }
        }, 16, null, true);
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onMiniStop();
        }
        this.mSparkRewardPopup.onStop();
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doRefreshMiniBadge(Bundle bundle) {
        if (this.mUIProxy != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_appid", bundle.getString("miniAppID"));
            bundle2.putInt(IPCConst.KEY_BADGE_COUNT, bundle.getInt(MiniChatConstants.PARAM_PROC_BADGE_COUNT));
            this.mUIProxy.onRefreshMiniBadge(this.mActivity, bundle2);
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void hideMiniAIOEntrance() {
        MiniAIOEntryView miniAIOEntryView = this.miniAIOEntryView;
        if (miniAIOEntryView != null) {
            miniAIOEntryView.setVisibility(8);
            this.miniAIOEntryView.onDestroy();
            this.miniAIOEntryView = null;
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onRequestPermissionsResult(this.mActivity, i3, strArr, iArr);
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnPause() {
        this.mGameIsRunning = false;
        super.doOnPause();
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onMiniPause();
        }
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this.mActivity, 2, true);
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            IUIProxy iUIProxy = this.mUIProxy;
            if (iUIProxy != null && iUIProxy.onBackPressed(this.mActivity)) {
                return true;
            }
            if (!this.mActivity.moveTaskToBack(false)) {
                this.mActivity.finish();
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public boolean showMiniAIOEntrance(JSONObject jSONObject) {
        String str;
        int i3;
        int i16 = -10;
        if (jSONObject != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            float f16 = displayMetrics.density;
            int optInt = (int) ((jSONObject.optInt(HippyTKDListViewAdapter.X, -10) * f16) + 0.5f);
            int optInt2 = (int) ((f16 * jSONObject.optInt("y", -10)) + 0.5f);
            str = jSONObject.optString("style");
            i3 = optInt2;
            i16 = optInt;
        } else {
            str = "";
            i3 = -10;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i16;
        layoutParams.topMargin = i3;
        if (i16 < 0 || i3 < 0) {
            return false;
        }
        MiniAIOEntryView miniAIOEntryView = this.miniAIOEntryView;
        if (miniAIOEntryView == null) {
            MiniAIOEntryView miniAIOEntryView2 = new MiniAIOEntryView(this.mActivity, str);
            this.miniAIOEntryView = miniAIOEntryView2;
            this.mRootView.addView(miniAIOEntryView2, layoutParams);
            return true;
        }
        miniAIOEntryView.setMiniAIOStyle(str);
        this.miniAIOEntryView.setLayoutParams(layoutParams);
        this.mRootView.requestLayout();
        return true;
    }
}
