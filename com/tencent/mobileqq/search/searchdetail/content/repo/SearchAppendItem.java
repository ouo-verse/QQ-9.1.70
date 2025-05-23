package com.tencent.mobileqq.search.searchdetail.content.repo;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/repo/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "docId", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "b", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "()Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.repo.d, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class SearchAppendItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String docId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final com.tencent.mobileqq.search.searchdetail.content.template.model.a item;

    public SearchAppendItem(@NotNull String docId, @NotNull com.tencent.mobileqq.search.searchdetail.content.template.model.a item) {
        Intrinsics.checkNotNullParameter(docId, "docId");
        Intrinsics.checkNotNullParameter(item, "item");
        this.docId = docId;
        this.item = item;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDocId() {
        return this.docId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final com.tencent.mobileqq.search.searchdetail.content.template.model.a getItem() {
        return this.item;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchAppendItem)) {
            return false;
        }
        SearchAppendItem searchAppendItem = (SearchAppendItem) other;
        if (Intrinsics.areEqual(this.docId, searchAppendItem.docId) && Intrinsics.areEqual(this.item, searchAppendItem.item)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.docId.hashCode() * 31) + this.item.hashCode();
    }

    @NotNull
    public String toString() {
        return "SearchAppendItem(docId=" + this.docId + ", item=" + this.item + ")";
    }
}
