package com.tencent.mobileqq.qzoneplayer.player;

import android.content.Context;
import android.graphics.Rect;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ext.mediaplayer.DecoderInfo;
import com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.player.IExo2MediaPlayer;
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

/* loaded from: classes16.dex */
public class Exo2MediaPlayer extends ExoMediaPlayer implements IExo2MediaPlayer {
    static IPatchRedirector $redirector_;
    private List<String> mProxyUrls;
    private List<String> mSourceUrls;

    public Exo2MediaPlayer(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.oskplayer.player.IExo2MediaPlayer
    public String getAudioDecoderName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        DecoderInfo decoderInfo = this.mAudioDecoderInfo;
        if (decoderInfo != null) {
            return decoderInfo.decoderName;
        }
        return null;
    }

    @Override // com.tencent.oskplayer.player.IExo2MediaPlayer
    public String getAudioMIMEType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        Format format = this.mAudioFormat;
        if (format != null) {
            return format.sampleMimeType;
        }
        return null;
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public String getCurrentProxySegmentUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        List<String> list = this.mProxyUrls;
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public String getCurrentSegmentUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        List<String> list = this.mSourceUrls;
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (MediaInfo) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getScore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public int getSegmentCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ITrackInfo[]) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.oskplayer.player.IExo2MediaPlayer
    public int getVideoBitrate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        Format format = this.mVideoFormat;
        if (format != null) {
            return format.bitrate;
        }
        return -1;
    }

    @Override // com.tencent.oskplayer.player.IExo2MediaPlayer
    public String getVideoDecoderName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        DecoderInfo decoderInfo = this.mVideoDecoderInfo;
        if (decoderInfo != null) {
            return decoderInfo.decoderName;
        }
        return null;
    }

    @Override // com.tencent.oskplayer.player.IExo2MediaPlayer
    public Rect getVideoDimension() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Rect) iPatchRedirector.redirect((short) 32, (Object) this);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        Format format = this.mVideoFormat;
        if (format != null) {
            return format.sampleMimeType;
        }
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer, com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void seekTo(long j3) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, j3);
        } else {
            super.seekTo(j3);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo) throws IOException {
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) streamInfo);
            return;
        }
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
    public void setKeepInBackground(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setNextMediaPlayer(IMediaPlayer iMediaPlayer) throws UnsupportedOperationException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) iMediaPlayer);
        } else {
            super.setNextMediaPlayer((MediaPlayerInterface) this);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) onBufferingUpdateListener);
        } else if (onBufferingUpdateListener != null) {
            super.setOnBufferingUpdateListener(new MediaPlayerInterface.OnBufferingUpdateListener(onBufferingUpdateListener) { // from class: com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ IMediaPlayer.OnBufferingUpdateListener val$onBufferingUpdateListener;

                {
                    this.val$onBufferingUpdateListener = onBufferingUpdateListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Exo2MediaPlayer.this, (Object) onBufferingUpdateListener);
                    }
                }

                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnBufferingUpdateListener
                public void onBufferingUpdate(MediaPlayerInterface mediaPlayerInterface, int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mediaPlayerInterface, i3);
                    } else {
                        this.val$onBufferingUpdateListener.onBufferingUpdate(Exo2MediaPlayer.this, i3);
                    }
                }
            });
        } else {
            super.setOnBufferingUpdateListener((MediaPlayerInterface.OnBufferingUpdateListener) null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) onCompletionListener);
        } else if (onCompletionListener != null) {
            super.setOnCompletionListener(new MediaPlayerInterface.OnCompletionListener(onCompletionListener) { // from class: com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ IMediaPlayer.OnCompletionListener val$onCompletionListener;

                {
                    this.val$onCompletionListener = onCompletionListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Exo2MediaPlayer.this, (Object) onCompletionListener);
                    }
                }

                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnCompletionListener
                public void onCompletion(MediaPlayerInterface mediaPlayerInterface) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mediaPlayerInterface);
                    } else {
                        this.val$onCompletionListener.onCompletion(Exo2MediaPlayer.this);
                    }
                }
            });
        } else {
            super.setOnCompletionListener((MediaPlayerInterface.OnCompletionListener) null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) onErrorListener);
        } else if (onErrorListener != null) {
            super.setOnErrorListener(new MediaPlayerInterface.OnErrorListener(onErrorListener) { // from class: com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer.7
                static IPatchRedirector $redirector_;
                final /* synthetic */ IMediaPlayer.OnErrorListener val$onErrorListener;

                {
                    this.val$onErrorListener = onErrorListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Exo2MediaPlayer.this, (Object) onErrorListener);
                    }
                }

                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnErrorListener
                public boolean onError(MediaPlayerInterface mediaPlayerInterface, int i3, int i16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, this, mediaPlayerInterface, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
                    }
                    return this.val$onErrorListener.onError(Exo2MediaPlayer.this, i3, i16);
                }
            });
        } else {
            super.setOnErrorListener((MediaPlayerInterface.OnErrorListener) null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) onInfoListener);
        } else if (onInfoListener != null) {
            super.setOnInfoListener(new MediaPlayerInterface.OnInfoListener(onInfoListener) { // from class: com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer.8
                static IPatchRedirector $redirector_;
                final /* synthetic */ IMediaPlayer.OnInfoListener val$onInfoListener;

                {
                    this.val$onInfoListener = onInfoListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Exo2MediaPlayer.this, (Object) onInfoListener);
                    }
                }

                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnInfoListener
                public boolean onInfo(MediaPlayerInterface mediaPlayerInterface, int i3, int i16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, this, mediaPlayerInterface, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
                    }
                    return this.val$onInfoListener.onInfo(Exo2MediaPlayer.this, i3, i16);
                }
            });
        } else {
            super.setOnInfoListener((MediaPlayerInterface.OnInfoListener) null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener onLoopStartListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onLoopStartListener);
        } else if (onLoopStartListener != null) {
            super.setOnLoopStartListener(new MediaPlayerInterface.OnLoopStartListener(onLoopStartListener) { // from class: com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IMediaPlayer.OnLoopStartListener val$listener;

                {
                    this.val$listener = onLoopStartListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Exo2MediaPlayer.this, (Object) onLoopStartListener);
                    }
                }

                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnLoopStartListener
                public void onLoopStart(MediaPlayerInterface mediaPlayerInterface) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mediaPlayerInterface);
                    } else {
                        this.val$listener.onLoopStart(Exo2MediaPlayer.this);
                    }
                }
            });
        } else {
            super.setOnLoopStartListener((MediaPlayerInterface.OnLoopStartListener) null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) onPreparedListener);
        } else if (onPreparedListener != null) {
            super.setOnPreparedListener(new MediaPlayerInterface.OnPreparedListener(onPreparedListener) { // from class: com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ IMediaPlayer.OnPreparedListener val$onPreparedListener;

                {
                    this.val$onPreparedListener = onPreparedListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Exo2MediaPlayer.this, (Object) onPreparedListener);
                    }
                }

                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnPreparedListener
                public void onPrepared(MediaPlayerInterface mediaPlayerInterface) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mediaPlayerInterface);
                    } else {
                        this.val$onPreparedListener.onPrepared(Exo2MediaPlayer.this);
                    }
                }
            });
        } else {
            super.setOnPreparedListener((MediaPlayerInterface.OnPreparedListener) null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) onSeekCompleteListener);
        } else if (onSeekCompleteListener != null) {
            super.setOnSeekCompleteListener(new MediaPlayerInterface.OnSeekCompleteListener(onSeekCompleteListener) { // from class: com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ IMediaPlayer.OnSeekCompleteListener val$onSeekCompleteListener;

                {
                    this.val$onSeekCompleteListener = onSeekCompleteListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Exo2MediaPlayer.this, (Object) onSeekCompleteListener);
                    }
                }

                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnSeekCompleteListener
                public void onSeekComplete(MediaPlayerInterface mediaPlayerInterface) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mediaPlayerInterface);
                    } else {
                        this.val$onSeekCompleteListener.onSeekComplete(Exo2MediaPlayer.this);
                    }
                }
            });
        } else {
            super.setOnSeekCompleteListener((MediaPlayerInterface.OnSeekCompleteListener) null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onTimedTextListener);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) onVideoSizeChangedListener);
        } else if (onVideoSizeChangedListener != null) {
            super.setOnVideoSizeChangedListener(new MediaPlayerInterface.OnVideoSizeChangedListener(onVideoSizeChangedListener) { // from class: com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer.6
                static IPatchRedirector $redirector_;
                final /* synthetic */ IMediaPlayer.OnVideoSizeChangedListener val$onVideoSizeChangedListener;

                {
                    this.val$onVideoSizeChangedListener = onVideoSizeChangedListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Exo2MediaPlayer.this, (Object) onVideoSizeChangedListener);
                    }
                }

                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnVideoSizeChangedListener
                public void onVideoSizeChanged(MediaPlayerInterface mediaPlayerInterface, int i3, int i16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, mediaPlayerInterface, Integer.valueOf(i3), Integer.valueOf(i16));
                    } else {
                        this.val$onVideoSizeChangedListener.onVideoSizeChanged(Exo2MediaPlayer.this, i3, i16);
                    }
                }
            });
        } else {
            super.setOnVideoSizeChangedListener((MediaPlayerInterface.OnVideoSizeChangedListener) null);
        }
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            setDataSource(streamInfo);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) streamInfo, i3);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException, UnsupportedOperationException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            throw new UnsupportedOperationException("no support");
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) fileDescriptor);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) throws UnsupportedOperationException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            throw new UnsupportedOperationException();
        }
        iPatchRedirector.redirect((short) 19, (Object) this, (Object) iMediaDataSource);
    }
}
