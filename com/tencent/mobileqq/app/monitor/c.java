package com.tencent.mobileqq.app.monitor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    ReportType f196299a;

    /* renamed from: b, reason: collision with root package name */
    int f196300b;

    /* renamed from: c, reason: collision with root package name */
    int f196301c;

    /* renamed from: d, reason: collision with root package name */
    int f196302d;

    /* renamed from: e, reason: collision with root package name */
    long f196303e;

    /* renamed from: f, reason: collision with root package name */
    long f196304f;

    /* renamed from: g, reason: collision with root package name */
    String f196305g;

    /* renamed from: h, reason: collision with root package name */
    String f196306h;

    /* renamed from: i, reason: collision with root package name */
    int f196307i;

    /* renamed from: j, reason: collision with root package name */
    String f196308j;

    /* renamed from: k, reason: collision with root package name */
    int f196309k;

    /* renamed from: l, reason: collision with root package name */
    List<a> f196310l;

    public c(ReportType reportType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) reportType);
            return;
        }
        this.f196299a = reportType;
        this.f196310l = new ArrayList();
        this.f196305g = "";
        this.f196306h = "";
        this.f196308j = "";
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ReportMessage{type=" + this.f196299a + ", poolSize=" + this.f196300b + ", queueSize=" + this.f196301c + ", runningTaskCount=" + this.f196302d + ", jobWaitTime=" + this.f196303e + ", jobRunTime=" + this.f196304f + ", threadStatus='" + this.f196305g + "', jobKey='" + this.f196306h + "', jobHighFreqCount=" + this.f196307i + ", currentThreadName='" + this.f196308j + "', blockThreadCount=" + this.f196309k + '}';
    }
}
