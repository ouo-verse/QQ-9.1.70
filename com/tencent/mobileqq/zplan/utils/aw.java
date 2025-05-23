package com.tencent.mobileqq.zplan.utils;

import com.tencent.mobileqq.zplan.proxy.channel.request.ChannelBusinessObserver;
import com.tencent.mobileqq.zplan.proxy.channel.request.ChannelRequestHandler;
import com.tencent.mobileqq.zplan.utils.av;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/aw;", "Lcom/tencent/mobileqq/zplan/utils/o;", "Lcom/tencent/mobileqq/zplan/utils/au;", "Lcom/tencent/mobileqq/zplan/utils/av;", "Lcom/tencent/mobileqq/zplan/utils/IZPlanRequest;", "req", "b", "(Lcom/tencent/mobileqq/zplan/utils/au;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class aw implements o<ZPlanRequestReq, av> {

    /* renamed from: a, reason: collision with root package name */
    public static final aw f335800a = new aw();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/utils/aw$a", "Lcom/tencent/mobileqq/zplan/proxy/channel/request/ChannelBusinessObserver;", "", "ssoResultCode", "trpcRspFuncRetCode", "", "trpcRspErrorMsg", "", "rspData", "", "onResponse", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements ChannelBusinessObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<av> f335801a;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super av> cancellableContinuation) {
            this.f335801a = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.zplan.proxy.channel.request.ChannelBusinessObserver
        public void onResponse(int ssoResultCode, int trpcRspFuncRetCode, String trpcRspErrorMsg, Object rspData) {
            byte[] bArr;
            IntRange until;
            QLog.i("SknNetworkUtil", 1, "\u8bf7\u6c42\u5230\u7f51\u7edc\u6570\u636e, ssoResultCode:" + ssoResultCode + ", trpcRspFuncRetCode: " + trpcRspFuncRetCode + ", trpcRspErrorMsg: " + trpcRspErrorMsg);
            if (rspData instanceof byte[]) {
                byte[] bArr2 = (byte[]) rspData;
                if (bArr2.length > 4) {
                    until = RangesKt___RangesKt.until(4, bArr2.length);
                    bArr = ArraysKt___ArraysKt.sliceArray(bArr2, until);
                    CancellableContinuation<av> cancellableContinuation = this.f335801a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(new av.c(bArr, ssoResultCode, trpcRspFuncRetCode, trpcRspErrorMsg)));
                }
            }
            bArr = null;
            CancellableContinuation<av> cancellableContinuation2 = this.f335801a;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(new av.c(bArr, ssoResultCode, trpcRspFuncRetCode, trpcRspErrorMsg)));
        }
    }

    aw() {
    }

    @Override // com.tencent.mobileqq.zplan.utils.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Object a(ZPlanRequestReq zPlanRequestReq, Continuation<? super av> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        try {
            ChannelRequestHandler a16 = ChannelRequestHandler.INSTANCE.a();
            Intrinsics.checkNotNull(a16);
            a16.G2(zPlanRequestReq.getCmd(), zPlanRequestReq.getReqBytes(), new a(cancellableContinuationImpl));
        } catch (Throwable th5) {
            QLog.i("SknNetworkUtil", 1, "ZPlanRequestWithTrpcResult request exception, " + th5);
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
