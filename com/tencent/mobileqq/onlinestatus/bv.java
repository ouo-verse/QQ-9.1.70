package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a.\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0000H\u0007\u00a8\u0006\b"}, d2 = {"", "tValue", "", "from", "revFlag1", "revFlag4", "", "d", "qqonlinestatus-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class bv {
    @JvmOverloads
    public static final void a(@NotNull String tValue) {
        Intrinsics.checkNotNullParameter(tValue, "tValue");
        e(tValue, 0, null, null, 14, null);
    }

    @JvmOverloads
    public static final void b(@NotNull String tValue, int i3) {
        Intrinsics.checkNotNullParameter(tValue, "tValue");
        e(tValue, i3, null, null, 12, null);
    }

    @JvmOverloads
    public static final void c(@NotNull String tValue, int i3, @NotNull String revFlag1) {
        Intrinsics.checkNotNullParameter(tValue, "tValue");
        Intrinsics.checkNotNullParameter(revFlag1, "revFlag1");
        e(tValue, i3, revFlag1, null, 8, null);
    }

    @JvmOverloads
    public static final void d(@NotNull String tValue, int i3, @NotNull String revFlag1, @NotNull String revFlag4) {
        Intrinsics.checkNotNullParameter(tValue, "tValue");
        Intrinsics.checkNotNullParameter(revFlag1, "revFlag1");
        Intrinsics.checkNotNullParameter(revFlag4, "revFlag4");
        ReportController.o(null, "dc00898", "", "", tValue, tValue, i3, 0, revFlag1, "", revFlag4, "");
    }

    public static /* synthetic */ void e(String str, int i3, String str2, String str3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        if ((i16 & 8) != 0) {
            str3 = "";
        }
        d(str, i3, str2, str3);
    }
}
