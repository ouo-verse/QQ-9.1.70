package ik2;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lik2/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "b", "()F", "left", "d", "top", "c", "right", "bottom", "<init>", "(FFFF)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ik2.d, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class GifClipData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float left;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float top;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float right;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float bottom;

    public GifClipData(float f16, float f17, float f18, float f19) {
        this.left = f16;
        this.top = f17;
        this.right = f18;
        this.bottom = f19;
    }

    /* renamed from: a, reason: from getter */
    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: b, reason: from getter */
    public final float getLeft() {
        return this.left;
    }

    /* renamed from: c, reason: from getter */
    public final float getRight() {
        return this.right;
    }

    /* renamed from: d, reason: from getter */
    public final float getTop() {
        return this.top;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GifClipData)) {
            return false;
        }
        GifClipData gifClipData = (GifClipData) other;
        if (Float.compare(this.left, gifClipData.left) == 0 && Float.compare(this.top, gifClipData.top) == 0 && Float.compare(this.right, gifClipData.right) == 0 && Float.compare(this.bottom, gifClipData.bottom) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom);
    }

    @NotNull
    public String toString() {
        return "GifClipData(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
    }
}
