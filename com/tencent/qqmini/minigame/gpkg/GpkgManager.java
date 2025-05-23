package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileInfo;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ZipUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GpkgManager {
    public static final int NO_PRELOAD = 0;
    public static final int PRELOAD_APPINFI = 1;
    public static final int PRELOAD_GPKG = 2;
    public static final String SUFFIX_TQAPKG = ".tqapkg";
    public static final String SUFFIX_WXAPKG = ".wxapkg";
    public static final String SUFFIX_ZIP = ".zip";
    private static final String TAG = "[minigame] GpkgManager";
    private static final int UNZIP_MAXCOUNT = 3;
    public static volatile long downloadDuration;
    private static final ConcurrentHashMap<String, Boolean> gpkgDownloadedMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface DownloadPluginCallback {
        void onPluginDownloadComplete(boolean z16, @Nullable Throwable th5, Info info);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Info {
        public long connectionTimeMs;
        public long contentSize;
        public long dnsTimeMs;
        public long httpStatusCode;
        public boolean isFromReusedConnection;
        public String message;

        @Nullable
        public Info plugin;
        public long queueTimeMs;
        public long receiveTimeMs;
        public long startDownloadTimeMs;
        public boolean success;
        public long timeCostMs;
        public String url;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static final class MergedOnInitListener implements OnInitGpkgListener, DownloadPluginCallback {
        private MiniAppInfo mGameConfig;
        private boolean mGpkgDone;
        private Info mGpkgDownloadInfo;
        private String mGpkgErrorMsg;
        private MiniGamePkg mGpkgPkg;
        private int mGpkgResCode;
        private final OnInitGpkgListener mMergedResultListener;
        private boolean mPluginDone;
        private Info mPluginDownloadInfo;
        private Throwable mPluginError;
        private boolean mPluginSuccess;

        MergedOnInitListener(MiniAppInfo miniAppInfo, OnInitGpkgListener onInitGpkgListener) {
            this.mGameConfig = miniAppInfo;
            this.mMergedResultListener = onInitGpkgListener;
        }

        private void handleFinish() {
            String str;
            if (this.mGpkgDone && this.mPluginDone) {
                Info info = this.mGpkgDownloadInfo;
                if (info != null) {
                    info.plugin = this.mPluginDownloadInfo;
                }
                if (!this.mPluginSuccess) {
                    OnInitGpkgListener onInitGpkgListener = this.mMergedResultListener;
                    MiniGamePkg miniGamePkg = this.mGpkgPkg;
                    Throwable th5 = this.mPluginError;
                    if (th5 != null) {
                        str = th5.getMessage();
                    } else {
                        str = "download plugin fail";
                    }
                    onInitGpkgListener.onInitGpkgInfo(2022, miniGamePkg, str, this.mGpkgDownloadInfo);
                }
                this.mMergedResultListener.onInitGpkgInfo(this.mGpkgResCode, this.mGpkgPkg, this.mGpkgErrorMsg, this.mGpkgDownloadInfo);
            }
        }

        @Override // com.tencent.qqmini.minigame.gpkg.GpkgManager.OnInitGpkgListener
        public void onDownloadGpkgProgress(MiniAppInfo miniAppInfo, float f16, long j3) {
            this.mMergedResultListener.onDownloadGpkgProgress(miniAppInfo, f16, j3);
        }

        @Override // com.tencent.qqmini.minigame.gpkg.GpkgManager.OnInitGpkgListener
        public synchronized void onInitGpkgInfo(int i3, MiniGamePkg miniGamePkg, String str, Info info) {
            this.mGpkgDone = true;
            this.mGpkgResCode = i3;
            this.mGpkgPkg = miniGamePkg;
            this.mGpkgErrorMsg = str;
            this.mGpkgDownloadInfo = info;
            handleFinish();
        }

        @Override // com.tencent.qqmini.minigame.gpkg.GpkgManager.DownloadPluginCallback
        public synchronized void onPluginDownloadComplete(boolean z16, @Nullable Throwable th5, Info info) {
            this.mPluginDone = true;
            this.mPluginSuccess = z16;
            this.mPluginError = th5;
            this.mPluginDownloadInfo = info;
            if (info != null) {
                info.message = this.mGameConfig.miniGamePluginInfo.name + "/" + this.mGameConfig.miniGamePluginInfo.f348088id + " " + info.message;
            }
            handleFinish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnInitGpkgListener {
        public static final int DEBUG_APK_NOT_EXIST = 2006;
        public static final int DOWNLOAD_PKG_CANCEL = 2003;
        public static final int DOWNLOAD_PKG_FAIL = 2004;
        public static final int DOWNLOAD_PLUGIN_FAIL = 2022;
        public static final int DOWNLOAD_SUB_PKG_CANCEL = 2009;
        public static final int DOWNLOAD_SUB_PKG_FAIL = 2010;
        public static final int EXCEPTION = 2001;
        public static final int GAME_CONFIG_NULL_ERROR = 2002;
        public static final int PKG_FOLD_NOT_EXIST = 2007;
        public static final int RES_SUCC = 0;
        public static final int SUB_PKG_DOWNLOAD_URL_NULL = 2008;
        public static final int SUB_PKG_NOT_EXISTS = 2013;
        public static final int UNKNOWN_SUB_PKG_ERROR = 2012;
        public static final int UNPACK_PKG_FAIL = 2005;
        public static final int UNPACK_SUB_PKG_FAIL = 2011;

        void onDownloadGpkgProgress(MiniAppInfo miniAppInfo, float f16, long j3);

        void onInitGpkgInfo(int i3, MiniGamePkg miniGamePkg, String str, @Nullable Info info);
    }

    private static boolean checkOfflineResourceContent(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str + File.separator + "offlineconfig.json");
                if (file.exists()) {
                    String readFileToString = FileUtils.readFileToString(file);
                    if (!TextUtils.isEmpty(readFileToString)) {
                        return new JSONObject(readFileToString).optBoolean("offlineResourceReady", false);
                    }
                }
            } catch (Throwable th5) {
                QMLog.i(TAG, "[Gpkg] checkOfflineResourceContent error:" + DebugUtil.getPrintableStackTrace(th5));
            }
        }
        return false;
    }

    private static boolean checkPkgFolderContent(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (new File(str + File.separator + "game.js").exists()) {
                    return true;
                }
                return false;
            } catch (Throwable th5) {
                QMLog.i(TAG, "[Gpkg] checkPkgFolderContent error:" + DebugUtil.getPrintableStackTrace(th5));
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void downloadGpkgByResumableDownloader(MiniAppInfo miniAppInfo, OnInitGpkgListener onInitGpkgListener, String str) {
        String str2;
        String str3;
        int i3;
        String str4;
        String str5;
        if (miniAppInfo == null) {
            if (onInitGpkgListener != null) {
                onInitGpkgListener.onInitGpkgInfo(2002, null, "downloadGpkgByResumableDownloader fail invalid params, game config null", null);
            }
            QMLog.e(TAG, "[Gpkg]downloadGpkgByResumableDownloader fail invalid params, game config null");
            return;
        }
        if (!TextUtils.isEmpty(miniAppInfo.appId)) {
            MiniAppStartState.setApkgDownload(miniAppInfo.appId, false);
            gpkgDownloadedMap.put(miniAppInfo.appId, Boolean.FALSE);
        }
        long currentTimeMillis = System.currentTimeMillis();
        FirstPageInfo firstPageInfo = miniAppInfo.firstPage;
        int i16 = -1;
        if (firstPageInfo != null) {
            str2 = firstPageInfo.subPkgName;
            List<SubPkgInfo> list = miniAppInfo.subpkgs;
            if (list != null) {
                Iterator<SubPkgInfo> it = list.iterator();
                str3 = null;
                while (true) {
                    if (it.hasNext()) {
                        SubPkgInfo next = it.next();
                        if (next != null && str2 != null && str2.equals(next.subPkgName)) {
                            if (next.independent == 1) {
                                str4 = next.downloadUrl;
                                i3 = next.fileSize;
                                break;
                            } else {
                                str3 = next.downloadUrl;
                                i16 = next.fileSize;
                            }
                        }
                    } else {
                        str2 = null;
                        i3 = i16;
                        str4 = null;
                        break;
                    }
                }
                if (str4 == null) {
                    str4 = miniAppInfo.downloadUrl;
                    i3 = miniAppInfo.fileSize;
                }
                str5 = str4;
                if (!TextUtils.isEmpty(str5)) {
                    if (onInitGpkgListener != null) {
                        onInitGpkgListener.onInitGpkgInfo(2002, null, "downloadGpkgByResumableDownloader fail invalid params, downloadUrl null", null);
                    }
                    QMLog.e(TAG, "[Gpkg]downloadGpkgByResumableDownloader fail invalid params, downloadUrl null");
                    return;
                }
                String str6 = ".zip";
                if (!str5.toLowerCase().endsWith(".zip")) {
                    str6 = SUFFIX_TQAPKG;
                }
                String str7 = ApkgManager.getPkgRoot(miniAppInfo) + miniAppInfo.appId + util.base64_pad_url + miniAppInfo.versionId + str6;
                QMLog.i(TAG, "[Gpkg]download gpkgUrl=" + str5 + " ,subApkUrl=" + str3 + " ,independentPath=" + str2 + " ,savePath=" + str7 + " ,fileSize=" + i3);
                MiniReportManager.reportEventType(miniAppInfo, 619, "1");
                DownloaderProxy downloaderProxy = (DownloaderProxy) ProxyManager.get(DownloaderProxy.class);
                new HashMap(1).put("Connection", "keep-alive");
                downloaderProxy.download(str5, null, str7, 60, getGpkgDownloadListener(miniAppInfo, onInitGpkgListener, str, currentTimeMillis, str7, i3, str2, str3));
                return;
            }
        }
        str2 = null;
        str3 = null;
        i3 = -1;
        str4 = null;
        if (str4 == null) {
        }
        str5 = str4;
        if (!TextUtils.isEmpty(str5)) {
        }
    }

    private static void downloadGpkgPlugin(final MiniGamePluginInfo miniGamePluginInfo, final DownloadPluginCallback downloadPluginCallback, final File file, final File file2) {
        ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).download(miniGamePluginInfo.url, null, file2.getAbsolutePath(), 60, new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.minigame.gpkg.GpkgManager.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadFailed(int i3, String str) {
                QMLog.e(GpkgManager.TAG, "[Gpkg] download plugin failed " + i3 + " " + MiniGamePluginInfo.this);
                DownloadPluginCallback downloadPluginCallback2 = downloadPluginCallback;
                if (downloadPluginCallback2 != null) {
                    downloadPluginCallback2.onPluginDownloadComplete(false, null, null);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadSucceed(int i3, String str, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
                try {
                    int i16 = MiniGamePluginInfo.this.packageSize;
                    if (i16 != 0 && i16 != file2.length()) {
                        QMLog.e(GpkgManager.TAG, "[Gpkg] download plugin file-size mismatch " + MiniGamePluginInfo.this);
                        DownloadPluginCallback downloadPluginCallback2 = downloadPluginCallback;
                        if (downloadPluginCallback2 != null) {
                            downloadPluginCallback2.onPluginDownloadComplete(false, new RuntimeException("file size mismatch, expected:" + MiniGamePluginInfo.this.packageSize + " got:" + file2.length()), null);
                        }
                    } else {
                        FileUtils.delete(file.getAbsolutePath(), false);
                        if (!WxapkgUnpacker.unpackSync(file2.getAbsolutePath(), file.getAbsolutePath())) {
                            QMLog.e(GpkgManager.TAG, "[Gpkg] download plugin unpack failed " + MiniGamePluginInfo.this);
                            DownloadPluginCallback downloadPluginCallback3 = downloadPluginCallback;
                            if (downloadPluginCallback3 != null) {
                                downloadPluginCallback3.onPluginDownloadComplete(false, new RuntimeException("unpack file failed"), null);
                            }
                        } else {
                            QMLog.i(GpkgManager.TAG, "[Gpkg] download plugin success " + MiniGamePluginInfo.this);
                            DownloadPluginCallback downloadPluginCallback4 = downloadPluginCallback;
                            if (downloadPluginCallback4 != null) {
                                downloadPluginCallback4.onPluginDownloadComplete(true, null, GpkgManager.getInfoFromDownloadResult(downloadResult));
                            }
                        }
                    }
                } finally {
                    file2.delete();
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

    private static DownloaderProxy.DownloadListener getGpkgDownloadListener(final MiniAppInfo miniAppInfo, final OnInitGpkgListener onInitGpkgListener, final String str, final long j3, final String str2, final int i3, final String str3, final String str4) {
        return new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.minigame.gpkg.GpkgManager.4
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadFailed(int i16, String str5) {
                MiniReportManager.reportEventType(MiniAppInfo.this, 1011, "game pkg download failed s=[" + str5 + "], httpStatus=[" + i16 + "] ", "1");
                MiniReportManager.reportEventType(MiniAppInfo.this, 620, null, null, null, i16, "1", 0L, null);
                OnInitGpkgListener onInitGpkgListener2 = onInitGpkgListener;
                if (onInitGpkgListener2 != null) {
                    onInitGpkgListener2.onInitGpkgInfo(2004, null, "download pkg fail", null);
                    QMLog.e(GpkgManager.TAG, "[Gpkg]onDownloadFailed() called with: s = [" + i16 + "], downloadResult = [" + str5 + "]");
                }
                SDKMiniProgramLpReportDC04239.reportForSDK(MiniAppInfo.this, "1", null, "page_view", "load_fail", "download_apk_fail", "");
                MiniAppReportManager2.reportPageView("2launch_fail", "download_apk_fail", null, MiniAppInfo.this);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadProgress(float f16, long j16, long j17) {
                int i16;
                OnInitGpkgListener onInitGpkgListener2 = onInitGpkgListener;
                if (onInitGpkgListener2 != null) {
                    if (j17 == 0 && (i16 = i3) > 0) {
                        j17 = i16;
                        if (j17 > j16) {
                            f16 = (((float) j16) * 1.0f) / ((float) j17);
                        }
                    }
                    onInitGpkgListener2.onDownloadGpkgProgress(MiniAppInfo.this, f16, j17);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadSucceed(int i16, String str5, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
                GpkgManager.downloadDuration = System.currentTimeMillis() - j3;
                QMLog.i(GpkgManager.TAG, "[Gpkg] onDownloadSucceed " + i16 + ",cost:" + GpkgManager.downloadDuration);
                MiniReportManager.addCostTimeEventAttachInfo(MiniAppInfo.this, 2, "1");
                MiniAppInfo miniAppInfo2 = MiniAppInfo.this;
                long j16 = 0;
                if (GpkgManager.downloadDuration > 0) {
                    j16 = GpkgManager.downloadDuration;
                }
                MiniReportManager.reportEventType(miniAppInfo2, 620, null, null, null, 0, "1", j16, null);
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).reportTrafficFlow(1, "downloadMainPkg", "SDK#GpkgManager", downloadResult.url, i3 / 1024);
                GpkgManager.handleGpkgDownloadSuccess(GpkgManager.getGpkgFilePath(str2), str, MiniAppInfo.this, onInitGpkgListener, str4, str3, downloadResult);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadHeadersReceived(int i16, Map<String, List<String>> map) {
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00c6 A[EDGE_INSN: B:48:0x00c6->B:52:0x00c6 BREAK  A[LOOP:0: B:8:0x0028->B:49:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[LOOP:0: B:8:0x0028->B:49:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getGpkgFilePath(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (".zip".equals(FileUtils.getExtension(str))) {
            String replace = str.replace(".zip", "_tmp");
            String replace2 = str.replace(".zip", SUFFIX_TQAPKG);
            int i3 = 0;
            while (true) {
                try {
                    if (ZipUtil.unZipFolder(str, replace) == 0 && FileUtils.fileExists(replace)) {
                        ArrayList<FileInfo> files = FileUtils.getFiles(replace, false, 0);
                        if (files != null && files.size() > 0) {
                            Iterator<FileInfo> it = files.iterator();
                            while (it.hasNext()) {
                                FileInfo next = it.next();
                                if (SUFFIX_TQAPKG.equals(FileUtils.getExtension(next.getPath())) || SUFFIX_WXAPKG.equals(FileUtils.getExtension(next.getPath()))) {
                                    str2 = next.getPath();
                                    break;
                                }
                            }
                        }
                        if (FileUtils.fileExists(str2) && FileUtils.renameFile(new File(str2), new File(replace2))) {
                            try {
                                FileUtils.delete(replace, false);
                                str2 = replace2;
                                break;
                            } catch (Throwable th5) {
                                th = th5;
                                str2 = replace2;
                                QMLog.e(TAG, "[Gpkg] getGpkgFilePath, unZip file " + str + " to " + replace + " error. tryCount:" + i3, th);
                                FileUtils.delete(replace, false);
                                i3++;
                                if (i3 < 3) {
                                }
                            }
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
                i3++;
                if (i3 < 3) {
                    break;
                }
            }
        }
        if (FileUtils.fileExists(str2)) {
            if (!str2.equals(str)) {
                FileUtils.delete(str, false);
            }
        } else {
            str2 = str;
        }
        QMLog.i(TAG, "[Gpkg] getGpkgFilePath gpkgPath:" + str2 + ", savePath:" + str);
        return str2;
    }

    public static void getGpkgInfoByConfig(final MiniAppInfo miniAppInfo, final OnInitGpkgListener onInitGpkgListener) {
        if (miniAppInfo == null) {
            QMLog.e(TAG, "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
            if (onInitGpkgListener != null) {
                onInitGpkgListener.onInitGpkgInfo(2002, null, "getGpkgInfoByConfig invalid request, game config null", null);
                return;
            }
            return;
        }
        ApkgMainProcessManager.checkShouldLoadPkgInMainProcess(miniAppInfo, new MiniCmdCallback.Stub() { // from class: com.tencent.qqmini.minigame.gpkg.GpkgManager.1
            @Override // com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
            public void onCmdResult(boolean z16, Bundle bundle) throws RemoteException {
                if (z16) {
                    GpkgManager.loadGpkgInMiniProcess(MiniAppInfo.this, onInitGpkgListener);
                } else if (bundle != null) {
                    onInitGpkgListener.onDownloadGpkgProgress(MiniAppInfo.this, bundle.getFloat(ApkgMainProcessManager.EXTRA_PROGRESS), bundle.getLong(ApkgMainProcessManager.EXTRA_TOTAL_SIZE));
                }
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Info getInfoFromDownloadResult(DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
        if (downloadResult == null) {
            return null;
        }
        Info info = new Info();
        info.url = downloadResult.url;
        info.timeCostMs = downloadResult.totalTimeMs;
        info.queueTimeMs = downloadResult.queueTimeMs;
        info.connectionTimeMs = downloadResult.connectionTimeMs;
        info.contentSize = downloadResult.contentLength;
        info.dnsTimeMs = downloadResult.dnsTimeMs;
        info.httpStatusCode = downloadResult.httpStatusCode;
        info.message = downloadResult.message;
        info.isFromReusedConnection = downloadResult.isFromReusedConnection;
        info.receiveTimeMs = downloadResult.receiveTimeMs;
        info.startDownloadTimeMs = downloadResult.startTimeMs;
        info.success = downloadResult.success;
        return info;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleGpkgDownloadSuccess(String str, String str2, MiniAppInfo miniAppInfo, OnInitGpkgListener onInitGpkgListener, String str3, String str4, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
        File file = new File(str);
        MiniReportManager.reportEventType(miniAppInfo, 621, "1");
        boolean unpackSync = WxapkgUnpacker.unpackSync(file.getAbsolutePath(), str2);
        MiniReportManager.reportEventType(miniAppInfo, 622, null, null, null, !unpackSync ? 1 : 0, "1", 0L, null);
        QMLog.i(TAG, "[Gpkg] handleGpkgDownloadSuccess path:" + str + ",unpack:" + str2 + ",hasUnpack:" + unpackSync);
        if (unpackSync) {
            MiniGamePkg loadGamePkgFromFolderPath = MiniGamePkg.loadGamePkgFromFolderPath(str2, str4, miniAppInfo);
            if (onInitGpkgListener != null) {
                onInitGpkgListener.onInitGpkgInfo(0, loadGamePkgFromFolderPath, "download pkg and unpack succeed", getInfoFromDownloadResult(downloadResult));
                return;
            }
            return;
        }
        SDKMiniProgramLpReportDC04239.reportForSDK(miniAppInfo, "1", null, "page_view", "load_fail", "unpkg_fail", "");
        MiniAppReportManager2.reportPageView("2launch_fail", "unpkg_fail", null, miniAppInfo);
        QMLog.e(TAG, "[Gpkg] handleGpkgDownloadSuccess hasUnpack=" + unpackSync);
        if (onInitGpkgListener != null) {
            onInitGpkgListener.onInitGpkgInfo(2005, null, "download pkg succeed but unpack fail", getInfoFromDownloadResult(downloadResult));
        }
    }

    public static boolean isGpkgDownloaded(String str) {
        Boolean bool;
        if (TextUtils.isEmpty(str) || (bool = gpkgDownloadedMap.get(str)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean isGpkgValid(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return false;
        }
        String apkgFolderPath = ApkgManager.getApkgFolderPath(miniAppInfo);
        if (!new File(apkgFolderPath).exists()) {
            return false;
        }
        return checkPkgFolderContent(apkgFolderPath);
    }

    public static boolean isOfflineResourceReady(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return false;
        }
        String apkgFolderPath = ApkgManager.getApkgFolderPath(miniAppInfo);
        if (!new File(apkgFolderPath).exists() || !checkPkgFolderContent(apkgFolderPath)) {
            return false;
        }
        return checkOfflineResourceContent(apkgFolderPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadGpkgInMiniProcess(MiniAppInfo miniAppInfo, OnInitGpkgListener onInitGpkgListener) {
        performGetGpkgInfoByConfig(miniAppInfo, onInitGpkgListener);
    }

    private static void performDownloadGpkg(MiniAppInfo miniAppInfo, OnInitGpkgListener onInitGpkgListener, String str) {
        if (new File(str).exists()) {
            if (checkPkgFolderContent(str)) {
                QMLog.i(TAG, "[Gpkg] checkPkgFolderContent success");
                MiniGamePkg loadGamePkgFromFolderPath = MiniGamePkg.loadGamePkgFromFolderPath(str, null, miniAppInfo);
                if (onInitGpkgListener != null) {
                    onInitGpkgListener.onInitGpkgInfo(0, loadGamePkgFromFolderPath, "gpkg exist, no need download", null);
                }
                if (!TextUtils.isEmpty(miniAppInfo.appId)) {
                    MiniAppStartState.setApkgDownload(miniAppInfo.appId, true);
                    gpkgDownloadedMap.put(miniAppInfo.appId, Boolean.TRUE);
                    return;
                }
                return;
            }
            QMLog.i(TAG, "[Gpkg] checkPkgFolderContent failed, delete folder:" + str);
            FileUtils.delete(str, false);
            QMLog.i(TAG, "[Gpkg] download gpkg by url1:" + miniAppInfo.downloadUrl);
            downloadGpkgByResumableDownloader(miniAppInfo, onInitGpkgListener, str);
            return;
        }
        QMLog.i(TAG, "[Gpkg] download gpkg by url2:" + miniAppInfo.downloadUrl);
        downloadGpkgByResumableDownloader(miniAppInfo, onInitGpkgListener, str);
    }

    private static void performDownloadGpkgPlugin(MiniGamePluginInfo miniGamePluginInfo, DownloadPluginCallback downloadPluginCallback) {
        File file = new File(ApkgManager.getGpkgPluginFolderPath(miniGamePluginInfo));
        if (file.exists()) {
            if (new File(file, "plugin.js").exists()) {
                QMLog.i(TAG, "[Gpkg] plugin existed:" + file.getAbsolutePath() + " " + miniGamePluginInfo);
                if (downloadPluginCallback != null) {
                    downloadPluginCallback.onPluginDownloadComplete(true, null, null);
                    return;
                }
                return;
            }
            QMLog.e(TAG, "[Gpkg] plugin corrupted:" + file.getAbsolutePath() + " " + miniGamePluginInfo);
        }
        try {
            File createTempFile = File.createTempFile("gpkg_plugin_" + miniGamePluginInfo.f348088id, SUFFIX_WXAPKG);
            if (TextUtils.isEmpty(miniGamePluginInfo.url)) {
                if (downloadPluginCallback != null) {
                    downloadPluginCallback.onPluginDownloadComplete(false, null, null);
                }
                QMLog.e(TAG, "[Gpkg] download plugin failed pluginInfo.url null");
                return;
            }
            QMLog.i(TAG, "[Gpkg] start download plugin to:" + file.getAbsolutePath() + " " + miniGamePluginInfo);
            downloadGpkgPlugin(miniGamePluginInfo, downloadPluginCallback, file, createTempFile);
        } catch (IOException e16) {
            if (downloadPluginCallback != null) {
                downloadPluginCallback.onPluginDownloadComplete(false, e16, null);
            }
        }
    }

    public static void performGetGpkgInfoByConfig(MiniAppInfo miniAppInfo, OnInitGpkgListener onInitGpkgListener) {
        MiniReportManager.addCostTimeEventAttachInfo(miniAppInfo, 2, "0");
        if (miniAppInfo == null) {
            QMLog.e(TAG, "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
            if (onInitGpkgListener != null) {
                onInitGpkgListener.onInitGpkgInfo(2002, null, "getGpkgInfoByConfig invalid request, game config null", null);
                return;
            }
            return;
        }
        QMLog.i(TAG, "[Gpkg] getGpkgInfoByConfig version:" + miniAppInfo.version + ", appid=" + miniAppInfo.appId + ",size=" + miniAppInfo.fileSize);
        String apkgFolderPath = ApkgManager.getApkgFolderPath(miniAppInfo);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[Gpkg] getGpkgInfoByConfig folderPath:");
        sb5.append(apkgFolderPath);
        QMLog.i(TAG, sb5.toString());
        if (miniAppInfo.verType != 3 && (!miniAppInfo.isSupportOffline || miniAppInfo.launchParam.scene == 1011)) {
            QMLog.i(TAG, "[Gpkg]verType is not online " + miniAppInfo.verType + ", delete path " + apkgFolderPath);
            if (new File(apkgFolderPath).exists()) {
                FileUtils.delete(apkgFolderPath, false);
            }
        }
        MergedOnInitListener mergedOnInitListener = new MergedOnInitListener(miniAppInfo, onInitGpkgListener);
        performDownloadGpkg(miniAppInfo, mergedOnInitListener, apkgFolderPath);
        MiniGamePluginInfo miniGamePluginInfo = miniAppInfo.miniGamePluginInfo;
        if (miniGamePluginInfo != null) {
            performDownloadGpkgPlugin(miniGamePluginInfo, mergedOnInitListener);
            return;
        }
        QMLog.i(TAG, "[Gpkg] game don't have plugin " + miniAppInfo.name + " " + miniAppInfo.appId);
        mergedOnInitListener.onPluginDownloadComplete(true, null, null);
    }

    public static boolean pkgExists(MiniAppInfo miniAppInfo) {
        return new File(ApkgManager.getApkgFolderPath(miniAppInfo)).exists();
    }

    public static void preloadGpkgByConfig(final MiniAppInfo miniAppInfo) {
        ThreadManager.executeOnNetworkIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.minigame.gpkg.GpkgManager.2
            @Override // java.lang.Runnable
            public void run() {
                ApkgMainProcessManager.checkShouldLoadPkgInMainProcess(MiniAppInfo.this, null, true);
            }
        });
    }

    public static void setOfflineResourceContent(MiniAppInfo miniAppInfo, boolean z16) {
        if (miniAppInfo == null) {
            return;
        }
        String apkgFolderPath = ApkgManager.getApkgFolderPath(miniAppInfo);
        if (new File(apkgFolderPath).exists()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("offlineResourceReady", z16);
                FileUtils.writeFile(new File(apkgFolderPath, "offlineconfig.json").getAbsolutePath(), jSONObject.toString().replaceAll("\\\\", ""));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }
}
