package com.tencent.mobileqq.gamecenter.api;

import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMallAIORecommend$GetShopArkRsp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameMallAIOApi extends QRouteApi {
    com.tencent.aio.main.businesshelper.h getAioHelper();

    void notifyGameMallAIOArkInfo(int i3, long j3, String str, GameMallAIORecommend$GetShopArkRsp gameMallAIORecommend$GetShopArkRsp);

    void removeGameMallAIOArkInfoCallback();

    void reqGameMallAIOArkInfo(d dVar);
}
