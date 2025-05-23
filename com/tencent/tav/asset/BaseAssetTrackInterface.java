package com.tencent.tav.asset;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface BaseAssetTrackInterface {
    void insertEmptyTimeRange(CMTimeRange cMTimeRange);

    boolean insertTimeRange(CMTimeRange cMTimeRange, AssetTrack assetTrack, CMTime cMTime);

    void removeTimeRange(CMTimeRange cMTimeRange);

    void scaleTimeRange(CMTimeRange cMTimeRange, CMTime cMTime);
}
