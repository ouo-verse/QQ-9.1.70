package com.tencent.qqmini.sdk.cache;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniCacheFreeManager;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class MiniCacheFreeManager implements IMiniCacheFreeManager {
    private static final String TAG = "MiniCacheFreeManager";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class a extends MiniCustomDialog {
        private final WeakReference<IMiniAppContext> C;

        a(Context context, int i3, IMiniAppContext iMiniAppContext) {
            super(context, i3);
            this.C = new WeakReference<>(iMiniAppContext);
        }

        public static a N(Context context, IMiniAppContext iMiniAppContext, String str, String str2, int i3, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
            a aVar = new a(context, R.style.mini_sdk_MiniAppInputDialog, iMiniAppContext);
            aVar.setContentView(R.layout.mini_sdk_custom_dialog_temp);
            aVar.setTitle(str);
            aVar.setMessage(str2);
            aVar.setNegativeButton(i3, onClickListener2);
            aVar.setPositiveButton(i16, onClickListener);
            aVar.setCanceledOnTouchOutside(false);
            return aVar;
        }

        @Nullable
        public IMiniAppContext O() {
            return this.C.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearAllFileCaches() {
        MiniAppFileManager.getInstance().clearAllCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearAllPkgs() {
        FileUtils.delete(ApkgManager.RootPath.getGamePkgRoot(), false);
        FileUtils.delete(ApkgManager.RootPath.getAppPkgRoot(), false);
        FileUtils.delete(ApkgManager.RootPath.getTissuePkgRoot(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearAllStorageCache() {
        try {
            FileUtils.delete(AppLoaderFactory.g().getContext().getCacheDir() + "/mini", false);
        } catch (Exception e16) {
            QMLog.e(TAG, "clearAllStorageCache failed", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearAuthSp(String str, MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        if (AppLoaderFactory.g().getContext().getSharedPreferences(miniAppInfo.appId + "_" + str, 4).edit().clear().commit()) {
            QMLog.i(TAG, "clearAuthSp finish. " + miniAppInfo.appId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearDebugSp(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        DebugUtil.setDebugEnabled(miniAppInfo.appId, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearFileCache(MiniAppInfo miniAppInfo) {
        MiniAppFileManager miniAppFileManager;
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId) && (miniAppFileManager = MiniAppFileManager.getMiniAppFileManager(miniAppInfo.apkgInfo)) != null) {
            miniAppFileManager.clearFileCache(miniAppInfo.appId);
            QMLog.i(TAG, "clearFileCache finish. " + miniAppInfo.appId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearPkg(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        clearPkg(miniAppInfo.appId, miniAppInfo.isEngineTypeMiniGame());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearStorageCache(String str, MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        String cacheDir = Storage.getCacheDir(AppLoaderFactory.g().getContext().getCacheDir().getAbsolutePath(), str, miniAppInfo.appId);
        if (new File(cacheDir).exists()) {
            FileUtils.delete(cacheDir, false);
            QMLog.i(TAG, "clearStorageCache finish. " + miniAppInfo.appId);
        }
    }

    public static void freeCacheDialog(final Activity activity, final String str, final MiniAppInfo miniAppInfo, final String str2, final IMiniAppContext iMiniAppContext) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.cache.MiniCacheFreeManager.1
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = activity;
                if (activity2 != null && !activity2.isFinishing()) {
                    try {
                        a N = a.N(activity, iMiniAppContext, null, str2, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.cache.MiniCacheFreeManager.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                MiniCacheFreeManager.freeCache(str, miniAppInfo, true, null);
                                if (dialogInterface instanceof a) {
                                    com.tencent.qqmini.sdk.utils.a.b(((a) dialogInterface).O(), MiniAppConst.RuntimeCloseType.FREE_CACHE);
                                }
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                            }
                        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.cache.MiniCacheFreeManager.1.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                            }
                        });
                        N.setCanceledOnTouchOutside(false);
                        Activity activity3 = activity;
                        if (activity3 != null && !activity3.isFinishing()) {
                            N.show();
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        QMLog.e(MiniCacheFreeManager.TAG, "freeCacheDialog exception ", e16);
                        return;
                    }
                }
                QMLog.e(MiniCacheFreeManager.TAG, "freeCacheDialog activity is null");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void killSelf(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        AppLoaderFactory.g().getAppBrandProxy().stopMiniApp(miniAppInfo);
        QMLog.i(TAG, "kill process. " + miniAppInfo.appId);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniCacheFreeManager
    public void freeCache(String str, MiniAppInfo miniAppInfo, boolean z16) {
        freeCache(str, miniAppInfo, z16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearDebugSp() {
        StorageUtil.getPreference().edit().clear().commit();
    }

    private static void clearPkg(String str, boolean z16) {
        String appPkgRoot = ApkgManager.RootPath.getAppPkgRoot();
        if (z16) {
            appPkgRoot = ApkgManager.RootPath.getGamePkgRoot();
        }
        String md5 = MD5Utils.toMD5(str);
        File file = new File(appPkgRoot);
        if (file.isDirectory()) {
            for (String str2 : file.list()) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(md5)) {
                    QMLog.i(TAG, "clear Pkg finish. " + str + " dir:" + appPkgRoot);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(appPkgRoot);
                    sb5.append(str2);
                    FileUtils.delete(sb5.toString(), false);
                }
            }
        }
    }

    public static void freeCache(final String str, final MiniAppInfo miniAppInfo, final boolean z16, final Runnable runnable) {
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.cache.MiniCacheFreeManager.2
            @Override // java.lang.Runnable
            public void run() {
                MiniCacheFreeManager.clearPkg(MiniAppInfo.this);
                MiniCacheFreeManager.clearFileCache(MiniAppInfo.this);
                MiniCacheFreeManager.clearStorageCache(str, MiniAppInfo.this);
                MiniCacheFreeManager.clearAuthSp(str, MiniAppInfo.this);
                MiniCacheFreeManager.clearDebugSp(MiniAppInfo.this);
                if (z16) {
                    MiniCacheFreeManager.killSelf(MiniAppInfo.this);
                }
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniCacheFreeManager
    public void freeCache() {
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.cache.MiniCacheFreeManager.3
            @Override // java.lang.Runnable
            public void run() {
                MiniCacheFreeManager.clearAllPkgs();
                MiniCacheFreeManager.clearAllFileCaches();
                MiniCacheFreeManager.clearAllStorageCache();
                MiniCacheFreeManager.clearDebugSp();
            }
        });
    }
}
