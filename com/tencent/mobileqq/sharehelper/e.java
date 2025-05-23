package com.tencent.mobileqq.sharehelper;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f287102a;

    /* renamed from: b, reason: collision with root package name */
    private final FrameLayout f287103b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, View> f287104c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f287105d;

    public e(Context context, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) bool);
            return;
        }
        this.f287104c = new HashMap();
        this.f287102a = context;
        this.f287103b = new FrameLayout(context);
        this.f287105d = bool.booleanValue();
    }

    public void a(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        if (this.f287105d || list == null) {
            return;
        }
        for (String str : list) {
            View view = new View(this.f287102a);
            this.f287104c.put(str, view);
            this.f287103b.addView(view);
            VideoReport.setElementId(view, str);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        }
    }

    public void b(String str, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) map);
        } else {
            if (this.f287105d) {
                return;
            }
            VideoReport.setPageId(this.f287103b, str);
            VideoReport.setPageParams(this.f287103b, new PageParams((Map<String, ?>) map));
        }
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            if (this.f287105d) {
                return;
            }
            d(str, null);
        }
    }

    public void d(String str, Map<String, Object> map) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) map);
        } else {
            if (this.f287105d || (view = this.f287104c.get(str)) == null) {
                return;
            }
            VideoReport.reportEvent("dt_clck", view, map);
        }
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            if (this.f287105d) {
                return;
            }
            f(str, null);
        }
    }

    public void f(String str, Map<String, Object> map) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) map);
        } else {
            if (this.f287105d || (view = this.f287104c.get(str)) == null) {
                return;
            }
            VideoReport.reportEvent("dt_imp", view, map);
        }
    }

    public void g(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) map);
        } else {
            if (this.f287105d) {
                return;
            }
            VideoReport.setPageParams(this.f287103b, new PageParams((Map<String, ?>) map));
            VideoReport.reportPgIn(this.f287103b);
        }
    }

    public void h(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) map);
        } else {
            if (this.f287105d) {
                return;
            }
            VideoReport.setPageParams(this.f287103b, new PageParams((Map<String, ?>) map));
            VideoReport.reportPgOut(this.f287103b);
        }
    }

    public e(Context context) {
        this(context, Boolean.FALSE);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
    }
}
