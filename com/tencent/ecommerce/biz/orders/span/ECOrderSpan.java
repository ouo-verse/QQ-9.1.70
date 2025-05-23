package com.tencent.ecommerce.biz.orders.span;

import android.net.Uri;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import hg0.b;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapWithDefaultKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J<\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fJ\u000e\u0010\u0011\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u0010R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan;", "", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "a", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpanScene;", "scene", "Lcom/tencent/ecommerce/biz/orders/span/ECOrderOperation;", QCircleDaTongConstant.ElementParamValue.OPERATION, "Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan$a;", "requestInfo", "", "extInfo", "", "b", "Lcom/tencent/ecommerce/base/network/api/d;", "d", "", "", "Ljava/util/Map;", "spanNums", "Ljava/lang/String;", "serviceName", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderSpan {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Integer> spanNums;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String serviceName;

    /* renamed from: c, reason: collision with root package name */
    public static final ECOrderSpan f103884c = new ECOrderSpan();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan$a;", "", "", "errorCode", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "a", "toString", "hashCode", "other", "", "equals", "I", "b", "Ljava/lang/String;", "<init>", "(ILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.span.ECOrderSpan$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class OrderRequestInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int errorCode;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String traceInfo;

        public OrderRequestInfo(int i3, String str) {
            this.errorCode = i3;
            this.traceInfo = str;
        }

        public final OrderRequestInfo a(int errorCode, String traceInfo) {
            return new OrderRequestInfo(errorCode, traceInfo);
        }

        public int hashCode() {
            int i3 = this.errorCode * 31;
            String str = this.traceInfo;
            return i3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "OrderRequestInfo(errorCode=" + this.errorCode + ", traceInfo=" + this.traceInfo + ")";
        }

        public /* synthetic */ OrderRequestInfo(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i16 & 2) != 0 ? "" : str);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OrderRequestInfo)) {
                return false;
            }
            OrderRequestInfo orderRequestInfo = (OrderRequestInfo) other;
            return this.errorCode == orderRequestInfo.errorCode && Intrinsics.areEqual(this.traceInfo, orderRequestInfo.traceInfo);
        }

        public static /* synthetic */ OrderRequestInfo b(OrderRequestInfo orderRequestInfo, int i3, String str, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = orderRequestInfo.errorCode;
            }
            if ((i16 & 2) != 0) {
                str = orderRequestInfo.traceInfo;
            }
            return orderRequestInfo.a(i3, str);
        }
    }

    static {
        Map<String, Integer> withDefaultMutable;
        withDefaultMutable = MapsKt__MapWithDefaultKt.withDefaultMutable(new LinkedHashMap(), new Function1<String, Integer>() { // from class: com.tencent.ecommerce.biz.orders.span.ECOrderSpan$spanNums$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2(String str) {
                return 1;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(String str) {
                return Integer.valueOf(invoke2(str));
            }
        });
        spanNums = withDefaultMutable;
        serviceName = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getOpenTelemetry().getSpanManager().getServiceName();
    }

    ECOrderSpan() {
    }

    public final void b(String orderId, ECOrderSpanScene scene, ECOrderOperation operation, OrderRequestInfo requestInfo, Map<String, String> extInfo) {
        Object value;
        Map<String, String> mapOf;
        Map<String, Integer> map = spanNums;
        value = MapsKt__MapsKt.getValue(map, orderId);
        int intValue = ((Number) value).intValue();
        String str = intValue + util.base64_pad_url + scene.meanings + util.base64_pad_url + operation.meanings;
        int i3 = requestInfo.errorCode;
        b bVar = new b();
        bVar.e(str, serviceName);
        bVar.a(str, "extInfo", extInfo);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("order_id", orderId), TuplesKt.to("scene", scene.name()), TuplesKt.to(QCircleDaTongConstant.ElementParamValue.OPERATION, operation.name()), TuplesKt.to("request_trace_link", f103884c.a(requestInfo.traceInfo)), TuplesKt.to(CheckForwardServlet.KEY_ERR_CODE, String.valueOf(i3)));
        bVar.d(str, mapOf);
        bVar.b(str, i3);
        map.put(orderId, Integer.valueOf(intValue + 1));
    }

    public final OrderRequestInfo d(ECNetworkResponse<?> eCNetworkResponse) {
        return new OrderRequestInfo(eCNetworkResponse.getCode(), eCNetworkResponse.getTraceInfo());
    }

    private final String a(String traceInfo) {
        List split$default;
        Object orNull;
        split$default = StringsKt__StringsKt.split$default((CharSequence) traceInfo, new char[]{'-'}, false, 0, 6, (Object) null);
        orNull = CollectionsKt___CollectionsKt.getOrNull(split$default, 1);
        String str = (String) orNull;
        if (str == null) {
            return traceInfo;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("datasource", "trace-detail-clickhouse-uid");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("query", str);
        Unit unit = Unit.INSTANCE;
        jSONArray.mo162put(jSONObject2);
        jSONObject.put("queries", jSONArray);
        return Uri.parse("https://qqkd.tot.woa.com/explore").buildUpon().appendQueryParameter("orgId", "1").appendQueryParameter("left", jSONObject.toString()).build().toString();
    }

    public static /* synthetic */ void c(ECOrderSpan eCOrderSpan, String str, ECOrderSpanScene eCOrderSpanScene, ECOrderOperation eCOrderOperation, OrderRequestInfo orderRequestInfo, Map map, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        eCOrderSpan.b(str, eCOrderSpanScene, eCOrderOperation, orderRequestInfo, map);
    }
}
