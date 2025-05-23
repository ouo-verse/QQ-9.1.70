package com.tencent.mobileqq.aio.msglist.msgrepo;

import com.tencent.mobileqq.aio.api.AIOTofuMsgIntent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/service/t;", "tofuAuthorityRsp", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.msgrepo.TofuAuthenticationAbility$handleAuthentication$1", f = "TofuAuthenticationAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class TofuAuthenticationAbility$handleAuthentication$1 extends SuspendLambda implements Function2<com.tencent.mobileqq.aio.msg.service.t, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AIOTofuMsgIntent.AuthenticationIntent $intent;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TofuAuthenticationAbility this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TofuAuthenticationAbility$handleAuthentication$1(AIOTofuMsgIntent.AuthenticationIntent authenticationIntent, TofuAuthenticationAbility tofuAuthenticationAbility, Continuation<? super TofuAuthenticationAbility$handleAuthentication$1> continuation) {
        super(2, continuation);
        this.$intent = authenticationIntent;
        this.this$0 = tofuAuthenticationAbility;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, authenticationIntent, tofuAuthenticationAbility, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TofuAuthenticationAbility tofuAuthenticationAbility, AIOTofuMsgIntent.AuthenticationIntent authenticationIntent, com.tencent.mobileqq.aio.msg.service.t tVar, int i3, String str, ArrayList arrayList) {
        tofuAuthenticationAbility.y(authenticationIntent.e(), authenticationIntent.f(), arrayList, tVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        TofuAuthenticationAbility$handleAuthentication$1 tofuAuthenticationAbility$handleAuthentication$1 = new TofuAuthenticationAbility$handleAuthentication$1(this.$intent, this.this$0, continuation);
        tofuAuthenticationAbility$handleAuthentication$1.L$0 = obj;
        return tofuAuthenticationAbility$handleAuthentication$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.mobileqq.aio.msg.service.t tVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TofuAuthenticationAbility$handleAuthentication$1) create(tVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) tVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ArrayList<Long> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                final com.tencent.mobileqq.aio.msg.service.t tVar = (com.tencent.mobileqq.aio.msg.service.t) this.L$0;
                com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    Contact contact = new Contact(this.$intent.e(), this.$intent.f(), "");
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Boxing.boxLong(tVar.a()));
                    final TofuAuthenticationAbility tofuAuthenticationAbility = this.this$0;
                    final AIOTofuMsgIntent.AuthenticationIntent authenticationIntent = this.$intent;
                    e16.getMsgsByMsgId(contact, arrayListOf, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.x
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                        public final void onResult(int i3, String str, ArrayList arrayList) {
                            TofuAuthenticationAbility$handleAuthentication$1.b(TofuAuthenticationAbility.this, authenticationIntent, tVar, i3, str, arrayList);
                        }
                    });
                }
                this.this$0.w(tVar);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
