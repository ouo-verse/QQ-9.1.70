package com.tencent.mobileqq.guild.base.extension;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.base.extension.FlowKt$withIdleTimeout$2$1$detectJob$1", f = "Flow.kt", i = {0, 1}, l = {77, 79}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: classes12.dex */
final class FlowKt$withIdleTimeout$2$1$detectJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $lastEmissionTime;
    final /* synthetic */ long $timeoutMillis;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.base.extension.FlowKt$withIdleTimeout$2$1$detectJob$1$2", f = "Flow.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.base.extension.FlowKt$withIdleTimeout$2$1$detectJob$1$2, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(10L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt$withIdleTimeout$2$1$detectJob$1(Ref.LongRef longRef, long j3, Continuation<? super FlowKt$withIdleTimeout$2$1$detectJob$1> continuation) {
        super(2, continuation);
        this.$lastEmissionTime = longRef;
        this.$timeoutMillis = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt$withIdleTimeout$2$1$detectJob$1 flowKt$withIdleTimeout$2$1$detectJob$1 = new FlowKt$withIdleTimeout$2$1$detectJob$1(this.$lastEmissionTime, this.$timeoutMillis, continuation);
        flowKt$withIdleTimeout$2$1$detectJob$1.L$0 = obj;
        return flowKt$withIdleTimeout$2$1$detectJob$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00a0 -> B:7:0x0031). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        FlowKt$withIdleTimeout$2$1$detectJob$1 flowKt$withIdleTimeout$2$1$detectJob$1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowKt$withIdleTimeout$2$1$detectJob$1 = this;
                flowKt$withIdleTimeout$2$1$detectJob$1.L$0 = coroutineScope;
                flowKt$withIdleTimeout$2$1$detectJob$1.label = 2;
                if (DelayKt.delay(100L, flowKt$withIdleTimeout$2$1$detectJob$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    long currentTimeMillis = System.currentTimeMillis() - flowKt$withIdleTimeout$2$1$detectJob$1.$lastEmissionTime.element;
                    if (currentTimeMillis > flowKt$withIdleTimeout$2$1$detectJob$1.$timeoutMillis) {
                        Logger logger = Logger.f235387a;
                        if (QLog.isColorLevel()) {
                            logger.d().d("FlowEx", 1, "timeout " + currentTimeMillis + " [" + coroutineScope.getCoroutineContext().get(CoroutineName.INSTANCE) + "]");
                        }
                        AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
                        flowKt$withIdleTimeout$2$1$detectJob$1.L$0 = coroutineScope;
                        flowKt$withIdleTimeout$2$1$detectJob$1.label = 1;
                        if (TimeoutKt.withTimeout(0L, anonymousClass2, flowKt$withIdleTimeout$2$1$detectJob$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    flowKt$withIdleTimeout$2$1$detectJob$1.L$0 = coroutineScope;
                    flowKt$withIdleTimeout$2$1$detectJob$1.label = 2;
                    if (DelayKt.delay(100L, flowKt$withIdleTimeout$2$1$detectJob$1) == coroutine_suspended) {
                    }
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        return Unit.INSTANCE;
                    }
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        }
        flowKt$withIdleTimeout$2$1$detectJob$1 = this;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt$withIdleTimeout$2$1$detectJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
