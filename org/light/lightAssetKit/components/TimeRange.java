package org.light.lightAssetKit.components;

import com.tencent.biz.common.util.WebViewConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TimeRange {
    public long duration;
    public long startTime;

    public TimeRange() {
        this.startTime = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.duration = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    public TimeRange(long j3, long j16) {
        this.startTime = j3;
        this.duration = j16;
    }
}
