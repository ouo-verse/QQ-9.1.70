package com.tencent.mobileqq.groupvideo.bridgeengine.avsdk;

import com.tencent.avcore.jni.audiodevice.TraeAudioManager;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.avcore.jni.data.OpenSDKEnterRoomParam;
import com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator;
import com.tencent.mobileqq.groupvideo.bridgeengine.QavSdkMultiParams;
import com.tencent.mobileqq.groupvideo.bridgeengine.RegistAudioDataCompleteCallback;
import com.tencent.mobileqq.groupvideo.bridgeengine.StageUserVideoInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e implements IQavSdkMultiOperator {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final b f213738a;

    /* renamed from: b, reason: collision with root package name */
    private final int f213739b;

    /* renamed from: c, reason: collision with root package name */
    private final String f213740c;

    public e(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            return;
        }
        this.f213739b = i3;
        this.f213740c = str;
        this.f213738a = (b) com.tencent.qav.b.b().c();
    }

    private void a(QavSdkMultiParams qavSdkMultiParams) {
        QLog.i("QavSdkMultiOperator", 1, "enterRoom setEnterParam param:" + qavSdkMultiParams);
        this.f213738a.I(new OpenSDKEnterRoomParam(this.f213739b, qavSdkMultiParams.appVersion, "", qavSdkMultiParams.authbuffer, qavSdkMultiParams.controlRole, qavSdkMultiParams.appRoomId, qavSdkMultiParams.audioCategory, qavSdkMultiParams.authBits, qavSdkMultiParams.videoRecvMode, qavSdkMultiParams.screenRecvMode, qavSdkMultiParams.enableMic, qavSdkMultiParams.enableSpeaker, qavSdkMultiParams.enableHdAudio, qavSdkMultiParams.scene));
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void changeAvRole(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.f213738a.q(this.f213739b, str);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public int enableLocalAudio(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, z16)).intValue();
        }
        return this.f213738a.enableLocalAudio(z16);
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void enableRemoteAudio(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.f213738a.enableRemoteAudio(z16);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public int enterRoom(QavSdkMultiParams qavSdkMultiParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) qavSdkMultiParams)).intValue();
        }
        this.f213738a.E(this.f213739b, this.f213740c);
        com.tencent.qav.a aVar = new com.tencent.qav.a();
        aVar.f342344b = 7;
        aVar.f342346d = qavSdkMultiParams.appRoomId;
        aVar.f342347e = Long.parseLong(this.f213740c);
        aVar.f342343a = 6;
        aVar.f342350h = qavSdkMultiParams.authbuffer;
        aVar.f342349g = this.f213739b;
        a(qavSdkMultiParams);
        return this.f213738a.e(aVar);
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void exitRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f213738a.M(this.f213739b);
            this.f213738a.exitRoom();
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public String getAVGQuality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f213738a.O();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public int getAudioRoute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f213738a.getAudioRoute();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public String getNetWorkQualityRTT() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f213738a.getNetWorkQualityRTT();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public int getVideoAbilityLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.f213738a.P();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public boolean goOffStage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.f213738a.Q();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public boolean goOnStage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.f213738a.R();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public boolean isLocalAudioEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f213738a.isLocalAudioEnable();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public boolean isRemoteAudioEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f213738a.w();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void registAudioDataUpdateListener(RegistAudioDataCompleteCallback registAudioDataCompleteCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) registAudioDataCompleteCallback);
            return;
        }
        b bVar = this.f213738a;
        if (bVar != null) {
            bVar.T(registAudioDataCompleteCallback);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void restartService(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.PARAM_DEVICE_CONFIG, TraeConstants.DEVICE_SPEAKERPHONE);
        hashMap.put(TraeConstants.PARAM_CONNECT_DEVICE_WHEN_START_SERVICE, null);
        hashMap.put(TraeConstants.PARAM_IS_ALLOWED_USE_BLUETOOTH, Boolean.valueOf(z16));
        QLog.d("QavSdkMultiOperator", 1, "restartService");
        TraeAudioManager.getInstance().sendMessage(32769, hashMap);
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void setAudioDataVolume(int i3, float f16) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        b bVar = this.f213738a;
        if (bVar != null) {
            i16 = bVar.U(i3, f16);
        } else {
            i16 = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QavSdkMultiOperator", 2, "setAudioDataVolume res=" + i16 + ", " + i3 + ", " + f16);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void setAudioRoute(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f213738a.setAudioRoute(i3);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void setEncodeDecodePtr(long j3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            this.f213738a.setEncodeDecodePtr(j3, z16, z17);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void setGAudioFormat(int i3, int i16, int i17, int i18) {
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        b bVar = this.f213738a;
        if (bVar != null) {
            i19 = bVar.V(i3, i16, i17, i18);
        } else {
            i19 = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QavSdkMultiOperator", 2, "setGAudioFormat res=" + i19 + ", " + i3 + ", " + i16 + ", " + i17 + ", " + i18);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void spearAddParamByRole(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, (Object) str2);
        } else {
            this.f213738a.K(this.f213739b, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void spearClear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.f213738a.L(this.f213739b);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void startFetchVideo(List<StageUserVideoInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) list);
            return;
        }
        ArrayList<com.tencent.av.gaudio.c> arrayList = new ArrayList<>();
        for (StageUserVideoInfo stageUserVideoInfo : list) {
            com.tencent.av.gaudio.c cVar = new com.tencent.av.gaudio.c();
            cVar.f73827a = stageUserVideoInfo.uin;
            cVar.f73828b = stageUserVideoInfo.videoSrcType;
            cVar.f73829c = stageUserVideoInfo.isBig;
            arrayList.add(cVar);
        }
        this.f213738a.m().startVideoRecv(arrayList);
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void stopFetchVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.f213738a.m().stopVideoRecv();
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void unregistAudioDataCallback(RegistAudioDataCompleteCallback registAudioDataCompleteCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) registAudioDataCompleteCallback);
            return;
        }
        b bVar = this.f213738a;
        if (bVar != null) {
            bVar.T(null);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkMultiOperator
    public void updateRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f213738a.updateRoomInfo();
        }
    }
}
