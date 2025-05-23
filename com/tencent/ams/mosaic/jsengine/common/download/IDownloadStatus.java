package com.tencent.ams.mosaic.jsengine.common.download;

import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface IDownloadStatus {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface DownloadStatus {
        public static final int STATUS_DOWNLOADING = 2;
        public static final int STATUS_DOWNLOAD_DELETE = 6;
        public static final int STATUS_DOWNLOAD_FAILED = 4;
        public static final int STATUS_DOWNLOAD_FINISHED = 3;
        public static final int STATUS_DOWNLOAD_PAUSED = 5;
        public static final int STATUS_DOWNLOAD_RESUME = 7;
        public static final int STATUS_INSTALLED = 1;
        public static final int STATUS_UNKNOWN = 0;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.CLASS)
    @Deprecated
    /* loaded from: classes3.dex */
    public @interface Status {
        public static final int CANCELLED = 3;
        public static final int COMPLETED = 4;
        public static final int DOWNING = 1;
        public static final int FAILED = 5;
        public static final int IDLE = 0;
        public static final int PAUSE = 2;
    }

    int getDownloadStatus();

    float progress();
}
