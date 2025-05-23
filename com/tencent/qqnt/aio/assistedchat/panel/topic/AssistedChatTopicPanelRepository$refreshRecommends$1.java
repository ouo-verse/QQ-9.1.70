package com.tencent.qqnt.aio.assistedchat.panel.topic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.d;
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
@DebugMetadata(c = "com.tencent.qqnt.aio.assistedchat.panel.topic.AssistedChatTopicPanelRepository$refreshRecommends$1", f = "AssistedChatTopicPanelRepository.kt", i = {0, 1}, l = {55, 68, 78}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
/* loaded from: classes23.dex */
public final class AssistedChatTopicPanelRepository$refreshRecommends$1 extends SuspendLambda implements Function2<FlowCollector<? super d>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AssistedChatTopicPanelRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssistedChatTopicPanelRepository$refreshRecommends$1(AssistedChatTopicPanelRepository assistedChatTopicPanelRepository, Continuation<? super AssistedChatTopicPanelRepository$refreshRecommends$1> continuation) {
        super(2, continuation);
        this.this$0 = assistedChatTopicPanelRepository;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) assistedChatTopicPanelRepository, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AssistedChatTopicPanelRepository$refreshRecommends$1 assistedChatTopicPanelRepository$refreshRecommends$1 = new AssistedChatTopicPanelRepository$refreshRecommends$1(this.this$0, continuation);
        assistedChatTopicPanelRepository$refreshRecommends$1.L$0 = obj;
        return assistedChatTopicPanelRepository$refreshRecommends$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005a, code lost:
    
        r15 = r14.this$0.j();
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0189 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        d j3;
        String str;
        List h16;
        FlowCollector flowCollector2;
        d dVar;
        String str2;
        d dVar2;
        boolean z16;
        List h17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowCollector2 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    dVar = (d) obj;
                    if (!dVar.g().isEmpty()) {
                        this.this$0.recommends.clear();
                        this.this$0.recommends.addAll(dVar.g());
                    }
                    str2 = this.this$0.logKeywords;
                    QLog.i("AssistedChatTopicPanelRepository", 1, "[Refresh " + str2 + "] emit server data size:" + dVar.g().size() + " hasMore:" + dVar.f());
                    if (!dVar.i() && (!dVar.g().isEmpty())) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    h17 = this.this$0.h();
                    dVar2 = new d(z16, h17, dVar.e());
                    dVar2.p(dVar.f());
                    dVar2.o(false);
                    dVar2.q(true);
                    dVar2.l(dVar.b());
                    this.L$0 = null;
                    this.label = 3;
                    if (flowCollector2.emit(dVar2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                if (this.this$0.recommends.isEmpty() && j3 != null && (!j3.g().isEmpty())) {
                    this.this$0.recommends.clear();
                    this.this$0.recommends.addAll(j3.g());
                    str = this.this$0.logKeywords;
                    QLog.i("AssistedChatTopicPanelRepository", 1, "[Refresh " + str + "] emit cache data size :" + this.this$0.recommends.size());
                    h16 = this.this$0.h();
                    d dVar3 = new d(false, h16, j3.e(), 1, null);
                    dVar3.p(true);
                    dVar3.o(true);
                    dVar3.q(true);
                    this.L$0 = flowCollector;
                    this.label = 1;
                    if (flowCollector.emit(dVar3, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            AssistedChatTopicPanelRepository assistedChatTopicPanelRepository = this.this$0;
            this.L$0 = flowCollector;
            this.label = 2;
            obj = assistedChatTopicPanelRepository.k(true, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector2 = flowCollector;
            dVar = (d) obj;
            if (!dVar.g().isEmpty()) {
            }
            str2 = this.this$0.logKeywords;
            QLog.i("AssistedChatTopicPanelRepository", 1, "[Refresh " + str2 + "] emit server data size:" + dVar.g().size() + " hasMore:" + dVar.f());
            if (!dVar.i()) {
            }
            z16 = false;
            h17 = this.this$0.h();
            dVar2 = new d(z16, h17, dVar.e());
            dVar2.p(dVar.f());
            dVar2.o(false);
            dVar2.q(true);
            dVar2.l(dVar.b());
            this.L$0 = null;
            this.label = 3;
            if (flowCollector2.emit(dVar2, this) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super d> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AssistedChatTopicPanelRepository$refreshRecommends$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) flowCollector, (Object) continuation);
    }
}
