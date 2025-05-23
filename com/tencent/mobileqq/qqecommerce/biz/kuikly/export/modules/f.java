package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.QQKuiklyPrePrequest;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J?\u0010\r\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002JI\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/f;", "Li01/e;", "", "params", "c", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "method", "call", "<init>", "()V", "d", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/f$a;", "", "", "errCode", "", "errMsg", "data", "a", "ERROR_IN_REQUEST", "I", "ERROR_NO_UNIQUE_ID", "ERROR_PARAMS", "ERROR_SUCCESS", "ERR_CODE", "Ljava/lang/String;", "ERR_DATA", "ERR_MSG", "METHOD_ACQUIRE_PRE_REQUEST_DATA", "METHOD_GET_PRE_REQUEST_DATA", "MODULE_NAME", "PARAM_UNIQUE_ID", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.f$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(int errCode, String errMsg, String data) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errCode", errCode);
            jSONObject.put("errMsg", errMsg);
            if (data != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(data);
                    if (jSONObject2.has("errCode") && jSONObject2.has("errMsg")) {
                        return data;
                    }
                    jSONObject.put("data", jSONObject2);
                } catch (JSONException e16) {
                    jSONObject.put("errCode", -1);
                    jSONObject.put("errMsg", e16);
                    QLog.e("QQKuiklyDataModule", 1, e16, new Object[0]);
                    Unit unit = Unit.INSTANCE;
                }
            }
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "result.toString()");
            return jSONObject3;
        }

        Companion() {
        }
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "getPreRequestData")) {
            return c(params);
        }
        if (Intrinsics.areEqual(method, "acquirePreRequestData")) {
            a(params, callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    private final void a(String params, Function1<Object, Unit> callback) {
        Map mapOf;
        if (params != null && com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this) != null) {
            QQKuiklyRenderView c16 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this);
            Intrinsics.checkNotNull(c16);
            if (c16.getPreRequest() != null) {
                JSONObject jSONObject = new JSONObject(params);
                QQKuiklyRenderView c17 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this);
                Intrinsics.checkNotNull(c17);
                QQKuiklyPrePrequest preRequest = c17.getPreRequest();
                Intrinsics.checkNotNull(preRequest);
                String optString = jSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID);
                Intrinsics.checkNotNullExpressionValue(optString, "paramsJSONObject.optString(PARAM_UNIQUE_ID)");
                preRequest.f(optString, callback);
                return;
            }
        }
        if (callback != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", -1), TuplesKt.to("errMsg", "no param or no qqmc config"));
            callback.invoke(mapOf);
        }
    }

    private final String c(String params) {
        if (params != null && com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this) != null) {
            QQKuiklyRenderView c16 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this);
            Intrinsics.checkNotNull(c16);
            if (c16.getPreRequest() != null) {
                JSONObject jSONObject = new JSONObject(params);
                QQKuiklyRenderView c17 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this);
                Intrinsics.checkNotNull(c17);
                QQKuiklyPrePrequest preRequest = c17.getPreRequest();
                Intrinsics.checkNotNull(preRequest);
                String optString = jSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID);
                Intrinsics.checkNotNullExpressionValue(optString, "paramsJSONObject.optString(PARAM_UNIQUE_ID)");
                return preRequest.h(optString);
            }
        }
        return INSTANCE.a(-1, "no param or no qqmc config", null);
    }
}
