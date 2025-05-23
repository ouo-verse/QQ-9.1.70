package com.tencent.qqnt.troop.filter;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfoFilter;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfoReq;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troop.filter.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J-\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/troop/filter/d;", "Lcom/tencent/qqnt/troop/filter/a;", "", "paramName", "", "g", "T", "newValue", "originValue", "f", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", IProfileProtocolConst.PARAM_TROOP_CODE, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfoReq;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "detailInfo", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "originTroopInfo", "a", "", "c", "Ljava/util/Map;", "configMap", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final d f362709b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Integer> configMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63166);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f362709b = new d();
        configMap = new LinkedHashMap();
        Iterator<String> it = com.tencent.mobileqq.troop.config.b.f294691a.a("102391").keySet().iterator();
        while (it.hasNext()) {
            configMap.put(it.next(), 0);
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final <T> T f(String paramName, T newValue, T originValue) {
        if (g(paramName) != 1) {
            return originValue;
        }
        return newValue;
    }

    private final int g(String paramName) {
        Integer num = configMap.get(paramName);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    @Override // com.tencent.qqnt.troop.filter.a
    @NotNull
    public TroopInfo a(@NotNull GroupDetailInfo detailInfo, @Nullable TroopInfo originTroopInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) detailInfo, (Object) originTroopInfo);
        }
        Intrinsics.checkNotNullParameter(detailInfo, "detailInfo");
        if (originTroopInfo == null) {
            originTroopInfo = new TroopInfo(String.valueOf(detailInfo.groupCode));
        }
        originTroopInfo.setTroopUin(String.valueOf(detailInfo.groupCode));
        originTroopInfo.troopcode = String.valueOf(detailInfo.groupUin);
        String str = detailInfo.groupName;
        Intrinsics.checkNotNullExpressionValue(str, "detailInfo.groupName");
        boolean z26 = false;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str2 = (String) f362709b.f("groupName", detailInfo.groupName, originTroopInfo.troopNameFromNT);
            originTroopInfo.troopNameFromNT = str2;
            originTroopInfo.troopname = str2;
        } else {
            QLog.e("TroopInfoForAIOFilter", 1, "convert: detailInfo.groupName is null");
        }
        d dVar = f362709b;
        originTroopInfo.troopface = ((Number) dVar.f("groupFace", Short.valueOf((short) detailInfo.groupFace), Short.valueOf(originTroopInfo.troopface))).shortValue();
        originTroopInfo.dwGroupFlagExt = ((Number) dVar.f("groupFlagExt", Long.valueOf(detailInfo.groupFlagExt), Long.valueOf(originTroopInfo.dwGroupFlagExt))).longValue();
        if ((detailInfo.groupFlagExt & 128) == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        originTroopInfo.mMemberInvitingFlag = ((Boolean) dVar.f("groupFlagExt", Boolean.valueOf(z17), Boolean.valueOf(originTroopInfo.mMemberInvitingFlag))).booleanValue();
        originTroopInfo.dwGroupFlagExt3 = ((Number) dVar.f("groupFlagExt3", Long.valueOf(detailInfo.groupFlagExt3), Long.valueOf(originTroopInfo.dwGroupFlagExt3))).longValue();
        originTroopInfo.dwGroupFlag = ((Number) dVar.f("groupFlag", Long.valueOf(detailInfo.groupFlag), Long.valueOf(originTroopInfo.dwGroupFlag))).longValue();
        if (dVar.g("richFingerMemo") == 1) {
            com.tencent.qqnt.inner.g.f357168a.f(detailInfo, originTroopInfo);
        }
        long j3 = detailInfo.ownerUin;
        if (j3 != 0) {
            originTroopInfo.troopowneruin = (String) dVar.f("ownerUin", String.valueOf(j3), originTroopInfo.troopowneruin);
        }
        originTroopInfo.troopOwnerUid = (String) dVar.f("ownerUid", detailInfo.ownerUid, originTroopInfo.troopOwnerUid);
        originTroopInfo.dwGroupClassExt = ((Number) dVar.f("classExt", Long.valueOf(detailInfo.classExt), Long.valueOf(originTroopInfo.dwGroupClassExt))).longValue();
        originTroopInfo.dwCmdUinJoinTime = ((Number) dVar.f("cmdUinJoinTime", Long.valueOf(detailInfo.cmdUinJoinTime), Long.valueOf(originTroopInfo.dwCmdUinJoinTime))).longValue();
        originTroopInfo.troopTypeExt = ((Number) dVar.f("groupTypeFlag", Integer.valueOf(detailInfo.groupTypeFlag), Integer.valueOf(originTroopInfo.troopTypeExt))).intValue();
        originTroopInfo.cmdUinFlagEx2 = ((Number) dVar.f("cmdUinFlagEx2", Long.valueOf(detailInfo.cmdUinFlagEx2), Long.valueOf(originTroopInfo.cmdUinFlagEx2))).longValue();
        originTroopInfo.udwCmdUinRingtoneID = ((Number) dVar.f("cmdUinRingtoneId", Long.valueOf(detailInfo.cmdUinRingtoneId), Long.valueOf(originTroopInfo.udwCmdUinRingtoneID))).longValue();
        originTroopInfo.dwGagTimeStamp = ((Number) dVar.f("shutUpAllTimestamp", Long.valueOf(detailInfo.shutUpAllTimestamp), Long.valueOf(originTroopInfo.dwGagTimeStamp))).longValue();
        if (detailInfo.isConfGroup == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        originTroopInfo.isNewTroop = ((Boolean) dVar.f("isConfGroup", Boolean.valueOf(z18), Boolean.valueOf(originTroopInfo.isNewTroop))).booleanValue();
        if (detailInfo.isModifyConfGroupFace == 1) {
            z19 = true;
        } else {
            z19 = false;
        }
        originTroopInfo.hasSetNewTroopHead = ((Boolean) dVar.f("isModifyConfGroupFace", Boolean.valueOf(z19), Boolean.valueOf(originTroopInfo.hasSetNewTroopHead))).booleanValue();
        if (detailInfo.isModifyConfGroupName == 1) {
            z26 = true;
        }
        originTroopInfo.hasSetNewTroopName = ((Boolean) dVar.f("isModifyConfGroupName", Boolean.valueOf(z26), Boolean.valueOf(originTroopInfo.hasSetNewTroopName))).booleanValue();
        originTroopInfo.wMemberNum = ((Number) dVar.f("memberNum", Integer.valueOf(detailInfo.memberNum), Integer.valueOf(originTroopInfo.wMemberNum))).intValue();
        if (originTroopInfo.isNewTroop()) {
            originTroopInfo.maxInviteMemNum = ((Number) dVar.f("autoAgreeJoinGroupUserNumForConfGroup", Integer.valueOf(detailInfo.autoAgreeJoinGroupUserNumForConfGroup), Integer.valueOf(originTroopInfo.maxInviteMemNum))).intValue();
        } else {
            originTroopInfo.maxInviteMemNum = ((Number) dVar.f("autoAgreeJoinGroupUserNumForNormalGroup", Integer.valueOf(detailInfo.autoAgreeJoinGroupUserNumForNormalGroup), Integer.valueOf(originTroopInfo.maxInviteMemNum))).intValue();
        }
        originTroopInfo.nMsgLimitFreq = ((Number) dVar.f("msgLimitFrequency", Integer.valueOf(detailInfo.msgLimitFrequency), Integer.valueOf(originTroopInfo.nMsgLimitFreq))).intValue();
        originTroopInfo.isAllowHistoryMsgFlag = ((Number) dVar.f("isAllowRecallMsg", Integer.valueOf(detailInfo.isAllowRecallMsg), Integer.valueOf(originTroopInfo.isAllowHistoryMsgFlag))).intValue();
        originTroopInfo.hlGuildAppid = ((Number) dVar.f("hlGuildAppid", Long.valueOf(detailInfo.hlGuildAppid), Long.valueOf(originTroopInfo.hlGuildAppid))).longValue();
        originTroopInfo.hlGuildSubType = ((Number) dVar.f("hlGuildSubType", Long.valueOf(detailInfo.hlGuildSubType), Long.valueOf(originTroopInfo.hlGuildSubType))).longValue();
        if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isDiscToTroopEnabled()) {
            originTroopInfo.discussUin = (String) dVar.f("confUin", String.valueOf(detailInfo.confUin), originTroopInfo.discussUin);
            originTroopInfo.discussMaxSeq = ((Number) dVar.f("confMaxMsgSeq", Long.valueOf(detailInfo.confMaxMsgSeq), Long.valueOf(originTroopInfo.discussMaxSeq))).longValue();
        }
        originTroopInfo.memberRole = (MemberRole) dVar.f("cmdUinPrivilege", detailInfo.cmdUinPrivilege, originTroopInfo.memberRole);
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
        groupDetailInfoReq.appid = 200010022;
        groupDetailInfoReq.groupCode = troopCode;
        GroupDetailInfoFilter groupDetailInfoFilter = new GroupDetailInfoFilter();
        groupDetailInfoFilter.groupUin = 1;
        d dVar = f362709b;
        groupDetailInfoFilter.groupName = dVar.g("groupName");
        groupDetailInfoFilter.longGroupName = dVar.g("longGroupName");
        groupDetailInfoFilter.groupFace = dVar.g("groupFace");
        groupDetailInfoFilter.groupFlagExt = dVar.g("groupFlagExt");
        groupDetailInfoFilter.groupFlagExt3 = dVar.g("groupFlagExt3");
        groupDetailInfoFilter.groupFlag = dVar.g("groupFlag");
        groupDetailInfoFilter.richFingerMemo = dVar.g("richFingerMemo");
        groupDetailInfoFilter.ownerUin = dVar.g("ownerUin");
        groupDetailInfoFilter.ownerUid = dVar.g("ownerUid");
        groupDetailInfoFilter.classExt = dVar.g("classExt");
        groupDetailInfoFilter.cmdUinJoinTime = dVar.g("cmdUinJoinTime");
        groupDetailInfoFilter.groupTypeFlag = dVar.g("groupTypeFlag");
        groupDetailInfoFilter.cmdUinFlagEx2 = dVar.g("cmdUinFlagEx2");
        groupDetailInfoFilter.cmdUinRingtoneId = dVar.g("cmdUinRingtoneId");
        groupDetailInfoFilter.shutUpAllTimestamp = dVar.g("shutUpAllTimestamp");
        groupDetailInfoFilter.isConfGroup = dVar.g("isConfGroup");
        groupDetailInfoFilter.isModifyConfGroupFace = dVar.g("isModifyConfGroupFace");
        groupDetailInfoFilter.isModifyConfGroupName = dVar.g("isModifyConfGroupName");
        groupDetailInfoFilter.memberNum = dVar.g("memberNum");
        groupDetailInfoFilter.autoAgreeJoinGroupUserNumForConfGroup = dVar.g("autoAgreeJoinGroupUserNumForConfGroup");
        groupDetailInfoFilter.autoAgreeJoinGroupUserNumForNormalGroup = dVar.g("autoAgreeJoinGroupUserNumForNormalGroup");
        groupDetailInfoFilter.msgLimitFrequency = dVar.g("msgLimitFrequency");
        groupDetailInfoFilter.isAllowRecallMsg = dVar.g("isAllowRecallMsg");
        groupDetailInfoFilter.hlGuildAppid = dVar.g("hlGuildAppid");
        groupDetailInfoFilter.hlGuildSubType = dVar.g("hlGuildSubType");
        groupDetailInfoFilter.cmdUinPrivilege = dVar.g("cmdUinPrivilege");
        if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isDiscToTroopEnabled()) {
            groupDetailInfoFilter.confUin = dVar.g("confUin");
            groupDetailInfoFilter.confMaxMsgSeq = dVar.g("confMaxMsgSeq");
        }
        groupDetailInfoReq.filter = groupDetailInfoFilter;
        return groupDetailInfoReq;
    }
}
