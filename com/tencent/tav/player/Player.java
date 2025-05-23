package com.tencent.tav.player;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.player.IPlayer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class Player implements IPlayer, Handler.Callback {
    public static final boolean DEFAULT_CONFIG_STATIC_AUDIO_SYNC_ENABLE = false;
    private static final int DEFAULT_MAX_CACHE_SIZE = 60;
    public static final String TAG = "PlayerThreadMain";
    public static final int TYPE_PROGRESS = 2;
    public static final int TYPE_STATES = 1;
    public static final int TYPE_VIEWPORT_UPDATE = 3;
    private static Map<PlayerStaticConfigKey, Boolean> configStaticMap = new HashMap();
    public static String time = "time";
    private AVPlayerActionAtItemEnd actionAtItemEnd;
    private Asset asset;
    private int bgColor;
    private PlayerItem currentItem;
    private boolean enableSync;
    private ErrorMsg errMsg;
    private boolean ignorePreparePosition;
    private boolean loop;
    private AudioFocusHelper mAudioFocuser;
    private CMTime mLastSeekTargetTimeUs;
    Handler mMainHandler;
    private CMTimeRange mPlayRange;
    private PlayerThread mPlayThread;
    private IPlayer.PlayerListener mPlayerListener;
    private IPlayer.PlayerStatus mPlayerStatus;
    private boolean mPlayingFlagFromApi;
    private CMTime mPosition;
    private CMTime mSeekTargetTimeUs;
    private boolean muted;
    private OnCompositionUpdateListener onCompositionUpdateListener;
    private PlayerLayer playerLayer;
    private float rate;
    private volatile boolean released;
    private PlayerStatus status;
    private HandlerThread videoThread;

    @Nullable
    private OnViewportUpdateListener viewportUpdateListener;
    private float volume;

    /* renamed from: com.tencent.tav.player.Player$2, reason: invalid class name */
    /* loaded from: classes26.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$tav$player$Player$PlayerStaticConfigKey;

        static {
            int[] iArr = new int[PlayerStaticConfigKey.values().length];
            $SwitchMap$com$tencent$tav$player$Player$PlayerStaticConfigKey = iArr;
            try {
                iArr[PlayerStaticConfigKey.CONFIG_STATIC_AUDIO_SYNC_ENABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$tav$player$Player$PlayerStaticConfigKey[PlayerStaticConfigKey.CONFIG_STATIC_VIDEO_AUDIO_SYNC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes26.dex */
    enum AVPlayerActionAtItemEnd {
        AVPlayerActionAtItemEndAdvance,
        AVPlayerActionAtItemEndPause,
        AVPlayerActionAtItemEndNone
    }

    /* loaded from: classes26.dex */
    public enum PlayerStaticConfigKey {
        CONFIG_STATIC_AUDIO_SYNC_ENABLE,
        CONFIG_STATIC_VIDEO_AUDIO_SYNC
    }

    /* loaded from: classes26.dex */
    enum PlayerStatus {
        PlayerStatusUnknown,
        PlayerStatusReadyToPlay,
        PlayerStatusFailed
    }

    public Player(String str) {
        this(new PlayerItem(str));
    }

    private synchronized void checkAndReady() {
        if (this.mPlayerStatus == IPlayer.PlayerStatus.IDLE) {
            this.mPlayThread.sendMessage(1, "main");
        }
    }

    public static boolean getPlayerStaticConfig(PlayerStaticConfigKey playerStaticConfigKey) {
        if (configStaticMap.containsKey(playerStaticConfigKey)) {
            return configStaticMap.get(playerStaticConfigKey).booleanValue();
        }
        if (AnonymousClass2.$SwitchMap$com$tencent$tav$player$Player$PlayerStaticConfigKey[playerStaticConfigKey.ordinal()] != 2) {
            return false;
        }
        return true;
    }

    public static void setPlayerStaticConfig(PlayerStaticConfigKey playerStaticConfigKey, boolean z16) {
        configStaticMap.put(playerStaticConfigKey, Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bindLayer(PlayerLayer playerLayer) {
        this.playerLayer = playerLayer;
        this.currentItem.bindLayer(playerLayer);
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized IPlayer.PlayerStatus currentStatus() {
        return this.mPlayerStatus;
    }

    public CMTime currentTime() {
        PlayerThread playerThread = this.mPlayThread;
        if (playerThread == null) {
            return CMTime.CMTimeZero;
        }
        return playerThread.getPosition();
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized CMTime duration() {
        CMTime duration;
        Asset asset = this.asset;
        if (asset == null) {
            duration = CMTime.CMTimeZero;
        } else {
            duration = asset.getDuration();
        }
        return duration;
    }

    public void enAbleAudioFocus(Context context, boolean z16) {
        if (z16) {
            if (this.mAudioFocuser == null) {
                this.mAudioFocuser = new AudioFocusHelper(context, this);
            }
        } else {
            AudioFocusHelper audioFocusHelper = this.mAudioFocuser;
            if (audioFocusHelper != null) {
                audioFocusHelper.release();
            }
        }
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public PlayerItem getCurrentItem() {
        return this.currentItem;
    }

    public boolean getEnableSync() {
        return this.enableSync;
    }

    public ErrorMsg getErrMsg() {
        return this.errMsg;
    }

    @Nullable
    public CGRect getGlViewport() {
        PlayerThread playerThread = this.mPlayThread;
        if (playerThread == null) {
            return null;
        }
        return playerThread.getGlViewportRect();
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized CMTimeRange getPlayRange() {
        return this.mPlayRange;
    }

    public float getRate() {
        return this.rate;
    }

    @Nullable
    public RenderContextParams getRenderContextParams() {
        PlayerThread playerThread = this.mPlayThread;
        if (playerThread != null) {
            return playerThread.getRenderContextParams();
        }
        return null;
    }

    public PlayerStatus getStatus() {
        return this.status;
    }

    public HandlerThread getVideoThread() {
        return this.videoThread;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.released) {
            return false;
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return false;
                }
                OnViewportUpdateListener onViewportUpdateListener = this.viewportUpdateListener;
                if (onViewportUpdateListener != null) {
                    Object obj = message.obj;
                    if (obj instanceof CGRect) {
                        onViewportUpdateListener.onViewportUpdate(((CGRect) obj).m257clone());
                    }
                }
            } else {
                this.mPosition = (CMTime) message.obj;
                if (this.mPlayerListener != null && !this.mMainHandler.hasMessages(2)) {
                    this.mPlayerListener.onPositionChanged(this.mPosition);
                }
                CMTimeRange cMTimeRange = this.mPlayRange;
                if (cMTimeRange != null && !this.mPosition.smallThan(cMTimeRange.getEnd()) && isPlaying()) {
                    if (this.loop) {
                        IPlayer.PlayerListener playerListener = this.mPlayerListener;
                        if (playerListener != null) {
                            playerListener.onStatusChanged(IPlayer.PlayerStatus.REPLAY);
                        }
                        seekToTime(this.mPlayRange.getStart());
                    } else {
                        pause();
                    }
                }
            }
        } else {
            IPlayer.PlayerStatus playerStatus = this.mPlayerStatus;
            PlayerStatusMsg playerStatusMsg = (PlayerStatusMsg) message.obj;
            IPlayer.PlayerStatus playerStatus2 = playerStatusMsg.getPlayerStatus();
            this.mPlayerStatus = playerStatus2;
            if (playerStatus == IPlayer.PlayerStatus.PLAYING && ((playerStatus2 == IPlayer.PlayerStatus.FINISHED || playerStatus2 == IPlayer.PlayerStatus.ERROR) && this.loop)) {
                synchronized (this) {
                    if (!this.mPlayThread.hasMessage(3) && !this.mPlayThread.hasMessage(6) && !this.mPlayThread.hasMessage(4) && !this.mPlayThread.hasMessage(11) && !this.mMainHandler.hasMessages(1)) {
                        CMTimeRange cMTimeRange2 = this.mPlayRange;
                        if (cMTimeRange2 != null && cMTimeRange2.getDuration().getValue() > 0) {
                            seekToTime(this.mPlayRange.getStart());
                        } else {
                            seekToTime(CMTime.CMTimeZero);
                        }
                        IPlayer.PlayerListener playerListener2 = this.mPlayerListener;
                        if (playerListener2 != null) {
                            playerListener2.onStatusChanged(IPlayer.PlayerStatus.REPLAY);
                        }
                        play();
                    }
                }
            } else {
                IPlayer.PlayerListener playerListener3 = this.mPlayerListener;
                if (playerListener3 != null) {
                    playerListener3.onStatusChanged(playerStatus2);
                }
                if (this.mPlayerStatus == IPlayer.PlayerStatus.ERROR) {
                    this.errMsg = new ErrorMsg(-1, playerStatusMsg.getErrorMsg());
                }
            }
        }
        return true;
    }

    public boolean isIgnorePreparePosition() {
        return this.ignorePreparePosition;
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized boolean isPlaying() {
        boolean z16;
        if (this.mPlayerStatus == IPlayer.PlayerStatus.PLAYING) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public synchronized boolean isReleased() {
        return this.released;
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void pause() {
        if (this.released) {
            return;
        }
        this.mPlayingFlagFromApi = false;
        this.mPlayThread.sendMessage(3, "main");
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void play() {
        if (this.released) {
            return;
        }
        CMTimeRange cMTimeRange = this.mPlayRange;
        if (cMTimeRange != null && !cMTimeRange.containsTime(currentTime())) {
            seekToTime(this.mPlayRange.getStart());
        }
        if (this.mPlayingFlagFromApi && isPlaying()) {
            this.mPlayThread.sendMessage(26, "main");
        } else {
            this.mPlayThread.sendMessage(2, "main");
        }
        this.mPlayingFlagFromApi = true;
        AudioFocusHelper audioFocusHelper = this.mAudioFocuser;
        if (audioFocusHelper != null) {
            audioFocusHelper.requestFocus();
        }
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized CMTime position() {
        CMTime position;
        PlayerThread playerThread = this.mPlayThread;
        if (playerThread == null) {
            position = CMTime.CMTimeZero;
        } else {
            position = playerThread.getPosition();
        }
        return position;
    }

    public boolean post(Runnable runnable) {
        if (this.released) {
            return false;
        }
        return this.mPlayThread.post(runnable);
    }

    public void prepare(PlayerPrepareListener playerPrepareListener) {
        IPlayer.PlayerStatus playerStatus = IPlayer.PlayerStatus.IDLE;
    }

    public void readSnapShootBitmap(OnReadSnapShootListener onReadSnapShootListener) {
        PlayerThread playerThread = this.mPlayThread;
        if (playerThread == null) {
            return;
        }
        playerThread.sendMessage(24, onReadSnapShootListener, "readSnapShootBitmap");
    }

    public boolean refresh() {
        if (this.released) {
            return false;
        }
        return this.mPlayThread.refresh();
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void release() {
        release(null);
    }

    public void replaceCurrentItemWithPlayerItem(PlayerItem playerItem) {
        update(playerItem, position());
    }

    public void seekToTime(CMTime cMTime) {
        seekToTime(cMTime, null);
    }

    public void setAudioRevertCacheSamples(int i3) {
        PlayerItem playerItem;
        IPlayer.PlayerStatus playerStatus = this.mPlayerStatus;
        if (playerStatus != IPlayer.PlayerStatus.PLAYING && playerStatus != IPlayer.PlayerStatus.PAUSED && (playerItem = this.currentItem) != null) {
            playerItem.setAudioRevertCacheSamples(i3);
        }
    }

    public void setAudioRevertMode(boolean z16) {
        PlayerItem playerItem;
        IPlayer.PlayerStatus playerStatus = this.mPlayerStatus;
        if (playerStatus != IPlayer.PlayerStatus.PLAYING && playerStatus != IPlayer.PlayerStatus.PAUSED && (playerItem = this.currentItem) != null) {
            playerItem.setAudioRevertMode(z16);
        }
    }

    public void setBgColor(int i3) {
        this.bgColor = i3;
    }

    public void setEnableSync(boolean z16) {
        this.enableSync = z16;
    }

    public void setGetTavExtraListener(OnGetTavExtraListener onGetTavExtraListener) {
        PlayerThread playerThread = this.mPlayThread;
        if (playerThread != null) {
            playerThread.sendMessage(25, onGetTavExtraListener, "setGetTavExtraListener");
        }
    }

    public void setIgnorePreparePosition(boolean z16) {
        this.ignorePreparePosition = z16;
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void setLoop(boolean z16) {
        this.loop = z16;
    }

    @Override // com.tencent.tav.player.IPlayer
    public void setOnCompositionUpdateListener(OnCompositionUpdateListener onCompositionUpdateListener) {
        this.onCompositionUpdateListener = onCompositionUpdateListener;
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void setPlayRange(CMTimeRange cMTimeRange) {
        this.mPlayRange = cMTimeRange;
        if (cMTimeRange != null && !cMTimeRange.containsTime(currentTime()) && isPlaying()) {
            seekToTime(cMTimeRange.getStart());
        }
    }

    @Override // com.tencent.tav.player.IPlayer
    public void setPlayerListener(IPlayer.PlayerListener playerListener) {
        this.mPlayerListener = playerListener;
    }

    public void setRate(float f16) {
        setRate(f16, 60);
    }

    public void setRenderContextParams(RenderContextParams renderContextParams) {
        PlayerThread playerThread = this.mPlayThread;
        if (playerThread != null) {
            playerThread.setRenderContextParams(renderContextParams);
        }
    }

    public void setVideoRevertMode(boolean z16) {
        PlayerItem playerItem;
        IPlayer.PlayerStatus playerStatus = this.mPlayerStatus;
        if (playerStatus != IPlayer.PlayerStatus.PLAYING && playerStatus != IPlayer.PlayerStatus.PAUSED && (playerItem = this.currentItem) != null) {
            playerItem.setVideoRevertMode(z16);
        }
    }

    public void setVideoThread(HandlerThread handlerThread) {
        this.videoThread = handlerThread;
    }

    public void setViewportUpdateListener(OnViewportUpdateListener onViewportUpdateListener) {
        this.viewportUpdateListener = onViewportUpdateListener;
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void setVolume(float f16) {
        if (this.released) {
            return;
        }
        this.mPlayThread.sendMessage(7, Float.valueOf(f16), "main");
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void stop() {
        if (this.released) {
            return;
        }
        this.mPlayingFlagFromApi = false;
        this.mPlayThread.sendMessage(4, Boolean.TRUE, "main");
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void update(@NonNull PlayerItem playerItem, CMTime cMTime) {
        if (this.released) {
            return;
        }
        this.currentItem = playerItem;
        this.asset = playerItem.getAsset();
        this.currentItem.updateDecoderTrack();
        this.mPlayThread.updatePositionRightAway(cMTime);
        this.mPlayThread.removeMessages(11);
        this.mPlayThread.sendMessage(11, new UpdateCompositionMessage(playerItem, cMTime, this.onCompositionUpdateListener), "update clips");
        this.mLastSeekTargetTimeUs = CMTime.CMTimeZero;
    }

    public synchronized void updateAllProperties() {
        if (this.released) {
            return;
        }
        this.mPlayThread.sendMessage(20, "main");
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void updateAudioClipsProperties() {
        if (this.released) {
            return;
        }
        this.mPlayThread.sendMessage(22, "main");
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void updateAudioVolumeProperties() {
        if (this.released) {
            return;
        }
        this.mPlayThread.sendMessage(23, "main");
    }

    public synchronized void updateProperties() {
        if (this.released) {
            return;
        }
        this.mPlayThread.sendMessage(10, "main");
    }

    public void updateViewport(int i3, int i16) {
        if (this.released) {
            return;
        }
        this.mPlayThread.sendMessage(21, new CGSize(i3, i16), "main");
    }

    @Override // com.tencent.tav.player.IPlayer
    public int videoHeight() {
        PlayerItem playerItem = this.currentItem;
        if (playerItem == null) {
            return 0;
        }
        return (int) playerItem.getPresentationSize().height;
    }

    @Override // com.tencent.tav.player.IPlayer
    public int videoWidth() {
        PlayerItem playerItem = this.currentItem;
        if (playerItem == null) {
            return 0;
        }
        return (int) playerItem.getPresentationSize().width;
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void waitForRelease(long j3) {
    }

    public Player(PlayerItem playerItem, HandlerThread handlerThread) {
        this.mPlayerStatus = IPlayer.PlayerStatus.IDLE;
        this.loop = false;
        this.released = false;
        this.ignorePreparePosition = false;
        this.bgColor = -16777216;
        this.enableSync = true;
        this.videoThread = handlerThread;
        this.currentItem = playerItem;
        this.mMainHandler = new Handler(Looper.getMainLooper(), this);
        this.asset = this.currentItem.getAsset();
        this.currentItem.start(this);
        this.mPlayThread = this.currentItem.getPlayerThreadMain();
    }

    public void seekToTime(CMTime cMTime, CMTime cMTime2, CMTime cMTime3) {
        seekToTime(cMTime, cMTime2, cMTime3, null);
    }

    public void setRate(float f16, int i3) {
        setRate(f16, i3, false);
    }

    @Override // com.tencent.tav.player.IPlayer
    public synchronized void release(Runnable runnable) {
        if (!this.released) {
            this.released = true;
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
            this.mPlayThread.sendMessage(4, "main");
            this.mPlayThread.sendMessage(6, runnable, "main");
            this.mPlayThread = null;
            AudioFocusHelper audioFocusHelper = this.mAudioFocuser;
            if (audioFocusHelper != null) {
                audioFocusHelper.release();
            }
            PlayerItem playerItem = this.currentItem;
            if (playerItem != null) {
                playerItem.release();
            }
            this.currentItem = null;
            this.mPlayingFlagFromApi = false;
        }
    }

    @Override // com.tencent.tav.player.IPlayer
    public void seekToTime(CMTime cMTime, Callback callback) {
        CMTime cMTime2 = CMTime.CMTimeZero;
        seekToTime(cMTime, cMTime2, cMTime2, callback);
    }

    public void setRate(float f16, int i3, boolean z16) {
        IPlayer.PlayerStatus playerStatus;
        if (z16 || !((playerStatus = this.mPlayerStatus) == IPlayer.PlayerStatus.PLAYING || playerStatus == IPlayer.PlayerStatus.PAUSED)) {
            this.rate = f16;
            this.currentItem.setRate(f16, i3);
        }
    }

    public void seekToTime(CMTime cMTime, CMTime cMTime2, CMTime cMTime3, Callback callback) {
        if (this.released) {
            return;
        }
        this.mSeekTargetTimeUs = cMTime;
        this.mLastSeekTargetTimeUs = cMTime;
        this.mPlayThread.updatePositionRightAway(cMTime);
        this.mPlayThread.sendMessage(5, this.mSeekTargetTimeUs, callback, "main");
    }

    public synchronized void update(@NonNull PlayerItem playerItem, CMTime cMTime, final OnCompositionUpdateListener onCompositionUpdateListener) {
        if (this.released) {
            return;
        }
        this.currentItem = playerItem;
        this.asset = playerItem.getAsset();
        this.currentItem.updateDecoderTrack();
        this.mPlayThread.updatePositionRightAway(cMTime);
        this.mPlayThread.removeMessages(11);
        this.mPlayThread.sendMessage(11, new UpdateCompositionMessage(playerItem, cMTime, new OnCompositionUpdateListener() { // from class: com.tencent.tav.player.Player.1
            @Override // com.tencent.tav.player.OnCompositionUpdateListener
            public void onUpdated(Player player, boolean z16) {
                OnCompositionUpdateListener onCompositionUpdateListener2 = onCompositionUpdateListener;
                if (onCompositionUpdateListener2 != null) {
                    onCompositionUpdateListener2.onUpdated(player, z16);
                }
                if (Player.this.onCompositionUpdateListener != null) {
                    Player.this.onCompositionUpdateListener.onUpdated(player, z16);
                }
            }
        }), "update clips");
        this.mLastSeekTargetTimeUs = CMTime.CMTimeZero;
    }

    public Player(PlayerItem playerItem) {
        this(playerItem, null);
    }

    public void setRateAtTimeAndHostTime(float f16, CMTime cMTime, CMTime cMTime2) {
    }
}
