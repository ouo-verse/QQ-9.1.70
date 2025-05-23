package com.tencent.biz.richframework.download;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWDownloaderFactory {
    private static final String TAG = "RFWDownloaderFactory";
    private static final ConcurrentHashMap<Class, RFWDownloader> mDownloaderMap = new ConcurrentHashMap<>();

    public static RFWDownloader getDownloader(RFWDownloadStrategy rFWDownloadStrategy) {
        RFWDownloader rFWDownloader;
        ConcurrentHashMap<Class, RFWDownloader> concurrentHashMap = mDownloaderMap;
        RFWDownloader rFWDownloader2 = concurrentHashMap.get(rFWDownloadStrategy.getClass());
        if (rFWDownloader2 == null) {
            synchronized (RFWDownloaderFactory.class) {
                rFWDownloader = new RFWDownloader(rFWDownloadStrategy);
                concurrentHashMap.put(rFWDownloadStrategy.getClass(), rFWDownloader);
            }
            return rFWDownloader;
        }
        return rFWDownloader2;
    }
}
