package com.huya.huyasdk.data;

import com.google.gson.annotations.SerializedName;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class WSLaunchReq {

    @SerializedName("lUid")
    public Long lUid = 0L;

    @SerializedName("sGuid")
    public String sGuid = "";

    @SerializedName("sUA")
    public String sUA = "";

    @SerializedName("sAppSrc")
    public String sAppSrc = "";

    @SerializedName("tDeviceInfo")
    public WSDeviceInfo tDeviceInfo = null;
}
