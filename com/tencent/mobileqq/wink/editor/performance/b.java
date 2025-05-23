package com.tencent.mobileqq.wink.editor.performance;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0007"}, d2 = {"", "renderNodeCostInMs", "", "a", "", "decimals", "b", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {
    public static final double a(long j3) {
        return 1000 / j3;
    }

    public static final double b(double d16, int i3) {
        String format = String.format(Locale.US, "%." + i3 + "f", Arrays.copyOf(new Object[]{Double.valueOf(d16)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, this, *args)");
        return Double.parseDouble(format);
    }

    public static /* synthetic */ double c(double d16, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 2;
        }
        return b(d16, i3);
    }
}
