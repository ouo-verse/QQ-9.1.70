package com.tencent.mobileqq.gamecenter.qa.api.impl;

import com.tencent.mobileqq.gamecenter.qa.api.IGameQAIpcApi;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameQAIpcApiImpl implements IGameQAIpcApi {
    @Override // com.tencent.mobileqq.gamecenter.qa.api.IGameQAIpcApi
    public void callbackStrategyAnswer(int i3, int i16, long j3, long j16) {
        com.tencent.mobileqq.qqgamepub.ipc.b.d().callbackStrategyAnswer(i3, i16, j3, j16);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IGameQAIpcApi
    public void callbackStrategyQuestion(int i3, int i16, long j3) {
        com.tencent.mobileqq.qqgamepub.ipc.b.d().callbackStrategyQuestion(i3, i16, j3);
    }
}
