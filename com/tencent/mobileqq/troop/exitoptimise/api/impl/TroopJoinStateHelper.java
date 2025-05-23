package com.tencent.mobileqq.troop.exitoptimise.api.impl;

import com.tencent.aio.api.runtime.a;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.input.joinstate.GroupJoinStateIntent;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.exitoptimise.msgintent.TroopUiStateManageMsgIntent;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.troop.utils.p;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
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
import com.tencent.qqnt.kernel.nativeinterface.GroupSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernel.nativeinterface.am;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001 \b\u0007\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/troop/exitoptimise/api/impl/TroopJoinStateHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "e", "g", h.F, "", "from", "j", "", "isJoined", "text", "i", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Ljava/lang/String;", "curTroopUin", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "f", "Z", "isFetchDBDetailInfoRunning", "com/tencent/mobileqq/troop/exitoptimise/api/impl/TroopJoinStateHelper$b", "Lcom/tencent/mobileqq/troop/exitoptimise/api/impl/TroopJoinStateHelper$b;", "groupListener", "Lcom/tencent/qqnt/kernel/api/s;", "Lcom/tencent/qqnt/kernel/api/s;", "groupService", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Boolean;", "curIsExitState", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes19.dex */
public final class TroopJoinStateHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String curTroopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a aioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isFetchDBDetailInfoRunning;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b groupListener = new b();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private s groupService;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean curIsExitState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/exitoptimise/api/impl/TroopJoinStateHelper$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupListUpdateType;", "updateType", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSimpleInfo;", "Lkotlin/collections/ArrayList;", "groupList", "", "onGroupListUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "groupDetail", "onGroupDetailInfoChange", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements IKernelGroupListener {
        b() {
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
        public void onGroupDetailInfoChange(@Nullable GroupDetailInfo groupDetail) {
            Long l3;
            String str = null;
            if (groupDetail != null) {
                l3 = Long.valueOf(groupDetail.groupCode);
            } else {
                l3 = null;
            }
            String valueOf = String.valueOf(l3);
            String str2 = TroopJoinStateHelper.this.curTroopUin;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            } else {
                str = str2;
            }
            if (Intrinsics.areEqual(valueOf, str)) {
                TroopJoinStateHelper.this.j("onGroupDetailInfoChange");
            }
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
        public void onGroupListUpdate(@Nullable GroupListUpdateType updateType, @Nullable ArrayList<GroupSimpleInfo> groupList) {
            Object obj;
            if (groupList != null) {
                TroopJoinStateHelper troopJoinStateHelper = TroopJoinStateHelper.this;
                Iterator<T> it = groupList.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    String valueOf = String.valueOf(((GroupSimpleInfo) next).groupCode);
                    String str = troopJoinStateHelper.curTroopUin;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
                    } else {
                        obj = str;
                    }
                    if (Intrinsics.areEqual(valueOf, obj)) {
                        obj = next;
                        break;
                    }
                }
                if (((GroupSimpleInfo) obj) != null && updateType == GroupListUpdateType.REMOVE) {
                    TroopJoinStateHelper.this.j("onGroupListUpdate");
                }
            }
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
        public /* synthetic */ void onMemberInfoChange(long j3, DataSource dataSource, HashMap hashMap) {
            am.A(this, j3, dataSource, hashMap);
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

    private final void e() {
        this.isFetchDBDetailInfoRunning = false;
        Integer num = null;
        this.curIsExitState = null;
        s i3 = bg.i(null, 1, null);
        this.groupService = i3;
        if (i3 != null) {
            i3.D(this.groupListener);
        }
        String str = this.curTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str = null;
        }
        s sVar = this.groupService;
        if (sVar != null) {
            num = Integer.valueOf(sVar.hashCode());
        }
        QLog.i("TroopJoinStateHelper", 1, "[doOnCreate] curTroopUin:" + str + ", groupService:" + num);
    }

    private final void g() {
        Integer num;
        String str = this.curTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str = null;
        }
        s sVar = this.groupService;
        if (sVar != null) {
            num = Integer.valueOf(sVar.hashCode());
        } else {
            num = null;
        }
        QLog.i("TroopJoinStateHelper", 1, "[doOnDestroy] curTroopUin:" + str + ", groupService:" + num);
        s sVar2 = this.groupService;
        if (sVar2 != null) {
            sVar2.x0(this.groupListener);
        }
        this.groupService = null;
        this.curIsExitState = null;
        this.isFetchDBDetailInfoRunning = false;
    }

    private final void h() {
        j("resume");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(boolean isJoined, String text) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopJoinStateHelper", 2, "[notifyJoinStatusChange] isJoined:" + isJoined + ", text:" + text);
        }
        a aVar = this.aioContext;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().h(new GroupJoinStateIntent.GroupJoinStateChange(isJoined));
        a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().h(new TroopUiStateManageMsgIntent.UpdateInputMode(1, isJoined, text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void j(String from) {
        TroopInfo troopInfo;
        T t16;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        ITroopListRepoApi iTroopListRepoApi = (ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class);
        String str = this.curTroopUin;
        Integer num = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str = null;
        }
        boolean z16 = false;
        boolean isExit = iTroopListRepoApi.isExit(str, "TroopJoinStateHelper", false);
        if (isExit) {
            booleanRef.element = false;
            ITroopListRepoApi iTroopListRepoApi2 = (ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class);
            String str2 = this.curTroopUin;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
                str2 = null;
            }
            troopInfo = iTroopListRepoApi2.getTroopInfoFromCache(str2);
            if (troopInfo != null && troopInfo.isDisband()) {
                z16 = true;
            }
            if (z16) {
                t16 = "\u65e0\u6cd5\u5728\u5df2\u89e3\u6563\u7684\u7fa4\u804a\u4e2d\u53d1\u9001\u6d88\u606f";
            } else {
                t16 = "\u65e0\u6cd5\u5728\u5df2\u9000\u51fa\u7684\u7fa4\u804a\u4e2d\u53d1\u9001\u6d88\u606f";
            }
            objectRef.element = t16;
            ITroopInfoService iTroopInfoService = (ITroopInfoService) bg.l(ITroopInfoService.class);
            if (iTroopInfoService != null) {
                String str3 = this.curTroopUin;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
                    str3 = null;
                }
                iTroopInfoService.tryToCancelTroopHideChat(str3);
            }
        } else {
            troopInfo = null;
        }
        p.f302196a.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.exitoptimise.api.impl.TroopJoinStateHelper$tryToUpdateJoinState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TroopJoinStateHelper.this.i(booleanRef.element, objectRef.element);
            }
        });
        if (QLog.isColorLevel() || !Intrinsics.areEqual(this.curIsExitState, Boolean.valueOf(isExit))) {
            this.curIsExitState = Boolean.valueOf(isExit);
            String str4 = this.curTroopUin;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
                str4 = null;
            }
            if (troopInfo != null) {
                num = Integer.valueOf(troopInfo.exitTroopReason);
            }
            QLog.d("TroopJoinStateHelper", 1, "[tryToUpdateJoinState] from:" + from + ", curTroopUin:" + str4 + ", exitState:" + isExit + " exitTroopReason:" + num);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350639h1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "TroopJoinStateHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 3, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        a a16 = param.a();
        this.aioContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            a16 = null;
        }
        this.curTroopUin = a16.g().r().c().j();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state != 3) {
                if (state == 12) {
                    g();
                    return;
                }
                return;
            }
            h();
            return;
        }
        e();
    }
}
