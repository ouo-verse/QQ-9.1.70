package com.tencent.mobileqq.vas.download.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vip.g;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IDownloadAdapter extends QRouteApi {
    void vipReportCgi(g gVar);
}
