package com.tencent.oskplayer.player;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.player.StateMediaPlayer;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

/* loaded from: classes22.dex */
public class SegmentMediaPlayer implements ISegmentMediaPlayer, IMediaPlayer.OnPreparedListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnVideoSizeChangedListener, IMediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnBufferingUpdateListener, IMediaPlayer.OnErrorListener {
    public static final int ERROR_SET_NEXT_MEDIA_PLAYER_FAILED = 20001;
    private static final String LOG_TAG = "SegmentMediaPlayer";
    private static final int MSG_INIT_NEXT_PLAYER = 0;
    private static final int MSG_RELEASE_OLD_PLAYER = 1;
    private static final int MSG_SEEK_TO = 2;
    private static final int SURFACE_TYPE_DISPLAY = 0;
    private static final int SURFACE_TYPE_SURFACE = 1;
    private Context context;
    private StateMediaPlayer currentPlayer;
    private int currentSegment;
    private Handler handler;
    private boolean isAllowLooping;
    private boolean isLooping;
    private volatile boolean isReleasing;
    private volatile boolean isSeeking;
    private float leftVolume;
    private volatile boolean needStartAfterPrepared;
    private StateMediaPlayer nextPlayer;
    private IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
    private IMediaPlayer.OnCompletionListener onCompletionListener;
    private IMediaPlayer.OnErrorListener onErrorListener;
    private IMediaPlayer.OnInfoListener onInfoListener;
    private IMediaPlayer.OnLoopStartListener onLoopStartListener;
    private IMediaPlayer.OnPreparedListener onPreparedListener;
    private IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener;
    private IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener;
    private List<String> proxyUrls;
    private float rightVolume;
    private volatile long seekAfterPrepared;
    private HandlerThread segmentPlayerThread;
    private List<String> sourceUrls;
    private SegmentVideoInfo.StreamInfo streamInfo;
    private Surface surface;
    private SurfaceHolder surfaceHolder;
    private int surfaceType;
    private int totalSegment;
    private int wakeMode;
    private boolean screenOnWhilePlaying = true;
    private volatile boolean needStopAfterPrepared = false;
    private boolean strictMode = false;
    private int defaultPlayMode = 3;
    private int mPlayMode = 3;
    private long mLastCurrentPosition = 0;

