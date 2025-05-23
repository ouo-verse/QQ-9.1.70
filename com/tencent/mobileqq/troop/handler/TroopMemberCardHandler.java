package com.tencent.mobileqq.troop.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.api.IVasNTFrequency;
import com.tencent.mobileqq.troop.api.config.ad;
import com.tencent.mobileqq.troop.api.handler.e;
import com.tencent.mobileqq.troop.d;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ITroopListTempApi;
import friendlist.ModifyGroupCardResp;
import friendlist.stUinInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.group.group_member_info$CustomEntry;
import tencent.im.group.group_member_info$GBarInfo;
import tencent.im.group.group_member_info$InfoCardVideoInfo;
import tencent.im.group.group_member_info$MemberGameInfo;
import tencent.im.group.group_member_info$MemberInfo;
import tencent.im.group.group_member_info$ReqBody;
import tencent.im.group.group_member_info$RspBody;
import tencent.im.group.group_member_info$RspGroupCardGetStory;
import tencent.im.troop.honor.troop_honor$GroupUserCardHonor;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopMemberCardHandler extends TroopBaseHandler implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f296240e;

    /* renamed from: f, reason: collision with root package name */
    private AppInterface f296241f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f296242a;

        a(String str) {
            this.f296242a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberCardHandler.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.troop.d
        public void a(Boolean bool, List<Object> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool, (Object) list);
                return;
            }
            if (!bool.booleanValue()) {
                QLog.e("TroopMemberCardHandler", 1, "getMemberInfoFromNT FAILED");
                TroopMemberCardHandler.this.notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_MODIFY_TROOPMEMEBER_CARD, false, null);
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(TroopMemberCardHandler.this.I2((TroopMemberInfo) it.next()));
            }
            TroopMemberCardHandler.this.notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_MODIFY_TROOPMEMEBER_CARD, true, new Object[]{arrayList, this.f296242a});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f296244a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f296245b;

        b(long j3, boolean z16) {
            this.f296244a = j3;
            this.f296245b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopMemberCardHandler.this, Long.valueOf(j3), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.troop.d
        public void a(Boolean bool, List<Object> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool, (Object) list);
                return;
            }
            if (!bool.booleanValue()) {
                QLog.e("TroopMemberCardHandler", 1, "getMemberInfoFromNT FAILED");
            }
            TroopMemberCardHandler.this.X2(list, this.f296244a, this.f296245b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements com.tencent.mobileqq.troop.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f296247a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TroopMemberCard f296248b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ITroopInfoService f296249c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TroopInfo f296250d;

        c(long j3, TroopMemberCard troopMemberCard, ITroopInfoService iTroopInfoService, TroopInfo troopInfo) {
            this.f296247a = j3;
            this.f296248b = troopMemberCard;
            this.f296249c = iTroopInfoService;
            this.f296250d = troopInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopMemberCardHandler.this, Long.valueOf(j3), troopMemberCard, iTroopInfoService, troopInfo);
            }
        }

        @Override // com.tencent.mobileqq.troop.c
        public void a(Object obj) {
            TroopMemberInfo troopMemberInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                return;
            }
            if (obj instanceof TroopMemberInfo) {
                troopMemberInfo = (TroopMemberInfo) obj;
            } else {
                troopMemberInfo = null;
            }
            TroopMemberCardHandler.this.H2(troopMemberInfo, this.f296247a, this.f296248b, this.f296249c, this.f296250d);
        }
    }

    public TroopMemberCardHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            ad.a();
            this.f296241f = appInterface;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H2(TroopMemberInfo troopMemberInfo, long j3, TroopMemberCard troopMemberCard, ITroopInfoService iTroopInfoService, TroopInfo troopInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        TroopInfo troopInfo2;
        if (((ITroopMemberInfoService) this.appRuntime.getRuntimeService(ITroopMemberInfoService.class, "")) == null) {
            return;
        }
        String valueOf = String.valueOf(troopMemberCard.memberUin);
        int i3 = troopMemberCard.titleId;
        if (i3 <= 0) {
            i3 = -100;
        }
        boolean z19 = true;
        boolean z26 = false;
        if (troopMemberInfo == null) {
            troopMemberInfo = new TroopMemberInfo(String.valueOf(j3), valueOf);
            troopMemberInfo.isTroopFollowed = false;
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.troop.change.troopmemberinfo.b bVar = new com.tencent.mobileqq.troop.change.troopmemberinfo.b();
        bVar.b(troopMemberInfo);
        boolean V2 = V2(troopMemberCard, i3, troopMemberInfo, W2(troopMemberCard, troopMemberInfo, z16));
        String str = troopMemberCard.honorList;
        if (str != null && (!str.equals(troopMemberInfo.honorList) || troopMemberCard.honorRichTag != troopMemberInfo.mHonorRichFlag)) {
            byte b16 = troopMemberCard.honorRichTag;
            if (b16 != troopMemberInfo.mHonorRichFlag) {
                z26 = true;
            }
            troopMemberInfo.honorList = troopMemberCard.honorList;
            troopMemberInfo.mHonorRichFlag = b16;
            z17 = Z2(troopMemberCard, troopMemberInfo);
            z18 = z26;
            z26 = true;
        } else {
            z19 = V2;
            z17 = false;
            z18 = false;
        }
        if (z19) {
            bVar.a(troopMemberInfo);
            bVar.c();
            if (z17) {
                ad.b(troopMemberInfo.troopuin, valueOf, troopMemberInfo.honorList, troopMemberInfo.mHonorRichFlag);
            }
            if (z18) {
                ad.c(troopInfo, troopMemberInfo);
            }
        }
        if (z26 && !TextUtils.isEmpty(this.f296241f.getAccount()) && this.f296241f.getAccount().equals(valueOf) && (troopInfo2 = iTroopInfoService.getTroopInfo(troopMemberInfo.troopuin)) != null) {
            if (!troopMemberInfo.honorList.equals(troopInfo2.extDBInfo.myHonorList) || troopMemberInfo.mHonorRichFlag != troopInfo2.extDBInfo.myHonorRichFlag) {
                ((ITroopListTempApi) QRoute.api(ITroopListTempApi.class)).updateMyTroopHonor(troopMemberInfo.troopuin, troopMemberInfo.honorList, troopMemberInfo.mHonorRichFlag);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TroopMemberCardInfo I2(TroopMemberInfo troopMemberInfo) {
        TroopMemberCardInfo troopMemberCardInfo = new TroopMemberCardInfo();
        troopMemberCardInfo.troopuin = troopMemberInfo.troopuin;
        troopMemberCardInfo.memberuin = troopMemberInfo.memberuin;
        TroopMemberNickInfo troopMemberNickInfo = troopMemberInfo.nickInfo;
        if (troopMemberNickInfo != null) {
            troopMemberCardInfo.name = troopMemberNickInfo.getTroopNick();
            troopMemberCardInfo.nick = troopMemberInfo.nickInfo.getFriendNick();
            troopMemberCardInfo.colorNick = troopMemberInfo.nickInfo.getColorNick();
            troopMemberCardInfo.colorNickId = troopMemberInfo.nickInfo.getColorNickId();
        }
        return troopMemberCardInfo;
    }

    private void J2(String str, ArrayList<String> arrayList, d dVar) {
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).fetchTroopMemberInfoByUins(str, arrayList, true, null, "TroopMemberCardHandler-friend-card", dVar);
    }

    private void N2(TroopMemberCard troopMemberCard, group_member_info$MemberInfo group_member_info_memberinfo) {
        if (group_member_info_memberinfo.uint32_concern_type.has()) {
            int i3 = group_member_info_memberinfo.uint32_concern_type.get();
            if (i3 == 0) {
                troopMemberCard.isConcerned = false;
                troopMemberCard.mIsShield = false;
                return;
            } else if (i3 == 1) {
                troopMemberCard.isConcerned = true;
                troopMemberCard.mIsShield = false;
                return;
            } else {
                if (i3 == 2) {
                    troopMemberCard.isConcerned = false;
                    troopMemberCard.mIsShield = true;
                    return;
                }
                return;
            }
        }
        troopMemberCard.isConcerned = group_member_info_memberinfo.bool_is_concerned.get();
    }

    private void O2(TroopMemberCard troopMemberCard, group_member_info$MemberInfo group_member_info_memberinfo) {
        if (group_member_info_memberinfo.bool_location_shared.has() && group_member_info_memberinfo.bool_location_shared.get() && group_member_info_memberinfo.uint64_distance.has()) {
            troopMemberCard.distance = group_member_info_memberinfo.uint64_distance.get();
        } else if (group_member_info_memberinfo.bool_location_shared.has() && !group_member_info_memberinfo.bool_location_shared.get()) {
            troopMemberCard.distance = TroopMemberInfo.VALUE_MEMBER_CLOSE_SHARE_LBS;
        } else {
            troopMemberCard.distance = -100L;
        }
    }

    private void P2(TroopMemberCard troopMemberCard, group_member_info$MemberInfo group_member_info_memberinfo) {
        if (group_member_info_memberinfo.msg_game_info.has()) {
            group_member_info$MemberGameInfo group_member_info_membergameinfo = group_member_info_memberinfo.msg_game_info.get();
            TroopMemberCard.MemberGameInfo memberGameInfo = new TroopMemberCard.MemberGameInfo();
            memberGameInfo.gameName = group_member_info_membergameinfo.str_game_name.get();
            memberGameInfo.levelName = group_member_info_membergameinfo.str_level_name.get();
            memberGameInfo.levelIcon = group_member_info_membergameinfo.str_level_icon.get();
            memberGameInfo.gameFontColor = group_member_info_membergameinfo.str_game_font_color.get();
            memberGameInfo.gameBackGroundColor = group_member_info_membergameinfo.str_game_background_color.get();
            memberGameInfo.gameUrl = group_member_info_membergameinfo.str_game_url.get();
            List<String> list = group_member_info_membergameinfo.str_desc_info.get();
            memberGameInfo.descInfo = new ArrayList<>();
            if (list != null && list.size() > 0) {
                memberGameInfo.descInfo.addAll(list);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberCardHandler", 2, "desc=", list.get(0));
                }
            }
            troopMemberCard.mMemberGameInfo = memberGameInfo;
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberCardHandler", 2, "gameInfo, gameName=", memberGameInfo.gameName, ", levelName=", memberGameInfo.levelName, ", gameUrl=", memberGameInfo.gameUrl, ", levelIcon=", memberGameInfo.levelIcon, ", gameFontColor=", memberGameInfo.gameFontColor, ", gameBackGroundColor=", memberGameInfo.gameBackGroundColor);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberCardHandler", 2, "has no game info");
        }
    }

    private void Q2(group_member_info$RspBody group_member_info_rspbody, long j3, TroopMemberCard troopMemberCard) {
        int i3;
        int i16;
        group_member_info$MemberInfo group_member_info_memberinfo = group_member_info_rspbody.msg_meminfo.get();
        troopMemberCard.result = group_member_info_memberinfo.uint32_result.get();
        troopMemberCard.isAllowModCard = group_member_info_memberinfo.bool_is_allow_mod_card.get();
        troopMemberCard.memberUin = group_member_info_memberinfo.uint64_uin.get();
        troopMemberCard.isFriend = group_member_info_memberinfo.bool_is_friend.get();
        troopMemberCard.credit = group_member_info_memberinfo.uint32_credit.get();
        N2(troopMemberCard, group_member_info_memberinfo);
        troopMemberCard.sex = -1;
        if (group_member_info_memberinfo.uint32_sex.has()) {
            troopMemberCard.sex = group_member_info_memberinfo.uint32_sex.get();
        }
        troopMemberCard.location = "";
        if (group_member_info_memberinfo.str_location.has()) {
            troopMemberCard.location = group_member_info_memberinfo.str_location.get().toStringUtf8();
        }
        troopMemberCard.age = group_member_info_memberinfo.uint32_age.get();
        troopMemberCard.nick = "";
        troopMemberCard.remark = "";
        troopMemberCard.card = "";
        if (group_member_info_memberinfo.str_nick.has()) {
            troopMemberCard.nick = group_member_info_memberinfo.str_nick.get().toStringUtf8();
        }
        if (group_member_info_memberinfo.str_remark.has()) {
            troopMemberCard.remark = group_member_info_memberinfo.str_remark.get().toStringUtf8();
        }
        troopMemberCard.levelName = group_member_info_memberinfo.str_lev.get().toStringUtf8();
        if (group_member_info_memberinfo.medal_id.has() && group_member_info_memberinfo.medal_id.get() > 0) {
            troopMemberCard.titleId = group_member_info_memberinfo.medal_id.get();
        }
        if (group_member_info_memberinfo.bytes_group_honor.has()) {
            troopMemberCard.realLevel = a3(group_member_info_memberinfo.bytes_group_honor.get().toByteArray());
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberCardHandler", 2, "handleGetTroopMemberCard, troopUin=" + j3 + ", memberUin=" + troopMemberCard.memberUin + ", titleId=" + troopMemberCard.titleId + ", lastSpeak=" + troopMemberCard.lastSpeak);
        }
        troopMemberCard.memberRole = -1;
        if (group_member_info_memberinfo.uint32_role.has()) {
            troopMemberCard.memberRole = group_member_info_memberinfo.uint32_role.get();
        }
        troopMemberCard.joinTime = group_member_info_memberinfo.uint64_join.get();
        troopMemberCard.lastSpeak = group_member_info_memberinfo.uint64_last_speak.get();
        troopMemberCard.isVip = group_member_info_memberinfo.bool_is_vip.get();
        troopMemberCard.isYearVip = group_member_info_memberinfo.bool_is_year_vip.get();
        troopMemberCard.isSuperVip = group_member_info_memberinfo.bool_is_super_vip.get();
        troopMemberCard.isSuperQQ = group_member_info_memberinfo.bool_is_super_qq.get();
        troopMemberCard.vipLevel = group_member_info_memberinfo.uint32_vip_lev.get();
        troopMemberCard.gbarTitle = group_member_info_memberinfo.str_gbar_title.get().toStringUtf8();
        troopMemberCard.gbarLinkUrl = group_member_info_memberinfo.str_gbar_url.get().toStringUtf8();
        troopMemberCard.gbarCount = group_member_info_memberinfo.uint32_gbar_cnt.get();
        troopMemberCard.gbarList = new ArrayList();
        if (group_member_info_memberinfo.uint32_special_title_expire_time.has() && (group_member_info_memberinfo.uint32_special_title_expire_time.get() == -1 || group_member_info_memberinfo.uint32_special_title_expire_time.get() - NetConnInfoCenter.getServerTime() > 0)) {
            if (group_member_info_memberinfo.bytes_special_title.has()) {
                troopMemberCard.mUniqueTitle = group_member_info_memberinfo.bytes_special_title.get().toStringUtf8();
            }
            troopMemberCard.mUniqueTitleExpire = group_member_info_memberinfo.uint32_special_title_expire_time.get();
        }
        List<group_member_info$GBarInfo> list = group_member_info_memberinfo.rpt_msg_gbar_concerned.get();
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        for (int i17 = 0; i17 < i3; i17++) {
            group_member_info$GBarInfo group_member_info_gbarinfo = list.get(i17);
            TroopMemberCard.GBarInfo gBarInfo = new TroopMemberCard.GBarInfo();
            gBarInfo.gbarId = group_member_info_gbarinfo.uint32_gbar_id.get();
            gBarInfo.level = group_member_info_gbarinfo.uint32_uin_lev.get();
            gBarInfo.headUrl = group_member_info_gbarinfo.str_head_portrait.get().toStringUtf8();
            gBarInfo.name = group_member_info_gbarinfo.bytes_gbar_name.get().toStringUtf8();
            troopMemberCard.gbarList.add(gBarInfo);
        }
        troopMemberCard.customEntryList = new ArrayList();
        List<group_member_info$CustomEntry> list2 = group_member_info_memberinfo.rpt_msg_custom_enties.get();
        if (list2 != null) {
            i16 = list2.size();
        } else {
            i16 = 0;
        }
        for (int i18 = 0; i18 < i16; i18++) {
            group_member_info$CustomEntry group_member_info_customentry = list2.get(i18);
            TroopMemberCard.CustomEntry customEntry = new TroopMemberCard.CustomEntry();
            customEntry.label = group_member_info_customentry.str_name.get().toStringUtf8();
            customEntry.info = group_member_info_customentry.str_value.get().toStringUtf8();
            customEntry.linkUrl = group_member_info_customentry.str_url.get().toStringUtf8();
            customEntry.isClickable = group_member_info_customentry.bool_clicked.get();
            customEntry.reportId = group_member_info_customentry.uint64_report_id.get();
            troopMemberCard.customEntryList.add(customEntry);
        }
        O2(troopMemberCard, group_member_info_memberinfo);
        if (group_member_info_memberinfo.bytes_phone_num.has()) {
            troopMemberCard.phoneNumber = group_member_info_memberinfo.bytes_phone_num.get().toStringUtf8();
        }
        S2(j3, troopMemberCard, group_member_info_memberinfo);
        if (group_member_info_memberinfo.bytes_job.has()) {
            troopMemberCard.mPosition = group_member_info_memberinfo.bytes_job.get().toStringUtf8();
        }
        R2(troopMemberCard, group_member_info_memberinfo);
        P2(troopMemberCard, group_member_info_memberinfo);
        ad.d(troopMemberCard, j3, group_member_info_memberinfo);
        T2(troopMemberCard, group_member_info_memberinfo);
        U2(j3, troopMemberCard);
    }

    private void R2(TroopMemberCard troopMemberCard, group_member_info$MemberInfo group_member_info_memberinfo) {
        if (group_member_info_memberinfo.qqstory_infocard.has()) {
            group_member_info$RspGroupCardGetStory group_member_info_rspgroupcardgetstory = group_member_info_memberinfo.qqstory_infocard.get();
            if (group_member_info_rspgroupcardgetstory.flag.has()) {
                boolean z16 = true;
                if (group_member_info_rspgroupcardgetstory.flag.get() != 1) {
                    z16 = false;
                }
                troopMemberCard.mHasStory = z16;
            }
            if (group_member_info_rspgroupcardgetstory.video_info.has()) {
                List<group_member_info$InfoCardVideoInfo> list = group_member_info_rspgroupcardgetstory.video_info.get();
                if (list.size() > 0) {
                    troopMemberCard.mStoryInfoList = new ArrayList<>();
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        group_member_info$InfoCardVideoInfo group_member_info_infocardvideoinfo = list.get(i3);
                        if (group_member_info_infocardvideoinfo.cover.has()) {
                            TroopMemberCard.StoryInfo storyInfo = new TroopMemberCard.StoryInfo();
                            storyInfo.mCoverUrl = group_member_info_infocardvideoinfo.cover.get().toStringUtf8();
                            troopMemberCard.mStoryInfoList.add(storyInfo);
                        }
                    }
                }
            }
        }
    }

    private void S2(long j3, TroopMemberCard troopMemberCard, group_member_info$MemberInfo group_member_info_memberinfo) {
        if (group_member_info_memberinfo.msg_team_entry.has()) {
            troopMemberCard.mOrgIds.clear();
            Iterator<Long> it = group_member_info_memberinfo.msg_team_entry.get().rpt_uint64_depid.get().iterator();
            while (it.hasNext()) {
                String str = "" + j3 + it.next().longValue();
                if (!troopMemberCard.mOrgIds.contains(str)) {
                    troopMemberCard.mOrgIds.add(str);
                }
            }
            troopMemberCard.mCurrAccountOrgIds.clear();
            Iterator<Long> it5 = group_member_info_memberinfo.msg_team_entry.get().rpt_uint64_self_depid.get().iterator();
            while (it5.hasNext()) {
                String str2 = "" + j3 + it5.next().longValue();
                if (!troopMemberCard.mCurrAccountOrgIds.contains(str2)) {
                    troopMemberCard.mCurrAccountOrgIds.add(str2);
                }
            }
        }
    }

    private void T2(TroopMemberCard troopMemberCard, group_member_info$MemberInfo group_member_info_memberinfo) {
        if (group_member_info_memberinfo.uint32_group_honor_bit.has()) {
            troopMemberCard.honorRichTag = (byte) group_member_info_memberinfo.uint32_group_honor_bit.get();
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberCardHandler", 2, "honor_rich_card," + group_member_info_memberinfo.uint32_group_honor_bit.get());
            }
        }
    }

    private void U2(long j3, TroopMemberCard troopMemberCard) {
        ITroopInfoService iTroopInfoService = (ITroopInfoService) this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
        if (iTroopInfoService != null) {
            if (troopMemberCard.mUniqueTitle == null) {
                troopMemberCard.mUniqueTitle = "";
            }
            String valueOf = String.valueOf(troopMemberCard.memberUin);
            TroopInfo troopInfo = iTroopInfoService.getTroopInfo(String.valueOf(j3));
            if (troopMemberCard.memberRole == 3 && troopInfo != null && troopMemberCard.memberUin != 0 && !valueOf.equals(troopInfo.troopowneruin)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberCardHandler", 2, "handleGetTroopMemberCard change troopOwner:" + j3 + ", oldOwner=" + troopInfo.troopowneruin + ", newOwner=" + valueOf);
                }
                troopInfo.troopowneruin = valueOf;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberCardHandler", 2, "handleGetTroopMemberCard memberRole:" + troopMemberCard.memberRole + ",memberUin: " + valueOf);
            }
            if (troopMemberCard.memberRole != 0) {
                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).fetchTroopMemberInfoFromDB(String.valueOf(j3), valueOf, null, "TroopMemberCardHandler-hTMC_hNN", new c(j3, troopMemberCard, iTroopInfoService, troopInfo));
            }
        }
    }

    private boolean V2(TroopMemberCard troopMemberCard, int i3, TroopMemberInfo troopMemberInfo, boolean z16) {
        if (i3 > 0 && i3 != troopMemberInfo.titleId) {
            troopMemberInfo.titleId = i3;
            z16 = true;
        }
        String str = troopMemberCard.nick;
        if (str != null && !str.equals(troopMemberInfo.friendnick)) {
            troopMemberInfo.friendnick = troopMemberCard.nick;
            z16 = true;
        }
        String str2 = troopMemberCard.mUniqueTitle;
        if (str2 != null) {
            if (troopMemberInfo.specialTitleInfo == null) {
                troopMemberInfo.specialTitleInfo = new TroopMemberSpecialTitleInfo(troopMemberInfo.troopuin, troopMemberInfo.memberuin, troopMemberInfo.friendnick, troopMemberCard.mUniqueTitle, troopMemberCard.mUniqueTitleExpire);
            } else if (!str2.equals(troopMemberInfo.getSpecialTitleStr())) {
                troopMemberInfo.specialTitleInfo.setSpecialTitle(troopMemberCard.mUniqueTitle);
                troopMemberInfo.specialTitleInfo.setExpireTimeSec(troopMemberCard.mUniqueTitleExpire);
            }
            z16 = true;
        }
        long j3 = troopMemberCard.joinTime;
        if (j3 != troopMemberInfo.join_time) {
            troopMemberInfo.join_time = j3;
            z16 = true;
        }
        long j16 = troopMemberCard.lastSpeak;
        if (j16 != troopMemberInfo.last_active_time) {
            troopMemberInfo.last_active_time = j16;
            z16 = true;
        }
        int i16 = troopMemberCard.colorCardId;
        if (i16 != troopMemberInfo.troopColorNickId) {
            troopMemberInfo.troopColorNickId = i16;
            ((IVasNTFrequency) QRoute.api(IVasNTFrequency.class)).requestTroopColorNameFrequency(troopMemberInfo.memberuin, troopMemberInfo.troopColorNickId, troopMemberInfo.troopuin);
            return true;
        }
        return z16;
    }

    private boolean W2(TroopMemberCard troopMemberCard, TroopMemberInfo troopMemberInfo, boolean z16) {
        String str = troopMemberInfo.troopnick;
        ad.e(troopMemberInfo, troopMemberCard);
        if (!TextUtils.isEmpty(troopMemberInfo.troopnick) && !troopMemberInfo.equals(str)) {
            return true;
        }
        return z16;
    }

    private void Y2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg == null) {
            notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_MODIFY_TROOPMEMEBER_CARD, false, null);
            return;
        }
        if (obj == null) {
            notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_MODIFY_TROOPMEMEBER_CARD, false, null);
            return;
        }
        if (toServiceMsg == null) {
            notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_MODIFY_TROOPMEMEBER_CARD, false, null);
            return;
        }
        ModifyGroupCardResp modifyGroupCardResp = (ModifyGroupCardResp) obj;
        if (modifyGroupCardResp.result != 0) {
            notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_MODIFY_TROOPMEMEBER_CARD, false, new Object[]{null, modifyGroupCardResp.ErrorString});
            return;
        }
        ArrayList arrayList = (ArrayList) toServiceMsg.extraData.getSerializable("vecUinInfo");
        if (arrayList != null && !arrayList.isEmpty()) {
            String valueOf = String.valueOf(toServiceMsg.extraData.getLong("dwGroupCode"));
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(String.valueOf(((stUinInfo) it.next()).dwuin));
            }
            J2(valueOf, arrayList2, new a(""));
            return;
        }
        notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_MODIFY_TROOPMEMEBER_CARD, false, null);
    }

    private boolean Z2(TroopMemberCard troopMemberCard, TroopMemberInfo troopMemberInfo) {
        if (TextUtils.equals(troopMemberCard.honorList, troopMemberInfo.honorList) && (TextUtils.isEmpty(troopMemberInfo.honorList) || troopMemberCard.honorRichTag == troopMemberInfo.mHonorRichFlag)) {
            return false;
        }
        return true;
    }

    public static int a3(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                troop_honor$GroupUserCardHonor troop_honor_groupusercardhonor = new troop_honor$GroupUserCardHonor();
                troop_honor_groupusercardhonor.mergeFrom(bArr);
                if (!troop_honor_groupusercardhonor.level.has()) {
                    return 0;
                }
                return troop_honor_groupusercardhonor.level.get();
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberCardHandler", 2, "parseRspToNewRealLevel exception");
                }
                e16.printStackTrace();
                return 0;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberCardHandler", 2, "data error");
        }
        return 0;
    }

    public void K2(String str, String str2, ArrayList<String> arrayList, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, arrayList, Long.valueOf(j3), Boolean.valueOf(z16));
        } else if (str != null && str2 != null && arrayList != null && arrayList.size() != 0) {
            J2(str, arrayList, new b(j3, z16));
        }
    }

    public void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (obj == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberCardHandler", 2, "handleGetTroopMemberCard : data==null");
            }
            notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_GET_TROOP_MEMBER_CARD, false, null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberCardHandler", 2, "handleGetTroopMemberCard : resp.isSuccess=" + fromServiceMsg.isSuccess());
        }
        if (!fromServiceMsg.isSuccess()) {
            notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_GET_TROOP_MEMBER_CARD, false, null);
            return;
        }
        group_member_info$RspBody group_member_info_rspbody = new group_member_info$RspBody();
        try {
            group_member_info_rspbody.mergeFrom((byte[]) obj);
            long j3 = group_member_info_rspbody.uint64_group_code.get();
            int i3 = group_member_info_rspbody.uint32_self_role.get();
            TroopMemberCard troopMemberCard = new TroopMemberCard();
            troopMemberCard.result = -1;
            if (group_member_info_rspbody.uint32_group_type.has()) {
                troopMemberCard.mGroupType = group_member_info_rspbody.uint32_group_type.get();
            }
            if (group_member_info_rspbody.msg_meminfo.has()) {
                Q2(group_member_info_rspbody, j3, troopMemberCard);
            }
            notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_GET_TROOP_MEMBER_CARD, true, new Object[]{Long.valueOf(j3), Integer.valueOf(i3), troopMemberCard, Boolean.valueOf(toServiceMsg.extraData.getBoolean("once", false))});
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberCardHandler", 2, "onReceive: handleGetTroopMemberCard mergeFrom:" + e16.toString());
            }
            notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_GET_TROOP_MEMBER_CARD, false, null);
        }
    }

    public void M2(Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, obj, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.e
    public void U(long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16));
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f296241f.getAccount(), "group_member_card.get_group_member_card_info");
        group_member_info$ReqBody group_member_info_reqbody = new group_member_info$ReqBody();
        group_member_info_reqbody.uint64_group_code.set(j3);
        group_member_info_reqbody.uint64_uin.set(j16);
        group_member_info_reqbody.bool_new_client.set(true);
        group_member_info_reqbody.uint32_client_type.set(1);
        group_member_info_reqbody.uint32_rich_card_name_ver.set(1);
        toServiceMsg.putWupBuffer(group_member_info_reqbody.toByteArray());
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.extraData.putBoolean("once", z16);
        sendPbReq(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberCardHandler", 2, "FriendListHandler.getTroopMemberCard, memberUin: " + j16 + " troopCode: " + j3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.e
    public void V0(String str, ArrayList<TroopMemberCardInfo> arrayList, ArrayList<Integer> arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, arrayList, arrayList2);
            return;
        }
        if (str == null || arrayList == null || arrayList2 == null || arrayList.size() != arrayList2.size()) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            TroopMemberCardInfo troopMemberCardInfo = arrayList.get(i3);
            int intValue = arrayList2.get(i3).intValue();
            stUinInfo stuininfo = new stUinInfo();
            stuininfo.dwuin = Long.parseLong(troopMemberCardInfo.memberuin);
            stuininfo.sName = troopMemberCardInfo.name;
            stuininfo.dwFlag = intValue;
            arrayList3.add(stuininfo);
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("friendlist.ModifyGroupCardReq");
        createToServiceMsg.extraData.putLong("dwZero", 0L);
        createToServiceMsg.extraData.putLong("dwGroupCode", Long.parseLong(str));
        createToServiceMsg.extraData.putSerializable("vecUinInfo", arrayList3);
        createToServiceMsg.extraData.putLong("dwNewSeq", 0L);
        send(createToServiceMsg);
    }

    public void X2(List<Object> list, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, list, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (list == null) {
            notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_GET_TROOPMEMEBER_CARD_LIST, false, null);
            QLog.i("TroopMemberCardHandler", 1, "[handlerGetTroopMemberInfoList] troopMemberList is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = list.iterator();
        String str = "0";
        while (it.hasNext()) {
            TroopMemberInfo troopMemberInfo = (TroopMemberInfo) it.next();
            arrayList.add(I2(troopMemberInfo));
            String str2 = troopMemberInfo.troopuin;
            if (StringUtils.toLong(str2) == j3) {
                M2(troopMemberInfo, z16);
            }
            str = str2;
        }
        if (!arrayList.isEmpty()) {
            Object[] objArr = {arrayList, Boolean.TRUE};
            notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_GET_TROOPMEMEBER_CARD_LIST, true, objArr);
            QLog.i("TroopMemberCardHandler", 1, "[handlerGetTroopMemberInfoList] troopUin:" + str + ", vecListSize:" + arrayList.size() + ", bRet = " + objArr[1]);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.e
    public void f2(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            U(j3, j16, false);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f296240e == null) {
            HashSet hashSet = new HashSet();
            this.f296240e = hashSet;
            hashSet.add("friendlist.ModifyGroupCardReq");
            this.f296240e.add("group_member_card.get_group_member_card_info");
        }
        return this.f296240e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopMemberCardHandler";
    }

    @Override // com.tencent.mobileqq.troop.api.handler.e
    public void i1(String str, String str2, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, arrayList);
        } else {
            K2(str, str2, arrayList, 0L, false);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.troop.api.observer.e.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberCardHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberCardHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("friendlist.ModifyGroupCardReq".equals(fromServiceMsg.getServiceCmd())) {
                Y2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("group_member_card.get_group_member_card_info".equals(fromServiceMsg.getServiceCmd())) {
                    L2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberCardHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
