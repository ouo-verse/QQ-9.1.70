package com.tencent.mobileqq.api;

import com.tencent.mobileqq.beancurd.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface ITofuActionApi extends QRouteApi {
    void enableNewYearTofuUpdate(AppRuntime appRuntime, String str);

    int getNormalOnlineStatusBeancurdBusId();

    int getOnlineStatusBeancurdBusiId();

    boolean isEnableNewYearTofu(AppRuntime appRuntime);

    boolean isEnableTofuMsgDelete(AppRuntime appRuntime);

    void saveAvatarStatusView(AppRuntime appRuntime, b bVar);

    void trigToGetAvatarStatusInfo(AppRuntime appRuntime, String str);

    void tryUpdateFriendAvatarSwitch(AppRuntime appRuntime, ec2.b bVar);
}
