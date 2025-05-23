package com.tencent.mobileqq.qqlive.anchor.room;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorThirdPushRoom;
import com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom;
import com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule;
import com.tencent.mobileqq.qqlive.api.impl.room.RoomSuperPlayerModule;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.raftframework.sla.SLAReporter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class an extends QQLiveAnchorRoom implements IQQLiveAnchorThirdPushRoom {
    static IPatchRedirector $redirector_;
    private static final String[] T;
    private final RoomPlayModule P;
    protected com.tencent.mobileqq.qqlive.anchor.room.helper.q Q;
    protected com.tencent.mobileqq.qqlive.anchor.room.helper.t R;
    private AudienceRoomPlayerListener S;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends com.tencent.mobileqq.qqlive.anchor.room.helper.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) an.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onError(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            if (!((BaseLiveRoom) an.this).isDestroy && !((BaseLiveRoom) an.this).isExitRoom && an.this.f270783i.ordinal() >= QQLiveAnchorRoomState.STATE_ENTER_ING.ordinal()) {
                QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
                qQLiveErrorMsg.bizModule = 2;
                qQLiveErrorMsg.bizErrCode = 6300;
                qQLiveErrorMsg.bizErrMsg = "living player error";
                qQLiveErrorMsg.originErrCode = i3;
                qQLiveErrorMsg.originErrMsg = str;
                an.this.f270782h.onError(qQLiveErrorMsg);
                com.tencent.mobileqq.qqlive.anchor.report.a aVar = an.this.G;
                if (aVar != null) {
                    aVar.o(qQLiveErrorMsg);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b extends al {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorAutoCheckPullPlayParams f270821e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback, QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams) {
            super(iQQLiveAnchorRoomThirdPushCallback);
            this.f270821e = qQLiveAnchorAutoCheckPullPlayParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, an.this, iQQLiveAnchorRoomThirdPushCallback, qQLiveAnchorAutoCheckPullPlayParams);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.al, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
        public void onGetPullInfo(QQLiveAnchorDataPullInfo qQLiveAnchorDataPullInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataPullInfo);
            } else {
                super.onGetPullInfo(qQLiveAnchorDataPullInfo);
                an.this.P(this.f270821e, qQLiveAnchorDataPullInfo.defaultPlayUrl, this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.al, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
        public void onThirdPushChecked(QQLiveAnchorDataThirdPushCheck qQLiveAnchorDataThirdPushCheck) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataThirdPushCheck);
            } else {
                super.onThirdPushChecked(qQLiveAnchorDataThirdPushCheck);
                an.this.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c extends al {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorAutoCheckPullPlayParams f270823e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback, QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams) {
            super(iQQLiveAnchorRoomThirdPushCallback);
            this.f270823e = qQLiveAnchorAutoCheckPullPlayParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, an.this, iQQLiveAnchorRoomThirdPushCallback, qQLiveAnchorAutoCheckPullPlayParams);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.al, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
        public void onGetPullInfo(QQLiveAnchorDataPullInfo qQLiveAnchorDataPullInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataPullInfo);
            } else {
                super.onGetPullInfo(qQLiveAnchorDataPullInfo);
                an.this.P(this.f270823e, qQLiveAnchorDataPullInfo.defaultPlayUrl, this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.al, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
        public void onThirdPushChecked(QQLiveAnchorDataThirdPushCheck qQLiveAnchorDataThirdPushCheck) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataThirdPushCheck);
            } else {
                super.onThirdPushChecked(qQLiveAnchorDataThirdPushCheck);
                an.this.Q();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60543);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            T = new String[]{SLAReporter.PERMISSION_NET, "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE"};
        }
    }

    public an(@NonNull Context context, @NonNull IQQLiveSDK iQQLiveSDK, @NonNull QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig, IQQLiveAnchorRoomCallback iQQLiveAnchorRoomCallback) {
        super(context, iQQLiveSDK, qQLiveAnchorRoomConfig, iQQLiveAnchorRoomCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, iQQLiveSDK, qQLiveAnchorRoomConfig, iQQLiveAnchorRoomCallback);
            return;
        }
        this.Q = new com.tencent.mobileqq.qqlive.anchor.room.helper.q();
        this.S = new a();
        RoomSuperPlayerModule roomSuperPlayerModule = new RoomSuperPlayerModule(iQQLiveSDK.getAppId(), false, qQLiveAnchorRoomConfig.playerConfig);
        this.P = roomSuperPlayerModule;
        roomSuperPlayerModule.registerRoomPlayerListener(this.S);
        roomSuperPlayerModule.setRetryParams(-1L, -1);
    }

    private void O() {
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchorThirdPushRoom", 1, "thirdpush room destroy player");
        }
        try {
            RoomPlayModule roomPlayModule = this.P;
            if (roomPlayModule == null) {
                return;
            }
            roomPlayModule.unRegisterRoomPlayerListener(this.S);
            this.P.destroy();
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchorThirdPushRoom", 1, "destroyPlayer error: " + th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams, String str, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback) {
        String str2;
        if (qQLiveAnchorAutoCheckPullPlayParams.autoCheckPullPlay) {
            com.tencent.mobileqq.qqlive.anchor.room.helper.t tVar = this.R;
            if (tVar != null) {
                tVar.b(false, true);
            }
            IQQLiveSDK iQQLiveSDK = this.liveSDK;
            if (iQQLiveSDK != null) {
                str2 = iQQLiveSDK.getAppId();
            } else {
                str2 = "-1";
            }
            com.tencent.mobileqq.qqlive.anchor.room.helper.t tVar2 = new com.tencent.mobileqq.qqlive.anchor.room.helper.t(str2, str, this.P, qQLiveAnchorAutoCheckPullPlayParams, iQQLiveAnchorRoomThirdPushCallback);
            this.R = tVar2;
            tVar2.e(qQLiveAnchorAutoCheckPullPlayParams.isMute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        this.P.setRetryParams(-1L, -1);
        this.R.b(false, false);
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            super.destroy();
            O();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorThirdPushRoom
    public boolean disableViewCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.P.disableViewCallback();
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorThirdPushRoom
    public boolean enableViewCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.P.enableViewCallback();
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public void exitRoom(ExitRoomCallback exitRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) exitRoomCallback);
        } else {
            super.exitRoom(exitRoomCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public void fastResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            if (this.isDestroy) {
                return;
            }
            super.fastResume();
            this.F.g(this, this.f270782h);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public int getPlayStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorThirdPushRoom
    public void getRtmpPullUrl(QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQLiveAnchorAutoCheckPullPlayParams);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchorThirdPushRoom", 1, "thirdPushRoom getPullUrl");
        }
        if (this.isDestroy) {
            return;
        }
        this.Q.c(this.liveSDK, this.f270781f, qQLiveAnchorAutoCheckPullPlayParams, new c(this.f270782h, qQLiveAnchorAutoCheckPullPlayParams));
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorThirdPushRoom
    public void getRtmpPushUrl(QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorAutoCheckPullPlayParams);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchorThirdPushRoom", 1, "thirdPushRoom getPushUrl");
        }
        if (this.isDestroy) {
            return;
        }
        this.Q.d(this.liveSDK, this.f270781f, qQLiveAnchorAutoCheckPullPlayParams, new b(this.f270782h, qQLiveAnchorAutoCheckPullPlayParams));
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom
    public boolean isOutputMute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (this.isDestroy) {
            return false;
        }
        return this.P.isOutputMute();
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.P.pause();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void play() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.P.startPlay("");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void playerOnlyPauseWhenReset(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void preloadUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void preloadWithCurrentUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            if (this.isDestroy) {
                return;
            }
            RoomPlayModule roomPlayModule = this.P;
            roomPlayModule.preloadUrl(roomPlayModule.getPlayUrl());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void registerRoomPlayerListener(AudienceRoomPlayerListener audienceRoomPlayerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) audienceRoomPlayerListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.P.registerRoomPlayerListener(audienceRoomPlayerListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            super.reset();
            O();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void setIgnoreRoomPush(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom
    public void setMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.P.setMute(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void setRetryParams(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), Integer.valueOf(i3));
        } else {
            this.P.setRetryParams(j3, i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void startPlay(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void unRegisterRoomPlayerListener(AudienceRoomPlayerListener audienceRoomPlayerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) audienceRoomPlayerListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.P.unRegisterRoomPlayerListener(audienceRoomPlayerListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom
    protected String[] x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return T;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom
    public ITPPlayerVideoView getDisplayView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ITPPlayerVideoView) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        if (this.isDestroy) {
            return null;
        }
        return this.P.getVideoView();
    }
}
