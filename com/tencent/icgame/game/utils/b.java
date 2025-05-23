package com.tencent.icgame.game.utils;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static volatile b f116093c;

    /* renamed from: a, reason: collision with root package name */
    private String f116094a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f116095b = "";

    b() {
    }

    public static b b() {
        if (f116093c == null) {
            synchronized (b.class) {
                if (f116093c == null) {
                    f116093c = new b();
                }
            }
        }
        return f116093c;
    }

    private static String d() {
        BaseApplication context = BaseApplication.getContext();
        StringBuilder sb5 = new StringBuilder("");
        try {
            sb5.append(InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException unused) {
            sb5.append("0.0.0.000");
        }
        return sb5.toString();
    }

    public String a() {
        if (TextUtils.isEmpty(this.f116094a)) {
            this.f116094a = d();
            g.h("DeviceInfoManager", "getAppVerion " + this.f116094a);
        }
        return this.f116094a;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f116095b)) {
            this.f116095b = com.dataline.util.a.a(false);
            g.h("DeviceInfoManager", "getIpAddress " + this.f116095b);
        }
        return this.f116095b;
    }
}
