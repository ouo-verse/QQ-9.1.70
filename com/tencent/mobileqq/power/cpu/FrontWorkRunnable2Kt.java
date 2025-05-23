package com.tencent.mobileqq.power.cpu;

import com.tencent.mobileqq.power.cpu.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/power/a;", "callback", "", "a", "(Lcom/tencent/mobileqq/power/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "power_monitor_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class FrontWorkRunnable2Kt {
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|(1:(4:9|10|11|12)(2:31|32))(2:33|(2:35|36)(4:37|38|39|(1:41)(1:42)))|13|14|15|16|17))|48|6|(0)(0)|13|14|15|16|17|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00bc, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(@Nullable com.tencent.mobileqq.power.a aVar, @NotNull Continuation<? super Unit> continuation) {
        FrontWorkRunnable2Kt$getTopCpuData$1 frontWorkRunnable2Kt$getTopCpuData$1;
        Object coroutine_suspended;
        int i3;
        Map<String, Map<String, com.tencent.mobileqq.power.cpu.proc.a>> map;
        com.tencent.mobileqq.power.cpu.proc.b bVar;
        a aVar2;
        String joinToString$default;
        com.tencent.mobileqq.power.a aVar3 = aVar;
        try {
            if (continuation instanceof FrontWorkRunnable2Kt$getTopCpuData$1) {
                frontWorkRunnable2Kt$getTopCpuData$1 = (FrontWorkRunnable2Kt$getTopCpuData$1) continuation;
                int i16 = frontWorkRunnable2Kt$getTopCpuData$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    frontWorkRunnable2Kt$getTopCpuData$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = frontWorkRunnable2Kt$getTopCpuData$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = frontWorkRunnable2Kt$getTopCpuData$1.label;
                    map = null;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            a aVar4 = (a) frontWorkRunnable2Kt$getTopCpuData$1.L$2;
                            bVar = (com.tencent.mobileqq.power.cpu.proc.b) frontWorkRunnable2Kt$getTopCpuData$1.L$1;
                            com.tencent.mobileqq.power.a aVar5 = (com.tencent.mobileqq.power.a) frontWorkRunnable2Kt$getTopCpuData$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                aVar2 = aVar4;
                                aVar3 = aVar5;
                            } catch (Exception e16) {
                                e = e16;
                                aVar3 = aVar5;
                                StackTraceElement[] stackTrace = e.getStackTrace();
                                Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
                                joinToString$default = ArraysKt___ArraysKt.joinToString$default(stackTrace, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                                com.tencent.mobileqq.perf.log.a.d("HP_CPU", "getTopCpuData error: " + e + "," + joinToString$default);
                                com.tencent.mobileqq.perf.log.a.c("HP_CPU", "getTopCpuData finally");
                                bVar.a(aVar3, map);
                                return Unit.INSTANCE;
                            } catch (Throwable th5) {
                                th = th5;
                                aVar3 = aVar5;
                                com.tencent.mobileqq.perf.log.a.c("HP_CPU", "getTopCpuData finally");
                                bVar.a(aVar3, map);
                                throw th;
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        if (aVar3 == null) {
                            com.tencent.mobileqq.perf.log.a.d("HP_CPU", "getTopCpuData callback null");
                            return Unit.INSTANCE;
                        }
                        com.tencent.mobileqq.power.cpu.proc.b bVar2 = new com.tencent.mobileqq.power.cpu.proc.b();
                        try {
                            com.tencent.mobileqq.perf.log.a.c("HP_CPU", "getTopCpuData start");
                            aVar2 = new a(System.currentTimeMillis(), null, 2, null);
                            bVar2.f();
                            Long b16 = aVar.b();
                            Intrinsics.checkNotNullExpressionValue(b16, "callback.intervals");
                            long longValue = b16.longValue();
                            frontWorkRunnable2Kt$getTopCpuData$1.L$0 = aVar3;
                            frontWorkRunnable2Kt$getTopCpuData$1.L$1 = bVar2;
                            frontWorkRunnable2Kt$getTopCpuData$1.L$2 = aVar2;
                            frontWorkRunnable2Kt$getTopCpuData$1.label = 1;
                            if (DelayKt.delay(longValue, frontWorkRunnable2Kt$getTopCpuData$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            bVar = bVar2;
                        } catch (Exception e17) {
                            e = e17;
                            bVar = bVar2;
                            StackTraceElement[] stackTrace2 = e.getStackTrace();
                            Intrinsics.checkNotNullExpressionValue(stackTrace2, "e.stackTrace");
                            joinToString$default = ArraysKt___ArraysKt.joinToString$default(stackTrace2, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                            com.tencent.mobileqq.perf.log.a.d("HP_CPU", "getTopCpuData error: " + e + "," + joinToString$default);
                            com.tencent.mobileqq.perf.log.a.c("HP_CPU", "getTopCpuData finally");
                            bVar.a(aVar3, map);
                            return Unit.INSTANCE;
                        } catch (Throwable th6) {
                            th = th6;
                            bVar = bVar2;
                            com.tencent.mobileqq.perf.log.a.c("HP_CPU", "getTopCpuData finally");
                            bVar.a(aVar3, map);
                            throw th;
                        }
                    }
                    aVar2.b(System.currentTimeMillis());
                    map = bVar.f();
                    a.Companion companion = a.INSTANCE;
                    companion.b(aVar2);
                    companion.a(aVar2, map);
                    com.tencent.mobileqq.perf.log.a.c("HP_CPU", "getTopCpuData finish");
                    com.tencent.mobileqq.perf.log.a.c("HP_CPU", "getTopCpuData finally");
                    bVar.a(aVar3, map);
                    return Unit.INSTANCE;
                }
            }
            aVar2.b(System.currentTimeMillis());
            map = bVar.f();
            a.Companion companion2 = a.INSTANCE;
            companion2.b(aVar2);
            companion2.a(aVar2, map);
            com.tencent.mobileqq.perf.log.a.c("HP_CPU", "getTopCpuData finish");
            com.tencent.mobileqq.perf.log.a.c("HP_CPU", "getTopCpuData finally");
            bVar.a(aVar3, map);
            return Unit.INSTANCE;
        } catch (Throwable th7) {
            th = th7;
            com.tencent.mobileqq.perf.log.a.c("HP_CPU", "getTopCpuData finally");
            bVar.a(aVar3, map);
            throw th;
        }
        frontWorkRunnable2Kt$getTopCpuData$1 = new FrontWorkRunnable2Kt$getTopCpuData$1(continuation);
        Object obj2 = frontWorkRunnable2Kt$getTopCpuData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = frontWorkRunnable2Kt$getTopCpuData$1.label;
        map = null;
        if (i3 == 0) {
        }
    }
}
