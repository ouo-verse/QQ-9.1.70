package com.tencent.qcircle.tavcut.player;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.view.TAVCutVideoView;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.player.IPlayer;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.OnReadSnapShootListener;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerItem;
import com.tencent.tav.player.PlayerLayer;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes22.dex */
public class MoviePlayer implements IPlayer.PlayerListener {
    public static final int VIDEO_PLAYER_HEIGHT = 1280;
    public static final int VIDEO_PLAYER_WIDTH = 720;
    private AudioManager audioManager;
    private Context context;
    private TextureView mContentView;
    private TAVCutVideoView mPlayerLayout;
    private onVideoProgressListener mProgressListener;
    private RenderContextParams mRenderContextParams;
    private CMTimeRange playRange;
    private volatile boolean playReady;
    private Player player;
    private int rotation;
    private float scaleRatio;
    private CMTime seekTime;
    private Surface surface;
    private int surfaceHeight;
    private int surfaceWidth;
    private TAVComposition tavComposition;
    private final String TAG = "MoviePlayer@" + Integer.toHexString(hashCode());
    private boolean isAllowInterrupt = true;
    private boolean isAutoPlay = true;
    private boolean loopPlay = false;
    private float volume = 1.0f;
    private CMTime position = CMTime.CMTimeZero;
    private int backColor = -16777216;
    private List<OnPlayerLifeCycleListener> playerLifeCycleListeners = new ArrayList();
    private List<IPlayer.PlayerListener> playerListeners = new ArrayList();
    private List<SurfaceTextureChangeListener> surfaceTextureChangeListeners = new ArrayList();
    private boolean updatingPlayItem = false;
    private boolean needNewComposition = false;
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.tencent.qcircle.tavcut.player.MoviePlayer.3
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            if (i3 != -2 && i3 != -1) {
                if (i3 == 1 && MoviePlayer.this.player != null) {
                    MoviePlayer.this.player.play();
                    return;
                }
                return;
            }
            if (MoviePlayer.this.isAllowInterrupt && MoviePlayer.this.player != null) {
                MoviePlayer.this.player.pause();
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface OnPlayerLifeCycleListener {
        void onPlayerDestroy();

        void onPlayerItemChanged();

        void onPlayerReady();
    }

    /* loaded from: classes22.dex */
    public interface SurfaceTextureChangeListener {
        void onTextureChange(SurfaceTexture surfaceTexture);
    }

    /* loaded from: classes22.dex */
    public interface onVideoProgressListener {
        void updateVideoProgress(long j3);
    }

    private void abandonAudioFocus() {
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return;
        }
        audioManager.abandonAudioFocus(this.audioFocusChangeListener);
    }

    @NonNull
    private PlayerItem buildPlayerItem(TAVComposition tAVComposition) {
        Logger.d(this.TAG, "buildPlayerItem() called with: tavComposition = [" + tAVComposition + "]");
        TAVSource buildSource = new TAVCompositionBuilder(tAVComposition).buildSource();
        PlayerItem playerItem = new PlayerItem(buildSource.getAsset());
        playerItem.setVideoComposition(buildSource.getVideoComposition());
        playerItem.setAudioMix(buildSource.getAudioMix());
        return playerItem;
    }

