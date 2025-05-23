package ch4;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lch4/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "left", "b", "top", "c", "getWidth", "width", "d", "getHeight", "height", "<init>", "(IIII)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ch4.k, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class RefViewPos {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int left;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int top;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    public RefViewPos() {
        this(0, 0, 0, 0, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getLeft() {
        return this.left;
    }

    /* renamed from: b, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RefViewPos)) {
            return false;
        }
        RefViewPos refViewPos = (RefViewPos) other;
        if (this.left == refViewPos.left && this.top == refViewPos.top && this.width == refViewPos.width && this.height == refViewPos.height) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.width) * 31) + this.height;
    }

    @NotNull
    public String toString() {
        return "RefViewPos(left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public RefViewPos(int i3, int i16, int i17, int i18) {
        this.left = i3;
        this.top = i16;
        this.width = i17;
        this.height = i18;
    }

    public /* synthetic */ RefViewPos(int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) != 0 ? 0 : i18);
    }
}
