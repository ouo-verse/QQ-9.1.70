package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.MessageForReminder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi;
import com.tencent.mobileqq.reminder.util.QQConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a$MsgBody;

/* compiled from: P */
/* loaded from: classes9.dex */
public class y {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface) {
        IQQReminderRecordFacadeApi a16 = com.tencent.mobileqq.reminder.db.d.a(qQAppInterface);
        for (com.tencent.mobileqq.reminder.db.b bVar : a16.getMsgList(AppConstants.ACTIVATE_FRIENDS_UIN, 9002)) {
            if (i(bVar, a16)) {
                QLog.d("QQNotifyHelper", 1, "delete msg: ", Long.valueOf(System.currentTimeMillis()), " msgTime: ", Long.valueOf(bVar.getTime() * 1000));
                a16.removeMsgByUniseq(QQConstants.ACTIVATE_FRIENDS_UIN, 9002, bVar.getUniseq());
            }
        }
    }

    public static void b(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5) {
        c(appRuntime, str, str2, str3, str4, str5, new HashMap());
    }

    public static void c(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (appRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQNotifyHelper", 1, "doReport app is null");
                return;
            }
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>(12);
        hashMap.put("time_stamp", String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        hashMap.put("bussiness_id", str2);
        hashMap.put("remind_id", str3);
        hashMap.put("uin", appRuntime.getCurrentAccountUin());
        if (str4 != null) {
            hashMap.put("flag1", str4);
        }
        if (str5 != null) {
            hashMap.put("flag2", str5);
        }
        hashMap.putAll(map);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", str, true, 0L, 0L, hashMap, "");
    }

    public static int d(byte[] bArr) {
        submsgtype0x13a$MsgBody submsgtype0x13a_msgbody = new submsgtype0x13a$MsgBody();
        try {
            submsgtype0x13a_msgbody.mergeFrom(bArr);
            JSONObject optJSONObject = new JSONObject(submsgtype0x13a_msgbody.bytes_push_data.get().toStringUtf8()).optJSONObject("ark_data");
            if (bArr != null) {
                optJSONObject = optJSONObject.getJSONObject(PublicAccountMessageUtilImpl.META_NAME);
            }
            if (optJSONObject != null) {
                optJSONObject = optJSONObject.optJSONObject(QQCustomArkDialogUtil.META_DATA);
            }
            if (optJSONObject != null) {
                return optJSONObject.optInt("friend_type");
            }
            return -1;
        } catch (InvalidProtocolBufferMicroException | JSONException e16) {
            QLog.e("QQNotifyHelper", 1, "parse Friend type error: ", e16);
            return -1;
        }
    }

    public static String e(AcsMsg acsMsg) {
        if (acsMsg == null) {
            return null;
        }
        if (acsMsg.type == 0) {
            return acsMsg.msg_id;
        }
        return acsMsg.msg_id + "-" + acsMsg.sub_time;
    }

    public static String f(int i3) {
        String qqStr = HardCodeUtil.qqStr(R.string.f2177061q);
        if (i3 == 1) {
            return HardCodeUtil.qqStr(R.string.f2177161r);
        }
        return qqStr;
    }

    public static boolean g(String str) {
        QLog.d("QQNotifyHelper", 1, "isMemorialMsg msgId: " + str);
        if (TextUtils.equals(QQConstants.MEMORIAL_MSG_ID, str) || TextUtils.equals(QQConstants.MEMORIAL_MSG_ID_FORMAL, str)) {
            return true;
        }
        return false;
    }

    public static boolean h(byte[] bArr) {
        submsgtype0x13a$MsgBody submsgtype0x13a_msgbody = new submsgtype0x13a$MsgBody();
        try {
            submsgtype0x13a_msgbody.mergeFrom(bArr);
            return g(new JSONObject(submsgtype0x13a_msgbody.bytes_push_data.get().toStringUtf8()).optString("msg_id"));
        } catch (InvalidProtocolBufferMicroException | JSONException e16) {
            QLog.e("QQNotifyHelper", 1, "parse Friend type error: ", e16);
            return false;
        }
    }

    private static boolean i(com.tencent.mobileqq.reminder.db.b bVar, IQQReminderRecordFacadeApi iQQReminderRecordFacadeApi) {
        if ((bVar instanceof MessageForReminder) && h(bVar.getMsgData())) {
            if (System.currentTimeMillis() - (bVar.getTime() * 1000) > 86400000) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void j(Context context, int i3, int i16) {
        String qqStr = HardCodeUtil.qqStr(R.string.f2188964y);
        if (i3 != 0 && i3 != 6) {
            if (i3 == -1) {
                qqStr = HardCodeUtil.qqStr(R.string.f2188964y);
            }
        } else {
            qqStr = f(i16);
        }
        QQToast.makeText(context, 2, qqStr, 0).show();
    }
}
