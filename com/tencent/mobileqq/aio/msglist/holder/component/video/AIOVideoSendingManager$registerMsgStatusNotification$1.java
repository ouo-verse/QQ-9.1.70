package com.tencent.mobileqq.aio.msglist.holder.component.video;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", TabPreloadItem.TAB_NAME_MESSAGE, "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoSendingManager$registerMsgStatusNotification$1", f = "AIOVideoSendingManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOVideoSendingManager$registerMsgStatusNotification$1 extends SuspendLambda implements Function2<List<? extends AIOMsgItem>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOVideoSendingManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOVideoSendingManager$registerMsgStatusNotification$1(AIOVideoSendingManager aIOVideoSendingManager, Continuation<? super AIOVideoSendingManager$registerMsgStatusNotification$1> continuation) {
        super(2, continuation);
        this.this$0 = aIOVideoSendingManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOVideoSendingManager, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOVideoSendingManager$registerMsgStatusNotification$1 aIOVideoSendingManager$registerMsgStatusNotification$1 = new AIOVideoSendingManager$registerMsgStatusNotification$1(this.this$0, continuation);
        aIOVideoSendingManager$registerMsgStatusNotification$1.L$0 = obj;
        return aIOVideoSendingManager$registerMsgStatusNotification$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ConcurrentHashMap concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List<AIOMsgItem> list = (List) this.L$0;
                concurrentHashMap = this.this$0.sendingTaskMap;
                if (concurrentHashMap.isEmpty()) {
                    return Unit.INSTANCE;
                }
                AIOVideoSendingManager aIOVideoSendingManager = this.this$0;
                for (AIOMsgItem aIOMsgItem : list) {
                    if (aIOMsgItem instanceof ShortVideoMsgItem) {
                        aIOVideoSendingManager.G((ShortVideoMsgItem) aIOMsgItem);
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull List<? extends AIOMsgItem> list, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOVideoSendingManager$registerMsgStatusNotification$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) continuation);
    }
}
