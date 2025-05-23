package cp0;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcp0/i;", "Lcp0/a;", "", "g", "", "getItemId", "", "toString", "hashCode", "", "other", "", "equals", "Lcp0/g;", "b", "Lcp0/g;", "f", "()Lcp0/g;", "hashTagGroupType", "c", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "groupName", "d", "groupCode", "<init>", "(Lcp0/g;Ljava/lang/String;Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: cp0.i, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class HashTagTroopData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final HashTagGroupType hashTagGroupType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String groupName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String groupCode;

    public HashTagTroopData(@NotNull HashTagGroupType hashTagGroupType, @NotNull String groupName, @NotNull String groupCode) {
        Intrinsics.checkNotNullParameter(hashTagGroupType, "hashTagGroupType");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        this.hashTagGroupType = hashTagGroupType;
        this.groupName = groupName;
        this.groupCode = groupCode;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getGroupCode() {
        return this.groupCode;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HashTagTroopData)) {
            return false;
        }
        HashTagTroopData hashTagTroopData = (HashTagTroopData) other;
        if (Intrinsics.areEqual(this.hashTagGroupType, hashTagTroopData.hashTagGroupType) && Intrinsics.areEqual(this.groupName, hashTagTroopData.groupName) && Intrinsics.areEqual(this.groupCode, hashTagTroopData.groupCode)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final HashTagGroupType getHashTagGroupType() {
        return this.hashTagGroupType;
    }

    public int g() {
        return 4;
    }

    @Override // cp0.k
    public long getItemId() {
        return Objects.hash(Integer.valueOf(g()), this.groupCode);
    }

    public int hashCode() {
        return (((this.hashTagGroupType.hashCode() * 31) + this.groupName.hashCode()) * 31) + this.groupCode.hashCode();
    }

    @NotNull
    public String toString() {
        return "HashTagTroopData(hashTagGroupType=" + this.hashTagGroupType + ", groupName=" + this.groupName + ", groupCode=" + this.groupCode + ")";
    }
}
