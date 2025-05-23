package com.tencent.qqlive.module.videoreport.reportdata;

import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.utils.reuse.IReusable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FinalData implements IReusable {
    public String eventKey;
    public Map<String, Object> eventParams = new ArrayMap();
    public EventAgingType eventType;

    public FinalData() {
    }

    public Map<String, Object> getEventParams() {
        return this.eventParams;
    }

    public void put(String str, Object obj) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            obj = "";
        }
        this.eventParams.put(str, obj);
    }

    public void putAll(Map<String, ?> map) {
        if (map != null) {
            this.eventParams.putAll(map);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.utils.reuse.IReusable
    public void reset() {
        this.eventKey = null;
        this.eventType = null;
        this.eventParams.clear();
    }

    public void setEventKey(String str) {
        this.eventKey = str;
    }

    public void setEventType(EventAgingType eventAgingType) {
        this.eventType = eventAgingType;
    }

    public String toString() {
        return "FinalData{eventKey='" + this.eventKey + "', eventParams=" + this.eventParams + '}';
    }

    public FinalData(String str) {
        this.eventKey = str;
    }
}
