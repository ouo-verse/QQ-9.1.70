package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.comic.api.IQQComicConfigApi;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.ap;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.ProcessorDispatcher;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.guild.api.GuildPublicAccountParams;
import com.tencent.mobileqq.guild.api.IGuildChannelLoadApi;
import com.tencent.mobileqq.guild.api.IGuildDiscoverApi;
import com.tencent.mobileqq.guild.api.IGuildPublicToDetailFullLinkReportApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.mobileqq.managers.AdDurationReportManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher;
import com.tencent.mobileqq.qcircle.api.ITVideoPublicAccountLauncherApi;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountLauncherSource;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.EcommerceMsgCenterSource;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqnews.api.IQQNewsCommApi;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.vas.api.IVasReadPublicAccount;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.z1.mod.api.IZPlanPublicAccountLauncherApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupSceneType;
import com.tencent.qqperf.opt.suspendthread.SuspendThreadManager;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.nt.api.IRelationAIOService;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildUnreadCntService;
import com.tencent.util.NumberUtil;
import com.tencent.util.URLUtil;
import com.tenpay.sdk.util.UinConfigManager;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791$RedDotInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class RecentUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f185176a;

    /* renamed from: b, reason: collision with root package name */
    public static MessageRecord f185177b;

    /* renamed from: c, reason: collision with root package name */
    public static long f185178c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f185179d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f185180e;

    /* renamed from: f, reason: collision with root package name */
    private static final Set<String> f185181f;

    /* renamed from: g, reason: collision with root package name */
    public static String f185182g;

    /* renamed from: h, reason: collision with root package name */
    private static int f185183h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69182);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f185176a = false;
        f185177b = null;
        f185178c = 0L;
        f185179d = false;
        f185180e = true;
        f185181f = new HashSet(Arrays.asList(AppConstants.QQBROADCAST_MSG_UIN, AppConstants.NEW_KANDIAN_UIN, AppConstants.WEISHI_UIN, AppConstants.TIM_TEAM_UIN, AppConstants.KANDIAN_SUBSCRIBE_UIN, AppConstants.KANDIAN_DAILY_UIN, AppConstants.VALUE.UIN_QZONE, "2747277822", "3593944551", IPublicAccountUtil.UIN_FOR_SHOP, AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, AppConstants.QQ_VIP_UIN, AppConstants.QQ_YELLOW_VIP_UIN, qb2.a.f428781a, IPublicAccountUtil.UIN_FOR_WALLET, AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN, AppConstants.ZPLAN_MOD_SMALLHOME_PUBLIC_ACCOUNT_UIN, AppConstants.Q_ECOMMERCE_MSG_PUBLIC_ACCOUNT_UIN, AppConstants.TVIDEO_PUBLIC_ACCOUNT_UIN));
        f185182g = "Async_report_recent_item_click";
        f185183h = -1;
    }

    public RecentUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    private static Bundle A(Bundle bundle) {
        if (bundle == null || (!bundle.getBoolean(AppConstants.Key.KEY_ENTER_FROM_TEMP_MSG_BOX, false) && !bundle.getBoolean("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM", false))) {
            return null;
        }
        return bundle;
    }

    private static void A0(QQAppInterface qQAppInterface, RecentUser recentUser) {
        if (recentUser.getType() == 5000) {
            n(qQAppInterface);
            return;
        }
        if (recentUser.getType() == 7210) {
            TroopBarAssistantManager.n().U(qQAppInterface, true);
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.RecentUtil.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAppInterface.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int size;
                    Message lastMessage;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    List<TroopBarData> r16 = TroopBarAssistantManager.n().r(QQAppInterface.this);
                    if (r16 == null) {
                        size = 0;
                    } else {
                        size = r16.size();
                    }
                    for (int i3 = 0; i3 < size; i3++) {
                        TroopBarData troopBarData = r16.get(i3);
                        if (troopBarData != null && (lastMessage = QQAppInterface.this.getMessageFacade().getLastMessage(troopBarData.mUin, 1008)) != null) {
                            TroopBarAssistantManager.n().R(QQAppInterface.this, lastMessage.time);
                        }
                    }
                }
            }, 8, null, false);
            TroopBarAssistantManager.n().M(qQAppInterface);
            return;
        }
        if (recentUser.getType() == 7120) {
            r(qQAppInterface);
            return;
        }
        if (recentUser.getType() == 9002) {
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004E99", "0X8004E99", 0, 0, "", "", "", "");
            List<com.tencent.mobileqq.reminder.db.b> msgList = com.tencent.mobileqq.reminder.db.d.a(qQAppInterface).getMsgList(AppConstants.ACTIVATE_FRIENDS_UIN, 0);
            ArrayList arrayList = new ArrayList(msgList.size());
            for (com.tencent.mobileqq.reminder.db.b bVar : msgList) {
                if (!bVar.getIsread() && (bVar.getExtLong() & 1) == 1 && !TextUtils.isEmpty(bVar.getExtStr())) {
                    arrayList.add(bVar.getExtStr());
                }
                qQAppInterface.getMessageFacade().T1(AppConstants.ACTIVATE_FRIENDS_UIN, 0, bVar.getUniseq());
            }
            if (arrayList.size() > 0) {
                com.tencent.mobileqq.app.activateFriends.a.i(qQAppInterface, arrayList);
                return;
            }
            return;
        }
        if (recentUser.getType() == 9003) {
            ((BlessManager) qQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).K0();
            return;
        }
        if (recentUser.getType() == 7000 && AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(recentUser.uin)) {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.RecentUtil.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAppInterface.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (QQAppInterface.this != null) {
                        ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).cleanAllThirdQQUnreadMsgNum(QQAppInterface.this);
                        ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).cleanAllSubAccountMessageUnread(QQAppInterface.this, true, null);
                    }
                }
            }, null, true);
            return;
        }
        if (recentUser.getType() == 6004) {
            m(qQAppInterface);
            return;
        }
        if (recentUser.getType() == 10011) {
            l(qQAppInterface);
        } else if (recentUser.getType() == 10012) {
            g(qQAppInterface);
        } else if (recentUser.getType() == 10015) {
            J0(qQAppInterface);
        }
    }

    private static GuildFeedReportSourceInfo B() {
        GuildFeedReportSourceInfo guildFeedReportSourceInfo = new GuildFeedReportSourceInfo();
        guildFeedReportSourceInfo.addReportItem("extra_feeds_pre_page_id", IGameMsgBoxRuntimeService.DT_PAGE_ID);
        return guildFeedReportSourceInfo;
    }

    private static void B0(QQAppInterface qQAppInterface, RecentUser recentUser, int i3) {
        String str;
        if (recentUser.getType() == 9000) {
            AppConstants.TROOP_NOTIFICATION_UIN.equals(recentUser.uin);
        }
        if (recentUser.getType() == 7210 && AppConstants.TROOP_BAR_ASSISTANT_UIN.equals(recentUser.uin)) {
            TroopBarAssistantManager.n().g(qQAppInterface);
            TroopBarAssistantManager.n().S(qQAppInterface);
            qQAppInterface.refreshMsgTabUnreadNum(true, 0);
        }
        if (AppConstants.TROOP_BAR_ASSISTANT_UIN.equals(recentUser.uin)) {
            ReportController.o(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800572D", "0X800572D", 0, 0, "", "", "", "");
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X800623F", "0X800623F", 0, 0, "", "", "", "");
            SubscriptRecommendController.G(qQAppInterface, false);
        } else if (AppConstants.EC_SHOP_ASSISTANT_UIN.equals(recentUser.uin)) {
            if (((EcShopAssistantManager) qQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).i(qQAppInterface) > 0) {
                str = "havereddot";
            } else {
                str = "noreddot";
            }
            ReportController.o(qQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsglist", "Del_shopHelper", 0, 0, "", "", str, "");
        }
    }

    private static GuildPublicAccountParams C(QQAppInterface qQAppInterface) {
        String extInfoFromExtStr = qQAppInterface.getMessageFacade().getLastMessage(AppConstants.VALUE.UIN_GUILD_OFFICIAL_ACCOUNT, 1008).getExtInfoFromExtStr(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND);
        if (extInfoFromExtStr.isEmpty()) {
            return null;
        }
        return D(extInfoFromExtStr);
    }

    private static void C0(QQAppInterface qQAppInterface, RecentUser recentUser, String str, int i3, RecentBaseData recentBaseData) {
        String str2;
        boolean z16;
        int i16;
        if (recentBaseData != null && i3 == 0 && recentUser.uin != null && (recentUser.getType() == 1008 || recentUser.getType() == 7220)) {
            RecentPubAccHelper.i(qQAppInterface, recentUser.uin, recentBaseData.mUnreadFlag, recentBaseData.getUnreadNum(), 1, str);
            if (recentUser.getType() == 7220 || AppConstants.KANDIAN_MERGE_UIN.equalsIgnoreCase(recentBaseData.getRecentUserUin()) || AppConstants.WEISHI_UIN.equalsIgnoreCase(recentBaseData.getRecentUserUin()) || AppConstants.VALUE.UIN_QZONE.equalsIgnoreCase(recentBaseData.getRecentUserUin())) {
                RecentPubAccHelper.f185165g.add(new RecentPubAccHelper.a(recentUser.uin, str, System.currentTimeMillis()));
            }
        }
        if (recentBaseData != null && recentUser.uin != null && recentUser.getType() == 1008) {
            if (recentBaseData instanceof RecentItemPublicAccountChatMsgData) {
                str2 = ((RecentItemPublicAccountChatMsgData) recentBaseData).mReportKeyBytesOacMsgxtend;
            } else {
                str2 = "";
            }
            String d16 = PublicAccountEventReport.d(str2);
            String str3 = recentBaseData.getRecentUserUin() + "_" + ((int) (System.currentTimeMillis() / 1000));
            if (recentBaseData.mUnreadNum > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            AdDurationReportManager.c.a aVar = new AdDurationReportManager.c.a();
            AdDurationReportManager.c.a e16 = aVar.c("vab_push").d(d16).e(str3);
            if (z16) {
                i16 = 6;
            } else {
                i16 = -1;
            }
            e16.b(i16);
            AdDurationReportManager.d().g(aVar.a());
        }
    }

    @Nullable
    public static GuildPublicAccountParams D(String str) {
        try {
            String optString = new JSONObject(str).optString("oac_triggle");
            String[] split = optString.split(ContainerUtils.FIELD_DELIMITER);
            QLog.d("RecentUtil", 1, "getPubAccountDiscoverJumpType oac_triggle:", optString);
            if (split == null) {
                return null;
            }
            for (String str2 : split) {
                if (str2.startsWith("busi_id") && str2.split(ContainerUtils.KEY_VALUE_DELIMITER).length > 1) {
                    JSONObject jSONObject = new JSONObject(URLUtil.decodeUrl(str2.split(ContainerUtils.KEY_VALUE_DELIMITER)[1]));
                    return new GuildPublicAccountParams(jSONObject.optInt(QQHealthReportApiImpl.MSG_TYPE_KEY), jSONObject.optString("jump_link"), 1, jSONObject.optString("busi_info"), jSONObject.optInt("jump_detail"), jSONObject.optInt("is_direct"));
                }
            }
            return null;
        } catch (JSONException unused) {
            QLog.e("RecentUtil", 1, "getPubAccountDiscoverJumpType error bytesOacMsgExt:", str);
            return null;
        }
    }

    public static void D0(QQAppInterface qQAppInterface, RecentUser recentUser) {
        if (recentUser.getType() != 5000) {
            if (recentUser.getType() != 7200 && recentUser.getType() != 1008) {
                if (String.valueOf(AppConstants.SUBACCOUNT_ASSISTANT_UIN_LONGVALUE).equals(recentUser.uin)) {
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X800419F", "0X800419F", 0, 0, "", "", "", "");
                } else if ((recentUser.getType() == 1001 || recentUser.getType() == 10002) && AppConstants.LBS_HELLO_UIN.equals(recentUser.uin)) {
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X80041A2", "0X80041A2", 0, 0, "", "", "", "");
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X80050FD", "0X80050FD", 0, 0, "", "", "", "");
                    ReportController.o(qQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_msg", 0, 0, "", "", "", "");
                } else if (recentUser.getType() == 1010 && AppConstants.DATE_UIN.equals(recentUser.uin)) {
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X80050FF", "0X80050FF", 0, 0, "", "", "", "");
                } else if (recentUser.getType() == 1009 && AppConstants.SAME_STATE_BOX_UIN.equals(recentUser.uin)) {
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X80041A4", "0X80041A4", 0, 0, "", "", "", "");
                }
            } else {
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X80041A1", "0X80041A1", 0, 0, "", "", "", "");
                if (recentUser.getType() == 1008) {
                    a(qQAppInterface, recentUser.uin, 1);
                }
            }
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X800419C", "0X800419C", 0, 0, "", "", "", "");
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800419C", "0X800419C", 0, 0, "", "", "", "");
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
    }

    @NotNull
    private static Intent E(Context context) {
        if (context instanceof PublicFragmentActivity) {
            PublicBaseFragment G2 = ((PublicFragmentActivity) context).G2();
            if (!(G2 instanceof TempMsgBoxFragment) && !(G2 instanceof FilterMsgBoxFragment)) {
                return SplashActivity.getAliasIntent(context);
            }
            return new Intent(context, (Class<?>) ChatActivity.class);
        }
        return SplashActivity.getAliasIntent(context);
    }

    private static void E0(QQAppInterface qQAppInterface, String str, MessageRecord messageRecord, int i3) {
        String str2;
        int i16;
        if (messageRecord != null) {
            PAMessage b16 = ap.b(messageRecord);
            if (b16 != null) {
                str2 = Long.toString(b16.mMsgId);
            } else {
                str2 = messageRecord.getExtInfoFromExtStr("pa_msgId");
            }
        } else {
            str2 = "";
        }
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_sys_3", "msg_aio", 0, 0, str, str2, String.valueOf(i3), "", false);
        if ("2909288299".equals(str)) {
            if (i3 > 0) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            ReportController.o(qQAppInterface, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X8007055", "0X8007055", 0, 0, "", "", "", ServiceAccountFolderManager.u(i16));
        }
    }

    private static GuildAppReportSourceInfo F() {
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", "msg_tab_list");
        return guildAppReportSourceInfo;
    }

    private static void F0(QQAppInterface qQAppInterface, RecentUser recentUser, RecentBaseData recentBaseData) {
        String str;
        String str2;
        String str3;
        long j3;
        MessageRecord messageRecord;
        int i3 = recentUser.msgType;
        if (i3 == 18) {
            TroopAioNavigateBarManager troopAioNavigateBarManager = (TroopAioNavigateBarManager) qQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
            String str4 = recentUser.uin;
            if (str4 != null) {
                j3 = troopAioNavigateBarManager.k(str4);
            } else {
                j3 = 0;
            }
            if (j3 != 0) {
                messageRecord = qQAppInterface.getMessageFacade().u0(recentUser.uin, recentUser.getType(), j3);
            } else {
                messageRecord = null;
            }
            if (MessageForQQWalletMsg.isRedPacketMsg(messageRecord)) {
                ReportController.o(qQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_hongbaoSign", 0, 0, recentUser.uin, "", "", "");
            } else {
                ReportController.o(qQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, recentUser.uin, "", "", "");
            }
            ReportController.o(qQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, recentUser.uin, "", "", "");
            str = LogTag.TAG_TROOP_SPECIAL_ATTENTION;
        } else if (i3 == 25) {
            ReportController.o(qQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_atsign", 0, 0, recentUser.uin, "", "", "");
            str = LogTag.TAG_TROOP_AT_MSG;
        } else {
            if (i3 == 23) {
                GroupMsgMask troopMask = qQAppInterface.getTroopMask(recentUser.uin);
                if (recentUser.getType() == 3000) {
                    str2 = "Grp_Dis_replyMsg";
                } else {
                    str2 = "Grp_replyMsg";
                }
                ReportController.o(qQAppInterface, "P_CliOper", str2, "", "Msglist", "Clk_replySign", 0, 0, recentUser.uin, "" + troopMask.ordinal(), "", "");
            } else if (i3 == 17) {
                ReportController.n(null, "dc00898", "", recentUser.uin, QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A907", 0, 1, 0, "", "", "", "");
            }
            str = "";
        }
        if (ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QQ_MESSAGE_REMINDER_DND).isExperiment()) {
            str3 = "4";
        } else {
            str3 = "3";
        }
        H0(qQAppInterface, recentBaseData, str3);
        if (!TextUtils.isEmpty(str) && QLog.isColorLevel()) {
            QLog.d(RecentUtil.class.getSimpleName() + str, 2, "onRecentUserClick, r.uin:" + recentUser.uin);
        }
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(recentUser.uin)) {
            com.tencent.mobileqq.filemanager.fileassistant.util.g.f();
        }
    }

    private static boolean G(Activity activity, QQAppInterface qQAppInterface, RecentUser recentUser, int i3, RecentBaseData recentBaseData) {
        String str = recentUser.uin;
        if ((str != null && str.length() == 4) || f185181f.contains(recentUser.uin) || ((IQQComicConfigApi) QRoute.api(IQQComicConfigApi.class)).isMatched(recentUser.uin) || com.tencent.gamecenter.common.util.l.f(recentBaseData, recentUser.uin)) {
            try {
                return V(qQAppInterface, activity, recentUser, i3, recentBaseData);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static void G0(QQAppInterface qQAppInterface, RecentUser recentUser) {
        int i3;
        int type = recentUser.getType();
        if (type != 0) {
            i3 = 1;
            if (type != 1) {
                if (type != 1000 && type != 1003 && type != 1006) {
                    if (type != 1008) {
                        if (type != 1025) {
                            if (type != 3000) {
                                if (type != 4000) {
                                    if (type != 6000) {
                                        if (type != 7000) {
                                            if (type != 10008) {
                                                if (type != 5000) {
                                                    if (type == 5001) {
                                                        i3 = 11;
                                                    }
                                                    i3 = 0;
                                                } else {
                                                    i3 = 4;
                                                }
                                            } else {
                                                i3 = 12;
                                            }
                                        } else {
                                            i3 = 5;
                                        }
                                    } else {
                                        i3 = 8;
                                    }
                                } else {
                                    i3 = 6;
                                }
                            } else {
                                i3 = 2;
                            }
                        }
                    } else {
                        a(qQAppInterface, recentUser.uin, 2);
                        i3 = 3;
                    }
                }
                i3 = 9;
            }
        } else {
            if (recentUser.uin.equals(AppConstants.SYSTEM_MSG_UIN)) {
                i3 = 7;
            }
            i3 = 0;
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "Msg_tab", "Delete_msg", 0, 0, i3 + "", "", "", "");
    }

    private static void H(Context context, QQAppInterface qQAppInterface, RecentUser recentUser, String str, boolean z16, Bundle bundle, Intent[] intentArr) {
        IGProChannelInfo channelInfo = ((IGPSService) qQAppInterface.getRuntimeService(IGPSService.class, "")).getChannelInfo(recentUser.uin);
        if (channelInfo == null) {
            return;
        }
        F();
        GuildFeedReportSourceInfo B = B();
        com.tencent.mobileqq.guild.report.b.g("msg_tab_list", "RecentUtil");
        if (channelInfo.getType() == 1) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("GuildFeedReportSourceInfo", B);
            com.tencent.mobileqq.guild.api.i a16 = new com.tencent.mobileqq.guild.api.i().f(channelInfo.getGuildId()).b(channelInfo.getChannelUin()).d(com.tencent.guild.aio.factory.a.class.getName()).e(bundle2).a();
            if (AppSetting.t(context)) {
                ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchSplashGuildChatFragment(context, a16);
                return;
            } else {
                ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchSplashGuildChatActivity(context, a16);
                return;
            }
        }
        JumpGuildParam jumpGuildParam = new JumpGuildParam(channelInfo.getGuildId(), channelInfo.getChannelUin());
        jumpGuildParam.setFeedReportSourceInfo(B);
        ((IGuildChannelLoadApi) QRoute.api(IGuildChannelLoadApi.class)).loadGuildChannelWithMsgListTab(context, jumpGuildParam);
    }

    private static void H0(QQAppInterface qQAppInterface, RecentBaseData recentBaseData, String str) {
        String str2;
        String str3;
        if (recentBaseData instanceof RecentItemChatMsgData) {
            int i3 = n.f185706a.get(0);
            int i16 = recentBaseData.mUnreadFlag;
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            str2 = "6";
                        } else {
                            str3 = str;
                            ReportController.o(qQAppInterface, "CliOper", "", "", "0X800BB64", "0X800BB64", 0, i3, str3, "", "", "");
                        }
                    } else {
                        str2 = "2";
                    }
                } else {
                    str2 = "1";
                }
            } else {
                str2 = "5";
            }
            str3 = str2;
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X800BB64", "0X800BB64", 0, i3, str3, "", "", "");
        }
    }

    private static void I(Activity activity, QQAppInterface qQAppInterface, RecentUser recentUser, RecentBaseData recentBaseData) {
        GuildPublicAccountParams guildPublicAccountParams;
        int i3 = recentBaseData.mUnreadNum;
        if (i3 > 0) {
            recentBaseData.clearUnReadNum();
            com.tencent.util.notification.d.h(qQAppInterface).d(recentBaseData.getRecentUserUin());
            c(qQAppInterface, recentUser, false, false);
            guildPublicAccountParams = C(qQAppInterface);
        } else {
            guildPublicAccountParams = null;
        }
        if (guildPublicAccountParams == null) {
            guildPublicAccountParams = new GuildPublicAccountParams(1);
        }
        QLog.d("RecentUtil", 1, "handleClickForGuildOfficialAccount params:", guildPublicAccountParams, " unreadNum:", Integer.valueOf(i3));
        ((IGuildDiscoverApi) QRoute.api(IGuildDiscoverApi.class)).openDiscoverFromPublicAccount(activity, guildPublicAccountParams);
    }

    public static void I0(QQAppInterface qQAppInterface, String str, int i3) {
        if (qQAppInterface != null && str != null && qQAppInterface.getConversationFacade().R(str, i3) > 0) {
            long X = qQAppInterface.getMessageFacade().X(str, i3);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("RecentUtil,uin: %s, uinType: %d, id: %d", str, Integer.valueOf(i3), Long.valueOf(X)));
            }
            if (X == -1) {
                return;
            }
            qQAppInterface.getMsgHandler().getProcessor(ProcessorDispatcher.getProcessType(i3)).c(str, i3, X);
            if (str.equals("2747277822")) {
                i(qQAppInterface);
            }
        }
    }

    private static boolean J(QQAppInterface qQAppInterface, RecentUser recentUser) {
        if (recentUser.getType() != 1 || (recentUser.lFlag & 1) == 0 || qQAppInterface.getHotChatMng(true) == null) {
            return false;
        }
        return true;
    }

    private static int K(QQAppInterface qQAppInterface, RecentUser recentUser, boolean z16, int i3) {
        if (b(qQAppInterface, recentUser.uin) && 1 != recentUser.getType() && 3000 != recentUser.getType() && recentUser.getType() != 0) {
            recentUser.setType(0);
            if (z16) {
                return 2;
            }
            return i3;
        }
        return i3;
    }

    public static void K0(RecentUser recentUser, QQMessageFacade qQMessageFacade) {
        DraftSummaryInfo draftSummaryInfo;
        long currentTimeMillis = System.currentTimeMillis();
        if (recentUser != null && qQMessageFacade != null) {
            if (recentUser.getStatus() == 1000 && recentUser.lastmsgdrafttime == 0 && (draftSummaryInfo = qQMessageFacade.getDraftSummaryInfo(recentUser.uin, recentUser.getType())) != null) {
                recentUser.lastmsgdrafttime = draftSummaryInfo.getTime();
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "updateLastDraftTimeForNewRU| cost = " + currentTimeMillis2);
            }
        }
    }

    private static void L(Activity activity, QQAppInterface qQAppInterface, RecentUser recentUser, RecentBaseData recentBaseData) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "RecentUtil.onRecentUserClick. r.uin=" + recentUser.uin + " r.type=" + recentUser.getType());
        }
        String str2 = recentUser.uin;
        if (recentBaseData instanceof RecentItemSubAccount) {
            str2 = ((RecentItemSubAccount) recentBaseData).showSubUin;
        }
        ISubAccountAssistantForward iSubAccountAssistantForward = (ISubAccountAssistantForward) QRoute.api(ISubAccountAssistantForward.class);
        if (str2 == null) {
            str2 = "";
        }
        iSubAccountAssistantForward.forwardTo(qQAppInterface, activity, str2);
        qQAppInterface.getMessageFacade().O0(recentUser.uin, recentUser.getType());
        if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(recentUser.uin)) {
            str = null;
        } else {
            str = recentUser.uin;
        }
        ReportController.o(qQAppInterface, "CliOper", "", str, "Bind_account", "Clk_bind_account", 0, 0, "", "", "", "");
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800713E", "0X800713E", 0, 0, "", "", "", "");
    }

    private static int M(Activity activity, QQAppInterface qQAppInterface, RecentUser recentUser, String str, boolean z16, int i3, boolean z17, Bundle bundle, Intent[] intentArr) {
        RecentUser findRecentUser;
        int i16;
        Bundle bundle2;
        if (b(qQAppInterface, recentUser.uin)) {
            recentUser.setType(0);
            if (z16) {
                i16 = 2;
            } else {
                i16 = i3;
            }
            if (bundle != null && bundle.getBoolean(AppConstants.Key.KEY_ENTER_FROM_TEMP_MSG_BOX, false)) {
                bundle2 = bundle;
            } else {
                bundle2 = null;
            }
            int u16 = u(activity, qQAppInterface, String.valueOf(recentUser.uin), recentUser.getType(), str, z17, bundle2, intentArr) | i16;
            if (QLog.isColorLevel()) {
                QLog.i("Q.recent", 2, "from_enterchat");
                return u16;
            }
            return u16;
        }
        String str2 = recentUser.troopUin;
        if ((str2 == null || str2.trim().length() == 0) && (findRecentUser = qQAppInterface.getProxyManager().m().findRecentUser(recentUser.uin, 1)) != null) {
            recentUser.troopUin = findRecentUser.troopUin;
        }
        x(activity, recentUser.uin, recentUser.troopUin, recentUser.getType(), str, z17, bundle, intentArr);
        return i3;
    }

    private static void N(Activity activity, QQAppInterface qQAppInterface, RecentUser recentUser) {
        int i3;
        String str;
        JSONObject jSONObject;
        oidb_0x791$RedDotInfo f16 = ((TroopRedTouchManager) qQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).f(46, false);
        if (f16 != null && f16.uint32_number.has()) {
            i3 = f16.uint32_number.get();
        } else {
            i3 = 0;
        }
        String str2 = null;
        if (f16 != null && !f16.bool_display_reddot.get()) {
            try {
                if (f16.str_custom_buffer.has()) {
                    str = f16.str_custom_buffer.get().toStringUtf8();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject(str);
                } else {
                    jSONObject = new JSONObject();
                }
                if (f16.uint32_last_time.has()) {
                    jSONObject.put("lastTime", f16.uint32_last_time.get());
                }
                jSONObject.put("lastMsg", jSONObject.get("msg"));
                f16.str_custom_buffer.set(ByteStringMicro.copyFromUtf8(jSONObject.toString()));
                TroopRedTouchHandler.M2(qQAppInterface, f16, 0, true);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (i3 > 0) {
            c(qQAppInterface, recentUser, true, true);
            int H1 = qQAppInterface.getMessageFacade().H1();
            str2 = HardCodeUtil.qqStr(R.string.svl);
            if (H1 > 0) {
                if (H1 > 99) {
                    str2 = str2 + "(99+)";
                } else {
                    str2 = str2 + "(" + H1 + ")";
                }
            }
        }
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, str2);
        }
        intent.putExtra(QQBrowserActivity.IS_WRAP_CONTENT, true);
        intent.putExtra("url", "https://docs.qq.com/components/Notifications.html?_wv=3");
        intent.putExtra("hide_more_button", true);
        intent.putExtra("webStyle", "noBottomBar");
        intent.putExtra("isScreenOrientationPortrait", true);
        intent.putExtra("title", qQAppInterface.getApp().getString(R.string.hzo));
        intent.addFlags(603979776);
        activity.startActivity(intent);
    }

    public static boolean O(RecentBaseData recentBaseData) {
        return false;
    }

    private static boolean P(Activity activity, QQAppInterface qQAppInterface, RecentUser recentUser) {
        if (activity != null && qQAppInterface != null && recentUser != null) {
            return false;
        }
        return true;
    }

    private static boolean Q(int i3) {
        if (i3 != 1000 && i3 != 1020 && i3 != 1004 && i3 != 10010) {
            return false;
        }
        return true;
    }

    private static boolean R(Context context, String str, String str2, int i3, String str3, Bundle bundle) {
        if (TextUtils.isEmpty(str2) && i3 == 1000) {
            long stringToLong = NumberUtil.stringToLong(str);
            if (stringToLong != 0) {
                String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
                if (!TextUtils.isEmpty(uidFromUin)) {
                    ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIOActivity(context, 100, uidFromUin, str3, stringToLong, bundle);
                    return true;
                }
                QLog.w("RecentUtil", 1, "#jumpToAioForSearchTmpChat: uid is empty");
            }
            QLog.w("RecentUtil", 1, "#jumpToAioForSearchTmpChat: troopUin is empty, type=" + i3 + ", uinName=" + str3);
            return false;
        }
        return false;
    }

    private static void S(int i3, String str, String str2) {
        if (i3 != 1006) {
            return;
        }
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface == null) {
            QLog.d("RecentUtil", 1, "ntPrepareContactStrangerTempChat appInterface is null");
        } else if (((IKernelService) appInterface.getRuntimeService(IKernelService.class, "")).getMsgService() == null) {
            QLog.d("RecentUtil", 1, "ntPrepareContactStrangerTempChat  msgService is null");
        } else {
            ((IRelationAIOService) QRoute.api(IRelationAIOService.class)).ntPrepareContactStrangerTempChat(appInterface, str, str2);
        }
    }

    private static void T(Activity activity, int i3) {
        int i16;
        Intent intent = new Intent(activity, (Class<?>) ActivateFriendActivity.class);
        intent.setFlags(67108864);
        if (i3 == 0) {
            i16 = 1;
        } else {
            i16 = 3;
        }
        intent.putExtra("af_key_from", i16);
        activity.startActivity(intent);
    }

    private static boolean U(QQAppInterface qQAppInterface, Activity activity, RecentUser recentUser) {
        return ((IQQComicConfigApi) QRoute.api(IQQComicConfigApi.class)).launchIfMatched(recentUser.uin, activity, 1043, qQAppInterface);
    }

    public static boolean V(QQAppInterface qQAppInterface, Activity activity, RecentUser recentUser, int i3, RecentBaseData recentBaseData) throws JSONException {
        if (AppConstants.VOTE_MSG_UIN.equals(recentUser.uin)) {
            s0(qQAppInterface, activity);
        } else if (AppConstants.RECOMMEND_CONTACT_UIN.equals(recentUser.uin)) {
            j0(qQAppInterface, activity);
        } else if (AppConstants.TROOP_ASSISTANT_UIN.equals(recentUser.uin)) {
            p0(qQAppInterface, activity);
        } else if (AppConstants.QQBROADCAST_MSG_UIN.equals(recentUser.uin)) {
            Intent intent = new Intent(activity, (Class<?>) QQBroadcastActivity.class);
            intent.setFlags(67108864);
            activity.startActivity(intent);
        } else if (AppConstants.TROOP_BAR_ASSISTANT_UIN.equals(recentUser.uin)) {
            q0(qQAppInterface, activity);
        } else if (AppConstants.SEND_BLESS_UIN.equals(recentUser.uin)) {
            l0(qQAppInterface, activity);
        } else if (!AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN.equals(recentUser.uin)) {
            if (AppConstants.TROOP_NOTIFICATION_UIN.equals(recentUser.uin)) {
                r0(qQAppInterface, activity, recentUser);
            } else if (AppConstants.DATALINE_PC_UIN.equals(recentUser.uin)) {
                Z(qQAppInterface, activity, recentUser.type);
            } else if (AppConstants.DATALINE_PHONE_UIN.equals(recentUser.uin)) {
                a0(qQAppInterface, activity, recentUser.type);
            } else if (AppConstants.DATALINE_IPAD_UIN.equals(recentUser.uin)) {
                Y(qQAppInterface, activity);
            } else if (AppConstants.ACTIVATE_FRIENDS_UIN.equals(recentUser.uin)) {
                T(activity, i3);
            } else if (AppConstants.EC_SHOP_ASSISTANT_UIN.equals(recentUser.uin)) {
                b0(qQAppInterface, activity, recentBaseData);
            } else {
                int i16 = recentUser.msgType;
                if (1012 == i16) {
                    t0(qQAppInterface, activity);
                } else {
                    if (1030 != i16 && 1035 != i16 && 1041 != i16 && 1042 != i16) {
                        return W(qQAppInterface, activity, recentUser, i3, recentBaseData);
                    }
                    g0(activity, recentBaseData);
                }
            }
        }
        return true;
    }

    private static boolean W(QQAppInterface qQAppInterface, Activity activity, RecentUser recentUser, int i3, RecentBaseData recentBaseData) {
        if (AppConstants.SERVICE_ACCOUNT_FOLDER_UIN.equals(recentUser.uin)) {
            m0(qQAppInterface, activity, recentUser, i3, recentBaseData);
            return true;
        }
        if (AppConstants.WEISHI_UIN.equals(recentUser.uin)) {
            ((IWSManager) QRoute.api(IWSManager.class)).enterWSPublicAccount(activity, "from_home_page", true);
            return true;
        }
        if (AppConstants.TIM_TEAM_UIN.equals(recentUser.uin)) {
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).enterTimTeam(activity, qQAppInterface);
            return true;
        }
        boolean z16 = false;
        if (TextUtils.equals(recentUser.uin, AppConstants.VALUE.UIN_QZONE) && ((IQzoneMsgApi) QRoute.api(IQzoneMsgApi.class)).openContentBox(activity)) {
            if (recentBaseData != null && recentBaseData.getUnreadNum() > 0) {
                z16 = true;
            }
            com.tencent.mobileqq.statistics.n.j(z16);
            return true;
        }
        if (AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(recentUser.uin)) {
            h0(qQAppInterface, activity);
            return true;
        }
        String str = AppConstants.QQ_VIP_UIN;
        if (str.equals(recentUser.uin)) {
            s23.a.j(activity, RecentUser.TABLE_NAME);
            qQAppInterface.getConversationFacade().r(str, 1008, false);
            return true;
        }
        String str2 = AppConstants.QQ_YELLOW_VIP_UIN;
        if (str2.equals(recentUser.uin)) {
            y33.b.f449310a.d(activity, RecentUser.TABLE_NAME);
            qQAppInterface.getConversationFacade().r(str2, 1008, false);
            return true;
        }
        if (((IVasReadPublicAccount) QRoute.api(IVasReadPublicAccount.class)).isVipRead(recentUser.uin)) {
            ((IVasReadPublicAccount) QRoute.api(IVasReadPublicAccount.class)).startVipReadFragment(activity);
            qQAppInterface.getConversationFacade().r(AppConstants.QQ_VIP_READ_UIN, 1008, false);
            return true;
        }
        if ("2747277822".equals(recentUser.uin)) {
            if (((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()) {
                i0(qQAppInterface, activity);
                return true;
            }
        } else if ("3593944551".equals(recentUser.uin)) {
            if (((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isCustomGameMallPubAccount()) {
                f0(qQAppInterface, activity);
                return true;
            }
        } else {
            if (((IMiniAppService) QRoute.api(IMiniAppService.class)).shouldOpenWebFragment(recentUser.uin)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniGamePublicAccount(activity, "aio");
                qQAppInterface.getConversationFacade().r(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, false);
                return true;
            }
            if (TextUtils.equals(IPublicAccountUtil.UIN_FOR_SHOP, recentUser.uin)) {
                ((IEcshopUtilApi) QRoute.api(IEcshopUtilApi.class)).jump(activity);
                return true;
            }
            if (!TextUtils.equals(IPublicAccountUtil.UIN_FOR_WALLET, recentUser.uin)) {
                if (qb2.a.f428781a.equals(recentUser.uin)) {
                    return qb2.b.e(activity, recentUser.uin, 1);
                }
                if (((IQQComicConfigApi) QRoute.api(IQQComicConfigApi.class)).isMatched(recentUser.uin)) {
                    return U(qQAppInterface, activity, recentUser);
                }
                if (AppConstants.TEMP_MSG_BOX_UIN.equals(recentUser.uin)) {
                    o0(qQAppInterface, activity);
                    return true;
                }
                if (AppConstants.FILTER_MSG_UIN.equals(recentUser.uin)) {
                    d0(qQAppInterface, activity);
                    return true;
                }
                if (AppConstants.GAME_MSG_BOX_UIN.equals(recentUser.uin)) {
                    v0(activity, 0L);
                    return true;
                }
                if (!com.tencent.gamecenter.common.util.l.f(recentBaseData, recentUser.uin)) {
                    return X(qQAppInterface, activity, recentUser, i3, recentBaseData);
                }
            }
        }
        return false;
    }

    private static boolean X(QQAppInterface qQAppInterface, Activity activity, RecentUser recentUser, int i3, RecentBaseData recentBaseData) {
        if (AppConstants.Q_ECOMMERCE_MSG_PUBLIC_ACCOUNT_UIN.equals(recentUser.uin)) {
            c0(qQAppInterface, activity);
        } else if (AppConstants.TVIDEO_PUBLIC_ACCOUNT_UIN.equals(recentUser.uin)) {
            n0(qQAppInterface, activity, recentBaseData);
        } else if (AppConstants.ZPLAN_MOD_SMALLHOME_PUBLIC_ACCOUNT_UIN.equals(recentUser.uin)) {
            u0(qQAppInterface, activity, recentUser);
        } else {
            return false;
        }
        return true;
    }

    private static void Y(QQAppInterface qQAppInterface, Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) LiteActivity.class);
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_IPAD_UIN);
        activity.startActivity(intent);
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800C3A7", "0X800C3A7", 0, 0, "", "", "", "");
    }

    private static void Z(QQAppInterface qQAppInterface, Activity activity, int i3) {
        Intent intent = new Intent(activity, (Class<?>) LiteActivity.class);
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_PC_UIN);
        intent.putExtra("peerType", i3);
        activity.startActivity(intent);
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800603B", "0X800603B", 0, 0, "", "", "", "");
    }

    public static void a(QQAppInterface qQAppInterface, String str, int i3) {
        String str2;
        ThreadManagerV2.post(new Runnable(str, i3) { // from class: com.tencent.mobileqq.activity.recent.RecentUtil.6
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f185195e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f185196f;

            {
                this.f185195e = str;
                this.f185196f = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QQAppInterface.this, str, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Message lastMessage = QQAppInterface.this.getMessageFacade().getLastMessage(this.f185195e, 1008);
                String str4 = "0";
                if (lastMessage != null) {
                    String extInfoFromExtStr = lastMessage.getExtInfoFromExtStr("gdt_msgClick");
                    if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                        try {
                            JSONObject jSONObject = new JSONObject(extInfoFromExtStr);
                            if (jSONObject.has("ad_id")) {
                                str4 = jSONObject.getString("ad_id");
                            }
                        } catch (Exception unused) {
                            if (QLog.isColorLevel()) {
                                QLog.i("Q.recent", 2, "from_enterchat");
                            }
                        }
                        String str5 = str4;
                        String extInfoFromExtStr2 = lastMessage.getExtInfoFromExtStr("pa_msgId");
                        if (this.f185196f == 1) {
                            str3 = "0X8005C36";
                        } else {
                            str3 = "0X8005C39";
                        }
                        String str6 = str3;
                        ReportController.n(QQAppInterface.this, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "" + lastMessage.frienduin, str6, str6, 0, 1, 0, extInfoFromExtStr2, String.valueOf(NetConnInfoCenter.getServerTime() * 1000), "", str5);
                    }
                }
            }
        }, 2, null, false);
        if (AppConstants.VALUE.UIN_QZONE.equals(str)) {
            if (i3 == 1) {
                str2 = "0X80090E4";
            } else {
                com.tencent.mobileqq.statistics.n.k(3);
                str2 = "0X80090E5";
            }
            String str3 = str2;
            ReportController.o(qQAppInterface, "CliOper", "", "", str3, str3, 0, 0, "", "", "", "");
        }
    }

    private static void a0(QQAppInterface qQAppInterface, Activity activity, int i3) {
        Intent intent = new Intent(activity, (Class<?>) LiteActivity.class);
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_PHONE_UIN);
        intent.putExtra("peerType", i3);
        activity.startActivity(intent);
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800C3C4", "0X800C3C4", 0, 0, "", "", "", "");
    }

    public static boolean b(QQAppInterface qQAppInterface, String str) {
        return com.tencent.qqnt.contact.friends.b.f355778a.c(str, "RecentUtil");
    }

    private static void b0(QQAppInterface qQAppInterface, Activity activity, RecentBaseData recentBaseData) {
        String str;
        Activity activity2;
        String valueOf;
        int size;
        int i3;
        String str2;
        EcShopAssistantManager ecShopAssistantManager;
        int i16;
        boolean z16;
        int i17;
        Intent intent = new Intent(activity, (Class<?>) EcshopWebActivity.class);
        intent.putExtra("start_time", System.currentTimeMillis());
        intent.setFlags(67108864);
        ReportController.o(qQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Msglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
        EcShopAssistantManager ecShopAssistantManager2 = (EcShopAssistantManager) qQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
        String config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_MINI_APP_ECSHOP_URL, "");
        if (ecShopAssistantManager2 != null) {
            List<EcShopData> g16 = ecShopAssistantManager2.g();
            if (g16 == null) {
                size = 0;
            } else {
                size = g16.size();
            }
            if (size == 0) {
                i3 = size;
                str = config;
                str2 = "";
                ecShopAssistantManager = ecShopAssistantManager2;
                ReportController.o(qQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_noMsglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
            } else {
                i3 = size;
                str = config;
                str2 = "";
                ecShopAssistantManager = ecShopAssistantManager2;
            }
            int i18 = ecShopAssistantManager.i(qQAppInterface);
            if (i18 > 0) {
                i16 = 1;
            } else {
                i16 = i18;
            }
            StringBuilder sb5 = new StringBuilder();
            String str3 = str2;
            sb5.append(str3);
            sb5.append(i16);
            int i19 = i16;
            ReportController.o(qQAppInterface, "dc00899", IPublicAccountHandler.MAIN_ACTION, "1", "0X80064CB", "0X80064CB", 0, 0, sb5.toString(), str3 + i3, "", "");
            if (i19 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            intent.putExtra("has_red_hot", z16);
            if (recentBaseData == null) {
                i17 = -1;
            } else {
                i17 = recentBaseData.mUnreadNum;
            }
            activity2 = activity;
            EcShopAssistantManager ecShopAssistantManager3 = ecShopAssistantManager;
            ecShopAssistantManager3.b(intent, activity2, i17);
            if (!TextUtils.isEmpty(str)) {
                ecShopAssistantManager3.e(qQAppInterface);
            }
        } else {
            str = config;
            activity2 = activity;
        }
        if (TextUtils.isEmpty(str)) {
            activity2.startActivity(intent);
            return;
        }
        String str4 = str;
        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str4)) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity2, str4, 4003, null);
            if (recentBaseData == null) {
                valueOf = "0";
            } else {
                valueOf = String.valueOf(recentBaseData.mUnreadNum);
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async("shopping_folder", "click", "message", valueOf, null, null);
        }
    }

    public static void c(QQAppInterface qQAppInterface, RecentUser recentUser, boolean z16, boolean z17) {
        if (qQAppInterface != null && recentUser != null) {
            y(qQAppInterface, recentUser);
            if (ao.z(recentUser.uin, recentUser.getType())) {
                if (!AppConstants.DATE_UIN.equals(recentUser.uin) && !AppConstants.LBS_HELLO_UIN.equals(recentUser.uin)) {
                    if (1032 == recentUser.getType() && AppConstants.CONFESS_UIN.equals(recentUser.uin)) {
                        qQAppInterface.getConversationFacade().t();
                        ConfessMsgUtil.i(qQAppInterface, false);
                        ConfessMsgUtil.h(qQAppInterface, false);
                    }
                } else {
                    Message lastMessage = qQAppInterface.getMessageFacade().getLastMessage(recentUser.uin, recentUser.getType());
                    if (lastMessage != null) {
                        qQAppInterface.getConversationFacade().v(recentUser.getType(), lastMessage.time);
                    }
                }
                String str = recentUser.uin;
                int type = recentUser.getType();
                qQAppInterface.getMessageFacade().J0(str, type);
                ThreadManagerV2.post(new Runnable(str, type) { // from class: com.tencent.mobileqq.activity.recent.RecentUtil.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f185187e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ int f185188f;

                    {
                        this.f185187e = str;
                        this.f185188f = type;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, MessageHandler.this, str, Integer.valueOf(type));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            MessageHandler.this.Y4(this.f185187e, this.f185188f, false);
                        }
                    }
                }, 8, null, false);
            } else if (recentUser.getType() == 10014) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(recentUser.uin);
                ((IGuildUnreadService) qQAppInterface.getRuntimeService(IGuildUnreadService.class, "")).setChannelRead(recentUser.troopUin, arrayList, false);
            } else {
                if (z16) {
                    SessionInfo sessionInfo = new SessionInfo();
                    String str2 = recentUser.uin;
                    sessionInfo.f179557e = str2;
                    sessionInfo.f179559f = str2;
                    int type2 = recentUser.getType();
                    sessionInfo.f179555d = type2;
                    if (type2 == 1006) {
                        sessionInfo.C = ac.m0(qQAppInterface, sessionInfo.f179557e);
                    }
                    ChatActivityFacade.Q0(qQAppInterface, sessionInfo);
                }
                if (7000 == recentUser.getType() && AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(recentUser.uin)) {
                    ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).cleanAllThirdQQUnreadMsgNum(qQAppInterface);
                }
                if (recentUser.type == 1 && ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuild(recentUser.uin)) {
                    ((ITroopGuildUnreadCntService) qQAppInterface.getRuntimeService(ITroopGuildUnreadCntService.class, "")).setTroopGuildMsgRead(recentUser.uin, GuildGroupSceneType.KALL, false);
                }
                qQAppInterface.getMessageFacade().R0(recentUser.uin, recentUser.getType(), true, z17);
            }
            d(qQAppInterface, recentUser, z17);
        }
    }

    private static void c0(QQAppInterface qQAppInterface, Activity activity) {
        ((IEcommerceMsgCenter) QRoute.api(IEcommerceMsgCenter.class)).launchMainPage(qQAppInterface, activity, EcommerceMsgCenterSource.MESSAGE_TAB);
    }

    private static void d(QQAppInterface qQAppInterface, RecentUser recentUser, boolean z16) {
        if (recentUser.getType() == 5000) {
            n(qQAppInterface);
            return;
        }
        if (5001 == recentUser.getType()) {
            j(qQAppInterface);
            return;
        }
        if (AppConstants.RECOMMEND_CONTACT_UIN.equals(recentUser.uin)) {
            ((INewFriendService) qQAppInterface.getRuntimeService(INewFriendService.class)).markAllDataReaded();
            return;
        }
        if (!String.valueOf(AppConstants.TROOP_NOTIFICATION_UIN_LONGVALUE).equals(recentUser.uin)) {
            if (recentUser.getType() == 7210) {
                o(qQAppInterface);
                return;
            }
            if (recentUser.getType() == 7120) {
                e(qQAppInterface);
                return;
            }
            if (1001 == recentUser.getType()) {
                qQAppInterface.getInterFollowMgr().clearMsgBoxUnreadCount();
                return;
            }
            if (recentUser.lFlag == 16) {
                p(qQAppInterface, recentUser, z16, 1008);
                return;
            }
            if (recentUser.getType() == 10005) {
                p(qQAppInterface, recentUser, z16, 10005);
                return;
            }
            if (recentUser.getType() == 6004) {
                m(qQAppInterface);
                return;
            }
            if ("2747277822".equals(recentUser.uin)) {
                i(qQAppInterface);
                return;
            }
            if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(recentUser.uin)) {
                ((DataLineHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).m3();
            } else if (TextUtils.equals(AppConstants.TEMP_MSG_BOX_UIN, recentUser.uin)) {
                k(qQAppInterface, z16);
            } else if (TextUtils.equals(AppConstants.GAME_MSG_BOX_UIN, recentUser.uin)) {
                h(qQAppInterface, z16);
            }
        }
    }

    private static void d0(QQAppInterface qQAppInterface, Activity activity) {
        Intent intent = new Intent();
        intent.setFlags(67108864);
        PublicFragmentActivity.start(activity, intent, FilterMsgBoxFragment.class);
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B1C0", "0X800B1C0", 10000, 0, "", "", "", "");
    }

    private static void e(QQAppInterface qQAppInterface) {
        List<EcShopData> g16;
        EcShopData ecShopData;
        Message lastMessage;
        EcShopAssistantManager ecShopAssistantManager = (EcShopAssistantManager) qQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
        if (ecShopAssistantManager != null && (g16 = ecShopAssistantManager.g()) != null && g16.size() > 0 && (ecShopData = g16.get(0)) != null && (lastMessage = qQAppInterface.getMessageFacade().getLastMessage(ecShopData.mUin, 1008)) != null) {
            ecShopAssistantManager.t(lastMessage.time);
        }
    }

    private static void e0(Activity activity, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (AppSetting.t(activity)) {
            com.tencent.mobileqq.pad.i.e(activity, bundle, GameMsgBoxFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.standard).a());
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        PublicFragmentActivity.start(activity, intent, GameMsgBoxFragment.class);
    }

    private static void f(QQAppInterface qQAppInterface, boolean z16) {
        for (RecentUser recentUser : ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getFilterBoxRecentUsers(qQAppInterface)) {
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.f179555d = recentUser.getType();
            sessionInfo.f179557e = recentUser.uin;
            ChatActivityFacade.Q0(qQAppInterface, sessionInfo);
            qQAppInterface.getMessageFacade().R0(sessionInfo.f179557e, sessionInfo.f179555d, true, z16);
        }
    }

    private static void f0(QQAppInterface qQAppInterface, Activity activity) {
        ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).startGameMallPubAccount(activity, 2);
        I0(qQAppInterface, "3593944551", 1008);
        qQAppInterface.getConversationFacade().r("3593944551", 1008, false);
    }

    public static void g(QQAppInterface qQAppInterface) {
        for (RecentUser recentUser : ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getFilterBoxRecentUsers(qQAppInterface)) {
            I0(qQAppInterface, recentUser.uin, recentUser.type);
            qQAppInterface.getMessageFacade().O0(recentUser.uin, recentUser.type);
        }
    }

    private static void g0(Activity activity, RecentBaseData recentBaseData) {
        Intent intent;
        if ((recentBaseData instanceof RecentItemNoticeData) && (intent = ((RecentItemNoticeData) recentBaseData).intent) != null) {
            activity.startActivity(intent);
        }
    }

    private static void h0(QQAppInterface qQAppInterface, Activity activity) {
        ((IQCirclePublicAccountLauncher) QRoute.api(IQCirclePublicAccountLauncher.class)).launchQCircleFromPublicAccount(qQAppInterface, activity, QCirclePublicAccountLauncherSource.MESSAGE_TAB);
    }

    public static void i(QQAppInterface qQAppInterface) {
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) qQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
        if (iGameMsgManagerService.isInited()) {
            iGameMsgManagerService.setUnshowedUnreadCnt(0);
        }
    }

    private static void i0(QQAppInterface qQAppInterface, Activity activity) {
        int i3;
        String str;
        String str2;
        ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).startQQGamePubAccount(activity, 2);
        I0(qQAppInterface, "2747277822", 1008);
        qQAppInterface.getConversationFacade().r("2747277822", 1008, false);
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) qQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
        if (iGameMsgManagerService.isInited() && iGameMsgManagerService.getMsgShowOnList()) {
            GameCenterSessionInfo lastSessionInfo = iGameMsgManagerService.getLastSessionInfo();
            if (lastSessionInfo != null) {
                String m3 = lastSessionInfo.m();
                i3 = lastSessionInfo.x();
                str = m3;
            } else {
                i3 = -1;
                str = "";
            }
            if (iGameMsgManagerService.getUnshowedUnreadCnt() > 0) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
            iGameMsgHelperApi.reportForGameMsg(str, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92003", "206346", str2, i3 + "", "0", "20", "0", "", "");
        }
    }

    private static void j(QQAppInterface qQAppInterface) {
        HotChatCenterManager hotChatCenterManager = (HotChatCenterManager) qQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER);
        List<HotChatItemData> j3 = hotChatCenterManager.j();
        if (j3 != null && j3.size() > 0) {
            Iterator<HotChatItemData> it = j3.iterator();
            while (it.hasNext()) {
                Message lastMessage = qQAppInterface.getMessageFacade().getLastMessage(it.next().mTroopUin, 1);
                if (lastMessage != null) {
                    hotChatCenterManager.q(lastMessage.time);
                }
            }
        }
    }

    private static void j0(QQAppInterface qQAppInterface, Activity activity) {
        Intent intent = new Intent();
        if (activity instanceof QQLSActivity) {
            intent.putExtra("from", "from_lsa");
        }
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).startActivity(activity, intent, 1);
        ReportController.o(qQAppInterface, "CliOper", "", "", "Add_frd", "Clk_Frd_offer", 22, 0, "", "", "", "");
    }

    private static void k(QQAppInterface qQAppInterface, boolean z16) {
        for (RecentUser recentUser : ((ITempMsgBoxManager) qQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers()) {
            if (TextUtils.equals(AppConstants.FILTER_MSG_UIN, recentUser.uin)) {
                f(qQAppInterface, z16);
            } else {
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.f179555d = recentUser.getType();
                sessionInfo.f179557e = recentUser.uin;
                ChatActivityFacade.Q0(qQAppInterface, sessionInfo);
                qQAppInterface.getMessageFacade().R0(sessionInfo.f179557e, sessionInfo.f179555d, true, z16);
            }
        }
    }

    public static void k0(Intent intent) {
        if (f185176a) {
            intent.putExtra("aio_msg_source", 1);
            intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 7);
            f185176a = false;
            f185177b = null;
            f185178c = 0L;
            return;
        }
        intent.putExtra("aio_msg_source", 0);
    }

    public static void l(QQAppInterface qQAppInterface) {
        for (RecentUser recentUser : ((ITempMsgBoxManager) qQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers()) {
            if (recentUser.getType() == 10012) {
                g(qQAppInterface);
            } else {
                I0(qQAppInterface, recentUser.uin, recentUser.type);
                qQAppInterface.getMessageFacade().O0(recentUser.uin, recentUser.type);
            }
        }
    }

    private static void l0(QQAppInterface qQAppInterface, Activity activity) {
        BlessManager blessManager = (BlessManager) qQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER);
        if (blessManager != null) {
            blessManager.B0(activity);
            blessManager.M0(false);
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X800618B", "0X800618B", 0, 0, "", "", "", "");
        }
    }

    private static void m(QQAppInterface qQAppInterface) {
        TroopRedTouchHandler troopRedTouchHandler = (TroopRedTouchHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
        if (troopRedTouchHandler != null) {
            troopRedTouchHandler.D2(46);
        }
    }

    private static void m0(QQAppInterface qQAppInterface, Activity activity, RecentUser recentUser, int i3, RecentBaseData recentBaseData) {
        com.tencent.biz.pubaccount.util.k.a(null, "SERVICE_FOLDER_COST");
    }

    private static void n0(QQAppInterface qQAppInterface, Activity activity, RecentBaseData recentBaseData) {
        String str;
        if (recentBaseData instanceof RecentItemPublicAccountChatMsgData) {
            str = ((RecentItemPublicAccountChatMsgData) recentBaseData).mReportKeyBytesOacMsgxtend;
        } else {
            str = "";
        }
        ((ITVideoPublicAccountLauncherApi) QRoute.api(ITVideoPublicAccountLauncherApi.class)).launchTVideoPublicAccountPage(qQAppInterface, activity, str);
    }

    private static void o(QQAppInterface qQAppInterface) {
        TroopBarData troopBarData;
        Message lastMessage;
        List<TroopBarData> r16 = TroopBarAssistantManager.n().r(qQAppInterface);
        if (r16 != null && r16.size() > 0 && (troopBarData = r16.get(0)) != null && (lastMessage = qQAppInterface.getMessageFacade().getLastMessage(troopBarData.mUin, 1008)) != null) {
            TroopBarAssistantManager.n().R(qQAppInterface, lastMessage.time);
        }
    }

    private static void o0(QQAppInterface qQAppInterface, Activity activity) {
        Intent intent = new Intent();
        intent.setFlags(67108864);
        PublicFragmentActivity.start(activity, intent, TempMsgBoxFragment.class);
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B1BF", "0X800B1BF", 0, 0, "", "", "", "");
    }

    private static void p(QQAppInterface qQAppInterface, RecentUser recentUser, boolean z16, int i3) {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = i3;
        String str = recentUser.uin;
        sessionInfo.f179559f = str;
        sessionInfo.f179557e = str;
        ChatActivityFacade.Q0(qQAppInterface, sessionInfo);
        qQAppInterface.getMessageFacade().R0(sessionInfo.f179557e, 1008, true, z16);
    }

    public static void q(QQAppInterface qQAppInterface, RecentUser recentUser, int i3) {
        if (qQAppInterface != null && recentUser != null) {
            qQAppInterface.getProxyManager().m().delRecentUser(recentUser, false);
            if (ao.z(recentUser.uin, recentUser.getType())) {
                if (!AppConstants.DATE_UIN.equals(recentUser.uin) && !AppConstants.LBS_HELLO_UIN.equals(recentUser.uin)) {
                    if (1032 == recentUser.getType() && AppConstants.CONFESS_UIN.equals(recentUser.uin)) {
                        qQAppInterface.getConversationFacade().t();
                        ConfessMsgUtil.i(qQAppInterface, false);
                        ConfessMsgUtil.h(qQAppInterface, false);
                    }
                } else {
                    Message lastMessage = qQAppInterface.getMessageFacade().getLastMessage(recentUser.uin, recentUser.getType());
                    if (lastMessage != null) {
                        qQAppInterface.getConversationFacade().v(recentUser.getType(), lastMessage.time);
                    }
                }
                ThreadManagerV2.post(new Runnable(recentUser.uin, recentUser.getType()) { // from class: com.tencent.mobileqq.activity.recent.RecentUtil.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f185190e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ int f185191f;

                    {
                        this.f185190e = r6;
                        this.f185191f = r7;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, MessageHandler.this, r6, Integer.valueOf(r7));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            MessageHandler.this.Y4(this.f185190e, this.f185191f, true);
                        }
                    }
                }, 8, null, false);
            } else {
                I0(qQAppInterface, recentUser.uin, recentUser.getType());
            }
            if (recentUser.getType() == 1 && ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuild(recentUser.uin)) {
                ((ITroopGuildUnreadCntService) qQAppInterface.getRuntimeService(ITroopGuildUnreadCntService.class, "")).setTroopGuildMsgRead(recentUser.uin, GuildGroupSceneType.KALL, true);
            }
            qQAppInterface.getMessageFacade().R0(recentUser.uin, recentUser.getType(), true, true);
            B0(qQAppInterface, recentUser, i3);
            G0(qQAppInterface, recentUser);
            A0(qQAppInterface, recentUser);
        }
    }

    private static void q0(QQAppInterface qQAppInterface, Activity activity) {
        int i3;
        SubscriptRecommendController.G(qQAppInterface, false);
        TroopBarAssistantManager n3 = TroopBarAssistantManager.n();
        if (n3.w(qQAppInterface)) {
            ReportController.o(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005B70", "0X8005B70", 0, 0, qQAppInterface.getCurrentAccountUin(), "", "", "");
        }
        n3.P(qQAppInterface, false);
        n3.O(qQAppInterface, false);
        int p16 = TroopBarAssistantManager.n().p(qQAppInterface);
        if (p16 > 0) {
            ReportController.o(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800572B", "0X800572B", 0, 0, "", "", "", "");
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006573", "0X8006573", 0, 0, "", "", "", "");
        } else {
            ReportController.o(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800572C", "0X800572C", 0, 0, "", "", "", "");
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006574", "0X8006574", 0, 0, "", "", "", "");
        }
        if (p16 > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        ThreadManagerV2.post(new Runnable(i3) { // from class: com.tencent.mobileqq.activity.recent.RecentUtil.1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f185185e;

            {
                this.f185185e = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAppInterface.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int size = TroopBarAssistantManager.n().r(QQAppInterface.this).size();
                ReportController.o(QQAppInterface.this, "dc00899", IPublicAccountHandler.MAIN_ACTION, "0", "0X80064CB", "0X80064CB", 0, 0, "" + this.f185185e, "" + size, "", "");
            }
        }, 8, null, false);
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800623E", "0X800623E", 0, 0, "", "", "", "");
        ReportController.o(qQAppInterface, "P_CliOper", "Grp_tribe", "", "Msglist", "Clk_tribeHelper", 0, 0, "", "", "", "");
    }

    private static void r(QQAppInterface qQAppInterface) {
        int size;
        Message lastMessage;
        EcShopAssistantManager ecShopAssistantManager = (EcShopAssistantManager) qQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
        if (ecShopAssistantManager != null) {
            ecShopAssistantManager.r(true);
            List<EcShopData> g16 = ecShopAssistantManager.g();
            if (g16 == null) {
                size = 0;
            } else {
                size = g16.size();
            }
            for (int i3 = 0; i3 < size; i3++) {
                EcShopData ecShopData = g16.get(i3);
                if (ecShopData != null && (lastMessage = qQAppInterface.getMessageFacade().getLastMessage(ecShopData.mUin, 1008)) != null) {
                    ecShopAssistantManager.t(lastMessage.time);
                }
            }
        }
    }

    private static void r0(QQAppInterface qQAppInterface, Activity activity, RecentUser recentUser) {
        Intent intent = new Intent();
        qQAppInterface.getConversationFacade().c0(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0);
        ReportController.o(null, "dc00898", "", "", "0X800B527", "0X800B527", 0, 0, "", "", null, null);
        intent.putExtra("key_from", 2);
        intent.putExtra(ILaunchTroopSysMsgUIUtilApi.KEY_HAS_RED, false);
        ((ILaunchTroopSysMsgUIUtilApi) QRoute.api(ILaunchTroopSysMsgUIUtilApi.class)).launchTroopNotificationFragment(intent);
        ReportController.o(qQAppInterface, "P_CliOper", "Grp_contacts", "", UinConfigManager.KEY_ADS, "Clk_notice", 0, 0, "", "1", "", "");
    }

    public static int s(Context context, QQAppInterface qQAppInterface, String str, int i3, String str2, boolean z16) {
        return u(context, qQAppInterface, str, i3, str2, z16, null, null);
    }

    private static void s0(QQAppInterface qQAppInterface, Activity activity) {
        qQAppInterface.getMessageFacade().O0(AppConstants.VOTE_MSG_UIN, 0);
        Intent intent = new Intent(activity, (Class<?>) VisitorsActivity.class);
        intent.putExtra("votersOnly", true);
        intent.putExtra("toUin", Long.valueOf(qQAppInterface.getCurrentAccountUin()));
        activity.startActivity(intent);
    }

    public static int t(Context context, QQAppInterface qQAppInterface, String str, int i3, String str2, boolean z16, Bundle bundle) {
        return u(context, qQAppInterface, str, i3, str2, z16, bundle, null);
    }

    private static void t0(QQAppInterface qQAppInterface, Activity activity) {
        AllInOne allInOne = new AllInOne(qQAppInterface.getCurrentAccountUin(), 0);
        Intent intent = new Intent();
        intent.putExtra("param_mode", 2);
        intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
        intent.putExtra("frome_where", -1);
        intent.putExtra("abp_flag", true);
        intent.addFlags(67108864);
        activity.startActivity(intent);
        RouteUtils.startActivity(BaseApplication.getContext(), intent, "/nearby/people/profile");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int u(Context context, QQAppInterface qQAppInterface, String str, int i3, String str2, boolean z16, Bundle bundle, Intent[] intentArr) {
        Intent intent;
        int i16;
        String str3;
        String str4;
        String str5;
        String str6;
        ei.a(null, "Recent_clk_enterchat");
        SuspendThreadManager.I().R();
        Intent intent2 = new Intent();
        boolean z17 = false;
        if (intentArr != null && intentArr.length != 0) {
            intentArr[0] = intent2;
        }
        Intent z18 = z(context, bundle, intent2);
        int i17 = 1;
        if (i3 != 0 && i3 != 1024) {
            if (i3 == 1) {
                ei.a(null, "Recent_clk_enterchat_troop");
                if (w(context, qQAppInterface, str, 0, z18)) {
                    return 0;
                }
                ei.a("Recent_clk_enterchat_troop", null);
                z17 = z16;
                intent = z18;
            } else if (i3 == 1008) {
                ei.a(null, "Recent_clk_enterchat_pub");
                if (v(context, qQAppInterface, str, 0, z18)) {
                    return 0;
                }
                ei.a("Recent_clk_enterchat_pub", null);
                intent = z18;
                i17 = 0;
            } else if (i3 == 10014) {
                z18.putExtra("channel_type", bundle.getInt("channel_type", 1));
                z18.putExtra("guild_id", bundle.getString("guild_id"));
            }
            str3 = "Recent_clk_enterchat";
            str6 = null;
            str5 = str;
            S(i3, str2, str5);
            Intent intent3 = intent;
            intent3.putExtra("uin", str5);
            intent3.putExtra("uintype", i3);
            intent3.putExtra("uinname", str2);
            intent3.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 1);
            k0(intent3);
            if (z17) {
            }
            ei.a(str3, str6);
            return i17;
        }
        if (i3 == 1024 || CrmUtils.r(qQAppInterface, str)) {
            ei.a(null, "Recent_clk_enterchat_cmr");
            intent = z18;
            i16 = 0;
            str3 = "Recent_clk_enterchat";
            str4 = null;
            ReportController.o(qQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, str, "0", "", "");
            ei.a("Recent_clk_enterchat_cmr", null);
            str5 = str;
            z17 = z16;
            str6 = str4;
            i17 = i16;
            S(i3, str2, str5);
            Intent intent32 = intent;
            intent32.putExtra("uin", str5);
            intent32.putExtra("uintype", i3);
            intent32.putExtra("uinname", str2);
            intent32.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 1);
            k0(intent32);
            if (z17) {
                z0(context, intent32);
            } else {
                context.startActivity(intent32);
            }
            ei.a(str3, str6);
            return i17;
        }
        intent = z18;
        i16 = 0;
        str3 = "Recent_clk_enterchat";
        str4 = null;
        str5 = str;
        z17 = z16;
        str6 = str4;
        i17 = i16;
        S(i3, str2, str5);
        Intent intent322 = intent;
        intent322.putExtra("uin", str5);
        intent322.putExtra("uintype", i3);
        intent322.putExtra("uinname", str2);
        intent322.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 1);
        k0(intent322);
        if (z17) {
        }
        ei.a(str3, str6);
        return i17;
    }

    private static void u0(QQAppInterface qQAppInterface, Activity activity, RecentUser recentUser) {
        ((IZPlanPublicAccountLauncherApi) QRoute.api(IZPlanPublicAccountLauncherApi.class)).launchSmallHomeMainPageFromPublicAccount(qQAppInterface, activity, "RecentUtil");
        c(qQAppInterface, recentUser, true, true);
    }

    private static boolean v(Context context, QQAppInterface qQAppInterface, String str, int i3, Intent intent) {
        int i16;
        int i17;
        boolean z16;
        IQQHealthService iQQHealthService;
        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) ((IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfoCache(String.valueOf(str));
        if (publicAccountInfo != null) {
            i16 = publicAccountInfo.extendType;
        } else {
            i16 = 0;
        }
        if (i16 == 2) {
            ReportController.o(qQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, str, "0", "", "");
            intent.putExtra("chat_subType", 1);
        } else {
            Message lastMessage = qQAppInterface.getMessageFacade().getLastMessage(str, 1008);
            if (lastMessage != null) {
                i17 = qQAppInterface.getConversationFacade().R(str, lastMessage.istroop);
            } else {
                i17 = 0;
            }
            E0(qQAppInterface, str, lastMessage, i17);
            IQQNewsCommApi iQQNewsCommApi = (IQQNewsCommApi) QRoute.api(IQQNewsCommApi.class);
            if (iQQNewsCommApi.isQQNewsPa(str) && iQQNewsCommApi.startQQNewsPA(context)) {
                return true;
            }
            IWeatherCommApi iWeatherCommApi = (IWeatherCommApi) QRoute.api(IWeatherCommApi.class);
            if (iWeatherCommApi.isWeatherPA(str) && iWeatherCommApi.startNewWeatherWebPageActivity(context, qQAppInterface)) {
                return true;
            }
            if (((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isNeedRedirectAIOToMainPage(str) && (iQQHealthService = (IQQHealthService) qQAppInterface.getRuntimeService(IQQHealthService.class)) != null && iQQHealthService.redirectAIOToMainPage(context, 161)) {
                return true;
            }
            intent.putExtra("shouldreport", true);
            if (context instanceof SplashActivity) {
                intent.putExtra("start_time", System.currentTimeMillis());
                intent.putExtra("red_hot_count", i17);
            }
            if (i17 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            intent.putExtra("has_unread_msg", z16);
            intent.putExtra("jump_from", 1);
            com.tencent.biz.pubaccount.util.k.a(null, "SUBSCRIPT_AIO_COST");
        }
        intent.setClass(context, ChatActivity.class);
        return false;
    }

    public static void v0(Activity activity, long j3) {
        w0(activity, j3, 0);
    }

    private static boolean w(Context context, QQAppInterface qQAppInterface, String str, int i3, Intent intent) {
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null) {
            TroopInfo l3 = troopManager.l(str + "", true);
            if (l3 != null && l3.troopuin != null) {
                if (l3.isUnreadableBlock() && (context instanceof QBaseActivity)) {
                    com.tencent.mobileqq.troop.blocktroop.k.F((Activity) context, qQAppInterface, str, null);
                    return true;
                }
                intent.putExtra("troop_uin", l3.troopuin);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.e("RecentUtil", 2, "when enter troop AIO, troop is not exist!!");
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.svq), 0).show();
                }
                return true;
            }
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
        return false;
    }

    public static void w0(Activity activity, long j3, int i3) {
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportClickMsgBoxEntry883(j3);
        Bundle bundle = new Bundle();
        bundle.putInt("tab_index", i3);
        e0(activity, bundle);
    }

    public static void x(Context context, String str, String str2, int i3, String str3, boolean z16, Bundle bundle, Intent[] intentArr) {
        Intent m3;
        long j3;
        if (context != null) {
            if (f185176a) {
                if (R(context, str, str2, i3, str3, bundle)) {
                    return;
                }
                m3 = new Intent(context, (Class<?>) ChatActivity.class);
                MessageRecord messageRecord = f185177b;
                if (messageRecord != null) {
                    int i16 = messageRecord.istroop;
                    if (i16 != 1 && i16 != 3000) {
                        j3 = messageRecord.time;
                    } else {
                        j3 = messageRecord.shmsgseq;
                    }
                    m3.putExtra(AppConstants.Key.KEY_SEARCHED_TIMEORSEQ, j3);
                }
            } else {
                m3 = BaseAIOUtils.m(E(context), new int[]{1});
            }
            if (intentArr != null && intentArr.length != 0) {
                intentArr[0] = m3;
            }
            if (bundle != null && bundle.getBoolean(AppConstants.Key.KEY_ENTER_FROM_TEMP_MSG_BOX, false)) {
                m3.putExtras(bundle);
            }
            m3.putExtra("uin", str);
            m3.putExtra("troop_uin", str2);
            m3.putExtra("key_groupUin", NumberUtil.stringToLong(str2, 0L));
            m3.putExtra("uintype", i3);
            m3.putExtra("uinname", str3);
            k0(m3);
            if (z16) {
                if (context instanceof SplashActivity) {
                    z0(context, m3);
                    return;
                }
                return;
            }
            context.startActivity(m3);
        }
    }

    public static int x0(Activity activity, QQAppInterface qQAppInterface, RecentUser recentUser, String str, boolean z16, int i3, RecentBaseData recentBaseData) {
        return y0(activity, qQAppInterface, recentUser, str, z16, i3, recentBaseData, null, null);
    }

    private static void y(QQAppInterface qQAppInterface, RecentUser recentUser) {
        int type = recentUser.getType();
        String str = recentUser.uin;
        if (type != 1033 && type != 1034) {
            com.tencent.mobileqq.statistics.d.a(1, 1, type, qQAppInterface.getConversationFacade().R(str, type));
        }
    }

    public static int y0(Activity activity, QQAppInterface qQAppInterface, RecentUser recentUser, String str, boolean z16, int i3, RecentBaseData recentBaseData, Bundle bundle, Intent[] intentArr) {
        String str2;
        boolean z17;
        int i16 = 0;
        if (P(activity, qQAppInterface, recentUser)) {
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "onRecentUserClick|[" + recentUser + "," + activity + "," + qQAppInterface + "]");
            }
            return 0;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "onRecentUserClick|[" + recentUser.uin + "," + recentUser.getType() + "]");
        }
        if (i3 != 0 && i3 != 2) {
            str2 = str;
            z17 = false;
        } else {
            str2 = str;
            z17 = true;
        }
        C0(qQAppInterface, recentUser, str2, i3, recentBaseData);
        if (!G(activity, qQAppInterface, recentUser, i3, recentBaseData) && recentUser.getType() != 8999) {
            if (recentUser.getType() == 7000) {
                L(activity, qQAppInterface, recentUser, recentBaseData);
            } else if (Q(recentUser.getType())) {
                i16 = M(activity, qQAppInterface, recentUser, str, z16, 0, z17, bundle, intentArr);
            } else if (recentUser.getType() != 1005 && recentUser.getType() != 1023) {
                if (recentUser.getType() == 1024) {
                    i16 = 0 | u(activity, qQAppInterface, recentUser.uin, recentUser.getType(), str, z17, A(bundle), intentArr);
                } else if (recentUser.getType() == 6004) {
                    N(activity, qQAppInterface, recentUser);
                } else if (recentUser.getType() == 8114) {
                    LoginUserGuideHelper.f(activity, qQAppInterface);
                    ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009F4C", "0X8009F4C", 0, 0, "", "", "", "");
                } else if (recentBaseData != null && recentBaseData.getRecentUserType() == 10007) {
                    MessageRecord lastGameMsg = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getLastGameMsg(qQAppInterface, recentBaseData.getRecentUserUin());
                    if (lastGameMsg != null) {
                        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(activity, recentBaseData.getRecentUserUin(), com.tencent.mobileqq.gamecenter.util.c.c(lastGameMsg), com.tencent.mobileqq.gamecenter.util.c.d(lastGameMsg), 5);
                    }
                } else if (recentUser.getType() == 10014) {
                    H(activity, qQAppInterface, recentUser, str, z17, bundle, intentArr);
                } else if (recentUser.getType() == 1008 && TextUtils.equals(recentUser.uin, AppConstants.VALUE.UIN_GUILD_OFFICIAL_ACCOUNT)) {
                    ((IGuildPublicToDetailFullLinkReportApi) QRoute.api(IGuildPublicToDetailFullLinkReportApi.class)).start(System.currentTimeMillis());
                    ((IGuildPublicToDetailFullLinkReportApi) QRoute.api(IGuildPublicToDetailFullLinkReportApi.class)).logMethod("RecentAdapter#onRecentBaseDataClick", System.currentTimeMillis(), true);
                    I(activity, qQAppInterface, recentUser, recentBaseData);
                } else {
                    if (J(qQAppInterface, recentUser)) {
                        return 4;
                    }
                    i16 = K(qQAppInterface, recentUser, z16, 0) | u(activity, qQAppInterface, recentUser.uin, recentUser.getType(), str, z17, bundle, intentArr);
                }
            } else {
                if (b(qQAppInterface, recentUser.uin)) {
                    recentUser.setType(0);
                    if (z16) {
                        i16 = 2;
                    }
                }
                i16 |= u(activity, qQAppInterface, recentUser.uin, recentUser.getType(), str, z17, A(bundle), intentArr);
            }
        }
        F0(qQAppInterface, recentUser, recentBaseData);
        return i16;
    }

    @NotNull
    private static Intent z(Context context, Bundle bundle, Intent intent) {
        String str;
        long j3;
        if (f185176a) {
            intent.setClassName(context, ChatActivity.class.getName());
            MessageRecord messageRecord = f185177b;
            if (messageRecord != null) {
                int i3 = messageRecord.istroop;
                if (i3 != 1 && i3 != 3000) {
                    j3 = messageRecord.time;
                } else {
                    j3 = messageRecord.shmsgseq;
                }
                intent.putExtra(AppConstants.Key.KEY_SEARCHED_TIMEORSEQ, j3);
            } else {
                long j16 = f185178c;
                if (j16 != 0) {
                    intent.putExtra(AppConstants.Key.KEY_SEARCHED_TIMEORSEQ, j16);
                }
            }
        } else {
            if (bundle != null) {
                str = bundle.getString("KEY_OPEN_AIO_INTENT_CLASS_NAME");
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                str = SplashActivity.getAliasName();
            }
            if (context instanceof PublicFragmentActivity) {
                PublicBaseFragment G2 = ((PublicFragmentActivity) context).G2();
                if ((G2 instanceof TempMsgBoxFragment) || (G2 instanceof FilterMsgBoxFragment)) {
                    str = ChatActivity.class.getName();
                }
            }
            intent.setClassName(context, str);
            intent = BaseAIOUtils.m(intent, new int[]{1});
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    public static void z0(Context context, Intent intent) {
        if (context instanceof SplashActivity) {
            SplashActivity splashActivity = (SplashActivity) context;
            intent.putExtra("isFromMainTab", true);
            intent.putExtra("isBack2Root", true);
            splashActivity.setIntent(intent);
            if (QLog.isColorLevel()) {
                QLog.i("Q.aio.SpalshActivity", 2, "mainTabToAio-->openAioFragment");
            }
            splashActivity.openAIO(false, 1);
            return;
        }
        if (intent.getBooleanExtra("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM", false)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.aio.SpalshActivity", 2, "start->SpalshActivity-->AIO");
        }
        context.startActivity(intent);
    }

    public static void J0(QQAppInterface qQAppInterface) {
    }

    private static void n(QQAppInterface qQAppInterface) {
    }

    private static void h(QQAppInterface qQAppInterface, boolean z16) {
    }

    private static void p0(QQAppInterface qQAppInterface, Activity activity) {
    }
}
