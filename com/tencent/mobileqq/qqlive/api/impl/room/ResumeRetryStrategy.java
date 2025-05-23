package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
class ResumeRetryStrategy implements PlayRetryStrategy {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ResumeRetryStrategy";
    private boolean isError;
    private RoomPlayModule playModule;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeRetryStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isError = false;
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
        if (!this.isError) {
            for (AudienceRoomPlayerListener audienceRoomPlayerListener : this.playModule.getPlayerListeners()) {
                audienceRoomPlayerListener.onError(i3, "");
                audienceRoomPlayerListener.onError(i3, i16, i17, str);
            }
        }
        this.isError = true;
        this.playModule.retry();
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.PlayRetryStrategy
    public void onPrepared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "onPrepared: " + this.isError);
        if (this.isError) {
            this.isError = false;
            Iterator<AudienceRoomPlayerListener> it = this.playModule.getPlayerListeners().iterator();
            while (it.hasNext()) {
                it.next().onResume();
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.PlayRetryStrategy
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.isError = false;
        }
    }
}
