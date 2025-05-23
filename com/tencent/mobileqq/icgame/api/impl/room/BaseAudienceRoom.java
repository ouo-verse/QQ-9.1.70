package com.tencent.mobileqq.icgame.api.impl.room;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.impl.room.corelog.EnterExitRoomLog;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceRoomTechReporter;
import com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.data.login.LoginInfo;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.api.room.EnterRoomReqConfig;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class BaseAudienceRoom extends BaseLiveRoom implements IAudienceRoom {
    private static final String TAG = "ICGameAudience|ICGameAudienceRoomImpl";
    private final AudienceRoomConfig roomConfig;
    protected AudienceRoomTechReporter techReporter = new AudienceRoomTechReporter();
    protected AudienceRoomEnterExitModule enterRoomModule = new AudienceRoomEnterExitModule();
    private w22.a loginCallback = null;
    private final IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    public BaseAudienceRoom(AudienceRoomConfig audienceRoomConfig) {
        this.roomConfig = audienceRoomConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doEnterRoom(final EnterRoomInfo enterRoomInfo, EnterRoomReqConfig enterRoomReqConfig, final boolean z16, final b32.c cVar) {
        if (!checkSdkStatus()) {
            this.iAegisLogApi.e(TAG, 1, "enterRoom, but sdk status error");
            cVar.onFailed(5109, "sdk status error");
            return;
        }
        this.iAegisLogApi.i(TAG, 1, hashCode() + " doEnterRoom, roomid:" + enterRoomInfo.getRoomId() + " vedio format:" + this.roomConfig.playerConfig.format);
        this.enterRoomModule.enterRoom(enterRoomInfo, enterRoomReqConfig, this.liveSDK, this.roomConfig.playerConfig.format, new b32.c() { // from class: com.tencent.mobileqq.icgame.api.impl.room.BaseAudienceRoom.2
            @Override // b32.c
            public void onFailed(int i3, String str) {
                BaseAudienceRoom.this.iAegisLogApi.e(BaseAudienceRoom.TAG, 1, enterRoomInfo.getRoomId() + " enterRoom Failed code is " + i3 + " :" + str);
                cVar.onFailed(i3, str);
                BaseAudienceRoom.this.techReporter.onEnterRoomFailed(i3, str);
            }

            @Override // b32.c
            public void onSuccess(LiveInfo liveInfo) {
                if (!BaseAudienceRoom.this.checkSdkStatus()) {
                    BaseAudienceRoom.this.iAegisLogApi.e(BaseAudienceRoom.TAG, 1, "enterRoom, but sdk status error");
                    cVar.onFailed(5109, "sdk status error");
                    return;
                }
                BaseAudienceRoom baseAudienceRoom = BaseAudienceRoom.this;
                if (baseAudienceRoom.isExitRoom) {
                    baseAudienceRoom.iAegisLogApi.i(BaseAudienceRoom.TAG, 1, "enterRoom success but exitRoom before");
                    return;
                }
                baseAudienceRoom.afterEnterRoomSuccess(enterRoomInfo, liveInfo, z16);
                BaseAudienceRoom.this.onEnterRoom();
                cVar.onSuccess(liveInfo);
                BaseAudienceRoom.this.techReporter.onEnterRoomSuccess(liveInfo);
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

    @VisibleForTesting
    public boolean checkSdkStatus() {
        IQQLiveSDK iQQLiveSDK = this.liveSDK;
        if (iQQLiveSDK != null && iQQLiveSDK.isInited() && !this.liveSDK.isDestroyed()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        this.iAegisLogApi.i(TAG, 1, "destroy rooId: " + getRoomId());
        super.destroy();
        this.enterRoomModule = null;
        this.liveSDK.getLoginModule().unregisterLoginStateCallback(this.loginCallback);
        this.loginCallback = null;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IAudienceRoom
    public void enterRoom(final EnterRoomInfo enterRoomInfo, final EnterRoomReqConfig enterRoomReqConfig, final boolean z16, final b32.c cVar) {
        if (this.isDestroy) {
            this.iAegisLogApi.e(TAG, 1, "enterRoom, but destroy");
            cVar.onFailed(5109, "room is destroy");
            return;
        }
        this.isExitRoom = false;
        this.techReporter.onEnterRoomStart();
        final IQQLiveModuleLogin loginModule = this.liveSDK.getLoginModule();
        if (loginModule.getLoginStatus() != 3 && loginModule.getLoginStatus() != 0) {
            if (loginModule.getLoginStatus() == 2) {
                this.iAegisLogApi.i(TAG, 1, "enterRoom waiting login");
                w22.a aVar = this.loginCallback;
                if (aVar != null) {
                    loginModule.unregisterLoginStateCallback(aVar);
                }
                w22.a aVar2 = new w22.a() { // from class: com.tencent.mobileqq.icgame.api.impl.room.BaseAudienceRoom.1
                    @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
                    public void onFailed(int i3, String str) {
                        BaseAudienceRoom.this.iAegisLogApi.e(BaseAudienceRoom.TAG, 1, "login failed not doEnterRoom");
                        loginModule.unregisterLoginStateCallback(this);
                        cVar.onFailed(5105, "login failed");
                    }

                    @Override // w22.a
                    public void onSuccess(LoginInfo loginInfo) {
                        BaseAudienceRoom.this.iAegisLogApi.i(BaseAudienceRoom.TAG, 1, "login success doEnterRoom");
                        loginModule.unregisterLoginStateCallback(this);
                        BaseAudienceRoom.this.liveSDK.getDataReportModule().setLoginInfo(loginInfo);
                        BaseAudienceRoom.this.doEnterRoom(enterRoomInfo, enterRoomReqConfig, z16, cVar);
                    }
                };
                this.loginCallback = aVar2;
                loginModule.registerLoginStateCallback(aVar2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "direct doEnterRoom");
            }
            this.liveSDK.getDataReportModule().setLoginInfo(loginModule.getLoginInfo());
            doEnterRoom(enterRoomInfo, enterRoomReqConfig, z16, cVar);
            return;
        }
        this.iAegisLogApi.e(TAG, 1, "enterRoom failed loginStatus is " + loginModule.getLoginStatus());
        cVar.onFailed(5105, "login failed");
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.icgame.api.room.ILiveRoomBase
    public void exitRoom(final ExitRoomCallback exitRoomCallback) {
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
            rt0.a.g(TAG, "exitRoom", "no liveSDK");
        }
        this.enterRoomModule.exitRoom(this.liveSDK, new ExitRoomCallback() { // from class: com.tencent.mobileqq.icgame.api.impl.room.BaseAudienceRoom.3
            @Override // com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback
            public void onComplete(int i3, String str) {
                EnterExitRoomLog.INSTANCE.endExitingRoom("code:" + i3 + " errorMsg:" + str);
                ExitRoomCallback exitRoomCallback2 = exitRoomCallback;
                if (exitRoomCallback2 != null) {
                    exitRoomCallback2.onComplete(i3, str);
                }
                BaseAudienceRoom.this.techReporter.onExitRoomEnd(i3, str);
            }
        });
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoom, com.tencent.mobileqq.icgame.api.room.ILiveRoomBase
    public BaseAnchorInfo getAnchorInfo() {
        LiveInfo liveInfo;
        if (this.isDestroy || (liveInfo = this.enterRoomModule.liveInfo) == null) {
            return null;
        }
        return liveInfo.anchorInfo;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IAudienceRoom
    public AudienceRoomConfig getAudienceRoomConfig() {
        return new AudienceRoomConfig(this.roomConfig);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoom, com.tencent.mobileqq.icgame.api.room.ILiveRoomBase
    public BaseRoomInfo getRoomInfo() {
        LiveRoomInfo liveRoomInfo;
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

    @Override // com.tencent.mobileqq.icgame.api.room.IAudienceRoom
    public LiveInfo getRoomLiveInfo() {
        if (this.isDestroy) {
            return null;
        }
        return this.enterRoomModule.liveInfo;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IAudienceRoom
    public int getRoomType() {
        AudienceRoomConfig audienceRoomConfig = this.roomConfig;
        if (audienceRoomConfig != null) {
            return audienceRoomConfig.roomType;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        super.init(iQQLiveSDK);
        this.isInited = true;
        this.techReporter.init(iQQLiveSDK, this.roomConfig);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoom
    public boolean isAnchorRoom() {
        return false;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IAudienceRoom
    public boolean isQQAnchor() {
        LiveInfo liveInfo;
        if (!this.isDestroy && (liveInfo = this.enterRoomModule.liveInfo) != null) {
            return liveInfo.isQQAnchor();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        this.iAegisLogApi.i(TAG, 1, "reset rooId: " + getRoomId());
        if (this.isDestroy) {
            return;
        }
        super.reset();
        this.liveSDK.getLoginModule().unregisterLoginStateCallback(this.loginCallback);
        this.loginCallback = null;
        this.techReporter.reset();
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IAudienceRoom
    public void setExtraData(Bundle bundle) {
        this.techReporter.setExtraData(bundle);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IAudienceRoom
    public void enterRoom(EnterRoomInfo enterRoomInfo, boolean z16, b32.c cVar) {
        enterRoom(enterRoomInfo, new EnterRoomReqConfig(false), z16, cVar);
    }

    protected void afterEnterRoomSuccess(EnterRoomInfo enterRoomInfo, LiveInfo liveInfo, boolean z16) {
    }
}
