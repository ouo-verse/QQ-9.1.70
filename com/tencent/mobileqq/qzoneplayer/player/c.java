package com.tencent.mobileqq.qzoneplayer.player;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.SafeUrlState;
import com.tencent.mobileqq.qzoneplayer.video.l;
import com.tencent.mobileqq.qzoneplayer.video.s;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.player.ISegmentMediaPlayer;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPVideoCropInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c implements ISegmentMediaPlayer {
    private PowerManager.WakeLock G;
    private WeakReference<Surface> I;
    private volatile boolean J;
    private IMediaPlayer.OnInfoListener L;
    private IMediaPlayer.OnPreparedListener M;
    private IMediaPlayer.OnCompletionListener N;
    private IMediaPlayer.OnSeekCompleteListener P;
    private IMediaPlayer.OnBufferingUpdateListener Q;
    private IMediaPlayer.OnVideoSizeChangedListener R;
    private IMediaPlayer.OnErrorListener S;

    /* renamed from: d, reason: collision with root package name */
    private ISuperPlayer f279459d;

    /* renamed from: f, reason: collision with root package name */
    private String f279461f;

    /* renamed from: h, reason: collision with root package name */
    private String f279462h;

    /* renamed from: i, reason: collision with root package name */
    private SuperPlayerVideoInfo f279463i;

    /* renamed from: m, reason: collision with root package name */
    private long f279464m;

    /* renamed from: e, reason: collision with root package name */
    private b f279460e = new b();
    private int C = -1;
    private int D = 0;
    private long E = -1;
    private int F = 3;
    private volatile int H = -1;
    private volatile int K = 0;
    private Handler T = new a(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.BackGroundThread));

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
            FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
            if (feedVideoExternalFunc != null && feedVideoExternalFunc.isDebugVersion()) {
                FeedVideoEnv.externalFunc.showToast("\u53d1\u8d77\u6362\u94fe\u8bf7\u6c42, error=" + c.this.H + ", retry=" + c.this.K);
                PlayerUtils.log(3, "SuperMediaPlayer", "[handleMessage] \u53d1\u8d77\u6362\u94fe\u8bf7\u6c42, error=" + c.this.H + ", retry=" + c.this.K);
            }
            c.this.H = -1;
            if (c.this.J) {
                PlayerUtils.log(6, "SuperMediaPlayer", "[handleMessage] player is released before retry");
                return;
            }
            if (TextUtils.isEmpty(c.this.f279462h)) {
                PlayerUtils.log(6, "SuperMediaPlayer", "[handleMessage] invalid originalUrl");
                return;
            }
            HttpRetryLogic c16 = com.tencent.mobileqq.qzoneplayer.videosource.a.d().c(c.this.f279461f);
            if (c16 == null) {
                PlayerUtils.log(6, "SuperMediaPlayer", "[handleMessage] no retry logic");
                return;
            }
            PlayerUtils.log(4, "SuperMediaPlayer", "[handleMessage] originalUrl=" + c.this.f279462h);
            String retryUrl = c16.getRetryUrl(c.this.f279462h, 0, 403, null);
            PlayerUtils.log(4, "SuperMediaPlayer", "[handleMessage] retryUrl=" + retryUrl);
            if (TextUtils.isEmpty(retryUrl)) {
                l h16 = s.g().h(c.this.f279462h, false);
                if (h16 != null && h16.f280001a == SafeUrlState.URL_STATE_SUCCESS && (arrayList = h16.f280002b) != null && arrayList.size() > 0 && h16.f280002b.get(0) != null && !TextUtils.isEmpty(h16.f280002b.get(0).url)) {
                    retryUrl = h16.f280002b.get(0).url;
                    PlayerUtils.log(4, "SuperMediaPlayer", "[handleMessage] try again, retryUrl=" + retryUrl);
                } else {
                    PlayerUtils.log(6, "SuperMediaPlayer", "[handleMessage] invalid retryUrl");
                    return;
                }
            }
            if (!c.this.J) {
                if (c.this.I != null && c.this.I.get() != null) {
                    Surface surface = (Surface) c.this.I.get();
                    try {
                        c.this.reset();
                        c.this.setSurface(surface);
                        c.this.setDataSource(retryUrl);
                        c.this.prepareAsync();
                        return;
                    } catch (Exception e16) {
                        PlayerUtils.log(6, "SuperMediaPlayer", "[handleMessage]", e16);
                        return;
                    }
                }
                PlayerUtils.log(6, "SuperMediaPlayer", "[handleMessage] invalid surface");
                return;
            }
            PlayerUtils.log(6, "SuperMediaPlayer", "[handleMessage] player is released after retry");
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnVideoSizeChangedListener {
        b() {
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            if (c.this.N != null) {
                c.this.N.onCompletion(c.this);
            } else {
                PlayerUtils.log(5, "SuperMediaPlayer", "[onCompletion] invalid out listener");
            }
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
        public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[onError] module=" + i3 + ", errorType=" + i16 + ", errorCode=" + i17 + ", retryCount=" + c.this.K);
            if (c.this.H <= 0) {
                c.this.H = i17;
                if (c.this.K != 0 || (14020003 != i17 && 14020004 != i17 && 11022116 != i17 && 11022115 != i17)) {
                    if (c.this.S != null) {
                        c.this.S.onError(c.this, i16, i17);
                    } else {
                        PlayerUtils.log(5, "SuperMediaPlayer", "[onError] invalid out listener");
                    }
                    return false;
                }
                c.this.T.sendEmptyMessageDelayed(0, 2000L);
                c.e(c.this);
                return false;
            }
            PlayerUtils.log(5, "SuperMediaPlayer", "[onError] already errored, erroredCode=" + c.this.H);
            return false;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
        public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
            String str;
            String extraInfo;
            PlayerUtils.log(3, "SuperMediaPlayer", "[onInfo] what=" + i3 + ", arg1=" + j3 + ", arg2=" + j16 + ", extra=" + obj);
            if (i3 == 105) {
                if (c.this.L != null && c.this.f279459d != null) {
                    c.this.L.onInfo(c.this, 3, 0);
                }
            } else {
                if (i3 != 122) {
                    if (i3 == 124) {
                        if (2 == j3) {
                            str = "ThumbPlayer";
                        } else if (1 == j3) {
                            str = "AndroidPlayer";
                        } else {
                            str = "known";
                        }
                        c.this.D = (int) j3;
                        PlayerUtils.log(3, "SuperMediaPlayer", "[onInfo]extra PLAYER_INFO_PLAYER_TYPE, type=" + str);
                    } else if (i3 == 201) {
                        PlayerUtils.log(3, "SuperMediaPlayer", "[onInfo]extra PLAYER_INFO_ALL_DOWNLOAD_FINISH, extra=" + obj);
                    } else if (i3 != 207) {
                        if (i3 != 204) {
                            if (i3 != 205) {
                                String str2 = "MediaCodec";
                                switch (i3) {
                                    case 112:
                                        if (c.this.L != null && c.this.f279459d != null) {
                                            c.this.L.onInfo(c.this, 701, a());
                                            break;
                                        }
                                        break;
                                    case 113:
                                        if (c.this.L != null && c.this.f279459d != null) {
                                            c.this.L.onInfo(c.this, 702, a());
                                            break;
                                        }
                                        break;
                                    case 114:
                                        if (1 == j3) {
                                            str2 = "FFMPEG";
                                        } else if (2 != j3) {
                                            str2 = "unknown";
                                        }
                                        PlayerUtils.log(3, "SuperMediaPlayer", "[onInfo]extra PLAYER_INFO_AUDIO_DECODER_TYPE, decoder=" + str2);
                                        break;
                                    case 115:
                                        if (101 == j3) {
                                            str2 = "FFMPEG";
                                        } else if (102 != j3) {
                                            str2 = "unknown";
                                        }
                                        c.this.C = (int) j3;
                                        PlayerUtils.log(3, "SuperMediaPlayer", "[onInfo]extra PLAYER_INFO_VIDEO_DECODER_TYPE, decoder=" + str2);
                                        break;
                                }
                            } else if (obj instanceof TPPlayerMsg.TPProtocolInfo) {
                                TPPlayerMsg.TPProtocolInfo tPProtocolInfo = (TPPlayerMsg.TPProtocolInfo) obj;
                                PlayerUtils.log(3, "SuperMediaPlayer", "[onInfo]extra PLAYER_INFO_PROTOCOL_UPDATE, protocol=" + tPProtocolInfo.protocolName + ", version=" + tPProtocolInfo.protocolVersion);
                            }
                        }
                    } else if (obj instanceof TPDownloadProgressInfo) {
                        TPDownloadProgressInfo tPDownloadProgressInfo = (TPDownloadProgressInfo) obj;
                        c.this.E = tPDownloadProgressInfo.getDownloadSpeedbps();
                        int downloadBytes = tPDownloadProgressInfo.getFileTotalBytes() > 0 ? (int) ((((float) tPDownloadProgressInfo.getDownloadBytes()) * 100.0f) / ((float) tPDownloadProgressInfo.getFileTotalBytes())) : 0;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("[onInfo]extra TP_PLAYER_INFO_OBJECT_DOWNLOAD_PROGRESS_UPDATE, playableDurationMS=");
                        sb5.append(tPDownloadProgressInfo.getAvailablePositionMs());
                        sb5.append(", downloadSpeedKBps=");
                        sb5.append(tPDownloadProgressInfo.getDownloadSpeedbps());
                        sb5.append(", currentDownloadSize=");
                        sb5.append(tPDownloadProgressInfo.getDownloadBytes());
                        sb5.append(", totalFileSize=");
                        sb5.append(tPDownloadProgressInfo.getFileTotalBytes());
                        sb5.append(", percent=");
                        sb5.append(downloadBytes);
                        sb5.append(", extraInfo=");
                        if (TextUtils.isEmpty(tPDownloadProgressInfo.getExtraInfo())) {
                            extraInfo = "";
                        } else {
                            extraInfo = tPDownloadProgressInfo.getExtraInfo();
                        }
                        sb5.append(extraInfo);
                        PlayerUtils.log(3, "SuperMediaPlayer", sb5.toString());
                        try {
                            if (c.this.Q != null) {
                                c.this.Q.onBufferingUpdate(c.this, downloadBytes);
                            }
                        } catch (Exception e16) {
                            PlayerUtils.log(6, "SuperMediaPlayer", "[onInfo]", e16);
                        }
                    }
                } else if (obj instanceof TPVideoCropInfo) {
                    TPVideoCropInfo tPVideoCropInfo = (TPVideoCropInfo) obj;
                    PlayerUtils.log(3, "SuperMediaPlayer", "[onInfo]extra PLAYER_INFO_MEDIACODEC_VIDEO_CROP, width=" + tPVideoCropInfo.getWidth() + ", height=" + tPVideoCropInfo.getHeight() + ", cropLeft=" + tPVideoCropInfo.getCropLeft() + ", cropRight=" + tPVideoCropInfo.getCropRight() + ", cropTop=" + tPVideoCropInfo.getCropTop() + ", cropBottom=" + tPVideoCropInfo.getCropBottom());
                }
                if (obj instanceof TPPlayerMsg.TPCDNURLInfo) {
                    TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = (TPPlayerMsg.TPCDNURLInfo) obj;
                    PlayerUtils.log(3, "SuperMediaPlayer", "[onInfo]extra PLAYER_INFO_OBJECT_PLAY_CDN_INFO_UPDATE, url=" + tPCDNURLInfo.url + ", uIP=" + tPCDNURLInfo.uIp + ", cdnIP=" + tPCDNURLInfo.cdnIp + ", error=" + tPCDNURLInfo.errorStr);
                }
            }
            return false;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
        public void onSeekComplete(ISuperPlayer iSuperPlayer) {
            if (c.this.P != null) {
                c.this.P.onSeekComplete(c.this);
            } else {
                PlayerUtils.log(5, "SuperMediaPlayer", "[onSeekComplete] invalid out listener");
            }
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
            if (c.this.M != null) {
                c.this.M.onPrepared(c.this);
            } else {
                PlayerUtils.log(5, "SuperMediaPlayer", "[onVideoPrepared] invalid out listener");
            }
            PlayerUtils.log(3, "SuperMediaPlayer", "[onVideoPrepared] dumpStreamInfo=" + iSuperPlayer.getStreamDumpInfo());
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(ISuperPlayer iSuperPlayer, int i3, int i16) {
            PlayerUtils.log(3, "SuperMediaPlayer", "[onVideoSizeChanged] width=" + i3 + ", height=" + i16);
            IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = c.this.R;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(c.this, i3, i16);
            } else {
                PlayerUtils.log(5, "SuperMediaPlayer", "[onError] invalid out listener");
            }
        }

        private int a() {
            try {
                if (c.this.f279459d.getDurationMs() == 0) {
                    return 0;
                }
                return (int) ((((float) (c.this.f279459d.getPlayableDurationMs() - c.this.f279459d.getCurrentPositionMs())) * 100.0f) / ((float) c.this.f279459d.getDurationMs()));
            } catch (Exception e16) {
                PlayerUtils.log(3, "SuperMediaPlayer", e16.toString());
                return 0;
            }
        }
    }

    public c() {
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(PlayerConfig.g().getAppContext(), 102, null);
        this.f279459d = createMediaPlayer;
        createMediaPlayer.setOnVideoPreparedListener(this.f279460e);
        this.f279459d.setOnInfoListener(this.f279460e);
        this.f279459d.setOnCompletionListener(this.f279460e);
        this.f279459d.setOnSeekCompleteListener(this.f279460e);
        this.f279459d.setOnVideoSizeChangedListener(this.f279460e);
        this.f279459d.setOnErrorListener(this.f279460e);
    }

    private void B() {
        WeakReference<Surface> weakReference = this.I;
        Surface surface = weakReference == null ? null : weakReference.get();
        if (surface != null) {
            surface.release();
        }
    }

    private void C(boolean z16) {
        PowerManager.WakeLock wakeLock = this.G;
        if (wakeLock != null) {
            if (z16 && !wakeLock.isHeld()) {
                this.G.acquire();
                PlayerUtils.log(3, "SuperMediaPlayer", "[stayAwake] wake lock acquired");
            } else {
                if (z16 || !this.G.isHeld()) {
                    return;
                }
                this.G.release();
                PlayerUtils.log(3, "SuperMediaPlayer", "[stayAwake] wake lock released");
            }
        }
    }

    static /* synthetic */ int e(c cVar) {
        int i3 = cVar.K;
        cVar.K = i3 + 1;
        return i3;
    }

    public String A() {
        int i3 = this.C;
        if (i3 == 101) {
            return "\u8f6f\u89e3";
        }
        if (i3 != 102) {
            return "unknown";
        }
        return "\u786c\u89e3";
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[getCurrentPosition] invalid player");
            return 0L;
        }
        return iSuperPlayer.getCurrentPositionMs();
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public String getCurrentProxySegmentUrl() {
        return this.f279461f;
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public String getCurrentSegmentUrl() {
        return this.f279461f;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return this.f279461f;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[getDuration] invalid player");
            return 0L;
        }
        return iSuperPlayer.getDurationMs();
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

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        PlayerUtils.log(3, "SuperMediaPlayer", "[getVideoHeight]");
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[getVideoHeight] invalid player");
            return 0;
        }
        return iSuperPlayer.getVideoHeight();
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
    public int getVideoWidth() {
        PlayerUtils.log(3, "SuperMediaPlayer", "[getVideoWidth]");
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[getVideoWidth] invalid player");
            return 0;
        }
        return iSuperPlayer.getVideoWidth();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[isLooping] invalid player");
            return false;
        }
        return iSuperPlayer.isLoopBack();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[isPlaying] invalid player");
            return false;
        }
        return iSuperPlayer.isPlaying();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws IllegalStateException, IMediaPlayer.InternalOperationException {
        PlayerUtils.log(3, "SuperMediaPlayer", "[pause]");
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[start] invalid player");
        } else {
            iSuperPlayer.pause();
            C(false);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        PlayerUtils.log(3, "SuperMediaPlayer", "[prepareAsync]");
        if (this.f279459d == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[prepareAsync] invalid player");
            return;
        }
        SuperPlayerOption obtain = SuperPlayerOption.obtain();
        obtain.tpCoreSampleRate = FeedVideoEnv.getTpCoreSampleRate();
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
        if (feedVideoExternalFunc != null) {
            feedVideoExternalFunc.injectExtraParam(this.f279459d, this.f279463i, obtain);
        }
        PlayerUtils.log(3, "SuperMediaPlayer", "[prepareAsync] tpCoreSampleRate:" + obtain.tpCoreSampleRate);
        this.f279459d.openMediaPlayer(PlayerConfig.g().getAppContext(), this.f279463i, this.f279464m, obtain);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        PlayerUtils.log(3, "SuperMediaPlayer", "[release]");
        this.J = true;
        if (this.I != null) {
            B();
            this.I.clear();
            this.I = null;
        }
        Handler handler = this.T;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[release] invalid player");
        } else {
            iSuperPlayer.release();
            C(false);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        PlayerUtils.log(3, "SuperMediaPlayer", "[reset]");
        this.J = true;
        WeakReference<Surface> weakReference = this.I;
        if (weakReference != null) {
            weakReference.clear();
            this.I = null;
        }
        Handler handler = this.T;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[reset] invalid player");
        } else {
            iSuperPlayer.reset();
            C(false);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long j3) throws IllegalStateException {
        PlayerUtils.log(3, "SuperMediaPlayer", "[seekTo] position=" + j3);
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[seekTo] invalid player");
        } else {
            iSuperPlayer.seekTo((int) j3, this.F);
        }
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo) throws IOException {
        setDataSource(streamInfo, 0);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (PlayerConfig.g().isDebugVersion()) {
            throw new UnsupportedOperationException("[setDisplay] no supported yet");
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z16) {
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[setLooping] invalid player");
        } else {
            iSuperPlayer.setLoopback(z16);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setNextMediaPlayer(IMediaPlayer iMediaPlayer) throws UnsupportedOperationException {
        if (PlayerConfig.g().isDebugVersion()) {
            throw new UnsupportedOperationException("[setNextMediaPlayer] no supported yet");
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (this.f279459d == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[setOnBufferingUpdateListener] invalid player");
        } else {
            this.Q = onBufferingUpdateListener;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.f279459d == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[setOnCompletionListener] invalid player");
        } else {
            this.N = onCompletionListener;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        if (this.f279459d == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[setOnErrorListener] invalid player");
        } else {
            this.S = onErrorListener;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        if (this.f279459d == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[setOnInfoListener] invalid player");
        } else {
            this.L = onInfoListener;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (this.f279459d == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[setSurface] invalid player");
        } else {
            this.M = onPreparedListener;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (this.f279459d == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[setOnSeekCompleteListener] invalid player");
        } else {
            this.P = onSeekCompleteListener;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (this.f279459d == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[setOnVideoSizeChangedListener] invalid player");
        } else {
            this.R = onVideoSizeChangedListener;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSeekParameters(SeekParameters seekParameters) {
        if (SeekParameters.EXACT == seekParameters) {
            this.F = 3;
        } else if (SeekParameters.NEXT_SYNC == seekParameters) {
            this.F = 4;
        } else {
            this.F = 1;
        }
        PlayerUtils.log(3, "SuperMediaPlayer", "[setSeekParameters] seekType=" + this.F);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        if (this.f279459d == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[setSurface] invalid surface");
            return;
        }
        B();
        this.f279459d.setSurface(surface);
        this.I = new WeakReference<>(surface);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f16, float f17) {
        PlayerUtils.log(3, "SuperMediaPlayer", "[setVolume]");
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[reset] invalid player");
        } else if (f16 > 0.5f) {
            iSuperPlayer.setOutputMute(false);
        } else {
            iSuperPlayer.setOutputMute(true);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(Context context, int i3) {
        boolean z16;
        PowerManager.WakeLock wakeLock = this.G;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                this.G.release();
                z16 = true;
            } else {
                z16 = false;
            }
            this.G = null;
        } else {
            z16 = false;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.WAKE_LOCK", context.getPackageName()) == 0) {
                PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i3 | 536870912, c.class.getName());
                this.G = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            } else {
                PlayerUtils.log(5, "SuperMediaPlayer", "[setWakeMode] no wakelock permission");
            }
        } catch (Exception e16) {
            PlayerUtils.log(5, "SuperMediaPlayer", "[setWakeMode]", e16);
        }
        C(z16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws IllegalStateException, IMediaPlayer.InternalOperationException {
        PlayerUtils.log(3, "SuperMediaPlayer", "[start]");
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[start] invalid player");
        } else {
            iSuperPlayer.start();
            C(true);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        PlayerUtils.log(3, "SuperMediaPlayer", "[stop]");
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[start] invalid player");
        } else {
            iSuperPlayer.stop();
            C(false);
        }
    }

    public String u() {
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer != null && iSuperPlayer.getMediaInfo() != null) {
            return this.f279459d.getMediaInfo().getAudioCodec();
        }
        PlayerUtils.log(6, "SuperMediaPlayer", "[getAudioCodecName] invalid player");
        return null;
    }

    public int v() {
        return (int) this.E;
    }

    public String w() {
        return "\u64ad\u653e\u4e2d\u53f0";
    }

    public String x() {
        int i3 = this.D;
        if (i3 == 1) {
            return "AndroidPlayer";
        }
        if (i3 != 2) {
            return "unknown";
        }
        return "ThumbPlayer";
    }

    public long y() {
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[getVideoBitrate] invalid player");
            return -1L;
        }
        com.tencent.superplayer.player.MediaInfo mediaInfo = iSuperPlayer.getMediaInfo();
        if (mediaInfo == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[getVideoBitrate] invalid mediaInfo");
            return -2L;
        }
        return mediaInfo.getVideoBitRate();
    }

    public String z() {
        ISuperPlayer iSuperPlayer = this.f279459d;
        if (iSuperPlayer != null && iSuperPlayer.getMediaInfo() != null) {
            return this.f279459d.getMediaInfo().getVideoCodec();
        }
        PlayerUtils.log(6, "SuperMediaPlayer", "[getVideoVideoName] invalid player");
        return null;
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo, int i3) throws IOException {
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc;
        PlayerUtils.log(3, "SuperMediaPlayer", "[setDataSource]1, " + this);
        if (this.f279459d == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[setDataSource]1 invalid player");
            return;
        }
        if (streamInfo != null && (arrayList = streamInfo.segmentInfos) != null && arrayList.get(0) != null) {
            this.f279461f = streamInfo.getSegment(0).url;
            long j3 = streamInfo.getSegment(0).duration;
            if (TextUtils.isEmpty(streamInfo.mSafeUrlKey)) {
                this.f279462h = this.f279461f;
            } else {
                this.f279462h = streamInfo.mSafeUrlKey;
            }
            int i16 = PlayerUtils.isHLSStream(this.f279461f) ? 102 : 101;
            FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc2 = FeedVideoEnv.externalFunc;
            if (feedVideoExternalFunc2 != null && feedVideoExternalFunc2.isDebugVersion() && FeedVideoEnv.externalFunc.forceUrlExpired()) {
                Uri parse = Uri.parse(this.f279461f);
                String str = parse.getScheme() + QzoneWebViewOfflinePlugin.STR_DEVIDER + parse.getHost() + parse.getPath();
                PlayerUtils.log(3, "SuperMediaPlayer", "[setDataSource]1 url=" + this.f279461f + ", format=" + i16 + ", originalUrl=" + this.f279462h + ", spliceUrl=" + str);
                this.f279463i = SuperPlayerFactory.createVideoInfoForUrl(new String[]{str}, i16, j3, (String) null);
                this.f279464m = (long) i3;
                return;
            }
            String g16 = com.tencent.mobileqq.qzoneplayer.videosource.a.d().g(this.f279461f);
            PlayerUtils.log(3, "SuperMediaPlayer", "[setDataSource]1 url=" + this.f279461f + ", format=" + i16 + ", originalUrl=" + this.f279462h + ", spliceUrl=" + g16);
            this.f279463i = SuperPlayerFactory.createVideoInfoForUrl(new String[]{g16}, i16, j3, (String) null);
            if (!this.f279461f.equals(g16) && (feedVideoExternalFunc = FeedVideoEnv.externalFunc) != null && feedVideoExternalFunc.isUgcOnCloudUrl(this.f279461f) && com.tencent.mobileqq.qzoneplayer.videosource.a.d().a()) {
                Uri parse2 = Uri.parse(this.f279461f);
                ArrayList<String> arrayList2 = new ArrayList<>();
                arrayList2.add(parse2.getHost());
                this.f279463i.setUrlHostList(arrayList2);
            }
            this.f279464m = i3;
            return;
        }
        PlayerUtils.log(6, "SuperMediaPlayer", "[setDataSource]1 invalid stream info");
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
    public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener onLoopStartListener) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z16) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        if (PlayerConfig.g().isDebugVersion()) {
            throw new UnsupportedOperationException("[setDataSource(FileDescriptor)] no supported yet");
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        if (PlayerConfig.g().isDebugVersion()) {
            throw new UnsupportedOperationException("[setDataSource(FileDescriptor)] no supported yet");
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException, UnsupportedOperationException {
        if (PlayerConfig.g().isDebugVersion()) {
            throw new UnsupportedOperationException("[setDataSource(FileDescriptor)] no supported yet");
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        if (this.f279459d == null) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[setDataSource]3 invalid player");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            PlayerUtils.log(6, "SuperMediaPlayer", "[setDataSource]3 invalid player");
            return;
        }
        this.f279461f = str;
        PlayerUtils.log(3, "SuperMediaPlayer", "[setDataSource]3 url=" + this.f279461f);
        this.f279463i = SuperPlayerFactory.createVideoInfoForUrl(this.f279461f, 101, (String) null);
        this.f279464m = 0L;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) throws UnsupportedOperationException {
        if (PlayerConfig.g().isDebugVersion()) {
            throw new UnsupportedOperationException("[setDataSource(IMediaDataSource)] no supported yet");
        }
    }
}
