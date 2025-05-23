package ei0;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.repo.live.ActivityType;
import com.tencent.ecommerce.repo.live.LiveActivity;
import com.tencent.ecommerce.repo.live.LiveProduct;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u0012\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"T", "Lcom/tencent/ecommerce/base/report/service/e;", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "b", "(Lcom/tencent/ecommerce/base/report/service/e;Lcom/tencent/ecommerce/repo/live/q;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/biz/common/e;", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class e {
    public static final com.tencent.ecommerce.biz.common.e a(com.tencent.ecommerce.biz.common.e eVar, LiveProduct liveProduct) {
        ActivityType activityType;
        String activityId;
        eVar.a("8");
        eVar.b("viewer_uin", String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount()));
        eVar.b("saas_id", liveProduct.getSaasTypeStr());
        eVar.b("product_price", liveProduct.getPrice().pricesTxt);
        eVar.b(ReportDataBuilder.KEY_PRODUCT_ID, liveProduct.getSaasProductId());
        eVar.b("product_name", liveProduct.getTitle());
        eVar.b("product_number", liveProduct.getIndexTxt());
        eVar.b("product_type", String.valueOf(LiveProduct.INSTANCE.c(liveProduct)));
        String shopId = liveProduct.getShopId();
        String str = "";
        if (shopId == null) {
            shopId = "";
        }
        eVar.b("shop_id", shopId);
        LiveActivity liveActivity = liveProduct.getLiveActivity();
        if (liveActivity != null && (activityId = liveActivity.getActivityId()) != null) {
            str = activityId;
        }
        eVar.b("activity_id", str);
        LiveActivity liveActivity2 = liveProduct.getLiveActivity();
        eVar.b("activity_type", String.valueOf((liveActivity2 == null || (activityType = liveActivity2.getActivityType()) == null) ? null : Integer.valueOf(activityType.value)));
        Map<String, String> t16 = liveProduct.t();
        if (t16 != null) {
            eVar.c(t16);
        }
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T b(com.tencent.ecommerce.base.report.service.e<T> eVar, LiveProduct liveProduct) {
        String str;
        LiveTabId liveTabId = liveProduct.getLiveTabId();
        eVar.a("qqlive_product_type", String.valueOf(liveTabId != null ? Integer.valueOf(liveTabId.getValue()) : null));
        if (liveProduct.getLiveActivity() == null) {
            str = "0";
        } else {
            str = "1";
        }
        eVar.a("qqlive_activity_product", str);
        LiveActivity liveActivity = liveProduct.getLiveActivity();
        if (liveActivity != null) {
            eVar.a("qqlive_activity_status", String.valueOf(liveActivity.getActivityStatus().value));
        }
        return eVar;
    }
}
