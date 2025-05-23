package com.tencent.qqnt.troop.filter;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.config.x;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfoFilter;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfoReq;
import com.tencent.qqnt.troop.filter.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/troop/filter/f;", "Lcom/tencent/qqnt/troop/filter/a;", "", IProfileProtocolConst.PARAM_TROOP_CODE, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfoReq;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "detailInfo", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "originTroopInfo", "a", "info", "", "d", "", "b", "Z", "isFromMsg0x26", "<init>", "(Z)V", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isFromMsg0x26;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/troop/filter/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.troop.filter.f$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63175);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        } else {
            this.isFromMsg0x26 = z16;
        }
    }

    @Override // com.tencent.qqnt.troop.filter.a
    @NotNull
    public TroopInfo a(@NotNull GroupDetailInfo detailInfo, @Nullable TroopInfo originTroopInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) detailInfo, (Object) originTroopInfo);
        }
        Intrinsics.checkNotNullParameter(detailInfo, "detailInfo");
        if (originTroopInfo == null) {
            originTroopInfo = new TroopInfo(String.valueOf(detailInfo.groupCode));
        }
        originTroopInfo.dwGroupClassExt = detailInfo.classExt;
        originTroopInfo.mGroupClassExtText = detailInfo.groupClassText;
        String str = detailInfo.groupName;
        Intrinsics.checkNotNullExpressionValue(str, "detailInfo.groupName");
        boolean z19 = false;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            originTroopInfo.troopname = detailInfo.groupName;
        }
        originTroopInfo.troopowneruin = String.valueOf(detailInfo.ownerUin);
        originTroopInfo.troopOwnerUid = detailInfo.ownerUid.toString();
        originTroopInfo.troopface = (short) detailInfo.groupFace;
        int i3 = detailInfo.memberNum;
        originTroopInfo.wMemberNum = i3;
        originTroopInfo.setMemberNumClient(i3);
        if (detailInfo.isConfGroup == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        originTroopInfo.isNewTroop = z17;
        if (detailInfo.isModifyConfGroupFace == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        originTroopInfo.hasSetNewTroopHead = z18;
        if (detailInfo.isModifyConfGroupName == 1) {
            z19 = true;
        }
        originTroopInfo.hasSetNewTroopName = z19;
        originTroopInfo.associatePubAccount = detailInfo.subscriptionUin;
        originTroopInfo.dwCmdUinJoinTime = detailInfo.cmdUinJoinTime;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 5, this, str, groupDetailInfo, troopInfo);
        }
        return a.b.d(this, str, groupDetailInfo, troopInfo);
    }

    @Override // com.tencent.qqnt.troop.filter.a
    @NotNull
    public TroopInfo c(long j3, @NotNull GroupDetailInfo groupDetailInfo, @Nullable TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), groupDetailInfo, troopInfo);
        }
        return a.b.c(this, j3, groupDetailInfo, troopInfo);
    }

    @Override // com.tencent.qqnt.troop.filter.a
    public void d(@NotNull TroopInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (this.isFromMsg0x26) {
            IMessageFacade iMessageFacade = (IMessageFacade) bg.l(IMessageFacade.class);
            if (iMessageFacade != null) {
                iMessageFacade.pullRecentGroupMsg(info.getTroopUin());
            }
            AppInterface e16 = bg.e();
            if (e16 != null) {
                x.a().c(e16, info);
            }
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
        groupDetailInfoFilter.classExt = 1;
        groupDetailInfoFilter.groupClassText = 1;
        groupDetailInfoFilter.groupName = 1;
        groupDetailInfoFilter.longGroupName = 1;
        groupDetailInfoFilter.groupFace = 1;
        groupDetailInfoFilter.subscriptionUin = 1;
        groupDetailInfoFilter.ownerUid = 1;
        groupDetailInfoFilter.ownerUin = 1L;
        groupDetailInfoFilter.cmdUinJoinTime = 1;
        groupDetailInfoFilter.isModifyConfGroupName = 1;
        groupDetailInfoFilter.isModifyConfGroupFace = 1;
        groupDetailInfoFilter.isConfGroup = 1;
        groupDetailInfoFilter.memberNum = 1;
        groupDetailInfoFilter.noFingerOpenFlag = 1;
        groupDetailInfoFilter.noCodeFingerOpenFlag = 1;
        groupDetailInfoFilter.isGroupFreeze = 1;
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
