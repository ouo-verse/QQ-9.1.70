package com.tencent.mobileqq.qqlive.anchor.live.utils;

import android.content.SharedPreferences;
import android.support.annotation.VisibleForTesting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static b f270733b;

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    SharedPreferences f270734a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55266);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f270733b = null;
        }
    }

    @VisibleForTesting
    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        AppRuntime a16 = a();
        this.f270734a = a16.getApplicationContext().getSharedPreferences("AnchorLive_FB_" + a16.getCurrentUin(), 0);
    }

    @VisibleForTesting
    static AppRuntime a() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static b b() {
        if (f270733b == null) {
            synchronized (b.class) {
                if (f270733b == null) {
                    f270733b = new b();
                }
            }
        }
        return f270733b;
    }

    private SharedPreferences d() {
        AppRuntime a16 = a();
        return a16.getApplicationContext().getSharedPreferences("AnchorLive_Base_" + a16.getCurrentUin(), 4);
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return d().getInt("live_room_type", 1);
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        SharedPreferences.Editor edit = d().edit();
        edit.putInt("live_room_type", i3);
        edit.commit();
    }
}
