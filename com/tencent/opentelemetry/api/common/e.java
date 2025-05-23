package com.tencent.opentelemetry.api.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.internal.InternalAttributeKeyImpl;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class e<T> {
    public static AttributeKey<List<Boolean>> a(String str) {
        IPatchRedirector iPatchRedirector = AttributeKey.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AttributeKey) iPatchRedirector.redirect((short) 6, (Object) str);
        }
        return InternalAttributeKeyImpl.create(str, AttributeType.BOOLEAN_ARRAY);
    }

    public static AttributeKey<Boolean> b(String str) {
        IPatchRedirector iPatchRedirector = AttributeKey.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AttributeKey) iPatchRedirector.redirect((short) 2, (Object) str);
        }
        return InternalAttributeKeyImpl.create(str, AttributeType.BOOLEAN);
    }

    public static AttributeKey<List<Double>> c(String str) {
        IPatchRedirector iPatchRedirector = AttributeKey.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AttributeKey) iPatchRedirector.redirect((short) 8, (Object) str);
        }
        return InternalAttributeKeyImpl.create(str, AttributeType.DOUBLE_ARRAY);
    }

    public static AttributeKey<Double> d(String str) {
        IPatchRedirector iPatchRedirector = AttributeKey.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AttributeKey) iPatchRedirector.redirect((short) 4, (Object) str);
        }
        return InternalAttributeKeyImpl.create(str, AttributeType.DOUBLE);
    }

    public static AttributeKey<List<Long>> e(String str) {
        IPatchRedirector iPatchRedirector = AttributeKey.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AttributeKey) iPatchRedirector.redirect((short) 7, (Object) str);
        }
        return InternalAttributeKeyImpl.create(str, AttributeType.LONG_ARRAY);
    }

    public static AttributeKey<Long> f(String str) {
        IPatchRedirector iPatchRedirector = AttributeKey.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AttributeKey) iPatchRedirector.redirect((short) 3, (Object) str);
        }
        return InternalAttributeKeyImpl.create(str, AttributeType.LONG);
    }

    public static AttributeKey<List<String>> g(String str) {
        IPatchRedirector iPatchRedirector = AttributeKey.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AttributeKey) iPatchRedirector.redirect((short) 5, (Object) str);
        }
        return InternalAttributeKeyImpl.create(str, AttributeType.STRING_ARRAY);
    }

    public static AttributeKey<String> h(String str) {
        IPatchRedirector iPatchRedirector = AttributeKey.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (AttributeKey) iPatchRedirector.redirect((short) 1, (Object) str);
        }
        return InternalAttributeKeyImpl.create(str, AttributeType.STRING);
    }
}
