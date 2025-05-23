package com.tencent.mobileqq.qqlive.callback.anchor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.data.anchor.room.AnchorLiveSystemInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataAuth;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataCheckPermission;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFastResume;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.common.QQLiveEventMsg;

/* loaded from: classes17.dex */
public abstract class QQLiveAnchorRoomThirdPushBaseCallback implements IQQLiveAnchorRoomThirdPushCallback {
    static IPatchRedirector $redirector_;

    public QQLiveAnchorRoomThirdPushBaseCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void onAnchorLiveNetStatus(AnchorLiveSystemInfo anchorLiveSystemInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) anchorLiveSystemInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCheckPermission
    public void onCheckPermission(QQLiveAnchorDataCheckPermission qQLiveAnchorDataCheckPermission) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataCheckPermission);
        }
    }

    public void onEnter(QQLiveAnchorDataEnter qQLiveAnchorDataEnter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQLiveAnchorDataEnter);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomEnter
    public void onEnterRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
    public void onError(QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) qQLiveErrorMsg);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
    public void onEvent(QQLiveEventMsg qQLiveEventMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) qQLiveEventMsg);
        }
    }

    public void onExit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
    public void onFaceAuth(QQLiveAnchorDataAuth qQLiveAnchorDataAuth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) qQLiveAnchorDataAuth);
        }
    }

    public void onFastResumeResult(QQLiveAnchorDataFastResume qQLiveAnchorDataFastResume) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) qQLiveAnchorDataFastResume);
        }
    }

    public void onGetPullInfo(QQLiveAnchorDataPullInfo qQLiveAnchorDataPullInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) qQLiveAnchorDataPullInfo);
        }
    }

    public void onGetPushInfo(QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) qQLiveAnchorDataPushInfo);
        }
    }

    public void onInit(QQLiveAnchorDataInit qQLiveAnchorDataInit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) qQLiveAnchorDataInit);
        }
    }

    public void onLiveError(QQLiveAnchorDataBase qQLiveAnchorDataBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) qQLiveAnchorDataBase);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomLive
    public void onLiveStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    public void onPrepare(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) qQLiveAnchorDataPrepare);
        }
    }

    public void onPublishStream(QQLiveAnchorDataPublishStream qQLiveAnchorDataPublishStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) qQLiveAnchorDataPublishStream);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomRemote
    public void onRemoteUserEnterRoom(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomRemote
    public void onRemoteUserLeaveRoom(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str, i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomStream
    public void onScreenCaptureError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3, (Object) str);
        }
    }

    public void onScreenCapturePause(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
        }
    }

    public void onScreenCaptureStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        }
    }

    public void onSet(QQLiveAnchorDataSet qQLiveAnchorDataSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) qQLiveAnchorDataSet);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCheckPermission
    public void onStartCheckPermission() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public void onStartEnter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
    public void onStartFaceAuth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomFastResume
    public void onStartFastResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
    public void onStartGetPullInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPushUrl
    public void onStartGetPushInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomInit
    public void onStartInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    public void onStartPrepare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    public void onStartPublishStream() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    public void onStartSet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
    public void onStateChange(QQLiveAnchorRoomState qQLiveAnchorRoomState, QQLiveAnchorRoomState qQLiveAnchorRoomState2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) qQLiveAnchorRoomState, (Object) qQLiveAnchorRoomState2);
        }
    }

    public void onThirdPushChecked(QQLiveAnchorDataThirdPushCheck qQLiveAnchorDataThirdPushCheck) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) qQLiveAnchorDataThirdPushCheck);
        }
    }
}
