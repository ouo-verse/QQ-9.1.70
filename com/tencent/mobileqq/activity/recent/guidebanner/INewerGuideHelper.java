package com.tencent.mobileqq.activity.recent.guidebanner;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface INewerGuideHelper extends QRouteApi {
    int getBannerId();

    NewerGuideBannerHandler getNewerGuideHandler(AppInterface appInterface);

    b getNewerGuideManager(AppRuntime appRuntime);

    void hideNewerGuideBanner(AppRuntime appRuntime);

    <T> boolean isMayKnowRecentBaseData(T t16);

    void notifyClickCloseBanner(NewerGuideBannerViewModel newerGuideBannerViewModel);

    void showNewerGuideBanner(AppInterface appInterface, Object obj);

    void startBrowser(Context context, String str, String str2);
}
