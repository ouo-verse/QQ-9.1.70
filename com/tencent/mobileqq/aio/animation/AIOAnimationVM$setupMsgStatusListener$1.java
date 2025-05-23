package com.tencent.mobileqq.aio.animation;

import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.aio.animation.api.IAioAnimationApi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgItemList", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.animation.AIOAnimationVM$setupMsgStatusListener$1", f = "AIOAnimationVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class AIOAnimationVM$setupMsgStatusListener$1 extends SuspendLambda implements Function2<List<? extends MsgRecord>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOAnimationVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOAnimationVM$setupMsgStatusListener$1(AIOAnimationVM aIOAnimationVM, Continuation<? super AIOAnimationVM$setupMsgStatusListener$1> continuation) {
        super(2, continuation);
        this.this$0 = aIOAnimationVM;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOAnimationVM, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MsgRecord msgRecord, AIOAnimationVM aIOAnimationVM) {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(((IAioAnimationApi) QRoute.api(IAioAnimationApi.class)).convertMsgRecord(msgRecord));
        aIOAnimationVM.z(arrayListOf, true);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOAnimationVM$setupMsgStatusListener$1 aIOAnimationVM$setupMsgStatusListener$1 = new AIOAnimationVM$setupMsgStatusListener$1(this.this$0, continuation);
        aIOAnimationVM$setupMsgStatusListener$1.L$0 = obj;
        return aIOAnimationVM$setupMsgStatusListener$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends MsgRecord> list, Continuation<? super Unit> continuation) {
        return invoke2((List<MsgRecord>) list, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List<MsgRecord> list = (List) this.L$0;
                final AIOAnimationVM aIOAnimationVM = this.this$0;
                for (final MsgRecord msgRecord : list) {
                    if (msgRecord.sendStatus != i3) {
                        return Unit.INSTANCE;
                    }
                    AIOContact c16 = ((com.tencent.aio.api.runtime.a) aIOAnimationVM.getMContext()).g().r().c();
                    if (c16.e() == msgRecord.chatType && Intrinsics.areEqual(c16.j(), msgRecord.peerUid)) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("AIOAnimationVM", 4, "handle self sent msg, msgId=" + msgRecord.msgId + " msgSeq=" + msgRecord.msgSeq + " sendStatus=" + msgRecord.sendStatus);
                        }
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                AIOAnimationVM$setupMsgStatusListener$1.b(MsgRecord.this, aIOAnimationVM);
                            }
                        });
                        return Unit.INSTANCE;
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("AIOAnimationVM", 4, "[setSentMsgRead] peerUid=" + msgRecord.peerUid + " msgId=" + msgRecord.msgId + " msgSeq=" + msgRecord.msgSeq + " sendStatus=" + msgRecord.sendStatus);
                    }
                    if (msgRecord.sendType == 4) {
                        ((IAioAnimationApi) QRoute.api(IAioAnimationApi.class)).setMsgHasRead(new Contact(msgRecord.chatType, msgRecord.peerUid, ""), msgRecord.msgSeq);
                    }
                    i3 = 2;
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull List<MsgRecord> list, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOAnimationVM$setupMsgStatusListener$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) continuation);
    }
}
