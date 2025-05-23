package com.tencent.gdtad;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\u0005H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/gdtad/IRealTimeConfigApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "clearRealTimeSplashConfig", "", "getAmsOlympicShowLimitEnable", "", "getRealTimeSplashAllLimit", "", "getRealTimeSplashColdLimit", "getRealTimeSplashDelayTime", "", "getRealTimeSplashDownloadRes", "getRealTimeSplashDuration", "getRealTimeSplashHotLimit", "getRealTimeSplashIsEffectiveTime", "qqad-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IRealTimeConfigApi extends QRouteApi {
    void clearRealTimeSplashConfig();

    boolean getAmsOlympicShowLimitEnable();

    int getRealTimeSplashAllLimit();

    int getRealTimeSplashColdLimit();

    long getRealTimeSplashDelayTime();

    boolean getRealTimeSplashDownloadRes();

    int getRealTimeSplashDuration();

    int getRealTimeSplashHotLimit();

    boolean getRealTimeSplashIsEffectiveTime();
}
