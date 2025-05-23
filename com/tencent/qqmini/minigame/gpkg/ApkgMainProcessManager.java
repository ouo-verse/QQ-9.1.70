package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.qqmini.minigame.gpkg.GpkgManager;
import com.tencent.qqmini.minigame.manager.EnginePackageUpdater;
import com.tencent.qqmini.minigame.manager.GameVConsoleManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.ipc.GamePkgIPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes23.dex */
public class ApkgMainProcessManager {
    public static final String EXTRA_PROGRESS = "PROGRESS";
    public static final String EXTRA_TOTAL_SIZE = "TOTAL_SIZE";
    public static final String KEY_MINI_APP_CONFIG = "key_mini_app_config";
    private static final String KEY_NEED_DOWNLOAD_IN_MAINPROCESS = "key_force_download_in_mainprocess";
    private static final String KEY_RUN_IN_MAINPROCSS = "key_run_in_mainprocess";
    private static final String TAG = "ApkgMainProcessManager";
    private static final ApkgMainProcessManager ourInstance = new ApkgMainProcessManager();
    private Set<String> subProcessLoadTaskSet = Collections.newSetFromMap(new ConcurrentHashMap());
    private ConcurrentHashMap<String, List<MiniCmdCallback>> cmdCallbackHashMap = new ConcurrentHashMap<>();

    ApkgMainProcessManager() {
    }

    public static void checkShouldLoadPkgInMainProcess(MiniAppInfo miniAppInfo, MiniCmdCallback miniCmdCallback, boolean z16) {
        checkShouldLoadPkgInMainProcess(miniAppInfo, miniCmdCallback, z16, !miniAppInfo.isEngineTypeMiniGame());
    }

    private void checkShouldPerformMainProcessLoadPkg(Bundle bundle, MiniCmdCallback miniCmdCallback) {
        MiniAppInfo miniAppInfo = (MiniAppInfo) bundle.getParcelable("key_mini_app_config");
        boolean z16 = bundle.getBoolean(KEY_RUN_IN_MAINPROCSS, false);
        if (miniAppInfo == null) {
            return;
        }
        if (this.cmdCallbackHashMap.get(miniAppInfo.appId) != null) {
            this.cmdCallbackHashMap.get(miniAppInfo.appId).add(miniCmdCallback);
            return;
        }
        if (!z16) {
            try {
                miniCmdCallback.onCmdResult(true, new Bundle());
                return;
            } catch (RemoteException e16) {
                QMLog.e(TAG, "checkShouldPerformMainProcessLoadPkg: onCmdResult failed.", e16);
                return;
            }
        }
        if (this.subProcessLoadTaskSet.contains(miniAppInfo.appId)) {
            QMLog.w(TAG, "pkg already download in sub process! " + miniAppInfo);
            return;
        }
        this.cmdCallbackHashMap.put(miniAppInfo.appId, new CopyOnWriteArrayList(Collections.singletonList(miniCmdCallback)));
        if (miniAppInfo.isEngineTypeMiniGame()) {
            loadGpkg(miniAppInfo);
        } else {
            loadApkg(miniAppInfo);
        }
    }

    private static void downloadGamePkg(Bundle bundle, MiniCmdCallback miniCmdCallback) {
        bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        MiniAppInfo miniAppInfo = (MiniAppInfo) bundle.getParcelable(GamePkgIPCConst.KEY_GAME_CONFIG);
        if (miniAppInfo == null) {
            c.i(miniCmdCallback, true, c.a("miniAppInfo get null."));
        } else {
            GamePkgDownloader.d(miniAppInfo, bundle.getBoolean(GamePkgIPCConst.KEY_IGNORE_PROGRESS, false), miniCmdCallback);
        }
    }

