package com.tencent.ark;

import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.ark.ark;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;

/* loaded from: classes3.dex */
public class ArkPlayer implements ark.PlayerStub, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnSeekCompleteListener {
    public static final String TAG = "ArkApp.ArkPlayer";
    protected boolean mPlayWhenReady;
    protected MediaPlayer mPlayer;
    protected ArkPlayerSurfaceHolder mSurfaceHolder;
    protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    public static final ark.PlayerStubFactory sFactory = new ark.PlayerStubFactory() { // from class: com.tencent.ark.ArkPlayer.1
        @Override // com.tencent.ark.ark.PlayerStubFactory
        public ark.PlayerStub CreateStub() {
            return new ArkPlayer();
        }
    };
    protected int mBufferPercent = 0;
    protected int mErrorCode = 0;
    protected long mStateCallback = 0;
    protected long mStateUserdata = 0;
    protected long mBufferingCallback = 0;
    protected long mBufferingUserdata = 0;
    protected long mFrameCallback = 0;
    protected long mFrameUserdata = 0;
    protected double mSeekPos = -1.0d;
    protected String mQueueKey = ArkDispatchQueue.getCurrentQueueKey();
    protected ark.PlayerStub.MediaInfo mMediaInfo = new ark.PlayerStub.MediaInfo();

    /* JADX INFO: Access modifiers changed from: protected */
    public ArkPlayer() {
        Logger.logI(TAG, String.format("player.create.%h", this));
    }

    private void bufferingChange(final boolean z16) {
        ArkDispatchQueue.asyncRun(this.mQueueKey, new Runnable() { // from class: com.tencent.ark.ArkPlayer.4
            @Override // java.lang.Runnable
            public void run() {
                ArkPlayer arkPlayer = ArkPlayer.this;
                ark.PlayerBufferingChange(arkPlayer.mBufferingCallback, arkPlayer.mBufferingUserdata, z16);
            }
        });
    }

