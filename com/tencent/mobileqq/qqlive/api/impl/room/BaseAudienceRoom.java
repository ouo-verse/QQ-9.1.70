package com.tencent.mobileqq.qqlive.api.impl.room;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.impl.room.corelog.EnterExitRoomLog;
import com.tencent.mobileqq.qqlive.api.impl.room.report.AudienceRoomTechReporter;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.qqlive.api.room.EnterRoomReqConfig;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class BaseAudienceRoom extends BaseLiveRoom implements IAudienceRoom {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Audience|AudienceRoomImpl";
    protected AudienceRoomEnterExitModule enterRoomModule;
    private final IAegisLogApi iAegisLogApi;
    private IQQLiveLoginCallback loginCallback;
    private final AudienceRoomConfig roomConfig;
    protected AudienceRoomTechReporter techReporter;

    public BaseAudienceRoom(AudienceRoomConfig audienceRoomConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) audienceRoomConfig);
            return;
        }
        this.techReporter = new AudienceRoomTechReporter();
        this.enterRoomModule = new AudienceRoomEnterExitModule();
        this.loginCallback = null;
        this.iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.roomConfig = audienceRoomConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doEnterRoom(EnterRoomInfo enterRoomInfo, EnterRoomReqConfig enterRoomReqConfig, boolean z16, EnterAudienceRoomCallback enterAudienceRoomCallback) {
        if (!checkSdkStatus()) {
            this.iAegisLogApi.e(TAG, 1, "enterRoom, but sdk status error");
            enterAudienceRoomCallback.onFailed(5109, "sdk status error");
            return;
        }
        this.iAegisLogApi.i(TAG, 1, hashCode() + " doEnterRoom, roomid:" + enterRoomInfo.getRoomId() + " vedio format:" + this.roomConfig.playerConfig.format);
        this.enterRoomModule.enterRoom(enterRoomInfo, enterRoomReqConfig, this.liveSDK, this.roomConfig.playerConfig.format, new EnterAudienceRoomCallback(enterAudienceRoomCallback, enterRoomInfo, z16) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean val$autoPlay;
            final /* synthetic */ EnterAudienceRoomCallback val$callback;
            final /* synthetic */ EnterRoomInfo val$roomInfo;

            {
                this.val$callback = enterAudienceRoomCallback;
                this.val$roomInfo = enterRoomInfo;
                this.val$autoPlay = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, BaseAudienceRoom.this, enterAudienceRoomCallback, enterRoomInfo, Boolean.valueOf(z16));
                }
            }

            @Override // com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback
            public void onFailed(int i3, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    BaseAudienceRoom.this.iAegisLogApi.e(BaseAudienceRoom.TAG, 1, this.val$roomInfo.getRoomId() + " enterRoom Failed code is " + i3 + " :" + str);
                    this.val$callback.onFailed(i3, str);
                    BaseAudienceRoom.this.techReporter.onFailed(i3, str);
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            }

            @Override // com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback
            public void onSuccess(LiveInfo liveInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) liveInfo);
                    return;
                }
                if (!BaseAudienceRoom.this.checkSdkStatus()) {
                    BaseAudienceRoom.this.iAegisLogApi.e(BaseAudienceRoom.TAG, 1, "enterRoom, but sdk status error");
                    this.val$callback.onFailed(5109, "sdk status error");
                    return;
                }
                BaseAudienceRoom baseAudienceRoom = BaseAudienceRoom.this;
                if (baseAudienceRoom.isExitRoom) {
                    baseAudienceRoom.iAegisLogApi.i(BaseAudienceRoom.TAG, 1, "enterRoom success but exitRoom before");
                    return;
                }
                baseAudienceRoom.afterEnterRoomSuccess(this.val$roomInfo, liveInfo, this.val$autoPlay);
                BaseAudienceRoom.this.onEnterRoom();
                this.val$callback.onSuccess(liveInfo);
                BaseAudienceRoom.this.techReporter.onSuccess(liveInfo);
                BaseAudienceRoom.this.recordCurRoom(liveInfo);
            }
        });
    }

    private long getRoomId() {
        BaseRoomInfo roomInfo = getRoomInfo();
        if (roomInfo != null) {
            return roomInfo.getRoomId();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordCurRoom(LiveInfo liveInfo) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "recordCurRoom liveInfo:" + liveInfo);
        }
        if (this.liveSDK != null) {
            if (liveInfo.roomInfo == null) {
                QLog.e(TAG, 1, "doEnterRoom onSuccess recordRoomInfo, something null");
                return;
            }
            QQLiveCurRoomInfo qQLiveCurRoomInfo = new QQLiveCurRoomInfo();
            qQLiveCurRoomInfo.roomId = liveInfo.roomInfo.roomId;
            qQLiveCurRoomInfo.roomType = 2;
            IQQLiveModuleLogin loginModule = this.liveSDK.getLoginModule();
            if (loginModule != null && loginModule.getLoginInfo() != null) {
                qQLiveCurRoomInfo.uid = this.liveSDK.getLoginModule().getLoginInfo().uid;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "recordCurRoom curRoomInfo:" + qQLiveCurRoomInfo);
            }
            this.liveSDK.recordCurRoomInfo(qQLiveCurRoomInfo);
            return;
        }
        QLog.e(TAG, 1, "recordCurRoom liveSDK is null");
    }

    protected void afterEnterRoomSuccess(EnterRoomInfo enterRoomInfo, LiveInfo liveInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, enterRoomInfo, liveInfo, Boolean.valueOf(z16));
        }
    }

    @VisibleForTesting
    public boolean checkSdkStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        IQQLiveSDK iQQLiveSDK = this.liveSDK;
        if (iQQLiveSDK != null && iQQLiveSDK.isInited() && !this.liveSDK.isDestroyed()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.iAegisLogApi.i(TAG, 1, "destroy rooId: " + getRoomId());
        super.destroy();
        this.enterRoomModule = null;
        this.liveSDK.getLoginModule().unregisterLoginStateCallback(this.loginCallback);
        this.loginCallback = null;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IAudienceRoom
    public void enterRoom(EnterRoomInfo enterRoomInfo, EnterRoomReqConfig enterRoomReqConfig, boolean z16, EnterAudienceRoomCallback enterAudienceRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, enterRoomInfo, enterRoomReqConfig, Boolean.valueOf(z16), enterAudienceRoomCallback);
            return;
        }
        if (this.isDestroy) {
            this.iAegisLogApi.e(TAG, 1, "enterRoom, but destroy");
            enterAudienceRoomCallback.onFailed(5109, "room is destroy");
            return;
        }
        this.isExitRoom = false;
        this.techReporter.onEnterRoomStart();
        IQQLiveModuleLogin loginModule = this.liveSDK.getLoginModule();
        if (loginModule.getLoginStatus() != 3 && loginModule.getLoginStatus() != 0) {
            if (loginModule.getLoginStatus() == 2) {
                this.iAegisLogApi.i(TAG, 1, "enterRoom waiting login");
                IQQLiveLoginCallback iQQLiveLoginCallback = this.loginCallback;
                if (iQQLiveLoginCallback != null) {
                    loginModule.unregisterLoginStateCallback(iQQLiveLoginCallback);
                }
                IQQLiveLoginCallback iQQLiveLoginCallback2 = new IQQLiveLoginCallback(loginModule, enterRoomInfo, enterRoomReqConfig, z16, enterAudienceRoomCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ boolean val$autoPlay;
                    final /* synthetic */ EnterAudienceRoomCallback val$callback;
                    final /* synthetic */ EnterRoomReqConfig val$config;
                    final /* synthetic */ IQQLiveModuleLogin val$loginModule;
                    final /* synthetic */ EnterRoomInfo val$roomInfo;

                    {
                        this.val$loginModule = loginModule;
                        this.val$roomInfo = enterRoomInfo;
                        this.val$config = enterRoomReqConfig;
                        this.val$autoPlay = z16;
                        this.val$callback = enterAudienceRoomCallback;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, BaseAudienceRoom.this, loginModule, enterRoomInfo, enterRoomReqConfig, Boolean.valueOf(z16), enterAudienceRoomCallback);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
                    public void onFailed(int i3, String str) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                            iPatchRedirector2.redirect((short) 3, (Object) this, i3, (Object) str);
                            return;
                        }
                        BaseAudienceRoom.this.iAegisLogApi.e(BaseAudienceRoom.TAG, 1, "login failed not doEnterRoom");
                        this.val$loginModule.unregisterLoginStateCallback(this);
                        this.val$callback.onFailed(5105, "login failed");
                    }

                    @Override // com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback
                    public void onSuccess(LoginInfo loginInfo) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) loginInfo);
                            return;
                        }
                        BaseAudienceRoom.this.iAegisLogApi.i(BaseAudienceRoom.TAG, 1, "login success doEnterRoom");
                        this.val$loginModule.unregisterLoginStateCallback(this);
                        BaseAudienceRoom.this.liveSDK.getDataReportModule().setLoginInfo(loginInfo);
                        BaseAudienceRoom.this.doEnterRoom(this.val$roomInfo, this.val$config, this.val$autoPlay, this.val$callback);
                    }
                };
                this.loginCallback = iQQLiveLoginCallback2;
                loginModule.registerLoginStateCallback(iQQLiveLoginCallback2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "direct doEnterRoom");
            }
            this.liveSDK.getDataReportModule().setLoginInfo(loginModule.getLoginInfo());
            doEnterRoom(enterRoomInfo, enterRoomReqConfig, z16, enterAudienceRoomCallback);
            return;
        }
        this.iAegisLogApi.e(TAG, 1, "enterRoom failed loginStatus is " + loginModule.getLoginStatus());
        enterAudienceRoomCallback.onFailed(5105, "login failed");
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public void exitRoom(ExitRoomCallback exitRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) exitRoomCallback);
            return;
        }
        EnterExitRoomLog enterExitRoomLog = EnterExitRoomLog.INSTANCE;
        enterExitRoomLog.beginExitingRoom("roomId: " + getRoomId());
        if (this.isDestroy) {
            enterExitRoomLog.errorExitRoom("room has been destroyed");
            return;
        }
        this.techReporter.onExitRoomStart();
        super.exitRoom(exitRoomCallback);
        long roomId = getRoomId();
        IQQLiveSDK iQQLiveSDK = this.liveSDK;
        if (iQQLiveSDK != null) {
            iQQLiveSDK.removeCurRoomRecord(roomId);
        } else {
            AegisLogger.w(TAG, "exitRoom", "no liveSDK");
        }
        this.enterRoomModule.exitRoom(this.liveSDK, new ExitRoomCallback(exitRoomCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ ExitRoomCallback val$callback;

            {
                this.val$callback = exitRoomCallback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseAudienceRoom.this, (Object) exitRoomCallback);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback
            public void onComplete(int i3, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) str);
                    return;
                }
                EnterExitRoomLog.INSTANCE.endExitingRoom("code:" + i3 + " errorMsg:" + str);
                ExitRoomCallback exitRoomCallback2 = this.val$callback;
                if (exitRoomCallback2 != null) {
                    exitRoomCallback2.onComplete(i3, str);
                }
                BaseAudienceRoom.this.techReporter.onComplete(i3, str);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public BaseAnchorInfo getAnchorInfo() {
        LiveInfo liveInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseAnchorInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.isDestroy || (liveInfo = this.enterRoomModule.liveInfo) == null) {
            return null;
        }
        return liveInfo.anchorInfo;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IAudienceRoom
    public AudienceRoomConfig getAudienceRoomConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (AudienceRoomConfig) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return new AudienceRoomConfig(this.roomConfig);
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public BaseRoomInfo getRoomInfo() {
        LiveRoomInfo liveRoomInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseRoomInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.isDestroy) {
            return null;
        }
        AudienceRoomEnterExitModule audienceRoomEnterExitModule = this.enterRoomModule;
        LiveInfo liveInfo = audienceRoomEnterExitModule.liveInfo;
        if (liveInfo != null && (liveRoomInfo = liveInfo.roomInfo) != null) {
            return liveRoomInfo;
        }
        return audienceRoomEnterExitModule.currentInfo;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IAudienceRoom
    public LiveInfo getRoomLiveInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (LiveInfo) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.isDestroy) {
            return null;
        }
        return this.enterRoomModule.liveInfo;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IAudienceRoom
    public int getRoomType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        AudienceRoomConfig audienceRoomConfig = this.roomConfig;
        if (audienceRoomConfig != null) {
            return audienceRoomConfig.roomType;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
            return;
        }
        super.init(iQQLiveSDK);
        this.isInited = true;
        this.techReporter.init(iQQLiveSDK);
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    public boolean isAnchorRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IAudienceRoom
    public boolean isQQAnchor() {
        LiveInfo liveInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (!this.isDestroy && (liveInfo = this.enterRoomModule.liveInfo) != null) {
            return liveInfo.isQQAnchor();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.iAegisLogApi.i(TAG, 1, "reset rooId: " + getRoomId());
        if (this.isDestroy) {
            return;
        }
        super.reset();
        this.liveSDK.getLoginModule().unregisterLoginStateCallback(this.loginCallback);
        this.loginCallback = null;
        this.techReporter.reset();
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IAudienceRoom
    public void setExtraData(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle);
        } else {
            this.techReporter.setExtraData(bundle);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IAudienceRoom
    public void enterRoom(EnterRoomInfo enterRoomInfo, boolean z16, EnterAudienceRoomCallback enterAudienceRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            enterRoom(enterRoomInfo, new EnterRoomReqConfig(false), z16, enterAudienceRoomCallback);
        } else {
            iPatchRedirector.redirect((short) 7, this, enterRoomInfo, Boolean.valueOf(z16), enterAudienceRoomCallback);
        }
    }
}
