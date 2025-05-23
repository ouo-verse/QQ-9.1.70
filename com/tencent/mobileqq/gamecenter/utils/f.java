package com.tencent.mobileqq.gamecenter.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.data.GameDelSessionDataHelper;
import com.tencent.mobileqq.gamecenter.data.n;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.msginfo.GameUserInfo;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$GetPartnerDialogRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$PartnerDialog;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static String f213434a = "GameCenterMsg.GameMsgUtil";

    /* renamed from: b, reason: collision with root package name */
    private static int f213435b = -1;

    public static long A(String str) {
        return BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).getLong(IGameMsgHelperApi.SP_KEY_LAST_GAME_SESSION_CLICKED + str, 0L);
    }

    public static long B(AppInterface appInterface) {
        return appInterface.getApplication().getSharedPreferences("game_center_sp", 0).getLong(IGameMsgHelperApi.SP_KEY_TOP_TIME + appInterface.getCurrentAccountUin(), 0L);
    }

    @Deprecated
    public static CharSequence C(AppInterface appInterface, RecentBaseData recentBaseData, CharSequence charSequence) {
        if (appInterface != null && recentBaseData != null) {
            try {
                IMessageFacade iMessageFacade = (IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "");
                if (iMessageFacade == null) {
                    return null;
                }
                return D(appInterface, iMessageFacade.getLastMessage(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType()), charSequence);
            } catch (Throwable unused) {
            }
        }
        return charSequence;
    }

    public static String D(AppInterface appInterface, MessageRecord messageRecord, CharSequence charSequence) {
        String str = ((Object) charSequence) + "";
        if (appInterface == null) {
            return str;
        }
        MessageRecord z16 = z(appInterface, messageRecord.frienduin);
        if (z16 == null) {
            return str;
        }
        String d16 = com.tencent.mobileqq.gamecenter.util.c.d(z16);
        if (TextUtils.isEmpty(d16)) {
            return str;
        }
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "");
        if (iGameMsgManagerService == null) {
            return str;
        }
        gd1.a singleGameDetail = iGameMsgManagerService.getSingleGameDetail(d16);
        if (singleGameDetail == null) {
            return str;
        }
        GameSwitchConfig findGameSwitchConfig = iGameMsgManagerService.findGameSwitchConfig(singleGameDetail.f401939c);
        if (findGameSwitchConfig != null && findGameSwitchConfig.mSyncSwitch != 1) {
            return appInterface.getApplication().getString(R.string.f13754075) + singleGameDetail.f401947k;
        }
        return str;
    }

    public static String E(AppInterface appInterface, RecentContactInfo recentContactInfo, CharSequence charSequence) {
        String str = ((Object) charSequence) + "";
        if (appInterface == null) {
            return str;
        }
        if (recentContactInfo == null) {
            return str;
        }
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "");
        if (iGameMsgManagerService == null) {
            return str;
        }
        TempChatGameSession gameSessionFromContact = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromContact(recentContactInfo);
        if (gameSessionFromContact == null) {
            return str;
        }
        gd1.a singleGameDetail = iGameMsgManagerService.getSingleGameDetail(gameSessionFromContact.getSelfRoleId());
        if (singleGameDetail == null) {
            return str;
        }
        GameSwitchConfig findGameSwitchConfig = iGameMsgManagerService.findGameSwitchConfig(singleGameDetail.f401939c);
        if (findGameSwitchConfig != null && findGameSwitchConfig.mSyncSwitch != 1) {
            return appInterface.getApplication().getString(R.string.f13754075) + singleGameDetail.f401947k;
        }
        return str;
    }

    private static n F(SgamePartnerSvr$PartnerDialog sgamePartnerSvr$PartnerDialog) {
        n nVar = new n();
        nVar.r(sgamePartnerSvr$PartnerDialog.from_openaio_id.get());
        nVar.y(sgamePartnerSvr$PartnerDialog.to_openaio_id.get());
        nVar.s(sgamePartnerSvr$PartnerDialog.from_role_id.get());
        nVar.z(sgamePartnerSvr$PartnerDialog.to_role_id.get());
        nVar.t(sgamePartnerSvr$PartnerDialog.appid.get());
        nVar.x(sgamePartnerSvr$PartnerDialog.to_online_state.get());
        nVar.v(sgamePartnerSvr$PartnerDialog.to_nick.get());
        nVar.q(sgamePartnerSvr$PartnerDialog.to_icon_url.get());
        nVar.w(sgamePartnerSvr$PartnerDialog.status.get());
        nVar.u(sgamePartnerSvr$PartnerDialog.last_msg_time.get());
        return nVar;
    }

    public static Drawable G(AppInterface appInterface, String str) {
        try {
            Drawable drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.f160830com);
            URLDrawable x16 = x(BaseApplication.getContext(), appInterface, ((IGameMsgManagerService) l().getRuntimeService(IGameMsgManagerService.class, "")).getSessionInfoByUin(str).v());
            if (x16 != null) {
                return x16;
            }
            return drawable;
        } catch (Throwable th5) {
            QLog.e(f213434a, 1, th5.getMessage());
            return BaseApplication.getContext().getResources().getDrawable(R.drawable.f160830com);
        }
    }

    public static long H(String str, String str2) {
        return BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).getLong(str2 + str, 0L);
    }

    public static String I(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5) - 1, 0, 0, 0);
        long time = calendar.getTime().getTime();
        long j16 = time - 518400000;
        long j17 = time - 2505600000L;
        if (P(j3)) {
            return new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR).format(new Date(j3));
        }
        if (j3 > time) {
            return "\u6628\u5929";
        }
        if (j3 > j16) {
            return "\u4e24\u5929\u524d";
        }
        if (j3 > j17) {
            return "\u4e00\u5468\u524d";
        }
        return "\u4e00\u6708\u524d";
    }

    public static String J(int i3) {
        if (i3 > 99) {
            return "99+";
        }
        return i3 + "";
    }

    public static boolean K(AppInterface appInterface, Message message, int i3, MsgSummary msgSummary) {
        IGameMsgManagerService iGameMsgManagerService;
        GameCenterSessionInfo sessionInfoByUin;
        if (appInterface == null || message == null || msgSummary == null || i3 != 10007 || (iGameMsgManagerService = (IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")) == null || (sessionInfoByUin = iGameMsgManagerService.getSessionInfoByUin(message.frienduin)) == null) {
            return false;
        }
        gd1.a singleGameDetail = iGameMsgManagerService.getSingleGameDetail(sessionInfoByUin.r());
        if (singleGameDetail != null) {
            msgSummary.prefixOfContent = "[" + singleGameDetail.f401947k + "]";
            return true;
        }
        return true;
    }

    public static boolean L(AppInterface appInterface, int i3) {
        if (i3 == 10007 && !((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).isGameMsgShowInBoxFormTabConfig()) {
            return true;
        }
        return false;
    }

    public static boolean M(AppInterface appInterface) {
        if (appInterface == null) {
            return false;
        }
        IPublicAccountDetail findAccountDetailInfo = ((IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findAccountDetailInfo("2747277822");
        if (findAccountDetailInfo == null) {
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).sendDetailInfoRequest(appInterface, appInterface.getApplication(), "2747277822");
            return false;
        }
        if (findAccountDetailInfo.getFollowType() != 1) {
            return false;
        }
        return true;
    }

    public static boolean N(AppInterface appInterface, String str) {
        IGameMsgManagerService iGameMsgManagerService;
        TempChatGameSession gameSessionFromPeerUid;
        if (l() == null || (iGameMsgManagerService = (IGameMsgManagerService) l().getRuntimeService(IGameMsgManagerService.class, "")) == null || (gameSessionFromPeerUid = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromPeerUid(iGameMsgManagerService.getSessionInfoByUin(str).t())) == null || gameSessionFromPeerUid.getRedPointSwitch().intValue() != 1) {
            return false;
        }
        return true;
    }

    private static boolean O(long j3, String str) {
        Date date = new Date(j3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        if (simpleDateFormat.format(date).equals(simpleDateFormat.format(new Date()))) {
            return true;
        }
        return false;
    }

    public static boolean P(long j3) {
        return O(j3, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WadlReportBuilder.TableElem.SQ_VERSION, AppSetting.f99551k);
            jSONObject.put("device_type", Build.BRAND);
            jSONObject.put("domain", "1");
            jSONObject.put(WadlReportBuilder.TableElem.GAME_APPID, str);
            jSONObject.put("ext12", str2);
            jSONObject.put("ext11", str3);
            jSONObject.put("ext1", str4);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_MOUDLE, str5);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_ID, str6);
            jSONObject.put("ext2", str7);
            jSONObject.put("ext3", str8);
            jSONObject.put("ext4", str9);
            jSONObject.put("ext6", str10);
            jSONObject.put("ext7", str11);
            jSONObject.put("ext8", str12);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", jSONObject);
            jSONObject2.put(WadlReportBuilder.KEY_DC_ID, WadlProxyConsts.TAG_DC_00087);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(WadlReportBuilder.KEY_REPORT_LIST, jSONArray);
            ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).report(jSONObject3, 0);
        } catch (Exception e16) {
            QLog.e(f213434a, 1, e16.getMessage());
        }
    }

    public static void S(Context context, GameCenterSessionInfo gameCenterSessionInfo, String str) {
        IGameMsgManagerService iGameMsgManagerService;
        if (context == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f213434a, 2, "[openGameMsgSessionPage],from:" + str);
        }
        AppInterface n3 = n();
        if (n3 == null || T(context, str) || (iGameMsgManagerService = (IGameMsgManagerService) n3.getRuntimeService(IGameMsgManagerService.class, "")) == null) {
            return;
        }
        String gameMsgListUrl = iGameMsgManagerService.getGameMsgListUrl();
        if (gameCenterSessionInfo != null && gameCenterSessionInfo.x() == 0) {
            gameMsgListUrl = gameMsgListUrl + "&&gameId=" + gameCenterSessionInfo.m() + "&gameName=" + gameCenterSessionInfo.n() + "&sessionId=" + gameCenterSessionInfo.w() + "&requestCount=" + gameCenterSessionInfo.u();
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_GAME_CENTER_ACTIVITY);
        activityURIRequest.extra().putString("url", gameMsgListUrl);
        activityURIRequest.extra().putString("big_brother_source_key", "biz_src_zf_games");
        activityURIRequest.extra().putInt(AppConstants.Key.KEY_GAME_MSG_OPEN_AIO_FROM, 2);
        activityURIRequest.extra().putLong("startOpenPageTime", System.currentTimeMillis());
        activityURIRequest.setFlags(268435456);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    public static boolean T(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (!((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getHippySwitch()) {
            QLog.e(f213434a, 1, "hippy switch is off, ail to open by hippy");
            return false;
        }
        try {
            QLog.i(f213434a, 1, "openGameMsgSessionPageByHippy runs.");
            ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).openQQGameCenterByHippy(context, IGameMsgHelperApi.HIPPY_URL + str, str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void U(Context context, GameCenterSessionInfo gameCenterSessionInfo, String str, String str2) {
        if (context == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f213434a, 2, "[openGameMsgSessionPageFromToolProcess],from:" + str);
        }
        if (T(context, str)) {
            return;
        }
        if (gameCenterSessionInfo != null && gameCenterSessionInfo.x() == 0) {
            str2 = str2 + "&&gameId=" + gameCenterSessionInfo.m() + "&gameName=" + gameCenterSessionInfo.n() + "&sessionId=" + gameCenterSessionInfo.w() + "&requestCount=" + gameCenterSessionInfo.u();
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_GAME_CENTER_ACTIVITY);
        activityURIRequest.extra().putString("url", str2);
        activityURIRequest.extra().putString("big_brother_source_key", "biz_src_zf_games");
        activityURIRequest.extra().putInt(AppConstants.Key.KEY_GAME_MSG_OPEN_AIO_FROM, 2);
        activityURIRequest.extra().putLong("startOpenPageTime", System.currentTimeMillis());
        activityURIRequest.setFlags(268435456);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    public static void V(Context context, String str) {
        IGameMsgManagerService iGameMsgManagerService;
        if (context == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f213434a, 2, "[openGameMsgSettingPage],from:" + str);
        }
        AppInterface n3 = n();
        if (n3 == null || (iGameMsgManagerService = (IGameMsgManagerService) n3.getRuntimeService(IGameMsgManagerService.class, "")) == null) {
            return;
        }
        String gameMsgSettingUrl = iGameMsgManagerService.getGameMsgSettingUrl();
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_GAME_CENTER_ACTIVITY);
        activityURIRequest.extra().putString("url", gameMsgSettingUrl);
        activityURIRequest.extra().putString("big_brother_source_key", "biz_src_zf_games");
        activityURIRequest.extra().putLong("startOpenPageTime", System.currentTimeMillis());
        activityURIRequest.setFlags(268435456);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    public static List<n> W(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            SgamePartnerSvr$GetPartnerDialogRsp sgamePartnerSvr$GetPartnerDialogRsp = new SgamePartnerSvr$GetPartnerDialogRsp();
            sgamePartnerSvr$GetPartnerDialogRsp.mergeFrom(bArr);
            PBRepeatMessageField<SgamePartnerSvr$PartnerDialog> pBRepeatMessageField = sgamePartnerSvr$GetPartnerDialogRsp.dialog_list;
            if (pBRepeatMessageField != null && pBRepeatMessageField.get() != null) {
                List<SgamePartnerSvr$PartnerDialog> list = sgamePartnerSvr$GetPartnerDialogRsp.dialog_list.get();
                QLog.i(f213434a, 1, "[parsePartnerSessionsFromBytes] session list size:" + list.size());
                for (int i3 = 0; i3 < list.size(); i3++) {
                    SgamePartnerSvr$PartnerDialog sgamePartnerSvr$PartnerDialog = list.get(i3);
                    if (sgamePartnerSvr$PartnerDialog != null) {
                        arrayList.add(F(sgamePartnerSvr$PartnerDialog));
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e(f213434a, 1, e16.getMessage());
        }
        return arrayList;
    }

    public static void X(int i3, int i16) {
        String y16 = y(i3);
        ReportController.o(null, "dc00898", "", "", y16, y16, i16, 0, "", "", "", "");
    }

    @Deprecated
    public static void Y(AppInterface appInterface, String str, int i3, int i16) {
        String str2;
        String str3;
        String str4;
        if (appInterface == null) {
            return;
        }
        String y16 = y(i3);
        try {
            IMessageFacade iMessageFacade = (IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "");
            if (iMessageFacade == null) {
                return;
            }
            Message lastMessage = iMessageFacade.getLastMessage(str, 10007);
            if (QLog.isColorLevel()) {
                QLog.d(f213434a, 2, "report called with: key = [" + y16 + "], from = [" + i3 + "], fromType = [" + i16 + "]");
            }
            if (lastMessage == null) {
                QLog.d(f213434a, 1, "report called with: conversationInfo null. key = [" + y16 + "], from = [" + i3 + "], fromType = [" + i16 + "]");
                return;
            }
            str2 = y16;
            str3 = "]";
            str4 = "], fromType = [";
            try {
                ReportController.o(null, "dc00898", "", "", y16, y16, i16, 0, m(lastMessage) + "", "", "", "");
            } catch (Exception e16) {
                e = e16;
                QLog.e(f213434a, 1, "report called with:  key = [" + str2 + str4 + i3 + str4 + i16 + str3, e);
            }
        } catch (Exception e17) {
            e = e17;
            str2 = y16;
            str3 = "]";
            str4 = "], fromType = [";
        }
    }

    public static void Z(String str, String str2, String str3, String str4, String str5, String str6, String str7, HashMap<String, String> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WadlReportBuilder.TableElem.SQ_VERSION, AppSetting.f99551k);
            jSONObject.put("device_type", Build.BRAND);
            jSONObject.put("domain", "1");
            jSONObject.put(WadlReportBuilder.TableElem.GAME_APPID, str);
            jSONObject.put("ext12", str3);
            jSONObject.put("ext11", str2);
            jSONObject.put("ext1", str5);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_MOUDLE, str4);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_ID, str6);
            jSONObject.put("logic_id", str7);
            if (hashMap != null && hashMap.size() > 0) {
                for (String str8 : hashMap.keySet()) {
                    jSONObject.put(str8, hashMap.get(str8));
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", jSONObject);
            jSONObject2.put(WadlReportBuilder.KEY_DC_ID, WadlProxyConsts.TAG_DC_00087);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(WadlReportBuilder.KEY_REPORT_LIST, jSONArray);
            ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).report(jSONObject3, 0);
        } catch (Exception e16) {
            QLog.e(f213434a, 1, e16.getMessage());
        }
    }

    public static void a0(long j3) {
        TempChatGameSession gameSessionFromContact;
        String str;
        IGameMsgNtApi iGameMsgNtApi = (IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class);
        List<RecentContactInfo> gameRecentContactList = iGameMsgNtApi.getGameRecentContactList();
        if (!gameRecentContactList.isEmpty() && (gameSessionFromContact = iGameMsgNtApi.getGameSessionFromContact(gameRecentContactList.get(0))) != null) {
            if (j3 > 0) {
                str = "0";
            } else {
                str = "1";
            }
            c0(gameSessionFromContact.getGameAppId() + "", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92003", "209056", "", "", "20", str);
        }
    }

    public static void b0(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<Integer, String> map) {
        if (QLog.isColorLevel()) {
            QLog.i(f213434a, 2, "reportDC00087New: operId=" + str + ",adId= " + str7 + ",extsMap=" + map);
        }
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(str5).setOperId(str).setExt(1, str6).setExt(4, str2).setExt(11, str3).setExt(12, str4).setExt(41, str7);
        if (map != null && map.keySet().size() > 0) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                wadlReportBuilder.setExt(entry.getKey().intValue(), entry.getValue());
            }
        }
        wadlReportBuilder.report();
    }

    public static void c0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        d0(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, "", "");
    }

    public static void d0(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, final String str12) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.gamecenter.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                f.Q(str, str3, str2, str5, str4, str6, str7, str8, str9, str10, str11, str12);
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(runnable, 16, null, false);
        } else {
            runnable.run();
        }
    }

    @Deprecated
    public static boolean e(MessageRecord messageRecord) {
        boolean z16;
        if (messageRecord != null && (!TextUtils.isEmpty(messageRecord.f203106msg) || messageRecord.time != 0)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f213434a, 2, "[checkMesssageIsValid] ret = " + z16);
        }
        return z16;
    }

    public static void e0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        f0(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, "");
    }

    public static void f(String str) {
        GameDelSessionDataHelper.g(str);
    }

    public static void f0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        g0(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, "", str11, str12, str13, str14);
    }

    @Deprecated
    public static void g(Context context, String str, String str2, String str3, int i3) {
        ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).enterGameMsgAio(context, str, i3);
    }

    public static void g0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WadlReportBuilder.TableElem.SQ_VERSION, AppSetting.f99551k);
            jSONObject.put("device_type", Build.BRAND);
            jSONObject.put("domain", "1");
            jSONObject.put(WadlReportBuilder.TableElem.GAME_APPID, str);
            jSONObject.put("ext12", str3);
            jSONObject.put("ext11", str2);
            jSONObject.put("ext1", str5);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_MOUDLE, str4);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_ID, str6);
            jSONObject.put("logic_id", str7);
            jSONObject.put("ext2", str8);
            jSONObject.put("ext3", str9);
            jSONObject.put("ext4", str10);
            jSONObject.put("ext5", str11);
            jSONObject.put("ext6", str12);
            jSONObject.put("ext10", str13);
            jSONObject.put("ext11", str14);
            jSONObject.put("ext24", str15);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", jSONObject);
            jSONObject2.put(WadlReportBuilder.KEY_DC_ID, WadlProxyConsts.TAG_DC_00087);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(WadlReportBuilder.KEY_REPORT_LIST, jSONArray);
            ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).report(jSONObject3, 0);
        } catch (Exception e16) {
            QLog.e(f213434a, 1, e16.getMessage());
        }
    }

    public static void h(AppInterface appInterface, Context context, String str) {
        ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).enterGameMsgAio(context, str);
    }

    public static void h0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WadlReportBuilder.TableElem.SQ_VERSION, AppSetting.f99551k);
            jSONObject.put("device_type", Build.BRAND);
            jSONObject.put("domain", "1");
            jSONObject.put(WadlReportBuilder.TableElem.GAME_APPID, str);
            jSONObject.put("ext12", str3);
            jSONObject.put("ext11", str2);
            jSONObject.put("ext1", str5);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_MOUDLE, str4);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_ID, str6);
            jSONObject.put("ext2", str8);
            jSONObject.put("ext4", str7);
            jSONObject.put("ext6", str9);
            jSONObject.put("ext8", str10);
            jSONObject.put(WadlReportBuilder.TableElem.TIANJI_REPORT_STR, str11);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", jSONObject);
            jSONObject2.put(WadlReportBuilder.KEY_DC_ID, WadlProxyConsts.TAG_DC_00087);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(WadlReportBuilder.KEY_REPORT_LIST, jSONArray);
            ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).report(jSONObject3, 0);
        } catch (Exception e16) {
            QLog.e(f213434a, 1, e16.getMessage());
        }
    }

    public static void i(AppInterface appInterface, Context context, String str, int i3) {
        ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).enterGameMsgAio(context, str, i3);
    }

    public static void i0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WadlReportBuilder.TableElem.SQ_VERSION, AppSetting.f99551k);
            jSONObject.put("device_type", Build.BRAND);
            jSONObject.put("domain", "1");
            jSONObject.put(WadlReportBuilder.TableElem.GAME_APPID, str);
            jSONObject.put("ext12", str3);
            jSONObject.put("ext11", str2);
            jSONObject.put("ext1", str5);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_MOUDLE, str4);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_ID, str6);
            jSONObject.put("ext2", str7);
            jSONObject.put("ext3", str8);
            jSONObject.put("ext4", str9);
            jSONObject.put("ext6", str10);
            jSONObject.put("ext7", str11);
            jSONObject.put("ext8", str12);
            jSONObject.put(WadlReportBuilder.TableElem.TIANJI_REPORT_STR, str13);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", jSONObject);
            jSONObject2.put(WadlReportBuilder.KEY_DC_ID, WadlProxyConsts.TAG_DC_00087);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(WadlReportBuilder.KEY_REPORT_LIST, jSONArray);
            ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).report(jSONObject3, 0);
        } catch (Exception e16) {
            QLog.e(f213434a, 1, e16.getMessage());
        }
    }

    @Deprecated
    private static MessageRecord j(List<MessageRecord> list) {
        if (list != null && list.size() != 0) {
            for (int size = list.size() - 1; size >= 0; size--) {
                MessageRecord messageRecord = list.get(size);
                int i3 = messageRecord.msgtype;
                if (i3 == -1000 || i3 == -2000 || i3 == -2001) {
                    return messageRecord;
                }
            }
        }
        return null;
    }

    public static void j0(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.utils.e
            @Override // java.lang.Runnable
            public final void run() {
                f.d0(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, "", "");
            }
        }, 16, null, false);
    }

    public static boolean k(String str) {
        return BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).getBoolean(IGameMsgHelperApi.SP_KEY_AIO_GAME_ENTRY_SHOWN + str, false);
    }

    public static void k0(String str, boolean z16) {
        BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).edit().putBoolean(IGameMsgHelperApi.SP_KEY_AIO_GAME_ENTRY_SHOWN + str, z16).commit();
    }

    public static AppRuntime l() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    public static void l0(AppInterface appInterface, int i3) {
        f213435b = i3;
        BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).edit().putInt(IGameMsgHelperApi.SP_KEY_GAME_MSG_UNREAD_COUNT + appInterface.getCurrentAccountUin(), i3).commit();
    }

    @Deprecated
    public static long m(MessageRecord messageRecord) {
        try {
            TinyInfo tinyInfo = new TinyInfo();
            tinyInfo.parseFromMessageRecord(messageRecord);
            return tinyInfo.gameAppId;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static void m0(String str, boolean z16) {
        BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).edit().putBoolean(IGameMsgHelperApi.SP_KEY_GAME_SESSION_SHOWN + str, z16).commit();
    }

    public static AppInterface n() {
        return (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static void n0(String str, long j3) {
        BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).edit().putLong(IGameMsgHelperApi.SP_KEY_CLEAN_TIME + str, j3).commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap o(AppInterface appInterface, GameUserInfo gameUserInfo) {
        URLDrawable uRLDrawable;
        if (appInterface != null && gameUserInfo != null) {
            Drawable drawable = appInterface.getApplication().getResources().getDrawable(R.drawable.icon);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            try {
                uRLDrawable = URLDrawable.getDrawable(new URL(gameUserInfo.mFaceUrl), obtain);
            } catch (MalformedURLException e16) {
                e = e16;
                uRLDrawable = null;
            }
            try {
                uRLDrawable.setTag(l.a(100, 100, 6));
                uRLDrawable.setDecodeHandler(l.f213444a);
            } catch (MalformedURLException e17) {
                e = e17;
                e.printStackTrace();
                if (uRLDrawable != null) {
                }
                return null;
            }
            if (uRLDrawable != null) {
                Drawable currDrawable = uRLDrawable.getCurrDrawable();
                if (QLog.isColorLevel()) {
                    QLog.d(f213434a, 2, "getGameRoleBitmap is called!.");
                }
                if (currDrawable instanceof BitmapDrawable) {
                    return ((BitmapDrawable) currDrawable).getBitmap();
                }
            }
        }
        return null;
    }

    public static void o0(String str, long j3) {
        BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).edit().putLong(IGameMsgHelperApi.SP_KEY_LAST_GAME_SESSION_CLICKED + str, j3).commit();
    }

    public static Drawable p(AppInterface appInterface, String str) {
        GameBoxRecentUser findGameBoxRecentUserInfo = ((IGameMsgBoxManager) appInterface.getRuntimeService(IGameMsgBoxManager.class, "")).findGameBoxRecentUserInfo(str);
        if (findGameBoxRecentUserInfo == null) {
            return G(appInterface, str);
        }
        return x(BaseApplication.getContext(), appInterface, findGameBoxRecentUserInfo.mToRoleId);
    }

    public static void p0(AppInterface appInterface, String str, long j3) {
        appInterface.getApplication().getSharedPreferences("game_center_sp", 0).edit().putLong(str + appInterface.getCurrentAccountUin(), j3).commit();
    }

    public static int q(AppInterface appInterface) {
        return BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).getInt(IGameMsgHelperApi.SP_KEY_GAME_MSG_UNREAD_COUNT + appInterface.getCurrentAccountUin(), -1);
    }

    public static void q0(Context context, String str, gd1.a aVar) {
        QLog.i(f213434a, 1, "[startGame]");
        if (QLog.isDevelopLevel()) {
            QLog.i(f213434a, 2, "url:" + str);
        }
        if (TextUtils.isEmpty(str) && aVar != null) {
            str = aVar.f401951o;
        }
        if (TextUtils.isEmpty(str) && aVar != null) {
            QLog.i(f213434a, 1, "appId:" + aVar.f401939c);
            str = GameBasicInfo.getDefaultGameLaunchUrl(aVar.f401939c);
        }
        if (!TextUtils.isEmpty(str)) {
            GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, str);
        }
    }

    public static Bitmap r(Message message, AppInterface appInterface) {
        Bitmap o16;
        boolean z16;
        if (appInterface == null) {
            return null;
        }
        String c16 = com.tencent.mobileqq.gamecenter.util.c.c(message);
        if (QLog.isColorLevel()) {
            String str = f213434a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[getGameRoleBitmap],roleId:");
            sb5.append(c16);
            sb5.append(" thread column = ");
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d(str, 2, sb5.toString());
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "");
        if (iGameMsgManagerService == null) {
            return null;
        }
        GameUserInfo findGameUserInfo = iGameMsgManagerService.findGameUserInfo(c16);
        if (findGameUserInfo != null && !TextUtils.isEmpty(findGameUserInfo.mFaceUrl)) {
            File file = AbsDownloader.getFile(findGameUserInfo.mFaceUrl);
            if (file != null && file.exists()) {
                o16 = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (QLog.isColorLevel()) {
                    QLog.d(f213434a, 2, "getGameRoleBitmap is called!.decode from file" + o16);
                }
            } else {
                o16 = o(appInterface, findGameUserInfo);
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (QLog.isColorLevel()) {
                QLog.d(f213434a, 2, "getGameRoleBitmap is called!. total cost = " + (elapsedRealtime2 - elapsedRealtime));
            }
            return o16;
        }
        QLog.w(f213434a, 1, "getGameRoleBitmap usrInfo or face url is null, roleId:" + c16);
        return null;
    }

    public static Bitmap s(RecentContactInfo recentContactInfo, AppInterface appInterface) {
        TempChatGameSession gameSessionFromContact;
        Bitmap o16;
        boolean z16;
        if (appInterface == null || recentContactInfo == null || (gameSessionFromContact = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromContact(recentContactInfo)) == null) {
            return null;
        }
        String peerRoleId = gameSessionFromContact.getPeerRoleId();
        if (QLog.isColorLevel()) {
            String str = f213434a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[getGameRoleBitmap],roleId:");
            sb5.append(peerRoleId);
            sb5.append(" thread column = ");
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d(str, 2, sb5.toString());
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "");
        if (iGameMsgManagerService == null) {
            return null;
        }
        GameUserInfo findGameUserInfo = iGameMsgManagerService.findGameUserInfo(peerRoleId);
        if (findGameUserInfo != null && !TextUtils.isEmpty(findGameUserInfo.mFaceUrl)) {
            File file = AbsDownloader.getFile(findGameUserInfo.mFaceUrl);
            if (file != null && file.exists()) {
                o16 = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (QLog.isColorLevel()) {
                    QLog.d(f213434a, 2, "getGameRoleBitmap is called!.decode from file" + o16);
                }
            } else {
                o16 = o(appInterface, findGameUserInfo);
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (QLog.isColorLevel()) {
                QLog.d(f213434a, 2, "getGameRoleBitmap is called!. total cost = " + (elapsedRealtime2 - elapsedRealtime));
            }
            return o16;
        }
        QLog.w(f213434a, 1, "getGameRoleBitmap usrInfo or face url is null, roleId:" + peerRoleId);
        return null;
    }

    public static String t(MessageRecord messageRecord, AppInterface appInterface) {
        if (messageRecord != null && appInterface != null) {
            String c16 = com.tencent.mobileqq.gamecenter.util.c.c(messageRecord);
            IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "");
            if (iGameMsgManagerService == null) {
                return null;
            }
            GameUserInfo findGameUserInfo = iGameMsgManagerService.findGameUserInfo(c16);
            if (findGameUserInfo != null && !TextUtils.isEmpty(findGameUserInfo.mNickInGame)) {
                return findGameUserInfo.mNickInGame;
            }
            TinyInfo tinyInfo = new TinyInfo(messageRecord.getExtInfoFromExtStr(TinyInfo.EXT_KEY_GAME_MSG_INFO));
            if (!TextUtils.isEmpty(tinyInfo.nickName)) {
                return tinyInfo.nickName;
            }
        }
        return BaseApplication.getContext().getResources().getString(R.string.f1374506w);
    }

    public static String u(RecentContactInfo recentContactInfo, AppInterface appInterface) {
        TempChatGameSession gameSessionFromContact;
        if (recentContactInfo != null && appInterface != null && (gameSessionFromContact = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromContact(recentContactInfo)) != null) {
            return ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).getFriendNickName(gameSessionFromContact);
        }
        return BaseApplication.getContext().getResources().getString(R.string.f1374506w);
    }

    public static String v(String str, AppInterface appInterface) {
        return ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).getFriendNickName(str);
    }

    public static boolean w(String str) {
        return BaseApplication.getContext().getSharedPreferences("game_center_sp", 0).getBoolean(IGameMsgHelperApi.SP_KEY_GAME_SESSION_SHOWN + str, true);
    }

    public static URLDrawable x(Context context, AppInterface appInterface, String str) {
        URLDrawable uRLDrawable = null;
        if (appInterface == null) {
            return null;
        }
        GameUserInfo findGameUserInfo = ((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).findGameUserInfo(str);
        if (findGameUserInfo == null) {
            QLog.w(f213434a, 1, "usrInfo is null, roleId:" + str);
            return null;
        }
        if (TextUtils.isEmpty(findGameUserInfo.mFaceUrl)) {
            QLog.w(f213434a, 1, "faceurl is null, roleId:" + str);
            return null;
        }
        Drawable drawable = context.getResources().getDrawable(R.drawable.f160830com);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mRequestWidth = c.d(60.0f, context.getResources());
        obtain.mRequestHeight = c.d(60.0f, context.getResources());
        try {
            URL url = new URL(findGameUserInfo.mFaceUrl);
            obtain.mMemoryCacheKeySuffix = "normal_mode";
            uRLDrawable = URLDrawable.getDrawable(url, obtain);
            uRLDrawable.setTag(l.a(100, 100, 6));
            uRLDrawable.setDecodeHandler(l.f213444a);
            return uRLDrawable;
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return uRLDrawable;
        }
    }

    public static String y(int i3) {
        switch (i3) {
            case 10001:
                return "0X800AD42";
            case 10002:
                return "0X800AD41";
            case 10003:
                return "0X800AD40";
            case 10004:
                return "0X800AD3F";
            case 10005:
                return "0X800AD3E";
            case 10006:
                return "0X800AD3D";
            default:
                return "";
        }
    }

    @Deprecated
    public static MessageRecord z(AppRuntime appRuntime, String str) {
        IMessageFacade iMessageFacade;
        if (appRuntime == null || TextUtils.isEmpty(str) || (iMessageFacade = (IMessageFacade) appRuntime.getRuntimeService(IMessageFacade.class, "")) == null) {
            return null;
        }
        return j(iMessageFacade.getMsgList(str, 10007));
    }
}
