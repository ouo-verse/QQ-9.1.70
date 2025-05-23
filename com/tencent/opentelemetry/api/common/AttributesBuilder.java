package com.tencent.opentelemetry.api.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.function.Predicate;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface AttributesBuilder {
    public static final IPatchRedirector $redirector_ = null;

    Attributes build();

    <T> AttributesBuilder put(AttributeKey<Long> attributeKey, int i3);

    <T> AttributesBuilder put(AttributeKey<T> attributeKey, T t16);

    AttributesBuilder put(String str, double d16);

    AttributesBuilder put(String str, long j3);

    AttributesBuilder put(String str, String str2);

    AttributesBuilder put(String str, boolean z16);

    AttributesBuilder put(String str, double... dArr);

    AttributesBuilder put(String str, long... jArr);

    AttributesBuilder put(String str, String... strArr);

    AttributesBuilder put(String str, boolean... zArr);

    AttributesBuilder putAll(Attributes attributes);

    <T> AttributesBuilder remove(AttributeKey<T> attributeKey);

    AttributesBuilder removeIf(Predicate<AttributeKey<?>> predicate);
}
