package com.tencent.icgame.game.scheme.tools;

import android.content.Context;
import android.content.Intent;
import com.tencent.icgame.game.utils.g;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f115823a = "ICGameSchemeUtil";

    public static void a(Context context, String str) {
        g.h(f115823a, "launchApp pkgName:" + str);
        if (context != null && str != null) {
            Context applicationContext = context.getApplicationContext();
            Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(applicationContext.getPackageManager(), str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setPackage(applicationContext.getPackageName());
                launchIntentForPackage.setFlags(268435456);
                applicationContext.startActivity(launchIntentForPackage);
                return;
            }
            g.d(f115823a, "launchApp err intent == null");
            return;
        }
        g.d(f115823a, "launchApp context = null || pkgName = null");
    }
}
