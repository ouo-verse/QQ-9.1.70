package com.tencent.richframework.compat.immersive.view;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/richframework/compat/immersive/view/RFWNavigationBarBackgroundView;", "Landroid/view/View;", "", "hasFixedDrawable", "Z", "getHasFixedDrawable", "()Z", "setHasFixedDrawable", "(Z)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWNavigationBarBackgroundView extends View {
    private boolean hasFixedDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWNavigationBarBackgroundView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setHasFixedDrawable(boolean z16) {
        this.hasFixedDrawable = z16;
    }
}
