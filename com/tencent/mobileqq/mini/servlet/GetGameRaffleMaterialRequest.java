package com.tencent.mobileqq.mini.servlet;

import NS_MINI_GAME_RAFFLE.GameRaffleInfo$StGetGameRaffleMaterialReq;
import NS_MINI_GAME_RAFFLE.GameRaffleInfo$StGetGameRaffleMaterialRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetGameRaffleMaterialRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_game_raffle.GetGameRaffleMaterial";
    public static final String TAG = "GetGameRaffleMaterialRequest";
    private GameRaffleInfo$StGetGameRaffleMaterialReq req;

    public GetGameRaffleMaterialRequest(String str) {
        GameRaffleInfo$StGetGameRaffleMaterialReq gameRaffleInfo$StGetGameRaffleMaterialReq = new GameRaffleInfo$StGetGameRaffleMaterialReq();
        this.req = gameRaffleInfo$StGetGameRaffleMaterialReq;
        gameRaffleInfo$StGetGameRaffleMaterialReq.appid.set(str);
    }

    public static GameRaffleInfo$StGetGameRaffleMaterialRsp onResponse(byte[] bArr) {
        try {
            GameRaffleInfo$StGetGameRaffleMaterialRsp gameRaffleInfo$StGetGameRaffleMaterialRsp = new GameRaffleInfo$StGetGameRaffleMaterialRsp();
            gameRaffleInfo$StGetGameRaffleMaterialRsp.mergeFrom(bArr);
            return gameRaffleInfo$StGetGameRaffleMaterialRsp;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
