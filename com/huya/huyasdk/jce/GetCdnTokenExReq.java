package com.huya.huyasdk.jce;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GetCdnTokenExReq {

    @Nullable
    public String sFlvUrl = "";

    @Nullable
    public String sStreamName = "";
    public int iLoopTime = 0;

    @Nullable
    public UserId tId = null;
    public int iAppId = 66;

    public String toString() {
        return "GetCdnTokenExReq{sFlvUrl='" + this.sFlvUrl + "', sStreamName='" + this.sStreamName + "', iLoopTime=" + this.iLoopTime + ", tId=" + this.tId + ", iAppId=" + this.iAppId + '}';
    }
}
