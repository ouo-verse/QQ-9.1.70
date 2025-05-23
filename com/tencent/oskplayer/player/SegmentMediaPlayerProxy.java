package com.tencent.oskplayer.player;

import com.tencent.oskplayer.model.SegmentVideoInfo;
import java.io.IOException;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.MediaPlayerProxy;

/* loaded from: classes22.dex */
public class SegmentMediaPlayerProxy extends MediaPlayerProxy implements ISegmentMediaPlayer {
    public SegmentMediaPlayerProxy(IMediaPlayer iMediaPlayer) {
        super(iMediaPlayer);
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public String getCurrentProxySegmentUrl() throws UnsupportedOperationException {
        IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
        if (iMediaPlayer instanceof ISegmentMediaPlayer) {
            return ((ISegmentMediaPlayer) iMediaPlayer).getCurrentProxySegmentUrl();
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public String getCurrentSegmentUrl() throws UnsupportedOperationException {
        IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
        if (iMediaPlayer instanceof ISegmentMediaPlayer) {
            return ((ISegmentMediaPlayer) iMediaPlayer).getCurrentSegmentUrl();
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public int getSegmentCount() throws UnsupportedOperationException {
        IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
        if (iMediaPlayer instanceof ISegmentMediaPlayer) {
            return ((ISegmentMediaPlayer) iMediaPlayer).getSegmentCount();
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo) throws IOException, UnsupportedOperationException {
        IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
        if (iMediaPlayer instanceof ISegmentMediaPlayer) {
            ((ISegmentMediaPlayer) iMediaPlayer).setDataSource(streamInfo);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo, int i3) throws IOException, UnsupportedOperationException {
        IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
        if (iMediaPlayer instanceof ISegmentMediaPlayer) {
            ((ISegmentMediaPlayer) iMediaPlayer).setDataSource(streamInfo, i3);
            return;
        }
        throw new UnsupportedOperationException();
    }
}
