package com.tencent.mobileqq.springhb.interactive.helper;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.entry.model.DragonCardConfigData;
import com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord;
import com.tencent.mobileqq.springhb.interactive.api.b;
import com.tencent.qqnt.msg.d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@\u00a8\u0006\u0004"}, d2 = {"T", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/FlowCollector;", "", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.springhb.interactive.helper.GuildInteractiveAnimationHelper$transformInteractive$$inlined$transform$1", f = "GuildInteractiveAnimationHelper.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class GuildInteractiveAnimationHelper$transformInteractive$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super InteractiveRecord>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildInteractiveAnimationHelper this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements FlowCollector<Pair<? extends d, ? extends DragonCardConfigData>> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FlowCollector f289261d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildInteractiveAnimationHelper f289262e;

        public a(FlowCollector flowCollector, GuildInteractiveAnimationHelper guildInteractiveAnimationHelper) {
            this.f289262e = guildInteractiveAnimationHelper;
            this.f289261d = flowCollector;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) flowCollector, (Object) guildInteractiveAnimationHelper);
            }
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Pair<? extends d, ? extends DragonCardConfigData> pair, @NotNull Continuation continuation) {
            b bVar;
            Object coroutine_suspended;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) pair, (Object) continuation);
            }
            FlowCollector flowCollector = this.f289261d;
            Pair<? extends d, ? extends DragonCardConfigData> pair2 = pair;
            bVar = this.f289262e.provider;
            InteractiveRecord a16 = bVar.a(pair2.getFirst());
            a16.u(pair2.getSecond());
            Object emit = flowCollector.emit(a16, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (emit == coroutine_suspended) {
                return emit;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInteractiveAnimationHelper$transformInteractive$$inlined$transform$1(Flow flow, Continuation continuation, GuildInteractiveAnimationHelper guildInteractiveAnimationHelper) {
        super(2, continuation);
        this.$this_transform = flow;
        this.this$0 = guildInteractiveAnimationHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, flow, continuation, guildInteractiveAnimationHelper);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        GuildInteractiveAnimationHelper$transformInteractive$$inlined$transform$1 guildInteractiveAnimationHelper$transformInteractive$$inlined$transform$1 = new GuildInteractiveAnimationHelper$transformInteractive$$inlined$transform$1(this.$this_transform, continuation, this.this$0);
        guildInteractiveAnimationHelper$transformInteractive$$inlined$transform$1.L$0 = obj;
        return guildInteractiveAnimationHelper$transformInteractive$$inlined$transform$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Flow flow = this.$this_transform;
                a aVar = new a(flowCollector, this.this$0);
                this.label = 1;
                if (flow.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super InteractiveRecord> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((GuildInteractiveAnimationHelper$transformInteractive$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) flowCollector, (Object) continuation);
    }
}