    private static void downloadGameSubPkg(Bundle bundle, MiniCmdCallback miniCmdCallback) {
        bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        MiniAppInfo miniAppInfo = (MiniAppInfo) bundle.getParcelable(GamePkgIPCConst.KEY_GAME_CONFIG);
        SubPkgInfo subPkgInfo = (SubPkgInfo) bundle.getParcelable(GamePkgIPCConst.KEY_GAME_SUB_PKG_INFO);
        String string = bundle.getString(GamePkgIPCConst.KEY_GAME_SUB_PKG_ROOT, null);
        if (miniAppInfo != null && subPkgInfo != null && !TextUtils.isEmpty(string)) {
            GameSubPkgDownloader.b(miniAppInfo, subPkgInfo, string, miniCmdCallback);
        } else {
            c.i(miniCmdCallback, true, c.a("download params invalid."));
        }
    }

    static ApkgMainProcessManager getInstance() {
        return ourInstance;
    }

    public static void handleMiniAppCmd(String str, Bundle bundle, MiniCmdCallback miniCmdCallback) {
        try {
            if (IPCConst.CMD_CONSOLE_LOG.equals(str)) {
                GameVConsoleManager.m(bundle.getString(IPCConst.KEY_CONSOLE_LOG_MSG));
                return;
            }
            if (IPCConst.CMD_DOWNLOAD_GAME_PKG.equals(str)) {
                downloadGamePkg(bundle, miniCmdCallback);
                return;
            }
            if (IPCConst.CMD_DOWNLOAD_GAME_SUB_PKG.equals(str)) {
                downloadGameSubPkg(bundle, miniCmdCallback);
                return;
            }
            bundle.setClassLoader(ApkgMainProcessManager.class.getClassLoader());
            MiniAppInfo miniAppInfo = (MiniAppInfo) bundle.getParcelable("key_mini_app_config");
            if (miniAppInfo == null) {
                return;
            }
            if (IPCConst.CMD_QUEUE_MINI_PROCESS_LOAD_APKG.equals(str)) {
                getInstance().queueSubProcessLoadTask(miniAppInfo.appId);
                return;
            }
            if (IPCConst.CMD_REMOVE_MINI_PROCESS_LOAD_APKG.equals(str)) {
                getInstance().removeSubProcessLoadTask(miniAppInfo.appId);
            } else if (IPCConst.CMD_MAIN_PROCESS_LOAD_PKG.equals(str)) {
                getInstance().checkShouldPerformMainProcessLoadPkg(bundle, miniCmdCallback);
            } else if ("cmd_update_triton_engine".equals(str)) {
                EnginePackageUpdater.e(miniAppInfo.appId);
            }
        } catch (Throwable th5) {
            QMLog.d(TAG, "handleMiniAppCmd ", th5);
            if (miniCmdCallback != null) {
                try {
                    miniCmdCallback.onCmdResult(true, new Bundle());
                } catch (RemoteException e16) {
                    QMLog.d(TAG, "handleMiniAppCmd ", e16);
                }
            }
        }
    }

