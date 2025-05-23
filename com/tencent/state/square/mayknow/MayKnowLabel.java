package com.tencent.state.square.mayknow;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/mayknow/MayKnowLabel;", "", "name", "", "labelType", "", "(Ljava/lang/String;I)V", "getLabelType", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MayKnowLabel {
    private final int labelType;
    private final String name;

    public MayKnowLabel(String name, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.labelType = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLabelType() {
        return this.labelType;
    }

    public final MayKnowLabel copy(String name, int labelType) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MayKnowLabel(name, labelType);
    }

    public final int getLabelType() {
        return this.labelType;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        return ((str != null ? str.hashCode() : 0) * 31) + this.labelType;
    }

    public String toString() {
        return "MayKnowLabel(name=" + this.name + ", labelType=" + this.labelType + ")";
    }

    public /* synthetic */ MayKnowLabel(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? 0 : i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MayKnowLabel)) {
            return false;
        }
        MayKnowLabel mayKnowLabel = (MayKnowLabel) other;
        return Intrinsics.areEqual(this.name, mayKnowLabel.name) && this.labelType == mayKnowLabel.labelType;
    }

    public static /* synthetic */ MayKnowLabel copy$default(MayKnowLabel mayKnowLabel, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = mayKnowLabel.name;
        }
        if ((i16 & 2) != 0) {
            i3 = mayKnowLabel.labelType;
        }
        return mayKnowLabel.copy(str, i3);
    }
}
