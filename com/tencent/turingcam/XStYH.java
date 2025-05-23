package com.tencent.turingcam;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingcam.jfo8q;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XStYH {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final String f382092b;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f382093a;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f382094a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f382095b;

        public spXPg(Context context, Map map) {
            this.f382094a = context;
            this.f382095b = map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) map);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                XStYH.a(this.f382094a, (Map<String, String>) this.f382095b);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21337);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        StringBuilder a16 = tmnyR.a("turingfd_conf_");
        a16.append(WT9z5.f382088a);
        a16.append("_");
        a16.append("mfa");
        f382092b = a16.toString();
    }

    public XStYH(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) handler);
        } else {
            this.f382093a = handler;
        }
    }

    public static String b(Context context, String str) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(f382092b, 0);
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
            Random random = Ckq8l.f381753a;
            int length = string.length() / 2;
            byte[] bArr = new byte[length];
            char[] charArray = string.toUpperCase().toCharArray();
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = i3 * 2;
                bArr[i3] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i16 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i16])) << 4));
            }
            return Ckq8l.a(VBlVU.a(bArr, VBlVU.a()), "UTF-8");
        } catch (Throwable unused2) {
            return "";
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

    public void c(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, context, Long.valueOf(j3));
            return;
        }
        a(context, "503", "" + j3, true);
    }

    public jfo8q a(Context context) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (jfo8q) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        }
        try {
            String b16 = b(context, "101");
            if (TextUtils.isEmpty(b16)) {
                return jfo8q.a(1);
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
            jfo8q.spXPg spxpg = new jfo8q.spXPg(0);
            spxpg.f382277b = j3;
            spxpg.f382276a = b16;
            spxpg.f382278c = b17;
            spxpg.f382279d = b18;
            spxpg.f382280e = b19;
            spxpg.f382281f = b26;
            return new jfo8q(spxpg);
        } catch (Throwable unused2) {
            return jfo8q.a(1);
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

    public VV8k1<Long> a(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (VV8k1) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, i3);
        }
        System.currentTimeMillis();
        VV8k1<Long> vV8k1 = new VV8k1<>(i3);
        for (String str : b(context, "402").split("_")) {
            try {
                vV8k1.a(Long.valueOf(Long.valueOf(str).longValue()));
            } catch (NumberFormatException unused) {
            }
        }
        return vV8k1;
    }

    public static void a(Context context, Map<String, String> map) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        try {
            sharedPreferences = context.getSharedPreferences(f382092b, 0);
        } catch (Throwable unused) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        for (String str : map.keySet()) {
            try {
                edit.putString(str, Ckq8l.a(VBlVU.b(map.get(str).getBytes(), VBlVU.a())));
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
            this.f382093a.post(new spXPg(context, map));
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

    public static void a(BfUKf bfUKf) {
        Context context;
        if (bfUKf == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("2001", String.valueOf(bfUKf.f381727b) + ',' + bfUKf.f381726a + ',' + bfUKf.f381728c);
        synchronized (eh5ma.class) {
            context = eh5ma.f382207a;
        }
        a(context, hashMap);
    }

    public static BfUKf a() {
        Context context;
        synchronized (eh5ma.class) {
            context = eh5ma.f382207a;
        }
        String b16 = b(context, "2001");
        if (TextUtils.isEmpty(b16)) {
            return null;
        }
        String[] split = b16.split(",", 3);
        if (split.length == 3 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1]) && !TextUtils.isEmpty(split[2])) {
            try {
                return new BfUKf(split[1], Long.parseLong(split[0]), split[2]);
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
