package com.tencent.qqnt.troopmemberlist;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.inner.TroopLifecycleCallback;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberInfoListId;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListResult;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback;
import com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/qqnt/kernel/api/s;", "it", "", "invoke", "(Lcom/tencent/qqnt/kernel/api/s;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopMemberListRepo$fetchTroopMemberList$1 extends Lambda implements Function1<com.tencent.qqnt.kernel.api.s, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $forceNet;
    final /* synthetic */ String $from;
    final /* synthetic */ int $id;
    final /* synthetic */ com.tencent.qqnt.report.l $report;
    final /* synthetic */ long $time;
    final /* synthetic */ String $troopUin;
    final /* synthetic */ Long $troopUinLong;
    final /* synthetic */ String $uniqueFrom;
    final /* synthetic */ boolean $useV2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopMemberListRepo$fetchTroopMemberList$1(com.tencent.qqnt.report.l lVar, boolean z16, String str, String str2, boolean z17, Long l3, long j3, String str3, int i3) {
        super(1);
        this.$report = lVar;
        this.$useV2 = z16;
        this.$troopUin = str;
        this.$from = str2;
        this.$forceNet = z17;
        this.$troopUinLong = l3;
        this.$time = j3;
        this.$uniqueFrom = str3;
        this.$id = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, lVar, Boolean.valueOf(z16), str, str2, Boolean.valueOf(z17), l3, Long.valueOf(j3), str3, Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final com.tencent.qqnt.report.m cmdReport, final com.tencent.qqnt.report.l report, final String str, final long j3, final String uniqueFrom, final boolean z16, final int i3, final int i16, final String str2, final GroupMemberListResult groupMemberListResult) {
        Integer num;
        ArrayList<GroupMemberInfoListId> arrayList;
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        cmdReport.f();
        if (groupMemberListResult != null && (arrayList = groupMemberListResult.ids) != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        report.j(num, Integer.valueOf(i16), str2);
        TroopMemberListRepo.INSTANCE.runInSubThread(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.an
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberListRepo$fetchTroopMemberList$1.d(GroupMemberListResult.this, str, j3, uniqueFrom, z16, i16, str2, report, i3, cmdReport);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GroupMemberListResult groupMemberListResult, String str, long j3, String uniqueFrom, boolean z16, int i3, String str2, com.tencent.qqnt.report.l report, int i16, com.tencent.qqnt.report.m cmdReport) {
        long timeCost;
        TroopLifecycleCallback memberListCallbackStore;
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        TroopMemberListRepo troopMemberListRepo = TroopMemberListRepo.INSTANCE;
        ArrayList memberListData$default = TroopMemberListRepo.getMemberListData$default(troopMemberListRepo, groupMemberListResult, str, null, 4, null);
        timeCost = troopMemberListRepo.timeCost(j3);
        boolean z17 = true;
        QLog.i("TroopMemberListRepo", 1, "[fetchTroopMemberList] troopUin: " + str + ", from:" + uniqueFrom + ", forceNet:" + z16 + ", errCode:" + i3 + ". errMsg:" + str2 + ", size:" + memberListData$default.size() + ", timeCost:" + timeCost);
        report.b();
        ITroopMemberCacheService a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
        if (a16 != null) {
            a16.saveUinUid(memberListData$default);
        }
        ITroopMemberCacheService a17 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
        if (a17 != null) {
            ITroopMemberCacheService.b.a(a17, str, memberListData$default, false, false, 8, null);
        }
        memberListCallbackStore = troopMemberListRepo.getMemberListCallbackStore();
        f fVar = (f) memberListCallbackStore.f(i16);
        if (fVar != null) {
            if (i3 != 0) {
                z17 = false;
            }
            fVar.a(z17, memberListData$default);
        }
        if (z16) {
            troopMemberListRepo.onHandlerMemberListResp(str, memberListData$default);
        }
        if (i3 == 0 && z16) {
            troopMemberListRepo.updateMemberDBVersionAfterNetRsp(str);
        }
        com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i3), null, str2, 2, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.kernel.api.s sVar) {
        invoke2(sVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull com.tencent.qqnt.kernel.api.s it) {
        com.tencent.qqnt.report.m mVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            return;
        }
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.qqnt.report.a.o(this.$report, null, 1, null);
        if (this.$useV2) {
            mVar = new com.tencent.qqnt.report.m("getAllMemberListV2", this.$troopUin, "TroopMemberListRepo-fetchTroopMemberList-" + this.$from, this.$forceNet, false, 16, null);
        } else {
            mVar = new com.tencent.qqnt.report.m("getAllMemberList", this.$troopUin, "TroopMemberListRepo-fetchTroopMemberList-" + this.$from, this.$forceNet, false, 16, null);
        }
        final com.tencent.qqnt.report.m mVar2 = mVar;
        final com.tencent.qqnt.report.l lVar = this.$report;
        final String str = this.$troopUin;
        final long j3 = this.$time;
        final String str2 = this.$uniqueFrom;
        final boolean z16 = this.$forceNet;
        final int i3 = this.$id;
        IGroupMemberListCallback iGroupMemberListCallback = new IGroupMemberListCallback() { // from class: com.tencent.qqnt.troopmemberlist.am
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback
            public final void onResult(int i16, String str3, GroupMemberListResult groupMemberListResult) {
                TroopMemberListRepo$fetchTroopMemberList$1.c(com.tencent.qqnt.report.m.this, lVar, str, j3, str2, z16, i3, i16, str3, groupMemberListResult);
            }
        };
        if (this.$useV2) {
            it.getAllMemberListV2(this.$troopUinLong.longValue(), true, iGroupMemberListCallback);
        } else {
            it.getAllMemberList(this.$troopUinLong.longValue(), this.$forceNet, iGroupMemberListCallback);
        }
    }
}
