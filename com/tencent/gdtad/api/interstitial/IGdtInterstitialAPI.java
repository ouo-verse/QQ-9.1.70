package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import tencent.gdt.qq_ad_get;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtInterstitialAPI extends QRouteApi {
    @NonNull
    IGdtInterstitialAd build(Context context, GdtInterstitialParams gdtInterstitialParams);

    void closeAd(qq_ad_get.QQAdGetRsp.AdInfo adInfo);

    void init(Context context);
}
