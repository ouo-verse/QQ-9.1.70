package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.mobileqq.gamecenter.api.IGameMallAIOApi;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMallAIORecommend$GetShopArkRsp;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public class GameMallAIOApiImpl implements IGameMallAIOApi {
    private com.tencent.mobileqq.gamecenter.api.d mGameMallRequestArkCallback;

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMallAIOApi
    public com.tencent.aio.main.businesshelper.h getAioHelper() {
        return new id1.c();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMallAIOApi
    public void notifyGameMallAIOArkInfo(int i3, long j3, String str, GameMallAIORecommend$GetShopArkRsp gameMallAIORecommend$GetShopArkRsp) {
        com.tencent.mobileqq.gamecenter.api.d dVar = this.mGameMallRequestArkCallback;
        if (dVar != null && dVar.hashCode() == i3) {
            dVar.a(j3, str, gameMallAIORecommend$GetShopArkRsp);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMallAIOApi
    public void removeGameMallAIOArkInfoCallback() {
        this.mGameMallRequestArkCallback = null;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMallAIOApi
    public void reqGameMallAIOArkInfo(com.tencent.mobileqq.gamecenter.api.d dVar) {
        if (dVar == null) {
            return;
        }
        this.mGameMallRequestArkCallback = dVar;
        GameCenterUnissoHandler.N2().q3(dVar.hashCode());
    }
}
