package com.tencent.mobileqq.zplan.meme.api.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.meme.api.impl.MemeHelper$recordSingleActionByResourceCenterWithTimeout$1", f = "MemeHelperImpl.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class MemeHelper$recordSingleActionByResourceCenterWithTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ZPlanRecordResource, Unit> $callback;
    final /* synthetic */ SingleRecordRequestParams $params;
    final /* synthetic */ long $timeout;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.meme.api.impl.MemeHelper$recordSingleActionByResourceCenterWithTimeout$1$1", f = "MemeHelperImpl.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.meme.api.impl.MemeHelper$recordSingleActionByResourceCenterWithTimeout$1$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ZPlanRecordResource, Unit> $callback;
        final /* synthetic */ SingleRecordRequestParams $params;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(SingleRecordRequestParams singleRecordRequestParams, Function1<? super ZPlanRecordResource, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$params = singleRecordRequestParams;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$params, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            List<? extends Source> listOf;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
                SingleRecordRequestParams singleRecordRequestParams = this.$params;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Source[]{Source.LOCAL_CACHE, Source.LOCAL_RECORD});
                this.label = 1;
                obj = zPlanRecordResourceCenter.h(singleRecordRequestParams, listOf, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ZPlanRecordResource zPlanRecordResource = (ZPlanRecordResource) obj;
            QLog.i(MemeHelper.TAG, 1, "requestSingleRequestResource  requestSingleResourceImmediate done localPath:" + (zPlanRecordResource != null ? zPlanRecordResource.getLocalPath() : null));
            this.$callback.invoke(zPlanRecordResource);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MemeHelper$recordSingleActionByResourceCenterWithTimeout$1(long j3, Function1<? super ZPlanRecordResource, Unit> function1, SingleRecordRequestParams singleRecordRequestParams, Continuation<? super MemeHelper$recordSingleActionByResourceCenterWithTimeout$1> continuation) {
        super(2, continuation);
        this.$timeout = j3;
        this.$callback = function1;
        this.$params = singleRecordRequestParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemeHelper$recordSingleActionByResourceCenterWithTimeout$1(this.$timeout, this.$callback, this.$params, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                long j3 = this.$timeout;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$params, this.$callback, null);
                this.label = 1;
                if (TimeoutKt.withTimeout(j3, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (TimeoutCancellationException unused) {
            QLog.w(MemeHelper.TAG, 1, "requestSingleRequestResource  requestSingleResourceImmediate timeout");
            this.$callback.invoke(null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MemeHelper$recordSingleActionByResourceCenterWithTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
