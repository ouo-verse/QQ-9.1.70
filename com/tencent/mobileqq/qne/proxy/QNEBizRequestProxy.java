package com.tencent.mobileqq.qne.proxy;

import com.tencent.mobileqq.opr.model.RequestParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qne.utils.network.d;
import com.tencent.mobileqq.qne.utils.network.e;
import com.tencent.mobileqq.qne.utils.network.f;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xc2.c;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qne/proxy/QNEBizRequestProxy;", "Lxc2/c;", "Lcom/tencent/mobileqq/opr/model/RequestParam;", "param", "", "e", "(Lcom/tencent/mobileqq/opr/model/RequestParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "b", "<init>", "()V", "qne-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QNEBizRequestProxy implements c {
    static IPatchRedirector $redirector_;

    public QNEBizRequestProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(RequestParam requestParam, Continuation<? super byte[]> continuation) {
        QNEBizRequestProxy$requestCmdByOidb$1 qNEBizRequestProxy$requestCmdByOidb$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof QNEBizRequestProxy$requestCmdByOidb$1) {
            qNEBizRequestProxy$requestCmdByOidb$1 = (QNEBizRequestProxy$requestCmdByOidb$1) continuation;
            int i16 = qNEBizRequestProxy$requestCmdByOidb$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qNEBizRequestProxy$requestCmdByOidb$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qNEBizRequestProxy$requestCmdByOidb$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qNEBizRequestProxy$requestCmdByOidb$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.mobileqq.qne.utils.network.b bVar = com.tencent.mobileqq.qne.utils.network.b.f262083a;
                    com.tencent.mobileqq.qne.utils.network.c cVar = new com.tencent.mobileqq.qne.utils.network.c(requestParam.getOidbCmdId(), requestParam.getOidbServiceType(), requestParam.getCmd(), requestParam.getReq());
                    qNEBizRequestProxy$requestCmdByOidb$1.label = 1;
                    obj = bVar.a(cVar, qNEBizRequestProxy$requestCmdByOidb$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Object a16 = ((f) obj).a();
                Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type kotlin.ByteArray");
                return (byte[]) a16;
            }
        }
        qNEBizRequestProxy$requestCmdByOidb$1 = new QNEBizRequestProxy$requestCmdByOidb$1(this, continuation);
        Object obj2 = qNEBizRequestProxy$requestCmdByOidb$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qNEBizRequestProxy$requestCmdByOidb$1.label;
        if (i3 == 0) {
        }
        Object a162 = ((f) obj2).a();
        Intrinsics.checkNotNull(a162, "null cannot be cast to non-null type kotlin.ByteArray");
        return (byte[]) a162;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(RequestParam requestParam, Continuation<? super byte[]> continuation) {
        QNEBizRequestProxy$requestCmdBySSO$1 qNEBizRequestProxy$requestCmdBySSO$1;
        Object coroutine_suspended;
        int i3;
        Object a16;
        if (continuation instanceof QNEBizRequestProxy$requestCmdBySSO$1) {
            qNEBizRequestProxy$requestCmdBySSO$1 = (QNEBizRequestProxy$requestCmdBySSO$1) continuation;
            int i16 = qNEBizRequestProxy$requestCmdBySSO$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qNEBizRequestProxy$requestCmdBySSO$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qNEBizRequestProxy$requestCmdBySSO$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qNEBizRequestProxy$requestCmdBySSO$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    d dVar = d.f262087a;
                    e eVar = new e(requestParam.getCmd(), requestParam.getReq());
                    qNEBizRequestProxy$requestCmdBySSO$1.label = 1;
                    obj = dVar.a(eVar, qNEBizRequestProxy$requestCmdBySSO$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                a16 = ((f) obj).a();
                if (!(a16 instanceof byte[])) {
                    return (byte[]) a16;
                }
                return null;
            }
        }
        qNEBizRequestProxy$requestCmdBySSO$1 = new QNEBizRequestProxy$requestCmdBySSO$1(this, continuation);
        Object obj2 = qNEBizRequestProxy$requestCmdBySSO$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qNEBizRequestProxy$requestCmdBySSO$1.label;
        if (i3 == 0) {
        }
        a16 = ((f) obj2).a();
        if (!(a16 instanceof byte[])) {
        }
    }

    @Override // xc2.c
    @Deprecated(message = "\u4f7f\u7528requestCmd\u901a\u7528\u901a\u9053")
    public void a(@NotNull String str, @NotNull String str2, @NotNull Function1<? super String, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, function1);
        } else {
            c.a.a(this, str, str2, function1);
        }
    }

    @Override // xc2.c
    @Nullable
    public Object b(@NotNull RequestParam requestParam, @NotNull Continuation<? super byte[]> continuation) {
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) requestParam, (Object) continuation);
        }
        if (requestParam.getOidbCmdId() > 0) {
            Object e16 = e(requestParam, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (e16 == coroutine_suspended) {
                return e16;
            }
            return (byte[]) e16;
        }
        return f(requestParam, continuation);
    }
}
