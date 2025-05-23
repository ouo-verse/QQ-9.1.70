package com.tencent.oskplayer.player;

import com.tencent.oskplayer.model.SegmentVideoInfo;
import java.io.IOException;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: classes22.dex */
public interface ISegmentMediaPlayer extends IMediaPlayer {
    String getCurrentProxySegmentUrl();

    String getCurrentSegmentUrl();

    int getSegmentCount();

    void setDataSource(SegmentVideoInfo.StreamInfo streamInfo) throws IOException;

    void setDataSource(SegmentVideoInfo.StreamInfo streamInfo, int i3) throws IOException;
}
