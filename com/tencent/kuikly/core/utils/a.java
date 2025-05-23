package com.tencent.kuikly.core.utils;

import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\tJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/kuikly/core/utils/a;", "", "", "md5L16", "", "a", "value", "", "c", "", "d", "str16", "b", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f118267a = new a();

    a() {
    }

    public final boolean c(Object value) {
        if (value instanceof String) {
            return ((String) value).length() > 0;
        }
        if (value instanceof Number) {
            return !(((Number) value).floatValue() == 0.0f);
        }
        if (value instanceof Boolean) {
            return ((Boolean) value).booleanValue();
        }
        return value != null;
    }

    public final float d(float value) {
        int roundToInt;
        if (Float.isNaN(value)) {
            return 0.0f;
        }
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        if (cVar.g().getPageData().getIsIOS()) {
            return value;
        }
        float pagerDensity = cVar.g().pagerDensity();
        if (pagerDensity == 0.0f) {
            return value;
        }
        roundToInt = MathKt__MathJVMKt.roundToInt(value * pagerDensity);
        return roundToInt / pagerDensity;
    }

    private final long a(String md5L16) {
        byte[] encodeToByteArray;
        if (md5L16 != null) {
            String lowerCase = md5L16.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(lowerCase);
            long j3 = 0;
            for (byte b16 : encodeToByteArray) {
                long j16 = j3 << 4;
                byte b17 = (byte) (b16 - 48);
                if (b17 > 9) {
                    b17 = (byte) (b17 - 39);
                }
                if (b17 > 15 || b17 < 0) {
                    throw new RuntimeException("For input string '" + lowerCase);
                }
                j3 = j16 + b17;
            }
            return j3;
        }
        throw new RuntimeException("null");
    }

    public final long b(String str16) {
        boolean startsWith$default;
        if (str16 != null) {
            String lowerCase = str16.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, RelationNTPushServiceImpl.PRE_HEX_STRING, false, 2, null);
            if (startsWith$default) {
                lowerCase = lowerCase.substring(2);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).substring(startIndex)");
            }
            if (lowerCase.length() <= 16) {
                return a(lowerCase);
            }
            throw new RuntimeException("For input string '" + lowerCase + "' is to long");
        }
        throw new NumberFormatException("null");
    }
}
