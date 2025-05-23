package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingfd.sdk.xq.Sultana;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Walnut {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final String f383198b;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f383199a;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Walnut$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f383200a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f383201b;

        public Cdo(Walnut walnut, Context context, Map map) {
            this.f383200a = context;
            this.f383201b = map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, walnut, context, map);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                Walnut.a(this.f383200a, (Map<String, String>) this.f383201b);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13347);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        StringBuilder a16 = Flat.a("turingfd_conf_");
        a16.append(Nectarine.f382928a);
        a16.append("_");
        a16.append("xq");
        f383198b = a16.toString();
    }

    public Walnut(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) handler);
        } else {
            this.f383199a = handler;
        }
    }

    public void a(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, Long.valueOf(j3));
            return;
        }
        if (j3 >= Long.MAX_VALUE) {
            j3 = Long.MAX_VALUE;
        }
        a(context, "401", "" + j3, true);
    }

    public Sultana b(Context context) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Sultana) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        }
        try {
            String b16 = b(context, "101");
            if (TextUtils.isEmpty(b16)) {
                return Sultana.a(1);
            }
            try {
                j3 = Long.valueOf(b(context, "102")).longValue();
            } catch (Throwable unused) {
                j3 = 0;
            }
            String b17 = b(context, "104");
            String b18 = b(context, "105");
            String b19 = b(context, "106");
            String b26 = b(context, "110");
            Sultana.Cdo cdo = new Sultana.Cdo(0);
            cdo.f383123b = j3;
            cdo.f383122a = b16;
            cdo.f383125d = b17;
            cdo.f383126e = b18;
            cdo.f383127f = b19;
            cdo.f383128g = b26;
            return new Sultana(cdo);
        } catch (Throwable unused2) {
            return Sultana.a(1);
        }
    }

    public void c(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, context, Long.valueOf(j3));
            return;
        }
        a(context, "503", "" + j3, true);
    }

    public UrsaMinor<Long> a(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (UrsaMinor) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, i3);
        }
        System.currentTimeMillis();
        UrsaMinor<Long> ursaMinor = new UrsaMinor<>(i3);
        for (String str : b(context, "402").split("_")) {
            try {
                ursaMinor.a(Long.valueOf(Long.valueOf(str).longValue()));
            } catch (NumberFormatException unused) {
            }
        }
        return ursaMinor;
    }

    public static void a(Context context, Map<String, String> map) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        try {
            sharedPreferences = context.getSharedPreferences(f383198b, 0);
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

    public final void a(Context context, String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, str, str2, Boolean.valueOf(z16));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        a(context, hashMap, z16);
    }

    public static String b(Context context, String str) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(f383198b, 0);
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
            return Plum.a(Cdefault.a(Plum.b(string), Cdefault.a()), "UTF-8");
        } catch (Throwable unused2) {
            return "";
        }
    }

    public final void a(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, str, str2);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        a(context, (Map<String, String>) hashMap, false);
    }

    public final void a(Context context, Map<String, String> map, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, map, Boolean.valueOf(z16));
        } else if (z16) {
            a(context, map);
        } else {
            this.f383199a.post(new Cdo(this, context, map));
        }
    }

    public final long a(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) str)).longValue();
        }
        try {
            return Long.valueOf(b(context, str)).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public void b(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, context, Long.valueOf(j3));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("902", "" + j3);
        a(context, hashMap);
    }

    public static Set<String> a(Context context) {
        HashSet hashSet = new HashSet();
        String b16 = b(context, "701");
        if (TextUtils.isEmpty(b16)) {
            return hashSet;
        }
        hashSet.addAll(Arrays.asList(b16.split("_")));
        return hashSet;
    }
}
