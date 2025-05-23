package com.tencent.mapsdk.shell.events;

import android.support.annotation.Keep;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class NetFlowEvent extends ReportEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetFlowEvent(NetFlowEventModel netFlowEventModel) {
        super("cm_nf", null);
        netFlowEventModel.getClass();
        HashMap hashMap = new HashMap();
        this.params = hashMap;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(netFlowEventModel.uploadFlow);
        hashMap.put("up", sb5.toString());
        Map<String, String> map = this.params;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(netFlowEventModel.downloadFlow);
        map.put("dw", sb6.toString());
        Map<String, String> map2 = this.params;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(netFlowEventModel.uploadTime);
        map2.put("up_time", sb7.toString());
        Map<String, String> map3 = this.params;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(netFlowEventModel.downloadTime);
        map3.put("dw_time", sb8.toString());
        Map<String, String> map4 = this.params;
        StringBuilder sb9 = new StringBuilder();
        sb9.append(netFlowEventModel.downloadTime - netFlowEventModel.uploadTime);
        map4.put("rt", sb9.toString());
        this.params.put("biz_type", netFlowEventModel.bizType);
        this.params.put("url", netFlowEventModel.url);
        Map<String, String> map5 = this.params;
        StringBuilder sb10 = new StringBuilder();
        sb10.append(netFlowEventModel.errorCode);
        map5.put(NotificationCompat.CATEGORY_ERROR, sb10.toString());
    }
}
