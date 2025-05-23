package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface Scope extends AutoCloseable {
    public static final IPatchRedirector $redirector_ = null;

    @Override // java.lang.AutoCloseable
    void close();
}
