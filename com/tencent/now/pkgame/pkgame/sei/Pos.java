package com.tencent.now.pkgame.pkgame.sei;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/now/pkgame/pkgame/sei/Pos;", "Ljava/io/Serializable;", "layer", "", HippyTKDListViewAdapter.X, "y", "w", h.F, "(IIIII)V", "getH", "()I", "getLayer", "getW", "getX", "getY", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final /* data */ class Pos implements Serializable {
    private final int h;
    private final int layer;
    private final int w;
    private final int x;
    private final int y;

    public Pos(int i3, int i16, int i17, int i18, int i19) {
        this.layer = i3;
        this.x = i16;
        this.y = i17;
        this.w = i18;
        this.h = i19;
    }

    public static /* synthetic */ Pos copy$default(Pos pos, int i3, int i16, int i17, int i18, int i19, int i26, Object obj) {
        if ((i26 & 1) != 0) {
            i3 = pos.layer;
        }
        if ((i26 & 2) != 0) {
            i16 = pos.x;
        }
        int i27 = i16;
        if ((i26 & 4) != 0) {
            i17 = pos.y;
        }
        int i28 = i17;
        if ((i26 & 8) != 0) {
            i18 = pos.w;
        }
        int i29 = i18;
        if ((i26 & 16) != 0) {
            i19 = pos.h;
        }
        return pos.copy(i3, i27, i28, i29, i19);
    }

    /* renamed from: component1, reason: from getter */
    public final int getLayer() {
        return this.layer;
    }

    /* renamed from: component2, reason: from getter */
    public final int getX() {
        return this.x;
    }

    /* renamed from: component3, reason: from getter */
    public final int getY() {
        return this.y;
    }

    /* renamed from: component4, reason: from getter */
    public final int getW() {
        return this.w;
    }

    /* renamed from: component5, reason: from getter */
    public final int getH() {
        return this.h;
    }

    @NotNull
    public final Pos copy(int layer, int x16, int y16, int w3, int h16) {
        return new Pos(layer, x16, y16, w3, h16);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Pos)) {
            return false;
        }
        Pos pos = (Pos) other;
        if (this.layer == pos.layer && this.x == pos.x && this.y == pos.y && this.w == pos.w && this.h == pos.h) {
            return true;
        }
        return false;
    }

    public final int getH() {
        return this.h;
    }

    public final int getLayer() {
        return this.layer;
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
        return (((((((this.layer * 31) + this.x) * 31) + this.y) * 31) + this.w) * 31) + this.h;
    }

    @NotNull
    public String toString() {
        return "Pos(layer=" + this.layer + ", x=" + this.x + ", y=" + this.y + ", w=" + this.w + ", h=" + this.h + ")";
    }
}
