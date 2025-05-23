package com.tencent.mobileqq.uftransfer.guild;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.guild.performance.report.r;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    final AppRuntime f305188a;

    /* renamed from: f, reason: collision with root package name */
    String f305193f;

    /* renamed from: g, reason: collision with root package name */
    String f305194g;

    /* renamed from: l, reason: collision with root package name */
    long f305199l;

    /* renamed from: p, reason: collision with root package name */
    ExcitingTransferUploadResultRp f305203p;

    /* renamed from: q, reason: collision with root package name */
    long f305204q;

    /* renamed from: b, reason: collision with root package name */
    long f305189b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f305190c = 0;

    /* renamed from: d, reason: collision with root package name */
    long f305191d = 0;

    /* renamed from: e, reason: collision with root package name */
    long f305192e = 0;

    /* renamed from: h, reason: collision with root package name */
    long f305195h = 0;

    /* renamed from: i, reason: collision with root package name */
    boolean f305196i = false;

    /* renamed from: j, reason: collision with root package name */
    long f305197j = 0;

    /* renamed from: k, reason: collision with root package name */
    long f305198k = 0;

    /* renamed from: m, reason: collision with root package name */
    int f305200m = 0;

    /* renamed from: n, reason: collision with root package name */
    int f305201n = 0;

    /* renamed from: o, reason: collision with root package name */
    int f305202o = 0;

    public a(AppRuntime appRuntime) {
        this.f305188a = appRuntime;
    }

    public void a(boolean z16) {
        String str;
        String str2;
        r.a aVar = new r.a();
        String str3 = "0";
        aVar.f231044a = "0";
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = this.f305203p;
        if (excitingTransferUploadResultRp == null) {
            str = "";
        } else {
            str = excitingTransferUploadResultRp.mstrFileUrl;
        }
        aVar.f231045b = str;
        aVar.f231055l = this.f305193f;
        aVar.f231046c = String.valueOf(this.f305195h);
        aVar.f231047d = "";
        aVar.f231048e = "0";
        aVar.f231049f = String.valueOf(this.f305204q);
        aVar.f231050g = String.valueOf(this.f305199l);
        if (!z16) {
            str3 = String.valueOf(this.f305190c);
        }
        aVar.f231051h = str3;
        aVar.f231052i = "";
        if (this.f305199l > 0 && this.f305195h > 0) {
            str2 = ((this.f305195h / this.f305199l) * 1000) + "B/s";
        } else {
            str2 = "0B/s";
        }
        aVar.f231056m = str2;
        r.d(GuildTelemetryTask.UPLOAD_FILE, aVar);
    }

    public void b(long j3) {
        this.f305197j = j3;
    }

    public void c(ExcitingTransferUploadResultRp excitingTransferUploadResultRp) {
        this.f305203p = excitingTransferUploadResultRp;
    }

    public void d(int i3) {
        this.f305201n = i3;
    }

    public void e(boolean z16) {
        this.f305196i = z16;
    }

    public void f(boolean z16) {
        this.f305202o = z16 ? 1 : 0;
    }

    public void g(int i3) {
        this.f305190c = i3;
    }

    public void h(long j3) {
        this.f305189b = j3;
    }

    public void i(long j3) {
        this.f305204q = j3;
    }

    public void j(long j3) {
        this.f305199l = j3;
    }

    public void k(long j3, long j16, String str, String str2, long j17) {
        this.f305191d = j3;
        this.f305192e = j16;
        this.f305193f = str;
        this.f305194g = str2;
        this.f305195h = j17;
    }

    public void l(int i3) {
        this.f305200m = i3;
    }
}
