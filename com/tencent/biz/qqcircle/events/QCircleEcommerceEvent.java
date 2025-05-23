package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleEcommerceEvent extends SimpleBaseEvent {
    private Integer mAction;
    private JSONObject mParams;

    public QCircleEcommerceEvent(Integer num, JSONObject jSONObject) {
        this.mAction = num;
        this.mParams = jSONObject;
    }

    public Integer getAction() {
        return this.mAction;
    }

    public JSONObject getParams() {
        return this.mParams;
    }
}
