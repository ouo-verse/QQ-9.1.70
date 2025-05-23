package com.tencent.kuikly.core.nvi.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u0018\u0010\u0017\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0015\u001a\u00020\u000fR\"\u0010\u001d\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u0018\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/kuikly/core/nvi/serialization/json/a;", "", "value", "", "c", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "", "d", "(Ljava/lang/Object;)Ljava/lang/Double;", "", "e", "(Ljava/lang/Object;)Ljava/lang/Integer;", "", "f", "(Ljava/lang/Object;)Ljava/lang/Long;", "", "g", "", "number", "a", "actual", "requiredType", "Lcom/tencent/kuikly/core/nvi/serialization/json/JSONException;", h.F, "b", "Z", "getUseNativeMethod", "()Z", "(Z)V", "useNativeMethod", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f117418a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean useNativeMethod;

    a() {
    }

    public final String a(Number number) throws JSONException {
        Intrinsics.checkNotNullParameter(number, "number");
        double doubleValue = number.doubleValue();
        long longValue = number.longValue();
        if (doubleValue == ((double) longValue)) {
            return String.valueOf(longValue);
        }
        return number.toString();
    }

    public final void b(boolean z16) {
        useNativeMethod = z16;
    }

    public final Boolean c(Object value) {
        boolean equals;
        boolean equals2;
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        if (value instanceof String) {
            String str = (String) value;
            equals = StringsKt__StringsJVMKt.equals("true", str, true);
            if (!equals) {
                equals2 = StringsKt__StringsJVMKt.equals("false", str, true);
                if (equals2) {
                    return Boolean.FALSE;
                }
                return null;
            }
            return Boolean.TRUE;
        }
        if (value instanceof Number) {
            return Boolean.valueOf(((Number) value).intValue() != 0);
        }
        return null;
    }

    public final Double d(Object value) {
        if (value instanceof Double) {
            return (Double) value;
        }
        if (value instanceof Number) {
            return Double.valueOf(((Number) value).doubleValue());
        }
        if (!(value instanceof String)) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble((String) value));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public final Integer e(Object value) {
        if (value instanceof Integer) {
            return (Integer) value;
        }
        if (value instanceof Number) {
            return Integer.valueOf(((Number) value).intValue());
        }
        if (!(value instanceof String)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) value));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public final Long f(Object value) {
        if (value instanceof Long) {
            return (Long) value;
        }
        if (value instanceof Number) {
            return Long.valueOf(((Number) value).longValue());
        }
        if (!(value instanceof String)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong((String) value));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public final String g(Object value) {
        if (value instanceof String) {
            return (String) value;
        }
        if (value != null) {
            return value.toString();
        }
        return null;
    }

    public final JSONException h(Object actual, String requiredType) throws JSONException {
        Intrinsics.checkNotNullParameter(requiredType, "requiredType");
        if (actual == null) {
            throw new JSONException("Value is null.");
        }
        throw new JSONException("Value " + actual + " of type " + Reflection.getOrCreateKotlinClass(actual.getClass()).getSimpleName() + " cannot be converted to " + requiredType);
    }
}
