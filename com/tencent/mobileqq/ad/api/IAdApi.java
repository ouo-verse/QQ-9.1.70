package com.tencent.mobileqq.ad.api;

import android.app.Activity;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import s71.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IAdApi extends QRouteApi {
    void clearLebaShoppingRedTouchAd();

    void doMaskAdValidExpo(GdtAd gdtAd);

    GdtAd getLebaShoppingRedTouchAd(String str);

    String getLebaShoppingRedTouchLastExpoAd();

    Map<String, String> getReportParams();

    void report(String str, Map<String, String> map);

    void requestLebaShoppingRedTouchAd(a aVar);

    void startAdH5DebugFragment(Activity activity);

    void startAlphaVideoAdDebugFragment(Activity activity);

    void startLoadingAdDebugFragment(Activity activity);

    void startRewardAdDebugFragment(Activity activity);

    void updateLebaShoppingRedTouchLastExpoAd(String str);
}
