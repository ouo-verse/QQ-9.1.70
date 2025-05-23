package com.tencent.mobileqq.app.monitor;

import com.tencent.mobileqq.app.ThreadSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f196311a;

    /* renamed from: b, reason: collision with root package name */
    public int f196312b;

    /* renamed from: c, reason: collision with root package name */
    public int f196313c;

    /* renamed from: d, reason: collision with root package name */
    public int f196314d;

    /* renamed from: e, reason: collision with root package name */
    public double f196315e;

    /* renamed from: f, reason: collision with root package name */
    public int f196316f;

    /* renamed from: g, reason: collision with root package name */
    public int f196317g;

    /* renamed from: h, reason: collision with root package name */
    public double f196318h;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f196311a = false;
        this.f196312b = 5000;
        this.f196313c = 5000;
        this.f196314d = 3;
        this.f196315e = 0.800000011920929d;
        this.f196316f = 1000;
        this.f196317g = 30;
        this.f196318h = 1.0E-5d;
    }

    public static e a() {
        e eVar = new e();
        if (!ThreadSetting.isPublicVersion && !ThreadSetting.isDebugVersion) {
            eVar.f196311a = true;
            eVar.f196318h = 0.2d;
        }
        return eVar;
    }

    public static e b(JSONObject jSONObject) {
        e a16 = a();
        if (jSONObject.has("isOpenMonitor")) {
            a16.f196311a = jSONObject.optBoolean("isOpenMonitor");
        }
        if (jSONObject.has("jobWaitTime")) {
            a16.f196312b = jSONObject.optInt("jobWaitTime");
        }
        if (jSONObject.has("jobCostTime")) {
            a16.f196313c = jSONObject.optInt("jobCostTime");
        }
        if (jSONObject.has("runningThreadCount")) {
            a16.f196314d = jSONObject.optInt("runningThreadCount");
        }
        if (jSONObject.has("blockQueueRatio")) {
            a16.f196315e = jSONObject.optDouble("blockQueueRatio");
        }
        if (jSONObject.has("highJobMonitorTime")) {
            a16.f196316f = jSONObject.optInt("highJobMonitorTime");
        }
        if (jSONObject.has("highJobMonitorCount")) {
            a16.f196317g = jSONObject.optInt("highJobMonitorCount");
        }
        if (jSONObject.has("reportRatio")) {
            a16.f196318h = jSONObject.optDouble("reportRatio");
        }
        QLog.d("ThreadPoolMonitorThreadPoolConfig", 1, "parser config:" + a16);
        return a16;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ThreadPoolConfig{isOpenMonitor=" + this.f196311a + ", jobWaitTime=" + this.f196312b + ", jobCostTime=" + this.f196313c + ", runningThreadCount=" + this.f196314d + ", blockQueueRatio=" + this.f196315e + ", highJobMonitorTime=" + this.f196316f + ", highJobMonitorCount=" + this.f196317g + ", reportRatio=" + this.f196318h + '}';
    }
}
