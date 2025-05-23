package com.tencent.qqmini.miniapp.core;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine;
import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;
import com.tencent.qqmini.miniapp.core.service.AppV8JsService;
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl;
import com.tencent.qqmini.sdk.core.Preloadable;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.PreCacheManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import com.tencent.qqmini.sdk.plugins.engine.c;
import com.tencent.qqmini.sdk.runtime.AppStateManager;
import com.tencent.qqmini.sdk.widget.MiniToast;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class BaseAppBrandRuntime extends BaseRuntimeImpl implements Preloadable<IAppBrandService> {
    private static final String TAG = "minisdk-start_BaseAppBrandRuntime";
    protected IAppBrandService appBrandService;
    protected JsPluginEngine jsPluginEngine;
    protected Activity mActivity;
    protected ApkgInfo mApkgInfo;
    protected AppStateManager mAppStateManager;
    protected String mEntryPath;
    protected EventListener mEventListener;
    private boolean mIsForground;
    protected MiniAppInfo mMiniAppInfo;
    protected boolean mPrecacheFetched;
    protected ViewGroup mRootLayout;
    protected IAppBrandPageContainer pageContainer;

    public BaseAppBrandRuntime(Context context) {
        super(context);
        this.mPrecacheFetched = false;
        this.mIsForground = true;
        this.mEventListener = new EventListener(this);
    }

    public AppStateManager getAppStateManager() {
        return this.mAppStateManager;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IBaseAppContext
    /* renamed from: getAttachedActivity */
    public Activity getAttachActivity() {
        return this.mActivity;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public String getBaseLibVersion() {
        return BaseLibManager.g().getBaseLibInfo().baseLibVersion;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IBaseAppContext
    public Context getContext() {
        return AppLoaderFactory.g().getContext();
    }

    public EventListener getEventListener() {
        return this.mEventListener;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public IJsService getJsService() {
        return this.appBrandService;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public MiniAppInfo getMiniAppInfo() {
        return this.mMiniAppInfo;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public IPage getPage() {
        return this.pageContainer;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public ShareState getShareState() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    /* renamed from: isForeground */
    public boolean getIsForeground() {
        return this.mIsForground;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public boolean isMiniGame() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public boolean isOrientationLandscape() {
        Activity activity;
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        if ((miniAppProxy != null && miniAppProxy.getDeviceType() == MiniAppProxy.DeviceType.PHONE) || (activity = this.mActivity) == null || activity.getResources().getConfiguration().orientation != 1) {
            return false;
        }
        return true;
    }

    protected void launchPage(MiniAppInfo miniAppInfo, boolean z16, String str) {
        String str2;
        String str3;
        ApkgBaseInfo apkgBaseInfo;
        if (z16) {
            this.pageContainer.cleanup(false);
        }
        if (TextUtils.isEmpty(str)) {
            str = miniAppInfo.launchParam.entryPath;
        }
        if (TextUtils.isEmpty(str)) {
            if (miniAppInfo != null && (apkgBaseInfo = miniAppInfo.apkgInfo) != null && ((ApkgInfo) apkgBaseInfo).mAppConfigInfo != null) {
                str3 = ((ApkgInfo) apkgBaseInfo).mAppConfigInfo.entryPagePath;
            } else {
                str3 = null;
            }
            str = str3;
        }
        IAppBrandPageContainer iAppBrandPageContainer = this.pageContainer;
        if (z16) {
            str2 = "reLaunch";
        } else {
            str2 = EventListener.APPLAUNCH;
        }
        iAppBrandPageContainer.launch(str, str2);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void loadMiniApp(MiniAppInfo miniAppInfo) {
        QMLog.i(TAG, " [MiniLifecycle] loadMiniApp");
        if (this.mApkgInfo != null) {
            return;
        }
        this.mMiniAppInfo = miniAppInfo;
        this.mApkgInfo = (ApkgInfo) miniAppInfo.apkgInfo;
        ((MiniAppFileManager) getManager(MiniAppFileManager.class)).initFileManager(this.mApkgInfo, false);
        AppBrandUtil.updateAppLaunchInfoForApkgInfo(miniAppInfo);
        if (!this.mPrecacheFetched) {
            this.mPrecacheFetched = true;
            PreCacheManager.g().fetchPreCacheData(this.mMiniAppInfo);
            PreCacheManager.g().fetchPreResourceIfNeed(this.mMiniAppInfo);
        }
        this.mEntryPath = this.mMiniAppInfo.launchParam.entryPath;
        JsPluginEngine jsPluginEngine = this.jsPluginEngine;
        if (jsPluginEngine != null) {
            jsPluginEngine.onCreate(this);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public boolean onBackPress() {
        IAppBrandPageContainer iAppBrandPageContainer = this.pageContainer;
        if (iAppBrandPageContainer != null && iAppBrandPageContainer.navigateBack(1, -1)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onLoadMiniAppInfo(final MiniAppInfo miniAppInfo, final boolean z16, final String str) {
        this.mMiniAppInfo = miniAppInfo;
        this.mApkgInfo = (ApkgInfo) miniAppInfo.apkgInfo;
        this.mEntryPath = miniAppInfo.launchParam.entryPath;
        this.jsPluginEngine.onCreate(this);
        this.pageContainer.setMiniAppInfo(miniAppInfo);
        this.pageContainer.setFromReload(z16);
        StateMachine.State currState = ((AbsAppBrandService) this.appBrandService).getCurrState();
        IAppBrandService iAppBrandService = this.appBrandService;
        if (currState == ((AbsAppBrandService) iAppBrandService).stateLoadSucc) {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseAppBrandRuntime.this.launchPage(miniAppInfo, z16, str);
                }
            });
        } else {
            ((AbsAppBrandService) iAppBrandService).addStateChangeListener(new StateMachine.OnStateChangeListener() { // from class: com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime.2
                @Override // com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener
                public void onStateChanged() {
                    if (((AbsAppBrandService) BaseAppBrandRuntime.this.appBrandService).getCurrState() == ((AbsAppBrandService) BaseAppBrandRuntime.this.appBrandService).stateLoadSucc) {
                        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                BaseAppBrandRuntime.this.launchPage(miniAppInfo, z16, str);
                            }
                        });
                    }
                }
            });
            this.appBrandService.setApkgInfo((ApkgInfo) miniAppInfo.apkgInfo);
        }
        if ((this.appBrandService instanceof AppV8JsService) && ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime.3
                @Override // java.lang.Runnable
                public void run() {
                    MiniToast.makeText(BaseAppBrandRuntime.this.getContext(), "run with v8rt", 0).show();
                }
            });
        }
        if (!FastClickUtils.isFastDoubleClick(TAG, 200L)) {
            QMLog.i(TAG, "onLoadMiniAppInfo miniAppInfo=" + miniAppInfo + ",fromReload=" + z16 + " is run with v8rt:" + (this.appBrandService instanceof AppV8JsService));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeAttachActivity(Activity activity, ViewGroup viewGroup) {
        QMLog.i(TAG, " [MiniLifecycle] onRuntimeAttachActivity");
        if (this.mActivity == activity && this.mRootLayout == viewGroup) {
            return;
        }
        this.mActivity = activity;
        this.mRootLayout = viewGroup;
        this.pageContainer.onAttachedToActivity(activity);
        if (this.pageContainer.getContentView() != null && this.pageContainer.getContentView().getParent() != null) {
            ((ViewGroup) this.pageContainer.getContentView().getParent()).removeView(this.pageContainer.getContentView());
        }
        viewGroup.addView(this.pageContainer.getContentView(), new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void onRuntimeCreate() {
        QMLog.i(TAG, " [MiniLifecycle] onRuntimeCreate");
        this.jsPluginEngine = new c(this.mContext);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeDetachActivity(Activity activity) {
        QMLog.i(TAG, " [MiniLifecycle] onRuntimeDetachActivity");
        try {
            if (this.mRootLayout != null && this.pageContainer.getContentView() != null) {
                this.mRootLayout.removeView(this.pageContainer.getContentView());
            }
            this.mActivity = null;
            this.mRootLayout = null;
        } catch (Throwable th5) {
            QMLog.e(TAG, " onRuntimeDetachActivity e = " + th5.getMessage());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimePause() {
        QMLog.i(TAG, " [MiniLifecycle] onRuntimePause");
        this.mIsForground = false;
        IAppBrandPageContainer iAppBrandPageContainer = this.pageContainer;
        if (iAppBrandPageContainer != null) {
            iAppBrandPageContainer.onPause();
        }
        JsPluginEngine jsPluginEngine = this.jsPluginEngine;
        if (jsPluginEngine != null) {
            jsPluginEngine.onPause();
        }
        this.lastStayTime += System.currentTimeMillis() - this.onResumeTime;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeResume() {
        QMLog.i(TAG, " [MiniLifecycle] onRuntimeResume");
        this.mIsForground = true;
        IAppBrandPageContainer iAppBrandPageContainer = this.pageContainer;
        if (iAppBrandPageContainer != null) {
            iAppBrandPageContainer.onResume();
        }
        JsPluginEngine jsPluginEngine = this.jsPluginEngine;
        if (jsPluginEngine != null) {
            jsPluginEngine.onResume();
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.onResumeTime = currentTimeMillis;
        if (this.startTime == 0) {
            this.startTime = currentTimeMillis;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeStart() {
        QMLog.i(TAG, " [MiniLifecycle] onRuntimeStart");
        JsPluginEngine jsPluginEngine = this.jsPluginEngine;
        if (jsPluginEngine != null) {
            jsPluginEngine.onStart();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeStop() {
        QMLog.i(TAG, " [MiniLifecycle] onRuntimeStop");
        IAppBrandPageContainer iAppBrandPageContainer = this.pageContainer;
        if (iAppBrandPageContainer != null) {
            iAppBrandPageContainer.onStop();
        }
        JsPluginEngine jsPluginEngine = this.jsPluginEngine;
        if (jsPluginEngine != null) {
            jsPluginEngine.onStop();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void onUpdateMiniAppInfo(MiniAppInfo miniAppInfo) {
        MiniAppInfo miniAppInfo2 = this.mMiniAppInfo;
        if (miniAppInfo2 != null) {
            miniAppInfo2.launchParam.clone(miniAppInfo.launchParam);
        } else {
            this.mMiniAppInfo = miniAppInfo;
        }
        this.pageContainer.setMiniAppInfo(miniAppInfo);
        this.appBrandService.setApkgInfo((ApkgInfo) miniAppInfo.apkgInfo);
    }

    public void setAppStateManager(AppStateManager appStateManager) {
        this.mAppStateManager = appStateManager;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public JsPluginEngine getJsPluginEngine() {
        return this.jsPluginEngine;
    }

    @Override // com.tencent.qqmini.sdk.core.Preloadable
    public void init(IAppBrandService iAppBrandService) {
        QMLog.i(TAG, " [MiniLifecycle] init");
        if (iAppBrandService == null) {
            QMLog.e(TAG, "customJsService is null!");
        } else {
            this.appBrandService = iAppBrandService;
            iAppBrandService.setAppBrandEventInterface(this.mEventListener);
        }
    }
}
