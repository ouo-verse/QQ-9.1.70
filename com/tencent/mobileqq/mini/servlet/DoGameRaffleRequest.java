package com.tencent.mobileqq.mini.servlet;

import NS_MINI_GAME_RAFFLE.GameRaffleInfo$StDoGameRaffleReq;
import NS_MINI_GAME_RAFFLE.GameRaffleInfo$StDoGameRaffleRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DoGameRaffleRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_game_raffle.DoGameRaffle";
    public static final String TAG = "DoGameRaffleRequest";
    private GameRaffleInfo$StDoGameRaffleReq req;

    public DoGameRaffleRequest(String str, String str2) {
        GameRaffleInfo$StDoGameRaffleReq gameRaffleInfo$StDoGameRaffleReq = new GameRaffleInfo$StDoGameRaffleReq();
        this.req = gameRaffleInfo$StDoGameRaffleReq;
        gameRaffleInfo$StDoGameRaffleReq.appid.set(str);
        this.req.uin.set(str2);
    }

    public static GameRaffleInfo$StDoGameRaffleRsp onResponse(byte[] bArr) {
        try {
            GameRaffleInfo$StDoGameRaffleRsp gameRaffleInfo$StDoGameRaffleRsp = new GameRaffleInfo$StDoGameRaffleRsp();
            gameRaffleInfo$StDoGameRaffleRsp.mergeFrom(bArr);
            return gameRaffleInfo$StDoGameRaffleRsp;
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
