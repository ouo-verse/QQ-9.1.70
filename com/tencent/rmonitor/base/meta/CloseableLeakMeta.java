package com.tencent.rmonitor.base.meta;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/rmonitor/base/meta/CloseableLeakMeta;", "Lcom/tencent/rmonitor/base/meta/MonitorMeta;", "stack", "", "(Ljava/lang/String;)V", "getStack", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final /* data */ class CloseableLeakMeta extends MonitorMeta {

    @NotNull
    private final String stack;

    public CloseableLeakMeta(@NotNull String stack) {
        Intrinsics.checkParameterIsNotNull(stack, "stack");
        this.stack = stack;
    }

    public static /* synthetic */ CloseableLeakMeta copy$default(CloseableLeakMeta closeableLeakMeta, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = closeableLeakMeta.stack;
        }
        return closeableLeakMeta.copy(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getStack() {
        return this.stack;
    }

    @NotNull
    public final CloseableLeakMeta copy(@NotNull String stack) {
        Intrinsics.checkParameterIsNotNull(stack, "stack");
        return new CloseableLeakMeta(stack);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof CloseableLeakMeta) || !Intrinsics.areEqual(this.stack, ((CloseableLeakMeta) other).stack)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @NotNull
    public final String getStack() {
        return this.stack;
    }

    public int hashCode() {
        String str = this.stack;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "CloseableLeakMeta(stack=" + this.stack + ")";
    }
}
