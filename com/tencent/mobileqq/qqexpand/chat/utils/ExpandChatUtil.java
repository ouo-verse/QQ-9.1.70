package com.tencent.mobileqq.qqexpand.chat.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.f;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qqexpand.manager.c;
import com.tencent.mobileqq.qqexpand.network.e;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance$EntranceGetReq;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExpandChatUtil {
    public static void A(final BaseQQAppInterface baseQQAppInterface, final String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil.3
            @Override // java.lang.Runnable
            public void run() {
                ExpandFriendData.setHasEnterAIO(BaseQQAppInterface.this, str, true);
            }
        });
    }

    public static void B(Context context, String str, int i3) {
        QLog.d("ExpandFriendChatUtil", 2, "getMMKVMigratedSharePreferencesSync oldSP is " + str + "|" + i3);
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(context, str, "common_mmkv_configurations");
        QMMKV.migrateToSpAdapter(context, str, i3, "common_mmkv_configurations");
        fromSpAdapter.edit().putBoolean("expand_chat_migrate_flag_", true).apply();
    }

    public static boolean C(AppInterface appInterface) {
        SharedPreferences s16 = s(appInterface);
        boolean z16 = false;
        if (s16 == null) {
            return false;
        }
        if (s16.getBoolean("sp_limit_chat_on_plus_panel_be_show", false) && !com.tencent.mobileqq.extendfriend.utils.a.e(appInterface)) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExpandFriendChatUtil", 2, "needShowLimitChatOnPlus: " + z16);
        }
        return z16;
    }

    public static void E(final String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ExpandFriendChatUtil", 2, "reportInSubThread UIN EMPTY");
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                    ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A801", "0X800A801", 0, 0, "", "", ExpandChatUtil.q(qQAppInterface, str), "");
                }
            });
        }
    }

    private static void F(QQAppInterface qQAppInterface) {
        new Entrance$EntranceGetReq().uin.set(qQAppInterface.getLongAccountUin());
    }

    public static void G(final QQAppInterface qQAppInterface, final String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil.4
            @Override // java.lang.Runnable
            public void run() {
                ExpandFriendData.setHasShowIcebreakerTopic(QQAppInterface.this, str, true);
            }
        });
    }

    public static void H(BaseQQAppInterface baseQQAppInterface, String str, int i3) {
        SharedPreferences r16 = r(baseQQAppInterface);
        if (r16 != null) {
            r16.edit().putInt("sp_match_chat_gray_section_" + str, i3).commit();
        }
    }

    public static void I(QQAppInterface qQAppInterface, String str, String str2) {
        SharedPreferences r16 = r(qQAppInterface);
        if (r16 != null) {
            r16.edit().putString("sp_match_chat_algorithm_id" + str, str2).commit();
        }
    }

    public static void J(BaseQQAppInterface baseQQAppInterface, String str, int i3, int i16, BusinessObserver businessObserver) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("ExpandFriendChatUtil", 1, "showIcebreakerTopic but matchUin is empty");
            return;
        }
        if ((i16 <= 100 || i16 >= 200) && (baseQQAppInterface instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) baseQQAppInterface;
            boolean v3 = v(qQAppInterface, str, i3);
            boolean k3 = k(qQAppInterface, str);
            if (v3 || k3 || !j(qQAppInterface, str)) {
                return;
            }
            D(qQAppInterface, Long.valueOf(Long.parseLong(str)), businessObserver);
            G(qQAppInterface, str);
        }
    }

    public static void K(BaseQQAppInterface baseQQAppInterface, ExpandFriendData expandFriendData) {
        c cVar = (c) baseQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        if (cVar != null) {
            cVar.F(expandFriendData);
        }
    }

    private static void b() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.chat.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                ExpandChatUtil.z();
            }
        }, 64, null, true);
    }

    public static boolean c(AppInterface appInterface) {
        return false;
    }

    public static boolean d(BaseQQAppInterface baseQQAppInterface) {
        return false;
    }

    public static void i(BaseQQAppInterface baseQQAppInterface) {
        SharedPreferences r16 = r(baseQQAppInterface);
        if (r16 != null) {
            r16.edit().clear().commit();
        }
    }

    public static boolean j(QQAppInterface qQAppInterface, String str) {
        return ExpandFriendData.getHasEnterAIO(qQAppInterface, str);
    }

    public static boolean k(QQAppInterface qQAppInterface, String str) {
        return ExpandFriendData.getHasShowIcebreakerTopic(qQAppInterface, str);
    }

    public static boolean l(QQAppInterface qQAppInterface) {
        SharedPreferences s16 = s(qQAppInterface);
        boolean z16 = true;
        if (s16 == null) {
            return true;
        }
        if (LocaleManager.isLocaleUpdatedByUser()) {
            QLog.i("ExpandFriendChatUtil", 2, "getLimitChatOnPlusExpireTime: by change local langauage");
            return true;
        }
        QLog.d("ExpandFriendChatUtil", 2, "getLimitChatOnPlusExpireTime: not ! by change local langauage");
        long j3 = s16.getLong("sp_limit_chat_on_plus_panel_expire_time", 10L);
        long j16 = s16.getLong("sp_limit_chat_on_plus_panel_update_time", 0L);
        long serverTime = NetConnInfoCenter.getServerTime();
        long j17 = serverTime - j16;
        if (j17 < j3 && j17 > 0) {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExpandFriendChatUtil", 2, "getLimitChatOnPlusExpireTime: " + j3 + " update :" + j16 + " now\uff1a" + serverTime + " needUpdate\uff1a" + z16);
        }
        return z16;
    }

    public static int n(BaseQQAppInterface baseQQAppInterface, String str) {
        SharedPreferences r16 = r(baseQQAppInterface);
        if (r16 == null) {
            return 0;
        }
        return r16.getInt("sp_match_chat_gray_section_" + str, 0);
    }

    public static String o(AppInterface appInterface) {
        SharedPreferences s16 = s(appInterface);
        if (s16 == null) {
            return "";
        }
        String string = s16.getString("sp_limit_chat_on_plus_panel_name", "");
        if (QLog.isColorLevel()) {
            QLog.d("ExpandFriendChatUtil", 2, "getLimitChatOnPlusName: " + string);
        }
        return string;
    }

    private static SharedPreferences p(Context context, String str) {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(context, str, "common_mmkv_configurations");
        if (fromSpAdapter.getBoolean("expand_chat_migrate_flag_", false)) {
            return fromSpAdapter;
        }
        b();
        return context.getSharedPreferences(str, 0);
    }

    public static String q(BaseQQAppInterface baseQQAppInterface, String str) {
        SharedPreferences r16 = r(baseQQAppInterface);
        if (r16 == null) {
            return "0";
        }
        return r16.getString("sp_match_chat_algorithm_id" + str, "0");
    }

    public static void t(final BaseQQAppInterface baseQQAppInterface, final String str, final int i3, final Object obj) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil.2
            @Override // java.lang.Runnable
            public void run() {
                ExpandChatUtil.x(BaseQQAppInterface.this, str, i3, obj);
            }
        }, 32, null, true);
    }

    public static boolean v(QQAppInterface qQAppInterface, String str, int i3) {
        return qQAppInterface.getConversationFacade().R(str, i3) > 0;
    }

    public static void h(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            QLog.e("ExpandFriendChatUtil", 2, "ExtendFriendLimitChat checkAndUpdateLimiteChatSetting app null");
            return;
        }
        if (l(qQAppInterface)) {
            e eVar = (e) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
            if (eVar != null) {
                eVar.q1(true);
            } else {
                QLog.e("ExpandFriendChatUtil", 2, "ExtendFriendLimitChat handler null");
            }
        }
    }

    public static ExpandFriendData m(BaseQQAppInterface baseQQAppInterface, String str) {
        if (baseQQAppInterface != null && !TextUtils.isEmpty(str)) {
            c cVar = (c) baseQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
            if (cVar != null) {
                ExpandFriendData o16 = cVar.o(str, true);
                return o16 == null ? new ExpandFriendData(str) : o16;
            }
            QLog.w("ExpandFriendChatUtil", 1, "getInstance error get ExtendFriendLimitChatManager failed");
            return null;
        }
        QLog.w("ExpandFriendChatUtil", 1, "getInstance error app or matchUin is invalid");
        return null;
    }

    public static void x(BaseQQAppInterface baseQQAppInterface, String str, int i3, Object obj) {
        if (baseQQAppInterface != null && !TextUtils.isEmpty(str)) {
            if (!(baseQQAppInterface instanceof QQAppInterface)) {
                QLog.w("ExpandFriendChatUtil", 1, "app not instanceof QQAppInterface");
                return;
            }
            QQAppInterface qQAppInterface = (QQAppInterface) baseQQAppInterface;
            qQAppInterface.getMessageFacade().c(w(qQAppInterface, str, f(qQAppInterface.getMessageFacade().l1(str, i3)), i3, obj), baseQQAppInterface.getCurrentAccountUin());
            return;
        }
        QLog.w("ExpandFriendChatUtil", 1, "insertIcebreakerTopic but matchUin or app is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z() {
        AppRuntime peekAppRuntime;
        QLog.d("ExpandFriendChatUtil", 1, "[asyncMigrateSpToMMKV] start to migrate on other thread");
        BaseApplication context = BaseApplication.getContext();
        if (context == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        String currentUin = peekAppRuntime.getCurrentUin();
        B(context, "sp_for_extendfriend_limit_chat" + currentUin, 0);
        B(context, "sp_for_extendfriend_match_chat" + currentUin, 0);
    }

    public static long e(List<ChatMessage> list) {
        long currentTimeMillis;
        long longValue;
        if (list != null && !list.isEmpty()) {
            currentTimeMillis = list.get(0).time;
            longValue = LimitChatUtil.f263530a.longValue();
        } else {
            currentTimeMillis = System.currentTimeMillis() / 1000;
            longValue = LimitChatUtil.f263530a.longValue();
        }
        return currentTimeMillis - longValue;
    }

    public static long f(List<ChatMessage> list) {
        if (list != null && !list.isEmpty()) {
            return list.get(list.size() - 1).shmsgseq + 1;
        }
        return Math.abs(new Random().nextInt());
    }

    public static SharedPreferences r(BaseQQAppInterface baseQQAppInterface) {
        if (baseQQAppInterface == null) {
            QLog.e("ExpandFriendChatUtil", 2, "get sp by app is null");
            return null;
        }
        String currentUin = baseQQAppInterface.getCurrentUin();
        if (currentUin != null && !TextUtils.isEmpty(currentUin)) {
            return p(BaseApplication.getContext(), "sp_for_extendfriend_match_chat" + currentUin);
        }
        QLog.e("ExpandFriendChatUtil", 2, "get matchSp is null");
        return null;
    }

    public static SharedPreferences s(AppInterface appInterface) {
        if (appInterface == null) {
            QLog.e("ExpandFriendChatUtil", 2, "get sp by app is null");
            return null;
        }
        String currentUin = appInterface.getCurrentUin();
        if (currentUin != null && !TextUtils.isEmpty(currentUin)) {
            return p(BaseApplication.getContext(), "sp_for_extendfriend_limit_chat" + currentUin);
        }
        QLog.e("ExpandFriendChatUtil", 2, "get sp by uin is null");
        return null;
    }

    public static boolean u(List<ChatMessage> list) {
        if (list == null) {
            return false;
        }
        Iterator<ChatMessage> it = list.iterator();
        while (it.hasNext()) {
            if (y(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static MessageForArkApp w(QQAppInterface qQAppInterface, String str, long j3, int i3, Object obj) {
        boolean z16;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("type", "normal");
            jSONObject.put("showSender", 0);
            jSONObject.put("hintWidth", (f.f199484d - BaseChatItemLayout.f178049g0) - BaseChatItemLayout.f178050h0);
            jSONObject.put("hintHeight", 60);
        } catch (Exception e16) {
            e = e16;
        }
        try {
            jSONObject3.put(IExpandReportUtils.REPORT_KEY_MANAGER_TEST_PLAN, ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).getManageTestPlanParams(qQAppInterface));
            jSONObject4.put("matchUin", Long.parseLong(str));
            jSONObject4.put(LocalDataJsPlugin.NAME_SPACE, obj.toString());
            jSONObject4.put("defaultReportParams", jSONObject3.toString());
            jSONObject4.put("msgSeq", j3);
            jSONObject2.put(TtmlNode.TAG_METADATA, jSONObject4);
        } catch (Exception e17) {
            e = e17;
            QLog.e("ExpandFriendChatUtil", 1, "initIcebreakerTopicMessage mateData error" + e);
            ArkAppMessage arkAppMessage = new ArkAppMessage();
            arkAppMessage.appId = "com.tencent.mobileqq.expandfriend.breakicetopic";
            arkAppMessage.appName = "com.tencent.mobileqq.expandfriend.breakicetopic";
            arkAppMessage.appDesc = "\u624b\u673aQQ\u6821\u56ed\u6269\u5217\u7834\u51b0\u8bdd\u9898";
            arkAppMessage.appView = "expand_icebreak_topic";
            arkAppMessage.appMinVersion = "1.0.0.0";
            arkAppMessage.config = jSONObject.toString();
            arkAppMessage.metaList = jSONObject2.toString();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            MessageForArkApp messageForArkApp = (MessageForArkApp) q.d(-4027);
            messageForArkApp.init(qQAppInterface.getCurrentAccountUin(), str, qQAppInterface.getCurrentAccountUin(), "mini profile ark message", currentTimeMillis, -4027, i3, j3);
            if (QLog.isDevelopLevel()) {
            }
            messageForArkApp.ark_app_message = arkAppMessage;
            messageForArkApp.frienduin = str;
            messageForArkApp.mNeedTimeStamp = false;
            messageForArkApp.isread = z16;
            messageForArkApp.shmsgseq = j3;
            messageForArkApp.getBytes();
            messageForArkApp.parse();
            return messageForArkApp;
        }
        ArkAppMessage arkAppMessage2 = new ArkAppMessage();
        arkAppMessage2.appId = "com.tencent.mobileqq.expandfriend.breakicetopic";
        arkAppMessage2.appName = "com.tencent.mobileqq.expandfriend.breakicetopic";
        arkAppMessage2.appDesc = "\u624b\u673aQQ\u6821\u56ed\u6269\u5217\u7834\u51b0\u8bdd\u9898";
        arkAppMessage2.appView = "expand_icebreak_topic";
        arkAppMessage2.appMinVersion = "1.0.0.0";
        arkAppMessage2.config = jSONObject.toString();
        arkAppMessage2.metaList = jSONObject2.toString();
        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
        MessageForArkApp messageForArkApp2 = (MessageForArkApp) q.d(-4027);
        messageForArkApp2.init(qQAppInterface.getCurrentAccountUin(), str, qQAppInterface.getCurrentAccountUin(), "mini profile ark message", currentTimeMillis2, -4027, i3, j3);
        if (QLog.isDevelopLevel()) {
            z16 = true;
        } else {
            z16 = true;
            QLog.i("ExpandFriendChatUtil", 4, String.format(Locale.getDefault(), "insertIcebreakerTopic in seq %s  time %s", Long.valueOf(j3), Long.valueOf(currentTimeMillis2)));
        }
        messageForArkApp2.ark_app_message = arkAppMessage2;
        messageForArkApp2.frienduin = str;
        messageForArkApp2.mNeedTimeStamp = false;
        messageForArkApp2.isread = z16;
        messageForArkApp2.shmsgseq = j3;
        messageForArkApp2.getBytes();
        messageForArkApp2.parse();
        return messageForArkApp2;
    }

    public static void g(QQAppInterface qQAppInterface, boolean z16) {
        boolean z17 = true;
        if (qQAppInterface == null) {
            QLog.e("ExpandFriendChatUtil", 1, "checkAndUpdateExpandContactsEntrance app == null");
            return;
        }
        if (!z16 && !com.tencent.mobileqq.extendfriend.utils.a.c(qQAppInterface)) {
            z17 = false;
        }
        if (z17) {
            F(qQAppInterface);
        }
    }

    public static boolean y(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return false;
        }
        int i3 = messageRecord.msgtype;
        return i3 == -4023 || i3 == -4024 || i3 == -4025 || i3 == -4026;
    }

    public static void D(QQAppInterface qQAppInterface, Long l3, BusinessObserver businessObserver) {
    }
}