    private void changeState(final int i3) {
        ark.PlayerStub.MediaInfo mediaInfo = this.mMediaInfo;
        final int i16 = mediaInfo.state;
        mediaInfo.state = i3;
        ArkDispatchQueue.asyncRun(this.mQueueKey, new Runnable() { // from class: com.tencent.ark.ArkPlayer.3
            @Override // java.lang.Runnable
            public void run() {
                ArkPlayer arkPlayer = ArkPlayer.this;
                ark.PlayerStateChange(arkPlayer.mStateCallback, arkPlayer.mStateUserdata, i16, i3);
            }
        });
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public void Destroy() {
        Logger.logI(TAG, String.format("player.destroy.%h", this));
        ArkPlayerSurfaceHolder arkPlayerSurfaceHolder = this.mSurfaceHolder;
        if (arkPlayerSurfaceHolder != null) {
            arkPlayerSurfaceHolder.deinitialize();
            this.mSurfaceHolder = null;
        }
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mPlayer = null;
        }
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public double GetBufferedTime() {
        if (this.mPlayer == null) {
            return 0.0d;
        }
        try {
            return (r0.getDuration() * this.mBufferPercent) / 100000.0d;
        } catch (Exception e16) {
            Logger.logE(TAG, e16.getLocalizedMessage());
            return 0.0d;
        }
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public double GetCurrentTime() {
        if (this.mPlayer == null || this.mMediaInfo.state == 5) {
            return 0.0d;
        }
        double d16 = this.mSeekPos;
        if (d16 >= 0.0d) {
            return d16;
        }
        try {
            return r0.getCurrentPosition() / 1000.0d;
        } catch (Exception e16) {
            Logger.logE(TAG, e16.getLocalizedMessage());
            return 0.0d;
        }
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public int GetErrorCode() {
        return this.mErrorCode;
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public ark.PlayerStub.MediaInfo GetMediaInfo() {
        return this.mMediaInfo;
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public boolean Load(String str) {
        boolean z16;
        if (!VideoPreviewSupported()) {
            Logger.logE(TAG, "Load.unsupport.hardware!!");
            this.mErrorCode = -4;
            changeState(6);
            return false;
        }
        if (VideoPreviewSupported() && this.mFrameCallback != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Surface surface = null;
        if (z16) {
            if (this.mSurfaceHolder == null) {
                ArkPlayerSurfaceHolder arkPlayerSurfaceHolder = new ArkPlayerSurfaceHolder();
                this.mSurfaceHolder = arkPlayerSurfaceHolder;
                if (!arkPlayerSurfaceHolder.initialize()) {
                    this.mSurfaceHolder = null;
                    Logger.logE(TAG, "Load.mSurfaceHolder.initialize.fail!!");
                    return false;
                }
                this.mSurfaceHolder.SetFrameCallback(this.mFrameCallback, this.mFrameUserdata);
            }
            surface = this.mSurfaceHolder.getSurface();
            if (surface == null) {
                Logger.logE(TAG, "Load.mSurfaceHolder.getSurface.null!!");
                return false;
            }
        } else {
            Logger.logI(TAG, "Load.not.support.hw.rendering.play.audio.only!!");
        }
        if (this.mMediaInfo.state == 1) {
            Logger.logE(TAG, "Load.state.is.loading!!");
            return false;
        }
        this.mErrorCode = 0;
        if (this.mPlayer == null) {
            this.mPlayer = new ReportMediaPlayer();
        }
        if (TextUtils.isEmpty(str)) {
            this.mPlayer.reset();
            changeState(0);
            Logger.logI(TAG, "Load.url.is.null!!");
            return true;
        }
        if (this.mMediaInfo.state != 0) {
            this.mPlayer.reset();
        }
        this.mPlayer.setSurface(surface);
        this.mPlayer.setOnPreparedListener(this);
        this.mPlayer.setOnCompletionListener(this);
        this.mPlayer.setOnInfoListener(this);
        this.mPlayer.setOnErrorListener(this);
        this.mPlayer.setOnBufferingUpdateListener(this);
        this.mPlayer.setOnSeekCompleteListener(this);
        if (z16) {
            this.mPlayer.setOnVideoSizeChangedListener(this);
        }
        this.mPlayWhenReady = false;
        Logger.logI(TAG, "ArkPlayer.load.setDataSource url=" + str);
        try {
            this.mPlayer.setDataSource(str);
            this.mPlayer.prepareAsync();
            changeState(1);
            return true;
        } catch (Exception e16) {
            Logger.logE(TAG, "Load.mPlayer.setDataSource.fail!!" + e16.getMessage());
            return false;
        }
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public boolean Pause() {
        if (!VideoPreviewSupported()) {
            Logger.logE(TAG, "Pause.unsupport.hardware!!");
            this.mErrorCode = -4;
            changeState(6);
            return false;
        }
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return false;
        }
        int i3 = this.mMediaInfo.state;
        if (i3 != 3) {
            Logger.logE(TAG, StringUtil.format("Pause.wrong.state.%d!!", Integer.valueOf(i3)));
            return false;
        }
        try {
            mediaPlayer.pause();
            changeState(4);
            return true;
        } catch (IllegalStateException e16) {
            Logger.logE(TAG, e16.getLocalizedMessage());
            return false;
        }
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public boolean Play() {
        if (!VideoPreviewSupported()) {
            Logger.logE(TAG, "Play.unsupport.hardware!!");
            this.mErrorCode = -4;
            changeState(6);
            return false;
        }
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return false;
        }
        int i3 = this.mMediaInfo.state;
        if (i3 != 2 && i3 != 4 && i3 != 5 && i3 != 3) {
            Logger.logE(TAG, StringUtil.format("Play.wrong.state.%d!!", Integer.valueOf(i3)));
            return false;
        }
        try {
            this.mSeekPos = 0.0d;
            if (i3 == 5) {
                this.mPlayWhenReady = true;
                mediaPlayer.prepareAsync();
                this.mMediaInfo.state = 1;
                return true;
            }
            if (mediaPlayer.getDuration() > 0) {
                this.mPlayer.seekTo(0);
            }
            this.mPlayer.start();
            changeState(3);
            return true;
        } catch (IllegalStateException e16) {
            Logger.logE(TAG, e16.getLocalizedMessage());
            return false;
        }
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public boolean Resume() {
        if (!VideoPreviewSupported()) {
            Logger.logE(TAG, "Resume.unsupport.hardware!!");
            this.mErrorCode = -4;
            changeState(6);
            return false;
        }
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return false;
        }
        int i3 = this.mMediaInfo.state;
        if (i3 != 4) {
            Logger.logE(TAG, StringUtil.format("Resume.wrong.state.%d!!", Integer.valueOf(i3)));
            return false;
        }
        try {
            mediaPlayer.start();
            changeState(3);
            return true;
        } catch (IllegalStateException e16) {
            Logger.logE(TAG, e16.getLocalizedMessage());
            return false;
        }
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public boolean Seek(double d16) {
        if (!VideoPreviewSupported()) {
            Logger.logE(TAG, "Seek.unsupport.hardware!!");
            this.mErrorCode = -4;
            changeState(6);
            return false;
        }
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return false;
        }
        ark.PlayerStub.MediaInfo mediaInfo = this.mMediaInfo;
        int i3 = mediaInfo.state;
        if (i3 != 2 && i3 != 4 && i3 != 3) {
            Logger.logE(TAG, StringUtil.format("Seek.wrong.state.%d!!", Integer.valueOf(i3)));
            return false;
        }
        if (d16 < 0.0d) {
            d16 = 0.0d;
        }
        try {
            double d17 = mediaInfo.duration;
            if (d16 > d17) {
                d16 = d17;
            }
            mediaPlayer.seekTo((int) (1000.0d * d16));
            this.mSeekPos = d16;
            return true;
        } catch (IllegalStateException e16) {
            Logger.logE(TAG, e16.getLocalizedMessage());
            return false;
        }
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public void SetBufferingCallback(long j3, long j16) {
        this.mBufferingCallback = j3;
        this.mBufferingUserdata = j16;
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public void SetFrameCallback(long j3, long j16) {
        this.mFrameCallback = j3;
        this.mFrameUserdata = j16;
        ArkPlayerSurfaceHolder arkPlayerSurfaceHolder = this.mSurfaceHolder;
        if (arkPlayerSurfaceHolder != null) {
            arkPlayerSurfaceHolder.SetFrameCallback(j3, j16);
        }
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public void SetStateCallback(long j3, long j16) {
        this.mStateCallback = j3;
        this.mStateUserdata = j16;
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public boolean SetVolume(float f16) {
        if (!VideoPreviewSupported()) {
            Logger.logE(TAG, "SetVolume.unsupport.hardware!!");
            this.mErrorCode = -4;
            changeState(6);
            return false;
        }
        int i3 = this.mMediaInfo.state;
        if (i3 != 2 && i3 != 4 && i3 != 3 && i3 != 5) {
            Logger.logE(TAG, StringUtil.format("SetVolume.wrong.state.%d!!", Integer.valueOf(i3)));
            return false;
        }
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return false;
        }
        if (f16 < 0.0f) {
            f16 = 0.0f;
        }
        if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        try {
            mediaPlayer.setVolume(f16, f16);
        } catch (Exception e16) {
            Logger.logE(TAG, e16.getLocalizedMessage());
        }
        return true;
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public boolean Stop() {
        if (!VideoPreviewSupported()) {
            Logger.logE(TAG, "Stop.unsupport.hardware!!");
            this.mErrorCode = -4;
            changeState(6);
            return false;
        }
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return false;
        }
        int i3 = this.mMediaInfo.state;
        if (i3 != 1 && i3 != 0) {
            try {
                mediaPlayer.stop();
                changeState(5);
                return true;
            } catch (IllegalStateException e16) {
                Logger.logE(TAG, e16.getLocalizedMessage());
                return false;
            }
        }
        Logger.logE(TAG, StringUtil.format("Stop.wrong.state.%d!!", Integer.valueOf(i3)));
        return false;
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public boolean VideoPreviewSupported() {
        return true;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i3) {
        this.mBufferPercent = i3;
        if (ENV.mIsDebug) {
            Logger.logD(TAG, StringUtil.format("onBufferingUpdate.%d", Integer.valueOf(i3)));
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (ENV.mIsDebug) {
            Logger.logD(TAG, "onCompletion.call!!");
        }
        try {
            mediaPlayer.stop();
        } catch (Exception e16) {
            Logger.logE(TAG, "onCompletion, exception!! " + e16.getMessage());
        }
        changeState(5);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        Logger.logE(TAG, StringUtil.format("onError.what.%d.extra.%d", Integer.valueOf(i3), Integer.valueOf(i16)));
        if (i3 != -1010) {
            if (i3 != -1007 && i3 != -1004 && i3 != -110 && i3 != 100) {
                this.mErrorCode = -1;
            } else {
                this.mErrorCode = -3;
            }
        } else {
            this.mErrorCode = -2;
        }
        changeState(6);
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i16) {
        if (ENV.mIsDebug) {
            Logger.logD(TAG, StringUtil.format("onInfo.what.%d.extra.%d", Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        if (i3 != 701) {
            if (i3 == 702) {
                bufferingChange(false);
            }
        } else {
            bufferingChange(true);
        }
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        int i3;
        Logger.logI(TAG, "onPrepared.call!!");
        try {
            int duration = mediaPlayer.getDuration();
            int videoWidth = mediaPlayer.getVideoWidth();
            int videoHeight = mediaPlayer.getVideoHeight();
            ark.PlayerStub.MediaInfo mediaInfo = this.mMediaInfo;
            boolean z16 = true;
            if (videoWidth > 0 && videoHeight > 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            mediaInfo.type = i3;
            mediaInfo.duration = duration / 1000.0d;
            if (duration > 0) {
                z16 = false;
            }
            mediaInfo.islive = z16;
            ArkPlayerSurfaceHolder arkPlayerSurfaceHolder = this.mSurfaceHolder;
            if (arkPlayerSurfaceHolder != null) {
                arkPlayerSurfaceHolder.SetFrameSize(mediaInfo.width, mediaInfo.height);
            }
            if (VideoPreviewSupported()) {
                ark.PlayerStub.MediaInfo mediaInfo2 = this.mMediaInfo;
                mediaInfo2.width = videoWidth;
                mediaInfo2.height = videoHeight;
            }
            if (this.mPlayWhenReady) {
                this.mPlayWhenReady = false;
                this.mMediaInfo.state = 2;
                ArkDispatchQueue.asyncRun(this.mQueueKey, new Runnable() { // from class: com.tencent.ark.ArkPlayer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ArkPlayer.this.Play();
                    }
                });
                return;
            }
            changeState(2);
        } catch (IllegalStateException e16) {
            Logger.logE(TAG, "onPrepared, exception!! " + e16.getMessage());
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        if (ENV.mIsDebug) {
            Logger.logD(TAG, StringUtil.format("onSeekComplete.pos.%.3f", Double.valueOf(this.mSeekPos)));
        }
        this.mSeekPos = -1.0d;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i3, int i16) {
        if (ENV.mIsDebug) {
            Logger.logD(TAG, StringUtil.format("onVideoSizeChanged.%d.%d", Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        if (VideoPreviewSupported()) {
            ark.PlayerStub.MediaInfo mediaInfo = this.mMediaInfo;
            mediaInfo.width = i3;
            mediaInfo.height = i16;
        }
        ArkPlayerSurfaceHolder arkPlayerSurfaceHolder = this.mSurfaceHolder;
        if (arkPlayerSurfaceHolder != null) {
            arkPlayerSurfaceHolder.SetFrameSize(i3, i16);
        }
    }

    @Override // com.tencent.ark.ark.PlayerStub
    public void SetOutputSizeHint(int i3, int i16) {
    }
}
