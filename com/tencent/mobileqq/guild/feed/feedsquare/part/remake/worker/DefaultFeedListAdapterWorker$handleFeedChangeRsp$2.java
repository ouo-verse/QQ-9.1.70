package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListAdapterWorker$handleFeedChangeRsp$2", f = "DefaultFeedListAdapterWorker.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class DefaultFeedListAdapterWorker$handleFeedChangeRsp$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DefaultFeedListAdapterWorker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultFeedListAdapterWorker$handleFeedChangeRsp$2(DefaultFeedListAdapterWorker defaultFeedListAdapterWorker, Continuation<? super DefaultFeedListAdapterWorker$handleFeedChangeRsp$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultFeedListAdapterWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultFeedListAdapterWorker$handleFeedChangeRsp$2(this.this$0, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0088, code lost:
    
        r0 = r5.this$0.observeFeedDataAction;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        String str2;
        boolean z16;
        boolean z17;
        Function1 function1;
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
            Logger logger = Logger.f235387a;
            str = this.this$0.logTag;
            logger.d().i(str, 1, "handleFeedChangeRsp lockUpdateList");
            this.label = 1;
            if (DelayKt.delay(450L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Logger logger2 = Logger.f235387a;
        str2 = this.this$0.logTag;
        DefaultFeedListAdapterWorker defaultFeedListAdapterWorker = this.this$0;
        Logger.a d16 = logger2.d();
        z16 = defaultFeedListAdapterWorker.updateListWhenUnLock;
        d16.i(str2, 1, "handleFeedChangeRsp unLockUpdateList updateListWhenUnLock:" + z16);
        this.this$0.lockUpdateList = false;
        z17 = this.this$0.updateListWhenUnLock;
        if (z17) {
            this.this$0.updateListWhenUnLock = false;
            UIStateData<List<ij1.g>> value = this.this$0.d().getVmApi().j().getValue();
            if (value != null && function1 != null) {
                function1.invoke(value);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultFeedListAdapterWorker$handleFeedChangeRsp$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
