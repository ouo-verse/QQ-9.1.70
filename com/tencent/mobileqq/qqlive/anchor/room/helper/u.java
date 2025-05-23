package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class u implements ITRTCRoomListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQLiveTRTCRoomBaseListener";

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onEnterRoom(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onEnterRoom, errCode:" + j3 + ", msg:" + str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onEvent(int i3, int i16, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onEvent, eventId:" + i3 + ", errCode:" + i16 + ", msg:" + str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onExitRoom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onExitRoom, reason:" + i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onFirstLocalAudioFrameSent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onFirstLocalAudioFrameSent");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onFirstLocalVideoFrameSent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onFirstLocalVideoFrameSent, streamType:" + i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onRemoteUserEnterRoom(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onRemoteUserEnterRoom, remoteUserId:" + str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onRemoteUserLeaveRoom(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onRemoteUserLeaveRoom, remoteUserId:" + str + ", reason:" + i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onSwitchRoom(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onSwitchRoom, errCode:" + i3 + ", msg:" + str);
        }
    }
}
