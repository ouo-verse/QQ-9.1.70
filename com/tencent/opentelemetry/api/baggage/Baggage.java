package com.tencent.opentelemetry.api.baggage;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.context.ImplicitContextKeyed;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface Baggage extends ImplicitContextKeyed {
    public static final IPatchRedirector $redirector_ = null;

    Map<String, BaggageEntry> asMap();

    void forEach(BiConsumer<? super String, ? super BaggageEntry> biConsumer);

    @Nullable
    String getEntryValue(String str);

    boolean isEmpty();

    int size();

    @Override // com.tencent.opentelemetry.context.ImplicitContextKeyed
    Context storeInContext(Context context);

    BaggageBuilder toBuilder();
}
