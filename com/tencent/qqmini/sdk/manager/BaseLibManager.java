package com.tencent.qqmini.sdk.manager;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.internal.engine.init.ScriptLoader;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.core.utils.ZipUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.AssetsUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BaseLibManager {
    public static final int RET_CODE_DOWNLOAD_FAIL = 1101;
    public static final int RET_CODE_NO_UPDATE = 1;
    public static final int RET_CODE_OTHER = 1103;
    public static final int RET_CODE_SUCC = 0;
    public static final int RET_CODE_UNZIP_FAIL = 1102;
    public static final int RET_CODE_UPDATE_CMD_ERROR = 1100;
    private static final String TAG = "miniapp-process_BaseLibManager";
    private static BaseLibManager instance;
    public static List<String> miniGameBaseLibFiles = Arrays.asList(ScriptLoader.ENGINE_SCRIPT_MAIN_NAME, ScriptLoader.ENGINE_SCRIPT_OPEN_DATA_NAME, ScriptLoader.ENGINE_SCRIPT_WORKER_NAME);
    private static byte[] lock = new byte[0];
    private static int MINI_APP_INNER_BASELIB_RETRY_COUNT_DEFAULT = 2;
    private List<UpdateListener> mListeners = new ArrayList();
    private boolean isUpdatingBaseLib = false;
    private boolean isFirstTimeUpdateBaseLib = false;
    private List<String> miniAppBaseLibFiles = Arrays.asList("QView.js", "QLogic.js", "QVConsole.js", "QRemoteDebug.js", "QWebview.js");

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface UpdateListener {
        void onUpdateResult(int i3);
    }

    BaseLibManager() {
    }

    private void deleteOldVersion(String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5) && !TextUtils.equals(str4, str2) && !TextUtils.equals(str5, str3)) {
            QMLog.i(TAG, "delete last path.");
            String baseLibDir = getBaseLibDir(str4, str5);
            if (!baseLibDir.equals(str)) {
                QMLog.i("miniapp-start", "delete last path. oldUrl : " + str4 + "; version : " + str3);
                FileUtils.delete(baseLibDir, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doUpdateBaseLib(final String str, final String str2, boolean z16, boolean z17, String str3) {
        return ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).updateBaseLib(str3, z17, z16, new AsyncResult() { // from class: com.tencent.qqmini.sdk.manager.BaseLibManager.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z18, final JSONObject jSONObject) {
                QMLog.i(BaseLibManager.TAG, "[MiniEng] updateBaseLib response. isSuc=" + z18 + " rsp=" + jSONObject);
                if (z18 && jSONObject != null) {
                    ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.BaseLibManager.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseLibInfo fromJSON = BaseLibInfo.fromJSON(jSONObject.optJSONObject(BaseLibInfo.getKey(2)));
                            JSONObject optJSONObject = jSONObject.optJSONObject(BaseLibInfo.getKey(3));
                            BaseLibInfo fromJSON2 = BaseLibInfo.fromJSON(optJSONObject);
                            QMLog.i(BaseLibManager.TAG, "[MiniEng] gameEngineLib " + fromJSON + ", miniAppEnginLib " + optJSONObject);
                            if (TextUtils.isEmpty(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getSoPath()) || !"1.74.3.00001".equals(str2)) {
                                if (!LocalGameEngine.g().isWnsConfigModel()) {
                                    if (fromJSON != null) {
                                        EngineManager.g().installBaseLib(fromJSON, null);
                                    }
                                } else {
                                    BaseLibInfo gameBaseLibInfo = BaseLibManager.getGameBaseLibInfo();
                                    QMLog.i(BaseLibManager.TAG, "[MiniEng]MiniEng QQSpeed gameEngineLib " + gameBaseLibInfo);
                                    if (gameBaseLibInfo != null && gameBaseLibInfo.baseLibType == 2) {
                                        EngineManager.g().installBaseLib(gameBaseLibInfo, null);
                                    }
                                }
                                if (fromJSON2 != null) {
                                    EngineManager.g().installBaseLib(fromJSON2, null);
                                }
                            }
                        }
                    });
                    BaseLibInfo fromJSON = BaseLibInfo.fromJSON(jSONObject.optJSONObject(BaseLibInfo.getKey(1)));
                    if (BaseLibManager.this.needUpdate(fromJSON).booleanValue()) {
                        String str4 = fromJSON.baseLibVersion;
                        String str5 = fromJSON.baseLibUrl;
                        QMLog.i(BaseLibManager.TAG, "[MiniEng] updateBaseLib end : version : " + str4 + "; url : " + str5);
                        BaseLibManager.this.doDownloadBaselib(str5, str4, str, str2, null);
                        return;
                    }
                    QMLog.i(BaseLibManager.TAG, "[MiniEng] updateBaseLib, no update");
                    BaseLibManager.this.notifyUpdateResult(1);
                    return;
                }
                QMLog.e(BaseLibManager.TAG, "[MiniEng] updateBaseLib failed!");
                BaseLibManager.this.notifyUpdateResult(1100);
            }
        });
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

    public static BaseLibInfo getGameBaseLibInfo() {
        String config = WnsConfig.getConfig("qqtriton", "MiniGameBaseLib", WnsConfig.DEFAULT_MINI_GAME_BASELIB);
        QMLog.i("minigame", "MiniEng getWnsGameBaseLibInfo " + config);
        if (!TextUtils.isEmpty(config)) {
            try {
                return BaseLibInfo.fromJSON(new JSONObject(config));
            } catch (Exception e16) {
                QMLog.e("minigame", "MiniEng getWnsGameBaseLibInfo failed", e16);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean needUpdate(BaseLibInfo baseLibInfo) {
        if (baseLibInfo == null) {
            return Boolean.FALSE;
        }
        String string = StorageUtil.getPreference().getString("version", null);
        String string2 = StorageUtil.getPreference().getString("downloadUrl", null);
        QMLog.i(TAG, "needUpdate: localVersion = " + string);
        boolean z16 = false;
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            try {
                z16 = verifyBaselib(new File(g().getBaseLibDir(string2, string)));
                QMLog.i(TAG, "needUpdate: local version is valid = " + z16);
            } catch (Exception e16) {
                QMLog.e(TAG, "needUpdate: exception --->", e16);
            }
        }
        if (!z16) {
            string = "1.74.3.00001";
        }
        return Boolean.valueOf(BaseLibInfo.needUpdateVersion(baseLibInfo.baseLibVersion, string));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void unZipFolder(String str, File file, String str2, String str3, String str4, String str5, String str6, UpdateListener updateListener) {
        boolean z16;
        if (file.exists()) {
            FileUtils.delete(str, false);
        }
        file.mkdir();
        int unZipFolder = ZipUtil.unZipFolder(str2, str);
        if (unZipFolder == 0) {
            z16 = verifyBaselib(file);
        } else {
            z16 = true;
        }
        MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 7, null, null, null, 0);
        if (unZipFolder == 0 && z16) {
            QMLog.i(TAG, "unZipFolder succeed.url:" + str3 + ",version:" + str4);
            SharedPreferences.Editor edit = StorageUtil.getPreference().edit();
            edit.putString("downloadUrl", str3);
            edit.putString("version", str4);
            edit.commit();
            deleteOldVersion(str, str3, str4, str5, str6);
            if (updateListener != null) {
                updateListener.onUpdateResult(0);
                return;
            } else {
                notifyUpdateResult(0);
                return;
            }
        }
        QMLog.e(TAG, "unZipFolder failed, read last path.");
        FileUtils.delete(str, false);
        if (updateListener != null) {
            updateListener.onUpdateResult(1102);
        } else {
            notifyUpdateResult(1102);
        }
        MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 618, null, null, null, 1102);
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
                        QMLog.e("miniapp-start", "\u914d\u7f6e\u6587\u4ef6\u683c\u5f0f\u5f02\u5e38\uff01\uff01\u8bf7\u4f7f\u7528json\u5de5\u5177\u68c0\u6d4b");
                    } else {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                        String string = jSONObject2.getString("name");
                        int i16 = jSONObject2.getInt("length");
                        File file3 = new File(file, string);
                        QMLog.i("miniapp-start", "BaselibManager--verifyBaselib file: " + string + " config_length=" + i16 + " local_length=" + file3.length());
                        if (file3.exists() && file3.isFile() && file3.length() == i16) {
                        }
                        return false;
                    }
                }
                return true;
            }
            QMLog.w("miniapp-start", "BaselibManager--verifyBaselib verify.json is not exist!");
            return true;
        } catch (Exception e16) {
            QMLog.e("miniapp-start", "BaselibManager--verifyBaselib exception.", e16);
            return false;
        }
    }

    public void doDownloadBaselib(final String str, final String str2, final String str3, final String str4, final UpdateListener updateListener) {
        QMLog.i(TAG, "doDownloadBaselib url=" + str + " version=" + str2 + " oldUrl=" + str3 + " oldVersion=" + str4);
        MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 4, null, null, null, 0);
        final String baseLibZipPath = getBaseLibZipPath(str, str2);
        ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).download(str, null, baseLibZipPath, 60, new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.sdk.manager.BaseLibManager.4
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadFailed(int i3, String str5) {
                QMLog.i(BaseLibManager.TAG, "ApkgManager--onDownloadFailed");
                UpdateListener updateListener2 = updateListener;
                if (updateListener2 == null) {
                    BaseLibManager.this.notifyUpdateResult(1101);
                } else {
                    updateListener2.onUpdateResult(1101);
                }
                MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 617, null, null, null, 1101);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadSucceed(int i3, String str5, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
                String baseLibDir;
                File file;
                QMLog.i(BaseLibManager.TAG, "ApkgManager--onDownloadSucceed");
                MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 5, null, null, null, 0);
                MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 6, null, null, null, 0);
                try {
                    try {
                        baseLibDir = BaseLibManager.this.getBaseLibDir(str, str2);
                        file = new File(baseLibDir);
                    } catch (Exception e16) {
                        QMLog.e("miniapp-start", "ApkgManager--unZipFolder exception.", e16);
                        UpdateListener updateListener2 = updateListener;
                        if (updateListener2 == null) {
                            BaseLibManager.this.notifyUpdateResult(1103);
                        } else {
                            updateListener2.onUpdateResult(1103);
                        }
                    }
                    if (!BaseLibManager.this.isBaseLibDirValid(file)) {
                        BaseLibManager.this.unZipFolder(baseLibDir, file, baseLibZipPath, str, str2, str3, str4, updateListener);
                        return;
                    }
                    QMLog.i(BaseLibManager.TAG, "unZipPath has downloaded and unziped!");
                    if (BaseLibInfo.needUpdateVersion(str2, str4)) {
                        QMLog.i(BaseLibManager.TAG, "update baselib local version from:" + str4 + " to:" + str2);
                        SharedPreferences.Editor edit = StorageUtil.getPreference().edit();
                        edit.putString("downloadUrl", str);
                        edit.putString("version", str2);
                        edit.commit();
                    }
                    UpdateListener updateListener3 = updateListener;
                    if (updateListener3 == null) {
                        BaseLibManager.this.notifyUpdateResult(0);
                    } else {
                        updateListener3.onUpdateResult(0);
                    }
                } finally {
                    FileUtils.delete(baseLibZipPath, true);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadHeadersReceived(int i3, Map<String, List<String>> map) {
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadProgress(float f16, long j3, long j16) {
            }
        });
    }

    public synchronized void forceUpdateBaseLib(final UpdateListener updateListener) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.BaseLibManager.2
            @Override // java.lang.Runnable
            public void run() {
                final String string = StorageUtil.getPreference().getString("downloadUrl", null);
                final String string2 = StorageUtil.getPreference().getString("version", "1.74.3.00001");
                QMLog.i(BaseLibManager.TAG, "updateBaseLib start. baseLibVersion=" + string2);
                QMLog.i(BaseLibManager.TAG, "forceUpdateBaseLib current requestVersion is:" + string2);
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).updateBaseLib(string2, true, true, new AsyncResult() { // from class: com.tencent.qqmini.sdk.manager.BaseLibManager.2.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, final JSONObject jSONObject) {
                        QMLog.i(BaseLibManager.TAG, "[MiniEng] updateBaseLib response. isSuc=" + z16 + " rsp=" + jSONObject);
                        if (z16 && jSONObject != null) {
                            ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.BaseLibManager.2.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    BaseLibInfo fromJSON = BaseLibInfo.fromJSON(jSONObject.optJSONObject(BaseLibInfo.getKey(2)));
                                    JSONObject optJSONObject = jSONObject.optJSONObject(BaseLibInfo.getKey(3));
                                    BaseLibInfo fromJSON2 = BaseLibInfo.fromJSON(optJSONObject);
                                    QMLog.i(BaseLibManager.TAG, "[MiniEng] gameEngineLib " + fromJSON + ", miniAppEnginLib " + optJSONObject);
                                    if (TextUtils.isEmpty(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getSoPath()) || !"1.74.3.00001".equals(string2)) {
                                        if (!LocalGameEngine.g().isWnsConfigModel()) {
                                            if (fromJSON != null) {
                                                EngineManager.g().installBaseLib(fromJSON, null);
                                            }
                                        } else {
                                            BaseLibInfo gameBaseLibInfo = BaseLibManager.getGameBaseLibInfo();
                                            QMLog.i(BaseLibManager.TAG, "[MiniEng]MiniEng QQSpeed gameEngineLib " + gameBaseLibInfo);
                                            if (gameBaseLibInfo != null && gameBaseLibInfo.baseLibType == 2) {
                                                EngineManager.g().installBaseLib(gameBaseLibInfo, null);
                                            }
                                        }
                                        if (fromJSON2 != null) {
                                            EngineManager.g().installBaseLib(fromJSON2, null);
                                        }
                                    }
                                }
                            });
                            BaseLibInfo fromJSON = BaseLibInfo.fromJSON(jSONObject.optJSONObject(BaseLibInfo.getKey(1)));
                            if (BaseLibManager.this.needUpdate(fromJSON).booleanValue()) {
                                String str = fromJSON.baseLibVersion;
                                String str2 = fromJSON.baseLibUrl;
                                QMLog.i(BaseLibManager.TAG, "[MiniEng] updateBaseLib end : version : " + str + "; url : " + str2);
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                BaseLibManager.this.doDownloadBaselib(str2, str, string, string2, updateListener);
                                return;
                            }
                            QMLog.i(BaseLibManager.TAG, "[MiniEng] updateBaseLib, no update");
                            UpdateListener updateListener2 = updateListener;
                            if (updateListener2 != null) {
                                updateListener2.onUpdateResult(1);
                                return;
                            }
                            return;
                        }
                        QMLog.e(BaseLibManager.TAG, "[MiniEng] updateBaseLib failed!");
                        UpdateListener updateListener3 = updateListener;
                        if (updateListener3 != null) {
                            updateListener3.onUpdateResult(1100);
                        }
                    }
                });
            }
        });
    }

    public String getBaseLibDir(String str, String str2) {
        return MiniSDKConst.getAppBaseLibDir(str, str2);
    }

    public BaseLibInfo getBaseLibInfo() {
        BaseLibInfo baseLibInfo = new BaseLibInfo();
        String string = StorageUtil.getPreference().getString("downloadUrl", null);
        baseLibInfo.baseLibVersion = StorageUtil.getPreference().getString("version", "1.74.3.00001");
        baseLibInfo.baseLibUrl = string;
        return baseLibInfo;
    }

    public String getBaseLibZipPath(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return MiniSDKConst.BASE_LIB_PATH_DIR + File.separator + MD5Utils.toMD5(str) + "_" + str2 + ".zip";
        }
        return null;
    }

    public synchronized String installMiniGameInnerJsLib() {
        String baseLibDir = g().getBaseLibDir("mini", "1.74.3.00001");
        if (g().isBaseLibDirValid4MiniGame(baseLibDir)) {
            QMLog.i(TAG, "[MiniEng] installMiniGameInnerJsLib, inner baseLib already installed, version:1.74.3.00001");
            return baseLibDir;
        }
        int config = WnsConfig.getConfig("qqminiapp", "mini_app_inner_baselib_retry_count", MINI_APP_INNER_BASELIB_RETRY_COUNT_DEFAULT);
        QMLog.i(TAG, "[MiniEng] installMiniGameInnerJsLib, version:1.74.3.00001, totalCount:" + config);
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= config) {
                break;
            }
            i3++;
            boolean copyFileOrDir = AssetsUtil.copyFileOrDir(AppLoaderFactory.g().getContext(), "mini", baseLibDir, miniGameBaseLibFiles);
            if (copyFileOrDir && g().isBaseLibDirValid4MiniGame(baseLibDir)) {
                z16 = copyFileOrDir;
                break;
            }
            File file = new File(baseLibDir);
            if (file.exists()) {
                FileUtils.deleteFile(file);
            }
        }
        QMLog.i(TAG, "[MiniEng] installMiniGameInnerJsLib success?" + z16 + ", from mini to " + baseLibDir + ", tryCount:" + i3);
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
            if (QUAUtil.isQQApp()) {
                return isBaseLibDirValid4MiniApp(str) && isBaseLibDirValid4MiniGame(str);
            }
            return isBaseLibDirValid4MiniGame(str);
        } catch (Throwable th5) {
            QMLog.e(TAG, "isBaseLibDirValid path, exception!", th5);
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
            QMLog.e(TAG, "isBaseLibDirValid4MiniApp path, exception!", th5);
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
            QMLog.e(TAG, "isBaseLibDirValid4MiniGame path, exception!", th5);
            return false;
        }
    }

    public synchronized void updateBaseLib(UpdateListener updateListener) {
        updateBaseLib(null, false, updateListener);
    }

    public synchronized void updateBaseLib(final String str, final boolean z16, final UpdateListener updateListener) {
        this.mListeners.add(updateListener);
        QMLog.i(TAG, "[MiniEng] postUpdateBaseLib " + this.isUpdatingBaseLib);
        if (this.isUpdatingBaseLib) {
            return;
        }
        this.isUpdatingBaseLib = true;
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.BaseLibManager.1
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                boolean z17;
                String str3;
                boolean z18;
                if (StorageUtil.getPreference() == null) {
                    return;
                }
                String string = StorageUtil.getPreference().getString("downloadUrl", null);
                String string2 = StorageUtil.getPreference().getString("version", "1.74.3.00001");
                QMLog.i(BaseLibManager.TAG, "updateBaseLib start. baseLibVersion=" + string2);
                boolean z19 = BaseLibManager.this.isFirstTimeUpdateBaseLib ^ true;
                if (z16) {
                    if (!TextUtils.isEmpty(str)) {
                        str2 = str;
                    } else {
                        str2 = string2;
                    }
                    z17 = true;
                } else {
                    str2 = string2;
                    z17 = false;
                }
                if ("1.74.3.00001".equals(string2)) {
                    QMLog.i(BaseLibManager.TAG, "[MiniEng] current version is default:1.74.3.00001");
                } else {
                    String baseLibDir = BaseLibManager.g().getBaseLibDir(string, string2);
                    if (!TextUtils.isEmpty(baseLibDir)) {
                        File file = new File(baseLibDir);
                        if (!file.exists() || !file.isDirectory()) {
                            QMLog.i(BaseLibManager.TAG, "baselib directory is not exist!");
                            str2 = "0.0.1";
                            z17 = true;
                        }
                    }
                }
                if (z16) {
                    if (!TextUtils.isEmpty(str)) {
                        str2 = str;
                    }
                    str3 = str2;
                    z18 = true;
                } else {
                    if (z17) {
                        str3 = "0.0.1";
                    } else {
                        str3 = str2;
                    }
                    z18 = z17;
                }
                QMLog.i(BaseLibManager.TAG, "[MiniEng] updateBaseLib current requestVersion is:" + str3);
                boolean doUpdateBaseLib = BaseLibManager.this.doUpdateBaseLib(string, string2, z18, z19, str3);
                BaseLibManager.this.isFirstTimeUpdateBaseLib = true;
                if (!doUpdateBaseLib) {
                    BaseLibManager.this.isUpdatingBaseLib = false;
                    updateListener.onUpdateResult(0);
                }
            }
        });
    }

    public boolean isBaseLibDirValid4MiniApp(File file) {
        List<String> list = this.miniAppBaseLibFiles;
        return isBaseLibDirValid(file, (String[]) list.toArray(new String[list.size()]));
    }

    public boolean isBaseLibDirValid4MiniGame(File file) {
        List<String> list = miniGameBaseLibFiles;
        return isBaseLibDirValid(file, (String[]) list.toArray(new String[list.size()]));
    }

    public boolean isBaseLibDirValid(File file) {
        return isBaseLibDirValid4MiniApp(file) && isBaseLibDirValid4MiniGame(file);
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
                    QMLog.e(TAG, "isBaseLibDirValid exception!", th5);
                }
            }
            return true;
        }
        return false;
    }
}
