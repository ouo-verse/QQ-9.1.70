package com.tencent.ecommerce.base.report.service;

import com.tencent.ecommerce.base.network.api.IECRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/base/report/service/h;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "Lcom/tencent/ecommerce/base/report/service/ECRealtimeReportOperation;", "a", "Lcom/tencent/ecommerce/base/report/service/ECRealtimeReportOperation;", "operationType", "", "b", "Ljava/lang/String;", "mediaId", "Lcom/tencent/ecommerce/base/report/service/i;", "c", "Lcom/tencent/ecommerce/base/report/service/i;", "product", "Lcom/tencent/ecommerce/base/report/service/n;", "d", "Lcom/tencent/ecommerce/base/report/service/n;", "terminalRealReportModel", "<init>", "(Lcom/tencent/ecommerce/base/report/service/ECRealtimeReportOperation;Ljava/lang/String;Lcom/tencent/ecommerce/base/report/service/i;Lcom/tencent/ecommerce/base/report/service/n;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class h implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ECRealtimeReportOperation operationType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String mediaId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ECRealtimeReportProductModel product;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final n terminalRealReportModel;

    public h(ECRealtimeReportOperation eCRealtimeReportOperation, String str, ECRealtimeReportProductModel eCRealtimeReportProductModel, n nVar) {
        this.operationType = eCRealtimeReportOperation;
        this.mediaId = str;
        this.product = eCRealtimeReportProductModel;
        this.terminalRealReportModel = nVar;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("operation_type", this.operationType.operation);
        jSONObject3.put("media_id", this.mediaId);
        ECRealtimeReportProductModel eCRealtimeReportProductModel = this.product;
        if (eCRealtimeReportProductModel == null || (jSONObject = eCRealtimeReportProductModel.a()) == null) {
            jSONObject = new JSONObject();
        }
        jSONObject3.put("product", jSONObject);
        n nVar = this.terminalRealReportModel;
        if (nVar == null || (jSONObject2 = nVar.a()) == null) {
            jSONObject2 = new JSONObject();
        }
        jSONObject3.put("terminal_real_report", jSONObject2);
        return jSONObject3;
    }

    public /* synthetic */ h(ECRealtimeReportOperation eCRealtimeReportOperation, String str, ECRealtimeReportProductModel eCRealtimeReportProductModel, n nVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ECRealtimeReportOperation.EC_REALTIME_REPORT_OPERATION_UNKNOWN : eCRealtimeReportOperation, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? null : eCRealtimeReportProductModel, (i3 & 8) != 0 ? null : nVar);
    }
}
