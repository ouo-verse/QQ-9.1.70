package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.mapsdk.internal.er;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hb;
import com.xiaomi.push.ij;
import com.xiaomi.push.service.ah;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f388061a;

        static {
            int[] iArr = new int[d.values().length];
            f388061a = iArr;
            try {
                iArr[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f388061a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f388061a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f388061a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int a() {
        Integer num = (Integer) com.xiaomi.push.y.f("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    static String b(Context context, d dVar) {
        return c(context, dVar, false);
    }

    protected static synchronized String c(Context context, d dVar, boolean z16) {
        synchronized (f.class) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            if (z16) {
                String string = sharedPreferences.getString("syncingToken", "");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            }
            String d16 = d(dVar);
            if (!TextUtils.isEmpty(d16)) {
                return sharedPreferences.getString(d16, "");
            }
            return "";
        }
    }

    public static String d(d dVar) {
        int i3 = a.f388061a[dVar.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return null;
                    }
                    return "ftos_push_token";
                }
                return "cos_push_token";
            }
            return "fcm_push_token_v2";
        }
        return "hms_push_token";
    }

    public static HashMap<String, String> e(Context context, d dVar) {
        int i3;
        HashMap<String, String> hashMap = new HashMap<>();
        int i16 = a.f388061a[dVar.ordinal()];
        String str = null;
        ApplicationInfo applicationInfo = null;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 == 4) {
                        ij.a a16 = new ij.a(":", "~").a("brand", q.VIVO.name()).a("token", c(context, dVar, true)).a("package_name", context.getPackageName());
                        int a17 = a();
                        if (a17 != 0) {
                            a16.a("version", Integer.valueOf(a17));
                        }
                        str = a16.toString();
                    }
                } else {
                    str = new ij.a(":", "~").a("brand", q.OPPO.name()).a("token", c(context, dVar, true)).a("package_name", context.getPackageName()).toString();
                }
            } else {
                ij.a a18 = new ij.a(":", "~").a("brand", q.FCM.name()).a("token", c(context, dVar, false)).a("package_name", context.getPackageName());
                int a19 = a();
                if (a19 != 0) {
                    a18.a("version", Integer.valueOf(a19));
                } else {
                    a18.a("version", 50909);
                }
                str = a18.toString();
            }
        } else {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (Exception e16) {
                jz4.c.B(e16.toString());
            }
            if (applicationInfo != null) {
                i3 = applicationInfo.metaData.getInt("com.huawei.hms.client.appid");
            } else {
                i3 = -1;
            }
            str = new ij.a(":", "~").a("brand", q.HUAWEI.name()).a("token", c(context, dVar, true)).a("package_name", context.getPackageName()).a("app_id", Integer.valueOf(i3)).toString();
        }
        hashMap.put("RegInfo", str);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(Context context) {
        boolean z16 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String d16 = d(d.ASSEMBLE_PUSH_HUAWEI);
        String d17 = d(d.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(d16, "")) && TextUtils.isEmpty(sharedPreferences.getString(d17, ""))) {
            z16 = true;
        }
        if (z16) {
            ag.h(context).p(2, d16);
        }
    }

    public static boolean g(Context context, d dVar) {
        if (u.c(dVar) != null) {
            return ah.d(context).m(u.c(dVar).a(), true);
        }
        return false;
    }

    public static boolean h(d dVar) {
        if (dVar != d.ASSEMBLE_PUSH_FTOS && dVar != d.ASSEMBLE_PUSH_FCM) {
            return false;
        }
        return true;
    }

    public static boolean i(hb hbVar, d dVar) {
        String str;
        if (hbVar != null && hbVar.m375a() != null && hbVar.m375a().m342a() != null) {
            if (dVar == d.ASSEMBLE_PUSH_FCM) {
                str = "FCM";
            } else {
                str = "";
            }
            return str.equalsIgnoreCase(hbVar.m375a().m342a().get("assemble_push_type"));
        }
        return false;
    }

    public static byte[] j(Context context, hb hbVar, d dVar) {
        if (i(hbVar, dVar)) {
            return com.xiaomi.push.ad.c(b(context, dVar));
        }
        return null;
    }

    public static String k(d dVar) {
        return d(dVar) + er.f148291t;
    }

    public static void l(Context context) {
        e.c(context).register();
    }

    public static void m(final Context context, final d dVar, final String str) {
        com.xiaomi.push.ae.b(context).g(new Runnable() { // from class: com.xiaomi.mipush.sdk.f.1
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split("~");
                    int length = split.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            String str3 = split[i3];
                            if (!TextUtils.isEmpty(str3) && str3.startsWith("token:")) {
                                str2 = str3.substring(str3.indexOf(":") + 1);
                                break;
                            }
                            i3++;
                        } else {
                            str2 = "";
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        jz4.c.m("ASSEMBLE_PUSH : receive correct token");
                        f.p(context, dVar, str2);
                        f.f(context);
                        return;
                    }
                    jz4.c.m("ASSEMBLE_PUSH : receive incorrect token");
                }
            }
        });
    }

    public static void n(Context context) {
        e.c(context).unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void p(Context context, d dVar, String str) {
        synchronized (f.class) {
            String d16 = d(dVar);
            if (TextUtils.isEmpty(d16)) {
                jz4.c.m("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(d16, str).putString("last_check_token", s.c(context).q());
            if (h(dVar)) {
                edit.putInt(k(dVar), a());
            }
            edit.putString("syncingToken", "");
            Cif.a(edit);
            jz4.c.m("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }
}
