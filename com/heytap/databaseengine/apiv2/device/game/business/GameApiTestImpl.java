package com.heytap.databaseengine.apiv2.device.game.business;

import com.heytap.databaseengine.apiv2.common.callback.HCallBack;
import com.heytap.databaseengine.apiv2.device.game.IGameApi;
import com.heytap.databaseengine.apiv2.device.game.model.GameData;
import com.heytap.databaseengine.apiv2.device.game.model.GameHealthData;
import com.heytap.databaseengine.apiv2.device.game.model.GameInfo;
import com.heytap.databaseengine.model.HeartRate;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GameApiTestImpl implements IGameApi {
    private List<OnResponseListener> mListeners = new ArrayList();
    private boolean mPlaying;

    /* JADX INFO: Access modifiers changed from: private */
    public GameHealthData debugData(GameInfo gameInfo) {
        GameHealthData gameHealthData = new GameHealthData();
        gameHealthData.setPackageName(gameInfo.getPackageName());
        gameHealthData.setStartTime(gameInfo.getRecord().getStartTime());
        gameHealthData.setEndTime(System.currentTimeMillis());
        int startTime = (int) (gameInfo.getRecord().getStartTime() / 1000);
        int endTime = (int) (gameInfo.getRecord().getEndTime() / 1000);
        for (long j3 = startTime; j3 < endTime; j3++) {
            HeartRate heartRate = new HeartRate();
            heartRate.setDataCreatedTimestamp(j3);
            heartRate.setHeartRateValue(((int) (Math.random() * 71.0d)) + 50);
            gameHealthData.getHeartRateList().add(heartRate);
        }
        gameHealthData.setStressAvg((int) (Math.random() * 100.0d));
        gameHealthData.setCalorie(100);
        return gameHealthData;
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void end(GameInfo gameInfo, HCallBack hCallBack) {
        this.mPlaying = false;
        hCallBack.onResponse(0);
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void endRound(final GameInfo gameInfo) {
        new BaseThread(new Runnable() { // from class: com.heytap.databaseengine.apiv2.device.game.business.GameApiTestImpl.1
            @Override // java.lang.Runnable
            public void run() {
                GameHealthData debugData = GameApiTestImpl.this.debugData(gameInfo);
                for (OnResponseListener onResponseListener : GameApiTestImpl.this.mListeners) {
                    if (onResponseListener != null) {
                        onResponseListener.onResponse(0, debugData);
                    }
                }
            }
        }).start();
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void isPlaying(HCallBack hCallBack) {
        int i3;
        if (this.mPlaying) {
            i3 = 0;
        } else {
            i3 = -1;
        }
        hCallBack.onResponse(i3);
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void isWearing(HCallBack hCallBack) {
        hCallBack.onResponse(0);
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void setOnResponseListener(OnResponseListener onResponseListener) {
        if (onResponseListener != null && !this.mListeners.contains(onResponseListener)) {
            this.mListeners.add(onResponseListener);
        }
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public boolean shouldCallForwarding() {
        return true;
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void start(GameInfo gameInfo, HCallBack hCallBack) {
        this.mPlaying = true;
        hCallBack.onResponse(0);
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void isConnectGameDevice(HCallBack hCallBack) {
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void onPermissionChanged(boolean z16) {
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void pause(GameInfo gameInfo) {
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void resume(GameInfo gameInfo) {
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void setOnRequestStatusListener(OnRequestStatusListener onRequestStatusListener) {
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void setSendConfig(boolean z16) {
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void setVerifyGameSwitch(boolean z16) {
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void startRound(GameInfo gameInfo, HCallBack hCallBack) {
    }

    @Override // com.heytap.databaseengine.apiv2.device.game.IGameApi
    public void updateData(GameInfo gameInfo, GameData gameData) {
    }
}
