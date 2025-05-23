package com.tencent.ecommerce.biz.live.ui;

import android.os.Bundle;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.mobileqq.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveVideoSelectGoodsTypeFragment$jumpTo$1", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "onResult", "", "result", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveVideoSelectGoodsTypeFragment$jumpTo$1 implements IECLogicCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ECLiveVideoSelectGoodsTypeFragment f102697a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECLiveVideoSelectGoodsTypeFragment$jumpTo$1(ECLiveVideoSelectGoodsTypeFragment eCLiveVideoSelectGoodsTypeFragment) {
        this.f102697a = eCLiveVideoSelectGoodsTypeFragment;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECLogicCallback
    public void onResult(final HashMap<String, Object> result) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveVideoSelectGoodsTypeFragment$jumpTo$1$onResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                IECSchemeCallback b16;
                if (ECLiveVideoSelectGoodsTypeFragment$jumpTo$1.this.f102697a.hasCallback) {
                    return;
                }
                Object obj = result.get("PARAM_JSON_RESULT");
                if (obj != null) {
                    JSONObject jSONObject = (JSONObject) obj;
                    jSONObject.put("is_wangzhe_select", ECLiveVideoSelectGoodsTypeFragment$jumpTo$1.this.f102697a.isGokGoodsSelected);
                    cg0.a.b("ECLiveVideoSelectGoodsTypeFragment", "LIVE_SCHEME_TYPE_ENTRY onCallbackFinished, jsonObject: " + jSONObject);
                    if (jSONObject.has("PARAM_ENTRY_SCHEME_ERROR")) {
                        i.f101155b.d(ECLiveVideoSelectGoodsTypeFragment$jumpTo$1.this.f102697a.requireContext().getString(R.string.wlb), ECToastIcon.ICON_ERROR, 0);
                    } else {
                        Bundle arguments = ECLiveVideoSelectGoodsTypeFragment$jumpTo$1.this.f102697a.getArguments();
                        if (arguments == null || (str = arguments.getString("scheme_callback_id")) == null) {
                            str = "";
                        }
                        ECLiveVideoSelectGoodsTypeFragment$jumpTo$1.this.f102697a.goodsNumber = jSONObject.optInt("live_product_counts", 0);
                        ECLiveVideoSelectGoodsTypeFragment$jumpTo$1.this.f102697a.shopGoodsNumber = jSONObject.optInt("shop_product_counts", 0);
                        if ((str.length() > 0) && (b16 = ug0.a.b(str)) != null) {
                            b16.onCallbackFinished(jSONObject);
                        }
                    }
                    ECLiveVideoSelectGoodsTypeFragment$jumpTo$1.this.f102697a.hasCallback = true;
                    ECLiveVideoSelectGoodsTypeFragment.Lh(ECLiveVideoSelectGoodsTypeFragment$jumpTo$1.this.f102697a).E();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        });
    }
}
