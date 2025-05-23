package com.tencent.tavkit.composition.video;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TAVAttachTimeRangeSourceEffect {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface TimeAttachFilter {
        void attachPositionTime(CMTime cMTime);
    }

    void attachTimeRange(CMTimeRange cMTimeRange);
}
