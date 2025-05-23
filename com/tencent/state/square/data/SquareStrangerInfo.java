package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/data/SquareStrangerInfo;", "", "source", "", "labelText", "", "(ILjava/lang/String;)V", "getLabelText", "()Ljava/lang/String;", "getSource", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareStrangerInfo {
    private final String labelText;
    private final int source;

    public SquareStrangerInfo(int i3, String labelText) {
        Intrinsics.checkNotNullParameter(labelText, "labelText");
        this.source = i3;
        this.labelText = labelText;
    }

    /* renamed from: component1, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLabelText() {
        return this.labelText;
    }

    public final SquareStrangerInfo copy(int source, String labelText) {
        Intrinsics.checkNotNullParameter(labelText, "labelText");
        return new SquareStrangerInfo(source, labelText);
    }

    public final String getLabelText() {
        return this.labelText;
    }

    public final int getSource() {
        return this.source;
    }

    public int hashCode() {
        int i3 = this.source * 31;
        String str = this.labelText;
        return i3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "SquareStrangerInfo(source=" + this.source + ", labelText=" + this.labelText + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareStrangerInfo)) {
            return false;
        }
        SquareStrangerInfo squareStrangerInfo = (SquareStrangerInfo) other;
        return this.source == squareStrangerInfo.source && Intrinsics.areEqual(this.labelText, squareStrangerInfo.labelText);
    }

    public static /* synthetic */ SquareStrangerInfo copy$default(SquareStrangerInfo squareStrangerInfo, int i3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = squareStrangerInfo.source;
        }
        if ((i16 & 2) != 0) {
            str = squareStrangerInfo.labelText;
        }
        return squareStrangerInfo.copy(i3, str);
    }
}
