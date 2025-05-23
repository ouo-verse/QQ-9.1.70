package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopHandler;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x210.submsgtype0x94.Submsgtype0x94$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class bh implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public bh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(QQAppInterface qQAppInterface, MsgType0x210 msgType0x210) {
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        Submsgtype0x94$MsgBody submsgtype0x94$MsgBody;
        boolean z27;
        String str2;
        boolean z28;
        String str3;
        boolean z29;
        String str4;
        int i3;
        String str5;
        String str6;
        String str7;
        QQAppInterface qQAppInterface2;
        String str8;
        Submsgtype0x94$MsgBody submsgtype0x94$MsgBody2;
        boolean z36;
        boolean z37;
        Submsgtype0x94$MsgBody submsgtype0x94$MsgBody3 = new Submsgtype0x94$MsgBody();
        try {
            submsgtype0x94$MsgBody3.mergeFrom(msgType0x210.vProtobuf);
        } catch (Throwable unused) {
        }
        if (!submsgtype0x94$MsgBody3.str_folder_msg.has()) {
            str = "";
        } else {
            str = submsgtype0x94$MsgBody3.str_folder_msg.get().trim();
        }
        if (QLog.isColorLevel()) {
            QLog.i("EcShopAssistantActivity", 2, "diy string:" + str);
        }
        if (submsgtype0x94$MsgBody3.uint32_discover_reddot_flag.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (submsgtype0x94$MsgBody3.uint32_folder_reddot_flag.get() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (submsgtype0x94$MsgBody3.uint32_discount_reddot_flag.get() == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (submsgtype0x94$MsgBody3.uint32_nearby_reddot_flag.get() == 1) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (submsgtype0x94$MsgBody3.uint32_mine_reddot_flag.get() == 1) {
            z26 = true;
        } else {
            z26 = false;
        }
        int i16 = submsgtype0x94$MsgBody3.uint32_start_ts.get();
        int i17 = submsgtype0x94$MsgBody3.uint32_end_ts.get();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i18 = submsgtype0x94$MsgBody3.uint32_period_of_validity.get();
        int i19 = submsgtype0x94$MsgBody3.uint32_task_type.get();
        String str9 = submsgtype0x94$MsgBody3.str_task_info.get();
        String str10 = submsgtype0x94$MsgBody3.str_type_name.get();
        String str11 = submsgtype0x94$MsgBody3.str_type_color.get();
        String str12 = str;
        String str13 = submsgtype0x94$MsgBody3.str_jump_url.get();
        int i26 = submsgtype0x94$MsgBody3.uint32_task_id.get();
        if (QLog.isColorLevel()) {
            submsgtype0x94$MsgBody = submsgtype0x94$MsgBody3;
            z27 = z17;
            str2 = "EcShopAssistantActivity";
            QLog.i(str2, 2, "reddot start=" + i16 + ",end=" + i17 + ",showtime=" + i18 + "flags:" + z17 + "," + z16 + "," + z18 + "," + z19 + "," + z26 + ",type:" + i19 + ",taskInfo:" + str9 + ",typeName:" + str10 + ",typeColor:" + str11 + ",jumpUrl:" + str13);
        } else {
            submsgtype0x94$MsgBody = submsgtype0x94$MsgBody3;
            z27 = z17;
            str2 = "EcShopAssistantActivity";
        }
        if (currentTimeMillis >= i16 && currentTimeMillis <= i17) {
            if (i18 > 172800000) {
                i18 = 172800000;
            }
            if (!z16 && !z18 && !z19 && !z26) {
                z28 = z27;
            } else {
                z28 = true;
            }
            if (!z28) {
                z29 = z28;
                if (!z16) {
                    submsgtype0x94$MsgBody2 = submsgtype0x94$MsgBody;
                    str3 = str13;
                    z36 = true;
                    if (submsgtype0x94$MsgBody2.uint32_only_discover_reddot_flag.get() != 1) {
                        z37 = false;
                        if (z18 && submsgtype0x94$MsgBody2.uint32_only_discount_reddot_flag.get() != z36) {
                            z18 = false;
                        } else {
                            z18 = z36;
                        }
                        if (z19 && submsgtype0x94$MsgBody2.uint32_only_nearby_reddot_flag.get() != z36) {
                            z19 = false;
                        } else {
                            z19 = z36;
                        }
                        if (z26 && submsgtype0x94$MsgBody2.uint32_only_mine_reddot_flag.get() != z36) {
                            z26 = false;
                        } else {
                            z26 = true;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i(str2, 2, "new flag:" + z37 + "," + z18 + "," + z19 + "," + z26);
                        }
                        z16 = z37;
                    }
                } else {
                    submsgtype0x94$MsgBody2 = submsgtype0x94$MsgBody;
                    str3 = str13;
                    z36 = true;
                }
                z37 = z36;
                if (z18) {
                }
                z18 = z36;
                if (z19) {
                }
                z19 = z36;
                if (z26) {
                }
                z26 = true;
                if (QLog.isColorLevel()) {
                }
                z16 = z37;
            } else {
                str3 = str13;
                z29 = z28;
            }
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            if (TextUtils.isEmpty(currentAccountUin)) {
                currentAccountUin = "noLogin";
            }
            BaseApplication app = qQAppInterface.getApp();
            StringBuilder sb5 = new StringBuilder();
            boolean z38 = z26;
            sb5.append("ecshop_sp");
            sb5.append(currentAccountUin);
            SharedPreferences sharedPreferences = app.getSharedPreferences(sb5.toString(), 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            boolean z39 = z19;
            boolean z46 = z18;
            boolean z47 = z16;
            if (!sharedPreferences.getBoolean("disc_reddot", false) && !sharedPreferences.getBoolean("welfare_reddot", false) && !sharedPreferences.getBoolean("nearby_reddot", false) && !sharedPreferences.getBoolean("mine_reddot", false) && !sharedPreferences.getBoolean("folder_reddot", false)) {
                str4 = "last_show_time1";
                i3 = i18;
                str6 = "reddot_start";
                str5 = "reddot_end";
            } else {
                int i27 = sharedPreferences.getInt("last_show_time1", 0);
                str4 = "last_show_time1";
                int i28 = sharedPreferences.getInt("reddot_start", 0);
                i3 = i18;
                int i29 = sharedPreferences.getInt("reddot_end", 0);
                int i36 = sharedPreferences.getInt("max_reddot_time", 0);
                str5 = "reddot_end";
                int currentTimeMillis2 = (int) (System.currentTimeMillis() / 1000);
                if (currentTimeMillis2 != 0 && i28 != 0 && i29 != 0 && i36 != 0 && (currentTimeMillis2 < i28 || currentTimeMillis2 > i29 || currentTimeMillis2 - i27 >= i36)) {
                    if (QLog.isColorLevel()) {
                        QLog.i(str2, 2, "online push found reddot out of date!");
                    }
                    edit.putBoolean("disc_reddot", false);
                    edit.putBoolean("welfare_reddot", false);
                    edit.putBoolean("nearby_reddot", false);
                    edit.putBoolean("mine_reddot", false);
                    edit.putBoolean("folder_reddot", false);
                }
                str6 = "reddot_start";
            }
            edit.putInt(str6, i16);
            edit.putInt(str5, i17);
            edit.putInt("max_reddot_time", i3);
            edit.putString("str_ecshop_diy", str12);
            edit.putInt(str4, currentTimeMillis);
            edit.putInt("PUSH_TASK_TYPE", i19);
            edit.putString("PUSH_TASK_INFO", str9);
            edit.putString("PUSH_TYPE_NAME", str10);
            edit.putString("PUSH_TYPE_COLOR", str11);
            edit.putLong("PUSH_RECEIVE_TIME", NetConnInfoCenter.getServerTime());
            edit.putInt("PUSH_TASK_ID", i26);
            if (str3 == null) {
                str7 = "";
            } else {
                str7 = str3;
            }
            edit.putString("PUSH_JUMP_URL", str7);
            edit.putInt("FOLDER_MSG_TYPE", 1);
            boolean z48 = z29;
            edit.putBoolean("folder_reddot", z48);
            edit.putBoolean("disc_reddot", z47);
            edit.putBoolean("welfare_reddot", z46);
            edit.putBoolean("nearby_reddot", z39);
            edit.putBoolean("mine_reddot", z38);
            edit.commit();
            if (z48) {
                qQAppInterface2 = qQAppInterface;
                ((EcShopAssistantManager) qQAppInterface2.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).a(NetConnInfoCenter.getServerTime(), z48);
            } else {
                qQAppInterface2 = qQAppInterface;
                MqqHandler handler = qQAppInterface2.getHandler(Conversation.class);
                if (handler != null) {
                    handler.sendEmptyMessage(1009);
                }
            }
            ((EcShopHandler) qQAppInterface2.getBusinessHandler(BusinessHandlerFactory.ECSHOP_HANDLER)).D2();
            if (z47) {
                str8 = "Arrived_shopdiscover_dot";
            } else if (z46) {
                str8 = "Arrived_shoppreferential_dot";
            } else if (z39) {
                str8 = "Arrived_shopnearbynot_dot";
            } else if (z38) {
                str8 = "Arrived_shopmynot_dot";
            } else if (z48) {
                str8 = "Arrived_folder_dot";
            } else {
                str8 = null;
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", "Shop_folder", str8, 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b((QQAppInterface) afVar.d(), msgType0x210);
        return null;
    }
}
