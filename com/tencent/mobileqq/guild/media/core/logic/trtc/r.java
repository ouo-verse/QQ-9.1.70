package com.tencent.mobileqq.guild.media.core.logic.trtc;

import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi;
import com.tencent.mobileqq.guild.media.core.logic.EnterTrtcRoomReq;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import kotlin.jvm.functions.Function2;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes14.dex */
public class r extends t {

    /* renamed from: x, reason: collision with root package name */
    public static Intent f228571x;

    /* renamed from: s, reason: collision with root package name */
    private IGuildTRTCFocusApi.b f228573s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f228574t;

    /* renamed from: u, reason: collision with root package name */
    private MediaProjection f228575u;

    /* renamed from: r, reason: collision with root package name */
    private final ArrayMap<String, it1.e> f228572r = new ArrayMap<>();

    /* renamed from: v, reason: collision with root package name */
    private final MediaProjection.Callback f228576v = new a();

    /* renamed from: w, reason: collision with root package name */
    private final Handler f228577w = ThreadManagerV2.getUIHandlerV2();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends MediaProjection.Callback {
        a() {
        }

        @Override // android.media.projection.MediaProjection.Callback
        public void onStop() {
            super.onStop();
            QLog.d("QGMC.MediaMainTRTCRoom", 1, "mediaProjection onStop " + r.this.f228574t);
            if (r.this.f228574t) {
                r.this.o();
                QQToast.makeText(BaseApplication.context, 0, HardCodeUtil.qqStr(R.string.f1498413d), 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r() {
        this.sTAG = "QGMC.MediaMainTRTCRoom";
        this.mEnableTRTCPublish = true;
    }

    private void i0() {
        MediaProjection mediaProjection = this.f228575u;
        if (mediaProjection != null) {
            mediaProjection.unregisterCallback(this.f228576v);
        }
        this.f228575u = null;
    }

    private void j0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DTConstants.TAG.API, "setScreenCaptureAutoRotateEnabled");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("enable", true);
            jSONObject.put("params", jSONObject2);
            this.mTRTCCloud.callExperimentalAPI(jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private String k0() {
        TRTCCloudDef.TRTCParams tRTCParams = this.mTRTCParams;
        if (tRTCParams != null) {
            return String.valueOf(tRTCParams.roomId);
        }
        return "";
    }

    private void l0(final int i3) {
        if (this.mTRTCParams == null) {
            QLog.e("QGMC.MediaMainTRTCRoom", 1, "mTRTCParams is null.");
        } else {
            this.f228573s = new IGuildTRTCFocusApi.b() { // from class: com.tencent.mobileqq.guild.media.core.logic.trtc.o
                @Override // com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi.b
                public final void a(boolean z16) {
                    r.this.m0(i3, z16);
                }
            };
            ((IGuildTRTCFocusApi) QRoute.api(IGuildTRTCFocusApi.class)).requestTRTCFocus(this, this.f228573s, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(int i3, boolean z16) {
        QLog.i("QGMC.MediaMainTRTCRoom", 1, "onGetFocusResult enterRoom start. is success:" + z16);
        this.mTRTCCloud.setListener(this);
        M(600);
        this.mTRTCCloud.enterRoom(this.mTRTCParams, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(String str, Integer num, Integer num2) {
        ITRTCAudioRoom.b bVar = this.mListener;
        if (bVar != null) {
            bVar.h(k0(), S(), str, num.intValue(), num2.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void o0(final String str, final Integer num, final Integer num2) {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.trtc.q
            @Override // java.lang.Runnable
            public final void run() {
                r.this.n0(str, num, num2);
            }
        });
        return null;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.t, com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void A() {
        try {
            a0();
            QLog.i("QGMC.MediaMainTRTCRoom", 1, "startScreenShare");
            TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
            tRTCVideoEncParam.videoResolution = 112;
            tRTCVideoEncParam.videoResolutionMode = 1;
            tRTCVideoEncParam.videoFps = 20;
            tRTCVideoEncParam.enableAdjustRes = false;
            tRTCVideoEncParam.videoBitrate = 1500;
            this.mTRTCCloud.setVideoEncoderParam(tRTCVideoEncParam);
            TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams = new TRTCCloudDef.TRTCScreenShareParams();
            i0();
            MediaProjection mediaProjection = ((MediaProjectionManager) MobileQQ.sMobileQQ.getApplicationContext().getSystemService("media_projection")).getMediaProjection(-1, f228571x);
            this.f228575u = mediaProjection;
            mediaProjection.registerCallback(this.f228576v, this.f228577w);
            tRTCScreenShareParams.mediaProjection = this.f228575u;
            this.mTRTCCloud.startScreenCapture(tRTCVideoEncParam, tRTCScreenShareParams);
            j0();
            this.f228574t = true;
        } catch (Exception e16) {
            QLog.e("QGMC.MediaMainTRTCRoom", 1, "startScreenShare error" + e16.getMessage());
            QQToast.makeText(BaseApplication.context, "\u6253\u5f00\u5c4f\u5e55\u5206\u4eab\u5931\u8d25", 0).show();
            o();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.t, com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void I(ITRTCAudioRoom.a aVar) {
        ITRTCAudioRoom.a aVar2;
        QLog.i("QGMC.MediaMainTRTCRoom", 1, "exit room.");
        this.mUserId = null;
        this.mTRTCParams = null;
        this.mEnterRoomCallback = null;
        this.mExitRoomCallback = aVar;
        this.mMainHandler.removeCallbacksAndMessages(null);
        if (W()) {
            this.mTRTCCloud.setDefaultStreamRecvMode(true, true);
            this.mTRTCCloud.exitRoom();
            this.mTRTCCloud.stopLocalAudio();
        }
        if (!this.mIsInRoom && (aVar2 = this.mExitRoomCallback) != null) {
            aVar2.onCallback(-1, "current is not in room.");
            this.mExitRoomCallback = null;
        }
        ((IGuildTRTCFocusApi) QRoute.api(IGuildTRTCFocusApi.class)).onReleaseTRTCFocus(this);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.t
    @NonNull
    public String R() {
        String k06 = k0();
        if (TextUtils.isEmpty(k06)) {
            return com.tencent.mobileqq.guild.media.core.j.a().E();
        }
        return k06;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.t
    public int S() {
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom, com.tencent.mobileqq.guild.media.core.logic.trtc.d
    public void a() {
        QLog.i("QGMC.MediaMainTRTCRoom", 1, "stopMicrophone.");
        if (com.tencent.mobileqq.guild.media.core.j.a().H0().C()) {
            this.mTRTCCloud.setAudioCaptureVolume(0);
            this.mTRTCCloud.muteLocalAudio(false);
            QLog.i("QGMC.MediaMainTRTCRoom", 1, "stopMicrophone, is open video, setAudioCaptureVolume 0.");
        } else {
            this.mTRTCCloud.muteLocalAudio(true);
            b0();
        }
        this.mMicEnable = false;
        onUserAudioAvailable(this.mUserId, false);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.t, com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void e(String str) {
        it1.e remove = this.f228572r.remove(str);
        if (remove != null) {
            remove.destroy();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.t, com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void k(@NonNull EnterTrtcRoomReq enterTrtcRoomReq, ITRTCAudioRoom.a aVar) {
        if (enterTrtcRoomReq.getSdkAppId() != 0 && !TextUtils.isEmpty(enterTrtcRoomReq.getRoomId()) && !TextUtils.isEmpty(enterTrtcRoomReq.getUserId()) && !TextUtils.isEmpty(enterTrtcRoomReq.getUserSign())) {
            this.mPrivateMapKey = enterTrtcRoomReq.getPrivateMapKey();
            this.mUserId = enterTrtcRoomReq.getUserId();
            this.mEnterRoomCallback = aVar;
            QLog.i("QGMC.MediaMainTRTCRoom", 1, "enter room, app id:" + enterTrtcRoomReq.getSdkAppId() + " room id:" + enterTrtcRoomReq.getRoomId() + " user id:" + enterTrtcRoomReq.getUserId() + " sign:" + enterTrtcRoomReq.getUserSign() + " autoRecv:" + enterTrtcRoomReq.getAutoReceiveAV());
            TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
            this.mTRTCParams = tRTCParams;
            tRTCParams.sdkAppId = enterTrtcRoomReq.getSdkAppId();
            this.mTRTCParams.privateMapKey = enterTrtcRoomReq.getPrivateMapKey();
            this.mTRTCParams.userId = enterTrtcRoomReq.getUserId();
            this.mTRTCParams.userSig = enterTrtcRoomReq.getUserSign();
            this.mTRTCParams.role = enterTrtcRoomReq.getRole();
            this.mTRTCParams.roomId = Integer.parseInt(enterTrtcRoomReq.getRoomId());
            this.mTRTCCloud.setDefaultStreamRecvMode(enterTrtcRoomReq.getAutoReceiveAV(), enterTrtcRoomReq.getAutoReceiveAV());
            l0(enterTrtcRoomReq.getAppScene());
            return;
        }
        QLog.e("QGMC.MediaMainTRTCRoom", 1, "enter trtc room fail. params invalid. room id:" + enterTrtcRoomReq.getRoomId() + " user id:" + enterTrtcRoomReq.getUserId() + " sign is empty:" + TextUtils.isEmpty(enterTrtcRoomReq.getUserSign()));
        if (aVar != null) {
            aVar.onCallback(-1, "enter trtc room fail. params invalid. room id:" + enterTrtcRoomReq.getRoomId() + " user id:" + enterTrtcRoomReq.getUserId() + " sign is empty:" + TextUtils.isEmpty(enterTrtcRoomReq.getUserSign()));
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.t, com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void o() {
        QLog.i("QGMC.MediaMainTRTCRoom", 1, "stopScreenShare");
        this.f228574t = false;
        this.mTRTCCloud.stopScreenCapture();
        i0();
        ITRTCAudioRoom.b bVar = this.mListener;
        if (bVar != null) {
            bVar.f(R(), S(), this.mUserId, false);
        }
        if (!this.mMicEnable) {
            b0();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.t, com.tencent.trtc.TRTCCloudListener
    public void onEnterRoom(long j3) {
        QLog.i("QGMC.MediaMainTRTCRoom", 1, "on enter room, tid:" + Thread.currentThread().getId());
        super.onEnterRoom(j3);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onExitRoom(int i3) {
        String str;
        QLog.i("QGMC.MediaMainTRTCRoom", 1, "on exit room. code:" + i3);
        this.mIsInRoom = false;
        ITRTCAudioRoom.a aVar = this.mExitRoomCallback;
        if (aVar != null) {
            aVar.onCallback(0, "exit room success.");
            this.mExitRoomCallback = null;
        }
        if (this.mEnterRoomCallback != null) {
            return;
        }
        ITRTCAudioRoom.b bVar = this.mListener;
        if (bVar != null) {
            if (i3 == 0) {
                str = "\u4e3b\u52a8\u8c03\u7528 exitRoom \u9000\u623f";
            } else if (i3 == 1) {
                str = "\u88ab\u670d\u52a1\u5668\u8e22\u51fa\u5f53\u524d\u623f\u95f4";
            } else if (i3 == 2) {
                str = "\u5f53\u524d\u623f\u95f4\u6574\u4e2a\u88ab\u89e3\u6563";
            } else {
                str = "";
            }
            bVar.d(R(), S(), i3, str);
        }
        ((IGuildTRTCFocusApi) QRoute.api(IGuildTRTCFocusApi.class)).onReleaseTRTCFocus(this);
        this.mTRTCCloud.stopLocalAudio();
        this.isMicReady = false;
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onScreenCaptureStarted() {
        super.onScreenCaptureStarted();
        QLog.i("QGMC.MediaMainTRTCRoom", 1, "onScreenCaptureStarted ");
        ITRTCAudioRoom.b bVar = this.mListener;
        if (bVar != null) {
            bVar.f(R(), S(), this.mUserId, true);
        }
        com.tencent.mobileqq.guild.media.core.j.a().W().h(true, true);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVideoAvailable(String str, boolean z16) {
        super.onUserVideoAvailable(str, z16);
        QLog.d("QGMC.MediaMainTRTCRoom", 4, "onUserVideoAvailable" + str + " available " + z16);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z16) {
            this.mTRTCCloud.startRemoteView(str, 0, null);
            com.tencent.mobileqq.guild.media.core.j.a().W().c();
        } else {
            this.mTRTCCloud.stopRemoteView(str, 0);
            com.tencent.mobileqq.guild.media.core.j.a().W().f();
        }
        ITRTCAudioRoom.b bVar = this.mListener;
        if (bVar != null) {
            bVar.f(R(), S(), str, z16);
        }
    }

    public void p0(Intent intent) {
        QLog.d("QGMC.MediaMainTRTCRoom", 1, "setCaptureIntent ");
        f228571x = intent;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.t, com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void w(final String str, Surface surface) {
        if (!this.f228572r.containsKey(str)) {
            this.f228572r.put(str, new it1.i(this.mTRTCCloud, str, surface, new Function2() { // from class: com.tencent.mobileqq.guild.media.core.logic.trtc.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Void o06;
                    o06 = r.this.o0(str, (Integer) obj, (Integer) obj2);
                    return o06;
                }
            }));
        }
        this.f228572r.get(str).init();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.t, com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void y(Context context) {
        com.tencent.mobileqq.guild.media.core.w.b("QGMC.MediaMainTRTCRoom", "requireTrtcInstance");
        this.mTRTCCloud = TRTCCloud.sharedInstance(context);
        this.mAudioQualityAdapter = new v(this.mTRTCCloud);
        TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam = new TRTCCloudDef.TRTCNetworkQosParam();
        tRTCNetworkQosParam.preference = 1;
        this.mTRTCCloud.setNetworkQosParam(tRTCNetworkQosParam);
        com.tencent.mobileqq.guild.media.core.w.a("QGMC.MediaMainTRTCRoom", "requireTrtcInstance");
    }
}
