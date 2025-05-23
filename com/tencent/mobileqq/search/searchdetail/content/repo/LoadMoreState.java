package com.tencent.mobileqq.search.searchdetail.content.repo;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/repo/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "isCompleted", "()Z", "c", "(Z)V", "b", "isSuccess", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/LoadMoreType;", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/LoadMoreType;", "getLoadMoreType", "()Lcom/tencent/mobileqq/search/searchdetail/content/repo/LoadMoreType;", "loadMoreType", "", "Lcom/tencent/mobileqq/search/searchdetail/c;", "d", "Ljava/util/List;", "getContentList", "()Ljava/util/List;", "contentList", "e", "isEnd", "<init>", "(ZZLcom/tencent/mobileqq/search/searchdetail/content/repo/LoadMoreType;Ljava/util/List;Z)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.repo.a, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class LoadMoreState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isCompleted;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final LoadMoreType loadMoreType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<com.tencent.mobileqq.search.searchdetail.c> contentList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isEnd;

    /* JADX WARN: Multi-variable type inference failed */
    public LoadMoreState(boolean z16, boolean z17, @NotNull LoadMoreType loadMoreType, @Nullable List<? extends com.tencent.mobileqq.search.searchdetail.c> list, boolean z18) {
        Intrinsics.checkNotNullParameter(loadMoreType, "loadMoreType");
        this.isCompleted = z16;
        this.isSuccess = z17;
        this.loadMoreType = loadMoreType;
        this.contentList = list;
        this.isEnd = z18;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public final void c(boolean z16) {
        this.isCompleted = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadMoreState)) {
            return false;
        }
        LoadMoreState loadMoreState = (LoadMoreState) other;
        if (this.isCompleted == loadMoreState.isCompleted && this.isSuccess == loadMoreState.isSuccess && this.loadMoreType == loadMoreState.loadMoreType && Intrinsics.areEqual(this.contentList, loadMoreState.contentList) && this.isEnd == loadMoreState.isEnd) {
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
        int hashCode;
        boolean z16 = this.isCompleted;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.isSuccess;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int hashCode2 = (((i16 + i17) * 31) + this.loadMoreType.hashCode()) * 31;
        List<com.tencent.mobileqq.search.searchdetail.c> list = this.contentList;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i18 = (hashCode2 + hashCode) * 31;
        boolean z17 = this.isEnd;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i18 + i3;
    }

    @NotNull
    public String toString() {
        return "LoadMoreState(isCompleted=" + this.isCompleted + ", isSuccess=" + this.isSuccess + ", loadMoreType=" + this.loadMoreType + ", contentList=" + this.contentList + ", isEnd=" + this.isEnd + ")";
    }
}
