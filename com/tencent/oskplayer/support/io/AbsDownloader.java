package com.tencent.oskplayer.support.io;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class AbsDownloader {
    protected DownloadListener mDownloadListener;
    protected String mUrl;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface DownloadListener {
        void onDownloadCanceled(String str);

        void onDownloadFailed(String str);

        void onDownloadProgress(String str, float f16);

        void onDownloadSucceed(String str, String str2);
    }

    protected AbsDownloader(String str) {
        this(str, null);
    }

    public abstract void download();

    public void setDownloadListener(DownloadListener downloadListener) {
        this.mDownloadListener = downloadListener;
    }

    protected AbsDownloader(String str, DownloadListener downloadListener) {
        this.mUrl = str;
        this.mDownloadListener = downloadListener;
    }
}
