package com.tencent.mobileqq.musicgene;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static boolean a(Context context, String str) {
        try {
            InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        return a(context, QZoneHelper.PACKAGENAME_QQMUSIC);
    }
}
