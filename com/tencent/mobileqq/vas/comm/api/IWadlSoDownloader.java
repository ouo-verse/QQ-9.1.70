package com.tencent.mobileqq.vas.comm.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vip.g;
import m03.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IWadlSoDownloader extends QRouteApi {
    boolean isWadlDownloader();

    int startDownload(g gVar, a aVar);
}
