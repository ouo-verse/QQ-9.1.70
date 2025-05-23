package com.tencent.mobileqq.zplan.utils;

import com.tencent.mobileqq.zplan.utils.w;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Add missing generic type declarations: [A, B] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u001b\u0010\u0003\u001a\u00028\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/zplan/utils/SknNetworkUtilKt$retryIfFailed$1", "Lcom/tencent/mobileqq/zplan/utils/o;", "req", "a", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SknNetworkUtilKt$retryIfFailed$1<A, B> implements o<A, B> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f335731a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ o<A, B> f335732b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f335733c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SknNetworkUtilKt$retryIfFailed$1(int i3, o<? super A, ? extends B> oVar, long j3) {
        this.f335731a = i3;
        this.f335732b = oVar;
        this.f335733c = j3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0082 -> B:11:0x0033). Please report as a decompilation issue!!! */
    @Override // com.tencent.mobileqq.zplan.utils.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(A a16, Continuation<? super B> continuation) {
        SknNetworkUtilKt$retryIfFailed$1$invoke$1 sknNetworkUtilKt$retryIfFailed$1$invoke$1;
        Object coroutine_suspended;
        int i3;
        SknNetworkUtilKt$retryIfFailed$1<A, B> sknNetworkUtilKt$retryIfFailed$1;
        A a17;
        int i16;
        Object obj;
        long j3;
        w wVar;
        A a18;
        if (continuation instanceof SknNetworkUtilKt$retryIfFailed$1$invoke$1) {
            sknNetworkUtilKt$retryIfFailed$1$invoke$1 = (SknNetworkUtilKt$retryIfFailed$1$invoke$1) continuation;
            int i17 = sknNetworkUtilKt$retryIfFailed$1$invoke$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                sknNetworkUtilKt$retryIfFailed$1$invoke$1.label = i17 - Integer.MIN_VALUE;
                Object obj2 = sknNetworkUtilKt$retryIfFailed$1$invoke$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = sknNetworkUtilKt$retryIfFailed$1$invoke$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    sknNetworkUtilKt$retryIfFailed$1 = this;
                    a17 = a16;
                    i16 = 0;
                    if (i16 >= sknNetworkUtilKt$retryIfFailed$1.f335731a) {
                    }
                } else if (i3 == 1) {
                    i16 = sknNetworkUtilKt$retryIfFailed$1$invoke$1.I$0;
                    obj = sknNetworkUtilKt$retryIfFailed$1$invoke$1.L$1;
                    sknNetworkUtilKt$retryIfFailed$1 = (SknNetworkUtilKt$retryIfFailed$1) sknNetworkUtilKt$retryIfFailed$1$invoke$1.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure(obj2);
                            obj = obj;
                        } catch (CancellationException e16) {
                            throw e16;
                        }
                    } catch (Throwable unused) {
                    }
                    wVar = (w) obj2;
                    if (wVar instanceof w.a) {
                    }
                    j3 = sknNetworkUtilKt$retryIfFailed$1.f335733c;
                    sknNetworkUtilKt$retryIfFailed$1$invoke$1.L$0 = sknNetworkUtilKt$retryIfFailed$1;
                    sknNetworkUtilKt$retryIfFailed$1$invoke$1.L$1 = obj;
                    sknNetworkUtilKt$retryIfFailed$1$invoke$1.I$0 = i16;
                    sknNetworkUtilKt$retryIfFailed$1$invoke$1.label = 2;
                    a18 = obj;
                    if (DelayKt.delay(j3, sknNetworkUtilKt$retryIfFailed$1$invoke$1) == coroutine_suspended) {
                    }
                    a17 = a18;
                    i16++;
                    if (i16 >= sknNetworkUtilKt$retryIfFailed$1.f335731a) {
                    }
                } else if (i3 == 2) {
                    i16 = sknNetworkUtilKt$retryIfFailed$1$invoke$1.I$0;
                    Object obj3 = sknNetworkUtilKt$retryIfFailed$1$invoke$1.L$1;
                    sknNetworkUtilKt$retryIfFailed$1 = (SknNetworkUtilKt$retryIfFailed$1) sknNetworkUtilKt$retryIfFailed$1$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    a18 = obj3;
                    a17 = a18;
                    i16++;
                    if (i16 >= sknNetworkUtilKt$retryIfFailed$1.f335731a) {
                        try {
                        } catch (Throwable unused2) {
                            obj = a17;
                        }
                        o<A, B> oVar = sknNetworkUtilKt$retryIfFailed$1.f335732b;
                        sknNetworkUtilKt$retryIfFailed$1$invoke$1.L$0 = sknNetworkUtilKt$retryIfFailed$1;
                        sknNetworkUtilKt$retryIfFailed$1$invoke$1.L$1 = a17;
                        sknNetworkUtilKt$retryIfFailed$1$invoke$1.I$0 = i16;
                        sknNetworkUtilKt$retryIfFailed$1$invoke$1.label = 1;
                        Object a19 = oVar.a(a17, sknNetworkUtilKt$retryIfFailed$1$invoke$1);
                        if (a19 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = a17;
                        obj2 = a19;
                        wVar = (w) obj2;
                        if (wVar instanceof w.a) {
                            return wVar;
                        }
                        j3 = sknNetworkUtilKt$retryIfFailed$1.f335733c;
                        sknNetworkUtilKt$retryIfFailed$1$invoke$1.L$0 = sknNetworkUtilKt$retryIfFailed$1;
                        sknNetworkUtilKt$retryIfFailed$1$invoke$1.L$1 = obj;
                        sknNetworkUtilKt$retryIfFailed$1$invoke$1.I$0 = i16;
                        sknNetworkUtilKt$retryIfFailed$1$invoke$1.label = 2;
                        a18 = obj;
                        if (DelayKt.delay(j3, sknNetworkUtilKt$retryIfFailed$1$invoke$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        a17 = a18;
                        i16++;
                        if (i16 >= sknNetworkUtilKt$retryIfFailed$1.f335731a) {
                            throw new TimeoutException("\u91cd\u8bd5\u6b21\u6570\u5230\u8fbe\u4e0a\u9650 " + sknNetworkUtilKt$retryIfFailed$1.f335731a + " \u6b21");
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        sknNetworkUtilKt$retryIfFailed$1$invoke$1 = new SknNetworkUtilKt$retryIfFailed$1$invoke$1(this, continuation);
        Object obj22 = sknNetworkUtilKt$retryIfFailed$1$invoke$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = sknNetworkUtilKt$retryIfFailed$1$invoke$1.label;
        if (i3 != 0) {
        }
    }
}
