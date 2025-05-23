package com.tencent.mobileqq.extendfriend.utils;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static int a(QQAppInterface qQAppInterface) {
        if (f(qQAppInterface)) {
            return MatchChatMsgUtil.d(qQAppInterface);
        }
        return 0;
    }

    public static int b(AppInterface appInterface) {
        SharedPreferences d16 = d(appInterface);
        if (d16 == null) {
            return 0;
        }
        return d16.getInt("sp_contacts_entrance_style", 0);
    }

    public static boolean c(QQAppInterface qQAppInterface) {
        boolean isLocaleUpdatedByUser;
        SharedPreferences d16 = d(qQAppInterface);
        boolean z16 = true;
        if (d16 == null || (isLocaleUpdatedByUser = LocaleManager.isLocaleUpdatedByUser())) {
            return true;
        }
        long j3 = d16.getLong("sp_contacts_entrance_expire_time", 10000L) / 1000;
        long j16 = d16.getLong("sp_contacts_entrance_update_time", 0L);
        long serverTime = NetConnInfoCenter.getServerTime();
        if (serverTime - j16 < j3) {
            z16 = isLocaleUpdatedByUser;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendCardUtils", 2, "getIfExpandContactsEntranceNeedUpdate: " + j3 + " update :" + j16 + " now\uff1a" + serverTime + " needUpdate\uff1a" + z16);
        }
        return z16;
    }

    private static SharedPreferences d(AppInterface appInterface) {
        if (appInterface != null && appInterface.getApp() != null) {
            return appInterface.getApp().getSharedPreferences("sp_extend_friend_entrance_local_data" + appInterface.getCurrentUin(), 0);
        }
        return null;
    }

    public static boolean e(AppInterface appInterface) {
        SharedPreferences d16 = d(appInterface);
        if (d16 == null) {
            return false;
        }
        return d16.getBoolean("sp_contacts_entrance_can_show", false);
    }

    public static boolean f(QQAppInterface qQAppInterface) {
        if (StudyModeManager.t()) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendCardUtils", 2, "isEntranceReallyCanShow false isStudyMode");
            }
            return false;
        }
        if (AppSetting.f99565y) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendCardUtils", 2, "isEntranceReallyCanShow false enableTalkBack");
            }
            return false;
        }
        if (!e(qQAppInterface)) {
            return false;
        }
        if (!((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).getExtendFriendUserSwitch(qQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendCardUtils", 2, "isEntranceReallyCanShow false user switch");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendCardUtils", 2, "isEntranceReallyCanShow true");
            return true;
        }
        return true;
    }
}
