package com.tencent.ams.dsdk.download;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface DownloadTask extends Runnable {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnDownloadListener {
        void onCancelled();

        void onDownloadComplete();

        void onDownloadFailed(Exception exc);

        void onDownloadProgress(long j3, long j16);

        void onDownloadStart();
    }

    boolean cancel();

    boolean isCancelled();

    boolean isCompleted();

    boolean isDownloading();

    boolean isFailed();
}
