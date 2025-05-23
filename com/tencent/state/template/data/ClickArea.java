package com.tencent.state.template.data;

import android.graphics.Point;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0006J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/template/data/ClickArea;", "", "isClickable", "", "points", "", "Landroid/graphics/Point;", "(ZLjava/util/List;)V", "()Z", "getPoints", "()Ljava/util/List;", "component1", "component2", "contains", "point", "copy", "equals", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class ClickArea {
    private final boolean isClickable;
    private final List<Point> points;

    /* JADX WARN: Multi-variable type inference failed */
    public ClickArea(boolean z16, List<? extends Point> points) {
        Intrinsics.checkNotNullParameter(points, "points");
        this.isClickable = z16;
        this.points = points;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsClickable() {
        return this.isClickable;
    }

    public final List<Point> component2() {
        return this.points;
    }

    public final boolean contains(Point point) {
        Intrinsics.checkNotNullParameter(point, "point");
        int size = this.points.size() - 1;
        boolean z16 = false;
        for (int i3 = 0; i3 < this.points.size(); i3++) {
            if ((this.points.get(i3).y >= point.y) != (this.points.get(size).y >= point.y) && point.x <= (((this.points.get(size).x - this.points.get(i3).x) * (point.y - this.points.get(i3).y)) / (this.points.get(size).y - this.points.get(i3).y)) + this.points.get(i3).x) {
                z16 = !z16;
            }
            size = i3;
        }
        return z16;
    }

    public final ClickArea copy(boolean isClickable, List<? extends Point> points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return new ClickArea(isClickable, points);
    }

    public final List<Point> getPoints() {
        return this.points;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isClickable;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        List<Point> list = this.points;
        return i3 + (list != null ? list.hashCode() : 0);
    }

    public final boolean isClickable() {
        return this.isClickable;
    }

    public String toString() {
        return "ClickArea(isClickable=" + this.isClickable + ", points=" + this.points + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClickArea)) {
            return false;
        }
        ClickArea clickArea = (ClickArea) other;
        return this.isClickable == clickArea.isClickable && Intrinsics.areEqual(this.points, clickArea.points);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClickArea copy$default(ClickArea clickArea, boolean z16, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = clickArea.isClickable;
        }
        if ((i3 & 2) != 0) {
            list = clickArea.points;
        }
        return clickArea.copy(z16, list);
    }
}
