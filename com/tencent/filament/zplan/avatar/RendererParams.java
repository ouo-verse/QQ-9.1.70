package com.tencent.filament.zplan.avatar;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplan/avatar/RendererParams;", "", "clearOptions", "Lcom/tencent/filament/zplan/avatar/ClearOptions;", "(Lcom/tencent/filament/zplan/avatar/ClearOptions;)V", "getClearOptions", "()Lcom/tencent/filament/zplan/avatar/ClearOptions;", "setClearOptions", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class RendererParams {

    @NotNull
    private ClearOptions clearOptions;

    public RendererParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public final ClearOptions getClearOptions() {
        return this.clearOptions;
    }

    public final void setClearOptions(@NotNull ClearOptions clearOptions) {
        Intrinsics.checkNotNullParameter(clearOptions, "<set-?>");
        this.clearOptions = clearOptions;
    }

    public RendererParams(@NotNull ClearOptions clearOptions) {
        Intrinsics.checkNotNullParameter(clearOptions, "clearOptions");
        this.clearOptions = clearOptions;
    }

    public /* synthetic */ RendererParams(ClearOptions clearOptions, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ClearOptions(null, false, false, 7, null) : clearOptions);
    }
}
