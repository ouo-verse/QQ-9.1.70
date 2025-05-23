package com.qzone.reborn.intimate.ntcompose;

import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/intimate/ntcompose/QZIntimateLoveTreeKuiklyExport;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/e;", "Lcom/tencent/kuikly/core/render/android/b;", "kuiklyRenderExport", "", "registerExternalModule", "registerExternalRenderView", "registerViewExternalPropHandler", "registerTDFlModule", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateLoveTreeKuiklyExport implements e {
    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerExternalModule(b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        kuiklyRenderExport.a("QZIntimateSpaceLoveTreeModule", new Function0<i01.a>() { // from class: com.qzone.reborn.intimate.ntcompose.QZIntimateLoveTreeKuiklyExport$registerExternalModule$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new a();
            }
        });
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerExternalRenderView(b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerTDFlModule(b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerViewExternalPropHandler(b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
    }
}
