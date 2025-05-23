package com.tencent.mobileqq.qqguildsdk.manager;

import com.tencent.mobileqq.qqguildsdk.data.GProAbstractUpdateData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/qqguildsdk/data/t;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqguildsdk.manager.GuildMsgServiceMgr$registerMsgAbstractUpdateFlow$1", f = "GuildMsgServiceMgr.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
final class GuildMsgServiceMgr$registerMsgAbstractUpdateFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super GProAbstractUpdateData>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildMsgServiceMgr$registerMsgAbstractUpdateFlow$1(Continuation<? super GuildMsgServiceMgr$registerMsgAbstractUpdateFlow$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildMsgServiceMgr$registerMsgAbstractUpdateFlow$1 guildMsgServiceMgr$registerMsgAbstractUpdateFlow$1 = new GuildMsgServiceMgr$registerMsgAbstractUpdateFlow$1(continuation);
        guildMsgServiceMgr$registerMsgAbstractUpdateFlow$1.L$0 = obj;
        return guildMsgServiceMgr$registerMsgAbstractUpdateFlow$1;
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
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final Function1<GProAbstractUpdateData, Unit> function1 = new Function1<GProAbstractUpdateData, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.manager.GuildMsgServiceMgr$registerMsgAbstractUpdateFlow$1$listener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GProAbstractUpdateData gProAbstractUpdateData) {
                    invoke2(gProAbstractUpdateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable GProAbstractUpdateData gProAbstractUpdateData) {
                    producerScope.mo2003trySendJP2dKIU(gProAbstractUpdateData);
                }
            };
            GuildMsgServiceMgr.f268418a.b().put(Boxing.boxInt(function1.hashCode()), function1);
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.manager.GuildMsgServiceMgr$registerMsgAbstractUpdateFlow$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    GuildMsgServiceMgr.f268418a.b().remove(Integer.valueOf(function1.hashCode()));
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
    public final Object invoke(@NotNull ProducerScope<? super GProAbstractUpdateData> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMsgServiceMgr$registerMsgAbstractUpdateFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
