package com.tencent.qqguild.directmessage.aio.input.inputbar;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qqguild.directmessage.aio.DirectMessageError;
import com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewModel;
import com.tencent.qqguild.directmessage.aio.input.mixin.AioMessageSenderMixinKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewModel$sendMsg$1", f = "InputBarViewModel.kt", i = {}, l = {332}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes22.dex */
public final class InputBarViewModel$sendMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hasPicMessage;
    final /* synthetic */ boolean $hasReplyMessage;
    final /* synthetic */ boolean $hasTextMessage;
    final /* synthetic */ List<sr0.b> $originElements;
    int label;
    final /* synthetic */ InputBarViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBarViewModel$sendMsg$1(InputBarViewModel inputBarViewModel, List<sr0.b> list, boolean z16, boolean z17, boolean z18, Continuation<? super InputBarViewModel$sendMsg$1> continuation) {
        super(2, continuation);
        this.this$0 = inputBarViewModel;
        this.$originElements = list;
        this.$hasReplyMessage = z16;
        this.$hasPicMessage = z17;
        this.$hasTextMessage = z18;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new InputBarViewModel$sendMsg$1(this.this$0, this.$originElements, this.$hasReplyMessage, this.$hasPicMessage, this.$hasTextMessage, continuation);
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
            final InputBarViewModel inputBarViewModel = this.this$0;
            List<sr0.b> list = this.$originElements;
            final boolean z16 = this.$hasReplyMessage;
            final boolean z17 = this.$hasPicMessage;
            final boolean z18 = this.$hasTextMessage;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewModel$sendMsg$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    InputBarViewModel.ReplyData replyData;
                    replyData = InputBarViewModel.this.replyData;
                    if (replyData != null && z16) {
                        InputBarViewModel.this.R();
                    }
                    if (z17) {
                        InputBarViewModel.this.Q();
                    }
                    if (z18) {
                        InputBarViewModel.this.P();
                    }
                }
            };
            final InputBarViewModel inputBarViewModel2 = this.this$0;
            Function1<com.tencent.aio.msgservice.j<String>, Unit> function1 = new Function1<com.tencent.aio.msgservice.j<String>, Unit>() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewModel$sendMsg$1.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.aio.msgservice.j<String> jVar) {
                    invoke2(jVar);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.aio.msgservice.j<String> result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (result.d()) {
                        return;
                    }
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "sendMsgs failed, result:" + result.c() + ", errorMsg:" + result.b();
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", 1, (String) it.next(), null);
                    }
                    com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) InputBarViewModel.this.getMContext()).e();
                    int c16 = result.c();
                    String b16 = result.b();
                    if (b16 == null) {
                        b16 = "";
                    }
                    e16.h(new DirectMessageError(c16, b16));
                }
            };
            this.label = 1;
            if (AioMessageSenderMixinKt.d(inputBarViewModel, list, null, function0, function1, this, 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((InputBarViewModel$sendMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
