package com.tencent.zplan.engine.service;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lx4.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004R\u001d\u0010\f\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/engine/service/ZPlanEngineQualityReporter;", "", "", "eventCode", "", "params", "", "b", "Llx4/b;", "a", "Lkotlin/Lazy;", "()Llx4/b;", "dtReporter", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanEngineQualityReporter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy dtReporter;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final ZPlanEngineQualityReporter f385585b = new ZPlanEngineQualityReporter();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<lx4.b>() { // from class: com.tencent.zplan.engine.service.ZPlanEngineQualityReporter$dtReporter$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final lx4.b invoke() {
                return (lx4.b) mx4.a.f417748a.a(lx4.b.class);
            }
        });
        dtReporter = lazy;
    }

    ZPlanEngineQualityReporter() {
    }

    private final lx4.b a() {
        return (lx4.b) dtReporter.getValue();
    }

    public final void b(@NotNull String eventCode, @Nullable Map<String, String> params) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        lx4.b a16 = a();
        if (a16 != null) {
            b.C10752b.a(a16, null, eventCode, params, 1, null);
        }
    }
}
