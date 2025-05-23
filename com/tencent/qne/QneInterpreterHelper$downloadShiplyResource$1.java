package com.tencent.qne;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qne.delegate.d;
import com.tencent.qne.delegate.e;
import com.tencent.qne.model.Backend;
import com.tencent.qne.model.PreloadStatusCode;
import com.tencent.qne.model.g;
import com.tencent.qne.util.Logger;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.qne.QneInterpreterHelper$downloadShiplyResource$1", f = "QneInterpreterHelper.kt", i = {1, 2}, l = {41, 55, 65}, m = "invokeSuspend", n = {"timeStart", "timeStart"}, s = {"J$0", "J$0"})
/* loaded from: classes22.dex */
final class QneInterpreterHelper$downloadShiplyResource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Backend $backend;
    final /* synthetic */ long $callbackHandle;
    final /* synthetic */ String $fallbackResource;
    final /* synthetic */ String $preferredResource;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ d $shiply;
    long J$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QneInterpreterHelper$downloadShiplyResource$1(Backend backend, d dVar, long j3, String str, String str2, String str3, Continuation<? super QneInterpreterHelper$downloadShiplyResource$1> continuation) {
        super(2, continuation);
        this.$backend = backend;
        this.$shiply = dVar;
        this.$callbackHandle = j3;
        this.$resourceId = str;
        this.$preferredResource = str2;
        this.$fallbackResource = str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, backend, dVar, Long.valueOf(j3), str, str2, str3, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new QneInterpreterHelper$downloadShiplyResource$1(this.$backend, this.$shiply, this.$callbackHandle, this.$resourceId, this.$preferredResource, this.$fallbackResource, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0174 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object f16;
        long currentTimeMillis;
        e eVar;
        Object a16;
        String str;
        Object a17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            String str2 = "shiply loadResource for ";
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            long j3 = this.J$0;
                            ResultKt.throwOnFailure(obj);
                            currentTimeMillis = j3;
                            a17 = obj;
                            e eVar2 = (e) a17;
                            Logger.i("[qne]QneInterpreterHelper", str2 + this.$resourceId + " with fallback " + this.$fallbackResource + " finish, cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", result:" + eVar2);
                            QneInterpreterHelper.INSTANCE.onDownloadFinish(this.$callbackHandle, g.a(eVar2.a()).getValue(), eVar2.b(), eVar2.d(), eVar2.c());
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j16 = this.J$0;
                    ResultKt.throwOnFailure(obj);
                    currentTimeMillis = j16;
                    a16 = obj;
                    eVar = (e) a16;
                    if (eVar == null) {
                        str = "shiply loadResource for ";
                    } else {
                        String str3 = this.$resourceId;
                        String str4 = this.$preferredResource;
                        long j17 = this.$callbackHandle;
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        StringBuilder sb5 = new StringBuilder();
                        str = "shiply loadResource for ";
                        sb5.append(str);
                        sb5.append(str3);
                        sb5.append(" with preferred ");
                        sb5.append((Object) str4);
                        sb5.append(" finish, cost:");
                        sb5.append(currentTimeMillis2);
                        sb5.append(", result:");
                        sb5.append(eVar);
                        Logger.i("[qne]QneInterpreterHelper", sb5.toString());
                        if (eVar.a() == PreloadStatusCode.DownloadSuccess.getValue() || eVar.a() == PreloadStatusCode.NotNeedDownload.getValue()) {
                            QneInterpreterHelper.INSTANCE.onDownloadFinish(j17, eVar.a(), eVar.b(), eVar.d(), eVar.c());
                            return Unit.INSTANCE;
                        }
                    }
                    d dVar = this.$shiply;
                    String str5 = this.$fallbackResource;
                    this.J$0 = currentTimeMillis;
                    this.label = 3;
                    str2 = str;
                    a17 = d.a.a(dVar, str5, null, this, 2, null);
                    if (a17 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    e eVar22 = (e) a17;
                    Logger.i("[qne]QneInterpreterHelper", str2 + this.$resourceId + " with fallback " + this.$fallbackResource + " finish, cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", result:" + eVar22);
                    QneInterpreterHelper.INSTANCE.onDownloadFinish(this.$callbackHandle, g.a(eVar22.a()).getValue(), eVar22.b(), eVar22.d(), eVar22.c());
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                f16 = obj;
            } else {
                ResultKt.throwOnFailure(obj);
                Backend backend = this.$backend;
                d dVar2 = this.$shiply;
                String stringPlus = Intrinsics.stringPlus(QneFoundationHelper.getRootPath(), "/QNE/so");
                this.label = 1;
                f16 = backend.f(dVar2, stringPlus, this);
                if (f16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (!((Boolean) f16).booleanValue()) {
                Logger.i("[qne]QneInterpreterHelper", "prepareDependency for " + this.$backend + " failed");
                QneInterpreterHelper.INSTANCE.onDownloadFinish(this.$callbackHandle, PreloadStatusCode.DownloadOrCheckFail.getValue(), "prepareDependency for " + this.$backend + " failed", null, null);
                return Unit.INSTANCE;
            }
            Logger.i("[qne]QneInterpreterHelper", "shiply loadResource for " + this.$resourceId + ":[preferred:" + ((Object) this.$preferredResource) + ", fallback:" + this.$fallbackResource + "] start");
            currentTimeMillis = System.currentTimeMillis();
            String str6 = this.$preferredResource;
            if (str6 != null) {
                d dVar3 = this.$shiply;
                this.J$0 = currentTimeMillis;
                this.label = 2;
                a16 = d.a.a(dVar3, str6, null, this, 2, null);
                if (a16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                eVar = (e) a16;
                if (eVar == null) {
                }
                d dVar4 = this.$shiply;
                String str52 = this.$fallbackResource;
                this.J$0 = currentTimeMillis;
                this.label = 3;
                str2 = str;
                a17 = d.a.a(dVar4, str52, null, this, 2, null);
                if (a17 == coroutine_suspended) {
                }
                e eVar222 = (e) a17;
                Logger.i("[qne]QneInterpreterHelper", str2 + this.$resourceId + " with fallback " + this.$fallbackResource + " finish, cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", result:" + eVar222);
                QneInterpreterHelper.INSTANCE.onDownloadFinish(this.$callbackHandle, g.a(eVar222.a()).getValue(), eVar222.b(), eVar222.d(), eVar222.c());
                return Unit.INSTANCE;
            }
            eVar = null;
            if (eVar == null) {
            }
            d dVar42 = this.$shiply;
            String str522 = this.$fallbackResource;
            this.J$0 = currentTimeMillis;
            this.label = 3;
            str2 = str;
            a17 = d.a.a(dVar42, str522, null, this, 2, null);
            if (a17 == coroutine_suspended) {
            }
            e eVar2222 = (e) a17;
            Logger.i("[qne]QneInterpreterHelper", str2 + this.$resourceId + " with fallback " + this.$fallbackResource + " finish, cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", result:" + eVar2222);
            QneInterpreterHelper.INSTANCE.onDownloadFinish(this.$callbackHandle, g.a(eVar2222.a()).getValue(), eVar2222.b(), eVar2222.d(), eVar2222.c());
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((QneInterpreterHelper$downloadShiplyResource$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
