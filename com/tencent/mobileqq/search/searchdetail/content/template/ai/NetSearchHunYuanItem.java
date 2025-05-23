package com.tencent.mobileqq.search.searchdetail.content.template.ai;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.NetSearchHunYuanViewModel;
import com.tencent.qqnt.kernel.nativeinterface.SearchAICard;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/b;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "", "getItemType", "", "toString", "G", "Ljava/lang/String;", "getKeyWord", "()Ljava/lang/String;", "keyWord", "H", "I", "getUserSource", "()I", "userSource", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/NetSearchHunYuanViewModel;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/NetSearchHunYuanViewModel;", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/NetSearchHunYuanViewModel;", "viewModel", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "template", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;Ljava/lang/String;I)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.ai.b, reason: from toString */
/* loaded from: classes18.dex */
public final class NetSearchHunYuanItem extends com.tencent.mobileqq.search.searchdetail.content.template.model.a {

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @NotNull
    private final String keyWord;

    /* renamed from: H, reason: from kotlin metadata */
    private final int userSource;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final NetSearchHunYuanViewModel viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchHunYuanItem(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate template, @NotNull String keyWord, int i3) {
        super(commonInfo, template);
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(keyWord, "keyWord");
        this.keyWord = keyWord;
        this.userSource = i3;
        SearchAICard searchAICard = template.aiCard;
        Intrinsics.checkNotNullExpressionValue(searchAICard, "template.aiCard");
        this.viewModel = new NetSearchHunYuanViewModel(searchAICard, keyWord, i3);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 19;
    }

    @NotNull
    public String toString() {
        return "NetSearchHunYuanItem(keyWord='" + this.keyWord + "', aiInfo=" + this.viewModel.getAiCard().aiInfo + ")";
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final NetSearchHunYuanViewModel getViewModel() {
        return this.viewModel;
    }
}
