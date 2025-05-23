package com.tencent.mobileqq.zplan.nameplate;

import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.vas.update.entity.UpdateListenerParams;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/nameplate/f;", "", "id", "Lkotlin/Pair;", "", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "a", "(Lcom/tencent/mobileqq/zplan/nameplate/f;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/nameplate/g$a", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadSuccess", "onLoadFail", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Pair<Boolean, ? extends UpdateListenerParams>> f334858a;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super Pair<Boolean, ? extends UpdateListenerParams>> cancellableContinuation) {
            this.f334858a = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            CancellableContinuation<Pair<Boolean, ? extends UpdateListenerParams>> cancellableContinuation = this.f334858a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(TuplesKt.to(Boolean.FALSE, params)));
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            CancellableContinuation<Pair<Boolean, ? extends UpdateListenerParams>> cancellableContinuation = this.f334858a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(TuplesKt.to(Boolean.TRUE, params)));
        }
    }

    public static final Object a(f fVar, int i3, Continuation<? super Pair<Boolean, ? extends UpdateListenerParams>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        fVar.addDownLoadListener(i3, new a(cancellableContinuationImpl));
        fVar.startDownload(i3);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
