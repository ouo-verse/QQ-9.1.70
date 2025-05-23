package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasPagLoadApi;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasPagLoadApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVasPagLoadApi;", "()V", "initPagSo", "", "requestPagDownload", "", "block", "Lkotlin/Function0;", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasPagLoadApiImpl implements IVasPagLoadApi {
    @Override // com.tencent.mobileqq.vas.api.IVasPagLoadApi
    public boolean initPagSo() {
        return ((IVasTempApi) QRoute.api(IVasTempApi.class)).initPagSo();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasPagLoadApi
    public void requestPagDownload(@NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ((IVasTempApi) QRoute.api(IVasTempApi.class)).requestPagDownload(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasPagLoadApiImpl$requestPagDownload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                block.invoke();
            }
        });
    }
}
