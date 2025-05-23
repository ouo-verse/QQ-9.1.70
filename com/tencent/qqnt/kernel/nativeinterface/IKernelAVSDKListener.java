package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelAVSDKListener {
    void OnGroupVideoActionToAVSDK(int i3, String str);

    void OnGroupVideoMemNumPushInfo(GroupVideoMemNumPushInfo groupVideoMemNumPushInfo);

    void OnGroupVideoServerPushToAVSDK(int i3, byte[] bArr);

    void OnInviteActionToAVSDK(InviteInfo inviteInfo, int i3, String str);

    void onActionToAVSDK(int i3, String str);

    void onGroupAudioMemNumChange(GroupAudioMemNumChangeNotifyInfo groupAudioMemNumChangeNotifyInfo);

    void onGroupVideoInviteMemberUpdate(GroupVideoInviteMemberUpdateNotifyInfo groupVideoInviteMemberUpdateNotifyInfo);

    void onRecvGroupVideoJsonBufferRsp(int i3, int i16, String str, String str2);
}
