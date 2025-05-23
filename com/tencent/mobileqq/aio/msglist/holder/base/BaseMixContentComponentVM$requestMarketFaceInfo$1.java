package com.tencent.mobileqq.aio.msglist.holder.base;

import com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceUIState$MarketFaceInfoUpdateState;
import com.tencent.mobileqq.aio.msglist.holder.component.marketface.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.adapter.api.IMarketFaceApi;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponentVM$requestMarketFaceInfo$1", f = "BaseMixContentComponentVM.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
final class BaseMixContentComponentVM$requestMarketFaceInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ MarketFaceElement $requestMarketFaceElement;
    final /* synthetic */ c.f $requestMarketFaceInfo;
    int label;
    final /* synthetic */ BaseMixContentComponentVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMixContentComponentVM$requestMarketFaceInfo$1(MarketFaceElement marketFaceElement, BaseMixContentComponentVM baseMixContentComponentVM, c.f fVar, Continuation<? super BaseMixContentComponentVM$requestMarketFaceInfo$1> continuation) {
        super(2, continuation);
        this.$requestMarketFaceElement = marketFaceElement;
        this.this$0 = baseMixContentComponentVM;
        this.$requestMarketFaceInfo = fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, marketFaceElement, baseMixContentComponentVM, fVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new BaseMixContentComponentVM$requestMarketFaceInfo$1(this.$requestMarketFaceElement, this.this$0, this.$requestMarketFaceInfo, continuation);
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
                IMarketFaceApi iMarketFaceApi = (IMarketFaceApi) QRoute.api(IMarketFaceApi.class);
                MarketFaceElement marketFaceElement = this.$requestMarketFaceElement;
                this.label = 1;
                obj = iMarketFaceApi.fetchMarketFaceInfoSuspend(marketFaceElement, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            com.tencent.qqnt.msg.api.c cVar = (com.tencent.qqnt.msg.api.c) obj;
            if (cVar.d()) {
                this.this$0.updateUI(new AIOMarketFaceUIState$MarketFaceInfoUpdateState((com.tencent.qqnt.emotion.adapter.api.a) cVar.a(), this.$requestMarketFaceInfo.a()));
            } else {
                QLog.e("BaseMixContentComponentVM", 1, "[requestMarketFaceInfo] fail. msg=" + cVar.b());
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((BaseMixContentComponentVM$requestMarketFaceInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
