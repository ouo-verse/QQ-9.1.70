package com.tencent.gdtad.config.data;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class g implements IConfigData {

    @SerializedName("initTimeOutSeconds")
    public int initTimeOutSeconds = 5;

    @SerializedName("updateJsBundleIntervalSeconds")
    public int updateJsBundleIntervalSeconds = 30;

    public String toString() {
        return l.a(this, null);
    }
}
