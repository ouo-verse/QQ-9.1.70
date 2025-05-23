package com.tencent.mobileqq.minigame.manager;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class AbstractDownloader {
    protected DownloadListener mDownloadListener;
    public String mUrl;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface DownloadListener {
        void onDownloadCanceled(String str);

        void onDownloadFailed(String str);

        void onDownloadProgress(String str, float f16);

        void onDownloadSucceed(String str, String str2);
    }

    public abstract void download();

    public void setDownloadListener(DownloadListener downloadListener) {
        this.mDownloadListener = downloadListener;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }
}
