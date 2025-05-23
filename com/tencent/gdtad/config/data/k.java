package com.tencent.gdtad.config.data;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class k implements IConfigData {

    @SerializedName("timeoutMillis")
    public long timeoutMillis = 10000;

    public String toString() {
        return l.a(this, null);
    }
}
