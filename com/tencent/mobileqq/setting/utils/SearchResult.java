package com.tencent.mobileqq.setting.utils;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0015j\b\u0012\u0004\u0012\u00020\t`\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011R'\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0015j\b\u0012\u0004\u0012\u00020\t`\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/setting/utils/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljq2/c;", "a", "Ljq2/c;", "c", "()Ljq2/c;", "resultNode", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "description", "d", "searchContent", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "indexPath", "<init>", "(Ljq2/c;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.setting.utils.k, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class SearchResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final jq2.c resultNode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String description;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String searchContent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final ArrayList<jq2.c> indexPath;

    public SearchResult(jq2.c resultNode, String description, String searchContent, ArrayList<jq2.c> indexPath) {
        Intrinsics.checkNotNullParameter(resultNode, "resultNode");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(searchContent, "searchContent");
        Intrinsics.checkNotNullParameter(indexPath, "indexPath");
        this.resultNode = resultNode;
        this.description = description;
        this.searchContent = searchContent;
        this.indexPath = indexPath;
    }

    /* renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final ArrayList<jq2.c> b() {
        return this.indexPath;
    }

    /* renamed from: c, reason: from getter */
    public final jq2.c getResultNode() {
        return this.resultNode;
    }

    /* renamed from: d, reason: from getter */
    public final String getSearchContent() {
        return this.searchContent;
    }

    public int hashCode() {
        return (((((this.resultNode.hashCode() * 31) + this.description.hashCode()) * 31) + this.searchContent.hashCode()) * 31) + this.indexPath.hashCode();
    }

    public String toString() {
        return "SearchResult(resultNode=" + this.resultNode + ", description=" + this.description + ", searchContent=" + this.searchContent + ", indexPath=" + this.indexPath + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchResult)) {
            return false;
        }
        SearchResult searchResult = (SearchResult) other;
        return Intrinsics.areEqual(this.resultNode, searchResult.resultNode) && Intrinsics.areEqual(this.description, searchResult.description) && Intrinsics.areEqual(this.searchContent, searchResult.searchContent) && Intrinsics.areEqual(this.indexPath, searchResult.indexPath);
    }
}