    public SegmentMediaPlayer() {
        StateMediaPlayer stateMediaPlayer = new StateMediaPlayer(new AndroidMediaPlayer(), this.strictMode);
        this.currentPlayer = stateMediaPlayer;
        stateMediaPlayer.setMode(this.mPlayMode);
        this.segmentPlayerThread = getRealTimeThread();
        this.handler = new Handler(this.segmentPlayerThread.getLooper()) { // from class: com.tencent.oskplayer.player.SegmentMediaPlayer.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (SegmentMediaPlayer.this.isReleasing) {
                    return;
                }
                int i3 = message.what;
                if (i3 == 0) {
                    SegmentMediaPlayer.this.handleSetupNextPlayer();
                } else if (i3 == 1) {
                    SegmentMediaPlayer.this.handleReleaseOldPlayer((IMediaPlayer) message.obj);
                } else if (i3 == 2) {
                    SegmentMediaPlayer.this.handleSeekTo(((Long) message.obj).longValue());
                }
            }
        };
    }

    private synchronized void doRelease() {
        try {
            if (this.currentPlayer != null) {
                PlayerUtils.log(4, LOG_TAG, "currentPlayer is release");
                this.currentPlayer.release();
                this.currentPlayer = null;
            }
            if (this.nextPlayer != null) {
                PlayerUtils.log(4, LOG_TAG, "nextPlayer is release");
                this.nextPlayer.release();
                this.nextPlayer = null;
            }
        } catch (Exception e16) {
            PlayerUtils.log(5, LOG_TAG, "failed release. msg=" + e16.getMessage());
        }
    }

    private HandlerThread getRealTimeThread() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("SegmentMediaPlayer_RealTime_HandlerThread", -2);
        if (!baseHandlerThread.isAlive()) {
            baseHandlerThread.start();
        }
        return baseHandlerThread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReleaseOldPlayer(IMediaPlayer iMediaPlayer) {
        if (iMediaPlayer != null) {
            iMediaPlayer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSeekTo(long j3) {
        StateMediaPlayer stateMediaPlayer;
        SegmentVideoInfo.StreamInfo streamInfo = this.streamInfo;
        if (streamInfo != null && streamInfo.segmentInfos != null) {
            PlayerUtils.log(4, LOG_TAG, "seekTo position=" + j3);
            int segmentIndex = this.streamInfo.getSegmentIndex(j3);
            PlayerUtils.log(4, LOG_TAG, "seekTo segment index=" + segmentIndex);
            boolean z16 = false;
            if (segmentIndex < 0) {
                PlayerUtils.log(5, LOG_TAG, "seekTo position out of bound! seek to 0");
                j3 = 0;
                segmentIndex = 0;
            }
            SegmentVideoInfo.SegmentInfo segmentInfo = this.streamInfo.segmentInfos.get(segmentIndex);
            if (segmentInfo == null) {
                return;
            }
            long j16 = j3 - segmentInfo.offset;
            PlayerUtils.log(4, LOG_TAG, "seekTo segment realPosition=" + j16 + " url=" + segmentInfo.url);
            if (segmentIndex == this.currentSegment) {
                if (this.currentPlayer != null) {
                    PlayerUtils.log(4, LOG_TAG, "seekTo currentPlayer");
                    try {
                        this.currentPlayer.seekTo(j16);
                        return;
                    } catch (Exception e16) {
                        PlayerUtils.log(5, LOG_TAG, "seekTo exception: " + PlayerUtils.getPrintableStackTrace(e16));
                        return;
                    }
                }
                return;
            }
            if (this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_ISPLAYING) && (((stateMediaPlayer = this.currentPlayer) != null && stateMediaPlayer.isPlaying()) || this.isSeeking)) {
                z16 = true;
            }
            PlayerUtils.log(4, LOG_TAG, "currentPlayer isPlaying=" + z16);
            this.currentSegment = segmentIndex;
            try {
                init(true);
                if (this.currentPlayer != null) {
                    this.seekAfterPrepared = j16;
                    this.needStartAfterPrepared = z16;
                    this.isSeeking = true;
                    PlayerUtils.log(4, LOG_TAG, "prepare currentPlayer. realPosition=" + j16 + " url=" + segmentInfo.url);
                    this.currentPlayer.prepareAsync();
                }
            } catch (IOException e17) {
                PlayerUtils.log(6, LOG_TAG, "failed seeking to segment=" + segmentIndex + " position=" + j3 + " exception:" + PlayerUtils.getPrintableStackTrace(e17));
            } catch (IllegalStateException e18) {
                PlayerUtils.log(6, LOG_TAG, "failed. IllegalStateException when seeking to segment=" + segmentIndex + " position=" + j3 + " exception=" + PlayerUtils.getPrintableStackTrace(e18));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSetupNextPlayer() {
        SegmentVideoInfo.SegmentInfo segment;
        if (hasNext()) {
            try {
                SegmentVideoInfo.StreamInfo streamInfo = this.streamInfo;
                if (streamInfo == null || (segment = streamInfo.getSegment(this.currentSegment + 1)) == null) {
                    return;
                }
                PlayerUtils.log(4, LOG_TAG, "init next mediaplayer");
                StateMediaPlayer stateMediaPlayer = new StateMediaPlayer(new AndroidMediaPlayer(), this.strictMode);
                this.nextPlayer = stateMediaPlayer;
                stateMediaPlayer.setMode(this.mPlayMode);
                String str = this.proxyUrls.get(this.currentSegment + 1);
                PlayerUtils.log(4, LOG_TAG, "setup next mediaplayer url=" + segment.url + " proxyurl=" + str);
                this.nextPlayer.setDataSource(str);
                this.nextPlayer.setOnPreparedListener(this);
                this.nextPlayer.setOnInfoListener(this);
                this.nextPlayer.setOnCompletionListener(this);
                this.nextPlayer.setOnBufferingUpdateListener(this);
                this.nextPlayer.setOnErrorListener(this);
                Context context = this.context;
                if (context != null) {
                    this.nextPlayer.setWakeMode(context, this.wakeMode);
                }
                if (PlayerConfig.g().isDebugVersion()) {
                    PlayerUtils.log(3, LOG_TAG, "nextPlayer setVolume, leftVolume=" + this.leftVolume + " rightVolume=" + this.rightVolume + toString());
                }
                this.nextPlayer.setVolume(this.leftVolume, this.rightVolume);
                this.nextPlayer.setScreenOnWhilePlaying(this.screenOnWhilePlaying);
                if (this.isAllowLooping) {
                    this.nextPlayer.setLooping(false);
                }
                this.nextPlayer.prepareAsync();
            } catch (Exception e16) {
                PlayerUtils.log(6, LOG_TAG, "setup next mediaplayer error. exception:" + PlayerUtils.getPrintableStackTrace(e16));
            }
        }
    }

    private boolean hasNext() {
        if (this.currentSegment + 1 < this.totalSegment) {
            return true;
        }
        return false;
    }

    private synchronized void init(boolean z16) throws IOException {
        if (z16) {
            doRelease();
        }
        PlayerUtils.log(4, LOG_TAG, "init: currentSegment=" + this.currentSegment);
        SegmentVideoInfo.SegmentInfo segment = this.streamInfo.getSegment(this.currentSegment);
        if (segment == null) {
            PlayerUtils.log(6, LOG_TAG, "init: segment==null currentSegment=" + this.currentSegment);
            return;
        }
        if (this.currentPlayer == null) {
            StateMediaPlayer stateMediaPlayer = new StateMediaPlayer(new AndroidMediaPlayer(), this.strictMode);
            this.currentPlayer = stateMediaPlayer;
            stateMediaPlayer.setMode(this.mPlayMode);
        }
        String str = this.proxyUrls.get(this.currentSegment);
        PlayerUtils.log(4, LOG_TAG, "init: currentSegment=" + this.currentSegment + " url=" + segment.url + " proxyUrl=" + str);
        this.currentPlayer.setDataSource(str);
        if (PlayerUtils.isHLSStream(str)) {
            this.isAllowLooping = false;
        } else {
            this.isAllowLooping = true;
        }
        initCurrentPlayer();
    }

    private void initCurrentPlayer() {
        PlayerUtils.log(4, LOG_TAG, "initCurrentPlayer...");
        StateMediaPlayer stateMediaPlayer = this.currentPlayer;
        if (stateMediaPlayer == null) {
            return;
        }
        stateMediaPlayer.setOnPreparedListener(this);
        this.currentPlayer.setOnInfoListener(this);
        this.currentPlayer.setOnCompletionListener(this);
        this.currentPlayer.setOnSeekCompleteListener(this);
        this.currentPlayer.setOnBufferingUpdateListener(this);
        this.currentPlayer.setOnVideoSizeChangedListener(this);
        this.currentPlayer.setOnErrorListener(this);
        Context context = this.context;
        if (context != null) {
            this.currentPlayer.setWakeMode(context, this.wakeMode);
        }
        if (PlayerConfig.g().isDebugVersion()) {
            PlayerUtils.log(3, LOG_TAG, "currentPlayer setVolume, leftVolume=" + this.leftVolume + " rightVolume=" + this.rightVolume + toString());
        }
        this.currentPlayer.setVolume(this.leftVolume, this.rightVolume);
        this.currentPlayer.setScreenOnWhilePlaying(this.screenOnWhilePlaying);
        this.currentPlayer.setLooping(false);
        if (this.isAllowLooping) {
            this.currentPlayer.setLooping(false);
        }
        setDisplaySurface(this.currentPlayer);
    }

    private void removeDisplaySurface(IMediaPlayer iMediaPlayer) {
        if (iMediaPlayer == null) {
            return;
        }
        int i3 = this.surfaceType;
        if (i3 == 0) {
            iMediaPlayer.setDisplay(null);
        } else if (i3 == 1) {
            iMediaPlayer.setSurface(null);
        }
    }

    private void setDisplaySurface(IMediaPlayer iMediaPlayer) {
        if (iMediaPlayer == null) {
            return;
        }
        int i3 = this.surfaceType;
        if (i3 == 0) {
            iMediaPlayer.setDisplay(this.surfaceHolder);
        } else if (i3 == 1) {
            iMediaPlayer.setSurface(this.surface);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        long j3 = 0;
        if (this.streamInfo == null) {
            return 0L;
        }
        StateMediaPlayer stateMediaPlayer = this.currentPlayer;
        if (stateMediaPlayer != null && stateMediaPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETCURRENTPOSITION)) {
            try {
                StateMediaPlayer stateMediaPlayer2 = this.currentPlayer;
                if (stateMediaPlayer2 != null) {
                    j3 = stateMediaPlayer2.getCurrentPosition();
                }
            } catch (IllegalStateException unused) {
                PlayerUtils.log(5, LOG_TAG, "getCurrentPosition illegal state");
            }
            ArrayList<SegmentVideoInfo.SegmentInfo> arrayList = this.streamInfo.segmentInfos;
            for (int i3 = 0; i3 < this.currentSegment; i3++) {
                j3 += arrayList.get(i3).duration;
            }
            this.mLastCurrentPosition = j3;
            return j3;
        }
        return this.mLastCurrentPosition;
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public String getCurrentProxySegmentUrl() {
        List<String> list = this.proxyUrls;
        if (list != null) {
            return list.get(this.currentSegment);
        }
        PlayerUtils.log(5, LOG_TAG, "illegal on calling getCurrentSegmentVideoUrl, must call setDataSource first " + PlayerUtils.getStackTrace());
        return null;
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public String getCurrentSegmentUrl() {
        List<String> list = this.sourceUrls;
        if (list != null) {
            return list.get(this.currentSegment);
        }
        PlayerUtils.log(5, LOG_TAG, "illegal on calling getCurrentSegmentVideoUrl, must call setDataSource first " + PlayerUtils.getStackTrace());
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        if (this.streamInfo != null) {
            return r0.getTotalDuration();
        }
        return 0L;
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
        return this.totalSegment;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        return new ITrackInfo[0];
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public synchronized int getVideoHeight() {
        StateMediaPlayer stateMediaPlayer = this.currentPlayer;
        if (stateMediaPlayer != null) {
            return stateMediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public synchronized int getVideoWidth() {
        StateMediaPlayer stateMediaPlayer = this.currentPlayer;
        if (stateMediaPlayer != null) {
            return stateMediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.isLooping;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        StateMediaPlayer stateMediaPlayer;
        try {
            StateMediaPlayer stateMediaPlayer2 = this.currentPlayer;
            if ((stateMediaPlayer2 != null && !stateMediaPlayer2.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_ISPLAYING)) || (stateMediaPlayer = this.currentPlayer) == null) {
                return false;
            }
            if (!stateMediaPlayer.isPlaying()) {
                return false;
            }
            return true;
        } catch (IllegalStateException e16) {
            PlayerUtils.log(5, LOG_TAG, PlayerUtils.getPrintableStackTrace(e16));
            return false;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
    public synchronized void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i3) {
        int i16;
        SegmentVideoInfo.SegmentInfo segment;
        if (this.isReleasing) {
            return;
        }
        StateMediaPlayer stateMediaPlayer = this.nextPlayer;
        if (stateMediaPlayer != null && iMediaPlayer == stateMediaPlayer.getInternalMediaPlayer()) {
            i16 = this.currentSegment + 1;
        } else {
            i16 = this.currentSegment;
        }
        SegmentVideoInfo.StreamInfo streamInfo = this.streamInfo;
        if (streamInfo != null && (segment = streamInfo.getSegment(i16)) != null) {
            i3 += (int) ((segment.offset * 100.0d) / this.streamInfo.getTotalDuration());
        }
        IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this.onBufferingUpdateListener;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(this, i3);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
    public synchronized void onCompletion(IMediaPlayer iMediaPlayer) {
        if (this.isReleasing) {
            return;
        }
        PlayerUtils.log(3, LOG_TAG, "onCompletion");
        if (hasNext()) {
            if (this.currentPlayer != null && this.nextPlayer != null) {
                PlayerUtils.log(4, LOG_TAG, "----------------- switching mediaplayer ----------------");
                if (this.surfaceType == 0) {
                    PlayerUtils.log(3, LOG_TAG, "currentPlayer.setDisplay(null)");
                    this.currentPlayer.setDisplay(null);
                    PlayerUtils.log(3, LOG_TAG, "nextPlayer.setDisplay(surfaceHolder)");
                    this.nextPlayer.setDisplay(this.surfaceHolder);
                } else {
                    PlayerUtils.log(3, LOG_TAG, "currentPlayer.setSurface(null)");
                    this.currentPlayer.setSurface(null);
                    PlayerUtils.log(3, LOG_TAG, "nextPlayer.setSurface(surface)");
                    this.nextPlayer.setSurface(this.surface);
                }
                if (!IMediaPlayer.SUPPORT_NEXT_MEDIA) {
                    Log.d(LOG_TAG, "nextPlayer.start()");
                    if (!this.nextPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_START)) {
                        this.needStartAfterPrepared = true;
                    } else {
                        try {
                            this.nextPlayer.start();
                        } catch (IMediaPlayer.InternalOperationException e16) {
                            PlayerUtils.log(6, LOG_TAG, e16.toString());
                        }
                    }
                }
                if (PlayerConfig.g().isDebugVersion()) {
                    PlayerUtils.log(3, LOG_TAG, "onCompletion setVolume, leftVolume=" + this.leftVolume + " rightVolume=" + this.rightVolume + toString());
                }
                StateMediaPlayer stateMediaPlayer = this.currentPlayer;
                this.currentPlayer = this.nextPlayer;
                try {
                    Message.obtain(this.handler, 1, stateMediaPlayer).sendToTarget();
                } catch (Exception unused) {
                }
                this.currentSegment++;
                Handler handler = this.handler;
                if (handler != null) {
                    handler.removeMessages(0);
                    this.handler.sendEmptyMessage(0);
                }
            }
            return;
        }
        if (this.isAllowLooping && this.isLooping) {
            if (this.isReleasing) {
                return;
            }
            seekTo(0L);
            try {
                start();
                IMediaPlayer.OnLoopStartListener onLoopStartListener = this.onLoopStartListener;
                if (onLoopStartListener != null) {
                    onLoopStartListener.onLoopStart(this);
                }
            } catch (IMediaPlayer.InternalOperationException e17) {
                PlayerUtils.log(6, LOG_TAG, e17.toString());
            }
        } else {
            PlayerUtils.log(3, LOG_TAG, "play complete");
            IMediaPlayer.OnCompletionListener onCompletionListener = this.onCompletionListener;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(this);
            }
        }
        return;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public synchronized boolean onError(IMediaPlayer iMediaPlayer, int i3, int i16) {
        String str;
        if (this.isReleasing) {
            return true;
        }
        if (this.currentPlayer != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onError: what=");
            sb5.append(i3);
            sb5.append(" extra=");
            sb5.append(i16);
            sb5.append(" currentSegment=");
            sb5.append(this.currentSegment);
            sb5.append(" mp==");
            if (iMediaPlayer == this.currentPlayer.getInternalMediaPlayer()) {
                str = "currentPlayer";
            } else {
                str = "nextPlayer";
            }
            sb5.append(str);
            PlayerUtils.log(6, LOG_TAG, sb5.toString());
        }
        IMediaPlayer.OnErrorListener onErrorListener = this.onErrorListener;
        if (onErrorListener == null) {
            return true;
        }
        return onErrorListener.onError(this, i3, i16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public synchronized boolean onInfo(IMediaPlayer iMediaPlayer, int i3, int i16) {
        String str;
        if (this.isReleasing) {
            return true;
        }
        if (iMediaPlayer == null) {
            return true;
        }
        if (PlayerConfig.g().isDebugVersion() && this.currentPlayer != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onInfo what=");
            sb5.append(i3);
            sb5.append(" extra=");
            sb5.append(i16);
            sb5.append(" mp==");
            if (iMediaPlayer == this.currentPlayer.getInternalMediaPlayer()) {
                str = "currentPlayer";
            } else {
                str = "nextPlayer";
            }
            sb5.append(str);
            PlayerUtils.log(3, LOG_TAG, sb5.toString());
        }
        if (i3 == 3) {
            PlayerUtils.log(4, LOG_TAG, "--------------- mediaplayer start rendering -----------------");
        }
        IMediaPlayer.OnInfoListener onInfoListener = this.onInfoListener;
        if (onInfoListener != null) {
            onInfoListener.onInfo(this, i3, i16);
        }
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public synchronized void onPrepared(IMediaPlayer iMediaPlayer) {
        SegmentVideoInfo.SegmentInfo segment;
        int duration;
        if (this.isReleasing) {
            return;
        }
        iMediaPlayer.setScreenOnWhilePlaying(this.screenOnWhilePlaying);
        if (this.isAllowLooping) {
            iMediaPlayer.setLooping(false);
        }
        iMediaPlayer.setVolume(this.leftVolume, this.rightVolume);
        StateMediaPlayer stateMediaPlayer = this.currentPlayer;
        if (stateMediaPlayer != null && iMediaPlayer == stateMediaPlayer.getInternalMediaPlayer()) {
            PlayerUtils.log(3, LOG_TAG, "onPrepared mp == currentPlayer, playing segment=" + this.currentSegment + " seekAfterPrepared=" + this.seekAfterPrepared + " needStartAfterPrepared=" + this.needStartAfterPrepared);
            SegmentVideoInfo.StreamInfo streamInfo = this.streamInfo;
            if (streamInfo != null && (segment = streamInfo.getSegment(this.currentSegment)) != null && (duration = (int) iMediaPlayer.getDuration()) > 0 && segment.duration != duration) {
                PlayerUtils.log(2, LOG_TAG, "fix segment duration. segment=" + this.currentSegment + " segment.duration=" + segment.duration + "real duration=" + duration);
                segment.duration = duration;
                this.streamInfo.updateDuration();
            }
            if (this.needStartAfterPrepared) {
                try {
                    iMediaPlayer.start();
                } catch (IMediaPlayer.InternalOperationException e16) {
                    PlayerUtils.log(6, LOG_TAG, e16.toString());
                }
                this.needStartAfterPrepared = false;
            } else if (this.needStopAfterPrepared) {
                iMediaPlayer.stop();
                this.needStopAfterPrepared = false;
            }
            boolean z16 = this.isSeeking;
            if (this.seekAfterPrepared != 0) {
                iMediaPlayer.seekTo(this.seekAfterPrepared);
                this.seekAfterPrepared = 0L;
            } else if (this.isSeeking) {
                this.isSeeking = false;
                IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this.onSeekCompleteListener;
                if (onSeekCompleteListener != null) {
                    onSeekCompleteListener.onSeekComplete(this);
                }
            }
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeMessages(0);
                this.handler.sendEmptyMessage(0);
            }
            IMediaPlayer.OnPreparedListener onPreparedListener = this.onPreparedListener;
            if (onPreparedListener != null && !z16) {
                onPreparedListener.onPrepared(this);
            }
        }
        StateMediaPlayer stateMediaPlayer2 = this.nextPlayer;
        if (stateMediaPlayer2 != null && iMediaPlayer == stateMediaPlayer2.getInternalMediaPlayer()) {
            PlayerUtils.log(3, LOG_TAG, "onPrepared mp == nextPlayer");
            if (IMediaPlayer.SUPPORT_NEXT_MEDIA && this.currentPlayer != null) {
                try {
                    PlayerUtils.log(3, LOG_TAG, "setNextMediaPlayer");
                    this.currentPlayer.setNextMediaPlayer(this.nextPlayer.getInternalMediaPlayer());
                } catch (Exception e17) {
                    PlayerUtils.log(6, LOG_TAG, "failed setNextMediaPlayer:" + e17);
                    IMediaPlayer.OnErrorListener onErrorListener = this.onErrorListener;
                    if (onErrorListener != null) {
                        onErrorListener.onError(this, 20001, 0);
                    }
                }
            }
            if (PlayerConfig.g().isDebugVersion()) {
                PlayerUtils.log(3, LOG_TAG, "nextPlayer onPrepared setVolume, leftVolume=" + this.leftVolume + " rightVolume=" + this.rightVolume + toString());
            }
            this.nextPlayer.setVolume(this.leftVolume, this.rightVolume);
            this.nextPlayer.setScreenOnWhilePlaying(this.screenOnWhilePlaying);
            if (this.isAllowLooping) {
                this.nextPlayer.setLooping(false);
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
    public synchronized void onSeekComplete(IMediaPlayer iMediaPlayer) {
        if (this.isReleasing) {
            return;
        }
        PlayerUtils.log(3, LOG_TAG, "onSeekComplete.");
        this.isSeeking = false;
        IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this.onSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete(this);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
    public synchronized void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i3, int i16) {
        if (this.isReleasing) {
            return;
        }
        IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.onVideoSizeChangedListener;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(this, i3, i16);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws IMediaPlayer.InternalOperationException {
        StateMediaPlayer stateMediaPlayer = this.currentPlayer;
        if (stateMediaPlayer != null) {
            if (stateMediaPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_PAUSE)) {
                try {
                    this.currentPlayer.pause();
                    return;
                } catch (IllegalStateException e16) {
                    PlayerUtils.log(6, LOG_TAG, "pause error: " + PlayerUtils.getPrintableStackTrace(e16));
                    return;
                }
            }
            throw new IMediaPlayer.InternalOperationException("pause failed, current media state = " + this.currentPlayer.getMediaPlayerState());
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() {
        StateMediaPlayer stateMediaPlayer = this.currentPlayer;
        if (stateMediaPlayer != null) {
            stateMediaPlayer.prepareAsync();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public synchronized void release() {
        this.isReleasing = true;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeMessages(0);
            this.handler.removeMessages(2);
            this.handler.removeMessages(1);
        }
        this.handler = null;
        HandlerThread handlerThread = this.segmentPlayerThread;
        if (handlerThread != null) {
            try {
                handlerThread.quit();
                this.segmentPlayerThread = null;
            } catch (Exception unused) {
                PlayerUtils.log(5, LOG_TAG, "release segmentPlayerThread error");
            }
        }
        this.onPreparedListener = null;
        this.onCompletionListener = null;
        this.onBufferingUpdateListener = null;
        this.onVideoSizeChangedListener = null;
        this.onSeekCompleteListener = null;
        this.onInfoListener = null;
        doRelease();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        if (this.currentPlayer != null) {
            PlayerUtils.log(4, LOG_TAG, "currentPlayer is reset");
            if (this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RESET)) {
                this.currentPlayer.reset();
            } else {
                if (this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RELEASE)) {
                    this.currentPlayer.release();
                }
                StateMediaPlayer stateMediaPlayer = new StateMediaPlayer(new AndroidMediaPlayer(), this.strictMode);
                this.currentPlayer = stateMediaPlayer;
                stateMediaPlayer.setMode(this.mPlayMode);
            }
        }
        if (this.nextPlayer != null) {
            PlayerUtils.log(4, LOG_TAG, "nextPlayer is reset");
            if (this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RESET)) {
                this.nextPlayer.reset();
                return;
            }
            if (this.nextPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RELEASE)) {
                this.nextPlayer.release();
            }
            StateMediaPlayer stateMediaPlayer2 = new StateMediaPlayer(new AndroidMediaPlayer(), this.strictMode);
            this.nextPlayer = stateMediaPlayer2;
            stateMediaPlayer2.setMode(this.mPlayMode);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public synchronized void seekTo(long j3) {
        if (this.handler == null) {
            return;
        }
        PlayerUtils.log(4, LOG_TAG, "seekTo " + j3);
        this.handler.removeMessages(2);
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(2, Long.valueOf(j3)));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i3) {
        StateMediaPlayer stateMediaPlayer = this.currentPlayer;
        if (stateMediaPlayer != null) {
            stateMediaPlayer.setAudioStreamType(i3);
        }
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo) throws IOException {
        setDataSource(streamInfo, 0);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.surfaceType = 0;
        this.surfaceHolder = surfaceHolder;
        this.surface = null;
        StateMediaPlayer stateMediaPlayer = this.currentPlayer;
        if (stateMediaPlayer != null) {
            stateMediaPlayer.setDisplay(surfaceHolder);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z16) {
        this.isLooping = z16;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setNextMediaPlayer(IMediaPlayer iMediaPlayer) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setNextMediaPlayer is not supported");
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.onBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.onCompletionListener = onCompletionListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.onInfoListener = onInfoListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener onLoopStartListener) {
        this.onLoopStartListener = onLoopStartListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.onPreparedListener = onPreparedListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.onSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        StateMediaPlayer stateMediaPlayer = this.currentPlayer;
        if (stateMediaPlayer != null) {
            stateMediaPlayer.setOnTimedTextListener(onTimedTextListener);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.onVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPlayMode(int i3) {
        this.mPlayMode = i3;
        StateMediaPlayer stateMediaPlayer = this.currentPlayer;
        if (stateMediaPlayer != null) {
            stateMediaPlayer.setMode(i3);
        }
        StateMediaPlayer stateMediaPlayer2 = this.nextPlayer;
        if (stateMediaPlayer2 != null) {
            stateMediaPlayer2.setMode(this.mPlayMode);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z16) {
        this.screenOnWhilePlaying = z16;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSeekParameters(SeekParameters seekParameters) {
        DebugLog.w(LOG_TAG, "setSeekParameters is not supported");
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        this.surfaceType = 1;
        this.surfaceHolder = null;
        this.surface = surface;
        if (this.currentPlayer != null) {
            PlayerUtils.log(4, LOG_TAG, "setSurface " + this);
            this.currentPlayer.setSurface(surface);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f16, float f17) {
        this.leftVolume = f16;
        this.rightVolume = f17;
        if (this.currentPlayer != null) {
            if (PlayerConfig.g().isDebugVersion()) {
                PlayerUtils.log(3, LOG_TAG, "set current setVolume, leftVolume=" + f16 + " rightVolume=" + f17 + toString());
            }
            try {
                if (this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETVOLUME)) {
                    this.currentPlayer.setVolume(f16, f17);
                }
            } catch (IllegalStateException e16) {
                PlayerUtils.log(6, LOG_TAG, "cant set volume to " + f16 + "," + f17 + e16);
            }
        }
        if (this.nextPlayer != null) {
            if (PlayerConfig.g().isDebugVersion()) {
                PlayerUtils.log(3, LOG_TAG, "set next setVolume, leftVolume=" + f16 + " rightVolume=" + f17 + toString());
            }
            try {
                if (this.nextPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETVOLUME)) {
                    this.nextPlayer.setVolume(f16, f17);
                }
            } catch (IllegalStateException e17) {
                PlayerUtils.log(6, LOG_TAG, "cant set volume to " + f16 + "," + f17 + e17);
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(Context context, int i3) {
        this.context = context;
        this.wakeMode = i3;
        StateMediaPlayer stateMediaPlayer = this.currentPlayer;
        if (stateMediaPlayer != null) {
            stateMediaPlayer.setWakeMode(context, i3);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws IMediaPlayer.InternalOperationException {
        StateMediaPlayer stateMediaPlayer = this.currentPlayer;
        if (stateMediaPlayer != null) {
            if (stateMediaPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_START)) {
                try {
                    this.currentPlayer.start();
                    this.needStopAfterPrepared = false;
                    return;
                } catch (Exception e16) {
                    PlayerUtils.log(6, LOG_TAG, "start error: " + PlayerUtils.getPrintableStackTrace(e16));
                    return;
                }
            }
            throw new IMediaPlayer.InternalOperationException("start failed, current media state = " + this.currentPlayer.getMediaPlayerState());
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        if (!this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_STOP)) {
            PlayerUtils.log(5, LOG_TAG, "stop failed cause of state illegal");
            this.needStopAfterPrepared = true;
        } else {
            StateMediaPlayer stateMediaPlayer = this.currentPlayer;
            if (stateMediaPlayer != null) {
                stateMediaPlayer.stop();
            }
        }
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo, int i3) throws IOException {
        this.streamInfo = streamInfo;
        this.currentSegment = 0;
        this.totalSegment = 0;
        this.seekAfterPrepared = 0L;
        if (streamInfo != null) {
            int segmentIndex = streamInfo.getSegmentIndex(i3);
            this.currentSegment = segmentIndex;
            if (segmentIndex >= 0) {
                this.totalSegment = streamInfo.getCount();
                ArrayList<SegmentVideoInfo.SegmentInfo> arrayList = streamInfo.segmentInfos;
                this.sourceUrls = new ArrayList();
                if (arrayList != null) {
                    Iterator<SegmentVideoInfo.SegmentInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        this.sourceUrls.add(it.next().url);
                    }
                }
                this.proxyUrls = VideoManager.getInstance().getUrl(this.sourceUrls);
                init(false);
                return;
            }
            this.currentSegment = 0;
            throw new IOException("invalid segment index");
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(new SegmentVideoInfo.StreamInfo(str, 0));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z16) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z16) {
    }
}
