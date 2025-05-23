package com.tencent.mobileqq.qqecommerce.biz.ui;

import android.content.Context;
import com.tencent.ecommerce.base.ui.api.IECRenderViewRegister;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyVideoBlurView;
import i01.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/ui/ECRenderViewRegister;", "Lcom/tencent/ecommerce/base/ui/api/IECRenderViewRegister;", "Lcom/tencent/kuikly/core/render/android/b;", "hippyRenderExport", "", "registerHippyRenderView", "kuiklyRenderExport", "registerKuiklyRenderView", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECRenderViewRegister implements IECRenderViewRegister {
    @Override // com.tencent.ecommerce.base.ui.api.IECRenderViewRegister
    public void registerHippyRenderView(b hippyRenderExport) {
        Intrinsics.checkNotNullParameter(hippyRenderExport, "hippyRenderExport");
        b.a.a(hippyRenderExport, "HRVideoView", new Function1<Context, c>() { // from class: com.tencent.mobileqq.qqecommerce.biz.ui.ECRenderViewRegister$registerHippyRenderView$1$1
            @Override // kotlin.jvm.functions.Function1
            public final c invoke(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new HRVideoView(context);
            }
        }, null, 4, null);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECRenderViewRegister
    public void registerKuiklyRenderView(b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        b.a.a(kuiklyRenderExport, "HRVideoView", new Function1<Context, c>() { // from class: com.tencent.mobileqq.qqecommerce.biz.ui.ECRenderViewRegister$registerKuiklyRenderView$1$1
            @Override // kotlin.jvm.functions.Function1
            public final c invoke(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new HRVideoView(context);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "QQKuiklyVideoBlurView", new Function1<Context, c>() { // from class: com.tencent.mobileqq.qqecommerce.biz.ui.ECRenderViewRegister$registerKuiklyRenderView$1$2
            @Override // kotlin.jvm.functions.Function1
            public final c invoke(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new QQKuiklyVideoBlurView(context);
            }
        }, null, 4, null);
    }
}
