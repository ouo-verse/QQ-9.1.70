package com.tencent.mobileqq.troop.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static boolean a(QQAppInterface qQAppInterface, String str, GroupExt groupExt) {
        int i3;
        if (qQAppInterface == null || TextUtils.isEmpty(str) || groupExt == null) {
            return false;
        }
        int i16 = groupExt.starId;
        TroopInfo B = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).B(str);
        if (B != null) {
            i3 = B.getFansTroopStarId();
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FansTroopUtils", 2, "isIdolBindStatusChanged oldId=", Integer.valueOf(i16), ", newid=", Integer.valueOf(i3));
        }
        if (i16 == i3) {
            return false;
        }
        return true;
    }

    public static boolean b() {
        TroopFansEntryConfig troopFansEntryConfig = (TroopFansEntryConfig) com.tencent.mobileqq.config.am.s().x(701);
        if (troopFansEntryConfig == null || !troopFansEntryConfig.isProfileCardEntranceSwitchOn() || StudyModeManager.t()) {
            return false;
        }
        return true;
    }

    public static void c(Context context, String str, int i3) {
        if (context != null && !TextUtils.isEmpty(str) && i3 != 0) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/index?gc=%1$s&idol_id=%2$s&show=1&_wv=16777216&_wwv=128", str, Integer.valueOf(i3)));
            context.startActivity(intent);
        }
    }

    public static void d(Context context, String str, int i3, int i16) {
        if (context != null && !TextUtils.isEmpty(str) && i3 != 0) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/index?gc=%1$s&idol_id=%2$s&_wv=16777216&_wwv=128", str, Integer.valueOf(i3)));
            ((Activity) context).startActivityForResult(intent, i16);
        }
    }

    public static void e(Context context, String str, int i3) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/hot?gc=%1$s&_wv=16777218&_wwv=129", str));
            ((Activity) context).startActivityForResult(intent, i3);
        }
    }

    public static void f(Context context, int i3, String str) {
        if (context != null && i3 != 0) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            if (TextUtils.isEmpty(str)) {
                intent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/index?idol_id=%1$s&_wv=16777216&_wwv=128", Integer.valueOf(i3)));
            } else {
                intent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/index?gc=%1$s&idol_id=%2$s&_wv=16777216&_wwv=128", str, Integer.valueOf(i3)));
            }
            context.startActivity(intent);
        }
    }
}
