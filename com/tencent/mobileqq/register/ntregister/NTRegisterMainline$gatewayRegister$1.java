package com.tencent.mobileqq.register.ntregister;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.qqnt.kernel.nativeinterface.SubmitIdentityInfoReq;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.register.ntregister.NTRegisterMainline$gatewayRegister$1", f = "NTRegisterMainline.kt", i = {}, l = {80, 90}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
public final class NTRegisterMainline$gatewayRegister$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QBaseActivity $activity;
    final /* synthetic */ WechatInfo $wechatInfo;
    int label;
    final /* synthetic */ NTRegisterMainline this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTRegisterMainline$gatewayRegister$1(NTRegisterMainline nTRegisterMainline, QBaseActivity qBaseActivity, WechatInfo wechatInfo, Continuation<? super NTRegisterMainline$gatewayRegister$1> continuation) {
        super(2, continuation);
        this.this$0 = nTRegisterMainline;
        this.$activity = qBaseActivity;
        this.$wechatInfo = wechatInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, nTRegisterMainline, qBaseActivity, wechatInfo, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new NTRegisterMainline$gatewayRegister$1(this.this$0, this.$activity, this.$wechatInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object O;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                NTRegisterMainline nTRegisterMainline = this.this$0;
                this.label = 1;
                obj = nTRegisterMainline.N(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            a aVar = (a) obj;
            if (aVar.c() != 10000 || aVar.b() == null) {
                this.this$0.H(String.valueOf(aVar.c()));
                return Unit.INSTANCE;
            }
            SubmitIdentityInfoReq submitIdentityInfoReq = new SubmitIdentityInfoReq();
            submitIdentityInfoReq.type = 1;
            byte[] bytes = ((String) aVar.b()).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            submitIdentityInfoReq.identity = bytes;
            NTRegisterMainline nTRegisterMainline2 = this.this$0;
            QBaseActivity qBaseActivity = this.$activity;
            WechatInfo wechatInfo = this.$wechatInfo;
            this.label = 2;
            O = nTRegisterMainline2.O(qBaseActivity, wechatInfo, submitIdentityInfoReq, this);
            if (O == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((NTRegisterMainline$gatewayRegister$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
