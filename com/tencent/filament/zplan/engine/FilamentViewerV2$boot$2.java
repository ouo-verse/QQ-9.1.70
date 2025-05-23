package com.tencent.filament.zplan.engine;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.engine.FilamentViewerV2$boot$2", f = "FilamentViewerV2.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FilamentViewerV2$boot$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ FilamentViewerV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentViewerV2$boot$2(FilamentViewerV2 filamentViewerV2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filamentViewerV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentViewerV2$boot$2(this.this$0, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilamentViewerV2$boot$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0039 -> B:5:0x003e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Channel channel;
        ChannelIterator it;
        FilamentViewerV2$boot$2 filamentViewerV2$boot$2;
        Object hasNext;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ChannelIterator channelIterator = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                ChannelIterator channelIterator2 = channelIterator;
                Object obj2 = coroutine_suspended;
                FilamentViewerV2$boot$2 filamentViewerV2$boot$22 = this;
                if (!((Boolean) obj).booleanValue()) {
                    ((Function0) channelIterator2.next()).invoke();
                    filamentViewerV2$boot$2 = filamentViewerV2$boot$22;
                    coroutine_suspended = obj2;
                    it = channelIterator2;
                    filamentViewerV2$boot$2.L$0 = it;
                    filamentViewerV2$boot$2.label = 1;
                    hasNext = it.hasNext(filamentViewerV2$boot$2);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj3 = coroutine_suspended;
                    filamentViewerV2$boot$22 = filamentViewerV2$boot$2;
                    obj = hasNext;
                    channelIterator2 = it;
                    obj2 = obj3;
                    if (!((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            channel = this.this$0.bootingOperations;
            it = channel.iterator();
            filamentViewerV2$boot$2 = this;
            filamentViewerV2$boot$2.L$0 = it;
            filamentViewerV2$boot$2.label = 1;
            hasNext = it.hasNext(filamentViewerV2$boot$2);
            if (hasNext != coroutine_suspended) {
            }
        }
    }
}
