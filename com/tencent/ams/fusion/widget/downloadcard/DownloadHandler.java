package com.tencent.ams.fusion.widget.downloadcard;

import android.content.DialogInterface;
import android.widget.ImageView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface DownloadHandler {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface DownloadStatusChangeListener {
        void onStatusChange(DownloadInfo downloadInfo, DownloadStatus downloadStatus);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface DownloadStatusGetter {
        void onGetStatus(DownloadStatus downloadStatus);
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface NetWorkType {
        public static final int TYPE_2G = 1;
        public static final int TYPE_3G = 2;
        public static final int TYPE_4G = 3;
        public static final int TYPE_5G = 4;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 5;
    }

    boolean deleteDownload(DownloadInfo downloadInfo);

    void displayImage(String str, ImageView imageView);

    void getDownloadStatus(DownloadInfo downloadInfo, DownloadStatusGetter downloadStatusGetter);

    int getNetWorkType();

    boolean installApp(DownloadInfo downloadInfo);

    boolean openApp(DownloadInfo downloadInfo);

    boolean pauseDownload(DownloadInfo downloadInfo);

    void registerDownloadStatusChangeListener(DownloadInfo downloadInfo, DownloadStatusChangeListener downloadStatusChangeListener);

    boolean resumeDownload(DownloadInfo downloadInfo);

    boolean showCustomDialog(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener);

    boolean startDownload(DownloadInfo downloadInfo);

    void unregisterDownloadStatusChangeListener(DownloadInfo downloadInfo);
}
