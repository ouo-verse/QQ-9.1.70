package com.tencent.mobileqq.nearbypro.feedscheck.basepart;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import op4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "statusFeedType", "Lop4/i;", "b", "Lop4/i;", "()Lop4/i;", "statusFeed", "Lup4/c;", "Lup4/c;", "()Lup4/c;", "moreIcon", "<init>", "(ILop4/i;Lup4/c;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.feedscheck.basepart.h, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class StatusFeedData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int statusFeedType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final i statusFeed;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final up4.c moreIcon;

    public StatusFeedData(int i3, @Nullable i iVar, @Nullable up4.c cVar) {
        this.statusFeedType = i3;
        this.statusFeed = iVar;
        this.moreIcon = cVar;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final up4.c getMoreIcon() {
        return this.moreIcon;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final i getStatusFeed() {
        return this.statusFeed;
    }

    /* renamed from: c, reason: from getter */
    public final int getStatusFeedType() {
        return this.statusFeedType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatusFeedData)) {
            return false;
        }
        StatusFeedData statusFeedData = (StatusFeedData) other;
        if (this.statusFeedType == statusFeedData.statusFeedType && Intrinsics.areEqual(this.statusFeed, statusFeedData.statusFeed) && Intrinsics.areEqual(this.moreIcon, statusFeedData.moreIcon)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.statusFeedType * 31;
        i iVar = this.statusFeed;
        int i16 = 0;
        if (iVar == null) {
            hashCode = 0;
        } else {
            hashCode = iVar.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        up4.c cVar = this.moreIcon;
        if (cVar != null) {
            i16 = cVar.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "StatusFeedData(statusFeedType=" + this.statusFeedType + ", statusFeed=" + this.statusFeed + ", moreIcon=" + this.moreIcon + ")";
    }

    public /* synthetic */ StatusFeedData(int i3, i iVar, up4.c cVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, iVar, (i16 & 4) != 0 ? null : cVar);
    }
}
