package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import android.content.Context;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "delegate", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "createKuiklyRenderView", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "createQQKuiklyFragment", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQKuiklyFactory extends QRouteApi {
    @NotNull
    g createKuiklyRenderView(@NotNull Context context, @NotNull h delegate);

    @NotNull
    QPublicBaseFragment createQQKuiklyFragment();
}
