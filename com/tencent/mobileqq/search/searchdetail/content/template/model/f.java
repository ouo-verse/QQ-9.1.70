package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchHotTopic;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/f;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "", "getItemType", "Lcom/tencent/mobileqq/search/searchdetail/c;", "newItem", "", HippyTKDListViewAdapter.X, "(Lcom/tencent/mobileqq/search/searchdetail/c;)Ljava/lang/Boolean;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "getTemplate", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "template", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchHotTopic;", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchHotTopic;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchHotTopic;", "hotTopic", "Lcom/tencent/mobileqq/search/searchdetail/multimedia/q;", "I", "Lcom/tencent/mobileqq/search/searchdetail/multimedia/q;", "y", "()Lcom/tencent/mobileqq/search/searchdetail/multimedia/q;", "setContentRichText", "(Lcom/tencent/mobileqq/search/searchdetail/multimedia/q;)V", "contentRichText", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "J", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f extends a {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final SearchTemplate template;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final SearchHotTopic hotTopic;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.search.searchdetail.multimedia.q contentRichText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate template) {
        super(commonInfo, template);
        boolean z16;
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(template, "template");
        this.template = template;
        SearchHotTopic searchHotTopic = template.hotTopic;
        searchHotTopic = searchHotTopic == null ? new SearchHotTopic() : searchHotTopic;
        this.hotTopic = searchHotTopic;
        com.tencent.mobileqq.search.searchdetail.multimedia.q qVar = new com.tencent.mobileqq.search.searchdetail.multimedia.q(searchHotTopic.richText);
        String str = searchHotTopic.content;
        Intrinsics.checkNotNullExpressionValue(str, "hotTopic.content");
        qVar.e(str);
        this.contentRichText = qVar;
        String str2 = template.data;
        Intrinsics.checkNotNullExpressionValue(str2, "template.data");
        if (str2.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("NetSearchHotTopicItem", 1, template.data);
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 17;
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
    public final com.tencent.mobileqq.search.searchdetail.multimedia.q getContentRichText() {
        return this.contentRichText;
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final SearchHotTopic getHotTopic() {
        return this.hotTopic;
    }
}
