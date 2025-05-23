package com.tencent.mobileqq.vas.ui;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.api.IVasPagLoadApi;
import com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/PagLoaderImpl;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$Loader;", "()V", "isLoad", "", "isLoading", "loaderListener", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$LoaderCallback;", "Lkotlin/collections/ArrayList;", "needLoad", "doLoad", "", "block", "Lkotlin/Function0;", "isLoaded", "notifyListener", "syncLoad", "callback", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class PagLoaderImpl implements AbsAsyncLoadProxy.Loader {
    private boolean isLoad;
    private boolean isLoading;

    @NotNull
    private final ArrayList<AbsAsyncLoadProxy.LoaderCallback> loaderListener = new ArrayList<>();
    private boolean needLoad;

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyListener() {
        if (this.loaderListener.isEmpty()) {
            return;
        }
        Iterator<T> it = this.loaderListener.iterator();
        while (it.hasNext()) {
            ((AbsAsyncLoadProxy.LoaderCallback) it.next()).onLoadSucceed();
        }
        this.loaderListener.clear();
    }

    public final void doLoad(@NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            IVasPagLoadApi.Companion companion = IVasPagLoadApi.INSTANCE;
            QRouteApi api = QRoute.api(IVasPagLoadApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVasPagLoadApi::class.java)");
            ((IVasPagLoadApi) api).requestPagDownload(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.ui.PagLoaderImpl$doLoad$1
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
                    boolean z16;
                    z16 = PagLoaderImpl.this.isLoad;
                    if (!z16) {
                        IVasPagLoadApi.Companion companion2 = IVasPagLoadApi.INSTANCE;
                        QRouteApi api2 = QRoute.api(IVasPagLoadApi.class);
                        Intrinsics.checkNotNullExpressionValue(api2, "api(IVasPagLoadApi::class.java)");
                        if (((IVasPagLoadApi) api2).initPagSo()) {
                            block.invoke();
                        }
                    }
                    PagLoaderImpl.this.isLoading = false;
                }
            });
        } catch (Throwable th5) {
            QLog.e(PagViewProxy.INSTANCE.getTAG(), 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy.Loader
    /* renamed from: isLoaded, reason: from getter */
    public boolean getIsLoad() {
        return this.isLoad;
    }

    @Override // com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy.Loader
    public void syncLoad(@NotNull AbsAsyncLoadProxy.LoaderCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.needLoad = true;
        synchronized (this.loaderListener) {
            if (this.isLoad) {
                callback.onLoadSucceed();
                notifyListener();
                return;
            }
            this.loaderListener.add(callback);
            if (!this.isLoading) {
                this.isLoading = true;
                doLoad(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.ui.PagLoaderImpl$syncLoad$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        ArrayList arrayList;
                        arrayList = PagLoaderImpl.this.loaderListener;
                        PagLoaderImpl pagLoaderImpl = PagLoaderImpl.this;
                        synchronized (arrayList) {
                            pagLoaderImpl.isLoad = true;
                            pagLoaderImpl.notifyListener();
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                });
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
