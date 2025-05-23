package com.tencent.state.square.media.utils;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import tl.h;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/media/utils/PointRect;", "", HippyTKDListViewAdapter.X, "", "y", "w", h.F, "(IIII)V", "getH", "()I", "getW", "getX", "getY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class PointRect {
    private final int h;
    private final int w;
    private final int x;
    private final int y;

    public PointRect(int i3, int i16, int i17, int i18) {
        this.x = i3;
        this.y = i16;
        this.w = i17;
        this.h = i18;
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

    public final PointRect copy(int x16, int y16, int w3, int h16) {
        return new PointRect(x16, y16, w3, h16);
    }

    public final int getH() {
        return this.h;
    }

    public final int getW() {
        return this.w;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public int hashCode() {
        return (((((this.x * 31) + this.y) * 31) + this.w) * 31) + this.h;
    }

    public String toString() {
        return "PointRect(x=" + this.x + ", y=" + this.y + ", w=" + this.w + ", h=" + this.h + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PointRect)) {
            return false;
        }
        PointRect pointRect = (PointRect) other;
        return this.x == pointRect.x && this.y == pointRect.y && this.w == pointRect.w && this.h == pointRect.h;
    }

    public static /* synthetic */ PointRect copy$default(PointRect pointRect, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            i3 = pointRect.x;
        }
        if ((i19 & 2) != 0) {
            i16 = pointRect.y;
        }
        if ((i19 & 4) != 0) {
            i17 = pointRect.w;
        }
        if ((i19 & 8) != 0) {
            i18 = pointRect.h;
        }
        return pointRect.copy(i3, i16, i17, i18);
    }
}
