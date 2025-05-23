package com.tencent.mobileqq.zootopia.webview;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zootopia/webview/ZPlanNotifyH5MediaStatusEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "mediaStatusData", "Lcom/tencent/mobileqq/zootopia/webview/ZPlanModH5MediaStatusData;", "(Lcom/tencent/mobileqq/zootopia/webview/ZPlanModH5MediaStatusData;)V", "getMediaStatusData", "()Lcom/tencent/mobileqq/zootopia/webview/ZPlanModH5MediaStatusData;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanNotifyH5MediaStatusEvent extends SimpleBaseEvent {
    private final ZPlanModH5MediaStatusData mediaStatusData;

    public ZPlanNotifyH5MediaStatusEvent(ZPlanModH5MediaStatusData mediaStatusData) {
        Intrinsics.checkNotNullParameter(mediaStatusData, "mediaStatusData");
        this.mediaStatusData = mediaStatusData;
    }

    public final ZPlanModH5MediaStatusData getMediaStatusData() {
        return this.mediaStatusData;
    }
}
