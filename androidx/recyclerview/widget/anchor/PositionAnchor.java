package androidx.recyclerview.widget.anchor;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Landroidx/recyclerview/widget/anchor/PositionAnchor;", "", "position", "", "offset", "baseBottom", "", "(IIZ)V", "getBaseBottom", "()Z", "getOffset", "()I", "getPosition", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class PositionAnchor {
    private final boolean baseBottom;
    private final int offset;
    private final int position;

    public PositionAnchor(int i3, int i16, boolean z16) {
        this.position = i3;
        this.offset = i16;
        this.baseBottom = z16;
    }

    public static /* synthetic */ PositionAnchor copy$default(PositionAnchor positionAnchor, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = positionAnchor.position;
        }
        if ((i17 & 2) != 0) {
            i16 = positionAnchor.offset;
        }
        if ((i17 & 4) != 0) {
            z16 = positionAnchor.baseBottom;
        }
        return positionAnchor.copy(i3, i16, z16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* renamed from: component2, reason: from getter */
    public final int getOffset() {
        return this.offset;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getBaseBottom() {
        return this.baseBottom;
    }

    @NotNull
    public final PositionAnchor copy(int position, int offset, boolean baseBottom) {
        return new PositionAnchor(position, offset, baseBottom);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PositionAnchor) {
                PositionAnchor positionAnchor = (PositionAnchor) other;
                if (this.position != positionAnchor.position || this.offset != positionAnchor.offset || this.baseBottom != positionAnchor.baseBottom) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean getBaseBottom() {
        return this.baseBottom;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getPosition() {
        return this.position;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((this.position * 31) + this.offset) * 31;
        boolean z16 = this.baseBottom;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    @NotNull
    public String toString() {
        return "PositionAnchor(position=" + this.position + ", offset=" + this.offset + ", baseBottom=" + this.baseBottom + ")";
    }
}
