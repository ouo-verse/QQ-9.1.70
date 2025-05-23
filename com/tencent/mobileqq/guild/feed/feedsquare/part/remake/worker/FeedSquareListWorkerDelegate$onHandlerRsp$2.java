package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPreloadGuildFeedsRsp;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareListWorkerDelegate$onHandlerRsp$2", f = "FeedSquareListWorkerDelegate.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedSquareListWorkerDelegate$onHandlerRsp$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GProPreloadGuildFeedsRsp $rsp;
    int label;
    final /* synthetic */ FeedSquareListWorkerDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareListWorkerDelegate$onHandlerRsp$2$1", f = "FeedSquareListWorkerDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareListWorkerDelegate$onHandlerRsp$2$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<ij1.g> $validBlockDataList;
        int label;
        final /* synthetic */ FeedSquareListWorkerDelegate this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FeedSquareListWorkerDelegate feedSquareListWorkerDelegate, ArrayList<ij1.g> arrayList, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = feedSquareListWorkerDelegate;
            this.$validBlockDataList = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$validBlockDataList, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FeedSquareListWorkerDelegate feedSquareListWorkerDelegate = this.this$0;
                ArrayList<ij1.g> validBlockDataList = this.$validBlockDataList;
                Intrinsics.checkNotNullExpressionValue(validBlockDataList, "validBlockDataList");
                feedSquareListWorkerDelegate.P(validBlockDataList);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedSquareListWorkerDelegate$onHandlerRsp$2(GProPreloadGuildFeedsRsp gProPreloadGuildFeedsRsp, FeedSquareListWorkerDelegate feedSquareListWorkerDelegate, Continuation<? super FeedSquareListWorkerDelegate$onHandlerRsp$2> continuation) {
        super(2, continuation);
        this.$rsp = gProPreloadGuildFeedsRsp;
        this.this$0 = feedSquareListWorkerDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedSquareListWorkerDelegate$onHandlerRsp$2(this.$rsp, this.this$0, continuation);
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
            ArrayList<ij1.g> c16 = ij1.c.c(this.$rsp.stfeedList, "");
            i.e eVar = i.e.f261783e;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, c16, null);
            this.label = 1;
            obj = CorountineFunKt.i(eVar, "FeedSquareListAdapterWorker.onHandlerRsp", null, anonymousClass1, this, 4, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedSquareListWorkerDelegate$onHandlerRsp$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
