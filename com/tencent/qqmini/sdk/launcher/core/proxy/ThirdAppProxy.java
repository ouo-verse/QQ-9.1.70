package com.tencent.qqmini.sdk.launcher.core.proxy;

import org.json.JSONObject;

/* loaded from: classes23.dex */
public abstract class ThirdAppProxy {

    /* loaded from: classes23.dex */
    public interface AppDownloadListener {
        void onDownloadComplete();

        void onDownloadFailed(int i3, int i16, String str);

        void onDownloadProgress(long j3, long j16, int i3);
    }

    public abstract boolean deleteDownloadTask(String str);

    public abstract void init();

    public abstract boolean installApp(String str, AsyncResult asyncResult);

    public abstract void queryApkDownloadInfo(String str, AsyncResult asyncResult);

    public abstract void queryDownloadTask(String str, AsyncResult asyncResult);

    public abstract boolean resumeDownloadTask(String str);

    public abstract void setSpeedBuffer(String str, int i3);

    public abstract void startDownload(String str, JSONObject jSONObject, boolean z16, AppDownloadListener appDownloadListener);

    public abstract boolean stopDownloadTask(String str);

    public abstract void unInit();
}
