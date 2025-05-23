package kt2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lkt2/c;", "Lkt2/a;", "newItem", "", "a", "", "toString", "", "hashCode", "", "other", "equals", "Z", "c", "()Z", "d", "(Z)V", "isLoadingMore", "<init>", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: kt2.c, reason: from toString */
/* loaded from: classes19.dex */
public final /* data */ class TroopBindGuildLFooterData extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isLoadingMore;

    public TroopBindGuildLFooterData() {
        this(false, 1, null);
    }

    @Override // kt2.a
    public boolean a(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof TroopBindGuildLFooterData) || ((TroopBindGuildLFooterData) newItem).isLoadingMore != this.isLoadingMore) {
            return false;
        }
        return true;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsLoadingMore() {
        return this.isLoadingMore;
    }

    public final void d(boolean z16) {
        this.isLoadingMore = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TroopBindGuildLFooterData) && this.isLoadingMore == ((TroopBindGuildLFooterData) other).isLoadingMore) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        boolean z16 = this.isLoadingMore;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "TroopBindGuildLFooterData(isLoadingMore=" + this.isLoadingMore + ")";
    }

    public /* synthetic */ TroopBindGuildLFooterData(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }

    public TroopBindGuildLFooterData(boolean z16) {
        this.isLoadingMore = z16;
    }
}
