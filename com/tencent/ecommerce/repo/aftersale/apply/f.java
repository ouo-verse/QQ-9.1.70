package com.tencent.ecommerce.repo.aftersale.apply;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyExtraItem;
import java.util.Iterator;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0005B#\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/f;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "Ljava/lang/String;", "afterSaleId", "b", "processId", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/c;", "c", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/c;", "extraItem", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/repo/aftersale/apply/item/c;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String afterSaleId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String processId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ECAfterSaleApplyExtraItem extraItem;

    public f(String str, String str2, ECAfterSaleApplyExtraItem eCAfterSaleApplyExtraItem) {
        this.afterSaleId = str;
        this.processId = str2;
        this.extraItem = eCAfterSaleApplyExtraItem;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("after_sales_id", this.afterSaleId);
            jSONObject.put(CrashHianalyticsData.PROCESS_ID, this.processId);
            ECAfterSaleApplyExtraItem eCAfterSaleApplyExtraItem = this.extraItem;
            if (eCAfterSaleApplyExtraItem != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reason_text", eCAfterSaleApplyExtraItem.getExtraText());
                JSONArray jSONArray = new JSONArray();
                Iterator<T> it = eCAfterSaleApplyExtraItem.c().iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put((String) it.next());
                }
                jSONObject2.put("imgs", jSONArray);
                jSONObject.put("additional_desc", jSONObject2);
            }
            cg0.a.b("ECAfterSaleApplyJudgementSubmitReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECAfterSaleApplyJudgementSubmitReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
