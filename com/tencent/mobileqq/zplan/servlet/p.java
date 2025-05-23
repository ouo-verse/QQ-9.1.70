package com.tencent.mobileqq.zplan.servlet;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import uv4.z;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001b\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/p;", "", "", "service", "method", "", "reqData", "Ltd3/a;", "observer", "", "b", "", "itemId", "Lu55/f;", "e", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lzv4/a;", "ugcItem", "Lu55/b;", "d", "(Lzv4/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Luv4/z;", "req", "Lu55/d;", "c", "(Luv4/z;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/String;", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f335428a = new p();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "ZplanUGCStoreItemRequest";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/p$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<u55.b> f335431a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super u55.b> continuation) {
            this.f335431a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            Continuation<u55.b> continuation = this.f335431a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            QLog.e(p.TAG, 1, "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            u55.b bVar;
            try {
                bVar = u55.b.c(data);
            } catch (Exception e16) {
                QLog.e(p.TAG, 1, "RequestCreateUGCItem failed.", e16);
                bVar = null;
            }
            if (bVar == null) {
                Continuation<u55.b> continuation = this.f335431a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("onReceive, rsp null."))));
            } else {
                QLog.i(p.TAG, 1, "RequestCreateUGCItem succeed");
                this.f335431a.resumeWith(Result.m476constructorimpl(bVar));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/p$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<u55.f> f335432a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super u55.f> continuation) {
            this.f335432a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            Continuation<u55.f> continuation = this.f335432a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            QLog.e(p.TAG, 1, "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            u55.f fVar;
            try {
                fVar = u55.f.c(data);
            } catch (Exception e16) {
                QLog.e(p.TAG, 1, "RequestPreCreateUGCItem failed.", e16);
                fVar = null;
            }
            if (fVar != null) {
                QLog.i(p.TAG, 1, "RequestPreCreateUGCItem succeed, rsp: " + fVar);
                this.f335432a.resumeWith(Result.m476constructorimpl(fVar));
                return;
            }
            Continuation<u55.f> continuation = this.f335432a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("onReceive, rsp null."))));
        }
    }

    p() {
    }

    private final void b(String service, String method, byte[] reqData, td3.a observer) {
        Map emptyMap;
        AppInterface c16 = bb.f335811a.c();
        if (c16 == null) {
            QLog.e(TAG, 1, "request failed, appRuntime null.");
            observer.a(-1, "appRuntime null");
            return;
        }
        QLog.i(TAG, 1, "doOutfitRequestByZootopiaServlet, service: " + service + ", method: " + method);
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, c16, service, method, reqData, emptyMap, observer, 0, 0, 192, null);
    }

    public final Object c(z zVar, Continuation<? super u55.d> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QLog.i(TAG, 1, "RequestBagUGCStoreItems begin");
        u55.c cVar = new u55.c();
        cVar.f438448a = 1;
        cVar.f438449b = zVar;
        byte[] reqData = MessageNano.toByteArray(cVar);
        a aVar = new a(safeContinuation);
        p pVar = f335428a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        pVar.b("trpc.metaverse.ugc_item.UGCItem", "GetBagUGCStoreItem", reqData, aVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object d(zv4.a aVar, Continuation<? super u55.b> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        u55.a aVar2 = new u55.a();
        aVar2.f438444a = 4;
        aVar2.f438445b = aVar;
        byte[] reqData = MessageNano.toByteArray(aVar2);
        b bVar = new b(safeContinuation);
        p pVar = f335428a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        pVar.b("trpc.metaverse.ugc_item.UGCItem", "CreateUGCItem", reqData, bVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object e(long j3, Continuation<? super u55.f> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        u55.e eVar = new u55.e();
        eVar.f438454a = 4;
        eVar.f438455b = j3;
        byte[] reqData = MessageNano.toByteArray(eVar);
        c cVar = new c(safeContinuation);
        p pVar = f335428a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        pVar.b("trpc.metaverse.ugc_item.UGCItem", "PreCreateUGCItem", reqData, cVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/p$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<u55.d> f335430a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super u55.d> continuation) {
            this.f335430a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            Continuation<u55.d> continuation = this.f335430a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            QLog.e(p.TAG, 1, "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            u55.d dVar;
            try {
                dVar = u55.d.c(data);
            } catch (Exception e16) {
                QLog.e(p.TAG, 1, "RequestBagUGCStoreItems failed.", e16);
                dVar = null;
            }
            if (dVar != null) {
                String str = p.TAG;
                zv4.c[] cVarArr = dVar.f438450a;
                QLog.i(str, 1, "RequestBagUGCStoreItems succeed, rsp.items.size: " + (cVarArr != null ? Integer.valueOf(cVarArr.length) : null));
                this.f335430a.resumeWith(Result.m476constructorimpl(dVar));
                return;
            }
            Continuation<u55.d> continuation = this.f335430a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("onReceive, rsp null."))));
        }
    }
}
