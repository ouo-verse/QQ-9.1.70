package com.tencent.mobileqq.qqecommerce.base.image;

import com.tencent.ecommerce.base.imageloader.api.IECPagSoLoader;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0006H\u0016R\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/image/ECPagSoLoader;", "Lcom/tencent/ecommerce/base/imageloader/api/IECPagSoLoader;", "", "downloadPagSo", "", "loadPagSo", "Lkotlin/Function1;", "resultBlock", "loadPagSoAsync", "a", "Z", "hasLoadSo", "<init>", "()V", "b", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECPagSoLoader implements IECPagSoLoader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean hasLoadSo;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final Function1 resultBlock) {
        Intrinsics.checkNotNullParameter(resultBlock, "$resultBlock");
        ((IVasTempApi) QRoute.api(IVasTempApi.class)).requestPagDownload(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.base.image.ECPagSoLoader$loadPagSoAsync$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                boolean initPagSo = ((IVasTempApi) QRoute.api(IVasTempApi.class)).initPagSo();
                if (!initPagSo) {
                    QLog.e("ECPagSoLoader", 1, "load so failed.");
                }
                resultBlock.invoke(Boolean.valueOf(initPagSo));
            }
        });
    }

    @Override // com.tencent.ecommerce.base.imageloader.api.IECPagSoLoader
    public void downloadPagSo() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.base.image.d
            @Override // java.lang.Runnable
            public final void run() {
                ECPagSoLoader.c();
            }
        }, 128, null, true);
    }

    @Override // com.tencent.ecommerce.base.imageloader.api.IECPagSoLoader
    public boolean loadPagSo() {
        if (!this.hasLoadSo) {
            this.hasLoadSo = ((IVasTempApi) QRoute.api(IVasTempApi.class)).initPagSo();
        }
        if (!this.hasLoadSo) {
            QLog.e("ECPagSoLoader", 1, "load so failed.");
        }
        return this.hasLoadSo;
    }

    @Override // com.tencent.ecommerce.base.imageloader.api.IECPagSoLoader
    public void loadPagSoAsync(final Function1<? super Boolean, Unit> resultBlock) {
        Intrinsics.checkNotNullParameter(resultBlock, "resultBlock");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.base.image.e
            @Override // java.lang.Runnable
            public final void run() {
                ECPagSoLoader.d(Function1.this);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        QLog.i("ECPagSoLoader", 1, "downloadPagSo start");
        ((IVasTempApi) QRoute.api(IVasTempApi.class)).requestPagDownload(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.base.image.ECPagSoLoader$downloadPagSo$1$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QLog.i("ECPagSoLoader", 1, "downloadPagSo finish");
            }
        });
    }
}
