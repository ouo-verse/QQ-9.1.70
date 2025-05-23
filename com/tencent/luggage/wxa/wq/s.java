package com.tencent.luggage.wxa.wq;

import android.os.Looper;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.XWebSdk;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public String f144420a = "";

    /* renamed from: b, reason: collision with root package name */
    public int f144421b = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f144422c = -1;

    /* renamed from: d, reason: collision with root package name */
    public long f144423d = -1;

    /* renamed from: e, reason: collision with root package name */
    public long f144424e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f144425f = 1;

    public void a(boolean z16, int i3, String str) {
        this.f144420a = str;
        this.f144421b = i3;
        long currentTimeMillis = System.currentTimeMillis();
        this.f144423d = currentTimeMillis;
        this.f144424e = currentTimeMillis - this.f144422c;
        this.f144425f = z16 ? 1 : 2;
        b();
    }

    public void b() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(XWebSdk.getXWebSdkVersion());
        sb5.append(",");
        sb5.append(XWebSdk.getAvailableVersion());
        sb5.append(",");
        sb5.append(this.f144420a);
        sb5.append(",");
        sb5.append(this.f144421b);
        sb5.append(",");
        sb5.append(this.f144422c);
        sb5.append(",");
        sb5.append(this.f144423d);
        sb5.append(",");
        sb5.append(this.f144424e);
        sb5.append(",");
        sb5.append(this.f144425f);
        sb5.append(",");
        sb5.append(XWalkEnvironment.getApplicationContext().getPackageName());
        sb5.append(",");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append(",");
        sb5.append(v0.b());
        sb5.append(",");
        sb5.append(CommandCfg.getInstance().getConfigVersion());
        String sb6 = sb5.toString();
        x0.d("KVReportForWebViewCore", "report:" + sb6);
        if (XWalkEnvironment.getBuildConfigThirdPartyRelease() && CommandCfg.getInstance().getEnableThirdAppReport()) {
            n0.a(10127, sb6);
        } else {
            n0.a(24761, sb6);
        }
    }

    public void c() {
        this.f144422c = System.currentTimeMillis();
    }

    public long a() {
        return this.f144424e;
    }
}
