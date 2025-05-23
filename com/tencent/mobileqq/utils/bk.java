package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.tencent.qphone.base.util.ROMUtil;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bk {
    public static Intent a(Context context) {
        if ("MIUI".equals(ROMUtil.getRomName())) {
            return d(context);
        }
        if (!"SMARTISAN".equals(ROMUtil.getRomName()) && !"360".equals(ROMUtil.getRomName())) {
            return c(context);
        }
        return b(context);
    }

    public static Intent b(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        return intent;
    }

    public static Intent c(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            intent.putExtra("android.provider.extra.CHANNEL_ID", context.getApplicationInfo().uid);
            return intent;
        }
        Intent intent2 = new Intent();
        intent2.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent2.putExtra("app_package", context.getPackageName());
        intent2.putExtra("app_uid", context.getApplicationInfo().uid);
        return intent2;
    }

    public static Intent d(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClassName("com.android.settings", "com.android.settings.Settings$NotificationFilterActivity");
        intent.putExtra("appName", context.getResources().getString(context.getApplicationInfo().labelRes));
        intent.putExtra("packageName", context.getPackageName());
        return intent;
    }
}
