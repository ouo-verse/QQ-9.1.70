package com.tencent.mobileqq.wink.editor.aielimination;

import com.google.gson.Gson;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminateGetStatusReq;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationButtonActionReq;
import com.tencent.mobileqq.wink.editor.aielimination.model.WinkAIEliminationRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import qshadow.ShadowAIGCGenerate$GenerateReply;
import qshadow.ShadowAIGCGenerate$GenerateRequest;
import qshadow.ShadowAIGCStatus$ButtonInfo;
import qshadow.ShadowAIGCStatus$DoActionReply;
import qshadow.ShadowAIGCStatus$DoActionRequest;
import qshadow.ShadowAIGCStatus$GetStatusReply;
import qshadow.ShadowAIGCStatus$GetStatusRequest;
import qshadow.ShadowAIGCStatus$PayInfo;
import qshadow.ShadowAIGCStatus$UsageInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJD\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002J\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/AIEliminateDataSource;", "", "", "busId", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/c;", "b", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "action", "", "a", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "imageUrl", "maskUrl", "originImageUrl", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqshadow/ShadowAIGCGenerate$GenerateReply;", "callBack", "funcId", "", "e", "extra", "", "d", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class AIEliminateDataSource {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIEliminateDataSource f318757a = new AIEliminateDataSource();

    AIEliminateDataSource() {
    }

    public static /* synthetic */ Object c(AIEliminateDataSource aIEliminateDataSource, String str, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "qzone_auto_removal";
        }
        return aIEliminateDataSource.b(str, continuation);
    }

    @Nullable
    public final Object a(int i3, @NotNull String str, @NotNull Continuation<? super Long> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ShadowAIGCStatus$DoActionRequest shadowAIGCStatus$DoActionRequest = new ShadowAIGCStatus$DoActionRequest();
        shadowAIGCStatus$DoActionRequest.busi_id.set(str);
        shadowAIGCStatus$DoActionRequest.action.set(i3);
        w93.e.f445096a.j(new AIEliminationButtonActionReq(shadowAIGCStatus$DoActionRequest), new Function5<BaseRequest, Boolean, Long, String, ShadowAIGCStatus$DoActionReply, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.AIEliminateDataSource$doAction$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(BaseRequest baseRequest, Boolean bool, Long l3, String str2, ShadowAIGCStatus$DoActionReply shadowAIGCStatus$DoActionReply) {
                invoke(baseRequest, bool.booleanValue(), l3.longValue(), str2, shadowAIGCStatus$DoActionReply);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull BaseRequest baseRequest, boolean z16, long j3, @Nullable String str2, @Nullable ShadowAIGCStatus$DoActionReply shadowAIGCStatus$DoActionReply) {
                Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
                if (shadowAIGCStatus$DoActionReply != null && z16) {
                    w53.b.f("AIEliminateDataSource", "requestAIElimination doAction success");
                    CancellableContinuation<Long> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(Long.valueOf(j3)));
                    return;
                }
                CancellableContinuation<Long> cancellableContinuation2 = cancellableContinuationImpl;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("rsp invalid " + shadowAIGCStatus$DoActionReply + " " + j3 + " " + z16))));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("requestAIElimination doAction fail: retCode: ");
                sb5.append(j3);
                sb5.append(", errMsg: ");
                sb5.append(str2);
                w53.b.c("AIEliminateDataSource", sb5.toString());
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object b(@NotNull String str, @NotNull Continuation<? super com.tencent.mobileqq.wink.editor.aielimination.model.c> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ShadowAIGCStatus$GetStatusRequest shadowAIGCStatus$GetStatusRequest = new ShadowAIGCStatus$GetStatusRequest();
        shadowAIGCStatus$GetStatusRequest.busi_id.set(str);
        final int j3 = w93.e.f445096a.j(new AIEliminateGetStatusReq(shadowAIGCStatus$GetStatusRequest), new Function5<BaseRequest, Boolean, Long, String, ShadowAIGCStatus$GetStatusReply, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.AIEliminateDataSource$getStatusReply$2$seq$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(BaseRequest baseRequest, Boolean bool, Long l3, String str2, ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
                invoke(baseRequest, bool.booleanValue(), l3.longValue(), str2, shadowAIGCStatus$GetStatusReply);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull BaseRequest baseRequest, boolean z16, long j16, @Nullable String str2, @Nullable ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
                PBEnumField pBEnumField;
                Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
                if (shadowAIGCStatus$GetStatusReply != null && j16 == 0 && z16) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (ShadowAIGCStatus$UsageInfo shadowAIGCStatus$UsageInfo : shadowAIGCStatus$GetStatusReply.usages.get()) {
                        if (shadowAIGCStatus$UsageInfo != null && (pBEnumField = shadowAIGCStatus$UsageInfo.type) != null) {
                            linkedHashMap.put(Integer.valueOf(pBEnumField.get()), shadowAIGCStatus$UsageInfo);
                        }
                    }
                    ShadowAIGCStatus$PayInfo payInfo = shadowAIGCStatus$GetStatusReply.pay_info.get();
                    CancellableContinuation<com.tencent.mobileqq.wink.editor.aielimination.model.c> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(payInfo, "payInfo");
                    ShadowAIGCStatus$ButtonInfo shadowAIGCStatus$ButtonInfo = shadowAIGCStatus$GetStatusReply.button_info.get();
                    Intrinsics.checkNotNullExpressionValue(shadowAIGCStatus$ButtonInfo, "rsp.button_info.get()");
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(new com.tencent.mobileqq.wink.editor.aielimination.model.c(linkedHashMap, payInfo, shadowAIGCStatus$ButtonInfo)));
                    return;
                }
                CancellableContinuation<com.tencent.mobileqq.wink.editor.aielimination.model.c> cancellableContinuation2 = cancellableContinuationImpl;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("rsp invalid " + shadowAIGCStatus$GetStatusReply + " " + j16 + " " + z16))));
            }
        });
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.AIEliminateDataSource$getStatusReply$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                VSNetworkHelper.getInstance().cancelRequest(MobileQQ.sMobileQQ, j3);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @NotNull
    public final Map<String, String> d(@NotNull String extra) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(extra, "extra");
        try {
            JSONObject jSONObject = new JSONObject(extra);
            JSONObject optJSONObject = jSONObject.optJSONObject("share_images");
            HashMap hashMap = new HashMap();
            String optString = jSONObject.optString("watermark_url");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"watermark_url\")");
            hashMap.put("SHARE_PREFIX__QQ", optString);
            if (optJSONObject != null) {
                String optString2 = optJSONObject.optString("wechat");
                Intrinsics.checkNotNullExpressionValue(optString2, "transferInfo.optString(\"wechat\")");
                hashMap.put("SHARE_PREFIX__OUT_CHANNEL", optString2);
                String optString3 = optJSONObject.optString("qq");
                Intrinsics.checkNotNullExpressionValue(optString3, "transferInfo.optString(\"qq\")");
                hashMap.put("SHARE_PREFIX__QQ", optString3);
            }
            String optString4 = jSONObject.optString("image_url");
            Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(\"image_url\")");
            hashMap.put("image_url", optString4);
            return hashMap;
        } catch (Throwable th5) {
            w53.b.d("AIEliminateDataSource", "parseExtra fail", th5);
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
    }

    public final void e(@NotNull String imageUrl, @Nullable String maskUrl, @Nullable String originImageUrl, @NotNull VSDispatchObserver.OnVSRspCallBack<ShadowAIGCGenerate$GenerateReply> callBack, @NotNull String busId, @NotNull String funcId) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        Intrinsics.checkNotNullParameter(busId, "busId");
        Intrinsics.checkNotNullParameter(funcId, "funcId");
        ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest = new ShadowAIGCGenerate$GenerateRequest();
        shadowAIGCGenerate$GenerateRequest.busi_id.set(busId);
        shadowAIGCGenerate$GenerateRequest.func_id.set(funcId);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("image_url", imageUrl);
        if (maskUrl != null) {
            linkedHashMap.put("mask_url", maskUrl);
        }
        if (originImageUrl != null) {
            linkedHashMap.put("origin_image_url", originImageUrl);
        }
        shadowAIGCGenerate$GenerateRequest.extra.set(new Gson().toJson(linkedHashMap));
        WinkAIEliminationRequest winkAIEliminationRequest = new WinkAIEliminationRequest(shadowAIGCGenerate$GenerateRequest);
        winkAIEliminationRequest.setTimeout(30000L);
        VSNetworkHelper.getInstance().sendRequest(winkAIEliminationRequest, callBack);
    }
}
