package com.tencent.ecommerce.biz.taskcenter.hippy;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mtt.hippy.common.HippyMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/taskcenter/hippy/ECHippyEventReceiver;", "", "onReceiverEvent", "", AdMetricTag.EVENT_NAME, "", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface ECHippyEventReceiver {
    void onReceiverEvent(String eventName, HippyMap params);
}
