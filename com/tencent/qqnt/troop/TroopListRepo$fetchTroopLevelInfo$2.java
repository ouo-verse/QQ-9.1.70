package com.tencent.qqnt.troop;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtReq;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberExtCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class TroopListRepo$fetchTroopLevelInfo$2 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $forceNet;
    final /* synthetic */ com.tencent.qqnt.kernel.api.s $groupService;
    final /* synthetic */ com.tencent.qqnt.report.g $report;
    final /* synthetic */ GroupMemberExtReq $req;
    final /* synthetic */ String $troopUin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopListRepo$fetchTroopLevelInfo$2(String str, boolean z16, com.tencent.qqnt.kernel.api.s sVar, GroupMemberExtReq groupMemberExtReq, com.tencent.qqnt.report.g gVar) {
        super(0);
        this.$troopUin = str;
        this.$forceNet = z16;
        this.$groupService = sVar;
        this.$req = groupMemberExtReq;
        this.$report = gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16), sVar, groupMemberExtReq, gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final com.tencent.qqnt.report.g report, final com.tencent.qqnt.report.m cmdReport, final String troopUin, final int i3, final String str, final GroupMemberExtListResult groupMemberExtListResult) {
        com.tencent.qqnt.inner.b bVar;
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        report.j(null, Integer.valueOf(i3), str);
        cmdReport.f();
        if (QLog.isColorLevel()) {
            QLog.d("TroopListRepoApi", 2, "fetchTroopLevelInfo: errCode=" + i3 + ", errMsg=" + str + ", groupCode=" + troopUin + ", sysFlag=" + groupMemberExtListResult.sysShowFlag + ", userFlag=" + groupMemberExtListResult.userShowFlag + ", userFlagNew=" + groupMemberExtListResult.userShowFlagNew);
        }
        if (i3 != 0) {
            bVar = TroopListRepo.troopLevelFrequencyControl;
            bVar.e(troopUin);
            com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i3), null, str, 2, null);
            return;
        }
        com.tencent.mobileqq.troop.utils.bg.f302144a.j(new Runnable() { // from class: com.tencent.qqnt.troop.bg
            @Override // java.lang.Runnable
            public final void run() {
                TroopListRepo$fetchTroopLevelInfo$2.d(troopUin, report, groupMemberExtListResult, cmdReport, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String troopUin, com.tencent.qqnt.report.g report, GroupMemberExtListResult groupMemberExtList, com.tencent.qqnt.report.m cmdReport, int i3, String str) {
        Map map;
        com.tencent.qqnt.inner.b bVar;
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        map = TroopListRepo.troopLevelInfoReqTimeMap;
        map.put(troopUin, Long.valueOf(System.currentTimeMillis()));
        report.b();
        TroopListRepo troopListRepo = TroopListRepo.INSTANCE;
        TroopInfo troopInfoFromCache = troopListRepo.getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache != null) {
            Intrinsics.checkNotNullExpressionValue(groupMemberExtList, "groupMemberExtList");
            troopListRepo.dealTroopLevelInfo(troopInfoFromCache, groupMemberExtList);
        }
        bVar = TroopListRepo.troopLevelFrequencyControl;
        bVar.e(troopUin);
        com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i3), null, str, 2, null);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getMemberExtInfo", this.$troopUin, "TroopListRepoApi-fetchTroopLevelInfo", this.$forceNet, false, 16, null);
        com.tencent.qqnt.kernel.api.s sVar = this.$groupService;
        if (sVar != null) {
            GroupMemberExtReq groupMemberExtReq = this.$req;
            final com.tencent.qqnt.report.g gVar = this.$report;
            final String str = this.$troopUin;
            sVar.getMemberExtInfo(groupMemberExtReq, new IGroupMemberExtCallback() { // from class: com.tencent.qqnt.troop.bf
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberExtCallback
                public final void onResult(int i3, String str2, GroupMemberExtListResult groupMemberExtListResult) {
                    TroopListRepo$fetchTroopLevelInfo$2.c(com.tencent.qqnt.report.g.this, mVar, str, i3, str2, groupMemberExtListResult);
                }
            });
        }
    }
}
