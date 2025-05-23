package com.tencent.qqmini.sdk.core;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.manager.ApkgLoader;
import com.tencent.qqmini.sdk.core.manager.impl.InternalBaselibLoader;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.annotation.BindClass;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.dynamic.MiniAppDexLoader;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniServiceFetcher;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppInterface;
import com.tencent.qqmini.sdk.launcher.shell.IMiniGameEnv;
import com.tencent.qqmini.sdk.launcher.shell.IReceiverProxy;
import com.tencent.qqmini.sdk.launcher.shell.IShareManager;
import com.tencent.qqmini.sdk.launcher.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class MiniAppEnv implements IMiniAppEnv {
    private static final String GAME_UI_PROXY_CLASS_NAME = "com.tencent.qqmini.minigame.ui.GameUIProxy";
    private static final String TAG = "MiniAppEnv";

    @BindClass(className = "com.tencent.qqmini.sdk.core.manager.ActivityResultManagerFaker")
    private IActivityResultManager activityResultManager;

    @BindClass(className = "com.tencent.qqmini.sdk.runtime.AppUIProxy")
    private IUIProxy appInternalUIProxy;

    @BindClass(className = "com.tencent.qqmini.sdk.runtime.AppUIProxy")
    private IUIProxy appUIProxy;
    private boolean hasInitialized;
    protected Context mContext;
    private IMiniGameEnv mMiniGameEnv;
    private IMiniServiceManager mMiniServiceManager;
    private List<MiniProcessorConfig> mProcessList;

    @BindClass(className = "com.tencent.qqmini.sdk.manager.MiniAppInterface")
    private IMiniAppInterface miniAppInterface;

    @BindClass(className = "com.tencent.qqmini.sdk.receiver.MainReceiverProxy")
    private IReceiverProxy receiverProxy;

    @BindClass(className = "com.tencent.qqmini.sdk.core.manager.ShareManager")
    private IShareManager shareManager;
    protected ApkgLoader mApkgLoader = ApkgLoader.g();
    protected BaselibLoader sBaselibLoader = new InternalBaselibLoader();
    private String mMenuStyle = MiniAppConst.MENU_STYLE_LIGHT;
    private LoginInfo mLoginInfo = new LoginInfo();
    private Map<String, AuthState> mAuthStateMap = new HashMap();
    private Map<String, WeakReference<IUIProxy>> mUIProxyMap = new HashMap();

    private void bindFields() {
        for (Field field : getClass().getDeclaredFields()) {
            AppBrandUtil.bindField(this, field);
        }
    }

    public static MiniAppEnv g() {
        return (MiniAppEnv) AppLoaderFactory.g().getMiniAppEnv();
    }

    private String getMiniAppKey(MiniAppInfo miniAppInfo) {
        return miniAppInfo.appId + "_" + miniAppInfo.verType + miniAppInfo.engineType;
    }

    private void initLoginInfo(Intent intent) {
        try {
            LoginInfo loginInfo = (LoginInfo) intent.getParcelableExtra(IPCConst.KEY_LOGININFO);
            if (loginInfo != null) {
                this.mLoginInfo = loginInfo;
            }
        } catch (Exception e16) {
            QMLog.i(AppLoaderFactory.TAG, "parse loginInfo error", e16);
        }
    }

    private void initMiniServiceManager(Intent intent) {
        try {
            MiniServiceFetcher miniServiceFetcher = (MiniServiceFetcher) intent.getParcelableExtra(IPCConst.KEY_MINI_SERVICE_MANAGER);
            if (miniServiceFetcher != null) {
                this.mMiniServiceManager = miniServiceFetcher.getMiniServiceManager();
            }
        } catch (Exception e16) {
            QMLog.i(AppLoaderFactory.TAG, "parse loginInfo error", e16);
        }
    }

    private void processConfiguration(Configuration configuration) {
        if (this.mContext == null) {
            QMLog.e(TAG, "processConfiguration with Context is null!");
            return;
        }
        if (configuration == null) {
            QMLog.e(TAG, "processConfiguration with Configuration is null!");
            return;
        }
        this.mProcessList = new ArrayList();
        for (Configuration.ProcessInfo processInfo : configuration.processInfoList) {
            MiniProcessorConfig miniProcessorConfig = new MiniProcessorConfig(processInfo.processType, processInfo.name, processInfo.uiClass, processInfo.internalUIClass, processInfo.receiverClass, processInfo.supportRuntimeType);
            QMLog.i(TAG, "createConfiguration. Add processor config: " + miniProcessorConfig);
            this.mProcessList.add(miniProcessorConfig);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
    public IActivityResultManager getActivityResultManager() {
        return this.activityResultManager;
    }

    public ApkgLoader getApkgLoader() {
        return this.mApkgLoader;
    }

    public AuthState getAuthSate(String str) {
        AuthState authState;
        if (this.mAuthStateMap.containsKey(str)) {
            return this.mAuthStateMap.get(str);
        }
        synchronized (this.mAuthStateMap) {
            authState = this.mAuthStateMap.get(str);
            if (authState == null) {
                AuthState authState2 = new AuthState(getContext(), str, LoginManager.getInstance().getAccount());
                this.mAuthStateMap.put(str, authState2);
                authState = authState2;
            }
        }
        return authState;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
    public BaselibLoader getBaselibLoader() {
        if (AppLoaderFactory.g().getBaselibLoader() != null) {
            return AppLoaderFactory.g().getBaselibLoader();
        }
        return this.sBaselibLoader;
    }

    public Context getContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        throw new RuntimeException("Should call init() first!");
    }

    public MiniProcessorConfig getCurrentProcessConfig() {
        if (this.mProcessList == null) {
            return null;
        }
        String processName = AppLoaderFactory.g().getProcessName();
        if (TextUtils.isEmpty(processName)) {
            return null;
        }
        for (MiniProcessorConfig miniProcessorConfig : this.mProcessList) {
            if (miniProcessorConfig != null && processName.equals(miniProcessorConfig.processName)) {
                return miniProcessorConfig;
            }
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
    public boolean getInnerMode() {
        return ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isInnerMode();
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
    public LoginInfo getLoginInfo() {
        return this.mLoginInfo;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
    public String getMenuStyle() {
        return this.mMenuStyle;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
    public IMiniGameEnv getMiniGameEnv() {
        return this.mMiniGameEnv;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
    public IMiniServiceManager getMiniServiceManager() {
        return this.mMiniServiceManager;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
    public boolean getPreloadApkgState() {
        return ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isPreloadApkgState();
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
    public IReceiverProxy getReceiverProxy() {
        return this.receiverProxy;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
    public IShareManager getShareManager() {
        return this.shareManager;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
    public IUIProxy getUIProxy(MiniAppInfo miniAppInfo) {
        IUIProxy iUIProxy;
        if (miniAppInfo == null) {
            QMLog.e(TAG, "Failed to getAppUIProxy, miniAppInfo is null, return default appUIProxy");
            return this.appUIProxy;
        }
        if (miniAppInfo.isEngineTypeMiniGame()) {
            WeakReference<IUIProxy> weakReference = this.mUIProxyMap.get(getMiniAppKey(miniAppInfo));
            if (weakReference == null || (iUIProxy = weakReference.get()) == null || iUIProxy.isDestroyed()) {
                IUIProxy iUIProxy2 = (IUIProxy) MiniAppDexLoader.g().create(GAME_UI_PROXY_CLASS_NAME);
                this.mUIProxyMap.put(getMiniAppKey(miniAppInfo), new WeakReference<>(iUIProxy2));
                return iUIProxy2;
            }
            return iUIProxy;
        }
        if (miniAppInfo.isInternalApp()) {
            return this.appInternalUIProxy;
        }
        return this.appUIProxy;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
    public void init(Context context, Configuration configuration) {
        if (this.hasInitialized) {
            return;
        }
        this.mContext = context;
        processConfiguration(configuration);
        bindFields();
        this.miniAppInterface.onCreate(context, configuration);
        this.hasInitialized = true;
        QMLog.i(TAG, "Init MiniAppEnv. MiniSdkVersion:1.83.3_576_90d624bd9 QUA:" + QUAUtil.getQUA() + " PlatformQUA:" + QUAUtil.getPlatformQUA());
    }

    public void setApkgLoader(ApkgLoader apkgLoader) {
        this.mApkgLoader = apkgLoader;
    }

    @Deprecated
    public void setBaselibLoader(BaselibLoader baselibLoader) {
        this.sBaselibLoader = baselibLoader;
    }

    public void setMenuStyle(String str) {
        this.mMenuStyle = str;
    }

    public void setMiniGameEnv(IMiniGameEnv iMiniGameEnv) {
        this.mMiniGameEnv = iMiniGameEnv;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
    public void setupWithIntent(Intent intent) {
        initMiniServiceManager(intent);
        initLoginInfo(intent);
    }
}
