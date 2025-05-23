package com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl;

import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyReport;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/impl/QQKuiklyReportImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyReport;", "()V", "getReportClassName", "", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class QQKuiklyReportImpl implements IQQKuiklyReport {
    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyReport
    public String getReportClassName() {
        String name = QQKuiklyRenderView.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "QQKuiklyRenderView::class.java.name");
        return name;
    }
}
