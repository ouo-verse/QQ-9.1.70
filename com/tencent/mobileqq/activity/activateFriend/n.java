package com.tencent.mobileqq.activity.activateFriend;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76$BirthdayNotify;

/* compiled from: P */
/* loaded from: classes9.dex */
public class n {
    static IPatchRedirector $redirector_;

    public static String a(boolean z16) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            if (z16) {
                jSONObject.put("app", "com.tencent.birthday.blessing");
                jSONObject.put("view", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_BLESSING);
                jSONObject2.put("blessingData", jSONObject3);
            } else {
                jSONObject.put("app", "com.tencent.giftmall.greeting");
                jSONObject.put("view", "greeting-0");
                jSONObject2.put("greetingData", jSONObject3);
            }
            jSONObject.put("ver", "1.0.4.1");
            jSONObject.put(PublicAccountMessageUtilImpl.META_NAME, jSONObject2);
            QLog.i("BirthdayActivateData", 1, " @arkgif getEmptyErroJson json data =" + jSONObject.toString() + ", experiment = " + z16);
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e("BirthdayActivateData", 1, "getEmptyErroJson" + e16.toString() + ", experiment = " + z16);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v0, types: [org.json.JSONObject, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r23v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.json.JSONObject, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.json.JSONObject, java.lang.Object] */
    public static String b(SubMsgType0x76$BirthdayNotify subMsgType0x76$BirthdayNotify, QQAppInterface qQAppInterface, boolean z16) {
        String str;
        String str2;
        SubMsgType0x76$BirthdayNotify subMsgType0x76$BirthdayNotify2 = subMsgType0x76$BirthdayNotify;
        String str3 = "BirthdayActivateData";
        try {
            ?? jSONObject = new JSONObject();
            ?? jSONObject2 = new JSONObject();
            ?? jSONObject3 = new JSONObject();
            String str4 = "greeting-0";
            String str5 = "greetingData";
            if (z16) {
                jSONObject.put("app", "com.tencent.birthday.blessing");
                str4 = MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_BLESSING;
                str5 = "blessingData";
            } else {
                jSONObject.put("app", "com.tencent.giftmall.greeting");
            }
            jSONObject3.put("ua", com.tencent.mobileqq.webview.webso.e.w());
            String str6 = PublicAccountMessageUtilImpl.META_NAME;
            String str7 = "1.0.4.1";
            if (subMsgType0x76$BirthdayNotify2 == null) {
                jSONObject.put("view", str4);
                jSONObject.put("ver", "1.0.4.1");
                jSONObject2.put(str5, jSONObject3);
                jSONObject.put(PublicAccountMessageUtilImpl.META_NAME, jSONObject2);
                QLog.i("BirthdayActivateData", 1, "@arkgif msg_birthday_info is null  =" + jSONObject.toString() + ", experiment = " + z16);
                return jSONObject.toString();
            }
            String str8 = subMsgType0x76$BirthdayNotify2.str_extend.get();
            try {
                if (TextUtils.isEmpty(str8)) {
                    str = ", experiment = ";
                    QLog.i("BirthdayActivateData", 1, "@arkgif json data strExtend is null  =");
                    jSONObject.put("view", str4);
                    jSONObject.put("ver", "1.0.4.1");
                } else {
                    JSONObject jSONObject4 = new JSONObject(str8);
                    String string = jSONObject4.getString("type");
                    String string2 = jSONObject4.getString("ver");
                    str = ", experiment = ";
                    if (!TextUtils.isEmpty(string) && !"null".equals(string)) {
                        str4 = string;
                    }
                    jSONObject.put("view", str4);
                    if (!TextUtils.isEmpty(string2) && !"null".equals(string2)) {
                        str7 = string2;
                    }
                    jSONObject.put("ver", str7);
                    QLog.i("BirthdayActivateData", 1, "@arkgif strExtend = " + str8);
                }
                jSONObject3.put("str_extend", str8);
                int size = subMsgType0x76$BirthdayNotify2.rpt_msg_one_friend.get().size();
                JSONArray jSONArray = new JSONArray();
                int i3 = 0;
                Object obj = jSONObject;
                Object obj2 = jSONObject2;
                while (i3 < size) {
                    long j3 = subMsgType0x76$BirthdayNotify2.rpt_msg_one_friend.get().get(i3).uint64_uin.get();
                    boolean z17 = subMsgType0x76$BirthdayNotify2.rpt_msg_one_friend.get().get(i3).bool_lunar_birth.get();
                    int i16 = subMsgType0x76$BirthdayNotify2.rpt_msg_one_friend.get().get(i3).uint32_birth_month.get();
                    str2 = str3;
                    try {
                        int i17 = subMsgType0x76$BirthdayNotify2.rpt_msg_one_friend.get().get(i3).uint32_birth_date.get();
                        String str9 = str8;
                        int i18 = subMsgType0x76$BirthdayNotify2.rpt_msg_one_friend.get().get(i3).uint32_birth_year.get();
                        int i19 = size;
                        Object obj3 = obj;
                        long j16 = subMsgType0x76$BirthdayNotify2.rpt_msg_one_friend.get().get(i3).uint64_msg_send_time.get();
                        String str10 = str5;
                        String g16 = com.tencent.mobileqq.utils.ac.g(qQAppInterface, j3 + "", true);
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("friendUin", j3 + "");
                        jSONObject5.put("lunarBirthday", z17);
                        jSONObject5.put("birthdayYear", i18);
                        jSONObject5.put("birthdayMonth", i16);
                        jSONObject5.put("birthdayDay", i17);
                        jSONObject5.put("messageSendTime", j16 + "");
                        jSONObject5.put("nickName", g16);
                        jSONArray.put(i3, jSONObject5);
                        i3++;
                        subMsgType0x76$BirthdayNotify2 = subMsgType0x76$BirthdayNotify;
                        str3 = str2;
                        str8 = str9;
                        size = i19;
                        obj2 = obj2;
                        obj = obj3;
                        str6 = str6;
                        str5 = str10;
                    } catch (Exception e16) {
                        e = e16;
                        str3 = str2;
                        QLog.e(str3, 1, e.toString());
                        return a(z16);
                    }
                }
                int i26 = size;
                str2 = str3;
                ?? r232 = obj;
                ?? r222 = obj2;
                String str11 = str5;
                String str12 = str6;
                String str13 = str8;
                jSONObject3.put("friendModels", jSONArray);
                int size2 = subMsgType0x76$BirthdayNotify.rpt_gift_msg.get().size();
                JSONArray jSONArray2 = new JSONArray();
                for (int i27 = 0; i27 < size2; i27++) {
                    JSONObject jSONObject6 = new JSONObject();
                    int i28 = subMsgType0x76$BirthdayNotify.rpt_gift_msg.get().get(i27).gift_id.get();
                    String str14 = subMsgType0x76$BirthdayNotify.rpt_gift_msg.get().get(i27).gift_name.get();
                    int i29 = subMsgType0x76$BirthdayNotify.rpt_gift_msg.get().get(i27).type.get();
                    String str15 = subMsgType0x76$BirthdayNotify.rpt_gift_msg.get().get(i27).gift_url.get();
                    int i36 = subMsgType0x76$BirthdayNotify.rpt_gift_msg.get().get(i27).price.get();
                    int i37 = subMsgType0x76$BirthdayNotify.rpt_gift_msg.get().get(i27).play_cnt.get();
                    String str16 = subMsgType0x76$BirthdayNotify.rpt_gift_msg.get().get(i27).background_color.get();
                    jSONObject6.put("gift_id", i28);
                    jSONObject6.put("gift_name", str14);
                    jSONObject6.put("gift_type", i29);
                    jSONObject6.put("gift_url", str15);
                    jSONObject6.put("gift_price", i36);
                    jSONObject6.put("play_count", i37);
                    jSONObject6.put("bgColorStr", str16);
                    jSONArray2.put(i27, jSONObject6);
                }
                jSONObject3.put("giftModels", jSONArray2);
                r222.put(str11, jSONObject3);
                r232.put(str12, r222);
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("@arkgif json data friendnum=");
                    sb5.append(i26);
                    sb5.append("strExtend = ");
                    sb5.append(str13);
                    sb5.append(str);
                    try {
                        sb5.append(z16);
                        str3 = str2;
                    } catch (Exception e17) {
                        e = e17;
                        str3 = str2;
                        QLog.e(str3, 1, e.toString());
                        return a(z16);
                    }
                    try {
                        QLog.i(str3, 1, sb5.toString());
                    } catch (Exception e18) {
                        e = e18;
                        QLog.e(str3, 1, e.toString());
                        return a(z16);
                    }
                } else {
                    str3 = str2;
                }
                return r232.toString();
            } catch (Exception e19) {
                e = e19;
            }
        } catch (Exception e26) {
            e = e26;
        }
    }
}
