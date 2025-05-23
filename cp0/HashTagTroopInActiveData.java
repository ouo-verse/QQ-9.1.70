package cp0;

import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R'\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcp0/j;", "Lcp0/a;", "", "e", "", "getItemId", "", "toString", "hashCode", "", "other", "", "equals", "Lcp0/g;", "b", "Lcp0/g;", "getHashTagGroupType", "()Lcp0/g;", "hashTagGroupType", "Ljava/util/ArrayList;", "Lcp0/i;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "d", "()Ljava/util/ArrayList;", "inActiveList", "<init>", "(Lcp0/g;Ljava/util/ArrayList;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: cp0.j, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class HashTagTroopInActiveData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final HashTagGroupType hashTagGroupType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<HashTagTroopData> inActiveList;

    public HashTagTroopInActiveData(@NotNull HashTagGroupType hashTagGroupType, @NotNull ArrayList<HashTagTroopData> inActiveList) {
        Intrinsics.checkNotNullParameter(hashTagGroupType, "hashTagGroupType");
        Intrinsics.checkNotNullParameter(inActiveList, "inActiveList");
        this.hashTagGroupType = hashTagGroupType;
        this.inActiveList = inActiveList;
    }

    @NotNull
    public final ArrayList<HashTagTroopData> d() {
        return this.inActiveList;
    }

    public int e() {
        return 5;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HashTagTroopInActiveData)) {
            return false;
        }
        HashTagTroopInActiveData hashTagTroopInActiveData = (HashTagTroopInActiveData) other;
        if (Intrinsics.areEqual(this.hashTagGroupType, hashTagTroopInActiveData.hashTagGroupType) && Intrinsics.areEqual(this.inActiveList, hashTagTroopInActiveData.inActiveList)) {
            return true;
        }
        return false;
    }

    @Override // cp0.k
    public long getItemId() {
        return Objects.hash(Integer.valueOf(e()), this.hashTagGroupType, Integer.valueOf(this.inActiveList.size()));
    }

    public int hashCode() {
        return (this.hashTagGroupType.hashCode() * 31) + this.inActiveList.hashCode();
    }

    @NotNull
    public String toString() {
        return "HashTagTroopInActiveData(hashTagGroupType=" + this.hashTagGroupType + ", inActiveList=" + this.inActiveList + ")";
    }
}
