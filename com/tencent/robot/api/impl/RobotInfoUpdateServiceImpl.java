package com.tencent.robot.api.impl;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.troop.data.RobotInfoUpdateProcessor;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.BulletinFeedsDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataSource;
import com.tencent.qqnt.kernel.nativeinterface.FirstGroupBulletinInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupAllInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupArkInviteStateInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletin;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletinListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberLevelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernel.nativeinterface.am;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.api.IRobotInfoUpdateService;
import com.tencent.robot.api.impl.RobotInfoUpdateServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b*\u0001\"\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0016\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u001e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014H\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0016\u0010 \u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/robot/api/impl/RobotInfoUpdateServiceImpl;", "Lcom/tencent/robot/api/IRobotInfoUpdateService;", "", "robotUin", "", "updateRobotFace", "newName", "updateFriendRobotName", "Lm44/a;", "initProcessor", "uin", "", "isRobot", IProfileProtocolConst.PARAM_IS_FRIEND, "initUpdateListener", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "onFetchRobotProfile", "roboUin", "onFetchRobotAvatar", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfoList", "onEnterTroopMemberList", "troopUin", "Lbt2/d;", "troopRobotList", "onEnterTroopRobotManagePage", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "processor", "Lm44/a;", "com/tencent/robot/api/impl/RobotInfoUpdateServiceImpl$b", "memberInfoListener", "Lcom/tencent/robot/api/impl/RobotInfoUpdateServiceImpl$b;", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotInfoUpdateServiceImpl implements IRobotInfoUpdateService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "RobotInfoUpdateServiceImpl";

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Robot/Inject_robot_info_processor.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<m44.a>> processorClass;

    @Nullable
    private final m44.a processor = initProcessor();

    @NotNull
    private final b memberInfoListener = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u000bR<\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/api/impl/RobotInfoUpdateServiceImpl$a;", "", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lm44/a;", "Lkotlin/collections/ArrayList;", "processorClass", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "getProcessorClass$annotations", "()V", "", "TAG", "Ljava/lang/String;", "<init>", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.api.impl.RobotInfoUpdateServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ArrayList<Class<m44.a>> a() {
            return RobotInfoUpdateServiceImpl.processorClass;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/robot/api/impl/RobotInfoUpdateServiceImpl$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "", "groupCode", "Lcom/tencent/qqnt/kernel/nativeinterface/DataSource;", "dataSource", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "Lkotlin/collections/HashMap;", "members", "", "onMemberInfoChange", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements IKernelGroupListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(HashMap members, RobotInfoUpdateServiceImpl this$0, long j3) {
            Intrinsics.checkNotNullParameter(members, "$members");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (Object obj : members.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "members.values");
                MemberInfo memberInfo = (MemberInfo) obj;
                String valueOf = String.valueOf(memberInfo.uin);
                if (this$0.isRobot(valueOf)) {
                    QLog.i(RobotInfoUpdateServiceImpl.TAG, 1, "onMemberInfoChange, groupCode=" + j3 + ", robotUin: " + memberInfo.uin);
                    if (this$0.isFriend(valueOf)) {
                        String str = memberInfo.nick;
                        Intrinsics.checkNotNullExpressionValue(str, "mem.nick");
                        this$0.updateFriendRobotName(valueOf, str);
                    }
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGetGroupBulletinListResult(long j3, String str, GroupBulletinListResult groupBulletinListResult) {
            am.a(this, j3, str, groupBulletinListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupAdd(long j3) {
            am.b(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupAllInfoChange(GroupAllInfo groupAllInfo) {
            am.c(this, groupAllInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupArkInviteStateResult(long j3, GroupArkInviteStateInfo groupArkInviteStateInfo) {
            am.d(this, j3, groupArkInviteStateInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinChange(long j3, GroupBulletin groupBulletin) {
            am.e(this, j3, groupBulletin);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRemindNotify(long j3, RemindGroupBulletinMsg remindGroupBulletinMsg) {
            am.f(this, j3, remindGroupBulletinMsg);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
            am.g(this, bulletinFeedsDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
            am.h(this, bulletinFeedsDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupConfMemberChange(long j3, ArrayList arrayList) {
            am.i(this, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupDetailInfoChange(GroupDetailInfo groupDetailInfo) {
            am.j(this, groupDetailInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupEssenceListChange(long j3) {
            am.k(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupExtListUpdate(GroupExtListUpdateType groupExtListUpdateType, ArrayList arrayList) {
            am.l(this, groupExtListUpdateType, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupFirstBulletinNotify(FirstGroupBulletinInfo firstGroupBulletinInfo) {
            am.m(this, firstGroupBulletinInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupListInited(boolean z16) {
            am.n(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupListUpdate(GroupListUpdateType groupListUpdateType, ArrayList arrayList) {
            am.o(this, groupListUpdateType, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupMemberLevelInfoChange(long j3, GroupMemberLevelInfo groupMemberLevelInfo) {
            am.p(this, j3, groupMemberLevelInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUnreadCountUpdated(boolean z16, long j3, int i3) {
            am.q(this, z16, j3, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUnreadCountUpdatedV2(boolean z16, long j3, int i3, int i16, int i17, int i18) {
            am.r(this, z16, j3, i3, i16, i17, i18);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUpdated(boolean z16, ArrayList arrayList) {
            am.s(this, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUpdatedV2(boolean z16, long j3, ArrayList arrayList, ArrayList arrayList2) {
            am.t(this, z16, j3, arrayList, arrayList2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupSingleScreenNotifies(boolean z16, long j3, ArrayList arrayList) {
            am.u(this, z16, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupSingleScreenNotifiesV2(boolean z16, long j3, long j16, boolean z17, int i3, ArrayList arrayList, ArrayList arrayList2) {
            am.v(this, z16, j3, j16, z17, i3, arrayList, arrayList2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupStatisticInfoChange(long j3, GroupStatisticInfo groupStatisticInfo) {
            am.w(this, j3, groupStatisticInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupsMsgMaskResult(ArrayList arrayList) {
            am.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17) {
            am.y(this, j3, z16, z17);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onJoinGroupNotify(JoinGroupNotifyMsg joinGroupNotifyMsg) {
            am.z(this, joinGroupNotifyMsg);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onMemberInfoChange(final long groupCode, @NotNull DataSource dataSource, @NotNull final HashMap<String, MemberInfo> members) {
            Intrinsics.checkNotNullParameter(dataSource, "dataSource");
            Intrinsics.checkNotNullParameter(members, "members");
            if (members.size() > 0) {
                final RobotInfoUpdateServiceImpl robotInfoUpdateServiceImpl = RobotInfoUpdateServiceImpl.this;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.api.impl.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        RobotInfoUpdateServiceImpl.b.b(members, robotInfoUpdateServiceImpl, groupCode);
                    }
                }, 16, null, true);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onMemberListChange(GroupMemberListChangeInfo groupMemberListChangeInfo) {
            am.B(this, groupMemberListChangeInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onSearchMemberChange(String str, String str2, ArrayList arrayList, HashMap hashMap) {
            am.C(this, str, str2, arrayList, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onShutUpMemberListChanged(long j3, ArrayList arrayList) {
            am.D(this, j3, arrayList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/api/impl/RobotInfoUpdateServiceImpl$c", "Lcom/tencent/qqnt/troopmemberlist/f;", "", "isSuccess", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberList", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements com.tencent.qqnt.troopmemberlist.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap<String, bt2.d> f367410a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f367411b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f367412c;

        c(HashMap<String, bt2.d> hashMap, ArrayList<String> arrayList, String str) {
            this.f367410a = hashMap;
            this.f367411b = arrayList;
            this.f367412c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(String troopUin, ArrayList robotUidList, int i3, String str) {
            Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
            Intrinsics.checkNotNullParameter(robotUidList, "$robotUidList");
            QLog.i(RobotInfoUpdateServiceImpl.TAG, 1, "[onEnterTroopRobotManagePage] getMemberInfo. result: " + i3 + ", errMsg: " + str + ", troopUin: " + troopUin + ", robotUidListSize: " + robotUidList.size());
        }

        @Override // com.tencent.qqnt.troopmemberlist.f
        public void a(boolean isSuccess, @NotNull List<? extends TroopMemberInfo> troopMemberList) {
            AppRuntime appRuntime;
            s groupService;
            Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
            Iterator<? extends TroopMemberInfo> it = troopMemberList.iterator();
            while (true) {
                appRuntime = null;
                String str = null;
                if (!it.hasNext()) {
                    break;
                }
                TroopMemberInfo next = it.next();
                String str2 = next.memberuin;
                String str3 = next.friendnick;
                bt2.d dVar = this.f367410a.get(str2);
                if (dVar != null) {
                    str = dVar.a();
                }
                if (TextUtils.equals(str3, str)) {
                    this.f367411b.remove(str2);
                }
            }
            QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
            IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) api;
            final ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it5 = this.f367411b.iterator();
            while (it5.hasNext()) {
                String next2 = it5.next();
                String uidFromUin = iRelationNTUinAndUidApi.getUidFromUin(next2);
                if (uidFromUin != null) {
                    arrayList.add(uidFromUin);
                }
                if (QLog.isColorLevel()) {
                    QLog.i(RobotInfoUpdateServiceImpl.TAG, 2, "[onEnterTroopRobotManagePage] fetch anyway. troopUin: " + this.f367412c + ", robot.uin:" + next2);
                }
            }
            try {
                MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                if (mobileQQ != null) {
                    appRuntime = mobileQQ.peekAppRuntime();
                }
                if (appRuntime != null && arrayList.size() > 0 && (groupService = ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getGroupService()) != null) {
                    long parseLong = Long.parseLong(this.f367412c);
                    final String str4 = this.f367412c;
                    groupService.getMemberInfo(parseLong, arrayList, true, new IOperateCallback() { // from class: com.tencent.robot.api.impl.i
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i3, String str5) {
                            RobotInfoUpdateServiceImpl.c.c(str4, arrayList, i3, str5);
                        }
                    });
                }
            } catch (Exception e16) {
                QLog.i(RobotInfoUpdateServiceImpl.TAG, 1, "[onEnterTroopRobotManagePage] troop: " + this.f367412c + ", getMemberInfo exception: " + e16.getMessage());
            }
        }
    }

    static {
        ArrayList<Class<m44.a>> arrayList = new ArrayList<>();
        processorClass = arrayList;
        arrayList.add(RobotInfoUpdateProcessor.class);
    }

    @NotNull
    public static final ArrayList<Class<m44.a>> getProcessorClass() {
        return INSTANCE.a();
    }

    private final m44.a initProcessor() {
        try {
            ArrayList<Class<m44.a>> arrayList = processorClass;
            if (arrayList.size() > 0) {
                m44.a newInstance = arrayList.get(0).newInstance();
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.robot.profile.processor.IRobotProfileProcessor");
                return newInstance;
            }
            return null;
        } catch (Exception e16) {
            QLog.i(TAG, 1, "initProcessor failed. exception: " + e16.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFriend(String uin) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        Intrinsics.checkNotNullExpressionValue(uidFromUin, "api(IRelationNTUinAndUid\u2026.java).getUidFromUin(uin)");
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRobot(String uin) {
        AppRuntime appRuntime;
        ITroopRobotService iTroopRobotService;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime != null && (iTroopRobotService = (ITroopRobotService) appRuntime.getRuntimeService(ITroopRobotService.class, "all")) != null) {
            return iTroopRobotService.isRobotUin(uin);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onEnterTroopMemberList$lambda$2(List troopMemberInfoList, RobotInfoUpdateServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(troopMemberInfoList, "$troopMemberInfoList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = troopMemberInfoList.iterator();
        while (it.hasNext()) {
            TroopMemberInfo troopMemberInfo = (TroopMemberInfo) it.next();
            String str = troopMemberInfo.memberuin;
            Intrinsics.checkNotNullExpressionValue(str, "member.memberuin");
            if (this$0.isRobot(str)) {
                String str2 = troopMemberInfo.memberuin;
                Intrinsics.checkNotNullExpressionValue(str2, "member.memberuin");
                if (this$0.isFriend(str2)) {
                    QLog.i(TAG, 1, "onEnterTroopMemberList, robotUin: " + troopMemberInfo.memberuin);
                    String str3 = troopMemberInfo.memberuin;
                    Intrinsics.checkNotNullExpressionValue(str3, "member.memberuin");
                    String str4 = troopMemberInfo.friendnick;
                    Intrinsics.checkNotNullExpressionValue(str4, "member.friendnick");
                    this$0.updateFriendRobotName(str3, str4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFetchRobotAvatar$lambda$1(RobotInfoUpdateServiceImpl this$0, String roboUin) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(roboUin, "$roboUin");
        this$0.updateRobotFace(roboUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFetchRobotProfile$lambda$0(RobotInfoUpdateServiceImpl this$0, GroupRobotProfile robotProfile) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotProfile, "$robotProfile");
        this$0.updateRobotFace(String.valueOf(robotProfile.robotData.robotUin));
        if (robotProfile.isFriend && !TextUtils.isEmpty(robotProfile.robotData.name)) {
            String valueOf = String.valueOf(robotProfile.robotData.robotUin);
            String str = robotProfile.robotData.name;
            Intrinsics.checkNotNullExpressionValue(str, "robotProfile.robotData.name");
            this$0.updateFriendRobotName(valueOf, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFriendRobotName(String robotUin, String newName) {
        m44.a aVar = this.processor;
        if (aVar != null) {
            aVar.b(robotUin, newName);
        }
    }

    private final void updateRobotFace(String robotUin) {
        m44.a aVar = this.processor;
        if (aVar != null) {
            aVar.a(robotUin);
        }
    }

    @Override // com.tencent.robot.api.IRobotInfoUpdateService
    public void initUpdateListener() {
        AppRuntime appRuntime;
        IKernelService iKernelService;
        s groupService;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime != null && (iKernelService = (IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")) != null && (groupService = iKernelService.getGroupService()) != null) {
            groupService.D(this.memberInfoListener);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        AppRuntime appRuntime;
        IKernelService iKernelService;
        s groupService;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime != null && (iKernelService = (IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")) != null && (groupService = iKernelService.getGroupService()) != null) {
            groupService.x0(this.memberInfoListener);
        }
    }

    @Override // com.tencent.robot.api.IRobotInfoUpdateService
    public void onEnterTroopMemberList(@NotNull final List<? extends TroopMemberInfo> troopMemberInfoList) {
        Intrinsics.checkNotNullParameter(troopMemberInfoList, "troopMemberInfoList");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.api.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                RobotInfoUpdateServiceImpl.onEnterTroopMemberList$lambda$2(troopMemberInfoList, this);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.robot.api.IRobotInfoUpdateService
    public void onEnterTroopRobotManagePage(@NotNull String troopUin, @NotNull List<? extends bt2.d> troopRobotList) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(troopRobotList, "troopRobotList");
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (bt2.d dVar : troopRobotList) {
            arrayList.add(String.valueOf(dVar.b()));
            hashMap.put(String.valueOf(dVar.b()), dVar);
        }
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberUinListInfo(troopUin, arrayList, false, null, TAG, new c(hashMap, arrayList, troopUin));
    }

    @Override // com.tencent.robot.api.IRobotInfoUpdateService
    public void onFetchRobotAvatar(@NotNull final String roboUin) {
        Intrinsics.checkNotNullParameter(roboUin, "roboUin");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.api.impl.g
            @Override // java.lang.Runnable
            public final void run() {
                RobotInfoUpdateServiceImpl.onFetchRobotAvatar$lambda$1(RobotInfoUpdateServiceImpl.this, roboUin);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.robot.api.IRobotInfoUpdateService
    public void onFetchRobotProfile(@NotNull final GroupRobotProfile robotProfile) {
        Intrinsics.checkNotNullParameter(robotProfile, "robotProfile");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.api.impl.f
            @Override // java.lang.Runnable
            public final void run() {
                RobotInfoUpdateServiceImpl.onFetchRobotProfile$lambda$0(RobotInfoUpdateServiceImpl.this, robotProfile);
            }
        }, 16, null, true);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
    }
}
