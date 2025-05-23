package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.mini.utils.WxapkgUnpacker;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import oicq.wlogin_sdk.tools.util;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ApkgManager {
    public static final String MINI_APP_MAIN_PKG = "/__APP__/";
    public static final String MINI_GAME_PERSISTENT_SP_KEY = "persistent";
    public static final String MINI_GAME_PERSISTENT_SP_NAME = "persistent_debug_version_";
    public static final String SUFFIX_WXAPKG = ".qapkg";
    private static final String TAG = "ApkgManager";
    public static volatile long downloadDuration;
    private static volatile ApkgManager sInstance;
    private String subRoot = "";
    public static final String PATH_GAMEPKG_ROOT = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/minigame/";
    public static final String PATH_WXAPKG_ROOT = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini/";
    public static final String PATH_APKG_TISSUE_ROOT = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini_tissue/";

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface OnFakeApkgListener {
        void onFakeApkgInfo(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface OnGetApkgInfoListener {
        void onFakeApkgInfo(String str, String str2);

        void onGetApkgInfo(ApkgInfo apkgInfo, int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface OnInitApkgListener {
        public static final int RES_DOWNLOAD_CANCEL = 4;
        public static final int RES_DOWNLOAD_FAIL = 2;
        public static final int RES_FAIL = 1;
        public static final int RES_SUCC = 0;
        public static final int RES_UNPACK_FAIL = 3;

        void onInitApkgInfo(int i3, ApkgInfo apkgInfo, String str);
    }

    private void deleteOldPkg(final MiniAppConfig miniAppConfig, final String str) {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.mini.apkg.ApkgManager.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MiniAppConfig miniAppConfig2 = miniAppConfig;
                    if (miniAppConfig2 == null || miniAppConfig2.config == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    String pkgRoot = ApkgManager.getPkgRoot(miniAppConfig.config);
                    String md5 = MD5.toMD5(miniAppConfig.config.appId);
                    File file = new File(pkgRoot);
                    if (file.isDirectory()) {
                        for (String str2 : file.list()) {
                            if (!TextUtils.isEmpty(str2) && str2.startsWith(md5) && !str.contains(str2)) {
                                QLog.d(ApkgManager.TAG, 1, "delete pkg : " + str2);
                                FileUtils.delete(pkgRoot + str2, false);
                            }
                        }
                    }
                } catch (Throwable th5) {
                    QLog.e(ApkgManager.TAG, 1, "deleteOldPkg error,", th5);
                }
            }
        });
    }

    private void downloadApkgByResumableDownloader(MiniAppConfig miniAppConfig, boolean z16, OnGetApkgInfoListener onGetApkgInfoListener, String str) {
        String str2;
        String str3;
        String str4;
        MiniAppInfo miniAppInfo = miniAppConfig.config;
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
                if (next != null && (str4 = next.subPkgName) != null && str6.equals(str4)) {
                    if (next.independent == 1) {
                        str5 = next.downloadUrl;
                        str3 = str6;
                        break;
                    }
                    str7 = miniAppConfig.config.firstPage.pagePath;
                }
            }
            str2 = str7;
        } else {
            str2 = null;
            str3 = null;
        }
        if (str5 == null) {
            str5 = miniAppConfig.config.downloadUrl;
        }
        downloadApkgByResumableDownloader(miniAppConfig, z16, onGetApkgInfoListener, str, str5, str2, str3);
    }

    public static String getGpkgPluginFolderPath(MiniGamePluginInfo miniGamePluginInfo) {
        return PATH_GAMEPKG_ROOT + MD5.toMD5(miniGamePluginInfo.f246320id) + "_plugin_" + miniGamePluginInfo.version;
    }

    public static JSONObject getHeader(String str, MiniAppConfig miniAppConfig) {
        if (miniAppConfig.config.verType == 3 || TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getHeader error. " + e16);
        }
        if (!new URL(str).getHost().contains(QQWinkConstants.VALID_HOST)) {
            return null;
        }
        jSONObject.put("cookie", "uin=o" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + ";");
        return jSONObject;
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
            return PATH_GAMEPKG_ROOT;
        }
        return PATH_WXAPKG_ROOT;
    }

    private String getSubPkgDownloadUrl(ApkgInfo apkgInfo, String str) {
        List<SubPkgInfo> list = apkgInfo.appConfig.config.subpkgs;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        for (SubPkgInfo subPkgInfo : list) {
            if (str.equals(subPkgInfo.subPkgName)) {
                return subPkgInfo.downloadUrl;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInitApkgInfo(OnInitApkgListener onInitApkgListener, int i3, ApkgInfo apkgInfo, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onInitApkgInfo :" + i3 + "|" + str);
        }
        if (onInitApkgListener != null) {
            onInitApkgListener.onInitApkgInfo(i3, apkgInfo, str);
        }
    }

    public static boolean pkgExists(MiniAppInfo miniAppInfo) {
        return new File(getApkgFolderPath(miniAppInfo)).exists();
    }

    public void getApkgInfoByConfig(MiniAppConfig miniAppConfig, OnInitApkgListener onInitApkgListener) {
        getApkgInfoByConfig(miniAppConfig, true, onInitApkgListener, null);
    }

    public void initApkgByConfig(MiniAppConfig miniAppConfig, OnInitApkgListener onInitApkgListener) {
        getApkgInfoByConfig(miniAppConfig, onInitApkgListener);
    }

    public void getApkgInfoByConfig(MiniAppConfig miniAppConfig, OnInitApkgListener onInitApkgListener, OnFakeApkgListener onFakeApkgListener) {
        getApkgInfoByConfig(miniAppConfig, true, onInitApkgListener, onFakeApkgListener);
    }

    public static String getApkgFolderPath(MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
            if (miniAppInfo.isEngineTypeMiniGame() && GameWnsUtils.enablePersistentDebugVersion()) {
                if (BaseApplicationImpl.getApplication().getSharedPreferences("persistent_debug_version_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("persistent", false)) {
                    String str = getPkgRoot(miniAppInfo) + miniAppInfo.appId + "_debug";
                    if (new File(str).exists()) {
                        return str;
                    }
                }
            }
            if (miniAppInfo.verType == 3) {
                return getPkgRoot(miniAppInfo) + MD5.toMD5(miniAppInfo.appId) + "_" + miniAppInfo.versionId;
            }
            return getPkgRoot(miniAppInfo) + miniAppInfo.appId + "_debug";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleApkgDownloadSuccess(String str, String str2, MiniAppConfig miniAppConfig, String str3, String str4, final OnGetApkgInfoListener onGetApkgInfoListener) {
        MiniReportManager.reportEventType(miniAppConfig, 621, "0");
        boolean unpackSync = WxapkgUnpacker.unpackSync(new File(str).getAbsolutePath(), str2);
        MiniReportManager.reportEventType(miniAppConfig, 622, null, null, null, !unpackSync ? 1 : 0);
        if (!unpackSync) {
            if (onGetApkgInfoListener != null) {
                onGetApkgInfoListener.onGetApkgInfo(null, 3, HardCodeUtil.qqStr(R.string.jes));
                return;
            }
            return;
        }
        ApkgInfo loadApkgInfoFromFolderPath = ApkgInfo.loadApkgInfoFromFolderPath(str2, str4, miniAppConfig);
        if (str3 != null && loadApkgInfoFromFolderPath != null) {
            downloadSubPack(loadApkgInfoFromFolderPath, str3, new OnInitApkgListener() { // from class: com.tencent.mobileqq.mini.apkg.ApkgManager.2
                @Override // com.tencent.mobileqq.mini.apkg.ApkgManager.OnInitApkgListener
                public void onInitApkgInfo(int i3, ApkgInfo apkgInfo, String str5) {
                    if (i3 == 0) {
                        OnGetApkgInfoListener onGetApkgInfoListener2 = onGetApkgInfoListener;
                        if (onGetApkgInfoListener2 != null) {
                            onGetApkgInfoListener2.onGetApkgInfo(apkgInfo, i3, str5);
                            return;
                        }
                        return;
                    }
                    OnGetApkgInfoListener onGetApkgInfoListener3 = onGetApkgInfoListener;
                    if (onGetApkgInfoListener3 != null) {
                        onGetApkgInfoListener3.onGetApkgInfo(null, i3, str5);
                    }
                }
            });
        } else if (onGetApkgInfoListener != null) {
            onGetApkgInfoListener.onGetApkgInfo(loadApkgInfoFromFolderPath, 0, "");
        }
    }

    public void getApkgInfoByConfig(final MiniAppConfig miniAppConfig, boolean z16, final OnInitApkgListener onInitApkgListener, final OnFakeApkgListener onFakeApkgListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        MiniReportManager.reportEventType(miniAppConfig, 12, null, null, null, 0);
        if (onFakeApkgListener != null) {
            MiniReportManager.reportEventType(miniAppConfig, 124, null, null, null, 0);
        }
        getApkgInfoByConfig(miniAppConfig, z16, new OnGetApkgInfoListener() { // from class: com.tencent.mobileqq.mini.apkg.ApkgManager.1
            @Override // com.tencent.mobileqq.mini.apkg.ApkgManager.OnGetApkgInfoListener
            public void onFakeApkgInfo(String str, String str2) {
                if (onFakeApkgListener != null) {
                    MiniReportManager.reportEventType(miniAppConfig, 125, null, null, null, 0);
                    onFakeApkgListener.onFakeApkgInfo(str, str2);
                }
            }

            @Override // com.tencent.mobileqq.mini.apkg.ApkgManager.OnGetApkgInfoListener
            public void onGetApkgInfo(ApkgInfo apkgInfo, int i3, String str) {
                if (i3 != 0 || apkgInfo == null) {
                    ApkgManager.this.onInitApkgInfo(onInitApkgListener, i3, null, str);
                } else {
                    ApkgManager.this.onInitApkgInfo(onInitApkgListener, 0, apkgInfo, "Apkg init succ :" + (System.currentTimeMillis() - currentTimeMillis));
                }
                MiniReportManager.reportEventType(miniAppConfig, 13, null, null, null, 0);
            }
        });
    }

    private void getApkgInfoByConfig(MiniAppConfig miniAppConfig, boolean z16, OnGetApkgInfoListener onGetApkgInfoListener) {
        MiniAppInfo miniAppInfo;
        if (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null) {
            return;
        }
        String str = miniAppInfo.version;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getApkgInfoByConfig version:" + str);
        }
        String apkgFolderPath = getApkgFolderPath(miniAppConfig.config);
        if (miniAppConfig.config.verType != 3) {
            QLog.d(TAG, 1, "verType is not online, delete unPackFolderPath." + miniAppConfig.config.verType);
            if (new File(apkgFolderPath).exists()) {
                FileUtils.delete(apkgFolderPath, false);
            }
        }
        if (new File(apkgFolderPath).exists()) {
            ApkgInfo apkgInfo = null;
            try {
                apkgInfo = ApkgInfo.loadApkgInfoFromFolderPath(apkgFolderPath, null, miniAppConfig);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "loadApkgInfoFromFolderPath exception!", th5);
            }
            if (apkgInfo != null) {
                if (onGetApkgInfoListener != null) {
                    onGetApkgInfoListener.onGetApkgInfo(apkgInfo, 0, "");
                }
                LaunchParam launchParam = miniAppConfig.launchParam;
                MiniAppReportManager2.reportPageView("cache_apkg_hit", "hit", launchParam != null ? launchParam.entryPath : "", miniAppConfig);
                MiniAppStartState.setApkgDownload(miniAppConfig.config.appId, true);
                return;
            }
            FileUtils.delete(apkgFolderPath, false);
        }
        downloadApkgByResumableDownloader(miniAppConfig, z16, onGetApkgInfoListener, apkgFolderPath);
        LaunchParam launchParam2 = miniAppConfig.launchParam;
        MiniAppReportManager2.reportPageView("cache_apkg_hit", "unhit", launchParam2 != null ? launchParam2.entryPath : "", miniAppConfig);
        MiniAppStartState.setApkgDownload(miniAppConfig.config.appId, false);
    }

    public void downloadSubPack(final ApkgInfo apkgInfo, final String str, final OnInitApkgListener onInitApkgListener) {
        String subPkgDownloadUrl;
        String apkgFolderPath = getApkgFolderPath(apkgInfo.appConfig.config);
        if ("/__APP__/".equals(str)) {
            this.subRoot = "";
            subPkgDownloadUrl = apkgInfo.appConfig.config.downloadUrl;
        } else {
            String rootPath = apkgInfo.getRootPath(str);
            this.subRoot = rootPath;
            subPkgDownloadUrl = getSubPkgDownloadUrl(apkgInfo, rootPath);
        }
        String str2 = subPkgDownloadUrl;
        QLog.d(TAG, 1, "downloadSubPack | downPage=" + str + "; subPackDownloadUrl=" + str2);
        if (TextUtils.isEmpty(str2)) {
            QLog.e(TAG, 1, "subPackDownloadUrl is null, return.");
            if (onInitApkgListener != null) {
                onInitApkgListener.onInitApkgInfo(1, apkgInfo, null);
                return;
            }
            return;
        }
        if (!"/__APP__/".equals(str) && new File(apkgFolderPath, this.subRoot).exists()) {
            if (onInitApkgListener != null) {
                onInitApkgListener.onInitApkgInfo(0, apkgInfo, null);
            }
        } else {
            if (!TextUtils.isEmpty(str2)) {
                final String str3 = PATH_WXAPKG_ROOT + apkgInfo.appConfig.config.appId + util.base64_pad_url + apkgInfo.appConfig.config.version + ".qapkg";
                MiniReportManager.reportEventType(apkgInfo.appConfig, 613, str, null, null, 0, "0", 0L, null);
                MiniappDownloadUtil.getInstance().downloadApkg(apkgInfo.appConfig, true, str2, str3, true, new Downloader.DownloadListener() { // from class: com.tencent.mobileqq.mini.apkg.ApkgManager.4
                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadCanceled(String str4) {
                        OnInitApkgListener onInitApkgListener2 = onInitApkgListener;
                        if (onInitApkgListener2 != null) {
                            onInitApkgListener2.onInitApkgInfo(1, apkgInfo, null);
                            QLog.d(ApkgManager.TAG, 1, "onDownloadCanceled() called with: s = [" + str4 + "]");
                        }
                    }

                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadFailed(String str4, DownloadResult downloadResult) {
                        int i3;
                        OnInitApkgListener onInitApkgListener2 = onInitApkgListener;
                        if (onInitApkgListener2 != null) {
                            onInitApkgListener2.onInitApkgInfo(2, apkgInfo, HardCodeUtil.qqStr(R.string.jeu));
                            QLog.d(ApkgManager.TAG, 1, "onDownloadFailed() called with: s = [" + str4 + "], downloadResult = [" + downloadResult + "]");
                        }
                        if (downloadResult.getStatus().exception2Code != 0) {
                            i3 = downloadResult.getStatus().exception2Code;
                        } else {
                            i3 = downloadResult.getStatus().httpStatus > 0 ? downloadResult.getStatus().httpStatus : -99999;
                        }
                        MiniReportManager.reportEventType(apkgInfo.appConfig, 614, str, null, null, i3, "0", downloadResult.getProcess().duration, null);
                    }

                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadSucceed(String str4, DownloadResult downloadResult) {
                        long j3;
                        long j16;
                        if (downloadResult == null || downloadResult.getContent() == null) {
                            j3 = -1;
                            j16 = 0;
                        } else {
                            j3 = downloadResult.getContent().length;
                            j16 = downloadResult.getProcess().duration;
                        }
                        MiniReportManager.reportEventType(apkgInfo.appConfig, 614, str, String.valueOf(j3), null, 0, "0", j16, null);
                        MiniReportManager.reportEventType(apkgInfo.appConfig, 615, str, null, null, 0, "0", 0L, null);
                        String apkgFolderPath2 = ApkgManager.getApkgFolderPath(apkgInfo.appConfig.config);
                        boolean unpackSync = WxapkgUnpacker.unpackSync(new File(str3).getAbsolutePath(), apkgFolderPath2, ApkgManager.this.subRoot);
                        QLog.d(ApkgManager.TAG, 1, "downloadSubPack | getResPath :hasUnpack=" + unpackSync + "; folderPath=" + apkgFolderPath2 + "; subRoot=" + ApkgManager.this.subRoot);
                        MiniReportManager.reportEventType(apkgInfo.appConfig, 616, str, null, null, 0, "0", 0L, null);
                        if (unpackSync) {
                            OnInitApkgListener onInitApkgListener2 = onInitApkgListener;
                            if (onInitApkgListener2 != null) {
                                onInitApkgListener2.onInitApkgInfo(0, apkgInfo, null);
                                return;
                            }
                            return;
                        }
                        OnInitApkgListener onInitApkgListener3 = onInitApkgListener;
                        if (onInitApkgListener3 != null) {
                            onInitApkgListener3.onInitApkgInfo(3, apkgInfo, HardCodeUtil.qqStr(R.string.jev));
                        }
                    }

                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadProgress(String str4, long j3, float f16) {
                    }
                }, Downloader.DownloadMode.StrictMode, getHeader(str2, apkgInfo.appConfig));
                return;
            }
            onInitApkgListener.onInitApkgInfo(1, apkgInfo, null);
        }
    }

    private void downloadApkgByResumableDownloader(final MiniAppConfig miniAppConfig, boolean z16, final OnGetApkgInfoListener onGetApkgInfoListener, final String str, String str2, final String str3, final String str4) {
        final String str5 = PATH_WXAPKG_ROOT + miniAppConfig.config.appId + util.base64_pad_url + miniAppConfig.config.version + ".qapkg";
        final long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str2)) {
            if (onGetApkgInfoListener != null) {
                onGetApkgInfoListener.onGetApkgInfo(null, 1, "apkUrl is Null!");
                QLog.e(TAG, 1, "downloadApkgByResumableDownloader apkUrl is null!");
                return;
            }
            return;
        }
        MiniReportManager.reportEventType(miniAppConfig, 619, "0");
        MiniappDownloadUtil.getInstance().downloadApkg(miniAppConfig, false, str2, str5, true, new Downloader.DownloadListener() { // from class: com.tencent.mobileqq.mini.apkg.ApkgManager.5
            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadCanceled(String str6) {
                OnGetApkgInfoListener onGetApkgInfoListener2 = onGetApkgInfoListener;
                if (onGetApkgInfoListener2 != null) {
                    onGetApkgInfoListener2.onGetApkgInfo(null, 4, HardCodeUtil.qqStr(R.string.jew));
                    QLog.d(ApkgManager.TAG, 2, "onDownloadCanceled() called with: s = [" + str6 + "]");
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadFailed(String str6, DownloadResult downloadResult) {
                int i3;
                HeaderIterator headerIterator;
                Header nextHeader;
                if (downloadResult != null && downloadResult.getStatus() != null) {
                    if (downloadResult.getStatus().exception2Code != 0) {
                        i3 = downloadResult.getStatus().exception2Code;
                    } else {
                        i3 = downloadResult.getStatus().httpStatus > 0 ? downloadResult.getStatus().httpStatus : -99999;
                    }
                    MiniReportManager.reportEventType(miniAppConfig, 620, null, null, null, i3);
                    if (miniAppConfig.config.verType != 3 && downloadResult.getStatus().httpStatus >= 400 && downloadResult.getReport() != null && downloadResult.getReport().response != null && (headerIterator = downloadResult.getReport().response.headerIterator("x-Miniprogram-Download-Error")) != null && (nextHeader = headerIterator.nextHeader()) != null) {
                        try {
                            String decode = URLDecoder.decode(nextHeader.getValue(), "UTF-8");
                            String substring = decode.substring(decode.indexOf("message=") + 8, decode.length());
                            OnGetApkgInfoListener onGetApkgInfoListener2 = onGetApkgInfoListener;
                            if (onGetApkgInfoListener2 != null) {
                                onGetApkgInfoListener2.onGetApkgInfo(null, 1, substring);
                                QLog.d(ApkgManager.TAG, 1, "onDownloadFailed() called with: s = [" + str6 + "], httpStatus = [" + downloadResult.getStatus().httpStatus + "]; header : " + nextHeader.getName() + "; " + decode);
                                return;
                            }
                            return;
                        } catch (UnsupportedEncodingException e16) {
                            QLog.e(ApkgManager.TAG, 1, "decode message error. " + e16);
                            return;
                        }
                    }
                }
                OnGetApkgInfoListener onGetApkgInfoListener3 = onGetApkgInfoListener;
                if (onGetApkgInfoListener3 != null) {
                    onGetApkgInfoListener3.onGetApkgInfo(null, 1, HardCodeUtil.qqStr(R.string.jex));
                    QLog.d(ApkgManager.TAG, 1, "onDownloadFailed() called with: s = [" + str6 + "], downloadResult = [" + downloadResult + "]");
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadSucceed(String str6, DownloadResult downloadResult) {
                MiniReportManager.reportEventType(miniAppConfig, 620, String.valueOf((downloadResult == null || downloadResult.getContent() == null) ? -1L : downloadResult.getContent().length), "0");
                ApkgManager.this.handleApkgDownloadSuccess(str5, str, miniAppConfig, str3, str4, onGetApkgInfoListener);
                ApkgManager.downloadDuration = System.currentTimeMillis() - currentTimeMillis;
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadProgress(String str6, long j3, float f16) {
            }
        }, Downloader.DownloadMode.StrictMode, -1, 0L, getHeader(str2, miniAppConfig), new DownloadRequest.OnResponseDataListener() { // from class: com.tencent.mobileqq.mini.apkg.ApkgManager.6
            byte[] totalContent = null;
            int index = 0;
            int fileCount = 0;
            int indexAreaLength = 0;
            Map<String, ApkgUnpackFileInfo> mapFileInfo = new HashMap();
            boolean completed = false;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.mini.apkg.ApkgManager$6$ApkgUnpackFileInfo */
            /* loaded from: classes33.dex */
            public class ApkgUnpackFileInfo {
                public String fileContent;
                public String filename;
                public int length;
                public int offset;

                ApkgUnpackFileInfo() {
                }

                public boolean isCompleted() {
                    return !TextUtils.isEmpty(this.fileContent);
                }
            }

            private boolean enablePipeline() {
                return QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_DOWNLOAD_PIPELINE_ENABLE, 0) > 0;
            }

            @Override // com.tencent.component.network.downloader.DownloadRequest.OnResponseDataListener
            public void onRecvData(byte[] bArr, int i3, int i16, long j3, int i17, boolean z17) {
                if (enablePipeline() && !this.completed && i17 == 0 && j3 > 0) {
                    if (this.totalContent == null) {
                        this.totalContent = new byte[((int) j3) * 2];
                    }
                    try {
                        ApkgUnpackFileInfo apkgUnpackFileInfo = this.mapFileInfo.get("/app-config.json");
                        ApkgUnpackFileInfo apkgUnpackFileInfo2 = this.mapFileInfo.get("/app-service.js");
                        if (apkgUnpackFileInfo != null && apkgUnpackFileInfo.isCompleted() && apkgUnpackFileInfo2 != null && apkgUnpackFileInfo2.isCompleted()) {
                            this.completed = true;
                            OnGetApkgInfoListener onGetApkgInfoListener2 = onGetApkgInfoListener;
                            if (onGetApkgInfoListener2 != null) {
                                onGetApkgInfoListener2.onFakeApkgInfo(apkgUnpackFileInfo.fileContent, apkgUnpackFileInfo2.fileContent);
                                return;
                            }
                            return;
                        }
                        System.arraycopy(bArr, i3, this.totalContent, this.index, i16);
                        this.index += i16;
                        unpackFileContent("/app-config.json");
                        unpackFileContent("/app-service.js");
                    } catch (Exception e16) {
                        this.completed = true;
                        QLog.e(ApkgManager.TAG, 1, "to download OnResponseDataListener error.", e16);
                    }
                }
            }

            public final int readInt(byte[] bArr, int i3) throws IOException {
                int i16 = bArr[i3] & 255;
                int i17 = bArr[i3 + 1] & 255;
                int i18 = bArr[i3 + 2] & 255;
                int i19 = bArr[i3 + 3] & 255;
                if ((i16 | i17 | i18 | i19) >= 0) {
                    return (i16 << 24) + (i17 << 16) + (i18 << 8) + (i19 << 0);
                }
                throw new EOFException();
            }

            boolean unpackFileContent(String str6) throws Exception {
                int i3;
                if (TextUtils.isEmpty(str6) || (i3 = this.index) < 17) {
                    return false;
                }
                int i16 = 18;
                if (i3 >= 18 && this.fileCount <= 0) {
                    this.indexAreaLength = readInt(this.totalContent, 5);
                    this.fileCount = readInt(this.totalContent, 14);
                }
                if (this.index < (this.indexAreaLength + 18) - 1) {
                    return false;
                }
                if (!this.mapFileInfo.containsKey(str6)) {
                    int i17 = 0;
                    while (true) {
                        if (i17 >= this.fileCount) {
                            break;
                        }
                        int readInt = readInt(this.totalContent, i16);
                        int i18 = i16 + 4;
                        String str7 = new String(this.totalContent, i18, readInt);
                        int i19 = i18 + readInt;
                        int readInt2 = readInt(this.totalContent, i19);
                        int i26 = i19 + 4;
                        int readInt3 = readInt(this.totalContent, i26);
                        i16 = i26 + 4;
                        if (str7.equals(str6)) {
                            QLog.e(ApkgManager.TAG, 1, "to download file=" + str7 + " offset=" + readInt2 + " size=" + readInt3 + " currRecvLength=" + this.index);
                            ApkgUnpackFileInfo apkgUnpackFileInfo = new ApkgUnpackFileInfo();
                            apkgUnpackFileInfo.filename = str6;
                            apkgUnpackFileInfo.offset = readInt2;
                            apkgUnpackFileInfo.length = readInt3;
                            this.mapFileInfo.put(str6, apkgUnpackFileInfo);
                            break;
                        }
                        i17++;
                    }
                }
                ApkgUnpackFileInfo apkgUnpackFileInfo2 = this.mapFileInfo.get(str6);
                if (apkgUnpackFileInfo2 != null) {
                    if (!TextUtils.isEmpty(apkgUnpackFileInfo2.fileContent)) {
                        return true;
                    }
                    int i27 = this.index;
                    int i28 = apkgUnpackFileInfo2.offset;
                    int i29 = apkgUnpackFileInfo2.length;
                    if (i27 >= i28 + i29) {
                        apkgUnpackFileInfo2.fileContent = new String(this.totalContent, i28, i29);
                        QLog.e(ApkgManager.TAG, 1, "to download and unpack sub file is done! " + str6 + ProgressTracer.SEPARATOR + apkgUnpackFileInfo2.fileContent.substring(0, 100));
                        return true;
                    }
                }
                return false;
            }
        });
        if (z16) {
            deleteOldPkg(miniAppConfig, str);
        }
    }
}
