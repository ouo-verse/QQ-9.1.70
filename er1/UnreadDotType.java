package er1;

import androidx.annotation.ColorRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Ler1/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ler1/b;", "a", "Ler1/b;", "()Ler1/b;", "dotBackground", "b", "I", "()I", "textColor", "<init>", "(Ler1/b;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: er1.d, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class UnreadDotType {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final DrawableType dotBackground;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int textColor;

    public UnreadDotType(@NotNull DrawableType dotBackground, @ColorRes int i3) {
        Intrinsics.checkNotNullParameter(dotBackground, "dotBackground");
        this.dotBackground = dotBackground;
        this.textColor = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final DrawableType getDotBackground() {
        return this.dotBackground;
    }

    /* renamed from: b, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnreadDotType)) {
            return false;
        }
        UnreadDotType unreadDotType = (UnreadDotType) other;
        if (Intrinsics.areEqual(this.dotBackground, unreadDotType.dotBackground) && this.textColor == unreadDotType.textColor) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.dotBackground.hashCode() * 31) + this.textColor;
    }

    @NotNull
    public String toString() {
        return "UnreadDotType(dotBackground=" + this.dotBackground + ", textColor=" + this.textColor + ")";
    }
}
