package com.tencent.ecommerce.base.ui.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/base/ui/api/IECRenderViewRegister;", "", "Lcom/tencent/kuikly/core/render/android/b;", "hippyRenderExport", "", "registerHippyRenderView", "kuiklyRenderExport", "registerKuiklyRenderView", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECRenderViewRegister {
    void registerHippyRenderView(@NotNull com.tencent.kuikly.core.render.android.b hippyRenderExport);

    void registerKuiklyRenderView(@NotNull com.tencent.kuikly.core.render.android.b kuiklyRenderExport);
}
