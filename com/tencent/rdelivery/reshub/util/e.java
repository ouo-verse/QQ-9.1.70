package com.tencent.rdelivery.reshub.util;

import com.tencent.rdelivery.reshub.report.ReportHelper;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a \u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0000\u001a\u001c\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/a;", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Lcom/tencent/rdelivery/reshub/processor/l;", "chain", "", "c", "", "status", "", "downloadSize", "totalSize", "", "a", "", "msg", "", "exception", "b", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class e {
    public static final float a(int i3, long j3, long j16) {
        float f16;
        if (j16 == 0) {
            f16 = 0.0f;
        } else if (j3 >= j16) {
            f16 = 1.0f;
        } else {
            f16 = ((float) j3) / ((float) j16);
        }
        switch (i3) {
            case 0:
            default:
                return 0.0f;
            case 1:
                return 0.1f;
            case 2:
                return 0.2f;
            case 3:
                return (f16 * 0.2f) + 0.2f;
            case 4:
                return 0.4f;
            case 5:
            case 12:
                return 0.5f;
            case 6:
            case 13:
                return (f16 * 0.3f) + 0.5f;
            case 7:
            case 14:
                return 0.8f;
            case 8:
                return 0.9f;
            case 9:
                return 0.95f;
            case 10:
                return 0.85f;
            case 11:
                return 0.86f;
            case 15:
                return 0.81f;
            case 16:
                return 0.82f;
        }
    }

    private static final void b(String str, Throwable th5) {
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(10004);
        aVar.g(str);
        aVar.f(th5);
        new ReportHelper().b(aVar);
    }

    public static final void c(@NotNull com.tencent.rdelivery.reshub.processor.a safeProceed, @NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull com.tencent.rdelivery.reshub.processor.l chain) {
        Object m476constructorimpl;
        Intrinsics.checkParameterIsNotNull(safeProceed, "$this$safeProceed");
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        try {
            Result.Companion companion = Result.INSTANCE;
            safeProceed.i(req, chain);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            String str = "Proceed Exception: " + m479exceptionOrNullimpl.getMessage();
            jz3.d.d("ProcessorUtil", str, m479exceptionOrNullimpl);
            b(str, m479exceptionOrNullimpl);
            safeProceed.d(chain, req, m479exceptionOrNullimpl);
        }
    }
}
