package com.tencent.mobileqq.guild.util;

import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes14.dex */
public class cy {

    /* renamed from: a, reason: collision with root package name */
    private static Method f235543a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f235544b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f235545c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f235546d;

    public static void a(long j3, String str, int i3) {
        if (!TraceUtils.m()) {
            return;
        }
        if (f235545c == null) {
            try {
                f235545c = Class.forName("android.os.Trace").getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        Method method = f235545c;
        if (method == null) {
            return;
        }
        try {
            method.invoke(null, Long.valueOf(j3), str, Integer.valueOf(i3));
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
    }

    public static void b(long j3, String str, int i3) {
        if (!TraceUtils.m()) {
            return;
        }
        if (f235546d == null) {
            try {
                f235546d = Class.forName("android.os.Trace").getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        Method method = f235546d;
        if (method == null) {
            return;
        }
        try {
            method.invoke(null, Long.valueOf(j3), str, Integer.valueOf(i3));
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
    }

    public static void c(String str) {
        if (!TraceUtils.m()) {
            return;
        }
        if (f235543a == null) {
            try {
                f235543a = Class.forName("android.os.Trace").getMethod("traceBegin", Long.TYPE, String.class);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        Method method = f235543a;
        if (method == null) {
            return;
        }
        try {
            method.invoke(null, 4096L, str);
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
    }

    public static void d() {
        if (!TraceUtils.m()) {
            return;
        }
        if (f235544b == null) {
            try {
                f235544b = Class.forName("android.os.Trace").getMethod("traceEnd", Long.TYPE);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        Method method = f235544b;
        if (method == null) {
            return;
        }
        try {
            method.invoke(null, 4096L);
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
    }
}
