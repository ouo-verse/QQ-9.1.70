package com.tencent.mobileqq.qqlive.room.report.clarify;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f272108a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58310);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f272108a = null;
        }
    }

    public static String a(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16384).versionName;
        } catch (Exception e16) {
            QLog.e("VideoClarify|Helper", 1, e16.getLocalizedMessage());
            return "unknown";
        }
    }
}
