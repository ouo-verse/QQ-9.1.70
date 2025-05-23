package com.tencent.mobileqq.aio.helper;

import com.tencent.mobileqq.aio.reserve1.navigation.NavigationMsgIntent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "notifyMsgList", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.helper.AIONavHelper$listenMsgUpdate$1", f = "AIONavHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class AIONavHelper$listenMsgUpdate$1 extends SuspendLambda implements Function2<List<? extends MsgRecord>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIONavHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIONavHelper$listenMsgUpdate$1(AIONavHelper aIONavHelper, Continuation<? super AIONavHelper$listenMsgUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = aIONavHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIONavHelper, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIONavHelper$listenMsgUpdate$1 aIONavHelper$listenMsgUpdate$1 = new AIONavHelper$listenMsgUpdate$1(this.this$0, continuation);
        aIONavHelper$listenMsgUpdate$1.L$0 = obj;
        return aIONavHelper$listenMsgUpdate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends MsgRecord> list, Continuation<? super Unit> continuation) {
        return invoke2((List<MsgRecord>) list, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        com.tencent.aio.api.runtime.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List list = (List) this.L$0;
                aVar = this.this$0.mContext;
                ArrayList arrayList = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar = null;
                }
                String j3 = aVar.g().r().c().j();
                List list2 = list;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list2) {
                    if (Intrinsics.areEqual(((MsgRecord) obj2).peerUid, j3)) {
                        arrayList2.add(obj2);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    arrayList = arrayList2;
                }
                if (arrayList != null) {
                    final AIONavHelper aIONavHelper = this.this$0;
                    final ArrayList arrayList3 = new ArrayList();
                    for (Object obj3 : list2) {
                        if (com.tencent.mobileqq.aio.utils.al.f((MsgRecord) obj3)) {
                            arrayList3.add(obj3);
                        }
                    }
                    com.tencent.qqnt.aio.util.d.c(new Function0<Unit>(arrayList3) { // from class: com.tencent.mobileqq.aio.helper.AIONavHelper$listenMsgUpdate$1$3$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ List<MsgRecord> $revokeMsgs;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$revokeMsgs = arrayList3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIONavHelper.this, (Object) arrayList3);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            com.tencent.aio.api.runtime.a aVar2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            aVar2 = AIONavHelper.this.mContext;
                            if (aVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                                aVar2 = null;
                            }
                            aVar2.e().h(new NavigationMsgIntent.RemoveRevokeNav(this.$revokeMsgs));
                        }
                    });
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIONavHelper$listenMsgUpdate$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) continuation);
    }
}
