package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface TraceFlags {
    public static final IPatchRedirector $redirector_ = null;

    byte asByte();

    String asHex();

    boolean isSampled();
}
