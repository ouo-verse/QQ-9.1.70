package com.tencent.mobileqq.gamecenter.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGameMsgAddFriendRulesApi extends QRouteApi {
    void doInit(AppInterface appInterface, String str, String str2, int i3);

    boolean isAbleToAction();

    void recordAction();
}
