package com.tencent.opentelemetry.api.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class g {
    public static AttributesBuilder a(AttributesBuilder attributesBuilder, String str, double d16) {
        IPatchRedirector iPatchRedirector = AttributesBuilder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 3, attributesBuilder, str, Double.valueOf(d16));
        }
        return attributesBuilder.put((AttributeKey<AttributeKey<Double>>) e.d(str), (AttributeKey<Double>) Double.valueOf(d16));
    }

    public static AttributesBuilder b(AttributesBuilder attributesBuilder, String str, long j3) {
        IPatchRedirector iPatchRedirector = AttributesBuilder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 2, attributesBuilder, str, Long.valueOf(j3));
        }
        return attributesBuilder.put((AttributeKey<AttributeKey<Long>>) e.f(str), (AttributeKey<Long>) Long.valueOf(j3));
    }

    public static AttributesBuilder c(AttributesBuilder attributesBuilder, String str, String str2) {
        IPatchRedirector iPatchRedirector = AttributesBuilder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 1, (Object) attributesBuilder, (Object) str, (Object) str2);
        }
        return attributesBuilder.put((AttributeKey<AttributeKey<String>>) e.h(str), (AttributeKey<String>) str2);
    }

    public static AttributesBuilder d(AttributesBuilder attributesBuilder, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = AttributesBuilder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 4, attributesBuilder, str, Boolean.valueOf(z16));
        }
        return attributesBuilder.put((AttributeKey<AttributeKey<Boolean>>) e.b(str), (AttributeKey<Boolean>) Boolean.valueOf(z16));
    }

    public static AttributesBuilder e(AttributesBuilder attributesBuilder, String str, double... dArr) {
        IPatchRedirector iPatchRedirector = AttributesBuilder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 7, (Object) attributesBuilder, (Object) str, (Object) dArr);
        }
        if (dArr == null) {
            return attributesBuilder;
        }
        return attributesBuilder.put((AttributeKey<AttributeKey<List<Double>>>) e.c(str), (AttributeKey<List<Double>>) ArrayBackedAttributesBuilder.toList(dArr));
    }

    public static AttributesBuilder f(AttributesBuilder attributesBuilder, String str, long... jArr) {
        IPatchRedirector iPatchRedirector = AttributesBuilder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 6, (Object) attributesBuilder, (Object) str, (Object) jArr);
        }
        if (jArr == null) {
            return attributesBuilder;
        }
        return attributesBuilder.put((AttributeKey<AttributeKey<List<Long>>>) e.e(str), (AttributeKey<List<Long>>) ArrayBackedAttributesBuilder.toList(jArr));
    }

    public static AttributesBuilder g(AttributesBuilder attributesBuilder, String str, String... strArr) {
        IPatchRedirector iPatchRedirector = AttributesBuilder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 5, (Object) attributesBuilder, (Object) str, (Object) strArr);
        }
        if (strArr == null) {
            return attributesBuilder;
        }
        return attributesBuilder.put((AttributeKey<AttributeKey<List<String>>>) e.g(str), (AttributeKey<List<String>>) Arrays.asList(strArr));
    }

    public static AttributesBuilder h(AttributesBuilder attributesBuilder, String str, boolean... zArr) {
        IPatchRedirector iPatchRedirector = AttributesBuilder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 8, (Object) attributesBuilder, (Object) str, (Object) zArr);
        }
        if (zArr == null) {
            return attributesBuilder;
        }
        return attributesBuilder.put((AttributeKey<AttributeKey<List<Boolean>>>) e.a(str), (AttributeKey<List<Boolean>>) ArrayBackedAttributesBuilder.toList(zArr));
    }

    public static AttributesBuilder i(AttributesBuilder attributesBuilder, AttributeKey attributeKey) {
        IPatchRedirector iPatchRedirector = AttributesBuilder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 9, (Object) attributesBuilder, (Object) attributeKey);
        }
        return attributesBuilder;
    }

    public static AttributesBuilder j(AttributesBuilder attributesBuilder, Predicate predicate) {
        IPatchRedirector iPatchRedirector = AttributesBuilder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 10, (Object) attributesBuilder, (Object) predicate);
        }
        return attributesBuilder;
    }
}
