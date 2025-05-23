package com.tencent.mobileqq.power.cpu;

import com.tencent.mobileqq.power.cpu.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0005"}, d2 = {"", "avgCpuUsage", "", "a", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "power_monitor_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class FrontWorkRunnableKt {
    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|(1:(4:10|11|12|(4:14|(1:16)|12|(3:18|19|20)(0))(0))(2:22|23))(3:24|25|(0)(0))))|28|6|7|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0104, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0105, code lost:
    
        r5 = r0.getStackTrace();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "e.stackTrace");
        r1 = kotlin.collections.ArraysKt___ArraysKt.joinToString$default(r5, ";", (java.lang.CharSequence) null, (java.lang.CharSequence) null, 0, (java.lang.CharSequence) null, (kotlin.jvm.functions.Function1) null, 62, (java.lang.Object) null);
        com.tencent.mobileqq.perf.log.a.d("HP_CPU", "FrontWorkRunnable error: " + r0 + "," + r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b2 A[Catch: Exception -> 0x0104, TryCatch #0 {Exception -> 0x0104, blocks: (B:11:0x0040, B:12:0x00c9, B:14:0x00b2, B:18:0x00fd, B:25:0x005b), top: B:7:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00fd A[Catch: Exception -> 0x0104, TRY_LEAVE, TryCatch #0 {Exception -> 0x0104, blocks: (B:11:0x0040, B:12:0x00c9, B:14:0x00b2, B:18:0x00fd, B:25:0x005b), top: B:7:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x00c6 -> B:12:0x00c9). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(double d16, @NotNull Continuation<? super Unit> continuation) {
        FrontWorkRunnableKt$frontWorkRunnable$1 frontWorkRunnableKt$frontWorkRunnable$1;
        Object coroutine_suspended;
        int i3;
        long b16;
        com.tencent.mobileqq.power.config.b bVar;
        int i16;
        int i17;
        a aVar;
        com.tencent.mobileqq.power.cpu.proc.b bVar2;
        Ref.IntRef intRef;
        if (continuation instanceof FrontWorkRunnableKt$frontWorkRunnable$1) {
            frontWorkRunnableKt$frontWorkRunnable$1 = (FrontWorkRunnableKt$frontWorkRunnable$1) continuation;
            int i18 = frontWorkRunnableKt$frontWorkRunnable$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                frontWorkRunnableKt$frontWorkRunnable$1.label = i18 - Integer.MIN_VALUE;
                Object obj = frontWorkRunnableKt$frontWorkRunnable$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = frontWorkRunnableKt$frontWorkRunnable$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        i17 = frontWorkRunnableKt$frontWorkRunnable$1.I$1;
                        b16 = frontWorkRunnableKt$frontWorkRunnable$1.J$0;
                        i16 = frontWorkRunnableKt$frontWorkRunnable$1.I$0;
                        intRef = (Ref.IntRef) frontWorkRunnableKt$frontWorkRunnable$1.L$3;
                        bVar2 = (com.tencent.mobileqq.power.cpu.proc.b) frontWorkRunnableKt$frontWorkRunnable$1.L$2;
                        aVar = (a) frontWorkRunnableKt$frontWorkRunnable$1.L$1;
                        bVar = (com.tencent.mobileqq.power.config.b) frontWorkRunnableKt$frontWorkRunnable$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        aVar.b(System.currentTimeMillis());
                        Map<String, Map<String, com.tencent.mobileqq.power.cpu.proc.a>> f16 = bVar2.f();
                        a.Companion companion = a.INSTANCE;
                        companion.b(aVar);
                        companion.a(aVar, f16);
                        com.tencent.mobileqq.perf.log.a.c("HP_CPU", "FrontWork doWork count: " + intRef.element);
                        bVar2.e(f16, bVar);
                        intRef.element = intRef.element + 1;
                        i17++;
                        if (i17 < i16) {
                            frontWorkRunnableKt$frontWorkRunnable$1.L$0 = bVar;
                            frontWorkRunnableKt$frontWorkRunnable$1.L$1 = aVar;
                            frontWorkRunnableKt$frontWorkRunnable$1.L$2 = bVar2;
                            frontWorkRunnableKt$frontWorkRunnable$1.L$3 = intRef;
                            frontWorkRunnableKt$frontWorkRunnable$1.I$0 = i16;
                            frontWorkRunnableKt$frontWorkRunnable$1.J$0 = b16;
                            frontWorkRunnableKt$frontWorkRunnable$1.I$1 = i17;
                            frontWorkRunnableKt$frontWorkRunnable$1.label = 1;
                            if (DelayKt.delay(b16, frontWorkRunnableKt$frontWorkRunnable$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            aVar.b(System.currentTimeMillis());
                            Map<String, Map<String, com.tencent.mobileqq.power.cpu.proc.a>> f162 = bVar2.f();
                            a.Companion companion2 = a.INSTANCE;
                            companion2.b(aVar);
                            companion2.a(aVar, f162);
                            com.tencent.mobileqq.perf.log.a.c("HP_CPU", "FrontWork doWork count: " + intRef.element);
                            bVar2.e(f162, bVar);
                            intRef.element = intRef.element + 1;
                            i17++;
                            if (i17 < i16) {
                                com.tencent.mobileqq.perf.log.a.c("HP_CPU", "FrontWork doWork finish");
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    QLog.d("QQPowerMonitor", 4, "FrontWork doWork");
                    com.tencent.mobileqq.power.config.b e16 = com.tencent.mobileqq.power.config.a.INSTANCE.a().e(d16);
                    int e17 = e16.e();
                    b16 = e16.b();
                    com.tencent.mobileqq.perf.log.a.c("HP_CPU", "FrontWork doWork type: CpuMonitor_front");
                    a aVar2 = new a(System.currentTimeMillis(), null, 2, null);
                    com.tencent.mobileqq.power.cpu.proc.b bVar3 = new com.tencent.mobileqq.power.cpu.proc.b();
                    bVar3.f();
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 1;
                    bVar = e16;
                    i16 = e17;
                    i17 = 0;
                    aVar = aVar2;
                    bVar2 = bVar3;
                    intRef = intRef2;
                    if (i17 < i16) {
                    }
                }
            }
        }
        frontWorkRunnableKt$frontWorkRunnable$1 = new FrontWorkRunnableKt$frontWorkRunnable$1(continuation);
        Object obj2 = frontWorkRunnableKt$frontWorkRunnable$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = frontWorkRunnableKt$frontWorkRunnable$1.label;
        if (i3 == 0) {
        }
    }
}
