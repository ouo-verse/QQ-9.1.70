package com.tencent.state.square.interaction.record;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/interaction/record/InteractionRecordTipData;", "", "tip", "", "(Ljava/lang/String;)V", "getTip", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionRecordTipData {
    private final String tip;

    public InteractionRecordTipData(String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        this.tip = tip;
    }

    /* renamed from: component1, reason: from getter */
    public final String getTip() {
        return this.tip;
    }

    public final InteractionRecordTipData copy(String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        return new InteractionRecordTipData(tip);
    }

    public final String getTip() {
        return this.tip;
    }

    public int hashCode() {
        String str = this.tip;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "InteractionRecordTipData(tip=" + this.tip + ")";
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof InteractionRecordTipData) && Intrinsics.areEqual(this.tip, ((InteractionRecordTipData) other).tip);
        }
        return true;
    }

    public static /* synthetic */ InteractionRecordTipData copy$default(InteractionRecordTipData interactionRecordTipData, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = interactionRecordTipData.tip;
        }
        return interactionRecordTipData.copy(str);
    }
}
