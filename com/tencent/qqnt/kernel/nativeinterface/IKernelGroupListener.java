package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelGroupListener {
    void onGetGroupBulletinListResult(long j3, String str, GroupBulletinListResult groupBulletinListResult);

    void onGroupAdd(long j3);

    void onGroupAllInfoChange(GroupAllInfo groupAllInfo);

    void onGroupArkInviteStateResult(long j3, GroupArkInviteStateInfo groupArkInviteStateInfo);

    void onGroupBulletinChange(long j3, GroupBulletin groupBulletin);

    void onGroupBulletinRemindNotify(long j3, RemindGroupBulletinMsg remindGroupBulletinMsg);

    void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo);

    void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo);

    void onGroupConfMemberChange(long j3, ArrayList<String> arrayList);

    void onGroupDetailInfoChange(GroupDetailInfo groupDetailInfo);

    void onGroupEssenceListChange(long j3);

    void onGroupExtListUpdate(GroupExtListUpdateType groupExtListUpdateType, ArrayList<GroupExtInfo> arrayList);

    void onGroupFirstBulletinNotify(FirstGroupBulletinInfo firstGroupBulletinInfo);

    void onGroupListInited(boolean z16);

    void onGroupListUpdate(GroupListUpdateType groupListUpdateType, ArrayList<GroupSimpleInfo> arrayList);

    void onGroupMemberLevelInfoChange(long j3, GroupMemberLevelInfo groupMemberLevelInfo);

    void onGroupNotifiesUnreadCountUpdated(boolean z16, long j3, int i3);

    void onGroupNotifiesUnreadCountUpdatedV2(boolean z16, long j3, int i3, int i16, int i17, int i18);

    void onGroupNotifiesUpdated(boolean z16, ArrayList<GroupNotifyMsg> arrayList);

    void onGroupNotifiesUpdatedV2(boolean z16, long j3, ArrayList<GroupNotifyMsg> arrayList, ArrayList<GroupNotifyTemplateItem> arrayList2);

    void onGroupSingleScreenNotifies(boolean z16, long j3, ArrayList<GroupNotifyMsg> arrayList);

    void onGroupSingleScreenNotifiesV2(boolean z16, long j3, long j16, boolean z17, int i3, ArrayList<GroupNotifyMsg> arrayList, ArrayList<GroupNotifyTemplateItem> arrayList2);

    void onGroupStatisticInfoChange(long j3, GroupStatisticInfo groupStatisticInfo);

    void onGroupsMsgMaskResult(ArrayList<GroupMsgMaskInfo> arrayList);

    void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17);

    void onJoinGroupNotify(JoinGroupNotifyMsg joinGroupNotifyMsg);

    void onMemberInfoChange(long j3, DataSource dataSource, HashMap<String, MemberInfo> hashMap);

    void onMemberListChange(GroupMemberListChangeInfo groupMemberListChangeInfo);

    void onSearchMemberChange(String str, String str2, ArrayList<GroupMemberInfoListId> arrayList, HashMap<String, MemberInfo> hashMap);

    void onShutUpMemberListChanged(long j3, ArrayList<MemberInfo> arrayList);
}
