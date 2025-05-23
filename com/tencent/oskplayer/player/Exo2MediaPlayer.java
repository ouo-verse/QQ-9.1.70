package com.tencent.oskplayer.player;

import android.content.Context;
import android.graphics.Rect;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ext.mediaplayer.DecoderInfo;
import com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.proxy.VideoManager;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

/* loaded from: classes22.dex */
public class Exo2MediaPlayer extends ExoMediaPlayer implements IExo2MediaPlayer {
    private List<String> mProxyUrls;
    private List<String> mSourceUrls;

    public Exo2MediaPlayer(Context context) {
        super(context);
    }

    @Override // com.tencent.oskplayer.player.IExo2MediaPlayer
    public String getAudioDecoderName() {
        DecoderInfo decoderInfo = this.mAudioDecoderInfo;
        if (decoderInfo != null) {
            return decoderInfo.decoderName;
        }
        return null;
    }

    @Override // com.tencent.oskplayer.player.IExo2MediaPlayer
    public String getAudioMIMEType() {
        Format format = this.mAudioFormat;
        if (format != null) {
            return format.sampleMimeType;
        }
        return null;
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public String getCurrentProxySegmentUrl() {
        List<String> list = this.mProxyUrls;
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public String getCurrentSegmentUrl() {
        List<String> list = this.mSourceUrls;
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getScore() {
        return 0;
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public int getSegmentCount() {
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        return null;
    }

    @Override // com.tencent.oskplayer.player.IExo2MediaPlayer
    public int getVideoBitrate() {
        Format format = this.mVideoFormat;
        if (format != null) {
            return format.bitrate;
        }
        return -1;
    }

    @Override // com.tencent.oskplayer.player.IExo2MediaPlayer
    public String getVideoDecoderName() {
        DecoderInfo decoderInfo = this.mVideoDecoderInfo;
        if (decoderInfo != null) {
            return decoderInfo.decoderName;
        }
        return null;
    }

    @Override // com.tencent.oskplayer.player.IExo2MediaPlayer
    public Rect getVideoDimension() {
        if (this.mVideoFormat != null) {
            Rect rect = new Rect();
            rect.left = 0;
            rect.top = 0;
            Format format = this.mVideoFormat;
            rect.right = format.width;
            rect.bottom = format.height;
            return rect;
        }
        return null;
    }

    @Override // com.tencent.oskplayer.player.IExo2MediaPlayer
    public String getVideoMIMEType() {
        Format format = this.mVideoFormat;
        if (format != null) {
            return format.sampleMimeType;
        }
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return 1;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return 1;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return false;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer, com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void seekTo(long j3) throws IllegalStateException {
        super.seekTo(j3);
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo) throws IOException {
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        if (streamInfo == null || (arrayList = streamInfo.segmentInfos) == null || arrayList.get(0) == null) {
            return;
        }
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList2 = streamInfo.segmentInfos;
        this.mSourceUrls = new ArrayList();
        if (arrayList2 != null) {
            Iterator<SegmentVideoInfo.SegmentInfo> it = arrayList2.iterator();
            while (it.hasNext()) {
                this.mSourceUrls.add(it.next().url);
            }
        }
        this.mProxyUrls = VideoManager.getInstance().getUrl(this.mSourceUrls);
        if (arrayList2 != null && arrayList2.size() > 1) {
            throw new UnsupportedOperationException("Exo2MediaPlayer is not support multiple video segment");
        }
        setDataSource(this.mProxyUrls.get(0));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setNextMediaPlayer(IMediaPlayer iMediaPlayer) throws UnsupportedOperationException {
        super.setNextMediaPlayer((MediaPlayerInterface) this);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnBufferingUpdateListener(final IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (onBufferingUpdateListener != null) {
            super.setOnBufferingUpdateListener(new MediaPlayerInterface.OnBufferingUpdateListener() { // from class: com.tencent.oskplayer.player.Exo2MediaPlayer.4
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnBufferingUpdateListener
                public void onBufferingUpdate(MediaPlayerInterface mediaPlayerInterface, int i3) {
                    onBufferingUpdateListener.onBufferingUpdate(Exo2MediaPlayer.this, i3);
                }
            });
        } else {
            super.setOnBufferingUpdateListener((MediaPlayerInterface.OnBufferingUpdateListener) null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnCompletionListener(final IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener != null) {
            super.setOnCompletionListener(new MediaPlayerInterface.OnCompletionListener() { // from class: com.tencent.oskplayer.player.Exo2MediaPlayer.3
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnCompletionListener
                public void onCompletion(MediaPlayerInterface mediaPlayerInterface) {
                    onCompletionListener.onCompletion(Exo2MediaPlayer.this);
                }
            });
        } else {
            super.setOnCompletionListener((MediaPlayerInterface.OnCompletionListener) null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnErrorListener(final IMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener != null) {
            super.setOnErrorListener(new MediaPlayerInterface.OnErrorListener() { // from class: com.tencent.oskplayer.player.Exo2MediaPlayer.7
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnErrorListener
                public boolean onError(MediaPlayerInterface mediaPlayerInterface, int i3, int i16) {
                    return onErrorListener.onError(Exo2MediaPlayer.this, i3, i16);
                }
            });
        } else {
            super.setOnErrorListener((MediaPlayerInterface.OnErrorListener) null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnInfoListener(final IMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener != null) {
            super.setOnInfoListener(new MediaPlayerInterface.OnInfoListener() { // from class: com.tencent.oskplayer.player.Exo2MediaPlayer.8
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnInfoListener
                public boolean onInfo(MediaPlayerInterface mediaPlayerInterface, int i3, int i16) {
                    return onInfoListener.onInfo(Exo2MediaPlayer.this, i3, i16);
                }
            });
        } else {
            super.setOnInfoListener((MediaPlayerInterface.OnInfoListener) null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnLoopStartListener(final IMediaPlayer.OnLoopStartListener onLoopStartListener) {
        if (onLoopStartListener != null) {
            super.setOnLoopStartListener(new MediaPlayerInterface.OnLoopStartListener() { // from class: com.tencent.oskplayer.player.Exo2MediaPlayer.1
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnLoopStartListener
                public void onLoopStart(MediaPlayerInterface mediaPlayerInterface) {
                    onLoopStartListener.onLoopStart(Exo2MediaPlayer.this);
                }
            });
        } else {
            super.setOnLoopStartListener((MediaPlayerInterface.OnLoopStartListener) null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnPreparedListener(final IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (onPreparedListener != null) {
            super.setOnPreparedListener(new MediaPlayerInterface.OnPreparedListener() { // from class: com.tencent.oskplayer.player.Exo2MediaPlayer.2
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnPreparedListener
                public void onPrepared(MediaPlayerInterface mediaPlayerInterface) {
                    onPreparedListener.onPrepared(Exo2MediaPlayer.this);
                }
            });
        } else {
            super.setOnPreparedListener((MediaPlayerInterface.OnPreparedListener) null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnSeekCompleteListener(final IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener != null) {
            super.setOnSeekCompleteListener(new MediaPlayerInterface.OnSeekCompleteListener() { // from class: com.tencent.oskplayer.player.Exo2MediaPlayer.5
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnSeekCompleteListener
                public void onSeekComplete(MediaPlayerInterface mediaPlayerInterface) {
                    onSeekCompleteListener.onSeekComplete(Exo2MediaPlayer.this);
                }
            });
        } else {
            super.setOnSeekCompleteListener((MediaPlayerInterface.OnSeekCompleteListener) null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnVideoSizeChangedListener(final IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener != null) {
            super.setOnVideoSizeChangedListener(new MediaPlayerInterface.OnVideoSizeChangedListener() { // from class: com.tencent.oskplayer.player.Exo2MediaPlayer.6
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnVideoSizeChangedListener
                public void onVideoSizeChanged(MediaPlayerInterface mediaPlayerInterface, int i3, int i16) {
                    onVideoSizeChangedListener.onVideoSizeChanged(Exo2MediaPlayer.this, i3, i16);
                }
            });
        } else {
            super.setOnVideoSizeChangedListener((MediaPlayerInterface.OnVideoSizeChangedListener) null);
        }
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo, int i3) throws IOException {
        setDataSource(streamInfo);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException, UnsupportedOperationException {
        throw new UnsupportedOperationException("no support");
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i3) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z16) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z16) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
    }
}
