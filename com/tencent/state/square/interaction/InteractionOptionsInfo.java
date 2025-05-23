package com.tencent.state.square.interaction;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionOptionsInfo;", "", "selectOrder", "Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "interactionOptions", "", "Lcom/tencent/state/square/interaction/InteractionOption;", "(Lcom/tencent/state/square/interaction/InteractionSelectOrder;Ljava/util/List;)V", "getInteractionOptions", "()Ljava/util/List;", "setInteractionOptions", "(Ljava/util/List;)V", "getSelectOrder", "()Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "setSelectOrder", "(Lcom/tencent/state/square/interaction/InteractionSelectOrder;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionOptionsInfo {
    private List<InteractionOption> interactionOptions;
    private InteractionSelectOrder selectOrder;

    public InteractionOptionsInfo(InteractionSelectOrder selectOrder, List<InteractionOption> interactionOptions) {
        Intrinsics.checkNotNullParameter(selectOrder, "selectOrder");
        Intrinsics.checkNotNullParameter(interactionOptions, "interactionOptions");
        this.selectOrder = selectOrder;
        this.interactionOptions = interactionOptions;
    }

    /* renamed from: component1, reason: from getter */
    public final InteractionSelectOrder getSelectOrder() {
        return this.selectOrder;
    }

    public final List<InteractionOption> component2() {
        return this.interactionOptions;
    }

    public final InteractionOptionsInfo copy(InteractionSelectOrder selectOrder, List<InteractionOption> interactionOptions) {
        Intrinsics.checkNotNullParameter(selectOrder, "selectOrder");
        Intrinsics.checkNotNullParameter(interactionOptions, "interactionOptions");
        return new InteractionOptionsInfo(selectOrder, interactionOptions);
    }

    public final List<InteractionOption> getInteractionOptions() {
        return this.interactionOptions;
    }

    public final InteractionSelectOrder getSelectOrder() {
        return this.selectOrder;
    }

    public int hashCode() {
        InteractionSelectOrder interactionSelectOrder = this.selectOrder;
        int hashCode = (interactionSelectOrder != null ? interactionSelectOrder.hashCode() : 0) * 31;
        List<InteractionOption> list = this.interactionOptions;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setInteractionOptions(List<InteractionOption> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.interactionOptions = list;
    }

    public final void setSelectOrder(InteractionSelectOrder interactionSelectOrder) {
        Intrinsics.checkNotNullParameter(interactionSelectOrder, "<set-?>");
        this.selectOrder = interactionSelectOrder;
    }

    public String toString() {
        return "InteractionOptionsInfo(selectOrder=" + this.selectOrder + ", interactionOptions=" + this.interactionOptions + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionOptionsInfo)) {
            return false;
        }
        InteractionOptionsInfo interactionOptionsInfo = (InteractionOptionsInfo) other;
        return Intrinsics.areEqual(this.selectOrder, interactionOptionsInfo.selectOrder) && Intrinsics.areEqual(this.interactionOptions, interactionOptionsInfo.interactionOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InteractionOptionsInfo copy$default(InteractionOptionsInfo interactionOptionsInfo, InteractionSelectOrder interactionSelectOrder, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            interactionSelectOrder = interactionOptionsInfo.selectOrder;
        }
        if ((i3 & 2) != 0) {
            list = interactionOptionsInfo.interactionOptions;
        }
        return interactionOptionsInfo.copy(interactionSelectOrder, list);
    }
}
