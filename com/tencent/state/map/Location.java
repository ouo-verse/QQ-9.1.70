package com.tencent.state.map;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001J\b\u0010#\u001a\u00020$H\u0016R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000b\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/map/Location;", "", HippyTKDListViewAdapter.X, "", "y", "width", "height", GdtGetUserInfoHandler.KEY_AREA, "rank", "(IIIIII)V", "getArea", "()I", "centerX", "getCenterX", "centerY", "getCenterY", "getHeight", "setHeight", "(I)V", "getRank", "getWidth", "setWidth", "getX", "getY", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes4.dex */
public final /* data */ class Location {
    private final int area;
    private final int centerX;
    private final int centerY;

    /* renamed from: height, reason: from kotlin metadata and from toString */
    private int h;
    private final int rank;

    /* renamed from: width, reason: from kotlin metadata and from toString */
    private int w;
    private final int x;
    private final int y;

    public Location(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.x = i3;
        this.y = i16;
        this.w = i17;
        this.h = i18;
        this.area = i19;
        this.rank = i26;
        this.centerX = i3 + (i17 / 2);
        this.centerY = i16 + (i18 / 2);
    }

    public static /* synthetic */ Location copy$default(Location location, int i3, int i16, int i17, int i18, int i19, int i26, int i27, Object obj) {
        if ((i27 & 1) != 0) {
            i3 = location.x;
        }
        if ((i27 & 2) != 0) {
            i16 = location.y;
        }
        int i28 = i16;
        if ((i27 & 4) != 0) {
            i17 = location.w;
        }
        int i29 = i17;
        if ((i27 & 8) != 0) {
            i18 = location.h;
        }
        int i36 = i18;
        if ((i27 & 16) != 0) {
            i19 = location.area;
        }
        int i37 = i19;
        if ((i27 & 32) != 0) {
            i26 = location.rank;
        }
        return location.copy(i3, i28, i29, i36, i37, i26);
    }

    /* renamed from: component1, reason: from getter */
    public final int getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final int getY() {
        return this.y;
    }

    /* renamed from: component3, reason: from getter */
    public final int getW() {
        return this.w;
    }

    /* renamed from: component4, reason: from getter */
    public final int getH() {
        return this.h;
    }

    /* renamed from: component5, reason: from getter */
    public final int getArea() {
        return this.area;
    }

    /* renamed from: component6, reason: from getter */
    public final int getRank() {
        return this.rank;
    }

    @NotNull
    public final Location copy(int x16, int y16, int width, int height, int area, int rank) {
        return new Location(x16, y16, width, height, area, rank);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Location) {
                Location location = (Location) other;
                if (this.x != location.x || this.y != location.y || this.w != location.w || this.h != location.h || this.area != location.area || this.rank != location.rank) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getArea() {
        return this.area;
    }

    public final int getCenterX() {
        return this.centerX;
    }

    public final int getCenterY() {
        return this.centerY;
    }

    public final int getHeight() {
        return this.h;
    }

    public final int getRank() {
        return this.rank;
    }

    public final int getWidth() {
        return this.w;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public int hashCode() {
        return (((((((((this.x * 31) + this.y) * 31) + this.w) * 31) + this.h) * 31) + this.area) * 31) + this.rank;
    }

    public final void setHeight(int i3) {
        this.h = i3;
    }

    public final void setWidth(int i3) {
        this.w = i3;
    }

    @NotNull
    public String toString() {
        return "Location(x=" + this.x + ", y=" + this.y + ", w=" + this.w + ", h=" + this.h + ", area=" + this.area + ", rank=" + this.rank + ')';
    }

    public /* synthetic */ Location(int i3, int i16, int i17, int i18, int i19, int i26, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, i17, i18, (i27 & 16) != 0 ? -1 : i19, (i27 & 32) != 0 ? -1 : i26);
    }
}
