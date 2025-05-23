package com.tencent.qqlive.module.videoreport.staging;

import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CustomEventStagingData {
    private final String eventId;
    private final Map<String, ?> map;
    private final WeakReference<Object> object;

    public CustomEventStagingData(String str, @Nullable Object obj, Map<String, ?> map) {
        this.eventId = str;
        if (obj != null) {
            this.object = new WeakReference<>(obj);
        } else {
            this.object = null;
        }
        this.map = map;
    }

    public String getEventId() {
        return this.eventId;
    }

    public Map<String, ?> getMap() {
        return this.map;
    }

    public Object getObject() {
        WeakReference<Object> weakReference = this.object;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
