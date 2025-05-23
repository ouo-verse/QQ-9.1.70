package com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "d", "(I)V", HippyTKDListViewAdapter.X, "c", "e", "y", "", UserInfo.SEX_FEMALE, "()F", "weight", "<init>", "(IIF)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.h, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class HeatPoint {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int y;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float weight;

    public HeatPoint(int i3, int i16, float f16) {
        this.x = i3;
        this.y = i16;
        this.weight = f16;
    }

    /* renamed from: a, reason: from getter */
    public final float getWeight() {
        return this.weight;
    }

    /* renamed from: b, reason: from getter */
    public final int getX() {
        return this.x;
    }

    /* renamed from: c, reason: from getter */
    public final int getY() {
        return this.y;
    }

    public final void d(int i3) {
        this.x = i3;
    }

    public final void e(int i3) {
        this.y = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HeatPoint)) {
            return false;
        }
        HeatPoint heatPoint = (HeatPoint) other;
        if (this.x == heatPoint.x && this.y == heatPoint.y && Float.compare(this.weight, heatPoint.weight) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.x * 31) + this.y) * 31) + Float.floatToIntBits(this.weight);
    }

    @NotNull
    public String toString() {
        return "HeatPoint(x=" + this.x + ", y=" + this.y + ", weight=" + this.weight + ")";
    }
}
