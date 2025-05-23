package com.tencent.mobileqq.springhb.interactive.helper;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@\u00a8\u0006\u0004"}, d2 = {"T", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/FlowCollector;", "", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.springhb.interactive.helper.GuildInteractiveAnimationHelper$matchKeyWordAnimation$$inlined$transform$1", f = "GuildInteractiveAnimationHelper.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class GuildInteractiveAnimationHelper$matchKeyWordAnimation$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super InteractiveRecord>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.springhb.interactive.helper.GuildInteractiveAnimationHelper$matchKeyWordAnimation$$inlined$transform$1$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    public static final class AnonymousClass1 implements FlowCollector<InteractiveRecord> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FlowCollector f289258d;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.tencent.mobileqq.springhb.interactive.helper.GuildInteractiveAnimationHelper$matchKeyWordAnimation$$inlined$transform$1$1", f = "GuildInteractiveAnimationHelper.kt", i = {0}, l = {136, 137}, m = "emit", n = {"$this$matchKeyWordAnimation_u24lambda_u2412"}, s = {"L$0"})
        /* renamed from: com.tencent.mobileqq.springhb.interactive.helper.GuildInteractiveAnimationHelper$matchKeyWordAnimation$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes18.dex */
        public static final class C86061 extends ContinuationImpl {
            static IPatchRedirector $redirector_;
            Object L$0;
            int label;
            /* synthetic */ Object result;

            public C86061(Continuation continuation) {
                super(continuation);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) continuation);
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                }
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector) {
            this.f289258d = flowCollector;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) flowCollector);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object emit(InteractiveRecord interactiveRecord, @NotNull Continuation continuation) {
            C86061 c86061;
            Object coroutine_suspended;
            int i3;
            FlowCollector flowCollector;
            InteractiveRecord interactiveRecord2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) interactiveRecord, (Object) continuation);
            }
            if (continuation instanceof C86061) {
                c86061 = (C86061) continuation;
                int i16 = c86061.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    c86061.label = i16 - Integer.MIN_VALUE;
                    Object obj = c86061.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = c86061.label;
                    if (i3 == 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        flowCollector = (FlowCollector) c86061.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        FlowCollector flowCollector2 = this.f289258d;
                        c86061.L$0 = flowCollector2;
                        c86061.label = 1;
                        Object s16 = interactiveRecord.s(c86061);
                        if (s16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = s16;
                        flowCollector = flowCollector2;
                    }
                    interactiveRecord2 = (InteractiveRecord) obj;
                    if (interactiveRecord2 != null) {
                        c86061.L$0 = null;
                        c86061.label = 2;
                        if (flowCollector.emit(interactiveRecord2, c86061) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            c86061 = new C86061(continuation);
            Object obj2 = c86061.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = c86061.label;
            if (i3 == 0) {
            }
            interactiveRecord2 = (InteractiveRecord) obj2;
            if (interactiveRecord2 != null) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInteractiveAnimationHelper$matchKeyWordAnimation$$inlined$transform$1(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.$this_transform = flow;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) flow, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        GuildInteractiveAnimationHelper$matchKeyWordAnimation$$inlined$transform$1 guildInteractiveAnimationHelper$matchKeyWordAnimation$$inlined$transform$1 = new GuildInteractiveAnimationHelper$matchKeyWordAnimation$$inlined$transform$1(this.$this_transform, continuation);
        guildInteractiveAnimationHelper$matchKeyWordAnimation$$inlined$transform$1.L$0 = obj;
        return guildInteractiveAnimationHelper$matchKeyWordAnimation$$inlined$transform$1;
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
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowCollector);
                this.label = 1;
                if (flow.collect(anonymousClass1, this) == coroutine_suspended) {
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((GuildInteractiveAnimationHelper$matchKeyWordAnimation$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) flowCollector, (Object) continuation);
    }
}
