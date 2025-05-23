package com.tencent.ecommerce.repo.aftersale.apply;

import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.ecommerce.repo.aftersale.common.ECAfterSaleProductCard;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b*\u0010+J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\"\u0004\b\u0017\u0010\u0014R.\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R0\u0010)\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001a\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b\u0007\u0010&\"\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/b;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "d", "Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "c", "()Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "setProductCard", "(Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;)V", "productCard", "Lcom/tencent/ecommerce/repo/aftersale/apply/c;", "e", "Lcom/tencent/ecommerce/repo/aftersale/apply/c;", "b", "()Lcom/tencent/ecommerce/repo/aftersale/apply/c;", "setOnlyRefundInfo", "(Lcom/tencent/ecommerce/repo/aftersale/apply/c;)V", "onlyRefundInfo", "f", "setReturnAndRefundInfo", "returnAndRefundInfo", "", "", tl.h.F, "Ljava/util/Map;", "a", "()Ljava/util/Map;", "setExtReportMap", "(Ljava/util/Map;)V", "extReportMap", "Lkotlin/Pair;", "", "i", "Lkotlin/Pair;", "()Lkotlin/Pair;", "setResult", "(Lkotlin/Pair;)V", "result", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ECAfterSaleProductCard productCard;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ECAfterSaleApplyInfo onlyRefundInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ECAfterSaleApplyInfo returnAndRefundInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Map<String, String> extReportMap = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Pair<Integer, String> result;

    public final Map<String, String> a() {
        return this.extReportMap;
    }

    /* renamed from: b, reason: from getter */
    public final ECAfterSaleApplyInfo getOnlyRefundInfo() {
        return this.onlyRefundInfo;
    }

    /* renamed from: c, reason: from getter */
    public final ECAfterSaleProductCard getProductCard() {
        return this.productCard;
    }

    public final Pair<Integer, String> d() {
        return this.result;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        cg0.a.b("ECAfterSaleApplyGetPageRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        JSONObject optJSONObject = data.optJSONObject("apply_page");
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("product_card");
            if (optJSONObject2 != null) {
                this.productCard = ECAfterSaleProductCard.INSTANCE.b(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("refund_only");
            if (optJSONObject3 != null) {
                this.onlyRefundInfo = ECAfterSaleApplyInfo.INSTANCE.a(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("return_and_refund");
            if (optJSONObject4 != null) {
                this.returnAndRefundInfo = ECAfterSaleApplyInfo.INSTANCE.a(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("report_ext");
            if (optJSONObject5 != null) {
                Iterator keys = optJSONObject5.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    Map<String, String> map = this.extReportMap;
                    Object obj = optJSONObject5.get(str);
                    if (obj != null) {
                        map.put(str, (String) obj);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }
            }
        }
        JSONObject optJSONObject6 = data.optJSONObject("result");
        if (optJSONObject6 == null) {
            return true;
        }
        this.result = new Pair<>(Integer.valueOf(optJSONObject6.optInt("result_code")), optJSONObject6.optString("result_string"));
        return true;
    }

    /* renamed from: e, reason: from getter */
    public final ECAfterSaleApplyInfo getReturnAndRefundInfo() {
        return this.returnAndRefundInfo;
    }
}
