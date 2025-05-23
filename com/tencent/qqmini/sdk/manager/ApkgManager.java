package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.PreLoadApkgToStrHelper;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ApkgManager {
    public static final String MINI_APP_MAIN_PKG = "/__APP__/";
    public static final String MINI_GAME_PERSISTENT_SP_KEY = "persistent";
    public static final String MINI_GAME_PERSISTENT_SP_NAME = "persistent_debug_version_";
    public static final String SUFFIX_WXAPKG = ".qapkg";
    private static final String TAG = "ApkgManager";
    public static volatile long downloadDuration;
    private static volatile ApkgManager sInstance;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnGetApkgInfoListener {
        void onGetApkgInfo(ApkgInfo apkgInfo, int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnInitApkgListener {
        public static final int RES_DOWNLOAD_CANCEL = 4;
        public static final int RES_DOWNLOAD_FAIL = 2;
        public static final int RES_FAIL = 1;
        public static final int RES_FAIL_URL_IS_EMPTY = 5;
        public static final int RES_SUCC = 0;
        public static final int RES_UNPACK_FAIL = 3;

        void onInitApkgInfo(int i3, ApkgInfo apkgInfo, String str);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class RootPath {
        private static String PATH_APKG_TISSUE_ROOT;
        private static String PATH_GAMEPKG_ROOT;
        private static String PATH_WXAPKG_ROOT;

        public static String getAppPkgRoot() {
            if (PATH_WXAPKG_ROOT == null) {
                PATH_WXAPKG_ROOT = getRoot() + "/mini/";
            }
            return PATH_WXAPKG_ROOT;
        }

        public static String getGamePkgRoot() {
            if (PATH_GAMEPKG_ROOT == null) {
                PATH_GAMEPKG_ROOT = getRoot() + "/minigame/";
            }
            return PATH_GAMEPKG_ROOT;
        }

        public static String getRoot() {
            if (AppLoaderFactory.g().getContext() == null) {
                return "";
            }
            return AppLoaderFactory.g().getContext().getFilesDir().getPath();
        }

        public static String getTissuePkgRoot() {
            if (PATH_APKG_TISSUE_ROOT == null) {
                PATH_APKG_TISSUE_ROOT = getRoot() + "/mini_tissue/";
            }
            return PATH_APKG_TISSUE_ROOT;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements DownloaderProxy.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloaderProxy.DownloadListener f348091a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f348092b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ApkgInfo f348093c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SubPkgInfo f348094d;

        a(DownloaderProxy.DownloadListener downloadListener, String str, ApkgInfo apkgInfo, SubPkgInfo subPkgInfo) {
            this.f348091a = downloadListener;
            this.f348092b = str;
            this.f348093c = apkgInfo;
            this.f348094d = subPkgInfo;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadFailed(int i3, String str) {
            File file = new File(this.f348092b);
            if (file.exists()) {
                file.delete();
            }
            DownloaderProxy.DownloadListener downloadListener = this.f348091a;
            if (downloadListener != null) {
                downloadListener.onDownloadFailed(i3, str);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadHeadersReceived(int i3, Map<String, List<String>> map) {
            DownloaderProxy.DownloadListener downloadListener = this.f348091a;
            if (downloadListener != null) {
                downloadListener.onDownloadHeadersReceived(i3, map);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadProgress(float f16, long j3, long j16) {
            DownloaderProxy.DownloadListener downloadListener = this.f348091a;
            if (downloadListener != null) {
                downloadListener.onDownloadProgress(f16, j3, j16);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadSucceed(int i3, String str, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
            File file = new File(this.f348092b);
            if (file.exists()) {
                file.renameTo(new File(this.f348093c.getSubSavePath(this.f348094d)));
                str = file.getAbsolutePath();
            }
            DownloaderProxy.DownloadListener downloadListener = this.f348091a;
            if (downloadListener != null) {
                downloadListener.onDownloadSucceed(i3, str, downloadResult);
            }
        }
    }

    private void deleteOldPkg(final MiniAppInfo miniAppInfo, final String str) {
        ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.ApkgManager.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (miniAppInfo != null && !TextUtils.isEmpty(str)) {
                        String pkgRoot = ApkgManager.getPkgRoot(miniAppInfo);
                        String md5 = MD5Utils.toMD5(miniAppInfo.appId);
                        File file = new File(pkgRoot);
                        if (file.isDirectory()) {
                            for (String str2 : file.list()) {
                                if (!TextUtils.isEmpty(str2) && str2.startsWith(md5) && !str.contains(str2)) {
                                    QMLog.d(ApkgManager.TAG, "delete pkg : " + str2);
                                    FileUtils.delete(pkgRoot + str2, false);
                                }
                            }
                        }
                    }
                } catch (Throwable th5) {
                    QMLog.e(ApkgManager.TAG, "deleteOldPkg error,", th5);
                }
            }
        });
    }

    private void deleteoldSubPkg(final ApkgInfo apkgInfo, final MiniAppInfo miniAppInfo) {
        if (!miniAppInfo.isContainerLoad()) {
            return;
        }
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.ApkgManager.5
            @Override // java.lang.Runnable
            public void run() {
                for (SubPkgInfo subPkgInfo : miniAppInfo.subpkgs) {
                    String apkgFolderPath = apkgInfo.getApkgFolderPath();
                    File file = new File(apkgFolderPath);
                    if (file.isDirectory()) {
                        for (String str : file.list()) {
                            if (!TextUtils.isEmpty(str) && str.startsWith(subPkgInfo.subPkgName) && !str.contains(subPkgInfo.versionId)) {
                                QMLog.d(ApkgManager.TAG, "delete pkg : " + str);
                                FileUtils.delete(apkgFolderPath + str, false);
                            }
                        }
                    }
                }
            }
        });
    }

    private void doDownload(ApkgInfo apkgInfo, MiniAppInfo miniAppInfo, String str, OnInitApkgListener onInitApkgListener, String str2, String str3, String str4, long j3) {
        if (!TextUtils.isEmpty(str2)) {
            MiniReportManager.reportEventType(miniAppInfo, 613, str, null, null, 0, "0", 0L, null);
            ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).miniAppDownload(miniAppInfo.isContainerInfo(), str2, null, str4, 60, j3, new b(onInitApkgListener, apkgInfo, str3, str2, str4, j3, miniAppInfo, str));
        } else {
            QMLog.d(TAG, "downloadSubPack fail because subPackDownloadUrl is null!");
            onInitApkgListener.onInitApkgInfo(1, apkgInfo, null);
        }
    }

    private void downloadApkgByResumableDownloader(MiniAppInfo miniAppInfo, boolean z16, OnGetApkgInfoListener onGetApkgInfoListener, String str) {
        String str2;
        String str3;
        String str4;
        FirstPageInfo firstPageInfo = miniAppInfo.firstPage;
        String str5 = null;
        if (firstPageInfo != null) {
            String str6 = firstPageInfo.subPkgName;
            Iterator<SubPkgInfo> it = miniAppInfo.subpkgs.iterator();
            String str7 = null;
            while (true) {
                if (!it.hasNext()) {
                    str3 = null;
                    break;
                }
                SubPkgInfo next = it.next();
                if (next != null && (str4 = next.subPkgName) != null && str4.equals(str6)) {
                    if (next.independent == 1) {
                        str5 = next.downloadUrl;
                        str3 = str6;
                        break;
                    }
                    str7 = miniAppInfo.firstPage.pagePath;
                }
            }
            str2 = str7;
        } else {
            str2 = null;
            str3 = null;
        }
        if (str5 == null) {
            str5 = miniAppInfo.downloadUrl;
        }
        downloadApkgByResumableDownloader(miniAppInfo, z16, onGetApkgInfoListener, str, str5, str2, str3);
    }

    public static String getApkgFolderPath(MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
            if (miniAppInfo.verType == 3) {
                return getPkgRoot(miniAppInfo) + MD5Utils.toMD5(miniAppInfo.appId) + "_" + miniAppInfo.versionId;
            }
            return getPkgRoot(miniAppInfo) + miniAppInfo.appId + "_debug";
        }
        return "";
    }

    public static String getGpkgPluginFolderPath(MiniGamePluginInfo miniGamePluginInfo) {
        return RootPath.getGamePkgRoot() + MD5Utils.toMD5(miniGamePluginInfo.f348088id) + "_plugin_" + miniGamePluginInfo.version;
    }

    public static ApkgManager getInstance() {
        if (sInstance == null) {
            synchronized (ApkgManager.class) {
                if (sInstance == null) {
                    sInstance = new ApkgManager();
                }
            }
        }
        return sInstance;
    }

    public static String getPkgRoot(MiniAppInfo miniAppInfo) {
        if (miniAppInfo.isEngineTypeMiniGame()) {
            return RootPath.getGamePkgRoot();
        }
        if (miniAppInfo.launchParam.isFlutterMode) {
            return RootPath.getTissuePkgRoot();
        }
        return RootPath.getAppPkgRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleApkgDownloadSuccess(String str, String str2, MiniAppInfo miniAppInfo, String str3, String str4, OnGetApkgInfoListener onGetApkgInfoListener) {
        boolean z16 = false;
        MiniAppStartState.setApkgDownload(miniAppInfo.appId, false);
        File file = new File(str);
        boolean z17 = miniAppInfo.launchParam.isFlutterMode;
        if (z17) {
            MiniReportManager.reportEventType(miniAppInfo, 621, "0");
            z16 = WxapkgUnpacker.unpackSync(file.getAbsolutePath(), str2);
            MiniReportManager.reportEventType(miniAppInfo, 622, null, null, null, !z16 ? 1 : 0);
        } else {
            if (!FileUtils.copyFile(str, str2 + "/mini.qapkg")) {
                QMLog.e(TAG, "copyFile to " + str + str2 + "/mini.qapkg err");
                return;
            }
            FileUtils.deleteFile(str);
        }
        if (!z16 && z17) {
            if (onGetApkgInfoListener != null) {
                onGetApkgInfoListener.onGetApkgInfo(null, 3, "\u89e3\u5305\u5931\u8d25");
                return;
            }
            return;
        }
        handleDownloadSubPack(str2, miniAppInfo, str3, str4, onGetApkgInfoListener);
    }

    private void handleDownloadSubPack(String str, MiniAppInfo miniAppInfo, String str2, String str3, final OnGetApkgInfoListener onGetApkgInfoListener) {
        ApkgInfo apkgInfo;
        try {
            apkgInfo = ApkgInfo.loadApkgInfoFromFolderPath(str, str3, miniAppInfo);
        } catch (Throwable th5) {
            QMLog.e(TAG, "exception when loadApkgInfoFromFolderPath.", th5);
            apkgInfo = null;
        }
        if (str2 != null && apkgInfo != null) {
            downloadSubPack(apkgInfo, miniAppInfo, str2, new OnInitApkgListener() { // from class: com.tencent.qqmini.sdk.manager.ApkgManager.3
                @Override // com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener
                public void onInitApkgInfo(int i3, ApkgInfo apkgInfo2, String str4) {
                    if (i3 == 0) {
                        OnGetApkgInfoListener onGetApkgInfoListener2 = onGetApkgInfoListener;
                        if (onGetApkgInfoListener2 != null) {
                            onGetApkgInfoListener2.onGetApkgInfo(apkgInfo2, i3, str4);
                            return;
                        }
                        return;
                    }
                    OnGetApkgInfoListener onGetApkgInfoListener3 = onGetApkgInfoListener;
                    if (onGetApkgInfoListener3 != null) {
                        onGetApkgInfoListener3.onGetApkgInfo(null, i3, str4);
                    }
                }
            });
        } else if (onGetApkgInfoListener != null) {
            if (apkgInfo != null) {
                onGetApkgInfoListener.onGetApkgInfo(apkgInfo, 0, "");
            } else {
                onGetApkgInfoListener.onGetApkgInfo(apkgInfo, 1, "apkginfo is null");
            }
        }
    }

    private boolean isApkgInfoValid(ApkgInfo apkgInfo) {
        if (apkgInfo == null) {
            return false;
        }
        if (TextUtils.isEmpty(apkgInfo.mConfigStr)) {
            QMLog.e(TAG, "apkgInfo.mConfigStr is null!");
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0014, code lost:
    
        if (isApkgInfoValid(r0) == false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void loadApkgInfo(MiniAppInfo miniAppInfo, boolean z16, OnGetApkgInfoListener onGetApkgInfoListener, String str) {
        Throwable th5;
        ApkgInfo apkgInfo;
        ApkgInfo apkgInfo2 = null;
        if (new File(str).exists()) {
            try {
                apkgInfo = ApkgInfo.loadApkgInfoFromFolderPath(str, null, miniAppInfo);
            } catch (Throwable th6) {
                th5 = th6;
                apkgInfo = null;
            }
            try {
            } catch (Throwable th7) {
                th5 = th7;
                QMLog.e(TAG, "exception when loadApkgInfoFromFolderPath.", th5);
                apkgInfo2 = apkgInfo;
                String str2 = "";
                if (apkgInfo2 == null) {
                }
            }
        }
        String str22 = "";
        if (apkgInfo2 == null) {
            if (onGetApkgInfoListener != null) {
                onGetApkgInfoListener.onGetApkgInfo(apkgInfo2, 0, "");
            }
            LaunchParam launchParam = miniAppInfo.launchParam;
            if (launchParam != null) {
                str22 = launchParam.entryPath;
            }
            MiniAppReportManager2.reportPageView("cache_apkg_hit", "hit", str22, miniAppInfo);
            return;
        }
        downloadApkgByResumableDownloader(miniAppInfo, z16, onGetApkgInfoListener, str);
        LaunchParam launchParam2 = miniAppInfo.launchParam;
        if (launchParam2 != null) {
            str22 = launchParam2.entryPath;
        }
        MiniAppReportManager2.reportPageView("cache_apkg_hit", "unhit", str22, miniAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInitApkgInfo(OnInitApkgListener onInitApkgListener, int i3, ApkgInfo apkgInfo, String str) {
        QMLog.d(TAG, "onInitApkgInfo :" + i3 + "|" + str);
        if (onInitApkgListener != null) {
            onInitApkgListener.onInitApkgInfo(i3, apkgInfo, str);
        }
    }

    public static boolean pkgExists(MiniAppInfo miniAppInfo) {
        return new File(getApkgFolderPath(miniAppInfo)).exists();
    }

    public void containerDownloadSubPkg(ApkgInfo apkgInfo, MiniAppInfo miniAppInfo, SubPkgInfo subPkgInfo, DownloaderProxy.DownloadListener downloadListener) {
        if (miniAppInfo.isContainerLoad() && subPkgInfo != null) {
            String subTempSavePath = apkgInfo.getSubTempSavePath(subPkgInfo);
            ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).miniAppDownload(miniAppInfo.isContainerInfo(), subPkgInfo.downloadUrl, null, subTempSavePath, 60, subPkgInfo.fileSize, new a(downloadListener, subTempSavePath, apkgInfo, subPkgInfo));
        }
    }

    public void downloadSubPack(ApkgInfo apkgInfo, MiniAppInfo miniAppInfo, String str, OnInitApkgListener onInitApkgListener) {
        long j3;
        String str2;
        String str3;
        if ("/__APP__/".equals(str)) {
            String str4 = miniAppInfo.downloadUrl;
            j3 = miniAppInfo.fileSize;
            str3 = str4;
            str2 = "";
        } else {
            if (apkgInfo == null) {
                QMLog.e(TAG, "apkgInfo is null");
                return;
            }
            String rootPath = apkgInfo.getRootPath(str);
            SubPkgInfo subPkgInfo = apkgInfo.getSubPkgInfo(miniAppInfo, rootPath);
            if (subPkgInfo != null) {
                String str5 = subPkgInfo.downloadUrl;
                long j16 = subPkgInfo.fileSize;
                str3 = str5;
                j3 = j16;
                str2 = rootPath;
            } else {
                j3 = 0;
                str2 = rootPath;
                str3 = "";
            }
        }
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "downloadSubPack | downPage=" + str + "; subPackDownloadUrl=" + str3);
        }
        if (TextUtils.isEmpty(str3)) {
            if (QMLog.isColorLevel()) {
                QMLog.e(TAG, "subPackDownloadUrl is null, return.");
            }
            if (onInitApkgListener != null) {
                onInitApkgListener.onInitApkgInfo(5, apkgInfo, null);
                return;
            }
            return;
        }
        String replaceAll = str2.replaceAll("/", "");
        File apkgFile = apkgInfo.getApkgFile(str);
        String path = apkgFile.getPath();
        boolean z16 = miniAppInfo.launchParam.isFlutterMode;
        if ("/__APP__/".equals(str)) {
            if (onInitApkgListener != null) {
                onInitApkgListener.onInitApkgInfo(0, apkgInfo, null);
                return;
            }
            return;
        }
        if (apkgFile.exists() && !z16) {
            QMLog.d(TAG, "downloadSubPack | subRoot=" + replaceAll + " has downloaded. path=" + path);
            if (miniAppInfo.isContainerLoad()) {
                try {
                    apkgFile.delete();
                } catch (Exception e16) {
                    QMLog.e(TAG, "downloadSubPack | delete exits file exception:" + e16);
                }
            } else {
                if (onInitApkgListener != null) {
                    onInitApkgListener.onInitApkgInfo(0, apkgInfo, null);
                }
                PreLoadApkgToStrHelper.getInstance().preloadSubApkgInfoToMap(miniAppInfo);
                return;
            }
        }
        doDownload(apkgInfo, miniAppInfo, str, onInitApkgListener, str3, str2, path, j3);
        deleteoldSubPkg(apkgInfo, miniAppInfo);
    }

    public void getApkgInfoByConfig(MiniAppInfo miniAppInfo, OnInitApkgListener onInitApkgListener) {
        getApkgInfoByConfig(miniAppInfo, true, onInitApkgListener);
    }

    public void getApkgInfoByConfig(final MiniAppInfo miniAppInfo, boolean z16, final OnInitApkgListener onInitApkgListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        MiniReportManager.reportEventType(miniAppInfo, 12, null, null, null, 0);
        getApkgInfoByConfig(miniAppInfo, z16, new OnGetApkgInfoListener() { // from class: com.tencent.qqmini.sdk.manager.ApkgManager.1
            @Override // com.tencent.qqmini.sdk.manager.ApkgManager.OnGetApkgInfoListener
            public void onGetApkgInfo(ApkgInfo apkgInfo, int i3, String str) {
                if (i3 != 0 || apkgInfo == null) {
                    ApkgManager.this.onInitApkgInfo(onInitApkgListener, i3, null, str);
                } else {
                    ApkgManager.this.onInitApkgInfo(onInitApkgListener, 0, apkgInfo, "Apkg init succ :" + (System.currentTimeMillis() - currentTimeMillis));
                }
                MiniReportManager.reportEventType(miniAppInfo, 13, null, null, null, 0);
            }
        });
    }

    private void getApkgInfoByConfig(MiniAppInfo miniAppInfo, boolean z16, OnGetApkgInfoListener onGetApkgInfoListener) {
        if (miniAppInfo == null) {
            return;
        }
        QMLog.d(TAG, "getApkgInfoByConfig version:" + miniAppInfo.version);
        String apkgFolderPath = getApkgFolderPath(miniAppInfo);
        if (miniAppInfo.verType != 3) {
            QMLog.d(TAG, "verType is not online, delete unPackFolderPath." + miniAppInfo.verType);
            if (new File(apkgFolderPath).exists()) {
                FileUtils.delete(apkgFolderPath, false);
            }
        }
        if (miniAppInfo.launchParam.isFlutterMode) {
            try {
                String str = apkgFolderPath + "_maintmp";
                if (new File(str).exists()) {
                    ApkgInfo loadApkgInfoFromFolderPath = ApkgInfo.loadApkgInfoFromFolderPath(str, null, miniAppInfo);
                    if (loadApkgInfoFromFolderPath != null) {
                        QMLog.i(TAG, "apkg has download in main process. folder:" + str);
                        MiniAppStartState.setApkgDownload(miniAppInfo.appId, true);
                        if (onGetApkgInfoListener != null) {
                            onGetApkgInfoListener.onGetApkgInfo(loadApkgInfoFromFolderPath, 0, "\u52a0\u8f7d\u6210\u529f");
                            return;
                        }
                        return;
                    }
                    return;
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, "", th5);
            }
        }
        loadApkgInfo(miniAppInfo, z16, onGetApkgInfoListener, apkgFolderPath);
    }

    private void downloadApkgByResumableDownloader(final MiniAppInfo miniAppInfo, boolean z16, final OnGetApkgInfoListener onGetApkgInfoListener, final String str, final String str2, final String str3, final String str4) {
        final String str5 = RootPath.getAppPkgRoot() + miniAppInfo.appId + util.base64_pad_url + miniAppInfo.version + ".qapkg";
        final long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str2)) {
            if (onGetApkgInfoListener != null) {
                onGetApkgInfoListener.onGetApkgInfo(null, 1, "apkUrl is Null!");
                QMLog.e(TAG, "downloadApkgByResumableDownloader apkUrl is null!");
                return;
            }
            return;
        }
        long j3 = miniAppInfo.fileSize;
        MiniReportManager.reportEventType(miniAppInfo, 619, "0");
        ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).miniAppDownload(miniAppInfo.isContainerInfo(), str2, null, str5, 60, j3, new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.sdk.manager.ApkgManager.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadFailed(int i3, String str6) {
                OnGetApkgInfoListener onGetApkgInfoListener2 = onGetApkgInfoListener;
                if (onGetApkgInfoListener2 != null) {
                    onGetApkgInfoListener2.onGetApkgInfo(null, 1, "\u4e0b\u8f7d\u5931\u8d25");
                    QMLog.d(ApkgManager.TAG, "onDownloadFailed() called with: statusCode = [" + i3 + "], errorMsg = [" + str6 + "]");
                    MiniReportManager.reportEventType(miniAppInfo, 620, null, str6, null, i3);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadSucceed(int i3, String str6, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
                long j16;
                QMLog.d(ApkgManager.TAG, "onDownloadSucceed " + str2);
                if (downloadResult != null) {
                    j16 = downloadResult.contentLength;
                } else {
                    j16 = -1;
                }
                MiniReportManager.reportEventType(miniAppInfo, 620, "", String.valueOf(j16), "", 0, str2, "", "", "");
                FileUtils.deleteDirectory(str);
                ApkgManager.this.handleApkgDownloadSuccess(str5, str, miniAppInfo, str3, str4, onGetApkgInfoListener);
                ApkgManager.downloadDuration = System.currentTimeMillis() - currentTimeMillis;
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadHeadersReceived(int i3, Map<String, List<String>> map) {
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadProgress(float f16, long j16, long j17) {
            }
        });
        if (z16) {
            deleteOldPkg(miniAppInfo, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements DownloaderProxy.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnInitApkgListener f348096a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ApkgInfo f348097b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f348098c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f348099d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f348100e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f348101f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ MiniAppInfo f348102g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f348103h;

        b(OnInitApkgListener onInitApkgListener, ApkgInfo apkgInfo, String str, String str2, String str3, long j3, MiniAppInfo miniAppInfo, String str4) {
            this.f348096a = onInitApkgListener;
            this.f348097b = apkgInfo;
            this.f348098c = str;
            this.f348099d = str2;
            this.f348100e = str3;
            this.f348101f = j3;
            this.f348102g = miniAppInfo;
            this.f348103h = str4;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadFailed(int i3, String str) {
            OnInitApkgListener onInitApkgListener = this.f348096a;
            if (onInitApkgListener != null) {
                onInitApkgListener.onInitApkgInfo(2, this.f348097b, "\u4e0b\u8f7d\u5931\u8d25");
                QMLog.d(ApkgManager.TAG, "onDownloadFailed() called with: statusCode = [" + i3 + "], errorMsg = [" + str + "] subRoot:" + this.f348098c);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadSucceed(int i3, String str, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
            boolean z16;
            QMLog.i(ApkgManager.TAG, "onDownloadSucceed subRoot=" + this.f348098c + " url=" + this.f348099d + " path=" + this.f348100e + ", target size is " + this.f348101f);
            MiniReportManager.reportEventType(this.f348102g, 614, this.f348103h, null, null, 0, "0", 0L, null);
            String apkgFolderPath = ApkgManager.getApkgFolderPath(this.f348102g);
            File file = new File(this.f348100e);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(apkgFolderPath);
            sb5.append(File.separator);
            sb5.append(this.f348098c);
            FileUtils.delete(sb5.toString(), false);
            boolean z17 = this.f348102g.launchParam.isFlutterMode;
            long length = file.length();
            if (length != this.f348101f) {
                QMLog.w(ApkgManager.TAG, "onDownloadSucceed file size != target, is " + length);
            }
            if (z17) {
                MiniReportManager.reportEventType(this.f348102g, 615, this.f348103h, null, null, 0, "0", 0L, null);
                z16 = WxapkgUnpacker.unpackSync(file.getAbsolutePath(), apkgFolderPath, this.f348098c);
                QMLog.d(ApkgManager.TAG, "downloadSubPack | getResPath :hasUnpack=" + z16 + "; folderPath=" + apkgFolderPath + "; subRoot=" + this.f348098c);
                MiniReportManager.reportEventType(this.f348102g, 1045, null, null, null, 0);
            } else {
                z16 = false;
            }
            if (!z16 && z17) {
                OnInitApkgListener onInitApkgListener = this.f348096a;
                if (onInitApkgListener != null) {
                    onInitApkgListener.onInitApkgInfo(3, this.f348097b, "\u89e3\u5305\u5931\u8d25");
                    return;
                }
                return;
            }
            OnInitApkgListener onInitApkgListener2 = this.f348096a;
            if (onInitApkgListener2 != null) {
                onInitApkgListener2.onInitApkgInfo(0, this.f348097b, null);
            }
            PreLoadApkgToStrHelper.getInstance().preloadSubApkgInfoToMap(this.f348102g);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadHeadersReceived(int i3, Map<String, List<String>> map) {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadProgress(float f16, long j3, long j16) {
        }
    }
}