    @NonNull
    private Player newPlayer(PlayerItem playerItem, CMTime cMTime, boolean z16) {
        Logger.d(this.TAG, "newPlayer() called with: playerItem = [" + playerItem + "], position = [" + cMTime + "], autoPlay = [" + z16 + "]");
        Player player = new Player(playerItem);
        player.setPlayerListener(this);
        player.setLoop(this.loopPlay);
        player.setPlayRange(this.playRange);
        player.setVolume(getVolume());
        player.seekToTime(cMTime);
        player.setRenderContextParams(this.mRenderContextParams);
        player.setBgColor(this.backColor);
        new PlayerLayer(this.surface, this.surfaceWidth, this.surfaceHeight).setPlayer(player);
        if (z16 && requestAudioFocus()) {
            player.play();
        }
        return player;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySurfaceTextureChange(SurfaceTexture surfaceTexture) {
        List<SurfaceTextureChangeListener> list = this.surfaceTextureChangeListeners;
        if (list != null && list.size() > 0) {
            Iterator<SurfaceTextureChangeListener> it = this.surfaceTextureChangeListeners.iterator();
            while (it.hasNext()) {
                it.next().onTextureChange(surfaceTexture);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayerDestroy() {
        Iterator<OnPlayerLifeCycleListener> it = this.playerLifeCycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayerDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayerItemChanged() {
        Iterator<OnPlayerLifeCycleListener> it = this.playerLifeCycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayerItemChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayerReady() {
        Iterator<OnPlayerLifeCycleListener> it = this.playerLifeCycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayerReady();
        }
    }

    private boolean requestAudioFocus() {
        Context context = this.context;
        if (context == null) {
            return true;
        }
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) context.getSystemService("audio");
        }
        if (this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 1) == 1) {
            return true;
        }
        return false;
    }

    private void startRotatePlayerContainer(int i3, int i16, CGSize cGSize, int i17) {
        float f16;
        float f17;
        Player player = this.player;
        if (player == null || player.getGlViewport() == null) {
            return;
        }
        float f18 = this.surfaceWidth;
        float f19 = this.surfaceHeight;
        if (f18 == 0.0f || f19 == 0.0f || cGSize.equals(CGSize.CGSizeZero)) {
            return;
        }
        float f26 = cGSize.width;
        float f27 = cGSize.height;
        if (f26 != 0.0f && f27 != 0.0f) {
            float f28 = f26 / f27;
            if (f28 < f18 / f19) {
                f17 = f28 * f19;
                f16 = f19;
            } else {
                f16 = f18 / f28;
                f17 = f18;
            }
            float min = Math.min(f19 / f17, f18 / f16);
            this.scaleRatio = min;
            AnimatorSet animatorSet = new AnimatorSet();
            if (i16 == 90) {
                long j3 = i17;
                animatorSet.play(ObjectAnimator.ofFloat(this.mPlayerLayout, BasicAnimation.KeyPath.ROTATION, -i3, -90.0f).setDuration(j3)).with(ObjectAnimator.ofFloat(this.mPlayerLayout, BasicAnimation.KeyPath.SCALE_X, 1.0f, min).setDuration(j3)).with(ObjectAnimator.ofFloat(this.mPlayerLayout, BasicAnimation.KeyPath.SCALE_Y, 1.0f, min).setDuration(j3));
            } else if (i16 == 180) {
                long j16 = i17;
                animatorSet.play(ObjectAnimator.ofFloat(this.mPlayerLayout, BasicAnimation.KeyPath.ROTATION, -i3, -180.0f).setDuration(j16)).with(ObjectAnimator.ofFloat(this.mPlayerLayout, BasicAnimation.KeyPath.SCALE_X, min, 1.0f).setDuration(j16)).with(ObjectAnimator.ofFloat(this.mPlayerLayout, BasicAnimation.KeyPath.SCALE_Y, min, 1.0f).setDuration(j16));
            } else if (i16 == 270) {
                long j17 = i17;
                animatorSet.play(ObjectAnimator.ofFloat(this.mPlayerLayout, BasicAnimation.KeyPath.ROTATION, -i3, -270.0f).setDuration(j17)).with(ObjectAnimator.ofFloat(this.mPlayerLayout, BasicAnimation.KeyPath.SCALE_X, 1.0f, min).setDuration(j17)).with(ObjectAnimator.ofFloat(this.mPlayerLayout, BasicAnimation.KeyPath.SCALE_Y, 1.0f, min).setDuration(j17));
            } else if (i16 == 0) {
                long j18 = i17;
                animatorSet.play(ObjectAnimator.ofFloat(this.mPlayerLayout, BasicAnimation.KeyPath.ROTATION, -i3, 0.0f).setDuration(j18)).with(ObjectAnimator.ofFloat(this.mPlayerLayout, BasicAnimation.KeyPath.SCALE_X, min, 1.0f).setDuration(j18)).with(ObjectAnimator.ofFloat(this.mPlayerLayout, BasicAnimation.KeyPath.SCALE_Y, min, 1.0f).setDuration(j18));
            }
            animatorSet.start();
        }
    }

    public void addOnPlayerLifeCycleListener(OnPlayerLifeCycleListener onPlayerLifeCycleListener) {
        if (onPlayerLifeCycleListener == null) {
            return;
        }
        this.playerLifeCycleListeners.add(onPlayerLifeCycleListener);
    }

    public void addPlayerListener(IPlayer.PlayerListener playerListener) {
        if (playerListener == null) {
            return;
        }
        this.playerListeners.add(playerListener);
    }

    public void addTextureChangeListener(SurfaceTextureChangeListener surfaceTextureChangeListener) {
        if (surfaceTextureChangeListener == null) {
            return;
        }
        this.surfaceTextureChangeListeners.add(surfaceTextureChangeListener);
    }

    public void bindView(TAVCutVideoView tAVCutVideoView) {
        this.context = tAVCutVideoView.getContext();
        this.mPlayerLayout = tAVCutVideoView;
        TextureView textureView = new TextureView(this.context);
        this.mContentView = textureView;
        textureView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mPlayerLayout.removeAllViews();
        this.mPlayerLayout.addView(this.mContentView);
        this.mContentView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.tencent.qcircle.tavcut.player.MoviePlayer.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
                MoviePlayer.this.surfaceWidth = i3;
                MoviePlayer.this.surfaceHeight = i16;
                MoviePlayer.this.surface = new Surface(surfaceTexture);
                if (!MoviePlayer.this.needNewComposition) {
                    MoviePlayer moviePlayer = MoviePlayer.this;
                    moviePlayer.updateComposition(moviePlayer.tavComposition, MoviePlayer.this.position, MoviePlayer.this.isAutoPlay);
                }
                MoviePlayer.this.playReady = true;
                MoviePlayer.this.onPlayerReady();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (MoviePlayer.this.player != null && !MoviePlayer.this.player.isReleased()) {
                    MoviePlayer moviePlayer = MoviePlayer.this;
                    moviePlayer.position = moviePlayer.player.position();
                    MoviePlayer.this.player.release();
                }
                surfaceTexture.release();
                if (MoviePlayer.this.surface != null) {
                    MoviePlayer.this.surface.release();
                    MoviePlayer.this.surface = null;
                }
                MoviePlayer.this.playReady = false;
                MoviePlayer.this.onPlayerDestroy();
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
                if (MoviePlayer.this.player != null) {
                    MoviePlayer.this.player.updateViewport(i3, i16);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                Log.d("lingeng_cover", "onSurfaceTextureUpdated: ");
                MoviePlayer.this.notifySurfaceTextureChange(surfaceTexture);
            }
        });
    }

