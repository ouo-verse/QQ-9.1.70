package com.tencent.ecommerce.repo.aftersale.apply;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyExtraItem;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0005B5\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/i;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "b", "skuId", "c", "processId", "Lcom/tencent/ecommerce/repo/aftersale/apply/c;", "d", "Lcom/tencent/ecommerce/repo/aftersale/apply/c;", "applyInfo", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/c;", "e", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/c;", "extraItem", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/repo/aftersale/apply/c;Lcom/tencent/ecommerce/repo/aftersale/apply/item/c;)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class i implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String orderId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String skuId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String processId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ECAfterSaleApplyInfo applyInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ECAfterSaleApplyExtraItem extraItem;

    public i(String str, String str2, String str3, ECAfterSaleApplyInfo eCAfterSaleApplyInfo, ECAfterSaleApplyExtraItem eCAfterSaleApplyExtraItem) {
        this.orderId = str;
        this.skuId = str2;
        this.processId = str3;
        this.applyInfo = eCAfterSaleApplyInfo;
        this.extraItem = eCAfterSaleApplyExtraItem;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        List<ECAfterSaleApplyOptionInfo> a16;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("order_id", this.orderId);
            jSONObject2.put("sku_id", this.skuId);
            jSONObject2.put(CrashHianalyticsData.PROCESS_ID, this.processId);
            ECAfterSaleApplyInfo eCAfterSaleApplyInfo = this.applyInfo;
            if (eCAfterSaleApplyInfo != null) {
                jSONObject2.put("apply_type", eCAfterSaleApplyInfo.getApplyType().value);
                JSONArray jSONArray = new JSONArray();
                for (ECAfterSaleApplyOptionInfo eCAfterSaleApplyOptionInfo : eCAfterSaleApplyInfo.e()) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("key", eCAfterSaleApplyOptionInfo.getKey());
                    OptionValue selectedOption = eCAfterSaleApplyOptionInfo.getSelectedOption();
                    jSONObject3.put("value", selectedOption != null ? selectedOption.getValue() : 0);
                    jSONArray.mo162put(jSONObject3);
                    OptionValue selectedOption2 = eCAfterSaleApplyOptionInfo.getSelectedOption();
                    if (selectedOption2 != null && (a16 = selectedOption2.a()) != null) {
                        for (ECAfterSaleApplyOptionInfo eCAfterSaleApplyOptionInfo2 : a16) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("key", eCAfterSaleApplyOptionInfo2.getKey());
                            OptionValue selectedOption3 = eCAfterSaleApplyOptionInfo2.getSelectedOption();
                            jSONObject4.put("value", selectedOption3 != null ? selectedOption3.getValue() : 0);
                            jSONArray.mo162put(jSONObject4);
                        }
                    }
                }
                jSONObject2.put("req_options", jSONArray);
            }
            ECAfterSaleApplyExtraItem eCAfterSaleApplyExtraItem = this.extraItem;
            if (eCAfterSaleApplyExtraItem != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("reason_text", eCAfterSaleApplyExtraItem.getExtraText());
                JSONArray jSONArray2 = new JSONArray();
                Iterator<T> it = eCAfterSaleApplyExtraItem.c().iterator();
                while (it.hasNext()) {
                    jSONArray2.mo162put((String) it.next());
                }
                jSONObject5.put("imgs", jSONArray2);
                jSONObject2.put("additional_desc", jSONObject5);
            }
            jSONObject.put("apply_info", jSONObject2);
            cg0.a.b("ECAfterSaleApplySubmitReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECAfterSaleApplySubmitReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
