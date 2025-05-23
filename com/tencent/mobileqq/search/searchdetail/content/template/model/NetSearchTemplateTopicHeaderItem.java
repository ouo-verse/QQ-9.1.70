package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import com.tencent.qqnt.kernel.nativeinterface.SearchTopicHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/r;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "", "getItemType", "Lcom/tencent/mobileqq/search/searchdetail/c;", "newItem", "", HippyTKDListViewAdapter.X, "(Lcom/tencent/mobileqq/search/searchdetail/c;)Ljava/lang/Boolean;", "", "i", "", "toString", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTopicHeader;", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTopicHeader;", "y", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchTopicHeader;", "topicHeader", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "template", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.r, reason: from toString */
/* loaded from: classes18.dex */
public final class NetSearchTemplateTopicHeaderItem extends a {

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @NotNull
    private final SearchTopicHeader topicHeader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchTemplateTopicHeaderItem(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate template) {
        super(commonInfo, template);
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(template, "template");
        SearchTopicHeader searchTopicHeader = template.topicHeader;
        this.topicHeader = searchTopicHeader == null ? new SearchTopicHeader() : searchTopicHeader;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public void i() {
        super.i();
    }

    @NotNull
    public String toString() {
        return "NetSearchTemplateTopicHeaderItem(topicHeader=" + this.topicHeader + ", commonInfo=" + getCommonInfo() + ")";
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a, com.tencent.mobileqq.search.searchdetail.c
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Boolean e(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Boolean.FALSE;
    }

    @NotNull
    /* renamed from: y, reason: from getter */
    public final SearchTopicHeader getTopicHeader() {
        return this.topicHeader;
    }
}
