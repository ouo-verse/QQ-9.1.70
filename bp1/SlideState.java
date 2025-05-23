package bp1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\rJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lbp1/y;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "b", "(Z)V", "canViewSlideRight", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bp1.y, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class SlideState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean canViewSlideRight;

    public SlideState() {
        this(false, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getCanViewSlideRight() {
        return this.canViewSlideRight;
    }

    public final void b(boolean z16) {
        this.canViewSlideRight = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof SlideState) && this.canViewSlideRight == ((SlideState) other).canViewSlideRight) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        boolean z16 = this.canViewSlideRight;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "SlideState(canViewSlideRight=" + this.canViewSlideRight + ")";
    }

    public SlideState(boolean z16) {
        this.canViewSlideRight = z16;
    }

    public /* synthetic */ SlideState(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
