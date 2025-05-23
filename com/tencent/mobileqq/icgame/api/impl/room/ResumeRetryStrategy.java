package com.tencent.mobileqq.icgame.api.impl.room;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes15.dex */
class ResumeRetryStrategy implements PlayRetryStrategy {
    private static final String TAG = "ICGameResumeRetryStrategy";
    private boolean isError = false;
    private RoomPlayModule playModule;

    @Override // com.tencent.mobileqq.icgame.api.impl.room.PlayRetryStrategy
    public void bindPlayModule(RoomPlayModule roomPlayModule) {
        this.playModule = roomPlayModule;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.PlayRetryStrategy
    public void onError(int i3, int i16, int i17, String str) {
        if (!this.isError) {
            for (b32.a aVar : this.playModule.getRoomPlayerListeners()) {
                aVar.onError(i3, "");
                aVar.onError(i3, i16, i17, str);
            }
        }
        this.isError = true;
        this.playModule.retry();
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.PlayRetryStrategy
    public void onPrepared() {
        QLog.i(TAG, 1, "onPrepared: " + this.isError);
        if (this.isError) {
            this.isError = false;
            Iterator<b32.a> it = this.playModule.getRoomPlayerListeners().iterator();
            while (it.hasNext()) {
                it.next().onResume();
            }
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.PlayRetryStrategy
    public void reset() {
        this.isError = false;
    }
}
