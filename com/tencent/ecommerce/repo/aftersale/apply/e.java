package com.tencent.ecommerce.repo.aftersale.apply;

import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.ecommerce.repo.aftersale.common.ECAfterSaleProductCard;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 !2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/e;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "d", "Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "c", "()Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "setOrderCard", "(Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;)V", "orderCard", "Lcom/tencent/ecommerce/repo/aftersale/apply/c;", "e", "Lcom/tencent/ecommerce/repo/aftersale/apply/c;", "b", "()Lcom/tencent/ecommerce/repo/aftersale/apply/c;", "setJudgementInfo", "(Lcom/tencent/ecommerce/repo/aftersale/apply/c;)V", "judgementInfo", "", "", "f", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "setExtReportMap", "(Ljava/util/Map;)V", "extReportMap", "<init>", "()V", tl.h.F, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ECAfterSaleProductCard orderCard;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ECAfterSaleApplyInfo judgementInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Map<String, String> extReportMap = new LinkedHashMap();

    public final Map<String, String> a() {
        return this.extReportMap;
    }

    /* renamed from: b, reason: from getter */
    public final ECAfterSaleApplyInfo getJudgementInfo() {
        return this.judgementInfo;
    }

    /* renamed from: c, reason: from getter */
    public final ECAfterSaleProductCard getOrderCard() {
        return this.orderCard;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        cg0.a.b("ECAfterSaleApplyJudgementPageRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        JSONObject optJSONObject = data.optJSONObject("page");
        if (optJSONObject == null) {
            return true;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("product_card");
        if (optJSONObject2 != null) {
            this.orderCard = ECAfterSaleProductCard.INSTANCE.b(optJSONObject2);
        }
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("judgement_info");
        if (optJSONObject3 != null) {
            this.judgementInfo = ECAfterSaleApplyInfo.INSTANCE.a(optJSONObject3);
        }
        JSONObject optJSONObject4 = optJSONObject.optJSONObject("report_ext");
        if (optJSONObject4 == null) {
            return true;
        }
        Iterator keys = optJSONObject4.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Map<String, String> map = this.extReportMap;
            Object obj = optJSONObject4.get(str);
            if (obj != null) {
                map.put(str, (String) obj);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        return true;
    }
}
