package com.tencent.mobileqq.profilecard.processor;

import NS_COMM.COMM;
import NS_MINI_APP_MISC.MISC$StAppPlayingInfo;
import NS_MINI_APP_MISC.MISC$StGetFriendPlayListV2Rsp;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StGetUserAppListRsp;
import NS_MINI_INTERFACE.INTERFACE$StUserAppInfo;
import QQService.EVIPSPEC;
import QQService.PrivilegeBaseInfo;
import QQService.PrivilegeInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SummaryCard.AlbumInfo;
import SummaryCard.DateCard;
import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import SummaryCard.TMedalWallInfo;
import SummaryCardTaf.SLabelInfo;
import SummaryCardTaf.SSummaryCardQueryReq;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.STRecommendInfo;
import SummaryCardTaf.SUserLabel;
import SummaryCardTaf.cardDiyComplicatedInfo;
import SummaryCardTaf.cardDiyTextInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.DressUpShowType;
import com.tencent.mobileqq.data.GxhIPCollectionData;
import com.tencent.mobileqq.data.GxhSuitItemData;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QQCardItemData;
import com.tencent.mobileqq.data.SimilarityData;
import com.tencent.mobileqq.data.SplendidItemData;
import com.tencent.mobileqq.data.StrongSimilarityData;
import com.tencent.mobileqq.data.SvipPrivilegeShow;
import com.tencent.mobileqq.data.UsingDressUpItemData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.medalwall.MedalID;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.b;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService;
import com.tencent.mobileqq.onlinestatus.model.f;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.bussiness.achievement.processor.LifeAchievementBusinessProcessor;
import com.tencent.mobileqq.profilecard.bussiness.miniapp.ProfileMiniAppInfo;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;
import com.tencent.mobileqq.profilecard.processor.TempProfileBusinessProcessor;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.profilesetting.w;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.pb.profilecard.VaProfileGate$BigVipBadgeItem;
import com.tencent.pb.profilecard.VaProfileGate$CardItem;
import com.tencent.pb.profilecard.VaProfileGate$CommTaskInfo;
import com.tencent.pb.profilecard.VaProfileGate$GetCardRsp;
import com.tencent.pb.profilecard.VaProfileGate$GetClmTipReq;
import com.tencent.pb.profilecard.VaProfileGate$GetGiftListReq;
import com.tencent.pb.profilecard.VaProfileGate$GetGiftListRsp;
import com.tencent.pb.profilecard.VaProfileGate$GetGxhUsingRsp;
import com.tencent.pb.profilecard.VaProfileGate$GetSplendidRsp;
import com.tencent.pb.profilecard.VaProfileGate$GxhIPCollection;
import com.tencent.pb.profilecard.VaProfileGate$GxhSuit;
import com.tencent.pb.profilecard.VaProfileGate$GxhUsingItem;
import com.tencent.pb.profilecard.VaProfileGate$OidbFlagInfo;
import com.tencent.pb.profilecard.VaProfileGate$PrivilegeBaseInfoReq;
import com.tencent.pb.profilecard.VaProfileGate$PrivilegeBaseInfoRsp;
import com.tencent.pb.profilecard.VaProfileGate$PrivilegeInfo;
import com.tencent.pb.profilecard.VaProfileGate$PrivilegeShowItem;
import com.tencent.pb.profilecard.VaProfileGate$PrivilegeShowRsp;
import com.tencent.pb.profilecard.VaProfileGate$QidInfoItem;
import com.tencent.pb.profilecard.VaProfileGate$SplendidItem;
import com.tencent.pb.profilecard.VaProfileGate$VaProfileGateReq;
import com.tencent.pb.profilecard.VaProfileGate$VaProfileGateRsp;
import com.tencent.pb.profilecard.VaProfileGate$VipMedalItem;
import com.tencent.pb.profilecard.VipMusicBox$GetProfileMusicBoxInfoReq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.qzonehub.api.utils.IQZoneDeviceInfoUtil;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.trpcprotocol.qq.summary_card_similarity.summary_card_similarity.SummaryCardSimilarity$GetSummaryCardSimilarityReq;
import com.tencent.trpcprotocol.qq.summary_card_similarity.summary_card_similarity.SummaryCardSimilarity$GetSummaryCardSimilarityRsp;
import com.tencent.trpcprotocol.qq.summary_card_similarity.summary_card_similarity.SummaryCardSimilarity$Similarity;
import com.tencent.trpcprotocol.qq.summary_card_similarity.summary_card_similarity.SummaryCardSimilarity$StrongSimilarity;
import com.tencent.trpcprotocol.zplan.data_card.data_card.dataCard$RspBody;
import com.tencent.trpcprotocol.zplan.user_info.common_pb.commonPb$Info;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudDatacard$DataCardCoverClientInfo;
import feedcloud.FeedCloudDatacard$GetDataCardCoverReq;
import feedcloud.FeedCloudDatacard$GetDataCardCoverRsp;
import feedcloud.FeedCloudMeta$StFeedAbstract;
import gxh_message.Dialogue;
import hx3.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import tencent.im.mutualmark.MutualMarkCard$ReqBody;
import tencent.im.mutualmark.MutualMarkCard$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class TempProfileBusinessProcessor extends AbsProfileBusinessProcessor {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TempProfileBusinessProcessor";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.profilecard.processor.TempProfileBusinessProcessor$3, reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass3 implements c<Boolean> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Card val$card;
        final /* synthetic */ long val$getControl;
        final /* synthetic */ String val$uid;
        final /* synthetic */ String val$uin;

        AnonymousClass3(String str, String str2, Card card, long j3) {
            this.val$uid = str;
            this.val$uin = str2;
            this.val$card = card;
            this.val$getControl = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TempProfileBusinessProcessor.this, str, str2, card, Long.valueOf(j3));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onUpdateResult$0(String str, e eVar) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(str) { // from class: com.tencent.mobileqq.profilecard.processor.TempProfileBusinessProcessor.3.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$uin;

                {
                    this.val$uin = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        TempProfileBusinessProcessor.this.notifyContactChange(this.val$uin);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable e<Boolean> eVar) {
            String c16;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            if (eVar.a() != 0) {
                return;
            }
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            d dVar = new d(this.val$uid, this.val$uin);
            dVar.M();
            dVar.k0(this.val$card.strNick);
            dVar.m0(this.val$card.strReMark);
            if ((this.val$getControl & 1) != 0) {
                c16 = this.val$card.strShowName;
            } else {
                c16 = dVar.c();
            }
            dVar.Z(c16);
            short s16 = this.val$card.shGender;
            if (s16 == 0) {
                i3 = 1;
            } else if (s16 != 1) {
                i3 = 0;
            }
            dVar.q0(i3);
            dVar.V(this.val$card.age);
            final String str = this.val$uin;
            iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, TempProfileBusinessProcessor.TAG, new c() { // from class: com.tencent.mobileqq.profilecard.processor.a
                @Override // hx3.c
                public final void onUpdateResult(e eVar2) {
                    TempProfileBusinessProcessor.AnonymousClass3.this.lambda$onUpdateResult$0(str, eVar2);
                }
            });
            TempProfileBusinessProcessor.this.updateSpecialFlag(this.val$card, this.val$getControl);
        }
    }

    public TempProfileBusinessProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    private VaProfileGate$VaProfileGateReq buildVaProfileGateReq(long j3) {
        ArrayList arrayList = new ArrayList();
        VaProfileGate$OidbFlagInfo vaProfileGate$OidbFlagInfo = new VaProfileGate$OidbFlagInfo();
        vaProfileGate$OidbFlagInfo.uint32_fieled.set(ProfileContants.FIELD_QQ_LEVEL_ICON_TYPE);
        arrayList.add(vaProfileGate$OidbFlagInfo);
        VaProfileGate$OidbFlagInfo vaProfileGate$OidbFlagInfo2 = new VaProfileGate$OidbFlagInfo();
        vaProfileGate$OidbFlagInfo2.uint32_fieled.set(ProfileContants.FIELD_MUSICBOX_SWITCH);
        arrayList.add(vaProfileGate$OidbFlagInfo2);
        VaProfileGate$OidbFlagInfo vaProfileGate$OidbFlagInfo3 = new VaProfileGate$OidbFlagInfo();
        vaProfileGate$OidbFlagInfo3.uint32_fieled.set(ProfileContants.FIELD_NAMEPLATEVIPTYPE);
        arrayList.add(vaProfileGate$OidbFlagInfo3);
        VaProfileGate$OidbFlagInfo vaProfileGate$OidbFlagInfo4 = new VaProfileGate$OidbFlagInfo();
        vaProfileGate$OidbFlagInfo4.uint32_fieled.set(ProfileContants.FIELD_GRAYNAMEPLATE);
        arrayList.add(vaProfileGate$OidbFlagInfo4);
        VaProfileGate$OidbFlagInfo vaProfileGate$OidbFlagInfo5 = new VaProfileGate$OidbFlagInfo();
        vaProfileGate$OidbFlagInfo5.uint32_fieled.set(27375);
        arrayList.add(vaProfileGate$OidbFlagInfo5);
        VaProfileGate$GetClmTipReq vaProfileGate$GetClmTipReq = new VaProfileGate$GetClmTipReq();
        VipMusicBox$GetProfileMusicBoxInfoReq vipMusicBox$GetProfileMusicBoxInfoReq = new VipMusicBox$GetProfileMusicBoxInfoReq();
        vipMusicBox$GetProfileMusicBoxInfoReq.uin.set(j3);
        VaProfileGate$CommTaskInfo vaProfileGate$CommTaskInfo = new VaProfileGate$CommTaskInfo();
        vaProfileGate$CommTaskInfo.uint32_appid.set(4);
        vaProfileGate$CommTaskInfo.bytes_task_data.set(ByteStringMicro.copyFrom(vipMusicBox$GetProfileMusicBoxInfoReq.toByteArray()));
        VaProfileGate$PrivilegeBaseInfoReq vaProfileGate$PrivilegeBaseInfoReq = new VaProfileGate$PrivilegeBaseInfoReq();
        vaProfileGate$PrivilegeBaseInfoReq.uReqUin.set(j3);
        VaProfileGate$GetGiftListReq vaProfileGate$GetGiftListReq = new VaProfileGate$GetGiftListReq();
        vaProfileGate$GetGiftListReq.uin.set((int) j3);
        VaProfileGate$VaProfileGateReq vaProfileGate$VaProfileGateReq = new VaProfileGate$VaProfileGateReq();
        vaProfileGate$VaProfileGateReq.uCmd.set(3);
        vaProfileGate$VaProfileGateReq.rpt_oidb_flag.set(arrayList);
        vaProfileGate$VaProfileGateReq.get_clm_tip_req.set(vaProfileGate$GetClmTipReq);
        vaProfileGate$VaProfileGateReq.rpt_task_item.add(vaProfileGate$CommTaskInfo);
        vaProfileGate$VaProfileGateReq.stPrivilegeReq.set(vaProfileGate$PrivilegeBaseInfoReq);
        vaProfileGate$VaProfileGateReq.stGiftReq.set(vaProfileGate$GetGiftListReq);
        return vaProfileGate$VaProfileGateReq;
    }

    private void handleGetSummaryCardForBaseInfoPrivacy(QQAppInterface qQAppInterface, Card card, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        if (oidb_0x5eb_udcuindata.uint32_profile_sex_visible.has()) {
            w.INSTANCE.q(41611, oidb_0x5eb_udcuindata.uint32_profile_sex_visible.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_age_visible.has()) {
            w.INSTANCE.q(41610, oidb_0x5eb_udcuindata.uint32_profile_age_visible.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_birthday_visible.has()) {
            w.INSTANCE.q(41607, oidb_0x5eb_udcuindata.uint32_profile_birthday_visible.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_constellation_visible.has()) {
            w.INSTANCE.q(IProfileSettingApi.FIELD_PRIVACY_CONSTELLATION, oidb_0x5eb_udcuindata.uint32_profile_constellation_visible.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_profession_visible.has()) {
            w.INSTANCE.q(41618, oidb_0x5eb_udcuindata.uint32_profile_profession_visible.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_college_visible.has()) {
            w.INSTANCE.q(41619, oidb_0x5eb_udcuindata.uint32_profile_college_visible.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_location_visible.has()) {
            w.INSTANCE.q(41614, oidb_0x5eb_udcuindata.uint32_profile_location_visible.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_hometown_visible.has()) {
            w.INSTANCE.q(41613, oidb_0x5eb_udcuindata.uint32_profile_hometown_visible.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_email_visible.has()) {
            w.INSTANCE.q(41622, oidb_0x5eb_udcuindata.uint32_profile_email_visible.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_personal_note_visible.has()) {
            w.INSTANCE.q(41623, oidb_0x5eb_udcuindata.uint32_profile_personal_note_visible.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_company_visible.has()) {
            w.INSTANCE.q(40272, oidb_0x5eb_udcuindata.uint32_profile_company_visible.get(), card, qQAppInterface);
        }
    }

    private void handleGetSummaryCardForBusinessSwitch(QQAppInterface qQAppInterface, Card card, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        if (oidb_0x5eb_udcuindata.uint32_profile_anonymous_answer_switch.has()) {
            w.INSTANCE.q(42425, oidb_0x5eb_udcuindata.uint32_profile_anonymous_answer_switch.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_show_idol_switch.has()) {
            w.INSTANCE.q(42488, oidb_0x5eb_udcuindata.uint32_profile_show_idol_switch.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_privilege.has()) {
            w.INSTANCE.q(45160, oidb_0x5eb_udcuindata.uint32_profile_privilege.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_membership_and_rank.has()) {
            w.INSTANCE.q(45161, oidb_0x5eb_udcuindata.uint32_profile_membership_and_rank.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_dressup_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_DRESSUP_SWITCH, oidb_0x5eb_udcuindata.uint32_profile_dressup_switch.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_qqcard_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_QQCARD_SWITCH, oidb_0x5eb_udcuindata.uint32_profile_qqcard_switch.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_q_cub_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_Q_CUB_SWITCH, oidb_0x5eb_udcuindata.uint32_profile_q_cub_switch.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_music_data_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_MUSIC_DATA_SWITCH, oidb_0x5eb_udcuindata.uint32_profile_music_data_switch.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_music_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_MUSIC_SWITCH, oidb_0x5eb_udcuindata.uint32_profile_music_switch.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_meta_farm_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_META_FARM_SWITCH, oidb_0x5eb_udcuindata.uint32_profile_meta_farm_switch.get(), card, qQAppInterface);
        }
        if (oidb_0x5eb_udcuindata.uint32_haoma_nameplate.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_HAOMA_NAMEPLATE, oidb_0x5eb_udcuindata.uint32_haoma_nameplate.get(), card, qQAppInterface);
        }
    }

    private void handleGetSummaryCardForMedalWall(RespSummaryCard respSummaryCard, Card card) {
        boolean z16;
        int i3;
        int i16;
        if (respSummaryCard.stMedalWallInfo != null) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                respSummaryCard.stMedalWallInfo.display(sb5, 0);
                QLog.d("MedalWallMng", 2, "from summary card medal wall info: ", sb5.toString());
            }
            TMedalWallInfo tMedalWallInfo = respSummaryCard.stMedalWallInfo;
            card.iMedalCount = tMedalWallInfo.iMedalCount;
            if (tMedalWallInfo.iOpenFlag == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            card.medalSwitchDisable = z16;
            int i17 = tMedalWallInfo.iNewCount;
            int i18 = tMedalWallInfo.iUpgradeCount;
            String str = tMedalWallInfo.strPromptParams;
            if ((i17 > 0 || i18 > 0) && !TextUtils.isEmpty(str) && Utils.p(card.uin, this.appRuntime.getAccount())) {
                ArrayList<MedalID> t16 = ((MedalWallMng) this.appRuntime.getManager(QQManagerFactory.MEDAL_WALL_MNG)).t(str);
                if (t16 != null && t16.size() > 0) {
                    Iterator<MedalID> it = t16.iterator();
                    i3 = 0;
                    i16 = 0;
                    while (it.hasNext()) {
                        MedalID next = it.next();
                        if (next != null) {
                            int i19 = next.f245722e;
                            if (i19 != 1 && i19 != 255) {
                                if (i19 == 2 || i19 == 3) {
                                    i16++;
                                }
                            } else {
                                i3++;
                            }
                        }
                    }
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "summary card server[%d, %d] compute[%d, %d]", Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i3), Integer.valueOf(i16)));
                }
                i17 = i3;
                i18 = i16;
            }
            card.iNewCount = i17;
            card.iUpgradeCount = i18;
            card.strPromptParams = str;
        }
    }

    private void handleGetSummaryCardForMoreInfo(RespSummaryCard respSummaryCard, Card card) {
        DateCard dateCard = respSummaryCard.stDateCard;
        if (dateCard != null) {
            card.constellation = dateCard.bConstellation;
            card.strCompany = dateCard.strCompany;
            card.iProfession = (int) dateCard.uProfession;
            card.strSchool = dateCard.strSchool;
            String str = ConditionSearchManager.n(dateCard.uHomeCountry) + "-" + ConditionSearchManager.n(respSummaryCard.stDateCard.uHomeProvince) + "-" + ConditionSearchManager.n(respSummaryCard.stDateCard.uHomeCity) + "-" + ConditionSearchManager.n(respSummaryCard.stDateCard.uHomeZone);
            card.strHometownCodes = str;
            if (!TextUtils.isEmpty(str)) {
                ((ConditionSearchManager) this.appRuntime.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).P(card);
            }
        }
    }

    private void handleGetSummaryCardForNearby(RespSummaryCard respSummaryCard, String str) {
        b bVar;
        if (str.equals(this.appRuntime.getAccount()) && (bVar = (b) this.appRuntime.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)) != null) {
            bVar.d(respSummaryCard.bSex);
            bVar.a(respSummaryCard.bAge);
        }
    }

    private void handleGetSummaryCardForPersonalityLabel(RespSummaryCard respSummaryCard, Card card) {
        if (respSummaryCard.vRespCustomLabelInfo != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "handleGetSummaryCard PersonalityLabel");
            }
            card.putBusinessInfo(ProfilePersonalityLabelInfo.convertFromPbBytes(respSummaryCard.vRespCustomLabelInfo));
        }
    }

    private void handleGetSummaryCardForPrivilege(RespSummaryCard respSummaryCard, SparseArray<BusinessRespBuffer> sparseArray, Card card) {
        PrivilegeBaseInfo privilegeBaseInfo;
        if (!handleVaProfileGate(card, sparseArray) && (privilegeBaseInfo = respSummaryCard.stPrivInfo) != null) {
            card.privilegePromptStr = privilegeBaseInfo.strMsg;
            card.privilegeJumpUrl = privilegeBaseInfo.strJumpUrl;
            card.savePrivilegeOpenedInfo(privilegeBaseInfo.vOpenPriv);
            card.savePrivilegeClosedInfo(privilegeBaseInfo.vClosePriv);
        }
    }

    private void handleGetSummaryCardForQCircle(String str, Card card, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        boolean z16;
        boolean z17 = false;
        if (oidb_0x5eb_udcuindata.uint32_flag_qcircle_cover_switch.has()) {
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "flag_qcircle_cover_switch=" + oidb_0x5eb_udcuindata.uint32_flag_qcircle_cover_switch.get());
            }
            if (oidb_0x5eb_udcuindata.uint32_flag_qcircle_cover_switch.get() == 1 && uq3.c.c7()) {
                z16 = true;
            } else {
                z16 = false;
            }
            card.isShowQCircleCover = z16;
        }
        if (oidb_0x5eb_udcuindata.uint32_req_small_world_head_flag.has()) {
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "uint32_req_small_world_head_flag=" + oidb_0x5eb_udcuindata.uint32_req_small_world_head_flag.get());
            }
            if (oidb_0x5eb_udcuindata.uint32_req_small_world_head_flag.get() == 1) {
                z17 = true;
            }
            card.isQCircleDynamicAvatar = z17;
        }
    }

    private void handleGetSummaryCardForQZone(RespSummaryCard respSummaryCard, Card card) {
        boolean z16;
        card.strQzoneFeedsDesc = respSummaryCard.strQzoneFeedsDesc;
        card.strSpaceName = respSummaryCard.strSpaceName;
        card.strQzoneHeader = respSummaryCard.strQzoneHeader;
        Map<String, String> map = respSummaryCard.mapQzoneEx;
        if (map != null) {
            card.mapQzoneEx = map;
            String str = map.get("enlarge_qzone");
            if (!TextUtils.isEmpty(str)) {
                try {
                    card.enlargeQzonePic = Integer.parseInt(str);
                } catch (NumberFormatException e16) {
                    QLog.w(TAG, 1, "strEnlargQzone is not a integer:", e16);
                }
            } else {
                card.enlargeQzonePic = 0;
            }
            String str2 = respSummaryCard.mapQzoneEx.get("show_publish_button");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (Integer.parseInt(str2) == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    card.showPublishButton = z16;
                } catch (NumberFormatException e17) {
                    QLog.w(TAG, 1, "show_publish_button is not a integer:", e17);
                    card.showPublishButton = false;
                }
            } else {
                card.showPublishButton = false;
            }
        }
        card.vQzoneCoverInfo = respSummaryCard.vQzoneCoverInfo;
        if (!card.isPhotoUseCache()) {
            card.qzonePhotoList.clear();
            AlbumInfo albumInfo = respSummaryCard.oLatestPhotos;
            if (albumInfo != null && albumInfo.vPhotos != null) {
                try {
                    card.addQZonePhotoList(albumInfo);
                } catch (OutOfMemoryError e18) {
                    QLog.e(TAG, 1, "card.addQZonePhotoList(albumInfo)  OOM !" + e18.getMessage());
                }
            }
        }
    }

    private void handleGetSummaryCardForTemplate(RespSummaryCard respSummaryCard, String str, Card card, long j3) {
        SSummaryCardRsp sSummaryCardRsp;
        STRecommendInfo sTRecommendInfo;
        if ((j3 & 32) != 0) {
            HashMap hashMap = new HashMap();
            byte[] bArr = respSummaryCard.vRespTemplateInfo;
            if (bArr != null) {
                try {
                    sSummaryCardRsp = (SSummaryCardRsp) Packet.decodePacket(bArr, "rsp", new SSummaryCardRsp());
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "[onProcessProfileCard] decodePacket exception:", e16);
                    sSummaryCardRsp = null;
                }
                updateCardTemplate(card, str, sSummaryCardRsp);
                if (sSummaryCardRsp != null && !TextUtils.isEmpty(sSummaryCardRsp.urlprefix)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "handleGetSummaryCard: defaultCardUrlPrefix=" + sSummaryCardRsp.urlprefix + " defId=" + sSummaryCardRsp.profileid);
                    }
                    ProfileCardManager.f259995j = sSummaryCardRsp.urlprefix;
                }
                if (sSummaryCardRsp != null && (sTRecommendInfo = sSummaryCardRsp.stRecom) != null) {
                    long j16 = sTRecommendInfo.iRecomCard;
                    String str2 = ProfileCardManager.f259995j + sSummaryCardRsp.stRecom.strRecomUrl;
                    String str3 = sSummaryCardRsp.stRecom.strDesc;
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        BaseApplicationImpl.getApplication().getSharedPreferences("profile_sp", 0).edit().putLong("recommend_id", j16).putString("recommend_url", str2).putString("recommend_desc", str3).commit();
                        return;
                    }
                    return;
                }
                return;
            }
            hashMap.put("param_FailCode", "-100");
            StatisticCollector.getInstance(this.appRuntime.getApplication()).collectPerformance(str, "profileCardGet", false, 0L, 0L, (HashMap<String, String>) null, "", false);
        }
    }

    private void handleGetSummaryCardForUdcInner(String str, Card card, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        boolean z16;
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), str);
        nTVasSimpleInfo.c();
        if (str.equals(this.appRuntime.getAccount()) && oidb_0x5eb_udcuindata.int32_history_num_flag.has()) {
            int i3 = oidb_0x5eb_udcuindata.int32_history_num_flag.get();
            ea.f4(this.appRuntime.getApplication(), this.appRuntime.getAccount(), i3);
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "history_num_flag= " + i3);
            }
        }
        if (oidb_0x5eb_udcuindata.uint64_game_appid.has()) {
            long j3 = oidb_0x5eb_udcuindata.uint64_game_appid.get();
            card.namePlateOfKingGameId = j3;
            nTVasSimpleInfo.namePlateOfKingGameId = j3;
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "namePlateOfKingGameId= " + j3);
            }
        }
        if (oidb_0x5eb_udcuindata.uint64_game_last_login_time.has()) {
            long j16 = oidb_0x5eb_udcuindata.uint64_game_last_login_time.get();
            card.namePlateOfKingLoginTime = j16;
            nTVasSimpleInfo.namePlateOfKingLoginTime = j16;
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "namePlateOfKingLoginTime= " + j16);
            }
        }
        if (oidb_0x5eb_udcuindata.uint32_plate_of_king_dan.has()) {
            int i16 = oidb_0x5eb_udcuindata.uint32_plate_of_king_dan.get();
            card.namePlateOfKingDan = i16;
            nTVasSimpleInfo.namePlateOfKingDan = i16;
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "namePlateOfKingDan= " + i16);
            }
        }
        if (oidb_0x5eb_udcuindata.uint32_plate_of_king_dan_display_switch.has()) {
            int i17 = oidb_0x5eb_udcuindata.uint32_plate_of_king_dan_display_switch.get();
            boolean z17 = true;
            if (i17 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            card.namePlateOfKingDanDisplatSwitch = z16;
            if (i17 != 1) {
                z17 = false;
            }
            nTVasSimpleInfo.namePlateOfKingDanDisplatSwitch = Boolean.valueOf(z17);
            if (!TextUtils.isEmpty(str) && this.appRuntime.getAccount().equals(str)) {
                this.appRuntime.getApplication().getSharedPreferences(ProfileContants.SP_PLATE_OF_KING, 0).edit().putBoolean("plate_of_king_display_switch_" + this.appRuntime.getAccount(), nTVasSimpleInfo.namePlateOfKingDanDisplatSwitch.booleanValue()).apply();
            }
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "namePlateOfKingDanDisplatSwitch= " + i17);
            }
        }
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, TAG, (c<NTVasSimpleInfo>) null);
        if (oidb_0x5eb_udcuindata.uint32_online_status_avatar_switch.has()) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "update online status avatar switch, uin=" + str);
            }
            ((IOnlineStatusAvatarSwitchService) this.appRuntime.getRuntimeService(IOnlineStatusAvatarSwitchService.class, "")).onSwitchUpdated(str, new f(oidb_0x5eb_udcuindata.uint32_online_status_avatar_switch.get()));
        }
        if (oidb_0x5eb_udcuindata.uint32_suspend_effect_id.has()) {
            int i18 = oidb_0x5eb_udcuindata.uint32_suspend_effect_id.get();
            if (i18 >= 0) {
                ((ISVIPHandler) ((AppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setColorScreenId(str, i18);
            }
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "uin " + str + " colorScreenid= " + i18);
            }
        }
        if (oidb_0x5eb_udcuindata.uint32_vas_face_id.has()) {
            ((ao) this.appRuntime.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308429f.i(str, oidb_0x5eb_udcuindata.uint32_vas_face_id.get());
        }
        handleGetSummaryCardForZplan(str, card, oidb_0x5eb_udcuindata);
        handleGetSummaryCardForQCircle(str, card, oidb_0x5eb_udcuindata);
    }

    private void handleGetSummaryCardForUdcInner2(String str, Card card, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        if (oidb_0x5eb_udcuindata.uint32_extend_friend_flag.has()) {
            card.extendFriendFlag = oidb_0x5eb_udcuindata.uint32_extend_friend_flag.get();
        }
        if (oidb_0x5eb_udcuindata.uint32_extend_friend_card_shown.has()) {
            if (oidb_0x5eb_udcuindata.uint32_extend_friend_card_shown.get() == 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            card.isShowCard = z26;
        }
        if (oidb_0x5eb_udcuindata.uint32_stranger_vote_switch.has()) {
            if (oidb_0x5eb_udcuindata.uint32_stranger_vote_switch.get() == 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            card.strangerVoteOpen = z19;
            if (str.equals(this.appRuntime.getAccount())) {
                ((com.tencent.mobileqq.nearby.a) this.appRuntime.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).b(card.strangerVoteOpen);
            }
        }
        if (oidb_0x5eb_udcuindata.uint32_school_status_flag.has()) {
            int i3 = oidb_0x5eb_udcuindata.uint32_school_status_flag.get();
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "uin " + str + " uint32_school_status_flag=" + i3);
            }
            card.newSchoolStatusFlagForGuide = i3;
        }
        if (oidb_0x5eb_udcuindata.uint32_flag_is_pretty_group_owner.has()) {
            if (oidb_0x5eb_udcuindata.uint32_flag_is_pretty_group_owner.get() == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            card.isPrettyGroupOwner = z18;
            QLog.e("vip_pretty.", 1, "uin " + str + " is pretty troop owner:" + card.isPrettyGroupOwner);
        }
        if (oidb_0x5eb_udcuindata.uint32_flag_hide_pretty_group_owner_identity.has()) {
            if (oidb_0x5eb_udcuindata.uint32_flag_hide_pretty_group_owner_identity.get() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            card.isHidePrettyGroutIdentity = z17;
            QLog.e("vip_pretty.", 1, "uin " + str + " is pretty hide troop owner identity:" + card.isHidePrettyGroutIdentity);
        }
        handleStickyNoteSwitch(str, card, oidb_0x5eb_udcuindata);
        if (oidb_0x5eb_udcuindata.uint32_flag_school_verified.has()) {
            if (oidb_0x5eb_udcuindata.uint32_flag_school_verified.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            card.schoolVerifiedFlag = z16;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("handleGetSummaryCard uin=%s schoolVerifiedFlag=%s", str, Boolean.valueOf(card.schoolVerifiedFlag)));
            }
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_qqcircle_switch.has()) {
            int i16 = oidb_0x5eb_udcuindata.uint32_profile_qqcircle_switch.get();
            card.switchQQCircle = (short) i16;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("handleGetSummaryCard uin=%s qqcircle_switch=%s", str, Integer.valueOf(i16)));
            }
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_life_achievement_switch.has()) {
            int i17 = oidb_0x5eb_udcuindata.uint32_profile_life_achievement_switch.get();
            card.switchLifeAchievement = (short) i17;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("handleGetSummaryCard uin=%s switch_life_achievement=%s", str, Integer.valueOf(i17)));
            }
        }
        if (oidb_0x5eb_udcuindata.uint32_profile_weishi_switch.has()) {
            int i18 = oidb_0x5eb_udcuindata.uint32_profile_weishi_switch.get();
            card.switchWeiShi = (short) i18;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("handleGetSummaryCard uin=%s switchWeishi=%s", str, Integer.valueOf(i18)));
            }
        }
    }

    private void handleGetSummaryCardForVote(RespHead respHead, RespSummaryCard respSummaryCard, SparseArray<BusinessRespBuffer> sparseArray, String str, Card card) {
        if (respHead != null) {
            card.vCookies = respHead.vCookies;
        }
        int i3 = respSummaryCard.i0x6d4Success;
        if (i3 != 0) {
            QLog.e(TAG, 1, String.format("handleGetSummaryCardForVote 0x6d4 fail. resultCode=%d", Integer.valueOf(i3)));
        }
        if (!setCardHotValue(card, sparseArray)) {
            if (respSummaryCard.i0x6d4Success == 0) {
                card.lVoteCount = respSummaryCard.iVoteCount;
                card.iVoteIncrement = respSummaryCard.iLastestVoteCount;
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleGetSummaryCard hot value cover vote.");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("handleGetSummaryCard lVoteCount=%d iVoteIncrement=%d", Long.valueOf(card.lVoteCount), Integer.valueOf(card.iVoteIncrement)));
        }
        if (respSummaryCard.i0x6d4Success == 0) {
            card.strVoteLimitedNotice = respSummaryCard.strVoteLimitedNotice;
            short s16 = respSummaryCard.bHaveVotedCnt;
            card.bHaveVotedCnt = s16;
            card.bAvailVoteCnt = respSummaryCard.bAvailVoteCnt;
            if (s16 > 0) {
                card.bVoted = (byte) 1;
            } else {
                card.bVoted = (byte) 0;
            }
            if (str.equals(this.appRuntime.getAccount())) {
                card.setLastPraiseInfoList(respSummaryCard.vPraiseList);
                ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setVoteInfo(this.appRuntime.getAccount(), card.lVoteCount, card.iVoteIncrement);
                EntityManager createEntityManager = this.appRuntime.getEntityManagerFactory().createEntityManager();
                NearbyPeopleCard nearbyPeopleCard = (NearbyPeopleCard) DBMethodProxy.find(createEntityManager, NearbyPeopleCard.class, "uin=?", new String[]{str});
                if (nearbyPeopleCard == null) {
                    nearbyPeopleCard = new NearbyPeopleCard();
                }
                nearbyPeopleCard.likeCount = (int) card.lVoteCount;
                nearbyPeopleCard.likeCountInc = card.iVoteIncrement;
                nearbyPeopleCard.praiseList = respSummaryCard.vPraiseList;
                if (nearbyPeopleCard.getStatus() == 1000) {
                    createEntityManager.persistOrReplace(nearbyPeopleCard);
                } else if (nearbyPeopleCard.getStatus() == 1001 || nearbyPeopleCard.getStatus() == 1002) {
                    createEntityManager.update(nearbyPeopleCard);
                }
                createEntityManager.close();
            }
        }
    }

    private void handleGetSummaryCardForZplan(String str, Card card, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        boolean z16;
        boolean z17;
        if (oidb_0x5eb_udcuindata.str_zplanphoto_url.has()) {
            String str2 = oidb_0x5eb_udcuindata.str_zplanphoto_url.get();
            card.strZplanDayUrl = str2;
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "uin " + str + " strZplanDayUrl= " + str2);
            }
        }
        boolean z18 = true;
        card.isZplanMasterShow = true;
        if (oidb_0x5eb_udcuindata.uint32_zplan_master_show.has()) {
            if (oidb_0x5eb_udcuindata.uint32_zplan_master_show.get() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            card.isZplanMasterShow = z17;
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "uin " + str + " isZplanMasterShow= " + z17);
            }
        }
        card.isZplanProfileCardShow = true;
        if (oidb_0x5eb_udcuindata.uint32_zplan_profile_card_show.has()) {
            if (oidb_0x5eb_udcuindata.uint32_zplan_profile_card_show.get() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            card.isZplanProfileCardShow = z16;
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "uin " + str + " isZplanProfileCardShow= " + z16);
            }
        }
        card.isZPlanAvatar = false;
        if (oidb_0x5eb_udcuindata.uint32_flag_zplan_edit_avatar.has()) {
            if (oidb_0x5eb_udcuindata.uint32_flag_zplan_edit_avatar.get() <= 0) {
                z18 = false;
            }
            card.isZPlanAvatar = z18;
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "uin " + str + " isZPlanAvatar= " + z18);
            }
        }
    }

    private boolean handleMiniAppPlayingInfo(Card card, SparseArray<BusinessRespBuffer> sparseArray, long j3, long j16) {
        boolean z16;
        ProfileMiniAppInfo profileMiniAppInfo = new ProfileMiniAppInfo();
        BusinessRespBuffer businessRespBuffer = sparseArray.get(17);
        if (businessRespBuffer != null && businessRespBuffer.buffer != null) {
            if (j3 == j16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                INTERFACE$StGetUserAppListRsp iNTERFACE$StGetUserAppListRsp = new INTERFACE$StGetUserAppListRsp();
                try {
                    iNTERFACE$StGetUserAppListRsp.mergeFrom(businessRespBuffer.buffer);
                    List<INTERFACE$StUserAppInfo> list = iNTERFACE$StGetUserAppListRsp.userAppList.get();
                    if (list != null && list.size() >= 1) {
                        ArrayList<INTERFACE$StApiAppInfo> arrayList = new ArrayList<>();
                        Iterator<INTERFACE$StUserAppInfo> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().appInfo.get());
                        }
                        profileMiniAppInfo.miniAppInfoArrayList = arrayList;
                        COMM.StCommonExt stCommonExt = iNTERFACE$StGetUserAppListRsp.extInfo;
                        if (stCommonExt != null && stCommonExt.mapInfo != null) {
                            for (int i3 = 0; i3 < iNTERFACE$StGetUserAppListRsp.extInfo.mapInfo.size(); i3++) {
                                COMM.Entry entry = iNTERFACE$StGetUserAppListRsp.extInfo.mapInfo.get(i3);
                                if (WadlProxyConsts.KEY_JUMP_URL.equals(entry.key.get())) {
                                    profileMiniAppInfo.tabJumpUrl = entry.value.get();
                                }
                            }
                        }
                    }
                    profileMiniAppInfo.isShowMiniPlaying = false;
                    QLog.e(TAG, 1, "handleMiniAppPlayingInfo: host request data is null.");
                    return true;
                } catch (Exception e16) {
                    profileMiniAppInfo.isShowMiniPlaying = false;
                    QLog.e(TAG, 1, "handleMiniAppPlayingInfo: host request exception.", e16);
                }
            } else {
                MISC$StGetFriendPlayListV2Rsp mISC$StGetFriendPlayListV2Rsp = new MISC$StGetFriendPlayListV2Rsp();
                try {
                    mISC$StGetFriendPlayListV2Rsp.mergeFrom(businessRespBuffer.buffer);
                    List<MISC$StAppPlayingInfo> list2 = mISC$StGetFriendPlayListV2Rsp.appPlayingInfos.get();
                    profileMiniAppInfo.appPlayingInfos = list2;
                    if (list2 != null && list2.size() >= 1) {
                        profileMiniAppInfo.guestJumpUrl = mISC$StGetFriendPlayListV2Rsp.moreJumpLink.get();
                        profileMiniAppInfo.guestAppTotal = mISC$StGetFriendPlayListV2Rsp.total.get();
                    }
                    profileMiniAppInfo.isShowMiniPlaying = false;
                    QLog.e(TAG, 1, "handleMiniAppPlayingInfo: guest request data is null.");
                    return true;
                } catch (InvalidProtocolBufferMicroException e17) {
                    profileMiniAppInfo.isShowMiniPlaying = false;
                    QLog.e(TAG, 1, "handleMiniAppPlayingInfo: guest request exception.", e17);
                }
            }
            profileMiniAppInfo.isShowMiniPlaying = true;
        } else {
            profileMiniAppInfo.isShowMiniPlaying = false;
        }
        card.putBusinessInfo(profileMiniAppInfo);
        return true;
    }

    private void handleMutualMarkInfo(Card card, SparseArray<BusinessRespBuffer> sparseArray) {
        if (card == null) {
            QLog.e(TAG, 1, "[handleMutualMarkInfo] card is null");
            return;
        }
        BusinessRespBuffer businessRespBuffer = sparseArray.get(24);
        if (businessRespBuffer != null && businessRespBuffer.buffer != null) {
            MutualMarkCard$RspBody mutualMarkCard$RspBody = new MutualMarkCard$RspBody();
            try {
                mutualMarkCard$RspBody.mergeFrom(businessRespBuffer.buffer);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[handleMutualMarkInfo] merge rsp fail", th5);
            }
            card.mutualStateList = new ArrayList(mutualMarkCard$RspBody.state.get());
            card.mutualGuide = mutualMarkCard$RspBody.guide.get();
            card.mutualCount = mutualMarkCard$RspBody.total_count.get();
            card.mutualHomeUrl = mutualMarkCard$RspBody.home_url.get();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[handleMutualMarkInfo]card.mutualStateList.size=" + card.mutualStateList.size() + ", card.mutualCount=" + card.mutualCount + ", jumpUrl=" + card.mutualHomeUrl);
                if (card.mutualGuide != null) {
                    QLog.i(TAG, 2, "[handleMutualMarkInfo]card.mutualGuide.desc=" + card.mutualGuide.desc.get());
                    return;
                }
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "[handleMutualMarkInfo] vvResp or vResp.buffer is null");
    }

    private void handleQCircleResourceInfo(Card card, SparseArray<BusinessRespBuffer> sparseArray, long j3, long j16) {
        byte[] bArr;
        if (card == null) {
            QLog.e(TAG, 1, "[handleQCircleResourceInfo] card is null");
            return;
        }
        BusinessRespBuffer businessRespBuffer = sparseArray.get(21);
        if (businessRespBuffer != null && (bArr = businessRespBuffer.buffer) != null && bArr.length != 0) {
            FeedCloudDatacard$GetDataCardCoverRsp feedCloudDatacard$GetDataCardCoverRsp = new FeedCloudDatacard$GetDataCardCoverRsp();
            try {
                feedCloudDatacard$GetDataCardCoverRsp.mergeFrom(businessRespBuffer.buffer);
                FeedCloudMeta$StFeedAbstract feedCloudMeta$StFeedAbstract = feedCloudDatacard$GetDataCardCoverRsp.feed.get();
                if (feedCloudMeta$StFeedAbstract != null) {
                    card.qcircleFeedId = feedCloudMeta$StFeedAbstract.f398450id.get();
                    card.qcircleFeedPosterUin = feedCloudMeta$StFeedAbstract.poster.f398463id.get();
                    card.qcircleVideoUrl = feedCloudMeta$StFeedAbstract.video.playUrl.get();
                    card.qcircleVideoHeight = feedCloudMeta$StFeedAbstract.video.height.get();
                    card.qcircleVideoWidth = feedCloudMeta$StFeedAbstract.video.width.get();
                    card.qcircleVideoCoverUrl = feedCloudMeta$StFeedAbstract.pic.picUrl.get();
                }
                if (feedCloudDatacard$GetDataCardCoverRsp.client_info.get() != null) {
                    FeedCloudDatacard$DataCardCoverClientInfo feedCloudDatacard$DataCardCoverClientInfo = new FeedCloudDatacard$DataCardCoverClientInfo();
                    feedCloudDatacard$DataCardCoverClientInfo.mergeFrom(feedCloudDatacard$GetDataCardCoverRsp.client_info.get().toByteArray());
                    card.qcircleCoverY = feedCloudDatacard$DataCardCoverClientInfo.y_percent.get();
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "[handleQCircleResourceInfo] merge rsp failed", e16);
                return;
            }
        }
        QLog.e(TAG, 1, "[handleQCircleResourceInfo] vvResp.buffer null");
    }

    private void handleSimilarityInfo(Card card, SparseArray<BusinessRespBuffer> sparseArray) {
        StrongSimilarityData strongSimilarityData;
        if (card == null) {
            QLog.e(TAG, 1, "[handleSimilarityInfo] card is null");
            return;
        }
        BusinessRespBuffer businessRespBuffer = sparseArray.get(22);
        if (businessRespBuffer != null && businessRespBuffer.buffer != null) {
            SummaryCardSimilarity$GetSummaryCardSimilarityRsp summaryCardSimilarity$GetSummaryCardSimilarityRsp = new SummaryCardSimilarity$GetSummaryCardSimilarityRsp();
            try {
                summaryCardSimilarity$GetSummaryCardSimilarityRsp.mergeFrom(businessRespBuffer.buffer);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[handleSimilarityInfo] merge rsp fail", th5);
            }
            if (summaryCardSimilarity$GetSummaryCardSimilarityRsp.ret_code.get() != 0) {
                QLog.e(TAG, 1, "[handleSimilarityInfo] error, code=" + summaryCardSimilarity$GetSummaryCardSimilarityRsp.ret_code.get() + ", msg=" + summaryCardSimilarity$GetSummaryCardSimilarityRsp.err_msg.get());
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (SummaryCardSimilarity$Similarity summaryCardSimilarity$Similarity : summaryCardSimilarity$GetSummaryCardSimilarityRsp.similarities.get()) {
                if (summaryCardSimilarity$Similarity != null) {
                    SimilarityData similarityData = new SimilarityData(summaryCardSimilarity$Similarity.icon.get(), summaryCardSimilarity$Similarity.title.get(), summaryCardSimilarity$Similarity.wordings.get());
                    arrayList.add(similarityData);
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "[handleSimilarityInfo][similarityData]" + similarityData.toString());
                    }
                }
            }
            card.similarityData = arrayList;
            card.isStrongSimilarity = summaryCardSimilarity$GetSummaryCardSimilarityRsp.is_strong_similarity.get();
            SummaryCardSimilarity$StrongSimilarity summaryCardSimilarity$StrongSimilarity = summaryCardSimilarity$GetSummaryCardSimilarityRsp.strong_similarity.get();
            if (summaryCardSimilarity$StrongSimilarity != null) {
                strongSimilarityData = new StrongSimilarityData(summaryCardSimilarity$StrongSimilarity.icon.get(), summaryCardSimilarity$StrongSimilarity.content.get()).setTimeThread(summaryCardSimilarity$StrongSimilarity.time_thread.get()).setDisplayDuration(summaryCardSimilarity$StrongSimilarity.display_time.get()).setDelayDisplayTime(summaryCardSimilarity$StrongSimilarity.start_display.get());
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "[handleSimilarityInfo][strongSimilarityData]" + strongSimilarityData.toString());
                }
            } else {
                strongSimilarityData = null;
            }
            card.strongSimilarityData = strongSimilarityData;
            return;
        }
        QLog.e(TAG, 1, "[handleSimilarityInfo] vvResp or vResp.buffer is null");
    }

    private void handleStickyNoteSwitch(String str, Card card, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        if (oidb_0x5eb_udcuindata.uint32_profile_sticky_note_switch.has()) {
            int i3 = oidb_0x5eb_udcuindata.uint32_profile_sticky_note_switch.get();
            card.switchStickyNote = (short) i3;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("handleGetSummaryCard uin=%s sticky_note_switch=%s", str, Integer.valueOf(i3)));
            }
        }
        card.offlineStickyNote = (short) 1;
    }

    private boolean handleVaProfileGate(Card card, SparseArray<BusinessRespBuffer> sparseArray) {
        int i3;
        BusinessRespBuffer businessRespBuffer = sparseArray.get(16);
        if (businessRespBuffer != null && businessRespBuffer.buffer != null) {
            VaProfileGate$VaProfileGateRsp vaProfileGate$VaProfileGateRsp = new VaProfileGate$VaProfileGateRsp();
            try {
                vaProfileGate$VaProfileGateRsp.mergeFrom(businessRespBuffer.buffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 1, "rsp VASPROFILEGATE_SERVICE decode error:" + e16);
                return false;
            }
            if (vaProfileGate$VaProfileGateRsp.iRetCode.get() == 0) {
                if (vaProfileGate$VaProfileGateRsp.lhLogoLv.has()) {
                    card.lhLevel = vaProfileGate$VaProfileGateRsp.lhLogoLv.get();
                }
                parseQidInfo(card, vaProfileGate$VaProfileGateRsp);
                parseMedalInfo(card, vaProfileGate$VaProfileGateRsp);
                VaProfileGate$PrivilegeBaseInfoRsp vaProfileGate$PrivilegeBaseInfoRsp = vaProfileGate$VaProfileGateRsp.stPrivilegeRsp;
                VaProfileGate$GetGiftListRsp vaProfileGate$GetGiftListRsp = vaProfileGate$VaProfileGateRsp.stGiftRsp;
                for (int i16 = 0; i16 < vaProfileGate$VaProfileGateRsp.rpt_task_item.size(); i16++) {
                    VaProfileGate$CommTaskInfo vaProfileGate$CommTaskInfo = vaProfileGate$VaProfileGateRsp.rpt_task_item.get(i16);
                    if (4 == vaProfileGate$CommTaskInfo.uint32_appid.get()) {
                        com.tencent.mobileqq.profile.musicbox.a.j(vaProfileGate$CommTaskInfo, card);
                    }
                }
                VaProfileGate$GetSplendidRsp vaProfileGate$GetSplendidRsp = vaProfileGate$VaProfileGateRsp.splendid_info;
                card.splendidIsGray = vaProfileGate$GetSplendidRsp.is_gray.get();
                card.splendidIsOn = vaProfileGate$GetSplendidRsp.is_on.get();
                card.splendidItems.clear();
                List<VaProfileGate$SplendidItem> list = vaProfileGate$GetSplendidRsp.splendid_list.get();
                for (int i17 = 0; i17 < list.size(); i17++) {
                    SplendidItemData splendidItemData = new SplendidItemData();
                    splendidItemData.displayUrl = list.get(i17).display_url.get();
                    splendidItemData.name = list.get(i17).name.get();
                    splendidItemData.jumpUrl = list.get(i17).jump_url.get();
                    card.splendidItems.add(splendidItemData);
                }
                card.splendidNum = vaProfileGate$GetSplendidRsp.num.get();
                card.splendidNValueNum = vaProfileGate$GetSplendidRsp.value_n.get();
                card.splendidJumpUrl = vaProfileGate$GetSplendidRsp.jump_url.get();
                card.presentDesc = vaProfileGate$GetGiftListRsp.desc.get();
                card.presentCustourl = vaProfileGate$GetGiftListRsp.custom_url.get();
                card.presentSwitch = vaProfileGate$GetGiftListRsp.is_on.get();
                card.presentUrl = vaProfileGate$GetGiftListRsp.gift_url.get();
                card.presentNum = vaProfileGate$GetGiftListRsp.gift_num.get();
                if (vaProfileGate$GetGiftListRsp.is_on.get()) {
                    ReportController.o(this.appRuntime, "", "", "", "0X800A1CA", "0X800A1CA", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(this.appRuntime, "", "", "", "0X800A1CB", "0X800A1CB", 0, 0, "", "", "", "");
                }
                if (card.presentUrl.size() > 0) {
                    card.showPresent = true;
                } else {
                    card.showPresent = false;
                }
                parseDressUpInfo(card, vaProfileGate$VaProfileGateRsp);
                parseQQCardInfo(card, vaProfileGate$VaProfileGateRsp);
                parseIPrivilegeInfo(card, vaProfileGate$VaProfileGateRsp, vaProfileGate$PrivilegeBaseInfoRsp);
                parseBigVipLevelBadge(card, vaProfileGate$VaProfileGateRsp);
                parseSvipPrivilegeShow(card, vaProfileGate$VaProfileGateRsp);
                if (vaProfileGate$VaProfileGateRsp.rpt_oidb_flag.has()) {
                    List<VaProfileGate$OidbFlagInfo> list2 = vaProfileGate$VaProfileGateRsp.rpt_oidb_flag.get();
                    for (int i18 = 0; i18 < list2.size(); i18++) {
                        VaProfileGate$OidbFlagInfo vaProfileGate$OidbFlagInfo = list2.get(i18);
                        if (vaProfileGate$OidbFlagInfo.uint32_fieled.get() == 42334) {
                            String stringUtf8 = vaProfileGate$OidbFlagInfo.byets_value.get().toStringUtf8();
                            try {
                                card.mQQLevelType = Integer.parseInt(stringUtf8);
                            } catch (NumberFormatException unused) {
                                QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 2, "rsp VASPROFILEGATE_SERVICE oidb FIELD_QQ_LEVEL_ICON_TYPE flag content error , valStr:" + stringUtf8);
                            }
                        } else if (vaProfileGate$OidbFlagInfo.uint32_fieled.get() == 42340) {
                            String stringUtf82 = vaProfileGate$OidbFlagInfo.byets_value.get().toStringUtf8();
                            try {
                                card.switchMusicBox = Short.parseShort(stringUtf82);
                            } catch (NumberFormatException unused2) {
                                QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 2, "rsp VASPROFILEGATE_SERVICE oidb FIELD_MUSICBOX_SWITCH flag content error , valStr:" + stringUtf82);
                            }
                        } else if (vaProfileGate$OidbFlagInfo.uint32_fieled.get() == 42344) {
                            String stringUtf83 = vaProfileGate$OidbFlagInfo.byets_value.get().toStringUtf8();
                            try {
                                card.nameplateVipType = Short.parseShort(stringUtf83);
                                QLog.i(TAG, 1, "handleVaProfileGate = " + card.nameplateVipType);
                            } catch (NumberFormatException unused3) {
                                QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 2, "rsp VASPROFILEGATE_SERVICE oidb FIELD_NAMEPLATEVIPTYPE flag content error , valStr:" + stringUtf83);
                            }
                        } else if (vaProfileGate$OidbFlagInfo.uint32_fieled.get() == 42354) {
                            String stringUtf84 = vaProfileGate$OidbFlagInfo.byets_value.get().toStringUtf8();
                            try {
                                card.grayNameplateFlag = Short.parseShort(stringUtf84);
                            } catch (NumberFormatException unused4) {
                                QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 2, "rsp VASPROFILEGATE_SERVICE oidb FIELD_GRAYNAMEPLATE flag content error , valStr:" + stringUtf84);
                            }
                        } else {
                            if (vaProfileGate$OidbFlagInfo.uint32_fieled.get() == 27375) {
                                try {
                                    Dialogue dialogue = new Dialogue();
                                    dialogue.mergeFrom(vaProfileGate$OidbFlagInfo.byets_value.get().toByteArray());
                                    if (dialogue.nameplate_pendant_itemid.has()) {
                                        i3 = dialogue.nameplate_pendant_itemid.get();
                                    } else {
                                        i3 = 0;
                                    }
                                    card.nameplateExtId = i3;
                                    card.gameCardId = dialogue.game_nameplate.get();
                                    card.vipStarFlag = dialogue.vipstar_flag.get();
                                    String vipIconsString = com.tencent.mobileqq.vip.api.d.a().getVipIconsString(dialogue.diy_nameplate_ids.get());
                                    if (vipIconsString != null) {
                                        card.vipIcons = vipIconsString;
                                    }
                                    card.vipDataFlag = dialogue.qqvadata_changerand.get();
                                    com.tencent.mobileqq.vip.api.b.a().updateFlagData(card.uin, card.vipDataFlag);
                                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                    if (peekAppRuntime != null && TextUtils.equals(card.uin, peekAppRuntime.getCurrentUin())) {
                                        int i19 = dialogue.aio_badge_show_switch.get();
                                        if (QLog.isDebugVersion()) {
                                            VasLogNtReporter.getVipIcon().reportDebug("friend aioBadgeShowSwitch=" + i19);
                                        }
                                        VipNtMMKV.getCommon(card.uin).encodeInt("aioBadgeShowSwitch", i19);
                                    }
                                    if (card.vipDataFlag > 0) {
                                        String str = card.uin;
                                        if (!TextUtils.isEmpty(str) && VasToggle.BUG_103247711.isEnable(true)) {
                                            com.tencent.mobileqq.vip.api.b.a().requestAndUpdateData(str, null);
                                        }
                                    }
                                } catch (Exception e17) {
                                    QLog.d(TAG, 1, "big_vip_ext,card_parse,error:" + e17.getMessage());
                                }
                            }
                        }
                        QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 1, "rsp VASPROFILEGATE_SERVICE decode error:" + e16);
                        return false;
                    }
                }
                if (vaProfileGate$VaProfileGateRsp.get_clm_tip_rsp.has()) {
                    ((ao) this.appRuntime.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).e(ao.b(vaProfileGate$VaProfileGateRsp.get_clm_tip_rsp.get()));
                } else if (QLog.isColorLevel()) {
                    QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 2, "rsp data is null");
                }
                if (vaProfileGate$VaProfileGateRsp.qq_value.has()) {
                    m23.b.b().e(card.uin, vaProfileGate$VaProfileGateRsp.qq_value.get());
                }
                ((IProfileDataService) this.appRuntime.getRuntimeService(IProfileDataService.class, "all")).saveProfileCard(card);
                if (!vaProfileGate$VaProfileGateRsp.stPrivilegeRsp.has()) {
                    QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 1, "rsp VASPROFILEGATE_SERVICE decode priv rsp is null!");
                    return false;
                }
                if (vaProfileGate$PrivilegeBaseInfoRsp.uIsGrayUsr.get() != 0) {
                    return true;
                }
                QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 1, "rsp VASPROFILEGATE_SERVICE current user is not gray user.");
                return false;
            }
            QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 1, "rsp VASPROFILEGATE_SERVICE failed:" + vaProfileGate$VaProfileGateRsp.iRetCode.get() + " msg=" + vaProfileGate$VaProfileGateRsp.sRetMsg.get().toStringUtf8());
            return false;
        }
        QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 1, "rsp VASPROFILEGATE_SERVICE is null!");
        return false;
    }

    private void handleZPlanResourceInfo(Card card, SparseArray<BusinessRespBuffer> sparseArray, long j3, long j16) {
        if (card == null) {
            QLog.e(TAG, 1, "[handleZPlanResourceInfo] card is null");
            return;
        }
        BusinessRespBuffer businessRespBuffer = sparseArray.get(20);
        if (businessRespBuffer != null && businessRespBuffer.buffer != null) {
            dataCard$RspBody datacard_rspbody = new dataCard$RspBody();
            try {
                datacard_rspbody.mergeFrom(businessRespBuffer.buffer);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[handleZPlanResourceInfo] merge rsp fail", th5);
            }
            if (datacard_rspbody.infos.isEmpty()) {
                QLog.e(TAG, 1, "[handleZPlanResourceInfo] user_infos empty");
                return;
            }
            HashMap hashMap = new HashMap();
            for (commonPb$Info commonpb_info : datacard_rspbody.infos.get()) {
                if (commonpb_info != null) {
                    hashMap.put(Integer.valueOf(commonpb_info.des.get().name.get()), commonpb_info.value.get());
                }
            }
            card.strZPlanNightUrl = (String) hashMap.get(3);
            card.strZPlanShpUrl = (String) hashMap.get(4);
            card.strZPlanProperty = (String) hashMap.get(9);
            card.zplanAppearanceKey = (String) hashMap.get(5);
            card.zplanNameplateId = (String) hashMap.get(20);
            QLog.e(TAG, 1, "test: " + ((String) hashMap.get(25)));
            card.isZPlanProfileCardMiniHomeShow = (String) hashMap.get(25);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[handleZPlanResourceInfo] card.strZPlanNightUrl\uff1a", card.strZPlanNightUrl, " card.strZPlanShpUrl:", card.strZPlanShpUrl, " zplanAppearanceKey:", card.zplanAppearanceKey, " card.zplanNameplateId:", card.zplanNameplateId, " isZPlanProfileCardMiniHomeShow:" + card.isZPlanProfileCardMiniHomeShow);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[handleZPlanResourceInfo] vvResp or vvResp.buffer == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyContactChange(String str) {
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.appRuntime.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null && iPhoneContactService.queryPhoneContactByUin(str) != null) {
            iPhoneContactService.notifyContactChanged();
        }
    }

    private void parseBigVipLevelBadge(Card card, VaProfileGate$VaProfileGateRsp vaProfileGate$VaProfileGateRsp) {
        VaProfileGate$BigVipBadgeItem vaProfileGate$BigVipBadgeItem = vaProfileGate$VaProfileGateRsp.big_vip_badge_item;
        if (vaProfileGate$BigVipBadgeItem == null) {
            return;
        }
        card.bigVipBadgeItemId = vaProfileGate$BigVipBadgeItem.item_id.get();
    }

    private void parseDressUpInfo(Card card, VaProfileGate$VaProfileGateRsp vaProfileGate$VaProfileGateRsp) {
        VaProfileGate$GetGxhUsingRsp vaProfileGate$GetGxhUsingRsp = vaProfileGate$VaProfileGateRsp.gxh_using;
        if (vaProfileGate$GetGxhUsingRsp == null) {
            return;
        }
        card.dressUpJumpUrl = vaProfileGate$GetGxhUsingRsp.jump_url.get();
        card.dressUpIsOn = vaProfileGate$GetGxhUsingRsp.is_on.get();
        ArrayList arrayList = new ArrayList();
        for (VaProfileGate$GxhUsingItem vaProfileGate$GxhUsingItem : vaProfileGate$GetGxhUsingRsp.item_list.get()) {
            arrayList.add(new UsingDressUpItemData(vaProfileGate$GxhUsingItem.url.get(), vaProfileGate$GxhUsingItem.app_name.get(), vaProfileGate$GxhUsingItem.report_appid.get(), vaProfileGate$GxhUsingItem.item_bg_color.get()));
        }
        card.dressUpList = arrayList;
        card.dressByte = vaProfileGate$GetGxhUsingRsp.toByteArray();
        card.dressSuitJumpUrl = vaProfileGate$GetGxhUsingRsp.suit_jump_url.get();
        ArrayList arrayList2 = new ArrayList();
        for (VaProfileGate$GxhSuit vaProfileGate$GxhSuit : vaProfileGate$GetGxhUsingRsp.suit_list.get()) {
            arrayList2.add(new GxhSuitItemData(vaProfileGate$GxhSuit.url.get(), vaProfileGate$GxhSuit.number.get(), vaProfileGate$GxhSuit.is_long_series.get(), vaProfileGate$GxhSuit.f342171id.get()));
        }
        card.dressSuits = arrayList2;
        card.ipCardsJumpUrl = vaProfileGate$GetGxhUsingRsp.ip_jump_url.get();
        card.dressUpTitle = vaProfileGate$GetGxhUsingRsp.title.get();
        card.dressUpShowType = DressUpShowType.fromInt(vaProfileGate$GetGxhUsingRsp.type.get());
        ArrayList arrayList3 = new ArrayList();
        for (VaProfileGate$GxhIPCollection vaProfileGate$GxhIPCollection : vaProfileGate$GetGxhUsingRsp.ip_list.get()) {
            arrayList3.add(new GxhIPCollectionData(vaProfileGate$GxhIPCollection.url.get(), vaProfileGate$GxhIPCollection.number.get(), vaProfileGate$GxhIPCollection.is_long_series.get(), vaProfileGate$GxhIPCollection.f342170id.get(), vaProfileGate$GxhIPCollection.level.get()));
        }
        card.ipCards = arrayList3;
    }

    private void parseIPrivilegeInfo(Card card, VaProfileGate$VaProfileGateRsp vaProfileGate$VaProfileGateRsp, VaProfileGate$PrivilegeBaseInfoRsp vaProfileGate$PrivilegeBaseInfoRsp) {
        VaProfileGate$PrivilegeBaseInfoRsp vaProfileGate$PrivilegeBaseInfoRsp2 = vaProfileGate$PrivilegeBaseInfoRsp;
        if (vaProfileGate$VaProfileGateRsp.stPrivilegeRsp.has() && vaProfileGate$PrivilegeBaseInfoRsp2.uIsGrayUsr.get() != 0) {
            card.privilegePromptStr = vaProfileGate$PrivilegeBaseInfoRsp2.strMsg.get().toStringUtf8();
            card.privilegeJumpUrl = vaProfileGate$PrivilegeBaseInfoRsp2.strJumpUrl.get().toStringUtf8();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < vaProfileGate$PrivilegeBaseInfoRsp2.vOpenPriv.size(); i3++) {
                VaProfileGate$PrivilegeInfo vaProfileGate$PrivilegeInfo = vaProfileGate$PrivilegeBaseInfoRsp2.vOpenPriv.get(i3);
                arrayList.add(new PrivilegeInfo(vaProfileGate$PrivilegeInfo.iType.get(), vaProfileGate$PrivilegeInfo.iSort.get(), vaProfileGate$PrivilegeInfo.iFeeType.get(), vaProfileGate$PrivilegeInfo.iLevel.get(), vaProfileGate$PrivilegeInfo.iFlag.get(), vaProfileGate$PrivilegeInfo.strIconUrl.get().toStringUtf8(), vaProfileGate$PrivilegeInfo.strDeluxeIconUrl.get().toStringUtf8(), vaProfileGate$PrivilegeInfo.strJumpUrl.get().toStringUtf8(), vaProfileGate$PrivilegeInfo.iIsBig.get(), vaProfileGate$PrivilegeInfo.iIsRemind.get(), vaProfileGate$PrivilegeInfo.iRemindTime.get(), vaProfileGate$PrivilegeInfo.strTipsIconUrl.get(), vaProfileGate$PrivilegeInfo.iTipsTimes.get(), vaProfileGate$PrivilegeInfo.strExtInfo.get().toStringUtf8()));
            }
            ArrayList arrayList2 = new ArrayList();
            int i16 = 0;
            while (i16 < vaProfileGate$PrivilegeBaseInfoRsp2.vClosePriv.size()) {
                VaProfileGate$PrivilegeInfo vaProfileGate$PrivilegeInfo2 = vaProfileGate$PrivilegeBaseInfoRsp2.vClosePriv.get(i16);
                arrayList2.add(new PrivilegeInfo(vaProfileGate$PrivilegeInfo2.iType.get(), vaProfileGate$PrivilegeInfo2.iSort.get(), vaProfileGate$PrivilegeInfo2.iFeeType.get(), vaProfileGate$PrivilegeInfo2.iLevel.get(), vaProfileGate$PrivilegeInfo2.iFlag.get(), vaProfileGate$PrivilegeInfo2.strIconUrl.get().toStringUtf8(), vaProfileGate$PrivilegeInfo2.strDeluxeIconUrl.get().toStringUtf8(), vaProfileGate$PrivilegeInfo2.strJumpUrl.get().toStringUtf8(), vaProfileGate$PrivilegeInfo2.iIsBig.get(), vaProfileGate$PrivilegeInfo2.iIsRemind.get(), vaProfileGate$PrivilegeInfo2.iRemindTime.get(), vaProfileGate$PrivilegeInfo2.strTipsIconUrl.get(), vaProfileGate$PrivilegeInfo2.iTipsTimes.get(), vaProfileGate$PrivilegeInfo2.strExtInfo.get().toStringUtf8()));
                i16++;
                vaProfileGate$PrivilegeBaseInfoRsp2 = vaProfileGate$PrivilegeBaseInfoRsp;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DIYProfileTemplate.TempProfileBusinessProcessor", 1, "save privilege open list=" + arrayList.size() + " close list=" + arrayList2.size());
            }
            card.savePrivilegeOpenedInfo(arrayList);
            card.savePrivilegeClosedInfo(arrayList2);
        }
    }

    private void parseMedalInfo(Card card, VaProfileGate$VaProfileGateRsp vaProfileGate$VaProfileGateRsp) {
        card.vipMedalId = 0;
        if (vaProfileGate$VaProfileGateRsp.vip_medal_item.has()) {
            VaProfileGate$VipMedalItem vaProfileGate$VipMedalItem = vaProfileGate$VaProfileGateRsp.vip_medal_item.get();
            if (vaProfileGate$VipMedalItem.item_id.has()) {
                card.vipMedalId = vaProfileGate$VipMedalItem.item_id.get();
            }
            if (vaProfileGate$VipMedalItem.jump_url.has()) {
                card.vipMedalJumpUrl = vaProfileGate$VipMedalItem.jump_url.get();
            }
        }
    }

    private void parseQQCardInfo(Card card, VaProfileGate$VaProfileGateRsp vaProfileGate$VaProfileGateRsp) {
        VaProfileGate$GetCardRsp vaProfileGate$GetCardRsp = vaProfileGate$VaProfileGateRsp.card_info;
        if (vaProfileGate$GetCardRsp == null) {
            return;
        }
        card.qqCardJumpUrl = vaProfileGate$GetCardRsp.jump_url.get();
        boolean z16 = false;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("vas_profile_qqcard", false);
        if (vaProfileGate$GetCardRsp.is_on.get() && isSwitchOn) {
            z16 = true;
        }
        card.qqCardIsOn = z16;
        card.cardNameplateId = vaProfileGate$GetCardRsp.nameplate_id.get();
        QLog.d(TAG, 1, "parseQQCardInfo: is_on=" + vaProfileGate$GetCardRsp.is_on.get() + ",featureIsOn=" + isSwitchOn);
        ArrayList arrayList = new ArrayList();
        for (VaProfileGate$CardItem vaProfileGate$CardItem : vaProfileGate$GetCardRsp.item_list.get()) {
            arrayList.add(new QQCardItemData(vaProfileGate$CardItem.url.get(), vaProfileGate$CardItem.card_id.get()));
        }
        card.qqCardList = arrayList;
    }

    private void parseQidInfo(Card card, VaProfileGate$VaProfileGateRsp vaProfileGate$VaProfileGateRsp) {
        if (vaProfileGate$VaProfileGateRsp.qid_info.has()) {
            VaProfileGate$QidInfoItem vaProfileGate$QidInfoItem = vaProfileGate$VaProfileGateRsp.qid_info.get();
            if (vaProfileGate$QidInfoItem.qid.has()) {
                ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).updateLoginAccount(card.qid, vaProfileGate$QidInfoItem.qid.get());
                card.qid = vaProfileGate$QidInfoItem.qid.get();
            }
            if (vaProfileGate$QidInfoItem.color.has()) {
                card.qidColor = vaProfileGate$QidInfoItem.color.get();
            }
            if (vaProfileGate$QidInfoItem.logo_url.has()) {
                card.qidLogoUrl = vaProfileGate$QidInfoItem.logo_url.get();
            }
            if (vaProfileGate$QidInfoItem.url.has()) {
                card.qidBgUrl = vaProfileGate$QidInfoItem.url.get();
            }
        }
    }

    private void parseSvipPrivilegeShow(Card card, VaProfileGate$VaProfileGateRsp vaProfileGate$VaProfileGateRsp) {
        boolean z16;
        VaProfileGate$PrivilegeShowRsp vaProfileGate$PrivilegeShowRsp = vaProfileGate$VaProfileGateRsp.privilege_show_rsp;
        if (vaProfileGate$PrivilegeShowRsp == null) {
            return;
        }
        IConfigProxy iConfigProxy = VasNormalToggle.VAS_PROFILE_CARD_SVIP_PRIVILEGE;
        boolean isEnable = iConfigProxy.isEnable(true);
        long optLong = iConfigProxy.getJson().optLong("time_out", 1000L);
        card.svipPrivilegeLimitTime = optLong;
        if (vaProfileGate$PrivilegeShowRsp.is_show.get() && isEnable) {
            z16 = true;
        } else {
            z16 = false;
        }
        card.svipPrivilegeNeedShow = z16;
        QLog.d(TAG, 1, "parseSvipPrivilegeShow: is_on=" + vaProfileGate$PrivilegeShowRsp.is_show.get() + ",featureIsOn=" + isEnable + ",timeOut=" + optLong);
        ArrayList arrayList = new ArrayList();
        for (VaProfileGate$PrivilegeShowItem vaProfileGate$PrivilegeShowItem : vaProfileGate$PrivilegeShowRsp.privilege_show_list.get()) {
            SvipPrivilegeShow svipPrivilegeShow = new SvipPrivilegeShow();
            svipPrivilegeShow.appId = vaProfileGate$PrivilegeShowItem.appid.get();
            svipPrivilegeShow.isRecommend = vaProfileGate$PrivilegeShowItem.is_recommend.get();
            svipPrivilegeShow.itemId = vaProfileGate$PrivilegeShowItem.item_id.get();
            svipPrivilegeShow.text = vaProfileGate$PrivilegeShowItem.text.get();
            svipPrivilegeShow.icon = vaProfileGate$PrivilegeShowItem.icon.get();
            arrayList.add(svipPrivilegeShow);
        }
        card.svipPrivilegeShowItems = arrayList;
    }

    private void updateFriendInfo(RespSummaryCard respSummaryCard, String str, Card card, long j3) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        updateVipInfo(respSummaryCard, card, uidFromUin, new AnonymousClass3(uidFromUin, str, card, j3));
    }

    private void updateRichSign(RespSummaryCard respSummaryCard, long j3, String str) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, TAG);
        if (friendsSimpleInfoWithUid == null) {
            friendsSimpleInfoWithUid = new d(uidFromUin, str);
        }
        updateRichSign(respSummaryCard, str, j3, friendsSimpleInfoWithUid, new c<Boolean>(str, uidFromUin, respSummaryCard) { // from class: com.tencent.mobileqq.profilecard.processor.TempProfileBusinessProcessor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ RespSummaryCard val$respSummaryCard;
            final /* synthetic */ String val$strTargetUin;
            final /* synthetic */ String val$uid;

            {
                this.val$strTargetUin = str;
                this.val$uid = uidFromUin;
                this.val$respSummaryCard = respSummaryCard;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TempProfileBusinessProcessor.this, str, uidFromUin, respSummaryCard);
                }
            }

            @Override // hx3.c
            public void onUpdateResult(@Nullable e<Boolean> eVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    TempProfileBusinessProcessor.updateRichSignVasInfo(this.val$strTargetUin, this.val$uid, this.val$respSummaryCard);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateRichSignVasInfo(String str, String str2, RespSummaryCard respSummaryCard) {
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(str2, str);
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.pendantId = respSummaryCard.ulFaceAddonId;
        nTVasSimpleInfo.timestamp = System.currentTimeMillis();
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, TAG, (c<NTVasSimpleInfo>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpecialFlag(Card card, long j3) {
        byte byteValue;
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(card.uin);
        d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, TAG);
        if (friendsSimpleInfoWithUid == null) {
            friendsSimpleInfoWithUid = new d(uidFromUin, card.uin);
        }
        d dVar = new d(uidFromUin, card.uin);
        dVar.M();
        if (friendsSimpleInfoWithUid.e() == null) {
            byteValue = 0;
        } else {
            byteValue = friendsSimpleInfoWithUid.e().byteValue();
        }
        if ((j3 & 8) != 0) {
            if ((card.lUserFlag & 1) != 0) {
                dVar.c0(Byte.valueOf((byte) (byteValue | 1)));
            } else {
                dVar.c0(Byte.valueOf((byte) (byteValue & (-2))));
            }
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(dVar, TAG, (c<d>) null);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "cardhandler uin=" + friendsSimpleInfoWithUid.x() + ", cSpecialFlag=" + friendsSimpleInfoWithUid.e());
            }
        }
    }

    private void updateTroopInfo(long j3, int i3, RespSummaryCard respSummaryCard, String str) {
        n nVar;
        DiscussionMemberInfo l3;
        if (j3 > 0) {
            ITroopInfoService iTroopInfoService = (ITroopInfoService) this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
            if (i3 != 2 && i3 != 5 && i3 != 7) {
                if (i3 == 4 && (l3 = (nVar = (n) this.appRuntime.getManager(QQManagerFactory.DISCUSSION_MANAGER)).l(String.valueOf(j3), str)) != null) {
                    l3.memberName = respSummaryCard.strNick;
                    String str2 = respSummaryCard.strAutoRemark;
                    if (str2 != null && str2.length() > 0 && !respSummaryCard.strAutoRemark.equals(l3.inteRemark)) {
                        String str3 = respSummaryCard.strAutoRemark;
                        l3.inteRemark = str3;
                        if (str3.equals(respSummaryCard.strNick)) {
                            l3.inteRemarkSource = 129L;
                        } else {
                            l3.inteRemarkSource = 128L;
                        }
                    }
                    nVar.E(l3);
                    return;
                }
                return;
            }
            TroopInfo findTroopInfo = iTroopInfoService.findTroopInfo(String.valueOf(j3));
            if (findTroopInfo != null) {
                String str4 = findTroopInfo.troopname;
                if (str4 != null) {
                    if (!str4.equals(respSummaryCard.strGroupName)) {
                        findTroopInfo.troopname = respSummaryCard.strGroupName;
                    }
                } else {
                    String str5 = respSummaryCard.strGroupName;
                    if (str5 != null) {
                        findTroopInfo.troopname = str5;
                    }
                }
            }
        }
    }

    private void updateVipInfo(RespSummaryCard respSummaryCard, Card card, String str, c<Boolean> cVar) {
        Map<Integer, VipOpenInfo> map;
        String str2;
        List<PrivilegeInfo> privilegeOpenInfo;
        if (respSummaryCard.stVipInfo != null && card != null) {
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(str, TAG);
            if (vasSimpleInfoWithUid == null) {
                vasSimpleInfoWithUid = new NTVasSimpleInfo(str, card.uin);
            }
            NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(str, card.uin);
            nTVasSimpleInfo.c();
            nTVasSimpleInfo.qqVipInfo = com.tencent.mobileqq.app.friendlist.a.m(respSummaryCard.stVipInfo, EVIPSPEC.E_SP_QQVIP.value(), vasSimpleInfoWithUid.qqVipInfo);
            nTVasSimpleInfo.superQqInfo = com.tencent.mobileqq.app.friendlist.a.m(respSummaryCard.stVipInfo, EVIPSPEC.E_SP_SUPERQQ.value(), vasSimpleInfoWithUid.superQqInfo);
            nTVasSimpleInfo.superVipInfo = com.tencent.mobileqq.app.friendlist.a.m(respSummaryCard.stVipInfo, EVIPSPEC.E_SP_SUPERVIP.value(), vasSimpleInfoWithUid.superVipInfo);
            nTVasSimpleInfo.bigClubInfo = com.tencent.mobileqq.app.friendlist.a.m(respSummaryCard.stVipInfo, EVIPSPEC.E_SP_BIGCLUB.value(), vasSimpleInfoWithUid.bigClubInfo);
            if (vasSimpleInfoWithUid.bigClubInfo == 0 && (privilegeOpenInfo = card.getPrivilegeOpenInfo()) != null) {
                for (PrivilegeInfo privilegeInfo : privilegeOpenInfo) {
                    if (privilegeInfo.iType == 113) {
                        int i3 = privilegeInfo.iIsBig;
                        int i16 = privilegeInfo.iLevel;
                        if (i3 > 0 && i16 > 0) {
                            nTVasSimpleInfo.bigClubInfo = ((short) i16) | (((i3 << 8) | 1) << 16);
                        }
                    }
                }
            }
            VipBaseInfo vipBaseInfo = respSummaryCard.stVipInfo;
            if (vipBaseInfo != null && (map = vipBaseInfo.mOpenInfo) != null) {
                VipOpenInfo vipOpenInfo = map.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
                if (vipOpenInfo != null) {
                    long j3 = vipOpenInfo.lNameplateId;
                    nTVasSimpleInfo.superVipTemplateId = (int) j3;
                    nTVasSimpleInfo.bigClubTemplateId = (int) j3;
                }
                VipOpenInfo vipOpenInfo2 = respSummaryCard.stVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
                if (vipOpenInfo2 != null) {
                    long j16 = vipOpenInfo2.lNameplateId;
                    nTVasSimpleInfo.superVipTemplateId = (int) j16;
                    nTVasSimpleInfo.bigClubTemplateId = (int) j16;
                }
                nTVasSimpleInfo.nameplateVipType = card.nameplateVipType;
                nTVasSimpleInfo.grayNameplateFlag = card.grayNameplateFlag;
                nTVasSimpleInfo.vipStartFlag = card.vipStarFlag;
                if (TextUtils.isEmpty(card.vipIcons)) {
                    str2 = "";
                } else {
                    str2 = card.vipIcons;
                }
                nTVasSimpleInfo.vipIcons = str2;
                nTVasSimpleInfo.vipDataFlag = card.vipDataFlag;
                com.tencent.mobileqq.vip.api.b.a().updateFlagData(nTVasSimpleInfo.getUin(), nTVasSimpleInfo.vipDataFlag);
            }
            ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, TAG, new c<NTVasSimpleInfo>(cVar) { // from class: com.tencent.mobileqq.profilecard.processor.TempProfileBusinessProcessor.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ c val$updateGeneralDataCallback;

                {
                    this.val$updateGeneralDataCallback = cVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TempProfileBusinessProcessor.this, (Object) cVar);
                    }
                }

                @Override // hx3.c
                public void onUpdateResult(@Nullable e<NTVasSimpleInfo> eVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                        return;
                    }
                    e eVar2 = new e();
                    eVar2.d(eVar.a());
                    this.val$updateGeneralDataCallback.onUpdateResult(eVar2);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onProcessProfile0x5eb(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bundle, card, respHead, respSummaryCard, oidb_0x5eb_udcuindata);
            return;
        }
        try {
            String valueOf = String.valueOf(bundle.getLong(IProfileProtocolConst.PARAM_TARGET_UIN));
            handleGetSummaryCardForUdcInner(valueOf, card, oidb_0x5eb_udcuindata);
            handleGetSummaryCardForUdcInner2(valueOf, card, oidb_0x5eb_udcuindata);
            AppRuntime appRuntime = this.appRuntime;
            if (appRuntime instanceof QQAppInterface) {
                handleGetSummaryCardForBaseInfoPrivacy((QQAppInterface) appRuntime, card, oidb_0x5eb_udcuindata);
                handleGetSummaryCardForBusinessSwitch((QQAppInterface) this.appRuntime, card, oidb_0x5eb_udcuindata);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, e16.toString());
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onProcessProfileCard(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bundle, card, respHead, respSummaryCard);
            return;
        }
        long j3 = bundle.getLong(IProfileProtocolConst.PARAM_TARGET_UIN);
        int i3 = bundle.getInt(IProfileProtocolConst.PARAM_COME_FROM_TYPE);
        long j16 = bundle.getLong(IProfileProtocolConst.PARAM_GET_CONTROL);
        long j17 = bundle.getLong(IProfileProtocolConst.PARAM_TROOP_CODE);
        String valueOf = String.valueOf(j3);
        handleGetSummaryCardForNearby(respSummaryCard, valueOf);
        handleGetSummaryCardForQZone(respSummaryCard, card);
        handleGetSummaryCardForTemplate(respSummaryCard, valueOf, card, j16);
        handleGetSummaryCardForPersonalityLabel(respSummaryCard, card);
        handleGetSummaryCardForMedalWall(respSummaryCard, card);
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(valueOf), valueOf);
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.pendantId = respSummaryCard.ulFaceAddonId;
        nTVasSimpleInfo.timestamp = System.currentTimeMillis();
        updateRichSign(respSummaryCard, j16, valueOf);
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, TAG, (c<NTVasSimpleInfo>) null);
        updateTroopInfo(j17, i3, respSummaryCard, valueOf);
        handleGetSummaryCardForMoreInfo(respSummaryCard, card);
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onProcessProfileService(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard, SparseArray<BusinessRespBuffer> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, bundle, card, respHead, respSummaryCard, sparseArray);
            return;
        }
        long j3 = bundle.getLong("selfUin");
        long j16 = bundle.getLong(IProfileProtocolConst.PARAM_TARGET_UIN);
        long j17 = bundle.getLong(IProfileProtocolConst.PARAM_GET_CONTROL);
        String valueOf = String.valueOf(j16);
        handleGetSummaryCardForVote(respHead, respSummaryCard, sparseArray, valueOf, card);
        handleGetSummaryCardForPrivilege(respSummaryCard, sparseArray, card);
        handleMiniAppPlayingInfo(card, sparseArray, j16, j3);
        handleZPlanResourceInfo(card, sparseArray, j16, j3);
        handleSimilarityInfo(card, sparseArray);
        handleMutualMarkInfo(card, sparseArray);
        handleQCircleResourceInfo(card, sparseArray, j16, j3);
        updateFriendInfo(respSummaryCard, valueOf, card, j17);
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onRequestProfileCard(Bundle bundle, ArrayList<BusinessReqBuffer> arrayList, ArrayList<Integer> arrayList2) {
        byte[] getFriendPlayListV2RequestBusiBuf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bundle, arrayList, arrayList2);
            return;
        }
        long j3 = bundle.getLong("selfUin", 0L);
        long j16 = bundle.getLong(IProfileProtocolConst.PARAM_TARGET_UIN, 0L);
        SSummaryCardQueryReq sSummaryCardQueryReq = new SSummaryCardQueryReq(1, j3, j16, AppSetting.f99551k, bundle.getInt(IProfileProtocolConst.PARAM_COME_FROM_TYPE, 0), 109L);
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setEncodeName("utf-8");
        uniPacket.setFuncName("query");
        uniPacket.setServantName("MCardSvc");
        uniPacket.put("req", sSummaryCardQueryReq);
        bundle.putByteArray(IProfileProtocolConst.PARAM_REQ_TEMPLATE, uniPacket.encode());
        arrayList.add(new BusinessReqBuffer(16, buildVaProfileGateReq(j16).toByteArray()));
        if (j3 == j16) {
            getFriendPlayListV2RequestBusiBuf = ((IMiniAppService) QRoute.api(IMiniAppService.class)).getGetUserAppListRequestBusiBuf(j3, 15L);
        } else {
            getFriendPlayListV2RequestBusiBuf = ((IMiniAppService) QRoute.api(IMiniAppService.class)).getGetFriendPlayListV2RequestBusiBuf(String.valueOf(j16), 15);
        }
        arrayList.add(new BusinessReqBuffer(17, getFriendPlayListV2RequestBusiBuf));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new com.tencent.mobileqq.zplan.model.c(25, 3));
        arrayList3.add(new com.tencent.mobileqq.zplan.model.c(3, 1));
        arrayList3.add(new com.tencent.mobileqq.zplan.model.c(4, 1));
        arrayList3.add(new com.tencent.mobileqq.zplan.model.c(9, 1));
        arrayList3.add(new com.tencent.mobileqq.zplan.model.c(5, 1));
        arrayList3.add(new com.tencent.mobileqq.zplan.model.c(20, 3));
        arrayList.add(new BusinessReqBuffer(20, ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).getZPlanResourceUrlRequestBusiBuf(arrayList3)));
        arrayList2.add(45165);
        arrayList2.add(47170);
        FeedCloudDatacard$GetDataCardCoverReq feedCloudDatacard$GetDataCardCoverReq = new FeedCloudDatacard$GetDataCardCoverReq();
        feedCloudDatacard$GetDataCardCoverReq.user_id.set(String.valueOf(j16));
        feedCloudDatacard$GetDataCardCoverReq.qua.set(QUA.getQUA3());
        feedCloudDatacard$GetDataCardCoverReq.device_info.set(((IQZoneDeviceInfoUtil) QRoute.api(IQZoneDeviceInfoUtil.class)).getDeviceInfo());
        arrayList.add(new BusinessReqBuffer(21, feedCloudDatacard$GetDataCardCoverReq.toByteArray()));
        FriendsManager friendsManager = (FriendsManager) this.appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j16)), TAG);
        if (j3 != j16 && !isFriend && ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isInStepComponentEnable()) {
            SummaryCardSimilarity$GetSummaryCardSimilarityReq summaryCardSimilarity$GetSummaryCardSimilarityReq = new SummaryCardSimilarity$GetSummaryCardSimilarityReq();
            summaryCardSimilarity$GetSummaryCardSimilarityReq.uin.set(j16);
            arrayList.add(new BusinessReqBuffer(22, summaryCardSimilarity$GetSummaryCardSimilarityReq.toByteArray()));
        }
        if (!friendsManager.E(true) && j3 != j16 && isFriend) {
            MutualMarkCard$ReqBody mutualMarkCard$ReqBody = new MutualMarkCard$ReqBody();
            mutualMarkCard$ReqBody.friend_uin.set(j16);
            arrayList.add(new BusinessReqBuffer(24, mutualMarkCard$ReqBody.toByteArray()));
        }
        if (j3 == j16) {
            arrayList2.add(42104);
            arrayList2.add(41611);
            arrayList2.add(41610);
            arrayList2.add(41607);
            arrayList2.add(Integer.valueOf(IProfileSettingApi.FIELD_PRIVACY_CONSTELLATION));
            arrayList2.add(41618);
            arrayList2.add(41619);
            arrayList2.add(41614);
            arrayList2.add(41613);
            arrayList2.add(41622);
            arrayList2.add(41623);
            arrayList2.add(40272);
        }
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_KING_GAME_ID));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_KING_GMAE_LAST_LOGIN_TIME));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_KING_GAME_DAN));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_KING_GAME_DAN_DISPLAY_SWITCH));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_EXTEND_FRIEND_FLAG));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_EXTEND_FRIEND_SWITCH));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_STRANGER_VOTE_SWITCH));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_NEW_EDU_STATUS_FLAG));
        arrayList2.add(Integer.valueOf(ProfileContants.FILED_IS_PRETTY_GROUP_OWNER));
        arrayList2.add(Integer.valueOf(ProfileContants.FILED_HIDE_PRETTY_GROUP_OWNER_IDENTITY));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_STICKY_NOTE_SWITCH));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_STICKY_NOTE_OFFLINE));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_SCHOOL_VERIFIED));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_QQCIRCLE_SWITCH));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_LIFE_ACHIEVEMENT_SWITCH));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_WEISHI_SWITCH));
        arrayList2.add(42425);
        arrayList2.add(42488);
        arrayList2.add(45160);
        arrayList2.add(45161);
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_ZPLAN_COVER_IMG));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_ZPLAN_MASTER_SHOW_SWITCH));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_ZPLAN_PROFILE_CARD_SHOW_SWITCH));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_IS_ZPLAN_AVATAR));
        arrayList2.add(Integer.valueOf(IOnlineStatusAvatarSwitchService.SWITCH_ID));
        arrayList2.add(27236);
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_DRESSUP_SWITCH));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_QQCARD_SWITCH));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_MUSIC_DATA_SWITCH));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_META_FARM_SWITCH));
        arrayList2.add(Integer.valueOf(ProfileContants.FIELD_HAOMA_NAMEPLATE));
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onResponseProfileCard(boolean z16, Bundle bundle, RespHead respHead, RespSummaryCard respSummaryCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), bundle, respHead, respSummaryCard);
        } else {
            super.onResponseProfileCard(z16, bundle, respHead, respSummaryCard);
        }
    }

    public boolean setCardHotValue(Card card, SparseArray<BusinessRespBuffer> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) card, (Object) sparseArray)).booleanValue();
        }
        return false;
    }

    public void updateCardTemplate(Card card, String str, SSummaryCardRsp sSummaryCardRsp) {
        Map<Long, SLabelInfo> map;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, card, str, sSummaryCardRsp);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (sSummaryCardRsp != null) {
            String str3 = "";
            if (sSummaryCardRsp.res < 0) {
                QLog.e("DIYProfileTemplate.protocol/SummaryCard", 1, "getSummaryCard template error! res =" + sSummaryCardRsp.res);
                VasMonitorDT.reportErrCode("individual_v2_personalcard_get_fail", "" + sSummaryCardRsp.res);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w("DIYProfileTemplate.protocol/SummaryCard", 1, "updateCardTemplate res=" + sSummaryCardRsp.res + " styleid=" + sSummaryCardRsp.styleid + " bgid=" + sSummaryCardRsp.bgid + " strDrawerCardUrl=" + sSummaryCardRsp.strDrawerCard);
                cardDiyComplicatedInfo carddiycomplicatedinfo = sSummaryCardRsp.stDiyComplicated;
                if (carddiycomplicatedinfo != null && (str2 = carddiycomplicatedinfo.detail) != null && str2.length() > 850) {
                    QLog.w("DIYProfileTemplate.protocol/SummaryCard", 1, "stDiyComplicated(1)=" + sSummaryCardRsp.stDiyComplicated.detail.substring(0, 840));
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("stDiyComplicated(2)=");
                    String str4 = sSummaryCardRsp.stDiyComplicated.detail;
                    sb5.append(str4.substring(830, str4.length() - 1));
                    QLog.w("DIYProfileTemplate.protocol/SummaryCard", 1, sb5.toString());
                } else {
                    QLog.w("DIYProfileTemplate.protocol/SummaryCard", 1, "stDiyComplicated=" + sSummaryCardRsp.stDiyComplicated);
                }
            }
            card.templateRet = sSummaryCardRsp.res;
            card.lCurrentStyleId = sSummaryCardRsp.styleid;
            card.backgroundUrl = sSummaryCardRsp.bgurl;
            card.lCurrentBgId = sSummaryCardRsp.bgid;
            card.backgroundColor = sSummaryCardRsp.color;
            card.dynamicCardFlag = sSummaryCardRsp.dynamicCardFlag;
            card.strZipUrl = sSummaryCardRsp.strZipUrl;
            card.strActiveUrl = sSummaryCardRsp.strActiveCardUrl;
            card.strDrawerCardUrl = sSummaryCardRsp.strDrawerCard;
            card.strWzryHeroUrl = sSummaryCardRsp.strWzryHeroUrl;
            card.strExtInfo = sSummaryCardRsp.extInfo;
            card.cardType = sSummaryCardRsp.cardType;
            card.diyDefaultText = sSummaryCardRsp.strDiyDefaultText;
            card.defaultCardId = sSummaryCardRsp.profileid;
            cardDiyComplicatedInfo carddiycomplicatedinfo2 = sSummaryCardRsp.stDiyComplicated;
            if (carddiycomplicatedinfo2 != null) {
                str3 = carddiycomplicatedinfo2.detail;
            }
            card.diyComplicatedInfo = str3;
            card.cardId = sSummaryCardRsp.cardid;
            card.likeAreaId = sSummaryCardRsp.likeAreaID;
            ArrayList<Integer> arrayList = sSummaryCardRsp.bgtype;
            if (arrayList != null) {
                card.setBgType(arrayList);
            }
            SUserLabel sUserLabel = sSummaryCardRsp.label;
            if (sUserLabel != null && (map = sUserLabel.label) != null) {
                card.setLabelList(map);
            }
            card.setWzryHonorInfo(sSummaryCardRsp.wzryInfo);
            cardDiyTextInfo carddiytextinfo = sSummaryCardRsp.stDiyText;
            if (carddiytextinfo != null) {
                card.diyTextFontId = carddiytextinfo.iFontId;
                card.diyText = carddiytextinfo.strText;
                card.diyTextScale = carddiytextinfo.fScaling;
                card.diyTextDegree = carddiytextinfo.fRotationAngle;
                card.diyTextTransparency = carddiytextinfo.fTransparency;
                if (!TextUtils.isEmpty(carddiytextinfo.strPoint)) {
                    String[] split = sSummaryCardRsp.stDiyText.strPoint.split("_");
                    if (split.length >= 4) {
                        try {
                            card.diyTextLocX = Float.parseFloat(split[0]);
                            card.diyTextLocY = Float.parseFloat(split[1]);
                            card.diyTextWidth = Float.parseFloat(split[2]);
                            card.diyTextHeight = Float.parseFloat(split[3]);
                        } catch (Exception e16) {
                            QLog.e("Card", 1, "set card with diy text response:", e16);
                        }
                    }
                }
            }
            hashMap.put("param_FailCode", "0");
            hashMap.put("param_templateRet", String.valueOf(sSummaryCardRsp.res));
            if (QLog.isColorLevel()) {
                QLog.i("protocol/SummaryCard", 2, "updateCardTemplate templateInfo-->" + card.getProfileCardDesc());
            }
            StatisticCollector.getInstance(this.appRuntime.getApplication()).collectPerformance(str, "profileCardGet", true, 0L, 0L, hashMap, "", false);
            return;
        }
        QLog.i("protocol/SummaryCard", 1, "updateCardTemplate templateInfo is null");
        VasMonitorDT.reportErrCode("individual_v2_personalcard_get_fail", "personalcard_get_template_null");
        hashMap.put("param_FailCode", "-101");
        hashMap.put("param_templateRet", "0");
        StatisticCollector.getInstance(this.appRuntime.getApplication()).collectPerformance(str, "profileCardGet", false, 0L, 0L, hashMap, "", false);
    }

    private void updateRichSign(RespSummaryCard respSummaryCard, String str, long j3, d dVar, c<Boolean> cVar) {
        if ((j3 & 4) != 0) {
            long t16 = dVar.t();
            long j16 = respSummaryCard.uSignModifyTime;
            if (t16 != j16) {
                com.tencent.mobileqq.richstatus.c.l(dVar, respSummaryCard.vRichSign, j16, new c<Boolean>(str, dVar, cVar) { // from class: com.tencent.mobileqq.profilecard.processor.TempProfileBusinessProcessor.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ d val$ntSimpleInfo;
                    final /* synthetic */ String val$uin;
                    final /* synthetic */ c val$updateGeneralDataCallback;

                    {
                        this.val$uin = str;
                        this.val$ntSimpleInfo = dVar;
                        this.val$updateGeneralDataCallback = cVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, TempProfileBusinessProcessor.this, str, dVar, cVar);
                        }
                    }

                    @Override // hx3.c
                    public void onUpdateResult(@Nullable e<Boolean> eVar) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                            return;
                        }
                        ((FriendListHandler) ((AppInterface) TempProfileBusinessProcessor.this.appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getRichStatus(new String[]{this.val$uin});
                        if (QLog.isColorLevel()) {
                            QLog.d(TempProfileBusinessProcessor.TAG, 2, "insertSignMsgIfNeeded from cardHandler uin = " + this.val$uin + " result = " + this.val$ntSimpleInfo.y());
                        }
                        c cVar2 = this.val$updateGeneralDataCallback;
                        if (cVar2 != null) {
                            cVar2.onUpdateResult(eVar);
                        }
                    }
                });
            }
        }
    }
}
