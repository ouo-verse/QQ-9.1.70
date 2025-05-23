package com.tencent.gdtad.api.banner;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtBannerAdAPI extends QRouteApi {
    IGdtBannerAd buildBannerAd(GdtBannerParams gdtBannerParams);
}
