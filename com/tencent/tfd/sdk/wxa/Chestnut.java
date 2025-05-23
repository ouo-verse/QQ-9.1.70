package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tfd.sdk.wxa.Cantaloupe;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Chestnut {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final String f375539b;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f375540a;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Chestnut$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cdo implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f375541a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f375542b;

        public Cdo(Context context, Map map) {
            this.f375541a = context;
            this.f375542b = map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) map);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                Chestnut.a(this.f375541a, (Map<String, String>) this.f375542b);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62499);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        StringBuilder a16 = Pyxis.a("turingfd_conf_");
        a16.append(UrsaMinor.f375742a);
        a16.append("_");
        a16.append("wxa");
        f375539b = a16.toString();
    }

    public Chestnut(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) handler);
        } else {
            this.f375540a = handler;
        }
    }

    public final Cantaloupe a(Context context) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Cantaloupe) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        }
        try {
            String b16 = b(context, "101");
            if (TextUtils.isEmpty(b16)) {
                return Cantaloupe.a(1);
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
            Cantaloupe.Cdo cdo = new Cantaloupe.Cdo();
            cdo.f375505b = j3;
            cdo.f375504a = b16;
            cdo.f375507d = b17;
            cdo.f375508e = b18;
            cdo.f375509f = b19;
            cdo.f375510g = b26;
            return new Cantaloupe(cdo);
        } catch (Throwable unused2) {
            return Cantaloupe.a(1);
        }
    }

    public final Centaurus b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Centaurus) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
        }
        System.currentTimeMillis();
        Centaurus centaurus = new Centaurus(30);
        for (String str : b(context, "402").split("_")) {
            try {
                centaurus.a(Long.valueOf(Long.valueOf(str).longValue()));
            } catch (NumberFormatException unused) {
            }
        }
        return centaurus;
    }

    public final void c(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, Long.valueOf(j3));
            return;
        }
        a(context, "503", "" + j3, true);
    }

    public static String b(Context context, String str) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(f375539b, 0);
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
            int length = string.length() / 2;
            byte[] bArr = new byte[length];
            char[] charArray = string.toUpperCase().toCharArray();
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = i3 * 2;
                bArr[i3] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i16 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i16])) << 4));
            }
            return new String(Cimport.a(bArr, Cimport.a()), "UTF-8");
        } catch (Throwable unused2) {
            return "";
        }
    }

    public final void a(Context context, long j3) {
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

    public static void a(Context context, Map<String, String> map) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        try {
            sharedPreferences = context.getSharedPreferences(f375539b, 0);
        } catch (Throwable unused) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        for (String str : map.keySet()) {
            try {
                edit.putString(str, Bennet.a(Cimport.b(map.get(str).getBytes(), Cimport.a())));
            } catch (Throwable unused2) {
            }
        }
        try {
            edit.commit();
        } catch (Throwable unused3) {
        }
    }

    public final void b(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, context, Long.valueOf(j3));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("902", "" + j3);
        a(context, hashMap);
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
            this.f375540a.post(new Cdo(context, map));
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
}
