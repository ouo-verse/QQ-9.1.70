package com.tencent.ecommerce.biz.hr.module;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/HRNotifyModuleCrossProcessEvent;", "", "onReceiveCrossProcessEvent", "", AdMetricTag.EVENT_NAME, "", "data", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
interface HRNotifyModuleCrossProcessEvent {
    void onReceiveCrossProcessEvent(String eventName, String data);
}
