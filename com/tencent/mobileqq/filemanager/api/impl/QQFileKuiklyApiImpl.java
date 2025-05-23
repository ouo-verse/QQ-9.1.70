package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IQQFileKuiklyApi;
import com.tencent.mobileqq.filemanager.kuikly.module.QQFileKuiklyModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/filemanager/api/impl/QQFileKuiklyApiImpl;", "Lcom/tencent/mobileqq/filemanager/api/IQQFileKuiklyApi;", "Lcom/tencent/kuikly/core/render/android/b;", "kuiklyRenderExport", "", "registerExternalModule", "<init>", "()V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QQFileKuiklyApiImpl implements IQQFileKuiklyApi {
    @Override // com.tencent.mobileqq.filemanager.api.IQQFileKuiklyApi
    public void registerExternalModule(@NotNull com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        kuiklyRenderExport.a("QQFileKuiklyModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.filemanager.api.impl.QQFileKuiklyApiImpl$registerExternalModule$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new QQFileKuiklyModule();
            }
        });
        kuiklyRenderExport.a("QQFlashTransferKuiklyModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.filemanager.api.impl.QQFileKuiklyApiImpl$registerExternalModule$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new com.tencent.mobileqq.filemanager.kuikly.module.a();
            }
        });
    }
}
