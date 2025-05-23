package com.tencent.mobileqq.qwallet.pet.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u000e\u0010\u000bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017\"\u0004\b\u0015\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/data/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "id", "", "b", "Ljava/util/List;", "getSupportPets", "()Ljava/util/List;", "supportPets", "c", "nodeName", "d", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "(Ljava/lang/Boolean;)V", "isEquipped", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qwallet.pet.data.a, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class ClothInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> supportPets;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nodeName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Boolean isEquipped;

    public ClothInfo(@NotNull String id5, @NotNull List<String> supportPets, @NotNull String nodeName, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(supportPets, "supportPets");
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        this.id = id5;
        this.supportPets = supportPets;
        this.nodeName = nodeName;
        this.isEquipped = bool;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getNodeName() {
        return this.nodeName;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Boolean getIsEquipped() {
        return this.isEquipped;
    }

    public final void d(@Nullable Boolean bool) {
        this.isEquipped = bool;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClothInfo)) {
            return false;
        }
        ClothInfo clothInfo = (ClothInfo) other;
        if (Intrinsics.areEqual(this.id, clothInfo.id) && Intrinsics.areEqual(this.supportPets, clothInfo.supportPets) && Intrinsics.areEqual(this.nodeName, clothInfo.nodeName) && Intrinsics.areEqual(this.isEquipped, clothInfo.isEquipped)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.id.hashCode() * 31) + this.supportPets.hashCode()) * 31) + this.nodeName.hashCode()) * 31;
        Boolean bool = this.isEquipped;
        if (bool == null) {
            hashCode = 0;
        } else {
            hashCode = bool.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "ClothInfo(id=" + this.id + ", supportPets=" + this.supportPets + ", nodeName=" + this.nodeName + ", isEquipped=" + this.isEquipped + ")";
    }

    public /* synthetic */ ClothInfo(String str, List list, String str2, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, str2, (i3 & 8) != 0 ? null : bool);
    }
}
