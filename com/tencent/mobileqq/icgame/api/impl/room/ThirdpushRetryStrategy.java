package com.tencent.mobileqq.icgame.api.impl.room;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ThirdpushRetryStrategy implements PlayRetryStrategy {
    private RoomPlayModule playModule;
    private int currentTime = 0;
    int retryTime = Integer.MAX_VALUE;

    @Override // com.tencent.mobileqq.icgame.api.impl.room.PlayRetryStrategy
    public void bindPlayModule(RoomPlayModule roomPlayModule) {
        this.playModule = roomPlayModule;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.PlayRetryStrategy
    public void onError(int i3, int i16, int i17, String str) {
        if (this.currentTime >= this.retryTime) {
            this.currentTime = 0;
            return;
        }
        for (b32.a aVar : this.playModule.getRoomPlayerListeners()) {
            aVar.onError(i3, "");
            aVar.onError(i3, i16, i17, str);
        }
        this.currentTime++;
        this.playModule.retry();
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.PlayRetryStrategy
    public void reset() {
        this.currentTime = 0;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.PlayRetryStrategy
    public void onPrepared() {
    }
}
