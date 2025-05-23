package com.tencent.state.template.data;

import android.graphics.Point;
import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/template/data/QuickSeatTable;", "", "tableId", "", "location", "Landroid/graphics/Point;", "(JLandroid/graphics/Point;)V", "getLocation", "()Landroid/graphics/Point;", "getTableId", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class QuickSeatTable {
    private final Point location;
    private final long tableId;

    public QuickSeatTable(long j3, Point location) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.tableId = j3;
        this.location = location;
    }

    /* renamed from: component1, reason: from getter */
    public final long getTableId() {
        return this.tableId;
    }

    /* renamed from: component2, reason: from getter */
    public final Point getLocation() {
        return this.location;
    }

    public final QuickSeatTable copy(long tableId, Point location) {
        Intrinsics.checkNotNullParameter(location, "location");
        return new QuickSeatTable(tableId, location);
    }

    public final Point getLocation() {
        return this.location;
    }

    public final long getTableId() {
        return this.tableId;
    }

    public int hashCode() {
        int a16 = c.a(this.tableId) * 31;
        Point point = this.location;
        return a16 + (point != null ? point.hashCode() : 0);
    }

    public String toString() {
        return "QuickSeatTable(tableId=" + this.tableId + ", location=" + this.location + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuickSeatTable)) {
            return false;
        }
        QuickSeatTable quickSeatTable = (QuickSeatTable) other;
        return this.tableId == quickSeatTable.tableId && Intrinsics.areEqual(this.location, quickSeatTable.location);
    }

    public static /* synthetic */ QuickSeatTable copy$default(QuickSeatTable quickSeatTable, long j3, Point point, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = quickSeatTable.tableId;
        }
        if ((i3 & 2) != 0) {
            point = quickSeatTable.location;
        }
        return quickSeatTable.copy(j3, point);
    }
}
