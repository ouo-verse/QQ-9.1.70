package com.tencent.ams.mosaic.jsengine.common.download;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IMosaicDownloadManager {

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
    public interface a {
        void a(String str);

        void b(int i3, int i16);

        void onDownloadPause();

        void onDownloadResume();

        void onDownloadStart();

        void onFailed(@ErrorCode int i3);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
        String a();

        String b();

        String c();

        String getName();

        String getUrl();
    }

    IDownload download(b bVar, a aVar);

    IDownloadStatus queryDownload(b bVar);
}
