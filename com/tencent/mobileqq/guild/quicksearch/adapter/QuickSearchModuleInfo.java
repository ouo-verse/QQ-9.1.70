package com.tencent.mobileqq.guild.quicksearch.adapter;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedGroupInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/adapter/d;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchFeedGroupInfo;", "info", "", "isSelected", "a", "", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchFeedGroupInfo;", "c", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchFeedGroupInfo;", "b", "Z", "d", "()Z", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchFeedGroupInfo;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.quicksearch.adapter.d, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class QuickSearchModuleInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IGProGuildSearchFeedGroupInfo info;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSelected;

    public QuickSearchModuleInfo(@NotNull IGProGuildSearchFeedGroupInfo info, boolean z16) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.info = info;
        this.isSelected = z16;
    }

    public static /* synthetic */ QuickSearchModuleInfo b(QuickSearchModuleInfo quickSearchModuleInfo, IGProGuildSearchFeedGroupInfo iGProGuildSearchFeedGroupInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            iGProGuildSearchFeedGroupInfo = quickSearchModuleInfo.info;
        }
        if ((i3 & 2) != 0) {
            z16 = quickSearchModuleInfo.isSelected;
        }
        return quickSearchModuleInfo.a(iGProGuildSearchFeedGroupInfo, z16);
    }

    @NotNull
    public final QuickSearchModuleInfo a(@NotNull IGProGuildSearchFeedGroupInfo info, boolean isSelected) {
        Intrinsics.checkNotNullParameter(info, "info");
        return new QuickSearchModuleInfo(info, isSelected);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final IGProGuildSearchFeedGroupInfo getInfo() {
        return this.info;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuickSearchModuleInfo)) {
            return false;
        }
        QuickSearchModuleInfo quickSearchModuleInfo = (QuickSearchModuleInfo) other;
        if (Intrinsics.areEqual(this.info, quickSearchModuleInfo.info) && this.isSelected == quickSearchModuleInfo.isSelected) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.info.hashCode() * 31;
        boolean z16 = this.isSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "QuickSearchModuleInfo(info=" + this.info + ", isSelected=" + this.isSelected + ")";
    }
}
