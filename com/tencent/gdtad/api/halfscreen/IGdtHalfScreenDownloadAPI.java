package com.tencent.gdtad.api.halfscreen;

import com.tencent.ad.tangram.halfScreenDownload.AdHalfScreenDownload;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtHalfScreenDownloadAPI extends QRouteApi {
    void start(AdHalfScreenDownload.Params params);
}
