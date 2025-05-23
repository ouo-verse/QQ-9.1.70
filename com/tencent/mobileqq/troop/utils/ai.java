package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/utils/ai;", "", "", "e", "", "str", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "detailInfo", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "memberInfo", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;", "result", "b", "Ljava/lang/Boolean;", "enable", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class ai {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ai f302012a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean enable;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25337);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f302012a = new ai();
        }
    }

    ai() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean e() {
        Boolean bool = enable;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105955", true);
        enable = Boolean.valueOf(isSwitchOn);
        return isSwitchOn;
    }

    @Nullable
    public final String a(@Nullable GroupDetailInfo detailInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) detailInfo);
        }
        if (detailInfo == null) {
            return null;
        }
        if (!e()) {
            return detailInfo.toString();
        }
        long j3 = detailInfo.groupCode;
        long j16 = detailInfo.groupUin;
        String str = detailInfo.ownerUid;
        long j17 = detailInfo.ownerUin;
        int i3 = detailInfo.groupFlag;
        int i16 = detailInfo.groupFlagExt;
        int i17 = detailInfo.maxMemberNum;
        int i18 = detailInfo.memberNum;
        int i19 = detailInfo.groupOption;
        int i26 = detailInfo.classExt;
        ai aiVar = f302012a;
        return "GroupDetailInfo{groupCode=" + j3 + ",groupUin=" + j16 + ",ownerUid=" + str + ",ownerUin=" + j17 + ",groupFlag=" + i3 + ",groupFlagExt=" + i16 + ",maxMemberNum=" + i17 + ",memberNum=" + i18 + ",groupOption=" + i19 + ",classExt=" + i26 + ",groupName=" + aiVar.d(detailInfo.groupName) + ",fingerMemo=" + detailInfo.fingerMemo + ",groupQuestion=" + detailInfo.groupQuestion + ",certType=" + detailInfo.certType + ",shutUpAllTimestamp=" + detailInfo.shutUpAllTimestamp + ",shutUpMeTimestamp=" + detailInfo.shutUpMeTimestamp + ",groupTypeFlag=" + detailInfo.groupTypeFlag + ",privilegeFlag=" + detailInfo.privilegeFlag + ",groupSecLevel=" + detailInfo.groupSecLevel + ",groupFlagExt3=" + detailInfo.groupFlagExt3 + ",isConfGroup=" + detailInfo.isConfGroup + ",isModifyConfGroupFace=" + detailInfo.isModifyConfGroupFace + ",isModifyConfGroupName=" + detailInfo.isModifyConfGroupName + ",groupFlagExt4=" + detailInfo.groupFlagExt4 + ",groupMemo=" + detailInfo.groupMemo + ",cmdUinMsgSeq=" + detailInfo.cmdUinMsgSeq + ",cmdUinJoinTime=" + detailInfo.cmdUinJoinTime + ",cmdUinUinFlag=" + detailInfo.cmdUinUinFlag + ",cmdUinMsgMask=" + detailInfo.cmdUinMsgMask + ",groupSecLevelInfo=" + detailInfo.groupSecLevelInfo + ",cmdUinPrivilege=" + detailInfo.cmdUinPrivilege + ",cmdUinFlagEx2=" + detailInfo.cmdUinFlagEx2 + ",appealDeadline=" + detailInfo.appealDeadline + ",remarkName=" + aiVar.d(detailInfo.remarkName) + ",isTop=" + detailInfo.isTop + ",groupFace=" + detailInfo.groupFace + ",cmdUinRingtoneId=" + detailInfo.cmdUinRingtoneId + ",longGroupName=" + aiVar.d(detailInfo.longGroupName) + ",autoAgreeJoinGroupUserNumForConfGroup=" + detailInfo.autoAgreeJoinGroupUserNumForConfGroup + ",autoAgreeJoinGroupUserNumForNormalGroup=" + detailInfo.autoAgreeJoinGroupUserNumForNormalGroup + ",cmdUinFlagExt3Grocery=" + detailInfo.cmdUinFlagExt3Grocery + ",groupExt=" + detailInfo.groupExt + ",msgLimitFrequency=" + detailInfo.msgLimitFrequency + ",hlGuildAppid=" + detailInfo.hlGuildAppid + ",hlGuildSubType=" + detailInfo.hlGuildSubType + ",isAllowRecallMsg=" + detailInfo.isAllowRecallMsg + ",confUin=" + detailInfo.confUin + ",confMaxMsgSeq=" + detailInfo.confMaxMsgSeq + ",confToGroupTime=" + detailInfo.confToGroupTime + ",groupSchoolInfo=" + detailInfo.groupSchoolInfo + ",activeMemberNum=" + detailInfo.activeMemberNum + ",groupGrade=" + detailInfo.groupGrade + ",groupCreateTime=" + detailInfo.groupCreateTime + ",subscriptionUin=" + detailInfo.subscriptionUin + ",subscriptionUid=" + detailInfo.subscriptionUid + ",noFingerOpenFlag=" + detailInfo.noFingerOpenFlag + ",noCodeFingerOpenFlag=" + detailInfo.noCodeFingerOpenFlag + ",isGroupFreeze=" + detailInfo.isGroupFreeze + ",allianceId=" + detailInfo.allianceId + ",groupExtOnly=" + detailInfo.groupExtOnly + ",isAllowConfGroupMemberNick=" + detailInfo.isAllowConfGroupMemberNick + ",isAllowConfGroupMemberAtAll=" + detailInfo.isAllowConfGroupMemberAtAll + ",groupClassText=" + detailInfo.groupClassText + ",groupFreezeReason=" + detailInfo.groupFreezeReason + ",headPortraitSeq=" + detailInfo.headPortraitSeq + ",cmdUinJoinMsgSeq=" + detailInfo.cmdUinJoinMsgSeq + ",cmdUinJoinRealMsgSeq=" + detailInfo.cmdUinJoinRealMsgSeq + ",groupAnswer=" + detailInfo.groupAnswer + ",groupAdminMaxNum=" + detailInfo.groupAdminMaxNum + ",inviteNoAuthNumLimit=" + detailInfo.inviteNoAuthNumLimit + ",hlGuildOrgId=" + detailInfo.hlGuildOrgId + ",isAllowHlGuildBinary=" + detailInfo.isAllowHlGuildBinary + ",localExitGroupReason=" + detailInfo.localExitGroupReason + ",groupPermissions=" + detailInfo.groupPermissions + ",wxNotifyStatus=" + detailInfo.wxNotifyStatus + ",groupGameList=" + detailInfo.groupGameList + ",selectedGameId=" + detailInfo.selectedGameId + ",}";
    }

    @Nullable
    public final String b(@Nullable GroupMemberExtListResult result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) result);
        }
        if (result == null) {
            return null;
        }
        if (!e()) {
            return result.toString();
        }
        long j3 = result.groupCode;
        long j16 = result.endUin;
        long j17 = result.dataTime;
        int i3 = result.userShowFlag;
        int i16 = result.sysShowFlag;
        int i17 = result.timeToUpdate;
        ai aiVar = f302012a;
        return "GroupMemberExtListResult{groupCode=" + j3 + ",endUin=" + j16 + ",dataTime=" + j17 + ",userShowFlag=" + i3 + ",sysShowFlag=" + i16 + ",timeToUpdate=" + i17 + ",strOwnerName=" + aiVar.d(result.strOwnerName) + ",strAdminName=" + aiVar.d(result.strAdminName) + ",levelNameSeq=" + result.levelNameSeq + ",userShowFlagNew=" + result.userShowFlagNew + ",memberInfoSeq=" + result.memberInfoSeq + ",}";
    }

    @Nullable
    public final String c(@Nullable MemberInfo memberInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) memberInfo);
        }
        if (memberInfo == null) {
            return null;
        }
        if (!e()) {
            return memberInfo.toString();
        }
        String str = memberInfo.uid;
        long j3 = memberInfo.uin;
        ai aiVar = f302012a;
        return "MemberInfo{uid=" + str + ",uin=" + j3 + ",nick=" + aiVar.d(memberInfo.nick) + ",remark=" + aiVar.d(memberInfo.remark) + ",cardType=" + memberInfo.cardType + ",cardName=" + aiVar.d(memberInfo.cardName) + ",role=" + memberInfo.role + ",shutUpTime=" + memberInfo.shutUpTime + ",isDelete=" + memberInfo.isDelete + ",isSpecialConcerned=" + memberInfo.isSpecialConcerned + ",isRobot=" + memberInfo.isRobot + ",groupHonor=" + memberInfo.groupHonor + ",memberRealLevel=" + memberInfo.memberRealLevel + ",memberLevel=" + memberInfo.memberLevel + ",globalGroupLevel=" + memberInfo.globalGroupLevel + ",globalGroupPoint=" + memberInfo.globalGroupPoint + ",memberTitleId=" + memberInfo.memberTitleId + ",memberSpecialTitle=" + memberInfo.memberSpecialTitle + ",specialTitleExpireTime=" + memberInfo.specialTitleExpireTime + ",userShowFlag=" + memberInfo.userShowFlag + ",userShowFlagNew=" + memberInfo.userShowFlagNew + ",richFlag=" + memberInfo.richFlag + ",mssVipType=" + memberInfo.mssVipType + ",bigClubLevel=" + memberInfo.bigClubLevel + ",bigClubFlag=" + memberInfo.bigClubFlag + ",autoRemark=" + aiVar.d(memberInfo.autoRemark) + ",creditLevel=" + memberInfo.creditLevel + ",joinTime=" + memberInfo.joinTime + ",lastSpeakTime=" + memberInfo.lastSpeakTime + ",memberFlag=" + memberInfo.memberFlag + ",memberFlagExt=" + memberInfo.memberFlagExt + ",memberMobileFlag=" + memberInfo.memberMobileFlag + ",memberFlagExt2=" + memberInfo.memberFlagExt2 + ",isSpecialShielded=" + memberInfo.isSpecialShielded + ",cardNameId=" + memberInfo.cardNameId + ",}";
    }

    @Nullable
    public final String d(@Nullable String str) {
        boolean z16;
        String repeat;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        if (!e()) {
            return str;
        }
        if (str.length() <= 2) {
            return str;
        }
        String substring = str.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        repeat = StringsKt__StringsJVMKt.repeat("*", str.length() - 2);
        return substring + repeat;
    }
}
