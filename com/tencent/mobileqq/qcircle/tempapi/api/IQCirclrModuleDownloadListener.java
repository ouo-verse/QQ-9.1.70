package com.tencent.mobileqq.qcircle.tempapi.api;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface IQCirclrModuleDownloadListener {
    void onDownloadCanceled(String str);

    void onDownloadFailed(String str);

    void onDownloadProgress(String str, float f16);

    void onDownloadSucceed(String str);
}
