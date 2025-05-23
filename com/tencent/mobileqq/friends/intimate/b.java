package com.tencent.mobileqq.friends.intimate;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import f61.f;
import f61.h;
import f61.i;
import f61.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0x1250.oidb_0x1250$RspBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$CommonBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$CommonGroupChatInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$DateTips;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$DnaInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$FriendInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$MutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$OneGroupInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$PrefetchMutualMarkInfo;
import tencent.im.oidb.recheck_flag_info.recheck_flag_info$RecheckFlagInfo;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static IntimateInfo a(QQAppInterface qQAppInterface, oidb_0x1250$RspBody oidb_0x1250_rspbody) {
        String str;
        List<oidb_0xcf4$PrefetchMutualMarkInfo> list;
        List<oidb_0xcf4$MutualMarkInfo> list2;
        oidb_0xcf4$CommonGroupChatInfo oidb_0xcf4_commongroupchatinfo;
        List<oidb_0xcf4$OneGroupInfo> list3;
        oidb_0xcf4$FriendInfo oidb_0xcf4_friendinfo;
        int i3;
        int i16;
        oidb_0xcf4$MutualMarkInfo oidb_0xcf4_mutualmarkinfo;
        int i17;
        int i18;
        if (oidb_0x1250_rspbody != null && qQAppInterface != null) {
            IntimateInfo intimateInfo = new IntimateInfo();
            String str2 = "";
            if (!oidb_0x1250_rspbody.uint64_to_uin.has()) {
                str = "";
            } else {
                str = String.valueOf(oidb_0x1250_rspbody.uint64_to_uin.get());
            }
            intimateInfo.friendUin = str;
            intimateInfo.useNewType = true;
            if (oidb_0x1250_rspbody.msg_cur_mutual_mark_info.has() && (oidb_0xcf4_mutualmarkinfo = oidb_0x1250_rspbody.msg_cur_mutual_mark_info.get()) != null) {
                int i19 = 0;
                if (oidb_0xcf4_mutualmarkinfo.eMutualMarkNewType.has()) {
                    i17 = oidb_0xcf4_mutualmarkinfo.eMutualMarkNewType.get();
                } else {
                    i17 = 0;
                }
                intimateInfo.maskType = i17;
                if (oidb_0xcf4_mutualmarkinfo.uint32_level.has()) {
                    i18 = oidb_0xcf4_mutualmarkinfo.uint32_level.get();
                } else {
                    i18 = 0;
                }
                intimateInfo.maskLevel = i18;
                if (oidb_0xcf4_mutualmarkinfo.uint32_days.has()) {
                    i19 = oidb_0xcf4_mutualmarkinfo.uint32_days.get();
                }
                intimateInfo.maskDays = i19;
            }
            if (oidb_0x1250_rspbody.msg_friend_info.has() && (oidb_0xcf4_friendinfo = oidb_0x1250_rspbody.msg_friend_info.get()) != null) {
                int i26 = -1;
                if (oidb_0xcf4_friendinfo.uint32_add_frd_days.has()) {
                    i3 = oidb_0xcf4_friendinfo.uint32_add_frd_days.get();
                } else {
                    i3 = -1;
                }
                intimateInfo.beFriendDays = i3;
                if (oidb_0xcf4_friendinfo.uint32_add_frd_source.has()) {
                    i16 = oidb_0xcf4_friendinfo.uint32_add_frd_source.get();
                } else {
                    i16 = -1;
                }
                intimateInfo.addFriendSource = i16;
                if (oidb_0xcf4_friendinfo.uint32_add_frd_sub_source.has()) {
                    i26 = oidb_0xcf4_friendinfo.uint32_add_frd_sub_source.get();
                }
                intimateInfo.addFriendSubSource = i26;
                if (oidb_0xcf4_friendinfo.bytes_add_frd_wording.has()) {
                    str2 = oidb_0xcf4_friendinfo.bytes_add_frd_wording.get().toStringUtf8();
                }
                intimateInfo.addFriendWording = str2;
            }
            if (oidb_0x1250_rspbody.msg_common_group_chat_info.has() && (oidb_0xcf4_commongroupchatinfo = oidb_0x1250_rspbody.msg_common_group_chat_info.get()) != null) {
                if (oidb_0xcf4_commongroupchatinfo.msg_one_group_info.has()) {
                    intimateInfo.recentChatTroopInfo = IntimateInfo.CommonTroopInfo.copyFrom(oidb_0xcf4_commongroupchatinfo.msg_one_group_info.get());
                }
                if (oidb_0xcf4_commongroupchatinfo.rpt_msg_one_group_info.has() && (list3 = oidb_0xcf4_commongroupchatinfo.rpt_msg_one_group_info.get()) != null && list3.size() > 0) {
                    intimateInfo.commonTroopInfoList = new ArrayList();
                    Iterator<oidb_0xcf4$OneGroupInfo> it = list3.iterator();
                    while (it.hasNext()) {
                        IntimateInfo.CommonTroopInfo copyFrom = IntimateInfo.CommonTroopInfo.copyFrom(it.next());
                        if (copyFrom != null) {
                            intimateInfo.commonTroopInfoList.add(copyFrom);
                        }
                    }
                }
                if (oidb_0xcf4_commongroupchatinfo.bytes_wording.has()) {
                    intimateInfo.commonTroopTips = oidb_0xcf4_commongroupchatinfo.bytes_wording.get().toStringUtf8();
                }
            }
            if (oidb_0x1250_rspbody.rpt_msg_mutual_mark_info.has() && (list2 = oidb_0x1250_rspbody.rpt_msg_mutual_mark_info.get()) != null && list2.size() > 0) {
                intimateInfo.markInfoList = new ArrayList();
                Iterator<oidb_0xcf4$MutualMarkInfo> it5 = list2.iterator();
                while (it5.hasNext()) {
                    IntimateInfo.MutualMarkInfo copyFrom2 = IntimateInfo.MutualMarkInfo.copyFrom(it5.next());
                    if (copyFrom2 != null && g.n(copyFrom2.type)) {
                        intimateInfo.markInfoList.add(copyFrom2);
                    }
                }
            }
            if (oidb_0x1250_rspbody.rpt_msg_prefetch_mutual_mark_info.has() && (list = oidb_0x1250_rspbody.rpt_msg_prefetch_mutual_mark_info.get()) != null && list.size() > 0) {
                intimateInfo.prefetchMutualMarkInfoList = new ArrayList();
                Iterator<oidb_0xcf4$PrefetchMutualMarkInfo> it6 = list.iterator();
                while (it6.hasNext()) {
                    IntimateInfo.PrefetchMutualMarkInfo copyFrom3 = IntimateInfo.PrefetchMutualMarkInfo.copyFrom(it6.next());
                    if (copyFrom3 != null && g.n(copyFrom3.type)) {
                        intimateInfo.prefetchMutualMarkInfoList.add(copyFrom3);
                    }
                }
            }
            if (oidb_0x1250_rspbody.rpt_msg_dna_info.has()) {
                intimateInfo.dnaInfoList = new ArrayList();
                List<oidb_0xcf4$DnaInfo> list4 = oidb_0x1250_rspbody.rpt_msg_dna_info.get();
                if (list4 != null && list4.size() > 0) {
                    Iterator<oidb_0xcf4$DnaInfo> it7 = list4.iterator();
                    while (it7.hasNext()) {
                        IntimateInfo.DNAInfo copyFrom4 = IntimateInfo.DNAInfo.copyFrom(it7.next());
                        if (copyFrom4 != null) {
                            intimateInfo.dnaInfoList.add(copyFrom4);
                        }
                    }
                }
            }
            if (oidb_0x1250_rspbody.rpt_msg_data_tips.has()) {
                intimateInfo.memoryDayInfoList = new ArrayList();
                List<oidb_0xcf4$DateTips> list5 = oidb_0x1250_rspbody.rpt_msg_data_tips.get();
                if (list5 != null) {
                    Iterator<oidb_0xcf4$DateTips> it8 = list5.iterator();
                    while (it8.hasNext()) {
                        IntimateInfo.MemoryDayInfo copyFrom5 = IntimateInfo.MemoryDayInfo.copyFrom(it8.next());
                        if (copyFrom5 != null) {
                            intimateInfo.memoryDayInfoList.add(copyFrom5);
                        }
                    }
                }
            }
            if (oidb_0x1250_rspbody.rpt_msg_common_rspbody.has()) {
                intimateInfo.commonBodyList = new ArrayList();
                List<oidb_0xcf4$CommonBody> list6 = oidb_0x1250_rspbody.rpt_msg_common_rspbody.get();
                if (list6 != null) {
                    for (oidb_0xcf4$CommonBody oidb_0xcf4_commonbody : list6) {
                        IntimateInfo.CommonBody copyFrom6 = IntimateInfo.CommonBody.copyFrom(oidb_0xcf4_commonbody);
                        if (copyFrom6 != null) {
                            intimateInfo.commonBodyList.add(copyFrom6);
                            int i27 = copyFrom6.cmd;
                            if (i27 == 3436) {
                                intimateInfo.friendGiftInfo = IntimateInfo.FriendGiftInfo.copyFrom(copyFrom6);
                            } else if (i27 == 3399) {
                                byte[] byteArray = oidb_0xcf4_commonbody.string_oidb_body.get().toByteArray();
                                try {
                                    recheck_flag_info$RecheckFlagInfo recheck_flag_info_recheckflaginfo = new recheck_flag_info$RecheckFlagInfo();
                                    recheck_flag_info_recheckflaginfo.mergeFrom(byteArray);
                                    intimateInfo.isShowRedPoint = recheck_flag_info_recheckflaginfo.bool_has_redtouch.get();
                                    intimateInfo.mCanRecheckCount = recheck_flag_info_recheckflaginfo.uint32_recheck_num.get();
                                } catch (Exception e16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.w("intimate_relationship", 2, "parse 0xd47 body exception:" + e16.getStackTrace());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (oidb_0x1250_rspbody.rpt_msg_mutual_score_card.has()) {
                IntimateInfo.IntimateScoreCardInfo copyFrom7 = IntimateInfo.IntimateScoreCardInfo.copyFrom(oidb_0x1250_rspbody.rpt_msg_mutual_score_card.get());
                intimateInfo.scoreCardInfo = copyFrom7;
                if (copyFrom7 != null) {
                    intimateInfo.currentScore = copyFrom7.score;
                }
            }
            intimateInfo.updateTimeMills = NetConnInfoCenter.getServerTimeMillis();
            intimateInfo.isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(intimateInfo.friendUin), "IntimateInfoHelper");
            intimateInfo.commonBodies = oidb_0x1250_rspbody.rpt_msg_common_rspbody.get();
            b(qQAppInterface, oidb_0x1250_rspbody, intimateInfo);
            intimateInfo.loveTreeInfo = f.b(oidb_0x1250_rspbody.msg_love_tree_info.get());
            c(oidb_0x1250_rspbody, intimateInfo);
            d(oidb_0x1250_rspbody, intimateInfo);
            return intimateInfo;
        }
        return null;
    }

    private static void b(QQAppInterface qQAppInterface, oidb_0x1250$RspBody oidb_0x1250_rspbody, IntimateInfo intimateInfo) {
        if (oidb_0x1250_rspbody.msg_love_ach_info.has()) {
            intimateInfo.loveAchievementInfo = f61.e.a(oidb_0x1250_rspbody.msg_love_ach_info.get());
        }
        if (oidb_0x1250_rspbody.rpt_new_dna_info.has()) {
            intimateInfo.newDnaInfos = i.a(oidb_0x1250_rspbody.rpt_new_dna_info.get());
        }
        if (oidb_0x1250_rspbody.msg_empty_status.has()) {
            intimateInfo.emptyStatusInfo = f61.b.a(oidb_0x1250_rspbody.msg_empty_status.get());
        }
    }

    private static void c(oidb_0x1250$RspBody oidb_0x1250_rspbody, IntimateInfo intimateInfo) {
        if (oidb_0x1250_rspbody.rpt_mutual_mark_state.has()) {
            intimateInfo.mutualMarkList = h.a(oidb_0x1250_rspbody.rpt_mutual_mark_state.get());
        }
        if (oidb_0x1250_rspbody.rpt_activity_banner.has()) {
            intimateInfo.activityBanner = f61.a.a(oidb_0x1250_rspbody.rpt_activity_banner.get());
        }
        if (oidb_0x1250_rspbody.special_word_info.has()) {
            intimateInfo.specialWordInfo = l.a(oidb_0x1250_rspbody.special_word_info.get());
        }
    }

    private static void d(oidb_0x1250$RspBody oidb_0x1250_rspbody, IntimateInfo intimateInfo) {
        if (oidb_0x1250_rspbody.generic_cards.has()) {
            intimateInfo.genericCardInfoList = new ArrayList();
            for (int i3 = 0; i3 < oidb_0x1250_rspbody.generic_cards.size(); i3++) {
                f61.c cVar = new f61.c();
                f61.c.INSTANCE.a(cVar, oidb_0x1250_rspbody.generic_cards.get(i3));
                intimateInfo.genericCardInfoList.add(cVar);
            }
        }
    }
}
