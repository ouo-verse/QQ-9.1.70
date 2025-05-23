package com.tencent.opentelemetry.context.propagation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.context.Context;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes22.dex */
public interface TextMapPropagator {
    public static final IPatchRedirector $redirector_ = null;

    <C> Context extract(Context context, @Nullable C c16, TextMapGetter<C> textMapGetter);

    Collection<String> fields();

    <C> void inject(Context context, @Nullable C c16, TextMapSetter<C> textMapSetter);
}
