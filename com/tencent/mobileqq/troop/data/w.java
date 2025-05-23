package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\"\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"$\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b*\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b*\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/data/v;", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "d", "", "a", "(Lcom/tencent/mobileqq/troop/data/v;)I", "fixedActiveMemberNum", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "Lkotlin/Pair;", "", "c", "(Lcom/tencent/mobileqq/data/troop/TroopInfo;)Lkotlin/Pair;", "troopAuthenMode", "b", "inviteMode", "qqtroop-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class w {
    public static final int a(@NotNull v vVar) {
        Intrinsics.checkNotNullParameter(vVar, "<this>");
        if (vVar.c() > vVar.i().wMemberNum) {
            return vVar.i().wMemberNum;
        }
        return vVar.c();
    }

    private static final Pair<Integer, String> b(TroopInfo troopInfo) {
        boolean z16;
        String qqStr;
        String qqStr2;
        int i3 = 1;
        if ((troopInfo.dwGroupFlagExt & 128) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (c(troopInfo).getFirst().intValue() == 3) {
            qqStr = HardCodeUtil.qqStr(R.string.e0e);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qb_string\u2026ite_description_no_entry)");
            i3 = 4;
        } else if (c(troopInfo).getFirst().intValue() == 1) {
            qqStr = HardCodeUtil.qqStr(R.string.e0b);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qb_string\u2026one_entry_without_review)");
            i3 = 5;
        } else if (z16) {
            i3 = 6;
            if (c(troopInfo).getFirst().intValue() == 6) {
                qqStr = HardCodeUtil.qqStr(R.string.e0a);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qb_string\u2026nyone_entry_with_payment)");
            } else {
                long j3 = troopInfo.troopPrivilegeFlag;
                if ((j3 & 101711872) == 0) {
                    qqStr2 = HardCodeUtil.qqStr(R.string.e0c);
                    Intrinsics.checkNotNullExpressionValue(qqStr2, "{\n                      \u2026ew)\n                    }");
                } else if ((j3 & 33554432) != 33554432 && (j3 & 67108864) != 67108864 && (j3 & 1048576) != 1048576) {
                    qqStr2 = "";
                } else {
                    qqStr2 = HardCodeUtil.qqStr(R.string.e0d);
                    Intrinsics.checkNotNullExpressionValue(qqStr2, "{\n                      \u2026ew)\n                    }");
                }
                long j16 = troopInfo.troopPrivilegeFlag;
                if ((j16 & 1048576) == 1048576) {
                    i3 = 2;
                } else if ((101711872 & j16) == 0) {
                    qqStr = qqStr2;
                    i3 = 3;
                } else if ((j16 & 33554432) == 33554432) {
                    i3 = 7;
                } else {
                    if ((j16 & 67108864) == 67108864) {
                        qqStr = qqStr2;
                    } else if (troopInfo.isOnlyTroopMemberInviteOption()) {
                        qqStr = HardCodeUtil.qqStr(R.string.e0d);
                        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qb_string\u2026le_invate_without_review)");
                    } else {
                        qqStr = qqStr2;
                        i3 = 0;
                    }
                    i3 = 8;
                }
                qqStr = qqStr2;
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.e0f);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qb_string\u2026escription_unable_invate)");
        }
        return TuplesKt.to(Integer.valueOf(i3), qqStr);
    }

    private static final Pair<Integer, String> c(TroopInfo troopInfo) {
        short s16;
        String qqStr;
        if (TroopInfo.hasPayPrivilege(troopInfo.troopPrivilegeFlag, 128) && TroopInfo.hasPayPrivilege(troopInfo.troopPrivilegeFlag, 512)) {
            qqStr = HardCodeUtil.qqStr(R.string.i7e);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.troop_info_pay_to_join)");
            s16 = 6;
        } else if (troopInfo.isOnlyTroopMemberInviteOption()) {
            qqStr = HardCodeUtil.qqStr(R.string.i76);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.troop_inf\u2026only_troop_member_invite)");
            s16 = 0;
        } else {
            s16 = troopInfo.cGroupOption;
            if (s16 != 1) {
                if (s16 != 2) {
                    if (s16 != 3) {
                        if (s16 != 4) {
                            if (s16 != 5) {
                                qqStr = "";
                            } else {
                                qqStr = HardCodeUtil.qqStr(R.string.i78);
                                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.troop_inf\u2026n_answer_question_authen)");
                            }
                        } else {
                            qqStr = HardCodeUtil.qqStr(R.string.i79);
                            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.troop_inf\u2026ion_answer_question_auto)");
                        }
                    } else {
                        qqStr = HardCodeUtil.qqStr(R.string.i7d);
                        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.troop_info_option_refuse_all)");
                    }
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.i7b);
                    Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.troop_info_option_need_verify_only)");
                }
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.i77);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.troop_info_option_allow_all)");
            }
        }
        return TuplesKt.to(Integer.valueOf(s16), qqStr);
    }

    @NotNull
    public static final TroopInfoData d(@NotNull v vVar) {
        Intrinsics.checkNotNullParameter(vVar, "<this>");
        TroopInfo i3 = vVar.i();
        TroopInfoData troopInfoData = new TroopInfoData();
        troopInfoData.allowMemberAtAll = i3.allowMemberAtAll;
        troopInfoData.allowMemberKick = i3.allowMemberKick;
        troopInfoData.bAdmin = i3.isOwnerOrAdmin();
        troopInfoData.bOwner = i3.isOwner();
        troopInfoData.cGroupOption = i3.cGroupOption;
        troopInfoData.channelSourceItem = vVar.d();
        troopInfoData.cityId = vVar.e();
        troopInfoData.dwAuthGroupType = i3.dwAuthGroupType;
        troopInfoData.dwGroupClassExt = i3.dwGroupClassExt;
        troopInfoData.dwGroupFlagExt = i3.dwGroupFlagExt;
        troopInfoData.grade = i3.grade;
        troopInfoData.groupAllianceid = i3.groupAllianceid;
        troopInfoData.groupFlagExt4 = i3.groupFlagExt4;
        troopInfoData.groupFreezeReason = i3.groupFreezeReason;
        troopInfoData.hasSetNewTroopHead = i3.hasSetNewTroopHead;
        troopInfoData.hasSetNewTroopName = i3.hasSetNewTroopName;
        troopInfoData.inviteMode = b(i3).getFirst().intValue();
        troopInfoData.inviteModeDescription = b(i3).getSecond();
        troopInfoData.isMember = i3.isMember();
        troopInfoData.isNewTroop = i3.isNewTroop;
        troopInfoData.isOnlyTroopMemberInvite = i3.isOnlyTroopMemberInviteOption();
        troopInfoData.isQidianPrivateTroop = i3.isQidianPrivateTroop();
        troopInfoData.isTroopGuild = i3.isTroopGuild();
        troopInfoData.isUseClassAvatar = i3.isUseClassAvatar();
        troopInfoData.location = i3.location;
        troopInfoData.mIsFreezed = i3.mIsFreezed;
        troopInfoData.mMemberInvitingFlag = i3.mMemberInvitingFlag;
        troopInfoData.mRichFingerMemo = i3.mRichFingerMemo;
        troopInfoData.mStrJoinAnswer = i3.joinTroopAnswer;
        troopInfoData.mStrJoinQuestion = i3.joinTroopQuestion;
        troopInfoData.mTroopClassExtText = i3.mGroupClassExtText;
        troopInfoData.mTroopCreateTime = i3.troopCreateTime;
        troopInfoData.mTroopNeedPayNumber = i3.mTroopNeedPayNumber;
        troopInfoData.mTroopPrivilegeFlag = (int) i3.troopPrivilegeFlag;
        troopInfoData.nActiveMemberNum = vVar.c();
        troopInfoData.newTroopName = i3.troopNameFromNT;
        troopInfoData.nStatOption = vVar.h();
        troopInfoData.nTroopGrade = i3.nTroopGrade;
        troopInfoData.f294880pa = vVar.g();
        troopInfoData.school = i3.school;
        troopInfoData.troopAuthen = c(i3).getSecond();
        troopInfoData.troopAuthenticateInfo = i3.troopAuthenticateInfo;
        troopInfoData.troopCode = i3.troopcode;
        troopInfoData.troopface = i3.troopface;
        troopInfoData.troopIntro = i3.fingertroopmemo;
        troopInfoData.troopLat = i3.troopLat;
        troopInfoData.troopLocation = i3.strLocation;
        troopInfoData.troopLon = i3.troopLon;
        troopInfoData.troopMemberMaxNum = i3.wMemberMax;
        troopInfoData.troopMemo = i3.troopmemo;
        troopInfoData.troopName = i3.troopname;
        troopInfoData.troopowneruin = i3.troopowneruin;
        troopInfoData.troopTags = TroopInfo.getTags(i3.mTags);
        troopInfoData.troopTypeExt = i3.troopTypeExt;
        troopInfoData.troopUin = i3.troopuin;
        troopInfoData.userFrom = vVar.j();
        troopInfoData.wMemberNum = i3.wMemberNum;
        return troopInfoData;
    }
}
