package com.tencent.qqlive.module.videoreport.staging.data;

import com.tencent.qqlive.module.videoreport.storage.annotation.ClassId;
import java.util.Map;

/* compiled from: P */
@ClassId("stash_event")
/* loaded from: classes22.dex */
public class StashEvent {
    private String mAppKey;
    private String mEventKey;
    private Map<String, Object> mEventParams;

    public StashEvent(String str, Map<String, Object> map, String str2) {
        this.mEventKey = str;
        this.mEventParams = map;
        this.mAppKey = str2;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getEventKey() {
        return this.mEventKey;
    }

    public Map<String, Object> getEventParams() {
        return this.mEventParams;
    }

    public String toString() {
        return "StashEvent{mEventKey='" + this.mEventKey + "', mEventParams=" + this.mEventParams + ", mAppKey='" + this.mAppKey + "'}";
    }
}
