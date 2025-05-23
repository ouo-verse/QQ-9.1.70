package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = true)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameVipWithoutAdManager extends QRouteApi {
    boolean getVipWithoutAdMemberState();

    String getVipWithoutAdToastText();
}
