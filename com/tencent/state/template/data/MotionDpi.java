package com.tencent.state.template.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/template/data/MotionDpi;", "", "recordDpi", "Lcom/tencent/state/template/data/Dpi;", "showDpi", "(Lcom/tencent/state/template/data/Dpi;Lcom/tencent/state/template/data/Dpi;)V", "getRecordDpi", "()Lcom/tencent/state/template/data/Dpi;", "getShowDpi", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MotionDpi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Dpi recordDpi;
    private final Dpi showDpi;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/state/template/data/MotionDpi$Companion;", "", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MotionDpi(Dpi recordDpi, Dpi showDpi) {
        Intrinsics.checkNotNullParameter(recordDpi, "recordDpi");
        Intrinsics.checkNotNullParameter(showDpi, "showDpi");
        this.recordDpi = recordDpi;
        this.showDpi = showDpi;
    }

    /* renamed from: component1, reason: from getter */
    public final Dpi getRecordDpi() {
        return this.recordDpi;
    }

    /* renamed from: component2, reason: from getter */
    public final Dpi getShowDpi() {
        return this.showDpi;
    }

    public final MotionDpi copy(Dpi recordDpi, Dpi showDpi) {
        Intrinsics.checkNotNullParameter(recordDpi, "recordDpi");
        Intrinsics.checkNotNullParameter(showDpi, "showDpi");
        return new MotionDpi(recordDpi, showDpi);
    }

    public final Dpi getRecordDpi() {
        return this.recordDpi;
    }

    public final Dpi getShowDpi() {
        return this.showDpi;
    }

    public int hashCode() {
        Dpi dpi = this.recordDpi;
        int hashCode = (dpi != null ? dpi.hashCode() : 0) * 31;
        Dpi dpi2 = this.showDpi;
        return hashCode + (dpi2 != null ? dpi2.hashCode() : 0);
    }

    public String toString() {
        return "MotionDpi(recordDpi=" + this.recordDpi + ", showDpi=" + this.showDpi + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MotionDpi)) {
            return false;
        }
        MotionDpi motionDpi = (MotionDpi) other;
        return Intrinsics.areEqual(this.recordDpi, motionDpi.recordDpi) && Intrinsics.areEqual(this.showDpi, motionDpi.showDpi);
    }

    public static /* synthetic */ MotionDpi copy$default(MotionDpi motionDpi, Dpi dpi, Dpi dpi2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            dpi = motionDpi.recordDpi;
        }
        if ((i3 & 2) != 0) {
            dpi2 = motionDpi.showDpi;
        }
        return motionDpi.copy(dpi, dpi2);
    }
}
