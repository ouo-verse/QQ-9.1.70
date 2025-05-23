package com.tencent.kuikly.core.base;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u00a8\u0006\u0005"}, d2 = {"", "", "a", "", "b", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class i {
    public static final String a(int i3) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(i3, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        if (num.length() != 1) {
            return num;
        }
        return '0' + num;
    }

    public static final String b(long j3) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String l3 = Long.toString(j3, checkRadix);
        Intrinsics.checkNotNullExpressionValue(l3, "toString(this, checkRadix(radix))");
        if (l3.length() != 1) {
            return l3;
        }
        return '0' + l3;
    }
}
