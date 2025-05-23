package com.tencent.mobileqq.springhb.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.springhb.entry.model.DragonCardConfigData;
import com.tencent.mobileqq.springhb.entry.model.TimeInfo;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISpringHbTempApi extends QRouteApi {
    boolean activityConfigLoaded();

    boolean disableReport(int i3);

    int getApngPlayCount();

    DragonCardConfigData getDragonCardConfig(AppRuntime appRuntime);

    DragonCardConfigData getDragonCardConfigFromCache(AppRuntime appRuntime);

    int getEntryConfigTaskId(AppRuntime appRuntime);

    int getEntryConfigVersion(AppRuntime appRuntime);

    int getGameCenterPreloadConfVersion(AppRuntime appRuntime);

    long getReportConfigDelayTime(int i3);

    long getSpringHBSpeedTime();

    int getSpringHbPreloadConfVersion(AppRuntime appRuntime);

    boolean isCurTimeInTime(TimeInfo timeInfo);

    boolean isFoldDevice();

    boolean isGameCenterActivity(AppRuntime appRuntime);

    boolean isInTime(TimeInfo timeInfo, long j3);

    boolean isLoadingShowing();

    boolean isSplashActivity(Context context);

    boolean isSpringHbActivity(AppRuntime appRuntime);

    boolean needReportFullTask();

    void openCommonHbPage();

    void openSpringHbWebView(Context context, String str, int i3, String str2, boolean z16, Bundle bundle);

    Long parseTime(String str);

    void requestSpringHBPreloadSource();

    void setIsLoadingShowing(boolean z16);
}
