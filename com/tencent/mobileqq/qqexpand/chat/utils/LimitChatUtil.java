package com.tencent.mobileqq.qqexpand.chat.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gdtad.aditem.GdtAdUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.ark.f;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.chat.LimitChatDamon;
import com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdHandler;
import com.tencent.mobileqq.qqexpand.network.d;
import com.tencent.mobileqq.qqexpand.network.e;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCardOnHeadIconClick;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig$GetOptionsReq;
import com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig$GetOptionsRsp;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;
import expand.common.AddMatchedRaletionReq;
import expand.common.MatchedInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes35.dex */
public class LimitChatUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Long f263530a = 5L;

    /* renamed from: b, reason: collision with root package name */
    public static final int f263531b = (f.f199484d - BaseChatItemLayout.f178049g0) - BaseChatItemLayout.f178050h0;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements d {
        b() {
        }

        @Override // com.tencent.mobileqq.qqexpand.network.d
        public void a(com.tencent.mobileqq.qqexpand.network.a aVar, com.tencent.mobileqq.qqexpand.network.b bVar) {
            QLog.i("LimitChatUtil", 1, "QQExpand.ExpandRelation.AddMatchedRaletion response code=" + bVar.c() + " msg=" + bVar.e());
        }
    }

    public static String A(String str, String str2) {
        StringBuilder sb5;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (Long.parseLong(str) < Long.parseLong(str2)) {
                sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append("_");
                sb5.append(str2);
            } else {
                sb5 = new StringBuilder();
                sb5.append(str2);
                sb5.append("_");
                sb5.append(str);
            }
            return sb5.toString();
        }
        return "";
    }

    private static byte[] B(Map<String, Object> map) {
        if (map == null) {
            QLog.w("LimitChatUtil", 2, "getSignature failed, urlParams is null!");
            return null;
        }
        Object obj = map.get(PreloadTRTCPlayerParams.KEY_SIG);
        if (obj == null || !obj.getClass().isArray()) {
            return null;
        }
        try {
            return (byte[]) map.get(PreloadTRTCPlayerParams.KEY_SIG);
        } catch (Throwable th5) {
            QLog.e("LimitChatUtil", 1, "getSignature failed!", th5);
            return null;
        }
    }

    public static void C(final MessageRecord messageRecord, AppInterface appInterface) {
        final QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil.2
            @Override // java.lang.Runnable
            public void run() {
                e eVar = (e) QQAppInterface.this.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
                if (eVar != null) {
                    eVar.d1(messageRecord);
                }
            }
        });
    }

    public static void D(final AppInterface appInterface, final String str, final int i3, final boolean z16, final Object obj) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil.3
            @Override // java.lang.Runnable
            public void run() {
                AppInterface appInterface2 = AppInterface.this;
                if (appInterface2 instanceof QQAppInterface) {
                    QQAppInterface qQAppInterface = (QQAppInterface) appInterface2;
                    LimitChatUtil.b(qQAppInterface, str, z16, i3, obj);
                    if (i3 == 1045) {
                        ExpandFriendData.setMatchSrc(qQAppInterface, str, 6);
                        return;
                    }
                    try {
                        int i16 = new JSONObject((String) obj).getJSONObject("infos").getJSONObject("match_src").getInt("id");
                        if (i16 != 0) {
                            ExpandFriendData.setMatchSrc(qQAppInterface, str, i16);
                        }
                        LimitChatUtil.d0(qQAppInterface, str, i3, i16);
                        return;
                    } catch (Exception e16) {
                        QLog.w("LimitChatUtil", 1, "handlePreLoadDataForArkMiniProfileCard get matchSource error" + e16);
                        return;
                    }
                }
                QLog.w("LimitChatUtil", 1, "app not instanceof QQAppInterface");
            }
        });
    }

    public static void E(AppInterface appInterface, String str, Object obj) {
        ExtendFriendCardOnHeadIconClick.W.put(str, (String) obj);
        ExtendFriendCardOnHeadIconClick.X.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static boolean H(BaseQQAppInterface baseQQAppInterface, String str) {
        return com.tencent.mobileqq.qqexpand.utils.b.f264085a.b(ExpandFriendData.getAdvertiseDate(baseQQAppInterface, str));
    }

    public static MessageForArkApp I(QQAppInterface qQAppInterface, String str, long j3, long j16, int i3, int i16, Object obj) {
        ArkAppMessage arkAppMessage = new ArkAppMessage();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("type", "normal");
            jSONObject.put("showSender", 0);
            jSONObject.put("hintWidth", f263531b);
            jSONObject.put("hintHeight", 96);
            try {
                jSONObject3.put(IExpandReportUtils.REPORT_KEY_MANAGER_TEST_PLAN, ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).getManageTestPlanParams(qQAppInterface));
                jSONObject4.put("matchUin", Long.parseLong(str));
                jSONObject4.put(LocalDataJsPlugin.NAME_SPACE, obj.toString());
                jSONObject4.put("defaultReportParams", jSONObject3.toString());
                jSONObject2.put(TtmlNode.TAG_METADATA, jSONObject4);
            } catch (Exception e16) {
                e = e16;
                QLog.e("LimitChatUtil", 1, "ArkMiniProfileCardMessage mateData error" + e);
                arkAppMessage.appId = "com.tencent.mobileqq.expandfriend";
                arkAppMessage.appName = "com.tencent.mobileqq.expandfriend";
                arkAppMessage.appDesc = "\u624b\u673aQQ\u6821\u56ed\u6269\u5217\u7684mini\u8d44\u6599\u5361\u52a8\u6001\u5316\u4e0b\u53d1";
                arkAppMessage.appView = "qq_expand_mini_profile_ark";
                arkAppMessage.appMinVersion = "1.0.0.0";
                arkAppMessage.config = jSONObject.toString();
                arkAppMessage.metaList = jSONObject2.toString();
                MessageForArkApp messageForArkApp = (MessageForArkApp) q.d(i16);
                messageForArkApp.init(qQAppInterface.getCurrentAccountUin(), str, qQAppInterface.getCurrentAccountUin(), "mini profile ark message", j16, i16, i3, j3);
                messageForArkApp.ark_app_message = arkAppMessage;
                messageForArkApp.frienduin = str;
                messageForArkApp.mNeedTimeStamp = false;
                messageForArkApp.isread = true;
                messageForArkApp.shmsgseq = j3;
                messageForArkApp.getBytes();
                messageForArkApp.parse();
                return messageForArkApp;
            }
        } catch (Exception e17) {
            e = e17;
        }
        arkAppMessage.appId = "com.tencent.mobileqq.expandfriend";
        arkAppMessage.appName = "com.tencent.mobileqq.expandfriend";
        arkAppMessage.appDesc = "\u624b\u673aQQ\u6821\u56ed\u6269\u5217\u7684mini\u8d44\u6599\u5361\u52a8\u6001\u5316\u4e0b\u53d1";
        arkAppMessage.appView = "qq_expand_mini_profile_ark";
        arkAppMessage.appMinVersion = "1.0.0.0";
        arkAppMessage.config = jSONObject.toString();
        arkAppMessage.metaList = jSONObject2.toString();
        MessageForArkApp messageForArkApp2 = (MessageForArkApp) q.d(i16);
        messageForArkApp2.init(qQAppInterface.getCurrentAccountUin(), str, qQAppInterface.getCurrentAccountUin(), "mini profile ark message", j16, i16, i3, j3);
        messageForArkApp2.ark_app_message = arkAppMessage;
        messageForArkApp2.frienduin = str;
        messageForArkApp2.mNeedTimeStamp = false;
        messageForArkApp2.isread = true;
        messageForArkApp2.shmsgseq = j3;
        messageForArkApp2.getBytes();
        messageForArkApp2.parse();
        return messageForArkApp2;
    }

    private static g J(AppInterface appInterface, String str, int i3, String str2, String str3, int i16, String str4, int i17) {
        g gVar = new g(str, appInterface.getCurrentAccountUin(), str3, i3, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, i16, com.tencent.mobileqq.service.message.e.K0());
        gVar.f213683f = str3;
        if (!TextUtils.isEmpty(str4)) {
            Bundle bundle = new Bundle();
            int indexOf = str3.indexOf(str4);
            if (indexOf >= 0) {
                bundle.putInt("key_action", i17);
                bundle.putString("textColor", "#40A0FF");
                bundle.putString("key_action_DATA", str2);
                gVar.b(indexOf, str4.length() + indexOf, bundle);
            }
        }
        return gVar;
    }

    private static void K(JSONObject jSONObject, vg2.d dVar) {
        try {
            Object obj = dVar.f441608d;
            if (obj != null) {
                jSONObject.put("topic_msg", obj);
            }
            com.tencent.mobileqq.qqexpand.bean.chat.a aVar = dVar.f441615k;
            if (aVar != null) {
                Object obj2 = aVar.f263445b;
                if (obj2 != null) {
                    jSONObject.put("age", obj2);
                }
                jSONObject.put("gender", dVar.f441615k.f263451h);
                jSONObject.put("matchTagId", dVar.f441613i);
                jSONObject.put("matchTagName", dVar.f441614j);
                Object obj3 = dVar.f441615k.f263446c;
                if (obj3 != null) {
                    jSONObject.put(LpReport_UserInfo_dc02148.CONSTELLATION, obj3);
                }
                Object obj4 = dVar.f441615k.f263448e;
                if (obj4 != null) {
                    jSONObject.put("school", obj4);
                }
                Object obj5 = dVar.f441615k.f263450g;
                if (obj5 != null) {
                    jSONObject.put(IProfileProtocolConst.KEY_COMPANY, obj5);
                }
                Object obj6 = dVar.f441615k.f263447d;
                if (obj6 != null) {
                    jSONObject.put("city", obj6);
                }
                Object obj7 = dVar.f441615k.f263452i;
                if (obj7 != null) {
                    jSONObject.put("declaration", obj7);
                }
                Object obj8 = dVar.f441615k.f263455l;
                if (obj8 != null) {
                    jSONObject.put("signWords", obj8);
                }
                if (dVar.f441615k.f263449f != null) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<vg2.e> it = dVar.f441615k.f263449f.iterator();
                    while (it.hasNext()) {
                        vg2.e next = it.next();
                        if (next.f441617b != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("tagName", next.f441617b);
                            jSONObject2.put("tagSame", next.f441616a != 0);
                            jSONArray.mo162put(jSONObject2);
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("personalTags", jSONArray);
                    }
                }
                jSONObject.put("popular", dVar.f441615k.f263459p);
                if (dVar.f441615k.f263460q != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<com.tencent.mobileqq.qqexpand.bean.chat.b> it5 = dVar.f441615k.f263460q.iterator();
                    while (it5.hasNext()) {
                        com.tencent.mobileqq.qqexpand.bean.chat.b next2 = it5.next();
                        if (next2.f263465a != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("shcool_name", next2.f263465a);
                            jSONObject3.put("shcool_state", next2.f263467c);
                            jSONArray2.mo162put(jSONObject3);
                        }
                    }
                    if (jSONArray2.length() > 0) {
                        jSONObject.put("shcoolInfos", jSONArray2);
                    }
                }
                int i3 = dVar.f441615k.f263461r;
                if (i3 >= 0) {
                    jSONObject.put(Element.ELEMENT_NAME_DISTANCE, i3);
                }
            }
        } catch (JSONException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.i("LimitChatUtil", 4, "initProfileJSON " + e16);
            }
        }
    }

    public static boolean M(int i3) {
        if (1044 != i3 && 1045 != i3) {
            return false;
        }
        return true;
    }

    private static boolean O(QQAppInterface qQAppInterface) {
        if (ExpandChatUtil.C(qQAppInterface)) {
            return ((ILebaHelperService) qQAppInterface.getRuntimeService(ILebaHelperService.class, "")).isPluginOpen(7720L);
        }
        return false;
    }

    public static boolean Q(int i3) {
        if (i3 != 32772 && i3 != 32768) {
            return true;
        }
        return false;
    }

    public static boolean R(int i3) {
        for (int[] iArr : sg2.b.f433792b) {
            for (int i16 : iArr) {
                if (i16 == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean S(BaseQQAppInterface baseQQAppInterface) {
        return System.currentTimeMillis() - t().getLong(baseQQAppInterface.getCurrentUin().concat("_ts"), 0L) < 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(BaseQQAppInterface baseQQAppInterface, com.tencent.mobileqq.qqexpand.network.a aVar, com.tencent.mobileqq.qqexpand.network.b bVar) {
        QLog.i("LimitChatUtil", 1, "getExtendFriendSwitch errorCode=" + bVar.c());
        if (bVar.c() == 1000) {
            UserConfig$GetOptionsRsp userConfig$GetOptionsRsp = new UserConfig$GetOptionsRsp();
            try {
                userConfig$GetOptionsRsp.mergeFrom(bVar.b());
                t().edit().putBoolean(baseQQAppInterface.getCurrentUin(), userConfig$GetOptionsRsp.options.get().expandEntranceOptions.IsAllowDisplayEntrance.get()).putLong(baseQQAppInterface.getCurrentUin().concat("_ts"), userConfig$GetOptionsRsp.next_pull_time.get()).apply();
            } catch (Exception e16) {
                QLog.e("LimitChatUtil", 1, "error! hiding extend entrance", e16);
            }
        }
    }

    private static Intent U(Context context, String str, String str2, Long l3, String str3, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("LimitChatUtil", 2, "makeIntent, uin:" + str + " nick:" + str2 + " timestamp:" + l3 + " topic:" + str3);
        }
        Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
        intent.putExtra("uin", str);
        intent.putExtra("uinname", str2);
        intent.putExtra("uintype", 1044);
        if (i3 == 0) {
            intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 21);
        } else {
            intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 20);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_FROME_TYPE, i3);
        intent.putExtras(bundle);
        return intent;
    }

    private static void W(QQAppInterface qQAppInterface, String str) {
        IceBreakingMng iceBreakingMng = (IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
        iceBreakingMng.i(str);
        iceBreakingMng.e0();
    }

    public static void Z(BaseQQAppInterface baseQQAppInterface, String str) {
        ((IceBreakingMng) baseQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).Q(str);
    }

    public static void a0(QQAppInterface qQAppInterface, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("LimitChatUtil", 2, "getLimitChatState in mainprocess");
        }
        LimitChatDamon.b().c(qQAppInterface, str);
    }

    public static void c(BaseQQAppInterface baseQQAppInterface, String str, int i3, String str2, boolean z16, int i16) {
        com.tencent.mobileqq.qqexpand.manager.e eVar = (com.tencent.mobileqq.qqexpand.manager.e) baseQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        ExpandUserInfo o16 = eVar.o(str, true);
        if (o16 == null) {
            o16 = new ExpandUserInfo();
        }
        o16.uin = str;
        eVar.m(o16);
    }

    public static void c0(BaseQQAppInterface baseQQAppInterface, boolean z16, String str, long j3) {
        SharedPreferences t16 = t();
        if (!t16.contains(baseQQAppInterface.getCurrentUin())) {
            if (QLog.isColorLevel()) {
                QLog.i("LimitChatUtil", 2, "setup user_switch configs:" + z16);
            }
        } else if (QLog.isColorLevel()) {
            QLog.i("LimitChatUtil", 2, "update user_switch configs:" + z16);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            str = u();
        }
        t16.edit().putBoolean(baseQQAppInterface.getCurrentUin(), z16).putLong(baseQQAppInterface.getCurrentUin().concat("_ts"), j3).putString("extendSwitchText", str).apply();
    }

    public static void d(BaseQQAppInterface baseQQAppInterface, String str) {
        if (baseQQAppInterface instanceof QQAppInterface) {
            RecentUserProxy recentUserProxy = ((QQAppInterface) baseQQAppInterface).getRecentUserProxy();
            if (recentUserProxy == null) {
                return;
            }
            RecentUser findRecentUserByUin = recentUserProxy.findRecentUserByUin(str, 0);
            long serverTime = NetConnInfoCenter.getServerTime();
            if (findRecentUserByUin.lastmsgtime < serverTime) {
                findRecentUserByUin.lastmsgtime = serverTime;
            }
            recentUserProxy.saveRecentUser(findRecentUserByUin);
            return;
        }
        QLog.w("LimitChatUtil", 1, "app not instanceof QQAppInterface");
    }

    public static void e(BaseQQAppInterface baseQQAppInterface, String str, int i3, String str2, String str3, int i16, String str4, int i17, MessageRecord messageRecord) {
        if (baseQQAppInterface == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        if (messageRecord != null && N(baseQQAppInterface, str, i16, messageRecord)) {
            QLog.w("LimitChatUtil", 1, "addGrayTipsMessage last tip message is same");
            return;
        }
        g J = J(baseQQAppInterface, str, i3, str2, str3, i16, str4, i17);
        long i18 = i(messageRecord);
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.initGrayTipMsg(baseQQAppInterface, J);
        messageForUniteGrayTip.isread = true;
        messageForUniteGrayTip.shmsgseq = i18;
        messageForUniteGrayTip.mNeedTimeStamp = true;
        messageForUniteGrayTip.updateUniteGrayTipMsgData(baseQQAppInterface);
        if (baseQQAppInterface instanceof QQAppInterface) {
            ((QQAppInterface) baseQQAppInterface).getMessageFacade().c(messageForUniteGrayTip, baseQQAppInterface.getCurrentAccountUin());
        } else {
            QLog.w("LimitChatUtil", 1, "app not instanceof QQAppInterface");
        }
    }

    public static void f(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3) {
        AddMatchedRaletionReq addMatchedRaletionReq = new AddMatchedRaletionReq();
        addMatchedRaletionReq.UserInfo.set(new MatchedInfo());
        addMatchedRaletionReq.UserInfo.MatchedUin.set(Long.parseLong(str));
        addMatchedRaletionReq.UserInfo.MatchSrcId.set(i3);
        addMatchedRaletionReq.MatchUserInfo.set(new MatchedInfo());
        addMatchedRaletionReq.MatchUserInfo.MatchedUin.set(Long.parseLong(str2));
        addMatchedRaletionReq.MatchUserInfo.MatchSrcId.set(i3);
        ((IExpandCmdHandler) QRoute.api(IExpandCmdHandler.class)).sendSSORequest(baseQQAppInterface, "QQExpand.ExpandRelation.AddMatchedRaletion", addMatchedRaletionReq.toByteArray(), new b());
    }

    public static void f0(Context context, String str, int i3) {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (str.equals(appInterface.getCurrentUin()) || !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "LimitChatUtil")) {
            Intent intent = new Intent();
            intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str);
            intent.putExtra("fromPage", i3);
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, ExtendFriendCardOnHeadIconClick.class);
        }
    }

    public static boolean h(AppInterface appInterface) {
        return ExpandChatUtil.c(appInterface);
    }

    public static void k(BaseQQAppInterface baseQQAppInterface, String str) {
        ((IceBreakingMng) baseQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).W(str);
    }

    private static qq_ad_get.QQAdGet m(long j3, String str, int i3, int i16, long j16, long j17, int i17, int i18, int i19, int i26, String str2) {
        qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo shareInfo = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo();
        shareInfo.share_rate.set(i26);
        shareInfo.share_check.set(GdtAdUtil.getShareCheck(j16, j17, i26));
        qq_ad_get.QQAdGet.PositionInfo.PositionExt positionExt = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
        positionExt.share_info.set(shareInfo);
        positionExt.deep_link_version.set(i16);
        qq_ad_get.QQAdGet.PositionInfo positionInfo = new qq_ad_get.QQAdGet.PositionInfo();
        positionInfo.pos_id.set(str);
        positionInfo.ad_count.set(i3);
        positionInfo.pos_ext.set(positionExt);
        qq_ad_get.QQAdGet.ContextInfo contextInfo = new qq_ad_get.QQAdGet.ContextInfo();
        contextInfo.public_id.set(j16);
        contextInfo.article_id.set(j17);
        contextInfo.tribe_tag.set(i17);
        contextInfo.tribe_id_tag.set(i18);
        contextInfo.source_from.set(i19);
        qq_ad_get.QQAdGet.UserInfo userInfo = new qq_ad_get.QQAdGet.UserInfo();
        qq_ad_get.QQAdGet qQAdGet = new qq_ad_get.QQAdGet();
        qQAdGet.position_info.add(positionInfo);
        qQAdGet.context_info.set(contextInfo);
        qQAdGet.user_info.set(userInfo);
        qQAdGet.gdt_cookie.set(str2);
        return qQAdGet;
    }

    public static void n(Activity activity, vg2.d dVar, String str, int i3, int i16, int i17) {
        Intent U = U(activity, dVar.f441607c, str, Long.valueOf(dVar.f441609e), dVar.f441608d, i17);
        U.putExtra("need_check_apollo_dress_up", true);
        int i18 = dVar.f441613i;
        U.putExtra(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_ENTER_TYPE, i18 != 0 ? i18 != 1 ? i18 != 10000 ? 5 : 7 : 3 : 4);
        U.putExtra(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_MATCH_SEX_TYPE, i3);
        U.putExtra(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_MATCH_PURPOSE, i16);
        activity.startActivity(U);
    }

    public static void p(QQAppInterface qQAppInterface, String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        Intent intent = new Intent(qQAppInterface.getApplicationContext(), (Class<?>) ChatActivity.class);
        intent.putExtra("uin", str);
        String j3 = ac.j(qQAppInterface, str);
        if (TextUtils.isEmpty(j3)) {
            j3 = ac.g(qQAppInterface, str, false);
        }
        intent.putExtra("uinname", j3);
        if (i18 == 163) {
            intent.putExtra("uintype", 1044);
        } else if (i18 == 166) {
            intent.putExtra("uintype", 1045);
        }
        if (i3 == 6) {
            intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 20);
        } else {
            intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 21);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_FROME_TYPE, 0);
        intent.putExtras(bundle);
        intent.putExtra("need_check_apollo_dress_up", true);
        intent.putExtra(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_ENTER_TYPE, i16);
        intent.putExtra(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_MATCH_RELATION_SOURCE, i27);
        intent.putExtra("key_is_passive", i17);
        intent.putExtra(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_MATCH_SEX_TYPE, i19);
        intent.putExtra(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_MATCH_PURPOSE, i26);
        intent.setFlags(268435456);
        qQAppInterface.getApplicationContext().startActivity(intent);
    }

    public static void q(QQAppInterface qQAppInterface, String str, int i3, int i16) {
        Intent intent = new Intent(qQAppInterface.getApplicationContext(), (Class<?>) ChatActivity.class);
        intent.putExtra("uin", str);
        intent.putExtra("uintype", i3);
        intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 20);
        intent.putExtra(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_ENTER_TYPE, 6);
        intent.putExtra(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_MATCH_PURPOSE, i16);
        intent.putExtra("uinname", "");
        intent.setFlags(268435456);
        qQAppInterface.getApplicationContext().startActivity(intent);
    }

    private static void r(final BaseQQAppInterface baseQQAppInterface) {
        s(baseQQAppInterface, Long.valueOf(baseQQAppInterface.getCurrentUin()), new d() { // from class: com.tencent.mobileqq.qqexpand.chat.utils.b
            @Override // com.tencent.mobileqq.qqexpand.network.d
            public final void a(com.tencent.mobileqq.qqexpand.network.a aVar, com.tencent.mobileqq.qqexpand.network.b bVar) {
                LimitChatUtil.T(BaseQQAppInterface.this, aVar, bVar);
            }
        });
    }

    private static SharedPreferences t() {
        return BaseApplication.getContext().getSharedPreferences("extend_friend_entrance", 0);
    }

    public static boolean v(BaseQQAppInterface baseQQAppInterface) {
        SharedPreferences t16 = t();
        if (!t16.contains(baseQQAppInterface.getCurrentUin())) {
            if (QLog.isColorLevel()) {
                QLog.e("LimitChatUtil", 2, "configs not upgraded yet");
            }
            r(baseQQAppInterface);
            return true;
        }
        if (!t16.contains(baseQQAppInterface.getCurrentUin())) {
            return false;
        }
        if (!S(baseQQAppInterface)) {
            r(baseQQAppInterface);
        }
        return t16.getBoolean(baseQQAppInterface.getCurrentUin(), true);
    }

    public static String w(BaseQQAppInterface baseQQAppInterface) {
        return ExpandChatUtil.o(baseQQAppInterface);
    }

    private static boolean P(Object obj) {
        try {
            return new JSONObject((String) obj).getJSONObject("infos").getJSONObject("match_src").getInt("id") == 5;
        } catch (Exception e16) {
            QLog.w("LimitChatUtil", 1, "isNotShowIceBreakingMng get matchSource error" + e16);
            return false;
        }
    }

    public static boolean V(BaseQQAppInterface baseQQAppInterface, String str) {
        if (baseQQAppInterface != null && !TextUtils.isEmpty(str)) {
            if (!(baseQQAppInterface instanceof QQAppInterface)) {
                QLog.w("LimitChatUtil", 1, "app not instanceof QQAppInterface");
                return false;
            }
            RecentUserProxy recentUserProxy = ((QQAppInterface) baseQQAppInterface).getRecentUserProxy();
            if (recentUserProxy == null) {
                QLog.w("LimitChatUtil", 1, "needAddFriendConversationNode error, recentUserProxy is null");
                return false;
            }
            if (!recentUserProxy.isUinInRecent(str)) {
                return true;
            }
            QLog.w("LimitChatUtil", 1, "needAddFriendConversationNode false, already add friend conversation node");
            return false;
        }
        QLog.w("LimitChatUtil", 1, "needAddFriendConversationNode error, app or matchUin is null");
        return false;
    }

    public static boolean F(List<MessageRecord> list) {
        if (list == null) {
            return false;
        }
        Iterator<MessageRecord> it = list.iterator();
        while (it.hasNext()) {
            if (ExpandChatUtil.y(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void e0(Context context, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("LimitChatUtil", 2, "startAddFriendActivity " + str + " " + str2);
        }
        ExpandUserInfo o16 = ((com.tencent.mobileqq.qqexpand.manager.e) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).o(str, false);
        int fromTypeToSubID = o16 != null ? ExpandUserInfo.fromTypeToSubID(o16.fromType) : 8;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(activity, 1, str, null, 3094, fromTypeToSubID, str2, null, null, activity.getResources().getString(R.string.button_back), null);
            if (startAddFriend != null) {
                startAddFriend.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 1);
            }
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(activity, startAddFriend, 16002);
        }
    }

    private static long i(MessageRecord messageRecord) {
        if (messageRecord != null) {
            return messageRecord.shmsgseq + 1;
        }
        return Math.abs(new Random().nextInt());
    }

    public static void o(Uri uri, Map<String, Object> map) {
        if (uri != null && uri.getQueryParameter("toUin") != null && uri.getQueryParameter("fromPage") != null) {
            int parseInt = Integer.parseInt(uri.getQueryParameter("fromPage"));
            String queryParameter = uri.getQueryParameter("toUin");
            byte[] B = B(map);
            int y16 = y(map, "chooseCondition", 1);
            int z16 = z(uri, "matchSourceId", 0);
            ExpandFlutterIPCClient.g().e(queryParameter, parseInt, x(uri), z(uri, "accostType", 163), z(uri, "isPassive", 0), y16, z16, B);
            return;
        }
        QLog.e("LimitChatUtil", 2, "flutterEnterLimitChatAIO, necessary arguments is null, will not jump to AIO ");
    }

    private static int x(Uri uri) {
        if (uri == null || uri.getQueryParameter("srcType") == null) {
            return 3;
        }
        return Integer.parseInt(uri.getQueryParameter("srcType")) - 2;
    }

    private static int y(Map<String, Object> map, String str, int i3) {
        return (map == null || map.get(str) == null) ? i3 : Integer.parseInt((String) map.get(str));
    }

    private static int z(Uri uri, String str, int i3) {
        return (uri == null || uri.getQueryParameter(str) == null) ? i3 : Integer.parseInt(uri.getQueryParameter(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a extends ExpandObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f263539d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f263540e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f263541f;

        a(QQAppInterface qQAppInterface, String str, int i3) {
            this.f263539d = qQAppInterface;
            this.f263540e = str;
            this.f263541f = i3;
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && obj != null) {
                ExpandChatUtil.t(this.f263539d, this.f263540e, this.f263541f, obj);
            } else {
                QLog.w("LimitChatUtil", 1, "showIcebreakerTopic network error, data is null");
            }
        }
    }

    public static boolean G(List<MessageRecord> list) {
        if (list != null && !list.isEmpty()) {
            for (MessageRecord messageRecord : list) {
                if (!R(messageRecord.msgtype) && Q(messageRecord.extraflag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean N(AppInterface appInterface, String str, int i3, MessageRecord messageRecord) {
        return (appInterface == null || TextUtils.isEmpty(str) || messageRecord == null || !(messageRecord instanceof MessageForUniteGrayTip) || ((MessageForUniteGrayTip) messageRecord).tipParam.f213685h != i3) ? false : true;
    }

    public static void d0(QQAppInterface qQAppInterface, String str, int i3, int i16) {
        if (i16 == 4) {
            ExpandChatUtil.J(qQAppInterface, str, i3, i16, new a(qQAppInterface, str, i3));
        }
    }

    public static void s(BaseQQAppInterface baseQQAppInterface, Long l3, d dVar) {
        if (baseQQAppInterface == null) {
            return;
        }
        UserConfig$GetOptionsReq userConfig$GetOptionsReq = new UserConfig$GetOptionsReq();
        userConfig$GetOptionsReq.optionIDs.add(3);
        userConfig$GetOptionsReq.Uin.set(l3.longValue());
        ((IExpandCmdHandler) QRoute.api(IExpandCmdHandler.class)).sendSSORequest(baseQQAppInterface, "QQExpand.UserConfig.GetOptions", userConfig$GetOptionsReq.toByteArray(), dVar);
        if (QLog.isColorLevel()) {
            QLog.d("LimitChatUtil", 1, "cmd=QQExpand.UserConfig.GetOptions, req=" + userConfig$GetOptionsReq.toString());
        }
    }

    public static String u() {
        String qqStr = HardCodeUtil.qqStr(R.string.f198934o2);
        return t().contains("extendSwitchText") ? t().getString("extendSwitchText", qqStr) : qqStr;
    }

    public static boolean L(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return false;
        }
        return M(messageRecord.istroop);
    }

    public static boolean j(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        if (baseQQAppInterface == null || messageRecord == null || TextUtils.isEmpty(messageRecord.frienduin) || !(baseQQAppInterface instanceof QQAppInterface)) {
            return false;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) baseQQAppInterface;
        boolean z16 = O(qQAppInterface) || com.tencent.mobileqq.extendfriend.utils.a.f(qQAppInterface);
        if (QLog.isColorLevel()) {
            QLog.d("LimitChatUtil", 2, "checkInterceptMatchMessage showEntry = " + z16);
        }
        if (z16) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LimitChatUtil", 2, "checkInterceptMatchMessage, intercept");
        }
        a0(qQAppInterface, messageRecord.frienduin);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(QQAppInterface qQAppInterface, String str, boolean z16, int i3, Object obj) {
        int i16;
        if (qQAppInterface == null || str == null) {
            return;
        }
        List<ChatMessage> l16 = qQAppInterface.getMessageFacade().l1(str, i3);
        if (ExpandChatUtil.u(l16)) {
            return;
        }
        if (P(obj)) {
            W(qQAppInterface, str);
        }
        long f16 = ExpandChatUtil.f(l16);
        long e16 = ExpandChatUtil.e(l16);
        if (!z16) {
            boolean P = ((com.tencent.mobileqq.qqexpand.manager.e) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).P();
            if (i3 == 1045 || P) {
                i16 = -4026;
                int i17 = i16;
                if (QLog.isDevelopLevel()) {
                    QLog.i("LimitChatUtil", 4, String.format("addArkMiniProfileCard in seq %s  time %s", Long.valueOf(f16), Long.valueOf(e16)));
                }
                qQAppInterface.getMessageFacade().c(I(qQAppInterface, str, f16, e16, i3, i17, obj), qQAppInterface.getCurrentAccountUin());
            }
        }
        i16 = -4025;
        int i172 = i16;
        if (QLog.isDevelopLevel()) {
        }
        qQAppInterface.getMessageFacade().c(I(qQAppInterface, str, f16, e16, i3, i172, obj), qQAppInterface.getCurrentAccountUin());
    }

    public static long g(BaseQQAppInterface baseQQAppInterface, vg2.d dVar, long j3, int i3, int i16) {
        long abs;
        if (baseQQAppInterface == null || dVar == null || !(baseQQAppInterface instanceof QQAppInterface)) {
            return -1L;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) baseQQAppInterface;
        List<ChatMessage> l16 = qQAppInterface.getMessageFacade().l1(dVar.f441607c, i16);
        for (ChatMessage chatMessage : l16) {
            if (ExpandChatUtil.y(chatMessage)) {
                return chatMessage.time;
            }
        }
        int i17 = (i3 == 1 || i16 == 1045) ? MessageRecord.MSG_TYPE_LIMIT_CHAT_TOPIC_RECEIVER : MessageRecord.MSG_TYPE_LIMIT_CHAT_TOPIC;
        MessageForLimitChatTopic messageForLimitChatTopic = (MessageForLimitChatTopic) q.d(i17);
        if (!l16.isEmpty()) {
            abs = l16.get(l16.size() - 1).shmsgseq + 1;
        } else {
            abs = Math.abs(new Random().nextInt());
        }
        long j16 = abs;
        long j17 = j3 - 5;
        messageForLimitChatTopic.init(baseQQAppInterface.getCurrentAccountUin(), dVar.f441607c, baseQQAppInterface.getCurrentAccountUin(), dVar.f441608d, j17, i17, i16, j16);
        messageForLimitChatTopic.isread = true;
        messageForLimitChatTopic.shmsgseq = j16;
        JSONObject jSONObject = new JSONObject();
        K(jSONObject, dVar);
        messageForLimitChatTopic.saveExtInfoToExtStr("match_chat_msg_data_key", jSONObject.toString());
        if (QLog.isDevelopLevel()) {
            QLog.i("LimitChatUtil", 4, String.format(Locale.getDefault(), "addTopicMessage in seq %s  time %s", Long.valueOf(j16), Long.valueOf(j17)));
        }
        if (!MessageHandlerUtils.msgFilter(baseQQAppInterface, messageForLimitChatTopic, false)) {
            qQAppInterface.getMessageFacade().c(messageForLimitChatTopic, messageForLimitChatTopic.selfuin);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LimitChatUtil", 4, String.format(Locale.getDefault(), "addTopicMessage in 2", new Object[0]));
        }
        return System.currentTimeMillis();
    }

    public static qq_ad_get.QQAdGet l(long j3, String str, int i3, int i16) {
        return m(j3, str, i3, i16, 0L, 0L, 0, 0, 0, 0, null);
    }

    public static void X(BaseQQAppInterface baseQQAppInterface, Long l3, BusinessObserver businessObserver) {
    }

    public static void Y(BaseQQAppInterface baseQQAppInterface, Long l3, BusinessObserver businessObserver) {
    }

    public static void b0(BaseQQAppInterface baseQQAppInterface, boolean z16, d dVar) {
    }
}
