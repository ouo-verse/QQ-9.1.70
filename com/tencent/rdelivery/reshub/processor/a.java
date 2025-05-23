package com.tencent.rdelivery.reshub.processor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\u0002J\b\u0010\u0005\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\"\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fJ \u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003H\u0004J4\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013J0\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/a;", "", "other", "", "c", "getPriority", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Lcom/tencent/rdelivery/reshub/processor/l;", "chain", "", "i", "", "exception", "d", "status", "j", "Lcom/tencent/rdelivery/reshub/report/a;", "errorInfo", "", "downloadSize", "totalSize", "g", "", "isSuccess", "e", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public abstract class a implements Comparable<a> {
    public static /* synthetic */ void f(a aVar, boolean z16, int i3, com.tencent.rdelivery.reshub.core.k kVar, l lVar, com.tencent.rdelivery.reshub.report.a aVar2, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 16) != 0) {
                aVar2 = new com.tencent.rdelivery.reshub.report.a();
            }
            aVar.e(z16, i3, kVar, lVar, aVar2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onComplete");
    }

    public static /* synthetic */ void h(a aVar, int i3, com.tencent.rdelivery.reshub.core.k kVar, com.tencent.rdelivery.reshub.report.a aVar2, long j3, long j16, int i16, Object obj) {
        long j17;
        long j18;
        if (obj == null) {
            if ((i16 & 8) != 0) {
                j17 = 0;
            } else {
                j17 = j3;
            }
            if ((i16 & 16) != 0) {
                j18 = 0;
            } else {
                j18 = j16;
            }
            aVar.g(i3, kVar, aVar2, j17, j18);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onProgress");
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(@NotNull a other) {
        Intrinsics.checkParameterIsNotNull(other, "other");
        return getPriority() - other.getPriority();
    }

    public final void d(@NotNull l chain, @NotNull com.tencent.rdelivery.reshub.core.k req, @Nullable Throwable exception) {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Intrinsics.checkParameterIsNotNull(req, "req");
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(10004);
        aVar.f(exception);
        e(false, 208, req, chain, aVar);
    }

    public final void e(boolean isSuccess, int status, @NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain, @NotNull com.tencent.rdelivery.reshub.report.a errorInfo) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Intrinsics.checkParameterIsNotNull(errorInfo, "errorInfo");
        com.tencent.rdelivery.reshub.core.e.f364425b.c(isSuccess, status, req, errorInfo);
        chain.b();
    }

    public final void g(int status, @NotNull com.tencent.rdelivery.reshub.core.k req, @Nullable com.tencent.rdelivery.reshub.report.a errorInfo, long downloadSize, long totalSize) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        req.B(status, errorInfo);
        com.tencent.rdelivery.reshub.core.e.f364425b.f(status, downloadSize, totalSize, req);
    }

    public abstract int getPriority();

    public abstract void i(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j(@NotNull l chain, @NotNull com.tencent.rdelivery.reshub.core.k req, int status) {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Intrinsics.checkParameterIsNotNull(req, "req");
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(1005);
        e(false, status, req, chain, aVar);
    }
}
