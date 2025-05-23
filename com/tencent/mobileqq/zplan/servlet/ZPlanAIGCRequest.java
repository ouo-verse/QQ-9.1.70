package com.tencent.mobileqq.zplan.servlet;

import android.text.TextUtils;
import com.epicgames.ue4.ZPlanVersion;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.mobileqq.zplan.aigc.data.AIGCTemplateInfo;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import sg3.ZPlanCosUGCAvatarKeyInfo;
import sg3.ZplanCreateAIGCResponseInfo;
import uv4.ab;
import uv4.ac;
import uv4.bn;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bP\u0010QJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001b\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0010J\u001b\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u000eJ\u001b\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u000eJ\u001b\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010\u000eJ/\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010\u0019\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u0004\u0018\u00010&H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u0010JC\u0010/\u001a\u0004\u0018\u00010.2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u00100JG\u00106\u001a\u0004\u0018\u0001052\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00022\b\b\u0002\u00104\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u00107J-\u0010;\u001a\u00020:2\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b;\u0010<J\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0=JA\u0010F\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010GJ,\u0010I\u001a\b\u0012\u0004\u0012\u00020E0=2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u0002R\"\u0010O\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/ZPlanAIGCRequest;", "", "", "service", "method", "", "reqData", "Ltd3/a;", "observer", "", "b", "", "buyCount", "f", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", DomainData.DOMAIN_NAME, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", WadlProxyConsts.SCENE_ID, "e", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "ugcId_", "r", "i", "eTag", "Liu4/h;", "j", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ugcId", "Liu4/b;", "o", "gender", "", "dontNeedUgcid", "Lcom/tencent/mobileqq/zplan/aigc/data/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(IZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/zplan/aigc/data/a;", "d", "", "Lyv4/a;", "fileHeaders", "itemId", "name", "desc", "Lsg3/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "([Lyv4/a;JJLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUpload", "isOfficial", "prompt", "shareType", "Lsg3/b;", tl.h.F, "(JZZLjava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "index", "count", "Lu45/l;", "k", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Deferred;", "Lyv4/e;", "p", "reqStartIndex", "imageryId", "imageryDescription", "batchSize", "", "Lu45/h;", "a", "(JIILjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reqIndex", "l", "Z", "c", "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "firstEnter", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanAIGCRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanAIGCRequest f335341a = new ZPlanAIGCRequest();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean firstEnter = true;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanAIGCRequest$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<com.tencent.mobileqq.zplan.aigc.data.a> f335343a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super com.tencent.mobileqq.zplan.aigc.data.a> continuation) {
            this.f335343a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZPlanAIGCRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
            this.f335343a.resumeWith(Result.m476constructorimpl(null));
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            ju4.f fVar;
            try {
                fVar = ju4.f.c(data);
            } catch (Exception e16) {
                QLog.e("ZPlanAIGCRequest", 1, "requestAIGCShoppingBagInfo failed.", e16);
                fVar = null;
            }
            if (fVar == null) {
                QLog.e("ZPlanAIGCRequest", 1, "requestAIGCShoppingBagInfo failed, onReceive rsp null.");
                this.f335343a.resumeWith(Result.m476constructorimpl(null));
                return;
            }
            String str = fVar.f410983a;
            Intrinsics.checkNotNullExpressionValue(str, "rsp.iconUrl");
            String str2 = fVar.f410984b;
            Intrinsics.checkNotNullExpressionValue(str2, "rsp.name");
            com.tencent.mobileqq.zplan.aigc.data.a aVar = new com.tencent.mobileqq.zplan.aigc.data.a(str, str2, fVar.f410985c, fVar.f410986d, fVar.f410987e);
            QLog.i("ZPlanAIGCRequest", 1, "requestAIGCShoppingBagInfo succeed, bagInfo: " + aVar);
            this.f335343a.resumeWith(Result.m476constructorimpl(aVar));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanAIGCRequest$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Integer> f335344a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super Integer> continuation) {
            this.f335344a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZPlanAIGCRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
            Continuation<Integer> continuation = this.f335344a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            u45.f fVar;
            try {
                fVar = u45.f.c(data);
            } catch (Exception e16) {
                QLog.e("ZPlanAIGCRequest", 1, "requestAdPlayQualification parse rsp failed.", e16);
                fVar = null;
            }
            if (fVar == null) {
                Continuation<Integer> continuation = this.f335344a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("onReceive, rsp null."))));
                return;
            }
            QLog.i("ZPlanAIGCRequest", 1, "requestAdPlayQualification succeed, playQualification: " + fVar.f438227a);
            Continuation<Integer> continuation2 = this.f335344a;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(Integer.valueOf(fVar.f438227a)));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanAIGCRequest$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Long> f335345a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super Long> continuation) {
            this.f335345a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            Continuation<Long> continuation = this.f335345a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            QLog.e("ZPlanAIGCRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            ju4.b bVar;
            try {
                bVar = ju4.b.c(data);
            } catch (Exception e16) {
                QLog.e("ZPlanAIGCRequest", 1, "requestBuyAIGCCoupon failed.", e16);
                bVar = null;
            }
            if (bVar == null) {
                Continuation<Long> continuation = this.f335345a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("onReceive, rsp null."))));
                return;
            }
            QLog.i("ZPlanAIGCRequest", 1, "requestBuyAIGCCoupon succeed, rsp.retCode: " + bVar.f410980a + ", totalCount: " + bVar.f410981b);
            Continuation<Long> continuation2 = this.f335345a;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(Long.valueOf(bVar.f410981b)));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanAIGCRequest$d", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<String> f335346a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Continuation<? super String> continuation) {
            this.f335346a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            Continuation<String> continuation = this.f335346a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            QLog.e("ZPlanAIGCRequest", 1, "requestChannelSig errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            iu4.d dVar;
            try {
                dVar = iu4.d.c(data);
            } catch (Exception e16) {
                QLog.e("ZPlanAIGCRequest", 1, "requestChannelSig failed.", e16);
                dVar = null;
            }
            if (dVar == null) {
                Continuation<String> continuation = this.f335346a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("requestChannelSig onReceive, rsp null."))));
                return;
            }
            QLog.i("ZPlanAIGCRequest", 1, "requestChannelSig succeed, rsp.signature: " + dVar.f408774a + ",");
            Continuation<String> continuation2 = this.f335346a;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(dVar.f408774a));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanAIGCRequest$e", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<ZplanCreateAIGCResponseInfo> f335347d;

        /* JADX WARN: Multi-variable type inference failed */
        e(Continuation<? super ZplanCreateAIGCResponseInfo> continuation) {
            this.f335347d = continuation;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            yv4.c cVar;
            t55.c cVar2;
            QLog.w("ZPlanAIGCRequest", 1, "requestCreateAIGC onUpdate, type " + type + ", success: " + isSuccess);
            Integer num = null;
            try {
                cVar = yv4.c.c(data instanceof byte[] ? (byte[]) data : null);
            } catch (Exception e16) {
                QLog.e("ZPlanAIGCRequest", 1, "requestCreateAIGC failed.", e16);
                cVar = null;
            }
            if (cVar != null && (cVar2 = cVar.f451329a) != null) {
                num = Integer.valueOf(cVar2.f435455a);
            }
            if (isSuccess && num != null && num.intValue() == 0) {
                Intrinsics.checkNotNull(cVar);
                ZplanCreateAIGCResponseInfo zplanCreateAIGCResponseInfo = new ZplanCreateAIGCResponseInfo(cVar.f451330b, true);
                QLog.i("ZPlanAIGCRequest", 1, "requestCreateAIGC succeed.");
                this.f335347d.resumeWith(Result.m476constructorimpl(zplanCreateAIGCResponseInfo));
                return;
            }
            Continuation<ZplanCreateAIGCResponseInfo> continuation = this.f335347d;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("requestCreateAIGC failed, rspCode: " + num))));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanAIGCRequest$f", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Long> f335348a;

        /* JADX WARN: Multi-variable type inference failed */
        f(Continuation<? super Long> continuation) {
            this.f335348a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            Continuation<Long> continuation = this.f335348a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            QLog.e("ZPlanAIGCRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            iu4.k kVar;
            try {
                kVar = iu4.k.c(data);
            } catch (Exception e16) {
                QLog.e("ZPlanAIGCRequest", 1, "requesDoFeedLike failed.", e16);
                kVar = null;
            }
            if (kVar == null) {
                Continuation<Long> continuation = this.f335348a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("onReceive, rsp null."))));
            } else {
                QLog.i("ZPlanAIGCRequest", 1, "requesDoFeedLike succeed");
                Continuation<Long> continuation2 = this.f335348a;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(Long.valueOf(kVar.f408787a)));
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanAIGCRequest$g", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<iu4.h> f335349a;

        /* JADX WARN: Multi-variable type inference failed */
        g(Continuation<? super iu4.h> continuation) {
            this.f335349a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            Continuation<iu4.h> continuation = this.f335349a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            QLog.e("ZPlanAIGCRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            iu4.h hVar;
            try {
                hVar = iu4.h.c(data);
            } catch (Exception e16) {
                QLog.e("ZPlanAIGCRequest", 1, "requestFeedItems failed.", e16);
                hVar = null;
            }
            if (hVar == null) {
                Continuation<iu4.h> continuation = this.f335349a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("onReceive, rsp null."))));
                return;
            }
            iu4.b[] bVarArr = hVar.f408781b;
            Integer valueOf = bVarArr != null ? Integer.valueOf(bVarArr.length) : null;
            QLog.i("ZPlanAIGCRequest", 1, "requestFeedItems succeed, rsp.feeds.size: " + valueOf + ", etag: " + hVar.f408780a + "}");
            this.f335349a.resumeWith(Result.m476constructorimpl(hVar));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanAIGCRequest$h", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class h implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CompletableDeferred<u45.h> f335350a;

        h(CompletableDeferred<u45.h> completableDeferred) {
            this.f335350a = completableDeferred;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZPlanAIGCRequest", 1, "requestImageryRecommendPics errCode: " + errCode + ", errMsg: " + errMsg);
            this.f335350a.completeExceptionally(new Exception("onReceive, rsp null."));
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            u45.h hVar;
            String joinToString$default;
            try {
                hVar = u45.h.c(data);
            } catch (Exception e16) {
                QLog.e("ZPlanAIGCRequest", 1, "requestImageryDetails failed.", e16);
                hVar = null;
            }
            if (hVar == null) {
                this.f335350a.completeExceptionally(new Exception("onReceive, rsp null."));
                return;
            }
            String[] strArr = hVar.f438235a;
            Intrinsics.checkNotNullExpressionValue(strArr, "rsp.picUrls");
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(strArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
            QLog.i("ZPlanAIGCRequest", 1, "requestImageryRecommendPics succeed, imagerys size: " + joinToString$default);
            this.f335350a.complete(hVar);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanAIGCRequest$i", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class i implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<ZPlanCosUGCAvatarKeyInfo> f335351d;

        /* JADX WARN: Multi-variable type inference failed */
        i(Continuation<? super ZPlanCosUGCAvatarKeyInfo> continuation) {
            this.f335351d = continuation;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            yv4.g gVar;
            t55.c cVar;
            QLog.w("ZPlanAIGCRequest", 1, "requestPreCreateAIGC onUpdate, type " + type + ", success: " + isSuccess);
            String str = "";
            if (!isSuccess) {
                Continuation<ZPlanCosUGCAvatarKeyInfo> continuation = this.f335351d;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(""))));
                return;
            }
            try {
                gVar = yv4.g.c(data instanceof byte[] ? (byte[]) data : null);
            } catch (Exception e16) {
                QLog.e("ZPlanAIGCRequest", 1, "requestPreCreateAIGC failed.", e16);
                gVar = null;
            }
            Integer valueOf = (gVar == null || (cVar = gVar.f451341a) == null) ? null : Integer.valueOf(cVar.f435455a);
            if (valueOf == null || valueOf.intValue() != 0) {
                if (valueOf != null && (valueOf.intValue() == 26070 || valueOf.intValue() == 26071 || valueOf.intValue() == 26072)) {
                    if (valueOf.intValue() == 26072) {
                        str = "\u5b89\u5168\u56de\u8c03\u8d85\u65f6";
                    } else {
                        t55.c cVar2 = gVar.f451341a;
                        String str2 = cVar2 != null ? cVar2.f435456b : null;
                        if (str2 != null) {
                            str = str2;
                        }
                    }
                }
                QLog.e("ZPlanAIGCRequest", 1, "requestPreCreateAIGC failed, errorCode: " + valueOf);
                Continuation<ZPlanCosUGCAvatarKeyInfo> continuation2 = this.f335351d;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("aigcPreCreateErrToastMsg:" + str))));
                return;
            }
            if ((gVar != null ? gVar.f451342b : null) == null) {
                QLog.e("ZPlanAIGCRequest", 1, "requestPreCreateAIGC failed, onReceive rsp null.");
                Continuation<ZPlanCosUGCAvatarKeyInfo> continuation3 = this.f335351d;
                Result.Companion companion3 = Result.INSTANCE;
                continuation3.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(""))));
                return;
            }
            String str3 = gVar.f451342b.f451324a;
            Intrinsics.checkNotNullExpressionValue(str3, "rsp.keyInfo.secretId");
            String[] strArr = gVar.f451342b.f451325b;
            Intrinsics.checkNotNullExpressionValue(strArr, "rsp.keyInfo.signature");
            yv4.b bVar = gVar.f451342b;
            long j3 = bVar.f451326c;
            long j16 = bVar.f451327d;
            String str4 = bVar.f451328e;
            Intrinsics.checkNotNullExpressionValue(str4, "rsp.keyInfo.token");
            String str5 = gVar.f451343c;
            Intrinsics.checkNotNullExpressionValue(str5, "rsp.dir");
            ZPlanCosUGCAvatarKeyInfo zPlanCosUGCAvatarKeyInfo = new ZPlanCosUGCAvatarKeyInfo(str3, strArr, j3, j16, str4, str5);
            QLog.i("ZPlanAIGCRequest", 1, "requestPreCreateAIGC succeed.");
            this.f335351d.resumeWith(Result.m476constructorimpl(zPlanCosUGCAvatarKeyInfo));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanAIGCRequest$j", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class j implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Long> f335352a;

        /* JADX WARN: Multi-variable type inference failed */
        j(Continuation<? super Long> continuation) {
            this.f335352a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZPlanAIGCRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
            Continuation<Long> continuation = this.f335352a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            ju4.d dVar;
            try {
                dVar = ju4.d.c(data);
            } catch (Exception e16) {
                QLog.e("ZPlanAIGCRequest", 1, "requestQueryAIGCCoupon failed.", e16);
                dVar = null;
            }
            if (dVar == null) {
                Continuation<Long> continuation = this.f335352a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("onReceive, rsp null."))));
                return;
            }
            QLog.i("ZPlanAIGCRequest", 1, "requestQueryAIGCCoupon succeed, totalCount: " + dVar.f410982a);
            Continuation<Long> continuation2 = this.f335352a;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(Long.valueOf(dVar.f410982a)));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanAIGCRequest$k", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class k implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<iu4.b> f335353a;

        /* JADX WARN: Multi-variable type inference failed */
        k(Continuation<? super iu4.b> continuation) {
            this.f335353a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZPlanAIGCRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
            Continuation<iu4.b> continuation = this.f335353a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            iu4.f fVar;
            QLog.i("ZPlanAIGCRequest", 1, "onReceive:");
            try {
                fVar = iu4.f.c(data);
            } catch (Exception e16) {
                QLog.e("ZPlanAIGCRequest", 1, "requestSingleFeedInfo failed.", e16.getMessage());
                fVar = null;
            }
            if (fVar == null) {
                Continuation<iu4.b> continuation = this.f335353a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("onReceive, rsp null."))));
                return;
            }
            QLog.i("ZPlanAIGCRequest", 1, "requestSingleFeedInfo succeed, totalCount: " + fVar.f408778a);
            Continuation<iu4.b> continuation2 = this.f335353a;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(fVar.f408778a));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanAIGCRequest$l", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class l implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CompletableDeferred<yv4.e> f335354a;

        l(CompletableDeferred<yv4.e> completableDeferred) {
            this.f335354a = completableDeferred;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZPlanAIGCRequest", 1, "requestUGCIDAsync errCode: " + errCode + ", errMsg: " + errMsg);
            this.f335354a.completeExceptionally(new Exception("onReceive, rsp null."));
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            yv4.e eVar;
            try {
                eVar = yv4.e.c(data);
            } catch (Exception e16) {
                QLog.e("ZPlanAIGCRequest", 1, "requestUGCIDAsync failed.", e16);
                eVar = null;
            }
            if (eVar == null) {
                this.f335354a.completeExceptionally(new Exception("onReceive, rsp null."));
                return;
            }
            QLog.i("ZPlanAIGCRequest", 1, "requestUGCIDAsync succeed, imagerys size: " + eVar.f451340a);
            this.f335354a.complete(eVar);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanAIGCRequest$m", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class m implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Long> f335355a;

        /* JADX WARN: Multi-variable type inference failed */
        m(Continuation<? super Long> continuation) {
            this.f335355a = continuation;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            Continuation<Long> continuation = this.f335355a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            QLog.e("ZPlanAIGCRequest", 1, "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            iu4.l lVar;
            try {
                lVar = iu4.l.c(data);
            } catch (Exception e16) {
                QLog.e("ZPlanAIGCRequest", 1, "requesDoFeedLike failed.", e16);
                lVar = null;
            }
            if (lVar == null) {
                Continuation<Long> continuation = this.f335355a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("onReceive, rsp null."))));
            } else {
                QLog.i("ZPlanAIGCRequest", 1, "requesDoFeedLike succeed");
                Continuation<Long> continuation2 = this.f335355a;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(Long.valueOf(lVar.f408789a)));
            }
        }
    }

    ZPlanAIGCRequest() {
    }

    private final void b(String service, String method, byte[] reqData, td3.a observer) {
        Map emptyMap;
        AppInterface c16 = bb.f335811a.c();
        if (c16 == null) {
            QLog.e("ZPlanAIGCRequest", 1, "request failed, appRuntime null.");
            observer.a(-1, "appRuntime null");
            return;
        }
        QLog.i("ZPlanAIGCRequest", 1, "doAIGCRequestByZootopiaServlet, service: " + service + ", method: " + method);
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, c16, service, method, reqData, emptyMap, observer, 0, 0, 192, null);
    }

    public final Object a(long j3, int i3, int i16, String str, int i17, Continuation<? super List<u45.h>> continuation) {
        ArrayList arrayList = new ArrayList();
        for (int i18 = 0; i18 < i17; i18++) {
            arrayList.add(l(j3, i3, i16, str));
        }
        return AwaitKt.awaitAll(arrayList, continuation);
    }

    public final boolean c() {
        return firstEnter;
    }

    public final Object d(Continuation<? super com.tencent.mobileqq.zplan.aigc.data.a> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        byte[] reqData = MessageNano.toByteArray(new ju4.e());
        a aVar = new a(safeContinuation);
        ZPlanAIGCRequest zPlanAIGCRequest = f335341a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        zPlanAIGCRequest.b("trpc.zplan.aigc_coupon.AigcCoupon", "ShoppingBag", reqData, aVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object e(int i3, Continuation<? super Integer> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        u45.e eVar = new u45.e();
        eVar.f438226a = i3;
        byte[] reqData = MessageNano.toByteArray(eVar);
        b bVar = new b(safeContinuation);
        ZPlanAIGCRequest zPlanAIGCRequest = f335341a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        zPlanAIGCRequest.b("trpc.metaverse.ugc_store_svr.UgcStoreSvr", "GetAIGCADPlayQualifications", reqData, bVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object f(long j3, Continuation<? super Long> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ju4.a aVar = new ju4.a();
        aVar.f410979a = j3;
        byte[] reqData = MessageNano.toByteArray(aVar);
        c cVar = new c(safeContinuation);
        ZPlanAIGCRequest zPlanAIGCRequest = f335341a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        zPlanAIGCRequest.b("trpc.zplan.aigc_coupon.AigcCoupon", "Buy", reqData, cVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object g(Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        byte[] reqData = MessageNano.toByteArray(new iu4.c());
        d dVar = new d(safeContinuation);
        ZPlanAIGCRequest zPlanAIGCRequest = f335341a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        zPlanAIGCRequest.b("trpc.metaverse.aigc_feeds.AigcFeeds", "GetChannelInfo", reqData, dVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object h(long j3, boolean z16, boolean z17, String str, String str2, int i3, Continuation<? super ZplanCreateAIGCResponseInfo> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        e eVar = new e(safeContinuation);
        t55.b bVar = new t55.b();
        bVar.f435448a = ZPlanVersion.ZPlanVersion;
        yv4.d dVar = new yv4.d();
        dVar.f451332b = j3;
        dVar.f451331a = bVar;
        dVar.f451333c = z16;
        dVar.f451334d = z17;
        dVar.f451335e = str;
        dVar.f451336f = str2;
        dVar.f451337g = i3;
        byte[] byteArray = MessageNano.toByteArray(dVar);
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.request("trpc.zplan.ugc_avatar.Avatar.SsoCreateAIGCAvatar", byteArray, eVar);
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object i(long j3, Continuation<? super Long> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        iu4.j jVar = new iu4.j();
        jVar.f408786a = j3;
        byte[] reqData = MessageNano.toByteArray(jVar);
        f fVar = new f(safeContinuation);
        ZPlanAIGCRequest zPlanAIGCRequest = f335341a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        zPlanAIGCRequest.b("trpc.metaverse.aigc_feeds.AigcFeeds", "LikeFeed", reqData, fVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object j(String str, Continuation<? super iu4.h> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        iu4.g gVar = new iu4.g();
        gVar.f408779a = str;
        byte[] reqData = MessageNano.toByteArray(gVar);
        g gVar2 = new g(safeContinuation);
        ZPlanAIGCRequest zPlanAIGCRequest = f335341a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        zPlanAIGCRequest.b("trpc.metaverse.aigc_feeds.AigcFeeds", "GetFeedsList", reqData, gVar2);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object k(int i3, int i16, final String str, Continuation<? super u45.l> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        u45.k kVar = new u45.k();
        kVar.f438249a = i3;
        kVar.f438250b = i16;
        kVar.f438251c = str;
        byte[] reqData = MessageNano.toByteArray(kVar);
        final String str2 = "GetImageryDetails";
        td3.a aVar = new td3.a() { // from class: com.tencent.mobileqq.zplan.servlet.ZPlanAIGCRequest$requestImageryDetails$2$requestObserver$1
            @Override // td3.a
            public void a(Integer errCode, String errMsg) {
                QLog.e("ZPlanAIGCRequest", 1, "requestImageryDetails errCode: " + errCode + ", errMsg: " + errMsg);
                Continuation<u45.l> continuation2 = safeContinuation;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1 */
            /* JADX WARN: Type inference failed for: r4v15 */
            /* JADX WARN: Type inference failed for: r4v2, types: [T, u45.l] */
            @Override // td3.a
            public void onReceive(byte[] data) {
                ?? r46;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                T t16 = 0;
                try {
                    r46 = u45.l.c(data);
                } catch (Exception e16) {
                    QLog.e("ZPlanAIGCRequest", 1, "requestImageryDetails failed.", e16);
                    r46 = 0;
                }
                objectRef.element = r46;
                if (r46 == 0) {
                    Continuation<u45.l> continuation2 = safeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("onReceive, rsp null."))));
                    return;
                }
                if (!TextUtils.isEmpty(r46.f438254c)) {
                    if (Intrinsics.areEqual(((u45.l) objectRef.element).f438254c, str)) {
                        try {
                            t16 = u45.l.c(com.tencent.mobileqq.zplan.aigc.helper.h.f330325a.j(str2));
                        } catch (Exception e17) {
                            QLog.e("ZPlanAIGCRequest", 1, "requestImageryDetails restoredData failed.", e17);
                        }
                        objectRef.element = t16;
                        if (t16 == 0) {
                            Continuation<u45.l> continuation3 = safeContinuation;
                            Result.Companion companion2 = Result.INSTANCE;
                            continuation3.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("requestImageryDetails onReceive, rsp null."))));
                            return;
                        }
                        QLog.i("ZPlanAIGCRequest", 1, "requestUGCTemplateInfo restoredData success");
                    } else {
                        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
                        if (f16 != null) {
                            CorountineFunKt.e(f16, "ZPlanAIGCRequest_saveImageryPbFile", null, null, null, new ZPlanAIGCRequest$requestImageryDetails$2$requestObserver$1$onReceive$1(str2, objectRef, data, null), 14, null);
                        }
                    }
                }
                QLog.i("ZPlanAIGCRequest", 1, "requestImageryDetails succeed, imagerys size: " + ((u45.l) objectRef.element).f438253b.length);
                Continuation<u45.l> continuation4 = safeContinuation;
                Result.Companion companion3 = Result.INSTANCE;
                continuation4.resumeWith(Result.m476constructorimpl(objectRef.element));
            }
        };
        ZPlanAIGCRequest zPlanAIGCRequest = f335341a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        zPlanAIGCRequest.b("trpc.metaverse.ugc_store_svr.UgcStoreSvr", "GetImageryDetails", reqData, aVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Deferred<u45.h> l(long ugcId, int reqIndex, int imageryId, String imageryDescription) {
        Intrinsics.checkNotNullParameter(imageryDescription, "imageryDescription");
        QLog.d("ZPlanAIGCRequest", 1, "requestImageryRecommendPicsAsync");
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        u45.g gVar = new u45.g();
        gVar.f438231d = String.valueOf(ugcId);
        gVar.f438228a = imageryId;
        gVar.f438230c = imageryDescription;
        gVar.f438234g = reqIndex;
        gVar.f438229b = 0;
        gVar.f438232e = false;
        gVar.f438233f = 1;
        byte[] reqData = MessageNano.toByteArray(gVar);
        h hVar = new h(CompletableDeferred$default);
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        b("trpc.metaverse.ugc_store_svr.UgcStoreSvr", "GetAIGCRecommendPics", reqData, hVar);
        return CompletableDeferred$default;
    }

    public final Object m(yv4.a[] aVarArr, long j3, long j16, String str, String str2, Continuation<? super ZPlanCosUGCAvatarKeyInfo> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        i iVar = new i(safeContinuation);
        t55.b bVar = new t55.b();
        bVar.f435448a = ZPlanVersion.ZPlanVersion;
        yv4.h hVar = new yv4.h();
        hVar.f451346c = j3;
        hVar.f451345b = j16;
        hVar.f451347d = aVarArr;
        hVar.f451344a = bVar;
        hVar.f451348e = str;
        hVar.f451349f = str2;
        byte[] byteArray = MessageNano.toByteArray(hVar);
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.request("trpc.zplan.ugc_avatar.Avatar.SsoPreCreateAIGCAvatar", byteArray, iVar);
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object n(Continuation<? super Long> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        byte[] reqData = MessageNano.toByteArray(new ju4.c());
        j jVar = new j(safeContinuation);
        ZPlanAIGCRequest zPlanAIGCRequest = f335341a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        zPlanAIGCRequest.b("trpc.zplan.aigc_coupon.AigcCoupon", "Query", reqData, jVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object o(long j3, Continuation<? super iu4.b> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QLog.i("ZPlanAIGCRequest", 1, "requestSingleFeedInfo." + j3);
        iu4.e eVar = new iu4.e();
        eVar.f408777a = j3;
        byte[] reqData = MessageNano.toByteArray(eVar);
        k kVar = new k(safeContinuation);
        ZPlanAIGCRequest zPlanAIGCRequest = f335341a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        zPlanAIGCRequest.b("trpc.metaverse.aigc_feeds.AigcFeeds", "GetFeed", reqData, kVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Deferred<yv4.e> p() {
        QLog.d("ZPlanAIGCRequest", 1, "requestImageryRecommendPicsAsync");
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        byte[] reqData = MessageNano.toByteArray(new yv4.f());
        l lVar = new l(CompletableDeferred$default);
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        b("trpc.zplan.ugc_avatar.Avatar", "S2SGenerateAvatarID", reqData, lVar);
        return CompletableDeferred$default;
    }

    public final Object q(final int i3, boolean z16, final String str, Continuation<? super AIGCTemplateInfo> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ab abVar = new ab();
        abVar.f440109a = i3;
        abVar.f440110b = z16;
        abVar.f440111c = str;
        byte[] reqData = MessageNano.toByteArray(abVar);
        final String str2 = "GetUGCTemplateInfo";
        td3.a aVar = new td3.a() { // from class: com.tencent.mobileqq.zplan.servlet.ZPlanAIGCRequest$requestUGCTemplateInfo$2$requestObserver$1
            @Override // td3.a
            public void a(Integer errCode, String errMsg) {
                QLog.e("ZPlanAIGCRequest", 1, "requestUGCTemplateInfo errCode: " + errCode + ", errMsg: " + errMsg);
                Continuation<AIGCTemplateInfo> continuation2 = safeContinuation;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(errCode + ", " + errMsg))));
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v2 */
            /* JADX WARN: Type inference failed for: r0v23 */
            /* JADX WARN: Type inference failed for: r0v3, types: [uv4.ac, T] */
            @Override // td3.a
            public void onReceive(byte[] data) {
                ?? r06;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                T t16 = 0;
                try {
                    r06 = ac.c(data);
                } catch (Exception e16) {
                    QLog.e("ZPlanAIGCRequest", 1, "requestUGCTemplateInfo failed.", e16);
                    r06 = 0;
                }
                objectRef.element = r06;
                if (r06 == 0) {
                    Continuation<AIGCTemplateInfo> continuation2 = safeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("onReceive, rsp null."))));
                    return;
                }
                if (!TextUtils.isEmpty(r06.f440114c)) {
                    if (Intrinsics.areEqual(((ac) objectRef.element).f440114c, str)) {
                        try {
                            t16 = ac.c(com.tencent.mobileqq.zplan.aigc.helper.h.f330325a.j(str2 + i3));
                        } catch (Exception e17) {
                            QLog.e("ZPlanAIGCRequest", 1, "requestUGCTemplateInfo restoredData failed.", e17);
                        }
                        objectRef.element = t16;
                        if (t16 == 0) {
                            Continuation<AIGCTemplateInfo> continuation3 = safeContinuation;
                            Result.Companion companion2 = Result.INSTANCE;
                            continuation3.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("restoredData onReceive, rsp null."))));
                            return;
                        }
                        QLog.i("ZPlanAIGCRequest", 1, "requestUGCTemplateInfo success");
                    } else {
                        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
                        if (f16 != null) {
                            CorountineFunKt.e(f16, "ZPlanAIGCRequest_saveUGCTemplateInfoPbFile", null, null, null, new ZPlanAIGCRequest$requestUGCTemplateInfo$2$requestObserver$1$onReceive$1(str2, i3, objectRef, data, null), 14, null);
                        }
                    }
                }
                bn[] bnVarArr = ((ac) objectRef.element).f440112a;
                Intrinsics.checkNotNullExpressionValue(bnVarArr, "rsp.templateList");
                long j3 = ((ac) objectRef.element).f440113b;
                QLog.i("ZPlanAIGCRequest", 1, "requestUGCTemplateInfo succeed, ugcId: " + j3 + ", templateInfoSize:" + bnVarArr.length);
                Continuation<AIGCTemplateInfo> continuation4 = safeContinuation;
                Result.Companion companion3 = Result.INSTANCE;
                continuation4.resumeWith(Result.m476constructorimpl(new AIGCTemplateInfo(bnVarArr, j3)));
            }
        };
        ZPlanAIGCRequest zPlanAIGCRequest = f335341a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        zPlanAIGCRequest.b("trpc.metaverse.store_conf_svr.StoreConfSvr", "GetUGCTemplateInfo", reqData, aVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object r(long j3, Continuation<? super Long> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        iu4.j jVar = new iu4.j();
        jVar.f408786a = j3;
        byte[] reqData = MessageNano.toByteArray(jVar);
        m mVar = new m(safeContinuation);
        ZPlanAIGCRequest zPlanAIGCRequest = f335341a;
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        zPlanAIGCRequest.b("trpc.metaverse.aigc_feeds.AigcFeeds", "UnlikeFeed", reqData, mVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void s(boolean z16) {
        firstEnter = z16;
    }
}
