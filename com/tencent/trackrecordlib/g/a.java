package com.tencent.trackrecordlib.g;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f381131a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11646);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f381131a = a.class.getName();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a(Context context) {
        int i3;
        String string;
        if (context == null) {
            return false;
        }
        try {
            i3 = Settings.Secure.getInt(context.getApplicationContext().getContentResolver(), "accessibility_enabled");
        } catch (Throwable th5) {
            Log.e(f381131a, "Error finding setting, default accessibility to not found: " + th5.getMessage());
            i3 = 0;
        }
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        if (i3 == 1 && (string = DeviceInfoMonitor.getString(context.getContentResolver(), "enabled_accessibility_services")) != null) {
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                if (simpleStringSplitter.next().equalsIgnoreCase("com.google.android.marvin.talkback/com.google.android.marvin.talkback.TalkBackService")) {
                    return true;
                }
            }
        }
        return false;
    }
}
