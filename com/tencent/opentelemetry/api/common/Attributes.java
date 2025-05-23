package com.tencent.opentelemetry.api.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface Attributes {
    public static final IPatchRedirector $redirector_ = null;

    Map<AttributeKey<?>, Object> asMap();

    void forEach(BiConsumer<? super AttributeKey<?>, ? super Object> biConsumer);

    @Nullable
    <T> T get(AttributeKey<T> attributeKey);

    boolean isEmpty();

    int size();

    AttributesBuilder toBuilder();
}
