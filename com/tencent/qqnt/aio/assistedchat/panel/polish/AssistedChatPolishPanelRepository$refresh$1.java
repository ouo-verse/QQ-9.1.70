package com.tencent.qqnt.aio.assistedchat.panel.polish;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/d;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelRepository$refresh$1", f = "AssistedChatPolishPanelRepository.kt", i = {0}, l = {51, 61}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes23.dex */
public final class AssistedChatPolishPanelRepository$refresh$1 extends SuspendLambda implements Function2<FlowCollector<? super com.tencent.qqnt.aio.assistedchat.panel.subpanel.d>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AssistedChatPolishPanelRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssistedChatPolishPanelRepository$refresh$1(AssistedChatPolishPanelRepository assistedChatPolishPanelRepository, Continuation<? super AssistedChatPolishPanelRepository$refresh$1> continuation) {
        super(2, continuation);
        this.this$0 = assistedChatPolishPanelRepository;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) assistedChatPolishPanelRepository, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AssistedChatPolishPanelRepository$refresh$1 assistedChatPolishPanelRepository$refresh$1 = new AssistedChatPolishPanelRepository$refresh$1(this.this$0, continuation);
        assistedChatPolishPanelRepository$refresh$1.L$0 = obj;
        return assistedChatPolishPanelRepository$refresh$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        String str;
        boolean z16;
        List f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                AssistedChatPolishPanelRepository assistedChatPolishPanelRepository = this.this$0;
                this.L$0 = flowCollector;
                this.label = 1;
                obj = assistedChatPolishPanelRepository.l(true, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            com.tencent.qqnt.aio.assistedchat.panel.subpanel.d dVar = (com.tencent.qqnt.aio.assistedchat.panel.subpanel.d) obj;
            if (!dVar.g().isEmpty()) {
                this.this$0.recommends.clear();
                this.this$0.recommends.addAll(dVar.g());
            }
            str = this.this$0.logKeywords;
            QLog.i("AssistedChatPolishPanelRepository", 1, "[Refresh " + str + "] emit data polish:" + dVar.g().size() + " hasMore:" + dVar.f());
            if (dVar.i() && (!dVar.g().isEmpty())) {
                z16 = true;
            } else {
                z16 = false;
            }
            f16 = this.this$0.f();
            com.tencent.qqnt.aio.assistedchat.panel.subpanel.d dVar2 = new com.tencent.qqnt.aio.assistedchat.panel.subpanel.d(z16, f16, dVar.e());
            dVar2.p(dVar.f());
            dVar2.q(true);
            dVar2.r(dVar.h());
            dVar2.l(dVar.b());
            this.L$0 = null;
            this.label = 2;
            if (flowCollector.emit(dVar2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super com.tencent.qqnt.aio.assistedchat.panel.subpanel.d> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AssistedChatPolishPanelRepository$refresh$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) flowCollector, (Object) continuation);
    }
}
