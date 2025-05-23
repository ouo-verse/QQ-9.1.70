package com.tencent.qqnt.inner;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupCardPrefix;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.kernel.nativeinterface.GroupGeoInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatus;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troop.TroopExtDBInfoRepo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/inner/g;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSimpleInfo;", "simpleInfo", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "originTroopInfo", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "detailInfo", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExt;", "groupExtInfo", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;", "groupMemberExtList", "", "updateLevelMap", "c", "g", "f", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final g f357168a;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        public static final /* synthetic */ int[] f357169a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f357170b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62202);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[MemberRole.values().length];
            try {
                iArr[MemberRole.STRANGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MemberRole.UNSPECIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f357169a = iArr;
            int[] iArr2 = new int[GroupStatus.values().length];
            try {
                iArr2[GroupStatus.KDELETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[GroupStatus.KENABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[GroupStatus.KDISABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f357170b = iArr2;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62204);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f357168a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ TroopInfo e(g gVar, GroupMemberExtListResult groupMemberExtListResult, TroopInfo troopInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return gVar.c(groupMemberExtListResult, troopInfo, z16);
    }

    @NotNull
    public final TroopInfo a(@NotNull GroupDetailInfo detailInfo, @Nullable TroopInfo originTroopInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) detailInfo, (Object) originTroopInfo);
        }
        Intrinsics.checkNotNullParameter(detailInfo, "detailInfo");
        if (bg.f302144a.b(detailInfo.groupCode, detailInfo)) {
            if (originTroopInfo == null) {
                return new TroopInfo(String.valueOf(detailInfo.groupCode));
            }
            return originTroopInfo;
        }
        if (originTroopInfo == null) {
            originTroopInfo = new TroopInfo(String.valueOf(detailInfo.groupCode));
        }
        boolean z36 = true;
        originTroopInfo.hadInitDetail = true;
        originTroopInfo.setTroopUin(String.valueOf(detailInfo.groupCode));
        long j3 = detailInfo.groupUin;
        if (j3 != 0) {
            originTroopInfo.troopcode = String.valueOf(j3);
        }
        String str = detailInfo.groupName;
        Intrinsics.checkNotNullExpressionValue(str, "detailInfo.groupName");
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
            QLog.e("TroopInfoConverter", 1, "convert: detailInfo.groupName is null");
        }
        int i3 = detailInfo.localExitGroupReason;
        if (i3 == 2) {
            originTroopInfo.groupStatus = GroupStatus.KDELETE;
        }
        originTroopInfo.exitTroopReason = i3;
        if (QLog.isDebugVersion()) {
            QLog.d("TroopInfoConverter", 4, "[convert] detailInfo\uff0c groupCode:" + detailInfo.groupCode + ", exitTroopReason:" + detailInfo.localExitGroupReason);
        }
        originTroopInfo.troopRemark = detailInfo.remarkName;
        if (detailInfo.isConfGroup == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        originTroopInfo.isNewTroop = z17;
        originTroopInfo.wMemberMax = detailInfo.maxMemberNum;
        originTroopInfo.maxAdminNum = detailInfo.groupAdminMaxNum;
        int i16 = detailInfo.memberNum;
        originTroopInfo.wMemberNum = i16;
        originTroopInfo.setMemberNumClient(i16);
        originTroopInfo.dwGroupFlagExt = detailInfo.groupFlagExt;
        originTroopInfo.dwAuthGroupType = detailInfo.certType;
        originTroopInfo.troopCreditLevel = detailInfo.groupSecLevel;
        originTroopInfo.dwGroupFlagExt3 = detailInfo.groupFlagExt3;
        originTroopInfo.memberRole = detailInfo.cmdUinPrivilege;
        originTroopInfo.isTop = detailInfo.isTop;
        int i17 = detailInfo.privilegeFlag;
        originTroopInfo.dwAppPrivilegeFlag = i17;
        originTroopInfo.troopPrivilegeFlag = i17;
        if (detailInfo.isModifyConfGroupFace == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        originTroopInfo.hasSetNewTroopHead = z18;
        if (detailInfo.isModifyConfGroupName == 1) {
            z19 = true;
        } else {
            z19 = false;
        }
        originTroopInfo.hasSetNewTroopName = z19;
        originTroopInfo.dwGagTimeStamp = detailInfo.shutUpAllTimestamp;
        originTroopInfo.dwGagTimeStamp_me = detailInfo.shutUpMeTimestamp;
        long j16 = detailInfo.ownerUin;
        if (j16 != 0) {
            originTroopInfo.troopowneruin = String.valueOf(j16);
        }
        String str3 = detailInfo.ownerUid;
        Intrinsics.checkNotNullExpressionValue(str3, "detailInfo.ownerUid");
        if (str3.length() > 0) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26) {
            originTroopInfo.troopOwnerUid = detailInfo.ownerUid;
        }
        originTroopInfo.cGroupOption = (short) detailInfo.groupOption;
        originTroopInfo.dwGroupFlag = detailInfo.groupFlag;
        originTroopInfo.dwGroupClassExt = detailInfo.classExt;
        originTroopInfo.troopmemo = detailInfo.groupMemo;
        originTroopInfo.troopface = (short) detailInfo.groupFace;
        GroupGeoInfo groupGeoInfo = detailInfo.groupGeoInfo;
        originTroopInfo.strLocation = groupGeoInfo.GeoContent;
        originTroopInfo.troopLat = (int) groupGeoInfo.Latitude;
        originTroopInfo.troopLon = (int) groupGeoInfo.Longitude;
        originTroopInfo.cityId = groupGeoInfo.getCityId();
        if ((detailInfo.groupFlagExt & 128) == 0) {
            z27 = true;
        } else {
            z27 = false;
        }
        originTroopInfo.mMemberInvitingFlag = z27;
        originTroopInfo.mTags = TroopInfo.parseNTTags(detailInfo.tagRecord);
        originTroopInfo.troopAuthenticateInfo = detailInfo.certificationText;
        f357168a.f(detailInfo, originTroopInfo);
        originTroopInfo.dwGroupClassExt = detailInfo.classExt;
        int i18 = detailInfo.cmdUinJoinTime;
        if (i18 > 0) {
            originTroopInfo.dwCmdUinJoinTime = i18;
        }
        originTroopInfo.troopTypeExt = detailInfo.groupTypeFlag;
        originTroopInfo.cmdUinFlagEx2 = detailInfo.cmdUinFlagEx2;
        originTroopInfo.udwCmdUinRingtoneID = detailInfo.cmdUinRingtoneId;
        if (detailInfo.isConfGroup == 1) {
            z28 = true;
        } else {
            z28 = false;
        }
        originTroopInfo.isNewTroop = z28;
        originTroopInfo.wMemberNum = detailInfo.memberNum;
        if (originTroopInfo.isNewTroop()) {
            originTroopInfo.maxInviteMemNum = detailInfo.autoAgreeJoinGroupUserNumForConfGroup;
        } else {
            originTroopInfo.maxInviteMemNum = detailInfo.autoAgreeJoinGroupUserNumForNormalGroup;
        }
        originTroopInfo.inviteNoAuthLimitNum = (int) detailInfo.inviteNoAuthNumLimit;
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
        originTroopInfo.joinTroopQuestion = detailInfo.groupQuestion;
        originTroopInfo.troopmask = detailInfo.cmdUinMsgMask;
        originTroopInfo.appealDeadline = detailInfo.appealDeadline;
        originTroopInfo.associatePubAccount = detailInfo.subscriptionUin;
        GroupSchoolInfo groupSchoolInfo = detailInfo.groupSchoolInfo;
        originTroopInfo.school = groupSchoolInfo.school;
        originTroopInfo.location = groupSchoolInfo.location;
        originTroopInfo.grade = groupSchoolInfo.grade;
        originTroopInfo.nTroopGrade = detailInfo.groupGrade;
        originTroopInfo.troopCreateTime = detailInfo.groupCreateTime;
        originTroopInfo.mIsFreezed = detailInfo.isGroupFreeze;
        originTroopInfo.groupFreezeReason = detailInfo.groupFreezeReason;
        originTroopInfo.groupAllianceid = detailInfo.allianceId;
        originTroopInfo.allowMemberKick = detailInfo.isAllowConfGroupMemberNick;
        originTroopInfo.allowMemberAtAll = detailInfo.isAllowConfGroupMemberAtAll;
        originTroopInfo.mGroupClassExtText = detailInfo.groupClassText;
        originTroopInfo.joinTroopSeq = detailInfo.cmdUinJoinRealMsgSeq;
        originTroopInfo.joinTroopAnswer = detailInfo.groupAnswer;
        originTroopInfo.groupPermissions = detailInfo.groupPermissions;
        originTroopInfo.groupGameList = detailInfo.groupGameList;
        originTroopInfo.selectedGameId = detailInfo.selectedGameId;
        if (detailInfo.noFingerOpenFlag == 0) {
            z29 = true;
        } else {
            z29 = false;
        }
        originTroopInfo.mCanSearchByKeywords = z29;
        if (detailInfo.noCodeFingerOpenFlag != 0) {
            z36 = false;
        }
        originTroopInfo.mCanSearchByTroopUin = z36;
        originTroopInfo.activeMemberNum = detailInfo.activeMemberNum;
        return originTroopInfo;
    }

    @NotNull
    public final TroopInfo b(@NotNull GroupExt groupExtInfo, @NotNull TroopInfo originTroopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) groupExtInfo, (Object) originTroopInfo);
        }
        Intrinsics.checkNotNullParameter(groupExtInfo, "groupExtInfo");
        Intrinsics.checkNotNullParameter(originTroopInfo, "originTroopInfo");
        originTroopInfo.hadInitExt = true;
        GroupExt groupExt = originTroopInfo.groupExt;
        if (groupExt == null) {
            originTroopInfo.groupExt = groupExtInfo;
        } else {
            groupExt.groupInfoExtSeq = groupExtInfo.groupInfoExtSeq;
            groupExt.luckyWordId = groupExtInfo.luckyWordId;
            groupExt.lightCharNum = groupExtInfo.lightCharNum;
            groupExt.starId = groupExtInfo.starId;
            groupExt.essentialMsgSwitch = groupExtInfo.essentialMsgSwitch;
            groupExt.essentialMsgPrivilege = groupExtInfo.essentialMsgPrivilege;
            groupExt.blacklistExpireTime = groupExtInfo.blacklistExpireTime;
            groupExt.todoSeq = groupExtInfo.todoSeq;
            groupExt.hasGroupCustomPortrait = groupExtInfo.hasGroupCustomPortrait;
            groupExt.bindGuildId = groupExtInfo.bindGuildId;
            groupExt.gangUpId = groupExtInfo.gangUpId;
            groupExt.groupFlagPro1 = groupExtInfo.groupFlagPro1;
            groupExt.groupExtFlameData = groupExtInfo.groupExtFlameData;
            groupExt.groupBindGuildSwitch = groupExtInfo.groupBindGuildSwitch;
            groupExt.groupSquareSwitch = groupExtInfo.groupSquareSwitch;
            groupExt.groupAioBindGuildId = groupExtInfo.groupAioBindGuildId;
            groupExt.fullGroupExpansionSwitch = groupExtInfo.fullGroupExpansionSwitch;
            groupExt.inviteRobotSwitch = groupExtInfo.inviteRobotSwitch;
            groupExt.inviteRobotMemberSwitch = groupExtInfo.inviteRobotMemberSwitch;
            groupExt.inviteRobotMemberExamine = groupExtInfo.inviteRobotMemberExamine;
            groupExt.memberChangeGroupNameSwitch = groupExtInfo.memberChangeGroupNameSwitch;
            groupExt.topBannerSeq = groupExtInfo.topBannerSeq;
        }
        return originTroopInfo;
    }

    @NotNull
    public final TroopInfo c(@NotNull GroupMemberExtListResult groupMemberExtList, @NotNull TroopInfo originTroopInfo, boolean updateLevelMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 5, this, groupMemberExtList, originTroopInfo, Boolean.valueOf(updateLevelMap));
        }
        Intrinsics.checkNotNullParameter(groupMemberExtList, "groupMemberExtList");
        Intrinsics.checkNotNullParameter(originTroopInfo, "originTroopInfo");
        if (updateLevelMap) {
            originTroopInfo.updateTroopLevelMap(groupMemberExtList);
        }
        TroopExtDBInfo troopExtDBInfo = originTroopInfo.extDBInfo;
        troopExtDBInfo.cGroupRankUserFlag = (byte) groupMemberExtList.userShowFlag;
        troopExtDBInfo.cNewGroupRankUserFlag = (byte) groupMemberExtList.userShowFlagNew;
        TroopExtDBInfoRepo.INSTANCE.updateTroopLevelInfo(originTroopInfo.troopuin, groupMemberExtList);
        return originTroopInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00af, code lost:
    
        if (r10 == false) goto L102;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TroopInfo d(@NotNull GroupSimpleInfo simpleInfo, @Nullable TroopInfo originTroopInfo) {
        TroopInfo troopInfo;
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) simpleInfo, (Object) originTroopInfo);
        }
        Intrinsics.checkNotNullParameter(simpleInfo, "simpleInfo");
        if (bg.f302144a.c(simpleInfo.groupCode, simpleInfo)) {
            if (originTroopInfo == null) {
                return new TroopInfo(String.valueOf(simpleInfo.groupCode));
            }
            return originTroopInfo;
        }
        if (originTroopInfo == null) {
            troopInfo = new TroopInfo(String.valueOf(simpleInfo.groupCode));
        } else {
            troopInfo = originTroopInfo;
        }
        troopInfo.setTroopUin(String.valueOf(simpleInfo.groupCode));
        long j3 = simpleInfo.groupUin;
        if (j3 != 0) {
            troopInfo.troopcode = String.valueOf(j3);
            if (QLog.isDebugVersion()) {
                QLog.d("TroopInfoConverter", 4, "[convert] " + troopInfo.troopuin + ", " + troopInfo.troopcode);
            }
        }
        troopInfo.wMemberMax = simpleInfo.maxMember;
        int i3 = simpleInfo.memberCount;
        troopInfo.wMemberNum = i3;
        troopInfo.setMemberNumClient(i3);
        if (originTroopInfo != null) {
            str = originTroopInfo.troopNameFromNT;
        } else {
            str = null;
        }
        boolean z19 = false;
        if (str != null) {
            String troopNameFromNT = originTroopInfo.troopNameFromNT;
            if (troopNameFromNT != null) {
                Intrinsics.checkNotNullExpressionValue(troopNameFromNT, "troopNameFromNT");
                if (troopNameFromNT.length() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    z17 = true;
                }
            }
            z17 = false;
        }
        String str2 = simpleInfo.groupName;
        Intrinsics.checkNotNullExpressionValue(str2, "simpleInfo.groupName");
        if (str2.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str3 = simpleInfo.groupName;
            troopInfo.troopNameFromNT = str3;
            troopInfo.troopname = str3;
        } else {
            QLog.e("TroopInfoConverter", 1, "convert: simpleInfo.groupName is null");
        }
        troopInfo.isTop = simpleInfo.isTop;
        troopInfo.setTopTime = simpleInfo.toppedTimestamp;
        int i16 = simpleInfo.privilegeFlag;
        troopInfo.dwAppPrivilegeFlag = i16;
        troopInfo.troopPrivilegeFlag = i16;
        troopInfo.isNewTroop = simpleInfo.isConf;
        troopInfo.hasSetNewTroopHead = simpleInfo.hasModifyConfGroupFace;
        troopInfo.hasSetNewTroopName = simpleInfo.hasModifyConfGroupName;
        troopInfo.troopRemark = simpleInfo.remarkName;
        troopInfo.dwGagTimeStamp = simpleInfo.groupShutupExpireTime;
        troopInfo.dwGagTimeStamp_me = simpleInfo.personShutupExpireTime;
        troopInfo.discussUin = String.valueOf(simpleInfo.discussToGroupUin);
        troopInfo.discussMaxSeq = simpleInfo.discussToGroupMaxMsgSeq;
        troopInfo.discussToTroopTime = simpleInfo.discussToGroupTime;
        f357168a.g(simpleInfo, troopInfo);
        troopInfo.dwGroupFlagExt = simpleInfo.groupFlagExt;
        troopInfo.dwGroupFlagExt3 = simpleInfo.groupFlagExt3;
        troopInfo.dwAuthGroupType = simpleInfo.authGroupType;
        troopInfo.troopCreditLevel = simpleInfo.groupCreditLevel;
        troopInfo.memberRole = simpleInfo.memberRole;
        troopInfo.dwGroupInfoSeq = simpleInfo.groupInfoChangeSeq;
        troopInfo.troopmemo = simpleInfo.groupMemo.toString();
        troopInfo.dwGroupLevelSeq = simpleInfo.memberLevelNameSeq;
        troopInfo.cmdUinFlagEx2 = simpleInfo.cmdUinFlagEx2;
        troopInfo.udwCmdUinRingtoneID = simpleInfo.cmdUinRingtoneId;
        troopInfo.troopTypeExt = simpleInfo.groupTypeFlag;
        troopInfo.dwGroupClassExt = simpleInfo.groupClassExt;
        int i17 = simpleInfo.joinTime;
        if (i17 > 0) {
            troopInfo.dwCmdUinJoinTime = i17;
        }
        long j16 = simpleInfo.groupOwnerId.memberUin;
        if (j16 != 0) {
            troopInfo.troopowneruin = String.valueOf(j16);
        }
        String str4 = simpleInfo.groupOwnerId.memberUid;
        Intrinsics.checkNotNullExpressionValue(str4, "simpleInfo.groupOwnerId.memberUid");
        if (str4.length() > 0) {
            z19 = true;
        }
        if (z19) {
            troopInfo.troopOwnerUid = simpleInfo.groupOwnerId.memberUid;
        }
        troopInfo.troopowneruin = String.valueOf(simpleInfo.groupOwnerId.memberUin);
        troopInfo.troopOwnerUid = simpleInfo.groupOwnerId.memberUid;
        troopInfo.associatePubAccount = simpleInfo.subscriptionUin;
        troopInfo.mMemberNumSeq = simpleInfo.memberChangeSeq;
        int i18 = simpleInfo.memberCardChangeSeq;
        troopInfo.mMemberCardSeq = i18;
        troopInfo.appealDeadline = simpleInfo.appealDeadline;
        troopInfo.groupFlagExt4 = simpleInfo.groupFlagExt4;
        troopInfo.hlGuildAppid = simpleInfo.hlGuildAppId;
        troopInfo.hlGuildSubType = simpleInfo.hlGuildSubType;
        troopInfo.mMemberNickIconSeq = i18;
        troopInfo.troopmask = simpleInfo.cmdUinMsgMask;
        return troopInfo;
    }

    @NotNull
    public final TroopInfo f(@NotNull GroupDetailInfo detailInfo, @Nullable TroopInfo originTroopInfo) {
        String c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 7, (Object) this, (Object) detailInfo, (Object) originTroopInfo);
        }
        Intrinsics.checkNotNullParameter(detailInfo, "detailInfo");
        if (originTroopInfo == null) {
            originTroopInfo = new TroopInfo(String.valueOf(detailInfo.groupCode));
        }
        originTroopInfo.fingertroopmemo = detailInfo.fingerMemo;
        String str = detailInfo.richFingerMemo;
        originTroopInfo.mRichFingerMemo = str;
        if (TextUtils.isEmpty(str)) {
            c16 = com.tencent.mobileqq.troop.util.a.c(originTroopInfo.fingertroopmemo);
        } else {
            c16 = com.tencent.mobileqq.troop.util.a.c(originTroopInfo.mRichFingerMemo);
        }
        originTroopInfo.mRichFingerMemo = c16;
        return originTroopInfo;
    }

    @NotNull
    public final TroopInfo g(@NotNull GroupSimpleInfo simpleInfo, @Nullable TroopInfo originTroopInfo) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) simpleInfo, (Object) originTroopInfo);
        }
        Intrinsics.checkNotNullParameter(simpleInfo, "simpleInfo");
        if (originTroopInfo == null) {
            originTroopInfo = new TroopInfo(String.valueOf(simpleInfo.groupCode));
        }
        GroupStatus groupStatus = simpleInfo.groupStatus;
        originTroopInfo.groupStatus = groupStatus;
        int i16 = 0;
        if (groupStatus == GroupStatus.KDISABLE) {
            z16 = true;
        } else {
            z16 = false;
        }
        originTroopInfo.isTroopBlocked = z16;
        if (originTroopInfo.isExitByJce) {
            i16 = 3;
        } else {
            int i17 = -1;
            if (groupStatus == null) {
                i3 = -1;
            } else {
                i3 = a.f357170b[groupStatus.ordinal()];
            }
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                MemberRole memberRole = simpleInfo.memberRole;
                if (memberRole != null) {
                    i17 = a.f357169a[memberRole.ordinal()];
                }
                if (i17 == 1 || i17 == 2) {
                    i16 = 1;
                }
            } else {
                i16 = 2;
            }
        }
        originTroopInfo.exitTroopReason = i16;
        return originTroopInfo;
    }
}
