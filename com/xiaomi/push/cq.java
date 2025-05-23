package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes28.dex */
public class cq {

    /* renamed from: a, reason: collision with root package name */
    private static int f388463a;

    private static int a(Context context) {
        if (f388463a <= 0) {
            f388463a = hz.l(context);
        }
        return f388463a;
    }

    private static SharedPreferences c(Context context) {
        return context.getSharedPreferences("sp_disconnect_stats", 0);
    }

    private static String d(String str, int i3) {
        return f(str, String.valueOf(i3));
    }

    private static String e(String str, long j3) {
        return f(str, String.valueOf(j3));
    }

    private static String f(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            str2 = "null";
        }
        if (str != null && str.length() > 0) {
            return str + ";" + str2;
        }
        return str2;
    }

    private static List<bo> g(Context context) {
        SharedPreferences c16 = c(context);
        String[] l3 = l(c16.getString("host", null));
        if (l3 != null && l3.length > 0) {
            String[] l16 = l(c16.getString(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_NETWORK_STATE, null));
            String[] l17 = l(c16.getString("reason", null));
            String[] l18 = l(c16.getString("ping_interval", null));
            String[] l19 = l(c16.getString("network_type", null));
            String[] l26 = l(c16.getString("wifi_digest", null));
            String[] l27 = l(c16.getString("connected_network_type", null));
            String[] l28 = l(c16.getString("disconnect_time", null));
            String[] l29 = l(c16.getString("connected_time", null));
            String[] l36 = l(c16.getString("xmsf_vc", null));
            String[] l37 = l(c16.getString("android_vc", null));
            if (l16 != null && l17 != null && l18 != null && l19 != null && l26 != null && l27 != null && l28 != null && l29 != null && l36 != null && l37 != null && l3.length == l16.length && l3.length == l17.length && l3.length == l18.length && l3.length == l19.length && l3.length == l26.length && l3.length == l27.length && l3.length == l28.length && l3.length == l29.length && l3.length == l36.length && l3.length == l37.length) {
                ArrayList arrayList = new ArrayList(l3.length);
                int i3 = 0;
                while (i3 < l3.length) {
                    bo boVar = new bo();
                    boVar.d(1);
                    boVar.f(l3[i3]);
                    boVar.j(ij.a(l16[i3], -1));
                    boVar.o(ij.a(l17[i3], -1));
                    String[] strArr = l16;
                    String[] strArr2 = l3;
                    ArrayList arrayList2 = arrayList;
                    boVar.e(ij.b(l18[i3], -1L));
                    boVar.s(ij.a(l19[i3], -1));
                    boVar.l(l26[i3]);
                    boVar.v(ij.a(l27[i3], -1));
                    long b16 = ij.b(l28[i3], -1L);
                    long b17 = ij.b(l29[i3], -1L);
                    boVar.k(b17 - b16);
                    boVar.p(b16);
                    boVar.t(b17);
                    boVar.x(ij.a(l36[i3], -1));
                    boVar.z(ij.a(l37[i3], -1));
                    arrayList2.add(boVar);
                    i3++;
                    l16 = strArr;
                    arrayList = arrayList2;
                    l18 = l18;
                    l17 = l17;
                    l3 = strArr2;
                    l19 = l19;
                }
                return arrayList;
            }
            jz4.c.m("DisconnectStatsSP Cached data incorrect,drop.");
            return null;
        }
        jz4.c.m("DisconnectStatsSP Cached hosts data is empty,drop.");
        return null;
    }

    private static void h(Context context) {
        bm.g(JobDbManager.TBL_UPLOAD);
        new bu().a(context, g(context));
        m(context);
    }

    public static void i(final Context context, final long j3) {
        ae.b(context).g(new Runnable() { // from class: com.xiaomi.push.cq.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cq.p(context, j3);
                } catch (Exception e16) {
                    jz4.c.m("DisconnectStatsSP onReconnection exception: " + e16.getMessage());
                }
            }
        });
    }

    private static void j(Context context, String str, int i3, long j3, int i16, long j16, int i17, String str2, int i18) {
        bm.g(String.format(Locale.US, "recordDisconnectInfo host=%s, netState=%d, currentTimeMillis=%d, reason=%d, pingInterval=%d, netType=%d, wifiDigest=%s, connectedNetType=%d", str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), str2, Integer.valueOf(i18)));
        SharedPreferences c16 = c(context);
        String string = c16.getString("host", null);
        String string2 = c16.getString(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_NETWORK_STATE, null);
        String string3 = c16.getString("reason", null);
        String string4 = c16.getString("ping_interval", null);
        String string5 = c16.getString("network_type", null);
        String string6 = c16.getString("wifi_digest", null);
        String string7 = c16.getString("connected_network_type", null);
        String string8 = c16.getString("disconnect_time", null);
        String string9 = c16.getString("xmsf_vc", null);
        String string10 = c16.getString("android_vc", null);
        String f16 = f(string, str);
        String d16 = d(string2, i3);
        String d17 = d(string3, i16);
        String e16 = e(string4, j16);
        String d18 = d(string5, i17);
        String f17 = f(string6, str2);
        String d19 = d(string7, i18);
        String e17 = e(string8, j3);
        c16.edit().putString("host", f16).putString(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_NETWORK_STATE, d16).putString("reason", d17).putString("ping_interval", e16).putString("network_type", d18).putString("wifi_digest", f17).putString("connected_network_type", d19).putString("disconnect_time", e17).putString("xmsf_vc", d(string9, a(context))).putString("android_vc", d(string10, Build.VERSION.SDK_INT)).apply();
    }

    public static void k(final Context context, final String str, final boolean z16, final long j3, final int i3, final long j16, final int i16, final String str2, final int i17) {
        ae.b(context).g(new Runnable() { // from class: com.xiaomi.push.cq.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cq.q(context, str, z16, j3, i3, j16, i16, str2, i17);
                } catch (Exception e16) {
                    jz4.c.m("DisconnectStatsSP onDisconnection exception: " + e16.getMessage());
                }
            }
        });
    }

    private static String[] l(String str) {
        if (str != null && str.length() > 0) {
            return str.split(";");
        }
        return null;
    }

    private static void m(Context context) {
        bm.g("resetAfterUpload");
        c(context).edit().putString("host", null).putString(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_NETWORK_STATE, null).putString("reason", null).putString("ping_interval", null).putString("network_type", null).putString("wifi_digest", null).putString("connected_network_type", null).putString("disconnect_time", null).putString("connected_time", null).putLong("last_discnt_time", 0L).putInt("discnt_count", 0).putInt("cnt_count", 0).putString("xmsf_vc", null).putString("android_vc", null).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void p(Context context, long j3) {
        synchronized (cq.class) {
            SharedPreferences c16 = c(context);
            long j16 = c16.getLong("start_time_for_day", 0L);
            if (j16 == 0) {
                c16.edit().putLong("start_time_for_day", j3).putLong("last_discnt_time", 0L).putInt("discnt_count_in_day", 0).putInt("discnt_count", 0).putInt("cnt_count", 0).apply();
                return;
            }
            int i3 = c16.getInt("discnt_count", 0);
            int i16 = c16.getInt("cnt_count", 0);
            if (i3 > i16) {
                c16.edit().putInt("cnt_count", i16 + 1).putString("connected_time", e(c16.getString("connected_time", null), j3)).apply();
            }
            if (j3 - j16 >= 86400000) {
                c16.edit().putLong("start_time_for_day", j3).putInt("discnt_count_in_day", 0).apply();
                h(context);
            } else if (i3 >= 10) {
                h(context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void q(Context context, String str, boolean z16, long j3, int i3, long j16, int i16, String str2, int i17) {
        synchronized (cq.class) {
            SharedPreferences c16 = c(context);
            long j17 = c16.getLong("start_time_for_day", 0L);
            if (j17 == 0) {
                bm.g("recordDisconnection not initialized");
                return;
            }
            if (j3 - c16.getLong("last_discnt_time", 0L) < 60000) {
                bm.g("recordDisconnection anti-shake");
                return;
            }
            if (j3 - j17 < 86400000) {
                int i18 = c16.getInt("discnt_count_in_day", 0);
                if (i18 > 100) {
                    bm.g("recordDisconnection count > 100 in 24H cycle,abandon.");
                    return;
                } else {
                    c16.edit().putInt("discnt_count_in_day", i18 + 1).apply();
                }
            } else {
                bm.g("recordDisconnection with the current time exceeds 24H cycle, go on.");
            }
            int i19 = c16.getInt("discnt_count", 0);
            if (i19 == c16.getInt("cnt_count", 0)) {
                j(context, str, b(z16), j3, i3, j16, i16, str2, i17);
                c16.edit().putLong("last_discnt_time", j3).putInt("discnt_count", i19 + 1).apply();
            }
            bm.g("recordDisconnection complete");
        }
    }

    private static int b(boolean z16) {
        return z16 ? 1 : 0;
    }
}
