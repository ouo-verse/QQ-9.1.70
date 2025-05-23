package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchListDetail;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import com.tencent.qqnt.kernel.nativeinterface.SearchVerticalList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/s;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/u;", "", "getItemType", "Lcom/tencent/mobileqq/search/searchdetail/c;", "newItem", "", HippyTKDListViewAdapter.X, "(Lcom/tencent/mobileqq/search/searchdetail/c;)Ljava/lang/Boolean;", "", "toString", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchVerticalList;", "I", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchVerticalList;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchVerticalList;", "verticalList", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchListDetail;", "J", "Ljava/util/List;", "y", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "searchTemplate", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.s, reason: from toString */
/* loaded from: classes18.dex */
public final class NetSearchTemplateVerticalListItem extends QSearchBaseTitleGroupTemplateItem {

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @NotNull
    private final SearchVerticalList verticalList;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    @NotNull
    private List<SearchListDetail> items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchTemplateVerticalListItem(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate searchTemplate) {
        super(commonInfo, searchTemplate);
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(searchTemplate, "searchTemplate");
        this.items = new ArrayList();
        SearchVerticalList searchVerticalList = searchTemplate.verticalList;
        searchVerticalList = searchVerticalList == null ? new SearchVerticalList() : searchVerticalList;
        this.verticalList = searchVerticalList;
        ArrayList<SearchListDetail> listList = searchVerticalList.getListList();
        Intrinsics.checkNotNullExpressionValue(listList, "verticalList.getListList()");
        this.items = listList;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 4;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.QSearchBaseTitleGroupTemplateItem
    @NotNull
    public String toString() {
        return "NetSearchTemplateVerticalListItem(verticalList=" + this.verticalList + ", items=" + this.items + ") " + super.toString();
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a, com.tencent.mobileqq.search.searchdetail.c
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Boolean e(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Boolean.FALSE;
    }

    @NotNull
    public final List<SearchListDetail> y() {
        return this.items;
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final SearchVerticalList getVerticalList() {
        return this.verticalList;
    }
}
