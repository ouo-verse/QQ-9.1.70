package com.qzone.misc.network.downloader;

import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.reborn.QZoneDownloadSharedPreferencesProvider;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FileDownloaderManager {
    private static FileDownloaderManager instance = null;
    private static Object lock = new Object();
    public static boolean needReportTraffic = true;
    Downloader mDownloader;

    FileDownloaderManager() {
        DownloaderFactory.getInstance(BaseApplication.getContext());
        DownloaderFactory.init(new f(), new c(), QZoneDownloadSharedPreferencesProvider.INSTANCE);
        Downloader createDownloader = DownloaderFactory.createDownloader("ZipFile");
        this.mDownloader = createDownloader;
        if (createDownloader == null) {
            return;
        }
        if (needReportTraffic) {
            createDownloader.setNetworkFlowStatistics(new g());
        }
        this.mDownloader.enableResumeTransfer();
        this.mDownloader.setPortConfigStrategy(new QzoneDownloadPortConfig());
        this.mDownloader.setDirectIPConfigStrategy(new h());
        this.mDownloader.setBackupIPConfigStrategy(new d());
        this.mDownloader.setKeepAliveStrategy(new e());
    }

    public static FileDownloaderManager g() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new FileDownloaderManager();
                }
            }
        }
        return instance;
    }

    public void abortDownload(String str, Downloader.DownloadListener downloadListener) {
        Downloader downloader = this.mDownloader;
        if (downloader != null) {
            downloader.abort(str, downloadListener);
        } else {
            QZLog.w("FileDownloaderManager", 1, "abortDownload, mDownloader is null");
        }
    }

    public void download(String str, String str2, Downloader.DownloadListener downloadListener) {
        Downloader downloader = this.mDownloader;
        if (downloader != null) {
            downloader.download(str, str2, downloadListener);
        } else {
            QZLog.w("FileDownloaderManager", 1, "download, mDownloader is null");
        }
    }

    public Downloader getDownloader() {
        return this.mDownloader;
    }
}
