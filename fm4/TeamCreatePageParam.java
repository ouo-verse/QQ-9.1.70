package fm4;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\rJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lfm4/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "setBaseOnTempActivity", "(Z)V", "baseOnTempActivity", "<init>", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: fm4.l, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class TeamCreatePageParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean baseOnTempActivity;

    public TeamCreatePageParam() {
        this(false, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getBaseOnTempActivity() {
        return this.baseOnTempActivity;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TeamCreatePageParam) && this.baseOnTempActivity == ((TeamCreatePageParam) other).baseOnTempActivity) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        boolean z16 = this.baseOnTempActivity;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "TeamCreatePageParam(baseOnTempActivity=" + this.baseOnTempActivity + ")";
    }

    public TeamCreatePageParam(boolean z16) {
        this.baseOnTempActivity = z16;
    }

    public /* synthetic */ TeamCreatePageParam(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
