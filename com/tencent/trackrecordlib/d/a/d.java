package com.tencent.trackrecordlib.d.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f381095a = "element_exposure_page";

    /* renamed from: b, reason: collision with root package name */
    public static final String f381096b = "element_exposure_page_id";

    /* renamed from: c, reason: collision with root package name */
    public static final String f381097c = "element_exposure_start_time";

    /* renamed from: d, reason: collision with root package name */
    public static final String f381098d = "element_exposure_end_time";

    /* renamed from: e, reason: collision with root package name */
    public static final String f381099e = "element_exposure_duration";

    /* renamed from: f, reason: collision with root package name */
    public static final int f381100f = 2131165332;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
