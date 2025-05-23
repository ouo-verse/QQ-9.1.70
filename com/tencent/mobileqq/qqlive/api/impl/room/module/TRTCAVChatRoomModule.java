package com.tencent.mobileqq.qqlive.api.impl.room.module;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.av.AVChatRoomListener;
import com.tencent.mobileqq.qqlive.api.av.IAVChatAbility;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfig;
import com.tencent.mobileqq.qqlive.api.impl.room.common.AVChatStreamPublisher;
import com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveQuality;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRenderParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.data.trtc.RTCCameraDefine;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener;
import com.tencent.mobileqq.qqlive.listener.trtc.RemoteUserAudioInfo;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes17.dex */
public class TRTCAVChatRoomModule implements IAVChatAbility {
    static IPatchRedirector $redirector_ = null;
    private static final int DefaultAudioQuality = 2;
    private static final int DefaultBitrate = 400;
    private static final int DefaultFps = 15;
    private static final int DefaultMinBitrate = 320;
    private static final int DefaultResolution = 0;
    private static final int ImageFps = 10;
    private static final String TAG = "TRTCAVChatRoomModule";
    private static final int VolumeDuration = 200;
    private final IAegisLogApi aegisLogger;
    private long anchorUserId;
    private com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a beautyProcess;
    private final com.tencent.mobileqq.qqlive.trtc.b engineProxy;
    private boolean isExitTRTCRoom;
    private boolean isInitTRTCEngine;
    private boolean isPublish;
    private final IQQLiveSDK liveSDK;
    private LiveMediaConfig mediaConfig;
    private AVChatStreamPublisher protocolPublisher;
    private final BaseRoomInfo roomInfo;
    private final List<AVChatRoomListener> roomListeners;
    private QQLiveRoomParams roomParams;
    private final ITRTCRemoteListener tRtcRemoteListener;
    private final ITRTCRoomListener tRtcRoomListener;

