package com.tencent.msdk.dns.base.report;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.base.report.a;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class d implements a.InterfaceC9209a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Context f336217a;

    /* renamed from: b, reason: collision with root package name */
    public final String f336218b;

    public d(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
        } else {
            this.f336217a = context;
            this.f336218b = str;
        }
    }
}
