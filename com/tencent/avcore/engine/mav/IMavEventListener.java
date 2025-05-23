package com.tencent.avcore.engine.mav;

import com.tencent.avcore.data.MavInviteData;
import com.tencent.avcore.data.RecordParam;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avcore.jni.data.GetSignResponse;
import com.tencent.avcore.jni.data.MavCommonPBMsg;
import com.tencent.avcore.jni.data.UinOpenIdResponse;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IMavEventListener {
    void onCameraSettingNotify(int i3, int i16, int i17);

    void onChangeAuthority(int i3, String str);

    void onChangeRole(int i3, String str);

    void onCheckScreenShareAvailable(int i3, byte[] bArr);

    void onCreateRoomSuc(int i3, long j3, int i16);

    void onDetectAudioDataIssue(int i3);

    void onDoubleVideoMeetingInvite(String str, int i3, int i16);

    void onEnterSuc(long j3, int i3, int i16);

    void onFpsChange(int i3);

    void onGAudioInvite(int i3, long j3, String str, String[] strArr, boolean z16, int i16, int i17, int i18);

    void onGAudioInviteResp(MavInviteData mavInviteData);

    void onGAudioKickOut(long j3, int i3, int i16);

    void onGAudioMemAllUpdate(long j3, ArrayList<AVUserInfo> arrayList, int i3, int i16);

    void onGAudioMemAllUpdate(long j3, String[] strArr, int i3, int i16);

    void onGAudioMemberMicChanged(String str, int i3, int i16, boolean z16);

    void onGAudioMicSetByAdmin(long j3, int i3);

    void onGAudioRoomDestroy(int i3, long j3);

    void onGAudioRoomMicModeChanged(long j3, boolean z16, boolean z17);

    void onGAudioSDKError(int i3, long j3, int i16, int i17);

    void onGAudioSetMicFailed(int i3, ArrayList<AVUserInfo> arrayList);

    void onGAudioTerminalEnterRoom(int i3, long j3, int... iArr);

    void onGAudioUserAudioSuspectNoisy(long j3, boolean z16, long j16);

    void onGVideoDownloadChannelCtlChanged(byte[] bArr);

    void onGaGoOffStageResult(int i3, long j3, long j16, int i16);

    void onGaGoOnStageResult(int i3, long j3, long j16, int i16);

    void onGaSwitchVideoResult(int i3, long j3, long j16, int i16);

    void onGeneralRawChannelData(long j3, int i3, int i16, long j16, byte[] bArr);

    void onGetSignRespond(GetSignResponse getSignResponse, long j3, int i3, int i16, long j16, int i17);

    void onGetUinOpenIdRespond(UinOpenIdResponse uinOpenIdResponse, long j3, int i3, int i16, long j16, int i17);

    void onGroupChatModeChange(long j3, int i3, int i16);

    void onGroupSecurityLimit(long j3, long j16, String str);

    void onGroupVideoClosed(int i3, long j3, int i16, int i17);

    void onHowling();

    void onInitAIDenoiseStatus();

    void onKickOutFail(long j3, int i3, int i16, int i17, String str);

    void onKickOutSuc(long j3, int i3, int i16, int i17, String str);

    void onMAVMemberInOrOut(AVUserInfo aVUserInfo, long j3, int i3, int i16, long j16, int... iArr);

    void onMultiVideoChatMembersInfoChange(long j3, String[] strArr, int i3, int i16, long j16, int i17, int i18);

    void onNotifyBusinessExtInfo(AVUserInfo aVUserInfo, long j3, int i3, int i16, long j16, int i17);

    void onNotifyCommonTips(int i3, byte[] bArr);

    void onOpenMicFail();

    void onPPTInOrOut(long j3, long j16, int i3, int i16);

    void onRecSharePushEncParam(int i3, long j3, RecordParam recordParam);

    void onRecvCommonChannelMsg(MavCommonPBMsg.MavCommonChannelInfo mavCommonChannelInfo, long j3, int i3, int i16, int i17);

    void onRemoteVideoDataComeIn(int i3, String str, int i16);

    void onSelfAudioVolumeChange(long j3);

    void onSetMicBySelf(long j3);

    void onShareOpsCallback(int i3, int i16, int i17, long j3, int i18, int i19);

    void onVideoSrcChange(int i3, int i16, long j3, long j16);
}
