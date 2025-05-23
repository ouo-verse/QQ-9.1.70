package com.tencent.qqmini.sdk.runtime;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmini.sdk.annotation.RuntimeLoaderConfig;
import com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppPrelaunchRecorder;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.runtime.RuntimeLoaderConfiguration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/* compiled from: P */
@RuntimeLoaderConfig(loaders = {@RuntimeLoaderInfo(className = "com.tencent.qqmini.miniapp.AppRuntimeLoader", type = 1), @RuntimeLoaderInfo(className = "com.tencent.qqmini.minigame.GameRuntimeLoader", type = 4)})
/* loaded from: classes23.dex */
public class AppRuntimeLoaderManager {
    private static final String TAG = "minisdk-start_AppRuntimeLoaderManager";
    private static volatile AppRuntimeLoaderManager instance;
    private static volatile byte[] lock = new byte[0];
    private final int mGameMaxLoaderCount;
    private int mMaxLoaderCount;
    private BaseRuntimeLoader mPrelaunchRuntimeLoader;
    private Bundle mPreloadBundle;
    private BaseRuntimeLoader mPreloadRuntimeLoader;
    private long mRuntimeLoaderRecycleTime;
    private final LinkedList<BaseRuntimeLoader> loadedRuntimeLinkedList = new LinkedList<>();
    private final HashMap<Class<BaseRuntimeLoader>, BaseRuntimeLoader> mEmptyRuntimeLoaderList = new HashMap<>();
    private final Vector<AppRuntimeEventCenter.RuntimeStateObserver> mObservers = new Vector<>();
    private Handler mHandler = ThreadManager.getSubThreadHandler();
    private long mEnterBackgroundTimestamp = 0;
    private int mProcessType = -1;
    private final AppRuntimeEventCenter.RuntimeStateObserver mRuntimeObserver = new AppRuntimeEventCenter.RuntimeStateObserver() { // from class: com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager.1
        @Override // com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver
        public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
            if (miniAppStateMessage != null && miniAppStateMessage.appRuntimeLoader != null) {
                if (QMLog.isDebugEnabled()) {
                    QMLog.i(AppRuntimeLoaderManager.TAG, "OnRuntimeEvent message:" + miniAppStateMessage);
                }
                AppRuntimeLoaderManager.this.notifyAppStateMessageForAll(miniAppStateMessage);
                synchronized (AppRuntimeLoaderManager.this) {
                    try {
                        if (miniAppStateMessage.appRuntimeLoader == AppRuntimeLoaderManager.this.mPreloadRuntimeLoader) {
                            if (AppRuntimeLoaderManager.this.mPreloadRuntimeLoader.getStatus() == 4 || AppRuntimeLoaderManager.this.mPreloadRuntimeLoader.getStatus() == 5) {
                                AppRuntimeLoaderManager.this.mPreloadRuntimeLoader = null;
                                AppRuntimeLoaderManager appRuntimeLoaderManager = AppRuntimeLoaderManager.this;
                                appRuntimeLoaderManager.preloadRuntime(appRuntimeLoaderManager.mPreloadBundle);
                            }
                        } else if (miniAppStateMessage.appRuntimeLoader == AppRuntimeLoaderManager.this.mPrelaunchRuntimeLoader && (AppRuntimeLoaderManager.this.mPrelaunchRuntimeLoader.getStatus() == 5 || miniAppStateMessage.what == 4)) {
                            AppRuntimeLoaderManager.this.mPrelaunchRuntimeLoader = null;
                            AppRuntimeLoaderManager appRuntimeLoaderManager2 = AppRuntimeLoaderManager.this;
                            appRuntimeLoaderManager2.preloadRuntime(appRuntimeLoaderManager2.mPreloadBundle);
                        }
                    } finally {
                    }
                }
            }
        }
    };
    public Runnable processRecycleRunnable = new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager.2
        @Override // java.lang.Runnable
        public void run() {
            AppRuntimeLoaderManager.this.cleanRuntimeLoader();
        }
    };
    private RuntimeLoaderConfiguration mRuntimeConfiguration = new RuntimeLoaderConfiguration(this);

    AppRuntimeLoaderManager() {
        this.mRuntimeLoaderRecycleTime = 900000L;
        this.mMaxLoaderCount = 3;
        initProcessConfig(null);
        this.mMaxLoaderCount = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_APP_RUNTIME_CACHE_MAX, 3);
        this.mGameMaxLoaderCount = WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_GAME_MULTI_INSTANCE, 1);
        this.mRuntimeLoaderRecycleTime = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_APP_RUNTIME_RECYCLE_TIME, 900000L);
        QMLog.i(TAG, "RuntimeLoaderConfig:" + this.mRuntimeConfiguration.toString() + " ProcessType=" + this.mProcessType + " maxRuntime=" + this.mMaxLoaderCount);
    }

    private synchronized void addRuntimeLoader(BaseRuntimeLoader baseRuntimeLoader) {
        if (baseRuntimeLoader != null) {
            if (baseRuntimeLoader.getMiniAppInfo() != null) {
                this.loadedRuntimeLinkedList.addFirst(baseRuntimeLoader);
            }
        }
        int i3 = this.mMaxLoaderCount;
        if (this.mProcessType == 4) {
            i3 = this.mGameMaxLoaderCount;
        }
        if (i3 >= 1 && this.loadedRuntimeLinkedList.size() > i3) {
            BaseRuntimeLoader removeLast = this.loadedRuntimeLinkedList.removeLast();
            removeLast.destroy();
            QMLog.w(TAG, "RuntimeLoader count exceed the maxcount, remove the last one! removed=" + removeLast.toSimpleString());
        }
        notifyRuntimeListInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanRuntimeLoader() {
        QMLog.i(TAG, "clean RuntimeLoader");
        try {
            if (this.loadedRuntimeLinkedList.size() <= 1) {
                return;
            }
            while (this.loadedRuntimeLinkedList.size() > 1) {
                BaseRuntimeLoader removeLast = this.loadedRuntimeLinkedList.removeLast();
                if (removeLast != null) {
                    QMLog.i(TAG, "removed RuntimeLoader:" + removeLast.toSimpleString());
                    removeLast.destroy();
                }
            }
            notifyRuntimeListInfo();
            preloadRuntime(null);
        } catch (Throwable th5) {
            QMLog.e(TAG, "cleanRuntimeLoader exception!", th5);
        }
    }

    public static AppRuntimeLoaderManager g() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AppRuntimeLoaderManager();
                }
            }
        }
        return instance;
    }

    private boolean hasRunningRuntimeLoader() {
        try {
            Iterator it = new ArrayList(this.loadedRuntimeLinkedList).iterator();
            while (it.hasNext()) {
                if (((BaseRuntimeLoader) it.next()).isRunning()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th5) {
            QMLog.e(TAG, "hasRunnintRumtimeLoader exception!", th5);
            return false;
        }
    }

    private void initProcessConfig(Bundle bundle) {
        if (this.mProcessType >= 0) {
            return;
        }
        MiniProcessorConfig currentProcessConfig = MiniAppEnv.g().getCurrentProcessConfig();
        if (currentProcessConfig != null) {
            this.mProcessType = currentProcessConfig.supportRuntimeType;
        }
        if (this.mProcessType < 0 && bundle != null && bundle.containsKey(MiniAppConst.MINI_KEY_PRELOAD_TYPE)) {
            String string = bundle.getString(MiniAppConst.MINI_KEY_PRELOAD_TYPE);
            if (MiniAppConst.PRELOAD_TYPE_APP.equals(string)) {
                this.mProcessType = 3;
            } else if (MiniAppConst.PRELOAD_TYPE_GAME.equals(string)) {
                this.mProcessType = 4;
            }
        }
    }

    private boolean isMatch(BaseRuntimeLoader baseRuntimeLoader, MiniAppInfo miniAppInfo) {
        BaseRuntimeLoader.Creator<?> creator;
        if (baseRuntimeLoader != null && miniAppInfo != null) {
            for (RuntimeLoaderConfiguration.RuntimeLoaderInfo runtimeLoaderInfo : this.mRuntimeConfiguration.getLoaderInfoListForPreload()) {
                if (runtimeLoaderInfo != null && baseRuntimeLoader.getClass() == runtimeLoaderInfo.runtimeLoaderClass && (creator = runtimeLoaderInfo.creator) != null && creator.support(miniAppInfo) && (baseRuntimeLoader.getMiniAppInfo() == null || baseRuntimeLoader.getMiniAppInfo().equals(miniAppInfo))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyAppStateMessageForAll(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
        Iterator<AppRuntimeEventCenter.RuntimeStateObserver> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().onStateChange(miniAppStateMessage);
        }
    }

    private void notifyRuntimeListInfo() {
        ArrayList<MiniAppInfo> allLoadedAppInfos = getAllLoadedAppInfos();
        QMLog.i(TAG, "notifyRuntime runtime info to main process.");
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(IPCConst.KEY_BUNDLE_RUNTIME_LIST, allLoadedAppInfos);
        AppBrandCmdProxy.g().sendCmd(IPCConst.CMD_NOTIFY_RUNTIME_INFO, bundle, new MiniCmdCallback.Stub() { // from class: com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager.5
            @Override // com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
            public void onCmdResult(boolean z16, Bundle bundle2) throws RemoteException {
                QMLog.i(AppRuntimeLoaderManager.TAG, "notifyRuntime runtime info result " + z16);
            }
        });
    }

    private BaseRuntimeLoader obtainEmptyRuntimeLoader(MiniAppInfo miniAppInfo, Bundle bundle) {
        BaseRuntimeLoader baseRuntimeLoader;
        for (RuntimeLoaderConfiguration.RuntimeLoaderInfo runtimeLoaderInfo : this.mRuntimeConfiguration.getLoaderInfoList()) {
            QMLog.i(TAG, "loaderInfo: " + runtimeLoaderInfo);
            if (!runtimeLoaderInfo.creator.isEnginePrepared(bundle)) {
                QMLog.i(TAG, "RuntimeLoader engine is not prepared! " + runtimeLoaderInfo.creator);
            } else if (runtimeLoaderInfo.creator.support(miniAppInfo)) {
                QMLog.i(TAG, "RuntimeLoader engine support: " + runtimeLoaderInfo.creator);
                if (this.mProcessType < 0) {
                    QMLog.w(TAG, "set ProcessType to " + this.mProcessType);
                    this.mProcessType = runtimeLoaderInfo.type;
                }
                if (this.mEmptyRuntimeLoaderList.containsKey(runtimeLoaderInfo.runtimeLoaderClass)) {
                    baseRuntimeLoader = this.mEmptyRuntimeLoaderList.remove(runtimeLoaderInfo.runtimeLoaderClass);
                } else {
                    baseRuntimeLoader = (BaseRuntimeLoader) runtimeLoaderInfo.creator.create(MiniAppEnv.g().getContext(), bundle);
                }
                baseRuntimeLoader.addRuntimeStateObserver(this.mRuntimeObserver);
                return baseRuntimeLoader;
            }
        }
        return null;
    }

    public synchronized void addAppEventObserverForAll(AppRuntimeEventCenter.RuntimeStateObserver runtimeStateObserver) {
        if (runtimeStateObserver != null) {
            if (!this.mObservers.contains(runtimeStateObserver)) {
                this.mObservers.addElement(runtimeStateObserver);
            }
        }
    }

    public void bringToFront(BaseRuntimeLoader baseRuntimeLoader) {
        try {
            this.loadedRuntimeLinkedList.remove(baseRuntimeLoader);
            this.loadedRuntimeLinkedList.addFirst(baseRuntimeLoader);
        } catch (Throwable th5) {
            QMLog.e(TAG, "bringToFront exception!", th5);
        }
    }

    public BaseRuntimeLoader createAppRuntimeLoader(MiniAppInfo miniAppInfo, final BaseRuntimeLoader.OnAppRuntimeLoadListener onAppRuntimeLoadListener, Bundle bundle) {
        if (miniAppInfo == null) {
            QMLog.e(TAG, "Failed to createAppRuntimeLoader, appInfo is null");
            return null;
        }
        try {
            BaseRuntimeLoader baseRuntimeLoader = this.mPreloadRuntimeLoader;
            if (baseRuntimeLoader != null && !isMatch(baseRuntimeLoader, miniAppInfo) && this.mPreloadRuntimeLoader.isRunning()) {
                QMLog.i(TAG, "createAppRuntimeLoader, stop the preloading runtimeloader " + this.mPreloadRuntimeLoader.toSimpleString());
                this.mPreloadRuntimeLoader.pause();
            }
            BaseRuntimeLoader baseRuntimeLoader2 = this.mPrelaunchRuntimeLoader;
            if (baseRuntimeLoader2 != null && !isMatch(baseRuntimeLoader2, miniAppInfo) && this.mPrelaunchRuntimeLoader.isRunning()) {
                QMLog.i(TAG, "createAppRuntimeLoader, stop the prelaunch runtimeloader " + this.mPrelaunchRuntimeLoader.toSimpleString());
                this.mPrelaunchRuntimeLoader.pause();
            }
            BaseRuntimeLoader obtainEmptyRuntimeLoader = obtainEmptyRuntimeLoader(miniAppInfo, bundle);
            QMLog.i(TAG, "createAppRuntimeLoader appId=" + miniAppInfo.appId + " versionType=" + miniAppInfo.verType + " version=" + miniAppInfo.version + " obtainRuntimeLoader:" + obtainEmptyRuntimeLoader);
            if (obtainEmptyRuntimeLoader != null) {
                obtainEmptyRuntimeLoader.setRuntimeLoadListener(new BaseRuntimeLoader.OnAppRuntimeLoadListener() { // from class: com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager.3
                    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.OnAppRuntimeLoadListener
                    public void onResult(int i3, String str, BaseRuntimeLoader baseRuntimeLoader3) {
                        try {
                            BaseRuntimeLoader.OnAppRuntimeLoadListener onAppRuntimeLoadListener2 = onAppRuntimeLoadListener;
                            if (onAppRuntimeLoadListener2 != null) {
                                onAppRuntimeLoadListener2.onResult(i3, str, baseRuntimeLoader3);
                            }
                            if (i3 != 0) {
                                QMLog.e(AppRuntimeLoaderManager.TAG, "runtime load result error! remove it. retCode = " + i3);
                                AppRuntimeLoaderManager.this.removeRuntimeLoader(baseRuntimeLoader3);
                            }
                        } catch (Throwable th5) {
                            QMLog.e(AppRuntimeLoaderManager.TAG, "runtime load result exception! remove it. ", th5);
                            AppRuntimeLoaderManager.this.removeRuntimeLoader(baseRuntimeLoader3);
                        }
                    }
                });
                obtainEmptyRuntimeLoader.setMiniAppInfo(miniAppInfo);
                addRuntimeLoader(obtainEmptyRuntimeLoader);
            }
            return obtainEmptyRuntimeLoader;
        } catch (Throwable th5) {
            QMLog.e(TAG, "getAppBrandRunTime exception!", th5);
            return null;
        }
    }

    public synchronized void deleteAppEventObserverForAll(AppRuntimeEventCenter.RuntimeStateObserver runtimeStateObserver) {
        if (runtimeStateObserver != null) {
            this.mObservers.removeElement(runtimeStateObserver);
        }
    }

    public ArrayList<MiniAppInfo> getAllLoadedAppInfos() {
        ArrayList<MiniAppInfo> arrayList = new ArrayList<>();
        Iterator it = new ArrayList(this.loadedRuntimeLinkedList).iterator();
        while (it.hasNext()) {
            MiniAppInfo miniAppInfo = ((BaseRuntimeLoader) it.next()).getMiniAppInfo();
            if (miniAppInfo != null) {
                arrayList.add(miniAppInfo);
            }
        }
        return arrayList;
    }

    @Deprecated
    public BaseRuntimeLoader getCurrentRunTimeLoader() {
        try {
            LinkedList linkedList = new LinkedList(this.loadedRuntimeLinkedList);
            if (linkedList.size() > 0) {
                return (BaseRuntimeLoader) linkedList.peekFirst();
            }
            return null;
        } catch (Throwable th5) {
            QMLog.e(TAG, "getCurrentRunTimeLoader exception!", th5);
            return null;
        }
    }

    public BaseRuntimeLoader getPrepareRuntimeLoader() {
        BaseRuntimeLoader baseRuntimeLoader = this.mPrelaunchRuntimeLoader;
        if (baseRuntimeLoader != null) {
            return baseRuntimeLoader;
        }
        return this.mPreloadRuntimeLoader;
    }

    public void onEnterBackground() {
        QMLog.i(TAG, "onEnterBackground");
        this.mEnterBackgroundTimestamp = System.currentTimeMillis();
        this.mHandler.removeCallbacks(this.processRecycleRunnable);
        this.mHandler.postDelayed(this.processRecycleRunnable, this.mRuntimeLoaderRecycleTime);
        preloadRuntime(null);
    }

    public void onEnterForeground(@NonNull BaseRuntimeLoader baseRuntimeLoader) {
        QMLog.i(TAG, "onEnterForeground");
        this.mEnterBackgroundTimestamp = 0L;
        bringToFront(baseRuntimeLoader);
        this.mHandler.removeCallbacks(this.processRecycleRunnable);
    }

    public void preLaunchRuntimeLoader(MiniAppInfo miniAppInfo, final BaseRuntimeLoader.OnAppRuntimeLoadListener onAppRuntimeLoadListener, Bundle bundle) {
        if (miniAppInfo == null) {
            QMLog.e(TAG, "Failed to preLaunchRuntimeLoader, appInfo is null");
            QMLog.e(TAG, "Failed to preLaunch RuntimeLoader, appInfo is null");
            return;
        }
        String config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_PRELAUNCH_WHITE_LIST, WnsConfig.DEFAULT_PRELAUNCH_WHITE_LIST);
        QMLog.i(TAG, "preLaunch whitelist=" + config + " appid=" + miniAppInfo.appId);
        if (!TextUtils.isEmpty(config) && config.contains(miniAppInfo.appId)) {
            if (this.mPrelaunchRuntimeLoader != null) {
                QMLog.e(TAG, "There is a preLaunch loader now! Stop preLaunch!");
                return;
            }
            MiniAppPrelaunchRecorder.get().onPrelaunch(miniAppInfo.appId);
            try {
                BaseRuntimeLoader queryAppRunTimeLoader = queryAppRunTimeLoader(miniAppInfo);
                if (queryAppRunTimeLoader != null) {
                    QMLog.w(TAG, "preLaunchRuntimeLoader, There is a loader now! No need PreLaunch! " + queryAppRunTimeLoader.toSimpleString());
                    return;
                }
                if (hasRunningRuntimeLoader()) {
                    QMLog.w(TAG, "preLaunchRuntimeLoader, There is a running loader now! Stop prelaunch!");
                    return;
                }
                BaseRuntimeLoader baseRuntimeLoader = this.mPreloadRuntimeLoader;
                if (baseRuntimeLoader != null && baseRuntimeLoader.isRunning()) {
                    QMLog.i(TAG, "preLaunchRuntimeLoader, There is a running preload loader now " + this.mPreloadRuntimeLoader.toSimpleString());
                    return;
                }
                BaseRuntimeLoader obtainEmptyRuntimeLoader = obtainEmptyRuntimeLoader(miniAppInfo, bundle);
                if (obtainEmptyRuntimeLoader != null) {
                    QMLog.i(TAG, "preLaunchRuntimeLoader, appId=" + miniAppInfo.appId + " name=" + miniAppInfo.name + " versionType=" + miniAppInfo.verType + " version=" + miniAppInfo.version + " obtainRuntimeLoader:" + obtainEmptyRuntimeLoader.toSimpleString());
                    obtainEmptyRuntimeLoader.setRuntimeLoadListener(new BaseRuntimeLoader.OnAppRuntimeLoadListener() { // from class: com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager.4
                        @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.OnAppRuntimeLoadListener
                        public void onResult(int i3, String str, BaseRuntimeLoader baseRuntimeLoader2) {
                            try {
                                BaseRuntimeLoader.OnAppRuntimeLoadListener onAppRuntimeLoadListener2 = onAppRuntimeLoadListener;
                                if (onAppRuntimeLoadListener2 != null) {
                                    onAppRuntimeLoadListener2.onResult(i3, str, baseRuntimeLoader2);
                                }
                                if (i3 != 0) {
                                    AppRuntimeLoaderManager.this.removeRuntimeLoader(baseRuntimeLoader2);
                                }
                            } catch (Throwable th5) {
                                QMLog.e(AppRuntimeLoaderManager.TAG, "runtime load result exception!", th5);
                            }
                        }
                    });
                    obtainEmptyRuntimeLoader.setMiniAppInfo(miniAppInfo);
                    obtainEmptyRuntimeLoader.getAppStateManager().isFromPrelaunch = true;
                }
                this.mPrelaunchRuntimeLoader = obtainEmptyRuntimeLoader;
                if (obtainEmptyRuntimeLoader != null) {
                    obtainEmptyRuntimeLoader.start();
                }
                addRuntimeLoader(obtainEmptyRuntimeLoader);
                return;
            } catch (Throwable th5) {
                QMLog.e(TAG, "preLaunchRuntimeLoader exception!", th5);
                return;
            }
        }
        QMLog.e(TAG, "preLaunch white list not hit, Stop preLaunch!");
    }

    public void preloadRuntime(Bundle bundle) {
        initProcessConfig(bundle);
        if (bundle != null) {
            this.mPreloadBundle = bundle;
        }
        QMLog.w(TAG, "preloadRuntime with ProcessType=" + this.mProcessType);
        if (this.mProcessType < 0) {
            return;
        }
        if (hasRunningRuntimeLoader()) {
            QMLog.w(TAG, "There is a running loader now! Stop preload!");
            return;
        }
        BaseRuntimeLoader baseRuntimeLoader = this.mPreloadRuntimeLoader;
        if (baseRuntimeLoader != null && baseRuntimeLoader.isPause()) {
            QMLog.w(TAG, "Resume the preload runtime! " + this.mPreloadRuntimeLoader.toSimpleString());
            this.mPreloadRuntimeLoader.resume();
            return;
        }
        BaseRuntimeLoader baseRuntimeLoader2 = this.mPreloadRuntimeLoader;
        if (baseRuntimeLoader2 != null && baseRuntimeLoader2.isRunning()) {
            QMLog.w(TAG, "There is already a preload runtime now! " + this.mPreloadRuntimeLoader.toSimpleString());
            return;
        }
        for (RuntimeLoaderConfiguration.RuntimeLoaderInfo runtimeLoaderInfo : this.mRuntimeConfiguration.getLoaderInfoListForPreload()) {
            if ((this.mProcessType & runtimeLoaderInfo.type) != 0) {
                if (!runtimeLoaderInfo.creator.isEnginePrepared(bundle)) {
                    QMLog.e(TAG, "The loader engine is not prepared! " + runtimeLoaderInfo.runtimeLoaderClass.getSimpleName());
                    runtimeLoaderInfo.creator.doPrepareEngine(bundle);
                } else if (!this.mEmptyRuntimeLoaderList.containsKey(runtimeLoaderInfo.runtimeLoaderClass)) {
                    BaseRuntimeLoader.Creator<?> creator = runtimeLoaderInfo.creator;
                    Context context = MiniAppEnv.g().getContext();
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    BaseRuntimeLoader baseRuntimeLoader3 = (BaseRuntimeLoader) creator.create(context, bundle);
                    baseRuntimeLoader3.addRuntimeStateObserver(this.mRuntimeObserver);
                    baseRuntimeLoader3.getAppStateManager().isFromPreload = true;
                    baseRuntimeLoader3.start();
                    this.mEmptyRuntimeLoaderList.put(runtimeLoaderInfo.runtimeLoaderClass, baseRuntimeLoader3);
                    this.mPreloadRuntimeLoader = baseRuntimeLoader3;
                    return;
                }
            }
        }
    }

    @Nullable
    public BaseRuntimeLoader queryAppRunTimeLoader(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return null;
        }
        if (QMLog.isDebugEnabled()) {
            QMLog.i(TAG, "queryAppRunTimeLoader appId=" + miniAppInfo.appId + " versionType=" + miniAppInfo.verType + " version=" + miniAppInfo.version);
        }
        try {
            for (BaseRuntimeLoader baseRuntimeLoader : new ArrayList(this.loadedRuntimeLinkedList)) {
                if (baseRuntimeLoader.getMiniAppInfo() != null && baseRuntimeLoader.getMiniAppInfo().equals(miniAppInfo)) {
                    return baseRuntimeLoader;
                }
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "getAppBrandRunTime exception!", th5);
        }
        return null;
    }

    public synchronized void removeRuntimeLoader(BaseRuntimeLoader baseRuntimeLoader) {
        if (baseRuntimeLoader != null) {
            if (this.loadedRuntimeLinkedList.remove(baseRuntimeLoader)) {
                QMLog.i(TAG, "removed RuntimeLoader:" + baseRuntimeLoader.toSimpleString());
                baseRuntimeLoader.destroy();
                notifyRuntimeListInfo();
            }
        }
    }
}
