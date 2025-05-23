package o14;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lo14/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lo14/h;", "a", "Lo14/h;", "()Lo14/h;", "d", "(Lo14/h;)V", "itemData1", "b", "e", "itemData2", "c", "f", "itemData3", "<init>", "(Lo14/h;Lo14/h;Lo14/h;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: o14.i, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AdelieHotAndFriendPageData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private AdelieHotAndFriendItemData itemData1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private AdelieHotAndFriendItemData itemData2;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private AdelieHotAndFriendItemData itemData3;

    public AdelieHotAndFriendPageData() {
        this(null, null, null, 7, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final AdelieHotAndFriendItemData getItemData1() {
        return this.itemData1;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final AdelieHotAndFriendItemData getItemData2() {
        return this.itemData2;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final AdelieHotAndFriendItemData getItemData3() {
        return this.itemData3;
    }

    public final void d(@Nullable AdelieHotAndFriendItemData adelieHotAndFriendItemData) {
        this.itemData1 = adelieHotAndFriendItemData;
    }

    public final void e(@Nullable AdelieHotAndFriendItemData adelieHotAndFriendItemData) {
        this.itemData2 = adelieHotAndFriendItemData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdelieHotAndFriendPageData)) {
            return false;
        }
        AdelieHotAndFriendPageData adelieHotAndFriendPageData = (AdelieHotAndFriendPageData) other;
        if (Intrinsics.areEqual(this.itemData1, adelieHotAndFriendPageData.itemData1) && Intrinsics.areEqual(this.itemData2, adelieHotAndFriendPageData.itemData2) && Intrinsics.areEqual(this.itemData3, adelieHotAndFriendPageData.itemData3)) {
            return true;
        }
        return false;
    }

    public final void f(@Nullable AdelieHotAndFriendItemData adelieHotAndFriendItemData) {
        this.itemData3 = adelieHotAndFriendItemData;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        AdelieHotAndFriendItemData adelieHotAndFriendItemData = this.itemData1;
        int i3 = 0;
        if (adelieHotAndFriendItemData == null) {
            hashCode = 0;
        } else {
            hashCode = adelieHotAndFriendItemData.hashCode();
        }
        int i16 = hashCode * 31;
        AdelieHotAndFriendItemData adelieHotAndFriendItemData2 = this.itemData2;
        if (adelieHotAndFriendItemData2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = adelieHotAndFriendItemData2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        AdelieHotAndFriendItemData adelieHotAndFriendItemData3 = this.itemData3;
        if (adelieHotAndFriendItemData3 != null) {
            i3 = adelieHotAndFriendItemData3.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "AdelieHotAndFriendPageData(itemData1=" + this.itemData1 + ", itemData2=" + this.itemData2 + ", itemData3=" + this.itemData3 + ")";
    }

    public AdelieHotAndFriendPageData(@Nullable AdelieHotAndFriendItemData adelieHotAndFriendItemData, @Nullable AdelieHotAndFriendItemData adelieHotAndFriendItemData2, @Nullable AdelieHotAndFriendItemData adelieHotAndFriendItemData3) {
        this.itemData1 = adelieHotAndFriendItemData;
        this.itemData2 = adelieHotAndFriendItemData2;
        this.itemData3 = adelieHotAndFriendItemData3;
    }

    public /* synthetic */ AdelieHotAndFriendPageData(AdelieHotAndFriendItemData adelieHotAndFriendItemData, AdelieHotAndFriendItemData adelieHotAndFriendItemData2, AdelieHotAndFriendItemData adelieHotAndFriendItemData3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : adelieHotAndFriendItemData, (i3 & 2) != 0 ? null : adelieHotAndFriendItemData2, (i3 & 4) != 0 ? null : adelieHotAndFriendItemData3);
    }
}
