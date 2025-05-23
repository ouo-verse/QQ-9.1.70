package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.mobileqq.gamecenter.api.IGameMsgHandlerNameApi;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameMsgHandlerNameApiImpl implements IGameMsgHandlerNameApi {
    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHandlerNameApi
    public String getGameMsgHandlerName() {
        return GameCenterUnissoHandler.class.getName();
    }
}
