package com.tencent.mobileqq.minigame.manager;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.minigame.manager.AbstractDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DefaultDownloader extends AbstractDownloader {
    public static final String LOG_TAG = "DefaultDownloader";

    @Override // com.tencent.mobileqq.minigame.manager.AbstractDownloader
    public void download() {
        final String str = BaseApplication.getContext().getCacheDir() + File.separator + UUID.randomUUID() + ".zip";
        MiniappDownloadUtil.getInstance().download(this.mUrl, str, true, new Downloader.DownloadListener() { // from class: com.tencent.mobileqq.minigame.manager.DefaultDownloader.1
            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadCanceled(String str2) {
                AbstractDownloader.DownloadListener downloadListener = DefaultDownloader.this.mDownloadListener;
                if (downloadListener != null) {
                    downloadListener.onDownloadCanceled(str2);
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadFailed(String str2, DownloadResult downloadResult) {
                AbstractDownloader.DownloadListener downloadListener = DefaultDownloader.this.mDownloadListener;
                if (downloadListener != null) {
                    downloadListener.onDownloadFailed(str2);
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadProgress(String str2, long j3, float f16) {
                AbstractDownloader.DownloadListener downloadListener = DefaultDownloader.this.mDownloadListener;
                if (downloadListener != null) {
                    downloadListener.onDownloadProgress(str2, f16);
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadSucceed(String str2, DownloadResult downloadResult) {
                AbstractDownloader.DownloadListener downloadListener = DefaultDownloader.this.mDownloadListener;
                if (downloadListener != null) {
                    downloadListener.onDownloadSucceed(str2, str);
                }
            }
        }, Downloader.DownloadMode.OkHttpMode, null);
        QLog.i(LOG_TAG, 1, "[MiniEng] download " + this.mUrl + " start, saveTo=" + str);
    }
}
