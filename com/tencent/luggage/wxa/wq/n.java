package com.tencent.luggage.wxa.wq;

import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebSdk;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n {

    /* renamed from: b, reason: collision with root package name */
    public int f144382b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f144383c;

    /* renamed from: a, reason: collision with root package name */
    public int f144381a = -1;

    /* renamed from: d, reason: collision with root package name */
    public long f144384d = -1;

    /* renamed from: e, reason: collision with root package name */
    public long f144385e = -1;

    /* renamed from: f, reason: collision with root package name */
    public long f144386f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f144387g = 1;

    /* renamed from: h, reason: collision with root package name */
    public long f144388h = -1;

    /* renamed from: i, reason: collision with root package name */
    public long f144389i = -1;

    /* renamed from: j, reason: collision with root package name */
    public long f144390j = -1;

    /* renamed from: k, reason: collision with root package name */
    public long f144391k = -1;

    /* renamed from: l, reason: collision with root package name */
    public long f144392l = -1;

    /* renamed from: m, reason: collision with root package name */
    public long f144393m = -1;

    /* renamed from: n, reason: collision with root package name */
    public long f144394n = -1;

    public void a(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f144385e = currentTimeMillis;
        this.f144386f = currentTimeMillis - this.f144384d;
        this.f144387g = i3;
        b();
    }

    public void b() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(XWebSdk.getXWebSdkVersion());
        sb5.append(",");
        sb5.append(this.f144382b);
        sb5.append(",");
        sb5.append(WebView.getModuleName());
        sb5.append(",");
        sb5.append(this.f144381a);
        sb5.append(",");
        sb5.append(this.f144383c ? 1 : 2);
        sb5.append(",");
        sb5.append(this.f144384d);
        sb5.append(",");
        sb5.append(this.f144385e);
        sb5.append(",");
        sb5.append(this.f144386f);
        sb5.append(",");
        sb5.append(this.f144387g);
        sb5.append(",");
        sb5.append(this.f144388h);
        sb5.append(",");
        sb5.append(this.f144389i);
        sb5.append(",");
        sb5.append(this.f144390j);
        sb5.append(",");
        sb5.append(this.f144391k);
        sb5.append(",");
        sb5.append(this.f144392l);
        sb5.append(",");
        sb5.append(this.f144393m);
        sb5.append(",");
        sb5.append(this.f144394n);
        sb5.append(",");
        sb5.append(XWalkEnvironment.getApplicationContext().getPackageName());
        String sb6 = sb5.toString();
        x0.d("KVReportForStandAloneChannel", "report:" + sb6);
        n0.a(26318, sb6);
    }

    public void c() {
        this.f144384d = System.currentTimeMillis();
    }

    public void d(long j3) {
        this.f144390j = j3;
    }

    public void e(long j3) {
        this.f144393m = j3;
    }

    public void f(long j3) {
        this.f144391k = j3;
    }

    public void g(long j3) {
        this.f144392l = j3;
    }

    public void c(int i3) {
        this.f144381a = i3;
    }

    public void c(long j3) {
        this.f144389i = j3;
    }

    public long a() {
        return this.f144386f;
    }

    public void a(boolean z16) {
        this.f144383c = z16;
    }

    public void a(long j3) {
        this.f144394n = j3;
    }

    public void b(int i3) {
        this.f144382b = i3;
    }

    public void b(long j3) {
        this.f144388h = j3;
    }
}
