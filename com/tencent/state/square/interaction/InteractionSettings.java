package com.tencent.state.square.interaction;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pt4.j;
import pt4.r;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001b\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0003J#\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/interaction/InteractionSettings;", "", "Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "component1", "", "Lcom/tencent/state/square/interaction/InteractionSettingOption;", "component2", "selectOrder", "interactionOptions", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "getSelectOrder", "()Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "setSelectOrder", "(Lcom/tencent/state/square/interaction/InteractionSelectOrder;)V", "Ljava/util/List;", "getInteractionOptions", "()Ljava/util/List;", "setInteractionOptions", "(Ljava/util/List;)V", "<init>", "(Lcom/tencent/state/square/interaction/InteractionSelectOrder;Ljava/util/List;)V", "Lpt4/j;", "pb", "(Lpt4/j;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionSettings {
    private List<InteractionSettingOption> interactionOptions;
    private InteractionSelectOrder selectOrder;

    public InteractionSettings(InteractionSelectOrder selectOrder, List<InteractionSettingOption> interactionOptions) {
        Intrinsics.checkNotNullParameter(selectOrder, "selectOrder");
        Intrinsics.checkNotNullParameter(interactionOptions, "interactionOptions");
        this.selectOrder = selectOrder;
        this.interactionOptions = interactionOptions;
    }

    /* renamed from: component1, reason: from getter */
    public final InteractionSelectOrder getSelectOrder() {
        return this.selectOrder;
    }

    public final List<InteractionSettingOption> component2() {
        return this.interactionOptions;
    }

    public final InteractionSettings copy(InteractionSelectOrder selectOrder, List<InteractionSettingOption> interactionOptions) {
        Intrinsics.checkNotNullParameter(selectOrder, "selectOrder");
        Intrinsics.checkNotNullParameter(interactionOptions, "interactionOptions");
        return new InteractionSettings(selectOrder, interactionOptions);
    }

    public final List<InteractionSettingOption> getInteractionOptions() {
        return this.interactionOptions;
    }

    public final InteractionSelectOrder getSelectOrder() {
        return this.selectOrder;
    }

    public int hashCode() {
        InteractionSelectOrder interactionSelectOrder = this.selectOrder;
        int hashCode = (interactionSelectOrder != null ? interactionSelectOrder.hashCode() : 0) * 31;
        List<InteractionSettingOption> list = this.interactionOptions;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setInteractionOptions(List<InteractionSettingOption> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.interactionOptions = list;
    }

    public final void setSelectOrder(InteractionSelectOrder interactionSelectOrder) {
        Intrinsics.checkNotNullParameter(interactionSelectOrder, "<set-?>");
        this.selectOrder = interactionSelectOrder;
    }

    public String toString() {
        return "InteractionSettings(selectOrder=" + this.selectOrder + ", interactionOptions=" + this.interactionOptions + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InteractionSettings(j pb5) {
        this(r0, r1);
        List emptyList;
        Intrinsics.checkNotNullParameter(pb5, "pb");
        InteractionSelectOrder interactionSelectOrder = InteractionSelectOrder.RANDOM;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.selectOrder = InteractionSelectOrder.INSTANCE.parsePB(pb5.f427177b);
        r[] rVarArr = pb5.f427176a;
        Intrinsics.checkNotNullExpressionValue(rVarArr, "pb.options");
        ArrayList arrayList = new ArrayList(rVarArr.length);
        for (r it : rVarArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(new InteractionSettingOption(it));
        }
        this.interactionOptions = arrayList;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionSettings)) {
            return false;
        }
        InteractionSettings interactionSettings = (InteractionSettings) other;
        return Intrinsics.areEqual(this.selectOrder, interactionSettings.selectOrder) && Intrinsics.areEqual(this.interactionOptions, interactionSettings.interactionOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InteractionSettings copy$default(InteractionSettings interactionSettings, InteractionSelectOrder interactionSelectOrder, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            interactionSelectOrder = interactionSettings.selectOrder;
        }
        if ((i3 & 2) != 0) {
            list = interactionSettings.interactionOptions;
        }
        return interactionSettings.copy(interactionSelectOrder, list);
    }
}
