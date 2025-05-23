package com.tencent.ttpic.videoshelf.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener;
import com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.VideoShelfPlayer;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;

/* loaded from: classes27.dex */
public class VideoShelfPlayView extends TextureView implements TextureView.SurfaceTextureListener, IVideoShelfPlayerListener {
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private static final String TAG = "VideoShelfPlayView";
    private final int FLUSH_FORCE;
    private final int START_PLAY;
    private int mCurrentState;
    private Handler mHandler;
    private int mHeightVideo;
    private boolean mIsInited;
    private boolean mIsNotCalledStart;
    private boolean mIsSurfaceDetroyed;
    private boolean mIsVideoFile;
    private Surface mPlaySurface;
    private IVideoShelfPlayerListener mPreparedlistener;
    private IVideoShelfPlayer mVideoSehlfPlayer;
    private int mWidthVideo;

    public VideoShelfPlayView(Context context) {
        super(context);
        this.mCurrentState = 0;
        this.mIsVideoFile = true;
        this.mIsInited = false;
        this.mIsNotCalledStart = true;
        this.mIsSurfaceDetroyed = true;
        this.START_PLAY = 1;
        this.FLUSH_FORCE = 2;
        this.mWidthVideo = 0;
        this.mHeightVideo = 0;
        this.mHandler = new Handler() { // from class: com.tencent.ttpic.videoshelf.ui.VideoShelfPlayView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i3 = message.what;
                if (i3 != 1) {
                    if (i3 == 2) {
                        VideoShelfPlayView.this.flush();
                        return;
                    }
                    return;
                }
                VideoShelfPlayView.this.start();
            }
        };
        initView();
    }

    private boolean initVideoShelfPlayer() {
        IVideoShelfPlayer pagShelfPlayer;
        if (!this.mIsInited) {
            return false;
        }
        if (this.mVideoSehlfPlayer == null) {
            try {
                if (this.mIsVideoFile) {
                    pagShelfPlayer = new VideoShelfPlayer();
                } else {
                    pagShelfPlayer = new PagShelfPlayer();
                }
                this.mVideoSehlfPlayer = pagShelfPlayer;
                IVideoShelfPlayerListener iVideoShelfPlayerListener = this.mPreparedlistener;
                if (iVideoShelfPlayerListener != null) {
                    pagShelfPlayer.setVideoShelfPlayerListener(iVideoShelfPlayerListener);
                }
                Surface surface = this.mPlaySurface;
                if (surface != null) {
                    this.mVideoSehlfPlayer.setSurface(surface);
                }
                this.mVideoSehlfPlayer.reset();
                this.mVideoSehlfPlayer.setVideoShelfPlayerListener(this);
                return true;
            } catch (PagNotSupportSystemException e16) {
                Log.e(TAG, e16.getMessage());
                TTPTLogger.e(TAG, e16.getMessage());
                return false;
            }
        }
        return true;
    }

    private void initView() {
        this.mCurrentState = 0;
        setSurfaceTextureListener(this);
    }

    private boolean isInPlaybackState() {
        int i3;
        if (this.mVideoSehlfPlayer != null && (i3 = this.mCurrentState) != -1 && i3 != 0 && i3 != 1) {
            return true;
        }
        return false;
    }

    public void flush() {
        Log.i(TAG, "called flush.");
        if (!this.mIsSurfaceDetroyed && isInPlaybackState() && initVideoShelfPlayer()) {
            this.mVideoSehlfPlayer.flush();
        }
    }

    public double getAspectRatio() {
        if (!initVideoShelfPlayer() || getVideoHeight() == 0) {
            return 0.0d;
        }
        return (getVideoWidth() * 1.0d) / getVideoHeight();
    }

    public int getCurrentPosition() {
        if (initVideoShelfPlayer()) {
            return this.mVideoSehlfPlayer.getCurrentPosition();
        }
        return 0;
    }

    public IVideoShelfPlayer getPlayer() {
        return this.mVideoSehlfPlayer;
    }

    public int getVideoHeight() {
        if (this.mHeightVideo == 0 && initVideoShelfPlayer()) {
            this.mHeightVideo = this.mVideoSehlfPlayer.getVideoHeight();
        }
        return this.mHeightVideo;
    }

    public int getVideoWidth() {
        if (this.mWidthVideo == 0 && initVideoShelfPlayer()) {
            this.mWidthVideo = this.mVideoSehlfPlayer.getVideoWidth();
        }
        return this.mWidthVideo;
    }

    public boolean isHorizontalVideo() {
        if (!initVideoShelfPlayer() || getVideoWidth() <= getVideoHeight()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
    public void onChangVideoSize(int i3, int i16) {
        updateVideoSize(i3, i16);
        IVideoShelfPlayerListener iVideoShelfPlayerListener = this.mPreparedlistener;
        if (iVideoShelfPlayerListener != null) {
            iVideoShelfPlayerListener.onChangVideoSize(i3, i16);
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
    public void onCompletion() {
        this.mCurrentState = 5;
        IVideoShelfPlayerListener iVideoShelfPlayerListener = this.mPreparedlistener;
        if (iVideoShelfPlayerListener != null) {
            iVideoShelfPlayerListener.onCompletion();
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
    public boolean onError(int i3, String str, Object obj) {
        this.mCurrentState = -1;
        IVideoShelfPlayerListener iVideoShelfPlayerListener = this.mPreparedlistener;
        if (iVideoShelfPlayerListener != null) {
            iVideoShelfPlayerListener.onError(i3, str, obj);
            return false;
        }
        return false;
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
    public void onPrepared(IVideoShelfPlayer iVideoShelfPlayer) {
        IVideoShelfPlayerListener iVideoShelfPlayerListener = this.mPreparedlistener;
        if (iVideoShelfPlayerListener != null) {
            iVideoShelfPlayerListener.onPrepared(iVideoShelfPlayer);
        }
        this.mCurrentState = 2;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        Log.i(TAG, "onSurfaceTextureAvailable.");
        this.mPlaySurface = new Surface(surfaceTexture);
        if (initVideoShelfPlayer()) {
            this.mVideoSehlfPlayer.setSurface(this.mPlaySurface);
            this.mIsSurfaceDetroyed = false;
            if (this.mIsNotCalledStart) {
                this.mHandler.sendEmptyMessage(1);
            }
            if (4 == this.mCurrentState) {
                this.mHandler.sendEmptyMessage(2);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.i(TAG, "onSurfaceTextureDestroyed.");
        this.mIsSurfaceDetroyed = true;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        Log.i(TAG, "onSurfaceTextureSizeChanged.");
        if (initVideoShelfPlayer()) {
            this.mVideoSehlfPlayer.surfaceUpdateSize();
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
    public void onUpdateRate(long j3) {
        IVideoShelfPlayerListener iVideoShelfPlayerListener = this.mPreparedlistener;
        if (iVideoShelfPlayerListener != null) {
            iVideoShelfPlayerListener.onUpdateRate(j3);
        }
    }

    public void pause() {
        if (isInPlaybackState() && initVideoShelfPlayer() && this.mVideoSehlfPlayer.isPlaying()) {
            this.mVideoSehlfPlayer.pause();
            this.mCurrentState = 4;
        }
    }

    public void resume() {
        if (initVideoShelfPlayer()) {
            this.mVideoSehlfPlayer.start();
        }
    }

    public void setAudioPath(String str) {
        if (initVideoShelfPlayer()) {
            this.mVideoSehlfPlayer.setParam(PagShelfPlayer.AUDIO_PATH, Boolean.FALSE, str);
        }
    }

    public void setAudioPathFromAsset(String str, AssetManager assetManager) {
        if (initVideoShelfPlayer()) {
            this.mVideoSehlfPlayer.setParam(PagShelfPlayer.AUDIO_PATH, Boolean.TRUE, assetManager, str);
        }
    }

    public void setOnPlayerListener(IVideoShelfPlayerListener iVideoShelfPlayerListener) {
        this.mPreparedlistener = iVideoShelfPlayerListener;
    }

    public void setParam(String str, Object... objArr) {
        if (initVideoShelfPlayer()) {
            this.mVideoSehlfPlayer.setParam(str, objArr);
        }
    }

    public void setVideoFilePath(String str) {
        if (initVideoShelfPlayer()) {
            this.mVideoSehlfPlayer.setDataSource(str);
            this.mCurrentState = 1;
            this.mVideoSehlfPlayer.prepare();
        }
    }

    public void setVideoFilePathFromAsset(String str, AssetManager assetManager) {
        if (initVideoShelfPlayer()) {
            this.mVideoSehlfPlayer.setDataSource(assetManager, str);
            this.mCurrentState = 1;
            this.mVideoSehlfPlayer.prepare();
        }
    }

    public void setVideoType(boolean z16) {
        this.mIsInited = true;
        this.mIsVideoFile = z16;
        initVideoShelfPlayer();
    }

    public void start() {
        if (isInPlaybackState() && this.mPlaySurface != null && initVideoShelfPlayer()) {
            IVideoShelfPlayer iVideoShelfPlayer = this.mVideoSehlfPlayer;
            iVideoShelfPlayer.seekTo(iVideoShelfPlayer.getCurrentPosition());
            this.mVideoSehlfPlayer.start();
            this.mIsNotCalledStart = false;
            this.mCurrentState = 3;
            return;
        }
        this.mIsNotCalledStart = true;
    }

    public void stop() {
        this.mIsNotCalledStart = false;
        if (initVideoShelfPlayer()) {
            this.mVideoSehlfPlayer.stop();
            this.mVideoSehlfPlayer.setVideoShelfPlayerListener(null);
        }
        this.mCurrentState = 0;
    }

    public void updateVideoSize(int i3, int i16) {
        this.mWidthVideo = i3;
        this.mHeightVideo = i16;
        Log.i("VideoShelfPlayer", "call onGlobalLayout.w:" + i3 + ",h:" + i16);
        double aspectRatio = getAspectRatio();
        if (isHorizontalVideo()) {
            if (aspectRatio < 3.0d) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                marginLayoutParams.height = (int) (getWidth() / aspectRatio);
                setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        if (aspectRatio > 0.3333333333333333d) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = (int) (getHeight() * aspectRatio);
            setLayoutParams(layoutParams);
        }
    }

    public VideoShelfPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.mIsVideoFile = true;
        this.mIsInited = false;
        this.mIsNotCalledStart = true;
        this.mIsSurfaceDetroyed = true;
        this.START_PLAY = 1;
        this.FLUSH_FORCE = 2;
        this.mWidthVideo = 0;
        this.mHeightVideo = 0;
        this.mHandler = new Handler() { // from class: com.tencent.ttpic.videoshelf.ui.VideoShelfPlayView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i3 = message.what;
                if (i3 != 1) {
                    if (i3 == 2) {
                        VideoShelfPlayView.this.flush();
                        return;
                    }
                    return;
                }
                VideoShelfPlayView.this.start();
            }
        };
        initView();
    }

    public VideoShelfPlayView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mCurrentState = 0;
        this.mIsVideoFile = true;
        this.mIsInited = false;
        this.mIsNotCalledStart = true;
        this.mIsSurfaceDetroyed = true;
        this.START_PLAY = 1;
        this.FLUSH_FORCE = 2;
        this.mWidthVideo = 0;
        this.mHeightVideo = 0;
        this.mHandler = new Handler() { // from class: com.tencent.ttpic.videoshelf.ui.VideoShelfPlayView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i36 = message.what;
                if (i36 != 1) {
                    if (i36 == 2) {
                        VideoShelfPlayView.this.flush();
                        return;
                    }
                    return;
                }
                VideoShelfPlayView.this.start();
            }
        };
        initView();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @TargetApi(21)
    public VideoShelfPlayView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mCurrentState = 0;
        this.mIsVideoFile = true;
        this.mIsInited = false;
        this.mIsNotCalledStart = true;
        this.mIsSurfaceDetroyed = true;
        this.START_PLAY = 1;
        this.FLUSH_FORCE = 2;
        this.mWidthVideo = 0;
        this.mHeightVideo = 0;
        this.mHandler = new Handler() { // from class: com.tencent.ttpic.videoshelf.ui.VideoShelfPlayView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i36 = message.what;
                if (i36 != 1) {
                    if (i36 == 2) {
                        VideoShelfPlayView.this.flush();
                        return;
                    }
                    return;
                }
                VideoShelfPlayView.this.start();
            }
        };
        initView();
    }
}
