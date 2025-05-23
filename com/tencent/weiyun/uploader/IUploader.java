package com.tencent.weiyun.uploader;

import com.tencent.weiyun.uploader.xplatform.UploadNative;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IUploader {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IUploadListener {
        void onUploadCanceled(UploadRequest uploadRequest);

        void onUploadFinished(UploadRequest uploadRequest, boolean z16, UploadResponse uploadResponse);

        void onUploadProgress(UploadRequest uploadRequest, long j3, float f16, long j16, long j17, long j18);
    }

    String[] calSliceSha1(String str, UploadNative.CanceledFlag canceledFlag);

    void cancel(UploadRequest uploadRequest);

    void cancelAll();

    void reportError(long j3, String str, String str2, String str3, int i3, boolean z16, long j16, long j17, long j18, boolean z17, int i16);

    void setHttpProxy(String str, int i3, String str2, String str3);

    void setIpConfig(String str, String str2);

    void setNetType(int i3);

    void setReporter(IReporter iReporter);

    void speedDown();

    void trialSpeedUp(int i3);

    boolean upload(UploadRequest uploadRequest);

    void vipSpeedUp();
}
