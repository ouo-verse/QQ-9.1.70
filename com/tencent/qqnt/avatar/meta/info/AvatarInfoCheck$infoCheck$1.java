package com.tencent.qqnt.avatar.meta.info;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.avatar.meta.info.AvatarInfoCheck$infoCheck$1", f = "AvatarInfoCheck.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class AvatarInfoCheck$infoCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ com.tencent.qqnt.avatar.meta.a $avatarBean;
    final /* synthetic */ a $avatarInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarInfoCheck$infoCheck$1(com.tencent.qqnt.avatar.meta.a aVar, a aVar2, Continuation<? super AvatarInfoCheck$infoCheck$1> continuation) {
        super(2, continuation);
        this.$avatarBean = aVar;
        this.$avatarInfo = aVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, aVar2, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AvatarInfoCheck$infoCheck$1(this.$avatarBean, this.$avatarInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            boolean z17 = true;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                d b16 = c.f352932a.b();
                if (b16 != null) {
                    z16 = b16.a(this.$avatarBean, this.$avatarInfo.d());
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return Unit.INSTANCE;
                }
                AvatarInfoRequestManager avatarInfoRequestManager = AvatarInfoRequestManager.f352916a;
                com.tencent.qqnt.avatar.meta.a aVar = this.$avatarBean;
                this.label = 1;
                obj = avatarInfoRequestManager.f(aVar, true, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            a[] aVarArr = (a[]) obj;
            if (aVarArr != null) {
                if (aVarArr.length != 0) {
                    z17 = false;
                }
                if (!z17 && !Intrinsics.areEqual(aVarArr[0].c(), this.$avatarInfo.c())) {
                    com.tencent.qqnt.avatar.util.d.f352991a.e("AvatarInfoCheck", "infoCheck notifyRefresh " + this.$avatarBean.a() + "_" + this.$avatarBean.c() + MsgSummary.STR_COLON + aVarArr[0].c() + ", " + this.$avatarInfo.c());
                    AvatarInfoCheck.b(this.$avatarBean.a(), this.$avatarBean.c());
                    return Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AvatarInfoCheck$infoCheck$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
