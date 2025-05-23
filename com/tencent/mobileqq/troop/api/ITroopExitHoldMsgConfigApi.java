package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopExitHoldMsgConfigApi extends QRouteApi {
    String getNewTroopNotifyConfig();

    boolean useNewTroopNotifyConfig();
}
