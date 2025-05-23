package com.tencent.mobileqq.profilecard.api;

import com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IProfileCardBlacklistApi extends QRouteApi {
    String getBlacklistTipMsg(String str);

    int getProfileCardBlacklistReportType(String str);

    boolean isBlackOrBlackedUin(String str, CheckBlacklistListener checkBlacklistListener);
}
