package com.tencent.mobileqq.weiyun.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.TransFileUtil;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f315288a;

    /* renamed from: b, reason: collision with root package name */
    private static int f315289b;

    /* renamed from: c, reason: collision with root package name */
    private static int f315290c;

    /* renamed from: d, reason: collision with root package name */
    private static int f315291d;

    public static int a() {
        e();
        return f315290c;
    }

    public static int b() {
        e();
        return f315288a;
    }

    public static int c() {
        e();
        return f315289b;
    }

    public static int d() {
        e();
        return f315291d;
    }

    private static void e() {
        if (f315290c == 0) {
            String[] split = TransFileUtil.getVersionCode().split("\\.");
            if (split.length < 4) {
                return;
            }
            try {
                f315288a = Integer.valueOf(split[0]).intValue();
                f315289b = Integer.valueOf(split[1]).intValue();
                f315291d = Integer.valueOf(split[2]).intValue();
                f315290c = Integer.valueOf(split[3]).intValue();
            } catch (NumberFormatException unused) {
            }
        }
    }
}
