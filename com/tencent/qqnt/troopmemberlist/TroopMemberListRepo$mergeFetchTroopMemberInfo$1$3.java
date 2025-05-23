package com.tencent.qqnt.troopmemberlist;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.inner.TroopLifecycleCallback;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberInfoListId;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListResult;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService;
import java.util.ArrayList;
import java.util.Iterator;
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
public final class TroopMemberListRepo$mergeFetchTroopMemberInfo$1$3 extends Lambda implements Function1<com.tencent.qqnt.kernel.api.s, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ArrayList<String> $memberUidList;
    final /* synthetic */ ArrayList<com.tencent.qqnt.troopmemberlist.merge.b> $mergedTaskList;
    final /* synthetic */ long $troopUinLong;
    final /* synthetic */ Integer $uniqueLogKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopMemberListRepo$mergeFetchTroopMemberInfo$1$3(long j3, ArrayList<com.tencent.qqnt.troopmemberlist.merge.b> arrayList, ArrayList<String> arrayList2, Integer num) {
        super(1);
        this.$troopUinLong = j3;
        this.$mergedTaskList = arrayList;
        this.$memberUidList = arrayList2;
        this.$uniqueLogKey = num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), arrayList, arrayList2, num);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(com.tencent.qqnt.report.m cmdReport, long j3, final Integer num, final ArrayList memberUidList, ArrayList arrayList, final int i3, final String str, GroupMemberListResult groupMemberListResult) {
        final ArrayList memberListData;
        Integer num2;
        ArrayList<GroupMemberInfoListId> arrayList2;
        String str2 = str;
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        Intrinsics.checkNotNullParameter(memberUidList, "$memberUidList");
        cmdReport.f();
        final String valueOf = String.valueOf(j3);
        memberListData = TroopMemberListRepo.INSTANCE.getMemberListData(groupMemberListResult, valueOf, new Function1<MemberInfo, Boolean>(memberUidList) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberListRepo$mergeFetchTroopMemberInfo$1$3$2$resultList$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<String> $memberUidList;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$memberUidList = memberUidList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) memberUidList);
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
                return Boolean.valueOf(this.$memberUidList.contains(it.uid));
            }
        });
        if (QLog.isColorLevel()) {
            QLog.i("TroopMemberListRepo", 2, "[mergeFetchTroopMemberInfo]  mark:" + num + ", errCode:" + i3 + ", errMsg:" + str2 + ", uinSize:" + memberUidList.size() + ", size:" + memberListData.size());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final com.tencent.qqnt.troopmemberlist.merge.b bVar = (com.tencent.qqnt.troopmemberlist.merge.b) it.next();
            if (bVar.c()) {
                com.tencent.qqnt.report.j d16 = bVar.d();
                if (groupMemberListResult != null && (arrayList2 = groupMemberListResult.ids) != null) {
                    num2 = Integer.valueOf(arrayList2.size());
                } else {
                    num2 = null;
                }
                d16.j(num2, Integer.valueOf(i3), str2);
                TroopMemberListRepo.INSTANCE.runInSubThread(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.at
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopMemberListRepo$mergeFetchTroopMemberInfo$1$3.d(memberListData, num, i3, str, bVar, valueOf);
                    }
                });
            }
            str2 = str;
        }
        if (i3 != 0) {
            com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i3), null, str, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ArrayList resultList, Integer num, int i3, String str, com.tencent.qqnt.troopmemberlist.merge.b task, String troopUin) {
        TroopLifecycleCallback memberListCallbackStore;
        String fetchTroopMemberTaskKey;
        Intrinsics.checkNotNullParameter(resultList, "$resultList");
        Intrinsics.checkNotNullParameter(task, "$task");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        ArrayList arrayList = new ArrayList();
        for (Object obj : resultList) {
            if (task.f().contains(((TroopMemberInfo) obj).memberUid.toString())) {
                arrayList.add(obj);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopMemberListRepo", 2, "[mergeFetchTroopMemberInfo]  mark:" + num + ", errCode:" + i3 + ", errMsg:" + str + ", from:" + task.h() + ", uinSize:" + task.f().size() + ", size:" + arrayList.size());
        }
        ITroopMemberCacheService a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
        boolean z16 = true;
        if (a16 != null) {
            a16.putMemberList(troopUin, arrayList, false, true);
        }
        if (task.f().size() == 1) {
            TroopMemberListRepo troopMemberListRepo = TroopMemberListRepo.INSTANCE;
            fetchTroopMemberTaskKey = troopMemberListRepo.getFetchTroopMemberTaskKey(troopUin, task.g().get(0), false);
            if (i3 != 0) {
                z16 = false;
            }
            troopMemberListRepo.notifySameTask(fetchTroopMemberTaskKey, z16, arrayList);
            return;
        }
        task.d().b();
        memberListCallbackStore = TroopMemberListRepo.INSTANCE.getMemberListCallbackStore();
        f fVar = (f) memberListCallbackStore.f(task.a());
        if (fVar != null) {
            if (i3 != 0) {
                z16 = false;
            }
            fVar.a(z16, arrayList);
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
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getMemberInfoForMqq", String.valueOf(this.$troopUinLong), "TroopMemberListRepo-mergeFetchTroopMemberInfo", false, true);
        for (com.tencent.qqnt.troopmemberlist.merge.b bVar : this.$mergedTaskList) {
            if (bVar.c()) {
                bVar.d().n(Integer.valueOf(bVar.f().size()));
            }
        }
        final long j3 = this.$troopUinLong;
        final ArrayList<String> arrayList = this.$memberUidList;
        final Integer num = this.$uniqueLogKey;
        final ArrayList<com.tencent.qqnt.troopmemberlist.merge.b> arrayList2 = this.$mergedTaskList;
        it.e(j3, arrayList, false, "TroopMemberListRepo-mergeFetchTroopMemberInfo", new IGroupMemberListCallback() { // from class: com.tencent.qqnt.troopmemberlist.as
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback
            public final void onResult(int i3, String str, GroupMemberListResult groupMemberListResult) {
                TroopMemberListRepo$mergeFetchTroopMemberInfo$1$3.c(com.tencent.qqnt.report.m.this, j3, num, arrayList, arrayList2, i3, str, groupMemberListResult);
            }
        });
    }
}
