package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u001d\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\t\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/ag;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "setHasCreatedMiniHome", "(Z)V", "hasCreatedMiniHome", "e", "setGrayUser", "isGrayUser", "Lcom/tencent/mobileqq/zplan/minihome/ao;", "c", "Lcom/tencent/mobileqq/zplan/minihome/ao;", "d", "()Lcom/tencent/mobileqq/zplan/minihome/ao;", "roomDesc", "hasGift", "Lcom/tencent/mobileqq/zplan/minihome/v;", "Lcom/tencent/mobileqq/zplan/minihome/v;", "()Lcom/tencent/mobileqq/zplan/minihome/v;", "giftDesc", "<init>", "(ZZLcom/tencent/mobileqq/zplan/minihome/ao;ZLcom/tencent/mobileqq/zplan/minihome/v;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.minihome.ag, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MiniHomeInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hasCreatedMiniHome;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isGrayUser;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ao roomDesc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasGift;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GiftDesc giftDesc;

    public MiniHomeInfo(boolean z16, boolean z17, @NotNull ao roomDesc, boolean z18, @NotNull GiftDesc giftDesc) {
        Intrinsics.checkNotNullParameter(roomDesc, "roomDesc");
        Intrinsics.checkNotNullParameter(giftDesc, "giftDesc");
        this.hasCreatedMiniHome = z16;
        this.isGrayUser = z17;
        this.roomDesc = roomDesc;
        this.hasGift = z18;
        this.giftDesc = giftDesc;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GiftDesc getGiftDesc() {
        return this.giftDesc;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasCreatedMiniHome() {
        return this.hasCreatedMiniHome;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getHasGift() {
        return this.hasGift;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final ao getRoomDesc() {
        return this.roomDesc;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsGrayUser() {
        return this.isGrayUser;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiniHomeInfo)) {
            return false;
        }
        MiniHomeInfo miniHomeInfo = (MiniHomeInfo) other;
        if (this.hasCreatedMiniHome == miniHomeInfo.hasCreatedMiniHome && this.isGrayUser == miniHomeInfo.isGrayUser && Intrinsics.areEqual(this.roomDesc, miniHomeInfo.roomDesc) && this.hasGift == miniHomeInfo.hasGift && Intrinsics.areEqual(this.giftDesc, miniHomeInfo.giftDesc)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.hasCreatedMiniHome;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.isGrayUser;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int hashCode = (((i16 + i17) * 31) + this.roomDesc.hashCode()) * 31;
        boolean z17 = this.hasGift;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((hashCode + i3) * 31) + this.giftDesc.hashCode();
    }

    @NotNull
    public String toString() {
        return "MiniHomeInfo(hasCreatedMiniHome=" + this.hasCreatedMiniHome + ", isGrayUser=" + this.isGrayUser + ", roomDesc=" + this.roomDesc + ", hasGift=" + this.hasGift + ", giftDesc=" + this.giftDesc + ')';
    }
}
