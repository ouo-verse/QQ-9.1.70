package com.tencent.mobileqq.guild.feed.publish.result;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;

/* compiled from: P */
@Keep
/* loaded from: classes13.dex */
public class ResultWrapper {

    @SerializedName("data")
    public String data;

    @SerializedName("type")
    public int type;

    public ResultWrapper(int i3, String str) {
        this.type = i3;
        this.data = str;
    }
}
