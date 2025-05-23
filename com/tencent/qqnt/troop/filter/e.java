package com.tencent.qqnt.troop.filter;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfoFilter;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFilter;
import com.tencent.qqnt.kernel.nativeinterface.GroupGeoInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolInfo;
import com.tencent.qqnt.troop.filter.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/troop/filter/e;", "Lcom/tencent/qqnt/troop/filter/a;", "", IProfileProtocolConst.PARAM_TROOP_CODE, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfoReq;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "detailInfo", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "originTroopInfo", "a", "", "b", "Z", "isMember", "<init>", "(Z)V", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isMember;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/troop/filter/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.troop.filter.e$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63172);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        } else {
            this.isMember = z16;
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
        boolean z27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) detailInfo, (Object) originTroopInfo);
        }
        Intrinsics.checkNotNullParameter(detailInfo, "detailInfo");
        if (originTroopInfo == null) {
            originTroopInfo = new TroopInfo(String.valueOf(detailInfo.groupCode));
        }
        originTroopInfo.setTroopUin(String.valueOf(detailInfo.groupCode));
        originTroopInfo.nTroopGrade = detailInfo.groupGrade;
        com.tencent.qqnt.inner.g.f357168a.f(detailInfo, originTroopInfo);
        long j3 = detailInfo.privilegeFlag;
        originTroopInfo.dwAppPrivilegeFlag = j3;
        originTroopInfo.troopPrivilegeFlag = j3;
        originTroopInfo.associatePubAccount = detailInfo.subscriptionUin;
        originTroopInfo.dwGroupFlagExt3 = detailInfo.groupFlagExt3;
        boolean z28 = false;
        if (detailInfo.noFingerOpenFlag == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        originTroopInfo.mCanSearchByKeywords = z16;
        if (detailInfo.noCodeFingerOpenFlag == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        originTroopInfo.mCanSearchByTroopUin = z17;
        if (detailInfo.isConfGroup == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        originTroopInfo.isNewTroop = z18;
        if (detailInfo.isModifyConfGroupFace == 1) {
            z19 = true;
        } else {
            z19 = false;
        }
        originTroopInfo.hasSetNewTroopHead = z19;
        if (detailInfo.isModifyConfGroupName == 1) {
            z26 = true;
        } else {
            z26 = false;
        }
        originTroopInfo.hasSetNewTroopName = z26;
        originTroopInfo.troopCreateTime = detailInfo.groupCreateTime;
        originTroopInfo.dwGroupClassExt = detailInfo.classExt;
        if (QLog.isDebugVersion()) {
            QLog.d("TroopInfoForBatchFilter", 4, "[parseRsp] dwGroupClassExt:" + originTroopInfo.dwGroupClassExt);
        }
        originTroopInfo.dwAuthGroupType = detailInfo.certType;
        originTroopInfo.troopAuthenticateInfo = detailInfo.certificationText;
        long j16 = detailInfo.ownerUin;
        if (j16 != 0) {
            originTroopInfo.troopowneruin = String.valueOf(j16);
        }
        String str = detailInfo.ownerUid;
        Intrinsics.checkNotNullExpressionValue(str, "detailInfo.ownerUid");
        if (str.length() > 0) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z27) {
            originTroopInfo.troopOwnerUid = detailInfo.ownerUid;
        }
        if (TextUtils.isEmpty(originTroopInfo.troopname)) {
            originTroopInfo.troopname = detailInfo.groupName;
        }
        originTroopInfo.troopNameFromNT = detailInfo.groupName;
        originTroopInfo.mTags = TroopInfo.parseNTTags(detailInfo.tagRecord);
        originTroopInfo.mGroupClassExtText = detailInfo.groupClassText;
        originTroopInfo.isAllowHistoryMsgFlag = detailInfo.isAllowRecallMsg;
        GroupGeoInfo groupGeoInfo = detailInfo.groupGeoInfo;
        originTroopInfo.strLocation = groupGeoInfo.GeoContent;
        originTroopInfo.troopLat = (int) groupGeoInfo.getLatitude();
        originTroopInfo.troopLon = (int) groupGeoInfo.getLongitude();
        originTroopInfo.cityId = groupGeoInfo.getCityId();
        originTroopInfo.maxAdminNum = detailInfo.groupAdminMaxNum;
        originTroopInfo.wMemberMax = detailInfo.maxMemberNum;
        int i3 = detailInfo.memberNum;
        originTroopInfo.wMemberNum = i3;
        originTroopInfo.setMemberNumClient(i3);
        originTroopInfo.dwGroupFlagExt = detailInfo.groupFlagExt;
        originTroopInfo.troopTypeExt = detailInfo.groupTypeFlag;
        originTroopInfo.dwGroupFlag = detailInfo.groupFlag;
        if (originTroopInfo.isNewTroop()) {
            originTroopInfo.maxInviteMemNum = detailInfo.autoAgreeJoinGroupUserNumForConfGroup;
        } else {
            originTroopInfo.maxInviteMemNum = detailInfo.autoAgreeJoinGroupUserNumForNormalGroup;
        }
        originTroopInfo.allowMemberKick = detailInfo.isAllowConfGroupMemberNick;
        originTroopInfo.allowMemberAtAll = detailInfo.isAllowConfGroupMemberAtAll;
        String str2 = detailInfo.longGroupName;
        Intrinsics.checkNotNullExpressionValue(str2, "detailInfo.longGroupName");
        if (str2.length() > 0) {
            z28 = true;
        }
        if ((z28 && !originTroopInfo.isNewTroop) || originTroopInfo.hasSetNewTroopName) {
            String str3 = detailInfo.longGroupName;
            if (!TextUtils.isEmpty(str3)) {
                originTroopInfo.troopname = str3;
            }
        }
        originTroopInfo.mIsFreezed = detailInfo.isGroupFreeze;
        originTroopInfo.cmdUinFlagEx2 = detailInfo.cmdUinFlagEx2;
        originTroopInfo.groupFlagExt4 = detailInfo.groupFlagExt4;
        originTroopInfo.groupFreezeReason = detailInfo.groupFreezeReason;
        GroupSchoolInfo groupSchoolInfo = detailInfo.groupSchoolInfo;
        originTroopInfo.location = groupSchoolInfo.location;
        originTroopInfo.grade = groupSchoolInfo.grade;
        originTroopInfo.school = groupSchoolInfo.school;
        originTroopInfo.groupAllianceid = detailInfo.allianceId;
        originTroopInfo.activeMemberNum = detailInfo.activeMemberNum;
        if (!originTroopInfo.isMember()) {
            originTroopInfo.groupExt.essentialMsgSwitch = detailInfo.groupExt.essentialMsgSwitch;
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
        groupDetailInfoReq.appid = 200000020;
        groupDetailInfoReq.groupCode = troopCode;
        groupDetailInfoReq.lastGetGroupNameTime = 0;
        GroupDetailInfoFilter groupDetailInfoFilter = new GroupDetailInfoFilter();
        groupDetailInfoFilter.groupCode = 1;
        groupDetailInfoFilter.groupName = 1;
        groupDetailInfoFilter.groupGrade = 1;
        groupDetailInfoFilter.activeMemberNum = 1;
        groupDetailInfoFilter.groupFlagExt = 1;
        groupDetailInfoFilter.groupFlag = 1;
        groupDetailInfoFilter.certType = 1;
        groupDetailInfoFilter.certificationText = 1;
        groupDetailInfoFilter.maxMemberNum = 1;
        groupDetailInfoFilter.groupAdminMaxNum = 1;
        groupDetailInfoFilter.memberNum = 1;
        groupDetailInfoFilter.privilegeFlag = 1;
        groupDetailInfoFilter.groupTypeFlag = 1;
        groupDetailInfoFilter.groupCreateTime = 1;
        groupDetailInfoFilter.subscriptionUin = 1;
        groupDetailInfoFilter.isModifyConfGroupName = 1;
        groupDetailInfoFilter.isModifyConfGroupFace = 1;
        groupDetailInfoFilter.isConfGroup = 1;
        groupDetailInfoFilter.noFingerOpenFlag = 1;
        groupDetailInfoFilter.noCodeFingerOpenFlag = 1;
        groupDetailInfoFilter.isGroupFreeze = 1;
        groupDetailInfoFilter.allianceId = 1;
        groupDetailInfoFilter.isAllowConfGroupMemberNick = 1;
        groupDetailInfoFilter.isAllowConfGroupMemberAtAll = 1;
        groupDetailInfoFilter.longGroupName = 1;
        groupDetailInfoFilter.ownerUin = 1L;
        groupDetailInfoFilter.ownerUid = 1;
        groupDetailInfoFilter.groupGeoInfo = 1;
        groupDetailInfoFilter.classExt = 1;
        groupDetailInfoFilter.groupClassText = 1;
        groupDetailInfoFilter.groupFlagExt3 = 1;
        groupDetailInfoFilter.tagRecord = 1;
        groupDetailInfoFilter.fingerMemo = 1;
        groupDetailInfoFilter.richFingerMemo = 1;
        groupDetailInfoFilter.groupSchoolInfo = 1;
        groupDetailInfoFilter.autoAgreeJoinGroupUserNumForConfGroup = 1;
        groupDetailInfoFilter.autoAgreeJoinGroupUserNumForNormalGroup = 1;
        groupDetailInfoFilter.groupFlagExt4 = 1;
        groupDetailInfoFilter.groupFreezeReason = 1;
        groupDetailInfoFilter.isAllowRecallMsg = 1;
        if (!this.isMember) {
            GroupExtFilter groupExtFilter = new GroupExtFilter();
            groupExtFilter.essentialMsgSwitch = 1;
            groupDetailInfoFilter.groupExt = groupExtFilter;
        }
        groupDetailInfoReq.filter = groupDetailInfoFilter;
        return groupDetailInfoReq;
    }
}
