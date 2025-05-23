package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchNoResultCard;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/p;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "", "getItemType", "", "toString", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "getTemplate", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "template", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchNoResultCard;", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchNoResultCard;", HippyTKDListViewAdapter.X, "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchNoResultCard;", "noResultCard", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.p, reason: from toString */
/* loaded from: classes18.dex */
public final class NetSearchTemplateNoResultItem extends a {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final SearchTemplate template;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @NotNull
    private final SearchNoResultCard noResultCard;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchTemplateNoResultItem(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate template) {
        super(commonInfo, template);
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(template, "template");
        this.template = template;
        SearchNoResultCard searchNoResultCard = template.noResultCard;
        this.noResultCard = searchNoResultCard == null ? new SearchNoResultCard() : searchNoResultCard;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 20;
    }

    @NotNull
    public String toString() {
        return "NetSearchTemplateNoResultItem(noResultCard=" + this.noResultCard + ", commonInfo=" + getCommonInfo() + ")";
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final SearchNoResultCard getNoResultCard() {
        return this.noResultCard;
    }
}
