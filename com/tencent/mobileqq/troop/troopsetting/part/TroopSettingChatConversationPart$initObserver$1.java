package com.tencent.mobileqq.troop.troopsetting.part;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.troop.troopsetting.event.a;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopsetting.part.TroopSettingChatConversationPart$initObserver$1", f = "TroopSettingChatConversationPart.kt", i = {}, l = {PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopSettingChatConversationPart$initObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ TroopSettingChatConversationPart this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements FlowCollector<com.tencent.mobileqq.troop.troopsetting.event.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TroopSettingChatConversationPart f301260d;

        public a(TroopSettingChatConversationPart troopSettingChatConversationPart) {
            this.f301260d = troopSettingChatConversationPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSettingChatConversationPart);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
        
            r5 = r3.f301260d.notificationConfigItem;
         */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object emit(com.tencent.mobileqq.troop.troopsetting.event.a aVar, @NotNull Continuation<? super Unit> continuation) {
            com.tencent.mobileqq.troop.troopsetting.bizconfig.n nVar;
            com.tencent.mobileqq.troop.troopsetting.bizconfig.k kVar;
            com.tencent.mobileqq.widget.listitem.x xVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) continuation);
            }
            com.tencent.mobileqq.troop.troopsetting.event.a aVar2 = aVar;
            if (aVar2 instanceof a.z) {
                this.f301260d.Da(((a.z) aVar2).a());
            } else if (aVar2 instanceof a.ag) {
                this.f301260d.Ea(((a.ag) aVar2).a());
            } else if (aVar2 instanceof a.ac) {
                this.f301260d.ba();
            } else if (aVar2 instanceof a.q) {
                TroopSettingChatConversationPart troopSettingChatConversationPart = this.f301260d;
                xVar = troopSettingChatConversationPart.msgShieldConfig;
                if (xVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("msgShieldConfig");
                    xVar = null;
                }
                troopSettingChatConversationPart.E9(xVar, ((a.q) aVar2).a());
            } else if (aVar2 instanceof a.i) {
                kVar = this.f301260d.hindChatConfigItem;
                if (kVar != null) {
                    kVar.e0();
                }
            } else if ((aVar2 instanceof a.p) && nVar != null) {
                this.f301260d.E9(nVar, ((a.p) aVar2).a());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSettingChatConversationPart$initObserver$1(TroopSettingChatConversationPart troopSettingChatConversationPart, Continuation<? super TroopSettingChatConversationPart$initObserver$1> continuation) {
        super(2, continuation);
        this.this$0 = troopSettingChatConversationPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSettingChatConversationPart, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopSettingChatConversationPart$initObserver$1(this.this$0, continuation);
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
                StateFlow<com.tencent.mobileqq.troop.troopsetting.event.a> V2 = this.this$0.B9().V2();
                a aVar = new a(this.this$0);
                this.label = 1;
                if (V2.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopSettingChatConversationPart$initObserver$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
