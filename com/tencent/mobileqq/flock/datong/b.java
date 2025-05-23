package com.tencent.mobileqq.flock.datong;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Object> f210010a;

    /* renamed from: b, reason: collision with root package name */
    private IDynamicParams f210011b;

    /* renamed from: c, reason: collision with root package name */
    private String f210012c;

    /* renamed from: d, reason: collision with root package name */
    private ExposurePolicy f210013d;

    /* renamed from: e, reason: collision with root package name */
    private EndExposurePolicy f210014e;

    /* renamed from: f, reason: collision with root package name */
    private ClickPolicy f210015f;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f210013d = ExposurePolicy.REPORT_ALL;
        this.f210014e = EndExposurePolicy.REPORT_ALL;
        this.f210015f = ClickPolicy.REPORT_ALL;
    }

    public ClickPolicy a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ClickPolicy) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f210015f;
    }

    public IDynamicParams b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IDynamicParams) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f210011b;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f210012c;
    }

    public EndExposurePolicy d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (EndExposurePolicy) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f210014e;
    }

    public ExposurePolicy e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ExposurePolicy) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f210013d;
    }

    public Map<String, Object> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f210010a;
    }

    public b g(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
        }
        this.f210010a = map;
        return this;
    }
}
