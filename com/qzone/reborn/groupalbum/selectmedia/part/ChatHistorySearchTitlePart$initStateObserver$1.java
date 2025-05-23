package com.qzone.reborn.groupalbum.selectmedia.part;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySearchTitlePart$initStateObserver$1", f = "ChatHistorySearchTitlePart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class ChatHistorySearchTitlePart$initStateObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatHistorySearchTitlePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistorySearchTitlePart$initStateObserver$1(ChatHistorySearchTitlePart chatHistorySearchTitlePart, Continuation<? super ChatHistorySearchTitlePart$initStateObserver$1> continuation) {
        super(2, continuation);
        this.this$0 = chatHistorySearchTitlePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatHistorySearchTitlePart$initStateObserver$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LiveData<Boolean> T1 = this.this$0.G9().T1();
            LifecycleOwner lifecycleOwner = this.this$0.getPartHost().getLifecycleOwner();
            final ChatHistorySearchTitlePart chatHistorySearchTitlePart = this.this$0;
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySearchTitlePart$initStateObserver$1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    ChatHistorySearchTitlePart chatHistorySearchTitlePart2 = ChatHistorySearchTitlePart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    chatHistorySearchTitlePart2.Q9(it.booleanValue());
                }
            };
            T1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChatHistorySearchTitlePart$initStateObserver$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
