package com.tencent.qqlive.module.videoreport.report.bizready;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IBizReady<T> {
    T handleExposureInfo(T t16);

    void setBizReady(Object obj, boolean z16);

    void setOnBizReadyListener(IBizReadyListener<T> iBizReadyListener);
}
