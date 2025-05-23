package com.tencent.luggage.wxa.rq;

import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.downloader.IFileDownloaderProxy;
import com.tencent.xweb.downloader.IFileDownloaderProxyCallback;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements IFileDownloaderProxyCallback {

    /* renamed from: b, reason: collision with root package name */
    public static IFileDownloaderProxy f139910b;

    /* renamed from: a, reason: collision with root package name */
    public IFileDownloaderProxyCallback f139911a = null;

    public static void a(IFileDownloaderProxy iFileDownloaderProxy) {
        x0.d("WXFileDownloaderBridge", "setFileDownloaderProxy:" + iFileDownloaderProxy);
        f139910b = iFileDownloaderProxy;
    }

    @Override // com.tencent.xweb.downloader.IFileDownloaderProxyCallback
    public void onTaskFailed(String str, int i3, boolean z16) {
        IFileDownloaderProxyCallback iFileDownloaderProxyCallback = this.f139911a;
        if (iFileDownloaderProxyCallback != null) {
            iFileDownloaderProxyCallback.onTaskFailed(str, i3, z16);
        }
    }

    @Override // com.tencent.xweb.downloader.IFileDownloaderProxyCallback
    public void onTaskFinished(String str, String str2, boolean z16) {
        IFileDownloaderProxyCallback iFileDownloaderProxyCallback = this.f139911a;
        if (iFileDownloaderProxyCallback != null) {
            iFileDownloaderProxyCallback.onTaskFinished(str, str2, z16);
        }
    }

    @Override // com.tencent.xweb.downloader.IFileDownloaderProxyCallback
    public void onTaskProgressChanged(String str, long j3, long j16) {
        IFileDownloaderProxyCallback iFileDownloaderProxyCallback = this.f139911a;
        if (iFileDownloaderProxyCallback != null) {
            iFileDownloaderProxyCallback.onTaskProgressChanged(str, j3, j16);
        }
    }

    public boolean a() {
        return f139910b != null;
    }

    public void a(IFileDownloaderProxyCallback iFileDownloaderProxyCallback) {
        this.f139911a = iFileDownloaderProxyCallback;
    }

    public int a(String str, String str2, int i3) {
        IFileDownloaderProxy iFileDownloaderProxy = f139910b;
        if (iFileDownloaderProxy != null) {
            return iFileDownloaderProxy.addDownloadTask(str, str2, i3, this);
        }
        return -1;
    }
}
