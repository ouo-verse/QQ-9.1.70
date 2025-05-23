package com.tencent.mobileqq.search.searchdetail.content.template.model;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchHorizontalList;
import com.tencent.qqnt.kernel.nativeinterface.SearchListDetail;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/m;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/u;", "", "getItemType", "Lcom/tencent/mobileqq/search/searchdetail/c;", "newItem", "", HippyTKDListViewAdapter.X, "(Lcom/tencent/mobileqq/search/searchdetail/c;)Ljava/lang/Boolean;", "", "toString", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchHorizontalList;", "I", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchHorizontalList;", "y", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchHorizontalList;", "horizontalList", "J", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()I", "setType", "(I)V", "type", "", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/v;", "K", "Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/util/List;", "items", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "searchTemplate", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.m, reason: from toString */
/* loaded from: classes18.dex */
public final class NetSearchTemplateHorizontalListItem extends QSearchBaseTitleGroupTemplateItem {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final SearchHorizontalList horizontalList;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    private int type;

    /* renamed from: K, reason: from kotlin metadata and from toString */
    @NotNull
    private final List<QSearchListItemModel> items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchTemplateHorizontalListItem(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate searchTemplate) {
        super(commonInfo, searchTemplate);
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(searchTemplate, "searchTemplate");
        SearchHorizontalList searchHorizontalList = searchTemplate.horizontalList;
        searchHorizontalList = searchHorizontalList == null ? new SearchHorizontalList() : searchHorizontalList;
        this.horizontalList = searchHorizontalList;
        this.type = 1;
        this.items = new ArrayList();
        this.type = searchHorizontalList.listType;
        ArrayList<SearchListDetail> arrayList = searchHorizontalList.listList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "horizontalList.listList");
        for (SearchListDetail searchListDetail : arrayList) {
            this.items.add(new QSearchListItemModel(searchListDetail.icon, searchListDetail.title, searchListDetail.subTitle, searchListDetail.button, searchListDetail.jumpLink, searchListDetail.reportInfo));
        }
    }

    /* renamed from: A, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 3;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.QSearchBaseTitleGroupTemplateItem
    @NotNull
    public String toString() {
        return "NetSearchTemplateHorizontalListItem(commonInfo=" + getCommonInfo() + ", type=" + this.type + ", items=" + this.items + ")";
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
    public final SearchHorizontalList getHorizontalList() {
        return this.horizontalList;
    }

    @NotNull
    public final List<QSearchListItemModel> z() {
        return this.items;
    }
}
