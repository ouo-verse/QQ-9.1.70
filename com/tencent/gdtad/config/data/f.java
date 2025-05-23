package com.tencent.gdtad.config.data;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class f implements IConfigData {

    @SerializedName("url")
    public String url;

    @SerializedName("maxCount")
    public int maxCount = 0;

    @SerializedName("countThreshold")
    public int countThreshold = 0;

    @SerializedName("intervalMillisThreshold")
    public long intervalMillisThreshold = 0;

    public String toString() {
        return l.a(this, null);
    }
}
