package com.tencent.apkupdate.obfuscated;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.apkupdate.logic.protocol.jce.Terminal;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class l {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    public static l f72545b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f72546c = "";

    /* renamed from: d, reason: collision with root package name */
    public static int f72547d;

    /* renamed from: e, reason: collision with root package name */
    public static Terminal f72548e;

    /* renamed from: a, reason: collision with root package name */
    public Context f72549a;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (f72545b == null) {
                f72545b = new l();
            }
            lVar = f72545b;
        }
        return lVar;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        SharedPreferences sharedPreferences = this.f72549a.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString("TMAssistantSDKPhoneGUID", "");
    }
}
