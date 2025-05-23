package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameMsgUnissoHandlerApiImpl implements IGameMsgUnissoHandlerApi {
    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi
    public void addOrShieldFriend(int i3, int i16, String str, String str2, String str3) {
        GameCenterUnissoHandler.N2().addOrShieldFriend(i3, i16, str, str2, str3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi
    public void getAioPopInfo(int i3, int i16, String str, String str2) {
        GameCenterUnissoHandler.N2().getAioPopInfo(i3, i16, str, str2);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi
    public void getGameMsgTabConfig() {
        GameCenterUnissoHandler.N2().getGameMsgTabConfig();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi
    public void getGameStartPriority(int i3, String str) {
        GameCenterUnissoHandler.N2().getGameStartPriority(i3, str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi
    public void getGameSwitch(int i3) {
        GameCenterUnissoHandler.N2().getGameSwitch(i3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi
    public void setGameSwitch(int i3, String str, int i16, int i17, com.tencent.mobileqq.gamecenter.data.c cVar) {
        GameCenterUnissoHandler.N2().setGameSwitch(i3, str, i16, i17, cVar);
    }
}
