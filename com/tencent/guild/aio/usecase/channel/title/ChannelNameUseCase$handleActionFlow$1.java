package com.tencent.guild.aio.usecase.channel.title;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/guild/aio/usecase/channel/title/b;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.usecase.channel.title.ChannelNameUseCase$handleActionFlow$1", f = "ChannelNameUseCase.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ChannelNameUseCase$handleActionFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super ChannelNameMviResult>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $channelName;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelNameUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelNameUseCase$handleActionFlow$1(ChannelNameUseCase channelNameUseCase, Ref.ObjectRef<String> objectRef, Continuation<? super ChannelNameUseCase$handleActionFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = channelNameUseCase;
        this.$channelName = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelNameUseCase$handleActionFlow$1 channelNameUseCase$handleActionFlow$1 = new ChannelNameUseCase$handleActionFlow$1(this.this$0, this.$channelName, continuation);
        channelNameUseCase$handleActionFlow$1.L$0 = obj;
        return channelNameUseCase$handleActionFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            this.this$0.channelNameCB = new Function1<ChannelNameMviResult, Unit>() { // from class: com.tencent.guild.aio.usecase.channel.title.ChannelNameUseCase$handleActionFlow$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ChannelNameMviResult channelNameMviResult) {
                    invoke2(channelNameMviResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ChannelNameMviResult it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    try {
                        producerScope.mo2003trySendJP2dKIU(it);
                    } catch (ClosedSendChannelException e16) {
                        QLog.e("ChannelNameUseCase", 1, "channel name channel error = {" + e16.getMessage() + "}");
                    }
                }
            };
            function1 = this.this$0.channelNameCB;
            if (function1 != null) {
                function1.invoke(new ChannelNameMviResult(this.$channelName.element));
            }
            final ChannelNameUseCase channelNameUseCase = this.this$0;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.guild.aio.usecase.channel.title.ChannelNameUseCase$handleActionFlow$1.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ChannelNameUseCase.this.channelNameCB = null;
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super ChannelNameMviResult> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelNameUseCase$handleActionFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
