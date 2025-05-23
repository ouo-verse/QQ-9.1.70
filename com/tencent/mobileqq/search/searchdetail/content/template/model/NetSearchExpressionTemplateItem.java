package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchEmotionList;
import com.tencent.qqnt.kernel.nativeinterface.SearchPicture;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR0\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/c;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/u;", "", "getItemType", "Lcom/tencent/mobileqq/search/searchdetail/c;", "newItem", "", HippyTKDListViewAdapter.X, "(Lcom/tencent/mobileqq/search/searchdetail/c;)Ljava/lang/Boolean;", "", "toString", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "I", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "getSearchTemplate", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "searchTemplate", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchPicture;", "kotlin.jvm.PlatformType", "J", "Ljava/util/List;", "y", "()Ljava/util/List;", "setEmotionList", "(Ljava/util/List;)V", "emotionList", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.c, reason: from toString */
/* loaded from: classes18.dex */
public final class NetSearchExpressionTemplateItem extends QSearchBaseTitleGroupTemplateItem {

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @NotNull
    private final SearchTemplate searchTemplate;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    @NotNull
    private List<SearchPicture> emotionList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchExpressionTemplateItem(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate searchTemplate) {
        super(commonInfo, searchTemplate);
        List<SearchPicture> list;
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(searchTemplate, "searchTemplate");
        this.searchTemplate = searchTemplate;
        SearchEmotionList searchEmotionList = searchTemplate.emotionList;
        if (searchEmotionList != null) {
            list = searchEmotionList.getPics();
        } else {
            list = null;
        }
        this.emotionList = list == null ? CollectionsKt__CollectionsKt.emptyList() : list;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 12;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.QSearchBaseTitleGroupTemplateItem
    @NotNull
    public String toString() {
        return "NetSearchExpressionTemplateItem(searchTemplate=" + this.searchTemplate + ", emotionList=" + this.emotionList + ") " + super.toString();
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a, com.tencent.mobileqq.search.searchdetail.c
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Boolean e(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Boolean.FALSE;
    }

    @NotNull
    public final List<SearchPicture> y() {
        return this.emotionList;
    }
}
