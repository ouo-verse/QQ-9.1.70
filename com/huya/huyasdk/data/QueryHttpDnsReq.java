package com.huya.huyasdk.data;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public class QueryHttpDnsReq {

    @SerializedName("lUid")
    public Long lUid = 0L;

    @SerializedName("sUA")
    public String sUA = "";

    @SerializedName("vDomain")
    public ArrayList<String> vDomain = null;

    @SerializedName("sAppSrc")
    public String sAppSrc = "";

    @SerializedName("sClientIp")
    public String sClientIp = "";

    @SerializedName("iIpStack")
    public int iIpStack = 0;

    @SerializedName("iIpType")
    public int iIpType = 1;
}
