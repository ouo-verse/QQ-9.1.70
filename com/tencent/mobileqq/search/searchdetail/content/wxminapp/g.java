package com.tencent.mobileqq.search.searchdetail.content.wxminapp;

import android.view.View;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.view.QSearchMiniAppDetailView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J*\u0010\u000f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014J(\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/g;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/b;", "Landroid/view/View;", "containerView", "", "y", "", "getViewStubLayoutId", "data", "", "position", "", "", "payload", "Y", "X", "Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchMiniAppDetailView;", "D", "Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchMiniAppDetailView;", "contentView", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class g extends BaseSearchTemplateSection<b> {

    /* renamed from: D, reason: from kotlin metadata */
    private QSearchMiniAppDetailView contentView;

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull b data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection, com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchReportSection, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable b data, int position, @Nullable List<Object> payload) {
        if (getDtReportIoc() == null) {
            s((com.tencent.mobileqq.search.searchdetail.content.base.c) SectionIOCKt.getIocInterface(this, com.tencent.mobileqq.search.searchdetail.content.base.c.class));
        }
        if (data == null) {
            return;
        }
        QSearchMiniAppDetailView qSearchMiniAppDetailView = this.contentView;
        if (qSearchMiniAppDetailView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            qSearchMiniAppDetailView = null;
        }
        qSearchMiniAppDetailView.a(data, position, payload, getDtReportIoc());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public void y(@Nullable View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.content);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.content)");
            this.contentView = (QSearchMiniAppDetailView) findViewById;
        }
    }
}
