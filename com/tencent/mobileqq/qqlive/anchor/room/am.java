package com.tencent.mobileqq.qqlive.anchor.room;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperTRTC;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomBaseCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.AnchorLiveSystemInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.common.QQLiveEventMsg;
import com.tencent.mobileqq.qqlive.data.datareport.StatisticData;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveQuality;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRenderParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveTranscodingConfig;
import com.tencent.mobileqq.qqlive.data.trtc.RTCCameraDefine;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener;
import com.tencent.mobileqq.qqlive.listener.trtc.RemoteUserAudioInfo;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.raft.raftframework.sla.SLAReporter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class am extends QQLiveAnchorRoom implements IQQLiveAnchorTRTCRoom {
    static IPatchRedirector $redirector_;
    private static final String[] U;
    private FrameLayout P;
    protected QQLiveAnchorHelperTRTC Q;
    protected boolean R;
    private final com.tencent.mobileqq.qqlive.anchor.viewmodel.a S;
    protected boolean T;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends QQLiveAnchorRoomBaseCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorRoomConfig f270813d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IQQLiveSDK f270814e;

        a(QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig, IQQLiveSDK iQQLiveSDK) {
            this.f270813d = qQLiveAnchorRoomConfig;
            this.f270814e = iQQLiveSDK;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, am.this, qQLiveAnchorRoomConfig, iQQLiveSDK);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorLiveStatusCallBack
        public void onAnchorLiveNetStatus(AnchorLiveSystemInfo anchorLiveSystemInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) anchorLiveSystemInfo);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomStream
        public void onScreenCaptureError(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str);
                return;
            }
            if (am.this.a0()) {
                am.this.R = false;
                QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
                qQLiveErrorMsg.bizModule = 2;
                qQLiveErrorMsg.bizErrCode = 6103;
                qQLiveErrorMsg.bizErrMsg = "screenCaptureError";
                qQLiveErrorMsg.originErrCode = i3;
                qQLiveErrorMsg.originErrMsg = str;
                am.this.z(qQLiveErrorMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomStream
        public void onScreenCapturePause(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                am.this.d0(i3);
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomStream
        public void onScreenCaptureStarted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (am.this.a0()) {
                am amVar = am.this;
                amVar.R = false;
                amVar.c0();
            }
            QQLiveContext c16 = QQLiveContext.INSTANCE.c(this.f270814e.getAppId());
            if (c16 != null) {
                ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(c16.n()).eventId(QQLiveReportConstants.Event.E_START_LIVE_SCREEN_CAPTURE_STARTED).ext6(QQLiveReportConstants.Scene.SCENE_START_QQ_LIVE).ext7(String.valueOf(System.currentTimeMillis())));
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPublish
        public void onStartPublishStream() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            am amVar = am.this;
            if (amVar.f270780e.streamRecordType != QQLiveAnchorStreamRecordType.THIRD_PUSH) {
                com.tencent.mobileqq.qqlive.anchor.report.a aVar = amVar.G;
                if (aVar != null) {
                    aVar.t();
                }
                QQLiveRoomParams.Builder streamId = new QQLiveRoomParams.Builder().setUserId(String.valueOf(am.this.f270781f.userDta.f271213id)).setRoomId(am.this.f270781f.roomData.f271212id).setRoleType(0).setScene(1).setUserSig(am.this.f270781f.trtcData.sig).setStreamId(am.this.f270781f.trtcData.streamInfo.mainStreamId);
                am amVar2 = am.this;
                QQLiveRoomParams build = streamId.setBussinessInfo(amVar2.T(amVar2.f270781f.trtcData.trtcStr)).build();
                int i3 = this.f270813d.audioVolumeEvaluation;
                if (i3 > 0) {
                    am.this.Q.p(i3);
                }
                am.this.Q.q(build);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b extends com.tencent.mobileqq.qqlive.anchor.room.helper.u {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) am.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.helper.u, com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onEnterRoom(long j3, String str) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str);
                return;
            }
            super.onEnterRoom(j3, str);
            com.tencent.mobileqq.qqlive.anchor.report.a aVar = am.this.G;
            if (aVar != null) {
                aVar.w(j3, str);
            }
            if (((BaseLiveRoom) am.this).liveSDK != null) {
                str2 = QQLiveContext.INSTANCE.c(((BaseLiveRoom) am.this).liveSDK.getAppId()).n();
            } else {
                str2 = null;
            }
            QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder();
            builder.traceId(str2).eventId(QQLiveReportConstants.Event.E_ANCHOR_PUBLISH_STREAM).roomId(String.valueOf(am.this.f270781f.roomData.f271212id));
            if (j3 < 0) {
                builder.retCode(String.valueOf(j3));
                am.this.e0((int) j3, str);
            } else {
                builder.retCode("0").cost(String.valueOf(j3));
            }
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(builder);
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.helper.u, com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onEvent(int i3, int i16, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bundle);
                return;
            }
            super.onEvent(i3, i16, str, bundle);
            am.this.f0(i3, i16, str);
            if (i3 != 1000) {
                return;
            }
            com.tencent.mobileqq.qqlive.anchor.report.a aVar = am.this.G;
            if (aVar != null) {
                aVar.x(i16, str);
            }
            am.this.e0(i16, str);
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.helper.u, com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onFirstLocalVideoFrameSent(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
                return;
            }
            super.onFirstLocalVideoFrameSent(i3);
            am amVar = am.this;
            ak akVar = amVar.f270782h;
            if (akVar != null) {
                akVar.onStateChange(amVar.f270783i, QQLiveAnchorRoomState.STATE_FIRST_FRAME_SENT);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.helper.u, com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onRemoteUserEnterRoom(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                return;
            }
            super.onRemoteUserEnterRoom(str);
            ak akVar = am.this.f270782h;
            if (akVar != null) {
                akVar.onRemoteUserEnterRoom(str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.helper.u, com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onRemoteUserLeaveRoom(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
                return;
            }
            super.onRemoteUserLeaveRoom(str, i3);
            ak akVar = am.this.f270782h;
            if (akVar != null) {
                akVar.onRemoteUserLeaveRoom(str, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c implements com.tencent.mobileqq.qqlive.trtc.video.source.screen.d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) am.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.d
        public void a(StatisticData statisticData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) statisticData);
                return;
            }
            com.tencent.mobileqq.qqlive.anchor.report.a aVar = am.this.G;
            if (aVar != null) {
                aVar.v(statisticData);
            }
            am amVar = am.this;
            if (amVar.f270782h != null && amVar.S != null) {
                am.this.S.d(statisticData.upLoss);
                am amVar2 = am.this;
                ak akVar = amVar2.f270782h;
                float b16 = amVar2.S.b(statisticData.sendBytes);
                float f16 = statisticData.rtt;
                int i3 = statisticData.upLoss;
                int i16 = statisticData.appCpu;
                int a16 = am.this.S.a();
                MemoryUtil memoryUtil = MemoryUtil.f258173a;
                akVar.onAnchorLiveNetStatus(new AnchorLiveSystemInfo(b16, f16, i3, i16, a16, (memoryUtil.f() * 100) / memoryUtil.h()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class d implements ITRTCRemoteListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) am.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public /* synthetic */ void onConnectOtherRoom(String str, int i3, String str2) {
            com.tencent.mobileqq.qqlive.listener.trtc.a.a(this, str, i3, str2);
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public /* synthetic */ void onDisConnectOtherRoom(int i3, String str) {
            com.tencent.mobileqq.qqlive.listener.trtc.a.b(this, i3, str);
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public /* synthetic */ void onFirstAudioFrame(String str) {
            com.tencent.mobileqq.qqlive.listener.trtc.a.c(this, str);
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public /* synthetic */ void onFirstVideoFrame(String str, int i3, int i16, int i17) {
            com.tencent.mobileqq.qqlive.listener.trtc.a.d(this, str, i3, i16, i17);
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onNetworkQuality(QQLiveQuality qQLiveQuality, ArrayList<QQLiveQuality> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) qQLiveQuality, (Object) arrayList);
            } else if (am.this.S != null) {
                am.this.S.e(qQLiveQuality.quality);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onUserAudioAvailable(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onUserSei(String str, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) bArr);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onUserVideoAvailable(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onUserVoiceVolume(ArrayList<RemoteUserAudioInfo> arrayList, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class e implements QQLiveAnchorHelperTRTC.d {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) am.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperTRTC.d
        public void a(QQLiveErrorMsg qQLiveErrorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveErrorMsg);
            } else {
                am.this.z(qQLiveErrorMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperTRTC.d
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                am.this.B();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58163);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 58)) {
            redirector.redirect((short) 58);
        } else {
            U = new String[]{SLAReporter.PERMISSION_NET, "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.MODIFY_AUDIO_SETTINGS", "android.permission.BLUETOOTH", QQPermissionConstants.Permission.CAMERA};
        }
    }

    public am(@NonNull Context context, @NonNull IQQLiveSDK iQQLiveSDK, @NonNull QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig, IQQLiveAnchorRoomCallback iQQLiveAnchorRoomCallback) {
        super(context, iQQLiveSDK, qQLiveAnchorRoomConfig, iQQLiveAnchorRoomCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, iQQLiveSDK, qQLiveAnchorRoomConfig, iQQLiveAnchorRoomCallback);
            return;
        }
        this.Q = new QQLiveAnchorHelperTRTC();
        this.R = false;
        this.T = false;
        this.P = new FrameLayout(this.f270779d);
        this.S = new com.tencent.mobileqq.qqlive.anchor.viewmodel.a();
        this.f270782h.registerAnchorCallback(new a(qQLiveAnchorRoomConfig, iQQLiveSDK));
        this.Q.P(this.f270782h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String T(String str) {
        return String.format("{\"Str_uc_params\":{\"userdefine_push_args\":\"%s\"}}", str);
    }

    private void W() {
        if (this.isDestroy) {
            return;
        }
        this.Q.t(this.f270779d, this.liveSDK, new e());
    }

    private void X() {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.j(new b());
            this.Q.O(new c());
            this.Q.addRemoteListener(new d());
        }
    }

    private boolean Y() {
        QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig = this.f270780e;
        if (qQLiveAnchorRoomConfig != null && qQLiveAnchorRoomConfig.streamRecordType == QQLiveAnchorStreamRecordType.CAMERA) {
            return true;
        }
        return false;
    }

    private boolean Z() {
        QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig = this.f270780e;
        if (qQLiveAnchorRoomConfig != null && qQLiveAnchorRoomConfig.streamRecordType == QQLiveAnchorStreamRecordType.SCREEN) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a0() {
        if (this.isExitRoom || this.isDestroy || !this.T || this.isInited || !this.R) {
            return false;
        }
        return true;
    }

    private void b0(QQLiveErrorMsg qQLiveErrorMsg) {
        this.f270782h.onInit(new QQLiveAnchorDataInit(false, qQLiveErrorMsg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        this.isInited = true;
        this.T = false;
        this.f270782h.onInit(new QQLiveAnchorDataInit(true, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(int i3) {
        if (this.f270782h != null) {
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = 6107;
            qQLiveErrorMsg.bizErrMsg = "screen capture source error";
            qQLiveErrorMsg.originErrCode = i3;
            qQLiveErrorMsg.originErrMsg = "";
            this.f270782h.onError(qQLiveErrorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(int i3, String str) {
        if (this.f270782h != null) {
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = 6106;
            qQLiveErrorMsg.bizErrMsg = "trtc error";
            qQLiveErrorMsg.originErrCode = i3;
            qQLiveErrorMsg.originErrMsg = str;
            this.f270782h.onError(qQLiveErrorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(int i3, int i16, String str) {
        if (this.f270782h != null) {
            QQLiveEventMsg qQLiveEventMsg = new QQLiveEventMsg();
            qQLiveEventMsg.eventId = i3;
            qQLiveEventMsg.errorCode = i16;
            qQLiveEventMsg.message = str;
            this.f270782h.onEvent(qQLiveEventMsg);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom
    protected void B() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (!this.isDestroy && this.f270783i == QQLiveAnchorRoomState.STATE_INIT_ING && !this.isInited) {
            synchronized (this) {
                if (!this.isInited && this.C.f270870a && this.Q.f270851e) {
                    t(QQLiveAnchorRoomState.STATE_INIT_READY);
                    if (this.f270780e.streamRecordType == QQLiveAnchorStreamRecordType.SCREEN) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.R = z16;
                    X();
                    g0();
                    if (!this.R) {
                        c0();
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public FrameLayout getDisplayView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        if (this.isDestroy) {
            return null;
        }
        return this.P;
    }

    public void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            if (this.isDestroy) {
                return;
            }
            Y();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void addRemoteListener(ITRTCRemoteListener iTRTCRemoteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) iTRTCRemoteListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.Q.addRemoteListener(iTRTCRemoteListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorStreamQuality
    public void changeOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, i3);
            return;
        }
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            qQLiveAnchorHelperTRTC.k(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorStreamControl
    public void closeMixTranscoding() {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.m();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void connectRemote(long j3, long j16) {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, Long.valueOf(j3), Long.valueOf(j16));
        } else if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.connectRemote(j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl
    public IRTCMusicAccompany createMusicAccompany() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (IRTCMusicAccompany) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            return qQLiveAnchorHelperTRTC.n();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.destroy();
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            qQLiveAnchorHelperTRTC.o();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void disconnectRemote() {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
        } else if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.disconnectRemote();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl
    public void enableAudioVolumeEvaluation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
        } else {
            this.Q.p(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public void exitRoom(ExitRoomCallback exitRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) exitRoomCallback);
            return;
        }
        super.exitRoom(exitRoomCallback);
        this.Q.r();
        this.Q.P(null);
        this.Q.O(null);
        this.Q.l();
        QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType = this.f270780e.streamRecordType;
        if (qQLiveAnchorStreamRecordType == QQLiveAnchorStreamRecordType.CAMERA) {
            this.Q.W();
        } else if (qQLiveAnchorStreamRecordType == QQLiveAnchorStreamRecordType.SCREEN) {
            this.Q.X();
        }
        this.Q.V();
        this.Q.E(false);
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public void fastResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            if (this.isDestroy) {
                return;
            }
            super.fastResume();
            this.F.g(this, this.f270782h);
        }
    }

    public void g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f270780e.streamRecordType == QQLiveAnchorStreamRecordType.CAMERA) {
            startCameraPreview();
            QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig = this.f270780e;
            if (qQLiveAnchorRoomConfig.openAudio) {
                if (qQLiveAnchorRoomConfig.enableVolumeEvaluation) {
                    enableAudioVolumeEvaluation(300);
                }
                startAudioRecord();
            }
        }
        if (this.f270780e.streamRecordType == QQLiveAnchorStreamRecordType.SCREEN) {
            startScreenCapturePreview();
            QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig2 = this.f270780e;
            if (qQLiveAnchorRoomConfig2.openAudio) {
                if (qQLiveAnchorRoomConfig2.enableVolumeEvaluation) {
                    enableAudioVolumeEvaluation(300);
                }
                startAudioRecord();
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public int getAudioPlayOutVolume() {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Integer) iPatchRedirector.redirect((short) 48, (Object) this)).intValue();
        }
        if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            return qQLiveAnchorHelperTRTC.getAudioPlayOutVolume();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorStreamQuality
    public List<Pair<Long, Integer>> getUpLossRecordList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (List) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        com.tencent.mobileqq.qqlive.anchor.viewmodel.a aVar = this.S;
        if (aVar == null) {
            return new ArrayList();
        }
        return aVar.c();
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorStreamQuality
    public TRTCVideoQualityParams getVideoQuality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (TRTCVideoQualityParams) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            return qQLiveAnchorHelperTRTC.s();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iQQLiveSDK);
            return;
        }
        if (this.isDestroy) {
            return;
        }
        if (this.isInited) {
            c0();
            return;
        }
        this.T = true;
        super.init(iQQLiveSDK);
        if (this.J) {
            W();
            V();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.camera.IQQLiveModuleCamera
    public boolean isCameraMirror() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (this.isDestroy) {
            return false;
        }
        return this.Q.u();
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl
    public boolean isMicEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            return qQLiveAnchorHelperTRTC.w();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl
    public boolean isMicMuteEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            return qQLiveAnchorHelperTRTC.x();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom
    public boolean isOutputMute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void muteAllRemoteAudio(boolean z16) {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, z16);
        } else if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.muteAllRemoteAudio(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl
    public void muteLocalAudio(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, z16);
            return;
        }
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            qQLiveAnchorHelperTRTC.E(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void muteRemoteAudio(String str, boolean z16) {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, str, Boolean.valueOf(z16));
        } else if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.muteRemoteAudio(str, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorStreamControl
    public void openMixTranscoding(@NonNull QQLiveTranscodingConfig qQLiveTranscodingConfig) {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) qQLiveTranscodingConfig);
        } else if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.F(qQLiveTranscodingConfig);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorStreamControl
    public void pausePublishStream(Bitmap bitmap, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, bitmap, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            qQLiveAnchorHelperTRTC.G(bitmap, i3, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public void prepare(Activity activity, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) bArr);
        } else {
            super.prepare(activity, bArr);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void removeRemoteListener(ITRTCRemoteListener iTRTCRemoteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) iTRTCRemoteListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.Q.removeRemoteListener(iTRTCRemoteListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorStreamControl
    public void resumePublishStream(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
            return;
        }
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            qQLiveAnchorHelperTRTC.H(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public boolean sendSEIMsg(byte[] bArr, int i3) {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this, (Object) bArr, i3)).booleanValue();
        }
        if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            return qQLiveAnchorHelperTRTC.sendSEIMsg(bArr, i3);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void setAudioPlayOutVolume(int i3) {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, i3);
        } else if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.setAudioPlayOutVolume(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl
    public void setAudioVolume(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
            return;
        }
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            qQLiveAnchorHelperTRTC.J(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.camera.IQQLiveModuleCamera
    public void setCameraMirror(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.Q.L(this.f270780e, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom
    public void setMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorStreamQuality
    public void setNetworkQosPreferenceParam(com.tencent.mobileqq.qqlive.trtc.encoder.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) aVar);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.Q.M(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void setRemoteAudioVolume(String str, int i3) {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) str, i3);
        } else if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.setRemoteAudioVolume(str, i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void setRemoteVideoParam(String str, QQLiveRenderParams qQLiveRenderParams) {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) str, (Object) qQLiveRenderParams);
        } else if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.setRemoteVideoParam(str, qQLiveRenderParams);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl
    public void setVideoPreProcess(@Nullable com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) aVar);
            return;
        }
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            qQLiveAnchorHelperTRTC.Q(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorStreamQuality
    public void setVideoQuality(TRTCVideoQualityParams tRTCVideoQualityParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) tRTCVideoQualityParams);
            return;
        }
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            qQLiveAnchorHelperTRTC.R(tRTCVideoQualityParams);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl
    public void startAudioRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            qQLiveAnchorHelperTRTC.S();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl
    public void startCameraPreview() {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (!Y()) {
            return;
        }
        QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig = this.f270780e;
        if (qQLiveAnchorRoomConfig.streamRecordType == QQLiveAnchorStreamRecordType.CAMERA && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.T(qQLiveAnchorRoomConfig, this.P);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void startRemoteVideo(String str, ViewGroup viewGroup) {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) str, (Object) viewGroup);
        } else if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.startRemoteVideo(str, viewGroup);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void startRemoteView(String str, FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) str, (Object) frameLayout);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.Q.startRemoteView(str, frameLayout);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl
    public void startScreenCapturePreview() {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else if (Z() && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.U();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void stopAllRemoteVideo() {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this);
        } else if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.stopAllRemoteVideo();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl
    public void stopAudioRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            qQLiveAnchorHelperTRTC.V();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl
    public void stopCameraPreview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        if (!Y() || this.f270780e.streamRecordType != QQLiveAnchorStreamRecordType.CAMERA) {
            return;
        }
        FrameLayout frameLayout = this.P;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC = this.Q;
        if (qQLiveAnchorHelperTRTC != null) {
            qQLiveAnchorHelperTRTC.W();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void stopRemoteVideo(String str) {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) str);
        } else if (!this.isDestroy && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.stopRemoteVideo(str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void stopRemoteView(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) str);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.Q.stopRemoteView(str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl
    public void stopScreenCapturePreview() {
        QQLiveAnchorHelperTRTC qQLiveAnchorHelperTRTC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else if (Z() && (qQLiveAnchorHelperTRTC = this.Q) != null) {
            qQLiveAnchorHelperTRTC.X();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.camera.IQQLiveModuleCamera
    public void switchAnchorCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.Q.Y(this.f270780e);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom
    protected String[] x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return U;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom
    public void z(QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQLiveErrorMsg);
            return;
        }
        super.z(qQLiveErrorMsg);
        this.T = false;
        b0(qQLiveErrorMsg);
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.camera.IQQLiveModuleCamera
    public boolean isCameraMirror(RTCCameraDefine.RTCMirrorType rTCMirrorType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) rTCMirrorType)).booleanValue();
        }
        if (this.isDestroy) {
            return false;
        }
        return this.Q.v(rTCMirrorType);
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.camera.IQQLiveModuleCamera
    public void setCameraMirror(RTCCameraDefine.RTCMirrorType rTCMirrorType, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, rTCMirrorType, Boolean.valueOf(z16));
        } else {
            if (this.isDestroy) {
                return;
            }
            this.Q.K(this.f270780e, rTCMirrorType, z16);
        }
    }
}
