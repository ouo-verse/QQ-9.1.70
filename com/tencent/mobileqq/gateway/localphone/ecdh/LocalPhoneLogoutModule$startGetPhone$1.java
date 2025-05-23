package com.tencent.mobileqq.gateway.localphone.ecdh;

import android.os.Bundle;
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
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.gateway.localphone.ecdh.LocalPhoneLogoutModule$startGetPhone$1", f = "LocalPhoneLogoutModule.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {35, 54, 73}, m = "invokeSuspend", n = {"startTime", "getSessionStartTime", "sessionInfo", "startTime", "getMaskPhoneStartTime", "sessionInfo", "startTime", "getPhoneTokenStartTime"}, s = {"J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1"})
/* loaded from: classes12.dex */
public final class LocalPhoneLogoutModule$startGetPhone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ne1.a $callback;
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ int $phoneType;
    final /* synthetic */ int $serviceType;
    long J$0;
    long J$1;
    Object L$0;
    int label;
    final /* synthetic */ LocalPhoneLogoutModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalPhoneLogoutModule$startGetPhone$1(LocalPhoneLogoutModule localPhoneLogoutModule, int i3, int i16, Bundle bundle, ne1.a aVar, Continuation<? super LocalPhoneLogoutModule$startGetPhone$1> continuation) {
        super(2, continuation);
        this.this$0 = localPhoneLogoutModule;
        this.$serviceType = i3;
        this.$phoneType = i16;
        this.$extras = bundle;
        this.$callback = aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, localPhoneLogoutModule, Integer.valueOf(i3), Integer.valueOf(i16), bundle, aVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LocalPhoneLogoutModule$startGetPhone$1(this.this$0, this.$serviceType, this.$phoneType, this.$extras, this.$callback, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00de  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long currentTimeMillis;
        long currentTimeMillis2;
        Object h16;
        boolean z16;
        long currentTimeMillis3;
        Object f16;
        i iVar;
        boolean z17;
        i iVar2;
        boolean z18;
        long currentTimeMillis4;
        Object g16;
        long j3;
        i iVar3;
        boolean z19;
        i iVar4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            boolean z26 = false;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            long j16 = this.J$1;
                            j3 = this.J$0;
                            iVar3 = (i) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            currentTimeMillis4 = j16;
                            g16 = obj;
                            iVar4 = (i) g16;
                            if (iVar4.c() == 0 && iVar4.a() != null) {
                                z26 = true;
                            }
                            j.f213630a.a("local_phone_get_phone_token", z26, this.$serviceType, this.$phoneType, iVar3.c(), System.currentTimeMillis() - currentTimeMillis4);
                            if (z26) {
                                this.$callback.onFail(iVar4.c(), iVar4.b());
                                this.this$0.i(this.$serviceType, this.$phoneType, 3, System.currentTimeMillis() - j3);
                                return Unit.INSTANCE;
                            }
                            ne1.a aVar = this.$callback;
                            Object a16 = iVar4.a();
                            Intrinsics.checkNotNull(a16);
                            aVar.a((GetLocalPhone$OIDBGetPhoneRsp) a16);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j17 = this.J$1;
                    long j18 = this.J$0;
                    i iVar5 = (i) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    currentTimeMillis = j18;
                    iVar = iVar5;
                    currentTimeMillis3 = j17;
                    f16 = obj;
                    iVar2 = (i) f16;
                    if (iVar2.c() == 0) {
                        CharSequence charSequence = (CharSequence) iVar2.a();
                        if (charSequence != null && charSequence.length() != 0) {
                            z19 = false;
                        } else {
                            z19 = true;
                        }
                        if (!z19) {
                            z18 = true;
                            j.f213630a.a("local_phone_get_mask_phone", z18, this.$serviceType, this.$phoneType, iVar.c(), System.currentTimeMillis() - currentTimeMillis3);
                            if (!z18) {
                                this.$callback.onFail(iVar2.c(), iVar2.b());
                                this.this$0.i(this.$serviceType, this.$phoneType, 2, System.currentTimeMillis() - currentTimeMillis);
                                return Unit.INSTANCE;
                            }
                            currentTimeMillis4 = System.currentTimeMillis();
                            LocalPhoneLogoutModule localPhoneLogoutModule = this.this$0;
                            Object a17 = iVar.a();
                            Intrinsics.checkNotNull(a17);
                            Object a18 = iVar2.a();
                            Intrinsics.checkNotNull(a18);
                            String str = (String) a18;
                            int i16 = this.$phoneType;
                            int i17 = this.$serviceType;
                            Bundle bundle = this.$extras;
                            this.L$0 = iVar;
                            this.J$0 = currentTimeMillis;
                            this.J$1 = currentTimeMillis4;
                            this.label = 3;
                            g16 = localPhoneLogoutModule.g((String) a17, str, i16, i17, bundle, this);
                            if (g16 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            j3 = currentTimeMillis;
                            iVar3 = iVar;
                            iVar4 = (i) g16;
                            if (iVar4.c() == 0) {
                                z26 = true;
                            }
                            j.f213630a.a("local_phone_get_phone_token", z26, this.$serviceType, this.$phoneType, iVar3.c(), System.currentTimeMillis() - currentTimeMillis4);
                            if (z26) {
                            }
                        }
                    }
                    z18 = false;
                    j.f213630a.a("local_phone_get_mask_phone", z18, this.$serviceType, this.$phoneType, iVar.c(), System.currentTimeMillis() - currentTimeMillis3);
                    if (!z18) {
                    }
                } else {
                    currentTimeMillis2 = this.J$1;
                    currentTimeMillis = this.J$0;
                    ResultKt.throwOnFailure(obj);
                    h16 = obj;
                }
            } else {
                ResultKt.throwOnFailure(obj);
                this.this$0.j(this.$serviceType, this.$phoneType);
                currentTimeMillis = System.currentTimeMillis();
                currentTimeMillis2 = System.currentTimeMillis();
                LocalPhoneLogoutModule localPhoneLogoutModule2 = this.this$0;
                int i18 = this.$serviceType;
                Bundle bundle2 = this.$extras;
                this.J$0 = currentTimeMillis;
                this.J$1 = currentTimeMillis2;
                this.label = 1;
                h16 = localPhoneLogoutModule2.h(i18, bundle2, this);
                if (h16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            i iVar6 = (i) h16;
            if (iVar6.c() == 0) {
                CharSequence charSequence2 = (CharSequence) iVar6.a();
                if (charSequence2 != null && charSequence2.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    z16 = true;
                    j.f213630a.a("local_phone_get_session", z16, this.$serviceType, this.$phoneType, iVar6.c(), System.currentTimeMillis() - currentTimeMillis2);
                    if (z16) {
                        this.$callback.onFail(iVar6.c(), iVar6.b());
                        this.this$0.i(this.$serviceType, this.$phoneType, 1, System.currentTimeMillis() - currentTimeMillis);
                        return Unit.INSTANCE;
                    }
                    currentTimeMillis3 = System.currentTimeMillis();
                    LocalPhoneLogoutModule localPhoneLogoutModule3 = this.this$0;
                    Object a19 = iVar6.a();
                    Intrinsics.checkNotNull(a19);
                    this.L$0 = iVar6;
                    this.J$0 = currentTimeMillis;
                    this.J$1 = currentTimeMillis3;
                    this.label = 2;
                    f16 = localPhoneLogoutModule3.f((String) a19, this);
                    if (f16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    iVar = iVar6;
                    iVar2 = (i) f16;
                    if (iVar2.c() == 0) {
                    }
                    z18 = false;
                    j.f213630a.a("local_phone_get_mask_phone", z18, this.$serviceType, this.$phoneType, iVar.c(), System.currentTimeMillis() - currentTimeMillis3);
                    if (!z18) {
                    }
                }
            }
            z16 = false;
            j.f213630a.a("local_phone_get_session", z16, this.$serviceType, this.$phoneType, iVar6.c(), System.currentTimeMillis() - currentTimeMillis2);
            if (z16) {
            }
        } else {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LocalPhoneLogoutModule$startGetPhone$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
