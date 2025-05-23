package org.light.aigc.bean;

import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AIGCRequest {
    public String bussId;
    public List<ContentInfo> contentInfos;
    public String extra;
    public String functionId;

    public String toString() {
        return "AIGCRequest{bussId='" + this.bussId + "', functionId='" + this.functionId + "', contentInfos=" + this.contentInfos + ", extra='" + this.extra + "'}";
    }
}
