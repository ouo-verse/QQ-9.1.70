package com.tencent.opentelemetry.api.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class f {
    public static AttributesBuilder a() {
        IPatchRedirector iPatchRedirector = Attributes.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 8);
        }
        return new ArrayBackedAttributesBuilder();
    }

    public static Attributes b() {
        IPatchRedirector iPatchRedirector = Attributes.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Attributes) iPatchRedirector.redirect((short) 1);
        }
        return ArrayBackedAttributes.EMPTY;
    }

    public static <T> Attributes c(AttributeKey<T> attributeKey, T t16) {
        IPatchRedirector iPatchRedirector = Attributes.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Attributes) iPatchRedirector.redirect((short) 2, (Object) attributeKey, (Object) t16);
        }
        return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t16);
    }

    public static <T, U> Attributes d(AttributeKey<T> attributeKey, T t16, AttributeKey<U> attributeKey2, U u16) {
        IPatchRedirector iPatchRedirector = Attributes.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Attributes) iPatchRedirector.redirect((short) 3, attributeKey, t16, attributeKey2, u16);
        }
        return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t16, attributeKey2, u16);
    }

    public static <T, U, V> Attributes e(AttributeKey<T> attributeKey, T t16, AttributeKey<U> attributeKey2, U u16, AttributeKey<V> attributeKey3, V v3) {
        IPatchRedirector iPatchRedirector = Attributes.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Attributes) iPatchRedirector.redirect((short) 4, attributeKey, t16, attributeKey2, u16, attributeKey3, v3);
        }
        return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t16, attributeKey2, u16, attributeKey3, v3);
    }

    public static <T, U, V, W> Attributes f(AttributeKey<T> attributeKey, T t16, AttributeKey<U> attributeKey2, U u16, AttributeKey<V> attributeKey3, V v3, AttributeKey<W> attributeKey4, W w3) {
        IPatchRedirector iPatchRedirector = Attributes.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Attributes) iPatchRedirector.redirect((short) 5, attributeKey, t16, attributeKey2, u16, attributeKey3, v3, attributeKey4, w3);
        }
        return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t16, attributeKey2, u16, attributeKey3, v3, attributeKey4, w3);
    }

    public static <T, U, V, W, X> Attributes g(AttributeKey<T> attributeKey, T t16, AttributeKey<U> attributeKey2, U u16, AttributeKey<V> attributeKey3, V v3, AttributeKey<W> attributeKey4, W w3, AttributeKey<X> attributeKey5, X x16) {
        IPatchRedirector iPatchRedirector = Attributes.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Attributes) iPatchRedirector.redirect((short) 6, attributeKey, t16, attributeKey2, u16, attributeKey3, v3, attributeKey4, w3, attributeKey5, x16);
        }
        return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t16, attributeKey2, u16, attributeKey3, v3, attributeKey4, w3, attributeKey5, x16);
    }

    public static <T, U, V, W, X, Y> Attributes h(AttributeKey<T> attributeKey, T t16, AttributeKey<U> attributeKey2, U u16, AttributeKey<V> attributeKey3, V v3, AttributeKey<W> attributeKey4, W w3, AttributeKey<X> attributeKey5, X x16, AttributeKey<Y> attributeKey6, Y y16) {
        IPatchRedirector iPatchRedirector = Attributes.$redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t16, attributeKey2, u16, attributeKey3, v3, attributeKey4, w3, attributeKey5, x16, attributeKey6, y16) : (Attributes) iPatchRedirector.redirect((short) 7, attributeKey, t16, attributeKey2, u16, attributeKey3, v3, attributeKey4, w3, attributeKey5, x16, attributeKey6, y16);
    }
}
