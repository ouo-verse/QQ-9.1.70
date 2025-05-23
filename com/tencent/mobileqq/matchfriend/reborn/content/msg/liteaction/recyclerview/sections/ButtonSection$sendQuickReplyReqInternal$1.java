package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections;

import com.tencent.mobileqq.matchfriend.aio.interactive.AIOInteractiveResult;
import com.tencent.mobileqq.matchfriend.aio.interactive.QQStrangerAIOInteractiveRequest;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$InteractiveOption;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$InteractiveParam;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.ButtonSection$sendQuickReplyReqInternal$1", f = "ButtonSection.kt", i = {}, l = {618, 630}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class ButtonSection$sendQuickReplyReqInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ButtonSection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.ButtonSection$sendQuickReplyReqInternal$1$1", f = "ButtonSection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.ButtonSection$sendQuickReplyReqInternal$1$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AIOInteractiveResult $result;
        int label;
        final /* synthetic */ ButtonSection this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ButtonSection buttonSection, AIOInteractiveResult aIOInteractiveResult, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = buttonSection;
            this.$result = aIOInteractiveResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$result, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.O(this.$result.getSuccess(), this.$result.getMsg());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonSection$sendQuickReplyReqInternal$1(ButtonSection buttonSection, Continuation<? super ButtonSection$sendQuickReplyReqInternal$1> continuation) {
        super(2, continuation);
        this.this$0 = buttonSection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ButtonSection$sendQuickReplyReqInternal$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QQStrangerAIOInteractiveRequest qQStrangerAIOInteractiveRequest = QQStrangerAIOInteractiveRequest.f243904a;
            long peerTinyId = this.this$0.getData().getPeerTinyId();
            Prompt$InteractiveParam prompt$InteractiveParam = new Prompt$InteractiveParam();
            ButtonSection buttonSection = this.this$0;
            prompt$InteractiveParam.Interactive_object.set(buttonSection.getData().getMsgInfo().getFeedId());
            prompt$InteractiveParam.tinyid.set(buttonSection.getData().getPeerTinyId());
            Unit unit = Unit.INSTANCE;
            Prompt$InteractiveOption prompt$InteractiveOption = new Prompt$InteractiveOption();
            ButtonSection buttonSection2 = this.this$0;
            prompt$InteractiveOption.interactive_id.set(buttonSection2.getData().getInteractiveOption().getInteractiveId());
            prompt$InteractiveOption.content.set(buttonSection2.getData().getInteractiveOption().getQuickReplyText());
            this.label = 1;
            obj = qQStrangerAIOInteractiveRequest.c(104, peerTinyId, 2, prompt$InteractiveParam, prompt$InteractiveOption, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, (AIOInteractiveResult) obj, null);
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ButtonSection$sendQuickReplyReqInternal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
