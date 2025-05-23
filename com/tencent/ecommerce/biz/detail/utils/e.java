package com.tencent.ecommerce.biz.detail.utils;

import com.tencent.ecommerce.biz.detail.dataprocessor.processor.ECBizType;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.ECGoodsType;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.ECProductDetailDataParserType;
import com.tencent.ecommerce.biz.util.g;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ&\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/utils/e;", "", "Lorg/json/JSONObject;", "dataJson", "Lorg/json/JSONArray;", "b", "", h.F, "remoteData", "", "isHost", "Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/ECProductDetailDataParserType;", "c", "", "goodsType", "categoryName", MiniGamePAHippyBaseFragment.KEY_THEME, "isCustom", "a", "g", "d", "e", "bizType", "f", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f102467a = new e();

    e() {
    }

    private final JSONArray b(JSONObject dataJson) {
        JSONObject optJSONObject = dataJson.optJSONObject("product");
        JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("main_pics") : null;
        return optJSONArray != null ? optJSONArray : new JSONArray();
    }

    public final JSONObject a(String goodsType, String categoryName, boolean isNightMode, boolean isCustom) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("EC_GOODS_TYPE", goodsType);
        jSONObject.put("EC_OTHER_CATEGORY", categoryName);
        jSONObject.put("EC_IS_CUSTOM", isCustom);
        return jSONObject;
    }

    public final boolean d(String goodsType) {
        return Intrinsics.areEqual(goodsType, String.valueOf(ECGoodsType.GOODS_TYPE_HONOR_KING.ordinal()));
    }

    public final boolean e(String goodsType) {
        return Intrinsics.areEqual(goodsType, String.valueOf(ECGoodsType.GOODS_TYPE_HONOR_KING.ordinal())) || Intrinsics.areEqual(goodsType, String.valueOf(ECGoodsType.GOODS_TYPE_TX_VIDEO.ordinal()));
    }

    public final boolean f(String bizType) {
        return Intrinsics.areEqual(bizType, String.valueOf(ECBizType.BIZ_TYPE_SHOP.type));
    }

    public final boolean g(String goodsType) {
        return Intrinsics.areEqual(goodsType, String.valueOf(ECGoodsType.GOODS_TYPE_TX_VIDEO.ordinal()));
    }

    public final void h(JSONObject dataJson) {
        JSONArray b16 = b(dataJson);
        if (b16.length() <= 0) {
            return;
        }
        ng0.a aVar = ng0.a.f420126b;
        g gVar = g.f104867a;
        aVar.b(gVar.b(gVar.a(b16), 5));
    }

    public final ECProductDetailDataParserType c(JSONObject remoteData, boolean isHost) {
        ECProductDetailDataParserType eCProductDetailDataParserType;
        if (isHost) {
            int optInt = remoteData.optInt("goods_type", 0);
            if (optInt == 1) {
                eCProductDetailDataParserType = ECProductDetailDataParserType.ECProductDetailDataHostGoodsTypeSaas;
            } else if (optInt == 2) {
                eCProductDetailDataParserType = ECProductDetailDataParserType.ECProductDetailDataHostGoodsTypeHonorKing;
            } else if (optInt != 3) {
                eCProductDetailDataParserType = ECProductDetailDataParserType.ECProductDetailDataUnknown;
            } else {
                eCProductDetailDataParserType = ECProductDetailDataParserType.ECProductDetailDataHostGoodsTypeTXVideo;
            }
        } else {
            eCProductDetailDataParserType = ECProductDetailDataParserType.ECProductDetailDataCustomNormal;
        }
        JSONObject optJSONObject = remoteData.optJSONObject("product");
        return (optJSONObject != null ? optJSONObject.optInt("state", 1) : 1) != 1 ? ECProductDetailDataParserType.ECProductDetailDataUnavailable : eCProductDetailDataParserType;
    }
}
