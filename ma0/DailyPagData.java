package ma0;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lma0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "show", "<init>", "(Z)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ma0.b, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class DailyPagData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean show;

    public DailyPagData(boolean z16) {
        this.show = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof DailyPagData) && this.show == ((DailyPagData) other).show) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        boolean z16 = this.show;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "DailyPagData(show=" + this.show + ")";
    }
}
