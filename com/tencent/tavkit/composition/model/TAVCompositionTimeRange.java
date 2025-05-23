package com.tencent.tavkit.composition.model;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TAVCompositionTimeRange {
    CMTime getDuration();

    CMTime getStartTime();

    CMTimeRange getTimeRange();

    void setDuration(CMTime cMTime);

    void setStartTime(CMTime cMTime);
}
