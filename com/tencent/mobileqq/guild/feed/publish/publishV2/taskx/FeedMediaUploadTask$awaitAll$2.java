package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/h;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$awaitAll$2", f = "FeedMediaUploadTask.kt", i = {}, l = {397}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedMediaUploadTask$awaitAll$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
    final /* synthetic */ boolean $retryIfFailNow;
    int label;
    final /* synthetic */ FeedMediaUploadTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/h;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$awaitAll$2$1", f = "FeedMediaUploadTask.kt", i = {}, l = {972}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$awaitAll$2$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
        final /* synthetic */ int $seq;
        int I$0;
        Object L$0;
        int label;
        final /* synthetic */ FeedMediaUploadTask this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FeedMediaUploadTask feedMediaUploadTask, int i3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = feedMediaUploadTask;
            this.$seq = i3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$seq, continuation);
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
                FeedMediaUploadTask feedMediaUploadTask = this.this$0;
                int i16 = this.$seq;
                this.L$0 = feedMediaUploadTask;
                this.I$0 = i16;
                this.label = 1;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                cancellableContinuationImpl.initCancellability();
                feedMediaUploadTask.awaitContinuation = cancellableContinuationImpl;
                feedMediaUploadTask.K(i16, null);
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
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super h> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedMediaUploadTask$awaitAll$2(FeedMediaUploadTask feedMediaUploadTask, boolean z16, Continuation<? super FeedMediaUploadTask$awaitAll$2> continuation) {
        super(2, continuation);
        this.this$0 = feedMediaUploadTask;
        this.$retryIfFailNow = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedMediaUploadTask$awaitAll$2(this.this$0, this.$retryIfFailNow, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e5, code lost:
    
        if (r5 != false) goto L36;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred deferred;
        h hVar;
        Set O;
        Boolean bool;
        Set O2;
        Deferred deferred2;
        CoroutineScope R;
        boolean z16;
        Map emptyMap;
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
            deferred = this.this$0.deferredResult;
            if (deferred != null) {
                hVar = this.this$0.P(deferred);
            } else {
                hVar = null;
            }
            int andIncrement = this.this$0.opSeq.getAndIncrement();
            String str = this.this$0.logTag;
            String Q = this.this$0.Q();
            boolean z17 = this.$retryIfFailNow;
            O = this.this$0.O();
            int size = O.size();
            if (deferred != null) {
                bool = Boxing.boxBoolean(deferred.isActive());
            } else {
                bool = null;
            }
            QLog.i(str, 1, "[awaitAll](" + andIncrement + "): parentId=" + Q + ", retryIfFailNow=" + z17 + ", mediaIds.size=" + size + ", deferred.isActive=" + bool + ", uploadResult=" + hVar);
            O2 = this.this$0.O();
            if (O2.isEmpty()) {
                emptyMap = MapsKt__MapsKt.emptyMap();
                return new h(0, "", emptyMap, 0, null, 16, null);
            }
            boolean z18 = false;
            if (this.$retryIfFailNow) {
                if (hVar != null && !hVar.g()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.this$0.L();
                }
            }
            deferred2 = this.this$0.deferredResult;
            if (deferred2 != null) {
                if (hVar != null && !hVar.g()) {
                    z18 = true;
                }
            }
            this.this$0.c0();
            this.this$0.f0(andIncrement, true);
            if (deferred2 == null) {
                R = this.this$0.R();
                deferred2 = BuildersKt__Builders_commonKt.async$default(R, null, CoroutineStart.LAZY, new AnonymousClass1(this.this$0, andIncrement, null), 1, null);
                this.this$0.deferredResult = deferred2;
            }
            this.label = 1;
            obj = deferred2.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super h> continuation) {
        return ((FeedMediaUploadTask$awaitAll$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
