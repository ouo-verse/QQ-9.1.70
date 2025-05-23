package com.tencent.qzonehub.api.impl;

import com.tencent.qzonehub.api.IQZoneComposeApi;
import defpackage.QZoneComposePlatformModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qzonehub/api/impl/QZoneComposeApiImpl;", "Lcom/tencent/qzonehub/api/IQZoneComposeApi;", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "", "registerExternalRenderView", "registerExternalModule", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QZoneComposeApiImpl implements IQZoneComposeApi {
    @Override // com.tencent.qzonehub.api.IQZoneComposeApi
    public void registerExternalModule(com.tencent.kuikly.core.render.android.b renderExport) {
        if (renderExport != null) {
            renderExport.a("QZoneComposePlatformModule", new Function0<i01.a>() { // from class: com.tencent.qzonehub.api.impl.QZoneComposeApiImpl$registerExternalModule$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final i01.a invoke() {
                    return new QZoneComposePlatformModule();
                }
            });
        }
    }

    @Override // com.tencent.qzonehub.api.IQZoneComposeApi
    public void registerExternalRenderView(com.tencent.kuikly.core.render.android.b renderExport) {
    }
}
