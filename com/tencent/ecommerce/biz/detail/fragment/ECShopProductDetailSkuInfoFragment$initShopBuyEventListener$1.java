package com.tencent.ecommerce.biz.detail.fragment;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.e;
import com.tencent.pts.core.PTSComposer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailSkuInfoFragment$initShopBuyEventListener$1", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductDetailSkuInfoFragment$initShopBuyEventListener$1 extends e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ECShopProductDetailSkuInfoFragment f102250a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECShopProductDetailSkuInfoFragment$initShopBuyEventListener$1(ECShopProductDetailSkuInfoFragment eCShopProductDetailSkuInfoFragment) {
        this.f102250a = eCShopProductDetailSkuInfoFragment;
    }

    @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
    public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
        CoroutineScope ji5;
        ji5 = this.f102250a.ji();
        BuildersKt__Builders_commonKt.launch$default(ji5, null, null, new ECShopProductDetailSkuInfoFragment$initShopBuyEventListener$1$onTapEventTriggered$1(this, null), 3, null);
    }
}
