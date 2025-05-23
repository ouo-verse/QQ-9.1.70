package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStRecomReportInfo {
    public ArrayList<GProStSingleRecomReportInfo> recomInfos = new ArrayList<>();

    public ArrayList<GProStSingleRecomReportInfo> getRecomInfos() {
        return this.recomInfos;
    }

    public String toString() {
        return "GProStRecomReportInfo{recomInfos=" + this.recomInfos + ",}";
    }
}
