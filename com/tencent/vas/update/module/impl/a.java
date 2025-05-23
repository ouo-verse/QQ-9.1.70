package com.tencent.vas.update.module.impl;

import com.tencent.vas.update.callback.listener.IDownloadListener;
import com.tencent.vas.update.callback.listener.ITaskDownloadCallback;
import com.tencent.vas.update.entity.DownloadInfoParams;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a implements uw4.a, IDownloadListener {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, ITaskDownloadCallback> f384043a = new ConcurrentHashMap<>();

    @Override // uw4.a
    public void a(String str, String str2, String str3, String str4, ITaskDownloadCallback iTaskDownloadCallback) {
        this.f384043a.put(str, iTaskDownloadCallback);
        DownloadInfoParams downloadInfoParams = new DownloadInfoParams();
        downloadInfoParams.mItemId = str;
        downloadInfoParams.mUrl = str2;
        downloadInfoParams.mFrom = str3;
        downloadInfoParams.mSavePath = str4;
        VasUpdateWrapper.getHttpDownloader().a(downloadInfoParams, this, null);
    }

    @Override // com.tencent.vas.update.callback.listener.IDownloadListener
    public void onCompleted(String str, int i3, int i16, String str2) {
        ITaskDownloadCallback iTaskDownloadCallback = this.f384043a.get(str);
        if (iTaskDownloadCallback != null) {
            iTaskDownloadCallback.notifyDownloadComplete(str, i3, i16, str2);
            this.f384043a.remove(str);
        }
    }

    @Override // com.tencent.vas.update.callback.listener.IDownloadListener
    public void onDownloadStart(String str) {
        VasUpdateWrapper.getLog().i("VasUpdate_DownloadModule", "onDownloadStart itemId = " + str);
    }

    @Override // com.tencent.vas.update.callback.listener.IDownloadListener
    public void onProgress(String str, long j3, long j16, int i3) {
        ITaskDownloadCallback iTaskDownloadCallback = this.f384043a.get(str);
        if (iTaskDownloadCallback != null) {
            iTaskDownloadCallback.notifyDownloadProgress(str, j3, j16, i3);
        }
    }
}
