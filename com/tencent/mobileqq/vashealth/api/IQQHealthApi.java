package com.tencent.mobileqq.vashealth.api;

import android.content.Context;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRemote;
import h43.d;
import mqq.app.NewIntent;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IQQHealthApi extends QRouteApi {
    Class getParserClass();

    boolean getRankingSwitchStateDefault();

    String getSpLBSLatitude();

    String getSpLBSLogitude();

    String getSpLBSUpdateTimeStamp();

    NewIntent getStepCounterServletIntent(Context context);

    Class<? extends Entity> getTracePathDataClass();

    Class<? extends Entity> getTracePointDataClass();

    @QRemote
    void hideBanner();

    boolean isHealthDomain(String str);

    boolean isHealthUin(String str);

    boolean isNeedRedirectAIOToMainPage(String str);

    boolean isNeedReport(String str);

    boolean isSubscribedHealthPA();

    boolean isSupportStepCounter(Context context);

    void requestJoinRanking(Boolean bool);

    void requestRankingState(d dVar);

    @QRemote
    void showBanner(long j3, String str);
}
