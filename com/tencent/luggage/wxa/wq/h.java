package com.tencent.luggage.wxa.wq;

import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.XWebSdk;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public boolean f144351a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f144352b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f144353c = -1;

    /* renamed from: d, reason: collision with root package name */
    public String f144354d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f144355e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f144356f = 1;

    /* renamed from: g, reason: collision with root package name */
    public String f144357g = null;

    /* renamed from: h, reason: collision with root package name */
    public long f144358h = -1;

    /* renamed from: i, reason: collision with root package name */
    public long f144359i = -1;

    /* renamed from: j, reason: collision with root package name */
    public long f144360j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f144361k = 0;

    public void a(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f144359i = currentTimeMillis;
        this.f144360j = currentTimeMillis - this.f144358h;
        this.f144361k = i3;
        a();
    }

    public void b() {
        this.f144358h = System.currentTimeMillis();
    }

    public void b(int i3) {
        this.f144355e = i3;
    }

    public void b(com.tencent.luggage.wxa.yq.f fVar) {
        this.f144351a = fVar.f146069d;
        this.f144352b = fVar.f146070e;
        this.f144353c = fVar.f146073h;
        this.f144354d = fVar.f146072g;
        this.f144356f = fVar.f146078m;
        this.f144357g = a(fVar);
    }

    public final void a() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(XWebSdk.getXWebSdkVersion());
        sb5.append(",");
        sb5.append(this.f144351a ? "1" : "0");
        sb5.append(",");
        sb5.append(this.f144352b);
        sb5.append(",");
        sb5.append(this.f144353c);
        sb5.append(",");
        sb5.append(this.f144358h);
        sb5.append(",");
        sb5.append(this.f144359i);
        sb5.append(",");
        sb5.append(this.f144360j);
        sb5.append(",");
        sb5.append(this.f144361k);
        sb5.append(",");
        sb5.append(this.f144354d);
        sb5.append(",");
        sb5.append(this.f144355e);
        sb5.append(",");
        sb5.append(XWalkEnvironment.dumpAppInfo());
        sb5.append(",");
        sb5.append(XWalkEnvironment.getApplicationContext().getPackageName());
        sb5.append(",");
        sb5.append(v0.b());
        sb5.append(",");
        sb5.append(this.f144356f != 1 ? "2" : "1");
        sb5.append(",");
        sb5.append(CommandCfg.getInstance().getConfigVersion());
        sb5.append(",");
        sb5.append(this.f144357g);
        String sb6 = sb5.toString();
        x0.d("KVReportForInstallRuntime", "report:" + sb6);
        if (XWalkEnvironment.getBuildConfigThirdPartyRelease() && CommandCfg.getInstance().getEnableThirdAppReport()) {
            n0.a(10126, sb6);
        } else {
            n0.a(24763, sb6);
        }
    }

    public void a(int i3, int i16) {
        this.f144352b = i3;
        this.f144353c = i16;
    }

    public static String a(com.tencent.luggage.wxa.yq.f fVar) {
        try {
            return fVar.b();
        } catch (Exception unused) {
            return "";
        }
    }
}
