package com.tencent.ams.dsdk.download;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface Download {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Callback {
        void onCancelled();

        void onDownloadComplete();

        void onDownloadFailed(Exception exc);

        void onDownloadProgress(long j3, long j16);

        void onDownloadStart();
    }

    boolean cancel();

    int getDownloadStatus();

    float getDownloadedProgress();

    boolean isRunning();

    boolean registerCallback(Callback callback);

    boolean start();

    boolean unRegisterCallback(Callback callback);
}
