package com.tencent.qqnt.aio.helper;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqnt.kernel.nativeinterface.BulletinFeedsDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataSource;
import com.tencent.qqnt.kernel.nativeinterface.FirstGroupBulletinInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupAllInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupArkInviteStateInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletin;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletinListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberInfoListId;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberLevelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMaskInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyTemplateItem;
import com.tencent.qqnt.kernel.nativeinterface.GroupSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bZ\u0010[J.\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J2\u0010\u0010\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\r2\u001e\u0010\u000f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u0001`\u0006H\u0016J(\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0004H\u0016JP\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00042\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0004H\u0016J8\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00042\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0004H\u0016J0\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u001e\u0010\u0015\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u0001`\u0006H\u0016J \u0010\"\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0019H\u0016J8\u0010&\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0016J(\u0010)\u001a\u00020\b2\u001e\u0010(\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u0001`\u0006H\u0016J0\u0010-\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00122\u001e\u0010,\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u0001`\u0006H\u0016J\u001a\u00100\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J$\u00104\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010+2\b\u00103\u001a\u0004\u0018\u000102H\u0016J\u0012\u00107\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u000105H\u0016JJ\u0010>\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00122\b\u00109\u001a\u0004\u0018\u0001082.\u0010=\u001a*\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0014\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u0001`<H\u0016Jl\u0010D\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010+2\b\u0010@\u001a\u0004\u0018\u00010+2\u001e\u0010B\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010A\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010A\u0018\u0001`\u00062.\u0010C\u001a*\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0014\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u0001`<H\u0016J\u0012\u0010G\u001a\u00020\b2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010H\u001a\u00020\b2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016J\u001a\u0010K\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00122\b\u0010J\u001a\u0004\u0018\u00010IH\u0016J\u0012\u0010M\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010LH\u0016J0\u0010O\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00122\u001e\u0010N\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u0001`\u0006H\u0016J\u001a\u0010Q\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010PH\u0016J\u0012\u0010T\u001a\u00020\b2\b\u0010S\u001a\u0004\u0018\u00010RH\u0016J\u0010\u0010U\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0012H\u0016J\u001a\u0010X\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00122\b\u0010W\u001a\u0004\u0018\u00010VH\u0016J\u0010\u0010Y\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0012H\u0016\u00a8\u0006\\"}, d2 = {"Lcom/tencent/qqnt/aio/helper/bi;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupListUpdateType;", "updateType", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSimpleInfo;", "Lkotlin/collections/ArrayList;", "groupList", "", "onGroupListUpdate", "", "listEmpty", "onGroupListInited", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtListUpdateType;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtInfo;", "groupExtList", "onGroupExtListUpdate", "doubt", "", "nextStartSeq", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsg;", "notifies", "onGroupSingleScreenNotifies", "curReadedSeq", "hasMore", "", "category", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyTemplateItem;", DKConfiguration.Directory.TEMPLATES, "onGroupSingleScreenNotifiesV2", "onGroupNotifiesUpdatedV2", "onGroupNotifiesUpdated", "oldestUnreadSeq", "unreadCount", "onGroupNotifiesUnreadCountUpdated", "unHandleCount", "unHandleAndUnreadCount", "memberQuitUnreadCount", "onGroupNotifiesUnreadCountUpdatedV2", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMaskInfo;", "groupsMsgMask", "onGroupsMsgMaskResult", "groupCode", "", "membersUid", "onGroupConfMemberChange", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupBulletin;", "groupBulletin", "onGroupBulletinChange", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupBulletinListResult;", "result", "onGetGroupBulletinListResult", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberListChangeInfo;", "info", "onMemberListChange", "Lcom/tencent/qqnt/kernel/nativeinterface/DataSource;", "dataSource", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "Lkotlin/collections/HashMap;", "members", "onMemberInfoChange", WadlProxyConsts.SCENE_ID, "keyword", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberInfoListId;", "ids", "infos", "onSearchMemberChange", "Lcom/tencent/qqnt/kernel/nativeinterface/BulletinFeedsDownloadInfo;", "downloadInfo", "onGroupBulletinRichMediaDownloadComplete", "onGroupBulletinRichMediaProgressUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupStatisticInfo;", "statisticInfo", "onGroupStatisticInfoChange", "Lcom/tencent/qqnt/kernel/nativeinterface/JoinGroupNotifyMsg;", "onJoinGroupNotify", "memList", "onShutUpMemberListChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/RemindGroupBulletinMsg;", "onGroupBulletinRemindNotify", "Lcom/tencent/qqnt/kernel/nativeinterface/FirstGroupBulletinInfo;", "firstGroupBulletinInfo", "onGroupFirstBulletinNotify", "onGroupAdd", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberLevelInfo;", "memberLevelInfo", "onGroupMemberLevelInfoChange", "onGroupEssenceListChange", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class bi implements IKernelGroupListener {
    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupAllInfoChange(GroupAllInfo groupAllInfo) {
        com.tencent.qqnt.kernel.nativeinterface.am.c(this, groupAllInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupArkInviteStateResult(long j3, GroupArkInviteStateInfo groupArkInviteStateInfo) {
        com.tencent.qqnt.kernel.nativeinterface.am.d(this, j3, groupArkInviteStateInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17) {
        com.tencent.qqnt.kernel.nativeinterface.am.y(this, j3, z16, z17);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupAdd(long groupCode) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo downloadInfo) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo downloadInfo) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupEssenceListChange(long groupCode) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupFirstBulletinNotify(FirstGroupBulletinInfo firstGroupBulletinInfo) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupListInited(boolean listEmpty) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupsMsgMaskResult(ArrayList<GroupMsgMaskInfo> groupsMsgMask) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onJoinGroupNotify(JoinGroupNotifyMsg notifies) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onMemberListChange(GroupMemberListChangeInfo info) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupBulletinChange(long groupCode, GroupBulletin groupBulletin) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupBulletinRemindNotify(long groupCode, RemindGroupBulletinMsg notifies) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupConfMemberChange(long groupCode, ArrayList<String> membersUid) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupExtListUpdate(GroupExtListUpdateType updateType, ArrayList<GroupExtInfo> groupExtList) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupListUpdate(GroupListUpdateType updateType, ArrayList<GroupSimpleInfo> groupList) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupMemberLevelInfoChange(long groupCode, GroupMemberLevelInfo memberLevelInfo) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupNotifiesUpdated(boolean doubt, ArrayList<GroupNotifyMsg> notifies) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupStatisticInfoChange(long groupCode, GroupStatisticInfo statisticInfo) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onShutUpMemberListChanged(long groupCode, ArrayList<MemberInfo> memList) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGetGroupBulletinListResult(long groupCode, String context, GroupBulletinListResult result) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupNotifiesUnreadCountUpdated(boolean doubt, long oldestUnreadSeq, int unreadCount) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupSingleScreenNotifies(boolean doubt, long nextStartSeq, ArrayList<GroupNotifyMsg> notifies) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onMemberInfoChange(long groupCode, DataSource dataSource, HashMap<String, MemberInfo> members) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupNotifiesUnreadCountUpdatedV2(boolean doubt, long oldestUnreadSeq, int unreadCount, int unHandleCount, int unHandleAndUnreadCount, int memberQuitUnreadCount) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupSingleScreenNotifiesV2(boolean doubt, long curReadedSeq, long nextStartSeq, boolean hasMore, int category, ArrayList<GroupNotifyMsg> notifies, ArrayList<GroupNotifyTemplateItem> templates) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupNotifiesUpdatedV2(boolean doubt, long curReadedSeq, ArrayList<GroupNotifyMsg> notifies, ArrayList<GroupNotifyTemplateItem> templates) {
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onSearchMemberChange(String sceneId, String keyword, ArrayList<GroupMemberInfoListId> ids, HashMap<String, MemberInfo> infos) {
    }
}
