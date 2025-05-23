package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.hippykotlin.demo.pages.base.SSORequestModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDCancelApplyRequestModel extends SSORequestModel {
    public String afterSalesId;
    public String processId;

    public ASDCancelApplyRequestModel(String str) {
        super(str);
        this.afterSalesId = "";
        this.processId = "";
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.SSORequestModel
    public final String cmd() {
        return "trpc.ecom.after_sales_svr.AfterSales/CancelAfterSales";
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.SSORequestModel
    public final e reqParam() {
        e eVar = new e();
        eVar.v("after_sales_id", this.afterSalesId);
        eVar.v(CrashHianalyticsData.PROCESS_ID, this.processId);
        return eVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.SSORequestModel
    public final void requestData(final Function3<? super e, ? super Integer, ? super String, Unit> function3) {
        super.requestData(new Function3<e, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDCancelApplyRequestModel$requestData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(e eVar, Integer num, String str) {
                int intValue = num.intValue();
                function3.invoke(eVar, Integer.valueOf(intValue), str);
                return Unit.INSTANCE;
            }
        });
    }
}
