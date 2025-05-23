package com.tencent.open.business.viareport;

import android.content.SharedPreferences;
import com.tencent.open.business.base.OpenConfig;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d extends a {
    public static long a() {
        return com.tencent.open.adapter.a.f().e().getSharedPreferences("reportConfig", 0).getLong("lastTime", 0L);
    }

    public static String b() {
        if (com.tencent.open.adapter.a.f().e() == null) {
            return "";
        }
        return c().getString("uin", "");
    }

    protected static SharedPreferences c() {
        return com.tencent.open.adapter.a.f().e().getSharedPreferences("reportConfig", 0);
    }

    public static int d(String str) {
        int j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), str).j("Common_BusinessReportFrequency");
        if (j3 == 0) {
            return 100;
        }
        return j3;
    }

    public static int e() {
        int j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_HttpRetryCount");
        if (j3 == 0) {
            return 2;
        }
        return j3;
    }

    public static int f() {
        int j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_BusinessReportMaxcount");
        if (j3 == 0) {
            return 20;
        }
        return j3;
    }

    public static long g() {
        long k3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).k("Common_BusinessReportTimeinterval");
        if (k3 == 0) {
            return 3600L;
        }
        return k3;
    }

    public static int h(int i3) {
        if (i3 == 0) {
            int j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_ViaSuccessRatioFrequencySuccess");
            if (j3 == 0) {
                return 20;
            }
            return j3;
        }
        int j16 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_ViaSuccessRatioFrequencyFail");
        if (j16 == 0) {
            return 50;
        }
        return j16;
    }

    public static void i(long j3) {
        if (com.tencent.open.adapter.a.f().e() == null) {
            return;
        }
        SharedPreferences.Editor edit = c().edit();
        edit.putLong("lastTime", j3);
        edit.commit();
    }

    public static void j(String str) {
        if (com.tencent.open.adapter.a.f().e() == null) {
            return;
        }
        SharedPreferences.Editor edit = c().edit();
        edit.putString("uin", str);
        edit.commit();
    }
}
