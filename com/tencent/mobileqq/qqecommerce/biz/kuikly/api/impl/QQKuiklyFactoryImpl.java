package com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl;

import android.content.Context;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyFragment;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/impl/QQKuiklyFactoryImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyFactory;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "delegate", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "createKuiklyRenderView", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "createQQKuiklyFragment", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyFactoryImpl implements IQQKuiklyFactory {
    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory
    public g createKuiklyRenderView(Context context, h delegate) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new QQKuiklyRenderView(context, delegate, true);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory
    public QPublicBaseFragment createQQKuiklyFragment() {
        QQKuiklyFragment qQKuiklyFragment = new QQKuiklyFragment();
        qQKuiklyFragment.wh(true);
        return qQKuiklyFragment;
    }
}
