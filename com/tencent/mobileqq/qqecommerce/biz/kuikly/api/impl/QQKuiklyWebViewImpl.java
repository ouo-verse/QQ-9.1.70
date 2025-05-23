package com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl;

import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyWebView;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyWebView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/impl/QQKuiklyWebViewImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyWebView;", "()V", "getWebUiBaseInterface", "", "kuklyWebView", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class QQKuiklyWebViewImpl implements IQQKuiklyWebView {
    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyWebView
    public Object getWebUiBaseInterface(Object kuklyWebView) {
        QQKuiklyWebView qQKuiklyWebView = kuklyWebView instanceof QQKuiklyWebView ? (QQKuiklyWebView) kuklyWebView : null;
        if (qQKuiklyWebView != null) {
            return qQKuiklyWebView.a();
        }
        return null;
    }
}
