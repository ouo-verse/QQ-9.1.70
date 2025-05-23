package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import com.tencent.qqnt.kernel.nativeinterface.SearchTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/u;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "", "toString", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTitle;", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTitle;", "getSearchTitle", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchTitle;", "searchTitle", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "getMoreJumpInfo", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "moreJumpInfo", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "template", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.u, reason: from toString */
/* loaded from: classes18.dex */
public abstract class QSearchBaseTitleGroupTemplateItem extends a {

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @Nullable
    private final SearchTitle searchTitle;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @Nullable
    private final SearchButton moreJumpInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchBaseTitleGroupTemplateItem(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate template) {
        super(commonInfo, template);
        SearchButton searchButton;
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(template, "template");
        SearchTitle searchTitle = template.title;
        this.searchTitle = searchTitle;
        if (searchTitle != null) {
            searchButton = searchTitle.button;
        } else {
            searchButton = null;
        }
        this.moreJumpInfo = searchButton;
    }

    @NotNull
    public String toString() {
        return "QSearchBaseTitleGroupTemplateItem(searchTitle=" + this.searchTitle + ", moreJumpInfo=" + this.moreJumpInfo + ") commonInfo=" + getCommonInfo();
    }
}
