package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import com.tencent.mobileqq.vaswebviewplugin.KingCardJsPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class t {
    public static int a() {
        return b(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
    }

    public static int b(String str) {
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("CUKingCardFile_" + str, 4);
        int i3 = sharedPreferences.getInt("kingCardSdk", -1);
        int i16 = sharedPreferences.getInt(KingCardJsPlugin.BUSINESS_NAME, -1);
        int i17 = sharedPreferences.getInt("kingCard2", -1);
        if (QLog.isColorLevel()) {
            QLog.i("CUKingCardHelper", 2, "getCUKingStatus: status1=" + i16 + " status2=" + i17 + " sdkStatus=" + i3);
        }
        if (i3 >= 0) {
            if (i3 > 0) {
                return 1;
            }
            return 0;
        }
        if (i16 < 0 && i17 < 0) {
            return -1;
        }
        if (i16 > 0 || i17 > 0) {
            return 1;
        }
        return 0;
    }
}
