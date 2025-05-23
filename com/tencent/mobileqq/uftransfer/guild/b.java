package com.tencent.mobileqq.uftransfer.guild;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.guild.performance.report.r;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    final AppRuntime f305205a;

    /* renamed from: f, reason: collision with root package name */
    String f305210f;

    /* renamed from: g, reason: collision with root package name */
    String f305211g;

    /* renamed from: i, reason: collision with root package name */
    ExcitingTransferUploaderRp f305213i;

    /* renamed from: m, reason: collision with root package name */
    long f305217m;

    /* renamed from: n, reason: collision with root package name */
    long f305218n;

    /* renamed from: b, reason: collision with root package name */
    long f305206b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f305207c = 0;

    /* renamed from: d, reason: collision with root package name */
    long f305208d = 0;

    /* renamed from: e, reason: collision with root package name */
    long f305209e = 0;

    /* renamed from: h, reason: collision with root package name */
    long f305212h = 0;

    /* renamed from: j, reason: collision with root package name */
    int f305214j = 0;

    /* renamed from: k, reason: collision with root package name */
    int f305215k = 0;

    /* renamed from: l, reason: collision with root package name */
    int f305216l = 0;

    public b(AppRuntime appRuntime) {
        this.f305205a = appRuntime;
    }

    public void a(boolean z16) {
        long j3;
        String str;
        String str2;
        long j16 = this.f305217m;
        if (j16 > 0) {
            j3 = this.f305218n - j16;
        } else {
            j3 = 0;
        }
        r.a aVar = new r.a();
        String str3 = "0";
        aVar.f231044a = "0";
        ExcitingTransferUploaderRp excitingTransferUploaderRp = this.f305213i;
        if (excitingTransferUploaderRp == null) {
            str = "";
        } else {
            str = excitingTransferUploaderRp.mstrFileUrl;
        }
        aVar.f231045b = str;
        aVar.f231055l = this.f305210f;
        aVar.f231046c = String.valueOf(this.f305212h);
        aVar.f231047d = "";
        aVar.f231048e = "0";
        aVar.f231049f = String.valueOf(this.f305217m);
        aVar.f231050g = String.valueOf(j3);
        if (!z16) {
            str3 = String.valueOf(this.f305207c);
        }
        aVar.f231051h = str3;
        aVar.f231052i = "";
        if (j3 > 0 && this.f305212h > 0) {
            str2 = ((this.f305212h / j3) * 1000) + "B/s";
        } else {
            str2 = "0B/s";
        }
        aVar.f231056m = str2;
        r.d(GuildTelemetryTask.UPLOADSENDER_FILE, aVar);
    }

    public void b(long j3) {
        this.f305218n = j3;
    }

    public void c(ExcitingTransferUploaderRp excitingTransferUploaderRp) {
        this.f305213i = excitingTransferUploaderRp;
    }

    public void d(int i3) {
        this.f305215k = i3;
    }

    public void e(boolean z16) {
        this.f305216l = z16 ? 1 : 0;
    }

    public void f(int i3) {
        this.f305207c = i3;
    }

    public void g(long j3) {
        this.f305206b = j3;
    }

    public void h(long j3) {
        this.f305217m = j3;
    }

    public void i(long j3, long j16, String str, String str2, long j17) {
        this.f305208d = j3;
        this.f305209e = j16;
        this.f305210f = str;
        this.f305211g = str2;
        this.f305212h = j17;
    }

    public void j(int i3) {
        this.f305214j = i3;
    }
}
