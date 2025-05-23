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

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J-\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0016J\u001b\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0016J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u0016J\u001b\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u0016J#\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/j;", "", "", "service", "method", "", "reqData", "Ltd3/a;", "observer", "", "a", "Lbv4/b;", "avatar", "Lbv4/c;", "detail", "Lbv4/e;", "outfit", "c", "(Lbv4/b;Lbv4/c;Lbv4/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "feedId", "", "d", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lbv4/a;", "g", "feedId_", "e", tl.h.F, "b", "reason_", "f", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f335411a = new j();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/j$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Long> f335412a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super Long> continuation) {
            this.f335412a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            Continuation<Long> continuation = this.f335412a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            QLog.e("ZplanOutfitRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            t45.b bVar;
            try {
                bVar = t45.b.c(data);
            } catch (Exception e16) {
                QLog.e("ZplanOutfitRequest", 1, "requestAddGetDressedCount failed.", e16);
                bVar = null;
            }
            if (bVar == null) {
                Continuation<Long> continuation = this.f335412a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("AddGetDressedCountRsp onReceive, rsp null."))));
            } else {
                QLog.i("ZplanOutfitRequest", 1, "requestAddGetDressedCount succeed");
                Continuation<Long> continuation2 = this.f335412a;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(Long.valueOf(bVar.f435398c)));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/j$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<String> f335413a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super String> continuation) {
            this.f335413a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            Continuation<String> continuation = this.f335413a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            QLog.e("ZplanOutfitRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            t45.d dVar;
            try {
                dVar = t45.d.c(data);
            } catch (Exception e16) {
                QLog.e("ZplanOutfitRequest", 1, "requestCreateOutfit failed.", e16);
                dVar = null;
            }
            if (dVar == null) {
                Continuation<String> continuation = this.f335413a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("CreateFeedRsp onReceive, rsp null."))));
            } else {
                QLog.i("ZplanOutfitRequest", 1, "requestCreateOutfit succeed");
                Continuation<String> continuation2 = this.f335413a;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(dVar.f435404c));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/j$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Long> f335414a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super Long> continuation) {
            this.f335414a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            Continuation<Long> continuation = this.f335414a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            QLog.e("ZplanOutfitRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            t45.f fVar;
            try {
                fVar = t45.f.c(data);
            } catch (Exception e16) {
                QLog.e("ZplanOutfitRequest", 1, "requestDeleteFeed failed.", e16);
                fVar = null;
            }
            if (fVar == null) {
                Continuation<Long> continuation = this.f335414a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("CreateFeedRsp onReceive, rsp null."))));
            } else {
                QLog.i("ZplanOutfitRequest", 1, "requestCreateOutfit succeed");
                Continuation<Long> continuation2 = this.f335414a;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(Long.valueOf(fVar.f435406a)));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/j$d", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Long> f335415a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Continuation<? super Long> continuation) {
            this.f335415a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            Continuation<Long> continuation = this.f335415a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            QLog.e("ZplanOutfitRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            t45.j jVar;
            try {
                jVar = t45.j.c(data);
            } catch (Exception e16) {
                QLog.e("ZplanOutfitRequest", 1, "requestDoFeedLike failed.", e16);
                jVar = null;
            }
            if (jVar == null) {
                Continuation<Long> continuation = this.f335415a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("LikeFeedRsp onReceive, rsp null."))));
            } else {
                QLog.i("ZplanOutfitRequest", 1, "requestDoFeedLike succeed");
                Continuation<Long> continuation2 = this.f335415a;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(Long.valueOf(jVar.f435413c)));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/j$e", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<String> f335416a;

        /* JADX WARN: Multi-variable type inference failed */
        e(Continuation<? super String> continuation) {
            this.f335416a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            Continuation<String> continuation = this.f335416a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            QLog.e("ZplanOutfitRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            t45.l lVar;
            try {
                lVar = t45.l.c(data);
            } catch (Exception e16) {
                QLog.e("ZplanOutfitRequest", 1, "requestReportFeedViolation failed.", e16);
                lVar = null;
            }
            if (lVar == null) {
                Continuation<String> continuation = this.f335416a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("ReportFeedViolationRsp onReceive, rsp null."))));
            } else {
                QLog.i("ZplanOutfitRequest", 1, "requestReportFeedViolation succeed");
                Continuation<String> continuation2 = this.f335416a;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(lVar.f435417b));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/j$f", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<bv4.a> f335417a;

        /* JADX WARN: Multi-variable type inference failed */
        f(Continuation<? super bv4.a> continuation) {
            this.f335417a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZplanOutfitRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
            Continuation<bv4.a> continuation = this.f335417a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(String.valueOf(errCode)))));
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            t45.h hVar;
            QLog.i("ZplanOutfitRequest", 1, "onReceive:");
            try {
                hVar = t45.h.c(data);
            } catch (Exception e16) {
                QLog.e("ZplanOutfitRequest", 1, "requestSingleFeedInfo failed.", e16.getMessage());
                hVar = null;
            }
            if (hVar == null) {
                Continuation<bv4.a> continuation = this.f335417a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("GetFeedReq onReceive, rsp null."))));
            } else {
                QLog.i("ZplanOutfitRequest", 1, "requestSingleFeedInfo succeed ");
                Continuation<bv4.a> continuation2 = this.f335417a;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(hVar.f435409a));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/j$g", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Long> f335418a;

        /* JADX WARN: Multi-variable type inference failed */
        g(Continuation<? super Long> continuation) {
            this.f335418a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            Continuation<Long> continuation = this.f335418a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            QLog.e("ZplanOutfitRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            t45.n nVar;
            try {
                nVar = t45.n.c(data);
            } catch (Exception e16) {
                QLog.e("ZplanOutfitRequest", 1, "requestDoFeedLike failed.", e16);
                nVar = null;
            }
            if (nVar == null) {
                Continuation<Long> continuation = this.f335418a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("UnlikeFeedRsp onReceive, rsp null."))));
            } else {
                QLog.i("ZplanOutfitRequest", 1, "requestDoFeedLike succeed");
                Continuation<Long> continuation2 = this.f335418a;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(Long.valueOf(nVar.f435421c)));
            }
        }
    }

    j() {
    }

    private final void a(String service, String method, byte[] reqData, td3.a observer) {
        Map emptyMap;
        AppInterface c16 = bb.f335811a.c();
        if (c16 == null) {
            QLog.e("ZplanOutfitRequest", 1, "request failed, appRuntime null.");
            observer.a(-1, "appRuntime null");
            return;
        }
        QLog.i("ZplanOutfitRequest", 1, "doOutfitRequestByZootopiaServlet, service: " + service + ", method: " + method);
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, c16, service, method, reqData, emptyMap, observer, 0, 0, 192, null);
    }

    public final Object b(String str, Continuation<? super Long> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        t45.a aVar = new t45.a();
        aVar.f435395a = str;
        byte[] reqData = MessageNano.toByteArray(aVar);
        a aVar2 = new a(safeContinuation);
        j jVar = f335411a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        jVar.a("trpc.metaverse.outfit_feeds.OutfitFeeds", "AddGetDressedCount", reqData, aVar2);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object c(bv4.b bVar, bv4.c cVar, bv4.e eVar, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QLog.i("ZplanOutfitRequest", 1, "requestCreateOutfit");
        b bVar2 = new b(safeContinuation);
        t45.c cVar2 = new t45.c();
        cVar2.f435399a = cVar;
        cVar2.f435400b = bVar;
        cVar2.f435401c = eVar;
        byte[] reqData = MessageNano.toByteArray(cVar2);
        j jVar = f335411a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        jVar.a("trpc.metaverse.outfit_feeds.OutfitFeeds", "CreateFeed", reqData, bVar2);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object d(String str, Continuation<? super Long> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QLog.i("ZplanOutfitRequest", 1, "requestDeleteFeed." + str);
        c cVar = new c(safeContinuation);
        t45.e eVar = new t45.e();
        eVar.f435405a = str;
        byte[] reqData = MessageNano.toByteArray(eVar);
        j jVar = f335411a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        jVar.a("trpc.metaverse.outfit_feeds.OutfitFeeds", "DeleteFeed", reqData, cVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object e(String str, Continuation<? super Long> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        t45.i iVar = new t45.i();
        iVar.f435410a = str;
        byte[] reqData = MessageNano.toByteArray(iVar);
        d dVar = new d(safeContinuation);
        j jVar = f335411a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        jVar.a("trpc.metaverse.outfit_feeds.OutfitFeeds", "LikeFeed", reqData, dVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object f(String str, String str2, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        t45.k kVar = new t45.k();
        kVar.f435414a = str;
        kVar.f435415b = str2;
        byte[] reqData = MessageNano.toByteArray(kVar);
        e eVar = new e(safeContinuation);
        j jVar = f335411a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        jVar.a("trpc.metaverse.outfit_feeds.OutfitFeeds", "ReportFeedViolation", reqData, eVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object g(String str, Continuation<? super bv4.a> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QLog.i("ZplanOutfitRequest", 1, "requestSingleFeedInfo." + str);
        t45.g gVar = new t45.g();
        gVar.f435408a = str;
        byte[] reqData = MessageNano.toByteArray(gVar);
        f fVar = new f(safeContinuation);
        j jVar = f335411a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        jVar.a("trpc.metaverse.outfit_feeds.OutfitFeeds", "GetFeed", reqData, fVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object h(String str, Continuation<? super Long> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        t45.m mVar = new t45.m();
        mVar.f435418a = str;
        byte[] reqData = MessageNano.toByteArray(mVar);
        g gVar = new g(safeContinuation);
        j jVar = f335411a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        jVar.a("trpc.metaverse.outfit_feeds.OutfitFeeds", "UnlikeFeed", reqData, gVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