    private void loadApkg(final MiniAppInfo miniAppInfo) {
        ApkgManager.getInstance().getApkgInfoByConfig(miniAppInfo, new ApkgManager.OnInitApkgListener() { // from class: com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager.4
            @Override // com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener
            public void onInitApkgInfo(int i3, ApkgInfo apkgInfo, String str) {
                QMLog.d(ApkgMainProcessManager.TAG, "onInitApkgInfo load apkg in main process end " + apkgInfo);
                List<MiniCmdCallback> list = (List) ApkgMainProcessManager.this.cmdCallbackHashMap.remove(miniAppInfo.appId);
                if (list != null) {
                    for (MiniCmdCallback miniCmdCallback : list) {
                        if (miniCmdCallback != null) {
                            try {
                                Bundle bundle = new Bundle();
                                bundle.putInt("retCode", i3);
                                bundle.putString("errMsg", str);
                                miniCmdCallback.onCmdResult(true, bundle);
                            } catch (RemoteException e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }

    private void loadGpkg(final MiniAppInfo miniAppInfo) {
        GpkgManager.performGetGpkgInfoByConfig(miniAppInfo, new GpkgManager.OnInitGpkgListener() { // from class: com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager.5
            @Override // com.tencent.qqmini.minigame.gpkg.GpkgManager.OnInitGpkgListener
            public void onDownloadGpkgProgress(MiniAppInfo miniAppInfo2, float f16, long j3) {
                List<MiniCmdCallback> list = (List) ApkgMainProcessManager.this.cmdCallbackHashMap.get(miniAppInfo.appId);
                if (list != null) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat(ApkgMainProcessManager.EXTRA_PROGRESS, f16);
                    bundle.putLong(ApkgMainProcessManager.EXTRA_TOTAL_SIZE, j3);
                    for (MiniCmdCallback miniCmdCallback : list) {
                        if (miniCmdCallback != null) {
                            try {
                                miniCmdCallback.onCmdResult(false, bundle);
                            } catch (RemoteException unused) {
                            }
                        }
                    }
                }
            }

            @Override // com.tencent.qqmini.minigame.gpkg.GpkgManager.OnInitGpkgListener
            public void onInitGpkgInfo(int i3, MiniGamePkg miniGamePkg, String str, @Nullable GpkgManager.Info info) {
                QMLog.d(ApkgMainProcessManager.TAG, "onInitGpkgInfo load gpkg in main process end " + miniAppInfo);
                List<MiniCmdCallback> list = (List) ApkgMainProcessManager.this.cmdCallbackHashMap.remove(miniAppInfo.appId);
                if (list != null) {
                    for (MiniCmdCallback miniCmdCallback : list) {
                        if (miniCmdCallback != null) {
                            try {
                                Bundle bundle = new Bundle();
                                bundle.putInt("retCode", i3);
                                bundle.putString("errMsg", str);
                                miniCmdCallback.onCmdResult(true, bundle);
                            } catch (RemoteException unused) {
                            }
                        }
                    }
                }
            }
        });
    }

    public static void queueSubProcessLoadTask(final MiniAppInfo miniAppInfo) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_mini_app_config", miniAppInfo);
        AppBrandCmdProxy.g().sendCmd(IPCConst.CMD_QUEUE_MINI_PROCESS_LOAD_APKG, bundle, new MiniCmdCallback.Stub() { // from class: com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager.2
            @Override // com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
            public void onCmdResult(boolean z16, Bundle bundle2) throws RemoteException {
                QMLog.d(ApkgMainProcessManager.TAG, "queueSubProcessLoadTask() called with: miniAppConfig = [" + MiniAppInfo.this + "]");
            }
        });
    }

    public static void removeSubProcessLoadTask(final MiniAppInfo miniAppInfo) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_mini_app_config", miniAppInfo);
        AppBrandCmdProxy.g().sendCmd(IPCConst.CMD_REMOVE_MINI_PROCESS_LOAD_APKG, bundle, new MiniCmdCallback.Stub() { // from class: com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager.3
            @Override // com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
            public void onCmdResult(boolean z16, Bundle bundle2) throws RemoteException {
                QMLog.d(ApkgMainProcessManager.TAG, "removeSubProcessLoadTask() called with: miniAppConfig = [" + MiniAppInfo.this + "]");
            }
        });
    }

    private static void checkShouldLoadPkgInMainProcess(MiniAppInfo miniAppInfo, final MiniCmdCallback miniCmdCallback, boolean z16, final boolean z17) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_mini_app_config", miniAppInfo);
        bundle.putBoolean(KEY_RUN_IN_MAINPROCSS, z16);
        AppBrandCmdProxy.g().sendCmd(IPCConst.CMD_MAIN_PROCESS_LOAD_PKG, bundle, new MiniCmdCallback.Stub() { // from class: com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager.1
            @Override // com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
            public void onCmdResult(boolean z18, Bundle bundle2) throws RemoteException {
                MiniCmdCallback miniCmdCallback2 = MiniCmdCallback.this;
                if (miniCmdCallback2 != null) {
                    miniCmdCallback2.onCmdResult(z18, bundle2);
                }
                if (z17 || z18) {
                    QMLog.d(ApkgMainProcessManager.TAG, "onCmdResult() called with: succ = [" + z18 + "], bundle = [" + bundle2 + "]");
                }
            }
        });
    }

    private void queueSubProcessLoadTask(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.subProcessLoadTaskSet.add(str);
    }

    private void removeSubProcessLoadTask(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.subProcessLoadTaskSet.remove(str);
    }
}