    public TRTCAVChatRoomModule(IQQLiveSDK iQQLiveSDK, BaseRoomInfo baseRoomInfo, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, iQQLiveSDK, baseRoomInfo, Long.valueOf(j3));
            return;
        }
        this.aegisLogger = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.engineProxy = com.tencent.mobileqq.qqlive.trtc.b.r();
        this.roomListeners = new CopyOnWriteArrayList();
        this.protocolPublisher = null;
        this.anchorUserId = 0L;
        this.roomParams = new QQLiveRoomParams.Builder().build();
        this.isInitTRTCEngine = false;
        this.isExitTRTCRoom = false;
        this.isPublish = false;
        this.mediaConfig = getDefaultMediaConfig();
        this.beautyProcess = null;
        this.tRtcRoomListener = new ITRTCRoomListener() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.module.TRTCAVChatRoomModule.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TRTCAVChatRoomModule.this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
            public void onEnterRoom(long j16, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Long.valueOf(j16), str);
                    return;
                }
                TRTCAVChatRoomModule.this.logI("onEnterRoom code:" + j16 + " msg:" + str);
                if (j16 < 0) {
                    TRTCAVChatRoomModule.this.logI("TRTC\u8fdb\u623f\u5931\u8d25, uid:" + TRTCAVChatRoomModule.this.roomParams.getUserId() + " \u623f\u95f4ID:" + TRTCAVChatRoomModule.this.roomParams.getRoomId() + " \u9519\u8bef\u7801:" + j16 + " \u9519\u8bef\u63cf\u8ff0:" + str);
                } else {
                    TRTCAVChatRoomModule.this.logI("TRTC\u8fdb\u623f\u6210\u529f, uid:" + TRTCAVChatRoomModule.this.roomParams.getUserId() + " \u623f\u95f4ID:" + TRTCAVChatRoomModule.this.roomParams.getRoomId());
                }
                Iterator it = TRTCAVChatRoomModule.this.roomListeners.iterator();
                while (it.hasNext()) {
                    ((AVChatRoomListener) it.next()).onEnterRoom(j16, str);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
            public void onEvent(int i3, int i16, String str, Bundle bundle) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 9)) {
                    iPatchRedirector2.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bundle);
                    return;
                }
                TRTCAVChatRoomModule.this.logI("onEvent eventId:" + i3 + " code:" + i16 + " msg:" + str);
                Iterator it = TRTCAVChatRoomModule.this.roomListeners.iterator();
                while (it.hasNext()) {
                    ((AVChatRoomListener) it.next()).onEvent(i3, i16, str);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
            public void onExitRoom(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, i3);
                    return;
                }
                TRTCAVChatRoomModule.this.logI("onExitRoom reason:" + i3);
                Iterator it = TRTCAVChatRoomModule.this.roomListeners.iterator();
                while (it.hasNext()) {
                    ((AVChatRoomListener) it.next()).onExitRoom(i3);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
            public void onFirstLocalAudioFrameSent() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 8)) {
                    TRTCAVChatRoomModule.this.logI("onFirstLocalAudioFrameSent");
                } else {
                    iPatchRedirector2.redirect((short) 8, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
            public void onFirstLocalVideoFrameSent(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, (Object) this, i3);
                    return;
                }
                TRTCAVChatRoomModule.this.logI("onFirstLocalVideoFrameSent streamType:" + i3);
            }

            @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
            public void onRemoteUserEnterRoom(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) str);
                    return;
                }
                TRTCAVChatRoomModule.this.logI("onRemoteUserEnterRoom remoteUserId:" + str);
            }

            @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
            public void onRemoteUserLeaveRoom(String str, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this, (Object) str, i3);
                    return;
                }
                TRTCAVChatRoomModule.this.logI("onRemoteUserLeaveRoom remoteUserId:" + str + " reason:" + i3);
            }

            @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
            public void onSwitchRoom(int i3, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, i3, (Object) str);
                    return;
                }
                TRTCAVChatRoomModule.this.logI("onSwitchRoom errCode:" + i3 + " message:" + str);
            }
        };
        this.tRtcRemoteListener = new ITRTCRemoteListener() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.module.TRTCAVChatRoomModule.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TRTCAVChatRoomModule.this);
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
            public /* synthetic */ void onNetworkQuality(QQLiveQuality qQLiveQuality, ArrayList arrayList) {
                com.tencent.mobileqq.qqlive.listener.trtc.a.e(this, qQLiveQuality, arrayList);
            }

            @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
            public void onUserAudioAvailable(String str, boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, str, Boolean.valueOf(z16));
                    return;
                }
                TRTCAVChatRoomModule.this.logI("onUserAudioAvailable uid:" + str + " available:" + z16);
                Iterator it = TRTCAVChatRoomModule.this.roomListeners.iterator();
                while (it.hasNext()) {
                    ((AVChatRoomListener) it.next()).onUserAudioAvailable(str, z16);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
            public void onUserSei(String str, byte[] bArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) str, (Object) bArr);
                    return;
                }
                Iterator it = TRTCAVChatRoomModule.this.roomListeners.iterator();
                while (it.hasNext()) {
                    ((AVChatRoomListener) it.next()).onUserSei(str, bArr);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
            public void onUserVideoAvailable(String str, boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, str, Boolean.valueOf(z16));
                    return;
                }
                TRTCAVChatRoomModule.this.logI("onUserVideoAvailable uid:" + str + " available:" + z16);
                Iterator it = TRTCAVChatRoomModule.this.roomListeners.iterator();
                while (it.hasNext()) {
                    ((AVChatRoomListener) it.next()).onUserVideoAvailable(str, z16);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
            public void onUserVoiceVolume(ArrayList<RemoteUserAudioInfo> arrayList, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) arrayList, i3);
                    return;
                }
                Iterator it = TRTCAVChatRoomModule.this.roomListeners.iterator();
                while (it.hasNext()) {
                    ((AVChatRoomListener) it.next()).onUserVoiceVolume(arrayList, i3);
                }
            }
        };
        this.liveSDK = iQQLiveSDK;
        this.roomInfo = baseRoomInfo;
        this.anchorUserId = j3;
    }

    private void doEnterTRTCRoom() {
        this.engineProxy.K(this.tRtcRoomListener);
        this.engineProxy.b(this.tRtcRoomListener);
        this.engineProxy.Y(this.tRtcRemoteListener);
        this.engineProxy.l(this.roomParams);
        this.engineProxy.j(200);
    }

    private LiveMediaConfig getDefaultMediaConfig() {
        return new LiveMediaConfig(0, 15, 400, 320);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enterTRTCRoom$0(int i3, int i16) {
        if (i3 == 2) {
            onInitSuccess();
            doEnterTRTCRoom();
            return;
        }
        onInitFailure(i16, "init engine fail! state:" + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String str) {
        this.aegisLogger.e(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String str) {
        this.aegisLogger.i(TAG, str);
    }

    private void onInitFailure(long j3, String str) {
        this.isInitTRTCEngine = false;
        logE("onInitFailure error:" + j3 + " msg:" + str);
        Iterator<AVChatRoomListener> it = this.roomListeners.iterator();
        while (it.hasNext()) {
            it.next().onInitRoom(j3, str);
        }
    }

    private void onInitSuccess() {
        logI("onInitSuccess");
        this.isInitTRTCEngine = true;
        Iterator<AVChatRoomListener> it = this.roomListeners.iterator();
        while (it.hasNext()) {
            it.next().onInitRoom(0L, "");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void addAVChatRoomListener(AVChatRoomListener aVChatRoomListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVChatRoomListener);
            return;
        }
        if (this.roomListeners.contains(aVChatRoomListener)) {
            return;
        }
        this.roomListeners.add(aVChatRoomListener);
        logI("addAVChatRoomListener roomListener:" + aVChatRoomListener + " num:" + this.roomListeners.size());
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void closeCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("closeCamera fail! isInitSdk is fail!");
            return;
        }
        logI("\u5173\u95ed\u6444\u50cf\u5934\uff0cuid:" + this.roomParams.getUserId() + " \u623f\u95f4ID:" + this.roomParams.getRoomId());
        if (isCameraOpened()) {
            this.engineProxy.j0();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void closeMic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("closeMic fail! isInitSdk is fail!");
            return;
        }
        logI("\u5173\u95ed\u9ea6\u514b\u98ce\uff0cuid:" + this.roomParams.getUserId() + " \u623f\u95f4ID:" + this.roomParams.getRoomId());
        this.engineProxy.i0();
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void enableBitmapUploader(boolean z16, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), bitmap);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("enableBitmapUploader fail! isInitSdk is fail!");
            return;
        }
        logI("enableBitmapUploader isSend:" + z16 + " bitmap:" + bitmap);
        if (z16 && bitmap != null) {
            logI("\u5f00\u59cb\u53d1\u9001\u9759\u6001\u56fe\uff0cuid:" + this.roomParams.getUserId() + " \u623f\u95f4ID:" + this.roomParams.getRoomId());
            this.engineProxy.k(true);
            com.tencent.mobileqq.qqlive.trtc.video.source.camera.a q16 = this.engineProxy.q(true);
            if (q16 != null) {
                q16.i(bitmap, 10);
                q16.j(true);
                return;
            }
            return;
        }
        logI("\u505c\u6b62\u53d1\u9001\u9759\u6001\u56fe\uff0cuid:" + this.roomParams.getUserId() + " \u623f\u95f4ID:" + this.roomParams.getRoomId());
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a q17 = this.engineProxy.q(true);
        if (q17 != null) {
            q17.j(false);
        }
    }

    public void enterTRTCRoom(Context context, String str, QQLiveRoomParams qQLiveRoomParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, str, qQLiveRoomParams);
            return;
        }
        if (context != null && str != null && qQLiveRoomParams != null) {
            logI("enterRoom context:" + context + " configData:" + str + " params:" + qQLiveRoomParams.toString());
            this.isExitTRTCRoom = false;
            this.roomParams = new QQLiveRoomParams.Builder().setUserId(qQLiveRoomParams.getUserId()).setRoomId(qQLiveRoomParams.getRoomId()).setUserSig(qQLiveRoomParams.getUserSig()).setRoleType(1).setStreamId(qQLiveRoomParams.getStreamId()).setUserDefineRecordId(qQLiveRoomParams.getUserDefineRecordId()).setBussinessInfo(qQLiveRoomParams.getBussinessInfo()).setScene(1).build();
            logI("\u51c6\u5907TRTC\u8fdb\u623f, uid:" + this.roomParams.getUserId() + " \u623f\u95f4ID:" + this.roomParams.getRoomId() + " sig:" + this.roomParams.getUserSig() + " streamId:" + this.roomParams.getStreamId());
            if (!this.isInitTRTCEngine) {
                this.engineProxy.w(context, str, new TRTCInitCallback() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.module.a
                    @Override // com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback
                    public final void onInitEvent(int i3, int i16) {
                        TRTCAVChatRoomModule.this.lambda$enterTRTCRoom$0(i3, i16);
                    }
                });
                return;
            } else {
                doEnterTRTCRoom();
                return;
            }
        }
        logE("enterRoom fail! param is null! context:" + context + " appId:" + str + " params:" + qQLiveRoomParams);
    }

    public void exitTRTCRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("exitRoom fail! isInitSdk is fail!");
            return;
        }
        if (this.isExitTRTCRoom) {
            logE("exitRoom fail! isExitRoom is true!");
            return;
        }
        logI("exitRoom");
        logI("TRTC\u9000\u623f, uid:" + this.roomParams.getUserId() + " \u623f\u95f4ID:" + this.roomParams.getRoomId());
        this.isExitTRTCRoom = true;
        this.engineProxy.K(this.tRtcRoomListener);
        this.engineProxy.Y(null);
        if (this.isPublish) {
            stopPublish();
        }
        closeCamera();
        closeMic();
        stopAllRemoteVideo();
        this.engineProxy.m();
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public boolean isCameraOpened() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (!this.isInitTRTCEngine) {
            logE("isCameraOpened fail! isInitSdk is fail!");
            return false;
        }
        return this.engineProxy.E();
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public boolean isMicOpened() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (!this.isInitTRTCEngine) {
            logE("isMicOpened fail! isInitSdk is fail!");
            return false;
        }
        return this.engineProxy.A();
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void openCamera(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewGroup);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("openCamera fail! isInitSdk is fail!");
            return;
        }
        logI("openCamera preview:" + viewGroup);
        logI("\u6253\u5f00\u6444\u50cf\u5934\uff0cuid:" + this.roomParams.getUserId() + " \u623f\u95f4ID:" + this.roomParams.getRoomId());
        this.engineProxy.k(false);
        if (viewGroup != null) {
            this.engineProxy.T(viewGroup);
        }
        this.engineProxy.d0();
        if (this.engineProxy.p() != 1) {
            this.engineProxy.n0();
        }
        this.engineProxy.Q(RTCCameraDefine.RTCMirrorType.RTC_ALL_PIPELINE, true);
        updateMediaConfig(getDefaultMediaConfig());
        logI("openCamera setBeautyPreProcess beautyProcess:" + this.beautyProcess);
        com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a aVar = this.beautyProcess;
        if (aVar != null) {
            this.engineProxy.Z(aVar);
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a q16 = this.engineProxy.q(true);
        if (q16 != null) {
            q16.j(false);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void openMic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("openMic fail! isInitSdk is fail!");
            return;
        }
        logI("\u6253\u5f00\u9ea6\u514b\u98ce\uff0cuid:" + this.roomParams.getUserId() + " \u623f\u95f4ID:" + this.roomParams.getRoomId());
        this.engineProxy.c0(2);
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        logI("release");
        this.beautyProcess = null;
        this.roomListeners.clear();
        this.engineProxy.K(this.tRtcRoomListener);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void removeAVChatRoomListener(AVChatRoomListener aVChatRoomListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVChatRoomListener);
            return;
        }
        this.roomListeners.remove(aVChatRoomListener);
        logI("addAVChatRoomListener removeAVChatRoomListener:" + aVChatRoomListener + " num:" + this.roomListeners.size());
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public boolean sendSEIMsg(byte[] bArr, int i3) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) bArr, i3)).booleanValue();
        }
        if (!this.isInitTRTCEngine) {
            logE("sendSEIMsg fail! isInitSdk is fail!");
            return false;
        }
        if (bArr != null && bArr.length > 0 && i3 >= 1) {
            return this.engineProxy.M(bArr, i3);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sendSEIMsg fail! data:");
        if (bArr != null) {
            obj = Integer.valueOf(bArr.length);
        } else {
            obj = "null";
        }
        sb5.append(obj);
        sb5.append(" repeatCount:");
        sb5.append(i3);
        logE(sb5.toString());
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void setBeautyPreProcess(com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        this.beautyProcess = aVar;
        logI("setBeautyPreProcess isCameraOpened:" + isCameraOpened() + " process:" + aVar);
        if (isCameraOpened() && aVar != null) {
            this.engineProxy.Z(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void setPreview(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) viewGroup);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("setPreview fail! isInitSdk is fail!");
            return;
        }
        logI("setPreview preview:" + viewGroup);
        this.engineProxy.T(viewGroup);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void setRemoteVideoParam(String str, QQLiveRenderParams qQLiveRenderParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) qQLiveRenderParams);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("setRemoteVideoParam fail! isInitSdk is fail!");
            return;
        }
        if (!TextUtils.isEmpty(str) && qQLiveRenderParams != null) {
            logI("setRemoteVideoParam userId:" + str + " params:" + qQLiveRenderParams);
            this.engineProxy.V(str, qQLiveRenderParams);
            return;
        }
        logE("setRemoteVideoParam fail! param is null! userId:" + str + " params:" + qQLiveRenderParams);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void startPublish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("startPublish fail! isInitSdk is fail!");
            return;
        }
        if (this.roomParams == null) {
            logE("startPublish fail! roomParams is null!");
            return;
        }
        logI("startPublish isPublish:" + this.isPublish);
        if (this.isPublish) {
            return;
        }
        if (this.protocolPublisher == null) {
            this.protocolPublisher = new AVChatStreamPublisher(this.mediaConfig, this.liveSDK, this.roomInfo, this.roomParams.getUserSig());
        }
        logI("\u53d1\u9001\u5f00\u64ad\u534f\u8bae\uff0cuid:" + this.roomParams.getUserId() + " \u623f\u95f4ID:" + this.roomParams.getRoomId());
        this.protocolPublisher.startPushStream(this.anchorUserId, new AudioStreamPublisher.PushCallback() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.module.TRTCAVChatRoomModule.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TRTCAVChatRoomModule.this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher.PushCallback
            public void onFailed(@Nullable String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) str);
                    return;
                }
                TRTCAVChatRoomModule.this.logE("protocolPublisher onFailed msg:" + str);
            }

            @Override // com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher.PushCallback
            public void onSuccess() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TRTCAVChatRoomModule.this.logI("protocolPublisher onSuccess isExitRoom:" + TRTCAVChatRoomModule.this.isExitTRTCRoom);
                if (TRTCAVChatRoomModule.this.isExitTRTCRoom) {
                    return;
                }
                TRTCAVChatRoomModule.this.logI("\u5f00\u59cb\u4e0a\u884c\u63a8\u6d41\uff0cuid:" + TRTCAVChatRoomModule.this.roomParams.getUserId() + " \u623f\u95f4ID:" + TRTCAVChatRoomModule.this.roomParams.getRoomId());
                TRTCAVChatRoomModule.this.protocolPublisher.sendHeartbeat();
            }
        });
        this.engineProxy.o0(0);
        this.isPublish = true;
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void startRemoteAudio(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("startRemoteAudio fail! isInitSdk is fail!");
            return;
        }
        logI("\u5f00\u59cb\u64ad\u653e\u8fdc\u7aef\u97f3\u9891\uff0cuid:" + str + " \u623f\u95f4ID:" + this.roomParams.getRoomId());
        this.engineProxy.H(str, false);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void startRemoteVideo(String str, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) viewGroup);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("startRemoteVideo fail! isInitSdk is fail!");
            return;
        }
        if (!TextUtils.isEmpty(str) && viewGroup != null) {
            logI("startRemoteVideo userId:" + str + " viewGroup:" + viewGroup);
            logI("\u5f00\u59cb\u64ad\u653e\u8fdc\u7aef\u89c6\u9891\uff0cuid:" + str + " \u623f\u95f4ID:" + this.roomParams.getRoomId());
            this.engineProxy.e0(str, viewGroup);
            setRemoteVideoParam(str, new QQLiveRenderParams.Builder().setFillMode(0).build());
            return;
        }
        logE("startRemoteVideo fail! param is null! userId:" + str + " viewGroup:" + viewGroup);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void stopAllRemoteAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("stopAllRemoteAudio fail! isInitSdk is fail!");
            return;
        }
        logI("\u505c\u6b62\u6240\u6709\u7684\u8fdc\u7aef\u97f3\u9891 \u623f\u95f4ID:" + this.roomParams.getRoomId());
        this.engineProxy.F(false);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void stopAllRemoteVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("stopAllRemoteVideo fail! isInitSdk is fail!");
            return;
        }
        logI("\u505c\u6b62\u6240\u6709\u7684\u8fdc\u7aef\u89c6\u9891 \u623f\u95f4ID:" + this.roomParams.getRoomId());
        this.engineProxy.h0();
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void stopPublish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("stopPublish fail! isInitSdk is fail!");
            return;
        }
        logI("stopPublish isPublish:" + this.isPublish);
        if (!this.isPublish) {
            return;
        }
        logI("\u53d1\u9001\u4e0b\u64ad\u534f\u8bae\uff0cuid:" + this.roomParams.getUserId() + " \u623f\u95f4ID:" + this.roomParams.getRoomId());
        this.protocolPublisher.stopHeartbeat();
        this.protocolPublisher.endPushStream(new AudioStreamPublisher.PushCallback() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.module.TRTCAVChatRoomModule.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TRTCAVChatRoomModule.this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher.PushCallback
            public void onFailed(@Nullable String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) str);
                    return;
                }
                TRTCAVChatRoomModule.this.logI("\u505c\u6b62\u4e0a\u884c\u63a8\u6d41\uff0cuid:" + TRTCAVChatRoomModule.this.roomParams.getUserId() + " \u623f\u95f4ID:" + TRTCAVChatRoomModule.this.roomParams.getRoomId());
                TRTCAVChatRoomModule.this.engineProxy.o0(1);
            }

            @Override // com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher.PushCallback
            public void onSuccess() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    TRTCAVChatRoomModule.this.logI("protocolPublisher endPushStream onSuccess");
                    TRTCAVChatRoomModule.this.logI("\u505c\u6b62\u4e0a\u884c\u63a8\u6d41\uff0cuid:" + TRTCAVChatRoomModule.this.roomParams.getUserId() + " \u623f\u95f4ID:" + TRTCAVChatRoomModule.this.roomParams.getRoomId());
                    TRTCAVChatRoomModule.this.engineProxy.o0(1);
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.isPublish = false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void stopRemoteAudio(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("stopRemoteAudio fail! isInitSdk is fail!");
            return;
        }
        logI("\u505c\u6b62\u64ad\u653e\u8fdc\u7aef\u97f3\u9891\uff0cuid:" + str + " \u623f\u95f4ID:" + this.roomParams.getRoomId());
        this.engineProxy.H(str, true);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void stopRemoteVideo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("stopRemoteVideo fail! isInitSdk is fail!");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            logE("stopRemoteVideo fail! param is null! userId:" + str);
            return;
        }
        logI("\u505c\u6b62\u64ad\u653e\u8fdc\u7aef\u89c6\u9891\uff0cuid:" + str + " \u623f\u95f4ID:" + this.roomParams.getRoomId());
        this.engineProxy.k0(str);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void switchCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("switchCamera fail! isInitSdk is fail!");
            return;
        }
        logI("\u7ffb\u8f6c\u6444\u50cf\u5934 \u623f\u95f4ID:" + this.roomParams.getRoomId());
        this.engineProxy.n0();
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void updateMediaConfig(LiveMediaConfig liveMediaConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) liveMediaConfig);
            return;
        }
        if (!this.isInitTRTCEngine) {
            logE("updateMediaConfig fail! isInitSdk is fail!");
            return;
        }
        if (liveMediaConfig == null) {
            return;
        }
        this.mediaConfig = liveMediaConfig;
        logI("updateMediaConfig mediaConfig:" + liveMediaConfig.toString());
        TRTCVideoQualityParams.Builder builder = new TRTCVideoQualityParams.Builder();
        builder.setVideoResolution(liveMediaConfig.getResolution()).setVideoFps(liveMediaConfig.getFps()).setVideoBitRate(liveMediaConfig.getBitRate()).setMinVideoBitRate(liveMediaConfig.getMinBitRate()).setVideoResolutionMode(1);
        this.engineProxy.a0(builder.build());
    }

    private void logE(String str, Throwable th5) {
        this.aegisLogger.e(TAG, str + " " + th5.getMessage());
    }
}
