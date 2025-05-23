package com.tencent.qqnt.troopmemberlist;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.inner.TroopLifecycleCallback;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberInfoListId;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListResult;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService;
import java.util.ArrayList;
import java.util.List;
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
public final class TroopMemberListRepo$fetchTroopMemberUinListInfo$1 extends Lambda implements Function1<com.tencent.qqnt.kernel.api.s, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $forceNet;
    final /* synthetic */ String $from;
    final /* synthetic */ int $id;
    final /* synthetic */ com.tencent.qqnt.report.j $report;
    final /* synthetic */ String $troopUin;
    final /* synthetic */ Long $troopUinLong;
    final /* synthetic */ ArrayList<String> $uidList;
    final /* synthetic */ List<String> $uinList;
    final /* synthetic */ String $uniqueFrom;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopMemberListRepo$fetchTroopMemberUinListInfo$1(String str, String str2, boolean z16, com.tencent.qqnt.report.j jVar, ArrayList<String> arrayList, Long l3, String str3, List<String> list, int i3) {
        super(1);
        this.$from = str;
        this.$troopUin = str2;
        this.$forceNet = z16;
        this.$report = jVar;
        this.$uidList = arrayList;
        this.$troopUinLong = l3;
        this.$uniqueFrom = str3;
        this.$uinList = list;
        this.$id = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Boolean.valueOf(z16), jVar, arrayList, l3, str3, list, Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final com.tencent.qqnt.report.j report, final com.tencent.qqnt.report.m cmdReport, final String str, final String uniqueFrom, final boolean z16, final ArrayList uidList, final List list, final int i3, final int i16, final String str2, final GroupMemberListResult groupMemberListResult) {
        Integer num;
        ArrayList<GroupMemberInfoListId> arrayList;
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(uidList, "$uidList");
        if (groupMemberListResult != null && (arrayList = groupMemberListResult.ids) != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        report.j(num, Integer.valueOf(i16), str2);
        cmdReport.f();
        TroopMemberListRepo.INSTANCE.runInSubThread(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.ar
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberListRepo$fetchTroopMemberUinListInfo$1.d(GroupMemberListResult.this, str, uniqueFrom, z16, i16, str2, uidList, list, report, i3, cmdReport);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GroupMemberListResult groupMemberListResult, String str, String uniqueFrom, boolean z16, int i3, String str2, ArrayList uidList, final List list, com.tencent.qqnt.report.j report, int i16, com.tencent.qqnt.report.m cmdReport) {
        ArrayList memberListData;
        TroopLifecycleCallback memberListCallbackStore;
        String fetchTroopMemberTaskKey;
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(uidList, "$uidList");
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        TroopMemberListRepo troopMemberListRepo = TroopMemberListRepo.INSTANCE;
        memberListData = troopMemberListRepo.getMemberListData(groupMemberListResult, str, new Function1<MemberInfo, Boolean>(list) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberListRepo$fetchTroopMemberUinListInfo$1$1$1$res$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ List<String> $uinList;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$uinList = list;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull MemberInfo it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(this.$uinList.contains(String.valueOf(it.uin)));
            }
        });
        if (QLog.isColorLevel()) {
            QLog.i("TroopMemberListRepo", 2, "[fetchTroopMemberUinListInfo] from:" + uniqueFrom + ", forceNet:" + z16 + ", errCode:" + i3 + ", errMsg:" + str2 + ", uinSize:" + uidList.size() + ", size:" + memberListData.size());
        }
        ITroopMemberCacheService a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
        boolean z17 = true;
        if (a16 != null) {
            a16.putMemberList(str, memberListData, false, true);
        }
        if (list.size() == 1) {
            fetchTroopMemberTaskKey = troopMemberListRepo.getFetchTroopMemberTaskKey(str, (String) list.get(0), z16);
            if (i3 != 0) {
                z17 = false;
            }
            troopMemberListRepo.notifySameTask(fetchTroopMemberTaskKey, z17, memberListData);
        } else {
            report.b();
            memberListCallbackStore = troopMemberListRepo.getMemberListCallbackStore();
            f fVar = (f) memberListCallbackStore.f(i16);
            if (fVar != null) {
                if (i3 != 0) {
                    z17 = false;
                }
                fVar.a(z17, memberListData);
            }
        }
        if (i3 != 0) {
            com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i3), null, str2, 2, null);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.kernel.api.s sVar) {
        invoke2(sVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull com.tencent.qqnt.kernel.api.s it) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            return;
        }
        Intrinsics.checkNotNullParameter(it, "it");
        String str = "TroopMemberListRepo-fetchTroopMemberUinListInfo-" + this.$from;
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getMemberInfoForMqq", this.$troopUin, str, this.$forceNet, true);
        this.$report.n(Integer.valueOf(this.$uidList.size()));
        long longValue = this.$troopUinLong.longValue();
        final ArrayList<String> arrayList = this.$uidList;
        final boolean z16 = this.$forceNet;
        final com.tencent.qqnt.report.j jVar = this.$report;
        final String str2 = this.$troopUin;
        final String str3 = this.$uniqueFrom;
        final List<String> list = this.$uinList;
        final int i3 = this.$id;
        it.e(longValue, arrayList, z16, str, new IGroupMemberListCallback() { // from class: com.tencent.qqnt.troopmemberlist.aq
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback
            public final void onResult(int i16, String str4, GroupMemberListResult groupMemberListResult) {
                TroopMemberListRepo$fetchTroopMemberUinListInfo$1.c(com.tencent.qqnt.report.j.this, mVar, str2, str3, z16, arrayList, list, i3, i16, str4, groupMemberListResult);
            }
        });
    }
}
