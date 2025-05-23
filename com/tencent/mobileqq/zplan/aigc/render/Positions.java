package com.tencent.mobileqq.zplan.aigc.render;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/Positions;", "", "rotationType", "", "position", "", "", "(ILjava/util/List;)V", "getPosition", "()Ljava/util/List;", "getRotationType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class Positions {
    private final List<Double> position;
    private final int rotationType;

    public Positions(int i3, List<Double> position) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.rotationType = i3;
        this.position = position;
    }

    /* renamed from: component1, reason: from getter */
    public final int getRotationType() {
        return this.rotationType;
    }

    public final List<Double> component2() {
        return this.position;
    }

    public final Positions copy(int rotationType, List<Double> position) {
        Intrinsics.checkNotNullParameter(position, "position");
        return new Positions(rotationType, position);
    }

    public final List<Double> getPosition() {
        return this.position;
    }

    public final int getRotationType() {
        return this.rotationType;
    }

    public int hashCode() {
        return (this.rotationType * 31) + this.position.hashCode();
    }

    public String toString() {
        return "Positions(rotationType=" + this.rotationType + ", position=" + this.position + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Positions copy$default(Positions positions, int i3, List list, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = positions.rotationType;
        }
        if ((i16 & 2) != 0) {
            list = positions.position;
        }
        return positions.copy(i3, list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Positions)) {
            return false;
        }
        Positions positions = (Positions) other;
        return this.rotationType == positions.rotationType && Intrinsics.areEqual(this.position, positions.position);
    }
}
