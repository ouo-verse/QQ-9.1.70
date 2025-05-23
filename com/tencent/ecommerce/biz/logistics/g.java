package com.tencent.ecommerce.biz.logistics;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0005B?\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/g;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "Ljava/lang/String;", "afterSalesId", "b", "logisticsNumber", "c", "companyCode", "d", "companyName", "e", "phoneNum", "f", "processId", "", "g", "Z", "isUserInput", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", tl.h.F, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class g implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String afterSalesId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String logisticsNumber;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String companyCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String companyName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final String phoneNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final String processId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final boolean isUserInput;

    public g(String str, String str2, String str3, String str4, String str5, String str6, boolean z16) {
        this.afterSalesId = str;
        this.logisticsNumber = str2;
        this.companyCode = str3;
        this.companyName = str4;
        this.phoneNum = str5;
        this.processId = str6;
        this.isUserInput = z16;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("after_sales_id", this.afterSalesId);
            jSONObject.put("is_user_defined_company", this.isUserInput);
            jSONObject.put("logistics_number", this.logisticsNumber);
            jSONObject.put("company_code", this.companyCode);
            jSONObject.put("company_name", this.companyName);
            jSONObject.put(AuthDevOpenUgActivity.KEY_PHONE_NUM, this.phoneNum);
            jSONObject.put(CrashHianalyticsData.PROCESS_ID, this.processId);
            cg0.a.b("SubmitLogisticsReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("SubmitLogisticsReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
