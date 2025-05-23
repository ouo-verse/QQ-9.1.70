package com.tencent.opentelemetry.api.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ArrayBackedAttributesBuilder implements AttributesBuilder {
    static IPatchRedirector $redirector_;
    private final List<Object> data;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayBackedAttributesBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.data = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putAll$0(AttributeKey attributeKey, Object obj) {
        put((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$remove$1(AttributeKey attributeKey, AttributeKey attributeKey2) {
        if (attributeKey.getKey().equals(attributeKey2.getKey()) && attributeKey.getType().equals(attributeKey2.getType())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Double> toList(double... dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i3 = 0; i3 < dArr.length; i3++) {
            dArr2[i3] = Double.valueOf(dArr[i3]);
        }
        return Arrays.asList(dArr2);
    }

    @Override // com.tencent.opentelemetry.api.common.AttributesBuilder
    public Attributes build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Attributes) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.data.size() == 2 && this.data.get(0) != null) {
            return new ArrayBackedAttributes(this.data.toArray());
        }
        return ArrayBackedAttributes.sortAndFilterToAttributes(this.data.toArray());
    }

    @Override // com.tencent.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, double d16) {
        return g.a(this, str, d16);
    }

    @Override // com.tencent.opentelemetry.api.common.AttributesBuilder
    public AttributesBuilder putAll(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) attributes);
        }
        if (attributes == null) {
            return this;
        }
        attributes.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.api.common.c
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ArrayBackedAttributesBuilder.this.lambda$putAll$0((AttributeKey) obj, obj2);
            }
        });
        return this;
    }

    @Override // com.tencent.opentelemetry.api.common.AttributesBuilder
    public <T> AttributesBuilder remove(final AttributeKey<T> attributeKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) attributeKey);
        }
        if (attributeKey != null && !attributeKey.getKey().isEmpty()) {
            return removeIf(new Predicate() { // from class: com.tencent.opentelemetry.api.common.d
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean lambda$remove$1;
                    lambda$remove$1 = ArrayBackedAttributesBuilder.lambda$remove$1(AttributeKey.this, (AttributeKey) obj);
                    return lambda$remove$1;
                }
            });
        }
        return this;
    }

    @Override // com.tencent.opentelemetry.api.common.AttributesBuilder
    public AttributesBuilder removeIf(Predicate<AttributeKey<?>> predicate) {
        boolean test;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) predicate);
        }
        if (predicate == null) {
            return this;
        }
        for (int i3 = 0; i3 < this.data.size() - 1; i3 += 2) {
            Object obj = this.data.get(i3);
            if (obj instanceof AttributeKey) {
                test = predicate.test((AttributeKey) obj);
                if (test) {
                    this.data.set(i3, null);
                    this.data.set(i3 + 1, null);
                }
            }
        }
        return this;
    }

    @Override // com.tencent.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, long j3) {
        return g.b(this, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayBackedAttributesBuilder(List<Object> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.data = list;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        }
    }

    @Override // com.tencent.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, String str2) {
        return g.c(this, str, str2);
    }

    @Override // com.tencent.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, boolean z16) {
        return g.d(this, str, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Long> toList(long... jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i3 = 0; i3 < jArr.length; i3++) {
            lArr[i3] = Long.valueOf(jArr[i3]);
        }
        return Arrays.asList(lArr);
    }

    @Override // com.tencent.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, double... dArr) {
        return g.e(this, str, dArr);
    }

    @Override // com.tencent.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, long... jArr) {
        return g.f(this, str, jArr);
    }

    @Override // com.tencent.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, String... strArr) {
        return g.g(this, str, strArr);
    }

    @Override // com.tencent.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, boolean... zArr) {
        return g.h(this, str, zArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Boolean> toList(boolean... zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i3 = 0; i3 < zArr.length; i3++) {
            boolArr[i3] = Boolean.valueOf(zArr[i3]);
        }
        return Arrays.asList(boolArr);
    }

    @Override // com.tencent.opentelemetry.api.common.AttributesBuilder
    public <T> AttributesBuilder put(AttributeKey<Long> attributeKey, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? put((AttributeKey<AttributeKey<Long>>) attributeKey, (AttributeKey<Long>) Long.valueOf(i3)) : (AttributesBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) attributeKey, i3);
    }

    @Override // com.tencent.opentelemetry.api.common.AttributesBuilder
    public <T> AttributesBuilder put(AttributeKey<T> attributeKey, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) attributeKey, (Object) t16);
        }
        if (attributeKey != null && !attributeKey.getKey().isEmpty() && t16 != null) {
            this.data.add(attributeKey);
            this.data.add(t16);
        }
        return this;
    }
}
