package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05325;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.minigame.manager.EngineManager;
import com.tencent.mobileqq.minigame.utils.AssetsUtil;
import com.tencent.mobileqq.triton.internal.engine.init.ScriptLoader;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BaseLibManager {
    private static int MINI_APP_INNER_BASELIB_RETRY_COUNT_DEFAULT = 2;
    public static final int RET_CODE_DOWNLOAD_FAIL = 1101;
    public static final int RET_CODE_NO_UPDATE = 1;
    public static final int RET_CODE_OTHER = 1103;
    public static final int RET_CODE_SUCC = 0;
    public static final int RET_CODE_UNZIP_FAIL = 1102;
    public static final int RET_CODE_UPDATE_CMD_ERROR = 1100;
    private static final String TAG = "MiniApp_QQ_BaseLibManager[MiniEng]";
    private static BaseLibManager instance;
    private static byte[] lock = new byte[0];
    private List<UpdateListener> mListeners = new ArrayList();
    private boolean isUpdatingBaseLib = false;
    private boolean isFirstTimeUpdateBaseLib = false;
    private List<String> miniAppBaseLibFiles = Arrays.asList("QView.js", "QLogic.js", "QVConsole.js", "QRemoteDebug.js", "QWebview.js");
    private List<String> miniGameBaseLibFiles = Arrays.asList("QGame.js", ScriptLoader.ENGINE_SCRIPT_OPEN_DATA_NAME, ScriptLoader.ENGINE_SCRIPT_WORKER_NAME);

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface UpdateListener {
        void onUpdateResult(int i3);
    }

    BaseLibManager() {
    }

    public static BaseLibManager g() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new BaseLibManager();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyUpdateResult(int i3) {
        ArrayList arrayList = new ArrayList(this.mListeners);
        this.mListeners.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((UpdateListener) it.next()).onUpdateResult(i3);
        }
        this.isUpdatingBaseLib = false;
    }

    public static boolean verifyBaselib(File file) {
        if (file == null || !file.exists() || file.isFile()) {
            return false;
        }
        try {
            File file2 = new File(file, "verify.json");
            if (file2.exists() && file2.isFile()) {
                JSONObject jSONObject = new JSONObject(FileUtils.readFileToString(file2));
                if (!jSONObject.has("verify_list")) {
                    return true;
                }
                JSONArray jSONArray = jSONObject.getJSONArray("verify_list");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    if (jSONArray.get(i3) == null) {
                        QLog.e("miniapp-start", 1, "\u914d\u7f6e\u6587\u4ef6\u683c\u5f0f\u5f02\u5e38\uff01\uff01\u8bf7\u4f7f\u7528json\u5de5\u5177\u68c0\u6d4b");
                    } else {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                        String string = jSONObject2.getString("name");
                        int i16 = jSONObject2.getInt("length");
                        File file3 = new File(file, string);
                        QLog.i("miniapp-start", 1, "BaselibManager--verifyBaselib file: " + string + " config_length=" + i16 + " local_length=" + file3.length());
                        if (file3.exists() && file3.isFile() && file3.length() == i16) {
                        }
                        return false;
                    }
                }
                return true;
            }
            QLog.w(TAG, 1, "BaselibManager--verifyBaselib verify.json is not exist!");
            return true;
        } catch (Exception e16) {
            QLog.e("miniapp-start", 1, "BaselibManager--verifyBaselib exception.", e16);
            return false;
        }
    }

    public void doDownloadBaselib(final String str, final String str2, final String str3, final String str4, final UpdateListener updateListener) {
        QLog.i(TAG, 1, "doDownloadBaselib url=" + str + " version=" + str2 + " oldUrl=" + str3 + " oldVersion=" + str4);
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 4, null, null, null, 0);
        final String baseLibZipPath = getBaseLibZipPath(str, str2);
        MiniappDownloadUtil.getInstance().download(str, baseLibZipPath, true, new Downloader.DownloadListener() { // from class: com.tencent.mobileqq.mini.apkg.BaseLibManager.3
            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadCanceled(String str5) {
                if (QLog.isColorLevel()) {
                    QLog.i(BaseLibManager.TAG, 1, "ApkgManager--onDownloadCanceled:" + str);
                }
                UpdateListener updateListener2 = updateListener;
                if (updateListener2 == null) {
                    BaseLibManager.this.notifyUpdateResult(1101);
                } else {
                    updateListener2.onUpdateResult(1101);
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadFailed(String str5, DownloadResult downloadResult) {
                QLog.i(BaseLibManager.TAG, 1, "ApkgManager--onDownloadFailed:" + str);
                UpdateListener updateListener2 = updateListener;
                if (updateListener2 == null) {
                    BaseLibManager.this.notifyUpdateResult(1101);
                } else {
                    updateListener2.onUpdateResult(1101);
                }
                MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 617, null, null, null, 1101);
                MiniProgramLpReportDC05325.reportApiReport(downloadResult, 4, null);
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadSucceed(String str5, DownloadResult downloadResult) {
                String baseLibDir;
                File file;
                QLog.i(BaseLibManager.TAG, 1, "ApkgManager--onDownloadSucceed:" + str);
                MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 5, null, null, null, 0);
                MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 6, null, null, null, 0);
                MiniProgramLpReportDC05325.reportApiReport(downloadResult, 4, null);
                try {
                    try {
                        baseLibDir = BaseLibManager.this.getBaseLibDir(str, str2);
                        file = new File(baseLibDir);
                    } catch (Exception e16) {
                        QLog.e(BaseLibManager.TAG, 1, "ApkgManager--unZipFolder exception.", e16);
                        UpdateListener updateListener2 = updateListener;
                        if (updateListener2 == null) {
                            BaseLibManager.this.notifyUpdateResult(1103);
                        } else {
                            updateListener2.onUpdateResult(1103);
                        }
                    }
                    if (BaseLibManager.this.isBaseLibDirValid(file)) {
                        QLog.i(BaseLibManager.TAG, 1, "unZipPath has downloaded and unziped!");
                        if (BaseLibInfo.needUpdateVersion(str2, str4)) {
                            QLog.i(BaseLibManager.TAG, 1, "update baselib local version from:" + str4 + " to:" + str2);
                            StorageUtil.getPreference().edit().putString("downloadUrl", str).commit();
                            StorageUtil.getPreference().edit().putString("version", str2).commit();
                        }
                        UpdateListener updateListener3 = updateListener;
                        if (updateListener3 == null) {
                            BaseLibManager.this.notifyUpdateResult(0);
                        } else {
                            updateListener3.onUpdateResult(0);
                        }
                        return;
                    }
                    if (file.exists()) {
                        FileUtils.delete(baseLibDir, false);
                    }
                    file.mkdir();
                    int unZipFolder = ZipUtils.unZipFolder(baseLibZipPath, baseLibDir);
                    boolean verifyBaselib = unZipFolder == 0 ? BaseLibManager.verifyBaselib(file) : true;
                    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 7, null, null, null, 0);
                    if (unZipFolder == 0 && verifyBaselib) {
                        QLog.i(BaseLibManager.TAG, 1, "unZipFolder succeed.url:" + str + ",version:" + str2);
                        StorageUtil.getPreference().edit().putString("downloadUrl", str).commit();
                        StorageUtil.getPreference().edit().putString("version", str2).commit();
                        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !TextUtils.equals(str3, str) && !TextUtils.equals(str4, str2)) {
                            QLog.i(BaseLibManager.TAG, 1, "delete last path.");
                            String baseLibDir2 = BaseLibManager.this.getBaseLibDir(str3, str4);
                            if (!baseLibDir2.equals(baseLibDir)) {
                                QLog.i(BaseLibManager.TAG, 1, "delete last path. oldUrl : " + str3 + "; version : " + str2);
                                FileUtils.delete(baseLibDir2, false);
                            }
                        }
                        UpdateListener updateListener4 = updateListener;
                        if (updateListener4 == null) {
                            BaseLibManager.this.notifyUpdateResult(0);
                        } else {
                            updateListener4.onUpdateResult(0);
                        }
                    } else {
                        QLog.e(BaseLibManager.TAG, 1, "unZipFolder failed, read last path.");
                        FileUtils.delete(baseLibDir, false);
                        UpdateListener updateListener5 = updateListener;
                        if (updateListener5 == null) {
                            BaseLibManager.this.notifyUpdateResult(1102);
                        } else {
                            updateListener5.onUpdateResult(1102);
                        }
                        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 618, null, null, null, 1102);
                    }
                } finally {
                    FileUtils.delete(baseLibZipPath, true);
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadProgress(String str5, long j3, float f16) {
            }
        }, Downloader.DownloadMode.StrictMode, null);
    }

    public synchronized void forceUpdateBaseLib(final UpdateListener updateListener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.apkg.BaseLibManager.1
            @Override // java.lang.Runnable
            public void run() {
                final String string = StorageUtil.getPreference().getString("downloadUrl", null);
                final String string2 = StorageUtil.getPreference().getString("version", "1.74.3.00001");
                QLog.i(BaseLibManager.TAG, 1, "updateBaseLib start. baseLibVersion=" + string2);
                QLog.i(BaseLibManager.TAG, 1, "forceUpdateBaseLib current requestVersion is:" + string2);
                MiniAppCmdUtil.getInstance().updateBaseLib(string2, true, true, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.apkg.BaseLibManager.1.1
                    @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                    public void onCmdListener(boolean z16, final JSONObject jSONObject) {
                        QLog.i(BaseLibManager.TAG, 1, "[MiniEng] updateBaseLib response. isSuc=" + z16 + " rsp=" + jSONObject);
                        if (z16 && jSONObject != null) {
                            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.mini.apkg.BaseLibManager.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    JSONObject optJSONObject = jSONObject.optJSONObject(BaseLibInfo.getKey(3));
                                    BaseLibInfo fromJSON = BaseLibInfo.fromJSON(optJSONObject);
                                    QLog.i(BaseLibManager.TAG, 1, "[MiniEng] miniAppEnginLib " + optJSONObject + " isWifi:" + NetworkUtil.isWifiConnected(BaseApplicationImpl.getApplication()));
                                    if (fromJSON != null) {
                                        EngineManager.g().installBaseLib(fromJSON, null);
                                    }
                                }
                            });
                            BaseLibInfo fromJSON = BaseLibInfo.fromJSON(jSONObject.optJSONObject(BaseLibInfo.getKey(1)));
                            if (BaseLibManager.this.needUpdate(fromJSON).booleanValue()) {
                                String str = fromJSON.baseLibVersion;
                                String str2 = fromJSON.baseLibUrl;
                                QLog.i(BaseLibManager.TAG, 1, "[MiniEng] updateBaseLib end : version : " + str + "; url : " + str2);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                BaseLibManager.this.doDownloadBaselib(str2, str, string, string2, updateListener);
                                return;
                            }
                            QLog.i(BaseLibManager.TAG, 1, "[MiniEng] updateBaseLib, no update");
                            UpdateListener updateListener2 = updateListener;
                            if (updateListener2 != null) {
                                updateListener2.onUpdateResult(1);
                                return;
                            }
                            return;
                        }
                        QLog.e(BaseLibManager.TAG, 1, "[MiniEng] updateBaseLib failed!");
                        UpdateListener updateListener3 = updateListener;
                        if (updateListener3 != null) {
                            updateListener3.onUpdateResult(1100);
                        }
                    }
                });
            }
        }, 16, null, false);
    }

    public String getBaseLibDir(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(AppLoaderFactory.BASE_LIB_PATH_DIR);
            String str3 = File.separator;
            sb5.append(str3);
            sb5.append(MD5Utils.toMD5(str));
            sb5.append("_");
            sb5.append(str2);
            sb5.append(str3);
            return sb5.toString();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getBaseLibDir exception!", th5);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(AppLoaderFactory.BASE_LIB_PATH_DIR);
            String str4 = File.separator;
            sb6.append(str4);
            sb6.append("_");
            sb6.append(str2);
            sb6.append(str4);
            return sb6.toString();
        }
    }

    public BaseLibInfo getBaseLibInfo() {
        BaseLibInfo baseLibInfo = new BaseLibInfo();
        String string = StorageUtil.getPreference().getString("downloadUrl", null);
        baseLibInfo.baseLibVersion = StorageUtil.getPreference().getString("version", "1.74.3.00001");
        baseLibInfo.baseLibUrl = string;
        return baseLibInfo;
    }

    public String getBaseLibZipPath(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return AppLoaderFactory.BASE_LIB_PATH_DIR + File.separator + MD5Utils.toMD5(str) + "_" + str2 + ".zip";
    }

    public synchronized String installMiniGameInnerJsLib() {
        String baseLibDir = g().getBaseLibDir("mini", "1.74.3.00001");
        if (g().isBaseLibDirValid4MiniGame(baseLibDir)) {
            QLog.i(TAG, 1, "installMiniGameInnerJsLib, inner baseLib already installed, version:1.74.3.00001");
            return baseLibDir;
        }
        int config = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_inner_baselib_retry_count", MINI_APP_INNER_BASELIB_RETRY_COUNT_DEFAULT);
        QLog.i(TAG, 1, "installMiniGameInnerJsLib, version:1.74.3.00001, totalCount:" + config);
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= config) {
                break;
            }
            i3++;
            boolean copyFileOrDir = AssetsUtil.copyFileOrDir(BaseApplication.getContext(), "mini", baseLibDir, this.miniGameBaseLibFiles);
            if (copyFileOrDir && g().isBaseLibDirValid4MiniGame(baseLibDir)) {
                z16 = copyFileOrDir;
                break;
            }
            File file = new File(baseLibDir);
            if (file.exists()) {
                q.c(file);
            }
        }
        QLog.i(TAG, 1, "installMiniGameInnerJsLib success? " + z16 + ", from mini to " + baseLibDir + ", tryCount:" + i3);
        if (!z16) {
            baseLibDir = null;
        }
        return baseLibDir;
    }

    public boolean isBaseLibDirValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (isBaseLibDirValid4MiniApp(str)) {
                return isBaseLibDirValid4MiniGame(str);
            }
            return false;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "isBaseLibDirValid path, exception!", th5);
            return false;
        }
    }

    public boolean isBaseLibDirValid4MiniApp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return isBaseLibDirValid4MiniApp(new File(str));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "isBaseLibDirValid4MiniApp path, exception!", th5);
            return false;
        }
    }

    public boolean isBaseLibDirValid4MiniGame(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return isBaseLibDirValid4MiniGame(new File(str));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "isBaseLibDirValid4MiniGame path, exception!", th5);
            return false;
        }
    }

    public synchronized void updateBaseLib(UpdateListener updateListener) {
        updateBaseLib(null, false, updateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean needUpdate(BaseLibInfo baseLibInfo) {
        if (baseLibInfo == null) {
            return Boolean.FALSE;
        }
        String string = StorageUtil.getPreference().getString("version", "1.74.3.00001");
        String string2 = StorageUtil.getPreference().getString("downloadUrl", null);
        QLog.i(TAG, 1, "needUpdate: localVersion = " + string);
        boolean z16 = false;
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            try {
                z16 = verifyBaselib(new File(g().getBaseLibDir(string2, string)));
                QLog.i(TAG, 1, "needUpdate: local version is valid = " + z16);
            } catch (Exception e16) {
                QLog.i(TAG, 1, "needUpdate: exception --->", e16);
            }
        }
        return Boolean.valueOf(BaseLibInfo.needUpdateVersion(baseLibInfo.baseLibVersion, z16 ? string : "1.74.3.00001"));
    }

    public synchronized void updateBaseLib(final String str, final boolean z16, final UpdateListener updateListener) {
        this.mListeners.add(updateListener);
        QLog.i(TAG, 1, "[MiniEng] postUpdateBaseLib " + this.isUpdatingBaseLib);
        if (this.isUpdatingBaseLib) {
            return;
        }
        this.isUpdatingBaseLib = true;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.apkg.BaseLibManager.2
            /* JADX WARN: Code restructure failed: missing block: B:23:0x0098, code lost:
            
                if (r8 != false) goto L29;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str2;
                boolean z17;
                final String string = StorageUtil.getPreference().getString("downloadUrl", null);
                final String string2 = StorageUtil.getPreference().getString("version", "1.74.3.00001");
                QLog.i(BaseLibManager.TAG, 1, "updateBaseLib start. baseLibVersion=" + string2);
                boolean z18 = BaseLibManager.this.isFirstTimeUpdateBaseLib ^ true;
                if (z16) {
                    str2 = !TextUtils.isEmpty(str) ? str : string2;
                    z17 = true;
                } else {
                    str2 = string2;
                    z17 = false;
                }
                String str3 = "0.0.1";
                if ("1.74.3.00001".equals(string2)) {
                    QLog.i(BaseLibManager.TAG, 1, "[MiniEng] current version is default:1.74.3.00001");
                } else {
                    String baseLibDir = BaseLibManager.g().getBaseLibDir(string, string2);
                    if (!TextUtils.isEmpty(baseLibDir)) {
                        File file = new File(baseLibDir);
                        if (!file.exists() || !file.isDirectory()) {
                            QLog.i(BaseLibManager.TAG, 1, "baselib directory is not exist!");
                            z17 = true;
                            str2 = "0.0.1";
                        }
                    }
                }
                if (z16) {
                    if (TextUtils.isEmpty(str)) {
                        z17 = true;
                        str3 = str2;
                    } else {
                        str3 = str;
                        z17 = true;
                    }
                }
                QLog.i(BaseLibManager.TAG, 1, "[MiniEng] updateBaseLib current requestVersion is:" + str3);
                boolean updateBaseLib = MiniAppCmdUtil.getInstance().updateBaseLib(str3, z18, z17, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.apkg.BaseLibManager.2.1
                    @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                    public void onCmdListener(boolean z19, final JSONObject jSONObject) {
                        QLog.i(BaseLibManager.TAG, 1, "[MiniEng] updateBaseLib response. isSuc=" + z19 + " rsp=" + jSONObject);
                        if (z19 && jSONObject != null) {
                            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.mini.apkg.BaseLibManager.2.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    JSONObject optJSONObject = jSONObject.optJSONObject(BaseLibInfo.getKey(3));
                                    BaseLibInfo fromJSON = BaseLibInfo.fromJSON(optJSONObject);
                                    QLog.i(BaseLibManager.TAG, 1, "[MiniEng] miniAppEnginLib " + optJSONObject + " isWifi:" + NetworkUtil.isWifiConnected(BaseApplicationImpl.getApplication()));
                                    if (fromJSON != null) {
                                        fromJSON.updateFor64IfNeed();
                                        EngineManager.g().installBaseLib(fromJSON, null);
                                    }
                                }
                            });
                            BaseLibInfo fromJSON = BaseLibInfo.fromJSON(jSONObject.optJSONObject(BaseLibInfo.getKey(1)));
                            if (BaseLibManager.this.needUpdate(fromJSON).booleanValue()) {
                                String str4 = fromJSON.baseLibVersion;
                                String str5 = fromJSON.baseLibUrl;
                                QLog.i(BaseLibManager.TAG, 1, "[MiniEng] updateBaseLib end : version : " + str4 + "; url : " + str5);
                                BaseLibManager.this.doDownloadBaselib(str5, str4, string, string2, null);
                                return;
                            }
                            QLog.i(BaseLibManager.TAG, 1, "[MiniEng] updateBaseLib, no update");
                            BaseLibManager.this.notifyUpdateResult(1);
                            return;
                        }
                        QLog.e(BaseLibManager.TAG, 1, "[MiniEng] updateBaseLib failed!");
                        BaseLibManager.this.notifyUpdateResult(1100);
                    }
                });
                BaseLibManager.this.isFirstTimeUpdateBaseLib = true;
                if (updateBaseLib) {
                    return;
                }
                BaseLibManager.this.isUpdatingBaseLib = false;
                updateListener.onUpdateResult(0);
            }
        }, 16, null, false);
    }

    public boolean isBaseLibDirValid(File file) {
        return isBaseLibDirValid4MiniApp(file) && isBaseLibDirValid4MiniGame(file);
    }

    public boolean isBaseLibDirValid4MiniApp(File file) {
        List<String> list = this.miniAppBaseLibFiles;
        return isBaseLibDirValid(file, (String[]) list.toArray(new String[list.size()]));
    }

    public boolean isBaseLibDirValid4MiniGame(File file) {
        List<String> list = this.miniGameBaseLibFiles;
        return isBaseLibDirValid(file, (String[]) list.toArray(new String[list.size()]));
    }

    private boolean isBaseLibDirValid(File file, String[] strArr) {
        if (file != null && file.exists() && file.isDirectory() && strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                try {
                    File file2 = new File(file, str);
                    if (!file2.exists() || file2.isDirectory()) {
                        return false;
                    }
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "isBaseLibDirValid exception!", th5);
                }
            }
            return true;
        }
        return false;
    }
}
