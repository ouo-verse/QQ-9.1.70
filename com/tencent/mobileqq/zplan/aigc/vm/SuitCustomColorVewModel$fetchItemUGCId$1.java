package com.tencent.mobileqq.zplan.aigc.vm;

import com.tencent.mobileqq.zplan.servlet.p;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel$fetchItemUGCId$1", f = "SuitCustomColorVewModel.kt", i = {}, l = {368}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitCustomColorVewModel$fetchItemUGCId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, Long, Unit> $callback;
    final /* synthetic */ Long $itemId;
    int label;
    final /* synthetic */ SuitCustomColorVewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel$fetchItemUGCId$1$1", f = "SuitCustomColorVewModel.kt", i = {}, l = {370}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel$fetchItemUGCId$1$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Boolean, Long, Unit> $callback;
        final /* synthetic */ Long $itemId;
        int label;
        final /* synthetic */ SuitCustomColorVewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Long l3, SuitCustomColorVewModel suitCustomColorVewModel, Function2<? super Boolean, ? super Long, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$itemId = l3;
            this.this$0 = suitCustomColorVewModel;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$itemId, this.this$0, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                p pVar = p.f335428a;
                long longValue = this.$itemId.longValue();
                this.label = 1;
                obj = pVar.e(longValue, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u55.f fVar = (u55.f) obj;
            this.this$0.v3(fVar.f438458c);
            this.$callback.invoke(Boxing.boxBoolean(true), Boxing.boxLong(fVar.f438458c));
            QLog.d("SuitCustomColorVewModel", 2, "fetchSlotItemUGCId success");
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
    public SuitCustomColorVewModel$fetchItemUGCId$1(Function2<? super Boolean, ? super Long, Unit> function2, Long l3, SuitCustomColorVewModel suitCustomColorVewModel, Continuation<? super SuitCustomColorVewModel$fetchItemUGCId$1> continuation) {
        super(2, continuation);
        this.$callback = function2;
        this.$itemId = l3;
        this.this$0 = suitCustomColorVewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitCustomColorVewModel$fetchItemUGCId$1(this.$callback, this.$itemId, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$itemId, this.this$0, this.$callback, null);
                this.label = 1;
                if (TimeoutKt.withTimeoutOrNull(10000L, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (TimeoutCancellationException unused) {
            QLog.e("SuitCustomColorVewModel", 2, "fetchSlotItemUGCId timed out.");
            this.$callback.invoke(Boxing.boxBoolean(false), Boxing.boxLong(0L));
        } catch (Exception e16) {
            QLog.e("SuitCustomColorVewModel", 2, e16.toString());
            this.$callback.invoke(Boxing.boxBoolean(false), Boxing.boxLong(0L));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitCustomColorVewModel$fetchItemUGCId$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
