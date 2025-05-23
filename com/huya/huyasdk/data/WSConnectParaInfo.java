package com.huya.huyasdk.data;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class WSConnectParaInfo {

    @SerializedName("lUid")
    public Long lUid = 0L;

    @SerializedName("sGuid")
    public String sGuid = "";

    @SerializedName("sUA")
    public String sUA = "";

    @SerializedName("sAppSrc")
    public String sAppSrc = "";

    @SerializedName("sMid")
    public String sMid = "";

    @SerializedName("sExp")
    public String sExp = "";

    @SerializedName("iTokenType")
    public Integer iTokenType = 0;

    @SerializedName("sToken")
    public String sToken = "";

    @SerializedName("sCookie")
    public String sCookie = "";

    @SerializedName("sTraceId")
    public String sTraceId = "";

    @SerializedName("mCustomHeaders")
    public Map<String, String> mCustomHeaders = new HashMap();
}
