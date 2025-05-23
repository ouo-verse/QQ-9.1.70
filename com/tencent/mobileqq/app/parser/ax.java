package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.icgame.cooperation.ilive.util.ILiveEntranceUtilApi;
import com.tencent.mobileqq.app.parse.JumpParseConstants;
import com.tencent.mobileqq.app.parser.api.IJumpParserApi;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.guild.IGuildExtApi;
import com.tencent.mobileqq.guild.api.IGuildJumpParserFactory;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotJumpParserFactory;
import com.tencent.mobileqq.guild.temp.gamecenter.qa.api.IGameQAApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.mobileqq.qwallet.jump.IQWalletJumpParserFactory;
import com.tencent.mobileqq.scheme.ILoginSchemeApi;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.api.IAssociatedAccountApi;
import com.tencent.mobileqq.troop.aivoicechat.api.ITroopAIVoiceChatApi;
import com.tencent.mobileqq.troop.flame.api.ITroopFlameApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.qrcode.api.ITroopQRCodeShareApi;
import com.tencent.mobileqq.troop.schooltoolbox.api.ISchoolToolApi;
import com.tencent.mobileqq.troop.teamup.api.ITroopTeamUpApi;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage;
import com.tencent.mobileqq.troop.troopfullmember.api.ITroopFullMemberChangeApi;
import com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi;
import com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi;
import com.tencent.mobileqq.troop.troopnotification.ITroopNotificationApi;
import com.tencent.mobileqq.troop.troopsquare.api.ITroopSquareApi;
import com.tencent.mobileqq.tux.api.IQTuxApi;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.vas.api.IVasMqqScheme;
import com.tencent.mobileqq.vas.pay.api.IVasPayRenewalPage;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.webview.api.IJumpApi;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory;
import com.tencent.open.api.IOpenSdkCommonChannelJumpActionMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxService;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import com.tencent.robot.scheme.api.IRobotSchemeApi;
import com.tencent.timi.game.jump.api.ITimiGameParserFactory;
import com.tencent.troopguild.api.ITroopGuildJumpParserFactory;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ax {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile ax f196455b;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<JumpParserBean> f196456a;

    ax() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f196456a = null;
        this.f196456a = new ArrayList<>();
        g("mqqapi://qqidentifier/web", aq.class);
        g("mqqapi://groupopenapp/openapp", ej.class);
        g("mqqapi://groupfile", ed.class);
        g("mqqapi://commonBuddyGroup/commonBuddyGroup", eh.class);
        g("mqqapi://trooptogether/open", el.class);
        g("mqqapi://manage_troop/main_page", ef.class);
        g("mqqapi://nearby/openpage", bg.class);
        g("mqqapi://now/playmedia", dv.class);
        g("mqqapi://wsgzh/waterfall", et.class);
        g("mqqapi://wsgzh/miniapp_player", ex.class);
        g("mqqapi://wsgzh/wesee", ev.class);
        g("mqqzone", di.class);
        g("mqzone", di.class);
        g("mqqapi://qzoneschema", di.class);
        g("mqqapi://qzone/publicaccount", dk.class);
        g("qqfav://operation/", cb.class);
        g("mqqapi://assistant_setting/ASSISTANT_SETTING", j.class);
        g("mqqapi://gamemsgbox/open", ac.class);
        g("mqqapi://eldermode/elderopen", q.class);
        g("mqqapi://expand/openpage", t.class);
        g("mqqapi://stranger/user_profile", bc.class);
        g("mqqapi://stranger/aio", bc.class);
        g("mqqapi://stranger/match_home", bc.class);
        g("mqqapi://stranger/jubao", bc.class);
        g("mqqapi://stranger/jump_home_page", bc.class);
        g("mqqapi://stranger/jump_liteactionlist_page", bc.class);
        g("mqqapi://stranger/message_notify_setting", bc.class);
        g("mqqapi://stranger/publish_feed", bc.class);
        g("mqqapi://stranger/signal_square", bc.class);
        g("mqqapi://qqstranger/immediate_match", bc.class);
        g("mqqapi://qqstranger/feed_detail", bc.class);
        g("mqqapi://qqstranger/feed_info", bc.class);
        g("mqqapi://qqstranger/msg_tab", bc.class);
        g("mqqapi://qqstranger/notification", bc.class);
        g("mqqapi://mutualmark/wear", com.tencent.mobileqq.mutualmark.mqqapi.b.class);
        g("mqqapi://mutualmark/unwear", com.tencent.mobileqq.mutualmark.mqqapi.b.class);
        g("mqqapi://mutualmark/poke", com.tencent.mobileqq.mutualmark.mqqapi.b.class);
        g("mqqapi://relation/deleteFriends", com.tencent.mobileqq.app.parser.nt.mqqapi.a.class);
        g("mqqapi://relation/addFriend", com.tencent.mobileqq.app.parser.nt.mqqapi.a.class);
        g("mqqapi://relation/welcome", com.tencent.mobileqq.app.parser.nt.mqqapi.a.class);
        g("mqqapi://relation/troopNick", com.tencent.mobileqq.app.parser.nt.mqqapi.a.class);
        g("mqqapi://relation/modifyGroupName", com.tencent.mobileqq.app.parser.nt.mqqapi.a.class);
        g("mqqapi://relation/tempManager", com.tencent.mobileqq.app.parser.nt.mqqapi.a.class);
        g("mqqapi://relation/friendSetting", com.tencent.mobileqq.app.parser.nt.mqqapi.a.class);
        g("mqqapi://relation/intimateInfo", com.tencent.mobileqq.app.parser.nt.mqqapi.a.class);
        g("mqqapi://relation/visitorLike", com.tencent.mobileqq.app.parser.nt.mqqapi.a.class);
        g("mqqapi://relation/partner_signin", com.tencent.mobileqq.app.parser.nt.mqqapi.a.class);
        g("mqqapi://group/graytip_addfriend", com.tencent.mobileqq.troopAddFrd.f.class);
        g("mqqapi://group/graytip_friendcheck", com.tencent.mobileqq.troopAddFrd.f.class);
        g("mqqapi://group/troop_flame_details", ((ITroopFlameApi) QRoute.api(ITroopFlameApi.class)).getParserClass());
        g("mqqapi://group/troop_notification", ((ITroopNotificationApi) QRoute.api(ITroopNotificationApi.class)).getTroopNotificationParserClass());
        g("mqqapi://group/troop_ai_voice_chat", ((ITroopAIVoiceChatApi) QRoute.api(ITroopAIVoiceChatApi.class)).getJumpParser());
        g("mqqapi://group/share_troop_qr_qzone", ((ITroopQRCodeShareApi) QRoute.api(ITroopQRCodeShareApi.class)).getJumpParser());
        g("mqqapi://group/troop_identity_wear", ((ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class)).getJumpParser());
        g("mqqapi://group/join_troop", ((ITroopJoinApi) QRoute.api(ITroopJoinApi.class)).getJoinTroopJumpParser());
        g("mqqapi://group/school_toolbox", ((ISchoolToolApi) QRoute.api(ISchoolToolApi.class)).getParserClass());
        g("mqqapi://group/troop_information_setting", ((ITroopInfoActivityApi) QRoute.api(ITroopInfoActivityApi.class)).getParserClass());
        g("mqqapi://group/troop_teacher_msg", ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).getTeacherHistoryMsgParser());
        g("mqqapi://group/square_topic", ((ITroopSquareApi) QRoute.api(ITroopSquareApi.class)).getParserClass());
        g("mqqapi://group/group_teamup", ((ITroopTeamUpApi) QRoute.api(ITroopTeamUpApi.class)).getParserClass());
        g("mqqapi://group/full_member_change", ((ITroopFullMemberChangeApi) QRoute.api(ITroopFullMemberChangeApi.class)).getParserClass());
        g("mqqapi://stranger/open_age_selector", bc.class);
        g("mqqapi://map/openmap", bb.class);
        g("mqqapi://mayknown/homepage", be.class);
        g("mqqapi://guildhelper/openguildassist", ((IGuildExtApi) QRoute.api(IGuildExtApi.class)).getParserClass());
        g("mqqapi://qzone/to_publish_queue", dm.class);
        g("mqqapi://qzone/to_friend_feeds", df.class);
        g("mqqapi://qzone/activefeed", df.class);
        g("mqqapi://qzone/open_homepage", dh.class);
        g("mqqapi://ftssearch/tab", x.class);
        g("mqqapi://ftssearch/openmixweb", v.class);
        g("mqqapi://qzone/to_qzone_dialog", dd.class);
        g("mqqapi://qzone/to_redpocket_share", Cdo.class);
        g("qapp://", cs.class);
        g("mqqapi://qqreg", cl.class);
        g("mqqapi://microapp/open?", ak.class);
        g("mqqapi://miniapp/open?", am.class);
        g("mqqapi://miniapp/adopen", am.class);
        g("mqqapi://miniapp/virtualmanage?", am.class);
        g("mqqapi://miniapp/bindwx?", ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getWxBindJumpClass());
        g("mqqapi://minibox/", ((IMiniBoxService) QRoute.api(IMiniBoxService.class)).getJumpParserClass());
        try {
            IZPlanClassObjectFactory iZPlanClassObjectFactory = (IZPlanClassObjectFactory) QRoute.api(IZPlanClassObjectFactory.class);
            g(ISchemeApi.SCHEME_ENTER_AVATAR, iZPlanClassObjectFactory.getZPlanEnterAvatarSceneParser());
            g(ISchemeApi.SCHEME_OPEN_PAGE, iZPlanClassObjectFactory.getZPlanOpenPageParser());
            g("mqqapi://zplan/enterSocialSquare", iZPlanClassObjectFactory.getZPlanStatusSquareParser());
            g("mqqapi://zplan/squarePersonalCenter", iZPlanClassObjectFactory.getZPlanStatusSquareParser());
            g("mqqapi://zplan/enterThemeSpace", iZPlanClassObjectFactory.getZPlanStatusSquareParser());
            g("mqqapi://zplan/squareArkInvite", iZPlanClassObjectFactory.getZPlanStatusSquareParser());
            g("mqqapi://zplan/enterLibrary", iZPlanClassObjectFactory.getZPlanStatusSquareParser());
            g("mqqapi://zplan/toast", iZPlanClassObjectFactory.getZPlanOpenPageParser());
            g("mqqapi://zplan/thirdAuth", iZPlanClassObjectFactory.getZPlanOpenPageParser());
            g("mqqapi://zplan/thirdJump", iZPlanClassObjectFactory.getZPlanOpenPageParser());
            g("mqqapi://zplan/faceAd", iZPlanClassObjectFactory.getZPlanOpenPageParser());
        } catch (Exception e16) {
            QLog.e("JumpParserUtil", 1, "registerParser ZPlan error." + e16);
        }
        try {
            IQWalletJumpParserFactory iQWalletJumpParserFactory = (IQWalletJumpParserFactory) QRoute.api(IQWalletJumpParserFactory.class);
            if (iQWalletJumpParserFactory != null) {
                g("mqqapi://wxminiapp/launch", iQWalletJumpParserFactory.getJumpParserClass("mqqapi://wxminiapp/launch"));
            }
            IGuildRobotJumpParserFactory iGuildRobotJumpParserFactory = (IGuildRobotJumpParserFactory) QRoute.api(IGuildRobotJumpParserFactory.class);
            if (iGuildRobotJumpParserFactory != null) {
                g("mqqapi://robot", iGuildRobotJumpParserFactory.getGuildRobotJumpParseClass());
            }
        } catch (Exception e17) {
            QLog.e("JumpParserUtil", 1, e17, new Object[0]);
        }
        g("mqqapi://qqnotify/subscribe", ch.class);
        g("mqqapi://qqnotify/open", da.class);
        g("mqqapi://qqnotify/jump", cf.class);
        g("mqqapi://wallet/open", cy.class);
        g("mqqmdpass://wallet/modify_pass", cw.class);
        g("mqqapi://gamecenter/install", er.class);
        g("mqqapi://gamecenter/searchgame", ab.class);
        g("mqqapi://gamecenter/kuikly_float", ab.class);
        g("mqqapi://vaslive", at.class);
        g("mqqapi://asyncmsg/showdetail?", l.class);
        g("mqqapi://icgame", ((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).getICGameJumpParserClass());
        g("mqqapi://webcustomheight", p.class);
        g("mqqapi://schedule/showDetail?", ds.class);
        g("mqqapi://huayang", ao.class);
        g("mqqapi://od", bm.class);
        g("mqqapi://0odAddFriend", bk.class);
        g("mqqapi://teamwork/opendoclist", dz.class);
        g("mqqapi://qstory/opencontent", co.class);
        g("qqstory://qstory/opencontent", co.class);
        g("mqqapi://contact/add", n.class);
        g("mqqapi://profile/setting", bs.class);
        g("mqqapi://userprofile/side_account", ((IAssociatedAccountApi) QRoute.api(IAssociatedAccountApi.class)).getSubAccountParserClass());
        g("mqqapi://about", com.tencent.mobileqq.activity.about.p.class);
        g("mqqapi://groupvideo", ae.class);
        g("mqqapi://qwerewolf/enterHomePage", bw.class);
        g("mqqapi://lightapp/open", az.class);
        g("mqqapi://qsubscribe", dx.class);
        g("mqqapi://qcircle", bz.class);
        g("mqqapi://troop_homework/publish", ai.class);
        g("https://qm.qq.com/cgi-bin/qm/qr", cu.class);
        g("mqqapi://avgame/join_room", f.class);
        g("mqqapi://avgame/create_room", b.class);
        g("mqqapi://avgame/lobby", d.class);
        g("mqqapi://avgame/pk_qqcj", h.class);
        g("mqqapi://avsharescreen/request", dt.class);
        g("mqqapi://setting", cn.class);
        g("mqqapi://opensdk", bu.class);
        g("mqqapi://TempSessionMessageBox", com.tencent.mobileqq.activity.recent.msgbox.search.b.class);
        g("mqqguild://guild", ((IGuildJumpParserFactory) QRoute.api(IGuildJumpParserFactory.class)).getGuildJumpParserClass());
        g("mqqapi://guild", ((IGuildJumpParserFactory) QRoute.api(IGuildJumpParserFactory.class)).getGuildJumpParserClass());
        g("mqqapi://gamecenterqa", ((IGameQAApi) QRoute.api(IGameQAApi.class)).getGuildJumpParserClass());
        g("mqqapi://adelie", ((IRobotSchemeApi) QRoute.api(IRobotSchemeApi.class)).createAdelieJumpParserClass());
        g("mqqapi://createTroop", ((ITroopCreatePage) QRoute.api(ITroopCreatePage.class)).getTroopCreateJumpParser());
        g("mqqapi://qrscan", ((IQRJumpApi) QRoute.api(IQRJumpApi.class)).getScannerJumpParser());
        g("mqqapi://gameqa", com.tencent.mobileqq.gamecenter.qa.jumpaction.a.class);
        g("mqqapi://hippyui", ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).getHippyUIParserClass());
        g("mqqforward://forward", z.class);
        g("mqqapi://qqfile", bq.class);
        g("tenpaysdk://redgiftDetail", dq.class);
        g("mqqapi://troopguild", ((ITroopGuildJumpParserFactory) QRoute.api(ITroopGuildJumpParserFactory.class)).getTroopGuildJumpParserClass());
        g("mqqapi://login", ((ILoginSchemeApi) QRoute.api(ILoginSchemeApi.class)).getParserClass());
        try {
            g("mqqapi://esports/open", ((ITimiGameParserFactory) QRoute.api(ITimiGameParserFactory.class)).getJumpParserClass());
            g("mqqapi://esports/team/create", ((ITimiGameParserFactory) QRoute.api(ITimiGameParserFactory.class)).getTeamCreateParserClass());
            g("mqqapi://esports/team/join", ((ITimiGameParserFactory) QRoute.api(ITimiGameParserFactory.class)).getTeamJoinParserClass());
            g("mqqapi://qqlive/startlive", ((ITimiGameParserFactory) QRoute.api(ITimiGameParserFactory.class)).getQQLiveStartLiveParserClass());
            g("mqqapi://qqlive/main", ((ITimiGameParserFactory) QRoute.api(ITimiGameParserFactory.class)).getQQLiveOpenMainParserClass());
            g("mqqapi://gamecenterqa", ((IQQGameQAUIApi) QRoute.api(IQQGameQAUIApi.class)).getJumpParserClass());
        } catch (Exception e18) {
            QLog.e("JumpParserUtil", 1, e18, new Object[0]);
        }
        g("mqqapi://channel/emotionReply", s.class);
        g("mqqapi://open_connect/common_channel", ((IOpenSdkCommonChannelJumpActionMgr) QRoute.api(IOpenSdkCommonChannelJumpActionMgr.class)).getParserClass());
        g("mqqapi://qqweather", ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).getParserClass());
        g("mqqapi://qqsport", ((IQQHealthApi) QRoute.api(IQQHealthApi.class)).getParserClass());
        g(IJumpApi.SCHEME_TXC_POSTSUBMIT, ((IJumpApi) QRoute.api(IJumpApi.class)).getTxcJumpParserClazz());
        g("mqqapi://openhalfscreenweb/", ag.class);
        g("mqqapi://trooprobot/", ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).getRobotProfileCardJumpClass());
        g("mqqapi://onlinestatus", cj.class);
        g("mqqapi://vasrenewal/open", ((IVasPayRenewalPage) QRoute.api(IVasPayRenewalPage.class)).getRenewalParserClass());
        g("mqqapi://kuikly", cd.class);
        g("mqqapi://metadream", ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getJumpParserClass());
        g("mqqapi://vasnewcustomer/open", ((IVasPayRenewalPage) QRoute.api(IVasPayRenewalPage.class)).getNewCustomerPageParserClass());
        g("mqqapi://vasvip/assistant_setting", en.class);
        g("mqqapi://vasvip/kuikly", ((IVasMqqScheme) QRoute.api(IVasMqqScheme.class)).getQVipKuiklyJumpParseClass());
        g("mqqapi://vastest", ep.class);
        g("mqqapi://nearbypro/feed_publish", bi.class);
        g("mqqapi://nearbypro/feed_detail", bi.class);
        g("mqqapi://qqrobotaio", ((IRobotSchemeApi) QRoute.api(IRobotSchemeApi.class)).createRobotAIOJumpParserClass());
        g("mqqapi://qqliteaction/operate", com.tencent.qqnt.biz.lightbusiness.lightinteraction.scheme.b.class);
        g("mqqapi://qzone/qzone_push", ((IJumpParserApi) QRoute.api(IJumpParserApi.class)).getQZonePushParser());
        g("mqqapi://qrobot", ((IRobotSchemeApi) QRoute.api(IRobotSchemeApi.class)).createQRobotJumpParserClass());
        g("mqqapi://o3/report", ((IDTAPI) QRoute.api(IDTAPI.class)).getO3SchemeParserClass());
        g("mqqapi://arktux", ((IQTuxApi) QRoute.api(IQTuxApi.class)).createTuxJumpParserClass());
        g("mqqrouter://flash_transfer", ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getFlashTransferJumpParserClass());
    }

    public static String c(String str) {
        int indexOf;
        try {
            if (!TextUtils.isEmpty(str) && str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) && (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) != -1) {
                return str.substring(0, indexOf);
            }
            return str;
        } catch (Exception e16) {
            QLog.d("JumpParserUtil", 2, "handleSensitiveSchemeLog out error", e16);
            return str;
        }
    }

    public static com.tencent.mobileqq.utils.ax d(BaseQQAppInterface baseQQAppInterface, Context context, String str) {
        try {
            if (f196455b == null) {
                synchronized (ax.class) {
                    if (f196455b == null) {
                        f196455b = new ax();
                    }
                }
            }
            return f196455b.a(baseQQAppInterface, context, str);
        } catch (Exception e16) {
            HashMap<String, String> hashMap = new HashMap<>(1);
            hashMap.put(JumpParseConstants.KEY_JUMP_PARSER_UTIL_URL_ERROR_KEY, str);
            hashMap.put(JumpParseConstants.KEY_JUMP_PARSER_UTIL_SCENE_ERROR_KEY, "1");
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance("", JumpParseConstants.KEY_JUMP_PARSER_UTIL, true, 0L, 0L, hashMap, "", false);
            QLog.e("JumpParserUtil", 1, "parse error: " + e16.getMessage());
            return null;
        }
    }

    public static JumpParserResult e(String str) {
        String substring;
        if (TextUtils.isEmpty(str)) {
            QLog.e("JumpParserUtil", 1, "parseUrl error: jump is empty");
            return null;
        }
        JumpParserResult jumpParserResult = new JumpParserResult("", "", "", "", str);
        int indexOf = str.indexOf(":");
        if (indexOf > 0) {
            jumpParserResult.setScheme(str.substring(0, indexOf));
            QLog.d("JumpParserUtil", 1, "parseUrl scheme is: " + jumpParserResult.getScheme());
            String[] split = str.split("\\?");
            if (split.length == 2) {
                substring = split[0].substring(indexOf + 3);
            } else {
                substring = str.substring(indexOf + 3);
            }
            String[] split2 = substring.split("/");
            if (split2.length == 0) {
                jumpParserResult.setServer(substring);
                QLog.d("JumpParserUtil", 1, "parseUrl server is: " + jumpParserResult.getServer());
            } else {
                jumpParserResult.setServer(split2[0]);
                jumpParserResult.setAction(substring.substring(substring.indexOf("/") + 1));
                QLog.d("JumpParserUtil", 1, "parseUrl server is: " + jumpParserResult.getServer() + " action is: " + c(jumpParserResult.getAction()));
            }
            if (split.length == 2) {
                for (String str2 : split[1].split(ContainerUtils.FIELD_DELIMITER)) {
                    String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER, 2);
                    if (split3.length == 2) {
                        try {
                            String decode = URLDecoder.decode(split3[1], "UTF-8");
                            split3[1] = decode;
                            jumpParserResult.putAttribute(split3[0], decode);
                        } catch (Exception e16) {
                            QLog.e("JumpParserUtil", 1, "failed to decode param value,keyValues[1] is:" + split3[1] + ",keyValues[2] is:" + split3[1], e16);
                        }
                    }
                }
            }
            return jumpParserResult;
        }
        jumpParserResult.setScheme(str);
        QLog.d("JumpParserUtil", 1, "parseUrl scheme is: " + jumpParserResult.getScheme());
        return jumpParserResult;
    }

    private String f(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("JumpParserUtil", 1, "shouldPreDecodeUrl error: url is null");
            return str;
        }
        if (!str.startsWith("mqqapi://qqidentifier/web") && !str.startsWith("mqqapi://groupopenapp/openapp") && !str.startsWith("mqqapi://commonBuddyGroup/commonBuddyGroup") && !str.startsWith("mqqapi://manage_troop/main_page") && !str.startsWith("mqqapi://nearby_entry/nearby_feed") && !str.startsWith("mqqapi://now/playmedia") && !str.startsWith("mqqapi://wsgzh/waterfall") && !str.startsWith("mqqapi://wsgzh/miniapp_player") && !str.startsWith("mqqapi://wsgzh/wesee") && !str.startsWith("mqqzone") && !str.startsWith("mqqapi://qzoneschema") && !str.startsWith("mqqapi://qzone/publicaccount") && !str.startsWith("mqqapi://qboss/loader") && !str.startsWith("qqfav://operation/") && !str.startsWith("mqq://shop/apollo_store") && !str.startsWith("mqqapi://shop/apollo_store") && !str.startsWith("mqqapi://assistant_setting/ASSISTANT_SETTING") && !str.startsWith("mqqapi://trooptogether/open") && str.contains("videochat") && str.contains("uinType=21")) {
            QLog.d("JumpParserUtil", 1, "shouldPreDecodeUrl execute for containing videochat and uinType=21");
            return URLDecoder.decode(str);
        }
        return str;
    }

    private void g(String str, Class cls) {
        if (cls == null) {
            QLog.e("JumpParserUtil", 1, "registerParser error: class is null");
        } else if (TextUtils.isEmpty(str)) {
            QLog.e("JumpParserUtil", 1, "registerParser error: urlStartStr is empty");
        } else {
            this.f196456a.add(new JumpParserBean(str, cls));
        }
    }

    public com.tencent.mobileqq.utils.ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.utils.ax) iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, context, str);
        }
        QLog.d("JumpParserUtil", 1, "doParse url: " + c(str));
        if (str == null) {
            QLog.d("JumpParserUtil", 1, "doParse url is null, return");
            return null;
        }
        String f16 = f(str);
        if (QQAudioHelper.f() && QQAudioHelper.c(8) == 1 && f16.startsWith("mqqconferenceflyticket://")) {
            f16 = "mqqavshare://avshare/forward?url=https%3a%2f%2fwww.baidu.com%2fs%3fwd%3dabc%26rsv_spt%3d1&exp=1566906601";
        }
        JumpParserResult e16 = e(f16);
        av a16 = aw.a(e16, b());
        if (a16 != null) {
            QLog.d("JumpParserUtil", 1, "doParse, prepare to parse url: " + c(f16));
            return a16.a(baseQQAppInterface, context, f16, e16);
        }
        QLog.d("JumpParserUtil", 1, "doParse error: jumpParser not register, handle with old method:" + f16);
        return null;
    }

    public ArrayList<JumpParserBean> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f196456a;
    }
}
