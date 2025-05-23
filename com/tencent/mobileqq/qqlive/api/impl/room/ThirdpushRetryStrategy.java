package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ThirdpushRetryStrategy implements PlayRetryStrategy {
    static IPatchRedirector $redirector_;
    private int currentTime;
    private RoomPlayModule playModule;
    int retryTime;

    public ThirdpushRetryStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.currentTime = 0;
            this.retryTime = Integer.MAX_VALUE;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.PlayRetryStrategy
    public void bindPlayModule(RoomPlayModule roomPlayModule) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) roomPlayModule);
        } else {
            this.playModule = roomPlayModule;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.PlayRetryStrategy
    public void onError(int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            return;
        }
        if (this.currentTime >= this.retryTime) {
            this.currentTime = 0;
            return;
        }
        for (AudienceRoomPlayerListener audienceRoomPlayerListener : this.playModule.getPlayerListeners()) {
            audienceRoomPlayerListener.onError(i3, "");
            audienceRoomPlayerListener.onError(i3, i16, i17, str);
        }
        this.currentTime++;
        this.playModule.retry();
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.PlayRetryStrategy
    public void onPrepared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.PlayRetryStrategy
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.currentTime = 0;
        }
    }
}
