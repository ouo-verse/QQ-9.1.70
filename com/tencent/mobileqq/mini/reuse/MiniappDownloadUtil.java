package com.tencent.mobileqq.mini.reuse;

import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.base.inter.Log;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05325;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniappDownloadUtil {
    private static final String TAG = "[mini] MiniappDownloadUtil";
    public static float gDownloadProgressStep = 0.2f;
    private static volatile MiniappDownloadUtil instance;
    private static List<Integer> sRangeModeNetworkLevel;
    private static List<Integer> sRangeModePerfLevel;
    private Downloader resumableDownloader;

    public MiniappDownloadUtil() {
        if (this.resumableDownloader == null) {
            if (QDLog.getLog() == null) {
                QDLog.setLog(new Log() { // from class: com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil.1
                    @Override // com.tencent.component.network.module.base.inter.Log
                    public void d(String str, String str2) {
                        QLog.d(str, 1, str2);
                    }

                    @Override // com.tencent.component.network.module.base.inter.Log
                    public void e(String str, String str2) {
                        QLog.e(str, 1, str2);
                    }

                    @Override // com.tencent.component.network.module.base.inter.Log
                    public int getLogLevel() {
                        if (QLog.isDevelopLevel()) {
                            return 2;
                        }
                        return QLog.isColorLevel() ? 3 : 4;
                    }

                    @Override // com.tencent.component.network.module.base.inter.Log
                    public void i(String str, String str2) {
                        QLog.i(str, 1, str2);
                    }

                    @Override // com.tencent.component.network.module.base.inter.Log
                    public void w(String str, String str2) {
                        QLog.w(str, 1, str2);
                    }

                    @Override // com.tencent.component.network.module.base.inter.Log
                    public void d(String str, String str2, Throwable th5) {
                        QLog.d(str, 1, str2, th5);
                    }

                    @Override // com.tencent.component.network.module.base.inter.Log
                    public void e(String str, String str2, Throwable th5) {
                        QLog.e(str, 1, str2, th5);
                    }

                    @Override // com.tencent.component.network.module.base.inter.Log
                    public void i(String str, String str2, Throwable th5) {
                        QLog.i(str, 1, str2, th5);
                    }

                    @Override // com.tencent.component.network.module.base.inter.Log
                    public void w(String str, String str2, Throwable th5) {
                        QLog.w(str, 1, str2, th5);
                    }
                });
            }
            if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_use_download_optimize", 1) == 1) {
                Config.setConfig(new MiniDownloadConfig());
                DownloaderFactory.getInstance(BaseApplication.getContext());
                this.resumableDownloader = DownloaderFactory.createDownloader("mini_app_downloader");
            } else {
                this.resumableDownloader = DownloaderFactory.getInstance(BaseApplication.getContext()).getCommonDownloader();
            }
            this.resumableDownloader.enableResumeTransfer(true);
            this.resumableDownloader.setHttpsIpDirectEnable(QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_HTTPS_IPDIRECT_ENABLE, 1) == 1);
            try {
                this.resumableDownloader.setDirectIPConfigStrategy(new QzoneIPStracyConfig());
                this.resumableDownloader.setBackupIPConfigStrategy(new QzoneBackupConfig());
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "", th5);
            }
        }
    }

    public static MiniappDownloadUtil getInstance() {
        if (instance == null) {
            synchronized (MiniappDownloadUtil.class) {
                if (instance == null) {
                    instance = new MiniappDownloadUtil();
                }
            }
        }
        return instance;
    }

    private synchronized List<Integer> getRangeModeNetworkLevel() {
        String[] split;
        if (sRangeModeNetworkLevel == null) {
            ArrayList arrayList = new ArrayList();
            String rangeModeNetworkLevel = GameWnsUtils.getRangeModeNetworkLevel();
            QLog.i(TAG, 1, "getRangeModeNetworkLevel wns config: " + rangeModeNetworkLevel);
            if (!TextUtils.isEmpty(rangeModeNetworkLevel) && (split = rangeModeNetworkLevel.split(",")) != null && split.length > 0) {
                for (String str : split) {
                    try {
                        arrayList.add(Integer.valueOf(str));
                    } catch (NumberFormatException e16) {
                        QLog.e(TAG, 1, "getRangeModeNetworkLevel exception:", e16);
                    }
                }
            }
            sRangeModeNetworkLevel = arrayList;
        }
        return sRangeModeNetworkLevel;
    }

    private synchronized List<Integer> getRangeModePerfLevel() {
        String[] split;
        if (sRangeModePerfLevel == null) {
            ArrayList arrayList = new ArrayList();
            String rangeModePerfLevel = GameWnsUtils.getRangeModePerfLevel();
            QLog.i(TAG, 1, "getRangeModePerfLevel wns config: " + rangeModePerfLevel);
            if (!TextUtils.isEmpty(rangeModePerfLevel) && (split = rangeModePerfLevel.split(",")) != null && split.length > 0) {
                for (String str : split) {
                    try {
                        arrayList.add(Integer.valueOf(str));
                    } catch (NumberFormatException e16) {
                        QLog.e(TAG, 1, "getRangeModePerfLevel exception:", e16);
                    }
                }
            }
            sRangeModePerfLevel = arrayList;
        }
        return sRangeModePerfLevel;
    }

    private boolean isUrlSupportRange(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) > 0) {
            str = str.substring(0, str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER));
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().endsWith(".zip");
    }

    public static void preLoadDownloader() {
        getInstance();
    }

    private boolean rangeDownloadEnvEnable() {
        List<Integer> rangeModePerfLevel = getRangeModePerfLevel();
        if (rangeModePerfLevel != null && !rangeModePerfLevel.contains(Integer.valueOf(DeviceInfoUtils.getPerfLevel()))) {
            return false;
        }
        List<Integer> rangeModeNetworkLevel = getRangeModeNetworkLevel();
        return rangeModeNetworkLevel == null || rangeModeNetworkLevel.contains(Integer.valueOf(NetworkState.g().getNetworkType()));
    }

    public void abort(String str) {
        this.resumableDownloader.abort(str, null);
    }

    public boolean download(String str, String str2, boolean z16, Downloader.DownloadListener downloadListener, Downloader.DownloadMode downloadMode, JSONObject jSONObject) {
        return download(str, str2, z16, downloadListener, downloadMode, -1, 0L, jSONObject, null);
    }

    public boolean downloadApkg(MiniAppConfig miniAppConfig, boolean z16, String str, String str2, boolean z17, Downloader.DownloadListener downloadListener, Downloader.DownloadMode downloadMode, JSONObject jSONObject) {
        return downloadApkg(miniAppConfig, z16, str, str2, z17, downloadListener, downloadMode, -1, 0L, jSONObject, null);
    }

    public Downloader.DownloadMode getDownloadMode(String str) {
        Downloader.DownloadMode downloadMode = getDownloadMode();
        return (downloadMode != Downloader.DownloadMode.RangeMode || (isUrlSupportRange(str) && rangeDownloadEnvEnable())) ? downloadMode : Downloader.DownloadMode.StrictMode;
    }

    public boolean needPreConnect() {
        Downloader.DownloadMode downloadMode = getDownloadMode();
        if (downloadMode == Downloader.DownloadMode.OkHttpMode) {
            return true;
        }
        if (downloadMode == Downloader.DownloadMode.RangeMode) {
            return rangeDownloadEnvEnable();
        }
        return false;
    }

    public void preConnectHost(ArrayList<String> arrayList, String str) {
        if (this.resumableDownloader != null) {
            QLog.d(TAG, 1, "preconnect method = " + str);
            this.resumableDownloader.preConnectHost(arrayList, str);
        }
    }

    public boolean download(final String str, String str2, boolean z16, final Downloader.DownloadListener downloadListener, Downloader.DownloadMode downloadMode, int i3, long j3, JSONObject jSONObject, DownloadRequest.OnResponseDataListener onResponseDataListener) {
        if (NetworkUtils.isNetworkUrl(str)) {
            DownloadRequest downloadRequest = new DownloadRequest(str, new String[]{str2}, false, downloadListener);
            downloadRequest.mode = downloadMode;
            downloadRequest.onResponseDataListener = onResponseDataListener;
            downloadRequest.rangeNumber = i3;
            downloadRequest.progressCallbackStep = gDownloadProgressStep;
            downloadRequest.addParam("Accept-Encoding", "gzip, deflate");
            downloadRequest.setFileSizeForRangeMode(j3);
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    downloadRequest.addParam(str3, jSONObject.optString(str3));
                }
            }
            com.tencent.qqperf.reporter.flow.a.a("MiniappDownloadUtil", str);
            return this.resumableDownloader.download(downloadRequest, z16);
        }
        QLog.w(TAG, 1, "download unsupported url:" + str + ", callback fail");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil.3
            @Override // java.lang.Runnable
            public void run() {
                if (downloadListener != null) {
                    String str4 = str;
                    if (TextUtils.isEmpty(str4)) {
                        str4 = "--null url--";
                    }
                    downloadListener.onDownloadFailed(str, new DownloadResult(str4));
                }
            }
        }, 16, null, false);
        return false;
    }

    public boolean downloadApkg(final MiniAppConfig miniAppConfig, final boolean z16, String str, String str2, boolean z17, final Downloader.DownloadListener downloadListener, Downloader.DownloadMode downloadMode, int i3, long j3, JSONObject jSONObject, DownloadRequest.OnResponseDataListener onResponseDataListener) {
        return download(str, str2, z17, new Downloader.DownloadListener() { // from class: com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil.2
            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadCanceled(String str3) {
                Downloader.DownloadListener downloadListener2 = downloadListener;
                if (downloadListener2 != null) {
                    downloadListener2.onDownloadCanceled(str3);
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadFailed(String str3, DownloadResult downloadResult) {
                Downloader.DownloadListener downloadListener2 = downloadListener;
                if (downloadListener2 != null) {
                    downloadListener2.onDownloadFailed(str3, downloadResult);
                }
                MiniProgramLpReportDC05325.reportApiReport(downloadResult, !z16 ? 1 : 2, miniAppConfig);
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadProgress(String str3, long j16, float f16) {
                Downloader.DownloadListener downloadListener2 = downloadListener;
                if (downloadListener2 != null) {
                    downloadListener2.onDownloadProgress(str3, j16, f16);
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadSucceed(String str3, DownloadResult downloadResult) {
                Downloader.DownloadListener downloadListener2 = downloadListener;
                if (downloadListener2 != null) {
                    downloadListener2.onDownloadSucceed(str3, downloadResult);
                }
                MiniProgramLpReportDC05325.reportApiReport(downloadResult, !z16 ? 1 : 2, miniAppConfig);
            }
        }, downloadMode, i3, j3, jSONObject, onResponseDataListener);
    }

    private Downloader.DownloadMode getDownloadMode() {
        int downloaderMode = GameWnsUtils.getDownloaderMode();
        Downloader.DownloadMode downloadMode = Downloader.DownloadMode.RangeMode;
        if (downloaderMode == downloadMode.ordinal()) {
            return downloadMode;
        }
        Downloader.DownloadMode downloadMode2 = Downloader.DownloadMode.OkHttpMode;
        return downloaderMode == downloadMode2.ordinal() ? downloadMode2 : Downloader.DownloadMode.StrictMode;
    }
}
