package com.tencent.rdelivery.reshub.loader;

import com.tencent.rdelivery.reshub.api.f;
import com.tencent.rdelivery.reshub.api.h;
import com.tencent.rdelivery.reshub.util.ResLoadCallbackUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/rdelivery/reshub/loader/RemoteLoadInterceptManager;", "", "Lcom/tencent/rdelivery/reshub/api/f;", "interceptor", "", "d", "", "c", "", "resId", "Lcom/tencent/rdelivery/reshub/api/h;", "callback", "Lkotlin/Function0;", "thenDo", "b", "a", "Lcom/tencent/rdelivery/reshub/api/f;", "loadInterceptor", "Lcom/tencent/rdelivery/reshub/report/a;", "Lcom/tencent/rdelivery/reshub/report/a;", "userCancelledError", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class RemoteLoadInterceptManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private f loadInterceptor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.rdelivery.reshub.report.a userCancelledError;

    public RemoteLoadInterceptManager() {
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(12001);
        this.userCancelledError = aVar;
    }

    public final void b(@NotNull String resId, @Nullable final h callback, @NotNull final Function0<Unit> thenDo) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        Intrinsics.checkParameterIsNotNull(thenDo, "thenDo");
        f fVar = this.loadInterceptor;
        if (fVar == null) {
            thenDo.invoke();
        } else if (!fVar.a(resId)) {
            thenDo.invoke();
        } else {
            fVar.c(resId, new Runnable() { // from class: com.tencent.rdelivery.reshub.loader.RemoteLoadInterceptManager$checkIntercept$preloadAction$1
                @Override // java.lang.Runnable
                public final void run() {
                    Function0.this.invoke();
                }
            }, new Runnable() { // from class: com.tencent.rdelivery.reshub.loader.RemoteLoadInterceptManager$checkIntercept$cancelAction$1
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.rdelivery.reshub.report.a aVar;
                    h hVar = callback;
                    if (hVar != null) {
                        aVar = RemoteLoadInterceptManager.this.userCancelledError;
                        ResLoadCallbackUtilKt.e(hVar, false, null, aVar);
                    }
                }
            });
        }
    }

    public final boolean c() {
        f fVar = this.loadInterceptor;
        if (fVar != null) {
            return fVar.b();
        }
        return false;
    }

    public final void d(@NotNull f interceptor) {
        Intrinsics.checkParameterIsNotNull(interceptor, "interceptor");
        this.loadInterceptor = interceptor;
    }
}
