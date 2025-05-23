package com.tencent.biz.richframework.ext;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u0001\u00a8\u0006\u0007"}, d2 = {"", "", "default", "radix", "toIntOrDefault", "", "toLongOrDefault", "common_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWStringsKt {
    public static final int toIntOrDefault(@NotNull String toIntOrDefault, int i3, int i16) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(toIntOrDefault, "$this$toIntOrDefault");
        try {
            checkRadix = CharsKt__CharJVMKt.checkRadix(i16);
            return Integer.parseInt(toIntOrDefault, checkRadix);
        } catch (Exception e16) {
            RFWLog.fatal("RFWStringsKt", RFWLog.USR, e16);
            return i3;
        }
    }

    public static /* synthetic */ int toIntOrDefault$default(String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = 10;
        }
        return toIntOrDefault(str, i3, i16);
    }

    public static final long toLongOrDefault(@NotNull String toLongOrDefault, long j3, int i3) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(toLongOrDefault, "$this$toLongOrDefault");
        try {
            checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
            return Long.parseLong(toLongOrDefault, checkRadix);
        } catch (Exception e16) {
            RFWLog.fatal("RFWStringsKt", RFWLog.USR, e16);
            return j3;
        }
    }

    public static /* synthetic */ long toLongOrDefault$default(String str, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 10;
        }
        return toLongOrDefault(str, j3, i3);
    }
}
