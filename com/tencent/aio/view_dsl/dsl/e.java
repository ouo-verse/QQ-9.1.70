package com.tencent.aio.view_dsl.dsl;

import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\"(\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Landroid/widget/ProgressBar;", "", "value", "getIndeterminateDrawable_res", "(Landroid/widget/ProgressBar;)I", "a", "(Landroid/widget/ProgressBar;I)V", "indeterminateDrawable_res", "core_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class e {
    public static final void a(@NotNull ProgressBar indeterminateDrawable_res, int i3) {
        Intrinsics.checkNotNullParameter(indeterminateDrawable_res, "$this$indeterminateDrawable_res");
        indeterminateDrawable_res.setIndeterminateDrawable(ContextCompat.getDrawable(indeterminateDrawable_res.getContext(), i3));
    }
}
