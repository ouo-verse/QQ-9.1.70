package com.tencent.oskplayer.player;

import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.IOException;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;

/* loaded from: classes22.dex */
public class HLSMediaPlayer extends AndroidMediaPlayer implements ISegmentMediaPlayer {
    private boolean isAllowLooping;
    private boolean isHLSLive;
    private String mProxyUrl;

    @Override // tv.danmaku.ijk.media.player.AndroidMediaPlayer, tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        if (this.isHLSLive) {
            return 0L;
        }
        return super.getCurrentPosition();
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public String getCurrentProxySegmentUrl() {
        return this.mProxyUrl;
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public String getCurrentSegmentUrl() {
        return this.mProxyUrl;
    }

    @Override // tv.danmaku.ijk.media.player.AndroidMediaPlayer, tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        if (this.isHLSLive) {
            return 0L;
        }
        return super.getDuration();
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public int getSegmentCount() {
        if (this.mProxyUrl == null) {
            return 0;
        }
        return 1;
    }

    @Override // tv.danmaku.ijk.media.player.AndroidMediaPlayer, tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        if (this.isAllowLooping) {
            return super.isLooping();
        }
        return false;
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo) throws IOException {
        if (streamInfo.getCount() <= 1) {
            String url = VideoManager.getInstance().getUrl(streamInfo.getSegment(0).url);
            this.mProxyUrl = url;
            if (PlayerUtils.isHLSStream(url)) {
                this.isAllowLooping = false;
            } else {
                this.isAllowLooping = true;
            }
            this.isHLSLive = streamInfo.isHLSLive;
            getInternalMediaPlayer().setDataSource(this.mProxyUrl);
            return;
        }
        throw new IOException("streamInfo size error");
    }

    @Override // tv.danmaku.ijk.media.player.AndroidMediaPlayer, tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z16) {
        if (this.isAllowLooping) {
            super.setLooping(z16);
        }
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo, int i3) throws IOException {
        setDataSource(streamInfo);
    }
}
