package com.tencent.mobileqq.matchfriend.minicard;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.f;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f244166a = (f.f199484d - BaseChatItemLayout.f178049g0) - BaseChatItemLayout.f178050h0;

    private static MessageForArkApp e(QQAppInterface qQAppInterface, String str, long j3, long j16, int i3, int i16, Object obj) {
        ArkAppMessage arkAppMessage = new ArkAppMessage();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("type", "normal");
            jSONObject.put("showSender", 0);
            jSONObject.put("hintWidth", f244166a);
            jSONObject.put("hintHeight", 96);
            jSONObject4.put("matchUin", Long.parseLong(str));
            jSONObject4.put(LocalDataJsPlugin.NAME_SPACE, obj.toString());
            jSONObject4.put("defaultReportParams", jSONObject3.toString());
            jSONObject2.put(TtmlNode.TAG_METADATA, jSONObject4);
        } catch (Exception e16) {
            QLog.e("MatchFriendMiniCardUtils", 1, "ArkMiniProfileCardMessage mateData error" + e16);
        }
        arkAppMessage.appId = "com.tencent.mobileqq.qqstranger.minicard";
        arkAppMessage.appName = "com.tencent.mobileqq.qqstranger.minicard";
        arkAppMessage.appDesc = "\u964c\u751f\u4eba\u4ea4\u53cbmini\u8d44\u6599\u5361\u52a8\u6001\u5316\u4e0b\u53d1";
        arkAppMessage.appView = "qqstranger_mini_profilecard";
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

    private static boolean g(Object obj) {
        return false;
    }

    private static void h(QQAppInterface qQAppInterface, String str) {
        IceBreakingMng iceBreakingMng = (IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
        iceBreakingMng.j(str);
        iceBreakingMng.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(QQAppInterface qQAppInterface, String str, String str2, int i3, Object obj) {
        if (qQAppInterface == null || TextUtils.isEmpty(str)) {
            return;
        }
        List<ChatMessage> l16 = qQAppInterface.getMessageFacade().l1(str, i3);
        if (f(l16)) {
            return;
        }
        if (g(obj)) {
            h(qQAppInterface, str2);
        }
        long d16 = d(l16);
        long c16 = c(l16);
        if (QLog.isDevelopLevel()) {
            QLog.i("MatchFriendMiniCardUtils", 4, String.format("addArkMiniProfileCard in seq %s  time %s", Long.valueOf(d16), Long.valueOf(c16)));
        }
        qQAppInterface.getMessageFacade().c(e(qQAppInterface, str, d16, c16, i3, -4071, obj), qQAppInterface.getCurrentAccountUin());
        QLog.d("MatchFriendMiniCardUtils", 1, "matchfriend add miniark message success!");
    }

    private static long d(List<ChatMessage> list) {
        if (list != null && !list.isEmpty()) {
            return list.get(list.size() - 1).shmsgseq + 1;
        }
        return Math.abs(new Random().nextInt());
    }

    public static boolean f(List<ChatMessage> list) {
        if (list == null) {
            return false;
        }
        Iterator<ChatMessage> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().msgtype == -4071) {
                return true;
            }
        }
        return false;
    }

    private static long c(List<ChatMessage> list) {
        long currentTimeMillis;
        if (list != null && !list.isEmpty()) {
            currentTimeMillis = list.get(0).time;
        } else {
            currentTimeMillis = System.currentTimeMillis() / 1000;
        }
        return currentTimeMillis - 5;
    }
}
