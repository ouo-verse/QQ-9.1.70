package com.heytap.databaseengine.model;

import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public abstract class SportHealthData {
    public String getDeviceUniqueId() {
        return "";
    }

    public long getEndTimestamp() {
        return 0L;
    }

    public String getSsoid() {
        return "";
    }

    public long getStartTimestamp() {
        return 0L;
    }

    public abstract String toString();
}
