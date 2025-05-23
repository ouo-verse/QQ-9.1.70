package com.tencent.qqmini.minigame.manager;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.model.Version;
import com.tencent.qqmini.minigame.manager.EnginePackageUpdater;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.minigame.utils.MD5FileUtil;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileInfo;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ZipUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.d;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class EnginePackageManager {
    private static final String TAG = "GameEnvManager[MiniEng]";
    public static final String TRITON_INSTALLED_ABI = "triton_installed_abi";
    public static final String TRITON_ONLINE_TIMESTAMP = "TritonTimeStamp";
    public static final String TRITON_ONLINE_VERSION = "TritonVersion";
    private static final String TRITON_PATH_BASE = AppLoaderFactory.g().getContext().getFilesDir().getPath() + "/mini/triton";

    static /* synthetic */ Version access$500() {
        return getLocalTritonVersion();
    }

    private static String calcMD5(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(str);
        String str2 = "";
        if (file.exists()) {
            try {
                String fileMD5String = MD5FileUtil.getFileMD5String(file);
                if (fileMD5String != null) {
                    str2 = fileMD5String;
                }
            } catch (IOException unused) {
            }
        }
        GameLog.getInstance().d(TAG, "calcMD5 " + str + ", md5:" + str2 + ", cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkShouldDownload(Version version) {
        boolean z16 = false;
        if (version == null) {
            return false;
        }
        Version localTritonVersion = getLocalTritonVersion();
        Version onlineTritonVersion = getOnlineTritonVersion();
        if (version.compareTo(localTritonVersion) > 0 && version.compareTo(onlineTritonVersion) > 0) {
            z16 = true;
        }
        GameLog.getInstance().i(TAG, "checkShouldDownload localVersion:" + localTritonVersion + ", onlineVersion:" + onlineTritonVersion + ", targetVersion:" + version + ", ret:" + z16);
        return z16;
    }

    public static void checkTritonUpdate(final EnginePackageUpdater.a aVar) {
        ThreadManager.runComputationTask(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.EnginePackageManager.1
            @Override // java.lang.Runnable
            public void run() {
                GameLog.getInstance().i(EnginePackageManager.TAG, "[\u5b89\u88c5\u5c0f\u6e38\u620f\u65b0\u7248\u672cso] \u5f00\u59cb\u8bf7\u6c42\u7ebf\u4e0a\u6700\u65b0\u7248\u672c");
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).updateBaseLib("0.0.1", false, true, new AsyncResult() { // from class: com.tencent.qqmini.minigame.manager.EnginePackageManager.1.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                        GameLog.getInstance().i(EnginePackageManager.TAG, "updateBaseLib response. isSuc=" + z16 + " rsp=" + jSONObject);
                        if (z16 && jSONObject != null) {
                            BaseLibInfo fromJSON = BaseLibInfo.fromJSON(jSONObject.optJSONObject(BaseLibInfo.getKey(2)));
                            GameLog.getInstance().i(EnginePackageManager.TAG, "targetInfo " + fromJSON);
                            Version tritonVersionByBaseLib = EnginePackageManager.getTritonVersionByBaseLib(fromJSON);
                            if (EnginePackageManager.checkShouldDownload(tritonVersionByBaseLib)) {
                                GameLog.getInstance().i(EnginePackageManager.TAG, "[\u5b89\u88c5\u5c0f\u6e38\u620f\u65b0\u7248\u672cso] \u5f00\u59cb\u4e0b\u8f7d\u7ebf\u4e0a\u6700\u65b0\u7248\u672c:" + tritonVersionByBaseLib + ", " + fromJSON.baseLibUrl);
                                EnginePackageManager.downloadLatestTritonEngine(fromJSON, tritonVersionByBaseLib, EnginePackageUpdater.a.this);
                                return;
                            }
                            EnginePackageUpdater.a.this.onFail("[\u5b89\u88c5\u5c0f\u6e38\u620f\u65b0\u7248\u672cso] \u7248\u672c\u68c0\u6d4b\u5931\u8d25, \u672c\u5730\u5df2\u6709\u66f4\u65b0\u7248\u672c");
                            return;
                        }
                        EnginePackageUpdater.a.this.onFail("request failed.");
                    }
                });
            }
        });
    }

    private static void deleteOldVersionTritonEngine() {
        ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.EnginePackageManager.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<FileInfo> files = FileUtils.getFiles(EnginePackageManager.TRITON_PATH_BASE, false, 0);
                if (files == null) {
                    return;
                }
                Version access$500 = EnginePackageManager.access$500();
                GameLog.getInstance().i(EnginePackageManager.TAG, "deleteOldVersionTritonEngine local:" + access$500);
                Iterator<FileInfo> it = files.iterator();
                while (it.hasNext()) {
                    FileInfo next = it.next();
                    if (next.isDirectory()) {
                        Version tritonVersionByFileInfo = EnginePackageManager.getTritonVersionByFileInfo(next);
                        if (access$500.compareTo(tritonVersionByFileInfo) >= 0) {
                            GameLog.getInstance().i(EnginePackageManager.TAG, "deleteOldVersionTritonEngine delete:" + tritonVersionByFileInfo);
                            FileUtils.deleteFile(next.getPath());
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void downloadLatestTritonEngine(final BaseLibInfo baseLibInfo, final Version version, final EnginePackageUpdater.a aVar) {
        if (baseLibInfo == null) {
            return;
        }
        final String str = TRITON_PATH_BASE + File.separator + baseLibInfo.baseLibVersion + "_" + System.nanoTime() + ".zip";
        ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).download(baseLibInfo.baseLibUrl, null, str, 60, new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.minigame.manager.EnginePackageManager.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadFailed(int i3, String str2) {
                EnginePackageUpdater.a.this.onFail("downloadLatestTritonEngine failed, from:" + baseLibInfo);
                MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 5, null, null, null, 1, "1", 0L, null);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadSucceed(int i3, String str2, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
                GameLog.getInstance().i(EnginePackageManager.TAG, "[\u5b89\u88c5\u5c0f\u6e38\u620f\u65b0\u7248\u672cso] \u4e0b\u8f7d\u6210\u529f, version:" + version + ", path:" + str2 + ", url:" + baseLibInfo.baseLibUrl);
                MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 5, "1");
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).reportTrafficFlow(1, "downloadTritonEngine", "SDK#EnginePackageManager", downloadResult.url, ((int) FileUtils.getFileSizes(str2)) / 1024);
                ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.EnginePackageManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        EnginePackageManager.onDownloadLatestTritonEngineSuccess(version, str, EnginePackageUpdater.a.this);
                    }
                });
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadHeadersReceived(int i3, Map<String, List<String>> map) {
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadProgress(float f16, long j3, long j16) {
            }
        });
        MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 4, "1");
    }

    private static Version getLocalTritonVersion() {
        Version tritonVersionFromJSONStr = getTritonVersionFromJSONStr("{\n    \"triton_info\": {\n        \"version\": \"3.0.0.486.6d09724f2\",\n        \"timestamp\": 1741578761730\n    }\n}");
        GameLog.getInstance().i(TAG, "getLocalTritonVersion:" + tritonVersionFromJSONStr);
        return tritonVersionFromJSONStr;
    }

    public static String getOnlineTritonPathByVersion(Version version) {
        if (version == null) {
            return null;
        }
        return TRITON_PATH_BASE + File.separator + version.getVersion() + "_" + version.getTimeStamp();
    }

    public static Version getOnlineTritonVersion() {
        Version version;
        String string = StorageUtil.getPreference().getString(TRITON_INSTALLED_ABI, "");
        GameLog gameLog = GameLog.getInstance();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getOnlineTritonVersion installedAbi:");
        sb5.append(string);
        sb5.append(", Build.CPU_ABI: ");
        String str = Build.CPU_ABI;
        sb5.append(str);
        gameLog.i(TAG, sb5.toString());
        if (string.equals(str)) {
            version = new Version(StorageUtil.getPreference().getString(TRITON_ONLINE_VERSION, ""), StorageUtil.getPreference().getLong(TRITON_ONLINE_TIMESTAMP, -1L));
        } else {
            version = new Version("", -1L);
        }
        GameLog.getInstance().i(TAG, "get online version:" + version);
        return version;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Version getTritonVersionByBaseLib(BaseLibInfo baseLibInfo) {
        if (baseLibInfo != null && !TextUtils.isEmpty(baseLibInfo.baseLibDesc)) {
            Version tritonVersionFromJSONStr = getTritonVersionFromJSONStr(baseLibInfo.baseLibDesc);
            GameLog.getInstance().i(TAG, "getTritonVersionByBaseLib:" + tritonVersionFromJSONStr);
            return tritonVersionFromJSONStr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Version getTritonVersionByFileInfo(FileInfo fileInfo) {
        if (fileInfo != null && !TextUtils.isEmpty(fileInfo.getName())) {
            Version version = new Version("", 0L);
            try {
                String[] split = fileInfo.getName().split("_");
                if (split.length == 2) {
                    return new Version(split[0], Long.parseLong(split[1]));
                }
                return version;
            } catch (NumberFormatException e16) {
                GameLog.getInstance().e(TAG, "getTritonVersionByFileInfo error." + fileInfo.getPath(), e16);
                return version;
            }
        }
        return null;
    }

    private static Version getTritonVersionFromJSONStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("triton_info");
            if (optJSONObject == null) {
                return null;
            }
            return new Version(optJSONObject.optString("version"), optJSONObject.optLong("timestamp"));
        } catch (Throwable th5) {
            GameLog.getInstance().e(TAG, "getTritonVersionByBaseLib content:" + str, th5);
            return null;
        }
    }

    private static boolean isVerifyListValid(File file, boolean z16, JSONArray jSONArray) throws JSONException {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            if (jSONArray.get(i3) == null) {
                GameLog.getInstance().e(TAG, "\u914d\u7f6e\u6587\u4ef6\u683c\u5f0f\u5f02\u5e38\uff01\uff01\u8bf7\u4f7f\u7528json\u5de5\u5177\u68c0\u6d4b");
            } else {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                String optString = jSONObject.optString("name");
                if (!TextUtils.isEmpty(optString)) {
                    File file2 = new File(file, optString);
                    if (file2.exists() && file2.isFile()) {
                        int optInt = jSONObject.optInt("length");
                        if (optInt > 0 && file2.length() != optInt) {
                            GameLog.getInstance().w(TAG, "verifyEngine file " + optString + " length fail, config_length:" + optInt + ", local_length:" + file2.length());
                        } else {
                            String optString2 = jSONObject.optString("md5");
                            if (TextUtils.isEmpty(optString2)) {
                                continue;
                            } else {
                                String calcMD5 = calcMD5(file2.getAbsolutePath());
                                if (!TextUtils.isEmpty(calcMD5) && !optString2.equalsIgnoreCase(calcMD5)) {
                                    GameLog.getInstance().w(TAG, "verifyEngine file " + optString + " md5 fail, config_md5:" + optString2 + ", local_md5:" + calcMD5);
                                }
                            }
                        }
                    } else {
                        GameLog.getInstance().w(TAG, "verifyEngine file " + optString + " not found");
                    }
                    return false;
                }
                continue;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void onDownloadLatestTritonEngineSuccess(Version version, String str, EnginePackageUpdater.a aVar) {
        boolean z16;
        int i3;
        synchronized (EnginePackageManager.class) {
            String onlineTritonPathByVersion = getOnlineTritonPathByVersion(version);
            String str2 = onlineTritonPathByVersion + "_" + System.nanoTime();
            MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 6, "1");
            int unZipFolder = ZipUtil.unZipFolder(str, str2);
            boolean verifyEngine = verifyEngine(str2);
            GameLog gameLog = GameLog.getInstance();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("download ");
            sb5.append(version);
            sb5.append(", unzip:");
            if (unZipFolder == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(" verify:");
            sb5.append(verifyEngine);
            gameLog.i(TAG, sb5.toString());
            MiniAppInfo miniAppConfigForPreload = ReportConst.miniAppConfigForPreload();
            if (unZipFolder == 0 && verifyEngine) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            MiniReportManager.reportEventType(miniAppConfigForPreload, 7, null, null, null, i3, "1", 0L, null);
            if (unZipFolder == 0 && verifyEngine) {
                Version onlineTritonVersion = getOnlineTritonVersion();
                if (version.compareTo(onlineTritonVersion) > 0) {
                    File file = new File(onlineTritonPathByVersion);
                    if (file.exists() && file.isDirectory()) {
                        FileUtils.deleteFile(onlineTritonPathByVersion);
                    }
                    if (FileUtils.rename(str2, onlineTritonPathByVersion)) {
                        StorageUtil.getPreference().edit().putString(TRITON_ONLINE_VERSION, version.getVersion()).putLong(TRITON_ONLINE_TIMESTAMP, version.getTimeStamp()).putString(TRITON_INSTALLED_ABI, Build.CPU_ABI).commit();
                        d.b(onlineTritonPathByVersion);
                        aVar.onSuccess();
                        GameLog.getInstance().i(TAG, "[\u5b89\u88c5\u5c0f\u6e38\u620f\u65b0\u7248\u672cso] \u5b89\u88c5\u6210\u529f, path:" + onlineTritonPathByVersion + ", \u66f4\u65b0\u7ebf\u4e0a\u7248\u672c\u81f3:" + version);
                        deleteOldVersionTritonEngine();
                    } else {
                        FileUtils.deleteFile(onlineTritonPathByVersion);
                        aVar.onFail("[\u5b89\u88c5\u5c0f\u6e38\u620f\u65b0\u7248\u672cso] \u5b89\u88c5\u5931\u8d25, rename fail. " + version + " from " + str2 + " to " + onlineTritonPathByVersion);
                    }
                } else {
                    aVar.onFail("[\u5b89\u88c5\u5c0f\u6e38\u620f\u65b0\u7248\u672cso] \u8df3\u8fc7\u5b89\u88c5, \u5df2\u5b58\u5728\u66f4\u9ad8\u6216\u76f8\u540c\u7248\u672c, latestVersion " + onlineTritonVersion + " targetVersion " + version);
                }
            } else {
                aVar.onFail("[\u5b89\u88c5\u5c0f\u6e38\u620f\u65b0\u7248\u672cso] \u89e3\u538b\u6216\u6821\u9a8c\u5931\u8d25!");
            }
            FileUtils.deleteFile(str);
            FileUtils.deleteFile(str2);
        }
    }

    private static boolean verifyEngine(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.isFile()) {
            return false;
        }
        try {
            File file2 = new File(file, "verify.json");
            if (file2.exists() && file2.isFile()) {
                String readFileToString = FileUtils.readFileToString(file2);
                if (TextUtils.isEmpty(readFileToString)) {
                    GameLog.getInstance().i(TAG, "verifyEngine " + str + " verify.json has no content, skip!");
                    return true;
                }
                if (QMLog.isColorLevel()) {
                    GameLog.getInstance().d(TAG, "verifyEngine " + str + " content:" + readFileToString);
                }
                JSONObject jSONObject = new JSONObject(readFileToString);
                if (!jSONObject.has("verify_list")) {
                    GameLog.getInstance().i(TAG, "verifyEngine " + str + " verify.json has no verify_list, skip!");
                    return true;
                }
                return isVerifyListValid(file, true, jSONObject.getJSONArray("verify_list"));
            }
            GameLog.getInstance().i(TAG, "verifyEngine " + str + " has no verify.json, skip!");
            return true;
        } catch (Throwable th5) {
            GameLog.getInstance().e(TAG, "verifyEngine exception.", th5);
            return false;
        }
    }
}
