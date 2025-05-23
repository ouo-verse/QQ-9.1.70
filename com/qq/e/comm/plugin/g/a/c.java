package com.qq.e.comm.plugin.g.a;

import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f39388a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f39389b = false;

    public static void a(long j3, double d16, g... gVarArr) {
        if (b()) {
            a a16 = new a(j3).a(d16);
            if (gVarArr != null) {
                for (g gVar : gVarArr) {
                    a16.a(gVar.f39408a, gVar.f39409b);
                }
            }
            d.a().a(a16);
        }
    }

    private static boolean b() {
        if (!f39388a) {
            f39388a = true;
            boolean a16 = com.qq.e.comm.plugin.j.c.a("metricReporterSwitch", 0, 1);
            f39389b = a16;
            if (!a16) {
                GDTLogger.i("[MetricReporter][isSwitchOn] switch of report is off");
            }
        }
        return f39389b;
    }

    public static void a(long j3, g... gVarArr) {
        if (b()) {
            a(j3, 1.0d, gVarArr);
        }
    }

    public static void a() {
        if (b()) {
            d.a().b();
        }
    }
}
