package com.tencent.tavkit.component;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.player.Callback;
import com.tencent.tav.player.IPlayer;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.OnReadSnapShootListener;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerItem;
import com.tencent.tav.player.PlayerLayer;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes26.dex */
public class TAVPlayer {
    public static final int MAX_CACHE_FRAME_SIZE = 20;
    private AudioManager audioManager;
    private OnCompositionUpdateListener compositionUpdateListener;
    private Context context;

    @Nullable
    private FrameLayout mPlayerLayout;
    private CMTimeRange playRange;
    private Player player;
    private IPlayer.PlayerListener playerListener;
    private PostUpdateThread postUpdateThread;
    private Surface surface;
    private int surfaceHeight;
    private TextureView.SurfaceTextureListener surfaceTextureListener;
    private int surfaceWidth;
    private TAVComposition tavComposition;
    private HandlerThread videoThread;
    private final String mTAG = "TAVPlayer@" + Integer.toHexString(hashCode());
    private boolean isAllowInterrupt = true;
    private boolean isAutoPlay = true;
    private final AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.tencent.tavkit.component.TAVPlayer.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            if (i3 != -2 && i3 != -1) {
                if (i3 == 1 && TAVPlayer.this.player != null) {
                    TAVPlayer.this.player.play();
                    return;
                }
                return;
            }
            if (TAVPlayer.this.isAllowInterrupt && TAVPlayer.this.player != null) {
                TAVPlayer.this.player.pause();
            }
        }
    };
    private boolean loopPlay = false;
    private float volume = 1.0f;
    private CMTime position = CMTime.CMTimeZero;
    private boolean videoTracksMerge = true;
    private boolean audioTracksMerge = true;
    private float rate = 1.0f;
    private boolean audioRevertMode = false;
    private boolean videoRevertMode = false;
    private int bgColor = -16777216;
    private boolean isResetting = false;
    private boolean released = false;
    private int maxCacheFrameSize = 20;
    private int audioRevertCacheSamples = 30;
    private final Queue<Runnable> runInPlayerTreadEvents = new LinkedList();

    /* loaded from: classes26.dex */
    public interface ICompositionBuilder extends OnCompositionUpdateListener {
        @NonNull
        TAVComposition buildComposition();
    }

    /* loaded from: classes26.dex */
    public interface PlayerListener {
        void onPositionChanged(CMTime cMTime, CMTime cMTime2);

        void onStatusChanged(IPlayer.PlayerStatus playerStatus, Player player);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class PostUpdateThread extends BaseHandlerThread implements Handler.Callback {
        private static final int MSG_UNLOCK = 95;
        private static final int MSG_UPDATE = 223;
        private boolean autoPlay;

        @Nullable
        private Handler handler;
        private volatile boolean msgLock;
        private ICompositionBuilder templateSource;

        private void doUnlockMsg() {
            if (this.msgLock) {
                this.msgLock = false;
                ICompositionBuilder iCompositionBuilder = this.templateSource;
                if (iCompositionBuilder != null) {
                    update(iCompositionBuilder, this.autoPlay);
                }
            }
        }

        private void doUpdateComposition(final ICompositionBuilder iCompositionBuilder, boolean z16) {
            unlockMsg(1000);
            TAVPlayer.this.updateComposition(iCompositionBuilder.buildComposition(), CMTime.CMTimeZero, z16, new OnCompositionUpdateListener() { // from class: com.tencent.tavkit.component.TAVPlayer.PostUpdateThread.1
                @Override // com.tencent.tav.player.OnCompositionUpdateListener
                public void onUpdated(Player player, boolean z17) {
                    iCompositionBuilder.onUpdated(player, z17);
                    PostUpdateThread.this.unlockMsg(0);
                }
            });
        }

        private void doUpdateMsg() {
            if (!this.msgLock && this.templateSource != null) {
                Logger.d(TAVPlayer.this.mTAG, "doUpdateMsg() called");
                this.msgLock = true;
                doUpdateComposition(this.templateSource, this.autoPlay);
                this.templateSource = null;
                this.autoPlay = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void unlockMsg(int i3) {
            Logger.d(TAVPlayer.this.mTAG, "unlockMsg() called thread = " + Thread.currentThread().getName());
            Handler handler = this.handler;
            if (handler == null) {
                return;
            }
            handler.removeMessages(95);
            this.handler.sendEmptyMessageDelayed(95, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void update(ICompositionBuilder iCompositionBuilder, boolean z16) {
            Logger.d(TAVPlayer.this.mTAG, "update() called with: thread = " + Thread.currentThread().getName() + ", templateSource = [" + iCompositionBuilder + "], autoPlay = [" + z16 + "]");
            Handler handler = this.handler;
            if (handler == null) {
                return;
            }
            this.templateSource = iCompositionBuilder;
            this.autoPlay = z16;
            handler.removeMessages(223);
            this.handler.sendEmptyMessage(223);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Logger.d(TAVPlayer.this.mTAG, "handleMessage() called with: msg = [" + message + "] msgLock = " + this.msgLock + ",templateSource = " + this.templateSource);
            int i3 = message.what;
            if (i3 != 95) {
                if (i3 == 223) {
                    doUpdateMsg();
                    return true;
                }
                return true;
            }
            doUnlockMsg();
            return true;
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
        }

        public synchronized void release() {
            this.templateSource = null;
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.handler = null;
            }
            quit();
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread, java.lang.Thread
        public synchronized void start() {
            super.start();
            this.handler = new Handler(getLooper(), this);
        }

        PostUpdateThread(String str) {
            super(str);
            this.msgLock = false;
        }
    }

    public TAVPlayer() {
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
        Logger.d(this.mTAG, "buildPlayerItem() called with: tavComposition = [" + tAVComposition + "]");
        TAVSource buildSource = buildSource(tAVComposition);
        PlayerItem playerItem = new PlayerItem(buildSource.getAsset());
        playerItem.setVideoComposition(buildSource.getVideoComposition());
        playerItem.setAudioMix(buildSource.getAudioMix());
        if (tAVComposition != null) {
            playerItem.setAudioInfo(tAVComposition.getAudioInfo());
        }
        return playerItem;
    }

    private TAVSource buildSource(TAVComposition tAVComposition) {
        TAVCompositionBuilder tAVCompositionBuilder = new TAVCompositionBuilder(tAVComposition);
        tAVCompositionBuilder.setVideoTracksMerge(this.videoTracksMerge);
        tAVCompositionBuilder.setAudioTracksMerge(this.audioTracksMerge);
        return tAVCompositionBuilder.buildSource();
    }

    private void initContentView() {
        FrameLayout frameLayout = this.mPlayerLayout;
        if (frameLayout == null) {
            return;
        }
        frameLayout.removeAllViews();
        TextureView textureView = new TextureView(this.context);
        textureView.setOpaque(false);
        textureView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mPlayerLayout.addView(textureView);
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.tencent.tavkit.component.TAVPlayer.2
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
                if (TAVPlayer.this.released) {
                    return;
                }
                TAVPlayer.this.onSurfaceCreate(new Surface(surfaceTexture), i3, i16);
                if (TAVPlayer.this.surfaceTextureListener != null) {
                    TAVPlayer.this.surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i3, i16);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                TAVPlayer.this.onSurfaceDestory();
                if (TAVPlayer.this.surfaceTextureListener != null) {
                    TAVPlayer.this.surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
                    return false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
                TAVPlayer.this.onSurfaceSizeChanged(i3, i16);
                if (TAVPlayer.this.surfaceTextureListener != null) {
                    TAVPlayer.this.surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i3, i16);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (TAVPlayer.this.surfaceTextureListener != null) {
                    TAVPlayer.this.surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
                }
            }
        });
    }

    @NonNull
    private Player newPlayer(PlayerItem playerItem, CMTime cMTime, boolean z16) {
        Logger.d(this.mTAG, "newPlayer() called with: playerItem = [" + playerItem + "], position = [" + cMTime + "], autoPlay = [" + z16 + "]");
        Player player = new Player(playerItem, this.videoThread);
        player.setPlayerListener(this.playerListener);
        player.setLoop(isLoopPlay());
        player.setRate(this.rate, this.maxCacheFrameSize);
        player.setBgColor(this.bgColor);
        player.setPlayRange(this.playRange);
        player.setVolume(getVolume());
        player.seekToTime(cMTime);
        new PlayerLayer(this.surface, this.surfaceWidth, this.surfaceHeight).setPlayer(player);
        if (z16 && requestAudioFocus()) {
            player.play();
        }
        this.isResetting = false;
        return player;
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

    private synchronized void runEventsToPlayerThread() {
        while (!this.runInPlayerTreadEvents.isEmpty()) {
            this.player.post(this.runInPlayerTreadEvents.poll());
        }
    }

    public synchronized IPlayer.PlayerStatus getCurrentStatus() {
        Player player = this.player;
        if (player == null) {
            return IPlayer.PlayerStatus.ERROR;
        }
        return player.currentStatus();
    }

    public synchronized CMTime getDuration() {
        Player player = this.player;
        if (player != null) {
            return player.duration();
        }
        return CMTime.CMTimeZero;
    }

    public synchronized CMTimeRange getPlayRange() {
        return this.playRange;
    }

    public synchronized CMTime getPosition() {
        Player player = this.player;
        if (player != null) {
            return player.position();
        }
        return CMTime.CMTimeInvalid;
    }

    public HandlerThread getVideoThread() {
        return this.videoThread;
    }

    public synchronized float getVolume() {
        return this.volume;
    }

    public synchronized boolean isLoopPlay() {
        return this.loopPlay;
    }

    public synchronized boolean isPlaying() {
        Player player = this.player;
        if (player != null) {
            return player.isPlaying();
        }
        return false;
    }

    public boolean isResetting() {
        return this.isResetting;
    }

    public void onSurfaceCreate(Surface surface, int i3, int i16) {
        this.surfaceWidth = i3;
        this.surfaceHeight = i16;
        this.surface = surface;
        updateComposition(this.tavComposition, this.position, this.isAutoPlay, this.compositionUpdateListener);
    }

    public void onSurfaceDestory() {
        Player player = this.player;
        if (player != null && !player.isReleased()) {
            this.position = this.player.position();
            this.player.release();
        }
        this.surface = null;
    }

    public void onSurfaceSizeChanged(int i3, int i16) {
        this.surfaceWidth = i3;
        this.surfaceHeight = i16;
        Player player = this.player;
        if (player != null) {
            player.updateViewport(i3, i16);
        }
    }

    public synchronized void pause() {
        Logger.d(this.mTAG, "pause: player = " + this.player);
        if (this.player != null) {
            abandonAudioFocus();
            this.player.pause();
        } else {
            this.isAutoPlay = false;
        }
    }

    public synchronized void play() {
        Logger.d(this.mTAG, "play: player = " + this.player);
        if (this.player != null) {
            if (requestAudioFocus()) {
                this.player.play();
            }
        } else {
            this.isAutoPlay = true;
        }
    }

    public synchronized void post(Runnable runnable) {
        Player player = this.player;
        if (player != null) {
            player.post(runnable);
        } else {
            this.runInPlayerTreadEvents.add(runnable);
        }
    }

    public synchronized void postUpdate(final TAVComposition tAVComposition, boolean z16) {
        postUpdate(new ICompositionBuilder() { // from class: com.tencent.tavkit.component.TAVPlayer.5
            @Override // com.tencent.tavkit.component.TAVPlayer.ICompositionBuilder
            @NonNull
            public TAVComposition buildComposition() {
                return tAVComposition;
            }

            @Override // com.tencent.tav.player.OnCompositionUpdateListener
            public void onUpdated(Player player, boolean z17) {
            }
        }, z16);
    }

    public void readSnapShootBitmap(OnReadSnapShootListener onReadSnapShootListener) {
        Player player = this.player;
        if (player != null) {
            player.readSnapShootBitmap(onReadSnapShootListener);
        }
    }

    public synchronized void refresh() {
        Player player = this.player;
        if (player == null) {
            return;
        }
        player.refresh();
    }

    public synchronized void release() {
        Logger.d(this.mTAG, "release: player = " + this.player);
        Player player = this.player;
        if (player != null) {
            this.position = player.position();
            abandonAudioFocus();
            this.player.release();
            this.player = null;
        }
        PostUpdateThread postUpdateThread = this.postUpdateThread;
        if (postUpdateThread != null) {
            postUpdateThread.quit();
            this.postUpdateThread = null;
        }
        this.released = true;
        this.isResetting = false;
        this.context = null;
    }

    public synchronized void reset() {
        Logger.d(this.mTAG, "reset() called");
        this.isResetting = true;
        initContentView();
    }

    public void seekToTime(CMTime cMTime) {
        Logger.d(this.mTAG, "seekToTime() called with: cmTime = [" + cMTime + "],player = " + this.player);
        Player player = this.player;
        if (player != null) {
            player.seekToTime(cMTime);
        }
    }

    public void setAllowInterrupt(boolean z16) {
        this.isAllowInterrupt = z16;
    }

    public void setAudioRevertCacheSamples(int i3) {
        this.audioRevertCacheSamples = i3;
        Player player = this.player;
        if (player != null) {
            player.setAudioRevertCacheSamples(i3);
        }
    }

    public void setAudioRevertMode(boolean z16) {
        this.audioRevertMode = z16;
        Player player = this.player;
        if (player != null) {
            player.setAudioRevertMode(z16);
        }
    }

    public void setAudioTracksMerge(boolean z16) {
        this.audioTracksMerge = z16;
    }

    public synchronized void setAutoPlay(boolean z16) {
        this.isAutoPlay = z16;
    }

    public void setBgColor(int i3) {
        this.bgColor = i3;
        Player player = this.player;
        if (player != null) {
            player.setBgColor(i3);
        }
    }

    public void setEnableSync(boolean z16) {
        Player player = this.player;
        if (player != null) {
            player.setEnableSync(z16);
        }
    }

    public synchronized void setLoopPlay(boolean z16) {
        Logger.d(this.mTAG, "setLoopPlay() called with: loopPlay = [" + z16 + "],player = " + this.player);
        this.loopPlay = z16;
        Player player = this.player;
        if (player != null) {
            player.setLoop(z16);
        }
    }

    public synchronized void setPlayRange(CMTimeRange cMTimeRange) {
        Logger.d(this.mTAG, "setPlayRange() called with: playRange = [" + cMTimeRange + "],player = " + this.player);
        this.playRange = cMTimeRange;
        Player player = this.player;
        if (player != null) {
            player.setPlayRange(cMTimeRange);
        }
    }

    public void setPlayerListener(final PlayerListener playerListener) {
        Logger.d(this.mTAG, "setPlayerListener() called with: playerListener = [" + playerListener + "],player = " + this.player);
        setPlayerListener(new IPlayer.PlayerListener() { // from class: com.tencent.tavkit.component.TAVPlayer.3
            @Override // com.tencent.tav.player.IPlayer.PlayerListener
            public void onPositionChanged(CMTime cMTime) {
                if (playerListener != null && TAVPlayer.this.player != null) {
                    playerListener.onPositionChanged(cMTime, TAVPlayer.this.player.duration());
                }
            }

            @Override // com.tencent.tav.player.IPlayer.PlayerListener
            public void onStatusChanged(IPlayer.PlayerStatus playerStatus) {
                if (playerListener != null && TAVPlayer.this.player != null) {
                    playerListener.onStatusChanged(playerStatus, TAVPlayer.this.player);
                }
            }
        });
    }

    public synchronized void setRate(float f16) {
        setRate(f16, 20);
    }

    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.surfaceTextureListener = surfaceTextureListener;
    }

    public void setVideoRevertMode(boolean z16) {
        this.videoRevertMode = z16;
        Player player = this.player;
        if (player != null) {
            player.setVideoRevertMode(z16);
        }
    }

    public void setVideoThread(HandlerThread handlerThread) {
        this.videoThread = handlerThread;
    }

    public void setVideoTracksMerge(boolean z16) {
        this.videoTracksMerge = z16;
    }

    public synchronized void setVolume(float f16) {
        Logger.d(this.mTAG, "setVolume() called with: volume = [" + f16 + "],player = " + this.player);
        this.volume = f16;
        Player player = this.player;
        if (player != null) {
            player.setVolume(f16);
        }
    }

    public synchronized void stop() {
        Logger.d(this.mTAG, "stop() called");
        if (this.player != null) {
            abandonAudioFocus();
            this.player.stop();
        }
    }

    public void updateAudioTracks(TAVComposition tAVComposition) {
        Player player;
        TAVSource buildSource = buildSource(tAVComposition);
        if (buildSource != null && (player = this.player) != null && player.getCurrentItem() != null) {
            this.player.getCurrentItem().updateComposition(buildSource.getAsset());
            this.player.getCurrentItem().setAudioMix(buildSource.getAudioMix());
            if (tAVComposition != null) {
                this.player.getCurrentItem().setAudioInfo(tAVComposition.getAudioInfo());
            }
            this.player.updateAudioClipsProperties();
        }
    }

    public void updateComposition(TAVComposition tAVComposition, boolean z16) {
        updateComposition(tAVComposition, CMTime.CMTimeZero, z16);
    }

    public void updateComposition(TAVComposition tAVComposition, CMTime cMTime, boolean z16) {
        updateComposition(tAVComposition, cMTime, z16, (OnCompositionUpdateListener) null);
    }

    private void setPlayerListener(IPlayer.PlayerListener playerListener) {
        Logger.d(this.mTAG, "setPlayerListener() called with: playerListener = [" + playerListener + "],player = " + this.player);
        this.playerListener = playerListener;
        Player player = this.player;
        if (player != null) {
            player.setPlayerListener(playerListener);
        }
    }

    public synchronized void postUpdate(@NonNull ICompositionBuilder iCompositionBuilder, boolean z16) {
        if (this.postUpdateThread == null) {
            PostUpdateThread postUpdateThread = new PostUpdateThread("PostUpdateThread");
            this.postUpdateThread = postUpdateThread;
            postUpdateThread.start();
        }
        this.postUpdateThread.update(iCompositionBuilder, z16);
    }

    public void setRate(float f16, int i3) {
        Logger.d(this.mTAG, "setRate() called with: rate = [" + f16 + "], maxCacheFrameSize = [" + i3 + "]");
        this.rate = f16;
        this.maxCacheFrameSize = i3;
        Player player = this.player;
        if (player != null) {
            player.setRate(f16, i3);
        }
    }

    public void updateComposition(TAVComposition tAVComposition, CMTime cMTime, boolean z16, OnCompositionUpdateListener onCompositionUpdateListener) {
        Logger.d(this.mTAG, "updateComposition() called with: tavComposition = [" + tAVComposition + "], position = [" + cMTime + "], autoPlay = [" + z16 + "]");
        this.tavComposition = tAVComposition;
        this.position = cMTime;
        this.compositionUpdateListener = onCompositionUpdateListener;
        if (tAVComposition == null) {
            this.isResetting = false;
            return;
        }
        if (this.surface == null) {
            this.isAutoPlay = z16;
            this.isResetting = false;
            return;
        }
        PlayerItem buildPlayerItem = buildPlayerItem(tAVComposition);
        buildPlayerItem.setRate(this.rate, this.maxCacheFrameSize);
        buildPlayerItem.setAudioRevertMode(this.audioRevertMode);
        buildPlayerItem.setVideoRevertMode(this.videoRevertMode);
        buildPlayerItem.setAudioRevertCacheSamples(this.audioRevertCacheSamples);
        buildPlayerItem.setAudioInfo(tAVComposition.getAudioInfo());
        updateComposition(cMTime, z16, onCompositionUpdateListener, buildPlayerItem);
    }

    public void seekToTime(CMTime cMTime, Callback callback) {
        Player player = this.player;
        if (player != null) {
            player.seekToTime(cMTime, callback);
        }
    }

    private synchronized void updateComposition(final CMTime cMTime, final boolean z16, final OnCompositionUpdateListener onCompositionUpdateListener, PlayerItem playerItem) {
        Player player = this.player;
        if (player != null && !player.isReleased()) {
            this.player.update(playerItem, cMTime, new OnCompositionUpdateListener() { // from class: com.tencent.tavkit.component.TAVPlayer.4
                @Override // com.tencent.tav.player.OnCompositionUpdateListener
                public void onUpdated(Player player2, boolean z17) {
                    TAVPlayer.this.seekToTime(cMTime);
                    if (z16 && z17) {
                        TAVPlayer.this.play();
                    }
                    TAVPlayer.this.isResetting = false;
                    OnCompositionUpdateListener onCompositionUpdateListener2 = onCompositionUpdateListener;
                    if (onCompositionUpdateListener2 != null) {
                        onCompositionUpdateListener2.onUpdated(player2, z17);
                    }
                }
            });
            return;
        }
        Player newPlayer = newPlayer(playerItem, cMTime, z16);
        this.player = newPlayer;
        if (onCompositionUpdateListener != null) {
            onCompositionUpdateListener.onUpdated(newPlayer, true);
        }
        runEventsToPlayerThread();
    }

    public TAVPlayer(Surface surface, int i3, int i16) {
        onSurfaceCreate(surface, i3, i16);
    }

    public TAVPlayer(FrameLayout frameLayout) {
        this.context = frameLayout.getContext();
        this.mPlayerLayout = frameLayout;
        initContentView();
    }
}
