package com.tencent.mobileqq.qzoneplayer.player;

import com.tencent.oskplayer.model.SegmentVideoInfo;

/* loaded from: classes16.dex */
public interface IPlayerSupport {
    PlayerSupportStatus isSupport();

    PlayerSupportStatus isSupportStream(SegmentVideoInfo.StreamInfo streamInfo);
}
