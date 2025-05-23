package com.tencent.avcore.jni.mav;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.engine.mav.IMavAdapter;
import com.tencent.avcore.engine.mav.IMavEngine;
import com.tencent.avcore.engine.mav.IMavEventListener;
import com.tencent.avcore.jni.data.NtrtcAppParam;
import com.tencent.avcore.jni.data.NtrtcAudioParam;
import com.tencent.avcore.jni.data.NtrtcCommonParam;
import com.tencent.avcore.jni.data.NtrtcNetworkParam;
import com.tencent.avcore.jni.data.NtrtcTerminalInfo;
import com.tencent.avcore.jni.data.NtrtcVideoParam;
import com.tencent.avcore.jni.data.OpenSDKEnterRoomParam;
import com.tencent.avcore.netchannel.IMavNetChannel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class MavEngineProxy implements IMavEngine {
    static IPatchRedirector $redirector_;
    private MavEngineJni mMavEngineJni;
    private AVCoreSystemInfo mSysInfo;

    public MavEngineProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void AppCrased() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this);
        } else {
            this.mMavEngineJni.AppCrased();
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void AppDeadLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this);
        } else {
            this.mMavEngineJni.AppDeadLock();
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void AppWillTerminal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this);
        } else {
            this.mMavEngineJni.AppWillTerminal();
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void EnterBackGround() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this);
        } else {
            this.mMavEngineJni.EnterBackGround();
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void EnterFrontGround() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this);
        } else {
            this.mMavEngineJni.EnterFrontGround();
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public boolean NotifyBusinessExtInfo(String str, int i3, String str2, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16))).booleanValue();
        }
        return this.mMavEngineJni.NotifyBusinessExtInfo(str, i3, str2, i16);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int accept(int i3, long j3, int i16, int i17, int i18, int i19, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26))).intValue();
        }
        return this.mMavEngineJni.accept(i3, j3, i16, i17, i18, i19, i26);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void changeAvRole(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this, i3, (Object) str);
        } else {
            this.mMavEngineJni.changeAvRole(i3, str);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void checkScreenShareAvaliable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
        } else {
            this.mMavEngineJni.checkScreenShareAvaliable();
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int commonRequest(int i3, long j3, int i16, int i17, int i18, int i19, int i26, String str, int i27, byte[] bArr, int i28) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Integer) iPatchRedirector.redirect((short) 58, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), str, Integer.valueOf(i27), bArr, Integer.valueOf(i28))).intValue();
        }
        return this.mMavEngineJni.commonRequest(i3, j3, i16, i17, i18, i19, i26, str, i27, bArr, i28);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int debugSwitch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this, z16)).intValue();
        }
        return this.mMavEngineJni.debugSwitch(z16);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void enableAIDenoise(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, z16);
        } else {
            this.mMavEngineJni.enableAIDenoise(z16);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void enableDumpAudioData(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, z16);
        } else {
            this.mMavEngineJni.enableDumpAudioData(z16);
        }
    }

    @Override // com.tencent.avcore.engine.common.IAVEngineCommon
    public void enableLocalSpeechRecognizeModel(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, z16);
        } else {
            this.mMavEngineJni.enableLocalSpeechRecognizeModel(z16);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public boolean enableLoopback(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this, z16)).booleanValue();
        }
        return this.mMavEngineJni.enableLoopback(z16);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public String getAVGQuality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.mMavEngineJni.getAVGQuality();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public String getAibotQualityReportInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (String) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        return this.mMavEngineJni.getAibotQualityReportInfo();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int getAudioScene() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Integer) iPatchRedirector.redirect((short) 52, (Object) this)).intValue();
        }
        return this.mMavEngineJni.getAudioScene();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public long getEnterRoomTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Long) iPatchRedirector.redirect((short) 57, (Object) this)).longValue();
        }
        return this.mMavEngineJni.getEnterRoomTime();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int getInviteStrategy(long[] jArr, int i3, String[] strArr, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return ((Integer) iPatchRedirector.redirect((short) 69, this, jArr, Integer.valueOf(i3), strArr, Integer.valueOf(i16))).intValue();
        }
        return this.mMavEngineJni.getInviteStrategy(jArr, i3, strArr, i16);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int getNetLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return this.mMavEngineJni.getNetLevel();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int getNetState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return this.mMavEngineJni.getNetState();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public long getNetTrafficSize(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Long) iPatchRedirector.redirect((short) 28, (Object) this, j3)).longValue();
        }
        return this.mMavEngineJni.getNetTrafficSize(j3);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public String getNetWorkQualityRTT() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (String) iPatchRedirector.redirect((short) 79, (Object) this);
        }
        return this.mMavEngineJni.getNetWorkQualityRTT();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Long) iPatchRedirector.redirect((short) 56, (Object) this)).longValue();
        }
        return this.mMavEngineJni.getRoomId();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void getRoomUinOpenIdMap(long j3, long j16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mMavEngineJni.getRoomUinOpenIdMap(j3, j16, i3, i16);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int getRoomUserClientVersion(int i3, long j3, int i16, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16))).intValue();
        }
        return this.mMavEngineJni.getRoomUserClientVersion(i3, j3, i16, j16);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int getRoomUserTerminalType(int i3, long j3, int i16, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16))).intValue();
        }
        return this.mMavEngineJni.getRoomUserTerminalType(i3, j3, i16, j16);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void getSign(long j3, int i3, long j16, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.mMavEngineJni.getSign(j3, i3, j16, i16, i17);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int getVideoAbilityLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }
        return this.mMavEngineJni.getVideoAbilityLevel();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int getVolume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.mMavEngineJni.getVolume();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int ignore(int i3, long j3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16))).intValue();
        }
        return this.mMavEngineJni.ignore(i3, j3, i16);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int init(Context context, String str, NtrtcAppParam ntrtcAppParam, NtrtcNetworkParam ntrtcNetworkParam, NtrtcAudioParam ntrtcAudioParam, NtrtcVideoParam ntrtcVideoParam, NtrtcCommonParam ntrtcCommonParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, context, str, ntrtcAppParam, ntrtcNetworkParam, ntrtcAudioParam, ntrtcVideoParam, ntrtcCommonParam)).intValue();
        }
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.mSysInfo.setScreenSize(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels), Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels));
        }
        return this.mMavEngineJni.init(context, str, ntrtcAppParam, ntrtcNetworkParam, ntrtcAudioParam, ntrtcVideoParam, ntrtcCommonParam, new NtrtcTerminalInfo(this.mSysInfo, ntrtcCommonParam.isPadForMultiDeviceLogin));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initEngine(AVCoreSystemInfo aVCoreSystemInfo, IMavAdapter iMavAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVCoreSystemInfo, (Object) iMavAdapter);
            return;
        }
        this.mSysInfo = aVCoreSystemInfo;
        this.mMavEngineJni = new MavEngineJni(aVCoreSystemInfo, iMavAdapter);
        MavEngineJni.regCallbacks();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int invite(int i3, String[] strArr, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), strArr, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).intValue();
        }
        return this.mMavEngineJni.invite(i3, strArr, i16, i17, i18);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public boolean isEnableLoopback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this)).booleanValue();
        }
        return this.mMavEngineJni.isEnableLoopback();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void lockVideoMaxQP(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, i3);
        } else {
            this.mMavEngineJni.lockVideoMaxQP(i3);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int modifyGroupAdmin(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, this, Long.valueOf(j3), Boolean.valueOf(z16))).intValue();
        }
        return this.mMavEngineJni.modifyGroupAdmin(j3, z16);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public byte[] postData(long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (byte[]) iPatchRedirector.redirect((short) 70, this, Long.valueOf(j3), bArr);
        }
        return this.mMavEngineJni.postData(j3, bArr);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int quitRoom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, i3)).intValue();
        }
        return this.mMavEngineJni.quitRoom(i3);
    }

    @Override // com.tencent.avcore.engine.common.IAVEngineCommon
    public int registerAudioDataCallback(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Integer) iPatchRedirector.redirect((short) 63, this, Integer.valueOf(i3), Boolean.valueOf(z16))).intValue();
        }
        return this.mMavEngineJni.registerAudioDataCallback(i3, z16);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void registerOpenSdkApp(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, i3, (Object) str);
            return;
        }
        System.out.println("registerOpenSdkApp sdkAppId: " + i3 + " tinyId: " + str);
        this.mMavEngineJni.registerOpenSdkApp(i3, str);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int request(int i3, long j3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), bArr)).intValue();
        }
        return this.mMavEngineJni.request(i3, j3, i16, i17, i18, i19, i26, i27, i28, bArr);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int requestCamera(int i3, long j3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Integer) iPatchRedirector.redirect((short) 60, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).intValue();
        }
        return this.mMavEngineJni.requestCamera(i3, j3, i16, i17, i18);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int requestMemPosInfoList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Integer) iPatchRedirector.redirect((short) 59, (Object) this)).intValue();
        }
        return this.mMavEngineJni.requestMemPosInfoList();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public boolean sendGeneralRawChannelData(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, (Object) this, i3, (Object) bArr)).booleanValue();
        }
        return this.mMavEngineJni.sendGeneralRawChannelData(i3, bArr);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int sendShareFrame2Native(byte[] bArr, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).intValue();
        }
        return this.mMavEngineJni.sendShareFrame2Native(bArr, i3, i16, i17, i18);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int sendShareFrame2NativeBmp(Bitmap bitmap, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return this.mMavEngineJni.sendShareFrame2NativeBmp(bitmap, i3, i16);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void setAECMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, i3);
        } else {
            this.mMavEngineJni.setAECMode(i3);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int setApType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this, i3)).intValue();
        }
        return this.mMavEngineJni.setApType(i3);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void setAppId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mMavEngineJni.setAppId(i3);
        }
    }

    @Override // com.tencent.avcore.engine.common.IAVEngineCommon
    public int setAudioDataFormat(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return ((Integer) iPatchRedirector.redirect((short) 65, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).intValue();
        }
        return this.mMavEngineJni.setAudioDataFormat(i3, i16, i17, i18);
    }

    @Override // com.tencent.avcore.engine.common.IAVEngineCommon
    public int setAudioDataVolume(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Integer) iPatchRedirector.redirect((short) 66, this, Integer.valueOf(i3), Float.valueOf(f16))).intValue();
        }
        return this.mMavEngineJni.setAudioDataVolume(i3, f16);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public boolean setAudioNoiseCtrlParam(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        return this.mMavEngineJni.setAudioNoiseCtrlParam(i3, i16, i17);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int setAudioOutputMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, i3)).intValue();
        }
        return this.mMavEngineJni.setAudioOutputMode(i3);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int setAudioScene(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this, i3)).intValue();
        }
        return this.mMavEngineJni.setAudioScene(i3);
    }

    public void setEventListener(IMavEventListener iMavEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iMavEventListener);
        } else {
            this.mMavEngineJni.setEventListener(iMavEventListener);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int setHowlingDetectEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return ((Integer) iPatchRedirector.redirect((short) 71, (Object) this, z16)).intValue();
        }
        return -1;
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public boolean setMicByAdmin(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, this, Long.valueOf(j3), Boolean.valueOf(z16))).booleanValue();
        }
        return this.mMavEngineJni.setMicByAdmin(j3, z16);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public boolean setMicMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this, i3)).booleanValue();
        }
        return this.mMavEngineJni.setMicMode(i3);
    }

    public void setNetChannel(IMavNetChannel iMavNetChannel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iMavNetChannel);
        } else {
            this.mMavEngineJni.setNetChannel(iMavNetChannel);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void setOpenSDKEnterRoomParam(OpenSDKEnterRoomParam openSDKEnterRoomParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this, (Object) openSDKEnterRoomParam);
        } else {
            this.mMavEngineJni.setOpenSDKEnterRoomParam(openSDKEnterRoomParam);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void setQosParams(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) str);
        } else {
            this.mMavEngineJni.setQosParams(str);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int setShareEncParam(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28))).intValue();
        }
        return this.mMavEngineJni.setShareEncParam(i3, i16, i17, i18, i19, i26, i27, i28);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void setVideoDataSendByDefault(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, z16);
        } else {
            this.mMavEngineJni.setVideoDataSendByDefault(z16);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void setVideoDataSink(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, z16);
        } else {
            this.mMavEngineJni.setVideoDataSink(z16);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int setVoiceType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Integer) iPatchRedirector.redirect((short) 44, (Object) this, i3)).intValue();
        }
        return this.mMavEngineJni.setVoiceType(i3);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void spearAddParamByRole(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, this, Integer.valueOf(i3), str, str2);
        } else {
            this.mMavEngineJni.spearAddParamByRole(i3, str, str2);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void spearClear(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this, i3);
        } else {
            this.mMavEngineJni.spearClear(i3);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int startAudioRecv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.mMavEngineJni.startAudioRecv();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int startAudioSend(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, z16)).intValue();
        }
        return this.mMavEngineJni.startAudioSend(z16);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int startShareSend(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this, i3)).intValue();
        }
        return this.mMavEngineJni.startShareSend(i3);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int startVideoRecv(String[] strArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) strArr, i3)).intValue();
        }
        return this.mMavEngineJni.startVideoRecv(strArr, i3);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int startVideoSend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return this.mMavEngineJni.startVideoSend();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int stopAudioRecv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.mMavEngineJni.stopAudioRecv();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int stopAudioSend(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, z16)).intValue();
        }
        return this.mMavEngineJni.stopAudioSend(z16);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int stopShareSend(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this, i3)).intValue();
        }
        return this.mMavEngineJni.stopShareSend(i3);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int stopVideoRecv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.mMavEngineJni.stopVideoRecv();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int stopVideoSend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return this.mMavEngineJni.stopVideoSend();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int switchToAudioMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        return this.mMavEngineJni.switchToAudioMode();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void uninit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mMavEngineJni.uninit();
        }
    }

    @Override // com.tencent.avcore.engine.common.IAVEngineCommon
    public int unregisterAudioDataCallback(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Integer) iPatchRedirector.redirect((short) 64, (Object) this, i3)).intValue();
        }
        return this.mMavEngineJni.unregisterAudioDataCallback(i3);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public void unregisterOpenSdkApp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, i3);
        } else {
            this.mMavEngineJni.unregisterOpenSdkApp(i3);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int updateRoomInfo(int i3, long j3, int i16, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18))).intValue();
        }
        return this.mMavEngineJni.updateRoomInfo(i3, j3, i16, z16, z17, z18);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEngine
    public int updateRoomUserTerminalInfo(int i3, long j3, int i16, long j16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), Integer.valueOf(i18))).intValue();
        }
        return this.mMavEngineJni.updateRoomUserTerminalInfo(i3, j3, i16, j16, i17, i18);
    }
}
