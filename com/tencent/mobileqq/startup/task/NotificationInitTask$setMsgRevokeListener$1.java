package com.tencent.mobileqq.startup.task;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.msg.MsgExtKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\u008a@"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/qqnt/msg/d;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.startup.task.NotificationInitTask$setMsgRevokeListener$1", f = "NotificationInitTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class NotificationInitTask$setMsgRevokeListener$1 extends SuspendLambda implements Function2<ArrayList<com.tencent.qqnt.msg.d>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ WeakReference<QQAppInterface> $appRef;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NotificationInitTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationInitTask$setMsgRevokeListener$1(NotificationInitTask notificationInitTask, WeakReference<QQAppInterface> weakReference, Continuation<? super NotificationInitTask$setMsgRevokeListener$1> continuation) {
        super(2, continuation);
        this.this$0 = notificationInitTask;
        this.$appRef = weakReference;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, notificationInitTask, weakReference, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        NotificationInitTask$setMsgRevokeListener$1 notificationInitTask$setMsgRevokeListener$1 = new NotificationInitTask$setMsgRevokeListener$1(this.this$0, this.$appRef, continuation);
        notificationInitTask$setMsgRevokeListener$1.L$0 = obj;
        return notificationInitTask$setMsgRevokeListener$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList = (ArrayList) this.L$0;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    com.tencent.qqnt.msg.d dVar = (com.tencent.qqnt.msg.d) obj2;
                    if (!MsgExtKt.Q(dVar) && !MsgExtKt.K(dVar)) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        arrayList2.add(obj2);
                    }
                }
                NotificationInitTask notificationInitTask = this.this$0;
                WeakReference<QQAppInterface> weakReference = this.$appRef;
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    final MsgRecord a16 = ((com.tencent.qqnt.msg.d) it.next()).a();
                    com.tencent.qqnt.notification.util.a.f359909a.a(new Function0<String>() { // from class: com.tencent.mobileqq.startup.task.NotificationInitTask$setMsgRevokeListener$1$2$1$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgRecord.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            MsgRecord msgRecord = MsgRecord.this;
                            return "handle revoke, peerUin=" + msgRecord.peerUin + " msgId=" + msgRecord.msgId + " seq=" + msgRecord.msgSeq;
                        }
                    });
                    QQAppInterface qQAppInterface = weakReference.get();
                    RecentContactInfo recentContactInfo = new RecentContactInfo();
                    recentContactInfo.peerUin = a16.peerUin;
                    recentContactInfo.chatType = a16.chatType;
                    recentContactInfo.msgId = a16.msgId;
                    Unit unit = Unit.INSTANCE;
                    notificationInitTask.d(qQAppInterface, recentContactInfo);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ArrayList<com.tencent.qqnt.msg.d> arrayList, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((NotificationInitTask$setMsgRevokeListener$1) create(arrayList, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList, (Object) continuation);
    }
}
