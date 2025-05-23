package com.tencent.mobileqq.search.searchdetail.banner;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchReportSection;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import hp2.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/banner/j;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchReportSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/model/b;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "t", "Lcom/tencent/mobileqq/search/searchdetail/banner/h;", "f", "Lcom/tencent/mobileqq/search/searchdetail/banner/h;", IndividuationUrlHelper.UrlId.CARD_HOME, "<init>", "()V", tl.h.F, "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class j extends BaseSearchReportSection<com.tencent.mobileqq.search.searchdetail.content.model.b> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h card;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView == null) {
            QLog.e("NetSearchBannerSection", 1, "onInitView got null item");
            return;
        }
        u e16 = u.e(containerView.findViewById(R.id.ydu));
        Intrinsics.checkNotNullExpressionValue(e16, "bind(containerView.findV\u2026out_correct_card_layout))");
        this.card = new h(e16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchReportSection, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.search.searchdetail.content.model.b data, int position, @Nullable List<Object> payload) {
        super.onBindData(data, position, payload);
        if (data == null) {
            QLog.e("NetSearchBannerSection", 1, "onBindData got null item");
            return;
        }
        h hVar = this.card;
        if (hVar != null) {
            hVar.h(data, getDtReportIoc());
        }
    }
}
