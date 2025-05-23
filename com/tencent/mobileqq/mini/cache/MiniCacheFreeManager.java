package com.tencent.mobileqq.mini.cache;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.aq;
import com.tencent.qqmini.sdk.MiniSDK;
import java.io.File;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniCacheFreeManager {
    private static final String TAG = "MiniCacheFreeManager";

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearAllFileCaches() {
        MiniAppFileManager.getInstance().clearAllCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearAllPkgs() {
        FileUtils.delete(ApkgManager.PATH_GAMEPKG_ROOT, false);
        FileUtils.delete(ApkgManager.PATH_WXAPKG_ROOT, false);
        FileUtils.delete(ApkgManager.PATH_APKG_TISSUE_ROOT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearAllStorageCache() {
        try {
            FileUtils.delete(BaseApplication.getContext().getCacheDir() + "/mini", false);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "clearAllStorageCache failed", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearAuthSp(String str, MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        if (BaseApplicationImpl.getApplication().getSharedPreferences(miniAppInfo.appId + "_" + str, 4).edit().clear().commit()) {
            QLog.i(TAG, 1, "clearAuthSp finish. " + miniAppInfo.appId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearDebugSp(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        if (StorageUtil.getPreference().edit().putBoolean(miniAppInfo.appId + "_debug", false).commit()) {
            QLog.i(TAG, 1, "clearDebugSp finish. " + miniAppInfo.appId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearFileCache(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null || TextUtils.isEmpty(miniAppInfo.appId)) {
            return;
        }
        MiniAppFileManager.getInstance().clearFileCache(miniAppInfo.appId);
        QLog.i(TAG, 1, "clearFileCache finish. " + miniAppInfo.appId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearPkg(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        String apkgFolderPath = ApkgManager.getApkgFolderPath(miniAppInfo);
        if (new File(apkgFolderPath).exists()) {
            FileUtils.delete(apkgFolderPath, false);
            QLog.i(TAG, 1, "clearPkg finish: " + miniAppInfo.appId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearStorageCache(String str, MiniAppInfo miniAppInfo) {
        Storage open;
        if (miniAppInfo == null || TextUtils.isEmpty(miniAppInfo.appId) || (open = Storage.open(BaseApplicationImpl.getApplication().getBaseContext(), str, miniAppInfo.appId)) == null) {
            return;
        }
        open.clearStorage();
        QLog.i(TAG, 1, "clearStorageCache finish. " + miniAppInfo.appId);
    }

    public static void freeCache(String str, MiniAppInfo miniAppInfo) {
        freeCache(str, miniAppInfo, true);
    }

    public static void freeCacheDialog(final Activity activity, final String str, final MiniAppInfo miniAppInfo, final String str2) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.cache.MiniCacheFreeManager.1
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = activity;
                if (activity2 != null && !activity2.isFinishing()) {
                    try {
                        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, str2, HardCodeUtil.qqStr(R.string.j6l), HardCodeUtil.qqStr(R.string.ket), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.cache.MiniCacheFreeManager.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                MiniCacheFreeManager.freeCache(str, miniAppInfo);
                                Activity activity3 = activity;
                                if (activity3 != null) {
                                    activity3.finish();
                                }
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                            }
                        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.cache.MiniCacheFreeManager.1.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                            }
                        });
                        createCustomDialog.setCanceledOnTouchOutside(false);
                        Activity activity3 = activity;
                        if (activity3 == null || activity3.isFinishing()) {
                            return;
                        }
                        createCustomDialog.show();
                        return;
                    } catch (Exception e16) {
                        QLog.e(MiniCacheFreeManager.TAG, 1, "freeCacheDialog exception ", e16);
                        return;
                    }
                }
                QLog.e(MiniCacheFreeManager.TAG, 1, "freeCacheDialog activity is null");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void killSelf(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        MiniSDK.stopMiniApp(BaseApplication.getContext(), MiniSdkLauncher.convert(miniAppInfo));
    }

    public static void freeCache(String str, MiniAppInfo miniAppInfo, boolean z16) {
        freeCache(str, miniAppInfo, z16, (ThreadExcutor.IThreadListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void killSelf(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MiniAppCmdUtil.getInstance().getAppInfoById(null, str, null, null, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.cache.MiniCacheFreeManager.5
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    QLog.i(MiniCacheFreeManager.TAG, 1, "getAppInfoById, retCode = " + jSONObject.optLong("retCode") + ",errMsg = " + jSONObject.optString("errMsg"));
                    MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                    if (miniAppInfo != null) {
                        MiniSDK.stopMiniApp(BaseApplication.getContext(), aq.e(miniAppInfo));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearDebugSp(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (StorageUtil.getPreference().edit().putBoolean(str + "_debug", false).commit()) {
            QLog.i(TAG, 1, "clearDebugSp finish. " + str);
        }
    }

    public static void freeCache(final String str, final MiniAppInfo miniAppInfo, final boolean z16, ThreadExcutor.IThreadListener iThreadListener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.cache.MiniCacheFreeManager.2
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
            }
        }, 16, iThreadListener, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearAuthSp(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (BaseApplicationImpl.getApplication().getSharedPreferences(str2 + "_" + str, 4).edit().clear().commit()) {
            QLog.i(TAG, 1, "clearAuthSp finish. " + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearFileCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MiniAppFileManager.getInstance().clearFileCache(str);
        QLog.i(TAG, 1, "clearFileCache finish. " + str);
    }

    public static void freeCache(final String str, final String str2, final boolean z16, ThreadExcutor.IThreadListener iThreadListener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.cache.MiniCacheFreeManager.3
            @Override // java.lang.Runnable
            public void run() {
                MiniCacheFreeManager.clearPkg(str2);
                MiniCacheFreeManager.clearFileCache(str2);
                MiniCacheFreeManager.clearStorageCache(str, str2);
                MiniCacheFreeManager.clearAuthSp(str, str2);
                MiniCacheFreeManager.clearDebugSp(str2);
                if (z16) {
                    MiniCacheFreeManager.killSelf(str2);
                }
            }
        }, 16, iThreadListener, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearStorageCache(String str, String str2) {
        Storage open;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (open = Storage.open(BaseApplicationImpl.getApplication().getBaseContext(), str, str2)) == null) {
            return;
        }
        open.clearStorage();
        QLog.i(TAG, 1, "clearStorageCache finish. " + str2);
    }

    public static void freeCache(boolean z16, ThreadExcutor.IThreadListener iThreadListener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.cache.MiniCacheFreeManager.4
            @Override // java.lang.Runnable
            public void run() {
                MiniCacheFreeManager.clearAllPkgs();
                MiniCacheFreeManager.clearAllFileCaches();
                MiniCacheFreeManager.clearAllStorageCache();
                MiniCacheFreeManager.clearDebugSp();
            }
        }, 16, iThreadListener, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearDebugSp() {
        StorageUtil.getPreference().edit().clear().commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearPkg(String str) {
        String str2 = ApkgManager.PATH_GAMEPKG_ROOT;
        String md5 = MD5.toMD5(str);
        File file = new File(str2);
        if (file.isDirectory()) {
            for (String str3 : file.list()) {
                if (!TextUtils.isEmpty(str3) && str3.startsWith(md5)) {
                    QLog.d(TAG, 1, "clearPkg delete pkg : " + str3);
                    com.tencent.mobileqq.mini.utils.FileUtils.delete(str2 + str3, false);
                }
            }
        }
        String str4 = ApkgManager.PATH_WXAPKG_ROOT;
        String md52 = MD5.toMD5(str);
        File file2 = new File(str4);
        if (file2.isDirectory()) {
            for (String str5 : file2.list()) {
                if (!TextUtils.isEmpty(str5) && str5.startsWith(md52)) {
                    QLog.d(TAG, 1, "clearPkg delete pkg : " + str5);
                    com.tencent.mobileqq.mini.utils.FileUtils.delete(str4 + str5, false);
                }
            }
        }
    }
}
