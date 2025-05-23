package com.tencent.opentelemetry.sdk.trace.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.trace.StatusCode;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class d {
    public static StatusData a(StatusCode statusCode, String str) {
        IPatchRedirector iPatchRedirector = StatusData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (StatusData) iPatchRedirector.redirect((short) 4, (Object) statusCode, (Object) str);
        }
        return ImmutableStatusData.create(statusCode, str);
    }

    public static StatusData b() {
        IPatchRedirector iPatchRedirector = StatusData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (StatusData) iPatchRedirector.redirect((short) 3);
        }
        return ImmutableStatusData.ERROR;
    }

    public static StatusData c() {
        IPatchRedirector iPatchRedirector = StatusData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (StatusData) iPatchRedirector.redirect((short) 1);
        }
        return ImmutableStatusData.OK;
    }

    public static StatusData d() {
        IPatchRedirector iPatchRedirector = StatusData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (StatusData) iPatchRedirector.redirect((short) 2);
        }
        return ImmutableStatusData.UNSET;
    }
}
