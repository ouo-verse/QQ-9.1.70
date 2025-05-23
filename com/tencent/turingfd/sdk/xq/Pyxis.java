package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes27.dex */
public class Pyxis {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final String f383038b;

    /* renamed from: a, reason: collision with root package name */
    public Handler f383039a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12461);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        StringBuilder a16 = Flat.a("ias_");
        a16.append(Nectarine.f382928a);
        a16.append("_");
        a16.append("xq");
        f383038b = a16.toString();
    }

    public Pyxis(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) handler);
        } else {
            this.f383039a = handler;
        }
    }

    public final void a(Context context, Map<String, String> map) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) map);
            return;
        }
        try {
            sharedPreferences = context.getSharedPreferences(f383038b, 0);
        } catch (Throwable unused) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        for (String str : map.keySet()) {
            try {
                edit.putString(str, Plum.a(Cdefault.b(map.get(str).getBytes(), Cdefault.a())));
            } catch (Throwable unused2) {
            }
        }
        try {
            edit.commit();
        } catch (Throwable unused3) {
        }
    }

    public static String a(Context context, String str) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(f383038b, 0);
        } catch (Throwable unused) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return new String(Cdefault.a(Plum.b(string), Cdefault.a()), "UTF-8");
        } catch (Throwable unused2) {
            return "";
        }
    }

    public void a(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Long.valueOf(j3));
            return;
        }
        if (j3 >= Long.MAX_VALUE) {
            j3 = Long.MAX_VALUE;
        }
        a(context, ThemeReporter.FROM_DIY, "" + j3, true);
    }

    public UrsaMinor<Long> a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (UrsaMinor) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        System.currentTimeMillis();
        UrsaMinor<Long> ursaMinor = new UrsaMinor<>(6);
        for (String str : a(context, "101").split("_")) {
            try {
                ursaMinor.a(Long.valueOf(Long.valueOf(str).longValue()));
            } catch (NumberFormatException unused) {
            }
        }
        return ursaMinor;
    }

    public final void a(Context context, String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, str, str2, Boolean.valueOf(z16));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        if (z16) {
            a(context, hashMap);
        } else {
            this.f383039a.post(new Phoenix(this, context, hashMap));
        }
    }
}
