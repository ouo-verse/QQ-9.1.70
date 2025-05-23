package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.impl.room.PlayRetryStrategy;
import com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule;
import com.tencent.mobileqq.qqlive.api.impl.room.RoomSuperPlayerModule;
import com.tencent.mobileqq.qqlive.api.room.PlayerConfig;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPush;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class t {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private RoomPlayModule f270917a;

    /* renamed from: b, reason: collision with root package name */
    private String f270918b;

    /* renamed from: c, reason: collision with root package name */
    private IQQLiveAnchorRoomThirdPush f270919c;

    /* renamed from: d, reason: collision with root package name */
    private QQLiveAnchorAutoCheckPullPlayParams f270920d;

    /* renamed from: e, reason: collision with root package name */
    private AudienceRoomPlayerListener f270921e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f270922f;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends com.tencent.mobileqq.qqlive.anchor.room.helper.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f270923a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IQQLiveAnchorRoomThirdPush f270924b;

        a(String str, IQQLiveAnchorRoomThirdPush iQQLiveAnchorRoomThirdPush) {
            this.f270923a = str;
            this.f270924b = iQQLiveAnchorRoomThirdPush;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, t.this, str, iQQLiveAnchorRoomThirdPush);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onError(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_tpChecker", 1, "onError, errorCode:" + i3 + ", msg:" + str + ", url: " + this.f270923a);
            }
            if (t.this.f270922f) {
                return;
            }
            try {
                QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
                qQLiveErrorMsg.bizModule = 2;
                qQLiveErrorMsg.bizErrCode = QQLiveError.ANCHOR_THIRD_PUSH_CHECK_ERR;
                qQLiveErrorMsg.bizErrMsg = "player error";
                qQLiveErrorMsg.originErrCode = i3;
                qQLiveErrorMsg.originErrMsg = str;
                this.f270924b.onThirdPushChecked(new QQLiveAnchorDataThirdPushCheck(false, qQLiveErrorMsg));
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_tpChecker", 1, th5, new Object[0]);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.helper.a, com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onFirstFrameCome(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_tpChecker", 1, "onFirstFrameCome, url: " + this.f270923a);
            }
            if (t.this.f270922f) {
                return;
            }
            try {
                this.f270924b.onThirdPushChecked(new QQLiveAnchorDataThirdPushCheck(true, null));
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_tpChecker", 1, th5, new Object[0]);
            }
        }
    }

    public t(String str, String str2, RoomPlayModule roomPlayModule, QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPush iQQLiveAnchorRoomThirdPush) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, roomPlayModule, qQLiveAnchorAutoCheckPullPlayParams, iQQLiveAnchorRoomThirdPush);
            return;
        }
        this.f270922f = false;
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_tpChecker", 1, "create QQLiveAnchorThirdPushChecker, isMute:" + qQLiveAnchorAutoCheckPullPlayParams.isMute + ", playUrl: " + str2);
        }
        this.f270917a = roomPlayModule;
        if (roomPlayModule == null) {
            PlayerConfig playerConfig = new PlayerConfig();
            playerConfig.playerSceneID = qQLiveAnchorAutoCheckPullPlayParams.sceneID;
            this.f270917a = new RoomSuperPlayerModule(str, qQLiveAnchorAutoCheckPullPlayParams.isMute, playerConfig);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_tpChecker", 1, "playModule, hashCode:" + this.f270917a.hashCode());
        }
        this.f270918b = str2;
        this.f270919c = iQQLiveAnchorRoomThirdPush;
        this.f270920d = qQLiveAnchorAutoCheckPullPlayParams;
        a aVar = new a(str2, iQQLiveAnchorRoomThirdPush);
        this.f270921e = aVar;
        this.f270917a.registerRoomPlayerListener(aVar);
        this.f270917a.setRetryParams(qQLiveAnchorAutoCheckPullPlayParams.playerRetryInterval, qQLiveAnchorAutoCheckPullPlayParams.playerRetryCount);
    }

    public void b(boolean z16, boolean z17) {
        AudienceRoomPlayerListener audienceRoomPlayerListener;
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("destroy, hashCode:");
            RoomPlayModule roomPlayModule = this.f270917a;
            if (roomPlayModule == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(roomPlayModule.hashCode());
            }
            sb5.append(valueOf);
            sb5.append(", destoryPlayer:");
            sb5.append(z16);
            sb5.append(", url:");
            sb5.append(this.f270918b);
            QLog.d("QQLiveAnchor_tpChecker", 1, sb5.toString());
        }
        this.f270922f = true;
        RoomPlayModule roomPlayModule2 = this.f270917a;
        if (roomPlayModule2 != null && (audienceRoomPlayerListener = this.f270921e) != null) {
            roomPlayModule2.unRegisterRoomPlayerListener(audienceRoomPlayerListener);
        }
        this.f270921e = null;
        RoomPlayModule roomPlayModule3 = this.f270917a;
        if (roomPlayModule3 != null) {
            if (z16) {
                roomPlayModule3.destroy();
            } else if (z17) {
                roomPlayModule3.resetPlayer();
                this.f270917a.setVideoSurface();
            }
        }
        this.f270917a = null;
        this.f270918b = null;
        this.f270920d = null;
        this.f270919c = null;
    }

    public View c() {
        RoomPlayModule roomPlayModule;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_tpChecker", 1, "getDisplayView, isDestroy:" + this.f270922f);
        }
        if (this.f270922f || (roomPlayModule = this.f270917a) == null) {
            return null;
        }
        return roomPlayModule.getVideoView().getCurrentDisplayView();
    }

    public void d(long j3, int i3, PlayRetryStrategy playRetryStrategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Integer.valueOf(i3), playRetryStrategy);
            return;
        }
        RoomPlayModule roomPlayModule = this.f270917a;
        if (roomPlayModule != null) {
            roomPlayModule.setRetryParams(j3, i3, playRetryStrategy);
        }
    }

    public void e(boolean z16) {
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        RoomPlayModule roomPlayModule = this.f270917a;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("startCheck, , isDestroy: ");
            sb5.append(this.f270922f);
            sb5.append(", hashCode: ");
            if (roomPlayModule == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(roomPlayModule.hashCode());
            }
            sb5.append(valueOf);
            sb5.append(", isMute:");
            sb5.append(z16);
            sb5.append(", url:");
            sb5.append(this.f270918b);
            QLog.d("QQLiveAnchor_tpChecker", 1, sb5.toString());
        }
        if (!this.f270922f && roomPlayModule != null) {
            roomPlayModule.startPlay(this.f270918b);
            roomPlayModule.setMute(z16);
        }
    }
}
