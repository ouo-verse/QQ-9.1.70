package com.tencent.qqnt.troop.filter;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupCardPrefix;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfoFilter;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupGeoInfo;
import com.tencent.qqnt.troop.filter.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/troop/filter/b;", "Lcom/tencent/qqnt/troop/filter/a;", "", IProfileProtocolConst.PARAM_TROOP_CODE, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfoReq;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "detailInfo", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "originTroopInfo", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f362707b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63164);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f362707b = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.troop.filter.a
    @NotNull
    public TroopInfo a(@NotNull GroupDetailInfo detailInfo, @Nullable TroopInfo originTroopInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
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
        originTroopInfo.troopmemo = detailInfo.groupMemo;
        String str = detailInfo.groupName;
        Intrinsics.checkNotNullExpressionValue(str, "detailInfo.groupName");
        boolean z27 = false;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str2 = detailInfo.groupName;
            originTroopInfo.troopNameFromNT = str2;
            originTroopInfo.troopname = str2;
        } else {
            QLog.e("TroopBasicInfoFilter", 1, "convert: detailInfo.groupName is null");
        }
        originTroopInfo.troopface = (short) detailInfo.groupFace;
        GroupGeoInfo groupGeoInfo = detailInfo.groupGeoInfo;
        originTroopInfo.strLocation = groupGeoInfo.GeoContent;
        originTroopInfo.troopLat = (int) groupGeoInfo.Latitude;
        originTroopInfo.troopLon = (int) groupGeoInfo.Longitude;
        originTroopInfo.cityId = groupGeoInfo.getCityId();
        originTroopInfo.cGroupOption = (short) detailInfo.groupOption;
        originTroopInfo.dwAuthGroupType = detailInfo.certType;
        originTroopInfo.troopCreateTime = detailInfo.groupCreateTime;
        originTroopInfo.dwAppPrivilegeFlag = detailInfo.privilegeFlag;
        originTroopInfo.joinTroopQuestion = detailInfo.groupQuestion;
        originTroopInfo.joinTroopAnswer = detailInfo.groupAnswer;
        originTroopInfo.dwGroupFlag = detailInfo.groupFlag;
        int i3 = detailInfo.groupFlagExt;
        originTroopInfo.dwGroupFlagExt = i3;
        if ((i3 & 128) == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        originTroopInfo.mMemberInvitingFlag = z17;
        originTroopInfo.dwGroupFlagExt3 = detailInfo.groupFlagExt3;
        originTroopInfo.troopAuthenticateInfo = detailInfo.certificationText;
        com.tencent.qqnt.inner.g.f357168a.f(detailInfo, originTroopInfo);
        long j3 = detailInfo.ownerUin;
        if (j3 != 0) {
            originTroopInfo.troopowneruin = String.valueOf(j3);
        }
        String str3 = detailInfo.ownerUid;
        Intrinsics.checkNotNullExpressionValue(str3, "detailInfo.ownerUid");
        if (str3.length() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            originTroopInfo.troopOwnerUid = detailInfo.ownerUid;
        }
        originTroopInfo.dwGroupClassExt = detailInfo.classExt;
        originTroopInfo.dwCmdUinJoinTime = detailInfo.cmdUinJoinTime;
        originTroopInfo.troopTypeExt = detailInfo.groupTypeFlag;
        originTroopInfo.cmdUinFlagEx2 = detailInfo.cmdUinFlagEx2;
        originTroopInfo.udwCmdUinRingtoneID = detailInfo.cmdUinRingtoneId;
        originTroopInfo.dwGagTimeStamp = detailInfo.shutUpAllTimestamp;
        if (detailInfo.isConfGroup == 1) {
            z19 = true;
        } else {
            z19 = false;
        }
        originTroopInfo.isNewTroop = z19;
        if (detailInfo.isModifyConfGroupFace == 1) {
            z26 = true;
        } else {
            z26 = false;
        }
        originTroopInfo.hasSetNewTroopHead = z26;
        if (detailInfo.isModifyConfGroupName == 1) {
            z27 = true;
        }
        originTroopInfo.hasSetNewTroopName = z27;
        originTroopInfo.wMemberNum = detailInfo.memberNum;
        originTroopInfo.maxAdminNum = detailInfo.groupAdminMaxNum;
        if (originTroopInfo.isNewTroop()) {
            originTroopInfo.maxInviteMemNum = detailInfo.autoAgreeJoinGroupUserNumForConfGroup;
        } else {
            originTroopInfo.maxInviteMemNum = detailInfo.autoAgreeJoinGroupUserNumForNormalGroup;
        }
        originTroopInfo.cmduinFlagEx3Grocery = detailInfo.cmdUinFlagExt3Grocery;
        originTroopInfo.groupFlagExt4 = detailInfo.groupFlagExt4;
        GroupCardPrefix groupCardPrefix = detailInfo.groupCardPrefix;
        originTroopInfo.groupCardPrefix = groupCardPrefix.rptPrefix;
        originTroopInfo.groupCardPrefixIntro = groupCardPrefix.introduction;
        originTroopInfo.troopRemark = detailInfo.remarkName;
        originTroopInfo.nMsgLimitFreq = detailInfo.msgLimitFrequency;
        originTroopInfo.hlGuildAppid = detailInfo.hlGuildAppid;
        originTroopInfo.hlGuildSubType = detailInfo.hlGuildSubType;
        originTroopInfo.isAllowHistoryMsgFlag = detailInfo.isAllowRecallMsg;
        originTroopInfo.hlGuildOrgid = detailInfo.hlGuildOrgId;
        originTroopInfo.hlGuildBinary = detailInfo.isAllowHlGuildBinary;
        if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isDiscToTroopEnabled()) {
            originTroopInfo.discussUin = String.valueOf(detailInfo.confUin);
            originTroopInfo.discussMaxSeq = detailInfo.confMaxMsgSeq;
            originTroopInfo.discussToTroopTime = detailInfo.confToGroupTime;
        }
        originTroopInfo.memberRole = detailInfo.cmdUinPrivilege;
        originTroopInfo.groupPermissions = detailInfo.groupPermissions;
        originTroopInfo.groupGameList = detailInfo.groupGameList;
        originTroopInfo.selectedGameId = detailInfo.selectedGameId;
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
        groupDetailInfoReq.appid = 200010024;
        groupDetailInfoReq.groupCode = troopCode;
        GroupDetailInfoFilter groupDetailInfoFilter = new GroupDetailInfoFilter();
        groupDetailInfoFilter.groupUin = 1;
        groupDetailInfoFilter.fingerMemo = 1;
        groupDetailInfoFilter.groupSchoolInfo = 1;
        groupDetailInfoFilter.groupMemo = 1;
        groupDetailInfoFilter.groupName = 1;
        groupDetailInfoFilter.groupFace = 1;
        groupDetailInfoFilter.groupGeoInfo = 1;
        groupDetailInfoFilter.groupFlag = 1;
        groupDetailInfoFilter.groupFlagExt = 1;
        groupDetailInfoFilter.groupFlagExt3 = 1;
        groupDetailInfoFilter.certificationText = 1;
        groupDetailInfoFilter.richFingerMemo = 1;
        groupDetailInfoFilter.ownerUid = 1;
        groupDetailInfoFilter.classExt = 1;
        groupDetailInfoFilter.cmdUinJoinTime = 1;
        groupDetailInfoFilter.groupTypeFlag = 1;
        groupDetailInfoFilter.cmdUinFlagEx2 = 1;
        groupDetailInfoFilter.cmdUinRingtoneId = 1;
        groupDetailInfoFilter.shutUpAllTimestamp = 1;
        groupDetailInfoFilter.isConfGroup = 1;
        groupDetailInfoFilter.isModifyConfGroupFace = 1;
        groupDetailInfoFilter.isModifyConfGroupName = 1;
        groupDetailInfoFilter.longGroupName = 1;
        groupDetailInfoFilter.memberNum = 1;
        groupDetailInfoFilter.groupAdminMaxNum = 1;
        groupDetailInfoFilter.autoAgreeJoinGroupUserNumForConfGroup = 1;
        groupDetailInfoFilter.autoAgreeJoinGroupUserNumForNormalGroup = 1;
        groupDetailInfoFilter.cmdUinFlagExt3Grocery = 1;
        groupDetailInfoFilter.groupFlagExt4 = 1;
        groupDetailInfoFilter.groupCardPrefix = 1;
        groupDetailInfoFilter.remarkName = 1;
        groupDetailInfoFilter.msgLimitFrequency = 1;
        groupDetailInfoFilter.hlGuildAppid = 1;
        groupDetailInfoFilter.hlGuildSubType = 1;
        groupDetailInfoFilter.hlGuildOrgId = 1;
        groupDetailInfoFilter.isAllowRecallMsg = 1;
        groupDetailInfoFilter.groupCode = 1;
        groupDetailInfoFilter.groupOption = 1;
        groupDetailInfoFilter.certType = 1;
        groupDetailInfoFilter.groupCreateTime = 1;
        groupDetailInfoFilter.groupQuestion = 1;
        groupDetailInfoFilter.groupAnswer = 1;
        groupDetailInfoFilter.privilegeFlag = 1;
        if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isDiscToTroopEnabled()) {
            groupDetailInfoFilter.confUin = 1;
            groupDetailInfoFilter.confMaxMsgSeq = 1;
            groupDetailInfoFilter.confToGroupTime = 1;
        }
        groupDetailInfoFilter.cmdUinPrivilege = 1;
        groupDetailInfoReq.filter = groupDetailInfoFilter;
        return groupDetailInfoReq;
    }
}
