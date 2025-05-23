package com.tencent.qqnt.aio.assistedchat.panel.prompt;

import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/tencent/qqnt/aio/assistedchat/model/a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.assistedchat.panel.prompt.AssistedChatPromptRepository$getPromptListFlow$1", f = "AssistedChatPromptRepository.kt", i = {1}, l = {31, 34, 39}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes23.dex */
public final class AssistedChatPromptRepository$getPromptListFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends com.tencent.qqnt.aio.assistedchat.model.a>>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AssistedChatPromptRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssistedChatPromptRepository$getPromptListFlow$1(AssistedChatPromptRepository assistedChatPromptRepository, Continuation<? super AssistedChatPromptRepository$getPromptListFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = assistedChatPromptRepository;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) assistedChatPromptRepository, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AssistedChatPromptRepository$getPromptListFlow$1 assistedChatPromptRepository$getPromptListFlow$1 = new AssistedChatPromptRepository$getPromptListFlow$1(this.this$0, continuation);
        assistedChatPromptRepository$getPromptListFlow$1.L$0 = obj;
        return assistedChatPromptRepository$getPromptListFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends com.tencent.qqnt.aio.assistedchat.model.a>> flowCollector, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super List<com.tencent.qqnt.aio.assistedchat.model.a>>) flowCollector, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b2 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List list;
        AIOContact aIOContact;
        Object e16;
        FlowCollector flowCollector;
        List list2;
        List list3;
        ArrayList arrayList;
        List list4;
        List list5;
        List list6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        flowCollector = (FlowCollector) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        list3 = (List) obj;
                        if (!list3.isEmpty()) {
                            list5 = this.this$0.prompts;
                            list5.clear();
                            list6 = this.this$0.prompts;
                            list6.addAll(list3);
                        }
                        list4 = this.this$0.prompts;
                        arrayList = new ArrayList(list4);
                        this.L$0 = null;
                        this.label = 3;
                        if (flowCollector.emit(arrayList, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
            } else {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                list = this.this$0.prompts;
                if (!list.isEmpty()) {
                    list2 = this.this$0.prompts;
                    ArrayList arrayList2 = new ArrayList(list2);
                    this.label = 1;
                    if (flowCollector2.emit(arrayList2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                AssistedChatPromptRepository assistedChatPromptRepository = this.this$0;
                aIOContact = assistedChatPromptRepository.aioContact;
                this.L$0 = flowCollector2;
                this.label = 2;
                e16 = assistedChatPromptRepository.e(aIOContact, this);
                if (e16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowCollector = flowCollector2;
                obj = e16;
                list3 = (List) obj;
                if (!list3.isEmpty()) {
                }
                list4 = this.this$0.prompts;
                arrayList = new ArrayList(list4);
                this.L$0 = null;
                this.label = 3;
                if (flowCollector.emit(arrayList, this) == coroutine_suspended) {
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull FlowCollector<? super List<com.tencent.qqnt.aio.assistedchat.model.a>> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AssistedChatPromptRepository$getPromptListFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) flowCollector, (Object) continuation);
    }
}
