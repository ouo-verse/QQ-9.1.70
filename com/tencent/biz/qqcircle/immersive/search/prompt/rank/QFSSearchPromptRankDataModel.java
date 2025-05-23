package com.tencent.biz.qqcircle.immersive.search.prompt.rank;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B3\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0014\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/a;", "T", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "isSuccess", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "items", "c", "hasMore", "Ljava/lang/String;", "()Ljava/lang/String;", "viewMoreUrl", "<init>", "(ZLjava/util/List;ZLjava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.immersive.search.prompt.rank.a, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSSearchPromptRankDataModel<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<T> items;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasMore;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String viewMoreUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public QFSSearchPromptRankDataModel(boolean z16, @NotNull List<? extends T> items, boolean z17, @NotNull String viewMoreUrl) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(viewMoreUrl, "viewMoreUrl");
        this.isSuccess = z16;
        this.items = items;
        this.hasMore = z17;
        this.viewMoreUrl = viewMoreUrl;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @NotNull
    public final List<T> b() {
        return this.items;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getViewMoreUrl() {
        return this.viewMoreUrl;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSSearchPromptRankDataModel)) {
            return false;
        }
        QFSSearchPromptRankDataModel qFSSearchPromptRankDataModel = (QFSSearchPromptRankDataModel) other;
        if (this.isSuccess == qFSSearchPromptRankDataModel.isSuccess && Intrinsics.areEqual(this.items, qFSSearchPromptRankDataModel.items) && this.hasMore == qFSSearchPromptRankDataModel.hasMore && Intrinsics.areEqual(this.viewMoreUrl, qFSSearchPromptRankDataModel.viewMoreUrl)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.isSuccess;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int hashCode = ((r06 * 31) + this.items.hashCode()) * 31;
        boolean z17 = this.hasMore;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((hashCode + i3) * 31) + this.viewMoreUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "QFSSearchPromptRankDataModel(isSuccess=" + this.isSuccess + ", items=" + this.items + ", hasMore=" + this.hasMore + ", viewMoreUrl=" + this.viewMoreUrl + ")";
    }

    public /* synthetic */ QFSSearchPromptRankDataModel(boolean z16, List list, boolean z17, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? false : z17, (i3 & 8) != 0 ? "" : str);
    }
}
