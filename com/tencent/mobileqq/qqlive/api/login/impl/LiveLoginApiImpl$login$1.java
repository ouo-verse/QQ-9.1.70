package com.tencent.mobileqq.qqlive.api.login.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.api.login.impl.LiveLoginApiImpl$login$1", f = "LiveLoginApiImpl.kt", i = {0, 0, 0, 1, 1}, l = {245, 104}, m = "invokeSuspend", n = {"loginInfo", "$this$withLock_u24default$iv", "start", "$this$withLock_u24default$iv", "start"}, s = {"L$0", "L$1", "J$0", "L$0", "J$0"})
/* loaded from: classes17.dex */
final class LiveLoginApiImpl$login$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $a2;
    final /* synthetic */ String $appId;
    final /* synthetic */ Function1<QQLiveResponse<LiveLoginInfo>, Unit> $callback;
    final /* synthetic */ String $uin;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ LiveLoginApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveLoginApiImpl$login$1(LiveLoginApiImpl liveLoginApiImpl, String str, String str2, Function1<? super QQLiveResponse<LiveLoginInfo>, Unit> function1, String str3, Continuation<? super LiveLoginApiImpl$login$1> continuation) {
        super(2, continuation);
        this.this$0 = liveLoginApiImpl;
        this.$appId = str;
        this.$uin = str2;
        this.$callback = function1;
        this.$a2 = str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, liveLoginApiImpl, str, str2, function1, str3, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LiveLoginApiImpl$login$1(this.this$0, this.$appId, this.$uin, this.$callback, this.$a2, continuation);
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [T, com.tencent.mobileqq.qqlive.login.LiveLoginInfo] */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, com.tencent.mobileqq.qqlive.login.LiveLoginInfo] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Ref.ObjectRef objectRef;
        ?? r26;
        boolean z16;
        Mutex mutex;
        String str;
        Function1<QQLiveResponse<LiveLoginInfo>, Unit> function1;
        Mutex mutex2;
        String str2;
        LiveLoginApiImpl liveLoginApiImpl;
        String str3;
        long j3;
        String str4;
        Mutex mutex3;
        ?? r112;
        Object doLogin;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            boolean z17 = false;
            try {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            j16 = this.J$0;
                            mutex3 = (Mutex) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                Unit unit = Unit.INSTANCE;
                                mutex3.unlock(null);
                                long currentTimeMillis = System.currentTimeMillis() - j16;
                                AegisLogger.INSTANCE.d(LiveLoginApiImpl.LOG_TAG, "login", "lock cost=" + currentTimeMillis);
                                return Unit.INSTANCE;
                            } catch (Throwable th5) {
                                th = th5;
                                mutex3.unlock(null);
                                throw th;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j3 = this.J$0;
                    String str5 = (String) this.L$6;
                    Function1<QQLiveResponse<LiveLoginInfo>, Unit> function12 = (Function1) this.L$5;
                    str = (String) this.L$4;
                    String str6 = (String) this.L$3;
                    liveLoginApiImpl = (LiveLoginApiImpl) this.L$2;
                    mutex2 = (Mutex) this.L$1;
                    objectRef = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    str3 = str6;
                    function1 = function12;
                    str2 = str5;
                } else {
                    ResultKt.throwOnFailure(obj);
                    objectRef = new Ref.ObjectRef();
                    r26 = this.this$0.get(this.$appId, this.$uin);
                    objectRef.element = r26;
                    if (r26 != 0 && r26.t()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        Function1<QQLiveResponse<LiveLoginInfo>, Unit> function13 = this.$callback;
                        if (function13 != null) {
                            function13.invoke(new QQLiveResponse<>(null, true, 0L, null, objectRef.element));
                        }
                        return Unit.INSTANCE;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    mutex = this.this$0.mutex;
                    LiveLoginApiImpl liveLoginApiImpl2 = this.this$0;
                    String str7 = this.$appId;
                    str = this.$uin;
                    function1 = this.$callback;
                    String str8 = this.$a2;
                    this.L$0 = objectRef;
                    this.L$1 = mutex;
                    this.L$2 = liveLoginApiImpl2;
                    this.L$3 = str7;
                    this.L$4 = str;
                    this.L$5 = function1;
                    this.L$6 = str8;
                    this.J$0 = currentTimeMillis2;
                    this.label = 1;
                    if (mutex.lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex2 = mutex;
                    str2 = str8;
                    liveLoginApiImpl = liveLoginApiImpl2;
                    str3 = str7;
                    j3 = currentTimeMillis2;
                }
                r112 = liveLoginApiImpl.get(str3, str4);
                objectRef.element = r112;
                if (r112 != 0 && r112.t()) {
                    z17 = true;
                }
                if (z17) {
                    if (function1 != null) {
                        function1.invoke(new QQLiveResponse<>(null, true, 0L, null, objectRef.element));
                    }
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return unit2;
                }
                this.L$0 = mutex2;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.L$6 = null;
                this.J$0 = j3;
                this.label = 2;
                doLogin = liveLoginApiImpl.doLogin(str3, str4, str2, function1, this);
                if (doLogin == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j16 = j3;
                mutex3 = mutex2;
                Unit unit3 = Unit.INSTANCE;
                mutex3.unlock(null);
                long currentTimeMillis3 = System.currentTimeMillis() - j16;
                AegisLogger.INSTANCE.d(LiveLoginApiImpl.LOG_TAG, "login", "lock cost=" + currentTimeMillis3);
                return Unit.INSTANCE;
            } catch (Throwable th6) {
                th = th6;
                mutex3 = mutex2;
                mutex3.unlock(null);
                throw th;
            }
            str4 = str;
        } else {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LiveLoginApiImpl$login$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
