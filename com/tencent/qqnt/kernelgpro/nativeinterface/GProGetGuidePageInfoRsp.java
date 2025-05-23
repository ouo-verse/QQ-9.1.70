package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetGuidePageInfoRsp {
    public GProGuidePageInfo mainGuidePage = new GProGuidePageInfo();
    public ArrayList<GProGuidePageInfo> guidePage = new ArrayList<>();

    public ArrayList<GProGuidePageInfo> getGuidePage() {
        return this.guidePage;
    }

    public GProGuidePageInfo getMainGuidePage() {
        return this.mainGuidePage;
    }

    public String toString() {
        return "GProGetGuidePageInfoRsp{mainGuidePage=" + this.mainGuidePage + ",guidePage=" + this.guidePage + ",}";
    }
}
