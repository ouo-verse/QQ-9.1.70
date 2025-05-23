package com.tencent.mobileqq.minigame.ui.controller;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minihippy.MiniThirdPartyUIProxy;
import com.tencent.mobileqq.minispecial.api.IThirdPartyMiniApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import com.tencent.util.LiuHaiUtils;
import d92.h;
import f92.a;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniThirdPartyActController extends BaseGameActController {
    private static final String TAG = "TAG_MiniHippy";
    private FrameLayout container;
    private final int enginType;
    private final IUIProxy mIUIProxy;
    private final g92.a miniFakeView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static class AppInfoCallback implements d92.a {
        private final WeakReference<MiniThirdPartyActController> mControllerRef;

        AppInfoCallback(MiniThirdPartyActController miniThirdPartyActController) {
            this.mControllerRef = new WeakReference<>(miniThirdPartyActController);
        }

        @Override // d92.a
        public void onFail(int i3, String str) {
            MiniThirdPartyActController miniThirdPartyActController = this.mControllerRef.get();
            if (miniThirdPartyActController == null) {
                return;
            }
            miniThirdPartyActController.finishWithError("requestAppInfo failed. errorCode=" + i3 + ", errorMsg=" + str);
        }

        @Override // d92.a
        public void onSuccess(MiniAppInfo miniAppInfo) {
            MiniThirdPartyActController miniThirdPartyActController = this.mControllerRef.get();
            if (miniThirdPartyActController == null) {
                QLog.e(MiniThirdPartyActController.TAG, 1, "onSuccess: hippyFragment is null");
            } else if (miniAppInfo != null) {
                miniThirdPartyActController.onMiniAppInfoUpdate(miniAppInfo);
            } else {
                miniThirdPartyActController.finishWithError("requestAppInfo miniAppInfo is null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static class AppInfoCallbackForExt implements d92.a {
        private final WeakReference<MiniThirdPartyActController> mControllerRef;

        AppInfoCallbackForExt(MiniThirdPartyActController miniThirdPartyActController) {
            this.mControllerRef = new WeakReference<>(miniThirdPartyActController);
        }

        @Override // d92.a
        public void onFail(int i3, String str) {
            MiniThirdPartyActController miniThirdPartyActController = this.mControllerRef.get();
            if (miniThirdPartyActController == null) {
                return;
            }
            miniThirdPartyActController.finishWithError("requestAppInfo failed. errorCode=" + i3 + ", errorMsg=" + str);
        }

        @Override // d92.a
        public void onSuccess(MiniAppInfo miniAppInfo) {
            QLog.e(MiniThirdPartyActController.TAG, 1, "AppInfoCallbackForExt onSuccess");
            MiniThirdPartyActController miniThirdPartyActController = this.mControllerRef.get();
            if (miniThirdPartyActController != null && miniThirdPartyActController.mRootView != null) {
                if (miniThirdPartyActController.mMiniAppInfo != null && miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId) && miniAppInfo.appId.equals(miniThirdPartyActController.mMiniAppInfo.appId)) {
                    miniThirdPartyActController.mMiniAppInfo.extInfo = miniAppInfo.extInfo;
                } else {
                    QLog.e(MiniThirdPartyActController.TAG, 1, "onSuccess: miniAppInfo is invalid");
                }
                miniThirdPartyActController.attachUIProxy(miniThirdPartyActController.mRootView, miniThirdPartyActController.mMiniAppInfo);
                return;
            }
            QLog.e(MiniThirdPartyActController.TAG, 1, "onSuccess: hippyFragment is null");
        }
    }

    public MiniThirdPartyActController(GameActivity1 gameActivity1, ViewGroup viewGroup, int i3) {
        super(gameActivity1, viewGroup);
        this.enginType = i3;
        MiniThirdPartyUIProxy miniThirdPartyUIProxy = new MiniThirdPartyUIProxy(i3);
        this.mIUIProxy = miniThirdPartyUIProxy;
        this.miniFakeView = ((IThirdPartyMiniApi) QRoute.api(IThirdPartyMiniApi.class)).getMiniThirdPartyView(gameActivity1, miniThirdPartyUIProxy, i3);
    }

    private void createContentView() {
        this.mRootView.removeAllViews();
        LayoutInflater.from(this.mActivity).inflate(R.layout.f167552aj, this.mRootView, true);
        RelativeLayout relativeLayout = new RelativeLayout(this.mActivity);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        relativeLayout.setTag(ThirdPartyMiniPageProxy.TAG_HIPPY_NAVIGATION);
        this.mRootView.addView(relativeLayout);
        this.container = (FrameLayout) this.mRootView.findViewById(R.id.ckj);
    }

    private boolean isNeedReqAppInfoForExt() {
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        return (miniAppInfo == null || !TextUtils.isEmpty(miniAppInfo.extInfo) || this.mMiniAppInfo.isShortcutFakeApp()) ? false : true;
    }

    private void loadUI(MiniAppInfo miniAppInfo) {
        if (miniAppInfo.isShortcutFakeApp()) {
            QLog.i(TAG, 1, "loadUI: miniAppInfo is not complete\uff0crequest");
            h.b(miniAppInfo.appId, miniAppInfo.firstPath, null, new AppInfoCallback(this));
            if (this.enginType != 2) {
                return;
            }
        }
        g92.a aVar = this.miniFakeView;
        if (aVar != null) {
            FrameLayout frameLayout = this.container;
            String str = miniAppInfo.appId;
            String optExtInfo = optExtInfo(miniAppInfo);
            String str2 = miniAppInfo.extendData;
            FirstPageInfo firstPageInfo = miniAppInfo.firstPage;
            aVar.initView(frameLayout, str, optExtInfo, str2, firstPageInfo != null ? firstPageInfo.pagePath : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMiniAppInfoUpdate(MiniAppInfo miniAppInfo) {
        QLog.i(TAG, 1, "onSuccess: request miniAppInfo success.");
        miniAppInfo.appMode.disableAddToMyFavor = true;
        this.mMiniAppInfo = miniAppInfo;
        g92.a aVar = this.miniFakeView;
        if (aVar != null) {
            FrameLayout frameLayout = this.container;
            String str = miniAppInfo.appId;
            String optExtInfo = optExtInfo(miniAppInfo);
            String str2 = miniAppInfo.extendData;
            FirstPageInfo firstPageInfo = miniAppInfo.firstPage;
            aVar.updateView(frameLayout, str, optExtInfo, str2, firstPageInfo == null ? null : firstPageInfo.pagePath);
        }
        updateUIProxyAppInfo(miniAppInfo);
    }

    private void reqAppInfoForExt() {
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        h.b(miniAppInfo.appId, miniAppInfo.firstPath, null, new AppInfoCallbackForExt(this));
    }

    private void updateUIProxyAppInfo(MiniAppInfo miniAppInfo) {
        if (this.mIUIProxy != null) {
            Intent intent = new Intent();
            intent.setAction(ThirdPartyMiniPageProxy.ACTION_UPDATE_APP_INFO);
            intent.putExtra(IPCConst.KEY_APPINFO, miniAppInfo);
            this.mIUIProxy.onIntentUpdate(intent);
        }
    }

    public void backToHome() {
        g92.a aVar = this.miniFakeView;
        if (aVar instanceof MiniHippyController) {
            ((MiniHippyController) aVar).backToHome();
        } else if (aVar instanceof e92.a) {
            ((e92.a) aVar).b();
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        g92.a aVar = this.miniFakeView;
        if (aVar != null) {
            aVar.onActivityResult(i3, i16, intent);
        }
        IUIProxy iUIProxy = this.mIUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onActivityResult(this.mActivity, i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnBackPressed() {
        g92.a aVar = this.miniFakeView;
        if (aVar != null) {
            aVar.onBackPressed();
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnConfigurationChanged(Configuration configuration) {
        g92.a aVar = this.miniFakeView;
        if (aVar != null) {
            aVar.onConfigurationChanged(configuration);
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnCreate(Bundle bundle, Intent intent) {
        QLog.i(TAG, 1, "before create cost:" + (System.currentTimeMillis() - intent.getLongExtra("startDuration", 0L)));
        LiuHaiUtils.resetFullScreen(this.mActivity);
        LiuHaiUtils.enableNotch(this.mActivity);
        initColorNote();
        MiniAppInfo miniAppInfo = (MiniAppInfo) intent.getParcelableExtra(IPCConst.KEY_APPINFO);
        this.mMiniAppInfo = miniAppInfo;
        g92.a aVar = this.miniFakeView;
        if (aVar != null) {
            if (miniAppInfo == null) {
                aVar.onCreate(bundle, null, null, null, null);
            } else {
                String str = miniAppInfo.appId;
                String optExtInfo = optExtInfo(miniAppInfo);
                MiniAppInfo miniAppInfo2 = this.mMiniAppInfo;
                String str2 = miniAppInfo2.extendData;
                FirstPageInfo firstPageInfo = miniAppInfo2.firstPage;
                aVar.onCreate(bundle, str, optExtInfo, str2, firstPageInfo == null ? null : firstPageInfo.pagePath);
            }
        }
        createContentView();
        if (isNeedReqAppInfoForExt()) {
            QLog.i(TAG, 1, "extInfo is null,request Info");
            reqAppInfoForExt();
        } else {
            attachUIProxy(this.mRootView, this.mMiniAppInfo);
        }
        MiniAppInfo miniAppInfo3 = this.mMiniAppInfo;
        if (miniAppInfo3 != null) {
            StartupReportUtil.reportDelete(miniAppInfo3);
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnDestroy() {
        g92.a aVar = this.miniFakeView;
        if (aVar != null) {
            aVar.onDestroy();
        }
        super.doOnDestroy();
        IUIProxy iUIProxy = this.mIUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onDetachActivity(this.mActivity);
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnNewIntent(Intent intent) {
        g92.a aVar;
        MiniAppInfo miniAppInfo = (MiniAppInfo) intent.getParcelableExtra(IPCConst.KEY_APPINFO);
        if (miniAppInfo == null || (aVar = this.miniFakeView) == null) {
            return;
        }
        String str = miniAppInfo.appId;
        String optExtInfo = optExtInfo(miniAppInfo);
        String str2 = miniAppInfo.extendData;
        FirstPageInfo firstPageInfo = miniAppInfo.firstPage;
        aVar.onNewIntent(str, optExtInfo, str2, firstPageInfo == null ? null : firstPageInfo.pagePath);
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnPause() {
        super.doOnPause();
        g92.a aVar = this.miniFakeView;
        if (aVar != null) {
            aVar.onPause();
        }
        IUIProxy iUIProxy = this.mIUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onMiniPause();
        }
    }

    public void doOnPopFragment() {
        g92.a aVar = this.miniFakeView;
        if (aVar instanceof MiniHippyController) {
            ((MiniHippyController) aVar).popOrBackFragment(2);
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnResume() {
        g92.a aVar = this.miniFakeView;
        if (aVar != null) {
            aVar.onResume();
        }
        IUIProxy iUIProxy = this.mIUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onMiniResume();
        }
        super.doOnResume();
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnStart() {
        g92.a aVar = this.miniFakeView;
        if (aVar != null) {
            aVar.onStart();
        }
        IUIProxy iUIProxy = this.mIUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onMiniStart();
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doOnStop() {
        g92.a aVar = this.miniFakeView;
        if (aVar != null) {
            aVar.onStop();
        }
        IUIProxy iUIProxy = this.mIUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onMiniStop();
        }
    }

    public void finishWithError(String str) {
        QQToast.makeText(this.mActivity, 1, "\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8fde\u63a5\u540e\u91cd\u8bd5", 0).show();
        this.mActivity.finish();
        QLog.e(TAG, 1, str);
    }

    public int getEnginType() {
        return this.enginType;
    }

    public void openUrl(String str) {
        this.miniFakeView.openUrl(str);
    }

    public void pushMiniHippy(Intent intent) {
        g92.a aVar = this.miniFakeView;
        if (aVar instanceof MiniHippyController) {
            ((MiniHippyController) aVar).pushMiniHippy(intent);
        }
    }

    public void restart() {
        g92.a aVar = this.miniFakeView;
        if (aVar != null) {
            FrameLayout frameLayout = this.container;
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            String str = miniAppInfo.appId;
            String optExtInfo = optExtInfo(miniAppInfo);
            MiniAppInfo miniAppInfo2 = this.mMiniAppInfo;
            String str2 = miniAppInfo2.extendData;
            FirstPageInfo firstPageInfo = miniAppInfo2.firstPage;
            aVar.handleRestart(frameLayout, str, optExtInfo, str2, firstPageInfo == null ? null : firstPageInfo.pagePath);
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public boolean showMiniAIOEntrance(JSONObject jSONObject) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attachUIProxy(ViewGroup viewGroup, MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            finishWithError("attachUIProxy: parse app info null.");
            return;
        }
        miniAppInfo.appMode.disableAddToMyFavor = true;
        Bundle bundle = new Bundle();
        bundle.putParcelable(IPCConst.KEY_APPINFO, miniAppInfo);
        IUIProxy iUIProxy = this.mIUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onAttachActivity(this.mActivity, bundle, viewGroup);
        }
        loadUI(miniAppInfo);
    }

    private String optExtInfo(MiniAppInfo miniAppInfo) {
        a.KuiklyConfig kuiklyConfig;
        if (miniAppInfo == null) {
            return null;
        }
        String str = miniAppInfo.appId;
        String str2 = miniAppInfo.extInfo;
        if (this.enginType != 2) {
            return str2;
        }
        if (!((IThirdPartyMiniApi) QRoute.api(IThirdPartyMiniApi.class)).isExtInfoContainsMiniGameThirdPartyParams(miniAppInfo)) {
            f92.a aVar = (f92.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101793");
            if (aVar == null || !aVar.a().containsKey(str) || (kuiklyConfig = aVar.a().get(str)) == null) {
                return null;
            }
            return kuiklyConfig.getOpenInfo();
        }
        return ((IThirdPartyMiniApi) QRoute.api(IThirdPartyMiniApi.class)).getKuiklyConfigByExtInfo(miniAppInfo.extInfo);
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void hideMiniAIOEntrance() {
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void doRefreshMiniBadge(Bundle bundle) {
    }

    @Override // com.tencent.mobileqq.minigame.ui.controller.BaseGameActController
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
    }
}
