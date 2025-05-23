package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ContextStorage {
    public static final IPatchRedirector $redirector_ = null;

    Scope attach(Context context);

    @Nullable
    Context current();
}
