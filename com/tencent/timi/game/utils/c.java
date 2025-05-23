package com.tencent.timi.game.utils;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static volatile c f380292c;

    /* renamed from: a, reason: collision with root package name */
    private String f380293a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f380294b = "";

    c() {
    }

    public static c b() {
        if (f380292c == null) {
            synchronized (c.class) {
                if (f380292c == null) {
                    f380292c = new c();
                }
            }
        }
        return f380292c;
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
        if (TextUtils.isEmpty(this.f380293a)) {
            this.f380293a = d();
            l.i("DeviceInfoManager", "getAppVerion " + this.f380293a);
        }
        return this.f380293a;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f380294b)) {
            this.f380294b = com.dataline.util.a.a(false);
            l.i("DeviceInfoManager", "getIpAddress " + this.f380294b);
        }
        return this.f380294b;
    }
}
