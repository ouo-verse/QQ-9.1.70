package com.tencent.qqnt.troop.filter;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfoFilter;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfoReq;
import com.tencent.qqnt.troop.filter.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/troop/filter/g;", "Lcom/tencent/qqnt/troop/filter/a;", "", IProfileProtocolConst.PARAM_TROOP_CODE, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfoReq;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "detailInfo", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "originTroopInfo", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g implements a {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.troop.filter.a
    @NotNull
    public TroopInfo a(@NotNull GroupDetailInfo detailInfo, @Nullable TroopInfo originTroopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) detailInfo, (Object) originTroopInfo);
        }
        Intrinsics.checkNotNullParameter(detailInfo, "detailInfo");
        if (originTroopInfo == null) {
            originTroopInfo = new TroopInfo(String.valueOf(detailInfo.groupCode));
        }
        originTroopInfo.troopCreditLevel = detailInfo.groupSecLevel;
        long j3 = detailInfo.confUin;
        if (j3 != 0) {
            originTroopInfo.discussUin = String.valueOf(j3);
            originTroopInfo.discussMaxSeq = detailInfo.confMaxMsgSeq;
            originTroopInfo.discussToTroopTime = detailInfo.confToGroupTime;
        }
        return originTroopInfo;
    }

    @Override // com.tencent.qqnt.troop.filter.a
    @NotNull
    public TroopInfo b(@Nullable String str, @NotNull GroupDetailInfo groupDetailInfo, @Nullable TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 4, this, str, groupDetailInfo, troopInfo);
        }
        return a.b.d(this, str, groupDetailInfo, troopInfo);
    }

    @Override // com.tencent.qqnt.troop.filter.a
    @NotNull
    public TroopInfo c(long j3, @NotNull GroupDetailInfo groupDetailInfo, @Nullable TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), groupDetailInfo, troopInfo);
        }
        return a.b.c(this, j3, groupDetailInfo, troopInfo);
    }

    @Override // com.tencent.qqnt.troop.filter.a
    public void d(@NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopInfo);
        } else {
            a.b.a(this, troopInfo);
        }
    }

    @Override // com.tencent.qqnt.troop.filter.a
    @NotNull
    public GroupDetailInfoReq e(long troopCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (GroupDetailInfoReq) iPatchRedirector.redirect((short) 2, (Object) this, troopCode);
        }
        GroupDetailInfoReq groupDetailInfoReq = new GroupDetailInfoReq();
        groupDetailInfoReq.appid = f();
        groupDetailInfoReq.groupCode = troopCode;
        groupDetailInfoReq.lastGetGroupNameTime = 0;
        GroupDetailInfoFilter groupDetailInfoFilter = new GroupDetailInfoFilter();
        groupDetailInfoFilter.groupCode = 1;
        groupDetailInfoFilter.groupSecLevel = 1;
        groupDetailInfoFilter.groupFlagExt4 = 1;
        groupDetailInfoFilter.groupFreezeReason = 1;
        groupDetailInfoFilter.allianceId = 1;
        groupDetailInfoReq.filter = groupDetailInfoFilter;
        return groupDetailInfoReq;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return a.b.b(this);
    }
}