    public synchronized IPlayer.PlayerStatus getCurrentStatus() {
        Player player = this.player;
        if (player == null) {
            return IPlayer.PlayerStatus.ERROR;
        }
        return player.currentStatus();
    }

    public CMTime getDuration() {
        Player player = this.player;
        if (player != null) {
            return player.duration();
        }
        return CMTime.CMTimeInvalid;
    }

    public boolean getLoopPlay() {
        return this.loopPlay;
    }

    public CMTimeRange getPlayRange() {
        return this.playRange;
    }

    public TAVCutVideoView getPlayerLayout() {
        return this.mPlayerLayout;
    }

    public synchronized CMTime getPosition() {
        Player player = this.player;
        if (player != null) {
            return player.position();
        }
        return CMTime.CMTimeInvalid;
    }

    public CGRect getRealRenderSize() {
        Player player = this.player;
        if (player == null) {
            return null;
        }
        return player.getGlViewport();
    }

    public int getRotation() {
        return this.rotation;
    }

    public float getScaleRatio() {
        return this.scaleRatio;
    }

    public TAVComposition getTavComposition() {
        return this.tavComposition;
    }

    public TextureView getTextureView() {
        return this.mContentView;
    }

    public synchronized float getVolume() {
        return this.volume;
    }

    public boolean isPlayReady() {
        return this.playReady;
    }

