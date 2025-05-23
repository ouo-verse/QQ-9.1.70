package kt2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \r2\u00020\u0001:\u0001\u0004B\u0019\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lkt2/e;", "Lkt2/a;", "newItem", "", "a", "", "toString", "", "hashCode", "", "other", "equals", "I", "c", "()I", "titleType", "b", "Z", "getOptGuildListIsEmpty", "()Z", "optGuildListIsEmpty", "<init>", "(IZ)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: kt2.e, reason: from toString */
/* loaded from: classes19.dex */
public final /* data */ class TroopBindGuildLTitleData extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int titleType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean optGuildListIsEmpty;

    public TroopBindGuildLTitleData(int i3, boolean z16) {
        this.titleType = i3;
        this.optGuildListIsEmpty = z16;
    }

    @Override // kt2.a
    public boolean a(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof TroopBindGuildLTitleData)) {
            return false;
        }
        TroopBindGuildLTitleData troopBindGuildLTitleData = (TroopBindGuildLTitleData) newItem;
        if (troopBindGuildLTitleData.titleType != this.titleType || troopBindGuildLTitleData.optGuildListIsEmpty != this.optGuildListIsEmpty) {
            return false;
        }
        return true;
    }

    /* renamed from: c, reason: from getter */
    public final int getTitleType() {
        return this.titleType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopBindGuildLTitleData)) {
            return false;
        }
        TroopBindGuildLTitleData troopBindGuildLTitleData = (TroopBindGuildLTitleData) other;
        if (this.titleType == troopBindGuildLTitleData.titleType && this.optGuildListIsEmpty == troopBindGuildLTitleData.optGuildListIsEmpty) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.titleType * 31;
        boolean z16 = this.optGuildListIsEmpty;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    @NotNull
    public String toString() {
        return "TroopBindGuildLTitleData(titleType=" + this.titleType + ", optGuildListIsEmpty=" + this.optGuildListIsEmpty + ")";
    }
}
