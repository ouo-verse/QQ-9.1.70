package com.tencent.biz.richframework.video.rfw.player.ioc;

import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;

/* loaded from: classes5.dex */
public abstract class RFWPlayerIOC {
    public RFWPlayerReportInfo getBusinessReportInfo() {
        return null;
    }

    public RFWPlayerUpperData getPlayerUpperData() {
        return null;
    }

    public Object getReportBean() {
        return null;
    }

    public boolean isPreloadTask() {
        return false;
    }

    public boolean isValid() {
        return true;
    }
}
