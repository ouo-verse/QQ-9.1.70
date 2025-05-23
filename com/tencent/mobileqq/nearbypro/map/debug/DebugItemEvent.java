package com.tencent.mobileqq.nearbypro.map.debug;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/debug/DebugItemEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/nearbypro/map/debug/b;", "component1", "options", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/nearbypro/map/debug/b;", "getOptions", "()Lcom/tencent/mobileqq/nearbypro/map/debug/b;", "setOptions", "(Lcom/tencent/mobileqq/nearbypro/map/debug/b;)V", "<init>", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final /* data */ class DebugItemEvent extends SimpleBaseEvent {

    @NotNull
    private DebugOptions options;

    public DebugItemEvent(@NotNull DebugOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
    }

    public static /* synthetic */ DebugItemEvent copy$default(DebugItemEvent debugItemEvent, DebugOptions debugOptions, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            debugOptions = debugItemEvent.options;
        }
        return debugItemEvent.copy(debugOptions);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final DebugOptions getOptions() {
        return this.options;
    }

    @NotNull
    public final DebugItemEvent copy(@NotNull DebugOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        return new DebugItemEvent(options);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof DebugItemEvent) && Intrinsics.areEqual(this.options, ((DebugItemEvent) other).options)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final DebugOptions getOptions() {
        return this.options;
    }

    public int hashCode() {
        return this.options.hashCode();
    }

    public final void setOptions(@NotNull DebugOptions debugOptions) {
        Intrinsics.checkNotNullParameter(debugOptions, "<set-?>");
        this.options = debugOptions;
    }

    @NotNull
    public String toString() {
        return "DebugItemEvent(options=" + this.options + ")";
    }
}
