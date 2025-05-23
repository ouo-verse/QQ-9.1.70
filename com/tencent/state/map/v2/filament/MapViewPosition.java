package com.tencent.state.map.v2.filament;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0017\u001a\u00020\bH\u00c6\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/map/v2/filament/MapViewPosition;", "", "containerRect", "Landroid/graphics/RectF;", "containerScaleX", "", "containerScaleY", "mapScrollX", "", "mapScrollY", "(Landroid/graphics/RectF;FFII)V", "getContainerRect", "()Landroid/graphics/RectF;", "getContainerScaleX", "()F", "getContainerScaleY", "getMapScrollX", "()I", "getMapScrollY", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final /* data */ class MapViewPosition {
    private final RectF containerRect;
    private final float containerScaleX;
    private final float containerScaleY;
    private final int mapScrollX;
    private final int mapScrollY;

    public MapViewPosition(RectF containerRect, float f16, float f17, int i3, int i16) {
        Intrinsics.checkNotNullParameter(containerRect, "containerRect");
        this.containerRect = containerRect;
        this.containerScaleX = f16;
        this.containerScaleY = f17;
        this.mapScrollX = i3;
        this.mapScrollY = i16;
    }

    /* renamed from: component1, reason: from getter */
    public final RectF getContainerRect() {
        return this.containerRect;
    }

    /* renamed from: component2, reason: from getter */
    public final float getContainerScaleX() {
        return this.containerScaleX;
    }

    /* renamed from: component3, reason: from getter */
    public final float getContainerScaleY() {
        return this.containerScaleY;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMapScrollX() {
        return this.mapScrollX;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMapScrollY() {
        return this.mapScrollY;
    }

    public final MapViewPosition copy(RectF containerRect, float containerScaleX, float containerScaleY, int mapScrollX, int mapScrollY) {
        Intrinsics.checkNotNullParameter(containerRect, "containerRect");
        return new MapViewPosition(containerRect, containerScaleX, containerScaleY, mapScrollX, mapScrollY);
    }

    public final RectF getContainerRect() {
        return this.containerRect;
    }

    public final float getContainerScaleX() {
        return this.containerScaleX;
    }

    public final float getContainerScaleY() {
        return this.containerScaleY;
    }

    public final int getMapScrollX() {
        return this.mapScrollX;
    }

    public final int getMapScrollY() {
        return this.mapScrollY;
    }

    public int hashCode() {
        RectF rectF = this.containerRect;
        return ((((((((rectF != null ? rectF.hashCode() : 0) * 31) + Float.floatToIntBits(this.containerScaleX)) * 31) + Float.floatToIntBits(this.containerScaleY)) * 31) + this.mapScrollX) * 31) + this.mapScrollY;
    }

    public String toString() {
        return "MapViewPosition(containerRect=" + this.containerRect + ", containerScaleX=" + this.containerScaleX + ", containerScaleY=" + this.containerScaleY + ", mapScrollX=" + this.mapScrollX + ", mapScrollY=" + this.mapScrollY + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MapViewPosition)) {
            return false;
        }
        MapViewPosition mapViewPosition = (MapViewPosition) other;
        return Intrinsics.areEqual(this.containerRect, mapViewPosition.containerRect) && Float.compare(this.containerScaleX, mapViewPosition.containerScaleX) == 0 && Float.compare(this.containerScaleY, mapViewPosition.containerScaleY) == 0 && this.mapScrollX == mapViewPosition.mapScrollX && this.mapScrollY == mapViewPosition.mapScrollY;
    }

    public static /* synthetic */ MapViewPosition copy$default(MapViewPosition mapViewPosition, RectF rectF, float f16, float f17, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            rectF = mapViewPosition.containerRect;
        }
        if ((i17 & 2) != 0) {
            f16 = mapViewPosition.containerScaleX;
        }
        float f18 = f16;
        if ((i17 & 4) != 0) {
            f17 = mapViewPosition.containerScaleY;
        }
        float f19 = f17;
        if ((i17 & 8) != 0) {
            i3 = mapViewPosition.mapScrollX;
        }
        int i18 = i3;
        if ((i17 & 16) != 0) {
            i16 = mapViewPosition.mapScrollY;
        }
        return mapViewPosition.copy(rectF, f18, f19, i18, i16);
    }
}
