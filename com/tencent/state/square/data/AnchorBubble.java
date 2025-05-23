package com.tencent.state.square.data;

import android.graphics.Point;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/data/AnchorBubble;", "", "textBefore", "", "textAfter", "coordinate", "Landroid/graphics/Point;", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Point;)V", "getCoordinate", "()Landroid/graphics/Point;", "getTextAfter", "()Ljava/lang/String;", "getTextBefore", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class AnchorBubble {
    private final Point coordinate;
    private final String textAfter;
    private final String textBefore;

    public AnchorBubble() {
        this(null, null, null, 7, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTextBefore() {
        return this.textBefore;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTextAfter() {
        return this.textAfter;
    }

    /* renamed from: component3, reason: from getter */
    public final Point getCoordinate() {
        return this.coordinate;
    }

    public final AnchorBubble copy(String textBefore, String textAfter, Point coordinate) {
        Intrinsics.checkNotNullParameter(textBefore, "textBefore");
        Intrinsics.checkNotNullParameter(textAfter, "textAfter");
        Intrinsics.checkNotNullParameter(coordinate, "coordinate");
        return new AnchorBubble(textBefore, textAfter, coordinate);
    }

    public final Point getCoordinate() {
        return this.coordinate;
    }

    public final String getTextAfter() {
        return this.textAfter;
    }

    public final String getTextBefore() {
        return this.textBefore;
    }

    public int hashCode() {
        String str = this.textBefore;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.textAfter;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Point point = this.coordinate;
        return hashCode2 + (point != null ? point.hashCode() : 0);
    }

    public String toString() {
        return "AnchorBubble(textBefore=" + this.textBefore + ", textAfter=" + this.textAfter + ", coordinate=" + this.coordinate + ")";
    }

    public AnchorBubble(String textBefore, String textAfter, Point coordinate) {
        Intrinsics.checkNotNullParameter(textBefore, "textBefore");
        Intrinsics.checkNotNullParameter(textAfter, "textAfter");
        Intrinsics.checkNotNullParameter(coordinate, "coordinate");
        this.textBefore = textBefore;
        this.textAfter = textAfter;
        this.coordinate = coordinate;
    }

    public /* synthetic */ AnchorBubble(String str, String str2, Point point, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? new Point(0, 0) : point);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnchorBubble)) {
            return false;
        }
        AnchorBubble anchorBubble = (AnchorBubble) other;
        return Intrinsics.areEqual(this.textBefore, anchorBubble.textBefore) && Intrinsics.areEqual(this.textAfter, anchorBubble.textAfter) && Intrinsics.areEqual(this.coordinate, anchorBubble.coordinate);
    }

    public static /* synthetic */ AnchorBubble copy$default(AnchorBubble anchorBubble, String str, String str2, Point point, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = anchorBubble.textBefore;
        }
        if ((i3 & 2) != 0) {
            str2 = anchorBubble.textAfter;
        }
        if ((i3 & 4) != 0) {
            point = anchorBubble.coordinate;
        }
        return anchorBubble.copy(str, str2, point);
    }
}
