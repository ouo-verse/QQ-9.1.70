package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ImplicitContextKeyed {
    public static final IPatchRedirector $redirector_ = null;

    Scope makeCurrent();

    Context storeInContext(Context context);
}
