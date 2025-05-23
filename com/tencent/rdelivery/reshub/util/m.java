package com.tencent.rdelivery.reshub.util;

import com.tencent.rdelivery.reshub.api.TargetType;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u001a\u0010\u0006\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000\u001a\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007\u001a\n\u0010\n\u001a\u00020\u0007*\u00020\t\u001a\n\u0010\f\u001a\u00020\u0007*\u00020\u000b\u001a\u0012\u0010\u000e\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007\u00a8\u0006\u000f"}, d2 = {"", "str", "", "a", "str1", "str2", "b", "", "c", "Lcom/tencent/rdelivery/reshub/api/TargetType;", "e", "Lcom/tencent/rdelivery/reshub/core/a;", "f", "path", "d", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class m {
    public static final boolean a(@Nullable CharSequence charSequence) {
        boolean z16;
        if (charSequence == null) {
            return true;
        }
        if (charSequence.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    public static final boolean b(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if (charSequence != null && Intrinsics.areEqual(charSequence, charSequence2)) {
            return true;
        }
        return false;
    }

    public static final boolean c(@Nullable String str, @Nullable String str2) {
        boolean z16;
        boolean equals;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            equals = StringsKt__StringsJVMKt.equals(str, str2, true);
            if (!equals) {
                return false;
            }
            return true;
        }
        return false;
    }

    @NotNull
    public static final String d(@NotNull String joinPath, @NotNull String path) {
        boolean endsWith$default;
        Intrinsics.checkParameterIsNotNull(joinPath, "$this$joinPath");
        Intrinsics.checkParameterIsNotNull(path, "path");
        String str = File.separator;
        Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(joinPath, str, false, 2, null);
        if (endsWith$default) {
            return joinPath + path;
        }
        return joinPath + str + path;
    }

    @NotNull
    public static final String e(@NotNull TargetType toStrValue) {
        Intrinsics.checkParameterIsNotNull(toStrValue, "$this$toStrValue");
        int i3 = l.f364604a[toStrValue.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return "project";
            }
            throw new NoWhenBranchMatchedException();
        }
        return "app";
    }

    @NotNull
    public static final String f(@NotNull com.tencent.rdelivery.reshub.core.a toStrValue) {
        Intrinsics.checkParameterIsNotNull(toStrValue, "$this$toStrValue");
        return "appId=" + toStrValue.c() + "target=" + e(toStrValue.getTarget()) + "env=" + toStrValue.i();
    }
}
