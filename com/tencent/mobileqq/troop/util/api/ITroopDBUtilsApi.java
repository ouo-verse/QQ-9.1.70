package com.tencent.mobileqq.troop.util.api;

import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopDBUtilsApi extends QRouteApi {
    BaseTransaction getSaveTroopMemberCardInfoTransactionObj(TroopMemberCardInfo troopMemberCardInfo);

    TroopMemberCardInfo getTroopMemberCardInfo(AppRuntime appRuntime, String str, String str2);

    boolean saveTroopMemberCardInfo(AppRuntime appRuntime, TroopMemberCardInfo troopMemberCardInfo);
}
