package com.tencent.ttpic.openapi;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.gles.SegmentDataPipe;
import java.util.Map;

/* loaded from: classes27.dex */
public class PTSegAttr {
    private Map<String, Long> detectTimes;
    private Frame maskFrame;

    public Frame getMaskFrame() {
        return this.maskFrame;
    }

    public long getSegDetectTime() {
        Map<String, Long> map = this.detectTimes;
        if (map != null && map.get(SegmentDataPipe.SEGMENT_TIME) != null) {
            return this.detectTimes.get(SegmentDataPipe.SEGMENT_TIME).longValue();
        }
        return 0L;
    }

    public PTSegAttr setDetectTimes(Map map) {
        this.detectTimes = map;
        return this;
    }

    public void setMaskFrame(Frame frame) {
        this.maskFrame = frame;
    }
}
