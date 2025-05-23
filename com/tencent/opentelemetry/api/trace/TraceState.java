package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface TraceState {
    public static final IPatchRedirector $redirector_ = null;

    Map<String, String> asMap();

    void forEach(BiConsumer<String, String> biConsumer);

    @Nullable
    String get(String str);

    boolean isEmpty();

    int size();

    TraceStateBuilder toBuilder();
}
