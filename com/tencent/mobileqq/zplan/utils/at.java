package com.tencent.mobileqq.zplan.utils;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.zplan.utils.av;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/at;", "Lcom/tencent/mobileqq/zplan/utils/o;", "Lcom/tencent/mobileqq/zplan/utils/au;", "Lcom/tencent/mobileqq/zplan/utils/av;", "Lcom/tencent/mobileqq/zplan/utils/IZPlanRequest;", "req", "b", "(Lcom/tencent/mobileqq/zplan/utils/au;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class at implements o<ZPlanRequestReq, av> {

    /* renamed from: a, reason: collision with root package name */
    public static final at f335791a = new at();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "isSuccess", "", "data", "", "kotlin.jvm.PlatformType", "onUpdate"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<av> f335792d;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super av> cancellableContinuation) {
            this.f335792d = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public final void onUpdate(int i3, boolean z16, Object obj) {
            QLog.i("SknNetworkUtil", 1, "\u8bf7\u6c42\u5230\u7f51\u7edc\u6570\u636e, success:" + z16);
            CancellableContinuation<av> cancellableContinuation = this.f335792d;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(new av.c(obj, 0, 0, null, 14, null)));
        }
    }

    at() {
    }

    @Override // com.tencent.mobileqq.zplan.utils.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Object a(ZPlanRequestReq zPlanRequestReq, Continuation<? super av> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        Intrinsics.checkNotNull(a16);
        a16.request(zPlanRequestReq.getCmd(), zPlanRequestReq.getReqBytes(), new a(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
