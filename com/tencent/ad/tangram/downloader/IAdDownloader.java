package com.tencent.ad.tangram.downloader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Pair;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IAdDownloader {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Callback {
        void onDownloadProgressUpdate(List<Object> list, List<Pair<String, String>> list2);

        void onDownloadStatusChanged(int i3, int i16, Pair<String, String> pair, String str);
    }

    void doDownloadAction(Activity activity, Bundle bundle, String str, int i3);

    int getCurrentPkgDownloadProgress(Context context, String str, String str2);

    @Nullable
    Object getDownloadInfoByUrl(String str);

    void installDownload(Object obj);

    int isPkgDownloadPaused(Context context, String str, String str2);

    int isPkgDownloading(Context context, String str, String str2);

    boolean isPkgExist(Context context, String str, String str2);

    void pauseDownload(String str, String str2);

    void registerListener(Callback callback);

    void unregisterListener(Callback callback);
}
