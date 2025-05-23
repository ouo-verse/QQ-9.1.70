package com.tencent.gdtad;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/gdtad/IAdConfigApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getCanInstallCheck", "", "getCanRefreshScheduleData", "getCanShowInstallTip", "getCanShowTabAdBanner", "getCanShowTabAdBannerGuide", "getRequestTabAdBannerDelay", "", "getTabAdBannerPullProcess", "", "qqad-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IAdConfigApi extends QRouteApi {
    boolean getCanInstallCheck();

    boolean getCanRefreshScheduleData();

    boolean getCanShowInstallTip();

    boolean getCanShowTabAdBanner();

    boolean getCanShowTabAdBannerGuide();

    long getRequestTabAdBannerDelay();

    double getTabAdBannerPullProcess();
}