    public synchronized boolean isPlaying() {
        if (this.player != null) {
            Logger.d(this.TAG, "isPlaying:" + this.player.isPlaying());
            return this.player.isPlaying();
        }
        return false;
    }

    public synchronized boolean isReleased() {
        boolean z16;
        Player player = this.player;
        if (player != null) {
            if (!player.isReleased()) {
                z16 = false;
            }
        }
        z16 = true;
        return z16;
    }

    @Override // com.tencent.tav.player.IPlayer.PlayerListener
    public void onPositionChanged(CMTime cMTime) {
        if (this.updatingPlayItem) {
            return;
        }
        Iterator<IPlayer.PlayerListener> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onPositionChanged(cMTime);
        }
        onVideoProgressListener onvideoprogresslistener = this.mProgressListener;
        if (onvideoprogresslistener != null) {
            onvideoprogresslistener.updateVideoProgress(cMTime.getTimeUs() / 1000);
        }
    }

    @Override // com.tencent.tav.player.IPlayer.PlayerListener
    public void onStatusChanged(IPlayer.PlayerStatus playerStatus) {
        Iterator<IPlayer.PlayerListener> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onStatusChanged(playerStatus);
        }
    }

    public synchronized void pause() {
        Logger.d(this.TAG, "pause: player = " + this.player);
        if (this.player != null) {
            abandonAudioFocus();
            this.player.pause();
        } else {
            this.isAutoPlay = false;
        }
    }

    public synchronized void play() {
        Logger.d(this.TAG, "play: player = " + this.player);
        if (this.player != null) {
            if (requestAudioFocus()) {
                this.player.play();
            }
        } else {
            this.isAutoPlay = true;
        }
    }

    public void readSnapShootBitmap(OnReadSnapShootListener onReadSnapShootListener) {
        this.player.readSnapShootBitmap(onReadSnapShootListener);
    }

    public synchronized void refresh() {
        Player player = this.player;
        if (player == null) {
            return;
        }
        if (player.duration().equalsTo(getPosition())) {
            this.player.seekToTime(getPosition().sub(new CMTime(1L, 1000)));
        } else {
            this.player.seekToTime(getPosition());
        }
    }

    public synchronized void release() {
        Logger.d(this.TAG, "release: player = " + this.player);
        if (this.player != null) {
            abandonAudioFocus();
            this.player.release();
            this.seekTime = null;
            this.player = null;
        }
    }

    public void removeOnPlayerLifeCyclerListener(OnPlayerLifeCycleListener onPlayerLifeCycleListener) {
        if (onPlayerLifeCycleListener == null) {
            return;
        }
        this.playerLifeCycleListeners.remove(onPlayerLifeCycleListener);
    }

    public void removePlayerListener(IPlayer.PlayerListener playerListener) {
        if (playerListener == null) {
            return;
        }
        this.playerListeners.remove(playerListener);
    }

    public synchronized void reset(boolean z16) {
        this.needNewComposition = z16;
        this.seekTime = null;
        bindView(this.mPlayerLayout);
    }

    public void rotate(int i3, boolean z16) {
        this.rotation = i3;
        CGSize cGSize = CGSize.CGSizeZero;
        TAVComposition tAVComposition = this.tavComposition;
        if (tAVComposition != null && tAVComposition.getRenderSize() != null) {
            cGSize = this.tavComposition.getRenderSize();
        }
        if (z16) {
            int i16 = this.rotation;
            startRotatePlayerContainer(i16 - 90, i16, cGSize, 300);
        } else {
            int i17 = this.rotation;
            startRotatePlayerContainer(i17, i17, cGSize, 0);
        }
    }

    public void seekToTime(CMTime cMTime) {
        Logger.d(this.TAG, "seekToTime() called with: cmTime = [" + cMTime + "],player = " + this.player);
        CMTime cMTime2 = CMTime.CMTimeZero;
        if (cMTime.smallThan(cMTime2)) {
            cMTime = cMTime2;
        }
        this.seekTime = cMTime;
        Player player = this.player;
        if (player != null) {
            player.seekToTime(cMTime);
        }
    }

    public void setAllowInterrupt(boolean z16) {
        this.isAllowInterrupt = z16;
    }

    public synchronized void setAutoPlay(boolean z16) {
        this.isAutoPlay = z16;
    }

    public void setBackColor(int i3) {
        this.backColor = i3;
        Player player = this.player;
        if (player != null) {
            player.setBgColor(i3);
        }
    }

    public synchronized void setLoopPlay(boolean z16) {
        Logger.d(this.TAG, "setLoopPlay() called with: loopPlay = [" + z16 + "],player = " + this.player);
        this.loopPlay = z16;
        Player player = this.player;
        if (player != null) {
            player.setLoop(z16);
        }
    }

    public synchronized void setPlayRange(CMTimeRange cMTimeRange) {
        Logger.d(this.TAG, "setPlayRange() called with: playRange = [" + cMTimeRange + "],player = " + this.player);
        this.playRange = cMTimeRange;
        Player player = this.player;
        if (player != null) {
            player.setPlayRange(cMTimeRange);
        }
    }

    public void setPlayerListener(IPlayer.PlayerListener playerListener) {
        addPlayerListener(playerListener);
    }

    public void setRenderContextParams(RenderContextParams renderContextParams) {
        this.mRenderContextParams = renderContextParams;
        Player player = this.player;
        if (player != null) {
            player.setRenderContextParams(renderContextParams);
        }
    }

    public void setSource(String str) {
        TAVClip tAVClip = new TAVClip(new URLAsset(str));
        TAVComposition tAVComposition = new TAVComposition();
        tAVComposition.addAudioChannel(Arrays.asList(tAVClip));
        tAVComposition.addVideoChannel(Arrays.asList(tAVClip));
        updateComposition(tAVComposition, false);
    }

    public void setVideoProgressListener(onVideoProgressListener onvideoprogresslistener) {
        this.mProgressListener = onvideoprogresslistener;
    }

    public synchronized void setVolume(float f16) {
        Logger.d(this.TAG, "setVolume() called with: volume = [" + f16 + "],player = " + this.player);
        this.volume = f16;
        Player player = this.player;
        if (player != null) {
            player.setVolume(f16);
        }
    }

    public void updateComposition(TAVComposition tAVComposition, boolean z16) {
        updateComposition(tAVComposition, CMTime.CMTimeZero, z16);
    }

    public void updateComposition(TAVComposition tAVComposition, CMTime cMTime, final boolean z16) {
        Logger.d(this.TAG, "updateComposition() called with: tavComposition = [" + tAVComposition + "], position = [" + cMTime + "], autoPlay = [" + z16 + "]");
        this.tavComposition = tAVComposition;
        this.position = cMTime;
        if (tAVComposition == null) {
            return;
        }
        if (this.surface == null) {
            this.isAutoPlay = z16;
            return;
        }
        PlayerItem buildPlayerItem = buildPlayerItem(tAVComposition);
        if (this.seekTime == null) {
            this.seekTime = cMTime;
        }
        Player player = this.player;
        if (player != null && !player.isReleased()) {
            this.updatingPlayItem = true;
            this.player.update(buildPlayerItem, cMTime, new OnCompositionUpdateListener() { // from class: com.tencent.qcircle.tavcut.player.MoviePlayer.2
                @Override // com.tencent.tav.player.OnCompositionUpdateListener
                public void onUpdated(Player player2, boolean z17) {
                    player2.setVolume(MoviePlayer.this.volume);
                    if (z16 && z17) {
                        MoviePlayer moviePlayer = MoviePlayer.this;
                        moviePlayer.seekToTime(moviePlayer.seekTime);
                        MoviePlayer.this.play();
                    }
                    MoviePlayer.this.onPlayerItemChanged();
                    MoviePlayer.this.updatingPlayItem = false;
                }
            });
        } else {
            this.player = newPlayer(buildPlayerItem, this.seekTime, z16);
        }
    }
}
