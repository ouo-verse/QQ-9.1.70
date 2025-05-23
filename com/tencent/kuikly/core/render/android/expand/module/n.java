package com.tencent.kuikly.core.render.android.expand.module;

import com.tencent.kuikly.core.render.android.expand.vendor.KRReflect;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a1\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "", "name", "", "", "args", "a", "(Lcom/tencent/kuikly/core/render/android/expand/vendor/a;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "core-render-android_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class n {
    @NotNull
    public static final KRReflect a(@NotNull KRReflect callMethod, @NotNull String name, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(callMethod, "$this$callMethod");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        if (Intrinsics.areEqual(name, "newInstance") && callMethod.e() == null) {
            return callMethod.k(Arrays.copyOf(args, args.length));
        }
        return callMethod.c(name, Arrays.copyOf(args, args.length));
    }
}
