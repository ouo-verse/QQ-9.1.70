package com.heytap.databaseengine.apiv2.device.game;

import androidx.annotation.Keep;
import com.heytap.databaseengine.apiv2.common.callback.HCallBack;
import com.heytap.databaseengine.apiv2.device.game.business.OnRequestStatusListener;
import com.heytap.databaseengine.apiv2.device.game.business.OnResponseListener;
import com.heytap.databaseengine.apiv2.device.game.model.GameData;
import com.heytap.databaseengine.apiv2.device.game.model.GameInfo;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public interface IGameApi {
    void end(GameInfo gameInfo, HCallBack hCallBack);

    void endRound(GameInfo gameInfo);

    void isConnectGameDevice(HCallBack hCallBack);

    void isPlaying(HCallBack hCallBack);

    void isWearing(HCallBack hCallBack);

    void onPermissionChanged(boolean z16);

    void pause(GameInfo gameInfo);

    void resume(GameInfo gameInfo);

    void setOnRequestStatusListener(OnRequestStatusListener onRequestStatusListener);

    void setOnResponseListener(OnResponseListener onResponseListener);

    void setSendConfig(boolean z16);

    void setVerifyGameSwitch(boolean z16);

    boolean shouldCallForwarding();

    void start(GameInfo gameInfo, HCallBack hCallBack);

    void startRound(GameInfo gameInfo, HCallBack hCallBack);

    void updateData(GameInfo gameInfo, GameData gameData);
}
