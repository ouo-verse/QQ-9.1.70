package com.tencent.avcore.engine.mav;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.avcore.jni.data.NtrtcAppParam;
import com.tencent.avcore.jni.data.NtrtcAudioParam;
import com.tencent.avcore.jni.data.NtrtcCommonParam;
import com.tencent.avcore.jni.data.NtrtcNetworkParam;
import com.tencent.avcore.jni.data.NtrtcVideoParam;
import com.tencent.avcore.jni.data.OpenSDKEnterRoomParam;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IMavEngine extends IAVEngineCommon {
    void AppCrased();

    void AppDeadLock();

    void AppWillTerminal();

    void EnterBackGround();

    void EnterFrontGround();

    boolean NotifyBusinessExtInfo(String str, int i3, String str2, int i16);

    int accept(int i3, long j3, int i16, int i17, int i18, int i19, int i26);

    void changeAvRole(int i3, String str);

    void checkScreenShareAvaliable();

    int commonRequest(int i3, long j3, int i16, int i17, int i18, int i19, int i26, String str, int i27, byte[] bArr, int i28);

    int debugSwitch(boolean z16);

    void enableAIDenoise(boolean z16);

    void enableDumpAudioData(boolean z16);

    boolean enableLoopback(boolean z16);

    String getAVGQuality();

    String getAibotQualityReportInfo();

    int getAudioScene();

    long getEnterRoomTime();

    int getInviteStrategy(long[] jArr, int i3, String[] strArr, int i16);

    int getNetLevel();

    int getNetState();

    long getNetTrafficSize(long j3);

    String getNetWorkQualityRTT();

    long getRoomId();

    void getRoomUinOpenIdMap(long j3, long j16, int i3, int i16);

    int getRoomUserClientVersion(int i3, long j3, int i16, long j16);

    int getRoomUserTerminalType(int i3, long j3, int i16, long j16);

    void getSign(long j3, int i3, long j16, int i16, int i17);

    int getVideoAbilityLevel();

    int getVolume();

    int ignore(int i3, long j3, int i16);

    int init(Context context, String str, NtrtcAppParam ntrtcAppParam, NtrtcNetworkParam ntrtcNetworkParam, NtrtcAudioParam ntrtcAudioParam, NtrtcVideoParam ntrtcVideoParam, NtrtcCommonParam ntrtcCommonParam);

    int invite(int i3, String[] strArr, int i16, int i17, int i18);

    boolean isEnableLoopback();

    void lockVideoMaxQP(int i3);

    int modifyGroupAdmin(long j3, boolean z16);

    byte[] postData(long j3, byte[] bArr);

    int quitRoom(int i3);

    void registerOpenSdkApp(int i3, String str);

    int request(int i3, long j3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, byte[] bArr);

    int requestCamera(int i3, long j3, int i16, int i17, int i18);

    int requestMemPosInfoList();

    boolean sendGeneralRawChannelData(int i3, byte[] bArr);

    int sendShareFrame2Native(byte[] bArr, int i3, int i16, int i17, int i18);

    int sendShareFrame2NativeBmp(Bitmap bitmap, int i3, int i16);

    void setAECMode(int i3);

    int setApType(int i3);

    void setAppId(int i3);

    boolean setAudioNoiseCtrlParam(int i3, int i16, int i17);

    int setAudioOutputMode(int i3);

    int setAudioScene(int i3);

    int setHowlingDetectEnable(boolean z16);

    boolean setMicByAdmin(long j3, boolean z16);

    boolean setMicMode(int i3);

    void setOpenSDKEnterRoomParam(OpenSDKEnterRoomParam openSDKEnterRoomParam);

    void setQosParams(String str);

    int setShareEncParam(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28);

    void setVideoDataSendByDefault(boolean z16);

    void setVideoDataSink(boolean z16);

    int setVoiceType(int i3);

    void spearAddParamByRole(int i3, String str, String str2);

    void spearClear(int i3);

    int startAudioRecv();

    int startAudioSend(boolean z16);

    int startShareSend(int i3);

    int startVideoRecv(String[] strArr, int i3);

    int startVideoSend();

    int stopAudioRecv();

    int stopAudioSend(boolean z16);

    int stopShareSend(int i3);

    int stopVideoRecv();

    int stopVideoSend();

    int switchToAudioMode();

    void uninit();

    void unregisterOpenSdkApp(int i3);

    int updateRoomInfo(int i3, long j3, int i16, boolean z16, boolean z17, boolean z18);

    int updateRoomUserTerminalInfo(int i3, long j3, int i16, long j16, int i17, int i18);
}
