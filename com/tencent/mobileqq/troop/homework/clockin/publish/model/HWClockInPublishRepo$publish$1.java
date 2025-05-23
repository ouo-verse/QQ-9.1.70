package com.tencent.mobileqq.troop.homework.clockin.publish.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.IPublishGroupSchoolTaskCallback;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskReq;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskRsp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/troop/homework/clockin/publish/model/b;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.publish.model.HWClockInPublishRepo$publish$1", f = "HWClockInPublishRepo.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
final class HWClockInPublishRepo$publish$1 extends SuspendLambda implements Function2<ProducerScope<? super b>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ PublishGroupSchoolTaskReq $req;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInPublishRepo$publish$1(PublishGroupSchoolTaskReq publishGroupSchoolTaskReq, Continuation<? super HWClockInPublishRepo$publish$1> continuation) {
        super(2, continuation);
        this.$req = publishGroupSchoolTaskReq;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) publishGroupSchoolTaskReq, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ProducerScope producerScope, int i3, String errMsg, PublishGroupSchoolTaskRsp rsp) {
        QLog.i("HW.ClockIn.PUBLISH.HWClockInPublishRepo", 1, "publish, errCode:" + i3 + ", errMsg:" + errMsg);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        producerScope.mo2003trySendJP2dKIU(new b(i3, errMsg, rsp));
        SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        HWClockInPublishRepo$publish$1 hWClockInPublishRepo$publish$1 = new HWClockInPublishRepo$publish$1(this.$req, continuation);
        hWClockInPublishRepo$publish$1.L$0 = obj;
        return hWClockInPublishRepo$publish$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                r g16 = bg.f302144a.g();
                if (g16 != null) {
                    g16.publishGroupSchoolTask(this.$req, new IPublishGroupSchoolTaskCallback() { // from class: com.tencent.mobileqq.troop.homework.clockin.publish.model.a
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IPublishGroupSchoolTaskCallback
                        public final void onResult(int i16, String str, PublishGroupSchoolTaskRsp publishGroupSchoolTaskRsp) {
                            HWClockInPublishRepo$publish$1.b(ProducerScope.this, i16, str, publishGroupSchoolTaskRsp);
                        }
                    });
                }
                AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, anonymousClass2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super b> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWClockInPublishRepo$publish$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
