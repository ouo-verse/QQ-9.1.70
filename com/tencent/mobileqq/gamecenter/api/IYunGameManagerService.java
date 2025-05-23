package com.tencent.mobileqq.gamecenter.api;

import android.os.Bundle;
import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.mobileqq.gamecenter.data.GameInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import eipc.EIPCResult;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes12.dex */
public interface IYunGameManagerService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void onResult(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void onStateChange(IYunGameConstant.GameStatusInfo gameStatusInfo);
    }

    void addGameStateListener(b bVar);

    void exitBackground();

    int getYunGameActivityStatus();

    void notifyUserFeedback();

    EIPCResult onCall(String str, Bundle bundle, int i3);

    void onPushReceive(String str);

    EIPCResult onRespone(String str, Bundle bundle, int i3);

    void preLoadYunGame();

    void removeGameStateListener(b bVar);

    void restartYunGame(GameInfo gameInfo, a aVar);

    void setYunGameClarity(int i3);

    void startGame(GameInfo gameInfo, a aVar);

    void stopGame(GameInfo gameInfo, a aVar);
}
