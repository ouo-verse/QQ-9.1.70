package com.tencent.mobileqq.qqguildsdk.tianjige;

import android.os.Build;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes17.dex */
public class i {

    /* renamed from: d, reason: collision with root package name */
    private static i f268531d;

    /* renamed from: a, reason: collision with root package name */
    private String f268532a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f268533b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f268534c = "";

    public i() {
        f();
        e();
        g();
    }

    public static i b() {
        if (f268531d == null) {
            synchronized (i.class) {
                if (f268531d == null) {
                    f268531d = new i();
                }
            }
        }
        return f268531d;
    }

    private void e() {
        this.f268533b = Build.BRAND;
    }

    private void f() {
        this.f268532a = DeviceInfoMonitor.getModel();
    }

    private void g() {
        this.f268534c = Build.VERSION.RELEASE;
    }

    public String a() {
        return this.f268533b;
    }

    public String c() {
        return this.f268532a;
    }

    public String d() {
        return this.f268534c;
    }
}
