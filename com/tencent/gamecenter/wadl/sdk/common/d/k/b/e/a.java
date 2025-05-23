package com.tencent.gamecenter.wadl.sdk.common.d.k.b.e;

import android.content.pm.PackageInfo;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f107206a;

    /* renamed from: b, reason: collision with root package name */
    public int f107207b;

    /* renamed from: c, reason: collision with root package name */
    public String f107208c;

    /* renamed from: d, reason: collision with root package name */
    public String f107209d;

    /* renamed from: e, reason: collision with root package name */
    public int f107210e;

    public a() {
        this.f107206a = "";
        this.f107207b = 0;
        this.f107208c = "";
        this.f107209d = "";
        try {
            this.f107206a = com.tencent.gamecenter.wadl.sdk.common.a.b().getPackageName();
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(com.tencent.gamecenter.wadl.sdk.common.a.b().getPackageManager(), this.f107206a, 0);
            this.f107207b = packageInfo.versionCode;
            this.f107208c = packageInfo.versionName;
            this.f107210e = com.tencent.gamecenter.wadl.sdk.common.a.c();
            this.f107209d = "";
        } catch (Throwable unused) {
        }
    }
}
