package com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation;

import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.ntcompose.foundation.lazy.d;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import to3.b;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$MiddleContent$3", f = "AdeliePromptConversationPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdeliePromptConversationPage$MiddleContent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ d $pageListSate;
    public final /* synthetic */ AdeliePromptConversationPage this$0;

    @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$MiddleContent$3$1", f = "AdeliePromptConversationPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$MiddleContent$3$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
        public final /* synthetic */ d $pageListSate;
        public final /* synthetic */ AdeliePromptConversationPage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AdeliePromptConversationPage adeliePromptConversationPage, d dVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = adeliePromptConversationPage;
            this.$pageListSate = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$pageListSate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            AdeliePromptConversationPage adeliePromptConversationPage = this.this$0;
            int i3 = AdeliePromptConversationPage.$r8$clinit;
            if (adeliePromptConversationPage.getViewModel().needScrollToBottom) {
                d dVar = this.$pageListSate;
                b.a.b(dVar, dVar.f(), false, null, 6, null);
                this.this$0.getViewModel().needScrollToBottom = false;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdeliePromptConversationPage$MiddleContent$3(AdeliePromptConversationPage adeliePromptConversationPage, d dVar, Continuation<? super AdeliePromptConversationPage$MiddleContent$3> continuation) {
        super(2, continuation);
        this.this$0 = adeliePromptConversationPage;
        this.$pageListSate = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdeliePromptConversationPage$MiddleContent$3(this.this$0, this.$pageListSate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdeliePromptConversationPage$MiddleContent$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        BuildersKt.e(e.f117232d, null, null, new AnonymousClass1(this.this$0, this.$pageListSate, null), 3, null);
        return Unit.INSTANCE;
    }
}
