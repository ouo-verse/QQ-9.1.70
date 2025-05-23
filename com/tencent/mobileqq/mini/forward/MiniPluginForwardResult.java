package com.tencent.mobileqq.mini.forward;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes33.dex */
public class MiniPluginForwardResult implements Serializable {
    private static final long serialVersionUID = 1;

    @SerializedName("memTitle")
    String name;

    @SerializedName("memType")
    String type;

    @SerializedName("memId")
    String uin;
}
