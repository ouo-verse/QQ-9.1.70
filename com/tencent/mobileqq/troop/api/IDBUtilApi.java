package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IDBUtilApi extends QRouteApi {
    void setTroopLuckyCharacterStatus(String str, String str2, String str3);

    Object transJsonToAioNavMsg(String str);
}
