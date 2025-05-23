package com.qwallet.localphone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qwallet.api.IQWalletServletApi;
import com.tencent.mobileqq.qwallet.pb.QWalletLocalPhone$GetMobileGWPhoneReq;
import com.tencent.mobileqq.qwallet.pb.QWalletLocalPhone$GetMobileGWPhoneRsp;
import com.tencent.mobileqq.qwallet.pb.QWalletLocalPhone$GetSessionIDReq;
import com.tencent.mobileqq.qwallet.pb.QWalletLocalPhone$GetSessionIDRsp;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;
import tl.h;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ9\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016Jq\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052O\u0010 \u001aK\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00140\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/qwallet/localphone/QWalletLocalPhoneModule;", "", "", "appId", "Lcom/qwallet/localphone/QWalletLocalPhoneModule$a;", "", "g", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessionId", "f", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BaseConstants.ATTR_KET_PHONE_TOKEN, "signStr", "Lcom/tencent/mobileqq/qwallet/pb/QWalletLocalPhone$GetMobileGWPhoneRsp;", "e", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lkotlinx/coroutines/CancellableContinuation;", "value", "tag", "", h.F, "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;Ljava/lang/String;)V", "sign", "sessionIdFromOut", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "errorCode", "rsp", "errMsg", "callback", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "i", "<init>", "()V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class QWalletLocalPhoneModule {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QWalletLocalPhoneModule f41592a = new QWalletLocalPhoneModule();

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0004\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/qwallet/localphone/QWalletLocalPhoneModule$a;", "T", "", "", "a", "I", "c", "()I", "setRet", "(I)V", "ret", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "data", "", "Ljava/lang/String;", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "errorMsg", "<init>", "(ILjava/lang/Object;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int ret;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private T data;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String errorMsg;

        public a(int i3, @Nullable T t16, @Nullable String str) {
            this.ret = i3;
            this.data = t16;
            this.errorMsg = str;
        }

        @Nullable
        public final T a() {
            return this.data;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        /* renamed from: c, reason: from getter */
        public final int getRet() {
            return this.ret;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/qwallet/localphone/QWalletLocalPhoneModule$b", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/QWalletLocalPhone$GetMobileGWPhoneRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b implements o<QWalletLocalPhone$GetMobileGWPhoneRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<a<QWalletLocalPhone$GetMobileGWPhoneRsp>> f41596a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super a<QWalletLocalPhone$GetMobileGWPhoneRsp>> cancellableContinuation) {
            this.f41596a = cancellableContinuation;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull QWalletLocalPhone$GetMobileGWPhoneRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QWalletLocalPhoneModule.f41592a.h(this.f41596a, new a(0, rsp, null), "get local phone");
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QWalletLocalPhoneModule.f41592a.h(this.f41596a, new a(errCode, null, errMsg), "get local phone");
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/qwallet/localphone/QWalletLocalPhoneModule$c", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/QWalletLocalPhone$GetSessionIDRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class c implements o<QWalletLocalPhone$GetSessionIDRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<a<String>> f41597a;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super a<String>> cancellableContinuation) {
            this.f41597a = cancellableContinuation;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull QWalletLocalPhone$GetSessionIDRsp rsp) {
            boolean z16;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            String str = rsp.session_id.get();
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QWalletLocalPhoneModule.f41592a.h(this.f41597a, new a(-1, null, "getSessionID session is null"), "get sessionId");
            } else {
                QWalletLocalPhoneModule.f41592a.h(this.f41597a, new a(0, str, null), "get sessionId");
            }
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QWalletLocalPhoneModule.f41592a.h(this.f41597a, new a(errCode, null, errMsg), "get sessionId");
        }
    }

    QWalletLocalPhoneModule() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e(long j3, String str, String str2, String str3, Continuation<? super a<QWalletLocalPhone$GetMobileGWPhoneRsp>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QWalletLocalPhone$GetMobileGWPhoneReq qWalletLocalPhone$GetMobileGWPhoneReq = new QWalletLocalPhone$GetMobileGWPhoneReq();
        qWalletLocalPhone$GetMobileGWPhoneReq.appid.set(j3);
        qWalletLocalPhone$GetMobileGWPhoneReq.session_id.set(str);
        qWalletLocalPhone$GetMobileGWPhoneReq.phone_token.set(str2);
        qWalletLocalPhone$GetMobileGWPhoneReq.sign.set(str3);
        QRouteApi api = QRoute.api(IQWalletServletApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQWalletServletApi::class.java)");
        IQWalletServletApi.a.a((IQWalletServletApi) api, "trpc.qwallet.phonesdk.MobilegwPhone", "GetMaskPhone", qWalletLocalPhone$GetMobileGWPhoneReq, (MessageMicro) QWalletLocalPhone$GetMobileGWPhoneRsp.class.newInstance(), false, true, false, new b(cancellableContinuationImpl), 80, null);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(String str, Continuation<? super a<String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new QWalletLocalPhoneModule$getPhoneToken$2(str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(long j3, Continuation<? super a<String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QRouteApi api = QRoute.api(IQWalletServletApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQWalletServletApi::class.java)");
        IQWalletServletApi iQWalletServletApi = (IQWalletServletApi) api;
        QWalletLocalPhone$GetSessionIDReq qWalletLocalPhone$GetSessionIDReq = new QWalletLocalPhone$GetSessionIDReq();
        qWalletLocalPhone$GetSessionIDReq.appid.set(j3);
        Unit unit = Unit.INSTANCE;
        IQWalletServletApi.a.a(iQWalletServletApi, "trpc.qwallet.phonesdk.MobilegwPhone", "GetSessionID", qWalletLocalPhone$GetSessionIDReq, (MessageMicro) QWalletLocalPhone$GetSessionIDRsp.class.newInstance(), false, true, false, new c(cancellableContinuationImpl), 80, null);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void h(CancellableContinuation<? super T> cancellableContinuation, T t16, String str) {
        if (cancellableContinuation.isActive()) {
            cancellableContinuation.resumeWith(Result.m476constructorimpl(t16));
            return;
        }
        QLog.i("QWalletLocalPhoneModule", 1, str + " cancel");
    }

    @Nullable
    public final com.tencent.mobileqq.qcoroutine.api.coroutine.b i(long appId, @NotNull String sign, @NotNull String sessionIdFromOut, @NotNull Function3<? super Integer, ? super QWalletLocalPhone$GetMobileGWPhoneRsp, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(sign, "sign");
        Intrinsics.checkNotNullParameter(sessionIdFromOut, "sessionIdFromOut");
        Intrinsics.checkNotNullParameter(callback, "callback");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            return CorountineFunKt.e(f16, "QWalletLocalPhoneModule", null, null, Boolean.TRUE, new QWalletLocalPhoneModule$startGetPhone$1(sessionIdFromOut, callback, appId, sign, null), 6, null);
        }
        return null;
    }
}
