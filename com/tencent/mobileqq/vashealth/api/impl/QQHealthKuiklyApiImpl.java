package com.tencent.mobileqq.vashealth.api.impl;

import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.vashealth.api.IQQHealthKuiklyApi;
import k43.d;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vashealth/api/impl/QQHealthKuiklyApiImpl;", "Lcom/tencent/mobileqq/vashealth/api/IQQHealthKuiklyApi;", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "", "registerExternalRenderView", "registerExternalModule", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QQHealthKuiklyApiImpl implements IQQHealthKuiklyApi {
    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthKuiklyApi
    public void registerExternalModule(@NotNull b renderExport) {
        Intrinsics.checkNotNullParameter(renderExport, "renderExport");
        renderExport.a("QQKuiklyHealthModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.vashealth.api.impl.QQHealthKuiklyApiImpl$registerExternalModule$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new d();
            }
        });
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthKuiklyApi
    public void registerExternalRenderView(@NotNull b renderExport) {
        Intrinsics.checkNotNullParameter(renderExport, "renderExport");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
