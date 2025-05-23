package com.tencent.richframework.argus.business.performance.function.sample;

import com.tencent.biz.richframework.monitor.sample.IRFWSampleManager;
import com.tencent.richframework.argus.business.performance.function.sample.page.ArgusPageSampleManager;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/richframework/argus/business/performance/function/sample/ArgusMonitorSampleHelper;", "", "", "isOpenReportSample", "isOpenPreloadSample", "isOpenPageSample", "isOpenReportSimple$delegate", "Lkotlin/Lazy;", "isOpenReportSimple", "()Z", "isOpenPreloadSimple$delegate", "isOpenPreloadSimple", "isOpenPageSimple$delegate", "isOpenPageSimple", "<init>", "()V", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class ArgusMonitorSampleHelper {

    @NotNull
    public static final ArgusMonitorSampleHelper INSTANCE = new ArgusMonitorSampleHelper();

    /* renamed from: isOpenPageSimple$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy isOpenPageSimple;

    /* renamed from: isOpenPreloadSimple$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy isOpenPreloadSimple;

    /* renamed from: isOpenReportSimple$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy isOpenReportSimple;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.richframework.argus.business.performance.function.sample.ArgusMonitorSampleHelper$isOpenReportSimple$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(IRFWSampleManager.DefaultImpls.hitSample$default(new ArgusReportSampleManager(), null, 1, null));
            }
        });
        isOpenReportSimple = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.richframework.argus.business.performance.function.sample.ArgusMonitorSampleHelper$isOpenPreloadSimple$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(IRFWSampleManager.DefaultImpls.hitSample$default(new ArgusPreloadSampleManager(), null, 1, null));
            }
        });
        isOpenPreloadSimple = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.richframework.argus.business.performance.function.sample.ArgusMonitorSampleHelper$isOpenPageSimple$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(IRFWSampleManager.DefaultImpls.hitSample$default(new ArgusPageSampleManager(), null, 1, null));
            }
        });
        isOpenPageSimple = lazy3;
    }

    ArgusMonitorSampleHelper() {
    }

    private final boolean isOpenPageSimple() {
        return ((Boolean) isOpenPageSimple.getValue()).booleanValue();
    }

    private final boolean isOpenPreloadSimple() {
        return ((Boolean) isOpenPreloadSimple.getValue()).booleanValue();
    }

    private final boolean isOpenReportSimple() {
        return ((Boolean) isOpenReportSimple.getValue()).booleanValue();
    }

    public final boolean isOpenPageSample() {
        return isOpenPageSimple();
    }

    public final boolean isOpenPreloadSample() {
        return isOpenPreloadSimple();
    }

    public final boolean isOpenReportSample() {
        return isOpenReportSimple();
    }
}
