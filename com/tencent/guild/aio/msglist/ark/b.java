package com.tencent.guild.aio.msglist.ark;

import android.util.DisplayMetrics;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static DisplayMetrics f111201a;

    static {
        a(1);
        f111201a = null;
    }

    private static void a(int i3) {
        DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        if (f111201a == null) {
            f111201a = displayMetrics;
        }
        QLog.d("ArkApp.GuildArkAppCenterUtil", 1, "ArkFold.checkArkSize model=", DeviceInfoMonitor.getModel(), ",screenWidth=", Integer.valueOf(min), ",scene=", Integer.valueOf(i3));
    }

    public static float b() {
        DisplayMetrics displayMetrics = f111201a;
        if (displayMetrics != null) {
            return displayMetrics.density;
        }
        return BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }
}
