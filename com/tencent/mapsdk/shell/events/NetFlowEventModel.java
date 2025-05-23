package com.tencent.mapsdk.shell.events;

import android.support.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class NetFlowEventModel {
    public String bizType;
    public double downloadFlow;
    public long downloadTime;
    public int errorCode;
    public final String eventCode = "cm_nf";
    public double uploadFlow;
    public long uploadTime;
    public String url;

    public NetFlowEventModel(double d16, double d17, long j3, long j16, int i3, String str, String str2) {
        this.uploadFlow = d16;
        this.downloadFlow = d17;
        this.uploadTime = j3;
        this.downloadTime = j16;
        this.errorCode = i3;
        this.url = str;
        this.bizType = str2;
    }

    public NetFlowEventModel() {
    }
}
