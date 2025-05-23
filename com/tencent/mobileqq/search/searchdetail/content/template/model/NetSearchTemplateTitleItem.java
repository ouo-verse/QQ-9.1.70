package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import com.tencent.qqnt.kernel.nativeinterface.SearchTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/q;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "", "getItemType", "", "toString", "", "other", "", "equals", "hashCode", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "getTemplate", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "template", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTitle;", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTitle;", HippyTKDListViewAdapter.X, "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchTitle;", "searchTitle", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.q, reason: from toString */
/* loaded from: classes18.dex */
public final class NetSearchTemplateTitleItem extends a {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final SearchTemplate template;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @NotNull
    private final SearchTitle searchTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchTemplateTitleItem(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate template) {
        super(commonInfo, template);
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(template, "template");
        this.template = template;
        SearchTitle searchTitle = template.title;
        this.searchTitle = searchTitle == null ? new SearchTitle() : searchTitle;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetSearchTemplateTitleItem) || !super.equals(other)) {
            return false;
        }
        NetSearchTemplateTitleItem netSearchTemplateTitleItem = (NetSearchTemplateTitleItem) other;
        if (Intrinsics.areEqual(this.template, netSearchTemplateTitleItem.template) && Intrinsics.areEqual(this.searchTitle, netSearchTemplateTitleItem.searchTitle)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 7;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a
    public int hashCode() {
        return (((super.hashCode() * 31) + this.template.hashCode()) * 31) + this.searchTitle.hashCode();
    }

    @NotNull
    public String toString() {
        return "NetSearchTemplateTitleItem(searchTitle=" + this.searchTitle + ", commonInfo=" + getCommonInfo() + ")";
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final SearchTitle getSearchTitle() {
        return this.searchTitle;
    }
}
