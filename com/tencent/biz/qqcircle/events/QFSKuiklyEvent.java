package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSKuiklyEvent extends SimpleBaseEvent {
    public final String eventName;
    public final JSONObject eventParams;

    public QFSKuiklyEvent(String str, JSONObject jSONObject) {
        this.eventName = str;
        this.eventParams = jSONObject;
    }

    public String getParamsString(String str) {
        JSONObject jSONObject = this.eventParams;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }
}
