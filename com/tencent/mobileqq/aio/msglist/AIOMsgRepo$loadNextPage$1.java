package com.tencent.mobileqq.aio.msglist;

import android.os.Process;
import com.huawei.hms.common.data.DataBufferUtils;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import defpackage.MsgListUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.AIOMsgRepo$loadNextPage$1", f = "AIOMsgRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOMsgRepo$loadNextPage$1 extends SuspendLambda implements Function2<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $count;
    final /* synthetic */ long $reqMsgId;
    final /* synthetic */ long $reqTime;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOMsgRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgRepo$loadNextPage$1(AIOMsgRepo aIOMsgRepo, long j3, long j16, int i3, Continuation<? super AIOMsgRepo$loadNextPage$1> continuation) {
        super(2, continuation);
        this.this$0 = aIOMsgRepo;
        this.$reqMsgId = j3;
        this.$reqTime = j16;
        this.$count = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aIOMsgRepo, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMsgRepo$loadNextPage$1 aIOMsgRepo$loadNextPage$1 = new AIOMsgRepo$loadNextPage$1(this.this$0, this.$reqMsgId, this.$reqTime, this.$count, continuation);
        aIOMsgRepo$loadNextPage$1.L$0 = obj;
        return aIOMsgRepo$loadNextPage$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMsgRepo$loadNextPage$1) create(hVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object lastOrNull;
        long j3;
        long j16;
        boolean T0;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.aio.msgservice.h hVar = (com.tencent.aio.msgservice.h) this.L$0;
                MsgList M = this.this$0.M();
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) M);
                com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) lastOrNull;
                if (aVar != null) {
                    j3 = aVar.getMsgId();
                } else {
                    j3 = 0;
                }
                long j17 = this.$reqMsgId;
                if (j3 != j17) {
                    QLog.d("AIOMsgRepo", 1, "loadNextPage not match msgId:" + j3 + ", reqMsgId:" + j17);
                    BaseMsgRepo.o0(this.this$0, M, DataBufferUtils.NEXT_PAGE, IMsgListRepository.MsgListRepoOpType.LoadNextPageFail, null, 8, null);
                    return Unit.INSTANCE;
                }
                long j18 = this.$reqTime;
                j16 = this.this$0.msgReqTime;
                if (j18 < j16) {
                    T0 = this.this$0.T0();
                    if (T0) {
                        QLog.i("AIOMsgRepo", 1, "[loadNextPage]: rsp is not match latest req, req time is " + this.$reqTime);
                        BaseMsgRepo.o0(this.this$0, M, DataBufferUtils.NEXT_PAGE, IMsgListRepository.MsgListRepoOpType.LoadNextPage, null, 8, null);
                        return Unit.INSTANCE;
                    }
                }
                int myTid = Process.myTid();
                Process.setThreadPriority(myTid, -4);
                QLog.d("AIOMsgRepo", 1, "After Post loadNextPage end. result=" + hVar.c() + " msg=" + hVar.b());
                this.this$0.A1(hVar, this.$count);
                if (hVar.c() == 0) {
                    if (!hVar.a().isEmpty()) {
                        M.addAll(hVar.a());
                        MsgListUtil.f24918a.n("AIOMsgRepo", "injectBusinessData", QLog.isDevelopLevel(), new Function0<Unit>(hVar) { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgRepo$loadNextPage$1.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> $it;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$it = hVar;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgRepo.this, (Object) hVar);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    AIOMsgRepo.this.l0(this.$it.a());
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                    }
                    AIOMsgRepo aIOMsgRepo = this.this$0;
                    BaseMsgRepo.o0(aIOMsgRepo, aIOMsgRepo.M(), DataBufferUtils.NEXT_PAGE, IMsgListRepository.MsgListRepoOpType.LoadNextPage, null, 8, null);
                } else {
                    AIOMsgRepo aIOMsgRepo2 = this.this$0;
                    BaseMsgRepo.o0(aIOMsgRepo2, aIOMsgRepo2.M(), DataBufferUtils.NEXT_PAGE, IMsgListRepository.MsgListRepoOpType.LoadNextPageFail, null, 8, null);
                }
                Process.setThreadPriority(myTid, -2);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
