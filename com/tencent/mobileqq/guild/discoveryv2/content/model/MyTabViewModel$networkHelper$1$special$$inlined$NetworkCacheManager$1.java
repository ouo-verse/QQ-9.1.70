package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.guild.discoveryv2.content.model.MyTabViewModel$networkHelper$1;
import com.tencent.mobileqq.qqguildsdk.data.genc.br;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0003\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@"}, d2 = {"K", "V", "req", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.model.MyTabViewModel$networkHelper$1$special$$inlined$NetworkCacheManager$1", f = "MyTabViewModel.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class MyTabViewModel$networkHelper$1$special$$inlined$NetworkCacheManager$1 extends SuspendLambda implements Function2<br, Continuation<? super c>, Object> {
    final /* synthetic */ long $timeout;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MyTabViewModel this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.model.MyTabViewModel$networkHelper$1$special$$inlined$NetworkCacheManager$1$1", f = "MyTabViewModel.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.model.MyTabViewModel$networkHelper$1$special$$inlined$NetworkCacheManager$1$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super c>, Object> {
        final /* synthetic */ Object $req$inlined;
        Object L$0;
        int label;
        final /* synthetic */ MyTabViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Continuation continuation, Object obj, MyTabViewModel myTabViewModel) {
            super(2, continuation);
            this.$req$inlined = obj;
            this.this$0 = myTabViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation, this.$req$inlined, this.this$0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Continuation intercepted;
            Object coroutine_suspended2;
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
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                cancellableContinuationImpl.initCancellability();
                Object obj2 = this.$req$inlined;
                Function1<c, Unit> function1 = new Function1<c, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.model.MyTabViewModel$networkHelper$1$special$.inlined.NetworkCacheManager.1.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
                        m180invoke(cVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m180invoke(c cVar) {
                        Continuation.this.resumeWith(Result.m476constructorimpl(cVar));
                    }
                };
                this.this$0.U1().getMyTabContent((br) obj2, new MyTabViewModel$networkHelper$1.a(function1));
                obj = cancellableContinuationImpl.getResult();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj == coroutine_suspended2) {
                    DebugProbes.probeCoroutineSuspended(this);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super c> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyTabViewModel$networkHelper$1$special$$inlined$NetworkCacheManager$1(long j3, Continuation continuation, MyTabViewModel myTabViewModel) {
        super(2, continuation);
        this.$timeout = j3;
        this.this$0 = myTabViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MyTabViewModel$networkHelper$1$special$$inlined$NetworkCacheManager$1 myTabViewModel$networkHelper$1$special$$inlined$NetworkCacheManager$1 = new MyTabViewModel$networkHelper$1$special$$inlined$NetworkCacheManager$1(this.$timeout, continuation, this.this$0);
        myTabViewModel$networkHelper$1$special$$inlined$NetworkCacheManager$1.L$0 = obj;
        return myTabViewModel$networkHelper$1$special$$inlined$NetworkCacheManager$1;
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
            Object obj2 = this.L$0;
            long j3 = this.$timeout;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null, obj2, this.this$0);
            this.label = 1;
            obj = TimeoutKt.withTimeoutOrNull(j3, anonymousClass1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (obj == null) {
            ri1.a b16 = ri1.a.b(-1, "client wait timeout");
            Intrinsics.checkNotNullExpressionValue(b16, "error(-1, \"client wait timeout\")");
            return new c(b16, null, false, null, 14, null);
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(br brVar, @Nullable Continuation<? super c> continuation) {
        return ((MyTabViewModel$networkHelper$1$special$$inlined$NetworkCacheManager$1) create(brVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
