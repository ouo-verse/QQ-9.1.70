package com.tencent.qqguild.directmessage.aio.input.mixin;

import com.tencent.aio.msgservice.j;
import com.tencent.aio.msgservice.k;
import com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aa\u0010\f\u001a\u00020\u0005*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00050\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a<\u0010\u0012\u001a\u00020\u0005*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/mixin/e;", "", "Lsr0/b;", "message", "Lkotlin/Function0;", "", "onInterrupt", "onSendStart", "Lkotlin/Function1;", "Lcom/tencent/aio/msgservice/j;", "", "onSendResult", "c", "(Lcom/tencent/qqguild/directmessage/aio/input/mixin/e;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/guild/aio/sendmsg/SendMsgInterceptUtil$a;", "it", "onStartSend", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AioMessageSenderMixinKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CoroutineScope coroutineScope, SendMsgInterceptUtil.SendMsgsRsp sendMsgsRsp, Function1<? super j<String>, Unit> function1, Function0<Unit> function0) {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.F(sendMsgsRsp.getSendMsgsReq()), new AioMessageSenderMixinKt$realSendMessage$1(function1, null)), Dispatchers.getIO()), coroutineScope);
        function0.invoke();
    }

    @Nullable
    public static final Object c(@NotNull e eVar, @NotNull List<sr0.b> list, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function1<? super j<String>, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new AioMessageSenderMixinKt$sendMessage$5(SendMsgInterceptUtil.b(SendMsgInterceptUtil.f112285a, new k(eVar.a().g().r(), list), eVar.a(), null, 4, null), function0, function1, function02, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutineScope == coroutine_suspended) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object d(e eVar, List list, Function0 function0, Function0 function02, Function1 function1, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: com.tencent.qqguild.directmessage.aio.input.mixin.AioMessageSenderMixinKt$sendMessage$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function0;
        if ((i3 & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: com.tencent.qqguild.directmessage.aio.input.mixin.AioMessageSenderMixinKt$sendMessage$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function04 = function02;
        if ((i3 & 8) != 0) {
            function1 = new Function1<j<String>, Unit>() { // from class: com.tencent.qqguild.directmessage.aio.input.mixin.AioMessageSenderMixinKt$sendMessage$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull j<String> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(j<String> jVar) {
                    invoke2(jVar);
                    return Unit.INSTANCE;
                }
            };
        }
        return c(eVar, list, function03, function04, function1, continuation);
    }
}
