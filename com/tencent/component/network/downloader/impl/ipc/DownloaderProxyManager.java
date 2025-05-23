package com.tencent.component.network.downloader.impl.ipc;

import android.content.Context;
import com.tencent.component.network.downloader.Downloader;

/* loaded from: classes5.dex */
public class DownloaderProxyManager {
    private static Downloader sCommonDownloader;
    private static Downloader sImageDownloader;

    public static Downloader getCommonDownloader(Context context) {
        Downloader downloader = sCommonDownloader;
        if (downloader != null) {
            return downloader;
        }
        synchronized (DownloaderProxyManager.class) {
            Downloader downloader2 = sCommonDownloader;
            if (downloader2 != null) {
                return downloader2;
            }
            DownloaderProxy downloaderProxy = new DownloaderProxy(context, "common_proxy", 2);
            sCommonDownloader = downloaderProxy;
            return downloaderProxy;
        }
    }

    public static Downloader getImageDownloader(Context context) {
        Downloader downloader = sImageDownloader;
        if (downloader != null) {
            return downloader;
        }
        synchronized (DownloaderProxyManager.class) {
            Downloader downloader2 = sImageDownloader;
            if (downloader2 != null) {
                return downloader2;
            }
            DownloaderProxy downloaderProxy = new DownloaderProxy(context, "image_proxy", 1);
            sImageDownloader = downloaderProxy;
            return downloaderProxy;
        }
    }
}
