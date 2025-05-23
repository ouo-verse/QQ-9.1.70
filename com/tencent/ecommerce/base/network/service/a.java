package com.tencent.ecommerce.base.network.service;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.ECPkgCodingType;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.ecommerce.base.network.api.IECSendPackageCallback;
import com.tencent.ecommerce.base.network.api.IECSender;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104JQ\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072\u0006\u0010\t\u001a\u00028\u0000H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJQ\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\t\u001a\u00028\u0000H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ[\u0010\u0019\u001a\u00020\u0018\"\b\b\u0000\u0010\u0011*\u00020\u0010\"\b\b\u0001\u0010\u0013*\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0016H\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ.\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0007J\u0012\u0010 \u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001bH\u0002J\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010!\u001a\u00020\u0004H\u0002JU\u0010%\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0016\u00a2\u0006\u0004\b%\u0010&J.\u0010,\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0017\u001a\u00020+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/tencent/ecommerce/base/network/service/a;", "", "P", BdhLogUtil.LogTag.Tag_Req, "", "service", "method", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "contracts", "requestParams", "Lcom/tencent/ecommerce/base/network/api/d;", "f", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/base/network/api/IECNetworkJsonContracts;", "e", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/base/network/api/IECNetworkJsonContracts;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "I", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "O", "req", "resp", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "callback", "", "b", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/base/network/api/IECRequest;Lcom/tencent/ecommerce/base/network/api/IECResponse;Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;)I", "Lorg/json/JSONObject;", "reqParams", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "c", "reqBody", "a", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", h.F, "cmd", "g", "(Ljava/lang/String;Ljava/lang/Object;Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;)I", "", "targetReqArray", "Lcom/tencent/ecommerce/base/network/api/ECPkgCodingType;", "codingType", "Lcom/tencent/ecommerce/base/network/api/IECSendPackageCallback;", "i", "Lcom/tencent/ecommerce/base/network/api/IECSender;", "Lcom/tencent/ecommerce/base/network/api/IECSender;", "sender", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "networkSpanNum", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f100826c = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static IECSender sender = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getNetwork();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final AtomicInteger networkSpanNum = new AtomicInteger(1);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/base/network/service/a$a", "Lcom/tencent/ecommerce/base/network/api/IECSendPackageCallback;", "Lcom/tencent/ecommerce/base/network/api/e;", "successResponse", "", "onSuccess", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.network.service.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static final class C1032a implements IECSendPackageCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f100827a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f100828b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IECResponse f100829c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IECNetworkCallback f100830d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IECRequest f100831e;

        C1032a(String str, String str2, IECResponse iECResponse, IECNetworkCallback iECNetworkCallback, IECRequest iECRequest) {
            this.f100827a = str;
            this.f100828b = str2;
            this.f100829c = iECResponse;
            this.f100830d = iECNetworkCallback;
            this.f100831e = iECRequest;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
        public void onError(ECRemoteResponse errorResponse) {
            IECNetworkCallback iECNetworkCallback = this.f100830d;
            if (iECNetworkCallback != null) {
                iECNetworkCallback.onError(this.f100831e, errorResponse);
            }
        }

        @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
        public void onSuccess(ECRemoteResponse successResponse) {
            if (successResponse.getCode() != 0) {
                cg0.a.a("ECNetwork", "requestWithCmd$\\sendPackage", "error code = %" + successResponse.getCode() + " service = " + this.f100827a + ", method = " + this.f100828b + TokenParser.SP);
            }
            boolean decodeData = this.f100829c.decodeData(com.tencent.ecommerce.base.network.api.c.c(successResponse.getData()));
            if (!decodeData) {
                cg0.a.a("ECNetwork", "requestWithCmd$\\sendPackage", "decode resp data invalid ret = " + decodeData + ", service = " + this.f100827a + ", method = " + this.f100828b);
            }
            IECNetworkCallback iECNetworkCallback = this.f100830d;
            if (iECNetworkCallback != null) {
                iECNetworkCallback.onSuccess(this.f100831e, this.f100829c);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/base/network/service/a$b", "Lcom/tencent/ecommerce/base/network/api/IECSendPackageCallback;", "Lcom/tencent/ecommerce/base/network/api/e;", "successResponse", "", "onSuccess", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class b implements IECSendPackageCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f100832a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f100833b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IECJsonNetworkCallback f100834c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f100835d;

        b(String str, String str2, IECJsonNetworkCallback iECJsonNetworkCallback, JSONObject jSONObject) {
            this.f100832a = str;
            this.f100833b = str2;
            this.f100834c = iECJsonNetworkCallback;
            this.f100835d = jSONObject;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
        public void onError(ECRemoteResponse errorResponse) {
            IECJsonNetworkCallback iECJsonNetworkCallback = this.f100834c;
            if (iECJsonNetworkCallback != null) {
                iECJsonNetworkCallback.onError(this.f100835d, errorResponse);
            }
        }

        @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
        public void onSuccess(ECRemoteResponse successResponse) {
            if (successResponse.getCode() != 0) {
                cg0.a.a("ECNetwork", "requestWithCmd$\\sendPackage", "req success, but rsp data invalid, error code = " + successResponse.getCode() + ", service = " + this.f100832a + ", method = " + this.f100833b);
            }
            IECJsonNetworkCallback iECJsonNetworkCallback = this.f100834c;
            if (iECJsonNetworkCallback != null) {
                iECJsonNetworkCallback.onSuccess(this.f100835d, com.tencent.ecommerce.base.network.api.c.c(successResponse.getData()), successResponse.getTraceInfo());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/base/network/service/ECNetwork$requestWithCmdAsync$2$1", "Lcom/tencent/ecommerce/base/network/api/IECSendPackageCallback;", "Lcom/tencent/ecommerce/base/network/api/e;", "successResponse", "", "onSuccess", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class c implements IECSendPackageCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation f100836a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IECNetworkJsonContracts f100837b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f100838c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f100839d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f100840e;

        c(Continuation continuation, IECNetworkJsonContracts iECNetworkJsonContracts, Object obj, String str, String str2) {
            this.f100836a = continuation;
            this.f100837b = iECNetworkJsonContracts;
            this.f100838c = obj;
            this.f100839d = str;
            this.f100840e = str2;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
        public void onError(ECRemoteResponse errorResponse) {
            this.f100836a.resumeWith(Result.m476constructorimpl(new ECNetworkResponse(errorResponse.getCode(), errorResponse.getMsg(), null, errorResponse.getTraceInfo())));
        }

        @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
        public void onSuccess(ECRemoteResponse successResponse) {
            byte[] data = successResponse.getData();
            this.f100836a.resumeWith(Result.m476constructorimpl(new ECNetworkResponse(successResponse.getCode(), successResponse.getMsg(), data != null ? this.f100837b.decodeResponse(data) : null, successResponse.getTraceInfo())));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/base/network/service/ECNetwork$requestWithPBCmdAsync$2$1", "Lcom/tencent/ecommerce/base/network/api/IECSendPackageCallback;", "Lcom/tencent/ecommerce/base/network/api/e;", "successResponse", "", "onSuccess", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class d implements IECSendPackageCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation f100841a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IECNetworkPBContracts f100842b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f100843c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f100844d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f100845e;

        d(Continuation continuation, IECNetworkPBContracts iECNetworkPBContracts, Object obj, String str, String str2) {
            this.f100841a = continuation;
            this.f100842b = iECNetworkPBContracts;
            this.f100843c = obj;
            this.f100844d = str;
            this.f100845e = str2;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
        public void onError(ECRemoteResponse errorResponse) {
            this.f100841a.resumeWith(Result.m476constructorimpl(new ECNetworkResponse(errorResponse.getCode(), errorResponse.getMsg(), null, errorResponse.getTraceInfo())));
        }

        @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
        public void onSuccess(ECRemoteResponse successResponse) {
            byte[] data = successResponse.getData();
            this.f100841a.resumeWith(Result.m476constructorimpl(new ECNetworkResponse(successResponse.getCode(), successResponse.getMsg(), data != null ? this.f100842b.decodeResponse(data) : null, successResponse.getTraceInfo())));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/base/network/service/a$e", "Lcom/tencent/ecommerce/base/network/api/IECSendPackageCallback;", "Lcom/tencent/ecommerce/base/network/api/e;", "successResponse", "", "onSuccess", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class e implements IECSendPackageCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECNetworkPBContracts f100846a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IECNetworkCallback f100847b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f100848c;

        e(IECNetworkPBContracts iECNetworkPBContracts, IECNetworkCallback iECNetworkCallback, Object obj) {
            this.f100846a = iECNetworkPBContracts;
            this.f100847b = iECNetworkCallback;
            this.f100848c = obj;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
        public void onError(ECRemoteResponse errorResponse) {
            IECNetworkCallback iECNetworkCallback = this.f100847b;
            if (iECNetworkCallback != null) {
                iECNetworkCallback.onError(this.f100848c, errorResponse);
            }
        }

        @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
        public void onSuccess(ECRemoteResponse successResponse) {
            byte[] data = successResponse.getData();
            if (data == null) {
                data = new byte[0];
            }
            Object decodeResponse = this.f100846a.decodeResponse(data);
            IECNetworkCallback iECNetworkCallback = this.f100847b;
            if (iECNetworkCallback != null) {
                iECNetworkCallback.onSuccess(this.f100848c, decodeResponse);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/base/network/service/a$f", "Lcom/tencent/ecommerce/base/network/api/IECSendPackageCallback;", "Lcom/tencent/ecommerce/base/network/api/e;", "successResponse", "", "onSuccess", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class f implements IECSendPackageCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f100849a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IECSendPackageCallback f100850b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ECPkgCodingType f100851c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f100852d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f100853e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f100854f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f100855g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f100856h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ byte[] f100857i;

        f(String str, IECSendPackageCallback iECSendPackageCallback, ECPkgCodingType eCPkgCodingType, String str2, String str3, Map map, long j3, int i3, byte[] bArr) {
            this.f100849a = str;
            this.f100850b = iECSendPackageCallback;
            this.f100851c = eCPkgCodingType;
            this.f100852d = str2;
            this.f100853e = str3;
            this.f100854f = map;
            this.f100855g = j3;
            this.f100856h = i3;
            this.f100857i = bArr;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
        public void onError(ECRemoteResponse errorResponse) {
            errorResponse.n(this.f100849a);
            this.f100850b.onError(errorResponse);
            cg0.a.a("ECNetwork", "sendPackageWithExtInfoInReq", "onError,  codingType = " + this.f100851c + " service = " + this.f100852d + ", method = " + this.f100853e + " traceInfo = " + this.f100854f.get(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO) + ",  code = " + errorResponse.getCode() + TokenParser.SP + " msg = " + errorResponse.getMsg());
            com.tencent.ecommerce.base.network.service.b bVar = com.tencent.ecommerce.base.network.service.b.f100859b;
            bVar.c(this.f100853e, errorResponse);
            bVar.b(this.f100852d, this.f100853e, this.f100855g, errorResponse);
            eg0.b bVar2 = eg0.b.f396238b;
            bVar2.a(this.f100853e, errorResponse, 0);
            bVar2.b(this.f100853e, errorResponse, this.f100855g);
            com.tencent.ecommerce.base.fragment.d dVar = com.tencent.ecommerce.base.fragment.d.f100713c;
            String str = this.f100852d;
            com.tencent.ecommerce.base.network.service.c cVar = com.tencent.ecommerce.base.network.service.c.f100861b;
            dVar.b(str, cVar.b(this.f100853e, this.f100856h));
            cVar.a(this.f100852d, this.f100853e, this.f100857i.length, errorResponse, this.f100856h);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
        public void onSuccess(ECRemoteResponse successResponse) {
            successResponse.n(this.f100849a);
            this.f100850b.onSuccess(successResponse);
            if (this.f100851c == ECPkgCodingType.EC_PACKAGE_CODING_TYPE_JSON) {
                cg0.a.b("ECNetwork", "sendPackageWithExtInfoInReq onSuccess,  codingType = " + this.f100851c + " service = " + this.f100852d + ", method = " + this.f100853e + TokenParser.SP + " traceInfo = " + this.f100854f.get(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO));
            } else {
                cg0.a.b("ECNetwork", "sendPackageWithExtInfoInReq onSuccess,  codingType = " + this.f100851c + " service = " + this.f100852d + ", method = " + this.f100853e + TokenParser.SP + " traceInfo = " + this.f100854f.get(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO));
            }
            com.tencent.ecommerce.base.network.service.b bVar = com.tencent.ecommerce.base.network.service.b.f100859b;
            bVar.c(this.f100853e, successResponse);
            bVar.b(this.f100852d, this.f100853e, this.f100855g, successResponse);
            eg0.b bVar2 = eg0.b.f396238b;
            bVar2.a(this.f100853e, successResponse, 1);
            bVar2.b(this.f100853e, successResponse, this.f100855g);
            com.tencent.ecommerce.base.fragment.d dVar = com.tencent.ecommerce.base.fragment.d.f100713c;
            String str = this.f100852d;
            com.tencent.ecommerce.base.network.service.c cVar = com.tencent.ecommerce.base.network.service.c.f100861b;
            dVar.b(str, cVar.b(this.f100853e, this.f100856h));
            cVar.a(this.f100852d, this.f100853e, this.f100857i.length, successResponse, this.f100856h);
        }
    }

    a() {
    }

    @JvmStatic
    public static final <I extends IECRequest, O extends IECResponse> int b(String service, String method, I req, O resp, IECNetworkCallback<I, O> callback) {
        ECPkgCodingType eCPkgCodingType = ECPkgCodingType.EC_PACKAGE_CODING_TYPE_JSON;
        a aVar = f100826c;
        return aVar.i(service, method, com.tencent.ecommerce.base.network.api.c.b(aVar.a(req.encodeParams())), eCPkgCodingType, new C1032a(service, method, resp, callback, req));
    }

    @JvmStatic
    public static final int c(String service, String method, JSONObject reqParams, IECJsonNetworkCallback callback) {
        ECPkgCodingType eCPkgCodingType = ECPkgCodingType.EC_PACKAGE_CODING_TYPE_JSON;
        a aVar = f100826c;
        JSONObject a16 = aVar.a(reqParams);
        return aVar.i(service, method, com.tencent.ecommerce.base.network.api.c.b(a16), eCPkgCodingType, new b(service, method, callback, a16));
    }

    @JvmStatic
    public static final <P, R> Object e(String str, String str2, IECNetworkJsonContracts<P, R> iECNetworkJsonContracts, P p16, Continuation<? super ECNetworkResponse<R>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ECPkgCodingType eCPkgCodingType = ECPkgCodingType.EC_PACKAGE_CODING_TYPE_JSON;
        JSONObject encodeRequestParams = iECNetworkJsonContracts.encodeRequestParams(p16);
        a aVar = f100826c;
        aVar.i(str, str2, com.tencent.ecommerce.base.network.api.c.b(aVar.a(encodeRequestParams)), eCPkgCodingType, new c(safeContinuation, iECNetworkJsonContracts, p16, str, str2));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @JvmStatic
    public static final <P, R> Object f(String str, String str2, IECNetworkPBContracts<P, R> iECNetworkPBContracts, P p16, Continuation<? super ECNetworkResponse<R>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ECPkgCodingType eCPkgCodingType = ECPkgCodingType.EC_PACKAGE_CODING_TYPE_PROTOBUF;
        ug0.b bVar = ug0.b.f438933d;
        f100826c.i(str, str2, iECNetworkPBContracts.encodeRequestParams(p16, bVar.e(), bVar.f()), eCPkgCodingType, new d(safeContinuation, iECNetworkPBContracts, p16, str, str2));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final <P, R> int g(String cmd, P requestParams, IECNetworkPBContracts<P, R> contracts, IECNetworkCallback<P, R> callback) {
        Map<Object, ? extends Object> mapOf;
        int andIncrement = networkSpanNum.getAndIncrement();
        com.tencent.ecommerce.base.network.service.c cVar = com.tencent.ecommerce.base.network.service.c.f100861b;
        cVar.d(cmd, andIncrement);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, cVar.b(cmd, andIncrement)));
        return sender.sendQQPackage(cmd, IECNetworkPBContracts.a.a(contracts, requestParams, 0, null, 6, null), mapOf, new e(contracts, callback, requestParams));
    }

    private final Map<Object, Object> h(String traceInfo) {
        Map<Object, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(WadlProxyConsts.CHANNEL, String.valueOf(ug0.b.f438933d.e())), TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, traceInfo));
        return mapOf;
    }

    private final JSONObject a(JSONObject reqBody) {
        if (reqBody == null) {
            reqBody = new JSONObject();
        }
        Object opt = reqBody.opt(WadlProxyConsts.CHANNEL);
        if (opt == null) {
            opt = Integer.valueOf(ug0.b.f438933d.e());
        }
        reqBody.put(WadlProxyConsts.CHANNEL, opt);
        Object opt2 = reqBody.opt("req_ext");
        if (opt2 == null) {
            opt2 = ug0.b.f438933d.f();
        }
        reqBody.put("req_ext", opt2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("req channel = ");
        ug0.b bVar = ug0.b.f438933d;
        sb5.append(bVar.e());
        sb5.append(", ");
        sb5.append(" ext = ");
        sb5.append(bVar.f());
        sb5.append(", ");
        sb5.append(" params = ");
        sb5.append(reqBody);
        sb5.append(']');
        cg0.a.b("ECNetwork", sb5.toString());
        return reqBody;
    }

    public final int i(String service, String method, byte[] targetReqArray, ECPkgCodingType codingType, IECSendPackageCallback callback) {
        long currentTimeMillis = System.currentTimeMillis();
        int andIncrement = networkSpanNum.getAndIncrement();
        com.tencent.ecommerce.base.network.service.c cVar = com.tencent.ecommerce.base.network.service.c.f100861b;
        cVar.d(method, andIncrement);
        String b16 = cVar.b(method, andIncrement);
        Map<Object, ? extends Object> h16 = h(b16);
        if (codingType == ECPkgCodingType.EC_PACKAGE_CODING_TYPE_JSON) {
            cg0.a.b("ECNetwork", "sendPackage service = " + service + ", method = " + method + " traceInfo = " + h16.get(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO) + '}');
        } else {
            cg0.a.b("ECNetwork", "sendPackage service = " + service + ", method = " + method + " req = " + targetReqArray + " ext=" + h16);
        }
        return sender.sendPackage(service, method, targetReqArray, codingType.ordinal(), h16, new f(b16, callback, codingType, service, method, h16, currentTimeMillis, andIncrement, targetReqArray));
    }

    public static /* synthetic */ int d(String str, String str2, IECRequest iECRequest, IECResponse iECResponse, IECNetworkCallback iECNetworkCallback, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            iECNetworkCallback = null;
        }
        return b(str, str2, iECRequest, iECResponse, iECNetworkCallback);
    }
}
