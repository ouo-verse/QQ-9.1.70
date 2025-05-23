package com.tencent.ams.dsdk.download;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface DKDownloadManager {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Callback {
        void onCancelled();

        void onDownloadComplete();

        void onDownloadFailed(@ErrorCode int i3);

        void onDownloadPause();

        void onDownloadResume();

        void onDownloadStart();

        void onDownloadUpdate(long j3, long j16);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface ErrorCode {
        public static final int CANCELLED = 4;
        public static final int HTTP_ERROR = 6;
        public static final int IO_ERROR = 3;
        public static final int OK = 0;
        public static final int OTHER = 7;
        public static final int PARAMS_ERROR = 1;
        public static final int REDIRECT_LIMIT_EXCEED = 5;
        public static final int VAILD_FAILED = 2;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface IDownloader {
        boolean cancel();

        int getDownloadStatus();

        float getDownloadedProgress();

        boolean isRunning();

        boolean pause();

        boolean resume();

        boolean start();
    }

    IDownloader download(DownloadRequest downloadRequest, Callback callback);
}
