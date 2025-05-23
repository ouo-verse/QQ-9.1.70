package com.tencent.mobileqq.guild.util;

import android.view.WindowManager;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class bi {
    public static int a(float f16) {
        if (f16 == 0.0f) {
            return 0;
        }
        float f17 = FontSettingManager.customMetrics.density;
        if (f17 <= 0.0f) {
            f17 = MobileQQ.sMobileQQ.getResources().getDisplayMetrics().density;
            QLog.e("Guild.comm.GuildViewUtils", 1, "FontSettingManager.customMetrics.density is error, system density:", Float.valueOf(f17));
        }
        return (int) ((f16 * f17) + 0.5f);
    }

    public static int b(int i3) {
        return a(i3);
    }

    public static int c() {
        if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
            return BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        }
        return BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int d() {
        if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
            return BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        return BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static boolean e() {
        BaseApplication context = BaseApplication.getContext();
        if (context == null || !(context.getSystemService("window") instanceof WindowManager)) {
            return false;
        }
        int orientation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getOrientation();
        if (orientation != 1 && orientation != 3) {
            return false;
        }
        return true;
    }
}
