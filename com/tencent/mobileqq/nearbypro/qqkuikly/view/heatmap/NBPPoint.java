package com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", HippyTKDListViewAdapter.X, "b", "y", "<init>", "(II)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.j, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class NBPPoint {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int y;

    public NBPPoint(int i3, int i16) {
        this.x = i3;
        this.y = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getX() {
        return this.x;
    }

    /* renamed from: b, reason: from getter */
    public final int getY() {
        return this.y;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NBPPoint)) {
            return false;
        }
        NBPPoint nBPPoint = (NBPPoint) other;
        if (this.x == nBPPoint.x && this.y == nBPPoint.y) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.x * 31) + this.y;
    }

    @NotNull
    public String toString() {
        return "NBPPoint(x=" + this.x + ", y=" + this.y + ")";
    }
}
