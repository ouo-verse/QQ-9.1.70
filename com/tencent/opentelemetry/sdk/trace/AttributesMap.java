package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class AttributesMap extends HashMap<AttributeKey<?>, Object> implements Attributes {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = -5072696312123632376L;
    private final long capacity;
    private final int lengthLimit;
    private int totalAddedValues;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttributesMap(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        this.totalAddedValues = 0;
        this.capacity = j3;
        this.lengthLimit = i3;
    }

    @Override // com.tencent.opentelemetry.api.common.Attributes
    public Map<AttributeKey<?>, Object> asMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return Collections.unmodifiableMap(this);
    }

    @Override // com.tencent.opentelemetry.api.common.Attributes
    @Nullable
    public <T> T get(AttributeKey<T> attributeKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) attributeKey);
        }
        return (T) super.get((Object) attributeKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTotalAddedValues() {
        return this.totalAddedValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Attributes immutableCopy() {
        return com.tencent.opentelemetry.api.common.f.a().putAll(this).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void put(AttributeKey<T> attributeKey, T t16) {
        this.totalAddedValues++;
        if (size() >= this.capacity && !containsKey(attributeKey)) {
            return;
        }
        super.put((AttributesMap) attributeKey, (AttributeKey<T>) AttributeUtil.applyAttributeLengthLimit(t16, this.lengthLimit));
    }

    @Override // com.tencent.opentelemetry.api.common.Attributes
    public AttributesBuilder toBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return com.tencent.opentelemetry.api.common.f.a().putAll(this);
    }

    @Override // java.util.AbstractMap
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "AttributesMap{data=" + super.toString() + ", capacity=" + this.capacity + ", totalAddedValues=" + this.totalAddedValues + '}';
    }
}
