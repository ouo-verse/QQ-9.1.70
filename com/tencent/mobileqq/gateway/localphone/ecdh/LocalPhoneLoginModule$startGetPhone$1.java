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
@DebugMetadata(c = "com.tencent.mobileqq.gateway.localphone.ecdh.LocalPhoneLoginModule$startGetPhone$1", f = "LocalPhoneLoginModule.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {34, 53, 72}, m = "invokeSuspend", n = {"startTime", "getSessionStartTime", "sessionInfo", "startTime", "getMaskPhoneStartTime", "sessionInfo", "startTime", "getPhoneTokenStartTime"}, s = {"J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1"})
/* loaded from: classes12.dex */
public final class LocalPhoneLoginModule$startGetPhone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ne1.a $callback;
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ int $phoneType;
    final /* synthetic */ int $serviceType;
    long J$0;
    long J$1;
    Object L$0;
    int label;
    final /* synthetic */ LocalPhoneLoginModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalPhoneLoginModule$startGetPhone$1(LocalPhoneLoginModule localPhoneLoginModule, int i3, int i16, ne1.a aVar, Bundle bundle, Continuation<? super LocalPhoneLoginModule$startGetPhone$1> continuation) {
        super(2, continuation);
        this.this$0 = localPhoneLoginModule;
        this.$serviceType = i3;
        this.$phoneType = i16;
        this.$callback = aVar;
        this.$extras = bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, localPhoneLoginModule, Integer.valueOf(i3), Integer.valueOf(i16), aVar, bundle, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LocalPhoneLoginModule$startGetPhone$1(this.this$0, this.$serviceType, this.$phoneType, this.$callback, this.$extras, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object h16;
        long j3;
        long j16;
        i iVar;
        boolean z16;
        long currentTimeMillis;
        boolean z17;
        i iVar2;
        i iVar3;
        boolean z18;
        Object f16;
        long j17;
        long j18;
        boolean z19;
        i iVar4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        Object obj2 = obj;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z26 = false;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        j18 = this.J$1;
                        j17 = this.J$0;
                        i iVar5 = (i) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        iVar2 = iVar5;
                        f16 = obj2;
                        iVar4 = (i) f16;
                        if (iVar4.c() == 0 && iVar4.a() != null) {
                            z26 = true;
                        }
                        j.f213630a.a("local_phone_get_phone_token", z26, this.$serviceType, this.$phoneType, iVar2.c(), System.currentTimeMillis() - j18);
                        if (z26) {
                            this.$callback.onFail(iVar4.c(), iVar4.b());
                            this.this$0.i(this.$serviceType, this.$phoneType, 3, System.currentTimeMillis() - j17);
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
                currentTimeMillis = this.J$1;
                j3 = this.J$0;
                iVar = (i) this.L$0;
                ResultKt.throwOnFailure(obj);
                iVar2 = iVar;
                long j19 = j3;
                iVar3 = (i) obj2;
                if (iVar3.c() == 0) {
                    CharSequence charSequence = (CharSequence) iVar3.a();
                    if (charSequence != null && charSequence.length() != 0) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                    if (!z19) {
                        z18 = true;
                        j.f213630a.a("local_phone_get_mask_phone", z18, this.$serviceType, this.$phoneType, iVar2.c(), System.currentTimeMillis() - currentTimeMillis);
                        if (!z18) {
                            this.$callback.onFail(iVar3.c(), iVar3.b());
                            this.this$0.i(this.$serviceType, this.$phoneType, 2, System.currentTimeMillis() - j19);
                            return Unit.INSTANCE;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        LocalPhoneLoginModule localPhoneLoginModule = this.this$0;
                        Object a17 = iVar2.a();
                        Intrinsics.checkNotNull(a17);
                        Object a18 = iVar3.a();
                        Intrinsics.checkNotNull(a18);
                        String str = (String) a18;
                        int i16 = this.$phoneType;
                        int i17 = this.$serviceType;
                        Bundle bundle = this.$extras;
                        this.L$0 = iVar2;
                        this.J$0 = j19;
                        this.J$1 = currentTimeMillis2;
                        this.label = 3;
                        f16 = LocalPhoneLoginModule.f(localPhoneLoginModule, (String) a17, str, i16, i17, null, bundle, this, 16, null);
                        if (f16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        j17 = j19;
                        j18 = currentTimeMillis2;
                        iVar4 = (i) f16;
                        if (iVar4.c() == 0) {
                            z26 = true;
                        }
                        j.f213630a.a("local_phone_get_phone_token", z26, this.$serviceType, this.$phoneType, iVar2.c(), System.currentTimeMillis() - j18);
                        if (z26) {
                        }
                    }
                }
                z18 = false;
                j.f213630a.a("local_phone_get_mask_phone", z18, this.$serviceType, this.$phoneType, iVar2.c(), System.currentTimeMillis() - currentTimeMillis);
                if (!z18) {
                }
            } else {
                j16 = this.J$1;
                j3 = this.J$0;
                ResultKt.throwOnFailure(obj);
                h16 = obj2;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.this$0.j(this.$serviceType, this.$phoneType);
            long currentTimeMillis3 = System.currentTimeMillis();
            long currentTimeMillis4 = System.currentTimeMillis();
            LocalPhoneLoginModule localPhoneLoginModule2 = this.this$0;
            int i18 = this.$serviceType;
            this.J$0 = currentTimeMillis3;
            this.J$1 = currentTimeMillis4;
            this.label = 1;
            h16 = LocalPhoneLoginModule.h(localPhoneLoginModule2, i18, null, this, 2, null);
            if (h16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = currentTimeMillis3;
            j16 = currentTimeMillis4;
        }
        iVar = (i) h16;
        if (iVar.c() == 0) {
            CharSequence charSequence2 = (CharSequence) iVar.a();
            if (charSequence2 != null && charSequence2.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                z16 = true;
                j.f213630a.a("local_phone_get_session", z16, this.$serviceType, this.$phoneType, iVar.c(), System.currentTimeMillis() - j16);
                if (z16) {
                    this.$callback.onFail(iVar.c(), iVar.b());
                    this.this$0.i(this.$serviceType, this.$phoneType, 1, System.currentTimeMillis() - j3);
                    return Unit.INSTANCE;
                }
                currentTimeMillis = System.currentTimeMillis();
                LocalPhoneLoginModule localPhoneLoginModule3 = this.this$0;
                Object a19 = iVar.a();
                Intrinsics.checkNotNull(a19);
                this.L$0 = iVar;
                this.J$0 = j3;
                this.J$1 = currentTimeMillis;
                this.label = 2;
                obj2 = localPhoneLoginModule3.d((String) a19, this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                iVar2 = iVar;
                long j192 = j3;
                iVar3 = (i) obj2;
                if (iVar3.c() == 0) {
                }
                z18 = false;
                j.f213630a.a("local_phone_get_mask_phone", z18, this.$serviceType, this.$phoneType, iVar2.c(), System.currentTimeMillis() - currentTimeMillis);
                if (!z18) {
                }
            }
        }
        z16 = false;
        j.f213630a.a("local_phone_get_session", z16, this.$serviceType, this.$phoneType, iVar.c(), System.currentTimeMillis() - j16);
        if (z16) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LocalPhoneLoginModule$startGetPhone$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
