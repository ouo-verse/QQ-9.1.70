package com.tencent.mobileqq.qqperf.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Set;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IDeviceOptSwitch extends QRouteApi {
    Set<Integer> getPreDownloadWhiteList();

    boolean isDisablePreDownload();

    void setDisablePreDownloadTime(long j3);
}
