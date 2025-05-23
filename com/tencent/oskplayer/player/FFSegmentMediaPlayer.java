package com.tencent.oskplayer.player;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.AbstractMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

/* loaded from: classes22.dex */
public class FFSegmentMediaPlayer extends AbstractMediaPlayer implements ISegmentMediaPlayer {
    private static final String LOG_TAG = "FFSegmentMediaPlayer";
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private static Object sIsSupported;
    private boolean isLooping;
    private final AbstractMediaPlayerListenerHolder mInternalListenerAdapter;
    private IjkMediaPlayer mInternalMediaPlayer;
    private boolean mLoopingPlaySeek;
    private File mPlayListFile;
    private List<String> mProxyUrls;
    private SeekParameters mSeekParameters;
    private List<String> mSourceUrls;
    private int mCurrentState = 0;
    private int mTargetState = 0;
    private String mPath = null;
    private boolean preventBufferingEvent = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class AbstractMediaPlayerListenerHolder implements IMediaPlayer.OnPreparedListener, IMediaPlayer.OnBufferingUpdateListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnVideoSizeChangedListener {
        public final WeakReference<AbstractMediaPlayer> mWeakMediaPlayer;

        public AbstractMediaPlayerListenerHolder(AbstractMediaPlayer abstractMediaPlayer) {
            this.mWeakMediaPlayer = new WeakReference<>(abstractMediaPlayer);
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i3) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            PlayerUtils.log(3, FFSegmentMediaPlayer.LOG_TAG, "onBufferingUpdate");
            FFSegmentMediaPlayer.this.notifyOnBufferingUpdate(i3);
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            AbstractMediaPlayer abstractMediaPlayer = this.mWeakMediaPlayer.get();
            if (abstractMediaPlayer == null) {
                return;
            }
            if (FFSegmentMediaPlayer.this.isLooping) {
                PlayerUtils.log(4, FFSegmentMediaPlayer.LOG_TAG, "looping play start");
                FFSegmentMediaPlayer.this.preventBufferingEvent = true;
                FFSegmentMediaPlayer.this.mLoopingPlaySeek = true;
                abstractMediaPlayer.seekTo(0L);
                try {
                    abstractMediaPlayer.start();
                    if (((AbstractMediaPlayer) FFSegmentMediaPlayer.this).mOnLoopStartListener != null) {
                        ((AbstractMediaPlayer) FFSegmentMediaPlayer.this).mOnLoopStartListener.onLoopStart(FFSegmentMediaPlayer.this);
                        return;
                    }
                    return;
                } catch (IMediaPlayer.InternalOperationException e16) {
                    PlayerUtils.log(6, FFSegmentMediaPlayer.LOG_TAG, e16.toString());
                    return;
                }
            }
            PlayerUtils.log(4, FFSegmentMediaPlayer.LOG_TAG, "onCompletion");
            FFSegmentMediaPlayer.this.notifyOnCompletion();
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i3, int i16) {
            AbstractMediaPlayer abstractMediaPlayer = this.mWeakMediaPlayer.get();
            PlayerUtils.log(4, FFSegmentMediaPlayer.LOG_TAG, "onError");
            FFSegmentMediaPlayer.this.mCurrentState = -1;
            FFSegmentMediaPlayer.this.mTargetState = -1;
            if (abstractMediaPlayer != null && FFSegmentMediaPlayer.this.notifyOnError(i3, i16)) {
                return true;
            }
            return false;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i3, int i16) {
            if (this.mWeakMediaPlayer.get() == null) {
                return false;
            }
            PlayerUtils.log(3, FFSegmentMediaPlayer.LOG_TAG, "onInfo what=" + i3 + ",extra=" + i16);
            if (FFSegmentMediaPlayer.this.preventBufferingEvent && i3 == 701) {
                return false;
            }
            if (!FFSegmentMediaPlayer.this.preventBufferingEvent || i3 != 702) {
                return FFSegmentMediaPlayer.this.notifyOnInfo(i3, i16);
            }
            FFSegmentMediaPlayer.this.preventBufferingEvent = false;
            return false;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            PlayerUtils.log(4, FFSegmentMediaPlayer.LOG_TAG, "onPrepared");
            FFSegmentMediaPlayer.this.mCurrentState = 2;
            if (FFSegmentMediaPlayer.this.mTargetState == 3) {
                FFSegmentMediaPlayer.this.start();
            }
            FFSegmentMediaPlayer.this.notifyOnPrepared();
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            if (FFSegmentMediaPlayer.this.mLoopingPlaySeek) {
                FFSegmentMediaPlayer.this.mLoopingPlaySeek = false;
            } else {
                FFSegmentMediaPlayer.this.notifyOnSeekComplete();
            }
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i3, int i16) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            PlayerUtils.log(4, FFSegmentMediaPlayer.LOG_TAG, "onVideoSizeChanged");
            FFSegmentMediaPlayer.this.notifyOnVideoSizeChanged(i3, i16, 1, 1);
        }
    }

    public FFSegmentMediaPlayer() {
        if (isSupported()) {
            this.mInternalListenerAdapter = new AbstractMediaPlayerListenerHolder(this);
            initPlayer();
            return;
        }
        throw new UnsupportedOperationException("FFSegmentMediaPlayer is not available to use");
    }

    private void attachInternalListeners() {
        this.mInternalMediaPlayer.setOnPreparedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnBufferingUpdateListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnCompletionListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnSeekCompleteListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnVideoSizeChangedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnErrorListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnInfoListener(this.mInternalListenerAdapter);
    }

    public static synchronized void disable() {
        synchronized (FFSegmentMediaPlayer.class) {
            sIsSupported = Boolean.FALSE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0169 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String generatePlayListFile(SegmentVideoInfo.StreamInfo streamInfo, List<String> list) {
        FileOutputStream fileOutputStream;
        int i3 = 0;
        if (streamInfo.segmentInfos.size() == 1) {
            return list.get(0);
        }
        if (this.mPlayListFile == null) {
            String tempDir = PlayerConfig.g().getTempDir();
            if (tempDir == null) {
                PlayerUtils.log(6, LOG_TAG, "GeneratePlayListFile Error: dirPath is null");
                return null;
            }
            File file = new File(tempDir);
            this.mPlayListFile = new File(tempDir + File.separator + System.currentTimeMillis() + ".qzvideo");
            if (!file.exists()) {
                file.mkdirs();
            }
            ?? r26 = "GeneratePlayListFile " + this.mPlayListFile;
            PlayerUtils.log(4, LOG_TAG, (String) r26);
            try {
                try {
                    fileOutputStream = new FileOutputStream(this.mPlayListFile);
                } catch (FileNotFoundException e16) {
                    e = e16;
                    fileOutputStream = null;
                } catch (IOException e17) {
                    e = e17;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    r26 = 0;
                    if (r26 != 0) {
                    }
                    throw th;
                }
                try {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("qzvideo version 1.0\n");
                    Iterator<SegmentVideoInfo.SegmentInfo> it = streamInfo.segmentInfos.iterator();
                    while (it.hasNext()) {
                        SegmentVideoInfo.SegmentInfo next = it.next();
                        sb5.append("file ");
                        sb5.append(list.get(i3));
                        sb5.append("\n");
                        sb5.append("duration ");
                        sb5.append(next.duration / 1000);
                        sb5.append("\n");
                        i3++;
                    }
                    fileOutputStream.write(sb5.toString().getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException e18) {
                        PlayerUtils.log(6, LOG_TAG, "PlayListFile close Error: " + e18.getMessage());
                        return null;
                    }
                } catch (FileNotFoundException e19) {
                    e = e19;
                    PlayerUtils.log(6, LOG_TAG, "GeneratePlayListFile Error: " + e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e26) {
                            PlayerUtils.log(6, LOG_TAG, "PlayListFile close Error: " + e26.getMessage());
                        }
                    }
                    return null;
                } catch (IOException e27) {
                    e = e27;
                    PlayerUtils.log(6, LOG_TAG, "GeneratePlayListFile Write Error: " + e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e28) {
                            PlayerUtils.log(6, LOG_TAG, "PlayListFile close Error: " + e28.getMessage());
                        }
                    }
                    return null;
                }
            } catch (Throwable th6) {
                th = th6;
                if (r26 != 0) {
                    try {
                        r26.close();
                    } catch (IOException e29) {
                        PlayerUtils.log(6, LOG_TAG, "PlayListFile close Error: " + e29.getMessage());
                        return null;
                    }
                }
                throw th;
            }
        }
        return this.mPlayListFile.getAbsolutePath();
    }

    private void initPlayer() {
        this.mInternalMediaPlayer = new IjkMediaPlayer(PlayerConfig.g().getNativeLibLoader());
        this.mCurrentState = 0;
        this.mTargetState = 0;
        if (PlayerConfig.g().isEnableHevcHwDecode()) {
            this.mInternalMediaPlayer.setOption(4, "mediacodec-all-videos", 1L);
        } else {
            this.mInternalMediaPlayer.setOption(4, "mediacodec", 0L);
        }
        this.mInternalMediaPlayer.setOption(2, "skip_loop_filter", 0L);
        this.mInternalMediaPlayer.setOption(4, "http-detect-range-support", 0L);
        this.mInternalMediaPlayer.setOption(4, "start-on-prepared", 0L);
        this.mInternalMediaPlayer.setOption(4, "infbuf", 1L);
        this.mInternalMediaPlayer.setOption(4, VideoConverterConfig.SoftwareConfig.PRESET_FAST, 1L);
        this.mInternalMediaPlayer.setOption(4, "framedrop", 5L);
        this.mInternalMediaPlayer.setOption(4, "enable-accurate-seek", 1L);
        this.mInternalMediaPlayer.setOption(4, "max-fps", 30L);
        this.mInternalMediaPlayer.setOption(1, "analyzeduration", 1L);
        this.mInternalMediaPlayer.setOption(4, "opensles", 0L);
        this.mInternalMediaPlayer.setOption(1, "protocol_whitelist", "file,http,https,tcp,tls");
        this.mInternalMediaPlayer.setOption(1, "safe", 0L);
        this.mInternalMediaPlayer.setLooping(false);
        this.mInternalMediaPlayer.setSurface(null);
        this.mInternalMediaPlayer.setSeekParameters(this.mSeekParameters);
        attachInternalListeners();
        this.mPath = null;
    }

    private boolean isInPlaybackState() {
        int i3;
        if (this.mInternalMediaPlayer != null && (i3 = this.mCurrentState) != -1 && i3 != 0 && i3 != 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0064 A[Catch: all -> 0x0075, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:10:0x000f, B:18:0x0059, B:20:0x005d, B:21:0x0060, B:23:0x0064, B:24:0x0068, B:29:0x0036), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean isSupported() {
        IjkMediaPlayer ijkMediaPlayer;
        Throwable th5;
        synchronized (FFSegmentMediaPlayer.class) {
            Object obj = sIsSupported;
            if (obj != null) {
                return ((Boolean) obj).booleanValue();
            }
            if (IjkMediaPlayer.isNativeLibReady(PlayerConfig.g().getNativeLibLoader())) {
                try {
                    ijkMediaPlayer = new IjkMediaPlayer(PlayerConfig.g().getNativeLibLoader());
                } catch (Throwable th6) {
                    ijkMediaPlayer = null;
                    th5 = th6;
                }
                try {
                    sIsSupported = Boolean.TRUE;
                } catch (Throwable th7) {
                    th5 = th7;
                    sIsSupported = Boolean.FALSE;
                    PlayerUtils.log(4, LOG_TAG, "error init hero player " + PlayerUtils.getPrintableStackTrace(th5));
                    if (ijkMediaPlayer != null) {
                        ijkMediaPlayer.release();
                    }
                    if (!IjkMediaPlayer.sIsLibLoadSuccess) {
                    }
                    return ((Boolean) sIsSupported).booleanValue();
                }
                if (ijkMediaPlayer != null && IjkMediaPlayer.sIsLibLoadSuccess) {
                    ijkMediaPlayer.release();
                }
                if (!IjkMediaPlayer.sIsLibLoadSuccess) {
                    sIsSupported = Boolean.FALSE;
                }
                return ((Boolean) sIsSupported).booleanValue();
            }
            return false;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.mInternalMediaPlayer.getAudioSessionId();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        if (isInPlaybackState()) {
            long currentPosition = this.mInternalMediaPlayer.getCurrentPosition();
            PlayerUtils.log(2, LOG_TAG, "getCurrentPosition=" + currentPosition);
            return currentPosition;
        }
        PlayerUtils.log(5, LOG_TAG, "getCurrentPosition failed, state error");
        return 0L;
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
        return this.mInternalMediaPlayer.getDataSource();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        if (isInPlaybackState()) {
            long duration = this.mInternalMediaPlayer.getDuration();
            PlayerUtils.log(2, LOG_TAG, "getDuration=" + duration);
            return duration;
        }
        PlayerUtils.log(5, LOG_TAG, "getDuration failed, state error");
        return 0L;
    }

    public IjkMediaPlayer getInternalMediaPlayer() {
        return this.mInternalMediaPlayer;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        return this.mInternalMediaPlayer.getMediaInfo();
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public int getSegmentCount() {
        return 1;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        return this.mInternalMediaPlayer.getTrackInfo();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mInternalMediaPlayer.getVideoHeight();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return this.mInternalMediaPlayer.getVideoSarDen();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return this.mInternalMediaPlayer.getVideoSarNum();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mInternalMediaPlayer.getVideoWidth();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.isLooping;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return this.mInternalMediaPlayer.isPlayable();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        if (isInPlaybackState() && this.mInternalMediaPlayer.isPlaying()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.ijk.media.player.AbstractMediaPlayer
    public void notifyOnSeekComplete() {
        PlayerUtils.log(4, LOG_TAG, "onSeekComplete");
        super.notifyOnSeekComplete();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws IllegalStateException {
        PlayerUtils.log(4, LOG_TAG, "pause");
        if (isInPlaybackState()) {
            if (this.mInternalMediaPlayer.isPlaying()) {
                this.mInternalMediaPlayer.pause();
                this.mCurrentState = 4;
            } else {
                PlayerUtils.log(5, LOG_TAG, "pause failed, state error");
            }
        } else {
            PlayerUtils.log(5, LOG_TAG, "pause failed, state error");
        }
        this.mTargetState = 4;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        PlayerUtils.log(4, LOG_TAG, "prepareAsync");
        this.mInternalMediaPlayer.prepareAsync();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        if (this.mInternalMediaPlayer != null) {
            PlayerUtils.log(4, LOG_TAG, "release");
            this.mInternalMediaPlayer.setSurface(null);
            this.mInternalMediaPlayer.release();
            this.mCurrentState = 0;
            this.mTargetState = 0;
            this.mInternalMediaPlayer = null;
        }
        File file = this.mPlayListFile;
        if (file != null && file.exists() && !this.mPlayListFile.delete()) {
            PlayerUtils.log(5, LOG_TAG, "playlist file delete failed!");
        }
        this.mPlayListFile = null;
        this.mPath = null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        PlayerUtils.log(4, LOG_TAG, "reset");
        IjkMediaPlayer ijkMediaPlayer = this.mInternalMediaPlayer;
        if (ijkMediaPlayer == null) {
            return;
        }
        ijkMediaPlayer.reset();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long j3) throws IllegalStateException {
        PlayerUtils.log(4, LOG_TAG, "seekTo " + j3);
        if (this.mCurrentState == 2) {
            this.mInternalMediaPlayer.start();
        }
        if (isInPlaybackState()) {
            this.mInternalMediaPlayer.seekTo(j3);
        } else {
            PlayerUtils.log(5, LOG_TAG, "seekTo failed, state error");
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i3) {
        this.mInternalMediaPlayer.setAudioStreamType(i3);
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo, int i3) throws IOException {
        setDataSource(streamInfo);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        PlayerUtils.log(4, LOG_TAG, "setSurfaceHolder");
        IjkMediaPlayer ijkMediaPlayer = this.mInternalMediaPlayer;
        if (ijkMediaPlayer == null) {
            return;
        }
        ijkMediaPlayer.setDisplay(surfaceHolder);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z16) {
        this.mInternalMediaPlayer.setKeepInBackground(z16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z16) {
        this.mInternalMediaPlayer.setLogEnabled(z16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z16) {
        this.isLooping = z16;
        PlayerUtils.log(4, LOG_TAG, "setLooping " + this.isLooping);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setNextMediaPlayer(IMediaPlayer iMediaPlayer) throws UnsupportedOperationException {
        this.mInternalMediaPlayer.setNextMediaPlayer(iMediaPlayer);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z16) {
        this.mInternalMediaPlayer.setScreenOnWhilePlaying(z16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSeekParameters(SeekParameters seekParameters) {
        this.mSeekParameters = seekParameters;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        PlayerUtils.log(4, LOG_TAG, V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface);
        IjkMediaPlayer ijkMediaPlayer = this.mInternalMediaPlayer;
        if (ijkMediaPlayer == null) {
            return;
        }
        ijkMediaPlayer.setSurface(surface);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f16, float f17) {
        PlayerUtils.log(4, LOG_TAG, "setVolume leftVolume=" + f16 + " rightVolume" + f17);
        this.mInternalMediaPlayer.setVolume(f16, f17);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(Context context, int i3) {
        if (context != null) {
            this.mInternalMediaPlayer.setWakeMode(context, i3);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws IllegalStateException {
        PlayerUtils.log(4, LOG_TAG, "start");
        if (isInPlaybackState()) {
            this.mInternalMediaPlayer.start();
            this.mCurrentState = 3;
        } else {
            PlayerUtils.log(5, LOG_TAG, "start failed, state error");
        }
        this.mTargetState = 3;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        this.mInternalMediaPlayer.stop();
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo) throws IOException {
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        if (this.mInternalMediaPlayer == null || streamInfo == null || (arrayList = streamInfo.segmentInfos) == null || arrayList.get(0) == null) {
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
        List<String> url = VideoManager.getInstance().getUrl(this.mSourceUrls);
        this.mProxyUrls = url;
        String generatePlayListFile = generatePlayListFile(streamInfo, url);
        String str = this.mPath;
        if (str == null || !str.equals(generatePlayListFile)) {
            this.mPath = generatePlayListFile;
            if (this.mInternalMediaPlayer.isPlaying()) {
                this.mInternalMediaPlayer.stop();
                IjkMediaPlayer ijkMediaPlayer = this.mInternalMediaPlayer;
                if (ijkMediaPlayer != null) {
                    ijkMediaPlayer.release();
                    this.mInternalMediaPlayer = null;
                    this.mCurrentState = 0;
                }
                initPlayer();
            }
            if (generatePlayListFile != null) {
                try {
                    this.mInternalMediaPlayer.setDataSource(generatePlayListFile);
                    this.mCurrentState = 1;
                    return;
                } catch (IOException unused) {
                    PlayerUtils.log(6, LOG_TAG, "IOException:Unable to open content: " + generatePlayListFile);
                    this.mCurrentState = -1;
                    this.mTargetState = -1;
                    return;
                } catch (IllegalArgumentException unused2) {
                    PlayerUtils.log(6, LOG_TAG, "IllegalArgumentException:Unable to open content: " + generatePlayListFile);
                    this.mCurrentState = -1;
                    this.mTargetState = -1;
                    return;
                }
            }
            throw new IOException("path is null");
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(context, uri);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(context, uri, map);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(fileDescriptor);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(new SegmentVideoInfo.StreamInfo(str, 0));
    }
}
