package com.tencent.state.square.avatar;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.avatar.IAvatarAnimView;
import com.tencent.state.square.media.ISquarePlayer;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.media.PlayerState;
import com.tencent.state.square.media.SquarePlayerPool;
import com.tencent.state.square.media.SquareVideoView;
import com.tencent.state.square.media.StopFrom;
import com.tencent.state.utils.SquareSwitchUtils;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0016J\u0016\u0010\u0016\u001a\u00020\u00142\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u0014\u0010\u0018\u001a\u00020\u00142\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020\u0014H\u0016J\b\u0010'\u001a\u00020\u0014H\u0016J\b\u0010(\u001a\u00020\u0014H\u0016J\b\u0010)\u001a\u00020\u0014H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0014H\u0016J\b\u0010/\u001a\u00020\u0014H\u0002J\u0010\u00100\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016J\b\u00101\u001a\u00020\u0014H\u0016J\"\u00102\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u00103\u001a\u00020\tH\u0016J\u0010\u00104\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020\tH\u0016J\b\u0010:\u001a\u00020\u0014H\u0016J\b\u0010;\u001a\u00020\u0014H\u0016J\u0010\u0010<\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/tencent/state/square/avatar/PlayerAvatarView;", "Lcom/tencent/state/square/avatar/IAvatarAnimView;", "Lcom/tencent/state/square/media/ISquarePlayer$Listener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/avatar/AvatarAnimConfig;", "isStopping", "", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "reStartWhenLastRelease", "Ljava/util/concurrent/atomic/AtomicBoolean;", "source", "Lcom/tencent/state/square/media/MapPlayableSource;", "view", "Lcom/tencent/state/square/media/SquareVideoView;", "addListener", "", "listener", "addListeners", "", "checkAndStart", "clearListeners", "destroy", "getListeners", "getView", "Landroid/view/View;", "isPlaying", "onVideoDestroy", "onVideoError", "code", "", "message", "", "onVideoFirstFrame", "onVideoLoop", "onVideoLoopStart", "onVideoPause", "onVideoResume", "onVideoStart", "onVideoStop", "from", "Lcom/tencent/state/square/media/StopFrom;", "pause", "recyclePlayer", "removeListener", "resume", "setAnimSource", "needAnim", "setConfig", "setData", "data", "Lcom/tencent/state/map/MapPlayableItem;", "setLoopPlay", "isLoop", "start", "stop", "updateAnimSource", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PlayerAvatarView implements IAvatarAnimView, ISquarePlayer.Listener {
    private static final String TAG = "PlayerAvatarView";
    private AvatarAnimConfig config;
    private boolean isStopping;
    private CopyOnWriteArraySet<IAvatarAnimListener> listeners;
    private final AtomicBoolean reStartWhenLastRelease;
    private MapPlayableSource source;
    private final SquareVideoView view;

    public PlayerAvatarView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = new SquareVideoView(context, null, 0, null, 14, null);
        this.listeners = new CopyOnWriteArraySet<>();
        this.config = new AvatarAnimConfig(false, null, null, false, 15, null);
        this.reStartWhenLastRelease = new AtomicBoolean(false);
    }

    private final void checkAndStart(MapPlayableSource source) {
        if (SquareSwitchUtils.INSTANCE.isMp4PlayBlockDevice()) {
            return;
        }
        this.source = source;
        if (this.isStopping && this.view.getState() != PlayerState.Idle) {
            this.reStartWhenLastRelease.set(true);
        } else if (source == null) {
            this.view.start();
        } else {
            this.view.start(source.getMediaSource());
        }
    }

    private final void recyclePlayer() {
        if (this.config.isPlayerRecycleEnabled()) {
            this.view.recyclePlayer();
        }
        this.isStopping = false;
        if (this.reStartWhenLastRelease.compareAndSet(true, false)) {
            checkAndStart(this.source);
        }
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void addListeners(Set<? extends IAvatarAnimListener> listeners) {
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        this.listeners.addAll(listeners);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void changeSourceWithAnim(MapPlayableSource source, IAvatarAnimListener iAvatarAnimListener, boolean z16) {
        Intrinsics.checkNotNullParameter(source, "source");
        IAvatarAnimView.DefaultImpls.changeSourceWithAnim(this, source, iAvatarAnimListener, z16);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void clearListeners() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            try {
                ((IAvatarAnimListener) it.next()).onRemovedListener();
            } catch (Throwable th5) {
                SquareBaseKt.getSquareLog().e(TAG, "onRemovedListener throw: ", th5);
            }
        }
        this.listeners.clear();
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void destroy() {
        clearListeners();
        this.view.reset();
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public CopyOnWriteArraySet<IAvatarAnimListener> getListeners() {
        return this.listeners;
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public View getView() {
        return this.view;
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public boolean isPlaying() {
        PlayerState state = this.view.getState();
        return state == PlayerState.Starting || state == PlayerState.Executing;
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoDestroy() {
        recyclePlayer();
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoError(int code, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        recyclePlayer();
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((IAvatarAnimListener) it.next()).onPlayError(code);
        }
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoFirstFrame() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((IAvatarAnimListener) it.next()).onFirstFrame();
        }
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoLoopStart() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((IAvatarAnimListener) it.next()).onPlayStart();
        }
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoStop(StopFrom from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (from != StopFrom.StartCheck) {
            recyclePlayer();
        }
        if (from == StopFrom.VideoComplete) {
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((IAvatarAnimListener) it.next()).onPlayEnd();
            }
        }
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void pause() {
        this.view.pause();
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void removeListener(IAvatarAnimListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
        try {
            listener.onRemovedListener();
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "onRemovedListener throw: ", th5);
        }
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void resume() {
        this.view.resume();
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setAnimSource(MapPlayableSource source, IAvatarAnimListener listener, boolean needAnim) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.view.setListener(this);
        clearListeners();
        addListener(listener);
        checkAndStart(source);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setAutoShowStatic(boolean z16) {
        IAvatarAnimView.DefaultImpls.setAutoShowStatic(this, z16);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setConfig(AvatarAnimConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        SquarePlayerPool playerPool = config.getPlayerPool();
        if (playerPool != null) {
            this.view.setPlayerPool(playerPool);
        }
        this.view.setPlayConfig(config.getPlayConfig());
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setData(MapPlayableItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.config.getPlayConfig().setUniqueId(data.getUin() + '-' + data.getTroopName());
        this.view.setPlayConfig(this.config.getPlayConfig());
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setLoopPlay(boolean isLoop) {
        this.view.setLoopPlay(isLoop);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void updateAnimSource(MapPlayableSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.view.setListener(this);
        checkAndStart(source);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void stop() {
        this.isStopping = true;
        this.view.stop();
        this.reStartWhenLastRelease.compareAndSet(true, false);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void addListener(IAvatarAnimListener listener) {
        if (listener == null || this.listeners.contains(listener)) {
            return;
        }
        this.listeners.add(listener);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void start() {
        checkAndStart$default(this, null, 1, null);
    }

    static /* synthetic */ void checkAndStart$default(PlayerAvatarView playerAvatarView, MapPlayableSource mapPlayableSource, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            mapPlayableSource = null;
        }
        playerAvatarView.checkAndStart(mapPlayableSource);
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoLoop() {
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoPause() {
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoResume() {
    }

    @Override // com.tencent.state.square.media.ISquarePlayer.Listener
    public void onVideoStart() {
    }
}
