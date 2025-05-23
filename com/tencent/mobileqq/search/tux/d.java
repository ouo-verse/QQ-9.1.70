package com.tencent.mobileqq.search.tux;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/search/tux/d;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "", "getItemType", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "getTemplate", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "template", "Lcom/tencent/mobileqq/search/tux/i;", "H", "Lcom/tencent/mobileqq/search/tux/i;", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/search/tux/i;", "tuxReportData", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "", "keyword", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;Ljava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d extends com.tencent.mobileqq.search.searchdetail.content.template.model.a {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final SearchTemplate template;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final i tuxReportData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate template, @NotNull String keyword) {
        super(commonInfo, template);
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        this.template = template;
        this.tuxReportData = new i(keyword, commonInfo.getTraceId());
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 21;
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final i getTuxReportData() {
        return this.tuxReportData;
    }
}
