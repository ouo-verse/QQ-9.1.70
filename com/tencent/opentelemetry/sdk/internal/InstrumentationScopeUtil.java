package com.tencent.opentelemetry.sdk.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class InstrumentationScopeUtil {
    static IPatchRedirector $redirector_;

    InstrumentationScopeUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static InstrumentationLibraryInfo toInstrumentationLibraryInfo(InstrumentationScopeInfo instrumentationScopeInfo) {
        return InstrumentationLibraryInfo.create(instrumentationScopeInfo.getName(), instrumentationScopeInfo.getVersion(), instrumentationScopeInfo.getSchemaUrl());
    }

    public static InstrumentationScopeInfo toInstrumentationScopeInfo(InstrumentationLibraryInfo instrumentationLibraryInfo) {
        return InstrumentationScopeInfo.create(instrumentationLibraryInfo.getName(), instrumentationLibraryInfo.getVersion(), instrumentationLibraryInfo.getSchemaUrl());
    }
}
